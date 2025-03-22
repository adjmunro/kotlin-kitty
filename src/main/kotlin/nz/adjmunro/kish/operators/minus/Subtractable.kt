package nz.adjmunro.kish.operators.minus

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge
import nz.adjmunro.kish.functions.Mergeable

@KishDsl
public interface Subtractable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Subtractable<ActualWrapper, BackingField>
{
    @KishDsl public val minus: Merge<BackingField>

    @KishDsl public operator fun minus(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = minus)
    }
}