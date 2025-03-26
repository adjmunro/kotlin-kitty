package nz.adjmunro.kty.tuple

import nz.adjmunro.kty.tuple.Tuple.Tuple2d
import nz.adjmunro.kty.tuple.Tuple.Tuple3d
import nz.adjmunro.kty.tuple.Tuple.Tuple4d
import nz.adjmunro.kty.tuple.Tuple.Tuple5d
import nz.adjmunro.kty.tuple.Tuple.Tuple6d
import nz.adjmunro.kty.tuple.Tuple.Tuple7d
import nz.adjmunro.kty.tuple.Tuple.Tuple8d
import nz.adjmunro.kty.tuple.Tuple.Tuple9d

public typealias Tuple2<T> = Tuple2d<T, T>
public typealias Tuple3<T> = Tuple3d<T, T, T>
public typealias Tuple4<T> = Tuple4d<T, T, T, T>
public typealias Tuple5<T> = Tuple5d<T, T, T, T, T>
public typealias Tuple6<T> = Tuple6d<T, T, T, T, T, T>
public typealias Tuple7<T> = Tuple7d<T, T, T, T, T, T, T>
public typealias Tuple8<T> = Tuple8d<T, T, T, T, T, T, T, T>
public typealias Tuple9<T> = Tuple9d<T, T, T, T, T, T, T, T, T>

public fun <A, B> Pair<A, B>.toTuple(): Duple<A, B> = Duple(first, second)
public fun <A, B> Tuple2d<A, B>.toPair(): Pair<A, B> = Pair(component1(), component2())

public fun <A, B, C> Triple<A, B, C>.toTuple(): Truple<A, B, C> = Truple(first, second, third)
public fun <A, B, C> Tuple3d<A, B, C>.toTriple(): Triple<A, B, C> = Triple(component1(), component2(), component3())

public fun <A, B> tupleOf(first: A, second: B): Duple<A, B> = Duple(first, second)
public fun <A, B, C> tupleOf(first: A, second: B, third: C): Truple<A, B, C> = Truple(first, second, third)
public fun <A, B, C, D> tupleOf(first: A, second: B, third: C, fourth: D): Quadruple<A, B, C, D> = Quadruple(first, second, third, fourth)
public fun <A, B, C, D, E> tupleOf(first: A, second: B, third: C, fourth: D, fifth: E): Quintuple<A, B, C, D, E> = Quintuple(first, second, third, fourth, fifth)
public fun <A, B, C, D, E, F> tupleOf(first: A, second: B, third: C, fourth: D, fifth: E, sixth: F): Sextuple<A, B, C, D, E, F> = Sextuple(first, second, third, fourth, fifth, sixth)
public fun <A, B, C, D, E, F, G> tupleOf(first: A, second: B, third: C, fourth: D, fifth: E, sixth: F, seventh: G): Septuple<A, B, C, D, E, F, G> = Septuple(first, second, third, fourth, fifth, sixth, seventh)
public fun <A, B, C, D, E, F, G, H> tupleOf(first: A, second: B, third: C, fourth: D, fifth: E, sixth: F, seventh: G, eighth: H): Octuple<A, B, C, D, E, F, G, H> = Octuple(first, second, third, fourth, fifth, sixth, seventh, eighth)
public fun <A, B, C, D, E, F, G, H, I> tupleOf(first: A, second: B, third: C, fourth: D, fifth: E, sixth: F, seventh: G, eighth: H, ninth: I): Nonuple<A, B, C, D, E, F, G, H, I> = Nonuple(first, second, third, fourth, fifth, sixth, seventh, eighth, ninth)

public fun <T> Tuple2<T>.toList(): List<T> = listOf(component1(), component2())
public fun <T> Tuple2<T>.toSet(): Set<T> = setOf(component1(), component2())
public fun <T> Tuple2<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2())

public fun <T> Tuple3<T>.toList(): List<T> = listOf(component1(), component2(), component3())
public fun <T> Tuple3<T>.toSet(): Set<T> = setOf(component1(), component2(), component3())
public fun <T> Tuple3<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2(), component3())

public fun <T> Tuple4<T>.toList(): List<T> = listOf(component1(), component2(), component3(), component4())
public fun <T> Tuple4<T>.toSet(): Set<T> = setOf(component1(), component2(), component3(), component4())
public fun <T> Tuple4<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2(), component3(), component4())

public fun <T> Tuple5<T>.toList(): List<T> = listOf(component1(), component2(), component3(), component4(), component5())
public fun <T> Tuple5<T>.toSet(): Set<T> = setOf(component1(), component2(), component3(), component4(), component5())
public fun <T> Tuple5<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2(), component3(), component4(), component5())

public fun <T> Tuple6<T>.toList(): List<T> = listOf(component1(), component2(), component3(), component4(), component5(), component6())
public fun <T> Tuple6<T>.toSet(): Set<T> = setOf(component1(), component2(), component3(), component4(), component5(), component6())
public fun <T> Tuple6<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2(), component3(), component4(), component5(), component6())

public fun <T> Tuple7<T>.toList(): List<T> = listOf(component1(), component2(), component3(), component4(), component5(), component6(), component7())
public fun <T> Tuple7<T>.toSet(): Set<T> = setOf(component1(), component2(), component3(), component4(), component5(), component6(), component7())
public fun <T> Tuple7<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2(), component3(), component4(), component5(), component6(), component7())

public fun <T> Tuple8<T>.toList(): List<T> = listOf(component1(), component2(), component3(), component4(), component5(), component6(), component7(), component8())
public fun <T> Tuple8<T>.toSet(): Set<T> = setOf(component1(), component2(), component3(), component4(), component5(), component6(), component7(), component8())
public fun <T> Tuple8<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2(), component3(), component4(), component5(), component6(), component7(), component8())

public fun <T> Tuple9<T>.toList(): List<T> = listOf(component1(), component2(), component3(), component4(), component5(), component6(), component7(), component8(), component9())
public fun <T> Tuple9<T>.toSet(): Set<T> = setOf(component1(), component2(), component3(), component4(), component5(), component6(), component7(), component8(), component9())
public fun <T> Tuple9<T>.toSequence(): Sequence<T> = sequenceOf(component1(), component2(), component3(), component4(), component5(), component6(), component7(), component8(), component9())
