package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/SecurityManagerCallStack.class */
public class SecurityManagerCallStack implements CallStack {
    private final String messageFormat;
    private final DateFormat dateFormat;
    private final PrivateSecurityManager securityManager;
    private volatile Snapshot snapshot;

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/SecurityManagerCallStack$PrivateSecurityManager.class */
    private static class PrivateSecurityManager extends SecurityManager {
        private PrivateSecurityManager() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<WeakReference<Class<?>>> getCallStack() {
            return (List) Stream.of((Object[]) getClassContext()).map((v1) -> {
                return new WeakReference(v1);
            }).collect(Collectors.toList());
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/SecurityManagerCallStack$Snapshot.class */
    private static class Snapshot {
        private final long timestampMillis;
        private final List<WeakReference<Class<?>>> stack;

        private Snapshot(List<WeakReference<Class<?>>> list) {
            this.timestampMillis = System.currentTimeMillis();
            this.stack = list;
        }
    }

    public SecurityManagerCallStack(String str, boolean z) {
        this.messageFormat = str;
        this.dateFormat = z ? new SimpleDateFormat(str) : null;
        this.securityManager = (PrivateSecurityManager) AccessController.doPrivileged(() -> {
            return new PrivateSecurityManager();
        });
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public void clear() {
        this.snapshot = null;
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public void fillInStackTrace() {
        this.snapshot = new Snapshot(this.securityManager.getCallStack());
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    public boolean printStackTrace(PrintWriter printWriter) {
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
        snapshot.stack.forEach(weakReference -> {
            printWriter.println(weakReference.get());
        });
        return true;
    }
}
