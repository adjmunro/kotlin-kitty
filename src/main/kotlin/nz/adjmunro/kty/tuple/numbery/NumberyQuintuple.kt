package nz.adjmunro.kty.tuple.numbery

import nz.adjmunro.kty.Numbery
import nz.adjmunro.kty.functions.Merge
import nz.adjmunro.kty.functions.MergeABtoA
import nz.adjmunro.kty.functions.operators.Mathable
import nz.adjmunro.kty.functions.operators.NumberMathable
import nz.adjmunro.kty.tuple.Tuple5

public interface NumberyQuintuple<ActualWrapper, BackingField> :
    Mathable<ActualWrapper, Tuple5<BackingField>>,
    NumberMathable<ActualWrapper, Tuple5<BackingField>>,
    Tuple5<BackingField> where
    ActualWrapper : NumberyQuintuple<ActualWrapper, BackingField>,
    BackingField : Numbery<BackingField, *>
{
    public val reconstructor: (BackingField, BackingField, BackingField, BackingField, BackingField) -> ActualWrapper

    public override val reconstruct: (Tuple5<BackingField>) -> ActualWrapper
        get() = { (a, b, c, d, e) -> reconstructor(a, b, c, d, e) }

    override val value: Tuple5<BackingField>
        get() = this@NumberyQuintuple

    override val plus: Merge<Tuple5<BackingField>>
        get() = { (a, b, c, d, e), (p, q, r, s, t) -> reconstructor(a + p, b + q, c + r, d + s, e + t) }

    override val minus: Merge<Tuple5<BackingField>>
        get() = { (a, b, c, d, e), (p, q, r, s, t) -> reconstructor(a - p, b - q, c - r, d - s, e - t) }

    override val times: Merge<Tuple5<BackingField>>
        get() = { (a, b, c, d, e), (p, q, r, s, t) -> reconstructor(a * p, b * q, c * r, d * s, e * t) }

    override val divide: Merge<Tuple5<BackingField>>
        get() = { (a, b, c, d, e), (p, q, r, s, t) -> reconstructor(a / p, b / q, c / r, d / s, e / t) }

    override val remainder: Merge<Tuple5<BackingField>>
        get() = { (a, b, c, d, e), (p, q, r, s, t) -> reconstructor(a % p, b % q, c % r, d % s, e % t) }

    override val addByNumber: MergeABtoA<Tuple5<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d, e), n -> reconstructor(a + n, b + n, c + n, d + n, e + n) }

    override val subtractByNumber: MergeABtoA<Tuple5<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d, e), n -> reconstructor(a - n, b - n, c - n, d - n, e - n) }

    override val multiplyByNumber: MergeABtoA<Tuple5<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d, e), n -> reconstructor(a * n, b * n, c * n, d * n, e * n) }

    override val divideByNumber: MergeABtoA<Tuple5<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d, e), n -> reconstructor(a / n, b / n, c / n, d / n, e / n) }

    override val remainderByNumber: MergeABtoA<Tuple5<BackingField>, Number>
        get() = MergeABtoA { (a, b, c, d, e), n -> reconstructor(a % n, b % n, c % n, d % n, e % n) }
}
