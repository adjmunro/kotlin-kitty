package nz.adjmunro.kty.tuple

import nz.adjmunro.kty.tuple.Tuple.Tuple8d

public data class Octuple<out A, out B, out C, out D, out E, out F, out G, out H>(
    val first: A,
    val second: B,
    val third: C,
    val fourth: D,
    val fifth: E,
    val sixth: F,
    val seventh: G,
    val eighth: H,
) : Tuple8d<A, B, C, D, E, F, G, H> {

    override fun toString(): String {
        return "Octuple<8>($first, $second, $third, $fourth, $fifth, $sixth, $seventh, $eighth)"
    }

    public operator fun <I> plus(ninth: I): Nonuple<A, B, C, D, E, F, G, H, I> = Nonuple(
        first = first,
        second = second,
        third = third,
        fourth = fourth,
        fifth = fifth,
        sixth = sixth,
        seventh = seventh,
        eighth = eighth,
        ninth = ninth,
    )

}
