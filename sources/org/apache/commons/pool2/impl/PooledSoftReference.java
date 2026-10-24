package org.apache.commons.pool2.impl;

import java.lang.ref.SoftReference;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/PooledSoftReference.class */
public class PooledSoftReference<T> extends DefaultPooledObject<T> {
    private volatile SoftReference<T> reference;

    public PooledSoftReference(SoftReference<T> softReference) {
        super(null);
        this.reference = softReference;
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObject, org.apache.commons.pool2.PooledObject
    public T getObject() {
        return this.reference.get();
    }

    public synchronized SoftReference<T> getReference() {
        return this.reference;
    }

    public synchronized void setReference(SoftReference<T> softReference) {
        this.reference = softReference;
    }

    @Override // org.apache.commons.pool2.impl.DefaultPooledObject, org.apache.commons.pool2.PooledObject
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Referenced Object: ");
        sb.append(getObject().toString());
        sb.append(", State: ");
        synchronized (this) {
            sb.append(getState().toString());
        }
        return sb.toString();
    }
}
