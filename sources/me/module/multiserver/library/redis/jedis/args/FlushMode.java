package me.module.multiserver.library.redis.jedis.args;

import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/args/FlushMode.class */
public enum FlushMode implements Rawable {
    SYNC,
    ASYNC;

    private final byte[] raw = SafeEncoder.encode(name());

    FlushMode() {
    }

    @Override // me.module.multiserver.library.redis.jedis.args.Rawable
    public byte[] getRaw() {
        return this.raw;
    }
}
