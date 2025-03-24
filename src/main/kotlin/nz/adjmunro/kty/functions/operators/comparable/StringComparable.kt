package nz.adjmunro.kty.functions.operators.comparable

import nz.adjmunro.kty.Boxed
import nz.adjmunro.kty.functions.DifferenceAB
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.merge.AnyMergeable

/** Interface for [Boxed] types that can compare directly with a [String]. */
@KtyDsl
public interface StringComparable<ActualWrapper, BackingField> :
    AnyMergeable<ActualWrapper, BackingField> where
    ActualWrapper : StringComparable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val compareByString: DifferenceAB<BackingField, String>

    @KtyDsl
    public operator fun compareTo(str: String): Int = compareByString(value, str)
}
