package me.module.multiserver.library.redis.jedis.search.aggr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/Limit.class */
public class Limit {
    public static final Limit NO_LIMIT = new Limit(0, 0);
    private final int offset;
    private final int count;

    public Limit(int i, int i2) {
        this.offset = i;
        this.count = i2;
    }

    public void addArgs(List<String> list) {
        if (this.count == 0) {
            return;
        }
        list.add("LIMIT");
        list.add(Integer.toString(this.offset));
        list.add(Integer.toString(this.count));
    }

    public List<String> getArgs() {
        if (this.count == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(3);
        addArgs(arrayList);
        return arrayList;
    }
}
