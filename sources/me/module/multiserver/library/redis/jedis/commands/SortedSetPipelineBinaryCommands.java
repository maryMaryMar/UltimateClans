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
import me.module.multiserver.library.redis.jedis.resps.ScanResult;
import me.module.multiserver.library.redis.jedis.resps.Tuple;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/SortedSetPipelineBinaryCommands.class */
public interface SortedSetPipelineBinaryCommands {
    Response<Long> zadd(byte[] bArr, double d, byte[] bArr2);

    Response<Long> zadd(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams);

    Response<Long> zadd(byte[] bArr, Map<byte[], Double> map);

    Response<Long> zadd(byte[] bArr, Map<byte[], Double> map, ZAddParams zAddParams);

    Response<Double> zaddIncr(byte[] bArr, double d, byte[] bArr2, ZAddParams zAddParams);

    Response<Long> zrem(byte[] bArr, byte[]... bArr2);

    Response<Double> zincrby(byte[] bArr, double d, byte[] bArr2);

    Response<Double> zincrby(byte[] bArr, double d, byte[] bArr2, ZIncrByParams zIncrByParams);

    Response<Long> zrank(byte[] bArr, byte[] bArr2);

    Response<Long> zrevrank(byte[] bArr, byte[] bArr2);

    Response<List<byte[]>> zrange(byte[] bArr, long j, long j2);

    Response<List<byte[]>> zrevrange(byte[] bArr, long j, long j2);

    Response<List<Tuple>> zrangeWithScores(byte[] bArr, long j, long j2);

    Response<List<Tuple>> zrevrangeWithScores(byte[] bArr, long j, long j2);

    Response<byte[]> zrandmember(byte[] bArr);

    Response<List<byte[]>> zrandmember(byte[] bArr, long j);

    Response<List<Tuple>> zrandmemberWithScores(byte[] bArr, long j);

    Response<Long> zcard(byte[] bArr);

    Response<Double> zscore(byte[] bArr, byte[] bArr2);

    Response<List<Double>> zmscore(byte[] bArr, byte[]... bArr2);

    Response<Tuple> zpopmax(byte[] bArr);

    Response<List<Tuple>> zpopmax(byte[] bArr, int i);

    Response<Tuple> zpopmin(byte[] bArr);

    Response<List<Tuple>> zpopmin(byte[] bArr, int i);

    Response<Long> zcount(byte[] bArr, double d, double d2);

    Response<Long> zcount(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> zrangeByScore(byte[] bArr, double d, double d2);

    Response<List<byte[]>> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> zrevrangeByScore(byte[] bArr, double d, double d2);

    Response<List<byte[]>> zrangeByScore(byte[] bArr, double d, double d2, int i, int i2);

    Response<List<byte[]>> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> zrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    Response<List<byte[]>> zrevrangeByScore(byte[] bArr, double d, double d2, int i, int i2);

    Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, double d, double d2);

    Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2);

    Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2);

    Response<List<byte[]>> zrevrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<Tuple>> zrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, double d, double d2, int i, int i2);

    Response<List<Tuple>> zrevrangeByScoreWithScores(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    Response<Long> zremrangeByRank(byte[] bArr, long j, long j2);

    Response<Long> zremrangeByScore(byte[] bArr, double d, double d2);

    Response<Long> zremrangeByScore(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<Long> zlexcount(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> zrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    Response<List<byte[]>> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> zrevrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2);

    Response<List<byte[]>> zrange(byte[] bArr, ZRangeParams zRangeParams);

    Response<List<Tuple>> zrangeWithScores(byte[] bArr, ZRangeParams zRangeParams);

    Response<Long> zrangestore(byte[] bArr, byte[] bArr2, ZRangeParams zRangeParams);

    Response<Long> zremrangeByLex(byte[] bArr, byte[] bArr2, byte[] bArr3);

    default Response<ScanResult<Tuple>> zscan(byte[] bArr, byte[] bArr2) {
        return zscan(bArr, bArr2, new ScanParams());
    }

    Response<ScanResult<Tuple>> zscan(byte[] bArr, byte[] bArr2, ScanParams scanParams);

    Response<List<byte[]>> bzpopmax(double d, byte[]... bArr);

    Response<List<byte[]>> bzpopmin(double d, byte[]... bArr);

    Response<Set<byte[]>> zdiff(byte[]... bArr);

    Response<Set<Tuple>> zdiffWithScores(byte[]... bArr);

    Response<Long> zdiffStore(byte[] bArr, byte[]... bArr2);

    Response<Set<byte[]>> zinter(ZParams zParams, byte[]... bArr);

    Response<Set<Tuple>> zinterWithScores(ZParams zParams, byte[]... bArr);

    Response<Long> zinterstore(byte[] bArr, byte[]... bArr2);

    Response<Long> zinterstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    Response<Long> zintercard(byte[]... bArr);

    Response<Long> zintercard(long j, byte[]... bArr);

    Response<Set<byte[]>> zunion(ZParams zParams, byte[]... bArr);

    Response<Set<Tuple>> zunionWithScores(ZParams zParams, byte[]... bArr);

    Response<Long> zunionstore(byte[] bArr, byte[]... bArr2);

    Response<Long> zunionstore(byte[] bArr, ZParams zParams, byte[]... bArr2);

    Response<KeyValue<byte[], List<Tuple>>> zmpop(SortedSetOption sortedSetOption, byte[]... bArr);

    Response<KeyValue<byte[], List<Tuple>>> zmpop(SortedSetOption sortedSetOption, int i, byte[]... bArr);

    Response<KeyValue<byte[], List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, byte[]... bArr);

    Response<KeyValue<byte[], List<Tuple>>> bzmpop(long j, SortedSetOption sortedSetOption, int i, byte[]... bArr);
}
