package me.ulrich.clans.library.enumconfig.library.util;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/util/ArrayUtils.class */
public class ArrayUtils {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/util/ArrayUtils$CompositeUnmodifiableArrayList.class */
    private static class CompositeUnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] array1;
        private final E[] array2;

        CompositeUnmodifiableArrayList(E[] eArr, E[] eArr2) {
            this.array1 = eArr;
            this.array2 = eArr2;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            E e;
            if (i < this.array1.length) {
                e = this.array1[i];
            } else {
                if (i - this.array1.length >= this.array2.length) {
                    throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
                }
                e = this.array2[i - this.array1.length];
            }
            return e;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array1.length + this.array2.length;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/enumconfig/library/util/ArrayUtils$UnmodifiableArrayList.class */
    private static class UnmodifiableArrayList<E> extends AbstractList<E> {
        private final E[] array;

        UnmodifiableArrayList(E[] eArr) {
            this.array = eArr;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            if (i >= this.array.length) {
                throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size());
            }
            return this.array[i];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.array.length;
        }
    }

    private ArrayUtils() {
    }

    public static <E> List<E> toUnmodifiableList(E[] eArr) {
        return eArr.length == 0 ? Collections.emptyList() : new UnmodifiableArrayList(eArr);
    }

    public static <E> List<E> toUnmodifiableCompositeList(E[] eArr, E[] eArr2) {
        List<E> unmodifiableList;
        if (eArr.length == 0) {
            unmodifiableList = toUnmodifiableList(eArr2);
        } else {
            unmodifiableList = eArr2.length == 0 ? toUnmodifiableList(eArr) : new CompositeUnmodifiableArrayList(eArr, eArr2);
        }
        return unmodifiableList;
    }
}
