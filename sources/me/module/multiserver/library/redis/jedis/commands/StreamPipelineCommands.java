package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.Response;
import me.module.multiserver.library.redis.jedis.StreamEntryID;
import me.module.multiserver.library.redis.jedis.params.XAddParams;
import me.module.multiserver.library.redis.jedis.params.XAutoClaimParams;
import me.module.multiserver.library.redis.jedis.params.XClaimParams;
import me.module.multiserver.library.redis.jedis.params.XPendingParams;
import me.module.multiserver.library.redis.jedis.params.XReadGroupParams;
import me.module.multiserver.library.redis.jedis.params.XReadParams;
import me.module.multiserver.library.redis.jedis.params.XTrimParams;
import me.module.multiserver.library.redis.jedis.resps.StreamConsumersInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamFullInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamGroupInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamInfo;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingEntry;
import me.module.multiserver.library.redis.jedis.resps.StreamPendingSummary;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StreamPipelineCommands.class */
public interface StreamPipelineCommands {
    Response<StreamEntryID> xadd(String str, StreamEntryID streamEntryID, Map<String, String> map);

    default Response<StreamEntryID> xadd(String str, Map<String, String> map, XAddParams xAddParams) {
        return xadd(str, xAddParams, map);
    }

    Response<StreamEntryID> xadd(String str, XAddParams xAddParams, Map<String, String> map);

    Response<Long> xlen(String str);

    Response<List<StreamEntry>> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2);

    Response<List<StreamEntry>> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i);

    Response<List<StreamEntry>> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2);

    Response<List<StreamEntry>> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i);

    Response<List<StreamEntry>> xrange(String str, String str2, String str3);

    Response<List<StreamEntry>> xrange(String str, String str2, String str3, int i);

    Response<List<StreamEntry>> xrevrange(String str, String str2, String str3);

    Response<List<StreamEntry>> xrevrange(String str, String str2, String str3, int i);

    Response<Long> xack(String str, String str2, StreamEntryID... streamEntryIDArr);

    Response<String> xgroupCreate(String str, String str2, StreamEntryID streamEntryID, boolean z);

    Response<String> xgroupSetID(String str, String str2, StreamEntryID streamEntryID);

    Response<Long> xgroupDestroy(String str, String str2);

    Response<Boolean> xgroupCreateConsumer(String str, String str2, String str3);

    Response<Long> xgroupDelConsumer(String str, String str2, String str3);

    Response<StreamPendingSummary> xpending(String str, String str2);

    @Deprecated
    Response<List<StreamPendingEntry>> xpending(String str, String str2, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i, String str3);

    Response<List<StreamPendingEntry>> xpending(String str, String str2, XPendingParams xPendingParams);

    Response<Long> xdel(String str, StreamEntryID... streamEntryIDArr);

    Response<Long> xtrim(String str, long j, boolean z);

    Response<Long> xtrim(String str, XTrimParams xTrimParams);

    Response<List<StreamEntry>> xclaim(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr);

    Response<List<StreamEntryID>> xclaimJustId(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr);

    Response<Map.Entry<StreamEntryID, List<StreamEntry>>> xautoclaim(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams);

    Response<Map.Entry<StreamEntryID, List<StreamEntryID>>> xautoclaimJustId(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams);

    Response<StreamInfo> xinfoStream(String str);

    Response<StreamFullInfo> xinfoStreamFull(String str);

    Response<StreamFullInfo> xinfoStreamFull(String str, int i);

    @Deprecated
    Response<List<StreamGroupInfo>> xinfoGroup(String str);

    Response<List<StreamGroupInfo>> xinfoGroups(String str);

    Response<List<StreamConsumersInfo>> xinfoConsumers(String str, String str2);

    Response<List<Map.Entry<String, List<StreamEntry>>>> xread(XReadParams xReadParams, Map<String, StreamEntryID> map);

    Response<List<Map.Entry<String, List<StreamEntry>>>> xreadGroup(String str, String str2, XReadGroupParams xReadGroupParams, Map<String, StreamEntryID> map);
}
