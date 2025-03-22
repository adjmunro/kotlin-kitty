package nz.adjmunro.kish.operators.cast

import nz.adjmunro.kish.KishDsl
import java.math.BigInteger

@KishDsl
public interface Wholable {
    @KishDsl public val asInt: Int
    @KishDsl public val asLong: Long
    @KishDsl public val asBigInteger: BigInteger
}