package a.a.b.b.a;

import a.a.b.B;
import a.a.b.r;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/f.class */
class f extends B<a.a.b.l> {
    private static String __s_cache_2Suu0ZFM_0;
    private static String __s_cache_esglYWHA_1;
    private static byte[] __aes_key_vQioxEks = {(byte) 228, (byte) 24, (byte) 22, (byte) 53, (byte) 190, (byte) 227, (byte) 47, (byte) 209, (byte) 177, (byte) 210, (byte) 252, (byte) 46, (byte) 151, (byte) 207, (byte) 180, (byte) 12, (byte) 65, (byte) 125, (byte) 164, (byte) 249, (byte) 77, (byte) 228, (byte) 59, (byte) 194, (byte) 97, (byte) 140, (byte) 67, (byte) 54, (byte) 159, (byte) 116, (byte) 143, (byte) 131};
    private static byte[] __aes_iv_gkrT0yi8 = {(byte) 76, (byte) 179, (byte) 172, (byte) 94, (byte) 233, (byte) 115, (byte) 194, (byte) 178, (byte) 206, (byte) 60, (byte) 120, (byte) 7, (byte) 235, (byte) 159, (byte) 226, (byte) 191};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final f f12a = new f();

    private f() {
    }

    private a.a.b.l a(a.a.b.d.a aVar, a.a.b.d.c cVar) throws IOException {
        switch (cVar) {
            case f76a:
                aVar.a();
                return new a.a.b.i();
            case c:
                aVar.c();
                return new a.a.b.o();
            default:
                return null;
        }
    }

    private a.a.b.l b(a.a.b.d.a aVar, a.a.b.d.c cVar) throws IOException {
        switch (cVar) {
            case f:
                return new r(aVar.h());
            case g:
                return new r(new a.a.b.b.g(aVar.h()));
            case h:
                return new r(Boolean.valueOf(aVar.i()));
            case i:
                aVar.j();
                return a.a.b.n.f88a;
            default:
                throw new IllegalStateException("Unexpected token: " + cVar);
        }
    }

    @Override // a.a.b.B
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a.a.b.l b(a.a.b.d.a aVar) throws IOException {
        if (aVar instanceof g) {
            return ((g) aVar).n();
        }
        a.a.b.d.c cVarF = aVar.f();
        a.a.b.l lVarA = a(aVar, cVarF);
        if (lVarA == null) {
            return b(aVar, cVarF);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.e()) {
                String strG = null;
                if (lVarA instanceof a.a.b.o) {
                    strG = aVar.g();
                }
                a.a.b.d.c cVarF2 = aVar.f();
                a.a.b.l lVarA2 = a(aVar, cVarF2);
                boolean z = lVarA2 != null;
                if (lVarA2 == null) {
                    lVarA2 = b(aVar, cVarF2);
                }
                if (lVarA instanceof a.a.b.i) {
                    ((a.a.b.i) lVarA).a(lVarA2);
                } else {
                    ((a.a.b.o) lVarA).a(strG, lVarA2);
                }
                if (z) {
                    arrayDeque.addLast(lVarA);
                    lVarA = lVarA2;
                }
            } else {
                if (lVarA instanceof a.a.b.i) {
                    aVar.b();
                } else {
                    aVar.d();
                }
                if (arrayDeque.isEmpty()) {
                    return lVarA;
                }
                lVarA = (a.a.b.l) arrayDeque.removeLast();
            }
        }
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, a.a.b.l lVar) throws IOException {
        if (lVar == null || lVar.u()) {
            dVar.f();
            return;
        }
        if (lVar.t()) {
            r rVarX = lVar.x();
            if (rVarX.c()) {
                dVar.a(rVarX.d());
                return;
            } else if (rVarX.b()) {
                dVar.a(rVarX.o());
                return;
            } else {
                dVar.b(rVarX.e());
                return;
            }
        }
        if (lVar.r()) {
            dVar.b();
            Iterator<a.a.b.l> it = lVar.w().iterator();
            while (it.hasNext()) {
                a(dVar, it.next());
            }
            dVar.c();
            return;
        }
        if (!lVar.s()) {
            throw new IllegalArgumentException("Couldn't write " + lVar.getClass());
        }
        dVar.d();
        for (Map.Entry<String, a.a.b.l> entry : lVar.v().b()) {
            dVar.a(entry.getKey());
            a(dVar, entry.getValue());
        }
        dVar.e();
    }

    private static String __unused_2108() {
        return "Unexpected token: ";
    }

    private static String __unused_2109() {
        return "Couldn't write ";
    }
}
