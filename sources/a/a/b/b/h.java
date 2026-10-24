package a.a.b.b;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/h.class */
public final class h<K, V> extends AbstractMap<K, V> implements Serializable {
    private static final Comparator<Comparable> f;
    private final Comparator<? super K> g;
    private final boolean h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    d<K, V> f60a;
    int b;
    int c;
    final d<K, V> d;
    private h<K, V>.a i;
    private h<K, V>.b j;
    static final /* synthetic */ boolean e;
    private static byte[] __aes_key_bMbmAO5H = {(byte) 63, (byte) 91, (byte) 41, (byte) 252, (byte) 152, (byte) 169, (byte) 102, (byte) 201, (byte) 25, (byte) 96, (byte) 122, (byte) 240, (byte) 219, (byte) 114, (byte) 51, (byte) 204, (byte) 129, (byte) 148, (byte) 10, (byte) 94, (byte) 78, (byte) 206, (byte) 127, (byte) 192, (byte) 78, (byte) 248, (byte) 116, (byte) 139, (byte) 102, (byte) 22, (byte) 204, (byte) 174};
    private static byte[] __aes_iv_f7rHr3Kg = {(byte) 135, (byte) 150, (byte) 198, (byte) 128, (byte) 141, (byte) 53, (byte) 110, (byte) 72, (byte) 230, (byte) 202, (byte) 184, (byte) 22, (byte) 180, (byte) 28, (byte) 63, (byte) 105};
    private static String __s_cache_J5GUgJi1_0;
    private static String __s_cache_RzmuhEnC_1;
    private static String __s_cache_FTPfL2tU_2;
    private static String __s_cache_Son3Ng9e_3;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/h$a.class */
    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new c() { // from class: a.a.b.b.h.a.1
                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry<K, V> next() {
                    return b();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && h.this.a((Map.Entry<?, ?>) obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            d<K, V> dVarA;
            if (!(obj instanceof Map.Entry) || (dVarA = h.this.a((Map.Entry<?, ?>) obj)) == null) {
                return false;
            }
            h.this.a((d) dVarA, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/h$b.class */
    final class b extends AbstractSet<K> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new c() { // from class: a.a.b.b.h.b.1
                {
                    h hVar = h.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return b().f;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return h.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return h.this.b(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            h.this.clear();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/h$c.class */
    private abstract class c<T> implements Iterator<T> {
        d<K, V> b;
        d<K, V> c = null;
        int d;

        c() {
            this.b = h.this.d.d;
            this.d = h.this.c;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.b != h.this.d;
        }

        final d<K, V> b() {
            d<K, V> dVar = this.b;
            if (dVar == h.this.d) {
                throw new NoSuchElementException();
            }
            if (h.this.c != this.d) {
                throw new ConcurrentModificationException();
            }
            this.b = dVar.d;
            this.c = dVar;
            return dVar;
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.c == null) {
                throw new IllegalStateException();
            }
            h.this.a((d) this.c, true);
            this.c = null;
            this.d = h.this.c;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/h$d.class */
    static final class d<K, V> implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        d<K, V> f65a;
        d<K, V> b;
        d<K, V> c;
        d<K, V> d;
        d<K, V> e;
        final K f;
        final boolean g;
        V h;
        int i;
        private static byte[] __aes_key_MWF5ZuZJ = {(byte) 93, (byte) 229, (byte) 203, (byte) 33, (byte) 220, (byte) 169, (byte) 66, (byte) 254, (byte) 70, (byte) 99, (byte) 152, (byte) 49, (byte) 112, (byte) 111, (byte) 90, (byte) 157, (byte) 18, (byte) 226, (byte) 252, (byte) 111, (byte) 216, (byte) 238, (byte) 11, (byte) 195, (byte) 243, (byte) 39, (byte) 193, (byte) 0, (byte) 154, (byte) 162, (byte) 0, (byte) 249};
        private static byte[] __aes_iv_W986HqRw = {(byte) 213, (byte) 103, (byte) 77, (byte) 48, (byte) 223, (byte) 109, (byte) 63, (byte) 142, (byte) 73, (byte) 208, (byte) 147, (byte) 181, (byte) 68, (byte) 88, (byte) 53, (byte) 191};
        private static String __s_cache_spbXOVtw_0;
        private static String __s_cache_vbwoDTad_1;

        d(boolean z) {
            this.f = null;
            this.g = z;
            this.e = this;
            this.d = this;
        }

        d(boolean z, d<K, V> dVar, K k, d<K, V> dVar2, d<K, V> dVar3) {
            this.f65a = dVar;
            this.f = k;
            this.g = z;
            this.i = 1;
            this.d = dVar2;
            this.e = dVar3;
            dVar3.d = this;
            dVar2.e = this;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.h;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (v == null && !this.g) {
                throw new NullPointerException("value == null");
            }
            V v2 = this.h;
            this.h = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (this.f != null ? this.f.equals(entry.getKey()) : entry.getKey() == null) {
                if (this.h != null ? this.h.equals(entry.getValue()) : entry.getValue() == null) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return (this.f == null ? 0 : this.f.hashCode()) ^ (this.h == null ? 0 : this.h.hashCode());
        }

        public String toString() {
            return this.f + __getString_vFyytCVB_1() + this.h;
        }

        public d<K, V> a() {
            d<K, V> dVar = this;
            d<K, V> dVar2 = dVar.b;
            while (true) {
                d<K, V> dVar3 = dVar2;
                if (dVar3 == null) {
                    return dVar;
                }
                dVar = dVar3;
                dVar2 = dVar.b;
            }
        }

        public d<K, V> b() {
            d<K, V> dVar = this;
            d<K, V> dVar2 = dVar.c;
            while (true) {
                d<K, V> dVar3 = dVar2;
                if (dVar3 == null) {
                    return dVar;
                }
                dVar = dVar3;
                dVar2 = dVar.c;
            }
        }

        private static String __unused_2008() {
        return "value == null";
    }

        private static String __getString_vFyytCVB_1() {
        return "=";
    }
    }

    public h() {
        this(f, true);
    }

    public h(boolean z) {
        this(f, z);
    }

    public h(Comparator<? super K> comparator, boolean z) {
        this.b = 0;
        this.c = 0;
        this.g = comparator != null ? comparator : f;
        this.h = z;
        this.d = new d<>(z);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            return dVarA.h;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return a(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    @a.a.a.a.a
    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        if (v == null && !this.h) {
            throw new NullPointerException("value == null");
        }
        d<K, V> dVarA = a((Object) k, true);
        V v2 = dVarA.h;
        dVarA.h = v;
        return v2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.f60a = null;
        this.b = 0;
        this.c++;
        d<K, V> dVar = this.d;
        dVar.e = dVar;
        dVar.d = dVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        d<K, V> dVarB = b(obj);
        if (dVarB != null) {
            return dVarB.h;
        }
        return null;
    }

    d<K, V> a(K k, boolean z) {
        d<K, V> dVar;
        Comparator<? super K> comparator = this.g;
        d<K, V> dVar2 = this.f60a;
        int iCompareTo = 0;
        if (dVar2 != null) {
            Comparable comparable = comparator == f ? (Comparable) k : null;
            while (true) {
                iCompareTo = comparable != null ? comparable.compareTo(dVar2.f) : comparator.compare(k, dVar2.f);
                if (iCompareTo == 0) {
                    return dVar2;
                }
                d<K, V> dVar3 = iCompareTo < 0 ? dVar2.b : dVar2.c;
                if (dVar3 == null) {
                    break;
                }
                dVar2 = dVar3;
            }
        }
        if (!z) {
            return null;
        }
        d<K, V> dVar4 = this.d;
        if (dVar2 != null) {
            dVar = new d<>(this.h, dVar2, k, dVar4, dVar4.e);
            if (iCompareTo < 0) {
                dVar2.b = dVar;
            } else {
                dVar2.c = dVar;
            }
            b(dVar2, true);
        } else {
            if (comparator == f && !(k instanceof Comparable)) {
                throw new ClassCastException(k.getClass().getName() + " is not Comparable");
            }
            dVar = new d<>(this.h, dVar2, k, dVar4, dVar4.e);
            this.f60a = dVar;
        }
        this.b++;
        this.c++;
        return dVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    d<K, V> a(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return a(obj, false);
        } catch (ClassCastException e2) {
            return null;
        }
    }

    d<K, V> a(Map.Entry<?, ?> entry) {
        d<K, V> dVarA = a(entry.getKey());
        if (dVarA != null && a(dVarA.h, entry.getValue())) {
            return dVarA;
        }
        return null;
    }

    private static boolean a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    void a(d<K, V> dVar, boolean z) {
        if (z) {
            dVar.e.d = dVar.d;
            dVar.d.e = dVar.e;
        }
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar.f65a;
        if (dVar2 == null || dVar3 == null) {
            if (dVar2 != null) {
                a((d) dVar, (d) dVar2);
                dVar.b = null;
            } else if (dVar3 != null) {
                a((d) dVar, (d) dVar3);
                dVar.c = null;
            } else {
                a((d) dVar, (d) null);
            }
            b(dVar4, false);
            this.b--;
            this.c++;
            return;
        }
        d<K, V> dVarB = dVar2.i > dVar3.i ? dVar2.b() : dVar3.a();
        a((d) dVarB, false);
        int i = 0;
        d<K, V> dVar5 = dVar.b;
        if (dVar5 != null) {
            i = dVar5.i;
            dVarB.b = dVar5;
            dVar5.f65a = dVarB;
            dVar.b = null;
        }
        int i2 = 0;
        d<K, V> dVar6 = dVar.c;
        if (dVar6 != null) {
            i2 = dVar6.i;
            dVarB.c = dVar6;
            dVar6.f65a = dVarB;
            dVar.c = null;
        }
        dVarB.i = Math.max(i, i2) + 1;
        a((d) dVar, (d) dVarB);
    }

    d<K, V> b(Object obj) {
        d<K, V> dVarA = a(obj);
        if (dVarA != null) {
            a((d) dVarA, true);
        }
        return dVarA;
    }

    private void a(d<K, V> dVar, d<K, V> dVar2) {
        d<K, V> dVar3 = dVar.f65a;
        dVar.f65a = null;
        if (dVar2 != null) {
            dVar2.f65a = dVar3;
        }
        if (dVar3 == null) {
            this.f60a = dVar2;
            return;
        }
        if (dVar3.b == dVar) {
            dVar3.b = dVar2;
        } else {
            if (!e && dVar3.c != dVar) {
                throw new AssertionError();
            }
            dVar3.c = dVar2;
        }
    }

    private void b(d<K, V> dVar, boolean z) {
        d<K, V> dVar2 = dVar;
        while (true) {
            d<K, V> dVar3 = dVar2;
            if (dVar3 == null) {
                return;
            }
            d<K, V> dVar4 = dVar3.b;
            d<K, V> dVar5 = dVar3.c;
            int i = dVar4 != null ? dVar4.i : 0;
            int i2 = dVar5 != null ? dVar5.i : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                d<K, V> dVar6 = dVar5.b;
                d<K, V> dVar7 = dVar5.c;
                int i4 = (dVar6 != null ? dVar6.i : 0) - (dVar7 != null ? dVar7.i : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    a((d) dVar3);
                } else {
                    if (!e && i4 != 1) {
                        throw new AssertionError();
                    }
                    b((d) dVar5);
                    a((d) dVar3);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                d<K, V> dVar8 = dVar4.b;
                d<K, V> dVar9 = dVar4.c;
                int i5 = (dVar8 != null ? dVar8.i : 0) - (dVar9 != null ? dVar9.i : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    b((d) dVar3);
                } else {
                    if (!e && i5 != -1) {
                        throw new AssertionError();
                    }
                    a((d) dVar4);
                    b((d) dVar3);
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                dVar3.i = i + 1;
                if (z) {
                    return;
                }
            } else {
                if (!e && i3 != -1 && i3 != 1) {
                    throw new AssertionError();
                }
                dVar3.i = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            }
            dVar2 = dVar3.f65a;
        }
    }

    private void a(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar3.b;
        d<K, V> dVar5 = dVar3.c;
        dVar.c = dVar4;
        if (dVar4 != null) {
            dVar4.f65a = dVar;
        }
        a((d) dVar, (d) dVar3);
        dVar3.b = dVar;
        dVar.f65a = dVar3;
        dVar.i = Math.max(dVar2 != null ? dVar2.i : 0, dVar4 != null ? dVar4.i : 0) + 1;
        dVar3.i = Math.max(dVar.i, dVar5 != null ? dVar5.i : 0) + 1;
    }

    private void b(d<K, V> dVar) {
        d<K, V> dVar2 = dVar.b;
        d<K, V> dVar3 = dVar.c;
        d<K, V> dVar4 = dVar2.b;
        d<K, V> dVar5 = dVar2.c;
        dVar.b = dVar5;
        if (dVar5 != null) {
            dVar5.f65a = dVar;
        }
        a((d) dVar, (d) dVar2);
        dVar2.c = dVar;
        dVar.f65a = dVar2;
        dVar.i = Math.max(dVar3 != null ? dVar3.i : 0, dVar5 != null ? dVar5.i : 0) + 1;
        dVar2.i = Math.max(dVar.i, dVar4 != null ? dVar4.i : 0) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        h<K, V>.a aVar = this.i;
        if (aVar == null) {
            h<K, V>.a aVar2 = new a();
            this.i = aVar2;
            aVar = aVar2;
        }
        return aVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        h<K, V>.b bVar = this.j;
        if (bVar == null) {
            h<K, V>.b bVar2 = new b();
            this.j = bVar2;
            bVar = bVar2;
        }
        return bVar;
    }

    private Object a() {
        return new LinkedHashMap(this);
    }

    private void a(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    static {
        e = !h.class.desiredAssertionStatus();
        f = new Comparator<Comparable>() { // from class: a.a.b.b.h.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Comparable comparable, Comparable comparable2) {
                return comparable.compareTo(comparable2);
            }
        };
    }

    private static String __unused_2009() {
        return "key == null";
    }

    private static String __unused_2010() {
        return "value == null";
    }

    private static String __unused_2011() {
        return " is not Comparable";
    }

    private static String __unused_2012() {
        return "Deserialization is unsupported";
    }
}
