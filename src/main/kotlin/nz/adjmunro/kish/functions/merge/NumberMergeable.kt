package nz.adjmunro.kish.functions.merge

import nz.adjmunro.kish.Boxed
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA

@KishDsl
public interface NumberMergeable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where ActualWrapper : NumberMergeable<ActualWrapper, BackingField> {

    @KishDsl public fun merge(other: Number, transform: MergeABtoA<BackingField, Number>): ActualWrapper {
        return reconstruct(transform(a = value, b = other))
    }
}
