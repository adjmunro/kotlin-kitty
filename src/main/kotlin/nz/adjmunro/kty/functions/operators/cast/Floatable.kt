package nz.adjmunro.kty.functions.operators.cast

import nz.adjmunro.kty.functions.KtyDsl
import java.math.BigDecimal

@KtyDsl
public interface Floatable {
    @KtyDsl
    public val asFloat: Float
    @KtyDsl
    public val asDouble: Double
    @KtyDsl
    public val asBigDecimal: BigDecimal
}
