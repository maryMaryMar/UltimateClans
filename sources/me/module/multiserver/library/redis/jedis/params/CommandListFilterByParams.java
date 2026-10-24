package me.module.multiserver.library.redis.jedis.params;

import me.module.multiserver.library.redis.jedis.CommandArguments;
import me.module.multiserver.library.redis.jedis.Protocol;
import me.module.multiserver.library.redis.jedis.exceptions.JedisDataException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/params/CommandListFilterByParams.class */
public class CommandListFilterByParams implements IParams {
    private String moduleName;
    private String category;
    private String pattern;

    public static CommandListFilterByParams commandListFilterByParams() {
        return new CommandListFilterByParams();
    }

    public CommandListFilterByParams filterByModule(String str) {
        this.moduleName = str;
        return this;
    }

    public CommandListFilterByParams filterByAclCat(String str) {
        this.category = str;
        return this;
    }

    public CommandListFilterByParams filterByPattern(String str) {
        this.pattern = str;
        return this;
    }

    @Override // me.module.multiserver.library.redis.jedis.params.IParams
    public void addParams(CommandArguments commandArguments) {
        commandArguments.add(Protocol.Keyword.FILTERBY);
        if (this.moduleName != null && this.category == null && this.pattern == null) {
            commandArguments.add(Protocol.Keyword.MODULE);
            commandArguments.add(this.moduleName);
            return;
        }
        if (this.moduleName == null && this.category != null && this.pattern == null) {
            commandArguments.add(Protocol.Keyword.ACLCAT);
            commandArguments.add(this.category);
        } else {
            if (this.moduleName != null || this.category != null || this.pattern == null) {
                throw new JedisDataException("Must choose exactly one filter");
            }
            commandArguments.add(Protocol.Keyword.PATTERN);
            commandArguments.add(this.pattern);
        }
    }
}
