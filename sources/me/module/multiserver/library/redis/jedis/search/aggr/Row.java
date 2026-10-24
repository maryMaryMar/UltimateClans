package me.module.multiserver.library.redis.jedis.search.aggr;

import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/Row.class */
public class Row {
    private final Map<String, Object> fields;

    public Row(Map<String, Object> map) {
        this.fields = map;
    }

    public boolean containsKey(String str) {
        return this.fields.containsKey(str);
    }

    public String getString(String str) {
        return !containsKey(str) ? "" : new String((byte[]) this.fields.get(str));
    }

    public long getLong(String str) {
        if (containsKey(str)) {
            return Long.parseLong(getString(str));
        }
        return 0L;
    }

    public double getDouble(String str) {
        if (containsKey(str)) {
            return Double.parseDouble(getString(str));
        }
        return 0.0d;
    }
}
