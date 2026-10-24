package me.module.multiserver.library.redis.jedis.resps;

import java.io.Serializable;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamInfo.class */
public class StreamInfo implements Serializable {
    public static final String LENGTH = "length";
    public static final String RADIX_TREE_KEYS = "radix-tree-keys";
    public static final String RADIX_TREE_NODES = "radix-tree-nodes";
    public static final String GROUPS = "groups";
    public static final String LAST_GENERATED_ID = "last-generated-id";
    public static final String FIRST_ENTRY = "first-entry";
    public static final String LAST_ENTRY = "last-entry";
    private final long length;
    private final long radixTreeKeys;
    private final long radixTreeNodes;
    private final long groups;
    private final StreamEntryID lastGeneratedId;
    private final StreamEntry firstEntry;
    private final StreamEntry lastEntry;
    private final Map<String, Object> streamInfo;

    public StreamInfo(Map<String, Object> map) {
        this.streamInfo = map;
        this.length = ((Long) map.get("length")).longValue();
        this.radixTreeKeys = ((Long) map.get("radix-tree-keys")).longValue();
        this.radixTreeNodes = ((Long) map.get("radix-tree-nodes")).longValue();
        this.groups = ((Long) map.get("groups")).longValue();
        this.lastGeneratedId = (StreamEntryID) map.get("last-generated-id");
        this.firstEntry = (StreamEntry) map.get(FIRST_ENTRY);
        this.lastEntry = (StreamEntry) map.get(LAST_ENTRY);
    }

    public long getLength() {
        return this.length;
    }

    public long getRadixTreeKeys() {
        return this.radixTreeKeys;
    }

    public long getRadixTreeNodes() {
        return this.radixTreeNodes;
    }

    public long getGroups() {
        return this.groups;
    }

    public StreamEntryID getLastGeneratedId() {
        return this.lastGeneratedId;
    }

    public StreamEntry getFirstEntry() {
        return this.firstEntry;
    }

    public StreamEntry getLastEntry() {
        return this.lastEntry;
    }

    public Map<String, Object> getStreamInfo() {
        return this.streamInfo;
    }
}
