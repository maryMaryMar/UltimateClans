package org.apache.commons.pool2.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.pool2.BaseObjectPool;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.PooledObjectFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/SoftReferenceObjectPool.class */
public class SoftReferenceObjectPool<T> extends BaseObjectPool<T> {
    private final PooledObjectFactory<T> factory;
    private int numActive;
    private long destroyCount;
    private long createCount;
    private final ReferenceQueue<T> refQueue = new ReferenceQueue<>();
    private final LinkedBlockingDeque<PooledSoftReference<T>> idleReferences = new LinkedBlockingDeque<>();
    private final ArrayList<PooledSoftReference<T>> allReferences = new ArrayList<>();

    public SoftReferenceObjectPool(PooledObjectFactory<T> pooledObjectFactory) {
        this.factory = pooledObjectFactory;
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool
    public synchronized void addObject() {
        assertOpen();
        if (this.factory == null) {
            throw new IllegalStateException("Cannot add objects without a factory.");
        }
        T object = this.factory.makeObject().getObject();
        this.createCount++;
        PooledSoftReference<T> pooledSoftReference = new PooledSoftReference<>(new SoftReference(object, this.refQueue));
        this.allReferences.add(pooledSoftReference);
        boolean z = true;
        if (this.factory.validateObject(pooledSoftReference)) {
            this.factory.passivateObject(pooledSoftReference);
        } else {
            z = false;
        }
        boolean z2 = !z;
        if (z) {
            this.idleReferences.add(pooledSoftReference);
            notifyAll();
        }
        if (z2) {
            try {
                destroy(pooledSoftReference);
            } catch (Exception e) {
            }
        }
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool
    public synchronized T borrowObject() {
        assertOpen();
        T object = null;
        boolean z = false;
        PooledSoftReference<T> pooledSoftReferencePollFirst = null;
        while (null == object) {
            if (!this.idleReferences.isEmpty()) {
                pooledSoftReferencePollFirst = this.idleReferences.pollFirst();
                object = pooledSoftReferencePollFirst.getObject();
                pooledSoftReferencePollFirst.getReference().clear();
                pooledSoftReferencePollFirst.setReference(new SoftReference<>(object));
            } else {
                if (null == this.factory) {
                    throw new NoSuchElementException();
                }
                z = true;
                object = this.factory.makeObject().getObject();
                this.createCount++;
                pooledSoftReferencePollFirst = new PooledSoftReference<>(new SoftReference(object));
                this.allReferences.add(pooledSoftReferencePollFirst);
            }
            if (null != this.factory && null != object) {
                try {
                    this.factory.activateObject(pooledSoftReferencePollFirst);
                    if (!this.factory.validateObject(pooledSoftReferencePollFirst)) {
                        throw new Exception("ValidateObject failed");
                    }
                } catch (Throwable th) {
                    PoolUtils.checkRethrow(th);
                    try {
                        try {
                            destroy(pooledSoftReferencePollFirst);
                            object = null;
                        } catch (Throwable th2) {
                            PoolUtils.checkRethrow(th2);
                            object = null;
                        }
                        if (z) {
                            throw new NoSuchElementException("Could not create a validated object, cause: " + th);
                        }
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
        this.numActive++;
        pooledSoftReferencePollFirst.allocate();
        return object;
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool
    public synchronized void clear() {
        if (null != this.factory) {
            this.idleReferences.forEach(pooledSoftReference -> {
                try {
                    if (null != pooledSoftReference.getObject()) {
                        this.factory.destroyObject(pooledSoftReference);
                    }
                } catch (Exception e) {
                }
            });
        }
        this.idleReferences.clear();
        pruneClearedReferences();
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        clear();
    }

    private void destroy(PooledSoftReference<T> pooledSoftReference) {
        pooledSoftReference.invalidate();
        this.idleReferences.remove(pooledSoftReference);
        this.allReferences.remove(pooledSoftReference);
        try {
            this.factory.destroyObject(pooledSoftReference);
        } finally {
            this.destroyCount++;
            pooledSoftReference.getReference().clear();
        }
    }

    private PooledSoftReference<T> findReference(T t) {
        return (PooledSoftReference) this.allReferences.stream().filter(pooledSoftReference -> {
            return pooledSoftReference.getObject() != null && pooledSoftReference.getObject().equals(t);
        }).findFirst().orElse(null);
    }

    public synchronized PooledObjectFactory<T> getFactory() {
        return this.factory;
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool
    public synchronized int getNumActive() {
        return this.numActive;
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool
    public synchronized int getNumIdle() {
        pruneClearedReferences();
        return this.idleReferences.size();
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool
    public synchronized void invalidateObject(T t) {
        PooledSoftReference<T> pooledSoftReferenceFindReference = findReference(t);
        if (pooledSoftReferenceFindReference == null) {
            throw new IllegalStateException("Object to invalidate is not currently part of this pool");
        }
        if (this.factory != null) {
            destroy(pooledSoftReferenceFindReference);
        }
        this.numActive--;
        notifyAll();
    }

    private void pruneClearedReferences() {
        removeClearedReferences(this.idleReferences.iterator());
        removeClearedReferences(this.allReferences.iterator());
        while (this.refQueue.poll() != null) {
        }
    }

    private void removeClearedReferences(Iterator<PooledSoftReference<T>> it) {
        while (it.hasNext()) {
            PooledSoftReference<T> next = it.next();
            if (next.getReference() == null || next.getReference().isEnqueued()) {
                it.remove();
            }
        }
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.ObjectPool
    public synchronized void returnObject(T t) {
        boolean z = !isClosed();
        PooledSoftReference<T> pooledSoftReferenceFindReference = findReference(t);
        if (pooledSoftReferenceFindReference == null) {
            throw new IllegalStateException("Returned object not currently part of this pool");
        }
        if (this.factory != null) {
            if (this.factory.validateObject(pooledSoftReferenceFindReference)) {
                try {
                    this.factory.passivateObject(pooledSoftReferenceFindReference);
                } catch (Exception e) {
                    z = false;
                }
            } else {
                z = false;
            }
        }
        boolean z2 = !z;
        this.numActive--;
        if (z) {
            pooledSoftReferenceFindReference.deallocate();
            this.idleReferences.add(pooledSoftReferenceFindReference);
        }
        notifyAll();
        if (!z2 || this.factory == null) {
            return;
        }
        try {
            destroy(pooledSoftReferenceFindReference);
        } catch (Exception e2) {
        }
    }

    @Override // org.apache.commons.pool2.BaseObjectPool, org.apache.commons.pool2.BaseObject
    protected void toStringAppendFields(StringBuilder sb) {
        super.toStringAppendFields(sb);
        sb.append(", factory=");
        sb.append(this.factory);
        sb.append(", refQueue=");
        sb.append(this.refQueue);
        sb.append(", numActive=");
        sb.append(this.numActive);
        sb.append(", destroyCount=");
        sb.append(this.destroyCount);
        sb.append(", createCount=");
        sb.append(this.createCount);
        sb.append(", idleReferences=");
        sb.append(this.idleReferences);
        sb.append(", allReferences=");
        sb.append(this.allReferences);
    }
}
