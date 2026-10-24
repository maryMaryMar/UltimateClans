package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.SortedSetOption;
import me.module.multiserver.library.redis.jedis.params.ScanParams;
import me.module.multiserver.library.redis.jedis.params.ZAddParams;
import me.module.multiserver.library.redis.jedis.params.ZIncrByParams;
import me.module.multiserver.library.redis.jedis.params.ZParams;
import me.module.multiserver.library.redis.jedis.params.ZRangeParams;
import me.module.multiserver.library.redis.jedis.resps.KeyedZSetElement;
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SortedSetPipelineCommands.class */
public interface SortedSetPipelineCommands {
    Response<Long> zadd(String str, double d, String str2);

    Response<Long> zadd(String str, double d, String str2, ZAddParams zAddParams);

    Response<Long> zadd(String str, Map<String, Double> map);

    Response<Long> zadd(String str, Map<String, Double> map, ZAddParams zAddParams);

    Response<Double> zaddIncr(String str, double d, String str2, ZAddParams zAddParams);

    Response<Long> zrem(String str, String... strArr);

    Response<Double> zincrby(String str, double d, String str2);

    Response<Double> zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams);

    Response<Long> zrank(String str, String str2);

    Response<Long> zrevrank(String str, String str2);

    Response<List<String>> zrange(String str, long j, long j2);

    Response<List<String>> zrevrange(String str, long j, long j2);

    Response<List<Tuple>> zrangeWithScores(String str, long j, long j2);

    Response<List<Tuple>> zrevrangeWithScores(String str, long j, long j2);

    Response<String> zrandmember(String str);

    Response<List<String>> zrandmember(String str, long j);

    Response<List<Tuple>> zrandmemberWithScores(String str, long j);

    Response<Long> zcard(String str);

    Response<Double> zscore(String str, String str2);

    Response<List<Double>> zmscore(String str, String... strArr);

    Response<Tuple> zpopmax(String str);

    Response<List<Tuple>> zpopmax(String str, int i);

    Response<Tuple> zpopmin(String str);

    Response<List<Tuple>> zpopmin(String str, int i);

    Response<Long> zcount(String str, double d, double d2);

    Response<Long> zcount(String str, String str2, String str3);

    Response<List<String>> zrangeByScore(String str, double d, double d2);

    Response<List<String>> zrangeByScore(String str, String str2, String str3);

    Response<List<String>> zrevrangeByScore(String str, double d, double d2);

    Response<List<String>> zrangeByScore(String str, double d, double d2, int i, int i2);

    Response<List<String>> zrevrangeByScore(String str, String str2, String str3);

    Response<List<String>> zrangeByScore(String str, String str2, String str3, int i, int i2);

    Response<List<String>> zrevrangeByScore(String str, double d, double d2, int i, int i2);

    Response<List<Tuple>> zrangeByScoreWithScores(String str, double d, double d2);

    Response<List<Tuple>> zrevrangeByScoreWithScores(String str, double d, double d2);

    Response<List<Tuple>> zrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    Response<List<String>> zrevrangeByScore(String str, String str2, String str3, int i, int i2);

    Response<List<Tuple>> zrangeByScoreWithScores(String str, String str2, String str3);

    Response<List<Tuple>> zrevrangeByScoreWithScores(String str, String str2, String str3);

    Response<List<Tuple>> zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    Response<List<Tuple>> zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    Response<List<Tuple>> zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    Response<List<String>> zrange(String str, ZRangeParams zRangeParams);

    Response<List<Tuple>> zrangeWithScores(String str, ZRangeParams zRangeParams);

    Response<Long> zrangestore(String str, String str2, ZRangeParams zRangeParams);

    Response<Long> zremrangeByRank(String str, long j, long j2);

    Response<Long> zremrangeByScore(String str, double d, double d2);

    Response<Long> zremrangeByScore(String str, String str2, String str3);

    Response<Long> zlexcount(String str, String str2, String str3);

    Response<List<String>> zrangeByLex(String str, String str2, String str3);

    Response<List<String>> zrangeByLex(String str, String str2, String str3, int i, int i2);

    Response<List<String>> zrevrangeByLex(String str, String str2, String str3);

    Response<List<String>> zrevrangeByLex(String str, String str2, String str3, int i, int i2);

    Response<Long> zremrangeByLex(String str, String str2, String str3);

    default Response<ScanResult<Tuple>> zscan(String str, String str2) {
        return zscan(str, str2, new ScanParams());
    }

    Response<ScanResult<Tuple>> zscan(String str, String str2, ScanParams scanParams);

    Response<KeyedZSetElement> bzpopmax(double d, String... strArr);

    Response<KeyedZSetElement> bzpopmin(double d, String... strArr);

    Response<Set<String>> zdiff(String... strArr);

    Response<Set<Tuple>> zdiffWithScores(String... strArr);

    Response<Long> zdiffStore(String str, String... strArr);

    Response<Long> zinterstore(String str, String... strArr);

    Response<Long> zinterstore(String str, ZParams zParams, String... strArr);

    Response<Set<String>> zinter(ZParams zParams, String... strArr);

    Response<Set<Tuple>> zinterWithScores(ZParams zParams, String... strArr);

    Response<Long> zintercard(String... strArr);

    Response<Long> zintercard(long j, String... strArr);

    Response<Set<String>> zunion(ZParams zParams, String... strArr);

    Response<Set<Tuple>> zunionWithScores(ZParams zParams, String... strArr);

    Response<Long> zunionstore(String str, String... strArr);

    Response<Long> zunionstore(String str, ZParams zParams, String... strArr);

    Response<KeyValue<String, List<Tuple>>> zmpop(SortedSetOption sortedSetOption, String... strArr);

    Response<KeyValue<String, List<Tuple>>> zmpop(SortedSetOption sortedSetOption, int i, String... strArr);

    Response<KeyValue<String, List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, String... strArr);

    Response<KeyValue<String, List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, int i, String... strArr);
}
