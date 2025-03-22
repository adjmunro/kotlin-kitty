package nz.adjmunro.kty.functions.operators.div

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.merge.NumberMergeable

@KtyDsl
public interface NumberDivisible<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberDivisible<ActualWrapper, BackingField>
{
    @KtyDsl
    public val divideByNumber: MergeABtoA<BackingField, Number>

    @KtyDsl
    public operator fun div(num: Number): ActualWrapper {
        return merge(other = num, transform = divideByNumber)
    }
}
