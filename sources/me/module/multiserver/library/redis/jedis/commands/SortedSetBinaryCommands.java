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
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SortedSetBinaryCommands.class */
public interface SortedSetBinaryCommands {
    long zadd(byte[] bArr, double d, byte[] bArr2);

    long zadd(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams);

    long zadd(byte[] bArr, Map<byte[], Double> map);

    long zadd(byte[] bArr, Map<byte[], Double> map, ZAddParams zAddParams);

    Double zaddIncr(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams);

    long zrem(byte[] bArr, byte[]... bArr2);

    double zincrby(byte[] bArr, double d, byte[] bArr2);

    Double zincrby(byte[] bArr, double d, byte[] bArr2, ZIncrByParams zIncrByParams);

    Long zrank(byte[] bArr, byte[] bArr2);

    Long zrevrank(byte[] bArr, byte[] bArr2);

    List<byte[]> zrange(byte[] bArr, long j, long j2);

    List<byte[]> zrevrange(byte[] bArr, long j, long j2);

    List<Tuple> zrangeWithScores(byte[] bArr, long j, long j2);

    List<Tuple> zrevrangeWithScores(byte[] bArr, long j, long j2);

    List<byte[]> zrange(byte[] bArr, ZRangeParams zRangeParams);

    List<Tuple> zrangeWithScores(byte[] bArr, ZRangeParams zRangeParams);

    long zrangestore(byte[] bArr, byte[] bArr2, ZRangeParams zRangeParams);

    byte[] zrandmember(byte[] bArr);

    List<byte[]> zrandmember(byte[] bArr, long j);

    List<Tuple> zrandmemberWithScores(byte[] bArr, long j);

    long zcard(byte[] bArr);

    Double zscore(byte[] bArr, byte[] bArr2);

    List<Double> zmscore(byte[] bArr, byte[]... bArr2);

    Tuple zpopmax(byte[] bArr);

    List<Tuple> zpopmax(byte[] bArr, int i);

    Tuple zpopmin(byte[] bArr);

    List<Tuple> zpopmin(byte[] bArr, int i);

    long zcount(byte[] bArr, double d, double d2);

    long zcount(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> zrangeByScore(byte[] bArr, double d, double d2);

    List<byte[]> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> zrevrangeByScore(byte[] bArr, double d, double d2);

    List<byte[]> zrangeByScore(byte[] bArr, double d, double d2, int i, int i2);

    List<byte[]> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    List<byte[]> zrevrangeByScore(byte[] bArr, double d, double d2, int i, int i2);

    List<Tuple> zrangeByScoreWithScores(byte[] bArr, double d, double d2);

    List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2);

    List<Tuple> zrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2);

    List<byte[]> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    List<Tuple> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<Tuple> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2);

    List<Tuple> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    long zremrangeByRank(byte[] bArr, long j, long j2);

    long zremrangeByScore(byte[] bArr, double d, double d2);

    long zremrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3);

    long zlexcount(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    List<byte[]> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    long zremrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3);

    default ScanResult<Tuple> zscan(byte[] bArr, byte[] bArr2) {
        return zscan(bArr, bArr2, new ScanParams());
    }

    ScanResult<Tuple> zscan(byte[] bArr, byte[] bArr2, ScanParams scanParams);

    List<byte[]> bzpopmax(double d, byte[]... bArr);

    List<byte[]> bzpopmin(double d, byte[]... bArr);

    Set<byte[]> zdiff(byte[]... bArr);

    Set<Tuple> zdiffWithScores(byte[]... bArr);

    long zdiffStore(byte[] bArr, byte[]... bArr2);

    Set<byte[]> zinter(ZParams zParams, byte[]... bArr);

    Set<Tuple> zinterWithScores(ZParams zParams, byte[]... bArr);

    long zinterstore(byte[] bArr, byte[]... bArr2);

    long zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    long zintercard(byte[]... bArr);

    long zintercard(long j, byte[]... bArr);

    Set<byte[]> zunion(ZParams zParams, byte[]... bArr);

    Set<Tuple> zunionWithScores(ZParams zParams, byte[]... bArr);

    long zunionstore(byte[] bArr, byte[]... bArr2);

    long zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    KeyValue<byte[], List<Tuple>> zmpop(SortedSetOption sortedSetOption, byte[]... bArr);

    KeyValue<byte[], List<Tuple>> zmpop(SortedSetOption sortedSetOption, int i, byte[]... bArr);

    KeyValue<byte[], List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, byte[]... bArr);

    KeyValue<byte[], List<Tuple>> bzmpop(long j, SortedSetOption sortedSetOption, int i, byte[]... bArr);
}
