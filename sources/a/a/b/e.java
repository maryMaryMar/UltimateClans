package a.a.b;

import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/e.class */
public class e {
    private final String c;
    private final String d;
    private final boolean e;
    private static String __s_cache_osakrSxb_0;
    private static String __s_cache_wbLIvqrg_1;
    private static String __s_cache_8aBJXiRR_2;
    private static String __s_cache_zZFila8b_3;
    private static String __s_cache_uQ6LsDFc_4;
    private static String __s_cache_7f6SimEt_5;
    private static byte[] __aes_key_lBJHrN2p = {(byte) 192, (byte) 164, (byte) 254, (byte) 22, (byte) 50, (byte) 49, (byte) 136, (byte) 81, (byte) 3, (byte) 208, (byte) 53, (byte) 234, (byte) 216, (byte) 33, (byte) 32, (byte) 184, (byte) 139, (byte) 19, (byte) 163, (byte) 202, (byte) 146, (byte) 29, (byte) 113, (byte) 88, (byte) 190, (byte) 190, (byte) 120, (byte) 210, (byte) 220, (byte) 117, (byte) 247, (byte) 124};
    private static byte[] __aes_iv_4Ktumhoi = {(byte) 226, (byte) 118, (byte) 9, (byte) 64, (byte) 107, (byte) 144, (byte) 85, (byte) 7, (byte) 93, (byte) 9, (byte) 84, (byte) 52, (byte) 189, (byte) 97, (byte) 246, (byte) 198};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f79a = new e("", "", false);
    public static final e b = new e("\n", "  ", true);

    private e(String str, String str2, boolean z) {
        Objects.requireNonNull(str, "newline == null");
        Objects.requireNonNull(str2, "indent == null");
        if (!str.matches("[\r\n]*")) {
            throw new IllegalArgumentException("Only combinations of \\n and \\r are allowed in newline.");
        }
        if (!str2.matches("[ \t]*")) {
            throw new IllegalArgumentException("Only combinations of spaces and tabs are allowed in indent.");
        }
        this.c = str;
        this.d = str2;
        this.e = z;
    }

    public e a(String str) {
        return new e(str, this.d, this.e);
    }

    public e b(String str) {
        return new e(this.c, str, this.e);
    }

    public e a(boolean z) {
        return new e(this.c, this.d, z);
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public boolean c() {
        return this.e;
    }

    private static String __unused_1819() {
        return "newline == null";
    }

    private static String __unused_1820() {
        return "indent == null";
    }

    private static String __unused_1821() {
        return "[\r\n]*";
    }

    private static String __unused_1822() {
        return "Only combinations of \\n and \\r are allowed in newline.";
    }

    private static String __unused_1823() {
        return "[ \t]*";
    }

    private static String __unused_1824() {
        return "Only combinations of spaces and tabs are allowed in indent.";
    }
}
