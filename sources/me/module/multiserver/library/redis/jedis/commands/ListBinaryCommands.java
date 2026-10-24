package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import me.module.multiserver.library.redis.jedis.args.ListDirection;
import me.module.multiserver.library.redis.jedis.args.ListPosition;
import me.module.multiserver.library.redis.jedis.params.LPosParams;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/ListBinaryCommands.class */
public interface ListBinaryCommands {
    long rpush(byte[] bArr, byte[]... bArr2);

    long lpush(byte[] bArr, byte[]... bArr2);

    long llen(byte[] bArr);

    List<byte[]> lrange(byte[] bArr, long j, long j2);

    String ltrim(byte[] bArr, long j, long j2);

    byte[] lindex(byte[] bArr, long j);

    String lset(byte[] bArr, long j, byte[] bArr2);

    long lrem(byte[] bArr, long j, byte[] bArr2);

    byte[] lpop(byte[] bArr);

    List<byte[]> lpop(byte[] bArr, int i);

    Long lpos(byte[] bArr, byte[] bArr2);

    Long lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams);

    List<Long> lpos(byte[] bArr, byte[] bArr2, LPosParams lPosParams, long j);

    byte[] rpop(byte[] bArr);

    List<byte[]> rpop(byte[] bArr, int i);

    long linsert(byte[] bArr, ListPosition listPosition, byte[] bArr2, byte[] bArr3);

    long lpushx(byte[] bArr, byte[]... bArr2);

    long rpushx(byte[] bArr, byte[]... bArr2);

    List<byte[]> blpop(int i, byte[]... bArr);

    List<byte[]> blpop(double d, byte[]... bArr);

    List<byte[]> brpop(int i, byte[]... bArr);

    List<byte[]> brpop(double d, byte[]... bArr);

    byte[] rpoplpush(byte[] bArr, byte[] bArr2);

    byte[] brpoplpush(byte[] bArr, byte[] bArr2, int i);

    byte[] lmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2);

    byte[] blmove(byte[] bArr, byte[] bArr2, ListDirection listDirection, ListDirection listDirection2, double d);

    KeyValue<byte[], List<byte[]>> lmpop(ListDirection listDirection, byte[]... bArr);

    KeyValue<byte[], List<byte[]>> lmpop(ListDirection listDirection, int i, byte[]... bArr);

    KeyValue<byte[], List<byte[]>> blmpop(long j, ListDirection listDirection, byte[]... bArr);

    KeyValue<byte[], List<byte[]>> blmpop(long j, ListDirection listDirection, int i, byte[]... bArr);
}
