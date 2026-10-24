package me.module.multiserver.library.redis.jedis.graph;

import java.util.List;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/Header.class */
public interface Header {
    List<ResultSet.ColumnType> getSchemaTypes();

    List<String> getSchemaNames();
}
