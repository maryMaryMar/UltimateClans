package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/XReadGroupParams.class */
public class XReadGroupParams implements IParams {
    private Integer count = null;
    private Integer block = null;
    private boolean noack = false;

    public static XReadGroupParams xReadGroupParams() {
        return new XReadGroupParams();
    }

    public XReadGroupParams count(int i) {
        this.count = Integer.valueOf(i);
        return this;
    }

    public XReadGroupParams block(int i) {
        this.block = Integer.valueOf(i);
        return this;
    }

    public XReadGroupParams noAck() {
        this.noack = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.count != null) {
            commandArguments.add(Protocol.Keyword.COUNT);
            commandArguments.add(Protocol.toByteArray(this.count.intValue()));
        }
        if (this.block != null) {
            commandArguments.add(Protocol.Keyword.BLOCK);
            commandArguments.add(Protocol.toByteArray(this.block.intValue()));
            commandArguments.blocking();
        }
        if (this.noack) {
            commandArguments.add(Protocol.Keyword.NOACK);
        }
    }
}
