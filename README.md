# TODO: Prepping to go open source (in no particular order)
- [ ] Comprehensive unit test coverage
- [ ] Remove unused dependencies from version catalog, used code, unused comments
- [ ] Add dependabot to update kotlin / dependencies
- [ ] Add gradle wrapper update plugin
- [ ] Buy domain name
- [ ] Register for maven repository
- [ ] Add CI to build, run unit tests, & publish
- [ ] Add CI to update semver numbers (e.g. major for big changes, minor for small changes, patch for dependabot updates)
- [ ] Add CI to auto-merge dependabot PRs if tests are green
- [ ] Rework readme and add examples

# Kty: A Kotlin Library to Interface & Delegate Primitives' Operators for Value Classes

*Or, "Kotlin's missing math operator interfaces and other delusions."*

### The goal:

To enable `@JvmInline value class` creations (and `data class` etc.) to behave like their value with minimal effort and maximum inheritance.

---

# How we got here.
### Why use inline classes?

Kotlin encourages us to codify our problem domain! We're encouraged to use type-safety to its fullest extent, using
`value class`, `data class`, `data object`, and `sealed` hierarchies.

Ordinarily, you can encapsulate your domain, a such:

```kotlin
@JvmInline
value class ZombieName(val name: String) :
    Comparable<String> by name, CharSequence by name
```

...and that's great! `ZombieName` is now a type-safe `String`, with some of the abilities of a string (like `length`),
and it's even Comparable! You can specify functions with `ZombieName` as an argument, and it's now impossible to pass a
regular `String`!

This is important, because classes like `String` are overused and abused. If you *aren't* using explicit call arguments,
it's incredibly easy to break your inputs if you change the parameter order.

```kotlin
class Zombie(
    val name: String,
    val id: String,
)

fun makeZombie() = Zombie("mike", "234567i")

// Oh, no! The order's all wrong!
class Zombie(
    val id: String,
    val name: String,
)

makeZombie() // Zombie(id = "mike", name = "234567i")
```

## Have you ever tried to wrap a `Number`?

*I have, and it wasn't pretty.*

The first time I tried to wrap a number, my goal was to represent SI and imperial measurement units for our app at work.
We wanted to measure the user's body proportions through the camera, and the whole affair was *littered* with custom
business rules & logic.

I wanted to make, say, a `MassUnit` or a `LengthUnit`, which would be backed by `BigDecimal` for precision. I had all
the suffixes, like Kotlin's `Duration`. I had all the conversions to and from our backing field unit. I had all the
string representation set up.

...but what I didn't have *was math*.

Or more specifically mathematical operators. **Did you know that Kotlin has *no* interface that can guarantee that my
class supports the `plus` operator?!**

That's okay, I thought. I'll just implement them all myself. It went something like...

```kotlin
import java.math.BigDecimal

// I can't actually remember why I had to use generics 
// like this, but it quickly spiralled out of control.
sealed interface MeasureUnit<T : MeasureUnit<T>> : Comparable<BigDecimal> {
    
    val value: BigDecimal
    
    // Generics were probably for something like this, but 
    // looking back, I was probably better off without this part.
    operator fun plus(other: T): T

    // Note: value classes can't extend classes, which 
    // means extending the abstract class Number is out!
    @JvmInline
    value class LengthUnit(override val value: BigDecimal) :
        MeasureUnit<LengthUnit>,
        Comparable<BigDecimal> by value {

        override operator fun plus(other: LengthUnit): LengthUnit {
            return LengthUnit(value + other.value)
        }
        // ... and all the other math operators!
    }
}
```

(Actually it was a lot more complicated than that -- I had generics up the wazoo).
Then we had different things about the body that we measured. And each aspect of the body needed a measurement.

*But we still didn't have math.*
```kotlin
sealed interface HumanBody<T : HumanBody<T, U>, U: MeasureUnit<U>> {
    
    operator fun minus(other: T): T
    
    @JvmInline 
    value class Height(val value: LengthUnit): HumanBody<Height, LengthUnit> {
        override fun minus(other: Height): Height {
            return value - other.value
        }
    }

    @JvmInline
    value class Weight(val value: MassUnit): HumanBody<Weight, MassUnit>{
        override fun minus(other: Weight): Weight {
            return value - other.value
        }
    }
    
    data class Circumference(
        val value: LengthUnit, 
        val part: BodyPart,
    ): HumanBody<Circumference, LengthUnit>{
        override fun minus(other: Circumference): Circumference {
            return value - other.value
        }
    }
}
```

I hope you can see just how out of control this got. The code was completely unmaintainable, quickly becoming a black-box to my team members and my future self (oops).

A few months later, it happened to me *again*. This time why trying to make a simple 2D game. 
I wanted to encapsulate `Position(x, y)`, `Velocity(vx, vy)`, `Acceleration(ax, ay)`, `Angle.Degrees(value)`.
So not only does the lack of a number interface harm `value class`, but it also harms `data class`!

*It should be noted that I often try to accept parameters of type `Number`. E.g. `Degrees<T: Number>` or `plus(other: Number)` for increased compatibility / fewer usage restrictions. This also can cause headaches...*

These all have pretty clear requirements, with definite patterns emerging:
1. You *can't* abuse delegation for math, because `Number` only tells you how to convert between `Number` classes. ***There is no operator interface.***
2. You have to override the same operator in *every* child class, or else you can't specify the exact types.
3. You have to re-wrap / instantiate the result of the inner operation.
4. If you want *cross-child operator magick*™, you need to define the operator in the parent interface AND
5. (or #3b) The parent interface *needs* to know how to remake the child instance!
6. Generics quickly become a massive headache for any consumer of your type.

# 3am
*The best ideas come at 3am. Unfortunately; because I wanted to sleep. -_-*

Fortunately, I thought "maybe the generics *are* the problem?"
So I tried to remove them. And when that didn't work out, I suddenly realised that the issue was that I only carried the backing field type, but never the wrapper (or vice versa, I forget)! ***You need both!***

Then, all kinds of things came together:
- [Boxed](./src/main/kotlin/nz/adjmunro/kty/Boxed.kt) is the fundamental interface. It guarantees:
  1. The backing field type;
  2. The implementing child class wrapper type;
  3. A property with a known name of the backing field type;
  4. A method reference to the child wrapper's constructor.
- Using those properties you can start creating interfaces to guarantee all sorts of behaviour!
- Interfaces should be more specific where possible. Member `val` properties of lambdas can be assigned to specific method references to effectively delegate the operations to a real Kotlin class.
