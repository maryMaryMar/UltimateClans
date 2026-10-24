package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import a.a.b.s;
import a.a.b.t;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/n.class */
public final class n<T> extends m<T> {
    private final t<T> b;
    private final a.a.b.k<T> c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a.a.b.f f31a;
    private final a.a.b.c.a<T> d;
    private final C e;
    private final n<T>.a f;
    private final boolean g;
    private volatile B<T> h;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/n$a.class */
    private final class a implements a.a.b.j, s {
        private a() {
        }

        @Override // a.a.b.s
        public a.a.b.l a(Object obj) {
            return n.this.f31a.a(obj);
        }

        @Override // a.a.b.s
        public a.a.b.l a(Object obj, Type type) {
            return n.this.f31a.a(obj, type);
        }

        @Override // a.a.b.j
        public <R> R a(a.a.b.l lVar, Type type) {
            return (R) n.this.f31a.a(lVar, type);
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/n$b.class */
    private static final class b implements C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a.a.b.c.a<?> f33a;
        private final boolean b;
        private final Class<?> c;
        private final t<?> d;
        private final a.a.b.k<?> e;
        private static byte[] __aes_key_3Qz929dU = {(byte) 59, (byte) 58, (byte) 227, (byte) 163, (byte) 172, (byte) 13, (byte) 186, (byte) 209, (byte) 101, (byte) 131, (byte) 195, (byte) 34, (byte) 12, (byte) 220, (byte) 150, (byte) 182, (byte) 36, (byte) 252, (byte) 193, (byte) 225, (byte) 98, (byte) 2, (byte) 52, (byte) 19, (byte) 234, (byte) 128, (byte) 181, (byte) 215, (byte) 37, (byte) 87, (byte) 8, (byte) 47};
        private static byte[] __aes_iv_HJAzDws5 = {(byte) 215, (byte) 168, (byte) 58, (byte) 32, (byte) 248, (byte) 205, (byte) 24, (byte) 56, (byte) 114, (byte) 44, (byte) 241, (byte) 128, (byte) 128, (byte) 251, (byte) 145, (byte) 156};
        private static String __s_cache_mF7uBex4_0;
        private static String __s_cache_ZBPbRhVC_1;

        b(Object obj, a.a.b.c.a<?> aVar, boolean z, Class<?> cls) {
            this.d = obj instanceof t ? (t) obj : null;
            this.e = obj instanceof a.a.b.k ? (a.a.b.k) obj : null;
            if (this.d == null && this.e == null) {
                Objects.requireNonNull(obj);
                throw new IllegalArgumentException("Type adapter " + obj.getClass().getName() + __getString_FkPyO4ki_1());
            }
            this.f33a = aVar;
            this.b = z;
            this.c = cls;
        }

        @Override // a.a.b.C
        public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
            boolean zIsAssignableFrom;
            if (this.f33a != null) {
                zIsAssignableFrom = this.f33a.equals(aVar) || (this.b && this.f33a.b() == aVar.a());
            } else {
                zIsAssignableFrom = this.c.isAssignableFrom(aVar.a());
            }
            if (zIsAssignableFrom) {
                return new n(this.d, this.e, fVar, aVar, this);
            }
            return null;
        }

        private static String __unused_2113() {
        return "Type adapter ";
    }

        private static String __getString_FkPyO4ki_1() {
        return " must implement JsonSerializer or JsonDeserializer";
    }
    }

    public n(t<T> tVar, a.a.b.k<T> kVar, a.a.b.f fVar, a.a.b.c.a<T> aVar, C c, boolean z) {
        this.f = new a();
        this.b = tVar;
        this.c = kVar;
        this.f31a = fVar;
        this.d = aVar;
        this.e = c;
        this.g = z;
    }

    public n(t<T> tVar, a.a.b.k<T> kVar, a.a.b.f fVar, a.a.b.c.a<T> aVar, C c) {
        this(tVar, kVar, fVar, aVar, c, true);
    }

    @Override // a.a.b.B
    public T b(a.a.b.d.a aVar) {
        if (this.c == null) {
            return c().b(aVar);
        }
        a.a.b.l lVarA = a.a.b.b.o.a(aVar);
        if (this.g && lVarA.u()) {
            return null;
        }
        return this.c.a(lVarA, this.d.b(), this.f);
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, T t) throws IOException {
        if (this.b == null) {
            c().a(dVar, t);
        } else if (this.g && t == null) {
            dVar.f();
        } else {
            a.a.b.b.o.a(this.b.a(t, this.d.b(), this.f), dVar);
        }
    }

    private B<T> c() {
        B<T> b2 = this.h;
        if (b2 == null) {
            B<T> bA = this.f31a.a(this.e, this.d);
            this.h = bA;
            b2 = bA;
        }
        return b2;
    }

    @Override // a.a.b.b.a.m
    public B<T> a() {
        return this.b != null ? this : c();
    }

    public static C a(a.a.b.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, false, null);
    }

    public static C b(a.a.b.c.a<?> aVar, Object obj) {
        return new b(obj, aVar, aVar.b() == aVar.a(), null);
    }

    public static C a(Class<?> cls, Object obj) {
        return new b(obj, null, false, cls);
    }
}
