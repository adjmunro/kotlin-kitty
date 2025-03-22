package nz.adjmunro.kty

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Transformable
import nz.adjmunro.kty.functions.operators.comparable.BoxedComparable
import nz.adjmunro.kty.functions.operators.plus.StringAddable

@KtyDsl
public interface Stringy<W : Stringy<W>> :
    BoxedComparable<W, String>,
    Transformable<W, String>,
    StringAddable<W, String>,
    CharSequence {

    /** @see CharSequence.length */
    override val length: Int get() = value.length

    /** @see CharSequence.get */
    override operator fun get(index: Int): Char = value[index]

    /** @see CharSequence.subSequence */
    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence =
        value.subSequence(startIndex, endIndex)
}
