package me.module.multiserver.library.redis.jedis.resps;

import java.util.Arrays;
import java.util.Objects;
import me.module.multiserver.library.redis.jedis.util.ByteArrayComparator;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/Tuple.class */
public class Tuple implements Comparable<Tuple> {
    private byte[] element;
    private Double score;

    public Tuple(String str, Double d) {
        this(SafeEncoder.encode(str), d);
    }

    public Tuple(byte[] bArr, Double d) {
        this.element = bArr;
        this.score = d;
    }

    public int hashCode() {
        int i = 31 * 1;
        if (null != this.element) {
            for (byte b : this.element) {
                i = (31 * i) + b;
            }
        }
        long jDoubleToLongBits = Double.doubleToLongBits(this.score.doubleValue());
        return (31 * i) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tuple)) {
            return false;
        }
        Tuple tuple = (Tuple) obj;
        if (Arrays.equals(this.element, tuple.element)) {
            return Objects.equals(this.score, tuple.score);
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(Tuple tuple) {
        return compare(this, tuple);
    }

    public static int compare(Tuple tuple, Tuple tuple2) {
        int iCompare = Double.compare(tuple.score.doubleValue(), tuple2.score.doubleValue());
        return iCompare != 0 ? iCompare : ByteArrayComparator.compare(tuple.element, tuple2.element);
    }

    public String getElement() {
        if (null != this.element) {
            return SafeEncoder.encode(this.element);
        }
        return null;
    }

    public byte[] getBinaryElement() {
        return this.element;
    }

    public double getScore() {
        return this.score.doubleValue();
    }

    public String toString() {
        return '[' + SafeEncoder.encode(this.element) + ',' + this.score + ']';
    }
}
