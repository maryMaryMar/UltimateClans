package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/LolwutParams.class */
public class LolwutParams implements IParams {
    private int version;
    private String[] args;

    public LolwutParams version(int i) {
        this.version = i;
        return this;
    }

    public LolwutParams args(String... strArr) {
        this.args = strArr;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.version != 0) {
            commandArguments.add(Integer.valueOf(this.version));
        }
        if (this.args != null) {
            commandArguments.add(this.args);
        }
    }
}
