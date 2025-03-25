package nz.adjmunro.kty.tuple

import nz.adjmunro.kty.tuple.Tuple.Tuple6d

public data class Sextuple<out A, out B, out C, out D, out E, out F>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
) : Tuple6d<A, B, C, D, E, F> {

    public override fun toString(): String {
        return "Sextuple<6>($first, $second, $third, $fourth, $fifth, $sixth)"
    }

    public operator fun <G> plus(seventh: G): Septuple<A, B, C, D, E, F, G> = Septuple(
        first = first,
        second = second,
        third = third,
        fourth = fourth,
        fifth = fifth,
        sixth = sixth,
        seventh = seventh,
    )

}
