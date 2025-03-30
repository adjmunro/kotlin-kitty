package nz.adjmunro.kty

import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlin.test.Test

class LongyTest {

    @JvmInline
    value class L(override val value: Long): Longy<L> {
        override val reconstruct: (Long) -> L get() = ::L
    }

    @Test
    fun `create Longy`() {
        L(0).shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
        L(Long.MAX_VALUE).shouldBeInstanceOf<L> { it.value.shouldBeEqual(Long.MAX_VALUE) }
        L(Long.MIN_VALUE).shouldBeInstanceOf<L> { it.value.shouldBeEqual(Long.MIN_VALUE) }
        L(Long.MAX_VALUE + 1).shouldBeInstanceOf<L> { it.value.shouldBeEqual(Long.MIN_VALUE) }
        L(Long.MIN_VALUE - 1).shouldBeInstanceOf<L> { it.value.shouldBeEqual(Long.MAX_VALUE) }
    }

    @Test
    fun `add Longy and Longy`() {
        // Given
        val a = L(1)
        val b = L(2)

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(3) }
    }

    @Test
    fun `add Longy and Number(floor)`() {
        // Given
        val a = L(1)
        val i = 2
        val l = 2L
        val d = 2.9
        val f = 2.5f

        // When
        val i1 = a + i
        val l1 = a + l
        val d1 = a + d
        val f1 = a + f

        // Then
        i1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(3) }
        l1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(3) }
        d1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(3) }
        f1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(3) }
    }

    @Test
    fun `minus Longy and Longy`() {
        // Given
        val a = L(1)
        val b = L(2)

        // When
        val c = a - b

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `minus Longy and Number(floor)`() {
        // Given
        val a = L(1)
        val i = 2
        val l = 2L
        val d = 2.9
        val f = 2.5f

        // When
        val i1 = a - i
        val l1 = a - l
        val d1 = a - d
        val f1 = a - f

        // Then
        i1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(-1) }
        l1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(-1) }
        d1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(-1) }
        f1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `times Longy and Longy`() {
        // Given
        val a = L(1)
        val b = L(2)

        // When
        val c = a * b

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(2) }
    }

    @Test
    fun `times Longy and Number(floor)`() {
        // Given
        val a = L(1)
        val i = 2
        val l = 2L
        val d = 2.9
        val f = 2.5f

        // When
        val i1 = a * i
        val l1 = a * l
        val d1 = a * d
        val f1 = a * f

        // Then
        i1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(2) }
        l1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(2) }
        d1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(2) }
        f1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(2) }
    }

    @Test
    fun `div Longy and Longy`() {
        // Given
        val a = L(1)
        val b = L(2)

        // When
        val c = a / b

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
    }

    @Test
    fun `div Longy and Number(floor)`() {
        // Given
        val a = L(1)
        val i = 2
        val l = 2L
        val d = 2.9
        val f = 2.5f

        // When
        val i1 = a / i
        val l1 = a / l
        val d1 = a / d
        val f1 = a / f

        // Then
        i1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
        l1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
        d1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
        f1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
    }

    @Test
    fun `mod Longy and Longy`() {
        // Given
        val a = L(1)
        val b = L(2)

        // When
        val c = a % b

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(1) }
    }

    @Test
    fun `mod Longy and Number(floor)`() {
        // Given
        val a = L(1)
        val i = 2
        val l = 2L
        val d = 2.9
        val f = 2.5f

        // When
        val i1 = a % i
        val l1 = a % l
        val d1 = a % d
        val f1 = a % f

        // Then
        i1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(1) }
        l1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(1) }
        d1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(1) }
        f1.shouldBeInstanceOf<L> { it.value.shouldBeEqual(1) }
    }

    @Test
    fun `unary minus Longy`() {
        // Given
        val a = L(1)

        // When
        val c = -a

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `unary plus Longy`() {
        // Given
        val a = L(-1)

        // When
        val c = +a

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(1) }
    }

    @Test
    fun `increment Longy`() {
        // Given
        var a = L(1)

        // When
        val c = ++a
        val d = a++

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(2) }
        d.shouldBeInstanceOf<L> { it.value.shouldBeEqual(2) }
        a.shouldBeInstanceOf<L> { it.value.shouldBeEqual(3) }
    }

    @Test
    fun `decrement Longy`() {
        // Given
        var a = L(1)

        // When
        val c = --a
        val d = a--

        // Then
        c.shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
        d.shouldBeInstanceOf<L> { it.value.shouldBeEqual(0) }
        a.shouldBeInstanceOf<L> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `compare Longy and Longy`() {
        // Given
        val a = L(1)
        val b = L(2)

        // When
        val c = a < b
        val d = a > b
        val e = a <= a
        val f = a >= a

        // Then
        c.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(true) }
        d.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(false) }
        e.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(true) }
        f.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(true) }
    }

    @Test
    fun `compare Longy and Number(floor)`() {
        // Given
        val a = L(1)
        val i = 1
        val l = 1L
        val d = 1.9
        val f = 1.00001f

        // When
        val i1 = a < i
        val l1 = a > l
        val d1 = a <= d
        val f1 = a >= f

        // Then
        i1.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(false) }
        l1.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(false) }
        d1.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(true) }
        f1.shouldBeInstanceOf<Boolean> { it.shouldBeEqual(true) }
    }

}
