package nz.adjmunro.kty.functions.operators

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.operators.minus.Decrementable
import nz.adjmunro.kty.functions.operators.minus.Negatable
import nz.adjmunro.kty.functions.operators.plus.Absolutable
import nz.adjmunro.kty.functions.operators.plus.Incrementable

@KtyDsl
public interface UnaryMathable<ActualWrapper, BackingField> :
    Absolutable<ActualWrapper, BackingField>,
    Negatable<ActualWrapper, BackingField>,
    Incrementable<ActualWrapper, BackingField>,
    Decrementable<ActualWrapper, BackingField>
        where
    ActualWrapper : UnaryMathable<ActualWrapper, BackingField>
