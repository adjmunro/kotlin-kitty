package nz.adjmunro.kish.ish

import nz.adjmunro.kish.DifferenceAB
import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.MergeABtoA
import nz.adjmunro.kish.operators.Mathable
import nz.adjmunro.kish.operators.NumberMathable
import nz.adjmunro.kish.operators.cast.NumberCastable
import nz.adjmunro.kish.operators.comparable.BoxedComparable
import nz.adjmunro.kish.operators.comparable.NumberComparable
import nz.adjmunro.kish.operators.specify.NumberSpecifiable
import java.math.BigDecimal
import java.math.BigInteger

@KishDsl
public interface Numberish<ActualWrapper, BackingField> :
    Mathable<ActualWrapper, BackingField>,
    BoxedComparable<ActualWrapper, BackingField>,
    NumberMathable<ActualWrapper, BackingField>,
    NumberComparable<ActualWrapper, BackingField>,
    NumberSpecifiable<BackingField>,
    NumberCastable where
    ActualWrapper : Numberish<ActualWrapper, BackingField>,
    BackingField : Number
{
    override val asFloat: Float get() = value.toFloat()
    override val asDouble: Double get() = value.toDouble()
    override val asBigDecimal: BigDecimal get() = BigDecimal.valueOf(asDouble)
    override val asInt: Int get() = value.toInt()
    override val asLong: Long get() = value.toLong()
    override val asBigInteger: BigInteger get() = BigInteger.valueOf(asLong)

    override val addByNumber: MergeABtoA<BackingField, Number>
        get() = MergeABtoA { a: BackingField, b: Number -> plus(a, spec(b)) }

    override val subtractByNumber: MergeABtoA<BackingField, Number>
        get() = MergeABtoA { a: BackingField, b: Number -> minus(a, spec(b)) }

    override val multiplyByNumber: MergeABtoA<BackingField, Number>
        get() = MergeABtoA { a: BackingField, b: Number -> times(a, spec(b)) }

    override val divideByNumber: MergeABtoA<BackingField, Number>
        get() = MergeABtoA { a: BackingField, b: Number -> divide(a, spec(b)) }

    override val remainderByNumber: MergeABtoA<BackingField, Number>
        get() = MergeABtoA { a: BackingField, b: Number -> remainder(a, spec(b)) }

    override val compareByNumber: DifferenceAB<BackingField, Number>
        get() = DifferenceAB { a: BackingField, b: Number -> compareToSelf(a, spec(b)) }

}
