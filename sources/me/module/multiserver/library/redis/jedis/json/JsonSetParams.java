package me.module.multiserver.library.redis.jedis.json;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.params.IParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/json/JsonSetParams.class */
public class JsonSetParams implements IParams {
    private boolean nx = false;
    private boolean xx = false;

    public static JsonSetParams jsonSetParams() {
        return new JsonSetParams();
    }

    public JsonSetParams nx() {
        this.nx = true;
        this.xx = false;
        return this;
    }

    public JsonSetParams xx() {
        this.nx = false;
        this.xx = true;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.nx) {
            commandArguments.add("NX");
        }
        if (this.xx) {
            commandArguments.add("XX");
        }
    }
}
