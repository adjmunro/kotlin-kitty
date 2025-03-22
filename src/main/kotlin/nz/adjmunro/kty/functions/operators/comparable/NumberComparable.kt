package nz.adjmunro.kty.functions.operators.comparable

import nz.adjmunro.kty.Boxed
import nz.adjmunro.kty.functions.DifferenceAB
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.merge.NumberMergeable

/** Interface for [Boxed] types that can compare directly with any [Number] type. */
@KtyDsl
public interface NumberComparable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberComparable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val compareByNumber: DifferenceAB<BackingField, Number>

    @KtyDsl
    public operator fun compareTo(num: Number): Int = compareByNumber(value, num)
}
