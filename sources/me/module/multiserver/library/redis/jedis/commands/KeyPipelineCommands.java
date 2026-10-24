package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.ExpiryOption;
import me.module.multiserver.library.redis.jedis.params.MigrateParams;
import me.module.multiserver.library.redis.jedis.params.RestoreParams;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.params.SortingParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/KeyPipelineCommands.class */
public interface KeyPipelineCommands {
    Response<Boolean> exists(String str);

    Response<Long> exists(String... strArr);

    Response<Long> persist(String str);

    Response<String> type(String str);

    Response<byte[]> dump(String str);

    Response<String> restore(String str, long j, byte[] bArr);

    Response<String> restore(String str, long j, byte[] bArr, RestoreParams restoreParams);

    Response<Long> expire(String str, long j);

    Response<Long> expire(String str, long j, ExpiryOption expiryOption);

    Response<Long> pexpire(String str, long j);

    Response<Long> pexpire(String str, long j, ExpiryOption expiryOption);

    Response<Long> expireTime(String str);

    Response<Long> pexpireTime(String str);

    Response<Long> expireAt(String str, long j);

    Response<Long> expireAt(String str, long j, ExpiryOption expiryOption);

    Response<Long> pexpireAt(String str, long j);

    Response<Long> pexpireAt(String str, long j, ExpiryOption expiryOption);

    Response<Long> ttl(String str);

    Response<Long> pttl(String str);

    Response<Long> touch(String str);

    Response<Long> touch(String... strArr);

    Response<List<String>> sort(String str);

    Response<Long> sort(String str, String str2);

    Response<List<String>> sort(String str, SortingParams sortingParams);

    Response<Long> sort(String str, SortingParams sortingParams, String str2);

    Response<List<String>> sortReadonly(String str, SortingParams sortingParams);

    Response<Long> del(String str);

    Response<Long> del(String... strArr);

    Response<Long> unlink(String str);

    Response<Long> unlink(String... strArr);

    Response<Boolean> copy(String str, String str2, boolean z);

    Response<String> rename(String str, String str2);

    Response<Long> renamenx(String str, String str2);

    Response<Long> memoryUsage(String str);

    Response<Long> memoryUsage(String str, int i);

    Response<Long> objectRefcount(String str);

    Response<String> objectEncoding(String str);

    Response<Long> objectIdletime(String str);

    Response<Long> objectFreq(String str);

    Response<String> migrate(String str, int i, String str2, int i2);

    Response<String> migrate(String str, int i, int i2, MigrateParams migrateParams, String... strArr);

    Response<Set<String>> keys(String str);

    Response<ScanResult<String>> scan(String str);

    Response<ScanResult<String>> scan(String str, ScanParams scanParams);

    Response<ScanResult<String>> scan(String str, ScanParams scanParams, String str2);

    Response<String> randomKey();
}
