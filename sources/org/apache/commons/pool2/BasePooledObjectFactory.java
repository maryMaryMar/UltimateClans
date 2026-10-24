package org.apache.commons.pool2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/BasePooledObjectFactory.class */
public abstract class BasePooledObjectFactory<T> extends BaseObject implements PooledObjectFactory<T> {
    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void activateObject(PooledObject<T> pooledObject) {
    }

    public abstract T create();

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void destroyObject(PooledObject<T> pooledObject) {
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public PooledObject<T> makeObject() {
        return wrap(create());
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public void passivateObject(PooledObject<T> pooledObject) {
    }

    @Override // org.apache.commons.pool2.PooledObjectFactory
    public boolean validateObject(PooledObject<T> pooledObject) {
        return true;
    }

    public abstract PooledObject<T> wrap(T t);
}
