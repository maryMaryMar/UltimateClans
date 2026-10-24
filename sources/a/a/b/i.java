package a.a.b;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/i.class */
public final class i extends l implements Iterable<l> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArrayList<l> f87a;
    private static byte[] __aes_key_EEDLmvkA = {(byte) 145, (byte) 72, (byte) 150, (byte) 217, (byte) 213, (byte) 136, (byte) 49, (byte) 193, (byte) 184, (byte) 14, (byte) 155, (byte) 60, (byte) 180, (byte) 174, (byte) 8, (byte) 164, (byte) 161, (byte) 15, (byte) 185, (byte) 147, (byte) 59, (byte) 121, (byte) 111, (byte) 242, (byte) 13, (byte) 62, (byte) 136, (byte) 229, (byte) 126, (byte) 47, (byte) 42, (byte) 17};
    private static byte[] __aes_iv_pyiYhMS8 = {(byte) 186, (byte) 244, (byte) 219, (byte) 34, (byte) 24, (byte) 232, (byte) 86, (byte) 18, (byte) 219, (byte) 87, (byte) 161, (byte) 52, (byte) 94, (byte) 152, (byte) 177, (byte) 122};
    private static String __s_cache_KuvAgrbx_0;

    public i() {
        this.f87a = new ArrayList<>();
    }

    public i(int i) {
        this.f87a = new ArrayList<>(i);
    }

    @Override // a.a.b.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public i q() {
        if (this.f87a.isEmpty()) {
            return new i();
        }
        i iVar = new i(this.f87a.size());
        Iterator<l> it = this.f87a.iterator();
        while (it.hasNext()) {
            iVar.a(it.next().q());
        }
        return iVar;
    }

    public void a(Boolean bool) {
        this.f87a.add(bool == null ? n.f88a : new r(bool));
    }

    public void a(Character ch) {
        this.f87a.add(ch == null ? n.f88a : new r(ch));
    }

    public void a(Number number) {
        this.f87a.add(number == null ? n.f88a : new r(number));
    }

    public void a(String str) {
        this.f87a.add(str == null ? n.f88a : new r(str));
    }

    public void a(l lVar) {
        if (lVar == null) {
            lVar = n.f88a;
        }
        this.f87a.add(lVar);
    }

    public void a(i iVar) {
        this.f87a.addAll(iVar.f87a);
    }

    @a.a.a.a.a
    public l a(int i, l lVar) {
        return this.f87a.set(i, lVar == null ? n.f88a : lVar);
    }

    @a.a.a.a.a
    public boolean b(l lVar) {
        return this.f87a.remove(lVar);
    }

    @a.a.a.a.a
    public l a(int i) {
        return this.f87a.remove(i);
    }

    public boolean c(l lVar) {
        return this.f87a.contains(lVar);
    }

    public int b() {
        return this.f87a.size();
    }

    public boolean c() {
        return this.f87a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<l> iterator() {
        return this.f87a.iterator();
    }

    public l b(int i) {
        return this.f87a.get(i);
    }

    private l z() {
        int size = this.f87a.size();
        if (size == 1) {
            return this.f87a.get(0);
        }
        throw new IllegalStateException("Array must have size 1, but has size " + size);
    }

    @Override // a.a.b.l
    public Number d() {
        return z().d();
    }

    @Override // a.a.b.l
    public String e() {
        return z().e();
    }

    @Override // a.a.b.l
    public double f() {
        return z().f();
    }

    @Override // a.a.b.l
    public BigDecimal g() {
        return z().g();
    }

    @Override // a.a.b.l
    public BigInteger h() {
        return z().h();
    }

    @Override // a.a.b.l
    public float i() {
        return z().i();
    }

    @Override // a.a.b.l
    public long j() {
        return z().j();
    }

    @Override // a.a.b.l
    public int k() {
        return z().k();
    }

    @Override // a.a.b.l
    public byte l() {
        return z().l();
    }

    @Override // a.a.b.l
    @Deprecated
    public char m() {
        return z().m();
    }

    @Override // a.a.b.l
    public short n() {
        return z().n();
    }

    @Override // a.a.b.l
    public boolean o() {
        return z().o();
    }

    public List<l> p() {
        return new a.a.b.b.i(this.f87a);
    }

    public boolean equals(Object obj) {
        return obj == this || ((obj instanceof i) && ((i) obj).f87a.equals(this.f87a));
    }

    public int hashCode() {
        return this.f87a.hashCode();
    }

    private static String __unused_1856() {
        return "Array must have size 1, but has size ";
    }
}
