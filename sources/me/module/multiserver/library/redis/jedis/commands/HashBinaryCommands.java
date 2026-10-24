package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/HashBinaryCommands.class */
public interface HashBinaryCommands {
    long hset(byte[] bArr, byte[] bArr2, byte[] bArr3);

    long hset(byte[] bArr, Map<byte[], byte[]> map);

    byte[] hget(byte[] bArr, byte[] bArr2);

    long hsetnx(byte[] bArr, byte[] bArr2, byte[] bArr3);

    String hmset(byte[] bArr, Map<byte[], byte[]> map);

    List<byte[]> hmget(byte[] bArr, byte[]... bArr2);

    long hincrBy(byte[] bArr, byte[] bArr2, long j);

    double hincrByFloat(byte[] bArr, byte[] bArr2, double d);

    boolean hexists(byte[] bArr, byte[] bArr2);

    long hdel(byte[] bArr, byte[]... bArr2);

    long hlen(byte[] bArr);

    Set<byte[]> hkeys(byte[] bArr);

    List<byte[]> hvals(byte[] bArr);

    Map<byte[], byte[]> hgetAll(byte[] bArr);

    byte[] hrandfield(byte[] bArr);

    List<byte[]> hrandfield(byte[] bArr, long j);

    Map<byte[], byte[]> hrandfieldWithValues(byte[] bArr, long j);

    default ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] bArr, byte[] bArr2) {
        return hscan(bArr, bArr2, new ScanParams());
    }

    ScanResult<Map.Entry<byte[], byte[]>> hscan(byte[] bArr, byte[] bArr2, ScanParams scanParams);

    long hstrlen(byte[] bArr, byte[] bArr2);
}
