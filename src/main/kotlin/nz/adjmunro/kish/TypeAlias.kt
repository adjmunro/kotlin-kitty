package nz.adjmunro.kish

@KishDsl
internal typealias Merge<Type> = (Type, Type) -> Type
@KishDsl
internal typealias Difference<Type> = (Type, Type) -> Int
@KishDsl
internal typealias Transform<Type> = (Type) -> Type

@KishDsl
public fun interface MergeABtoA<A, B> {
    @KishDsl
    public operator fun invoke(a: A, b: B): A
}

@KishDsl
public fun interface DifferenceAB<A, B> {
    @KishDsl
    public operator fun invoke(a: A, b: B): Int
}