package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/ThrowableCallStack.class */
public class ThrowableCallStack implements CallStack {
    private final String messageFormat;
    private final DateFormat dateFormat;
    private volatile Snapshot snapshot;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/ThrowableCallStack$Snapshot.class */
    private static class Snapshot extends Throwable {
        private static final long serialVersionUID = 1;
        private final long timestampMillis;

        private Snapshot() {
            this.timestampMillis = System.currentTimeMillis();
        }
    }

    public ThrowableCallStack(String str, boolean z) {
        this.messageFormat = str;
        this.dateFormat = z ? new SimpleDateFormat(str) : null;
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public void clear() {
        this.snapshot = null;
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public void fillInStackTrace() {
        this.snapshot = new Snapshot();
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public synchronized boolean printStackTrace(PrintWriter printWriter) {
        String str;
        Snapshot snapshot = this.snapshot;
        if (snapshot == null) {
            return false;
        }
        if (this.dateFormat == null) {
            str = this.messageFormat;
        } else {
            synchronized (this.dateFormat) {
                str = this.dateFormat.format(Long.valueOf(snapshot.timestampMillis));
            }
        }
        printWriter.println(str);
        snapshot.printStackTrace(printWriter);
        return true;
    }
}
