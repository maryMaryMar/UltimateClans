package a.a.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: renamed from: a.a.b.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b.class */
public final class C0009b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Field f2a;

    public C0009b(Field field) {
        this.f2a = (Field) Objects.requireNonNull(field);
    }

    public Class<?> a() {
        return this.f2a.getDeclaringClass();
    }

    public String b() {
        return this.f2a.getName();
    }

    public Type c() {
        return this.f2a.getGenericType();
    }

    public Class<?> d() {
        return this.f2a.getType();
    }

    public <T extends Annotation> T a(Class<T> cls) {
        return (T) this.f2a.getAnnotation(cls);
    }

    public Collection<Annotation> e() {
        return Arrays.asList(this.f2a.getAnnotations());
    }

    public boolean a(int i) {
        return (this.f2a.getModifiers() & i) != 0;
    }

    public String toString() {
        return this.f2a.toString();
    }
}
