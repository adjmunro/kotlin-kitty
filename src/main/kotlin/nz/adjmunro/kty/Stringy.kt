package nz.adjmunro.kty

import nz.adjmunro.kty.functions.Difference
import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.Transformable
import nz.adjmunro.kty.functions.operators.comparable.BoxedComparable
import nz.adjmunro.kty.functions.operators.plus.Addable
import nz.adjmunro.kty.functions.operators.plus.AnyAddable

@KtyDsl
public interface Stringy<W : Stringy<W>> :
    BoxedComparable<W, String>,
    Transformable<W, String>,
    Addable<W, String>,
    AnyAddable<W, String>,
    CharSequence
{
    override val addByAny: MergeABtoA<String, Any?>
        get() = MergeABtoA { a: String, b: Any? -> a + b }

    override val compareToSelf: Difference<String>
        get() = String::compareTo

    /** @see CharSequence.length */
    override val length: Int
        get() = value.length

    override val plus: Merge<String>
        get() = String::plus

    /** @see CharSequence.get */
    override operator fun get(index: Int): Char = value[index]

    /** @see CharSequence.subSequence */
    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence =
        value.subSequence(startIndex, endIndex)

}
