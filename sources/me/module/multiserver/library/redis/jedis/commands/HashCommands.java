package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HashCommands.class */
public interface HashCommands {
    long hset(String str, String str2, String str3);

    long hset(String str, Map<String, String> map);

    String hget(String str, String str2);

    long hsetnx(String str, String str2, String str3);

    String hmset(String str, Map<String, String> map);

    List<String> hmget(String str, String... strArr);

    long hincrBy(String str, String str2, long j);

    double hincrByFloat(String str, String str2, double d);

    boolean hexists(String str, String str2);

    long hdel(String str, String... strArr);

    long hlen(String str);

    Set<String> hkeys(String str);

    List<String> hvals(String str);

    Map<String, String> hgetAll(String str);

    String hrandfield(String str);

    List<String> hrandfield(String str, long j);

    Map<String, String> hrandfieldWithValues(String str, long j);

    default ScanResult<Map.Entry<String, String>> hscan(String str, String str2) {
        return hscan(str, str2, new ScanParams());
    }

    ScanResult<Map.Entry<String, String>> hscan(String str, String str2, ScanParams scanParams);

    long hstrlen(String str, String str2);
}
