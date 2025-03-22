package nz.adjmunro.kish.operators.div

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA
import nz.adjmunro.kish.functions.merge.NumberMergeable

@KishDsl
public interface NumberDivisible<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberDivisible<ActualWrapper, BackingField>
{
    @KishDsl public val divideByNumber: MergeABtoA<BackingField, Number>

    @KishDsl public operator fun div(num: Number): ActualWrapper {
        return merge(other = num, transform = divideByNumber)
    }
}