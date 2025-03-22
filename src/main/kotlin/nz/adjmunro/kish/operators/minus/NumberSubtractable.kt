package nz.adjmunro.kish.operators.minus

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA
import nz.adjmunro.kish.functions.merge.NumberMergeable

@KishDsl
public interface NumberSubtractable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberSubtractable<ActualWrapper, BackingField>
{
    @KishDsl public val subtractByNumber: MergeABtoA<BackingField, Number>

    @KishDsl public operator fun minus(num: Number): ActualWrapper {
        return merge(other = num, transform = subtractByNumber)
    }
}