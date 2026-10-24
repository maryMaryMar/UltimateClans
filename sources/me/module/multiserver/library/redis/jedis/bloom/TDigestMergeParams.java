package me.module.multiserver.library.redis.jedis.bloom;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/TDigestMergeParams.class */
public class TDigestMergeParams implements IParams {
    private Integer compression;
    private boolean override = false;

    public static TDigestMergeParams mergeParams() {
        return new TDigestMergeParams();
    }

    public TDigestMergeParams compression(int i) {
        this.compression = Integer.valueOf(i);
        return this;
    }

    public TDigestMergeParams override() {
        this.override = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.compression != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.COMPRESSION).add(Protocol.toByteArray(this.compression.intValue()));
        }
        if (this.override) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.OVERRIDE);
        }
    }
}
