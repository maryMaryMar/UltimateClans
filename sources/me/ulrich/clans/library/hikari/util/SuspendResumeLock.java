package me.ulrich.clans.library.hikari.util;

import java.sql.SQLTransientException;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/util/SuspendResumeLock.class */
public class SuspendResumeLock {
    public static final SuspendResumeLock FAUX_LOCK = new SuspendResumeLock(false) { // from class: me.ulrich.clans.library.hikari.util.SuspendResumeLock.1
        @Override // me.ulrich.clans.library.hikari.util.SuspendResumeLock
        public void acquire() {
        }

        @Override // me.ulrich.clans.library.hikari.util.SuspendResumeLock
        public void release() {
        }

        @Override // me.ulrich.clans.library.hikari.util.SuspendResumeLock
        public void suspend() {
        }

        @Override // me.ulrich.clans.library.hikari.util.SuspendResumeLock
        public void resume() {
        }
    };
    private static final int MAX_PERMITS = 10000;
    private final Semaphore acquisitionSemaphore;

    public SuspendResumeLock() {
        this(true);
    }

    private SuspendResumeLock(boolean z) {
        this.acquisitionSemaphore = z ? new Semaphore(MAX_PERMITS, true) : null;
    }

    public void acquire() throws SQLTransientException {
        if (this.acquisitionSemaphore.tryAcquire()) {
            return;
        }
        if (Boolean.getBoolean("me.ulrich.clans.library.hikari.throwIfSuspended")) {
            throw new SQLTransientException("The pool is currently suspended and configured to throw exceptions upon acquisition");
        }
        this.acquisitionSemaphore.acquireUninterruptibly();
    }

    public void release() {
        this.acquisitionSemaphore.release();
    }

    public void suspend() {
        this.acquisitionSemaphore.acquireUninterruptibly(MAX_PERMITS);
    }

    public void resume() {
        this.acquisitionSemaphore.release(MAX_PERMITS);
    }
}
