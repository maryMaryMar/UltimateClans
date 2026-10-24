package me.module.multiserver.library.redis.jedis.resps;

import java.util.Arrays;
import me.module.multiserver.library.redis.jedis.GeoCoordinate;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/GeoRadiusResponse.class */
public class GeoRadiusResponse {
    private byte[] member;
    private double distance;
    private GeoCoordinate coordinate;
    private long rawScore;

    public GeoRadiusResponse(byte[] bArr) {
        this.member = bArr;
    }

    public void setDistance(double d) {
        this.distance = d;
    }

    public void setCoordinate(GeoCoordinate geoCoordinate) {
        this.coordinate = geoCoordinate;
    }

    public byte[] getMember() {
        return this.member;
    }

    public String getMemberByString() {
        return SafeEncoder.encode(this.member);
    }

    public double getDistance() {
        return this.distance;
    }

    public GeoCoordinate getCoordinate() {
        return this.coordinate;
    }

    public long getRawScore() {
        return this.rawScore;
    }

    public void setRawScore(long j) {
        this.rawScore = j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeoRadiusResponse)) {
            return false;
        }
        GeoRadiusResponse geoRadiusResponse = (GeoRadiusResponse) obj;
        return Double.compare(this.distance, geoRadiusResponse.getDistance()) == 0 && this.rawScore == geoRadiusResponse.getRawScore() && this.coordinate.equals(geoRadiusResponse.coordinate) && Arrays.equals(this.member, geoRadiusResponse.getMember());
    }
}
