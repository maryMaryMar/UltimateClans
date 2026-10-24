package a.a.b.b.a;

import a.a.b.r;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/g.class */
public final class g extends a.a.b.d.a {
    private Object[] f;
    private int g;
    private String[] h;
    private int[] i;
    private static String __s_cache_TNpI1jZo_0;
    private static String __s_cache_gLw8LjQa_1;
    private static String __s_cache_VA88kUrO_2;
    private static String __s_cache_RfkbH5Ej_3;
    private static String __s_cache_zyxPgCCb_4;
    private static String __s_cache_acuShAcV_5;
    private static String __s_cache_zTCijmu4_6;
    private static String __s_cache_gLHDmad1_7;
    private static String __s_cache_f3jDgW4s_8;
    private static String __s_cache_enAfzujb_9;
    private static String __s_cache_CWjsRuPR_10;
    private static String __s_cache_HRVyhxUc_11;
    private static String __s_cache_DJiXEVdz_12;
    private static String __s_cache_j6vCHrPm_13;
    private static String __s_cache_m9TiUfu9_14;
    private static String __s_cache_XkjE3aZC_15;
    private static String __s_cache_TFev73sQ_16;
    private static String __s_cache_hfQW4LM3_17;
    private static byte[] __aes_key_l3vVytcP = {(byte) 235, (byte) 172, (byte) 161, (byte) 70, (byte) 13, (byte) 124, (byte) 68, (byte) 161, (byte) 171, (byte) 13, (byte) 27, (byte) 140, (byte) 165, (byte) 65, (byte) 154, (byte) 2, (byte) 72, (byte) 151, (byte) 154, (byte) 3, (byte) 90, (byte) 242, (byte) 252, (byte) 202, (byte) 70, (byte) 165, (byte) 125, (byte) 71, (byte) 85, (byte) 14, (byte) 185, (byte) 22};
    private static byte[] __aes_iv_HcluRRiJ = {(byte) 164, (byte) 31, (byte) 83, (byte) 250, (byte) 244, (byte) 81, (byte) 4, (byte) 121, (byte) 182, (byte) 87, (byte) 182, (byte) 169, (byte) 13, (byte) 119, (byte) 213, (byte) 141};
    private static final Reader d = new Reader() { // from class: a.a.b.b.a.g.1
        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }
    };
    private static final Object e = new Object();

    public g(a.a.b.l lVar) {
        super(d);
        this.f = new Object[32];
        this.g = 0;
        this.h = new String[32];
        this.i = new int[32];
        a(lVar);
    }

    @Override // a.a.b.d.a
    public void a() {
        a(a.a.b.d.c.f76a);
        a(((a.a.b.i) x()).iterator());
        this.i[this.g - 1] = 0;
    }

    @Override // a.a.b.d.a
    public void b() {
        a(a.a.b.d.c.b);
        y();
        y();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // a.a.b.d.a
    public void c() {
        a(a.a.b.d.c.c);
        a(((a.a.b.o) x()).b().iterator());
    }

    @Override // a.a.b.d.a
    public void d() {
        a(a.a.b.d.c.d);
        this.h[this.g - 1] = null;
        y();
        y();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // a.a.b.d.a
    public boolean e() throws a.a.b.d.e {
        a.a.b.d.c cVarF = f();
        return (cVarF == a.a.b.d.c.d || cVarF == a.a.b.d.c.b || cVarF == a.a.b.d.c.j) ? false : true;
    }

    @Override // a.a.b.d.a
    public a.a.b.d.c f() throws a.a.b.d.e {
        if (this.g == 0) {
            return a.a.b.d.c.j;
        }
        Object objX = x();
        if (objX instanceof Iterator) {
            boolean z = this.f[this.g - 2] instanceof a.a.b.o;
            Iterator it = (Iterator) objX;
            if (!it.hasNext()) {
                return z ? a.a.b.d.c.d : a.a.b.d.c.b;
            }
            if (z) {
                return a.a.b.d.c.e;
            }
            a(it.next());
            return f();
        }
        if (objX instanceof a.a.b.o) {
            return a.a.b.d.c.c;
        }
        if (objX instanceof a.a.b.i) {
            return a.a.b.d.c.f76a;
        }
        if (!(objX instanceof r)) {
            if (objX instanceof a.a.b.n) {
                return a.a.b.d.c.i;
            }
            if (objX == e) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new a.a.b.d.e("Custom JsonElement subclass " + objX.getClass().getName() + " is not supported");
        }
        r rVar = (r) objX;
        if (rVar.p()) {
            return a.a.b.d.c.f;
        }
        if (rVar.b()) {
            return a.a.b.d.c.h;
        }
        if (rVar.c()) {
            return a.a.b.d.c.g;
        }
        throw new AssertionError();
    }

    private Object x() {
        return this.f[this.g - 1];
    }

    @a.a.a.a.a
    private Object y() {
        Object[] objArr = this.f;
        int i = this.g - 1;
        this.g = i;
        Object obj = objArr[i];
        this.f[this.g] = null;
        return obj;
    }

    private void a(a.a.b.d.c cVar) {
        if (f() != cVar) {
            throw new IllegalStateException("Expected " + cVar + " but was " + f() + z());
        }
    }

    private String b(boolean z) {
        a(a.a.b.d.c.e);
        Map.Entry entry = (Map.Entry) ((Iterator) x()).next();
        String str = (String) entry.getKey();
        this.h[this.g - 1] = z ? "<skipped>" : str;
        a(entry.getValue());
        return str;
    }

    @Override // a.a.b.d.a
    public String g() {
        return b(false);
    }

    @Override // a.a.b.d.a
    public String h() throws a.a.b.d.e {
        a.a.b.d.c cVarF = f();
        if (cVarF != a.a.b.d.c.f && cVarF != a.a.b.d.c.g) {
            throw new IllegalStateException("Expected " + a.a.b.d.c.f + " but was " + cVarF + z());
        }
        String strE = ((r) y()).e();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
        return strE;
    }

    @Override // a.a.b.d.a
    public boolean i() {
        a(a.a.b.d.c.h);
        boolean zO = ((r) y()).o();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
        return zO;
    }

    @Override // a.a.b.d.a
    public void j() {
        a(a.a.b.d.c.i);
        y();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
    }

    @Override // a.a.b.d.a
    public double k() throws a.a.b.d.e {
        a.a.b.d.c cVarF = f();
        if (cVarF != a.a.b.d.c.g && cVarF != a.a.b.d.c.f) {
            throw new IllegalStateException("Expected " + a.a.b.d.c.g + " but was " + cVarF + z());
        }
        double dF = ((r) x()).f();
        if (!s() && (Double.isNaN(dF) || Double.isInfinite(dF))) {
            throw new a.a.b.d.e("JSON forbids NaN and infinities: " + dF);
        }
        y();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
        return dF;
    }

    @Override // a.a.b.d.a
    public long l() throws a.a.b.d.e {
        a.a.b.d.c cVarF = f();
        if (cVarF != a.a.b.d.c.g && cVarF != a.a.b.d.c.f) {
            throw new IllegalStateException("Expected " + a.a.b.d.c.g + " but was " + cVarF + z());
        }
        long j = ((r) x()).j();
        y();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
        return j;
    }

    @Override // a.a.b.d.a
    public int m() throws a.a.b.d.e {
        a.a.b.d.c cVarF = f();
        if (cVarF != a.a.b.d.c.g && cVarF != a.a.b.d.c.f) {
            throw new IllegalStateException("Expected " + a.a.b.d.c.g + " but was " + cVarF + z());
        }
        int iK = ((r) x()).k();
        y();
        if (this.g > 0) {
            int[] iArr = this.i;
            int i = this.g - 1;
            iArr[i] = iArr[i] + 1;
        }
        return iK;
    }

    a.a.b.l n() throws a.a.b.d.e {
        a.a.b.d.c cVarF = f();
        if (cVarF == a.a.b.d.c.e || cVarF == a.a.b.d.c.b || cVarF == a.a.b.d.c.d || cVarF == a.a.b.d.c.j) {
            throw new IllegalStateException("Unexpected " + cVarF + " when reading a JsonElement.");
        }
        a.a.b.l lVar = (a.a.b.l) x();
        o();
        return lVar;
    }

    @Override // a.a.b.d.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f = new Object[]{e};
        this.g = 1;
    }

    @Override // a.a.b.d.a
    public void o() throws a.a.b.d.e {
        switch (f()) {
            case e:
                b(true);
                break;
            case b:
                b();
                break;
            case d:
                d();
                break;
            case j:
                break;
            default:
                y();
                if (this.g > 0) {
                    int[] iArr = this.i;
                    int i = this.g - 1;
                    iArr[i] = iArr[i] + 1;
                }
                break;
        }
    }

    @Override // a.a.b.d.a
    public String toString() {
        return getClass().getSimpleName() + z();
    }

    public void p() {
        a(a.a.b.d.c.e);
        Map.Entry entry = (Map.Entry) ((Iterator) x()).next();
        a(entry.getValue());
        a(new r((String) entry.getKey()));
    }

    private void a(Object obj) {
        if (this.g == this.f.length) {
            int i = this.g * 2;
            this.f = Arrays.copyOf(this.f, i);
            this.i = Arrays.copyOf(this.i, i);
            this.h = (String[]) Arrays.copyOf(this.h, i);
        }
        Object[] objArr = this.f;
        int i2 = this.g;
        this.g = i2 + 1;
        objArr[i2] = obj;
    }

    private String c(boolean z) {
        StringBuilder sbAppend = new StringBuilder().append('$');
        int i = 0;
        while (i < this.g) {
            if (this.f[i] instanceof a.a.b.i) {
                i++;
                if (i < this.g && (this.f[i] instanceof Iterator)) {
                    int i2 = this.i[i];
                    if (z && i2 > 0 && (i == this.g - 1 || i == this.g - 2)) {
                        i2--;
                    }
                    sbAppend.append('[').append(i2).append(']');
                }
            } else if (this.f[i] instanceof a.a.b.o) {
                i++;
                if (i < this.g && (this.f[i] instanceof Iterator)) {
                    sbAppend.append('.');
                    if (this.h[i] != null) {
                        sbAppend.append(this.h[i]);
                    }
                }
            }
            i++;
        }
        return sbAppend.toString();
    }

    @Override // a.a.b.d.a
    public String q() {
        return c(false);
    }

    @Override // a.a.b.d.a
    public String r() {
        return c(true);
    }

    private String z() {
        return " at path " + q();
    }

    private static String __unused_2085() {
        return "JsonReader is closed";
    }

    private static String __unused_2086() {
        return "Custom JsonElement subclass ";
    }

    private static String __unused_2087() {
        return " is not supported";
    }

    private static String __unused_2088() {
        return "Expected ";
    }

    private static String __unused_2089() {
        return " but was ";
    }

    private static String __unused_2090() {
        return "<skipped>";
    }

    private static String __unused_2091() {
        return "Expected ";
    }

    private static String __unused_2092() {
        return " but was ";
    }

    private static String __unused_2093() {
        return "Expected ";
    }

    private static String __unused_2094() {
        return " but was ";
    }

    private static String __unused_2095() {
        return "JSON forbids NaN and infinities: ";
    }

    private static String __unused_2096() {
        return "Expected ";
    }

    private static String __unused_2097() {
        return " but was ";
    }

    private static String __unused_2098() {
        return "Expected ";
    }

    private static String __unused_2099() {
        return " but was ";
    }

    private static String __unused_2100() {
        return "Unexpected ";
    }

    private static String __unused_2101() {
        return " when reading a JsonElement.";
    }

    private static String __unused_2102() {
        return " at path ";
    }
}
