package nz.adjmunro.kty.functions.merge

import nz.adjmunro.kty.Boxed
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA

@KtyDsl
public interface AnyMergeable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where
    ActualWrapper : AnyMergeable<ActualWrapper, BackingField>
{
    @KtyDsl
    public fun merge(other: Any?, transform: MergeABtoA<BackingField, Any?>): ActualWrapper {
        return reconstruct(transform(a = value, b = other))
    }
}
