package me.module.multiserver.library.redis.jedis.search.aggr;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/SortedField.class */
public class SortedField {
    private final String fieldName;
    private final SortOrder sortOrder;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/search/aggr/SortedField$SortOrder.class */
    public enum SortOrder {
        ASC,
        DESC
    }

    public SortedField(String str, SortOrder sortOrder) {
        this.fieldName = str;
        this.sortOrder = sortOrder;
    }

    public final String getOrder() {
        return this.sortOrder.toString();
    }

    public final String getField() {
        return this.fieldName;
    }

    public static SortedField asc(String str) {
        return new SortedField(str, SortOrder.ASC);
    }

    public static SortedField desc(String str) {
        return new SortedField(str, SortOrder.DESC);
    }
}
