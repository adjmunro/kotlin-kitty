package nz.adjmunro.kty

import nz.adjmunro.kty.functions.Difference
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge

@KtyDsl
public interface Longy<W : Longy<W>> : Numbery<W, Long> {
    override val value: Long
    override val spec: (Number) -> Long get() = Number::toLong
    override val plus: Merge<Long> get() = Long::plus
    override val minus: Merge<Long> get() = Long::minus
    override val times: Merge<Long> get() = Long::times
    override val divide: Merge<Long> get() = Long::div
    override val remainder: Merge<Long> get() = Long::rem
    override val compareToSelf: Difference<Long> get() = Long::compareTo
}
