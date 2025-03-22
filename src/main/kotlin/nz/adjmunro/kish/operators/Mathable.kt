package nz.adjmunro.kish.operators

import nz.adjmunro.kish.KishDsl
import nz.adjmunro.kish.operators.div.Divisible
import nz.adjmunro.kish.operators.minus.Subtractable
import nz.adjmunro.kish.operators.plus.Addable
import nz.adjmunro.kish.operators.rem.Remainderable
import nz.adjmunro.kish.operators.times.Multipliable

@KishDsl
public interface Mathable<ActualWrapper, BackingField> :
    Addable<ActualWrapper, BackingField>,
    Subtractable<ActualWrapper, BackingField>,
    Multipliable<ActualWrapper, BackingField>,
    Divisible<ActualWrapper, BackingField>,
    Remainderable<ActualWrapper, BackingField>
        where
    ActualWrapper : Mathable<ActualWrapper, BackingField>