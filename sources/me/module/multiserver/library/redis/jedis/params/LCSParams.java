package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/LCSParams.class */
public class LCSParams implements IParams {
    private Long minMatchLen;
    private boolean len = false;
    private boolean idx = false;
    private boolean withMatchLen = false;

    public static LCSParams LCSParams() {
        return new LCSParams();
    }

    public LCSParams len() {
        this.len = true;
        return this;
    }

    public LCSParams idx() {
        this.idx = true;
        return this;
    }

    public LCSParams minMatchLen(long j) {
        this.minMatchLen = Long.valueOf(j);
        return this;
    }

    public LCSParams withMatchLen() {
        this.withMatchLen = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.len) {
            commandArguments.add(Protocol.Keyword.LEN);
        }
        if (this.idx) {
            commandArguments.add(Protocol.Keyword.IDX);
        }
        if (this.minMatchLen != null) {
            commandArguments.add(Protocol.Keyword.MINMATCHLEN).add(this.minMatchLen);
        }
        if (this.withMatchLen) {
            commandArguments.add(Protocol.Keyword.WITHMATCHLEN);
        }
    }
}
