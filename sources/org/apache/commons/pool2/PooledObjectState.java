package org.apache.commons.pool2;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/PooledObjectState.class */
public enum PooledObjectState {
    IDLE,
    ALLOCATED,
    EVICTION,
    EVICTION_RETURN_TO_HEAD,
    VALIDATION,
    VALIDATION_PREALLOCATED,
    VALIDATION_RETURN_TO_HEAD,
    INVALID,
    ABANDONED,
    RETURNING
}
