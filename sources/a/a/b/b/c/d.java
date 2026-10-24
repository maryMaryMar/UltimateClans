package a.a.b.b.c;

import a.a.b.C;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/c/d.class */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f52a;
    public static final a.a.b.b.a.c.a<? extends Date> b;
    public static final a.a.b.b.a.c.a<? extends Date> c;
    public static final C d;
    public static final C e;
    public static final C f;
    private static byte[] __aes_key_oWL6l5yJ = {(byte) 138, (byte) 247, (byte) 215, (byte) 65, (byte) 69, (byte) 246, (byte) 250, (byte) 192, (byte) 112, (byte) 221, (byte) 227, (byte) 138, (byte) 142, (byte) 223, (byte) 221, (byte) 191, (byte) 198, (byte) 80, (byte) 18, (byte) 19, (byte) 190, (byte) 51, (byte) 17, (byte) 62, (byte) 41, (byte) 124, (byte) 82, (byte) 80, (byte) 155, (byte) 242, (byte) 136, (byte) 65};
    private static byte[] __aes_iv_sFFDdEXe = {(byte) 12, (byte) 21, (byte) 30, (byte) 164, (byte) 10, (byte) 151, (byte) 34, (byte) 24, (byte) 46, (byte) 86, (byte) 120, (byte) 139, (byte) 15, (byte) 185, (byte) 199, (byte) 17};
    private static String __s_cache_kXjwAvTk_0;

    private d() {
    }

    static {
        boolean z;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException e2) {
            z = false;
        }
        f52a = z;
        if (f52a) {
            b = new a.a.b.b.a.c.a<java.sql.Date>(java.sql.Date.class) { // from class: a.a.b.b.c.d.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // a.a.b.b.a.c.a
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public java.sql.Date a(Date date) {
                    return new java.sql.Date(date.getTime());
                }
            };
            c = new a.a.b.b.a.c.a<Timestamp>(Timestamp.class) { // from class: a.a.b.b.c.d.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // a.a.b.b.a.c.a
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public Timestamp a(Date date) {
                    return new Timestamp(date.getTime());
                }
            };
            d = a.f49a;
            e = b.f50a;
            f = c.f51a;
            return;
        }
        b = null;
        c = null;
        d = null;
        e = null;
        f = null;
    }

    private static String __unused_2183() {
        return "java.sql.Date";
    }
}
