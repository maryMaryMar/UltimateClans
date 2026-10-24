package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.bloom.CFInsertParams;
import me.module.multiserver.library.redis.jedis.bloom.CFReserveParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/CuckooFilterPipelineCommands.class */
public interface CuckooFilterPipelineCommands {
    Response<String> cfReserve(String str, long j);

    Response<String> cfReserve(String str, long j, CFReserveParams cFReserveParams);

    Response<Boolean> cfAdd(String str, String str2);

    Response<Boolean> cfAddNx(String str, String str2);

    Response<List<Boolean>> cfInsert(String str, String... strArr);

    Response<List<Boolean>> cfInsert(String str, CFInsertParams cFInsertParams, String... strArr);

    Response<List<Boolean>> cfInsertNx(String str, String... strArr);

    Response<List<Boolean>> cfInsertNx(String str, CFInsertParams cFInsertParams, String... strArr);

    Response<Boolean> cfExists(String str, String str2);

    Response<Boolean> cfDel(String str, String str2);

    Response<Long> cfCount(String str, String str2);

    Response<Map.Entry<Long, byte[]>> cfScanDump(String str, long j);

    Response<String> cfLoadChunk(String str, long j, byte[] bArr);

    Response<Map<String, Object>> cfInfo(String str);
}
