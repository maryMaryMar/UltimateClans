package me.module.multiserver.library.redis.jedis.search.querybuilder;

import java.util.Arrays;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/querybuilder/QueryBuilders.class */
public class QueryBuilders {
    private QueryBuilders() {
        throw new InstantiationError("Must not instantiate this class");
    }

    public static QueryNode intersect(Node... nodeArr) {
        return new IntersectNode().add(nodeArr);
    }

    public static QueryNode intersect(String str, Value... valueArr) {
        return new IntersectNode().add(str, valueArr);
    }

    public static QueryNode intersect(String str, String str2) {
        return intersect(str, Values.value(str2));
    }

    public static QueryNode union(Node... nodeArr) {
        return new UnionNode().add(nodeArr);
    }

    public static QueryNode union(String str, Value... valueArr) {
        return new UnionNode().add(str, valueArr);
    }

    public static QueryNode union(String str, String... strArr) {
        return union(str, (Value[]) Arrays.stream(strArr).map(Values::value).toArray());
    }

    public static QueryNode disjunct(Node... nodeArr) {
        return new DisjunctNode().add(nodeArr);
    }

    public static QueryNode disjunct(String str, Value... valueArr) {
        return new DisjunctNode().add(str, valueArr);
    }

    public static QueryNode disjunct(String str, String... strArr) {
        return disjunct(str, (Value[]) Arrays.stream(strArr).map(Values::value).toArray());
    }

    public static QueryNode disjunctUnion(Node... nodeArr) {
        return new DisjunctUnionNode().add(nodeArr);
    }

    public static QueryNode disjunctUnion(String str, Value... valueArr) {
        return new DisjunctUnionNode().add(str, valueArr);
    }

    public static QueryNode disjunctUnion(String str, String... strArr) {
        return disjunctUnion(str, (Value[]) Arrays.stream(strArr).map(Values::value).toArray());
    }

    public static QueryNode optional(Node... nodeArr) {
        return new OptionalNode().add(nodeArr);
    }

    public static QueryNode optional(String str, Value... valueArr) {
        return new OptionalNode().add(str, valueArr);
    }
}
