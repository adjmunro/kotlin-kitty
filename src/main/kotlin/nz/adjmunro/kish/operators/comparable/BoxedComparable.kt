package nz.adjmunro.kish.operators.comparable

import nz.adjmunro.kish.Boxed
import nz.adjmunro.kish.Difference
import nz.adjmunro.kish.KishDsl

/**
 * A [Boxed] type that can compare to [itself][ActualWrapper], or its [field type][BackingField].
 *
 * *Only comparing against the [ActualWrapper] inherits from [Comparable],
 * as comparing to oneself is seen as default behaviour.*
 */
@KishDsl
@Suppress("INAPPLICABLE_JVM_NAME")
public interface BoxedComparable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField>,
    Comparable<ActualWrapper> where
    ActualWrapper : BoxedComparable<ActualWrapper, BackingField>
{
    @KishDsl
    public val compareToSelf: Difference<BackingField>

    @KishDsl
    @JvmName("compareToActualWrapper")
    public override fun compareTo(other: ActualWrapper): Int = compareToSelf(value, other.value)

    @KishDsl
    @JvmName("compareToBackingField")
    public operator fun compareTo(other: BackingField): Int = compareToSelf(value, other)
}
