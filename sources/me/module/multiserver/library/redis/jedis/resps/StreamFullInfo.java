package me.module.multiserver.library.redis.jedis.resps;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.StreamEntryID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/resps/StreamFullInfo.class */
public class StreamFullInfo implements Serializable {
    public static final String LENGTH = "length";
    public static final String RADIX_TREE_KEYS = "radix-tree-keys";
    public static final String RADIX_TREE_NODES = "radix-tree-nodes";
    public static final String GROUPS = "groups";
    public static final String LAST_GENERATED_ID = "last-generated-id";
    public static final String ENTRIES = "entries";
    private final long length;
    private final long radixTreeKeys;
    private final long radixTreeNodes;
    private final List<StreamGroupFullInfo> groups;
    private final StreamEntryID lastGeneratedId;
    private final List<StreamEntry> entries;
    private final Map<String, Object> streamFullInfo;

    public StreamFullInfo(Map<String, Object> map) {
        this.streamFullInfo = map;
        this.length = ((Long) map.get("length")).longValue();
        this.radixTreeKeys = ((Long) map.get("radix-tree-keys")).longValue();
        this.radixTreeNodes = ((Long) map.get("radix-tree-nodes")).longValue();
        this.groups = (List) map.get("groups");
        this.lastGeneratedId = (StreamEntryID) map.get("last-generated-id");
        this.entries = (List) map.get(ENTRIES);
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

    public List<StreamGroupFullInfo> getGroups() {
        return this.groups;
    }

    public StreamEntryID getLastGeneratedId() {
        return this.lastGeneratedId;
    }

    public List<StreamEntry> getEntries() {
        return this.entries;
    }

    public Map<String, Object> getStreamFullInfo() {
        return this.streamFullInfo;
    }
}
