package org.apache.commons.pool2.impl;

import java.time.Duration;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import org.apache.commons.pool2.DestroyMode;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/GenericObjectPool.class */
public class GenericObjectPool<T> extends BaseGenericObjectPool<T> implements ObjectPool<T>, UsageTracking<T>, GenericObjectPoolMXBean {
    private static final String ONAME_BASE = "org.apache.commons.pool2:type=GenericObjectPool,name=";
    private volatile String factoryType;
    private volatile int maxIdle;
    private volatile int minIdle;
    private final PooledObjectFactory<T> factory;
    private final Map<BaseGenericObjectPool.IdentityWrapper<T>, PooledObject<T>> allObjects;
    private final AtomicLong createCount;
    private long makeObjectCount;
    private final Object makeObjectCountLock;
    private final LinkedBlockingDeque<PooledObject<T>> idleObjects;

    public GenericObjectPool(PooledObjectFactory<T> pooledObjectFactory) {
        this(pooledObjectFactory, new GenericObjectPoolConfig());
    }

    public GenericObjectPool(PooledObjectFactory<T> pooledObjectFactory, GenericObjectPoolConfig<T> genericObjectPoolConfig) {
        super(genericObjectPoolConfig, ONAME_BASE, genericObjectPoolConfig.getJmxNamePrefix());
        this.maxIdle = 8;
        this.minIdle = 0;
        this.allObjects = new ConcurrentHashMap();
        this.createCount = new AtomicLong();
        this.makeObjectCountLock = new Object();
        if (pooledObjectFactory == null) {
            jmxUnregister();
            throw new IllegalArgumentException("Factory may not be null");
        }
        this.factory = pooledObjectFactory;
        this.idleObjects = new LinkedBlockingDeque<>(genericObjectPoolConfig.getFairness());
        setConfig((GenericObjectPoolConfig) genericObjectPoolConfig);
    }

    public GenericObjectPool(PooledObjectFactory<T> pooledObjectFactory, GenericObjectPoolConfig<T> genericObjectPoolConfig, AbandonedConfig abandonedConfig) {
        this(pooledObjectFactory, genericObjectPoolConfig);
        setAbandonedConfig(abandonedConfig);
    }

    private void addIdleObject(PooledObject<T> pooledObject) {
        if (pooledObject != null) {
            this.factory.passivateObject(pooledObject);
            if (getLifo()) {
                this.idleObjects.addFirst(pooledObject);
            } else {
                this.idleObjects.addLast(pooledObject);
            }
        }
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void addObject() {
        assertOpen();
        if (this.factory == null) {
            throw new IllegalStateException("Cannot add objects without a factory.");
        }
        addIdleObject(create());
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public T borrowObject() {
        return borrowObject(getMaxWaitDuration());
    }

    public T borrowObject(Duration duration) {
        assertOpen();
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        if (abandonedConfig != null && abandonedConfig.getRemoveAbandonedOnBorrow() && getNumIdle() < 2 && getNumActive() > getMaxTotal() - 3) {
            removeAbandoned(abandonedConfig);
        }
        PooledObject<T> pooledObjectPollFirst = null;
        boolean blockWhenExhausted = getBlockWhenExhausted();
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (pooledObjectPollFirst == null) {
            boolean z = false;
            pooledObjectPollFirst = this.idleObjects.pollFirst();
            if (pooledObjectPollFirst == null) {
                pooledObjectPollFirst = create();
                if (pooledObjectPollFirst != null) {
                    z = true;
                }
            }
            if (blockWhenExhausted) {
                if (pooledObjectPollFirst == null) {
                    pooledObjectPollFirst = duration.isNegative() ? this.idleObjects.takeFirst() : this.idleObjects.pollFirst(duration);
                }
                if (pooledObjectPollFirst == null) {
                    throw new NoSuchElementException(appendStats("Timeout waiting for idle object, borrowMaxWaitDuration=" + duration));
                }
            } else if (pooledObjectPollFirst == null) {
                throw new NoSuchElementException(appendStats("Pool exhausted"));
            }
            if (!pooledObjectPollFirst.allocate()) {
                pooledObjectPollFirst = null;
            }
            if (pooledObjectPollFirst != null) {
                try {
                    this.factory.activateObject(pooledObjectPollFirst);
                } catch (Exception e) {
                    try {
                        destroy(pooledObjectPollFirst, DestroyMode.NORMAL);
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
                        zValidateObject = this.factory.validateObject(pooledObjectPollFirst);
                    } catch (Throwable th2) {
                        PoolUtils.checkRethrow(th2);
                        th = th2;
                    }
                    if (zValidateObject) {
                        continue;
                    } else {
                        try {
                            destroy(pooledObjectPollFirst, DestroyMode.NORMAL);
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
        }
        updateStatsBorrow(pooledObjectPollFirst, Duration.ofMillis(System.currentTimeMillis() - jCurrentTimeMillis));
        return pooledObjectPollFirst.getObject();
    }

    PooledObject<T> getPooledObject(T t) {
        return this.allObjects.get(new BaseGenericObjectPool.IdentityWrapper(t));
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    String getStatsString() {
        return super.getStatsString() + String.format(", createdCount=%,d, makeObjectCount=%,d, maxIdle=%,d, minIdle=%,d", Long.valueOf(this.createdCount.get()), Long.valueOf(this.makeObjectCount), Integer.valueOf(this.maxIdle), Integer.valueOf(this.minIdle));
    }

    public T borrowObject(long j) {
        return borrowObject(Duration.ofMillis(j));
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void clear() {
        PooledObject<T> pooledObjectPoll = this.idleObjects.poll();
        while (true) {
            PooledObject<T> pooledObject = pooledObjectPoll;
            if (pooledObject == null) {
                return;
            }
            try {
                destroy(pooledObject, DestroyMode.NORMAL);
            } catch (Exception e) {
                swallowException(e);
            }
            pooledObjectPoll = this.idleObjects.poll();
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
            this.idleObjects.interuptTakeWaiters();
        }
    }

    private PooledObject<T> create() {
        int maxTotal = getMaxTotal();
        if (maxTotal < 0) {
            maxTotal = Integer.MAX_VALUE;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jMax = Math.max(getMaxWaitDuration().toMillis(), 0L);
        Boolean bool = null;
        while (bool == null) {
            synchronized (this.makeObjectCountLock) {
                if (this.createCount.incrementAndGet() > maxTotal) {
                    this.createCount.decrementAndGet();
                    if (this.makeObjectCount == 0) {
                        bool = Boolean.FALSE;
                    } else {
                        this.makeObjectCountLock.wait(jMax);
                    }
                } else {
                    this.makeObjectCount++;
                    bool = Boolean.TRUE;
                }
            }
            if (bool == null && jMax > 0 && System.currentTimeMillis() - jCurrentTimeMillis >= jMax) {
                bool = Boolean.FALSE;
            }
        }
        try {
            if (!bool.booleanValue()) {
                return null;
            }
            try {
                PooledObject<T> pooledObjectMakeObject = this.factory.makeObject();
                if (getTestOnCreate() && !this.factory.validateObject(pooledObjectMakeObject)) {
                    this.createCount.decrementAndGet();
                    synchronized (this.makeObjectCountLock) {
                        this.makeObjectCount--;
                        this.makeObjectCountLock.notifyAll();
                    }
                    return null;
                }
                synchronized (this.makeObjectCountLock) {
                    this.makeObjectCount--;
                    this.makeObjectCountLock.notifyAll();
                }
                AbandonedConfig abandonedConfig = this.abandonedConfig;
                if (abandonedConfig != null && abandonedConfig.getLogAbandoned()) {
                    pooledObjectMakeObject.setLogAbandoned(true);
                    pooledObjectMakeObject.setRequireFullStackTrace(abandonedConfig.getRequireFullStackTrace());
                }
                this.createdCount.incrementAndGet();
                this.allObjects.put(new BaseGenericObjectPool.IdentityWrapper<>(pooledObjectMakeObject.getObject()), pooledObjectMakeObject);
                return pooledObjectMakeObject;
            } catch (Throwable th) {
                this.createCount.decrementAndGet();
                throw th;
            }
        } catch (Throwable th2) {
            synchronized (this.makeObjectCountLock) {
                this.makeObjectCount--;
                this.makeObjectCountLock.notifyAll();
                throw th2;
            }
        }
    }

    private void destroy(PooledObject<T> pooledObject, DestroyMode destroyMode) {
        pooledObject.invalidate();
        this.idleObjects.remove(pooledObject);
        this.allObjects.remove(new BaseGenericObjectPool.IdentityWrapper(pooledObject.getObject()));
        try {
            this.factory.destroyObject(pooledObject, destroyMode);
        } finally {
            this.destroyedCount.incrementAndGet();
            this.createCount.decrementAndGet();
        }
    }

    private void ensureIdle(int i, boolean z) {
        PooledObject<T> pooledObjectCreate;
        if (i < 1 || isClosed()) {
            return;
        }
        if (z || this.idleObjects.hasTakeWaiters()) {
            while (this.idleObjects.size() < i && (pooledObjectCreate = create()) != null) {
                if (getLifo()) {
                    this.idleObjects.addFirst(pooledObjectCreate);
                } else {
                    this.idleObjects.addLast(pooledObjectCreate);
                }
            }
            if (isClosed()) {
                clear();
            }
        }
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    void ensureMinIdle() {
        ensureIdle(getMinIdle(), true);
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    public void evict() {
        boolean zEvict;
        assertOpen();
        if (!this.idleObjects.isEmpty()) {
            EvictionPolicy<T> evictionPolicy = getEvictionPolicy();
            synchronized (this.evictionLock) {
                EvictionConfig evictionConfig = new EvictionConfig(getMinEvictableIdleDuration(), getSoftMinEvictableIdleDuration(), getMinIdle());
                boolean testWhileIdle = getTestWhileIdle();
                int i = 0;
                int numTests = getNumTests();
                while (i < numTests) {
                    if (this.evictionIterator == null || !this.evictionIterator.hasNext()) {
                        this.evictionIterator = new BaseGenericObjectPool.EvictionIterator(this.idleObjects);
                    }
                    if (!this.evictionIterator.hasNext()) {
                        return;
                    }
                    try {
                        PooledObject<T> next = this.evictionIterator.next();
                        if (next.startEvictionTest()) {
                            try {
                                zEvict = evictionPolicy.evict(evictionConfig, next, this.idleObjects.size());
                            } catch (Throwable th) {
                                PoolUtils.checkRethrow(th);
                                swallowException(new Exception(th));
                                zEvict = false;
                            }
                            if (zEvict) {
                                destroy(next, DestroyMode.NORMAL);
                                this.destroyedByEvictorCount.incrementAndGet();
                            } else {
                                if (testWhileIdle) {
                                    boolean z = false;
                                    try {
                                        this.factory.activateObject(next);
                                        z = true;
                                    } catch (Exception e) {
                                        destroy(next, DestroyMode.NORMAL);
                                        this.destroyedByEvictorCount.incrementAndGet();
                                    }
                                    if (z) {
                                        boolean zValidateObject = false;
                                        Throwable th2 = null;
                                        try {
                                            zValidateObject = this.factory.validateObject(next);
                                        } catch (Throwable th3) {
                                            PoolUtils.checkRethrow(th3);
                                            th2 = th3;
                                        }
                                        if (zValidateObject) {
                                            try {
                                                this.factory.passivateObject(next);
                                            } catch (Exception e2) {
                                                destroy(next, DestroyMode.NORMAL);
                                                this.destroyedByEvictorCount.incrementAndGet();
                                            }
                                        } else {
                                            destroy(next, DestroyMode.NORMAL);
                                            this.destroyedByEvictorCount.incrementAndGet();
                                            if (th2 != null) {
                                                if (!(th2 instanceof RuntimeException)) {
                                                    throw ((Error) th2);
                                                }
                                                throw ((RuntimeException) th2);
                                            }
                                        }
                                    }
                                }
                                if (!next.endEvictionTest(this.idleObjects)) {
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
                }
            }
        }
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        if (abandonedConfig == null || !abandonedConfig.getRemoveAbandonedOnMaintenance()) {
            return;
        }
        removeAbandoned(abandonedConfig);
    }

    public PooledObjectFactory<T> getFactory() {
        return this.factory;
    }

    @Override // org.apache.commons.pool2.impl.GenericObjectPoolMXBean
    public String getFactoryType() {
        if (this.factoryType == null) {
            this.factoryType = this.factory.getClass().getName() + '<' + PoolImplUtils.getFactoryType(this.factory.getClass()).getName() + '>';
        }
        return this.factoryType;
    }

    @Override // org.apache.commons.pool2.impl.GenericObjectPoolMXBean
    public int getMaxIdle() {
        return this.maxIdle;
    }

    @Override // org.apache.commons.pool2.impl.GenericObjectPoolMXBean
    public int getMinIdle() {
        int maxIdle = getMaxIdle();
        return this.minIdle > maxIdle ? maxIdle : this.minIdle;
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public int getNumActive() {
        return this.allObjects.size() - this.idleObjects.size();
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.KeyedObjectPool
    public int getNumIdle() {
        return this.idleObjects.size();
    }

    private int getNumTests() {
        int numTestsPerEvictionRun = getNumTestsPerEvictionRun();
        return numTestsPerEvictionRun >= 0 ? Math.min(numTestsPerEvictionRun, this.idleObjects.size()) : (int) Math.ceil(((double) this.idleObjects.size()) / Math.abs(numTestsPerEvictionRun));
    }

    @Override // org.apache.commons.pool2.impl.GenericObjectPoolMXBean
    public int getNumWaiters() {
        if (getBlockWhenExhausted()) {
            return this.idleObjects.getTakeQueueLength();
        }
        return 0;
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void invalidateObject(T t) {
        invalidateObject(t, DestroyMode.NORMAL);
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void invalidateObject(T t, DestroyMode destroyMode) {
        PooledObject<T> pooledObject = getPooledObject(t);
        if (pooledObject == null) {
            if (!isAbandonedConfig()) {
                throw new IllegalStateException("Invalidated object not currently part of this pool");
            }
        } else {
            synchronized (pooledObject) {
                if (pooledObject.getState() != PooledObjectState.INVALID) {
                    destroy(pooledObject, destroyMode);
                }
            }
            ensureIdle(1, false);
        }
    }

    @Override // org.apache.commons.pool2.impl.GenericObjectPoolMXBean
    public Set<DefaultPooledObjectInfo> listAllObjects() {
        return (Set) this.allObjects.values().stream().map(DefaultPooledObjectInfo::new).collect(Collectors.toSet());
    }

    public void preparePool() {
        if (getMinIdle() < 1) {
            return;
        }
        ensureMinIdle();
    }

    private void removeAbandoned(AbandonedConfig abandonedConfig) {
        createRemoveList(abandonedConfig, this.allObjects).forEach(pooledObject -> {
            if (abandonedConfig.getLogAbandoned()) {
                pooledObject.printStackTrace(abandonedConfig.getLogWriter());
            }
            try {
                invalidateObject(pooledObject.getObject(), DestroyMode.ABANDONED);
            } catch (Exception e) {
                swallowException(e);
            }
        });
    }

    @Override // org.apache.commons.pool2.ObjectPool
    public void returnObject(T t) {
        PooledObject<T> pooledObject = getPooledObject(t);
        if (pooledObject == null) {
            if (!isAbandonedConfig()) {
                throw new IllegalStateException("Returned object not currently part of this pool");
            }
            return;
        }
        markReturningState(pooledObject);
        Duration activeDuration = pooledObject.getActiveDuration();
        if (getTestOnReturn() && !this.factory.validateObject(pooledObject)) {
            try {
                destroy(pooledObject, DestroyMode.NORMAL);
            } catch (Exception e) {
                swallowException(e);
            }
            try {
                ensureIdle(1, false);
            } catch (Exception e2) {
                swallowException(e2);
            }
            updateStatsReturn(activeDuration);
            return;
        }
        try {
            this.factory.passivateObject(pooledObject);
            if (!pooledObject.deallocate()) {
                throw new IllegalStateException("Object has already been returned to this pool or is invalid");
            }
            int maxIdle = getMaxIdle();
            if (isClosed() || (maxIdle > -1 && maxIdle <= this.idleObjects.size())) {
                try {
                    destroy(pooledObject, DestroyMode.NORMAL);
                } catch (Exception e3) {
                    swallowException(e3);
                }
                try {
                    ensureIdle(1, false);
                } catch (Exception e4) {
                    swallowException(e4);
                }
            } else {
                if (getLifo()) {
                    this.idleObjects.addFirst(pooledObject);
                } else {
                    this.idleObjects.addLast(pooledObject);
                }
                if (isClosed()) {
                    clear();
                }
            }
            updateStatsReturn(activeDuration);
        } catch (Exception e5) {
            swallowException(e5);
            try {
                destroy(pooledObject, DestroyMode.NORMAL);
            } catch (Exception e6) {
                swallowException(e6);
            }
            try {
                ensureIdle(1, false);
            } catch (Exception e7) {
                swallowException(e7);
            }
            updateStatsReturn(activeDuration);
        }
    }

    public void setConfig(GenericObjectPoolConfig<T> genericObjectPoolConfig) {
        super.setConfig((BaseObjectPoolConfig) genericObjectPoolConfig);
        setMaxIdle(genericObjectPoolConfig.getMaxIdle());
        setMinIdle(genericObjectPoolConfig.getMinIdle());
        setMaxTotal(genericObjectPoolConfig.getMaxTotal());
    }

    public void setMaxIdle(int i) {
        this.maxIdle = i;
    }

    public void setMinIdle(int i) {
        this.minIdle = i;
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        super.toStringAppendFields(sb);
        sb.append(", factoryType=");
        sb.append(this.factoryType);
        sb.append(", maxIdle=");
        sb.append(this.maxIdle);
        sb.append(", minIdle=");
        sb.append(this.minIdle);
        sb.append(", factory=");
        sb.append(this.factory);
        sb.append(", allObjects=");
        sb.append(this.allObjects);
        sb.append(", createCount=");
        sb.append(this.createCount);
        sb.append(", idleObjects=");
        sb.append(this.idleObjects);
        sb.append(", abandonedConfig=");
        sb.append(this.abandonedConfig);
    }

    @Override // org.apache.commons.pool2.UsageTracking
    public void use(T t) {
        AbandonedConfig abandonedConfig = this.abandonedConfig;
        if (abandonedConfig == null || !abandonedConfig.getUseUsageTracking()) {
            return;
        }
        getPooledObject(t).use();
    }
}
