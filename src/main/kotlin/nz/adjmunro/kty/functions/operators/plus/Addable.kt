package nz.adjmunro.kty.functions.operators.plus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.Mergeable

@KtyDsl
public interface Addable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Addable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val plus: Merge<BackingField>

    @KtyDsl
    public operator fun plus(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = plus)
    }
}
