package org.apache.commons.pool2.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/GenericKeyedObjectPool.class */
public class GenericKeyedObjectPool<K, T> extends BaseGenericObjectPool<T> implements KeyedObjectPool<K, T>, UsageTracking<T>, GenericKeyedObjectPoolMXBean<K> {
    private static final Integer ZERO = 0;
    private static final String ONAME_BASE = "org.apache.commons.pool2:type=GenericKeyedObjectPool,name=";
    private volatile int maxIdlePerKey;
    private volatile int minIdlePerKey;
    private volatile int maxTotalPerKey;
    private final KeyedPooledObjectFactory<K, T> factory;
    private final boolean fairness;
    private final Map<K, GenericKeyedObjectPool<K, T>.ObjectDeque<T>> poolMap;
    private final List<K> poolKeyList;
    private final ReadWriteLock keyLock;
    private final AtomicInteger numTotal;
    private Iterator<K> evictionKeyIterator;
    private K evictionKey;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/GenericKeyedObjectPool$ObjectDeque.class */
    private class ObjectDeque<S> {
        private final LinkedBlockingDeque<PooledObject<S>> idleObjects;
        private long makeObjectCount;
        private final AtomicInteger createCount = new AtomicInteger(0);
        private final Object makeObjectCountLock = new Object();
        private final Map<BaseGenericObjectPool.IdentityWrapper<S>, PooledObject<S>> allObjects = new ConcurrentHashMap();
        private final AtomicLong numInterested = new AtomicLong();

        public ObjectDeque(boolean z) {
            this.idleObjects = new LinkedBlockingDeque<>(z);
        }

        public Map<BaseGenericObjectPool.IdentityWrapper<S>, PooledObject<S>> getAllObjects() {
            return this.allObjects;
        }

        public AtomicInteger getCreateCount() {
            return this.createCount;
        }

        public LinkedBlockingDeque<PooledObject<S>> getIdleObjects() {
            return this.idleObjects;
        }

        public AtomicLong getNumInterested() {
            return this.numInterested;
        }

        public String toString() {
            return "ObjectDeque [idleObjects=" + this.idleObjects + ", createCount=" + this.createCount + ", allObjects=" + this.allObjects + ", numInterested=" + this.numInterested + "]";
        }

        static /* synthetic */ long access$108(ObjectDeque objectDeque) {
            long j = objectDeque.makeObjectCount;
            objectDeque.makeObjectCount = j + 1;
            return j;
        }

        static /* synthetic */ long access$110(ObjectDeque objectDeque) {
            long j = objectDeque.makeObjectCount;
            objectDeque.makeObjectCount = j - 1;
            return j;
        }
    }

    public GenericKeyedObjectPool(KeyedPooledObjectFactory<K, T> keyedPooledObjectFactory) {
        this(keyedPooledObjectFactory, new GenericKeyedObjectPoolConfig());
    }

    public GenericKeyedObjectPool(KeyedPooledObjectFactory<K, T> keyedPooledObjectFactory, GenericKeyedObjectPoolConfig<T> genericKeyedObjectPoolConfig) {
        super(genericKeyedObjectPoolConfig, ONAME_BASE, genericKeyedObjectPoolConfig.getJmxNamePrefix());
        this.maxIdlePerKey = 8;
        this.minIdlePerKey = 0;
        this.maxTotalPerKey = 8;
        this.poolMap = new ConcurrentHashMap();
        this.poolKeyList = new ArrayList();
        this.keyLock = new ReentrantReadWriteLock(true);
        this.numTotal = new AtomicInteger(0);
        if (keyedPooledObjectFactory == null) {
            jmxUnregister();
            throw new IllegalArgumentException("Factory may not be null");
        }
        this.factory = keyedPooledObjectFactory;
        this.fairness = genericKeyedObjectPoolConfig.getFairness();
        setConfig((GenericKeyedObjectPoolConfig) genericKeyedObjectPoolConfig);
    }

    public GenericKeyedObjectPool(KeyedPooledObjectFactory<K, T> keyedPooledObjectFactory, GenericKeyedObjectPoolConfig<T> genericKeyedObjectPoolConfig, AbandonedConfig abandonedConfig) {
        this(keyedPooledObjectFactory, genericKeyedObjectPoolConfig);
        setAbandonedConfig(abandonedConfig);
    }

    private void addIdleObject(K k, PooledObject<T> pooledObject) {
        if (pooledObject != null) {
            this.factory.passivateObject(k, pooledObject);
            LinkedBlockingDeque<PooledObject<T>> idleObjects = this.poolMap.get(k).getIdleObjects();
            if (getLifo()) {
                idleObjects.addFirst(pooledObject);
            } else {
                idleObjects.addLast(pooledObject);
            }
        }
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void addObject(K k) {
        assertOpen();
        register(k);
        try {
            addIdleObject(k, create(k));
        } finally {
            deregister(k);
        }
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public T borrowObject(K k) {
        return borrowObject(k, getMaxWaitDuration().toMillis());
    }

    public T borrowObject(K k, long j) {
        assertOpen();
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        if (abandonedConfig != null && abandonedConfig.getRemoveAbandonedOnBorrow() && getNumIdle() < 2 && getNumActive() > getMaxTotal() - 3) {
            removeAbandoned(abandonedConfig);
        }
        PooledObject<T> pooledObjectPollFirst = null;
        boolean blockWhenExhausted = getBlockWhenExhausted();
        long jCurrentTimeMillis = System.currentTimeMillis();
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDequeRegister = register(k);
        while (pooledObjectPollFirst == null) {
            try {
                boolean z = false;
                pooledObjectPollFirst = objectDequeRegister.getIdleObjects().pollFirst();
                if (pooledObjectPollFirst == null) {
                    pooledObjectPollFirst = create(k);
                    if (pooledObjectPollFirst != null) {
                        z = true;
                    }
                }
                if (blockWhenExhausted) {
                    if (pooledObjectPollFirst == null) {
                        pooledObjectPollFirst = j < 0 ? objectDequeRegister.getIdleObjects().takeFirst() : objectDequeRegister.getIdleObjects().pollFirst(j, TimeUnit.MILLISECONDS);
                    }
                    if (pooledObjectPollFirst == null) {
                        throw new NoSuchElementException(appendStats("Timeout waiting for idle object, borrowMaxWaitMillis=" + j));
                    }
                } else if (pooledObjectPollFirst == null) {
                    throw new NoSuchElementException(appendStats("Pool exhausted"));
                }
                if (!pooledObjectPollFirst.allocate()) {
                    pooledObjectPollFirst = null;
                }
                if (pooledObjectPollFirst != null) {
                    try {
                        this.factory.activateObject(k, pooledObjectPollFirst);
                    } catch (Exception e) {
                        try {
                            destroy(k, pooledObjectPollFirst, true, DestroyMode.NORMAL);
                        } catch (Exception e2) {
                        }
                        pooledObjectPollFirst = null;
                        if (z) {
                            NoSuchElementException noSuchElementException = new NoSuchElementException(appendStats("Unable to activate object"));
                            noSuchElementException.initCause(e);
                            throw noSuchElementException;
                        }
                    }
                    if (pooledObjectPollFirst != null && getTestOnBorrow()) {
                        boolean zValidateObject = false;
                        Throwable th = null;
                        try {
                            zValidateObject = this.factory.validateObject(k, pooledObjectPollFirst);
                        } catch (Throwable th2) {
                            PoolUtils.checkRethrow(th2);
                            th = th2;
                        }
                        if (!zValidateObject) {
                            try {
                                destroy(k, pooledObjectPollFirst, true, DestroyMode.NORMAL);
                                this.destroyedByBorrowValidationCount.incrementAndGet();
                            } catch (Exception e3) {
                            }
                            pooledObjectPollFirst = null;
                            if (z) {
                                NoSuchElementException noSuchElementException2 = new NoSuchElementException(appendStats("Unable to validate object"));
                                noSuchElementException2.initCause(th);
                                throw noSuchElementException2;
                            }
                        }
                    }
                }
            } catch (Throwable th3) {
                deregister(k);
                throw th3;
            }
        }
        deregister(k);
        updateStatsBorrow(pooledObjectPollFirst, Duration.ofMillis(System.currentTimeMillis() - jCurrentTimeMillis));
        return pooledObjectPollFirst.getObject();
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    String getStatsString() {
        return super.getStatsString() + String.format(", fairness=%s, maxIdlePerKey%,d, maxTotalPerKey=%,d, minIdlePerKey=%,d, numTotal=%,d", Boolean.valueOf(this.fairness), Integer.valueOf(this.maxIdlePerKey), Integer.valueOf(this.maxTotalPerKey), Integer.valueOf(this.minIdlePerKey), Integer.valueOf(this.numTotal.get()));
    }

    private int calculateDeficit(GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque) {
        if (objectDeque == null) {
            return getMinIdlePerKey();
        }
        int maxTotal = getMaxTotal();
        int maxTotalPerKey = getMaxTotalPerKey();
        int minIdlePerKey = getMinIdlePerKey() - objectDeque.getIdleObjects().size();
        if (maxTotalPerKey > 0) {
            minIdlePerKey = Math.min(minIdlePerKey, Math.max(0, maxTotalPerKey - objectDeque.getIdleObjects().size()));
        }
        if (maxTotal > 0) {
            minIdlePerKey = Math.min(minIdlePerKey, Math.max(0, (maxTotal - getNumActive()) - getNumIdle()));
        }
        return minIdlePerKey;
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void clear() {
        this.poolMap.keySet().forEach(this::clear);
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void clear(K k) {
        try {
            LinkedBlockingDeque<PooledObject<T>> idleObjects = register(k).getIdleObjects();
            for (PooledObject<T> pooledObjectPoll = idleObjects.poll(); pooledObjectPoll != null; pooledObjectPoll = idleObjects.poll()) {
                try {
                    destroy(k, pooledObjectPoll, true, DestroyMode.NORMAL);
                } catch (Exception e) {
                    swallowException(e);
                }
            }
            deregister(k);
        } catch (Throwable th) {
            deregister(k);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void clearOldest() {
        TreeMap treeMap = new TreeMap();
        this.poolMap.forEach((obj, objectDeque) -> {
            if (objectDeque != null) {
                objectDeque.getIdleObjects().forEach(pooledObject -> {
                    treeMap.put(pooledObject, obj);
                });
            }
        });
        int size = ((int) (((double) treeMap.size()) * 0.15d)) + 1;
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext() && size > 0) {
            Map.Entry entry = (Map.Entry) it.next();
            boolean zDestroy = true;
            try {
                zDestroy = destroy(entry.getValue(), (PooledObject) entry.getKey(), false, DestroyMode.NORMAL);
            } catch (Exception e) {
                swallowException(e);
            }
            if (zDestroy) {
                size--;
            }
        }
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isClosed()) {
            return;
        }
        synchronized (this.closeLock) {
            if (isClosed()) {
                return;
            }
            stopEvictor();
            this.closed = true;
            clear();
            jmxUnregister();
            this.poolMap.values().forEach(objectDeque -> {
                objectDeque.getIdleObjects().interuptTakeWaiters();
            });
            clear();
        }
    }

    private PooledObject<T> create(K k) {
        int maxTotalPerKey = getMaxTotalPerKey();
        if (maxTotalPerKey < 0) {
            maxTotalPerKey = Integer.MAX_VALUE;
        }
        int maxTotal = getMaxTotal();
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
        boolean z = true;
        while (z) {
            int iIncrementAndGet = this.numTotal.incrementAndGet();
            if (maxTotal <= -1 || iIncrementAndGet <= maxTotal) {
                z = false;
            } else {
                this.numTotal.decrementAndGet();
                if (getNumIdle() == 0) {
                    return null;
                }
                clearOldest();
            }
        }
        Boolean bool = null;
        while (bool == null) {
            synchronized (((ObjectDeque) objectDeque).makeObjectCountLock) {
                if (objectDeque.getCreateCount().incrementAndGet() > maxTotalPerKey) {
                    objectDeque.getCreateCount().decrementAndGet();
                    if (((ObjectDeque) objectDeque).makeObjectCount == 0) {
                        bool = Boolean.FALSE;
                    } else {
                        ((ObjectDeque) objectDeque).makeObjectCountLock.wait();
                    }
                } else {
                    ObjectDeque.access$108(objectDeque);
                    bool = Boolean.TRUE;
                }
            }
        }
        if (!bool.booleanValue()) {
            this.numTotal.decrementAndGet();
            return null;
        }
        try {
            try {
                PooledObject<T> pooledObjectMakeObject = this.factory.makeObject(k);
                if (getTestOnCreate() && !this.factory.validateObject(k, pooledObjectMakeObject)) {
                    this.numTotal.decrementAndGet();
                    objectDeque.getCreateCount().decrementAndGet();
                    synchronized (((ObjectDeque) objectDeque).makeObjectCountLock) {
                        ObjectDeque.access$110(objectDeque);
                        ((ObjectDeque) objectDeque).makeObjectCountLock.notifyAll();
                    }
                    return null;
                }
                synchronized (((ObjectDeque) objectDeque).makeObjectCountLock) {
                    ObjectDeque.access$110(objectDeque);
                    ((ObjectDeque) objectDeque).makeObjectCountLock.notifyAll();
                }
                AbandonedConfig abandonedConfig = this.abandonedConfig;
                if (abandonedConfig != null && abandonedConfig.getLogAbandoned()) {
                    pooledObjectMakeObject.setLogAbandoned(true);
                    pooledObjectMakeObject.setRequireFullStackTrace(abandonedConfig.getRequireFullStackTrace());
                }
                this.createdCount.incrementAndGet();
                objectDeque.getAllObjects().put(new BaseGenericObjectPool.IdentityWrapper<>(pooledObjectMakeObject.getObject()), pooledObjectMakeObject);
                return pooledObjectMakeObject;
            } catch (Exception e) {
                this.numTotal.decrementAndGet();
                objectDeque.getCreateCount().decrementAndGet();
                throw e;
            }
        } catch (Throwable th) {
            synchronized (((ObjectDeque) objectDeque).makeObjectCountLock) {
                ObjectDeque.access$110(objectDeque);
                ((ObjectDeque) objectDeque).makeObjectCountLock.notifyAll();
                throw th;
            }
        }
    }

    private void deregister(K k) {
        Lock lock = this.keyLock.readLock();
        try {
            lock.lock();
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
            if (objectDeque.getNumInterested().decrementAndGet() == 0 && objectDeque.getCreateCount().get() == 0) {
                lock.unlock();
                lock = this.keyLock.writeLock();
                lock.lock();
                if (objectDeque.getCreateCount().get() == 0 && objectDeque.getNumInterested().get() == 0) {
                    this.poolMap.remove(k);
                    this.poolKeyList.remove(k);
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private boolean destroy(K k, PooledObject<T> pooledObject, boolean z, DestroyMode destroyMode) {
        boolean zEquals;
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDequeRegister = register(k);
        try {
            synchronized (pooledObject) {
                zEquals = pooledObject.getState().equals(PooledObjectState.IDLE);
                if (zEquals || z) {
                    zEquals = objectDequeRegister.getIdleObjects().remove(pooledObject);
                }
            }
            if (!zEquals && !z) {
                deregister(k);
                return false;
            }
            objectDequeRegister.getAllObjects().remove(new BaseGenericObjectPool.IdentityWrapper(pooledObject.getObject()));
            pooledObject.invalidate();
            try {
                this.factory.destroyObject(k, pooledObject, destroyMode);
                objectDequeRegister.getCreateCount().decrementAndGet();
                this.destroyedCount.incrementAndGet();
                this.numTotal.decrementAndGet();
                deregister(k);
                return true;
            } catch (Throwable th) {
                objectDequeRegister.getCreateCount().decrementAndGet();
                this.destroyedCount.incrementAndGet();
                this.numTotal.decrementAndGet();
                throw th;
            }
        } catch (Throwable th2) {
            deregister(k);
            throw th2;
        }
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    void ensureMinIdle() {
        if (getMinIdlePerKey() < 1) {
            return;
        }
        Iterator<K> it = this.poolMap.keySet().iterator();
        while (it.hasNext()) {
            ensureMinIdle(it.next());
        }
    }

    private void ensureMinIdle(K k) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
        int iCalculateDeficit = calculateDeficit(objectDeque);
        for (int i = 0; i < iCalculateDeficit && calculateDeficit(objectDeque) > 0; i++) {
            addObject(k);
            if (objectDeque == null) {
                objectDeque = this.poolMap.get(k);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x0231 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:107:0x0114 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:108:0x021d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0141 A[Catch: all -> 0x0270, TryCatch #1 {, blocks: (B:6:0x0019, B:9:0x0044, B:11:0x004b, B:34:0x010d, B:37:0x0115, B:39:0x0117, B:42:0x0138, B:44:0x0141, B:78:0x0265, B:45:0x0147, B:50:0x0187, B:54:0x01a8, B:60:0x01df, B:65:0x0202, B:67:0x021d, B:69:0x0225, B:70:0x022a, B:71:0x022b, B:72:0x0230, B:73:0x0231, B:75:0x0244, B:62:0x01f4, B:56:0x01be, B:76:0x025a, B:47:0x016d, B:41:0x012d, B:13:0x0055, B:15:0x005c, B:25:0x00b0, B:27:0x00bc, B:30:0x00e3, B:33:0x0105, B:17:0x0068, B:18:0x0083, B:19:0x0091, B:24:0x00a5, B:22:0x009d, B:23:0x00a4, B:80:0x026c), top: B:95:0x0019, inners: #0, #2, #3, #4, #5, #6 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0187 A[Catch: all -> 0x0270, TryCatch #1 {, blocks: (B:6:0x0019, B:9:0x0044, B:11:0x004b, B:34:0x010d, B:37:0x0115, B:39:0x0117, B:42:0x0138, B:44:0x0141, B:78:0x0265, B:45:0x0147, B:50:0x0187, B:54:0x01a8, B:60:0x01df, B:65:0x0202, B:67:0x021d, B:69:0x0225, B:70:0x022a, B:71:0x022b, B:72:0x0230, B:73:0x0231, B:75:0x0244, B:62:0x01f4, B:56:0x01be, B:76:0x025a, B:47:0x016d, B:41:0x012d, B:13:0x0055, B:15:0x005c, B:25:0x00b0, B:27:0x00bc, B:30:0x00e3, B:33:0x0105, B:17:0x0068, B:18:0x0083, B:19:0x0091, B:24:0x00a5, B:22:0x009d, B:23:0x00a4, B:80:0x026c), top: B:95:0x0019, inners: #0, #2, #3, #4, #5, #6 }] */
    /* JADX WARN: Code duplicated, block: B:51:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:59:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:65:0x0202 A[Catch: all -> 0x0270, TryCatch #1 {, blocks: (B:6:0x0019, B:9:0x0044, B:11:0x004b, B:34:0x010d, B:37:0x0115, B:39:0x0117, B:42:0x0138, B:44:0x0141, B:78:0x0265, B:45:0x0147, B:50:0x0187, B:54:0x01a8, B:60:0x01df, B:65:0x0202, B:67:0x021d, B:69:0x0225, B:70:0x022a, B:71:0x022b, B:72:0x0230, B:73:0x0231, B:75:0x0244, B:62:0x01f4, B:56:0x01be, B:76:0x025a, B:47:0x016d, B:41:0x012d, B:13:0x0055, B:15:0x005c, B:25:0x00b0, B:27:0x00bc, B:30:0x00e3, B:33:0x0105, B:17:0x0068, B:18:0x0083, B:19:0x0091, B:24:0x00a5, B:22:0x009d, B:23:0x00a4, B:80:0x026c), top: B:95:0x0019, inners: #0, #2, #3, #4, #5, #6 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0225 A[Catch: all -> 0x0270, TryCatch #1 {, blocks: (B:6:0x0019, B:9:0x0044, B:11:0x004b, B:34:0x010d, B:37:0x0115, B:39:0x0117, B:42:0x0138, B:44:0x0141, B:78:0x0265, B:45:0x0147, B:50:0x0187, B:54:0x01a8, B:60:0x01df, B:65:0x0202, B:67:0x021d, B:69:0x0225, B:70:0x022a, B:71:0x022b, B:72:0x0230, B:73:0x0231, B:75:0x0244, B:62:0x01f4, B:56:0x01be, B:76:0x025a, B:47:0x016d, B:41:0x012d, B:13:0x0055, B:15:0x005c, B:25:0x00b0, B:27:0x00bc, B:30:0x00e3, B:33:0x0105, B:17:0x0068, B:18:0x0083, B:19:0x0091, B:24:0x00a5, B:22:0x009d, B:23:0x00a4, B:80:0x026c), top: B:95:0x0019, inners: #0, #2, #3, #4, #5, #6 }] */
    /* JADX WARN: Code duplicated, block: B:71:0x022b A[Catch: all -> 0x0270, TryCatch #1 {, blocks: (B:6:0x0019, B:9:0x0044, B:11:0x004b, B:34:0x010d, B:37:0x0115, B:39:0x0117, B:42:0x0138, B:44:0x0141, B:78:0x0265, B:45:0x0147, B:50:0x0187, B:54:0x01a8, B:60:0x01df, B:65:0x0202, B:67:0x021d, B:69:0x0225, B:70:0x022a, B:71:0x022b, B:72:0x0230, B:73:0x0231, B:75:0x0244, B:62:0x01f4, B:56:0x01be, B:76:0x025a, B:47:0x016d, B:41:0x012d, B:13:0x0055, B:15:0x005c, B:25:0x00b0, B:27:0x00bc, B:30:0x00e3, B:33:0x0105, B:17:0x0068, B:18:0x0083, B:19:0x0091, B:24:0x00a5, B:22:0x009d, B:23:0x00a4, B:80:0x026c), top: B:95:0x0019, inners: #0, #2, #3, #4, #5, #6 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x0147 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:98:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    public void evict() {
        PooledObject<T> next;
        Deque<PooledObject<T>> idleObjects;
        boolean zEvict;
        boolean z;
        boolean zValidateObject;
        Throwable th;
        assertOpen();
        if (getNumIdle() > 0) {
            EvictionPolicy<T> evictionPolicy = getEvictionPolicy();
            synchronized (this.evictionLock) {
                EvictionConfig evictionConfig = new EvictionConfig(getMinEvictableIdleDuration(), getSoftMinEvictableIdleDuration(), getMinIdlePerKey());
                boolean testWhileIdle = getTestWhileIdle();
                int i = 0;
                int numTests = getNumTests();
                while (i < numTests) {
                    if (this.evictionIterator == null || !this.evictionIterator.hasNext()) {
                        if (this.evictionKeyIterator == null || !this.evictionKeyIterator.hasNext()) {
                            ArrayList arrayList = new ArrayList();
                            Lock lock = this.keyLock.readLock();
                            lock.lock();
                            try {
                                arrayList.addAll(this.poolKeyList);
                                lock.unlock();
                                this.evictionKeyIterator = arrayList.iterator();
                            } catch (Throwable th2) {
                                lock.unlock();
                                throw th2;
                            }
                        }
                        while (this.evictionKeyIterator.hasNext()) {
                            this.evictionKey = this.evictionKeyIterator.next();
                            GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(this.evictionKey);
                            if (objectDeque != null) {
                                this.evictionIterator = new BaseGenericObjectPool.EvictionIterator(objectDeque.getIdleObjects());
                                if (this.evictionIterator.hasNext()) {
                                    break;
                                } else {
                                    this.evictionIterator = null;
                                }
                            }
                        }
                        if (this.evictionIterator == null) {
                            return;
                        }
                        try {
                            next = this.evictionIterator.next();
                            idleObjects = this.evictionIterator.getIdleObjects();
                            if (next.startEvictionTest()) {
                                try {
                                    zEvict = evictionPolicy.evict(evictionConfig, next, this.poolMap.get(this.evictionKey).getIdleObjects().size());
                                } catch (Throwable th3) {
                                    PoolUtils.checkRethrow(th3);
                                    swallowException(new Exception(th3));
                                    zEvict = false;
                                }
                                if (zEvict) {
                                    destroy(this.evictionKey, next, true, DestroyMode.NORMAL);
                                    this.destroyedByEvictorCount.incrementAndGet();
                                } else {
                                    if (testWhileIdle) {
                                        z = false;
                                        try {
                                            this.factory.activateObject(this.evictionKey, next);
                                            z = true;
                                        } catch (Exception e) {
                                            destroy(this.evictionKey, next, true, DestroyMode.NORMAL);
                                            this.destroyedByEvictorCount.incrementAndGet();
                                        }
                                        if (z) {
                                            zValidateObject = false;
                                            th = null;
                                            try {
                                                zValidateObject = this.factory.validateObject(this.evictionKey, next);
                                            } catch (Throwable th4) {
                                                PoolUtils.checkRethrow(th4);
                                                th = th4;
                                            }
                                            if (zValidateObject) {
                                                try {
                                                    this.factory.passivateObject(this.evictionKey, next);
                                                } catch (Exception e2) {
                                                    destroy(this.evictionKey, next, true, DestroyMode.NORMAL);
                                                    this.destroyedByEvictorCount.incrementAndGet();
                                                }
                                            } else {
                                                destroy(this.evictionKey, next, true, DestroyMode.NORMAL);
                                                this.destroyedByEvictorCount.incrementAndGet();
                                                if (th != null) {
                                                    if (th instanceof RuntimeException) {
                                                        throw ((Error) th);
                                                    }
                                                    throw ((RuntimeException) th);
                                                }
                                            }
                                        }
                                    }
                                    if (!next.endEvictionTest(idleObjects)) {
                                    }
                                }
                            } else {
                                i--;
                            }
                        } catch (NoSuchElementException e3) {
                            i--;
                            this.evictionIterator = null;
                        }
                        i++;
                    } else {
                        if (this.evictionIterator == null) {
                            return;
                        }
                        next = this.evictionIterator.next();
                        idleObjects = this.evictionIterator.getIdleObjects();
                        if (next.startEvictionTest()) {
                            i--;
                        } else {
                            zEvict = evictionPolicy.evict(evictionConfig, next, this.poolMap.get(this.evictionKey).getIdleObjects().size());
                            if (zEvict) {
                                destroy(this.evictionKey, next, true, DestroyMode.NORMAL);
                                this.destroyedByEvictorCount.incrementAndGet();
                            } else {
                                if (testWhileIdle) {
                                    z = false;
                                    this.factory.activateObject(this.evictionKey, next);
                                    z = true;
                                    if (z) {
                                        zValidateObject = false;
                                        th = null;
                                        zValidateObject = this.factory.validateObject(this.evictionKey, next);
                                        if (zValidateObject) {
                                            destroy(this.evictionKey, next, true, DestroyMode.NORMAL);
                                            this.destroyedByEvictorCount.incrementAndGet();
                                            if (th != null) {
                                                if (th instanceof RuntimeException) {
                                                    throw ((Error) th);
                                                }
                                                throw ((RuntimeException) th);
                                            }
                                        } else {
                                            this.factory.passivateObject(this.evictionKey, next);
                                        }
                                    }
                                }
                                if (!next.endEvictionTest(idleObjects)) {
                                }
                            }
                        }
                        i++;
                    }
                    throw th;
                }
            }
        }
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        if (abandonedConfig == null || !abandonedConfig.getRemoveAbandonedOnMaintenance()) {
            return;
        }
        removeAbandoned(abandonedConfig);
    }

    public KeyedPooledObjectFactory<K, T> getFactory() {
        return this.factory;
    }

    @Override // org.apache.commons.pool2.impl.GenericKeyedObjectPoolMXBean
    public int getMaxIdlePerKey() {
        return this.maxIdlePerKey;
    }

    @Override // org.apache.commons.pool2.impl.GenericKeyedObjectPoolMXBean
    public int getMaxTotalPerKey() {
        return this.maxTotalPerKey;
    }

    @Override // org.apache.commons.pool2.impl.GenericKeyedObjectPoolMXBean
    public int getMinIdlePerKey() {
        int maxIdlePerKey = getMaxIdlePerKey();
        return this.minIdlePerKey > maxIdlePerKey ? maxIdlePerKey : this.minIdlePerKey;
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public int getNumActive() {
        return this.numTotal.get() - getNumIdle();
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public int getNumActive(K k) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
        if (objectDeque != null) {
            return objectDeque.getAllObjects().size() - objectDeque.getIdleObjects().size();
        }
        return 0;
    }

    @Override // org.apache.commons.pool2.impl.GenericKeyedObjectPoolMXBean
    public Map<String, Integer> getNumActivePerKey() {
        HashMap map = new HashMap();
        this.poolMap.entrySet().forEach(entry -> {
            if (entry != null) {
                Object key = entry.getKey();
                ObjectDeque objectDeque = (ObjectDeque) entry.getValue();
                if (key == null || objectDeque == null) {
                    return;
                }
                map.put(key.toString(), Integer.valueOf(objectDeque.getAllObjects().size() - objectDeque.getIdleObjects().size()));
            }
        });
        return map;
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.KeyedObjectPool
    public int getNumIdle() {
        return this.poolMap.values().stream().mapToInt(objectDeque -> {
            return objectDeque.getIdleObjects().size();
        }).sum();
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public int getNumIdle(K k) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
        if (objectDeque != null) {
            return objectDeque.getIdleObjects().size();
        }
        return 0;
    }

    private int getNumTests() {
        int numIdle = getNumIdle();
        int numTestsPerEvictionRun = getNumTestsPerEvictionRun();
        return numTestsPerEvictionRun >= 0 ? Math.min(numTestsPerEvictionRun, numIdle) : (int) Math.ceil(((double) numIdle) / Math.abs(numTestsPerEvictionRun));
    }

    @Override // org.apache.commons.pool2.impl.GenericKeyedObjectPoolMXBean
    public int getNumWaiters() {
        if (getBlockWhenExhausted()) {
            return this.poolMap.values().stream().mapToInt(objectDeque -> {
                return objectDeque.getIdleObjects().getTakeQueueLength();
            }).sum();
        }
        return 0;
    }

    @Override // org.apache.commons.pool2.impl.GenericKeyedObjectPoolMXBean
    public Map<String, Integer> getNumWaitersByKey() {
        HashMap map = new HashMap();
        for (Map.Entry<K, GenericKeyedObjectPool<K, T>.ObjectDeque<T>> entry : this.poolMap.entrySet()) {
            K key = entry.getKey();
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> value = entry.getValue();
            if (value != null) {
                map.put(key.toString(), getBlockWhenExhausted() ? Integer.valueOf(value.getIdleObjects().getTakeQueueLength()) : ZERO);
            }
        }
        return map;
    }

    private boolean hasBorrowWaiters() {
        return this.poolMap.values().stream().anyMatch(objectDeque -> {
            return objectDeque != null && objectDeque.getIdleObjects().hasTakeWaiters();
        });
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void invalidateObject(K k, T t) {
        invalidateObject(k, t, DestroyMode.NORMAL);
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void invalidateObject(K k, T t, DestroyMode destroyMode) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
        PooledObject<T> pooledObject = objectDeque.getAllObjects().get(new BaseGenericObjectPool.IdentityWrapper(t));
        if (pooledObject == null) {
            throw new IllegalStateException(appendStats("Object not currently part of this pool"));
        }
        synchronized (pooledObject) {
            if (pooledObject.getState() != PooledObjectState.INVALID) {
                destroy(k, pooledObject, true, destroyMode);
            }
        }
        if (((ObjectDeque) objectDeque).idleObjects.hasTakeWaiters()) {
            addObject(k);
        }
    }

    @Override // org.apache.commons.pool2.impl.GenericKeyedObjectPoolMXBean
    public Map<String, List<DefaultPooledObjectInfo>> listAllObjects() {
        HashMap map = new HashMap();
        this.poolMap.forEach((obj, objectDeque) -> {
            if (objectDeque != null) {
                map.put(obj.toString(), objectDeque.getAllObjects().values().stream().map(DefaultPooledObjectInfo::new).collect(Collectors.toList()));
            }
        });
        return map;
    }

    public void preparePool(K k) {
        if (getMinIdlePerKey() < 1) {
            return;
        }
        ensureMinIdle(k);
    }

    private GenericKeyedObjectPool<K, T>.ObjectDeque<T> register(K k) {
        Lock lock = this.keyLock.readLock();
        try {
            lock.lock();
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
            if (objectDeque == null) {
                lock.unlock();
                lock = this.keyLock.writeLock();
                lock.lock();
                objectDeque = this.poolMap.get(k);
                if (objectDeque == null) {
                    objectDeque = new ObjectDeque<>(this.fairness);
                    objectDeque.getNumInterested().incrementAndGet();
                    this.poolMap.put(k, objectDeque);
                    this.poolKeyList.add(k);
                } else {
                    objectDeque.getNumInterested().incrementAndGet();
                }
            } else {
                objectDeque.getNumInterested().incrementAndGet();
            }
            lock = lock;
            return objectDeque;
        } finally {
            lock.unlock();
        }
    }

    private void removeAbandoned(AbandonedConfig abandonedConfig) {
        this.poolMap.forEach((obj, objectDeque) -> {
            createRemoveList(abandonedConfig, objectDeque.getAllObjects()).forEach(pooledObject -> {
                if (abandonedConfig.getLogAbandoned()) {
                    pooledObject.printStackTrace(abandonedConfig.getLogWriter());
                }
                try {
                    invalidateObject(obj, pooledObject.getObject(), DestroyMode.ABANDONED);
                } catch (Exception e) {
                    swallowException(e);
                }
            });
        });
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0173  */
    @Override // org.apache.commons.pool2.KeyedObjectPool
    public void returnObject(K k, T t) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
        if (objectDeque == null) {
            throw new IllegalStateException("No keyed pool found under the given key.");
        }
        PooledObject<T> pooledObject = objectDeque.getAllObjects().get(new BaseGenericObjectPool.IdentityWrapper(t));
        if (pooledObject == null) {
            throw new IllegalStateException("Returned object not currently part of this pool");
        }
        markReturningState(pooledObject);
        Duration activeDuration = pooledObject.getActiveDuration();
        try {
            if (getTestOnReturn() && !this.factory.validateObject(k, pooledObject)) {
                try {
                    destroy(k, pooledObject, true, DestroyMode.NORMAL);
                } catch (Exception e) {
                    swallowException(e);
                }
                whenWaitersAddObject(k, ((ObjectDeque) objectDeque).idleObjects);
                if (hasBorrowWaiters()) {
                    reuseCapacity();
                }
                updateStatsReturn(activeDuration);
                return;
            }
            try {
                this.factory.passivateObject(k, pooledObject);
                if (!pooledObject.deallocate()) {
                    throw new IllegalStateException("Object has already been returned to this pool");
                }
                int maxIdlePerKey = getMaxIdlePerKey();
                LinkedBlockingDeque<PooledObject<T>> idleObjects = objectDeque.getIdleObjects();
                if (isClosed() || (maxIdlePerKey > -1 && maxIdlePerKey <= idleObjects.size())) {
                    try {
                        destroy(k, pooledObject, true, DestroyMode.NORMAL);
                    } catch (Exception e2) {
                        swallowException(e2);
                    }
                } else {
                    if (getLifo()) {
                        idleObjects.addFirst(pooledObject);
                    } else {
                        idleObjects.addLast(pooledObject);
                    }
                    if (isClosed()) {
                        clear(k);
                    }
                }
                if (hasBorrowWaiters()) {
                    reuseCapacity();
                }
                updateStatsReturn(activeDuration);
                return;
            } catch (Exception e3) {
                swallowException(e3);
                try {
                    destroy(k, pooledObject, true, DestroyMode.NORMAL);
                } catch (Exception e4) {
                    swallowException(e4);
                }
                whenWaitersAddObject(k, ((ObjectDeque) objectDeque).idleObjects);
                if (hasBorrowWaiters()) {
                    reuseCapacity();
                }
                updateStatsReturn(activeDuration);
                return;
            }
        } catch (Throwable th) {
            if (hasBorrowWaiters()) {
                reuseCapacity();
            }
            updateStatsReturn(activeDuration);
            throw th;
        }
        if (hasBorrowWaiters()) {
            reuseCapacity();
        }
        updateStatsReturn(activeDuration);
        throw th;
    }

    private void reuseCapacity() {
        int maxTotalPerKey = getMaxTotalPerKey();
        int i = 0;
        LinkedBlockingDeque<PooledObject<T>> linkedBlockingDeque = null;
        K k = null;
        for (Map.Entry<K, GenericKeyedObjectPool<K, T>.ObjectDeque<T>> entry : this.poolMap.entrySet()) {
            K key = entry.getKey();
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> value = entry.getValue();
            if (value != null) {
                LinkedBlockingDeque<PooledObject<T>> idleObjects = value.getIdleObjects();
                int takeQueueLength = idleObjects.getTakeQueueLength();
                if (getNumActive(key) < maxTotalPerKey && takeQueueLength > i) {
                    i = takeQueueLength;
                    linkedBlockingDeque = idleObjects;
                    k = key;
                }
            }
        }
        if (linkedBlockingDeque != null) {
            register(k);
            try {
                PooledObject<T> pooledObjectCreate = create(k);
                if (pooledObjectCreate != null) {
                    addIdleObject(k, pooledObjectCreate);
                }
            } catch (Exception e) {
                swallowException(e);
            } finally {
                deregister(k);
            }
        }
    }

    public void setConfig(GenericKeyedObjectPoolConfig<T> genericKeyedObjectPoolConfig) {
        super.setConfig((BaseObjectPoolConfig) genericKeyedObjectPoolConfig);
        setMaxIdlePerKey(genericKeyedObjectPoolConfig.getMaxIdlePerKey());
        setMaxTotalPerKey(genericKeyedObjectPoolConfig.getMaxTotalPerKey());
        setMaxTotal(genericKeyedObjectPoolConfig.getMaxTotal());
        setMinIdlePerKey(genericKeyedObjectPoolConfig.getMinIdlePerKey());
    }

    public void setMaxIdlePerKey(int i) {
        this.maxIdlePerKey = i;
    }

    public void setMaxTotalPerKey(int i) {
        this.maxTotalPerKey = i;
    }

    public void setMinIdlePerKey(int i) {
        this.minIdlePerKey = i;
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        super.toStringAppendFields(sb);
        sb.append(", maxIdlePerKey=");
        sb.append(this.maxIdlePerKey);
        sb.append(", minIdlePerKey=");
        sb.append(this.minIdlePerKey);
        sb.append(", maxTotalPerKey=");
        sb.append(this.maxTotalPerKey);
        sb.append(", factory=");
        sb.append(this.factory);
        sb.append(", fairness=");
        sb.append(this.fairness);
        sb.append(", poolMap=");
        sb.append(this.poolMap);
        sb.append(", poolKeyList=");
        sb.append(this.poolKeyList);
        sb.append(", keyLock=");
        sb.append(this.keyLock);
        sb.append(", numTotal=");
        sb.append(this.numTotal);
        sb.append(", evictionKeyIterator=");
        sb.append(this.evictionKeyIterator);
        sb.append(", evictionKey=");
        sb.append(this.evictionKey);
        sb.append(", abandonedConfig=");
        sb.append(this.abandonedConfig);
    }

    private void whenWaitersAddObject(K k, LinkedBlockingDeque<PooledObject<T>> linkedBlockingDeque) {
        if (linkedBlockingDeque.hasTakeWaiters()) {
            try {
                addObject(k);
            } catch (Exception e) {
                swallowException(e);
            }
        }
    }

    @Override // org.apache.commons.pool2.UsageTracking
    public void use(T t) {
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        if (abandonedConfig == null || !abandonedConfig.getUseUsageTracking()) {
            return;
        }
        this.poolMap.values().stream().map(objectDeque -> {
            return (PooledObject) objectDeque.getAllObjects().get(new BaseGenericObjectPool.IdentityWrapper(t));
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).findFirst().ifPresent((v0) -> {
            v0.use();
        });
    }
}
