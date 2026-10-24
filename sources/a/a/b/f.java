package a.a.b;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/f.class */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f80a = false;
    static final boolean d = true;
    static final boolean e = false;
    static final boolean f = false;
    static final boolean g = false;
    static final boolean h = true;
    private static final String H = ")]}'\n";
    private final ThreadLocal<Map<a.a.b.c.a<?>, B<?>>> I;
    private final ConcurrentMap<a.a.b.c.a<?>, B<?>> J;
    private final a.a.b.b.a K;
    private final a.a.b.b.a.e L;
    final List<C> m;
    final a.a.b.b.b n;
    final InterfaceC0011d o;
    final Map<Type, h<?>> p;
    final boolean q;
    final boolean r;
    final boolean s;
    final boolean t;
    final e u;
    final y v;
    final boolean w;
    final boolean x;
    final String y;
    final int z;
    final int A;
    final w B;
    final List<C> C;
    final List<C> D;
    final A E;
    final A F;
    final List<x> G;
    private static String __s_cache_XTUEmpM3_0;
    private static String __s_cache_uXxy0usa_1;
    private static String __s_cache_N5GeeMKQ_2;
    private static String __s_cache_YmsqNfcO_3;
    private static String __s_cache_boaqT7WP_4;
    private static String __s_cache_gBkeJ2Rq_5;
    private static String __s_cache_Uf79B9my_6;
    private static String __s_cache_pxz1KMhG_7;
    private static String __s_cache_kYBxBkmj_8;
    private static String __s_cache_dDbcuLhi_9;
    private static String __s_cache_Mg3G7e5p_10;
    private static String __s_cache_ygaZPXfN_11;
    private static String __s_cache_tdqZUV1A_12;
    private static String __s_cache_Bku5uzgU_13;
    private static String __s_cache_YgnloOP0_14;
    private static String __s_cache_C0tet6b1_15;
    private static String __s_cache_I8NWxlce_16;
    private static String __s_cache_pLTxnQNr_17;
    private static String __s_cache_m69zvFv7_18;
    private static byte[] __aes_key_jK5bMg0E = {(byte) 126, (byte) 182, (byte) 190, (byte) 90, (byte) 56, (byte) 87, (byte) 105, (byte) 236, (byte) 148, (byte) 180, (byte) 54, (byte) 35, (byte) 100, (byte) 82, (byte) 172, (byte) 187, (byte) 66, (byte) 180, (byte) 253, (byte) 82, (byte) 8, (byte) 180, (byte) 19, (byte) 22, (byte) 185, (byte) 216, (byte) 86, (byte) 49, (byte) 137, (byte) 81, (byte) 125, (byte) 43};
    private static byte[] __aes_iv_ZpCsVl9I = {(byte) 220, (byte) 47, (byte) 100, (byte) 194, (byte) 95, (byte) 54, (byte) 244, (byte) 114, (byte) 129, (byte) 144, (byte) 223, (byte) 253, (byte) 172, (byte) 145, (byte) 40, (byte) 166};
    static final y b = null;
    static final e c = e.f79a;
    static final String i = null;
    static final InterfaceC0011d j = EnumC0010c.f72a;
    static final A k = z.f97a;
    static final A l = z.b;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/f$a.class */
    static class a<T> extends a.a.b.b.a.m<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private B<T> f85a = null;
        private static byte[] __aes_key_zvUVOUXh = {(byte) 18, (byte) 105, (byte) 10, (byte) 172, (byte) 154, (byte) 224, (byte) 80, (byte) 245, (byte) 51, (byte) 3, (byte) 171, (byte) 12, (byte) 195, (byte) 11, (byte) 168, (byte) 42, (byte) 170, (byte) 162, (byte) 76, (byte) 18, (byte) 135, (byte) 254, (byte) 83, (byte) 142, (byte) 177, (byte) 48, (byte) 98, (byte) 167, (byte) 170, (byte) 123, (byte) 17, (byte) 175};
        private static byte[] __aes_iv_92Kx9SJt = {(byte) 223, (byte) 133, (byte) 104, (byte) 171, (byte) 145, (byte) 21, (byte) 159, (byte) 137, (byte) 243, (byte) 90, (byte) 92, (byte) 52, (byte) 207, (byte) 105, (byte) 218, (byte) 139};
        private static String __s_cache_O5UbIe84_0;
        private static String __s_cache_w9vH8GCm_1;

        a() {
        }

        public void a(B<T> b) {
            if (this.f85a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f85a = b;
        }

        private B<T> c() {
            B<T> b = this.f85a;
            if (b == null) {
                throw new IllegalStateException(__getString_HY1tRpYT_1());
            }
            return b;
        }

        @Override // a.a.b.b.a.m
        public B<T> a() {
            return c();
        }

        @Override // a.a.b.B
        public T b(a.a.b.d.a aVar) {
            return c().b(aVar);
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, T t) {
            c().a(dVar, t);
        }

        private static String __unused_1861() {
        return "Delegate is already set";
    }

        private static String __getString_HY1tRpYT_1() {
        return "Adapter for type with cyclic dependency has been used before dependency has been resolved";
    }
    }

    public f() {
        this(a.a.b.b.b.f44a, j, Collections.emptyMap(), false, false, false, true, c, b, false, true, w.f93a, i, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), k, l, Collections.emptyList());
    }

    f(a.a.b.b.b bVar, InterfaceC0011d interfaceC0011d, Map<Type, h<?>> map, boolean z, boolean z2, boolean z3, boolean z4, e eVar, y yVar, boolean z5, boolean z6, w wVar, String str, int i2, int i3, List<C> list, List<C> list2, List<C> list3, A a2, A a3, List<x> list4) {
        this.I = new ThreadLocal<>();
        this.J = new ConcurrentHashMap();
        this.n = bVar;
        this.o = interfaceC0011d;
        this.p = map;
        this.K = new a.a.b.b.a(map, z6, list4);
        this.q = z;
        this.r = z2;
        this.s = z3;
        this.t = z4;
        this.u = eVar;
        this.v = yVar;
        this.w = z5;
        this.x = z6;
        this.B = wVar;
        this.y = str;
        this.z = i2;
        this.A = i3;
        this.C = list;
        this.D = list2;
        this.E = a2;
        this.F = a3;
        this.G = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(a.a.b.b.a.p.W);
        arrayList.add(a.a.b.b.a.k.a(a2));
        arrayList.add(bVar);
        arrayList.addAll(list3);
        arrayList.add(a.a.b.b.a.p.C);
        arrayList.add(a.a.b.b.a.p.m);
        arrayList.add(a.a.b.b.a.p.g);
        arrayList.add(a.a.b.b.a.p.i);
        arrayList.add(a.a.b.b.a.p.k);
        B<Number> bA = a(wVar);
        arrayList.add(a.a.b.b.a.p.a(Long.TYPE, Long.class, bA));
        arrayList.add(a.a.b.b.a.p.a(Double.TYPE, Double.class, a(z5)));
        arrayList.add(a.a.b.b.a.p.a(Float.TYPE, Float.class, b(z5)));
        arrayList.add(a.a.b.b.a.j.a(a3));
        arrayList.add(a.a.b.b.a.p.o);
        arrayList.add(a.a.b.b.a.p.q);
        arrayList.add(a.a.b.b.a.p.a(AtomicLong.class, a(bA)));
        arrayList.add(a.a.b.b.a.p.a(AtomicLongArray.class, b(bA)));
        arrayList.add(a.a.b.b.a.p.s);
        arrayList.add(a.a.b.b.a.p.x);
        arrayList.add(a.a.b.b.a.p.E);
        arrayList.add(a.a.b.b.a.p.G);
        arrayList.add(a.a.b.b.a.p.a(BigDecimal.class, a.a.b.b.a.p.z));
        arrayList.add(a.a.b.b.a.p.a(BigInteger.class, a.a.b.b.a.p.A));
        arrayList.add(a.a.b.b.a.p.a(a.a.b.b.g.class, a.a.b.b.a.p.B));
        arrayList.add(a.a.b.b.a.p.I);
        arrayList.add(a.a.b.b.a.p.K);
        arrayList.add(a.a.b.b.a.p.O);
        arrayList.add(a.a.b.b.a.p.Q);
        arrayList.add(a.a.b.b.a.p.U);
        arrayList.add(a.a.b.b.a.p.M);
        arrayList.add(a.a.b.b.a.p.d);
        arrayList.add(a.a.b.b.a.c.f8a);
        arrayList.add(a.a.b.b.a.p.S);
        if (a.a.b.b.c.d.f52a) {
            arrayList.add(a.a.b.b.c.d.e);
            arrayList.add(a.a.b.b.c.d.d);
            arrayList.add(a.a.b.b.c.d.f);
        }
        arrayList.add(a.a.b.b.a.a.f4a);
        arrayList.add(a.a.b.b.a.p.b);
        arrayList.add(new a.a.b.b.a.b(this.K));
        arrayList.add(new a.a.b.b.a.i(this.K, z2));
        this.L = new a.a.b.b.a.e(this.K);
        arrayList.add(this.L);
        arrayList.add(a.a.b.b.a.p.X);
        arrayList.add(new a.a.b.b.a.l(this.K, interfaceC0011d, bVar, this.L, list4));
        this.m = Collections.unmodifiableList(arrayList);
    }

    public g a() {
        return new g(this);
    }

    @Deprecated
    public a.a.b.b.b b() {
        return this.n;
    }

    public InterfaceC0011d c() {
        return this.o;
    }

    public boolean d() {
        return this.q;
    }

    public boolean e() {
        return this.t;
    }

    private B<Number> a(boolean z) {
        return z ? a.a.b.b.a.p.v : new B<Number>() { // from class: a.a.b.f.1
            @Override // a.a.b.B
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Double b(a.a.b.d.a aVar) throws IOException {
                if (aVar.f() != a.a.b.d.c.i) {
                    return Double.valueOf(aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // a.a.b.B
            public void a(a.a.b.d.d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.f();
                    return;
                }
                double dDoubleValue = number.doubleValue();
                f.a(dDoubleValue);
                dVar.a(dDoubleValue);
            }
        };
    }

    private B<Number> b(boolean z) {
        return z ? a.a.b.b.a.p.u : new B<Number>() { // from class: a.a.b.f.2
            @Override // a.a.b.B
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float b(a.a.b.d.a aVar) throws IOException {
                if (aVar.f() != a.a.b.d.c.i) {
                    return Float.valueOf((float) aVar.k());
                }
                aVar.j();
                return null;
            }

            @Override // a.a.b.B
            public void a(a.a.b.d.d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.f();
                    return;
                }
                float fFloatValue = number.floatValue();
                f.a(fFloatValue);
                dVar.a(number instanceof Float ? number : Float.valueOf(fFloatValue));
            }
        };
    }

    static void a(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private static B<Number> a(w wVar) {
        return wVar == w.f93a ? a.a.b.b.a.p.t : new B<Number>() { // from class: a.a.b.f.3
            @Override // a.a.b.B
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Number b(a.a.b.d.a aVar) throws IOException {
                if (aVar.f() != a.a.b.d.c.i) {
                    return Long.valueOf(aVar.l());
                }
                aVar.j();
                return null;
            }

            @Override // a.a.b.B
            public void a(a.a.b.d.d dVar, Number number) throws IOException {
                if (number == null) {
                    dVar.f();
                } else {
                    dVar.b(number.toString());
                }
            }
        };
    }

    private static B<AtomicLong> a(final B<Number> b2) {
        return new B<AtomicLong>() { // from class: a.a.b.f.4
            @Override // a.a.b.B
            public void a(a.a.b.d.d dVar, AtomicLong atomicLong) {
                b2.a(dVar, Long.valueOf(atomicLong.get()));
            }

            @Override // a.a.b.B
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLong b(a.a.b.d.a aVar) {
                return new AtomicLong(((Number) b2.b(aVar)).longValue());
            }
        }.b();
    }

    private static B<AtomicLongArray> b(final B<Number> b2) {
        return new B<AtomicLongArray>() { // from class: a.a.b.f.5
            @Override // a.a.b.B
            public void a(a.a.b.d.d dVar, AtomicLongArray atomicLongArray) throws IOException {
                dVar.b();
                int length = atomicLongArray.length();
                for (int i2 = 0; i2 < length; i2++) {
                    b2.a(dVar, Long.valueOf(atomicLongArray.get(i2)));
                }
                dVar.c();
            }

            @Override // a.a.b.B
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray b(a.a.b.d.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.a();
                while (aVar.e()) {
                    arrayList.add(Long.valueOf(((Number) b2.b(aVar)).longValue()));
                }
                aVar.b();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i2 = 0; i2 < size; i2++) {
                    atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
                }
                return atomicLongArray;
            }
        }.b();
    }

    public <T> B<T> a(a.a.b.c.a<T> aVar) {
        Objects.requireNonNull(aVar, "type must not be null");
        B<T> b2 = (B) this.J.get(aVar);
        if (b2 != null) {
            return b2;
        }
        Map<a.a.b.c.a<?>, B<?>> map = this.I.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap();
            this.I.set(map);
            z = true;
        } else {
            B<T> b3 = (B) map.get(aVar);
            if (b3 != null) {
                return b3;
            }
        }
        B<?> bA = null;
        try {
            a aVar2 = new a();
            map.put(aVar, aVar2);
            Iterator<C> it = this.m.iterator();
            while (it.hasNext()) {
                bA = it.next().a(this, aVar);
                if (bA != null) {
                    aVar2.a((B) bA);
                    map.put(aVar, bA);
                    break;
                }
            }
            if (z) {
                this.I.remove();
            }
            if (bA == null) {
                throw new IllegalArgumentException("GSON (2.13.2) cannot handle " + aVar);
            }
            if (z) {
                this.J.putAll(map);
            }
            return (B<T>) bA;
        } catch (Throwable th) {
            if (z) {
                this.I.remove();
            }
            throw th;
        }
    }

    public <T> B<T> a(Class<T> cls) {
        return a((a.a.b.c.a) a.a.b.c.a.b((Class) cls));
    }

    public <T> B<T> a(C c2, a.a.b.c.a<T> aVar) {
        Objects.requireNonNull(c2, "skipPast must not be null");
        Objects.requireNonNull(aVar, "type must not be null");
        if (this.L.a((a.a.b.c.a<?>) aVar, c2)) {
            c2 = this.L;
        }
        boolean z = false;
        for (C c3 : this.m) {
            if (z) {
                B<T> bA = c3.a(this, aVar);
                if (bA != null) {
                    return bA;
                }
            } else if (c3 == c2) {
                z = true;
            }
        }
        if (z) {
            throw new IllegalArgumentException("GSON cannot serialize or deserialize " + aVar);
        }
        return a((a.a.b.c.a) aVar);
    }

    public l a(Object obj) {
        return obj == null ? n.f88a : a(obj, obj.getClass());
    }

    public l a(Object obj, Type type) {
        a.a.b.b.a.h hVar = new a.a.b.b.a.h();
        a(obj, type, hVar);
        return hVar.a();
    }

    public String b(Object obj) {
        return obj == null ? a((l) n.f88a) : b(obj, obj.getClass());
    }

    public String b(Object obj, Type type) {
        StringBuilder sb = new StringBuilder();
        a(obj, type, sb);
        return sb.toString();
    }

    public void a(Object obj, Appendable appendable) {
        if (obj != null) {
            a(obj, obj.getClass(), appendable);
        } else {
            a((l) n.f88a, appendable);
        }
    }

    public void a(Object obj, Type type, Appendable appendable) {
        try {
            a(obj, type, a(a.a.b.b.o.a(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public void a(Object obj, Type type, a.a.b.d.d dVar) {
        B bA = a((a.a.b.c.a) a.a.b.c.a.b(type));
        y yVarI = dVar.i();
        if (this.v != null) {
            dVar.a(this.v);
        } else if (dVar.i() == y.b) {
            dVar.a(y.f96a);
        }
        boolean zJ = dVar.j();
        boolean zK = dVar.k();
        dVar.c(this.t);
        dVar.d(this.q);
        try {
            try {
                try {
                    bA.a(dVar, obj);
                    dVar.a(yVarI);
                    dVar.c(zJ);
                    dVar.d(zK);
                } catch (AssertionError e2) {
                    throw new AssertionError("AssertionError (GSON 2.13.2): " + e2.getMessage(), e2);
                }
            } catch (IOException e3) {
                throw new m(e3);
            }
        } catch (Throwable th) {
            dVar.a(yVarI);
            dVar.c(zJ);
            dVar.d(zK);
            throw th;
        }
    }

    public String a(l lVar) {
        StringBuilder sb = new StringBuilder();
        a(lVar, (Appendable) sb);
        return sb.toString();
    }

    public void a(l lVar, Appendable appendable) {
        try {
            a(lVar, a(a.a.b.b.o.a(appendable)));
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public void a(l lVar, a.a.b.d.d dVar) {
        y yVarI = dVar.i();
        boolean zJ = dVar.j();
        boolean zK = dVar.k();
        dVar.c(this.t);
        dVar.d(this.q);
        if (this.v != null) {
            dVar.a(this.v);
        } else if (dVar.i() == y.b) {
            dVar.a(y.f96a);
        }
        try {
            try {
                a.a.b.b.o.a(lVar, dVar);
                dVar.a(yVarI);
                dVar.c(zJ);
                dVar.d(zK);
            } catch (IOException e2) {
                throw new m(e2);
            } catch (AssertionError e3) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e3.getMessage(), e3);
            }
        } catch (Throwable th) {
            dVar.a(yVarI);
            dVar.c(zJ);
            dVar.d(zK);
            throw th;
        }
    }

    public a.a.b.d.d a(Writer writer) throws IOException {
        if (this.s) {
            writer.write(")]}'\n");
        }
        a.a.b.d.d dVar = new a.a.b.d.d(writer);
        dVar.a(this.u);
        dVar.c(this.t);
        dVar.a(this.v == null ? y.b : this.v);
        dVar.d(this.q);
        return dVar;
    }

    public a.a.b.d.a a(Reader reader) {
        a.a.b.d.a aVar = new a.a.b.d.a(reader);
        aVar.a(this.v == null ? y.b : this.v);
        return aVar;
    }

    public <T> T a(String str, Class<T> cls) {
        return (T) a(str, a.a.b.c.a.b((Class) cls));
    }

    public <T> T a(String str, Type type) {
        return (T) a(str, a.a.b.c.a.b(type));
    }

    public <T> T a(String str, a.a.b.c.a<T> aVar) {
        if (str == null) {
            return null;
        }
        return (T) a(new StringReader(str), aVar);
    }

    public <T> T a(Reader reader, Class<T> cls) {
        return (T) a(reader, a.a.b.c.a.b((Class) cls));
    }

    public <T> T a(Reader reader, Type type) {
        return (T) a(reader, a.a.b.c.a.b(type));
    }

    public <T> T a(Reader reader, a.a.b.c.a<T> aVar) {
        a.a.b.d.a aVarA = a(reader);
        T t = (T) a(aVarA, aVar);
        a(t, aVarA);
        return t;
    }

    public <T> T a(a.a.b.d.a aVar, Type type) {
        return (T) a(aVar, a.a.b.c.a.b(type));
    }

    public <T> T a(a.a.b.d.a aVar, a.a.b.c.a<T> aVar2) {
        boolean z = true;
        y yVarT = aVar.t();
        if (this.v != null) {
            aVar.a(this.v);
        } else if (aVar.t() == y.b) {
            aVar.a(y.f96a);
        }
        try {
            try {
                try {
                    aVar.f();
                    z = false;
                    B<T> bA = a((a.a.b.c.a) aVar2);
                    T tB = bA.b(aVar);
                    Class clsA = a.a.b.b.m.a((Class) aVar2.a());
                    if (tB != null && !clsA.isInstance(tB)) {
                        throw new ClassCastException("Type adapter '" + bA + "' returned wrong type; requested " + aVar2.a() + " but got instance of " + tB.getClass() + "\nVerify that the adapter was registered for the correct type.");
                    }
                    aVar.a(yVarT);
                    return tB;
                } catch (AssertionError e2) {
                    throw new AssertionError("AssertionError (GSON 2.13.2): " + e2.getMessage(), e2);
                } catch (IllegalStateException e3) {
                    throw new v(e3);
                }
            } catch (EOFException e4) {
                if (!z) {
                    throw new v(e4);
                }
                aVar.a(yVarT);
                return null;
            } catch (IOException e5) {
                throw new v(e5);
            }
        } catch (Throwable th) {
            aVar.a(yVarT);
            throw th;
        }
    }

    public <T> T a(l lVar, Class<T> cls) {
        return (T) a(lVar, a.a.b.c.a.b((Class) cls));
    }

    public <T> T a(l lVar, Type type) {
        return (T) a(lVar, a.a.b.c.a.b(type));
    }

    public <T> T a(l lVar, a.a.b.c.a<T> aVar) {
        if (lVar == null) {
            return null;
        }
        return (T) a(new a.a.b.b.a.g(lVar), aVar);
    }

    private static void a(Object obj, a.a.b.d.a aVar) {
        if (obj != null) {
            try {
                if (aVar.f() != a.a.b.d.c.j) {
                    throw new v("JSON document was not fully consumed.");
                }
            } catch (a.a.b.d.e e2) {
                throw new v(e2);
            } catch (IOException e3) {
                throw new m(e3);
            }
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.q + ",factories:" + this.m + ",instanceCreators:" + this.K + "}";
    }

    private static String __unused_1862() {
        return " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.";
    }

    private static String __unused_1863() {
        return "type must not be null";
    }

    private static String __unused_1864() {
        return "GSON (2.13.2) cannot handle ";
    }

    private static String __unused_1865() {
        return "skipPast must not be null";
    }

    private static String __unused_1866() {
        return "type must not be null";
    }

    private static String __unused_1867() {
        return "GSON cannot serialize or deserialize ";
    }

    private static String __unused_1868() {
        return "AssertionError (GSON 2.13.2): ";
    }

    private static String __unused_1869() {
        return "AssertionError (GSON 2.13.2): ";
    }

    private static String __unused_1870() {
        return ")]}'\n";
    }

    private static String __unused_1871() {
        return "Type adapter '";
    }

    private static String __unused_1872() {
        return "' returned wrong type; requested ";
    }

    private static String __unused_1873() {
        return " but got instance of ";
    }

    private static String __unused_1874() {
        return "\nVerify that the adapter was registered for the correct type.";
    }

    private static String __unused_1875() {
        return "AssertionError (GSON 2.13.2): ";
    }

    private static String __unused_1876() {
        return "JSON document was not fully consumed.";
    }

    private static String __unused_1877() {
        return "{serializeNulls:";
    }

    private static String __unused_1878() {
        return ",factories:";
    }

    private static String __unused_1879() {
        return ",instanceCreators:";
    }

    private static String __unused_1880() {
        return "}";
    }
}
