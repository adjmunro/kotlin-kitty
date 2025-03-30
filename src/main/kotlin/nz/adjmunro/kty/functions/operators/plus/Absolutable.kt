package nz.adjmunro.kty.functions.operators.plus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Mergeable
import nz.adjmunro.kty.functions.Transform

@KtyDsl
public interface Absolutable<ActualWrapper, BackingField> :
    Mergeable<ActualWrapper, BackingField> where
    ActualWrapper : Absolutable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val absolute: Transform<BackingField>

    @KtyDsl
    public operator fun unaryPlus(): ActualWrapper {
        return reconstruct(absolute(value))
    }
}
