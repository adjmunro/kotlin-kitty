package nz.adjmunro.kish.operators.plus

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA
import nz.adjmunro.kish.functions.merge.StringMergeable

@KishDsl
public interface StringAddable<ActualWrapper, BackingField> :
    StringMergeable<ActualWrapper, BackingField> where
ActualWrapper : StringAddable<ActualWrapper, BackingField>
{
    @KishDsl public val addByString: MergeABtoA<BackingField, String>

    @KishDsl public operator fun plus(str: String): ActualWrapper {
        return merge(other = str, transform = addByString)
    }
}
