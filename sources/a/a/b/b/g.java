package a.a.b.b;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.math.BigDecimal;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:a/a/b/b/g.class */
public final class g extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f59a;
    private static byte[] __aes_key_oTNXEK9Y = {(byte) 212, (byte) 116, (byte) 123, (byte) 34, (byte) 169, (byte) 229, (byte) 147, (byte) 79, (byte) 235, (byte) 183, (byte) 127, (byte) 27, (byte) 34, (byte) 243, (byte) 199, (byte) 119, (byte) 121, (byte) 185, (byte) 246, (byte) 252, (byte) 114, (byte) 30, (byte) 53, (byte) 86, (byte) 67, (byte) 32, (byte) 246, (byte) 235, (byte) 111, (byte) 235, (byte) 15, (byte) 200};
    private static byte[] __aes_iv_k9jxcx1e = {(byte) 45, (byte) 171, (byte) 191, (byte) 223, (byte) 22, (byte) 37, (byte) 176, (byte) 11, (byte) 235, (byte) 202, (byte) 202, (byte) 97, (byte) 30, (byte) 7, (byte) 129, (byte) 197};
    private static String __s_cache_o5YjKDkz_0;

    public g(String str) {
        this.f59a = str;
    }

    private BigDecimal a() {
        return j.a(this.f59a);
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            return Integer.parseInt(this.f59a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.f59a);
            } catch (NumberFormatException e2) {
                return a().intValue();
            }
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f59a);
        } catch (NumberFormatException e) {
            return a().longValue();
        }
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f59a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f59a);
    }

    public String toString() {
        return this.f59a;
    }

    private Object b() {
        return a();
    }

    private void a(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    public int hashCode() {
        return this.f59a.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            return this.f59a.equals(((g) obj).f59a);
        }
        return false;
    }

    private static String __unused_2013() {
        return "Deserialization is unsupported";
    }
}
