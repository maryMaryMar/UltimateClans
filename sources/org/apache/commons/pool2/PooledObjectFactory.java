package org.apache.commons.pool2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PooledObjectFactory.class */
public interface PooledObjectFactory<T> {
    void activateObject(PooledObject<T> pooledObject);

    void destroyObject(PooledObject<T> pooledObject);

    default void destroyObject(PooledObject<T> pooledObject, DestroyMode destroyMode) {
        destroyObject(pooledObject);
    }

    PooledObject<T> makeObject();

    void passivateObject(PooledObject<T> pooledObject);

    boolean validateObject(PooledObject<T> pooledObject);
}
