package org.apache.commons.pool2.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;
import org.apache.commons.pool2.UsageTracking;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/proxy/JdkProxySource.class */
public class JdkProxySource<T> implements ProxySource<T> {
    private final ClassLoader classLoader;
    private final Class<?>[] interfaces;

    public JdkProxySource(ClassLoader classLoader, Class<?>[] clsArr) {
        this.classLoader = classLoader;
        this.interfaces = new Class[clsArr.length];
        System.arraycopy(clsArr, 0, this.interfaces, 0, clsArr.length);
    }

    @Override // org.apache.commons.pool2.proxy.ProxySource
    public T createProxy(T t, UsageTracking<T> usageTracking) {
        return (T) Proxy.newProxyInstance(this.classLoader, this.interfaces, new JdkProxyHandler(t, usageTracking));
    }

    @Override // org.apache.commons.pool2.proxy.ProxySource
    public T resolveProxy(T t) {
        return ((JdkProxyHandler) Proxy.getInvocationHandler(t)).disableProxy();
    }

    public String toString() {
        return "JdkProxySource [classLoader=" + this.classLoader + ", interfaces=" + Arrays.toString(this.interfaces) + "]";
    }
}
