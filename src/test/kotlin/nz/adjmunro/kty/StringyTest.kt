package nz.adjmunro.kty

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlin.test.Test

class StringyTest {

    @JvmInline
    value class StringySubject(override val value: String) : Stringy<StringySubject> {
        override val reconstruct: (String) -> StringySubject
            get() = ::StringySubject
    }

    @Test
    fun `create instance of child class`() {
        StringySubject("Hello, World!").shouldBeInstanceOf<StringySubject> {
            it.value.shouldBeEqual("Hello, World!")
        }
    }

    @Test
    fun `add two instances`() {
        // Given
        val a = StringySubject("Hello, ")
        val b = StringySubject("World!")

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<StringySubject> {
            it.value.shouldBeEqual("Hello, World!")
        }
    }

    @Test
    fun `add instance and string creates instance`() {
        // Given
        val a = StringySubject("Hello, ")
        val b = "World!"

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<StringySubject> {
            it.value.shouldBeEqual("Hello, World!")
        }
    }

    @Test
    fun `add string and instance creates (class printout) string`() {
        // Given
        val a = "Hello, "
        val b = StringySubject("World!")

        // When
        val c = a + b

        // Then
        shouldNotThrowAny {
            c.shouldBeInstanceOf<String> {
                it.shouldBeEqual("Hello, StringySubject(value=World!)")
            }
        }
    }

    @Test
    fun `add instance and any creates instance`() {
        // Given
        val a = StringySubject("Hello, ")
        val b = 42

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<StringySubject> {
            it.value.shouldBeEqual("Hello, 42")
        }
    }

    @Test
    fun `compare to same type`() {
        // Given
        val a = StringySubject("A")
        val b = StringySubject("Z")

        // When
        val c = a > b
        val d = a < b
        val e = a >= a
        val f = a <= a
        val g = a == StringySubject("A")

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
        val a = StringySubject("A")
        val b = "Z"

        // When
        val c = a > b
        val d = a < b
        val e = a >= a
        val f = a <= a
        val g = a.value == "A" // No way to override the == operator at this time (reserved).

        // Then
        c.shouldBeEqual(false)
        d.shouldBeEqual(true)
        e.shouldBeEqual(true)
        f.shouldBeEqual(true)
        g.shouldBeEqual(true)
    }

    @Test
    fun `measure length`() {
        // Given
        val a = StringySubject("Hello, World!")

        // When
        val b = a.length

        // Then
        b.shouldBeEqual(13)
    }

    @Test
    fun `get character at index`() {
        // Given
        val a = StringySubject("Hello, World!")

        // When
        val b = a[7]

        // Then
        b.shouldBeEqual('W')
    }

    @Test
    fun `get subsequence`() {
        // Given
        val a = StringySubject("Hello, World!")

        // When
        val b = a.subSequence(7, 13)

        // Then
        b.shouldBeEqual("World!")
    }
}
