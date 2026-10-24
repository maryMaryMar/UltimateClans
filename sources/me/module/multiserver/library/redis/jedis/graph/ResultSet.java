package me.module.multiserver.library.redis.jedis.graph;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSet.class */
public interface ResultSet extends Iterable<Record> {

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/ResultSet$ColumnType.class */
    public enum ColumnType {
        UNKNOWN,
        SCALAR,
        NODE,
        RELATION
    }

    int size();

    Header getHeader();

    Statistics getStatistics();
}
