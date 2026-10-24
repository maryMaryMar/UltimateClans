package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.params.XAddParams;
import me.module.multiserver.library.redis.jedis.params.XAutoClaimParams;
import me.module.multiserver.library.redis.jedis.params.XClaimParams;
import me.module.multiserver.library.redis.jedis.params.XPendingParams;
import me.module.multiserver.library.redis.jedis.params.XReadGroupParams;
import me.module.multiserver.library.redis.jedis.params.XReadParams;
import me.module.multiserver.library.redis.jedis.params.XTrimParams;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StreamPipelineBinaryCommands.class */
public interface StreamPipelineBinaryCommands {
    default Response<byte[]> xadd(byte[] bArr, Map<byte[], byte[]> map, XAddParams xAddParams) {
        return xadd(bArr, xAddParams, map);
    }

    Response<byte[]> xadd(byte[] bArr, XAddParams xAddParams, Map<byte[], byte[]> map);

    Response<Long> xlen(byte[] bArr);

    Response<List<byte[]>> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> xrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    Response<List<byte[]>> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<List<byte[]>> xrevrange(byte[] bArr, byte[] bArr2, byte[] bArr3, int i);

    Response<Long> xack(byte[] bArr, byte[] bArr2, byte[]... bArr3);

    Response<String> xgroupCreate(byte[] bArr, byte[] bArr2, byte[] bArr3, boolean z);

    Response<String> xgroupSetID(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<Long> xgroupDestroy(byte[] bArr, byte[] bArr2);

    Response<Boolean> xgroupCreateConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<Long> xgroupDelConsumer(byte[] bArr, byte[] bArr2, byte[] bArr3);

    Response<Long> xdel(byte[] bArr, byte[]... bArr2);

    Response<Long> xtrim(byte[] bArr, long j, boolean z);

    Response<Long> xtrim(byte[] bArr, XTrimParams xTrimParams);

    Response<Object> xpending(byte[] bArr, byte[] bArr2);

    @Deprecated
    Response<List<Object>> xpending(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, byte[] bArr5);

    Response<List<Object>> xpending(byte[] bArr, byte[] bArr2, XPendingParams xPendingParams);

    Response<List<byte[]>> xclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4);

    Response<List<byte[]>> xclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, XClaimParams xClaimParams, byte[]... bArr4);

    Response<List<Object>> xautoclaim(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams);

    Response<List<Object>> xautoclaimJustId(byte[] bArr, byte[] bArr2, byte[] bArr3, long j, byte[] bArr4, XAutoClaimParams xAutoClaimParams);

    Response<Object> xinfoStream(byte[] bArr);

    Response<Object> xinfoStreamFull(byte[] bArr);

    Response<Object> xinfoStreamFull(byte[] bArr, int i);

    @Deprecated
    Response<List<Object>> xinfoGroup(byte[] bArr);

    Response<List<Object>> xinfoGroups(byte[] bArr);

    Response<List<Object>> xinfoConsumers(byte[] bArr, byte[] bArr2);

    Response<List<byte[]>> xread(XReadParams xReadParams, Map.Entry<byte[], byte[]>... entryArr);

    Response<List<byte[]>> xreadGroup(byte[] bArr, byte[] bArr2, XReadGroupParams xReadGroupParams, Map.Entry<byte[], byte[]>... entryArr);
}
