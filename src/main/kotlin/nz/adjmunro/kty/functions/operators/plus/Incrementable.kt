package nz.adjmunro.kty.functions.operators.plus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Mergeable
import nz.adjmunro.kty.functions.Transform

@KtyDsl
public interface Incrementable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
ActualWrapper : Incrementable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val increment: Transform<BackingField>

    @KtyDsl
    public operator fun inc(): ActualWrapper {
        return reconstruct(increment(value))
    }
}
