package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/b.class */
public final class b implements C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.a.b.b.a f6a;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/b$a.class */
    private static final class a<E> extends B<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final B<E> f7a;
        private final a.a.b.b.k<? extends Collection<E>> b;

        a(B<E> b, a.a.b.b.k<? extends Collection<E>> kVar) {
            this.f7a = b;
            this.b = kVar;
        }

        @Override // a.a.b.B
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(a.a.b.d.a aVar) throws IOException {
            if (aVar.f() == a.a.b.d.c.i) {
                aVar.j();
                return null;
            }
            Collection<E> collectionConstruct = this.b.construct();
            aVar.a();
            while (aVar.e()) {
                collectionConstruct.add(this.f7a.b(aVar));
            }
            aVar.b();
            return collectionConstruct;
        }

        @Override // a.a.b.B
        public void a(a.a.b.d.d dVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                dVar.f();
                return;
            }
            dVar.b();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f7a.a(dVar, it.next());
            }
            dVar.c();
        }
    }

    public b(a.a.b.b.a aVar) {
        this.f6a = aVar;
    }

    @Override // a.a.b.C
    public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
        Type typeB = aVar.b();
        Class<? super T> clsA = aVar.a();
        if (!Collection.class.isAssignableFrom(clsA)) {
            return null;
        }
        Type typeA = a.a.b.b.d.a(typeB, (Class<?>) clsA);
        return new a(new o(fVar, fVar.a((a.a.b.c.a) a.a.b.c.a.b(typeA)), typeA), this.f6a.a((a.a.b.c.a) aVar, false));
    }
}
