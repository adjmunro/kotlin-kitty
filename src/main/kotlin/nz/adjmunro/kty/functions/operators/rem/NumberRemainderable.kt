package nz.adjmunro.kty.functions.operators.rem

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.merge.NumberMergeable

@KtyDsl
public interface NumberRemainderable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberRemainderable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val remainderByNumber: MergeABtoA<BackingField, Number>

    @KtyDsl
    public operator fun rem(num: Number): ActualWrapper {
        return merge(other = num, transform = remainderByNumber)
    }
}
