package org.apache.commons.pool2.proxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/CglibProxyHandler.class */
class CglibProxyHandler<T> extends BaseProxyHandler<T> implements MethodInterceptor {
    CglibProxyHandler(T t, UsageTracking<T> usageTracking) {
        super(t, usageTracking);
    }

    public Object intercept(Object obj, Method method, Object[] objArr, MethodProxy methodProxy) {
        return doInvoke(method, objArr);
    }
}
