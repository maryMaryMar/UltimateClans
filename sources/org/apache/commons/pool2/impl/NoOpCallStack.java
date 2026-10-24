package org.apache.commons.pool2.impl;

import java.io.PrintWriter;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/NoOpCallStack.class */
public class NoOpCallStack implements CallStack {
    public static final CallStack INSTANCE = new NoOpCallStack();

    private NoOpCallStack() {
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public void clear() {
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public void fillInStackTrace() {
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public boolean printStackTrace(PrintWriter printWriter) {
        return false;
    }
}
