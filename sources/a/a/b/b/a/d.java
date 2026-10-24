package a.a.b.b.a;

import a.a.b.B;
import a.a.b.C;
import java.io.IOException;
import java.lang.Enum;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/a/d.class */
class d<T extends Enum<T>> extends B<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final C f10a = new C() { // from class: a.a.b.b.a.d.1
        @Override // a.a.b.C
        public <T> B<T> a(a.a.b.f fVar, a.a.b.c.a<T> aVar) {
            Class<? super T> clsA = aVar.a();
            if (!Enum.class.isAssignableFrom(clsA) || clsA == Enum.class) {
                return null;
            }
            if (!clsA.isEnum()) {
                clsA = clsA.getSuperclass();
            }
            return new d(clsA);
        }
    };
    private final Map<String, T> b;
    private final Map<String, T> c;
    private final Map<T, String> d;

    private d(Class<T> cls) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new HashMap();
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            int i = 0;
            for (Field field : declaredFields) {
                if (field.isEnumConstant()) {
                    int i2 = i;
                    i++;
                    declaredFields[i2] = field;
                }
            }
            Field[] fieldArr = (Field[]) Arrays.copyOf(declaredFields, i);
            AccessibleObject.setAccessible(fieldArr, true);
            for (Field field2 : fieldArr) {
                Enum r0 = (Enum) field2.get(null);
                String strName = r0.name();
                String string = r0.toString();
                a.a.b.a.c cVar = (a.a.b.a.c) field2.getAnnotation(a.a.b.a.c.class);
                if (cVar != null) {
                    strName = cVar.a();
                    for (String str : cVar.b()) {
                        this.b.put(str, (T) r0);
                    }
                }
                this.b.put(strName, (T) r0);
                this.c.put(string, (T) r0);
                this.d.put((T) r0, strName);
            }
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    @Override // a.a.b.B
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public T b(a.a.b.d.a aVar) throws IOException {
        if (aVar.f() == a.a.b.d.c.i) {
            aVar.j();
            return null;
        }
        String strH = aVar.h();
        T t = this.b.get(strH);
        return t == null ? this.c.get(strH) : t;
    }

    @Override // a.a.b.B
    public void a(a.a.b.d.d dVar, T t) throws IOException {
        dVar.b(t == null ? null : this.d.get(t));
    }
}
