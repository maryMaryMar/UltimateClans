package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.bloom.CFInsertParams;
import me.module.multiserver.library.redis.jedis.bloom.CFReserveParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/CuckooFilterCommands.class */
public interface CuckooFilterCommands {
    String cfReserve(String str, long j);

    String cfReserve(String str, long j, CFReserveParams cFReserveParams);

    boolean cfAdd(String str, String str2);

    boolean cfAddNx(String str, String str2);

    List<Boolean> cfInsert(String str, String... strArr);

    List<Boolean> cfInsert(String str, CFInsertParams cFInsertParams, String... strArr);

    List<Boolean> cfInsertNx(String str, String... strArr);

    List<Boolean> cfInsertNx(String str, CFInsertParams cFInsertParams, String... strArr);

    boolean cfExists(String str, String str2);

    List<Boolean> cfMExists(String str, String... strArr);

    boolean cfDel(String str, String str2);

    long cfCount(String str, String str2);

    Map.Entry<Long, byte[]> cfScanDump(String str, long j);

    String cfLoadChunk(String str, long j, byte[] bArr);

    Map<String, Object> cfInfo(String str);
}
