package a.a.b.b;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import java.util.RandomAccess;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/i.class */
public class i<E> extends AbstractList<E> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<E> f66a;
    private static byte[] __aes_key_070tXAiA = {(byte) 230, (byte) 210, (byte) 56, (byte) 191, (byte) 55, (byte) 201, (byte) 81, (byte) 179, (byte) 255, (byte) 53, (byte) 143, (byte) 135, (byte) 238, (byte) 209, (byte) 19, (byte) 223, (byte) 255, (byte) 148, (byte) 197, (byte) 12, (byte) 10, (byte) 117, (byte) 57, (byte) 28, (byte) 9, (byte) 68, (byte) 245, (byte) 86, (byte) 36, (byte) 255, (byte) 178, (byte) 169};
    private static byte[] __aes_iv_J0DRGSxA = {(byte) 235, (byte) 51, (byte) 46, (byte) 30, (byte) 52, (byte) 215, (byte) 55, (byte) 64, (byte) 66, (byte) 142, (byte) 7, (byte) 175, (byte) 176, (byte) 0, (byte) 182, (byte) 92};
    private static String __s_cache_KUQJDsE6_0;

    public i(ArrayList<E> arrayList) {
        this.f66a = (ArrayList) Objects.requireNonNull(arrayList);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        return this.f66a.get(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f66a.size();
    }

    private E a(E e) {
        if (e == null) {
            throw new NullPointerException("Element must be non-null");
        }
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        return this.f66a.set(i, a(e));
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        this.f66a.add(i, a(e));
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        return this.f66a.remove(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f66a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        return this.f66a.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        return this.f66a.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        return this.f66a.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return this.f66a.contains(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        return this.f66a.indexOf(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.f66a.lastIndexOf(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f66a.toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.f66a.toArray(tArr);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return this.f66a.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.f66a.hashCode();
    }

    private static String __unused_1994() {
        return "Element must be non-null";
    }
}
