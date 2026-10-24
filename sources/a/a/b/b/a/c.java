package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import a.a.b.v;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/c.class */
public final class c<T extends Date> extends B<T> {
    private static final String b = "DefaultDateTypeAdapter";
    private final a<T> c;
    private final List<DateFormat> d;
    private static String __s_cache_fICgmcLP_0;
    private static String __s_cache_Sw3rhf30_1;
    private static String __s_cache_yGbJz5GR_2;
    private static String __s_cache_PXn992G2_3;
    private static byte[] __aes_key_1WZsbNyp = {(byte) 212, (byte) 222, (byte) 206, (byte) 202, (byte) 234, (byte) 161, (byte) 177, (byte) 76, (byte) 75, (byte) 48, (byte) 28, (byte) 19, (byte) 54, (byte) 86, (byte) 243, (byte) 165, (byte) 16, (byte) 51, (byte) 255, (byte) 68, (byte) 107, (byte) 223, (byte) 252, (byte) 232, (byte) 162, (byte) 72, (byte) 96, (byte) 158, (byte) 201, (byte) 75, (byte) 188, (byte) 6};
    private static byte[] __aes_iv_W4TaOhGP = {(byte) 70, (byte) 215, (byte) 16, (byte) 135, (byte) 43, (byte) 110, (byte) 213, (byte) 189, (byte) 140, (byte) 147, (byte) 77, (byte) 80, (byte) 45, (byte) 173, (byte) 50, (byte) 27};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C f8a = new C() { // from class: a.a.b.b.a.c.1
        private static byte[] __aes_key_osxT8Yia = {(byte) 188, (byte) 211, (byte) 33, (byte) 15, (byte) 114, (byte) 66, (byte) 50, (byte) 8, (byte) 79, (byte) 50, (byte) 121, (byte) 30, (byte) 8, (byte) 78, (byte) 218, (byte) 155, (byte) 186, (byte) 247, (byte) 250, (byte) 172, (byte) 111, (byte) 65, (byte) 54, (byte) 189, (byte) 199, (byte) 181, (byte) 204, (byte) 18, (byte) 249, (byte) 171, (byte) 140, (byte) 116};
        private static byte[] __aes_iv_qc1yKz5W = {(byte) 123, (byte) 182, (byte) 119, (byte) 181, (byte) 45, (byte) 166, (byte) 150, (byte) 110, (byte) 61, (byte) 2, (byte) 29, (byte) 204, (byte) 107, (byte) 61, (byte) 254, (byte) 64};
        private static String __s_cache_AOuCYnbB_0;

        @Override // a.a.b.C
        public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
            if (aVar.a() == Date.class) {
                return new c(a.f9a, 2, 2);
            }
            return null;
        }

        public String toString() {
            return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
        }

        private static String __unused_2103() {
        return "DefaultDateTypeAdapter#DEFAULT_STYLE_FACTORY";
    }
    };

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/c$a.class */
    public static abstract class a<T extends Date> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<Date> f9a = new a<Date>(Date.class) { // from class: a.a.b.b.a.c.a.1
            @Override // a.a.b.b.a.c.a
            protected Date a(Date date) {
                return date;
            }
        };
        private final Class<T> b;

        protected a(Class<T> cls) {
            this.b = cls;
        }

        protected abstract T a(Date date);

        private C a(c<T> cVar) {
            return p.a(this.b, cVar);
        }

        public final C a(String str) {
            return a(new c<>(this, str));
        }

        public final C a(int i, int i2) {
            return a(new c<>(this, i, i2));
        }
    }

    private c(a<T> aVar, String str) {
        this.d = new ArrayList();
        this.c = (a) Objects.requireNonNull(aVar);
        this.d.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.d.add(new SimpleDateFormat(str));
    }

    private c(a<T> aVar, int i, int i2) {
        this.d = new ArrayList();
        this.c = (a) Objects.requireNonNull(aVar);
        this.d.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.d.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (a.a.b.b.e.b()) {
            this.d.add(a.a.b.b.l.a(i, i2));
        }
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, Date date) throws IOException {
        String str;
        if (date == null) {
            dVar.f();
            return;
        }
        DateFormat dateFormat = this.d.get(0);
        synchronized (this.d) {
            str = dateFormat.format(date);
        }
        dVar.b(str);
    }

    @Override // a.a.b.B
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T b(a.a.b.d.a aVar) throws IOException {
        if (aVar.f() == a.a.b.d.c.i) {
            aVar.j();
            return null;
        }
        return (T) this.c.a(c(aVar));
    }

    private Date c(a.a.b.d.a aVar) throws IOException {
        String strH = aVar.h();
        synchronized (this.d) {
            for (DateFormat dateFormat : this.d) {
                TimeZone timeZone = dateFormat.getTimeZone();
                try {
                    Date date = dateFormat.parse(strH);
                    dateFormat.setTimeZone(timeZone);
                    return date;
                } catch (ParseException e) {
                    dateFormat.setTimeZone(timeZone);
                } catch (Throwable th) {
                    dateFormat.setTimeZone(timeZone);
                    throw th;
                }
            }
            try {
                return a.a.b.b.a.a.a.a(strH, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new v("Failed parsing '" + strH + "' as Date; at path " + aVar.r(), e2);
            }
        }
    }

    public String toString() {
        DateFormat dateFormat = this.d.get(0);
        return dateFormat instanceof SimpleDateFormat ? "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')' : "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    private static String __unused_2104() {
        return "Failed parsing '";
    }

    private static String __unused_2105() {
        return "' as Date; at path ";
    }

    private static String __unused_2106() {
        return "DefaultDateTypeAdapter(";
    }

    private static String __unused_2107() {
        return "DefaultDateTypeAdapter(";
    }
}
