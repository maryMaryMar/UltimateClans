package me.module.multiserver.library.redis.jedis.resps;

import java.io.Serializable;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamPendingSummary.class */
public class StreamPendingSummary implements Serializable {
    private static final long serialVersionUID = 1;
    private final long total;
    private final StreamEntryID minId;
    private final StreamEntryID maxId;
    private final Map<String, Long> consumerMessageCount;

    public StreamPendingSummary(long j, StreamEntryID streamEntryID, StreamEntryID streamEntryID2, Map<String, Long> map) {
        this.total = j;
        this.minId = streamEntryID;
        this.maxId = streamEntryID2;
        this.consumerMessageCount = map;
    }

    public long getTotal() {
        return this.total;
    }

    public StreamEntryID getMinId() {
        return this.minId;
    }

    public StreamEntryID getMaxId() {
        return this.maxId;
    }

    public Map<String, Long> getConsumerMessageCount() {
        return this.consumerMessageCount;
    }
}
