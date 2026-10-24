package a.a.b.b.c;

import a.a.b.B;
import a.a.b.C;
import a.a.b.f;
import a.a.b.v;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/c/a.class */
final class a extends B<Date> {
    private final DateFormat b;
    private static String __s_cache_YdHrC6cy_0;
    private static String __s_cache_74W8PHbr_1;
    private static String __s_cache_9hkxRsyt_2;
    private static byte[] __aes_key_C3zX8Q4L = {(byte) 25, (byte) 208, (byte) 231, (byte) 145, (byte) 131, (byte) 145, (byte) 36, (byte) 135, (byte) 239, (byte) 72, (byte) 164, (byte) 96, (byte) 53, (byte) 77, (byte) 5, (byte) 43, (byte) 230, (byte) 26, (byte) 220, (byte) 37, (byte) 230, (byte) 130, (byte) 53, (byte) 27, (byte) 162, (byte) 97, (byte) 3, (byte) 38, (byte) 227, (byte) 132, (byte) 187, (byte) 157};
    private static byte[] __aes_iv_SqRtwBrX = {(byte) 189, (byte) 240, (byte) 32, (byte) 3, (byte) 193, (byte) 237, (byte) 170, (byte) 130, (byte) 239, (byte) 243, (byte) 126, (byte) 193, (byte) 230, (byte) 118, (byte) 133, (byte) 49};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C f49a = new C() { // from class: a.a.b.b.c.a.1
        @Override // a.a.b.C
        public <T> B<T> a(f fVar, a.a.b.c.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new a();
            }
            return null;
        }
    };

    private a() {
        this.b = new SimpleDateFormat("MMM d, yyyy");
    }

    @Override // a.a.b.B
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Date b(a.a.b.d.a aVar) throws IOException {
        Date date;
        if (aVar.f() == a.a.b.d.c.i) {
            aVar.j();
            return null;
        }
        String strH = aVar.h();
        synchronized (this) {
            TimeZone timeZone = this.b.getTimeZone();
            try {
                try {
                    date = new Date(this.b.parse(strH).getTime());
                    this.b.setTimeZone(timeZone);
                } catch (Throwable th) {
                    this.b.setTimeZone(timeZone);
                    throw th;
                }
            } catch (ParseException e) {
                throw new v("Failed parsing '" + strH + "' as SQL Date; at path " + aVar.r(), e);
            }
        }
        return date;
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.f();
            return;
        }
        synchronized (this) {
            str = this.b.format((java.util.Date) date);
        }
        dVar.b(str);
    }

    private static String __unused_2177() {
        return "MMM d, yyyy";
    }

    private static String __unused_2178() {
        return "Failed parsing '";
    }

    private static String __unused_2179() {
        return "' as SQL Date; at path ";
    }
}
