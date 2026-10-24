package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.BitCountOption;
import me.module.multiserver.library.redis.jedis.args.BitOP;
import me.module.multiserver.library.redis.jedis.params.BitPosParams;
import me.module.multiserver.library.redis.jedis.params.GetExParams;
import me.module.multiserver.library.redis.jedis.params.LCSParams;
import me.module.multiserver.library.redis.jedis.params.SetParams;
import me.module.multiserver.library.redis.jedis.params.StrAlgoLCSParams;
import me.module.multiserver.library.redis.jedis.resps.LCSMatchResult;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StringCommands.class */
public interface StringCommands {
    String set(String str, String str2);

    String set(String str, String str2, SetParams setParams);

    String get(String str);

    String setGet(String str, String str2, SetParams setParams);

    String getDel(String str);

    String getEx(String str, GetExParams getExParams);

    boolean setbit(String str, long j, boolean z);

    boolean getbit(String str, long j);

    long setrange(String str, long j, String str2);

    String getrange(String str, long j, long j2);

    String getSet(String str, String str2);

    long setnx(String str, String str2);

    String setex(String str, long j, String str2);

    String psetex(String str, long j, String str2);

    List<String> mget(String... strArr);

    String mset(String... strArr);

    long msetnx(String... strArr);

    long incr(String str);

    long incrBy(String str, long j);

    double incrByFloat(String str, double d);

    long decr(String str);

    long decrBy(String str, long j);

    long append(String str, String str2);

    String substr(String str, int i, int i2);

    long strlen(String str);

    long bitcount(String str);

    long bitcount(String str, long j, long j2);

    long bitcount(String str, long j, long j2, BitCountOption bitCountOption);

    long bitpos(String str, boolean z);

    long bitpos(String str, boolean z, BitPosParams bitPosParams);

    List<Long> bitfield(String str, String... strArr);

    List<Long> bitfieldReadonly(String str, String... strArr);

    long bitop(BitOP bitOP, String str, String... strArr);

    @Deprecated
    LCSMatchResult strAlgoLCSKeys(String str, String str2, StrAlgoLCSParams strAlgoLCSParams);

    LCSMatchResult lcs(String str, String str2, LCSParams lCSParams);
}
