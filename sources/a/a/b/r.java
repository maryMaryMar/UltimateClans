package a.a.b;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/r.class */
public final class r extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f91a;
    private static byte[] __aes_key_EvE59u6i = {(byte) 215, (byte) 32, (byte) 143, (byte) 131, (byte) 88, (byte) 28, (byte) 136, (byte) 97, (byte) 70, (byte) 94, (byte) 113, (byte) 18, (byte) 194, (byte) 240, (byte) 159, (byte) 8, (byte) 175, (byte) 21, (byte) 157, (byte) 123, (byte) 145, (byte) 205, (byte) 178, (byte) 108, (byte) 115, (byte) 16, (byte) 240, (byte) 49, (byte) 13, (byte) 188, (byte) 42, (byte) 186};
    private static byte[] __aes_iv_zE5NIGF8 = {(byte) 146, (byte) 210, (byte) 36, (byte) 41, (byte) 133, (byte) 177, (byte) 126, (byte) 158, (byte) 158, (byte) 54, (byte) 239, (byte) 14, (byte) 226, (byte) 193, (byte) 124, (byte) 222};
    private static String __s_cache_zT6jXxsY_0;
    private static String __s_cache_pY6OKysj_1;
    private static String __s_cache_v32qAsz9_2;

    public r(Boolean bool) {
        this.f91a = Objects.requireNonNull(bool);
    }

    public r(Number number) {
        this.f91a = Objects.requireNonNull(number);
    }

    public r(String str) {
        this.f91a = Objects.requireNonNull(str);
    }

    public r(Character ch) {
        this.f91a = ((Character) Objects.requireNonNull(ch)).toString();
    }

    @Override // a.a.b.l
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public r q() {
        return this;
    }

    public boolean b() {
        return this.f91a instanceof Boolean;
    }

    @Override // a.a.b.l
    public boolean o() {
        return b() ? ((Boolean) this.f91a).booleanValue() : Boolean.parseBoolean(e());
    }

    public boolean c() {
        return this.f91a instanceof Number;
    }

    @Override // a.a.b.l
    public Number d() {
        if (this.f91a instanceof Number) {
            return (Number) this.f91a;
        }
        if (this.f91a instanceof String) {
            return new a.a.b.b.g((String) this.f91a);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean p() {
        return this.f91a instanceof String;
    }

    @Override // a.a.b.l
    public String e() {
        if (this.f91a instanceof String) {
            return (String) this.f91a;
        }
        if (c()) {
            return d().toString();
        }
        if (b()) {
            return ((Boolean) this.f91a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f91a.getClass());
    }

    @Override // a.a.b.l
    public double f() {
        return c() ? d().doubleValue() : Double.parseDouble(e());
    }

    @Override // a.a.b.l
    public BigDecimal g() {
        return this.f91a instanceof BigDecimal ? (BigDecimal) this.f91a : a.a.b.b.j.a(e());
    }

    @Override // a.a.b.l
    public BigInteger h() {
        if (this.f91a instanceof BigInteger) {
            return (BigInteger) this.f91a;
        }
        return a(this) ? BigInteger.valueOf(d().longValue()) : a.a.b.b.j.b(e());
    }

    @Override // a.a.b.l
    public float i() {
        return c() ? d().floatValue() : Float.parseFloat(e());
    }

    @Override // a.a.b.l
    public long j() {
        return c() ? d().longValue() : Long.parseLong(e());
    }

    @Override // a.a.b.l
    public short n() {
        return c() ? d().shortValue() : Short.parseShort(e());
    }

    @Override // a.a.b.l
    public int k() {
        return c() ? d().intValue() : Integer.parseInt(e());
    }

    @Override // a.a.b.l
    public byte l() {
        return c() ? d().byteValue() : Byte.parseByte(e());
    }

    @Override // a.a.b.l
    @Deprecated
    public char m() {
        String strE = e();
        if (strE.isEmpty()) {
            throw new UnsupportedOperationException("String value is empty");
        }
        return strE.charAt(0);
    }

    public int hashCode() {
        if (this.f91a == null) {
            return 31;
        }
        if (a(this)) {
            long jLongValue = d().longValue();
            return (int) (jLongValue ^ (jLongValue >>> 32));
        }
        if (!(this.f91a instanceof Number)) {
            return this.f91a.hashCode();
        }
        long jDoubleToLongBits = Double.doubleToLongBits(d().doubleValue());
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        r rVar = (r) obj;
        if (this.f91a == null) {
            return rVar.f91a == null;
        }
        if (a(this) && a(rVar)) {
            if ((this.f91a instanceof BigInteger) || (rVar.f91a instanceof BigInteger)) {
                return h().equals(rVar.h());
            }
            return d().longValue() == rVar.d().longValue();
        }
        if (!(this.f91a instanceof Number) || !(rVar.f91a instanceof Number)) {
            return this.f91a.equals(rVar.f91a);
        }
        if ((this.f91a instanceof BigDecimal) && (rVar.f91a instanceof BigDecimal)) {
            return g().compareTo(rVar.g()) == 0;
        }
        double dF = f();
        double dF2 = rVar.f();
        return dF == dF2 || (Double.isNaN(dF) && Double.isNaN(dF2));
    }

    private static boolean a(r rVar) {
        if (!(rVar.f91a instanceof Number)) {
            return false;
        }
        Number number = (Number) rVar.f91a;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    private static String __unused_1845() {
        return "Primitive is neither a number nor a string";
    }

    private static String __unused_1846() {
        return "Unexpected value type: ";
    }

    private static String __unused_1847() {
        return "String value is empty";
    }
}
