package org.apache.commons.pool2;

import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/KeyedObjectPool.class */
public interface KeyedObjectPool<K, V> extends Closeable {
    void addObject(K k);

    default void addObjects(Collection<K> collection, int i) {
        if (collection == null) {
            throw new IllegalArgumentException("keys must not be null.");
        }
        Iterator<K> it = collection.iterator();
        while (it.hasNext()) {
            addObjects(it.next(), i);
        }
    }

    default void addObjects(K k, int i) {
        if (k == null) {
            throw new IllegalArgumentException("key must not be null.");
        }
        for (int i2 = 0; i2 < i; i2++) {
            addObject(k);
        }
    }

    V borrowObject(K k);

    void clear();

    void clear(K k);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getNumActive();

    int getNumActive(K k);

    int getNumIdle();

    int getNumIdle(K k);

    void invalidateObject(K k, V v);

    default void invalidateObject(K k, V v, DestroyMode destroyMode) {
        invalidateObject(k, v);
    }

    void returnObject(K k, V v);
}
