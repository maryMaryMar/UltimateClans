package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SetCommands.class */
public interface SetCommands {
    long sadd(String str, String... strArr);

    Set<String> smembers(String str);

    long srem(String str, String... strArr);

    String spop(String str);

    Set<String> spop(String str, long j);

    long scard(String str);

    boolean sismember(String str, String str2);

    List<Boolean> smismember(String str, String... strArr);

    String srandmember(String str);

    List<String> srandmember(String str, int i);

    default ScanResult<String> sscan(String str, String str2) {
        return sscan(str, str2, new ScanParams());
    }

    ScanResult<String> sscan(String str, String str2, ScanParams scanParams);

    Set<String> sdiff(String... strArr);

    long sdiffstore(String str, String... strArr);

    Set<String> sinter(String... strArr);

    long sinterstore(String str, String... strArr);

    long sintercard(String... strArr);

    long sintercard(int i, String... strArr);

    Set<String> sunion(String... strArr);

    long sunionstore(String str, String... strArr);

    long smove(String str, String str2, String str3);
}
