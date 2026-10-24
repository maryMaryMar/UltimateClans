package me.module.multiserver.library.redis.jedis.search.aggr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/Reducer.class */
public abstract class Reducer {
    private String alias;
    private final String field;

    protected Reducer(String str) {
        this.field = str;
        this.alias = null;
    }

    protected Reducer() {
        this(null);
    }

    protected List<String> getOwnArgs() {
        if (this.field == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.field);
        return arrayList;
    }

    public abstract String getName();

    public final String getAlias() {
        return this.alias;
    }

    public final Reducer setAlias(String str) {
        this.alias = str;
        return this;
    }

    public final Reducer as(String str) {
        return setAlias(str);
    }

    public final Reducer setAliasAsField() {
        if (this.field == null || this.field.isEmpty()) {
            throw new IllegalArgumentException("Cannot set to field name since no field exists");
        }
        return setAlias(this.field);
    }

    public void addArgs(List<String> list) {
        List<String> ownArgs = getOwnArgs();
        list.add(Integer.toString(ownArgs.size()));
        list.addAll(ownArgs);
    }

    public final List<String> getArgs() {
        ArrayList arrayList = new ArrayList();
        addArgs(arrayList);
        return arrayList;
    }
}
