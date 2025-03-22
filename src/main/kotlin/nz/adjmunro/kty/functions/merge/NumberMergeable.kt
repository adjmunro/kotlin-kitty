package nz.adjmunro.kty.functions.merge

import nz.adjmunro.kty.Boxed
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA

@KtyDsl
public interface NumberMergeable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where ActualWrapper : NumberMergeable<ActualWrapper, BackingField> {

    @KtyDsl
    public fun merge(other: Number, transform: MergeABtoA<BackingField, Number>): ActualWrapper {
        return reconstruct(transform(a = value, b = other))
    }
}
