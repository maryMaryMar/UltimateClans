package me.module.multiserver.library.redis.jedis.resps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamConsumerFullInfo.class */
public class StreamConsumerFullInfo implements Serializable {
    public static final String NAME = "name";
    public static final String SEEN_TIME = "seen-time";
    public static final String PEL_COUNT = "pel-count";
    public static final String PENDING = "pending";
    private final String name;
    private final Long seenTime;
    private final Long pelCount;
    private final List<List<Object>> pending;
    private final Map<String, Object> consumerInfo;

    public StreamConsumerFullInfo(Map<String, Object> map) {
        this.consumerInfo = map;
        this.name = (String) map.get("name");
        this.seenTime = (Long) map.get(SEEN_TIME);
        this.pending = (List) map.get("pending");
        this.pelCount = (Long) map.get("pel-count");
        this.pending.stream().forEach(list -> {
            list.set(0, new StreamEntryID((String) list.get(0)));
        });
    }

    public String getName() {
        return this.name;
    }

    public long getSeenTime() {
        return this.seenTime.longValue();
    }

    public Long getPelCount() {
        return this.pelCount;
    }

    public List<List<Object>> getPending() {
        return this.pending;
    }

    public Map<String, Object> getConsumerInfo() {
        return this.consumerInfo;
    }
}
