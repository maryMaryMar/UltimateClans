package org.apache.commons.pool2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/BaseObjectPool.class */
public abstract class BaseObjectPool<T> extends BaseObject implements ObjectPool<T> {
    private volatile boolean closed;

    @Override // org.apache.commons.pool2.ObjectPool
    public void addObject() {
        throw new UnsupportedOperationException();
    }

    protected final void assertOpen() {
        if (isClosed()) {
            throw new IllegalStateException("Pool not open");
        }
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public abstract T borrowObject();

    @Override // org.apache.commons.pool2.ObjectPool
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.pool2.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public int getNumActive() {
        return -1;
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public int getNumIdle() {
        return -1;
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public abstract void invalidateObject(T t);

    public final boolean isClosed() {
        return this.closed;
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public abstract void returnObject(T t);

    @Override // org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        sb.append("closed=");
        sb.append(this.closed);
    }
}
