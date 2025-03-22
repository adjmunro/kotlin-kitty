package nz.adjmunro.kty.functions.operators.div

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.Mergeable

@KtyDsl
public interface Divisible<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Divisible<ActualWrapper, BackingField>
{
    @KtyDsl
    public val divide: Merge<BackingField>

    @KtyDsl
    public operator fun div(other: ActualWrapper): ActualWrapper {
        return merge(other = other, transform = divide)
    }
}
