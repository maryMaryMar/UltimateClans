package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import org.apache.commons.pool2.PooledObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/DefaultPooledObjectInfo.class */
public class DefaultPooledObjectInfo implements DefaultPooledObjectInfoMBean {
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss Z";
    private final PooledObject<?> pooledObject;

    public DefaultPooledObjectInfo(PooledObject<?> pooledObject) {
        this.pooledObject = pooledObject;
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public long getBorrowedCount() {
        return this.pooledObject.getBorrowedCount();
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public long getCreateTime() {
        return this.pooledObject.getCreateInstant().toEpochMilli();
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public String getCreateTimeFormatted() {
        return getTimeFormatted(getCreateTime());
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public long getLastBorrowTime() {
        return this.pooledObject.getLastBorrowInstant().toEpochMilli();
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public String getLastBorrowTimeFormatted() {
        return getTimeFormatted(getLastBorrowTime());
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public String getLastBorrowTrace() {
        StringWriter stringWriter = new StringWriter();
        this.pooledObject.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public long getLastReturnTime() {
        return this.pooledObject.getLastReturnInstant().toEpochMilli();
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public String getLastReturnTimeFormatted() {
        return getTimeFormatted(getLastReturnTime());
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public String getPooledObjectToString() {
        return this.pooledObject.getObject().toString();
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObjectInfoMBean
    public String getPooledObjectType() {
        return this.pooledObject.getObject().getClass().getName();
    }

    private String getTimeFormatted(long j) {
        return new SimpleDateFormat(PATTERN).format(Long.valueOf(j));
    }

    public String toString() {
        return "DefaultPooledObjectInfo [pooledObject=" + this.pooledObject + "]";
    }
}
