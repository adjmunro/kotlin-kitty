package nz.adjmunro.kty.functions.operators

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.operators.div.NumberDivisible
import nz.adjmunro.kty.functions.operators.minus.NumberSubtractable
import nz.adjmunro.kty.functions.operators.plus.NumberAddable
import nz.adjmunro.kty.functions.operators.rem.NumberRemainderable
import nz.adjmunro.kty.functions.operators.times.NumberMultipliable

@KtyDsl
public interface NumberMathable<ActualWrapper, BackingField> :
        NumberAddable<ActualWrapper, BackingField>,
        NumberSubtractable<ActualWrapper, BackingField>,
        NumberMultipliable<ActualWrapper, BackingField>,
        NumberDivisible<ActualWrapper, BackingField>,
        NumberRemainderable<ActualWrapper, BackingField>
        where
        ActualWrapper : NumberMathable<ActualWrapper, BackingField>
