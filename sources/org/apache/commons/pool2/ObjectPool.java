package org.apache.commons.pool2;

import java.io.Closeable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/ObjectPool.class */
public interface ObjectPool<T> extends Closeable {
    void addObject();

    default void addObjects(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            addObject();
        }
    }

    T borrowObject();

    void clear();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getNumActive();

    int getNumIdle();

    void invalidateObject(T t);

    default void invalidateObject(T t, DestroyMode destroyMode) {
        invalidateObject(t);
    }

    void returnObject(T t);
}
