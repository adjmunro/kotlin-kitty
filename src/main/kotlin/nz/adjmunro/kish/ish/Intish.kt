package nz.adjmunro.kish.ish

import nz.adjmunro.kish.Difference
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge

@KishDsl
public interface Intish<W : Intish<W>> : Numberish<W, Int> {
    override val value: Int
    override val spec: (Number) -> Int get() = Number::toInt
    override val plus: Merge<Int> get() = Int::plus
    override val minus: Merge<Int> get() = Int::minus
    override val times: Merge<Int> get() = Int::times
    override val divide: Merge<Int> get() = Int::div
    override val remainder: Merge<Int> get() = Int::rem
    override val compareToSelf: Difference<Int> get() = Int::compareTo
}
