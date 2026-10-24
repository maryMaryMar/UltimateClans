package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/a.class */
public final class a<E> extends B<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C f4a = new C() { // from class: a.a.b.b.a.a.1
        @Override // a.a.b.C
        public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
            Type typeB = aVar.b();
            if (!(typeB instanceof GenericArrayType) && (!(typeB instanceof Class) || !((Class) typeB).isArray())) {
                return null;
            }
            Type typeG = a.a.b.b.d.g(typeB);
            return new a(fVar, fVar.a((a.a.b.c.a) a.a.b.c.a.b(typeG)), a.a.b.b.d.e(typeG));
        }
    };
    private final Class<E> b;
    private final B<E> c;

    public a(a.a.b.f fVar, B<E> b, Class<E> cls) {
        this.c = new o(fVar, b, cls);
        this.b = cls;
    }

    @Override // a.a.b.B
    public Object b(a.a.b.d.a aVar) throws IOException {
        if (aVar.f() == a.a.b.d.c.i) {
            aVar.j();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.a();
        while (aVar.e()) {
            arrayList.add(this.c.b(aVar));
        }
        aVar.b();
        int size = arrayList.size();
        if (!this.b.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.b, size));
        }
        Object objNewInstance = Array.newInstance((Class<?>) this.b, size);
        for (int i = 0; i < size; i++) {
            Array.set(objNewInstance, i, arrayList.get(i));
        }
        return objNewInstance;
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, Object obj) throws IOException {
        if (obj == null) {
            dVar.f();
            return;
        }
        dVar.b();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.c.a(dVar, (E) Array.get(obj, i));
        }
        dVar.c();
    }
}
