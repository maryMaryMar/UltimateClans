package org.apache.commons.pool2.proxy;

import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/ProxiedKeyedObjectPool.class */
public class ProxiedKeyedObjectPool<K, V> implements KeyedObjectPool<K, V> {
    private final KeyedObjectPool<K, V> pool;
    private final ProxySource<V> proxySource;

    public ProxiedKeyedObjectPool(KeyedObjectPool<K, V> keyedObjectPool, ProxySource<V> proxySource) {
        this.pool = keyedObjectPool;
        this.proxySource = proxySource;
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void addObject(K k) {
        this.pool.addObject(k);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // org.apache.commons.pool2.KeyedObjectPool
    public V borrowObject(K k) {
        UsageTracking<V> usageTracking = null;
        if (this.pool instanceof UsageTracking) {
            usageTracking = (UsageTracking) this.pool;
        }
        return this.proxySource.createProxy(this.pool.borrowObject(k), usageTracking);
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void clear() {
        this.pool.clear();
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void clear(K k) {
        this.pool.clear(k);
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.pool.close();
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public int getNumActive() {
        return this.pool.getNumActive();
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public int getNumActive(K k) {
        return this.pool.getNumActive(k);
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public int getNumIdle() {
        return this.pool.getNumIdle();
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public int getNumIdle(K k) {
        return this.pool.getNumIdle(k);
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void invalidateObject(K k, V v) {
        this.pool.invalidateObject(k, this.proxySource.resolveProxy(v));
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void returnObject(K k, V v) {
        this.pool.returnObject(k, this.proxySource.resolveProxy(v));
    }

    public String toString() {
        return "ProxiedKeyedObjectPool [pool=" + this.pool + ", proxySource=" + this.proxySource + "]";
    }
}
