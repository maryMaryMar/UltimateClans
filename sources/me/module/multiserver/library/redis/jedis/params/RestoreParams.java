package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/RestoreParams.class */
public class RestoreParams implements IParams {
    private boolean replace;
    private boolean absTtl;
    private Long idleTime;
    private Long frequency;

    public static RestoreParams restoreParams() {
        return new RestoreParams();
    }

    public RestoreParams replace() {
        this.replace = true;
        return this;
    }

    public RestoreParams absTtl() {
        this.absTtl = true;
        return this;
    }

    public RestoreParams idleTime(long j) {
        this.idleTime = Long.valueOf(j);
        return this;
    }

    public RestoreParams frequency(long j) {
        this.frequency = Long.valueOf(j);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.replace) {
            commandArguments.add(Protocol.Keyword.REPLACE.getRaw());
        }
        if (this.absTtl) {
            commandArguments.add(Protocol.Keyword.ABSTTL.getRaw());
        }
        if (this.idleTime != null) {
            commandArguments.add(Protocol.Keyword.IDLETIME.getRaw());
            commandArguments.add(Protocol.toByteArray(this.idleTime.longValue()));
        }
        if (this.frequency != null) {
            commandArguments.add(Protocol.Keyword.FREQ.getRaw());
            commandArguments.add(Protocol.toByteArray(this.frequency.longValue()));
        }
    }
}
