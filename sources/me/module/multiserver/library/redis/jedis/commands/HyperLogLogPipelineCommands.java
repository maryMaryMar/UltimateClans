package me.module.multiserver.library.redis.jedis.commands;

import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HyperLogLogPipelineCommands.class */
public interface HyperLogLogPipelineCommands {
    Response<Long> pfadd(String str, String... strArr);

    Response<String> pfmerge(String str, String... strArr);

    Response<Long> pfcount(String str);

    Response<Long> pfcount(String... strArr);
}
