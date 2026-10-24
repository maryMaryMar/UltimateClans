package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/StrAlgoLCSParams.class */
public class StrAlgoLCSParams extends Params implements IParams {
    private static final String IDX = "idx";
    private static final String LEN = "len";
    private static final String WITHMATCHLEN = "withmatchlen";
    private static final String MINMATCHLEN = "minmatchlen";

    public static StrAlgoLCSParams StrAlgoLCSParams() {
        return new StrAlgoLCSParams();
    }

    public StrAlgoLCSParams idx() {
        addParam(IDX);
        return this;
    }

    public StrAlgoLCSParams len() {
        addParam(LEN);
        return this;
    }

    public StrAlgoLCSParams withMatchLen() {
        addParam(WITHMATCHLEN);
        return this;
    }

    public StrAlgoLCSParams minMatchLen(long j) {
        addParam(MINMATCHLEN, Long.valueOf(j));
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (contains(IDX)) {
            commandArguments.add(IDX);
        }
        if (contains(LEN)) {
            commandArguments.add(LEN);
        }
        if (contains(WITHMATCHLEN)) {
            commandArguments.add(WITHMATCHLEN);
        }
        if (contains(MINMATCHLEN)) {
            commandArguments.add(MINMATCHLEN);
            commandArguments.add(Protocol.toByteArray(((Long) getParam(MINMATCHLEN)).longValue()));
        }
    }
}
