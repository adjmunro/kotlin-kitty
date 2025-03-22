package nz.adjmunro.kish.operators.times

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA
import nz.adjmunro.kish.functions.merge.NumberMergeable
import nz.adjmunro.kish.operators.minus.NumberSubtractable

@KishDsl public interface NumberMultipliable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberSubtractable<ActualWrapper, BackingField>
{
    @KishDsl public val multiplyByNumber: MergeABtoA<BackingField, Number>

    @KishDsl
    public operator fun times(num: Number): ActualWrapper {
        return merge(other = num, transform = multiplyByNumber)
    }
}