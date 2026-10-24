package me.module.multiserver.library.redis.jedis;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/CommandObject.class */
public class CommandObject<T> {
    private final CommandArguments arguments;
    private final Builder<T> builder;

    public CommandObject(CommandArguments commandArguments, Builder<T> builder) {
        this.arguments = commandArguments;
        this.builder = builder;
    }

    public CommandArguments getArguments() {
        return this.arguments;
    }

    public Builder<T> getBuilder() {
        return this.builder;
    }
}
