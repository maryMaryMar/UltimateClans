package me.module.multiserver.library.redis.jedis.bloom;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/BFInsertParams.class */
public class BFInsertParams implements IParams {
    private Long capacity;
    private Double errorRate;
    private Integer expansion;
    private boolean noCreate = false;
    private boolean nonScaling = false;

    public static BFInsertParams insertParams() {
        return new BFInsertParams();
    }

    public BFInsertParams capacity(long j) {
        this.capacity = Long.valueOf(j);
        return this;
    }

    public BFInsertParams error(double d) {
        this.errorRate = Double.valueOf(d);
        return this;
    }

    public BFInsertParams expansion(int i) {
        this.expansion = Integer.valueOf(i);
        return this;
    }

    public BFInsertParams noCreate() {
        this.noCreate = true;
        return this;
    }

    public BFInsertParams nonScaling() {
        this.nonScaling = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.capacity != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.CAPACITY).add(Protocol.toByteArray(this.capacity.longValue()));
        }
        if (this.errorRate != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.ERROR).add(Protocol.toByteArray(this.errorRate.doubleValue()));
        }
        if (this.expansion != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.EXPANSION).add(Protocol.toByteArray(this.expansion.intValue()));
        }
        if (this.noCreate) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.NOCREATE);
        }
        if (this.nonScaling) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.NONSCALING);
        }
    }
}
