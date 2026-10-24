package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SetPipelineBinaryCommands.class */
public interface SetPipelineBinaryCommands {
    Response<Long> sadd(byte[] bArr, byte[]... bArr2);

    Response<Set<byte[]>> smembers(byte[] bArr);

    Response<Long> srem(byte[] bArr, byte[]... bArr2);

    Response<byte[]> spop(byte[] bArr);

    Response<Set<byte[]>> spop(byte[] bArr, long j);

    Response<Long> scard(byte[] bArr);

    Response<Boolean> sismember(byte[] bArr, byte[] bArr2);

    Response<List<Boolean>> smismember(byte[] bArr, byte[]... bArr2);

    Response<byte[]> srandmember(byte[] bArr);

    Response<List<byte[]>> srandmember(byte[] bArr, int i);

    default Response<ScanResult<byte[]>> sscan(byte[] bArr, byte[] bArr2) {
        return sscan(bArr, bArr2, new ScanParams());
    }

    Response<ScanResult<byte[]>> sscan(byte[] bArr, byte[] bArr2, ScanParams scanParams);

    Response<Set<byte[]>> sdiff(byte[]... bArr);

    Response<Long> sdiffstore(byte[] bArr, byte[]... bArr2);

    Response<Set<byte[]>> sinter(byte[]... bArr);

    Response<Long> sinterstore(byte[] bArr, byte[]... bArr2);

    Response<Long> sintercard(byte[]... bArr);

    Response<Long> sintercard(int i, byte[]... bArr);

    Response<Set<byte[]>> sunion(byte[]... bArr);

    Response<Long> sunionstore(byte[] bArr, byte[]... bArr2);

    Response<Long> smove(byte[] bArr, byte[] bArr2, byte[] bArr3);
}
