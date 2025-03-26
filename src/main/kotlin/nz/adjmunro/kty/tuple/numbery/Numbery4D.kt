package nz.adjmunro.kty.tuple.numbery

import nz.adjmunro.kty.Numbery
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.operators.Mathable
import nz.adjmunro.kty.functions.operators.NumberMathable
import nz.adjmunro.kty.tuple.Tuple4

public interface Numbery4D<ActualWrapper, BackingField> :
    Mathable<ActualWrapper, Tuple4<BackingField>>,
    NumberMathable<ActualWrapper, Tuple4<BackingField>>,
    Tuple4<BackingField> where
    ActualWrapper : Numbery4D<ActualWrapper, BackingField>,
    BackingField : Numbery<BackingField, *>
{
    public val reconstructor: (BackingField, BackingField, BackingField, BackingField) -> ActualWrapper

    public override val reconstruct: (Tuple4<BackingField>) -> ActualWrapper
        get() = { (a, b, c, d) -> reconstructor(a, b, c, d) }

    override val value: Tuple4<BackingField>
        get() = this@Numbery4D

    override val plus: Merge<Tuple4<BackingField>>
        get() = { (a, b, c, d), (p, q, r, s) -> reconstructor(a + p, b + q, c + r, d + s) }

    override val minus: Merge<Tuple4<BackingField>>
        get() = { (a, b, c, d), (p, q, r, s) -> reconstructor(a - p, b - q, c - r, d - s) }

    override val times: Merge<Tuple4<BackingField>>
        get() = { (a, b, c, d), (p, q, r, s) -> reconstructor(a * p, b * q, c * r, d * s) }

    override val divide: Merge<Tuple4<BackingField>>
        get() = { (a, b, c, d), (p, q, r, s) -> reconstructor(a / p, b / q, c / r, d / s) }

    override val remainder: Merge<Tuple4<BackingField>>
        get() = { (a, b, c, d), (p, q, r, s) -> reconstructor(a % p, b % q, c % r, d % s) }

    override val addByNumber: MergeABtoA<Tuple4<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d), n -> reconstructor(a + n, b + n, c + n, d + n) }

    override val subtractByNumber: MergeABtoA<Tuple4<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d), n -> reconstructor(a - n, b - n, c - n, d - n) }

    override val multiplyByNumber: MergeABtoA<Tuple4<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d), n -> reconstructor(a * n, b * n, c * n, d * n) }

    override val divideByNumber: MergeABtoA<Tuple4<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d), n -> reconstructor(a / n, b / n, c / n, d / n) }

    override val remainderByNumber: MergeABtoA<Tuple4<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d), n -> reconstructor(a % n, b % n, c % n, d % n) }
}
