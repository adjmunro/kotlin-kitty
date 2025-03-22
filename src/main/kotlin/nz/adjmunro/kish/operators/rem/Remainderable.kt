package nz.adjmunro.kish.operators.rem

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge
import nz.adjmunro.kish.functions.Mergeable

@KishDsl
public interface Remainderable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Remainderable<ActualWrapper, BackingField>
{
    @KishDsl public val remainder: Merge<BackingField>

    @KishDsl public operator fun rem(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = remainder)
    }
}