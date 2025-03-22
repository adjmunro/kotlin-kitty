package nz.adjmunro.kish.operators

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.operators.div.NumberDivisible
import nz.adjmunro.kish.operators.minus.NumberSubtractable
import nz.adjmunro.kish.operators.plus.NumberAddable
import nz.adjmunro.kish.operators.rem.NumberRemainderable
import nz.adjmunro.kish.operators.times.NumberMultipliable

@KishDsl
public interface NumberMathable<ActualWrapper, BackingField> :
        NumberAddable<ActualWrapper, BackingField>,
        NumberSubtractable<ActualWrapper, BackingField>,
        NumberMultipliable<ActualWrapper, BackingField>,
        NumberDivisible<ActualWrapper, BackingField>,
        NumberRemainderable<ActualWrapper, BackingField>
        where
        ActualWrapper : NumberMathable<ActualWrapper, BackingField>