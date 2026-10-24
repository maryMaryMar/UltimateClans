package org.apache.commons.pool2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/KeyedPooledObjectFactory.class */
public interface KeyedPooledObjectFactory<K, V> {
    void activateObject(K k, PooledObject<V> pooledObject);

    void destroyObject(K k, PooledObject<V> pooledObject);

    default void destroyObject(K k, PooledObject<V> pooledObject, DestroyMode destroyMode) {
        destroyObject(k, pooledObject);
    }

    PooledObject<V> makeObject(K k);

    void passivateObject(K k, PooledObject<V> pooledObject);

    boolean validateObject(K k, PooledObject<V> pooledObject);
}
