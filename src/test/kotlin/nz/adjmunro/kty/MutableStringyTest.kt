package nz.adjmunro.kty

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.string.shouldBeLowerCase
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.Test

class MutableStringyTest {

    @JvmInline
    value class MutStringySubject(val str: String) : MutableStringy<MutStringySubject> {
        override val reconstruct: (String) -> MutStringySubject get() = ::MutStringySubject
        override val value: String get() = str
    }

    @Test
    fun `create instance of child class`() {
        MutStringySubject("Hello, World!").shouldBeInstanceOf<MutStringySubject> {
            it.value.shouldBeEqual("Hello, World!")
        }
    }

    @Test
    fun `add two instances`() {
        // Given
        val a = MutStringySubject("Hello, ")
        val b = MutStringySubject("World!")

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<MutStringySubject> {
            it.str.shouldBeEqual("Hello, World!")
        }
    }

    @Test
    fun `add instance and string creates instance`() {
        // Given
        val a = MutStringySubject("Hello, ")
        val b = "World!"

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<MutStringySubject> {
            it.str.shouldBeEqual("Hello, World!")
        }
    }

    @Test
    fun `add string and instance creates (class printout) string`() {
        // Given
        val a = "Hello, "
        val b = MutStringySubject("World!")

        // When
        val c = a + b

        // Then
        shouldNotThrowAny {
            c.shouldBeInstanceOf<String> {
                it.shouldBeEqual("Hello, MutStringySubject(str=World!)")
            }
        }
    }

    @Test
    fun `add instance and any creates instance`() {
        // Given
        val a = MutStringySubject("Hello, ")
        val b = 42

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<MutStringySubject> {
            it.str.shouldBeEqual("Hello, 42")
        }
    }

    @Test
    fun `compare to same type`() {
        // Given
        val a = MutStringySubject("A")
        val b = MutStringySubject("Z")

        // When
        val c = a > b
        val d = a < b
        val e = a >= a
        val f = a <= a
        val g = a == MutStringySubject("A")

        // Then
        c.shouldBeEqual(false)
        d.shouldBeEqual(true)
        e.shouldBeEqual(true)
        f.shouldBeEqual(true)
        g.shouldBeEqual(true)
    }

    @Test
    fun `compare to string`() {
        // Given
        val a = MutStringySubject("A")
        val b = "Z"

        // When
        val c = a > b
        val d = a < b
        val e = a >= a
        val f = a <= a
        val g = a.str == "A" // No way to override the == operator at this time (reserved).
        val h = a == MutStringySubject("A")
        val i = a == MutStringySubject("B")
        val j = a != MutStringySubject("A")
        val k = a != MutStringySubject("B")

        // Then
        c.shouldBeEqual(false)
        d.shouldBeEqual(true)
        e.shouldBeEqual(true)
        f.shouldBeEqual(true)
        g.shouldBeEqual(true)
        h.shouldBeEqual(true)
        i.shouldBeEqual(false)
        j.shouldBeEqual(false)
        k.shouldBeEqual(true)
    }

    @Test
    fun `measure length`() {
        // Given
        val a = MutStringySubject("Hello, World!")

        // When
        val b = a.length

        // Then
        b.shouldBeEqual(13)
    }

    @Test
    fun `get character at index`() {
        // Given
        val a = MutStringySubject("Hello, World!")

        // When
        val b = a[7]

        // Then
        b.shouldBeEqual('W')
    }

    @Test
    fun `get subsequence`() {
        // Given
        val a = MutStringySubject("Hello, World!")

        // When
        val b = a.subSequence(7, 13)

        // Then
        b.shouldBeEqual("World!")
    }

    @Test
    fun `map to lowercase`() {
        // Given
        val a = MutStringySubject("Hello, World!")

        // When
        val b = a.map(String::lowercase)

        // Then
        b.str.shouldBeLowerCase()
    }
}
