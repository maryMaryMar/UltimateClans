package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.PooledObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/DefaultEvictionPolicy.class */
public class DefaultEvictionPolicy<T> implements EvictionPolicy<T> {
    @Override // org.apache.commons.pool2.impl.EvictionPolicy
    public boolean evict(EvictionConfig evictionConfig, PooledObject<T> pooledObject, int i) {
        return (evictionConfig.getIdleSoftEvictDuration().compareTo(pooledObject.getIdleDuration()) < 0 && evictionConfig.getMinIdle() < i) || evictionConfig.getIdleEvictDuration().compareTo(pooledObject.getIdleDuration()) < 0;
    }
}
