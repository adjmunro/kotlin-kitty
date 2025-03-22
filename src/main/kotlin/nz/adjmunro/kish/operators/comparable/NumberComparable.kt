package nz.adjmunro.kish.operators.comparable

import nz.adjmunro.kish.Boxed
import nz.adjmunro.kish.DifferenceAB
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.functions.merge.NumberMergeable

/** Interface for [Boxed] types that can compare directly with any [Number] type. */
@KishDsl
public interface NumberComparable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberComparable<ActualWrapper, BackingField>
{
    @KishDsl
    public val compareByNumber: DifferenceAB<BackingField, Number>

    @KishDsl
    public operator fun compareTo(num: Number): Int = compareByNumber(value, num)
}
