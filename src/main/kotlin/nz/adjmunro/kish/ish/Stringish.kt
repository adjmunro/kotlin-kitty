package nz.adjmunro.kish.ish

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.functions.Transformable
import nz.adjmunro.kish.operators.comparable.BoxedComparable
import nz.adjmunro.kish.operators.plus.StringAddable

@KishDsl
public interface Stringish<W : Stringish<W>> :
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
