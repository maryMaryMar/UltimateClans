package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.bloom.TDigestMergeParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/TDigestSketchPipelineCommands.class */
public interface TDigestSketchPipelineCommands {
    Response<String> tdigestCreate(String str);

    Response<String> tdigestCreate(String str, int i);

    Response<String> tdigestReset(String str);

    Response<String> tdigestMerge(String str, String... strArr);

    Response<String> tdigestMerge(TDigestMergeParams tDigestMergeParams, String str, String... strArr);

    Response<Map<String, Object>> tdigestInfo(String str);

    Response<String> tdigestAdd(String str, double... dArr);

    Response<List<Double>> tdigestCDF(String str, double... dArr);

    Response<List<Double>> tdigestQuantile(String str, double... dArr);

    Response<Double> tdigestMin(String str);

    Response<Double> tdigestMax(String str);

    Response<Double> tdigestTrimmedMean(String str, double d, double d2);

    Response<List<Long>> tdigestRank(String str, double... dArr);

    Response<List<Long>> tdigestRevRank(String str, double... dArr);

    Response<List<Double>> tdigestByRank(String str, long... jArr);

    Response<List<Double>> tdigestByRevRank(String str, long... jArr);
}
