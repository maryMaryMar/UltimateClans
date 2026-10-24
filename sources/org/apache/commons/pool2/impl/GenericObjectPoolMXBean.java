package org.apache.commons.pool2.impl;

import java.util.Set;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/GenericObjectPoolMXBean.class */
public interface GenericObjectPoolMXBean {
    boolean getBlockWhenExhausted();

    long getBorrowedCount();

    long getCreatedCount();

    String getCreationStackTrace();

    long getDestroyedByBorrowValidationCount();

    long getDestroyedByEvictorCount();

    long getDestroyedCount();

    String getFactoryType();

    boolean getFairness();

    boolean getLifo();

    boolean getLogAbandoned();

    long getMaxBorrowWaitTimeMillis();

    int getMaxIdle();

    int getMaxTotal();

    long getMaxWaitMillis();

    long getMeanActiveTimeMillis();

    long getMeanBorrowWaitTimeMillis();

    long getMeanIdleTimeMillis();

    long getMinEvictableIdleTimeMillis();

    int getMinIdle();

    int getNumActive();

    int getNumIdle();

    int getNumTestsPerEvictionRun();

    int getNumWaiters();

    boolean getRemoveAbandonedOnBorrow();

    boolean getRemoveAbandonedOnMaintenance();

    int getRemoveAbandonedTimeout();

    long getReturnedCount();

    boolean getTestOnBorrow();

    boolean getTestOnCreate();

    boolean getTestOnReturn();

    boolean getTestWhileIdle();

    long getTimeBetweenEvictionRunsMillis();

    boolean isAbandonedConfig();

    boolean isClosed();

    Set<DefaultPooledObjectInfo> listAllObjects();
}
