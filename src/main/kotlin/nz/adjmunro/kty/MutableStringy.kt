package nz.adjmunro.kty

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.Transformable
import nz.adjmunro.kty.functions.operators.plus.Addable
import nz.adjmunro.kty.functions.operators.plus.AnyAddable

@KtyDsl
public interface MutableStringy<W : MutableStringy<W>> :
    Stringy<W>,
    Transformable<W, String>,
    Addable<W, String>,
    AnyAddable<W, String>
{
    /** @see String.plus */
    override val addByAny: MergeABtoA<String, Any?>
        get() = MergeABtoA { a: String, b: Any? -> a + b }

    /** @see String.plus */
    override val plus: Merge<String>
        get() = String::plus
}
