package me.module.multiserver.library.redis.jedis.util;

import me.module.multiserver.library.redis.jedis.exceptions.JedisException;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/library/redis/jedis/util/Pool.class */
public class Pool<T> extends GenericObjectPool<T> {
    public Pool(GenericObjectPoolConfig<T> genericObjectPoolConfig, PooledObjectFactory<T> pooledObjectFactory) {
        this(pooledObjectFactory, genericObjectPoolConfig);
    }

    public Pool(PooledObjectFactory<T> pooledObjectFactory, GenericObjectPoolConfig<T> genericObjectPoolConfig) {
        super(pooledObjectFactory, genericObjectPoolConfig);
    }

    @Override // org.apache.commons.pool2.impl.GenericObjectPool, org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        destroy();
    }

    public void destroy() {
        try {
            super.close();
        } catch (RuntimeException e) {
            throw new JedisException("Could not destroy the pool", e);
        }
    }

    public T getResource() {
        try {
            return (T) super.borrowObject();
        } catch (JedisException e) {
            throw e;
        } catch (Exception e2) {
            throw new JedisException("Could not get a resource from the pool", e2);
        }
    }

    public void returnResource(T t) {
        if (t == null) {
            return;
        }
        try {
            super.returnObject(t);
        } catch (RuntimeException e) {
            throw new JedisException("Could not return the resource to the pool", e);
        }
    }

    public void returnBrokenResource(T t) {
        if (t == null) {
            return;
        }
        try {
            super.invalidateObject(t);
        } catch (Exception e) {
            throw new JedisException("Could not return the broken resource to the pool", e);
        }
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void addObjects(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            try {
                addObject();
            } catch (Exception e) {
                throw new JedisException("Error trying to add idle objects", e);
            }
        }
    }
}
