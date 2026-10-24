package me.module.multiserver.library.redis.jedis.timeseries;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/RedisTimeSeriesPipelineCommands.class */
public interface RedisTimeSeriesPipelineCommands {
    Response<String> tsCreate(String str);

    Response<String> tsCreate(String str, TSCreateParams tSCreateParams);

    Response<Long> tsDel(String str, long j, long j2);

    Response<String> tsAlter(String str, TSAlterParams tSAlterParams);

    Response<Long> tsAdd(String str, double d);

    Response<Long> tsAdd(String str, long j, double d);

    Response<Long> tsAdd(String str, long j, double d, TSCreateParams tSCreateParams);

    Response<List<Long>> tsMAdd(Map.Entry<String, TSElement>... entryArr);

    Response<Long> tsIncrBy(String str, double d);

    Response<Long> tsIncrBy(String str, double d, long j);

    Response<Long> tsDecrBy(String str, double d);

    Response<Long> tsDecrBy(String str, double d, long j);

    Response<List<TSElement>> tsRange(String str, long j, long j2);

    Response<List<TSElement>> tsRange(String str, TSRangeParams tSRangeParams);

    Response<List<TSElement>> tsRevRange(String str, long j, long j2);

    Response<List<TSElement>> tsRevRange(String str, TSRangeParams tSRangeParams);

    Response<List<TSKeyedElements>> tsMRange(long j, long j2, String... strArr);

    Response<List<TSKeyedElements>> tsMRange(TSMRangeParams tSMRangeParams);

    Response<List<TSKeyedElements>> tsMRevRange(long j, long j2, String... strArr);

    Response<List<TSKeyedElements>> tsMRevRange(TSMRangeParams tSMRangeParams);

    Response<TSElement> tsGet(String str);

    Response<TSElement> tsGet(String str, TSGetParams tSGetParams);

    Response<List<TSKeyValue<TSElement>>> tsMGet(TSMGetParams tSMGetParams, String... strArr);

    Response<String> tsCreateRule(String str, String str2, AggregationType aggregationType, long j);

    Response<String> tsCreateRule(String str, String str2, AggregationType aggregationType, long j, long j2);

    Response<String> tsDeleteRule(String str, String str2);

    Response<List<String>> tsQueryIndex(String... strArr);
}
