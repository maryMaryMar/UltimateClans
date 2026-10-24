package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import a.a.b.t;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/e.class */
public final class e implements C {
    private final a.a.b.b.a c;
    private final ConcurrentMap<Class<?>, C> d = new ConcurrentHashMap();
    private static String __s_cache_AkSiCgMg_0;
    private static String __s_cache_SdNxW94D_1;
    private static String __s_cache_Wuqv0wWW_2;
    private static byte[] __aes_key_Uh65UFMF = {(byte) 18, (byte) 93, (byte) 68, (byte) 163, (byte) 164, (byte) 150, (byte) 134, (byte) 133, (byte) 224, (byte) 85, (byte) 118, (byte) 71, (byte) 221, (byte) 141, (byte) 39, (byte) 194, (byte) 202, (byte) 13, (byte) 87, (byte) 3, (byte) 129, (byte) 162, (byte) 54, (byte) 158, (byte) 234, (byte) 65, (byte) 49, (byte) 95, (byte) 219, (byte) 224, (byte) 232, (byte) 1};
    private static byte[] __aes_iv_FdMCh3s4 = {(byte) 168, (byte) 141, (byte) 185, (byte) 216, (byte) 212, (byte) 21, (byte) 122, (byte) 109, (byte) 58, (byte) 185, (byte) 6, (byte) 132, (byte) 198, (byte) 17, (byte) 66, (byte) 68};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C f11a = new a();
    private static final C b = new a();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/e$a.class */
    private static class a implements C {
        private static byte[] __aes_key_59fyoeMR = {(byte) 104, (byte) 160, (byte) 229, (byte) 193, (byte) 94, (byte) 10, (byte) 160, (byte) 167, (byte) 23, (byte) 42, (byte) 156, (byte) 225, (byte) 91, (byte) 11, (byte) 154, (byte) 182, (byte) 192, (byte) 86, (byte) 211, (byte) 112, (byte) 243, (byte) 72, (byte) 192, (byte) 109, (byte) 72, (byte) 115, (byte) 193, (byte) 36, (byte) 95, (byte) 250, (byte) 146, (byte) 252};
        private static byte[] __aes_iv_Fzy7b2qI = {(byte) 250, (byte) 64, (byte) 84, (byte) 59, (byte) 144, (byte) 86, (byte) 245, (byte) 50, (byte) 197, (byte) 211, (byte) 249, (byte) 183, (byte) 13, (byte) 194, (byte) 177, (byte) 136};
        private static String __s_cache_2OW49x2c_0;

        private a() {
        }

        @Override // a.a.b.C
        public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
            throw new AssertionError("Factory should not be used");
        }

        private static String __unused_2114() {
        return "Factory should not be used";
    }
    }

    public e(a.a.b.b.a aVar) {
        this.c = aVar;
    }

    private static a.a.b.a.b a(Class<?> cls) {
        return (a.a.b.a.b) cls.getAnnotation(a.a.b.a.b.class);
    }

    @Override // a.a.b.C
    public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
        a.a.b.a.b bVarA = a(aVar.a());
        if (bVarA == null) {
            return null;
        }
        return (B<T>) a(this.c, fVar, aVar, bVarA, true);
    }

    private static Object a(a.a.b.b.a aVar, Class<?> cls) {
        return aVar.a(a.a.b.c.a.b((Class) cls), true).construct();
    }

    private C a(Class<?> cls, C c) {
        C cPutIfAbsent = this.d.putIfAbsent(cls, c);
        return cPutIfAbsent != null ? cPutIfAbsent : c;
    }

    B<?> a(a.a.b.b.a aVar, a.a.b.f fVar, a.a.b.c.a<?> aVar2, a.a.b.a.b bVar, boolean z) {
        B<?> nVar;
        Object objA = a(aVar, bVar.a());
        boolean zB = bVar.b();
        if (objA instanceof B) {
            nVar = (B) objA;
        } else if (objA instanceof C) {
            C cA = (C) objA;
            if (z) {
                cA = a(aVar2.a(), cA);
            }
            nVar = cA.a(fVar, aVar2);
        } else {
            if (!(objA instanceof t) && !(objA instanceof a.a.b.k)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + objA.getClass().getName() + " as a @JsonAdapter for " + aVar2.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            nVar = new n(objA instanceof t ? (t) objA : null, objA instanceof a.a.b.k ? (a.a.b.k) objA : null, fVar, aVar2, z ? f11a : b, zB);
            zB = false;
        }
        if (nVar != null && zB) {
            nVar = nVar.b();
        }
        return nVar;
    }

    public boolean a(a.a.b.c.a<?> aVar, C c) {
        Objects.requireNonNull(aVar);
        Objects.requireNonNull(c);
        if (c == f11a) {
            return true;
        }
        Class<? super Object> clsA = aVar.a();
        C c2 = this.d.get(clsA);
        if (c2 != null) {
            return c2 == c;
        }
        a.a.b.a.b bVarA = a(clsA);
        if (bVarA == null) {
            return false;
        }
        Class<?> clsA2 = bVarA.a();
        return C.class.isAssignableFrom(clsA2) && a(clsA, (C) a(this.c, clsA2)) == c;
    }

    private static String __unused_2115() {
        return "Invalid attempt to bind an instance of ";
    }

    private static String __unused_2116() {
        return " as a @JsonAdapter for ";
    }

    private static String __unused_2117() {
        return ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.";
    }
}
