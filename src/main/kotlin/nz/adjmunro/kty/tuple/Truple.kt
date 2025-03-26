package nz.adjmunro.kty.tuple

import nz.adjmunro.kty.tuple.Tuple.Tuple3d

public data class Truple<out A, out B, out C>(
    public val first: A,
    public val second: B,
    public val third: C,
): Tuple3d<A, B, C> {

    public override fun toString(): String {
        return "Truple<3>($first, $second, $third)"
    }

    public operator fun <D> plus(fourth: D): Quadruple<A, B, C, D> = Quadruple(
        first = first,
        second = second,
        third = third,
        fourth = fourth
    )

}
