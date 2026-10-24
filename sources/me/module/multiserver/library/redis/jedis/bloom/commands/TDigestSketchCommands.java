package me.module.multiserver.library.redis.jedis.bloom.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.bloom.TDigestMergeParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/bloom/commands/TDigestSketchCommands.class */
public interface TDigestSketchCommands {
    String tdigestCreate(String str);

    String tdigestCreate(String str, int i);

    String tdigestReset(String str);

    String tdigestMerge(String str, String... strArr);

    String tdigestMerge(TDigestMergeParams tDigestMergeParams, String str, String... strArr);

    Map<String, Object> tdigestInfo(String str);

    String tdigestAdd(String str, double... dArr);

    List<Double> tdigestCDF(String str, double... dArr);

    List<Double> tdigestQuantile(String str, double... dArr);

    double tdigestMin(String str);

    double tdigestMax(String str);

    double tdigestTrimmedMean(String str, double d, double d2);

    List<Long> tdigestRank(String str, double... dArr);

    List<Long> tdigestRevRank(String str, double... dArr);

    List<Double> tdigestByRank(String str, long... jArr);

    List<Double> tdigestByRevRank(String str, long... jArr);
}
