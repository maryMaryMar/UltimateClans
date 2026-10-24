package me.module.multiserver.library.redis.jedis.search.querybuilder;

import java.util.StringJoiner;
import me.module.multiserver.library.redis.jedis.GeoCoordinate;
import me.module.multiserver.library.redis.jedis.args.GeoUnit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/Values.class */
public class Values {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/Values$ScalableValue.class */
    private static abstract class ScalableValue extends Value {
        private ScalableValue() {
        }

        @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Value
        public boolean isCombinable() {
            return true;
        }
    }

    private Values() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static Value value(final String str) {
        return new ScalableValue() { // from class: me.module.multiserver.library.redis.jedis.search.querybuilder.Values.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Value
            public String toString() {
                return str;
            }
        };
    }

    public static GeoValue geo(GeoCoordinate geoCoordinate, double d, GeoUnit geoUnit) {
        return new GeoValue(geoCoordinate.getLongitude(), geoCoordinate.getLatitude(), d, geoUnit);
    }

    public static RangeValue between(double d, double d2) {
        return new DoubleRangeValue(d, d2);
    }

    public static RangeValue between(int i, int i2) {
        return new LongRangeValue(i, i2);
    }

    public static RangeValue eq(double d) {
        return new DoubleRangeValue(d, d);
    }

    public static RangeValue eq(int i) {
        return new LongRangeValue(i, i);
    }

    public static RangeValue lt(double d) {
        return new DoubleRangeValue(Double.NEGATIVE_INFINITY, d).inclusiveMax(false);
    }

    public static RangeValue lt(int i) {
        return new LongRangeValue(Long.MIN_VALUE, i).inclusiveMax(false);
    }

    public static RangeValue gt(double d) {
        return new DoubleRangeValue(d, Double.POSITIVE_INFINITY).inclusiveMin(false);
    }

    public static RangeValue gt(int i) {
        return new LongRangeValue(i, Long.MAX_VALUE).inclusiveMin(false);
    }

    public static RangeValue le(double d) {
        return lt(d).inclusiveMax(true);
    }

    public static RangeValue le(int i) {
        return lt(i).inclusiveMax(true);
    }

    public static RangeValue ge(double d) {
        return gt(d).inclusiveMin(true);
    }

    public static RangeValue ge(int i) {
        return gt(i).inclusiveMin(true);
    }

    public static Value tags(String... strArr) {
        if (strArr.length == 0) {
            throw new IllegalArgumentException("Must have at least one tag");
        }
        final StringJoiner stringJoiner = new StringJoiner(" | ");
        for (String str : strArr) {
            stringJoiner.add(str);
        }
        return new Value() { // from class: me.module.multiserver.library.redis.jedis.search.querybuilder.Values.2
            @Override // me.module.multiserver.library.redis.jedis.search.querybuilder.Value
            public String toString() {
                return "{" + stringJoiner.toString() + "}";
            }
        };
    }
}
