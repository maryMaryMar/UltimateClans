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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StringPipelineBinaryCommands.class */
public interface StringPipelineBinaryCommands {
    Response<String> set(byte[] bArr, byte[] bArr2);

    Response<String> set(byte[] bArr, byte[] bArr2, SetParams setParams);

    Response<byte[]> get(byte[] bArr);

    Response<byte[]> setGet(byte[] bArr, byte[] bArr2, SetParams setParams);

    Response<byte[]> getDel(byte[] bArr);

    Response<byte[]> getEx(byte[] bArr, GetExParams getExParams);

    Response<Boolean> setbit(byte[] bArr, long j, boolean z);

    Response<Boolean> getbit(byte[] bArr, long j);

    Response<Long> setrange(byte[] bArr, long j, byte[] bArr2);

    Response<byte[]> getrange(byte[] bArr, long j, long j2);

    Response<byte[]> getSet(byte[] bArr, byte[] bArr2);

    Response<Long> setnx(byte[] bArr, byte[] bArr2);

    Response<String> setex(byte[] bArr, long j, byte[] bArr2);

    Response<String> psetex(byte[] bArr, long j, byte[] bArr2);

    Response<List<byte[]>> mget(byte[]... bArr);

    Response<String> mset(byte[]... bArr);

    Response<Long> msetnx(byte[]... bArr);

    Response<Long> incr(byte[] bArr);

    Response<Long> incrBy(byte[] bArr, long j);

    Response<Double> incrByFloat(byte[] bArr, double d);

    Response<Long> decr(byte[] bArr);

    Response<Long> decrBy(byte[] bArr, long j);

    Response<Long> append(byte[] bArr, byte[] bArr2);

    Response<byte[]> substr(byte[] bArr, int i, int i2);

    Response<Long> strlen(byte[] bArr);

    Response<Long> bitcount(byte[] bArr);

    Response<Long> bitcount(byte[] bArr, long j, long j2);

    Response<Long> bitcount(byte[] bArr, long j, long j2, BitCountOption bitCountOption);

    Response<Long> bitpos(byte[] bArr, boolean z);

    Response<Long> bitpos(byte[] bArr, boolean z, BitPosParams bitPosParams);

    Response<List<Long>> bitfield(byte[] bArr, byte[]... bArr2);

    Response<List<Long>> bitfieldReadonly(byte[] bArr, byte[]... bArr2);

    Response<Long> bitop(BitOP bitOP, byte[] bArr, byte[]... bArr2);

    @Deprecated
    Response<LCSMatchResult> strAlgoLCSKeys(byte[] bArr, byte[] bArr2, StrAlgoLCSParams strAlgoLCSParams);

    Response<LCSMatchResult> lcs(byte[] bArr, byte[] bArr2, LCSParams lCSParams);
}
