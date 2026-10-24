package org.apache.commons.pool2.proxy;

import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/ProxySource.class */
interface ProxySource<T> {
    T createProxy(T t, UsageTracking<T> usageTracking);

    T resolveProxy(T t);
}
