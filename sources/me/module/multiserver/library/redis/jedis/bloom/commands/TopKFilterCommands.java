package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/TopKFilterCommands.class */
public interface TopKFilterCommands {
    String topkReserve(String str, long j);

    String topkReserve(String str, long j, long j2, long j3, double d);

    List<String> topkAdd(String str, String... strArr);

    List<String> topkIncrBy(String str, Map<String, Long> map);

    List<Boolean> topkQuery(String str, String... strArr);

    List<Long> topkCount(String str, String... strArr);

    List<String> topkList(String str);

    Map<String, Object> topkInfo(String str);
}
