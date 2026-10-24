package a.a.b.b.a;

import a.a.b.r;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/h.class */
public final class h extends a.a.b.d.d {
    private final List<a.a.b.l> c;
    private String d;
    private a.a.b.l e;
    private static String __s_cache_NvviQn0t_0;
    private static String __s_cache_Zbj2LG9o_1;
    private static String __s_cache_0DOrCem4_2;
    private static String __s_cache_6nnwJVI0_3;
    private static String __s_cache_4H1YDvXN_4;
    private static String __s_cache_VhdYo6W3_5;
    private static String __s_cache_XNnjxtA8_6;
    private static String __s_cache_64L8KD8E_7;
    private static String __s_cache_GJR5RrK2_8;
    private static byte[] __aes_key_eiC1zLiP = {(byte) 223, (byte) 44, (byte) 252, (byte) 154, (byte) 154, (byte) 3, (byte) 236, (byte) 70, (byte) 165, (byte) 136, (byte) 124, (byte) 84, (byte) 252, (byte) 72, (byte) 90, (byte) 42, (byte) 187, (byte) 24, (byte) 215, (byte) 205, (byte) 147, (byte) 79, (byte) 187, (byte) 72, (byte) 83, (byte) 64, (byte) 2, (byte) 22, (byte) 218, (byte) 211, (byte) 25, (byte) 222};
    private static byte[] __aes_iv_dWBorvjS = {(byte) 151, (byte) 46, (byte) 28, (byte) 134, (byte) 54, (byte) 126, (byte) 144, (byte) 87, (byte) 208, (byte) 49, (byte) 179, (byte) 1, (byte) 142, (byte) 86, (byte) 62, (byte) 239};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Writer f15a = new Writer() { // from class: a.a.b.b.a.h.1
        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }
    };
    private static final r b = new r("closed");

    public h() {
        super(f15a);
        this.c = new ArrayList();
        this.e = a.a.b.n.f88a;
    }

    public a.a.b.l a() {
        if (this.c.isEmpty()) {
            return this.e;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.c);
    }

    private a.a.b.l l() {
        return this.c.get(this.c.size() - 1);
    }

    private void a(a.a.b.l lVar) {
        if (this.d != null) {
            if (!lVar.u() || k()) {
                ((a.a.b.o) l()).a(this.d, lVar);
            }
            this.d = null;
            return;
        }
        if (this.c.isEmpty()) {
            this.e = lVar;
            return;
        }
        a.a.b.l lVarL = l();
        if (!(lVarL instanceof a.a.b.i)) {
            throw new IllegalStateException();
        }
        ((a.a.b.i) lVarL).a(lVar);
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d b() {
        a.a.b.i iVar = new a.a.b.i();
        a(iVar);
        this.c.add(iVar);
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d c() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(l() instanceof a.a.b.i)) {
            throw new IllegalStateException();
        }
        this.c.remove(this.c.size() - 1);
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d d() {
        a.a.b.o oVar = new a.a.b.o();
        a(oVar);
        this.c.add(oVar);
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d e() {
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException();
        }
        if (!(l() instanceof a.a.b.o)) {
            throw new IllegalStateException();
        }
        this.c.remove(this.c.size() - 1);
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d a(String str) {
        Objects.requireNonNull(str, "name == null");
        if (this.c.isEmpty() || this.d != null) {
            throw new IllegalStateException("Did not expect a name");
        }
        if (!(l() instanceof a.a.b.o)) {
            throw new IllegalStateException("Please begin an object before writing a name.");
        }
        this.d = str;
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d b(String str) {
        if (str == null) {
            return f();
        }
        a(new r(str));
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d a(boolean z) {
        a(new r(Boolean.valueOf(z)));
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d a(Boolean bool) {
        if (bool == null) {
            return f();
        }
        a(new r(bool));
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d a(float f) {
        if (!h() && (Float.isNaN(f) || Float.isInfinite(f))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + f);
        }
        a(new r(Float.valueOf(f)));
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d a(double d) {
        if (!h() && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new IllegalArgumentException("JSON forbids NaN and infinities: " + d);
        }
        a(new r(Double.valueOf(d)));
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d a(long j) {
        a(new r(Long.valueOf(j)));
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d a(Number number) {
        if (number == null) {
            return f();
        }
        if (!h()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new r(number));
        return this;
    }

    @Override // a.a.b.d.d
    @a.a.a.a.a
    public a.a.b.d.d f() {
        a(a.a.b.n.f88a);
        return this;
    }

    @Override // a.a.b.d.d
    public a.a.b.d.d c(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // a.a.b.d.d, java.io.Flushable
    public void flush() {
    }

    @Override // a.a.b.d.d, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.c.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.c.add(b);
    }

    private static String __unused_2076() {
        return "Expected one JSON element but was ";
    }

    private static String __unused_2077() {
        return "name == null";
    }

    private static String __unused_2078() {
        return "Did not expect a name";
    }

    private static String __unused_2079() {
        return "Please begin an object before writing a name.";
    }

    private static String __unused_2080() {
        return "JSON forbids NaN and infinities: ";
    }

    private static String __unused_2081() {
        return "JSON forbids NaN and infinities: ";
    }

    private static String __unused_2082() {
        return "JSON forbids NaN and infinities: ";
    }

    private static String __unused_2083() {
        return "Incomplete document";
    }

    private static String __unused_2084() {
        return "closed";
    }
}
