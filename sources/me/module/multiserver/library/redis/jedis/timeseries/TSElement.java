package me.module.multiserver.library.redis.jedis.timeseries;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSElement.class */
public class TSElement {
    private final long timestamp;
    private final double value;

    public TSElement(long j, double d) {
        this.timestamp = j;
        this.value = d;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public double getValue() {
        return this.value;
    }

    public int hashCode() {
        return (31 * Long.hashCode(this.timestamp)) + Long.hashCode(Double.doubleToLongBits(this.value));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TSElement)) {
            return false;
        }
        TSElement tSElement = (TSElement) obj;
        return this.timestamp == tSElement.timestamp && this.value == tSElement.value;
    }

    public String toString() {
        return "(" + this.timestamp + ":" + this.value + ")";
    }
}
