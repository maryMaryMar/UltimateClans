package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SetPipelineCommands.class */
public interface SetPipelineCommands {
    Response<Long> sadd(String str, String... strArr);

    Response<Set<String>> smembers(String str);

    Response<Long> srem(String str, String... strArr);

    Response<String> spop(String str);

    Response<Set<String>> spop(String str, long j);

    Response<Long> scard(String str);

    Response<Boolean> sismember(String str, String str2);

    Response<List<Boolean>> smismember(String str, String... strArr);

    Response<String> srandmember(String str);

    Response<List<String>> srandmember(String str, int i);

    default Response<ScanResult<String>> sscan(String str, String str2) {
        return sscan(str, str2, new ScanParams());
    }

    Response<ScanResult<String>> sscan(String str, String str2, ScanParams scanParams);

    Response<Set<String>> sdiff(String... strArr);

    Response<Long> sdiffstore(String str, String... strArr);

    Response<Set<String>> sinter(String... strArr);

    Response<Long> sinterstore(String str, String... strArr);

    Response<Long> sintercard(String... strArr);

    Response<Long> sintercard(int i, String... strArr);

    Response<Set<String>> sunion(String... strArr);

    Response<Long> sunionstore(String str, String... strArr);

    Response<Long> smove(String str, String str2, String str3);
}
