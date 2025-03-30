package nz.adjmunro.kty

public fun <W: Numbery<W, *>> abs(a: W): W = a.unaryPlus()

public fun <W: Numbery<W, *>> max(a: W, b: W): W = if (a > b) a else b
public fun <W: Numbery<W, *>> max(a: W, b: Number): W = max(a, a.reconstruct(a.spec(b)))

public fun <W: Numbery<W, *>> min(a: W, b: W): W = if (a < b) a else b
public fun <W: Numbery<W, *>> min(a: W, b: Number): W = min(a, a.reconstruct(a.spec(b)))

