package me.module.multiserver.library.redis.jedis.timeseries;

import java.util.Map;
import me.module.multiserver.library.redis.jedis.util.KeyValue;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/timeseries/TSKeyValue.class */
public class TSKeyValue<V> extends KeyValue<String, V> {
    private final Map<String, String> labels;

    public TSKeyValue(String str, Map<String, String> map, V v) {
        super(str, v);
        this.labels = map;
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }
}
