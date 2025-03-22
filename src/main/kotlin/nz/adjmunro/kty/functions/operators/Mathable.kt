package nz.adjmunro.kty.functions.operators

import nz.adjmunro.kty.functions.KtyDsl
import nz.adjmunro.kty.functions.operators.div.Divisible
import nz.adjmunro.kty.functions.operators.minus.Subtractable
import nz.adjmunro.kty.functions.operators.plus.Addable
import nz.adjmunro.kty.functions.operators.rem.Remainderable
import nz.adjmunro.kty.functions.operators.times.Multipliable

@KtyDsl
public interface Mathable<ActualWrapper, BackingField> :
    Addable<ActualWrapper, BackingField>,
    Subtractable<ActualWrapper, BackingField>,
    Multipliable<ActualWrapper, BackingField>,
    Divisible<ActualWrapper, BackingField>,
    Remainderable<ActualWrapper, BackingField>
        where
    ActualWrapper : Mathable<ActualWrapper, BackingField>
