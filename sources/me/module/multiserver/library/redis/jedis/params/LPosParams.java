package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/LPosParams.class */
public class LPosParams extends Params implements IParams {
    private static final String RANK = "RANK";
    private static final String MAXLEN = "MAXLEN";

    public static LPosParams lPosParams() {
        return new LPosParams();
    }

    public LPosParams rank(int i) {
        addParam(RANK, Integer.valueOf(i));
        return this;
    }

    public LPosParams maxlen(int i) {
        addParam(MAXLEN, Integer.valueOf(i));
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (contains(RANK)) {
            commandArguments.add(RANK);
            commandArguments.add(Protocol.toByteArray(((Integer) getParam(RANK)).intValue()));
        }
        if (contains(MAXLEN)) {
            commandArguments.add(MAXLEN);
            commandArguments.add(Protocol.toByteArray(((Integer) getParam(MAXLEN)).intValue()));
        }
    }
}
