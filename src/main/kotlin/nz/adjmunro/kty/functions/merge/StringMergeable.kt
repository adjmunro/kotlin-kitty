package nz.adjmunro.kty.functions.merge

import nz.adjmunro.kty.Boxed
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA

@KtyDsl
public interface StringMergeable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where ActualWrapper : StringMergeable<ActualWrapper, BackingField> {

    @KtyDsl
    public fun merge(other: String, transform: MergeABtoA<BackingField, String>): ActualWrapper {
        return reconstruct(transform(a = value, b = other))
    }
}
