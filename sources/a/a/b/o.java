package a.a.b;

import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/o.class */
public final class o extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a.a.b.b.h<String, l> f89a = new a.a.b.b.h<>(false);

    @Override // a.a.b.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public o q() {
        o oVar = new o();
        for (Map.Entry<String, l> entry : this.f89a.entrySet()) {
            oVar.a(entry.getKey(), entry.getValue().q());
        }
        return oVar;
    }

    public void a(String str, l lVar) {
        this.f89a.put(str, lVar == null ? n.f88a : lVar);
    }

    @a.a.a.a.a
    public l a(String str) {
        return this.f89a.remove(str);
    }

    public void a(String str, String str2) {
        a(str, str2 == null ? n.f88a : new r(str2));
    }

    public void a(String str, Number number) {
        a(str, number == null ? n.f88a : new r(number));
    }

    public void a(String str, Boolean bool) {
        a(str, bool == null ? n.f88a : new r(bool));
    }

    public void a(String str, Character ch) {
        a(str, ch == null ? n.f88a : new r(ch));
    }

    public Set<Map.Entry<String, l>> b() {
        return this.f89a.entrySet();
    }

    public Set<String> c() {
        return this.f89a.keySet();
    }

    public int p() {
        return this.f89a.size();
    }

    public boolean z() {
        return this.f89a.isEmpty();
    }

    public boolean b(String str) {
        return this.f89a.containsKey(str);
    }

    public l c(String str) {
        return this.f89a.get(str);
    }

    public r d(String str) {
        return (r) this.f89a.get(str);
    }

    public i e(String str) {
        return (i) this.f89a.get(str);
    }

    public o f(String str) {
        return (o) this.f89a.get(str);
    }

    public Map<String, l> A() {
        return this.f89a;
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof o) && ((o) obj).f89a.equals(this.f89a));
    }

    public int hashCode() {
        return this.f89a.hashCode();
    }
}
