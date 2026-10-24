package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SetBinaryCommands.class */
public interface SetBinaryCommands {
    long sadd(byte[] bArr, byte[]... bArr2);

    Set<byte[]> smembers(byte[] bArr);

    long srem(byte[] bArr, byte[]... bArr2);

    byte[] spop(byte[] bArr);

    Set<byte[]> spop(byte[] bArr, long j);

    long scard(byte[] bArr);

    boolean sismember(byte[] bArr, byte[] bArr2);

    List<Boolean> smismember(byte[] bArr, byte[]... bArr2);

    byte[] srandmember(byte[] bArr);

    List<byte[]> srandmember(byte[] bArr, int i);

    default ScanResult<byte[]> sscan(byte[] bArr, byte[] bArr2) {
        return sscan(bArr, bArr2, new ScanParams());
    }

    ScanResult<byte[]> sscan(byte[] bArr, byte[] bArr2, ScanParams scanParams);

    Set<byte[]> sdiff(byte[]... bArr);

    long sdiffstore(byte[] bArr, byte[]... bArr2);

    Set<byte[]> sinter(byte[]... bArr);

    long sinterstore(byte[] bArr, byte[]... bArr2);

    long sintercard(byte[]... bArr);

    long sintercard(int i, byte[]... bArr);

    Set<byte[]> sunion(byte[]... bArr);

    long sunionstore(byte[] bArr, byte[]... bArr2);

    long smove(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
