package nz.adjmunro.kish.operators.plus

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge
import nz.adjmunro.kish.functions.Mergeable

@KishDsl public interface Addable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Addable<ActualWrapper, BackingField>
{
    @KishDsl
    public val plus: Merge<BackingField>

    @KishDsl public operator fun plus(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = plus)
    }
}