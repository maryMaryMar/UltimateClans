package org.apache.commons.pool2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/BaseKeyedPooledObjectFactory.class */
public abstract class BaseKeyedPooledObjectFactory<K, V> extends BaseObject implements KeyedPooledObjectFactory<K, V> {
    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    public void activateObject(K k, PooledObject<V> pooledObject) {
    }

    public abstract V create(K k);

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    public void destroyObject(K k, PooledObject<V> pooledObject) {
    }

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    public PooledObject<V> makeObject(K k) {
        return wrap(create(k));
    }

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    public void passivateObject(K k, PooledObject<V> pooledObject) {
    }

    @Override // org.apache.commons.pool2.KeyedPooledObjectFactory
    public boolean validateObject(K k, PooledObject<V> pooledObject) {
        return true;
    }

    public abstract PooledObject<V> wrap(V v);
}
