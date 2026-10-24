package a.a.b.b.c;

import a.a.b.B;
import a.a.b.C;
import a.a.b.f;
import a.a.b.v;
import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/c/b.class */
final class b extends B<Time> {
    private final DateFormat b;
    private static String __s_cache_gz9fWN9C_0;
    private static String __s_cache_0myGWKte_1;
    private static String __s_cache_REGAl970_2;
    private static byte[] __aes_key_G16NwUn2 = {(byte) 219, (byte) 222, (byte) 55, (byte) 176, (byte) 111, (byte) 240, (byte) 76, (byte) 141, (byte) 20, (byte) 40, (byte) 81, (byte) 164, (byte) 235, (byte) 55, (byte) 111, (byte) 110, (byte) 188, (byte) 113, (byte) 236, (byte) 169, (byte) 160, (byte) 113, (byte) 1, (byte) 30, (byte) 125, (byte) 185, (byte) 38, (byte) 252, (byte) 59, (byte) 170, (byte) 114, (byte) 220};
    private static byte[] __aes_iv_yzHkReYG = {(byte) 106, (byte) 100, (byte) 31, (byte) 118, (byte) 234, (byte) 100, (byte) 79, (byte) 132, (byte) 202, (byte) 249, (byte) 26, (byte) 189, (byte) 195, (byte) 152, (byte) 248, (byte) 47};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C f50a = new C() { // from class: a.a.b.b.c.b.1
        @Override // a.a.b.C
        public <T> B<T> a(f fVar, a.a.b.c.a<T> aVar) {
            if (aVar.a() == Time.class) {
                return new b();
            }
            return null;
        }
    };

    private b() {
        this.b = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // a.a.b.B
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Time b(a.a.b.d.a aVar) throws IOException {
        Time time;
        if (aVar.f() == a.a.b.d.c.i) {
            aVar.j();
            return null;
        }
        String strH = aVar.h();
        synchronized (this) {
            TimeZone timeZone = this.b.getTimeZone();
            try {
                try {
                    time = new Time(this.b.parse(strH).getTime());
                    this.b.setTimeZone(timeZone);
                } catch (Throwable th) {
                    this.b.setTimeZone(timeZone);
                    throw th;
                }
            } catch (ParseException e) {
                throw new v("Failed parsing '" + strH + "' as SQL Time; at path " + aVar.r(), e);
            }
        }
        return time;
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, Time time) throws IOException {
        String str;
        if (time == null) {
            dVar.f();
            return;
        }
        synchronized (this) {
            str = this.b.format((Date) time);
        }
        dVar.b(str);
    }

    private static String __unused_2180() {
        return "hh:mm:ss a";
    }

    private static String __unused_2181() {
        return "Failed parsing '";
    }

    private static String __unused_2182() {
        return "' as SQL Time; at path ";
    }
}
