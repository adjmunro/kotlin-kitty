package nz.adjmunro.kty.tuple.numbery

import nz.adjmunro.kty.Numbery
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.operators.Mathable
import nz.adjmunro.kty.functions.operators.NumberMathable
import nz.adjmunro.kty.tuple.Tuple2

public interface Numbery2D<ActualWrapper, BackingField> :
    Mathable<ActualWrapper, Tuple2<BackingField>>,
    NumberMathable<ActualWrapper, Tuple2<BackingField>>,
    Tuple2<BackingField> where
    ActualWrapper : Numbery2D<ActualWrapper, BackingField>,
    BackingField : Numbery<BackingField, *>
{
    public val reconstructor: (BackingField, BackingField) -> ActualWrapper

    public override val reconstruct: (Tuple2<BackingField>) -> ActualWrapper
        get() = { (a, b) -> reconstructor(a, b) }

    override val value: Tuple2<BackingField>
        get() = this@Numbery2D

    override val plus: Merge<Tuple2<BackingField>>
        get() = { (a, b), (p, q) -> reconstructor(a + p, b + q) }

    override val minus: Merge<Tuple2<BackingField>>
        get() = { (a, b), (p, q) -> reconstructor(a - p, b - q) }

    override val times: Merge<Tuple2<BackingField>>
        get() = { (a, b), (p, q) -> reconstructor(a * p, b * q) }

    override val divide: Merge<Tuple2<BackingField>>
        get() = { (a, b), (p, q) -> reconstructor(a / p, b / q) }

    override val remainder: Merge<Tuple2<BackingField>>
        get() = { (a, b), (p, q) -> reconstructor(a % p, b % q) }

    override val addByNumber: MergeABtoA<Tuple2<BackingField>, Number>
        get() = MergeABtoA { (a, b), n -> reconstructor(a + n, b + n) }

    override val subtractByNumber: MergeABtoA<Tuple2<BackingField>, Number>
        get() = MergeABtoA { (a, b), n -> reconstructor(a - n, b - n) }

    override val multiplyByNumber: MergeABtoA<Tuple2<BackingField>, Number>
        get() = MergeABtoA { (a, b), n -> reconstructor(a * n, b * n) }

    override val divideByNumber: MergeABtoA<Tuple2<BackingField>, Number>
        get() = MergeABtoA { (a, b), n -> reconstructor(a / n, b / n) }

    override val remainderByNumber: MergeABtoA<Tuple2<BackingField>, Number>
        get() = MergeABtoA { (a, b), n -> reconstructor(a % n, b % n) }
}
