package a.a.b.b.a;

import a.a.b.A;
import a.a.b.B;
import a.a.b.C;
import a.a.b.z;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/k.class */
public final class k extends B<Object> {
    private final a.a.b.f b;
    private final A c;
    private static String __s_cache_BshC35a5_0;
    private static byte[] __aes_key_HEZ4jUhM = {(byte) 149, (byte) 107, (byte) 206, (byte) 93, (byte) 28, (byte) 8, (byte) 148, (byte) 168, (byte) 90, (byte) 238, (byte) 46, (byte) 55, (byte) 86, (byte) 13, (byte) 28, (byte) 30, (byte) 124, (byte) 34, (byte) 99, (byte) 46, (byte) 46, (byte) 140, (byte) 61, (byte) 215, (byte) 83, (byte) 200, (byte) 104, (byte) 19, (byte) 192, (byte) 129, (byte) 35, (byte) 51};
    private static byte[] __aes_iv_ZQvrGdPm = {(byte) 32, (byte) 155, (byte) 136, (byte) 236, (byte) 20, (byte) 198, (byte) 114, (byte) 12, (byte) 198, (byte) 206, (byte) 129, (byte) 96, (byte) 164, (byte) 208, (byte) 187, (byte) 163};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C f21a = b((A) z.f97a);

    private k(a.a.b.f fVar, A a2) {
        this.b = fVar;
        this.c = a2;
    }

    private static C b(final A a2) {
        return new C() { // from class: a.a.b.b.a.k.1
            @Override // a.a.b.C
            public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
                if (aVar.a() == Object.class) {
                    return new k(fVar, a2);
                }
                return null;
            }
        };
    }

    public static C a(A a2) {
        return a2 == z.f97a ? f21a : b(a2);
    }

    private Object a(a.a.b.d.a aVar, a.a.b.d.c cVar) throws IOException {
        switch (cVar) {
            case f76a:
                aVar.a();
                return new ArrayList();
            case c:
                aVar.c();
                return new a.a.b.b.h();
            default:
                return null;
        }
    }

    private Object b(a.a.b.d.a aVar, a.a.b.d.c cVar) throws IOException {
        switch (cVar) {
            case f:
                return aVar.h();
            case g:
                return this.c.b(aVar);
            case h:
                return Boolean.valueOf(aVar.i());
            case i:
                aVar.j();
                return null;
            default:
                throw new IllegalStateException("Unexpected token: " + cVar);
        }
    }

    @Override // a.a.b.B
    public Object b(a.a.b.d.a aVar) throws IOException {
        a.a.b.d.c cVarF = aVar.f();
        Object objA = a(aVar, cVarF);
        if (objA == null) {
            return b(aVar, cVarF);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.e()) {
                String strG = null;
                if (objA instanceof Map) {
                    strG = aVar.g();
                }
                a.a.b.d.c cVarF2 = aVar.f();
                Object objA2 = a(aVar, cVarF2);
                boolean z = objA2 != null;
                if (objA2 == null) {
                    objA2 = b(aVar, cVarF2);
                }
                if (objA instanceof List) {
                    ((List) objA).add(objA2);
                } else {
                    ((Map) objA).put(strG, objA2);
                }
                if (z) {
                    arrayDeque.addLast(objA);
                    objA = objA2;
                }
            } else {
                if (objA instanceof List) {
                    aVar.b();
                } else {
                    aVar.d();
                }
                if (arrayDeque.isEmpty()) {
                    return objA;
                }
                objA = arrayDeque.removeLast();
            }
        }
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.f();
            return;
        }
        B bA = this.b.a((Class) obj.getClass());
        if (!(bA instanceof k)) {
            bA.a(dVar, obj);
        } else {
            dVar.d();
            dVar.e();
        }
    }

    private static String __unused_2112() {
        return "Unexpected token: ";
    }
}
