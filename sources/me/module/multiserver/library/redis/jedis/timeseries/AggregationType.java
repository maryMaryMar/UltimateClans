package me.module.multiserver.library.redis.jedis.timeseries;

import me.module.multiserver.library.redis.jedis.args.Rawable;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/AggregationType.class */
public enum AggregationType implements Rawable {
    AVG,
    SUM,
    MIN,
    MAX,
    RANGE,
    COUNT,
    FIRST,
    LAST,
    STD_P("STD.P"),
    STD_S("STD.S"),
    VAR_P("VAR.P"),
    VAR_S("VAR.S"),
    TWA;

    private final byte[] raw;

    AggregationType() {
        this.raw = SafeEncoder.encode(name());
    }

    AggregationType(String str) {
        this.raw = SafeEncoder.encode(str);
    }

    @Override // me.module.multiserver.library.redis.jedis.args.Rawable
    public byte[] getRaw() {
        return this.raw;
    }

    public static AggregationType safeValueOf(String str) {
        try {
            return valueOf(str.replace('.', '_'));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
