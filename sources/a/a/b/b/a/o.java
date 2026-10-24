package a.a.b.b.a;

import a.a.b.B;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/o.class */
final class o<T> extends B<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.a.b.f f34a;
    private final B<T> b;
    private final Type c;

    o(a.a.b.f fVar, B<T> b, Type type) {
        this.f34a = fVar;
        this.b = b;
        this.c = type;
    }

    @Override // a.a.b.B
    public T b(a.a.b.d.a aVar) {
        return this.b.b(aVar);
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, T t) {
        B<T> b = this.b;
        Type typeA = a(this.c, t);
        if (typeA != this.c) {
            B<T> bA = this.f34a.a((a.a.b.c.a) a.a.b.c.a.b(typeA));
            b = ((bA instanceof l.a) && !a((B<?>) this.b)) ? this.b : bA;
        }
        b.a(dVar, t);
    }

    private static boolean a(B<?> b) {
        B<?> bA;
        while ((b instanceof m) && (bA = ((m) b).a()) != b) {
            b = bA;
        }
        return b instanceof l.a;
    }

    private static Type a(Type type, Object obj) {
        if (obj != null && ((type instanceof Class) || (type instanceof TypeVariable))) {
            type = obj.getClass();
        }
        return type;
    }
}
