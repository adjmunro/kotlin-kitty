package nz.adjmunro.kty.functions.operators.plus

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.merge.StringMergeable

@KtyDsl
public interface StringAddable<ActualWrapper, BackingField> :
    StringMergeable<ActualWrapper, BackingField> where
ActualWrapper : StringAddable<ActualWrapper, BackingField>
{
    @KtyDsl
    public val addByString: MergeABtoA<BackingField, String>

    @KtyDsl
    public operator fun plus(str: String): ActualWrapper {
        return merge(other = str, transform = addByString)
    }
}
