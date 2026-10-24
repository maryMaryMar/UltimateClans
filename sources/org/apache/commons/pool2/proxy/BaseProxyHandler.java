package org.apache.commons.pool2.proxy;

import java.lang.reflect.Method;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/BaseProxyHandler.class */
class BaseProxyHandler<T> {
    private volatile T pooledObject;
    private final UsageTracking<T> usageTracking;

    BaseProxyHandler(T t, UsageTracking<T> usageTracking) {
        this.pooledObject = t;
        this.usageTracking = usageTracking;
    }

    T disableProxy() {
        T t = this.pooledObject;
        this.pooledObject = null;
        return t;
    }

    Object doInvoke(Method method, Object[] objArr) {
        validateProxiedObject();
        T pooledObject = getPooledObject();
        if (this.usageTracking != null) {
            this.usageTracking.use(pooledObject);
        }
        return method.invoke(pooledObject, objArr);
    }

    T getPooledObject() {
        return this.pooledObject;
    }

    public String toString() {
        return getClass().getName() + " [pooledObject=" + this.pooledObject + ", usageTracking=" + this.usageTracking + "]";
    }

    void validateProxiedObject() {
        if (this.pooledObject == null) {
            throw new IllegalStateException("This object may no longer be used as it has been returned to the Object Pool.");
        }
    }
}
