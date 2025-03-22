package nz.adjmunro.kish.operators.div

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge
import nz.adjmunro.kish.functions.Mergeable

@KishDsl
public interface Divisible<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Divisible<ActualWrapper, BackingField>
{
    @KishDsl public val divide: Merge<BackingField>

    @KishDsl public operator fun div(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = divide)
    }
}