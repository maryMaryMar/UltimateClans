package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.PooledObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/EvictionPolicy.class */
public interface EvictionPolicy<T> {
    boolean evict(EvictionConfig evictionConfig, PooledObject<T> pooledObject, int i);
}
