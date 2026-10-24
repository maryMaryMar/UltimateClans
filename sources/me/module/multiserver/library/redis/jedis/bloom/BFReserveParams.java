package me.module.multiserver.library.redis.jedis.bloom;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/BFReserveParams.class */
public class BFReserveParams implements IParams {
    private Integer expansion;
    private boolean nonScaling = false;

    public static BFReserveParams reserveParams() {
        return new BFReserveParams();
    }

    public BFReserveParams expansion(int i) {
        this.expansion = Integer.valueOf(i);
        return this;
    }

    public BFReserveParams nonScaling() {
        this.nonScaling = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.expansion != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.EXPANSION).add(Protocol.toByteArray(this.expansion.intValue()));
        }
        if (this.nonScaling) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.NONSCALING);
        }
    }
}
