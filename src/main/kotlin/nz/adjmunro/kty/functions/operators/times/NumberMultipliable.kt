package nz.adjmunro.kty.functions.operators.times

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.merge.NumberMergeable

@KtyDsl
public interface NumberMultipliable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberMultipliable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val multiplyByNumber: MergeABtoA<BackingField, Number>

    @KtyDsl
    public operator fun times(num: Number): ActualWrapper {
        return merge(other = num, transform = multiplyByNumber)
    }
}
