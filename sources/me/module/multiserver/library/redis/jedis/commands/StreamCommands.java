package me.module.multiserver.library.redis.jedis.commands;

import java.util.List;
import java.util.Map;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/commands/StreamCommands.class */
public interface StreamCommands {
    StreamEntryID xadd(String str, StreamEntryID streamEntryID, Map<String, String> map);

    default StreamEntryID xadd(String str, Map<String, String> map, XAddParams xAddParams) {
        return xadd(str, xAddParams, map);
    }

    StreamEntryID xadd(String str, XAddParams xAddParams, Map<String, String> map);

    long xlen(String str);

    List<StreamEntry> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2);

    List<StreamEntry> xrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i);

    List<StreamEntry> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2);

    List<StreamEntry> xrevrange(String str, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i);

    List<StreamEntry> xrange(String str, String str2, String str3);

    List<StreamEntry> xrange(String str, String str2, String str3, int i);

    List<StreamEntry> xrevrange(String str, String str2, String str3);

    List<StreamEntry> xrevrange(String str, String str2, String str3, int i);

    long xack(String str, String str2, StreamEntryID... streamEntryIDArr);

    String xgroupCreate(String str, String str2, StreamEntryID streamEntryID, boolean z);

    String xgroupSetID(String str, String str2, StreamEntryID streamEntryID);

    long xgroupDestroy(String str, String str2);

    boolean xgroupCreateConsumer(String str, String str2, String str3);

    long xgroupDelConsumer(String str, String str2, String str3);

    StreamPendingSummary xpending(String str, String str2);

    @Deprecated
    List<StreamPendingEntry> xpending(String str, String str2, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, int i, String str3);

    List<StreamPendingEntry> xpending(String str, String str2, XPendingParams xPendingParams);

    long xdel(String str, StreamEntryID... streamEntryIDArr);

    long xtrim(String str, long j, boolean z);

    long xtrim(String str, XTrimParams xTrimParams);

    List<StreamEntry> xclaim(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr);

    List<StreamEntryID> xclaimJustId(String str, String str2, String str3, long j, XClaimParams xClaimParams, StreamEntryID... streamEntryIDArr);

    Map.Entry<StreamEntryID, List<StreamEntry>> xautoclaim(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams);

    Map.Entry<StreamEntryID, List<StreamEntryID>> xautoclaimJustId(String str, String str2, String str3, long j, StreamEntryID streamEntryID, XAutoClaimParams xAutoClaimParams);

    StreamInfo xinfoStream(String str);

    StreamFullInfo xinfoStreamFull(String str);

    StreamFullInfo xinfoStreamFull(String str, int i);

    @Deprecated
    List<StreamGroupInfo> xinfoGroup(String str);

    List<StreamGroupInfo> xinfoGroups(String str);

    List<StreamConsumersInfo> xinfoConsumers(String str, String str2);

    List<Map.Entry<String, List<StreamEntry>>> xread(XReadParams xReadParams, Map<String, StreamEntryID> map);

    List<Map.Entry<String, List<StreamEntry>>> xreadGroup(String str, String str2, XReadGroupParams xReadGroupParams, Map<String, StreamEntryID> map);
}
