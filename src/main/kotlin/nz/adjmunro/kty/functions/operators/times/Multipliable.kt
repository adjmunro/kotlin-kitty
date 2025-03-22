package nz.adjmunro.kty.functions.operators.times

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.Mergeable

@KtyDsl
public interface Multipliable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Multipliable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val times: Merge<BackingField>

    @KtyDsl
    public operator fun times(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = times)
    }
}
