package me.module.multiserver.library.redis.jedis.bloom;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/CFInsertParams.class */
public class CFInsertParams implements IParams {
    private Long capacity;
    private boolean noCreate = false;

    public static CFInsertParams insertParams() {
        return new CFInsertParams();
    }

    public CFInsertParams capacity(long j) {
        this.capacity = Long.valueOf(j);
        return this;
    }

    public CFInsertParams noCreate() {
        this.noCreate = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.capacity != null) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.CAPACITY).add(Protocol.toByteArray(this.capacity.longValue()));
        }
        if (this.noCreate) {
            commandArguments.add(RedisBloomProtocol.RedisBloomKeyword.NOCREATE);
        }
    }
}
