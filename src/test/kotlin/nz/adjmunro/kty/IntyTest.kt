package nz.adjmunro.kty

import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.types.shouldBeInstanceOf
import kotlin.test.Test

class IntyTest {

    @JvmInline
    value class I(override val value: Int): Inty<I> {
        override val reconstruct: (Int) -> I get() = ::I
    }

    @Test
    fun `create Inty`() {
        I(0).shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
        I(Int.MAX_VALUE).shouldBeInstanceOf<I> { it.value.shouldBeEqual(Int.MAX_VALUE) }
        I(Int.MIN_VALUE).shouldBeInstanceOf<I> { it.value.shouldBeEqual(Int.MIN_VALUE) }
        I(Int.MAX_VALUE + 1).shouldBeInstanceOf<I> { it.value.shouldBeEqual(Int.MIN_VALUE) }
        I(Int.MIN_VALUE - 1).shouldBeInstanceOf<I> { it.value.shouldBeEqual(Int.MAX_VALUE) }
    }

    @Test
    fun `add Inty and Inty`() {
        // Given
        val a = I(1)
        val b = I(2)

        // When
        val c = a + b

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(3) }
    }

    @Test
    fun `add Inty and Number(floor)`() {
        // Given
        val a = I(1)
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
        i1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(3) }
        l1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(3) }
        d1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(3) }
        f1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(3) }
    }

    @Test
    fun `minus Inty and Inty`() {
        // Given
        val a = I(1)
        val b = I(2)

        // When
        val c = a - b

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `minus Inty and Number(floor)`() {
        // Given
        val a = I(1)
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
        i1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(-1) }
        l1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(-1) }
        d1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(-1) }
        f1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `times Inty and Inty`() {
        // Given
        val a = I(1)
        val b = I(2)

        // When
        val c = a * b

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(2) }
    }

    @Test
    fun `times Inty and Number(floor)`() {
        // Given
        val a = I(1)
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
        i1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(2) }
        l1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(2) }
        d1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(2) }
        f1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(2) }
    }

    @Test
    fun `div Inty and Inty`() {
        // Given
        val a = I(1)
        val b = I(2)

        // When
        val c = a / b

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
    }

    @Test
    fun `div Inty and Number(floor)`() {
        // Given
        val a = I(1)
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
        i1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
        l1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
        d1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
        f1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
    }

    @Test
    fun `mod Inty and Inty`() {
        // Given
        val a = I(1)
        val b = I(2)

        // When
        val c = a % b

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(1) }
    }

    @Test
    fun `mod Inty and Number(floor)`() {
        // Given
        val a = I(1)
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
        i1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(1) }
        l1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(1) }
        d1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(1) }
        f1.shouldBeInstanceOf<I> { it.value.shouldBeEqual(1) }
    }

    @Test
    fun `unary minus Inty`() {
        // Given
        val a = I(1)

        // When
        val c = -a

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `unary plus Inty`() {
        // Given
        val a = I(-1)

        // When
        val c = +a

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(1) }
    }

    @Test
    fun `increment Inty`() {
        // Given
        var a = I(1)

        // When
        val c = ++a
        val d = a++

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(2) }
        d.shouldBeInstanceOf<I> { it.value.shouldBeEqual(2) }
        a.shouldBeInstanceOf<I> { it.value.shouldBeEqual(3) }
    }

    @Test
    fun `decrement Inty`() {
        // Given
        var a = I(1)

        // When
        val c = --a
        val d = a--

        // Then
        c.shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
        d.shouldBeInstanceOf<I> { it.value.shouldBeEqual(0) }
        a.shouldBeInstanceOf<I> { it.value.shouldBeEqual(-1) }
    }

    @Test
    fun `compare Inty and Inty`() {
        // Given
        val a = I(1)
        val b = I(2)

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
    fun `compare Inty and Number(floor)`() {
        // Given
        val a = I(1)
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
