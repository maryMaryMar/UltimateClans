package me.ulrich.clans.library.enumconfig.library.util;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/util/Tuple.class */
public final class Tuple<T, K> {
    private final T _1;
    private final K _2;

    public Tuple(T t, K k) {
        this._1 = t;
        this._2 = k;
    }

    public K _2() {
        return this._2;
    }

    public T _1() {
        return this._1;
    }
}
