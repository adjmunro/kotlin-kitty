package nz.adjmunro.kty.functions.operators.plus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.merge.AnyMergeable

@KtyDsl
public interface AnyAddable<ActualWrapper, BackingField> :
    AnyMergeable<ActualWrapper, BackingField> where
    ActualWrapper : AnyAddable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val addByAny: MergeABtoA<BackingField, Any?>

    @KtyDsl
    public operator fun plus(other: Any?): ActualWrapper {
        return merge(other = other, transform = addByAny)
    }
}
