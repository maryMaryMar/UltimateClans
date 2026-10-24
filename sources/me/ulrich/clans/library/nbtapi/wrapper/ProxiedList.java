package me.ulrich.clans.library.nbtapi.wrapper;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import me.ulrich.clans.library.nbtapi.iface.ReadWriteNBTCompoundList;
import me.ulrich.clans.library.nbtapi.wrapper.NBTProxy;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/ProxiedList.class */
class ProxiedList<E extends NBTProxy> implements ProxyList<E> {
    private final ReadWriteNBTCompoundList nbt;
    private final Class<E> proxy;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/nbtapi/wrapper/ProxiedList$Itr.class */
    private class Itr implements Iterator<E> {
        int cursor;
        int lastRet;

        private Itr() {
            this.cursor = 0;
            this.lastRet = -1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != ProxiedList.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            try {
                int i = this.cursor;
                E e = (E) ProxiedList.this.get(i);
                this.lastRet = i;
                this.cursor = i + 1;
                return e;
            } catch (IndexOutOfBoundsException e2) {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.lastRet < 0) {
                throw new IllegalStateException();
            }
            try {
                ProxiedList.this.remove(this.lastRet);
                if (this.lastRet < this.cursor) {
                    this.cursor--;
                }
                this.lastRet = -1;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public ProxiedList(ReadWriteNBTCompoundList readWriteNBTCompoundList, Class<E> cls) {
        this.nbt = readWriteNBTCompoundList;
        this.proxy = cls;
    }

    @Override // me.ulrich.clans.library.nbtapi.wrapper.ProxyList
    public E get(int i) {
        return (E) new ProxyBuilder(this.nbt.get(i), this.proxy).build();
    }

    @Override // me.ulrich.clans.library.nbtapi.wrapper.ProxyList
    public int size() {
        return this.nbt.size();
    }

    @Override // me.ulrich.clans.library.nbtapi.wrapper.ProxyList
    public void remove(int i) {
        this.nbt.remove(i);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override // me.ulrich.clans.library.nbtapi.wrapper.ProxyList
    public E addCompound() {
        return (E) new ProxyBuilder(this.nbt.addCompound(), this.proxy).build();
    }

    @Override // me.ulrich.clans.library.nbtapi.wrapper.ProxyList
    public boolean isEmpty() {
        return this.nbt.isEmpty();
    }
}
