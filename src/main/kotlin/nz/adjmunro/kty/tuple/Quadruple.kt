package nz.adjmunro.kty.tuple

import nz.adjmunro.kty.tuple.Tuple.Tuple4d

public data class Quadruple<out A, out B, out C, out D>(
    public val first: A,
    public val second: B,
    public val third: C,
    public val fourth: D,
): Tuple4d<A, B, C, D> {

    public override fun toString(): String {
        return "Quadruple<4>($first, $second, $third, $fourth)"
    }

    public operator fun <E> plus(fifth: E): Quintuple<A, B, C, D, E> = Quintuple(
        first = first,
        second = second,
        third = third,
        fourth = fourth,
        fifth = fifth
    )

}
