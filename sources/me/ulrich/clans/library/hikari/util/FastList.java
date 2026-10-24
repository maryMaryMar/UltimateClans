package me.ulrich.clans.library.hikari.util;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/FastList.class */
public final class FastList<T> implements Serializable, List<T>, RandomAccess {
    private static final long serialVersionUID = -4598088075242913858L;
    private final Class<?> clazz;
    private T[] elementData;
    private int size;

    public FastList(Class<?> cls) {
        this.elementData = (T[]) ((Object[]) Array.newInstance(cls, 32));
        this.clazz = cls;
    }

    public FastList(Class<?> cls, int i) {
        this.elementData = (T[]) ((Object[]) Array.newInstance(cls, i));
        this.clazz = cls;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t) {
        if (this.size < this.elementData.length) {
            T[] tArr = this.elementData;
            int i = this.size;
            this.size = i + 1;
            tArr[i] = t;
            return true;
        }
        int length = this.elementData.length;
        T[] tArr2 = (T[]) ((Object[]) Array.newInstance(this.clazz, length << 1));
        System.arraycopy(this.elementData, 0, tArr2, 0, length);
        int i2 = this.size;
        this.size = i2 + 1;
        tArr2[i2] = t;
        this.elementData = tArr2;
        return true;
    }

    @Override // java.util.List
    public T get(int i) {
        return this.elementData[i];
    }

    public T removeLast() {
        T[] tArr = this.elementData;
        int i = this.size - 1;
        this.size = i;
        T t = tArr[i];
        this.elementData[this.size] = null;
        return t;
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        for (int i = this.size - 1; i >= 0; i--) {
            if (obj == this.elementData[i]) {
                int i2 = (this.size - i) - 1;
                if (i2 > 0) {
                    System.arraycopy(this.elementData, i + 1, this.elementData, i, i2);
                }
                T[] tArr = this.elementData;
                int i3 = this.size - 1;
                this.size = i3;
                tArr[i3] = null;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elementData[i] = null;
        }
        this.size = 0;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.List
    public T set(int i, T t) {
        T t2 = this.elementData[i];
        this.elementData[i] = t;
        return t2;
    }

    @Override // java.util.List
    public T remove(int i) {
        if (this.size == 0) {
            return null;
        }
        T t = this.elementData[i];
        int i2 = (this.size - i) - 1;
        if (i2 > 0) {
            System.arraycopy(this.elementData, i + 1, this.elementData, i, i2);
        }
        T[] tArr = this.elementData;
        int i3 = this.size - 1;
        this.size = i3;
        tArr[i3] = null;
        return t;
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new Iterator<T>() { // from class: me.ulrich.clans.library.hikari.util.FastList.1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < FastList.this.size;
            }

            @Override // java.util.Iterator
            public T next() {
                if (this.index >= FastList.this.size) {
                    throw new NoSuchElementException("No more elements in FastList");
                }
                T[] tArr = FastList.this.elementData;
                int i = this.index;
                this.index = i + 1;
                return tArr[i];
            }
        };
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void add(int i, T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public List<T> subList(int i, int i2) {
        throw new UnsupportedOperationException();
    }

    public Object clone() {
        throw new UnsupportedOperationException();
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super T> consumer) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Spliterator<T> spliterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super T> predicate) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException();
    }
}
