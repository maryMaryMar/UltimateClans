package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.bloom.BFInsertParams;
import me.module.multiserver.library.redis.jedis.bloom.BFReserveParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/BloomFilterPipelineCommands.class */
public interface BloomFilterPipelineCommands {
    Response<String> bfReserve(String str, double d, long j);

    Response<String> bfReserve(String str, double d, long j, BFReserveParams bFReserveParams);

    Response<Boolean> bfAdd(String str, String str2);

    Response<List<Boolean>> bfMAdd(String str, String... strArr);

    Response<List<Boolean>> bfInsert(String str, String... strArr);

    Response<List<Boolean>> bfInsert(String str, BFInsertParams bFInsertParams, String... strArr);

    Response<Boolean> bfExists(String str, String str2);

    Response<List<Boolean>> bfMExists(String str, String... strArr);

    Response<Map.Entry<Long, byte[]>> bfScanDump(String str, long j);

    Response<String> bfLoadChunk(String str, long j, byte[] bArr);

    Response<Map<String, Object>> bfInfo(String str);
}
