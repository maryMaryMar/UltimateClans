package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/ZIncrByParams.class */
public class ZIncrByParams extends Params implements IParams {
    private static final String XX = "xx";
    private static final String NX = "nx";
    private static final String INCR = "incr";

    public static ZIncrByParams zIncrByParams() {
        return new ZIncrByParams();
    }

    public ZIncrByParams nx() {
        addParam(NX);
        return this;
    }

    public ZIncrByParams xx() {
        addParam(XX);
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
        commandArguments.add(INCR);
    }
}
