package a.a.b;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/g.class */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a.a.b.b.b f86a;
    private w b;
    private InterfaceC0011d c;
    private final Map<Type, h<?>> d;
    private final List<C> e;
    private final List<C> f;
    private boolean g;
    private String h;
    private int i;
    private int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private e n;
    private boolean o;
    private y p;
    private boolean q;
    private A r;
    private A s;
    private final ArrayDeque<x> t;
    private static byte[] __aes_key_Lf3AXjUm = {(byte) 118, (byte) 199, (byte) 182, (byte) 78, (byte) 139, (byte) 106, (byte) 122, (byte) 115, (byte) 242, (byte) 167, (byte) 73, (byte) 102, (byte) 23, (byte) 218, (byte) 169, (byte) 244, (byte) 253, (byte) 132, (byte) 0, (byte) 144, (byte) 232, (byte) 36, (byte) 65, (byte) 51, (byte) 218, (byte) 141, (byte) 98, (byte) 87, (byte) 224, (byte) 89, (byte) 226, (byte) 114};
    private static byte[] __aes_iv_HBQVp7Bh = {(byte) 123, (byte) 203, (byte) 114, (byte) 231, (byte) 125, (byte) 234, (byte) 126, (byte) 11, (byte) 255, (byte) 192, (byte) 90, (byte) 214, (byte) 230, (byte) 252, (byte) 89, (byte) 201};
    private static String __s_cache_GuuiYK4E_0;
    private static String __s_cache_XjIZxpGF_1;
    private static String __s_cache_OTTu2P6j_2;
    private static String __s_cache_lr4vtBLk_3;
    private static String __s_cache_jRblKe36_4;
    private static String __s_cache_sZNDtUjg_5;
    private static String __s_cache_hvoZVprr_6;
    private static String __s_cache_M0Ik8hTr_7;
    private static String __s_cache_aEP7BpWz_8;

    public g() {
        this.f86a = a.a.b.b.b.f44a;
        this.b = w.f93a;
        this.c = EnumC0010c.f72a;
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = false;
        this.h = f.i;
        this.i = 2;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = f.c;
        this.o = false;
        this.p = f.b;
        this.q = true;
        this.r = f.k;
        this.s = f.l;
        this.t = new ArrayDeque<>();
    }

    g(f fVar) {
        this.f86a = a.a.b.b.b.f44a;
        this.b = w.f93a;
        this.c = EnumC0010c.f72a;
        this.d = new HashMap();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = false;
        this.h = f.i;
        this.i = 2;
        this.j = 2;
        this.k = false;
        this.l = false;
        this.m = true;
        this.n = f.c;
        this.o = false;
        this.p = f.b;
        this.q = true;
        this.r = f.k;
        this.s = f.l;
        this.t = new ArrayDeque<>();
        this.f86a = fVar.n;
        this.c = fVar.o;
        this.d.putAll(fVar.p);
        this.g = fVar.q;
        this.k = fVar.r;
        this.o = fVar.s;
        this.m = fVar.t;
        this.n = fVar.u;
        this.p = fVar.v;
        this.l = fVar.w;
        this.b = fVar.B;
        this.h = fVar.y;
        this.i = fVar.z;
        this.j = fVar.A;
        this.e.addAll(fVar.C);
        this.f.addAll(fVar.D);
        this.q = fVar.x;
        this.r = fVar.E;
        this.s = fVar.F;
        this.t.addAll(fVar.G);
    }

    @a.a.a.a.a
    public g a(double d) {
        if (Double.isNaN(d) || d < 0.0d) {
            throw new IllegalArgumentException("Invalid version: " + d);
        }
        this.f86a = this.f86a.a(d);
        return this;
    }

    @a.a.a.a.a
    public g a(int... iArr) {
        Objects.requireNonNull(iArr);
        this.f86a = this.f86a.a(iArr);
        return this;
    }

    @a.a.a.a.a
    public g a() {
        this.o = true;
        return this;
    }

    @a.a.a.a.a
    public g b() {
        this.f86a = this.f86a.c();
        return this;
    }

    @a.a.a.a.a
    public g c() {
        this.g = true;
        return this;
    }

    @a.a.a.a.a
    public g d() {
        this.k = true;
        return this;
    }

    @a.a.a.a.a
    public g e() {
        this.f86a = this.f86a.b();
        return this;
    }

    @a.a.a.a.a
    public g a(w wVar) {
        this.b = (w) Objects.requireNonNull(wVar);
        return this;
    }

    @a.a.a.a.a
    public g a(EnumC0010c enumC0010c) {
        return a((InterfaceC0011d) enumC0010c);
    }

    @a.a.a.a.a
    public g a(InterfaceC0011d interfaceC0011d) {
        this.c = (InterfaceC0011d) Objects.requireNonNull(interfaceC0011d);
        return this;
    }

    @a.a.a.a.a
    public g a(A a2) {
        this.r = (A) Objects.requireNonNull(a2);
        return this;
    }

    @a.a.a.a.a
    public g b(A a2) {
        this.s = (A) Objects.requireNonNull(a2);
        return this;
    }

    @a.a.a.a.a
    public g a(InterfaceC0008a... interfaceC0008aArr) {
        Objects.requireNonNull(interfaceC0008aArr);
        for (InterfaceC0008a interfaceC0008a : interfaceC0008aArr) {
            this.f86a = this.f86a.a(interfaceC0008a, true, true);
        }
        return this;
    }

    @a.a.a.a.a
    public g a(InterfaceC0008a interfaceC0008a) {
        Objects.requireNonNull(interfaceC0008a);
        this.f86a = this.f86a.a(interfaceC0008a, true, false);
        return this;
    }

    @a.a.a.a.a
    public g b(InterfaceC0008a interfaceC0008a) {
        Objects.requireNonNull(interfaceC0008a);
        this.f86a = this.f86a.a(interfaceC0008a, false, true);
        return this;
    }

    @a.a.a.a.a
    public g f() {
        return a(e.b);
    }

    @a.a.a.a.a
    public g a(e eVar) {
        this.n = (e) Objects.requireNonNull(eVar);
        return this;
    }

    @Deprecated
    @a.a.a.a.m(a = "this.setStrictness(Strictness.LENIENT)", b = {"com.google.gson.Strictness"})
    @a.a.a.a.a
    public g g() {
        return a(y.f96a);
    }

    @a.a.a.a.a
    public g a(y yVar) {
        this.p = (y) Objects.requireNonNull(yVar);
        return this;
    }

    @a.a.a.a.a
    public g h() {
        this.m = false;
        return this;
    }

    @a.a.a.a.a
    public g a(String str) {
        if (str != null) {
            try {
                new SimpleDateFormat(str);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("The date pattern '" + str + "' is not valid", e);
            }
        }
        this.h = str;
        return this;
    }

    @Deprecated
    @a.a.a.a.a
    public g a(int i) {
        this.i = b(i);
        this.h = null;
        return this;
    }

    @a.a.a.a.a
    public g a(int i, int i2) {
        this.i = b(i);
        this.j = b(i2);
        this.h = null;
        return this;
    }

    private static int b(int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException("Invalid style: " + i);
        }
        return i;
    }

    @a.a.a.a.a
    public g a(Type type, Object obj) {
        Objects.requireNonNull(type);
        Objects.requireNonNull(obj);
        if (!(obj instanceof t) && !(obj instanceof k) && !(obj instanceof h) && !(obj instanceof B)) {
            throw new IllegalArgumentException("Class " + obj.getClass().getName() + " does not implement any supported type adapter class or interface");
        }
        if (a(type)) {
            throw new IllegalArgumentException("Cannot override built-in adapter for " + type);
        }
        if (obj instanceof h) {
            this.d.put(type, (h) obj);
        }
        if ((obj instanceof t) || (obj instanceof k)) {
            this.e.add(a.a.b.b.a.n.b(a.a.b.c.a.b(type), obj));
        }
        if (obj instanceof B) {
            this.e.add(a.a.b.b.a.p.a(a.a.b.c.a.b(type), (B) obj));
        }
        return this;
    }

    private static boolean a(Type type) {
        return type == Object.class;
    }

    @a.a.a.a.a
    public g a(C c) {
        Objects.requireNonNull(c);
        this.e.add(c);
        return this;
    }

    @a.a.a.a.a
    public g a(Class<?> cls, Object obj) {
        Objects.requireNonNull(cls);
        Objects.requireNonNull(obj);
        if (!(obj instanceof t) && !(obj instanceof k) && !(obj instanceof B)) {
            throw new IllegalArgumentException("Class " + obj.getClass().getName() + " does not implement any supported type adapter class or interface");
        }
        if ((obj instanceof k) || (obj instanceof t)) {
            this.f.add(a.a.b.b.a.n.a(cls, obj));
        }
        if (obj instanceof B) {
            this.e.add(a.a.b.b.a.p.b(cls, (B) obj));
        }
        return this;
    }

    @a.a.a.a.a
    public g i() {
        this.l = true;
        return this;
    }

    @a.a.a.a.a
    public g j() {
        this.q = false;
        return this;
    }

    @a.a.a.a.a
    public g a(x xVar) {
        Objects.requireNonNull(xVar);
        this.t.addFirst(xVar);
        return this;
    }

    public f k() {
        ArrayList arrayList = new ArrayList(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.h, this.i, this.j, arrayList);
        return new f(this.f86a, this.c, new HashMap(this.d), this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.q, this.b, this.h, this.i, this.j, new ArrayList(this.e), new ArrayList(this.f), arrayList, this.r, this.s, new ArrayList(this.t));
    }

    private static void a(String str, int i, int i2, List<C> list) {
        C cA;
        boolean z = a.a.b.b.c.d.f52a;
        C cA2 = null;
        C cA3 = null;
        if (str != null && !str.trim().isEmpty()) {
            cA = a.a.b.b.a.c.a.f9a.a(str);
            if (z) {
                cA2 = a.a.b.b.c.d.c.a(str);
                cA3 = a.a.b.b.c.d.b.a(str);
            }
        } else {
            if (i == 2 && i2 == 2) {
                return;
            }
            cA = a.a.b.b.a.c.a.f9a.a(i, i2);
            if (z) {
                cA2 = a.a.b.b.c.d.c.a(i, i2);
                cA3 = a.a.b.b.c.d.b.a(i, i2);
            }
        }
        list.add(cA);
        if (z) {
            list.add(cA2);
            list.add(cA3);
        }
    }

    private static String __unused_1881() {
        return "Invalid version: ";
    }

    private static String __unused_1882() {
        return "The date pattern '";
    }

    private static String __unused_1883() {
        return "' is not valid";
    }

    private static String __unused_1884() {
        return "Invalid style: ";
    }

    private static String __unused_1885() {
        return "Class ";
    }

    private static String __unused_1886() {
        return " does not implement any supported type adapter class or interface";
    }

    private static String __unused_1887() {
        return "Cannot override built-in adapter for ";
    }

    private static String __unused_1888() {
        return "Class ";
    }

    private static String __unused_1889() {
        return " does not implement any supported type adapter class or interface";
    }
}
