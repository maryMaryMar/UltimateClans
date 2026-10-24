package me.ulrich.clans.library.nbtapi.wrapper;

import me.ulrich.clans.library.nbtapi.wrapper.NBTProxy;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/ProxyList.class */
public interface ProxyList<T extends NBTProxy> extends Iterable<T> {
    T addCompound();

    int size();

    boolean isEmpty();

    T get(int i);

    void remove(int i);
}
