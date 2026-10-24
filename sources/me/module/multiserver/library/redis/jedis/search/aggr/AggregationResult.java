package me.module.multiserver.library.redis.jedis.search.aggr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.module.multiserver.library.redis.jedis.exceptions.JedisDataException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/AggregationResult.class */
public class AggregationResult {

    @Deprecated
    public final long totalResults;
    private final List<Map<String, Object>> results;
    private long cursorId;

    public AggregationResult(Object obj, long j) {
        this(obj);
        this.cursorId = j;
    }

    public AggregationResult(Object obj) {
        this.results = new ArrayList();
        this.cursorId = -1L;
        List list = (List) obj;
        this.totalResults = ((Long) list.get(0)).longValue();
        for (int i = 1; i < list.size(); i++) {
            List list2 = (List) list.get(i);
            HashMap map = new HashMap();
            for (int i2 = 0; i2 < list2.size(); i2 += 2) {
                Object obj2 = list2.get(i2);
                if (obj2 instanceof JedisDataException) {
                    throw ((JedisDataException) obj2);
                }
                map.put(new String((byte[]) obj2), list2.get(i2 + 1));
            }
            this.results.add(map);
        }
    }

    public long getTotalResults() {
        return this.totalResults;
    }

    public List<Map<String, Object>> getResults() {
        return this.results;
    }

    public Row getRow(int i) {
        if (i >= this.results.size()) {
            return null;
        }
        return new Row(this.results.get(i));
    }

    public long getCursorId() {
        return this.cursorId;
    }
}
