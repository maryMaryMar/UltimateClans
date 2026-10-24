package me.module.multiserver.library.redis.jedis.search.aggr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import me.module.multiserver.library.redis.jedis.graph.RedisGraphQueryUtil;
import me.module.multiserver.library.redis.jedis.search.FieldName;
import me.module.multiserver.library.redis.jedis.util.SafeEncoder;
import org.slf4j.Marker;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/AggregationBuilder.class */
public class AggregationBuilder {
    private final List<String> args;
    private boolean isWithCursor;

    public AggregationBuilder(String str) {
        this.args = new ArrayList();
        this.isWithCursor = false;
        this.args.add(str);
    }

    public AggregationBuilder() {
        this(Marker.ANY_MARKER);
    }

    public AggregationBuilder load(String... strArr) {
        return load(FieldName.convert(strArr));
    }

    public AggregationBuilder load(FieldName... fieldNameArr) {
        this.args.add("LOAD");
        int size = this.args.size();
        this.args.add(null);
        int iAddCommandEncodedArguments = 0;
        for (FieldName fieldName : fieldNameArr) {
            iAddCommandEncodedArguments += fieldName.addCommandEncodedArguments(this.args);
        }
        this.args.set(size, Integer.toString(iAddCommandEncodedArguments));
        return this;
    }

    public AggregationBuilder loadAll() {
        this.args.add("LOAD");
        this.args.add(Marker.ANY_MARKER);
        return this;
    }

    public AggregationBuilder limit(int i, int i2) {
        new Limit(i, i2).addArgs(this.args);
        return this;
    }

    public AggregationBuilder limit(int i) {
        return limit(0, i);
    }

    public AggregationBuilder sortBy(SortedField... sortedFieldArr) {
        this.args.add("SORTBY");
        this.args.add(Integer.toString(sortedFieldArr.length * 2));
        for (SortedField sortedField : sortedFieldArr) {
            this.args.add(sortedField.getField());
            this.args.add(sortedField.getOrder());
        }
        return this;
    }

    public AggregationBuilder sortBy(int i, SortedField... sortedFieldArr) {
        sortBy(sortedFieldArr);
        if (i > 0) {
            this.args.add("MAX");
            this.args.add(Integer.toString(i));
        }
        return this;
    }

    public AggregationBuilder sortByAsc(String str) {
        return sortBy(SortedField.asc(str));
    }

    public AggregationBuilder sortByDesc(String str) {
        return sortBy(SortedField.desc(str));
    }

    public AggregationBuilder apply(String str, String str2) {
        this.args.add("APPLY");
        this.args.add(str);
        this.args.add("AS");
        this.args.add(str2);
        return this;
    }

    public AggregationBuilder groupBy(Collection<String> collection, Collection<Reducer> collection2) {
        Group group = new Group((String[]) collection.toArray(new String[collection.size()]));
        Iterator<Reducer> it = collection2.iterator();
        while (it.hasNext()) {
            group.reduce(it.next());
        }
        groupBy(group);
        return this;
    }

    public AggregationBuilder groupBy(String str, Reducer... reducerArr) {
        return groupBy(Collections.singletonList(str), Arrays.asList(reducerArr));
    }

    public AggregationBuilder groupBy(Group group) {
        this.args.add("GROUPBY");
        group.addArgs(this.args);
        return this;
    }

    public AggregationBuilder filter(String str) {
        this.args.add("FILTER");
        this.args.add(str);
        return this;
    }

    public AggregationBuilder cursor(int i, long j) {
        this.isWithCursor = true;
        if (i > 0) {
            this.args.add("WITHCURSOR");
            this.args.add("COUNT");
            this.args.add(Integer.toString(i));
            if (j < Long.MAX_VALUE && j >= 0) {
                this.args.add("MAXIDLE");
                this.args.add(Long.toString(j));
            }
        }
        return this;
    }

    public AggregationBuilder verbatim() {
        this.args.add("VERBATIM");
        return this;
    }

    public AggregationBuilder timeout(long j) {
        if (j >= 0) {
            this.args.add(RedisGraphQueryUtil.TIMEOUT_STRING);
            this.args.add(Long.toString(j));
        }
        return this;
    }

    public AggregationBuilder params(Map<String, Object> map) {
        if (map.size() >= 1) {
            this.args.add("PARAMS");
            this.args.add(Integer.toString(map.size() * 2));
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                this.args.add(entry.getKey());
                this.args.add(String.valueOf(entry.getValue()));
            }
        }
        return this;
    }

    public AggregationBuilder dialect(int i) {
        this.args.add("DIALECT");
        this.args.add(Integer.toString(i));
        return this;
    }

    public List<String> getArgs() {
        return Collections.unmodifiableList(this.args);
    }

    public void serializeRedisArgs(List<byte[]> list) {
        Iterator<String> it = getArgs().iterator();
        while (it.hasNext()) {
            list.add(SafeEncoder.encode(it.next()));
        }
    }

    public String getArgsString() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        Iterator<String> it = getArgs().iterator();
        while (it.hasNext()) {
            stringJoiner.add(it.next());
        }
        return stringJoiner.toString();
    }

    public boolean isWithCursor() {
        return this.isWithCursor;
    }
}
