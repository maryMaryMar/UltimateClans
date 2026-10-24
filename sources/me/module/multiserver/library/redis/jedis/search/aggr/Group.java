package me.module.multiserver.library.redis.jedis.search.aggr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/Group.class */
public class Group {
    private final List<Reducer> reducers = new ArrayList();
    private final List<String> fields = new ArrayList();
    private Limit limit = new Limit(0, 0);

    public Group(String... strArr) {
        this.fields.addAll(Arrays.asList(strArr));
    }

    public Group reduce(Reducer reducer) {
        this.reducers.add(reducer);
        return this;
    }

    public Group limit(Limit limit) {
        this.limit = limit;
        return this;
    }

    public void addArgs(List<String> list) {
        list.add(Integer.toString(this.fields.size()));
        list.addAll(this.fields);
        for (Reducer reducer : this.reducers) {
            list.add("REDUCE");
            list.add(reducer.getName());
            reducer.addArgs(list);
            String alias = reducer.getAlias();
            if (alias != null && !alias.isEmpty()) {
                list.add("AS");
                list.add(alias);
            }
        }
        list.addAll(this.limit.getArgs());
    }

    public List<String> getArgs() {
        ArrayList arrayList = new ArrayList();
        addArgs(arrayList);
        return arrayList;
    }
}
