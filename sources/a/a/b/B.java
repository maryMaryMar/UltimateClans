package a.a.b;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/B.class */
public abstract class B<T> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/B$a.class */
    private final class a extends B<T> {
        private static byte[] __aes_key_rHbizVlI = {(byte) 150, (byte) 190, (byte) 152, (byte) 234, (byte) 238, (byte) 178, (byte) 6, (byte) 234, (byte) 141, (byte) 142, (byte) 87, (byte) 34, (byte) 165, (byte) 26, (byte) 50, (byte) 41, (byte) 84, (byte) 201, (byte) 3, (byte) 66, (byte) 195, (byte) 136, (byte) 193, (byte) 204, (byte) 160, (byte) 52, (byte) 36, (byte) 146, (byte) 237, (byte) 157, (byte) 235, (byte) 248};
        private static byte[] __aes_iv_g2tOQTWZ = {(byte) 132, (byte) 121, (byte) 138, (byte) 37, (byte) 249, (byte) 37, (byte) 221, (byte) 174, (byte) 117, (byte) 7, (byte) 36, (byte) 101, (byte) 137, (byte) 181, (byte) 195, (byte) 231};
        private static String __s_cache_eq08YHzT_0;
        private static String __s_cache_MXO8GPJS_1;

        private a() {
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, T t) throws IOException {
            if (t == null) {
                dVar.f();
            } else {
                B.this.a(dVar, t);
            }
        }

        @Override // a.a.b.B
        public T b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() != a.a.b.d.c.i) {
                return (T) B.this.b(aVar);
            }
            aVar.j();
            return null;
        }

        public String toString() {
            return "NullSafeTypeAdapter[" + B.this + __getString_1ygJwZZK_1();
        }

        private static String __unused_1844() {
        return "NullSafeTypeAdapter[";
    }

        private static String __getString_1ygJwZZK_1() {
        return "]";
    }
    }

    public abstract void a(a.a.b.d.d dVar, T t);

    public final void a(Writer writer, T t) {
        a(new a.a.b.d.d(writer), t);
    }

    public final String a(T t) {
        StringBuilder sb = new StringBuilder();
        try {
            a(a.a.b.b.o.a(sb), t);
            return sb.toString();
        } catch (IOException e) {
            throw new m(e);
        }
    }

    public final l b(T t) {
        try {
            a.a.b.b.a.h hVar = new a.a.b.b.a.h();
            a(hVar, t);
            return hVar.a();
        } catch (IOException e) {
            throw new m(e);
        }
    }

    public abstract T b(a.a.b.d.a aVar);

    public final T a(Reader reader) {
        return b(new a.a.b.d.a(reader));
    }

    public final T a(String str) {
        return a((Reader) new StringReader(str));
    }

    public final T a(l lVar) {
        try {
            return b((a.a.b.d.a) new a.a.b.b.a.g(lVar));
        } catch (IOException e) {
            throw new m(e);
        }
    }

    public final B<T> b() {
        return !(this instanceof a) ? new a() : this;
    }
}
