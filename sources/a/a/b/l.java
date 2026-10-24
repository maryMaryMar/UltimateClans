package a.a.b;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/l.class */
public abstract class l {
    private static byte[] __aes_key_RCnmScA9 = {(byte) 156, (byte) 255, (byte) 172, (byte) 238, (byte) 72, (byte) 182, (byte) 23, (byte) 120, (byte) 210, (byte) 239, (byte) 252, (byte) 191, (byte) 198, (byte) 237, (byte) 224, (byte) 35, (byte) 139, (byte) 111, (byte) 135, (byte) 193, (byte) 48, (byte) 15, (byte) 193, (byte) 222, (byte) 77, (byte) 159, (byte) 214, (byte) 23, (byte) 11, (byte) 106, (byte) 45, (byte) 98};
    private static byte[] __aes_iv_xNymaFDS = {(byte) 172, (byte) 170, (byte) 7, (byte) 226, (byte) 39, (byte) 226, (byte) 57, (byte) 220, (byte) 179, (byte) 24, (byte) 190, (byte) 38, (byte) 186, (byte) 47, (byte) 28, (byte) 85};
    private static String __s_cache_qflhyavv_0;
    private static String __s_cache_Q08WeJjm_1;
    private static String __s_cache_Z8gbIf03_2;
    private static String __s_cache_sbHn8yFI_3;

    @Deprecated
    public l() {
    }

    public abstract l q();

    public boolean r() {
        return this instanceof i;
    }

    public boolean s() {
        return this instanceof o;
    }

    public boolean t() {
        return this instanceof r;
    }

    public boolean u() {
        return this instanceof n;
    }

    public o v() {
        if (s()) {
            return (o) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public i w() {
        if (r()) {
            return (i) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public r x() {
        if (t()) {
            return (r) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    @a.a.a.a.a
    public n y() {
        if (u()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Null: " + this);
    }

    public boolean o() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double f() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float i() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public long j() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int k() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte l() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    @Deprecated
    public char m() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigDecimal g() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short n() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String toString() {
        try {
            StringBuilder sb = new StringBuilder();
            a.a.b.d.d dVar = new a.a.b.d.d(a.a.b.b.o.a(sb));
            dVar.a(y.f96a);
            a.a.b.b.o.a(this, dVar);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    private static String __unused_1840() {
        return "Not a JSON Object: ";
    }

    private static String __unused_1841() {
        return "Not a JSON Array: ";
    }

    private static String __unused_1842() {
        return "Not a JSON Primitive: ";
    }

    private static String __unused_1843() {
        return "Not a JSON Null: ";
    }
}
