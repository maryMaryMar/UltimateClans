package me.module.multiserver.library.redis.jedis.search;

import me.module.multiserver.library.redis.jedis.args.Rawable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/LazyRawable.class */
class LazyRawable implements Rawable {
    private byte[] raw = null;

    LazyRawable() {
    }

    public void setRaw(byte[] bArr) {
        this.raw = bArr;
    }

    @Override // me.module.multiserver.library.redis.jedis.args.Rawable
    public byte[] getRaw() {
        return this.raw;
    }
}
