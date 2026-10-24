package me.module.multiserver.library.redis.jedis.resps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamGroupFullInfo.class */
public class StreamGroupFullInfo implements Serializable {
    public static final String NAME = "name";
    public static final String CONSUMERS = "consumers";
    public static final String PENDING = "pending";
    public static final String LAST_DELIVERED = "last-delivered-id";
    public static final String PEL_COUNT = "pel-count";
    private final String name;
    private final List<StreamConsumerFullInfo> consumers;
    private final List<List<Object>> pending;
    private final Long pelCount;
    private final StreamEntryID lastDeliveredId;
    private final Map<String, Object> groupFullInfo;

    public StreamGroupFullInfo(Map<String, Object> map) {
        this.groupFullInfo = map;
        this.name = (String) map.get("name");
        this.consumers = (List) map.get("consumers");
        this.pending = (List) map.get("pending");
        this.lastDeliveredId = (StreamEntryID) map.get("last-delivered-id");
        this.pelCount = (Long) map.get("pel-count");
        this.pending.stream().forEach(list -> {
            list.set(0, new StreamEntryID((String) list.get(0)));
        });
    }

    public String getName() {
        return this.name;
    }

    public List<StreamConsumerFullInfo> getConsumers() {
        return this.consumers;
    }

    public List<List<Object>> getPending() {
        return this.pending;
    }

    public StreamEntryID getLastDeliveredId() {
        return this.lastDeliveredId;
    }

    public Map<String, Object> getGroupFullInfo() {
        return this.groupFullInfo;
    }

    public Long getPelCount() {
        return this.pelCount;
    }
}
