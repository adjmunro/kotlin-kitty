package nz.adjmunro.kish.operators.times

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge
import nz.adjmunro.kish.functions.Mergeable

@KishDsl
public interface Multipliable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Multipliable<ActualWrapper, BackingField>
{
    @KishDsl public val times: Merge<BackingField>

    @KishDsl public operator fun times(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = times)
    }
}