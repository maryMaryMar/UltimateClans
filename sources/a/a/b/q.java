package a.a.b;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/q.class */
public final class q {
    private static byte[] __aes_key_qxiF6dm7 = {(byte) 240, (byte) 19, (byte) 117, (byte) 255, (byte) 85, (byte) 39, (byte) 80, (byte) 53, (byte) 135, (byte) 74, (byte) 254, (byte) 246, (byte) 246, (byte) 47, (byte) 169, (byte) 72, (byte) 138, (byte) 113, (byte) 13, (byte) 28, (byte) 107, (byte) 45, (byte) 248, (byte) 52, (byte) 249, (byte) 20, (byte) 67, (byte) 17, (byte) 52, (byte) 181, (byte) 88, (byte) 119};
    private static byte[] __aes_iv_CAW8Bspi = {(byte) 140, (byte) 101, (byte) 48, (byte) 192, (byte) 182, (byte) 16, (byte) 105, (byte) 252, (byte) 235, (byte) 131, (byte) 12, (byte) 141, (byte) 225, (byte) 136, (byte) 118, (byte) 31};
    private static String __s_cache_qHI3GtWa_0;
    private static String __s_cache_8euKu6vP_1;
    private static String __s_cache_P6hBwEFh_2;

    @Deprecated
    public q() {
    }

    public static l a(String str) {
        return a(new StringReader(str));
    }

    public static l a(Reader reader) {
        try {
            a.a.b.d.a aVar = new a.a.b.d.a(reader);
            l lVarA = a(aVar);
            if (lVarA.u() || aVar.f() == a.a.b.d.c.j) {
                return lVarA;
            }
            throw new v("Did not consume the entire document.");
        } catch (a.a.b.d.e | NumberFormatException e) {
            throw new v(e);
        } catch (IOException e2) {
            throw new m(e2);
        }
    }

    public static l a(a.a.b.d.a aVar) {
        y yVarT = aVar.t();
        if (yVarT == y.b) {
            aVar.a(y.f96a);
        }
        try {
            try {
                l lVarA = a.a.b.b.o.a(aVar);
                aVar.a(yVarT);
                return lVarA;
            } catch (OutOfMemoryError | StackOverflowError e) {
                throw new p("Failed parsing JSON source: " + aVar + " to Json", e);
            }
        } catch (Throwable th) {
            aVar.a(yVarT);
            throw th;
        }
    }

    @Deprecated
    @a.a.a.a.m(a = "JsonParser.parseString(json)", b = {"com.google.gson.JsonParser"})
    public l b(String str) {
        return a(str);
    }

    @Deprecated
    @a.a.a.a.m(a = "JsonParser.parseReader(json)", b = {"com.google.gson.JsonParser"})
    public l b(Reader reader) {
        return a(reader);
    }

    @Deprecated
    @a.a.a.a.m(a = "JsonParser.parseReader(json)", b = {"com.google.gson.JsonParser"})
    public l b(a.a.b.d.a aVar) {
        return a(aVar);
    }

    private static String __unused_1858() {
        return "Did not consume the entire document.";
    }

    private static String __unused_1859() {
        return "Failed parsing JSON source: ";
    }

    private static String __unused_1860() {
        return " to Json";
    }
}
