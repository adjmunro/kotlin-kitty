package nz.adjmunro.kty.functions.operators.minus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.Mergeable

@KtyDsl
public interface Subtractable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Subtractable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val minus: Merge<BackingField>

    @KtyDsl
    public operator fun minus(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = minus)
    }
}
