package me.module.multiserver.library.redis.jedis.timeseries;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/RedisTimeSeriesCommands.class */
public interface RedisTimeSeriesCommands {
    String tsCreate(String str);

    String tsCreate(String str, TSCreateParams tSCreateParams);

    long tsDel(String str, long j, long j2);

    String tsAlter(String str, TSAlterParams tSAlterParams);

    long tsAdd(String str, double d);

    long tsAdd(String str, long j, double d);

    long tsAdd(String str, long j, double d, TSCreateParams tSCreateParams);

    List<Long> tsMAdd(Map.Entry<String, TSElement>... entryArr);

    long tsIncrBy(String str, double d);

    long tsIncrBy(String str, double d, long j);

    long tsDecrBy(String str, double d);

    long tsDecrBy(String str, double d, long j);

    List<TSElement> tsRange(String str, long j, long j2);

    List<TSElement> tsRange(String str, TSRangeParams tSRangeParams);

    List<TSElement> tsRevRange(String str, long j, long j2);

    List<TSElement> tsRevRange(String str, TSRangeParams tSRangeParams);

    List<TSKeyedElements> tsMRange(long j, long j2, String... strArr);

    List<TSKeyedElements> tsMRange(TSMRangeParams tSMRangeParams);

    List<TSKeyedElements> tsMRevRange(long j, long j2, String... strArr);

    List<TSKeyedElements> tsMRevRange(TSMRangeParams tSMRangeParams);

    TSElement tsGet(String str);

    TSElement tsGet(String str, TSGetParams tSGetParams);

    List<TSKeyValue<TSElement>> tsMGet(TSMGetParams tSMGetParams, String... strArr);

    String tsCreateRule(String str, String str2, AggregationType aggregationType, long j);

    String tsCreateRule(String str, String str2, AggregationType aggregationType, long j, long j2);

    String tsDeleteRule(String str, String str2);

    List<String> tsQueryIndex(String... strArr);

    TSInfo tsInfo(String str);

    TSInfo tsInfoDebug(String str);
}
