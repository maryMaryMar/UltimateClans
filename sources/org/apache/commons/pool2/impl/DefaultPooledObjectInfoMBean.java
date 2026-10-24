package org.apache.commons.pool2.impl;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/DefaultPooledObjectInfoMBean.class */
public interface DefaultPooledObjectInfoMBean {
    long getBorrowedCount();

    long getCreateTime();

    String getCreateTimeFormatted();

    long getLastBorrowTime();

    String getLastBorrowTimeFormatted();

    String getLastBorrowTrace();

    long getLastReturnTime();

    String getLastReturnTimeFormatted();

    String getPooledObjectToString();

    String getPooledObjectType();
}
