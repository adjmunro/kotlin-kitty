package nz.adjmunro.kty

import nz.adjmunro.kty.functions.Difference
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge

@KtyDsl
public interface Inty<W : Inty<W>> : Numbery<W, Int> {
    override val value: Int
    override val spec: (Number) -> Int get() = Number::toInt
    override val plus: Merge<Int> get() = Int::plus
    override val minus: Merge<Int> get() = Int::minus
    override val times: Merge<Int> get() = Int::times
    override val divide: Merge<Int> get() = Int::div
    override val remainder: Merge<Int> get() = Int::rem
    override val compareToSelf: Difference<Int> get() = Int::compareTo
}
