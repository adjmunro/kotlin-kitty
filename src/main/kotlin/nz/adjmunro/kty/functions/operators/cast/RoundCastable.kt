package nz.adjmunro.kty.functions.operators.cast

import nz.adjmunro.kty.functions.KtyDsl

@KtyDsl
public interface RoundCastable {
    @KtyDsl
    public val roundToInt: () -> Int
    @KtyDsl
    public val roundToLong: () -> Long
}
