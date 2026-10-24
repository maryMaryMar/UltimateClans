package org.apache.commons.pool2.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/CglibProxySource.class */
public class CglibProxySource<T> implements ProxySource<T> {
    private final Class<? extends T> superclass;

    public CglibProxySource(Class<? extends T> cls) {
        this.superclass = cls;
    }

    @Override // org.apache.commons.pool2.proxy.ProxySource
    public T createProxy(T t, UsageTracking<T> usageTracking) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.superclass);
        enhancer.setCallback(new CglibProxyHandler(t, usageTracking));
        return (T) enhancer.create();
    }

    @Override // org.apache.commons.pool2.proxy.ProxySource
    public T resolveProxy(T t) {
        return ((Factory) t).getCallback(0).disableProxy();
    }

    public String toString() {
        return "CglibProxySource [superclass=" + this.superclass + "]";
    }
}
