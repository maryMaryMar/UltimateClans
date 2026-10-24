package a.a.b.b;

import a.a.b.B;
import a.a.b.C;
import a.a.b.C0009b;
import a.a.b.InterfaceC0008a;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/b.class */
public final class b implements C, Cloneable {
    private static final double b = -1.0d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f44a = new b();
    private boolean f;
    private double c = b;
    private int d = 136;
    private boolean e = true;
    private List<InterfaceC0008a> g = Collections.emptyList();
    private List<InterfaceC0008a> h = Collections.emptyList();

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b clone() {
        try {
            return (b) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public b a(double d) {
        b bVarClone = clone();
        bVarClone.c = d;
        return bVarClone;
    }

    public b a(int... iArr) {
        b bVarClone = clone();
        bVarClone.d = 0;
        for (int i : iArr) {
            bVarClone.d |= i;
        }
        return bVarClone;
    }

    public b b() {
        b bVarClone = clone();
        bVarClone.e = false;
        return bVarClone;
    }

    public b c() {
        b bVarClone = clone();
        bVarClone.f = true;
        return bVarClone;
    }

    public b a(InterfaceC0008a interfaceC0008a, boolean z, boolean z2) {
        b bVarClone = clone();
        if (z) {
            bVarClone.g = new ArrayList(this.g);
            bVarClone.g.add(interfaceC0008a);
        }
        if (z2) {
            bVarClone.h = new ArrayList(this.h);
            bVarClone.h.add(interfaceC0008a);
        }
        return bVarClone;
    }

    @Override // a.a.b.C
    public <T> B<T> a(final a.a.b.f fVar, final a.a.b.c.a<T> aVar) {
        Class<? super T> clsA = aVar.a();
        final boolean zA = a((Class<?>) clsA, true);
        final boolean zA2 = a((Class<?>) clsA, false);
        if (zA || zA2) {
            return new B<T>() { // from class: a.a.b.b.b.1
                private volatile B<T> f;

                @Override // a.a.b.B
                public T b(a.a.b.d.a aVar2) throws IOException {
                    if (!zA2) {
                        return a().b(aVar2);
                    }
                    aVar2.o();
                    return null;
                }

                @Override // a.a.b.B
                public void a(a.a.b.d.d dVar, T t) throws IOException {
                    if (zA) {
                        dVar.f();
                    } else {
                        a().a(dVar, t);
                    }
                }

                private B<T> a() {
                    B<T> b2 = this.f;
                    if (b2 == null) {
                        B<T> bA = fVar.a(b.this, aVar);
                        this.f = bA;
                        b2 = bA;
                    }
                    return b2;
                }
            };
        }
        return null;
    }

    public boolean a(Field field, boolean z) {
        if ((this.d & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.c != b && !a((a.a.b.a.d) field.getAnnotation(a.a.b.a.d.class), (a.a.b.a.e) field.getAnnotation(a.a.b.a.e.class))) || field.isSynthetic()) {
            return true;
        }
        if (this.f) {
            a.a.b.a.a aVar = (a.a.b.a.a) field.getAnnotation(a.a.b.a.a.class);
            if (aVar == null) {
                return true;
            }
            if (z) {
                if (!aVar.a()) {
                    return true;
                }
            } else if (!aVar.b()) {
                return true;
            }
        }
        if (a(field.getType(), z)) {
            return true;
        }
        List<InterfaceC0008a> list = z ? this.g : this.h;
        if (list.isEmpty()) {
            return false;
        }
        C0009b c0009b = new C0009b(field);
        Iterator<InterfaceC0008a> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().a(c0009b)) {
                return true;
            }
        }
        return false;
    }

    public boolean a(Class<?> cls, boolean z) {
        if (this.c != b && !a((a.a.b.a.d) cls.getAnnotation(a.a.b.a.d.class), (a.a.b.a.e) cls.getAnnotation(a.a.b.a.e.class))) {
            return true;
        }
        if (!this.e && a(cls)) {
            return true;
        }
        if (!z && !Enum.class.isAssignableFrom(cls) && a.a.b.b.b.a.b(cls)) {
            return true;
        }
        Iterator<InterfaceC0008a> it = (z ? this.g : this.h).iterator();
        while (it.hasNext()) {
            if (it.next().a(cls)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Class<?> cls) {
        return cls.isMemberClass() && !a.a.b.b.b.a.a(cls);
    }

    private boolean a(a.a.b.a.d dVar, a.a.b.a.e eVar) {
        return a(dVar) && a(eVar);
    }

    private boolean a(a.a.b.a.d dVar) {
        if (dVar != null) {
            return this.c >= dVar.a();
        }
        return true;
    }

    private boolean a(a.a.b.a.e eVar) {
        if (eVar != null) {
            return this.c < eVar.a();
        }
        return true;
    }
}
