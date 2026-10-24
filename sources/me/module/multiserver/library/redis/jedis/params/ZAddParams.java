package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ZAddParams.class */
public class ZAddParams extends Params implements IParams {
    private static final String XX = "xx";
    private static final String NX = "nx";
    private static final String CH = "ch";
    private static final String LT = "lt";
    private static final String GT = "gt";

    public static ZAddParams zAddParams() {
        return new ZAddParams();
    }

    public ZAddParams nx() {
        addParam(NX);
        return this;
    }

    public ZAddParams xx() {
        addParam(XX);
        return this;
    }

    public ZAddParams ch() {
        addParam(CH);
        return this;
    }

    public ZAddParams gt() {
        addParam(GT);
        return this;
    }

    public ZAddParams lt() {
        addParam(LT);
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (contains(NX)) {
            commandArguments.add(NX);
        }
        if (contains(XX)) {
            commandArguments.add(XX);
        }
        if (contains(CH)) {
            commandArguments.add(CH);
        }
        if (contains(LT)) {
            commandArguments.add(LT);
        }
        if (contains(GT)) {
            commandArguments.add(GT);
        }
    }
}
