package nz.adjmunro.kty.functions.operators.specify

import nz.adjmunro.kty.functions.KtyDsl

@KtyDsl
public interface NumberSpecifiable<T : Number> {
    @KtyDsl
    public val spec: (Number) -> T
}
