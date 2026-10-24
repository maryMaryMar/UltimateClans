package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/GetExParams.class */
public class GetExParams extends Params implements IParams {
    private static final String PX = "px";
    private static final String EX = "ex";
    private static final String EXAT = "exat";
    private static final String PXAT = "pxat";
    private static final String PERSIST = "persist";

    public static GetExParams getExParams() {
        return new GetExParams();
    }

    public GetExParams ex(long j) {
        addParam(EX, Long.valueOf(j));
        return this;
    }

    public GetExParams px(long j) {
        addParam(PX, Long.valueOf(j));
        return this;
    }

    public GetExParams exAt(long j) {
        addParam(EXAT, Long.valueOf(j));
        return this;
    }

    public GetExParams pxAt(long j) {
        addParam(PXAT, Long.valueOf(j));
        return this;
    }

    public GetExParams persist() {
        addParam(PERSIST);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (contains(EX)) {
            commandArguments.add(SafeEncoder.encode(EX));
            commandArguments.add(Protocol.toByteArray(((Long) getParam(EX)).longValue()));
            return;
        }
        if (contains(PX)) {
            commandArguments.add(SafeEncoder.encode(PX));
            commandArguments.add(Protocol.toByteArray(((Long) getParam(PX)).longValue()));
            return;
        }
        if (contains(EXAT)) {
            commandArguments.add(SafeEncoder.encode(EXAT));
            commandArguments.add(Protocol.toByteArray(((Long) getParam(EXAT)).longValue()));
        } else if (contains(PXAT)) {
            commandArguments.add(SafeEncoder.encode(PXAT));
            commandArguments.add(Protocol.toByteArray(((Long) getParam(PXAT)).longValue()));
        } else if (contains(PERSIST)) {
            commandArguments.add(SafeEncoder.encode(PERSIST));
        }
    }
}
