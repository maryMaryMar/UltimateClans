package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/TopKFilterPipelineCommands.class */
public interface TopKFilterPipelineCommands {
    Response<String> topkReserve(String str, long j);

    Response<String> topkReserve(String str, long j, long j2, long j3, double d);

    Response<List<String>> topkAdd(String str, String... strArr);

    Response<List<String>> topkIncrBy(String str, Map<String, Long> map);

    Response<List<Boolean>> topkQuery(String str, String... strArr);

    Response<List<Long>> topkCount(String str, String... strArr);

    Response<List<String>> topkList(String str);

    Response<Map<String, Object>> topkInfo(String str);
}
