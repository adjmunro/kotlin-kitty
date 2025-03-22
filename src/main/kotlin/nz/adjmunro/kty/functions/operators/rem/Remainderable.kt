package nz.adjmunro.kty.functions.operators.rem

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.Mergeable

@KtyDsl
public interface Remainderable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Remainderable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val remainder: Merge<BackingField>

    @KtyDsl
    public operator fun rem(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = remainder)
    }
}
