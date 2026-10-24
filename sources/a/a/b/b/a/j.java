package a.a.b.b.a;

import a.a.b.A;
import a.a.b.B;
import a.a.b.C;
import a.a.b.v;
import a.a.b.z;
import java.io.IOException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/j.class */
public final class j extends B<Number> {
    private final A b;
    private static String __s_cache_DP20HvlX_0;
    private static String __s_cache_HTC4I4ka_1;
    private static byte[] __aes_key_Bze6Crdd = {(byte) 61, (byte) 28, (byte) 186, (byte) 80, (byte) 74, (byte) 146, (byte) 63, (byte) 42, (byte) 115, (byte) 183, (byte) 226, (byte) 103, (byte) 208, (byte) 15, (byte) 90, (byte) 12, (byte) 83, (byte) 195, (byte) 249, (byte) 37, (byte) 48, (byte) 141, (byte) 107, (byte) 49, (byte) 251, (byte) 12, (byte) 63, (byte) 87, (byte) 4, (byte) 226, (byte) 186, (byte) 223};
    private static byte[] __aes_iv_vyW71HSb = {(byte) 221, (byte) 39, (byte) 240, (byte) 81, (byte) 206, (byte) 26, (byte) 228, (byte) 81, (byte) 166, (byte) 25, (byte) 139, (byte) 126, (byte) 18, (byte) 239, (byte) 206, (byte) 156};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C f18a = b((A) z.b);

    private j(A a2) {
        this.b = a2;
    }

    private static C b(A a2) {
        return new C() { // from class: a.a.b.b.a.j.1
            @Override // a.a.b.C
            public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
                if (aVar.a() == Number.class) {
                    return j.this;
                }
                return null;
            }
        };
    }

    public static C a(A a2) {
        return a2 == z.b ? f18a : b(a2);
    }

    @Override // a.a.b.B
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Number b(a.a.b.d.a aVar) throws IOException {
        a.a.b.d.c cVarF = aVar.f();
        switch (cVarF) {
            case i:
                aVar.j();
                return null;
            case g:
            case f:
                return this.b.b(aVar);
            default:
                throw new v("Expecting number, got: " + cVarF + "; at path " + aVar.q());
        }
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, Number number) throws IOException {
        dVar.a(number);
    }

    private static String __unused_2110() {
        return "Expecting number, got: ";
    }

    private static String __unused_2111() {
        return "; at path ";
    }
}
