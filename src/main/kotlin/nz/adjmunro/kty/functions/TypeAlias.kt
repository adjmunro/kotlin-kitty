package nz.adjmunro.kty.functions

@KtyDsl
internal typealias Merge<Type> = (Type, Type) -> Type
@KtyDsl
internal typealias Difference<Type> = (Type, Type) -> Int
@KtyDsl
internal typealias Transform<Type> = (Type) -> Type

@KtyDsl
public fun interface MergeABtoA<A, B> {
    @KtyDsl
    public operator fun invoke(a: A, b: B): A
}

@KtyDsl
public fun interface DifferenceAB<A, B> {
    @KtyDsl
    public operator fun invoke(a: A, b: B): Int
}
