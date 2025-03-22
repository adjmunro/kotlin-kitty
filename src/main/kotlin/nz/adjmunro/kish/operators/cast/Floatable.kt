package nz.adjmunro.kish.operators.cast

import nz.adjmunro.kish.KishDsl
import java.math.BigDecimal

@KishDsl
public interface Floatable {
    @KishDsl public val asFloat: Float
    @KishDsl public val asDouble: Double
    @KishDsl public val asBigDecimal: BigDecimal
}