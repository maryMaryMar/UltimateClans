package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.params.XAddParams;
import me.module.multiserver.library.redis.jedis.params.XAutoClaimParams;
import me.module.multiserver.library.redis.jedis.params.XClaimParams;
import me.module.multiserver.library.redis.jedis.params.XPendingParams;
import me.module.multiserver.library.redis.jedis.params.XReadGroupParams;
import me.module.multiserver.library.redis.jedis.params.XReadParams;
import me.module.multiserver.library.redis.jedis.params.XTrimParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StreamBinaryCommands.class */
public interface StreamBinaryCommands {
    default byte[] xadd(byte[] bArr, Map<byte[], byte[]> map, XAddParams xAddParams) {
        return xadd(bArr, xAddParams, map);
    }

    byte[] xadd(byte[] bArr, XAddParams xAddParams, Map<byte[], byte[]> map);

    long xlen(byte[] bArr);

    List<byte[]> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    List<byte[]> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3);

    List<byte[]> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    long xack(byte[] bArr, byte[] bArr2, byte[]... bArr3);

    String xgroupCreate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z);

    String xgroupSetID(byte[] bArr, byte[] bArr2, byte[] bArr3);

    long xgroupDestroy(byte[] bArr, byte[] bArr2);

    boolean xgroupCreateConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3);

    long xgroupDelConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3);

    long xdel(byte[] bArr, byte[]... bArr2);

    long xtrim(byte[] bArr, long j, boolean z);

    long xtrim(byte[] bArr, XTrimParams xTrimParams);

    Object xpending(byte[] bArr, byte[] bArr2);

    @Deprecated
    List<Object> xpending(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5);

    List<Object> xpending(byte[] bArr, byte[] bArr2, XPendingParams xPendingParams);

    List<byte[]> xclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4);

    List<byte[]> xclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4);

    List<Object> xautoclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams);

    List<Object> xautoclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams);

    Object xinfoStream(byte[] bArr);

    Object xinfoStreamFull(byte[] bArr);

    Object xinfoStreamFull(byte[] bArr, int i);

    @Deprecated
    List<Object> xinfoGroup(byte[] bArr);

    List<Object> xinfoGroups(byte[] bArr);

    List<Object> xinfoConsumers(byte[] bArr, byte[] bArr2);

    List<byte[]> xread(XReadParams xReadParams, Map.Entry<byte[], byte[]>... entryArr);

    List<byte[]> xreadGroup(byte[] bArr, byte[] bArr2, XReadGroupParams xReadGroupParams, Map.Entry<byte[], byte[]>... entryArr);
}
