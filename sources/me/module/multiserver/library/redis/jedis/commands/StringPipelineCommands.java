package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.BitCountOption;
import me.module.multiserver.library.redis.jedis.args.BitOP;
import me.module.multiserver.library.redis.jedis.params.BitPosParams;
import me.module.multiserver.library.redis.jedis.params.GetExParams;
import me.module.multiserver.library.redis.jedis.params.LCSParams;
import me.module.multiserver.library.redis.jedis.params.SetParams;
import me.module.multiserver.library.redis.jedis.params.StrAlgoLCSParams;
import me.module.multiserver.library.redis.jedis.resps.LCSMatchResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StringPipelineCommands.class */
public interface StringPipelineCommands {
    Response<String> set(String str, String str2);

    Response<String> set(String str, String str2, SetParams setParams);

    Response<String> get(String str);

    Response<String> setGet(String str, String str2, SetParams setParams);

    Response<String> getDel(String str);

    Response<String> getEx(String str, GetExParams getExParams);

    Response<Boolean> setbit(String str, long j, boolean z);

    Response<Boolean> getbit(String str, long j);

    Response<Long> setrange(String str, long j, String str2);

    Response<String> getrange(String str, long j, long j2);

    Response<String> getSet(String str, String str2);

    Response<Long> setnx(String str, String str2);

    Response<String> setex(String str, long j, String str2);

    Response<String> psetex(String str, long j, String str2);

    Response<List<String>> mget(String... strArr);

    Response<String> mset(String... strArr);

    Response<Long> msetnx(String... strArr);

    Response<Long> incr(String str);

    Response<Long> incrBy(String str, long j);

    Response<Double> incrByFloat(String str, double d);

    Response<Long> decr(String str);

    Response<Long> decrBy(String str, long j);

    Response<Long> append(String str, String str2);

    Response<String> substr(String str, int i, int i2);

    Response<Long> strlen(String str);

    Response<Long> bitcount(String str);

    Response<Long> bitcount(String str, long j, long j2);

    Response<Long> bitcount(String str, long j, long j2, BitCountOption bitCountOption);

    Response<Long> bitpos(String str, boolean z);

    Response<Long> bitpos(String str, boolean z, BitPosParams bitPosParams);

    Response<List<Long>> bitfield(String str, String... strArr);

    Response<List<Long>> bitfieldReadonly(String str, String... strArr);

    Response<Long> bitop(BitOP bitOP, String str, String... strArr);

    @Deprecated
    Response<LCSMatchResult> strAlgoLCSKeys(String str, String str2, StrAlgoLCSParams strAlgoLCSParams);

    Response<LCSMatchResult> lcs(String str, String str2, LCSParams lCSParams);
}
