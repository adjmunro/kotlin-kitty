package nz.adjmunro.kty

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Reconstructable

/**
 * Interface for assisting value class operations.
 *
 * @param ActualWrapper Type of the `value class` that implements this interface.
 * @param BackingField Type of the [Boxed.value] that is stored in the value class. (e.g. [kotlin.Double])
 */
@KtyDsl
public interface Boxed<ActualWrapper, BackingField> : 
    Reconstructable<ActualWrapper, BackingField> where
    ActualWrapper : Boxed<ActualWrapper, BackingField> {
        
    /** The backing field that is wrapped in the value class. */
    @KtyDsl
    public val value: BackingField
}
