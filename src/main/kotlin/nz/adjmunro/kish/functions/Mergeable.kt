package nz.adjmunro.kish.functions

import nz.adjmunro.kish.Boxed
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.Merge

/**
 * Represents a self-merging interface for types that wrap a backing field.
 *
 * The purpose of this interface is to provide a mechanism to merge two instances of the same type
 * by unwrapping their backing fields, applying a transformation function to these fields, and
 * wrapping the result into a new instance of the same type.
 *
 * @param ActualWrapper The specific type implementing the interface.
 * @param BackingField The type of the backing field wrapped by the instances.
 */
@KishDsl
public interface Mergeable<ActualWrapper, BackingField> :
    Boxed<ActualWrapper, BackingField> where
    ActualWrapper : Mergeable<ActualWrapper, BackingField> {

    /**
     * Merges this [Boxed] instance with another [Boxed] instance to create a new instance
     * of the same type.
     *
     * *Specifically, this function unwraps the backing field of the receiver and the [other]
     * instance, applies the [transform] function to both fields, and wraps the resulting value
     * in a new instance of this type.*
     *
     * @param other The [Boxed] instance to merge with this instance. It must be of the same type.
     * @param transform A function to combine the backing fields of this instance and [other].
     *                  The function takes two parameters: the receiver's backing field
     *                  and [other]'s backing field.
     * @return A new instance of the same type as the receiver, wrapping the result of [transform].
     */
    @KishDsl public fun merge(other: ActualWrapper, transform: Merge<BackingField>): ActualWrapper {
        return reconstruct(transform(this.value, other.value))
    }
}
