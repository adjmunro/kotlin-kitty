package nz.adjmunro.kty.tuple

import nz.adjmunro.kty.tuple.Tuple.Tuple5d

public data class Quintuple<out A, out B, out C, out D, out E>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
) : Tuple5d<A, B, C, D, E> {

    public override fun toString(): String {
        return "Quintuple<5>($first, $second, $third, $fourth, $fifth)"
    }

    public operator fun <F> plus(sixth: F): Sextuple<A, B, C, D, E, F> = Sextuple(
        first = first,
        second = second,
        third = third,
        fourth = fourth,
        fifth = fifth,
        sixth = sixth,
    )

}
