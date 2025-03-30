package nz.adjmunro.kty.functions.operators.cast

import nz.adjmunro.kty.functions.KtyDsl

@KtyDsl
public interface Specifiable<Parent, Child: Parent> {
    @KtyDsl
    public val spec: (Parent) -> Child
}
