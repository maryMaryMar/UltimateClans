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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/KeyPipelineBinaryCommands.class */
public interface KeyPipelineBinaryCommands {
    Response<Boolean> exists(byte[] bArr);

    Response<Long> exists(byte[]... bArr);

    Response<Long> persist(byte[] bArr);

    Response<String> type(byte[] bArr);

    Response<byte[]> dump(byte[] bArr);

    Response<String> restore(byte[] bArr, long j, byte[] bArr2);

    Response<String> restore(byte[] bArr, long j, byte[] bArr2, RestoreParams restoreParams);

    Response<Long> expire(byte[] bArr, long j);

    Response<Long> expire(byte[] bArr, long j, ExpiryOption expiryOption);

    Response<Long> pexpire(byte[] bArr, long j);

    Response<Long> pexpire(byte[] bArr, long j, ExpiryOption expiryOption);

    Response<Long> expireTime(byte[] bArr);

    Response<Long> pexpireTime(byte[] bArr);

    Response<Long> expireAt(byte[] bArr, long j);

    Response<Long> expireAt(byte[] bArr, long j, ExpiryOption expiryOption);

    Response<Long> pexpireAt(byte[] bArr, long j);

    Response<Long> pexpireAt(byte[] bArr, long j, ExpiryOption expiryOption);

    Response<Long> ttl(byte[] bArr);

    Response<Long> pttl(byte[] bArr);

    Response<Long> touch(byte[] bArr);

    Response<Long> touch(byte[]... bArr);

    Response<List<byte[]>> sort(byte[] bArr);

    Response<List<byte[]>> sort(byte[] bArr, SortingParams sortingParams);

    Response<List<byte[]>> sortReadonly(byte[] bArr, SortingParams sortingParams);

    Response<Long> del(byte[] bArr);

    Response<Long> del(byte[]... bArr);

    Response<Long> unlink(byte[] bArr);

    Response<Long> unlink(byte[]... bArr);

    Response<Boolean> copy(byte[] bArr, byte[] bArr2, boolean z);

    Response<String> rename(byte[] bArr, byte[] bArr2);

    Response<Long> renamenx(byte[] bArr, byte[] bArr2);

    Response<Long> sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2);

    Response<Long> sort(byte[] bArr, byte[] bArr2);

    Response<Long> memoryUsage(byte[] bArr);

    Response<Long> memoryUsage(byte[] bArr, int i);

    Response<Long> objectRefcount(byte[] bArr);

    Response<byte[]> objectEncoding(byte[] bArr);

    Response<Long> objectIdletime(byte[] bArr);

    Response<Long> objectFreq(byte[] bArr);

    Response<String> migrate(String str, int i, byte[] bArr, int i2);

    Response<String> migrate(String str, int i, int i2, MigrateParams migrateParams, byte[]... bArr);

    Response<Set<byte[]>> keys(byte[] bArr);

    Response<ScanResult<byte[]>> scan(byte[] bArr);

    Response<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams);

    Response<ScanResult<byte[]>> scan(byte[] bArr, ScanParams scanParams, byte[] bArr2);

    Response<byte[]> randomBinaryKey();
}
