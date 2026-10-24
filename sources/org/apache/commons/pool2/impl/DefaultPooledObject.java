package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.Deque;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.TrackedUse;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/DefaultPooledObject.class */
public class DefaultPooledObject<T> implements PooledObject<T> {
    private final T object;
    private volatile boolean logAbandoned;
    private volatile long borrowedCount;
    private PooledObjectState state = PooledObjectState.IDLE;
    private final Clock systemClock = Clock.systemUTC();
    private final Instant createInstant = now();
    private volatile Instant lastBorrowInstant = this.createInstant;
    private volatile Instant lastUseInstant = this.createInstant;
    private volatile Instant lastReturnInstant = this.createInstant;
    private volatile CallStack borrowedBy = NoOpCallStack.INSTANCE;
    private volatile CallStack usedBy = NoOpCallStack.INSTANCE;

    public DefaultPooledObject(T t) {
        this.object = t;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized boolean allocate() {
        if (this.state != PooledObjectState.IDLE) {
            if (this.state != PooledObjectState.EVICTION) {
                return false;
            }
            this.state = PooledObjectState.EVICTION_RETURN_TO_HEAD;
            return false;
        }
        this.state = PooledObjectState.ALLOCATED;
        this.lastBorrowInstant = now();
        this.lastUseInstant = this.lastBorrowInstant;
        this.borrowedCount++;
        if (!this.logAbandoned) {
            return true;
        }
        this.borrowedBy.fillInStackTrace();
        return true;
    }

    @Override // org.apache.commons.pool2.PooledObject, java.lang.Comparable
    public int compareTo(PooledObject<T> pooledObject) {
        int iCompareTo = getLastReturnInstant().compareTo(pooledObject.getLastReturnInstant());
        return iCompareTo == 0 ? System.identityHashCode(this) - System.identityHashCode(pooledObject) : iCompareTo;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized boolean deallocate() {
        if (this.state != PooledObjectState.ALLOCATED && this.state != PooledObjectState.RETURNING) {
            return false;
        }
        this.state = PooledObjectState.IDLE;
        this.lastReturnInstant = now();
        this.borrowedBy.clear();
        return true;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized boolean endEvictionTest(Deque<PooledObject<T>> deque) {
        if (this.state == PooledObjectState.EVICTION) {
            this.state = PooledObjectState.IDLE;
            return true;
        }
        if (this.state != PooledObjectState.EVICTION_RETURN_TO_HEAD) {
            return false;
        }
        this.state = PooledObjectState.IDLE;
        if (!deque.offerFirst(this)) {
        }
        return false;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public long getActiveTimeMillis() {
        return getActiveDuration().toMillis();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public long getBorrowedCount() {
        return this.borrowedCount;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public Instant getCreateInstant() {
        return this.createInstant;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public long getCreateTime() {
        return this.createInstant.toEpochMilli();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public Duration getIdleDuration() {
        Duration durationBetween = Duration.between(this.lastReturnInstant, now());
        return durationBetween.isNegative() ? Duration.ZERO : durationBetween;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public Duration getIdleTime() {
        return getIdleDuration();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public long getIdleTimeMillis() {
        return getIdleDuration().toMillis();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public Instant getLastBorrowInstant() {
        return this.lastBorrowInstant;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public long getLastBorrowTime() {
        return this.lastBorrowInstant.toEpochMilli();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public Instant getLastReturnInstant() {
        return this.lastReturnInstant;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public long getLastReturnTime() {
        return this.lastReturnInstant.toEpochMilli();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public Instant getLastUsedInstant() {
        return this.object instanceof TrackedUse ? PoolImplUtils.max(((TrackedUse) this.object).getLastUsedInstant(), this.lastUseInstant) : this.lastUseInstant;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public long getLastUsedTime() {
        return getLastUsedInstant().toEpochMilli();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public T getObject() {
        return this.object;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized PooledObjectState getState() {
        return this.state;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized void invalidate() {
        this.state = PooledObjectState.INVALID;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized void markAbandoned() {
        this.state = PooledObjectState.ABANDONED;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized void markReturning() {
        this.state = PooledObjectState.RETURNING;
    }

    private Instant now() {
        return this.systemClock.instant();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public void printStackTrace(PrintWriter printWriter) {
        if (this.borrowedBy.printStackTrace(printWriter) || this.usedBy.printStackTrace(printWriter)) {
            printWriter.flush();
        }
    }

    @Override // org.apache.commons.pool2.PooledObject
    public void setLogAbandoned(boolean z) {
        this.logAbandoned = z;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public void setRequireFullStackTrace(boolean z) {
        this.borrowedBy = CallStackUtils.newCallStack("'Pooled object created' yyyy-MM-dd HH:mm:ss Z 'by the following code has not been returned to the pool:'", true, z);
        this.usedBy = CallStackUtils.newCallStack("The last code to use this object was:", false, z);
    }

    @Override // org.apache.commons.pool2.PooledObject
    public synchronized boolean startEvictionTest() {
        if (this.state != PooledObjectState.IDLE) {
            return false;
        }
        this.state = PooledObjectState.EVICTION;
        return true;
    }

    @Override // org.apache.commons.pool2.PooledObject
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Object: ");
        sb.append(this.object.toString());
        sb.append(", State: ");
        synchronized (this) {
            sb.append(this.state.toString());
        }
        return sb.toString();
    }

    @Override // org.apache.commons.pool2.PooledObject
    public void use() {
        this.lastUseInstant = now();
        this.usedBy.fillInStackTrace();
    }
}
