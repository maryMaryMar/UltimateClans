package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.args.ExpiryOption;
import me.module.multiserver.library.redis.jedis.params.MigrateParams;
import me.module.multiserver.library.redis.jedis.params.RestoreParams;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.params.SortingParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/KeyBinaryCommands.class */
public interface KeyBinaryCommands {
    boolean exists(byte[] bArr);

    long exists(byte[]... bArr);

    long persist(byte[] bArr);

    String type(byte[] bArr);

    byte[] dump(byte[] bArr);

    String restore(byte[] bArr, long j, byte[] bArr2);

    String restore(byte[] bArr, long j, byte[] bArr2, RestoreParams restoreParams);

    long expire(byte[] bArr, long j);

    long expire(byte[] bArr, long j, ExpiryOption expiryOption);

    long pexpire(byte[] bArr, long j);

    long pexpire(byte[] bArr, long j, ExpiryOption expiryOption);

    long expireTime(byte[] bArr);

    long pexpireTime(byte[] bArr);

    long expireAt(byte[] bArr, long j);

    long expireAt(byte[] bArr, long j, ExpiryOption expiryOption);

    long pexpireAt(byte[] bArr, long j);

    long pexpireAt(byte[] bArr, long j, ExpiryOption expiryOption);

    long ttl(byte[] bArr);

    long pttl(byte[] bArr);

    long touch(byte[] bArr);

    long touch(byte[]... bArr);

    List<byte[]> sort(byte[] bArr);

    List<byte[]> sort(byte[] bArr, SortingParams sortingParams);

    long del(byte[] bArr);

    long del(byte[]... bArr);

    long unlink(byte[] bArr);

    long unlink(byte[]... bArr);

    boolean copy(byte[] bArr, byte[] bArr2, boolean z);

    String rename(byte[] bArr, byte[] bArr2);

    long renamenx(byte[] bArr, byte[] bArr2);

    long sort(byte[] bArr, SortingParams sortingParams, byte[] bArr2);

    long sort(byte[] bArr, byte[] bArr2);

    List<byte[]> sortReadonly(byte[] bArr, SortingParams sortingParams);

    Long memoryUsage(byte[] bArr);

    Long memoryUsage(byte[] bArr, int i);

    Long objectRefcount(byte[] bArr);

    byte[] objectEncoding(byte[] bArr);

    Long objectIdletime(byte[] bArr);

    Long objectFreq(byte[] bArr);

    String migrate(String str, int i, byte[] bArr, int i2);

    String migrate(String str, int i, int i2, MigrateParams migrateParams, byte[]... bArr);

    Set<byte[]> keys(byte[] bArr);

    ScanResult<byte[]> scan(byte[] bArr);

    ScanResult<byte[]> scan(byte[] bArr, ScanParams scanParams);

    ScanResult<byte[]> scan(byte[] bArr, ScanParams scanParams, byte[] bArr2);

    byte[] randomBinaryKey();
}
