package me.module.multiserver.library.redis.jedis.resps;

import java.io.Serializable;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamGroupInfo.class */
public class StreamGroupInfo implements Serializable {
    public static final String NAME = "name";
    public static final String CONSUMERS = "consumers";
    public static final String PENDING = "pending";
    public static final String LAST_DELIVERED = "last-delivered-id";
    private final String name;
    private final long consumers;
    private final long pending;
    private final StreamEntryID lastDeliveredId;
    private final Map<String, Object> groupInfo;

    public StreamGroupInfo(Map<String, Object> map) {
        this.groupInfo = map;
        this.name = (String) map.get("name");
        this.consumers = ((Long) map.get("consumers")).longValue();
        this.pending = ((Long) map.get("pending")).longValue();
        this.lastDeliveredId = (StreamEntryID) map.get("last-delivered-id");
    }

    public String getName() {
        return this.name;
    }

    public long getConsumers() {
        return this.consumers;
    }

    public long getPending() {
        return this.pending;
    }

    public StreamEntryID getLastDeliveredId() {
        return this.lastDeliveredId;
    }

    public Map<String, Object> getGroupInfo() {
        return this.groupInfo;
    }
}
