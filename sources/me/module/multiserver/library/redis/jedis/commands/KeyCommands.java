package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.args.ExpiryOption;
import me.module.multiserver.library.redis.jedis.params.MigrateParams;
import me.module.multiserver.library.redis.jedis.params.RestoreParams;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.params.SortingParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/KeyCommands.class */
public interface KeyCommands {
    boolean exists(String str);

    long exists(String... strArr);

    long persist(String str);

    String type(String str);

    byte[] dump(String str);

    String restore(String str, long j, byte[] bArr);

    String restore(String str, long j, byte[] bArr, RestoreParams restoreParams);

    long expire(String str, long j);

    long expire(String str, long j, ExpiryOption expiryOption);

    long pexpire(String str, long j);

    long pexpire(String str, long j, ExpiryOption expiryOption);

    long expireTime(String str);

    long pexpireTime(String str);

    long expireAt(String str, long j);

    long expireAt(String str, long j, ExpiryOption expiryOption);

    long pexpireAt(String str, long j);

    long pexpireAt(String str, long j, ExpiryOption expiryOption);

    long ttl(String str);

    long pttl(String str);

    long touch(String str);

    long touch(String... strArr);

    List<String> sort(String str);

    long sort(String str, String str2);

    List<String> sort(String str, SortingParams sortingParams);

    long sort(String str, SortingParams sortingParams, String str2);

    List<String> sortReadonly(String str, SortingParams sortingParams);

    long del(String str);

    long del(String... strArr);

    long unlink(String str);

    long unlink(String... strArr);

    boolean copy(String str, String str2, boolean z);

    String rename(String str, String str2);

    long renamenx(String str, String str2);

    Long memoryUsage(String str);

    Long memoryUsage(String str, int i);

    Long objectRefcount(String str);

    String objectEncoding(String str);

    Long objectIdletime(String str);

    Long objectFreq(String str);

    String migrate(String str, int i, String str2, int i2);

    String migrate(String str, int i, int i2, MigrateParams migrateParams, String... strArr);

    Set<String> keys(String str);

    ScanResult<String> scan(String str);

    ScanResult<String> scan(String str, ScanParams scanParams);

    ScanResult<String> scan(String str, ScanParams scanParams, String str2);

    String randomKey();
}
