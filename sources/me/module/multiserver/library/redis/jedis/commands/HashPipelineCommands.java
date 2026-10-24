package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HashPipelineCommands.class */
public interface HashPipelineCommands {
    Response<Long> hset(String str, String str2, String str3);

    Response<Long> hset(String str, Map<String, String> map);

    Response<String> hget(String str, String str2);

    Response<Long> hsetnx(String str, String str2, String str3);

    Response<String> hmset(String str, Map<String, String> map);

    Response<List<String>> hmget(String str, String... strArr);

    Response<Long> hincrBy(String str, String str2, long j);

    Response<Double> hincrByFloat(String str, String str2, double d);

    Response<Boolean> hexists(String str, String str2);

    Response<Long> hdel(String str, String... strArr);

    Response<Long> hlen(String str);

    Response<Set<String>> hkeys(String str);

    Response<List<String>> hvals(String str);

    Response<Map<String, String>> hgetAll(String str);

    Response<String> hrandfield(String str);

    Response<List<String>> hrandfield(String str, long j);

    Response<Map<String, String>> hrandfieldWithValues(String str, long j);

    default Response<ScanResult<Map.Entry<String, String>>> hscan(String str, String str2) {
        return hscan(str, str2, new ScanParams());
    }

    Response<ScanResult<Map.Entry<String, String>>> hscan(String str, String str2, ScanParams scanParams);

    Response<Long> hstrlen(String str, String str2);
}
