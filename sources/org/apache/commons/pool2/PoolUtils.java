package org.apache.commons.pool2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils.class */
public final class PoolUtils {
    private static final String MSG_FACTOR_NEGATIVE = "factor must be positive.";
    private static final String MSG_MIN_IDLE = "minIdle must be non-negative.";
    static final String MSG_NULL_KEY = "key must not be null.";
    private static final String MSG_NULL_KEYED_POOL = "keyedPool must not be null.";
    static final String MSG_NULL_KEYS = "keys must not be null.";
    private static final String MSG_NULL_POOL = "pool must not be null.";

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$ErodingFactor.class */
    private static final class ErodingFactor {
        private final float factor;
        private volatile transient long nextShrinkMillis;
        private volatile transient int idleHighWaterMark = 1;

        public ErodingFactor(float f) {
            this.factor = f;
            this.nextShrinkMillis = System.currentTimeMillis() + ((long) (900000.0f * f));
        }

        public long getNextShrink() {
            return this.nextShrinkMillis;
        }

        public String toString() {
            return "ErodingFactor{factor=" + this.factor + ", idleHighWaterMark=" + this.idleHighWaterMark + '}';
        }

        public void update(long j, int i) {
            int iMax = Math.max(0, i);
            this.idleHighWaterMark = Math.max(iMax, this.idleHighWaterMark);
            this.nextShrinkMillis = j + ((long) ((15.0f + (((-14.0f) / this.idleHighWaterMark) * iMax)) * 60000.0f * this.factor));
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$ErodingKeyedObjectPool.class */
    private static class ErodingKeyedObjectPool<K, V> implements KeyedObjectPool<K, V> {
        private final KeyedObjectPool<K, V> keyedPool;
        private final ErodingFactor erodingFactor;

        protected ErodingKeyedObjectPool(KeyedObjectPool<K, V> keyedObjectPool, ErodingFactor erodingFactor) {
            if (keyedObjectPool == null) {
                throw new IllegalArgumentException(PoolUtils.MSG_NULL_KEYED_POOL);
            }
            this.keyedPool = keyedObjectPool;
            this.erodingFactor = erodingFactor;
        }

        public ErodingKeyedObjectPool(KeyedObjectPool<K, V> keyedObjectPool, float f) {
            this(keyedObjectPool, new ErodingFactor(f));
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void addObject(K k) {
            this.keyedPool.addObject(k);
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public V borrowObject(K k) {
            return this.keyedPool.borrowObject(k);
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void clear() {
            this.keyedPool.clear();
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void clear(K k) {
            this.keyedPool.clear(k);
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                this.keyedPool.close();
            } catch (Exception e) {
            }
        }

        protected ErodingFactor getErodingFactor(K k) {
            return this.erodingFactor;
        }

        protected KeyedObjectPool<K, V> getKeyedPool() {
            return this.keyedPool;
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumActive() {
            return this.keyedPool.getNumActive();
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumActive(K k) {
            return this.keyedPool.getNumActive(k);
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumIdle() {
            return this.keyedPool.getNumIdle();
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumIdle(K k) {
            return this.keyedPool.getNumIdle(k);
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void invalidateObject(K k, V v) {
            try {
                this.keyedPool.invalidateObject(k, v);
            } catch (Exception e) {
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void returnObject(K k, V v) {
            boolean z = false;
            long jCurrentTimeMillis = System.currentTimeMillis();
            ErodingFactor erodingFactor = getErodingFactor(k);
            synchronized (this.keyedPool) {
                if (erodingFactor.getNextShrink() < jCurrentTimeMillis) {
                    int numIdle = getNumIdle(k);
                    if (numIdle > 0) {
                        z = true;
                    }
                    erodingFactor.update(jCurrentTimeMillis, numIdle);
                }
            }
            try {
                if (z) {
                    this.keyedPool.invalidateObject(k, v);
                } else {
                    this.keyedPool.returnObject(k, v);
                }
            } catch (Exception e) {
            }
        }

        public String toString() {
            return "ErodingKeyedObjectPool{factor=" + this.erodingFactor + ", keyedPool=" + this.keyedPool + '}';
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$ErodingObjectPool.class */
    private static class ErodingObjectPool<T> implements ObjectPool<T> {
        private final ObjectPool<T> pool;
        private final ErodingFactor factor;

        public ErodingObjectPool(ObjectPool<T> objectPool, float f) {
            this.pool = objectPool;
            this.factor = new ErodingFactor(f);
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public void addObject() {
            this.pool.addObject();
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public T borrowObject() {
            return this.pool.borrowObject();
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public void clear() {
            this.pool.clear();
        }

        @Override // org.apache.commons.pool2.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                this.pool.close();
            } catch (Exception e) {
            }
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
            try {
                this.pool.invalidateObject(t);
            } catch (Exception e) {
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public void returnObject(T t) {
            boolean z = false;
            long jCurrentTimeMillis = System.currentTimeMillis();
            synchronized (this.pool) {
                if (this.factor.getNextShrink() < jCurrentTimeMillis) {
                    int numIdle = this.pool.getNumIdle();
                    if (numIdle > 0) {
                        z = true;
                    }
                    this.factor.update(jCurrentTimeMillis, numIdle);
                }
            }
            try {
                if (z) {
                    this.pool.invalidateObject(t);
                } else {
                    this.pool.returnObject(t);
                }
            } catch (Exception e) {
            }
        }

        public String toString() {
            return "ErodingObjectPool{factor=" + this.factor + ", pool=" + this.pool + '}';
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$ErodingPerKeyKeyedObjectPool.class */
    private static final class ErodingPerKeyKeyedObjectPool<K, V> extends ErodingKeyedObjectPool<K, V> {
        private final float factor;
        private final Map<K, ErodingFactor> factors;

        public ErodingPerKeyKeyedObjectPool(KeyedObjectPool<K, V> keyedObjectPool, float f) {
            super(keyedObjectPool, (ErodingFactor) null);
            this.factors = Collections.synchronizedMap(new HashMap());
            this.factor = f;
        }

        @Override // org.apache.commons.pool2.PoolUtils.ErodingKeyedObjectPool
        protected ErodingFactor getErodingFactor(K k) {
            ErodingFactor erodingFactor = this.factors.get(k);
            if (erodingFactor == null) {
                erodingFactor = new ErodingFactor(this.factor);
                this.factors.put(k, erodingFactor);
            }
            return erodingFactor;
        }

        @Override // org.apache.commons.pool2.PoolUtils.ErodingKeyedObjectPool
        public String toString() {
            return "ErodingPerKeyKeyedObjectPool{factor=" + this.factor + ", keyedPool=" + getKeyedPool() + '}';
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$KeyedObjectPoolMinIdleTimerTask.class */
    private static final class KeyedObjectPoolMinIdleTimerTask<K, V> extends TimerTask {
        private final int minIdle;
        private final K key;
        private final KeyedObjectPool<K, V> keyedPool;

        KeyedObjectPoolMinIdleTimerTask(KeyedObjectPool<K, V> keyedObjectPool, K k, int i) {
            if (keyedObjectPool == null) {
                throw new IllegalArgumentException(PoolUtils.MSG_NULL_KEYED_POOL);
            }
            this.keyedPool = keyedObjectPool;
            this.key = k;
            this.minIdle = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                if (this.keyedPool.getNumIdle(this.key) < this.minIdle) {
                    this.keyedPool.addObject(this.key);
                }
                z = true;
            } catch (Exception e) {
                cancel();
            } finally {
                if (!z) {
                    cancel();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("KeyedObjectPoolMinIdleTimerTask");
            sb.append("{minIdle=").append(this.minIdle);
            sb.append(", key=").append(this.key);
            sb.append(", keyedPool=").append(this.keyedPool);
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$ObjectPoolMinIdleTimerTask.class */
    private static final class ObjectPoolMinIdleTimerTask<T> extends TimerTask {
        private final int minIdle;
        private final ObjectPool<T> pool;

        ObjectPoolMinIdleTimerTask(ObjectPool<T> objectPool, int i) {
            if (objectPool == null) {
                throw new IllegalArgumentException(PoolUtils.MSG_NULL_POOL);
            }
            this.pool = objectPool;
            this.minIdle = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            boolean z = false;
            try {
                if (this.pool.getNumIdle() < this.minIdle) {
                    this.pool.addObject();
                }
                z = true;
            } catch (Exception e) {
                cancel();
            } finally {
                if (!z) {
                    cancel();
                }
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ObjectPoolMinIdleTimerTask");
            sb.append("{minIdle=").append(this.minIdle);
            sb.append(", pool=").append(this.pool);
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$SynchronizedKeyedObjectPool.class */
    private static final class SynchronizedKeyedObjectPool<K, V> implements KeyedObjectPool<K, V> {
        private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private final KeyedObjectPool<K, V> keyedPool;

        SynchronizedKeyedObjectPool(KeyedObjectPool<K, V> keyedObjectPool) {
            if (keyedObjectPool == null) {
                throw new IllegalArgumentException(PoolUtils.MSG_NULL_KEYED_POOL);
            }
            this.keyedPool = keyedObjectPool;
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void addObject(K k) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.addObject(k);
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public V borrowObject(K k) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                return this.keyedPool.borrowObject(k);
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void clear() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.clear();
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void clear(K k) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.clear(k);
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.close();
            } catch (Exception e) {
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumActive() {
            ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
            lock.lock();
            try {
                return this.keyedPool.getNumActive();
            } finally {
                lock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumActive(K k) {
            ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
            lock.lock();
            try {
                return this.keyedPool.getNumActive(k);
            } finally {
                lock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumIdle() {
            ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
            lock.lock();
            try {
                return this.keyedPool.getNumIdle();
            } finally {
                lock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public int getNumIdle(K k) {
            ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
            lock.lock();
            try {
                return this.keyedPool.getNumIdle(k);
            } finally {
                lock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void invalidateObject(K k, V v) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.invalidateObject(k, v);
            } catch (Exception e) {
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedObjectPool
        public void returnObject(K k, V v) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.returnObject(k, v);
            } catch (Exception e) {
            } finally {
                writeLock.unlock();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedKeyedObjectPool");
            sb.append("{keyedPool=").append(this.keyedPool);
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$SynchronizedKeyedPooledObjectFactory.class */
    private static final class SynchronizedKeyedPooledObjectFactory<K, V> implements KeyedPooledObjectFactory<K, V> {
        private final ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        private final KeyedPooledObjectFactory<K, V> keyedFactory;

        SynchronizedKeyedPooledObjectFactory(KeyedPooledObjectFactory<K, V> keyedPooledObjectFactory) {
            if (keyedPooledObjectFactory == null) {
                throw new IllegalArgumentException("keyedFactory must not be null.");
            }
            this.keyedFactory = keyedPooledObjectFactory;
        }

        @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
        public void activateObject(K k, PooledObject<V> pooledObject) {
            this.writeLock.lock();
            try {
                this.keyedFactory.activateObject(k, pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
        public void destroyObject(K k, PooledObject<V> pooledObject) {
            this.writeLock.lock();
            try {
                this.keyedFactory.destroyObject(k, pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
        public PooledObject<V> makeObject(K k) {
            this.writeLock.lock();
            try {
                return this.keyedFactory.makeObject(k);
            } finally {
                this.writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
        public void passivateObject(K k, PooledObject<V> pooledObject) {
            this.writeLock.lock();
            try {
                this.keyedFactory.passivateObject(k, pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedKeyedPoolableObjectFactory");
            sb.append("{keyedFactory=").append(this.keyedFactory);
            sb.append('}');
            return sb.toString();
        }

        @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
        public boolean validateObject(K k, PooledObject<V> pooledObject) {
            this.writeLock.lock();
            try {
                return this.keyedFactory.validateObject(k, pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$SynchronizedObjectPool.class */
    private static final class SynchronizedObjectPool<T> implements ObjectPool<T> {
        private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        private final ObjectPool<T> pool;

        SynchronizedObjectPool(ObjectPool<T> objectPool) {
            if (objectPool == null) {
                throw new IllegalArgumentException(PoolUtils.MSG_NULL_POOL);
            }
            this.pool = objectPool;
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public void addObject() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.addObject();
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public T borrowObject() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                return this.pool.borrowObject();
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public void clear() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.clear();
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.close();
            } catch (Exception e) {
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public int getNumActive() {
            ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
            lock.lock();
            try {
                return this.pool.getNumActive();
            } finally {
                lock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public int getNumIdle() {
            ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
            lock.lock();
            try {
                return this.pool.getNumIdle();
            } finally {
                lock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public void invalidateObject(T t) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.invalidateObject(t);
            } catch (Exception e) {
            } finally {
                writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.ObjectPool
        public void returnObject(T t) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.returnObject(t);
            } catch (Exception e) {
            } finally {
                writeLock.unlock();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedObjectPool");
            sb.append("{pool=").append(this.pool);
            sb.append('}');
            return sb.toString();
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$SynchronizedPooledObjectFactory.class */
    private static final class SynchronizedPooledObjectFactory<T> implements PooledObjectFactory<T> {
        private final ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        private final PooledObjectFactory<T> factory;

        SynchronizedPooledObjectFactory(PooledObjectFactory<T> pooledObjectFactory) {
            if (pooledObjectFactory == null) {
                throw new IllegalArgumentException("factory must not be null.");
            }
            this.factory = pooledObjectFactory;
        }

        @Override // org.apache.commons.pool2.PooledObjectFactory
        public void activateObject(PooledObject<T> pooledObject) {
            this.writeLock.lock();
            try {
                this.factory.activateObject(pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.PooledObjectFactory
        public void destroyObject(PooledObject<T> pooledObject) {
            this.writeLock.lock();
            try {
                this.factory.destroyObject(pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.PooledObjectFactory
        public PooledObject<T> makeObject() {
            this.writeLock.lock();
            try {
                return this.factory.makeObject();
            } finally {
                this.writeLock.unlock();
            }
        }

        @Override // org.apache.commons.pool2.PooledObjectFactory
        public void passivateObject(PooledObject<T> pooledObject) {
            this.writeLock.lock();
            try {
                this.factory.passivateObject(pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedPoolableObjectFactory");
            sb.append("{factory=").append(this.factory);
            sb.append('}');
            return sb.toString();
        }

        @Override // org.apache.commons.pool2.PooledObjectFactory
        public boolean validateObject(PooledObject<T> pooledObject) {
            this.writeLock.lock();
            try {
                return this.factory.validateObject(pooledObject);
            } finally {
                this.writeLock.unlock();
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PoolUtils$TimerHolder.class */
    static class TimerHolder {
        static final Timer MIN_IDLE_TIMER = new Timer(true);

        TimerHolder() {
        }
    }

    public static <K, V> Map<K, TimerTask> checkMinIdle(KeyedObjectPool<K, V> keyedObjectPool, Collection<K> collection, int i, long j) {
        if (collection == null) {
            throw new IllegalArgumentException(MSG_NULL_KEYS);
        }
        HashMap map = new HashMap(collection.size());
        for (K k : collection) {
            map.put(k, checkMinIdle(keyedObjectPool, k, i, j));
        }
        return map;
    }

    public static <K, V> TimerTask checkMinIdle(KeyedObjectPool<K, V> keyedObjectPool, K k, int i, long j) {
        if (keyedObjectPool == null) {
            throw new IllegalArgumentException(MSG_NULL_KEYED_POOL);
        }
        if (k == null) {
            throw new IllegalArgumentException(MSG_NULL_KEY);
        }
        if (i < 0) {
            throw new IllegalArgumentException(MSG_MIN_IDLE);
        }
        KeyedObjectPoolMinIdleTimerTask keyedObjectPoolMinIdleTimerTask = new KeyedObjectPoolMinIdleTimerTask(keyedObjectPool, k, i);
        getMinIdleTimer().schedule(keyedObjectPoolMinIdleTimerTask, 0L, j);
        return keyedObjectPoolMinIdleTimerTask;
    }

    public static <T> TimerTask checkMinIdle(ObjectPool<T> objectPool, int i, long j) {
        if (objectPool == null) {
            throw new IllegalArgumentException(MSG_NULL_KEYED_POOL);
        }
        if (i < 0) {
            throw new IllegalArgumentException(MSG_MIN_IDLE);
        }
        ObjectPoolMinIdleTimerTask objectPoolMinIdleTimerTask = new ObjectPoolMinIdleTimerTask(objectPool, i);
        getMinIdleTimer().schedule(objectPoolMinIdleTimerTask, 0L, j);
        return objectPoolMinIdleTimerTask;
    }

    public static void checkRethrow(Throwable th) {
        if (th instanceof ThreadDeath) {
            throw ((ThreadDeath) th);
        }
        if (th instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th);
        }
    }

    public static <K, V> KeyedObjectPool<K, V> erodingPool(KeyedObjectPool<K, V> keyedObjectPool) {
        return erodingPool(keyedObjectPool, 1.0f);
    }

    public static <K, V> KeyedObjectPool<K, V> erodingPool(KeyedObjectPool<K, V> keyedObjectPool, float f) {
        return erodingPool(keyedObjectPool, f, false);
    }

    public static <K, V> KeyedObjectPool<K, V> erodingPool(KeyedObjectPool<K, V> keyedObjectPool, float f, boolean z) {
        if (keyedObjectPool == null) {
            throw new IllegalArgumentException(MSG_NULL_KEYED_POOL);
        }
        if (f <= 0.0f) {
            throw new IllegalArgumentException(MSG_FACTOR_NEGATIVE);
        }
        return z ? new ErodingPerKeyKeyedObjectPool(keyedObjectPool, f) : new ErodingKeyedObjectPool(keyedObjectPool, f);
    }

    public static <T> ObjectPool<T> erodingPool(ObjectPool<T> objectPool) {
        return erodingPool(objectPool, 1.0f);
    }

    public static <T> ObjectPool<T> erodingPool(ObjectPool<T> objectPool, float f) {
        if (objectPool == null) {
            throw new IllegalArgumentException(MSG_NULL_POOL);
        }
        if (f <= 0.0f) {
            throw new IllegalArgumentException(MSG_FACTOR_NEGATIVE);
        }
        return new ErodingObjectPool(objectPool, f);
    }

    private static Timer getMinIdleTimer() {
        return TimerHolder.MIN_IDLE_TIMER;
    }

    @Deprecated
    public static <K, V> void prefill(KeyedObjectPool<K, V> keyedObjectPool, Collection<K> collection, int i) {
        if (collection == null) {
            throw new IllegalArgumentException(MSG_NULL_KEYS);
        }
        keyedObjectPool.addObjects((Collection) collection, i);
    }

    @Deprecated
    public static <K, V> void prefill(KeyedObjectPool<K, V> keyedObjectPool, K k, int i) {
        if (keyedObjectPool == null) {
            throw new IllegalArgumentException(MSG_NULL_KEYED_POOL);
        }
        keyedObjectPool.addObjects(k, i);
    }

    @Deprecated
    public static <T> void prefill(ObjectPool<T> objectPool, int i) {
        if (objectPool == null) {
            throw new IllegalArgumentException(MSG_NULL_POOL);
        }
        objectPool.addObjects(i);
    }

    public static <K, V> KeyedPooledObjectFactory<K, V> synchronizedKeyedPooledFactory(KeyedPooledObjectFactory<K, V> keyedPooledObjectFactory) {
        return new SynchronizedKeyedPooledObjectFactory(keyedPooledObjectFactory);
    }

    public static <K, V> KeyedObjectPool<K, V> synchronizedPool(KeyedObjectPool<K, V> keyedObjectPool) {
        return new SynchronizedKeyedObjectPool(keyedObjectPool);
    }

    public static <T> ObjectPool<T> synchronizedPool(ObjectPool<T> objectPool) {
        if (objectPool == null) {
            throw new IllegalArgumentException(MSG_NULL_POOL);
        }
        return new SynchronizedObjectPool(objectPool);
    }

    public static <T> PooledObjectFactory<T> synchronizedPooledFactory(PooledObjectFactory<T> pooledObjectFactory) {
        return new SynchronizedPooledObjectFactory(pooledObjectFactory);
    }
}
