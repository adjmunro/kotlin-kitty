package nz.adjmunro.kty.tuple

import nz.adjmunro.kty.tuple.Tuple.Tuple2d

public data class Duple<out A, out B>(
    public val first: A,
    public val second: B,
) : Tuple2d<A, B> {

    public override fun toString(): String {
        return "Duple<2>($first, $second)"
    }

    public operator fun <C> plus(third: C): Triple<A, B, C> = Triple(
        first = first,
        second = second,
        third = third
    )

}
