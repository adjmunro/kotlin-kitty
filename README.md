# Kty <sub>[docs](https://adjmunro.github.io/project-kitty/)</sub>
**A Kotlin-y Library to Interface & Delegate Primitives' Operators for Value & Data Classes**

*Or, "Kotlin's missing math operator interfaces and other delusions."*

### The goal:

To enable `@JvmInline value class` and `data class` to behave like their internal primitive value(s) with minimal effort and maximum inheritance.
*No reflecktion! No annotation magick! Just plain-old type-system abuse.*

---

- [Using in your Project](https://github.com/adjmunro/project-kitty?tab=readme-ov-file#add-to-your-project)
- Value Classes
    - [Strings & Mutable Strings](https://github.com/adjmunro/project-kitty?tab=readme-ov-file#string-value-classes)
    - [Numbers](https://github.com/adjmunro/project-kitty?tab=readme-ov-file#number-value-classes)
- Data Classes / Tuples
    - [Number Data Classes](https://github.com/adjmunro/project-kitty?tab=readme-ov-file#number-data-classes)
    - [Other Tuples](https://github.com/adjmunro/project-kitty?tab=readme-ov-file#tuples)
- [Why Does This Exist](https://github.com/adjmunro/project-kitty?tab=readme-ov-file#why-does-this-exist)
- [Documentation](https://adjmunro.github.io/project-kitty/)
- [TODO](https://github.com/adjmunro/project-kitty?tab=readme-ov-file#todo)

---

### String Value Classes
There are two `String`-based value class interfaces: `Stringy` and `MutableStringy`. Because most `String` functions are actually extensions, `MutableStringy` not only supports the `plus` operator, it also has a `map` function that unwraps the value class, allows you to apply a transformation, like converting to lowercase, then reconstructs the value class instance with the new value. 
```kotlin
@JvmInline // (MUST) You need to pass the wrapper type, Name, as a type argument to Stringy. 
value class Name(val str: String): Stringy<Name> {
    // (MUST) Implement this property using a function reference to the constructor.
    // Then tells the parent interfaces how to make a new instance of [Name].
    override val reconstruct: (String) -> Name get() = ::Name
    
    // (Recommended) This library has no way to implement toString() on your behalf.
    // If you do not override this function, the default output will be `Name(str=[value])`.
    override fun toString(): String = str
  
    // (Optional) If you do not wish to use [value] as your wrapped property name, 
    // you can use this trick to map your new property to [value].
    override val value: String get() = str
}

@JvmInline
value class ApiKey(override val value: String): MutableStringy<ApiKey> {
    override val reconstruct: (String) -> ApiKey get() = ::ApiKey
}
// You can use map on a MutableStringy to apply String extension functions.
val a = ApiKey("ABcdEF").map { it.lowercase() } // ApiKey("abcdef")
val b = ApiKey("ABcdEF").map(String::lowercase) // ApiKey("abcdef")
```

### Number Value Classes
Implementing `Inty`, `Longy`, `Floaty`, or `Doubly` will provide you with a full suite of math & comparison operators both against the wrapper type and any `Number` type for convenience.
```kotlin
@JvmInline // (MUST) You need to pass the wrapper type, Point, as a type argument to Inty.
value class Point(override val value: Int): Inty<Point> {
    // (MUST) Implement this property using a function reference to the constructor.
    // Then tells the parent interfaces how to make a new instance of [Point].
    override val reconstruct: (Int) -> Point get() = ::Point
    
    // (Recommended) You can provide secondary constructors for convenience.
    constructor(n: Number): this(n.roundToInt())
}

// Math & Comparison against wrapper & numbers are all offloaded to the interfaces.
val x: Point = Point(4.5) + Point(3) % 3 >= Point(2)
```

### Number Data Classes
Implementing `Numbery2D` to `Numbery5D` will provide you with math operators against the same instance type and any `Number` (no comparison, but the interface is there if you want it).
```kotlin
// (MUST) The first generic argument is the wrapper type.
// (MUST) The second generic argument is the backing field of the component properties.
// Important! In order to guarantee math operations, the backing field can ONLY be a Numbery implementation!
data class Position(val x: Point, val y: Point): Numbery2D<Position, Point> {
    // (MUST) Implement this property using a function reference to the constructor.
    // Note: This function is called differently from value classes! This is because Numbery data classes
    // still use the Boxed interface. `value` therefore points to the tuple itself, and `reconstruct`
    // is implemented by the interface to unwrap the tuple into the backing fields 
    // to enable the same constructor reference trick.
    override val reconstructor: (Point, Point) -> Postion get() = ::Position
  
    // (Recommended) You can provide secondary constructors for convenience.
    constructor(x: Number, y: Number): this(Point(x), Point(y))
}

// Multi-argument math is done per argument: i.e. Position(x1 + x2, y1 + y2)
// Scalar math is applied to each argument: i.e. Position(x*n, y*n)
val (x, y) = Position(4, 6) + Position(2, 5) * 7
```
*Currently, the data class interface implementation is abusing the `componentN()` operators of data classes to avoid enforcing property names and/or necessitating overriding properties. This may be subject to change depending on the language development. We'll have to wait and see what happens with named destructuring, and whether positional destructuring is deprecated.*

### Tuples
Kty also supports tuples of size 2-9. These only come with basic functionality, but can be useful when returning multiple values, similar to Kotlin's `Pair` or `Triple`. Alternatively, you can extend the `Tuple` interface similar to `Numbery2D` to suit your own needs, such as requiring different backing field types for each argument of your data class.

---

### Add to your project
TODO: I need to set up public publishing first.

Local Builds:
1. Clone the project
2. Use `./gradlew build` to build
3. use `./gradlew publishToMavenLocal` to publish to your local maven m2 directory.
4. In `settings.gradle(.kts)` of the project you wish to use Kty in, add `mavenLocal()` to your dependency resolution block.

---

# Why does this exist?
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

### Have you ever tried to wrap a `Number`?

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

### 3am
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

---

# TODO
- [ ] Comprehensive unit test coverage
- [x] Remove unused dependencies from version catalog, used code, unused comments
- [x] Add dependabot to update kotlin / dependencies
- [ ] Add gradle wrapper update plugin
- [ ] Buy domain name
- [ ] Register for maven repository
- [x] Add CI to build, run unit tests
- [ ] Add CI to publish
- [x] Add CI to publish docs
- [ ] Add CI to update semver numbers (e.g. major for big changes, minor for small changes, patch for dependabot updates)
- [ ] Add CI to auto-merge dependabot PRs if tests are green
- [x] Rework readme and add examples

- Numbery operators: 
  - [ ] rangeTo
  - [ ] rangeUntil
  - [ ] unary minus
  - [ ] unary plus
  - [ ] increment
  - [ ] decrement
  - [ ] plus assign
  - [ ] minus assign
- Tuple operators:
  - [ ] contains
  - [ ] rangeTo
  - [ ] rangeUntil
  - [ ] compareTo(in 0 to ±n)
  - [ ] dot product
  - [ ] cross product
  - [ ] normalise
- [ ] booleany value class interface
