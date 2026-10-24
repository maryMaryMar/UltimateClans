package me.module.multiserver.library.redis.jedis.graph;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/graph/Statistics.class */
public interface Statistics {
    int nodesCreated();

    int nodesDeleted();

    int indicesCreated();

    int indicesDeleted();

    int labelsAdded();

    int relationshipsDeleted();

    int relationshipsCreated();

    int propertiesSet();

    boolean cachedExecution();

    String queryIntervalExecutionTime();
}
