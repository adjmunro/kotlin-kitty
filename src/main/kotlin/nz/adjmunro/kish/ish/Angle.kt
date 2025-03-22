package nz.adjmunro.kish.ish

import nz.adjmunro.kish.KishDsl

@KishDsl
public sealed interface Angle<T : Angle<T>> : Doublish<T> {

    @JvmInline
    @KishDsl
    public value class Degrees(override val value: Double) : Angle<Degrees> {
        override val reconstruct: (Double) -> Degrees get() = ::Degrees

        @KishDsl
        public inline val radians: Radians
            get() = Radians(value = Math.toRadians(value))
    }

    @JvmInline
    @KishDsl
    public value class Radians(override val value: Double) : Angle<Radians> {
        override val reconstruct: (Double) -> Radians get() = ::Radians

        @KishDsl
        public inline val degrees: Degrees
            get() = Degrees(value = Math.toDegrees(value))
    }

    @KishDsl
    public companion object {
        /** @return Any [Number] as [Angle.Degrees]. */
        @KishDsl
        public val Number.degrees: Degrees
            get() = Degrees(value = toDouble())

        /** @return Any [Number] as [Angle.Radians]. */
        @KishDsl
        public val Number.radians: Radians
            get() = Radians(value = toDouble())

        /** @return Force-converts [Angle] into [Radians]. */
        @KishDsl
        public fun Angle<*>.asRadians(): Radians = when (this) {
            is Degrees -> radians
            is Radians -> this
        }

        /** @return Force-converts [Angle] into [Degrees]. */
        @KishDsl
        public fun Angle<*>.asDegrees(): Degrees = when (this) {
            is Radians -> degrees
            is Degrees -> this
        }
    }
}
