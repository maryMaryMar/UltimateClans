package org.apache.commons.pool2.impl;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/GenericKeyedObjectPoolMXBean.class */
public interface GenericKeyedObjectPoolMXBean<K> {
    boolean getBlockWhenExhausted();

    long getBorrowedCount();

    long getCreatedCount();

    String getCreationStackTrace();

    long getDestroyedByBorrowValidationCount();

    long getDestroyedByEvictorCount();

    long getDestroyedCount();

    boolean getFairness();

    boolean getLifo();

    default boolean getLogAbandoned() {
        return false;
    }

    long getMaxBorrowWaitTimeMillis();

    int getMaxIdlePerKey();

    int getMaxTotal();

    int getMaxTotalPerKey();

    long getMaxWaitMillis();

    long getMeanActiveTimeMillis();

    long getMeanBorrowWaitTimeMillis();

    long getMeanIdleTimeMillis();

    long getMinEvictableIdleTimeMillis();

    int getMinIdlePerKey();

    int getNumActive();

    Map<String, Integer> getNumActivePerKey();

    int getNumIdle();

    int getNumTestsPerEvictionRun();

    int getNumWaiters();

    Map<String, Integer> getNumWaitersByKey();

    default boolean getRemoveAbandonedOnBorrow() {
        return false;
    }

    default boolean getRemoveAbandonedOnMaintenance() {
        return false;
    }

    default int getRemoveAbandonedTimeout() {
        return 0;
    }

    long getReturnedCount();

    boolean getTestOnBorrow();

    boolean getTestOnCreate();

    boolean getTestOnReturn();

    boolean getTestWhileIdle();

    long getTimeBetweenEvictionRunsMillis();

    default boolean isAbandonedConfig() {
        return false;
    }

    boolean isClosed();

    Map<String, List<DefaultPooledObjectInfo>> listAllObjects();
}
