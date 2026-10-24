package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import java.util.Set;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SortedSetCommands.class */
public interface SortedSetCommands {
    long zadd(String str, double d, String str2);

    long zadd(String str, double d, String str2, ZAddParams zAddParams);

    long zadd(String str, Map<String, Double> map);

    long zadd(String str, Map<String, Double> map, ZAddParams zAddParams);

    Double zaddIncr(String str, double d, String str2, ZAddParams zAddParams);

    long zrem(String str, String... strArr);

    double zincrby(String str, double d, String str2);

    Double zincrby(String str, double d, String str2, ZIncrByParams zIncrByParams);

    Long zrank(String str, String str2);

    Long zrevrank(String str, String str2);

    List<String> zrange(String str, long j, long j2);

    List<String> zrevrange(String str, long j, long j2);

    List<Tuple> zrangeWithScores(String str, long j, long j2);

    List<Tuple> zrevrangeWithScores(String str, long j, long j2);

    List<String> zrange(String str, ZRangeParams zRangeParams);

    List<Tuple> zrangeWithScores(String str, ZRangeParams zRangeParams);

    long zrangestore(String str, String str2, ZRangeParams zRangeParams);

    String zrandmember(String str);

    List<String> zrandmember(String str, long j);

    List<Tuple> zrandmemberWithScores(String str, long j);

    long zcard(String str);

    Double zscore(String str, String str2);

    List<Double> zmscore(String str, String... strArr);

    Tuple zpopmax(String str);

    List<Tuple> zpopmax(String str, int i);

    Tuple zpopmin(String str);

    List<Tuple> zpopmin(String str, int i);

    long zcount(String str, double d, double d2);

    long zcount(String str, String str2, String str3);

    List<String> zrangeByScore(String str, double d, double d2);

    List<String> zrangeByScore(String str, String str2, String str3);

    List<String> zrevrangeByScore(String str, double d, double d2);

    List<String> zrangeByScore(String str, double d, double d2, int i, int i2);

    List<String> zrevrangeByScore(String str, String str2, String str3);

    List<String> zrangeByScore(String str, String str2, String str3, int i, int i2);

    List<String> zrevrangeByScore(String str, double d, double d2, int i, int i2);

    List<Tuple> zrangeByScoreWithScores(String str, double d, double d2);

    List<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2);

    List<Tuple> zrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    List<String> zrevrangeByScore(String str, String str2, String str3, int i, int i2);

    List<Tuple> zrangeByScoreWithScores(String str, String str2, String str3);

    List<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3);

    List<Tuple> zrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    List<Tuple> zrevrangeByScoreWithScores(String str, double d, double d2, int i, int i2);

    List<Tuple> zrevrangeByScoreWithScores(String str, String str2, String str3, int i, int i2);

    long zremrangeByRank(String str, long j, long j2);

    long zremrangeByScore(String str, double d, double d2);

    long zremrangeByScore(String str, String str2, String str3);

    long zlexcount(String str, String str2, String str3);

    List<String> zrangeByLex(String str, String str2, String str3);

    List<String> zrangeByLex(String str, String str2, String str3, int i, int i2);

    List<String> zrevrangeByLex(String str, String str2, String str3);

    List<String> zrevrangeByLex(String str, String str2, String str3, int i, int i2);

    long zremrangeByLex(String str, String str2, String str3);

    default ScanResult<Tuple> zscan(String str, String str2) {
        return zscan(str, str2, new ScanParams());
    }

    ScanResult<Tuple> zscan(String str, String str2, ScanParams scanParams);

    KeyedZSetElement bzpopmax(double d, String... strArr);

    KeyedZSetElement bzpopmin(double d, String... strArr);

    Set<String> zdiff(String... strArr);

    Set<Tuple> zdiffWithScores(String... strArr);

    long zdiffStore(String str, String... strArr);

    Set<String> zinter(ZParams zParams, String... strArr);

    Set<Tuple> zinterWithScores(ZParams zParams, String... strArr);

    long zinterstore(String str, String... strArr);

    long zinterstore(String str, ZParams zParams, String... strArr);

    long zintercard(String... strArr);

    long zintercard(long j, String... strArr);

    Set<String> zunion(ZParams zParams, String... strArr);

    Set<Tuple> zunionWithScores(ZParams zParams, String... strArr);

    long zunionstore(String str, String... strArr);

    long zunionstore(String str, ZParams zParams, String... strArr);

    KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, String... strArr);

    KeyValue<String, List<Tuple>> zmpop(SortedSetOption sortedSetOption, int i, String... strArr);

    KeyValue<String, List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, String... strArr);

    KeyValue<String, List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, int i, String... strArr);
}
