package a.a.b.d;

import a.a.b.y;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import me.ulrich.clans.library.udojava.evalex.Expression;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/d/d.class */
public class d implements Closeable, Flushable {
    private static final String[] c;
    private final Writer d;
    private int[] e = new int[32];
    private int f = 0;
    private a.a.b.e g;
    private String h;
    private String i;
    private boolean j;
    private y k;
    private boolean l;
    private String m;
    private boolean n;
    private static String __s_cache_cvCqniWy_0;
    private static String __s_cache_UaJL713z_1;
    private static String __s_cache_uAJTA6Pk_2;
    private static String __s_cache_vL3psl68_3;
    private static String __s_cache_XPINQpIv_4;
    private static String __s_cache_43B9Ao7K_5;
    private static String __s_cache_yWUDXp2L_6;
    private static String __s_cache_IAKn5YMO_7;
    private static String __s_cache_wM3aZ0Mr_8;
    private static String __s_cache_77lRLchy_9;
    private static String __s_cache_IsvVs1R5_10;
    private static String __s_cache_l6R02Jlc_11;
    private static String __s_cache_AlpPRwal_12;
    private static String __s_cache_yhzB0Imz_13;
    private static String __s_cache_OveO2quO_14;
    private static String __s_cache_vt6mVtio_15;
    private static String __s_cache_zYogzgi6_16;
    private static String __s_cache_4zw9XIfe_17;
    private static String __s_cache_xGjaS1xe_18;
    private static String __s_cache_tQKpql9Z_19;
    private static String __s_cache_dNFNkpYX_20;
    private static String __s_cache_08LsHi29_21;
    private static String __s_cache_9VkHHdav_22;
    private static String __s_cache_hv2KtGet_23;
    private static String __s_cache_3cEZQ06y_24;
    private static String __s_cache_qBE8zzDi_25;
    private static String __s_cache_plgUJ17K_26;
    private static String __s_cache_Prx1tIpz_27;
    private static String __s_cache_TZPakWFF_28;
    private static String __s_cache_aaETtM0s_29;
    private static String __s_cache_cxHkvOaS_30;
    private static String __s_cache_BP2uG9D1_31;
    private static String __s_cache_W15SQLrQ_32;
    private static String __s_cache_UbaCrT8W_33;
    private static String __s_cache_bVotruhT_34;
    private static String __s_cache_aZx8kRuR_35;
    private static String __s_cache_8M7Wq375_36;
    private static String __s_cache_lFpCFbL8_37;
    private static String __s_cache_YjowpKfC_38;
    private static String __s_cache_QE0bKJPA_39;
    private static String __s_cache_tKXyvzeI_40;
    private static String __s_cache_EJBfiBkR_41;
    private static String __s_cache_ehrKSdQ2_42;
    private static String __s_cache_Bc9MWFxy_43;
    private static String __s_cache_aEhfswdp_44;
    private static byte[] __aes_key_bCUzRRAN = {(byte) 93, (byte) 78, (byte) 137, (byte) 90, (byte) 154, (byte) 241, (byte) 207, (byte) 234, (byte) 229, (byte) 173, (byte) 165, (byte) 253, (byte) 162, (byte) 159, (byte) 248, (byte) 80, (byte) 239, (byte) 237, (byte) 99, (byte) 136, (byte) 227, (byte) 15, (byte) 56, (byte) 188, (byte) 76, (byte) 241, (byte) 158, (byte) 174, (byte) 253, (byte) 140, (byte) 118, (byte) 212};
    private static byte[] __aes_iv_8YjH1UjZ = {(byte) 90, (byte) 84, (byte) 244, (byte) 87, (byte) 77, (byte) 36, (byte) 226, (byte) 43, (byte) 252, (byte) 1, (byte) 249, (byte) 60, (byte) 33, (byte) 189, (byte) 236, (byte) 222};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f77a = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");
    private static final String[] b = new String[128];

    public d(Writer writer) {
        a(6);
        this.k = y.b;
        this.n = true;
        this.d = (Writer) Objects.requireNonNull(writer, "out == null");
        a(a.a.b.e.f79a);
    }

    public final void d(String str) {
        if (str.isEmpty()) {
            a(a.a.b.e.f79a);
        } else {
            a(a.a.b.e.b.b(str));
        }
    }

    public final void a(a.a.b.e eVar) {
        this.g = (a.a.b.e) Objects.requireNonNull(eVar);
        this.i = ",";
        if (this.g.c()) {
            this.h = ": ";
            if (this.g.a().isEmpty()) {
                this.i = ", ";
            }
        } else {
            this.h = ":";
        }
        this.j = this.g.a().isEmpty() && this.g.b().isEmpty();
    }

    public final a.a.b.e g() {
        return this.g;
    }

    @Deprecated
    public final void b(boolean z) {
        a(z ? y.f96a : y.b);
    }

    public boolean h() {
        return this.k == y.f96a;
    }

    public final void a(y yVar) {
        this.k = (y) Objects.requireNonNull(yVar);
    }

    public final y i() {
        return this.k;
    }

    public final void c(boolean z) {
        this.l = z;
    }

    public final boolean j() {
        return this.l;
    }

    public final void d(boolean z) {
        this.n = z;
    }

    public final boolean k() {
        return this.n;
    }

    @a.a.a.a.a
    public d b() throws IOException {
        l();
        return a(1, '[');
    }

    @a.a.a.a.a
    public d c() {
        return a(1, 2, ']');
    }

    @a.a.a.a.a
    public d d() throws IOException {
        l();
        return a(3, '{');
    }

    @a.a.a.a.a
    public d e() {
        return a(3, 5, '}');
    }

    @a.a.a.a.a
    private d a(int i, char c2) throws IOException {
        o();
        a(i);
        this.d.write(c2);
        return this;
    }

    @a.a.a.a.a
    private d a(int i, int i2, char c2) throws IOException {
        int iA = a();
        if (iA != i2 && iA != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.m != null) {
            throw new IllegalStateException("Dangling name: " + this.m);
        }
        this.f--;
        if (iA == i2) {
            m();
        }
        this.d.write(c2);
        return this;
    }

    private void a(int i) {
        if (this.f == this.e.length) {
            this.e = Arrays.copyOf(this.e, this.f * 2);
        }
        int[] iArr = this.e;
        int i2 = this.f;
        this.f = i2 + 1;
        iArr[i2] = i;
    }

    private int a() {
        if (this.f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        return this.e[this.f - 1];
    }

    private void b(int i) {
        this.e[this.f - 1] = i;
    }

    @a.a.a.a.a
    public d a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.m != null) {
            throw new IllegalStateException("Already wrote a name, expecting a value.");
        }
        int iA = a();
        if (iA != 3 && iA != 5) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.m = str;
        return this;
    }

    private void l() throws IOException {
        if (this.m != null) {
            n();
            e(this.m);
            this.m = null;
        }
    }

    @a.a.a.a.a
    public d b(String str) throws IOException {
        if (str == null) {
            return f();
        }
        l();
        o();
        e(str);
        return this;
    }

    @a.a.a.a.a
    public d a(boolean z) throws IOException {
        l();
        o();
        this.d.write(z ? "true" : "false");
        return this;
    }

    @a.a.a.a.a
    public d a(Boolean bool) throws IOException {
        if (bool == null) {
            return f();
        }
        l();
        o();
        this.d.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    @a.a.a.a.a
    public d a(float f) throws IOException {
        l();
        if (this.k != y.f96a && (Float.isNaN(f) || Float.isInfinite(f))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + f);
        }
        o();
        this.d.append((CharSequence) Float.toString(f));
        return this;
    }

    @a.a.a.a.a
    public d a(double d) throws IOException {
        l();
        if (this.k != y.f96a && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
        }
        o();
        this.d.append((CharSequence) Double.toString(d));
        return this;
    }

    @a.a.a.a.a
    public d a(long j) throws IOException {
        l();
        o();
        this.d.write(Long.toString(j));
        return this;
    }

    @a.a.a.a.a
    public d a(Number number) throws IOException {
        if (number == null) {
            return f();
        }
        l();
        String string = number.toString();
        Class<?> cls = number.getClass();
        if (!a((Class<? extends Number>) cls)) {
            if (string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN")) {
                if (this.k != y.f96a) {
                    throw new IllegalArgumentException("Numeric values must be finite, but was " + string);
                }
            } else if (cls != Float.class && cls != Double.class && !f77a.matcher(string).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + string);
            }
        }
        o();
        this.d.append((CharSequence) string);
        return this;
    }

    @a.a.a.a.a
    public d f() throws IOException {
        if (this.m != null) {
            if (!this.n) {
                this.m = null;
                return this;
            }
            l();
        }
        o();
        this.d.write("null");
        return this;
    }

    @a.a.a.a.a
    public d c(String str) throws IOException {
        if (str == null) {
            return f();
        }
        l();
        o();
        this.d.append((CharSequence) str);
        return this;
    }

    public void flush() throws IOException {
        if (this.f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.d.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.d.close();
        int i = this.f;
        if (i > 1 || (i == 1 && this.e[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f = 0;
    }

    private static boolean a(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x006d  */
    private void e(String str) throws IOException {
        String str__getString_HqIe7hSf_27;
        String[] strArr = this.l ? c : b;
        this.d.write(34);
        int i = 0;
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str__getString_HqIe7hSf_27 = strArr[cCharAt];
                if (str__getString_HqIe7hSf_27 != null) {
                    if (i < i2) {
                        this.d.write(str, i, i2 - i);
                    }
                    this.d.write(str__getString_HqIe7hSf_27);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str__getString_HqIe7hSf_27 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str__getString_HqIe7hSf_27 = "\\u2029";
                }
                if (i < i2) {
                    this.d.write(str, i, i2 - i);
                }
                this.d.write(str__getString_HqIe7hSf_27);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.d.write(str, i, length - i);
        }
        this.d.write(34);
    }

    private void m() throws IOException {
        if (this.j) {
            return;
        }
        this.d.write(this.g.a());
        int i = this.f;
        for (int i2 = 1; i2 < i; i2++) {
            this.d.write(this.g.b());
        }
    }

    private void n() throws IOException {
        int iA = a();
        if (iA == 5) {
            this.d.write(this.i);
        } else if (iA != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m();
        b(4);
    }

    private void o() throws IOException {
        switch (a()) {
            case 1:
                b(2);
                m();
                return;
            case 2:
                this.d.append((CharSequence) this.i);
                m();
                return;
            case 3:
            case 5:
            default:
                throw new IllegalStateException("Nesting problem.");
            case 4:
                this.d.append((CharSequence) this.h);
                b(5);
                return;
            case 6:
                break;
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
                if (this.k != y.f96a) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
                break;
        }
        b(7);
    }

    static {
        for (int i = 0; i <= 31; i++) {
            b[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        b[34] = "\\\"";
        b[92] = "\\\\";
        b[9] = "\\t";
        b[8] = "\\b";
        b[10] = "\\n";
        b[13] = "\\r";
        b[12] = "\\f";
        c = (String[]) b.clone();
        c[60] = "\\u003c";
        c[62] = "\\u003e";
        c[38] = "\\u0026";
        c[61] = "\\u003d";
        c[39] = "\\u0027";
    }

    private static String __unused_1900() {
        return "out == null";
    }

    private static String __unused_1901() {
        return ",";
    }

    private static String __unused_1902() {
        return ": ";
    }

    private static String __unused_1903() {
        return ", ";
    }

    private static String __unused_1904() {
        return ":";
    }

    private static String __unused_1905() {
        return "Nesting problem.";
    }

    private static String __unused_1906() {
        return "Dangling name: ";
    }

    private static String __unused_1907() {
        return "JsonWriter is closed.";
    }

    private static String __unused_1908() {
        return "name == null";
    }

    private static String __unused_1909() {
        return "Already wrote a name, expecting a value.";
    }

    private static String __unused_1910() {
        return "Please begin an object before writing a name.";
    }

    private static String __unused_1911() {
        return "true";
    }

    private static String __unused_1912() {
        return "false";
    }

    private static String __unused_1913() {
        return "true";
    }

    private static String __unused_1914() {
        return "false";
    }

    private static String __unused_1915() {
        return "Numeric values must be finite, but was ";
    }

    private static String __unused_1916() {
        return "Numeric values must be finite, but was ";
    }

    private static String __unused_1917() {
        return "-Infinity";
    }

    private static String __unused_1918() {
        return "Infinity";
    }

    private static String __unused_1919() {
        return "NaN";
    }

    private static String __unused_1920() {
        return "Numeric values must be finite, but was ";
    }

    private static String __unused_1921() {
        return "String created by ";
    }

    private static String __unused_1922() {
        return " is not a valid JSON number: ";
    }

    private static String __unused_1923() {
        return "null";
    }

    private static String __unused_1924() {
        return "JsonWriter is closed.";
    }

    private static String __unused_1925() {
        return "Incomplete document";
    }

    private static String __unused_1926() {
        return "\\u2028";
    }

    private static String __unused_1927() {
        return "\\u2029";
    }

    private static String __unused_1928() {
        return "Nesting problem.";
    }

    private static String __unused_1929() {
        return "JSON must have only one top-level value.";
    }

    private static String __unused_1930() {
        return "Nesting problem.";
    }

    private static String __unused_1931() {
        return "-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?";
    }

    private static String __unused_1932() {
        return "\\u%04x";
    }

    private static String __unused_1933() {
        return "\\\"";
    }

    private static String __unused_1934() {
        return "\\\\";
    }

    private static String __unused_1935() {
        return "\\t";
    }

    private static String __unused_1936() {
        return "\\b";
    }

    private static String __unused_1937() {
        return "\\n";
    }

    private static String __unused_1938() {
        return "\\r";
    }

    private static String __unused_1939() {
        return "\\f";
    }

    private static String __unused_1940() {
        return "\\u003c";
    }

    private static String __unused_1941() {
        return "\\u003e";
    }

    private static String __unused_1942() {
        return "\\u0026";
    }

    private static String __unused_1943() {
        return "\\u003d";
    }

    private static String __unused_1944() {
        return "\\u0027";
    }
}
