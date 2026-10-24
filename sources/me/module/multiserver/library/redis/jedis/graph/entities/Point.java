package me.module.multiserver.library.redis.jedis.graph.entities;

import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/entities/Point.class */
public final class Point {
    private static final double EPSILON = 1.0E-5d;
    private final double latitude;
    private final double longitude;

    public Point(double d, double d2) {
        this.latitude = d;
        this.longitude = d2;
    }

    public Point(List<Double> list) {
        if (list == null || list.size() != 2) {
            throw new IllegalArgumentException("Point requires two doubles.");
        }
        this.latitude = list.get(0).doubleValue();
        this.longitude = list.get(1).doubleValue();
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return Math.abs(this.latitude - point.latitude) < EPSILON && Math.abs(this.longitude - point.longitude) < EPSILON;
    }

    public int hashCode() {
        return Objects.hash(Double.valueOf(this.latitude), Double.valueOf(this.longitude));
    }

    public String toString() {
        return "Point{latitude=" + this.latitude + ", longitude=" + this.longitude + "}";
    }
}
