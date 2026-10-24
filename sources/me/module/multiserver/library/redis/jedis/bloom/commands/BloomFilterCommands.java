package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.bloom.BFInsertParams;
import me.module.multiserver.library.redis.jedis.bloom.BFReserveParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/BloomFilterCommands.class */
public interface BloomFilterCommands {
    String bfReserve(String str, double d, long j);

    String bfReserve(String str, double d, long j, BFReserveParams bFReserveParams);

    boolean bfAdd(String str, String str2);

    List<Boolean> bfMAdd(String str, String... strArr);

    List<Boolean> bfInsert(String str, String... strArr);

    List<Boolean> bfInsert(String str, BFInsertParams bFInsertParams, String... strArr);

    boolean bfExists(String str, String str2);

    List<Boolean> bfMExists(String str, String... strArr);

    Map.Entry<Long, byte[]> bfScanDump(String str, long j);

    String bfLoadChunk(String str, long j, byte[] bArr);

    Map<String, Object> bfInfo(String str);
}
