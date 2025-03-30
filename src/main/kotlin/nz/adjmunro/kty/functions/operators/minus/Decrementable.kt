package nz.adjmunro.kty.functions.operators.minus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Mergeable
import nz.adjmunro.kty.functions.Transform

@KtyDsl
public interface Decrementable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Decrementable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val decrement: Transform<BackingField>

    @KtyDsl
    public operator fun dec(): ActualWrapper {
        return reconstruct(decrement(value))
    }
}
