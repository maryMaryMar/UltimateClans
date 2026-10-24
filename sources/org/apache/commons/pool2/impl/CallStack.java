package org.apache.commons.pool2.impl;

import java.io.PrintWriter;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/CallStack.class */
public interface CallStack {
    void clear();

    void fillInStackTrace();

    boolean printStackTrace(PrintWriter printWriter);
}
