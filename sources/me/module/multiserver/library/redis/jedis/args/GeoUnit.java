package me.module.multiserver.library.redis.jedis.args;

import java.util.Locale;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/args/GeoUnit.class */
public enum GeoUnit implements Rawable {
    M,
    KM,
    MI,
    FT;

    private final byte[] raw = SafeEncoder.encode(name().toLowerCase(Locale.ENGLISH));

    GeoUnit() {
    }

    @Override // me.module.multiserver.library.redis.jedis.args.Rawable
    public byte[] getRaw() {
        return this.raw;
    }
}
