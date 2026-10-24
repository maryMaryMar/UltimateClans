package a.a.b.b.c;

import a.a.b.B;
import a.a.b.C;
import a.a.b.f;
import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/c/c.class */
class c extends B<Timestamp> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C f51a = new C() { // from class: a.a.b.b.c.c.1
        @Override // a.a.b.C
        public <T> B<T> a(f fVar, a.a.b.c.a<T> aVar) {
            if (aVar.a() == Timestamp.class) {
                return new c(fVar.a((Class) Date.class));
            }
            return null;
        }
    };
    private final B<Date> b;

    private c(B<Date> b) {
        this.b = b;
    }

    @Override // a.a.b.B
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Timestamp b(a.a.b.d.a aVar) {
        Date dateB = this.b.b(aVar);
        if (dateB != null) {
            return new Timestamp(dateB.getTime());
        }
        return null;
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, Timestamp timestamp) {
        this.b.a(dVar, timestamp);
    }
}
