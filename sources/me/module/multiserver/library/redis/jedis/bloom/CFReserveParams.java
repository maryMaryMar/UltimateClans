package me.module.multiserver.library.redis.jedis.bloom;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/CFReserveParams.class */
public class CFReserveParams implements IParams {
    private Long bucketSize;
    private Integer maxIterations;
    private Integer expansion;

    public static CFReserveParams reserveParams() {
        return new CFReserveParams();
    }

    public CFReserveParams bucketSize(long j) {
        this.bucketSize = Long.valueOf(j);
        return this;
    }

    public CFReserveParams maxIterations(int i) {
        this.maxIterations = Integer.valueOf(i);
        return this;
    }

    public CFReserveParams expansion(int i) {
        this.expansion = Integer.valueOf(i);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.bucketSize != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.BUCKETSIZE).add(Protocol.toByteArray(this.bucketSize.longValue()));
        }
        if (this.maxIterations != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.MAXITERATIONS).add(Protocol.toByteArray(this.maxIterations.intValue()));
        }
        if (this.expansion != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.EXPANSION).add(Protocol.toByteArray(this.expansion.intValue()));
        }
    }
}
