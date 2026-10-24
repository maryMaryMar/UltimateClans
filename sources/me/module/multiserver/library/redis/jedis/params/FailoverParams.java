package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.HostAndPort;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/FailoverParams.class */
public class FailoverParams implements IParams {
    private HostAndPort to;
    private boolean force;
    private Long timeout;

    public static FailoverParams failoverParams() {
        return new FailoverParams();
    }

    public FailoverParams to(String str, int i) {
        return to(new HostAndPort(str, i));
    }

    public FailoverParams to(HostAndPort hostAndPort) {
        this.to = hostAndPort;
        return this;
    }

    public FailoverParams force() {
        this.force = true;
        return this;
    }

    public FailoverParams timeout(long j) {
        this.timeout = Long.valueOf(j);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.to != null) {
            commandArguments.add(Protocol.Keyword.TO);
            commandArguments.add(this.to.getHost()).add(Protocol.toByteArray(this.to.getPort()));
        }
        if (this.force) {
            if (this.to == null || this.timeout == null) {
                throw new IllegalStateException("ERR FAILOVER with force option requires both a timeout and target HOST and IP.");
            }
            commandArguments.add(Protocol.Keyword.FORCE);
        }
        if (this.timeout != null) {
            commandArguments.add(Protocol.Keyword.TIMEOUT).add(Protocol.toByteArray(this.timeout.longValue()));
        }
    }
}
