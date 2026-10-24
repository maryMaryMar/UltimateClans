package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/XAutoClaimParams.class */
public class XAutoClaimParams implements IParams {
    private Integer count;

    public static XAutoClaimParams xAutoClaimParams() {
        return new XAutoClaimParams();
    }

    public XAutoClaimParams count(int i) {
        this.count = Integer.valueOf(i);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.count != null) {
            commandArguments.add(Protocol.Keyword.COUNT.getRaw()).add(this.count);
        }
    }
}
