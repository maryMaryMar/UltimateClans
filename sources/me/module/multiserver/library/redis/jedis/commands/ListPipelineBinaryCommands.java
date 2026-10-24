package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.args.ListDirection;
import me.module.multiserver.library.redis.jedis.args.ListPosition;
import me.module.multiserver.library.redis.jedis.params.LPosParams;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ListPipelineBinaryCommands.class */
public interface ListPipelineBinaryCommands {
    Response<Long> rpush(byte[] bArr, byte[]... bArr2);

    Response<Long> lpush(byte[] bArr, byte[]... bArr2);

    Response<Long> llen(byte[] bArr);

    Response<List<byte[]>> lrange(byte[] bArr, long j, long j2);

    Response<String> ltrim(byte[] bArr, long j, long j2);

    Response<byte[]> lindex(byte[] bArr, long j);

    Response<String> lset(byte[] bArr, long j, byte[] bArr2);

    Response<Long> lrem(byte[] bArr, long j, byte[] bArr2);

    Response<byte[]> lpop(byte[] bArr);

    Response<List<byte[]>> lpop(byte[] bArr, int i);

    Response<Long> lpos(byte[] bArr, byte[] bArr2);

    Response<Long> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams);

    Response<List<Long>> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams, long j);

    Response<byte[]> rpop(byte[] bArr);

    Response<List<byte[]>> rpop(byte[] bArr, int i);

    Response<Long> linsert(byte[] bArr, ListPosition listPosition, byte[] bArr2, byte[] bArr3);

    Response<Long> lpushx(byte[] bArr, byte[]... bArr2);

    Response<Long> rpushx(byte[] bArr, byte[]... bArr2);

    Response<List<byte[]>> blpop(int i, byte[]... bArr);

    Response<List<byte[]>> blpop(double d, byte[]... bArr);

    Response<List<byte[]>> brpop(int i, byte[]... bArr);

    Response<List<byte[]>> brpop(double d, byte[]... bArr);

    Response<byte[]> rpoplpush(byte[] bArr, byte[] bArr2);

    Response<byte[]> brpoplpush(byte[] bArr, byte[] bArr2, int i);

    Response<byte[]> lmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2);

    Response<byte[]> blmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2, double d);

    Response<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection listDirection, byte[]... bArr);

    Response<KeyValue<byte[], List<byte[]>>> lmpop(ListDirection listDirection, int i, byte[]... bArr);

    Response<KeyValue<byte[], List<byte[]>>> blmpop(long j, ListDirection listDirection, byte[]... bArr);

    Response<KeyValue<byte[], List<byte[]>>> blmpop(long j, ListDirection listDirection, int i, byte[]... bArr);
}
