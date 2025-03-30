package nz.adjmunro.kty.functions

import nz.adjmunro.kty.Boxed

@KtyDsl
public interface Transformable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where
    ActualWrapper : Transformable<ActualWrapper, BackingField> {

    /** Applies some [transform] to the [BackingField] and [reconstructs][reconstruct] the [ActualWrapper]. */
    @KtyDsl
    public infix fun map(transform: Transform<BackingField>): ActualWrapper {
        return reconstruct(transform(value))
    }

}
