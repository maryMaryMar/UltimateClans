package org.apache.commons.pool2;

import java.io.PrintWriter;
import java.time.Duration;
import java.time.Instant;
import java.util.Deque;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PooledObject.class */
public interface PooledObject<T> extends Comparable<PooledObject<T>> {
    boolean allocate();

    @Override // java.lang.Comparable
    int compareTo(PooledObject<T> pooledObject);

    boolean deallocate();

    boolean endEvictionTest(Deque<PooledObject<T>> deque);

    boolean equals(Object obj);

    default Duration getActiveDuration() {
        Instant lastReturnInstant = getLastReturnInstant();
        Instant lastBorrowInstant = getLastBorrowInstant();
        return lastReturnInstant.isAfter(lastBorrowInstant) ? Duration.between(lastBorrowInstant, lastReturnInstant) : Duration.between(lastBorrowInstant, Instant.now());
    }

    @Deprecated
    default Duration getActiveTime() {
        return getActiveDuration();
    }

    @Deprecated
    long getActiveTimeMillis();

    default long getBorrowedCount() {
        return -1L;
    }

    default Instant getCreateInstant() {
        return Instant.ofEpochMilli(getCreateTime());
    }

    @Deprecated
    long getCreateTime();

    default Duration getIdleDuration() {
        return Duration.ofMillis(getIdleTimeMillis());
    }

    @Deprecated
    default Duration getIdleTime() {
        return Duration.ofMillis(getIdleTimeMillis());
    }

    @Deprecated
    long getIdleTimeMillis();

    default Instant getLastBorrowInstant() {
        return Instant.ofEpochMilli(getLastBorrowTime());
    }

    @Deprecated
    long getLastBorrowTime();

    default Instant getLastReturnInstant() {
        return Instant.ofEpochMilli(getLastReturnTime());
    }

    @Deprecated
    long getLastReturnTime();

    default Instant getLastUsedInstant() {
        return Instant.ofEpochMilli(getLastUsedTime());
    }

    @Deprecated
    long getLastUsedTime();

    T getObject();

    PooledObjectState getState();

    int hashCode();

    void invalidate();

    void markAbandoned();

    void markReturning();

    void printStackTrace(PrintWriter printWriter);

    void setLogAbandoned(boolean z);

    default void setRequireFullStackTrace(boolean z) {
    }

    boolean startEvictionTest();

    String toString();

    void use();
}
