package nz.adjmunro.kty

import nz.adjmunro.kty.functions.KtyDsl

@KtyDsl
public sealed interface Angle<T : Angle<T>> : Doubly<T> {

    @JvmInline
    @KtyDsl
    public value class Degrees(override val value: Double) : Angle<Degrees> {
        override val reconstruct: (Double) -> Degrees get() = ::Degrees

        @KtyDsl
        public inline val radians: Radians
            get() = Radians(value = Math.toRadians(value))
    }

    @JvmInline
    @KtyDsl
    public value class Radians(override val value: Double) : Angle<Radians> {
        override val reconstruct: (Double) -> Radians get() = ::Radians

        @KtyDsl
        public inline val degrees: Degrees
            get() = Degrees(value = Math.toDegrees(value))
    }

    @KtyDsl
    public companion object {
        /** @return Any [Number] as [Angle.Degrees]. */
        @KtyDsl
        public val Number.degrees: Degrees
            get() = Degrees(value = toDouble())

        /** @return Any [Number] as [Angle.Radians]. */
        @KtyDsl
        public val Number.radians: Radians
            get() = Radians(value = toDouble())

        /** @return Force-converts [Angle] into [Radians]. */
        @KtyDsl
        public fun Angle<*>.asRadians(): Radians = when (this) {
            is Degrees -> radians
            is Radians -> this
        }

        /** @return Force-converts [Angle] into [Degrees]. */
        @KtyDsl
        public fun Angle<*>.asDegrees(): Degrees = when (this) {
            is Radians -> degrees
            is Degrees -> this
        }
    }
}
