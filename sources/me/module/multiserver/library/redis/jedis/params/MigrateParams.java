package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/MigrateParams.class */
public class MigrateParams implements IParams {
    private boolean copy = false;
    private boolean replace = false;
    private String username = null;
    private String passowrd = null;

    public static MigrateParams migrateParams() {
        return new MigrateParams();
    }

    public MigrateParams copy() {
        this.copy = true;
        return this;
    }

    public MigrateParams replace() {
        this.replace = true;
        return this;
    }

    public MigrateParams auth(String str) {
        this.passowrd = str;
        return this;
    }

    public MigrateParams auth2(String str, String str2) {
        this.username = str;
        this.passowrd = str2;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        if (this.copy) {
            commandArguments.add(Protocol.Keyword.COPY);
        }
        if (this.replace) {
            commandArguments.add(Protocol.Keyword.REPLACE);
        }
        if (this.username != null) {
            commandArguments.add(Protocol.Keyword.AUTH2).add(this.username).add(this.passowrd);
        } else if (this.passowrd != null) {
            commandArguments.add(Protocol.Keyword.AUTH).add(this.passowrd);
        }
    }
}
