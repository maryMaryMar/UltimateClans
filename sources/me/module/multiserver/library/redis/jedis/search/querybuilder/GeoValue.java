package me.module.multiserver.library.redis.jedis.search.querybuilder;

import java.util.Locale;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/GeoValue.class */
public class GeoValue extends Value {
    private final GeoUnit unit;
    private final double lon;
    private final double lat;
    private final double radius;

    public GeoValue(double d, double d2, double d3, GeoUnit geoUnit) {
        this.lon = d;
        this.lat = d2;
        this.radius = d3;
        this.unit = geoUnit;
    }

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Value
    public String toString() {
        return "[" + this.lon + " " + this.lat + " " + this.radius + " " + this.unit.name().toLowerCase(Locale.ENGLISH) + "]";
    }

    @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Value
    public boolean isCombinable() {
        return false;
    }
}
