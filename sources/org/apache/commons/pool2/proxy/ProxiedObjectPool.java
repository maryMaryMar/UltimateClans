package org.apache.commons.pool2.proxy;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/ProxiedObjectPool.class */
public class ProxiedObjectPool<T> implements ObjectPool<T> {
    private final ObjectPool<T> pool;
    private final ProxySource<T> proxySource;

    public ProxiedObjectPool(ObjectPool<T> objectPool, ProxySource<T> proxySource) {
        this.pool = objectPool;
        this.proxySource = proxySource;
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void addObject() {
        this.pool.addObject();
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // org.apache.commons.pool2.ObjectPool
    public T borrowObject() {
        UsageTracking<T> usageTracking = null;
        if (this.pool instanceof UsageTracking) {
            usageTracking = (UsageTracking) this.pool;
        }
        return this.proxySource.createProxy(this.pool.borrowObject(), usageTracking);
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void clear() {
        this.pool.clear();
    }

    @Override // org.apache.commons.pool2.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pool.close();
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public int getNumActive() {
        return this.pool.getNumActive();
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public int getNumIdle() {
        return this.pool.getNumIdle();
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void invalidateObject(T t) {
        this.pool.invalidateObject(this.proxySource.resolveProxy(t));
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void returnObject(T t) {
        this.pool.returnObject(this.proxySource.resolveProxy(t));
    }

    public String toString() {
        return "ProxiedObjectPool [pool=" + this.pool + ", proxySource=" + this.proxySource + "]";
    }
}
