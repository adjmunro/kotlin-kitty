package nz.adjmunro.kish.ish

import nz.adjmunro.kish.Difference
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge
import nz.adjmunro.kish.operators.cast.RoundCastable
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@KishDsl
public interface Floatish<W : Floatish<W>> : Numberish<W, Float>, RoundCastable {
    override val value: Float
    override val spec: (Number) -> Float get() = Number::toFloat
    override val plus: Merge<Float> get() = Float::plus
    override val minus: Merge<Float> get() = Float::minus
    override val times: Merge<Float> get() = Float::times
    override val divide: Merge<Float> get() = Float::div
    override val remainder: Merge<Float> get() = Float::rem
    override val compareToSelf: Difference<Float> get() = Float::compareTo
    override val roundToInt: () -> Int get() = value::roundToInt
    override val roundToLong: () -> Long get() = value::roundToLong
}
