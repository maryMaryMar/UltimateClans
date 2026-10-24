package org.apache.commons.pool2.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/JdkProxyHandler.class */
class JdkProxyHandler<T> extends BaseProxyHandler<T> implements InvocationHandler {
    JdkProxyHandler(T t, UsageTracking<T> usageTracking) {
        super(t, usageTracking);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object obj, Method method, Object[] objArr) {
        return doInvoke(method, objArr);
    }
}
