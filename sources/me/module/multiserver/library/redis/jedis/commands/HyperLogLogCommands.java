package me.module.multiserver.library.redis.jedis.commands;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HyperLogLogCommands.class */
public interface HyperLogLogCommands {
    long pfadd(String str, String... strArr);

    String pfmerge(String str, String... strArr);

    long pfcount(String str);

    long pfcount(String... strArr);
}
