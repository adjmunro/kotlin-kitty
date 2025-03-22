package nz.adjmunro.kty.functions.operators.plus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.merge.NumberMergeable

@KtyDsl
public interface NumberAddable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberAddable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val addByNumber: MergeABtoA<BackingField, Number>

    @KtyDsl
    public operator fun plus(num: Number): ActualWrapper {
        return merge(other = num, transform = addByNumber)
    }
}
