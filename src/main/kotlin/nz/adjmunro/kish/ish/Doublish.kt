package nz.adjmunro.kish.ish

import nz.adjmunro.kish.Difference
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge
import nz.adjmunro.kish.operators.cast.RoundCastable
import kotlin.math.roundToInt
import kotlin.math.roundToLong

@KishDsl
public interface Doublish<W : Doublish<W>> : Numberish<W, Double>, RoundCastable {
    override val value: Double
    override val spec: (Number) -> Double get() = Number::toDouble
    override val plus: Merge<Double> get() = Double::plus
    override val minus: Merge<Double> get() = Double::minus
    override val times: Merge<Double> get() = Double::times
    override val divide: Merge<Double> get() = Double::div
    override val remainder: Merge<Double> get() = Double::rem
    override val compareToSelf: Difference<Double> get() = Double::compareTo
    override val roundToInt: () -> Int get() = value::roundToInt
    override val roundToLong: () -> Long get() = value::roundToLong
}
