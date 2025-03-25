package nz.adjmunro.kty.tuple.numbery

import nz.adjmunro.kty.Numbery
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.operators.Mathable
import nz.adjmunro.kty.functions.operators.NumberMathable
import nz.adjmunro.kty.tuple.Tuple3

public interface NumberyTriple<ActualWrapper, BackingField> :
    Mathable<ActualWrapper, Tuple3<BackingField>>,
    NumberMathable<ActualWrapper, Tuple3<BackingField>>,
    Tuple3<BackingField> where
    ActualWrapper : NumberyTriple<ActualWrapper, BackingField>,
    BackingField : Numbery<BackingField, *>
{
    public val reconstructor: (BackingField, BackingField, BackingField) -> ActualWrapper

    public override val reconstruct: (Tuple3<BackingField>) -> ActualWrapper
        get() = { (a, b, c) -> reconstructor(a, b, c) }

    override val value: Tuple3<BackingField>
        get() = this@NumberyTriple

    override val plus: Merge<Tuple3<BackingField>>
        get() = { (a, b, c), (p, q, r) -> reconstructor(a + p, b + q, c + r) }

    override val minus: Merge<Tuple3<BackingField>>
        get() = { (a, b, c), (p, q, r) -> reconstructor(a - p, b - q, c - r) }

    override val times: Merge<Tuple3<BackingField>>
        get() = { (a, b, c), (p, q, r) -> reconstructor(a * p, b * q, c * r) }

    override val divide: Merge<Tuple3<BackingField>>
        get() = { (a, b, c), (p, q, r) -> reconstructor(a / p, b / q, c / r) }

    override val remainder: Merge<Tuple3<BackingField>>
        get() = { (a, b, c), (p, q, r) -> reconstructor(a % p, b % q, c % r) }

    override val addByNumber: MergeABtoA<Tuple3<BackingField>, Number>
        get() = MergeABtoA { (a, b, c), n -> reconstructor(a + n, b + n, c + n) }

    override val subtractByNumber: MergeABtoA<Tuple3<BackingField>, Number>
        get() = MergeABtoA { (a, b, c), n -> reconstructor(a - n, b - n, c - n) }

    override val multiplyByNumber: MergeABtoA<Tuple3<BackingField>, Number>
        get() = MergeABtoA { (a, b, c), n -> reconstructor(a * n, b * n, c * n) }

    override val divideByNumber: MergeABtoA<Tuple3<BackingField>, Number>
        get() = MergeABtoA { (a, b, c), n -> reconstructor(a / n, b / n, c / n) }

    override val remainderByNumber: MergeABtoA<Tuple3<BackingField>, Number>
        get() = MergeABtoA { (a, b, c), n -> reconstructor(a % n, b % n, c % n) }
}
