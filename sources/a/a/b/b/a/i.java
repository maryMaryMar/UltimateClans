package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import a.a.b.r;
import a.a.b.v;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/i.class */
public final class i implements C {
    private final a.a.b.b.a b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final boolean f16a;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/i$a.class */
    private final class a<K, V> extends B<Map<K, V>> {
        private final B<K> b;
        private final B<V> c;
        private final a.a.b.b.k<? extends Map<K, V>> d;
        private static byte[] __aes_key_fWA98tRw = {(byte) 45, (byte) 101, (byte) 255, (byte) 71, (byte) 136, (byte) 173, (byte) 16, (byte) 183, (byte) 254, (byte) 53, (byte) 102, (byte) 248, (byte) 37, (byte) 68, (byte) 15, (byte) 60, (byte) 120, (byte) 66, (byte) 178, (byte) 110, (byte) 28, (byte) 73, (byte) 117, (byte) 109, (byte) 192, (byte) 131, (byte) 9, (byte) 8, (byte) 130, (byte) 245, (byte) 87, (byte) 207};
        private static byte[] __aes_iv_M4pYlWrw = {(byte) 166, (byte) 141, (byte) 0, (byte) 156, (byte) 119, (byte) 19, (byte) 66, (byte) 22, (byte) 32, (byte) 200, (byte) 106, (byte) 27, (byte) 6, (byte) 165, (byte) 79, (byte) 250};
        private static String __s_cache_f9uwVwaD_0;
        private static String __s_cache_nssHRnu8_1;
        private static String __s_cache_2uTGKemd_2;

        a(B<K> b, B<V> b2, a.a.b.b.k<? extends Map<K, V>> kVar) {
            this.b = b;
            this.c = b2;
            this.d = kVar;
        }

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<K, V> b(a.a.b.d.a aVar) throws IOException {
            a.a.b.d.c cVarF = aVar.f();
            if (cVarF == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            Map<K, V> mapConstruct = this.d.construct();
            if (cVarF == a.a.b.d.c.f76a) {
                aVar.a();
                while (aVar.e()) {
                    aVar.a();
                    K kB = this.b.b(aVar);
                    if (mapConstruct.put(kB, this.c.b(aVar)) != null) {
                        throw new v("duplicate key: " + kB);
                    }
                    aVar.b();
                }
                aVar.b();
            } else {
                aVar.c();
                while (aVar.e()) {
                    a.a.b.b.f.f58a.a(aVar);
                    K kB2 = this.b.b(aVar);
                    if (mapConstruct.put(kB2, this.c.b(aVar)) != null) {
                        throw new v(__getString_wPq1bKxL_1() + kB2);
                    }
                }
                aVar.d();
            }
            return mapConstruct;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Map<K, V> map) throws IOException {
            if (map == null) {
                dVar.f();
                return;
            }
            if (!i.this.f16a) {
                dVar.d();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    dVar.a(String.valueOf(entry.getKey()));
                    this.c.a(dVar, entry.getValue());
                }
                dVar.e();
                return;
            }
            boolean z = false;
            ArrayList arrayList = new ArrayList(map.size());
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Map.Entry<K, V> entry2 : map.entrySet()) {
                a.a.b.l lVarB = this.b.b(entry2.getKey());
                arrayList.add(lVarB);
                arrayList2.add(entry2.getValue());
                z |= lVarB.r() || lVarB.s();
            }
            if (!z) {
                dVar.d();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    dVar.a(b((a.a.b.l) arrayList.get(i)));
                    this.c.a(dVar, (V) arrayList2.get(i));
                }
                dVar.e();
                return;
            }
            dVar.b();
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                dVar.b();
                a.a.b.b.o.a((a.a.b.l) arrayList.get(i2), dVar);
                this.c.a(dVar, (V) arrayList2.get(i2));
                dVar.c();
            }
            dVar.c();
        }

        private String b(a.a.b.l lVar) {
            if (!lVar.t()) {
                if (lVar.u()) {
                    return __getString_GezwVxYf_2();
                }
                throw new AssertionError();
            }
            r rVarX = lVar.x();
            if (rVarX.c()) {
                return String.valueOf(rVarX.d());
            }
            if (rVarX.b()) {
                return Boolean.toString(rVarX.o());
            }
            if (rVarX.p()) {
                return rVarX.e();
            }
            throw new AssertionError();
        }

        private static String __unused_2136() {
        return "duplicate key: ";
    }

        private static String __getString_wPq1bKxL_1() {
        return "duplicate key: ";
    }

        private static String __getString_GezwVxYf_2() {
        return "null";
    }
    }

    public i(a.a.b.b.a aVar, boolean z) {
        this.b = aVar;
        this.f16a = z;
    }

    @Override // a.a.b.C
    public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
        Type typeB = aVar.b();
        Class<? super T> clsA = aVar.a();
        if (!Map.class.isAssignableFrom(clsA)) {
            return null;
        }
        Type[] typeArrB = a.a.b.b.d.b(typeB, clsA);
        Type type = typeArrB[0];
        Type type2 = typeArrB[1];
        return new a(new o(fVar, a(fVar, type), type), new o(fVar, fVar.a((a.a.b.c.a) a.a.b.c.a.b(type2)), type2), this.b.a((a.a.b.c.a) aVar, false));
    }

    private B<?> a(a.a.b.f fVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? p.f : fVar.a((a.a.b.c.a) a.a.b.c.a.b(type));
    }
}
