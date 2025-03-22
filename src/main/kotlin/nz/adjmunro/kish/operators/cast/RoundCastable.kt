package nz.adjmunro.kish.operators.cast

import nz.adjmunro.kish.KishDsl

@KishDsl
public interface RoundCastable {
    @KishDsl public val roundToInt: () -> Int
    @KishDsl public val roundToLong: () -> Long
}