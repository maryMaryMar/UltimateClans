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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StringBinaryCommands.class */
public interface StringBinaryCommands {
    String set(byte[] bArr, byte[] bArr2);

    String set(byte[] bArr, byte[] bArr2, SetParams setParams);

    byte[] get(byte[] bArr);

    byte[] setGet(byte[] bArr, byte[] bArr2, SetParams setParams);

    byte[] getDel(byte[] bArr);

    byte[] getEx(byte[] bArr, GetExParams getExParams);

    boolean setbit(byte[] bArr, long j, boolean z);

    boolean getbit(byte[] bArr, long j);

    long setrange(byte[] bArr, long j, byte[] bArr2);

    byte[] getrange(byte[] bArr, long j, long j2);

    byte[] getSet(byte[] bArr, byte[] bArr2);

    long setnx(byte[] bArr, byte[] bArr2);

    String setex(byte[] bArr, long j, byte[] bArr2);

    String psetex(byte[] bArr, long j, byte[] bArr2);

    List<byte[]> mget(byte[]... bArr);

    String mset(byte[]... bArr);

    long msetnx(byte[]... bArr);

    long incr(byte[] bArr);

    long incrBy(byte[] bArr, long j);

    double incrByFloat(byte[] bArr, double d);

    long decr(byte[] bArr);

    long decrBy(byte[] bArr, long j);

    long append(byte[] bArr, byte[] bArr2);

    byte[] substr(byte[] bArr, int i, int i2);

    long strlen(byte[] bArr);

    long bitcount(byte[] bArr);

    long bitcount(byte[] bArr, long j, long j2);

    long bitcount(byte[] bArr, long j, long j2, BitCountOption bitCountOption);

    long bitpos(byte[] bArr, boolean z);

    long bitpos(byte[] bArr, boolean z, BitPosParams bitPosParams);

    List<Long> bitfield(byte[] bArr, byte[]... bArr2);

    List<Long> bitfieldReadonly(byte[] bArr, byte[]... bArr2);

    long bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2);

    @Deprecated
    LCSMatchResult strAlgoLCSKeys(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams);

    LCSMatchResult lcs(byte[] bArr, byte[] bArr2, LCSParams lCSParams);
}
