package nz.adjmunro.kish.functions.merge

import nz.adjmunro.kish.Boxed
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA

@KishDsl
public interface StringMergeable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where ActualWrapper : StringMergeable<ActualWrapper, BackingField> {

    @KishDsl
    public fun merge(other: String, transform: MergeABtoA<BackingField, String>): ActualWrapper {
        return reconstruct(transform(a = value, b = other))
    }
}
