package me.module.multiserver.library.redis.jedis;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/GeoCoordinate.class */
public class GeoCoordinate {
    private double longitude;
    private double latitude;

    public GeoCoordinate(double d, double d2) {
        this.longitude = d;
        this.latitude = d2;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoCoordinate)) {
            return false;
        }
        GeoCoordinate geoCoordinate = (GeoCoordinate) obj;
        return Double.compare(geoCoordinate.longitude, this.longitude) == 0 && Double.compare(geoCoordinate.latitude, this.latitude) == 0;
    }

    public int hashCode() {
        long jDoubleToLongBits = Double.doubleToLongBits(this.longitude);
        int i = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
        long jDoubleToLongBits2 = Double.doubleToLongBits(this.latitude);
        return (31 * i) + ((int) (jDoubleToLongBits2 ^ (jDoubleToLongBits2 >>> 32)));
    }

    public String toString() {
        return "(" + this.longitude + "," + this.latitude + ")";
    }
}
