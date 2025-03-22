package nz.adjmunro.kish.operators.rem

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA
import nz.adjmunro.kish.functions.merge.NumberMergeable

@KishDsl
public interface NumberRemainderable<ActualWrapper, BackingField> :
    NumberMergeable<ActualWrapper, BackingField> where
    ActualWrapper : NumberRemainderable<ActualWrapper, BackingField>
{
    @KishDsl public val remainderByNumber: MergeABtoA<BackingField, Number>

    @KishDsl public operator fun rem(num: Number): ActualWrapper {
        return merge(other = num, transform = remainderByNumber)
    }
}