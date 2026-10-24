package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/XClaimParams.class */
public class XClaimParams implements IParams {
    private Long idleTime;
    private Long idleUnixTime;
    private Integer retryCount;
    private boolean force;

    public static XClaimParams xClaimParams() {
        return new XClaimParams();
    }

    public XClaimParams idle(long j) {
        this.idleTime = Long.valueOf(j);
        return this;
    }

    public XClaimParams time(long j) {
        this.idleUnixTime = Long.valueOf(j);
        return this;
    }

    public XClaimParams retryCount(int i) {
        this.retryCount = Integer.valueOf(i);
        return this;
    }

    public XClaimParams force() {
        this.force = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.idleTime != null) {
            commandArguments.add(Protocol.Keyword.IDLE).add(this.idleTime);
        }
        if (this.idleUnixTime != null) {
            commandArguments.add(Protocol.Keyword.TIME).add(this.idleUnixTime);
        }
        if (this.retryCount != null) {
            commandArguments.add(Protocol.Keyword.RETRYCOUNT).add(this.retryCount);
        }
        if (this.force) {
            commandArguments.add(Protocol.Keyword.FORCE);
        }
    }
}
