package nz.adjmunro.kish.operators.comparable

import nz.adjmunro.kish.Boxed
import nz.adjmunro.kish.DifferenceAB
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.functions.merge.StringMergeable

/** Interface for [Boxed] types that can compare directly with a [String]. */
@KishDsl
public interface StringComparable<ActualWrapper, BackingField> :
    StringMergeable<ActualWrapper, BackingField> where
    ActualWrapper : StringComparable<ActualWrapper, BackingField>
{
    @KishDsl
    public val compareByString: DifferenceAB<BackingField, String>

    @KishDsl
    public operator fun compareTo(str: String): Int = compareByString(value, str)
}
