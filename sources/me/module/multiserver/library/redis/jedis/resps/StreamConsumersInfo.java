package me.module.multiserver.library.redis.jedis.resps;

import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamConsumersInfo.class */
public class StreamConsumersInfo {
    public static final String NAME = "name";
    public static final String IDLE = "idle";
    public static final String PENDING = "pending";
    private final String name;
    private final long idle;
    private final long pending;
    private final Map<String, Object> consumerInfo;

    public StreamConsumersInfo(Map<String, Object> map) {
        this.consumerInfo = map;
        this.name = (String) map.get("name");
        this.idle = ((Long) map.get(IDLE)).longValue();
        this.pending = ((Long) map.get("pending")).longValue();
    }

    public String getName() {
        return this.name;
    }

    public long getIdle() {
        return this.idle;
    }

    public long getPending() {
        return this.pending;
    }

    public Map<String, Object> getConsumerInfo() {
        return this.consumerInfo;
    }
}
