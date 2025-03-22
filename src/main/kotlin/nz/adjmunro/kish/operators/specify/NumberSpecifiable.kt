package nz.adjmunro.kish.operators.specify

import nz.adjmunro.kish.KishDsl

@KishDsl
public interface NumberSpecifiable<T : Number> {
    @KishDsl public val spec: (Number) -> T
}