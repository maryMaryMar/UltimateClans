package org.apache.commons.pool2.impl;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/InterruptibleReentrantLock.class */
class InterruptibleReentrantLock extends ReentrantLock {
    private static final long serialVersionUID = 1;

    public InterruptibleReentrantLock(boolean z) {
        super(z);
    }

    public void interruptWaiters(Condition condition) {
        getWaitingThreads(condition).forEach((v0) -> {
            v0.interrupt();
        });
    }
}
