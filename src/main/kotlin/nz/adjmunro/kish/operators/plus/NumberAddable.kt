package nz.adjmunro.kish.operators.plus

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA
import nz.adjmunro.kish.functions.merge.NumberMergeable

@KishDsl
public interface NumberAddable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberAddable<ActualWrapper, BackingField>
{
    @KishDsl public val addByNumber: MergeABtoA<BackingField, Number>

    @KishDsl public operator fun plus(num: Number): ActualWrapper {
        return merge(other = num, transform = addByNumber)
    }
}