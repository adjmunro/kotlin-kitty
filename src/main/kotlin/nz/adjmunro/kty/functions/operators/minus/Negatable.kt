package nz.adjmunro.kty.functions.operators.minus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Mergeable
import nz.adjmunro.kty.functions.Transform

@KtyDsl
public interface Negatable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Negatable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val negate: Transform<BackingField>

    @KtyDsl
    public operator fun unaryMinus(): ActualWrapper {
        return reconstruct(negate(value))
    }
}
