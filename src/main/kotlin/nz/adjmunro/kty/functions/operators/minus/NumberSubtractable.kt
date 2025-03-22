package nz.adjmunro.kty.functions.operators.minus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.merge.NumberMergeable

@KtyDsl
public interface NumberSubtractable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberSubtractable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val subtractByNumber: MergeABtoA<BackingField, Number>

    @KtyDsl
    public operator fun minus(num: Number): ActualWrapper {
        return merge(other = num, transform = subtractByNumber)
    }
}
