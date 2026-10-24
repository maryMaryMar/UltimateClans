package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/SetParams.class */
public class SetParams extends Params implements IParams {
    private static final String XX = "xx";
    private static final String NX = "nx";
    private static final String PX = "px";
    private static final String EX = "ex";
    private static final String EXAT = "exat";
    private static final String PXAT = "pxat";
    private static final String KEEPTTL = "keepttl";
    private static final String GET = "get";

    public static SetParams setParams() {
        return new SetParams();
    }

    public SetParams ex(long j) {
        addParam(EX, Long.valueOf(j));
        return this;
    }

    public SetParams px(long j) {
        addParam(PX, Long.valueOf(j));
        return this;
    }

    public SetParams nx() {
        addParam(NX);
        return this;
    }

    public SetParams xx() {
        addParam(XX);
        return this;
    }

    public SetParams exAt(long j) {
        addParam(EXAT, Long.valueOf(j));
        return this;
    }

    public SetParams pxAt(long j) {
        addParam(PXAT, Long.valueOf(j));
        return this;
    }

    public SetParams keepttl() {
        addParam(KEEPTTL);
        return this;
    }

    @Deprecated
    public SetParams get() {
        addParam(GET);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (contains(NX)) {
            commandArguments.add(Protocol.Keyword.NX);
        }
        if (contains(XX)) {
            commandArguments.add(Protocol.Keyword.XX);
        }
        if (contains(EX)) {
            commandArguments.add(Protocol.Keyword.EX);
            commandArguments.add(Protocol.toByteArray(((Long) getParam(EX)).longValue()));
        }
        if (contains(PX)) {
            commandArguments.add(Protocol.Keyword.PX);
            commandArguments.add(Protocol.toByteArray(((Long) getParam(PX)).longValue()));
        }
        if (contains(EXAT)) {
            commandArguments.add(Protocol.Keyword.EXAT);
            commandArguments.add(Protocol.toByteArray(((Long) getParam(EXAT)).longValue()));
        }
        if (contains(PXAT)) {
            commandArguments.add(Protocol.Keyword.PXAT);
            commandArguments.add(Protocol.toByteArray(((Long) getParam(PXAT)).longValue()));
        }
        if (contains(KEEPTTL)) {
            commandArguments.add(Protocol.Keyword.KEEPTTL);
        }
        if (contains(GET)) {
            commandArguments.add(Protocol.Keyword.GET);
        }
    }
}
