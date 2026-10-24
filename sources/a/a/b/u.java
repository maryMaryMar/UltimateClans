package a.a.b;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/u.class */
public final class u implements Iterator<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.a.b.d.a f92a;
    private final Object b;
    private static byte[] __aes_key_uMjHioLg = {(byte) 5, (byte) 137, (byte) 152, (byte) 3, (byte) 69, (byte) 200, (byte) 29, (byte) 95, (byte) 56, (byte) 49, (byte) 64, (byte) 147, (byte) 42, (byte) 51, (byte) 107, (byte) 144, (byte) 30, (byte) 165, (byte) 126, (byte) 142, (byte) 202, (byte) 84, (byte) 169, (byte) 212, (byte) 61, (byte) 68, (byte) 190, (byte) 69, (byte) 53, (byte) 119, (byte) 209, (byte) 114};
    private static byte[] __aes_iv_s0WK1yol = {(byte) 137, (byte) 4, (byte) 77, (byte) 25, (byte) 111, (byte) 1, (byte) 124, (byte) 249, (byte) 240, (byte) 195, (byte) 7, (byte) 254, (byte) 49, (byte) 239, (byte) 182, (byte) 144};
    private static String __s_cache_DqxtuzbG_0;

    public u(String str) {
        this(new StringReader(str));
    }

    public u(Reader reader) {
        this.f92a = new a.a.b.d.a(reader);
        this.f92a.a(y.f96a);
        this.b = new Object();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public l next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return a.a.b.b.o.a(this.f92a);
        } catch (OutOfMemoryError | StackOverflowError e) {
            throw new p("Failed parsing JSON source to Json", e);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        boolean z;
        synchronized (this.b) {
            try {
                try {
                    z = this.f92a.f() != a.a.b.d.c.j;
                } catch (IOException e) {
                    throw new m(e);
                }
            } catch (a.a.b.d.e e2) {
                throw new v(e2);
            }
        }
        return z;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    private static String __unused_1857() {
        return "Failed parsing JSON source to Json";
    }
}
