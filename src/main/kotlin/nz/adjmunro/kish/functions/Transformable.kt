package nz.adjmunro.kish.functions

import nz.adjmunro.kish.Boxed
import nz.adjmunro.kish.KishDsl

@KishDsl
public interface Transformable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where
    ActualWrapper : Transformable<ActualWrapper, BackingField> {

    /** Applies some [transform] to the [BackingField] and [reconstructs][reconstruct] the [ActualWrapper]. */
    @KishDsl public infix fun map(transform: (BackingField) -> BackingField): ActualWrapper {
        return reconstruct(transform(value))
    }

}
