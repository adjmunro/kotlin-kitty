package nz.adjmunro.kty.functions.operators.cast

import nz.adjmunro.kty.functions.KtyDsl
import java.math.BigInteger

@KtyDsl
public interface Wholable {
    @KtyDsl
    public val asInt: Int
    @KtyDsl
    public val asLong: Long
    @KtyDsl
    public val asBigInteger: BigInteger
}
