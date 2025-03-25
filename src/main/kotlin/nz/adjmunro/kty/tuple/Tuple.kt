package nz.adjmunro.kty.tuple

public interface Tuple {

    public val size: Int

    public interface Tuple2d<out A, out B> : Tuple {
        override val size: Int get() = 2
        public operator fun component1(): A
        public operator fun component2(): B
    }

    public interface Tuple3d<out A, out B, out C> : Tuple2d<A, B> {
        override val size: Int get() = 3
        public operator fun component3(): C
    }

    public interface Tuple4d<out A, out B, out C, out D> : Tuple3d<A, B, C> {
        override val size: Int get() = 4
        public operator fun component4(): D
    }

    public interface Tuple5d<out A, out B, out C, out D, out E> : Tuple4d<A, B, C, D> {
        override val size: Int get() = 5
        public operator fun component5(): E
    }

    public interface Tuple6d<out A, out B, out C, out D, out E, out F> : Tuple5d<A, B, C, D, E> {
        override val size: Int get() = 6
        public operator fun component6(): F
    }

    public interface Tuple7d<out A, out B, out C, out D, out E, out F, out G> : Tuple6d<A, B, C, D, E, F> {
        override val size: Int get() = 7
        public operator fun component7(): G
    }

    public interface Tuple8d<out A, out B, out C, out D, out E, out F, out G, out H> : Tuple7d<A, B, C, D, E, F, G> {
        override val size: Int get() = 8
        public operator fun component8(): H
    }

    public interface Tuple9d<out A, out B, out C, out D, out E, out F, out G, out H, out I> : Tuple8d<A, B, C, D, E, F, G, H> {
        override val size: Int get() = 9
        public operator fun component9(): I
    }
}
