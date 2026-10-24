package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HashPipelineBinaryCommands.class */
public interface HashPipelineBinaryCommands {
    Response<Long> hset(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<Long> hset(byte[] bArr, Map<byte[], byte[]> map);

    Response<byte[]> hget(byte[] bArr, byte[] bArr2);

    Response<Long> hsetnx(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<String> hmset(byte[] bArr, Map<byte[], byte[]> map);

    Response<List<byte[]>> hmget(byte[] bArr, byte[]... bArr2);

    Response<Long> hincrBy(byte[] bArr, byte[] bArr2, long j);

    Response<Double> hincrByFloat(byte[] bArr, byte[] bArr2, double d);

    Response<Boolean> hexists(byte[] bArr, byte[] bArr2);

    Response<Long> hdel(byte[] bArr, byte[]... bArr2);

    Response<Long> hlen(byte[] bArr);

    Response<Set<byte[]>> hkeys(byte[] bArr);

    Response<List<byte[]>> hvals(byte[] bArr);

    Response<Map<byte[], byte[]>> hgetAll(byte[] bArr);

    Response<byte[]> hrandfield(byte[] bArr);

    Response<List<byte[]>> hrandfield(byte[] bArr, long j);

    Response<Map<byte[], byte[]>> hrandfieldWithValues(byte[] bArr, long j);

    default Response<ScanResult<Map.Entry<byte[], byte[]>>> hscan(byte[] bArr, byte[] bArr2) {
        return hscan(bArr, bArr2, new ScanParams());
    }

    Response<ScanResult<Map.Entry<byte[], byte[]>>> hscan(byte[] bArr, byte[] bArr2, ScanParams scanParams);

    Response<Long> hstrlen(byte[] bArr, byte[] bArr2);
}
