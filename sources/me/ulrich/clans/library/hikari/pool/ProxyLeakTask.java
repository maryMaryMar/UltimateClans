package me.ulrich.clans.library.hikari.pool;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyLeakTask.class */
class ProxyLeakTask implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger((Class<?>) ProxyLeakTask.class);
    static final ProxyLeakTask NO_LEAK = new ProxyLeakTask() { // from class: me.ulrich.clans.library.hikari.pool.ProxyLeakTask.1
        @Override // me.ulrich.clans.library.hikari.pool.ProxyLeakTask
        void schedule(ScheduledExecutorService scheduledExecutorService, long j) {
        }

        @Override // me.ulrich.clans.library.hikari.pool.ProxyLeakTask, java.lang.Runnable
        public void run() {
        }

        @Override // me.ulrich.clans.library.hikari.pool.ProxyLeakTask
        public void cancel() {
        }
    };
    private ScheduledFuture<?> scheduledFuture;
    private String connectionName;
    private Exception exception;
    private String threadName;
    private boolean isLeaked;

    ProxyLeakTask(PoolEntry poolEntry) {
        this.exception = new Exception("Apparent connection leak detected");
        this.threadName = Thread.currentThread().getName();
        this.connectionName = poolEntry.connection.toString();
    }

    private ProxyLeakTask() {
    }

    void schedule(ScheduledExecutorService scheduledExecutorService, long j) {
        this.scheduledFuture = scheduledExecutorService.schedule(this, j, TimeUnit.MILLISECONDS);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.isLeaked = true;
        StackTraceElement[] stackTrace = this.exception.getStackTrace();
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[stackTrace.length - 5];
        System.arraycopy(stackTrace, 5, stackTraceElementArr, 0, stackTraceElementArr.length);
        this.exception.setStackTrace(stackTraceElementArr);
        LOGGER.warn("Connection leak detection triggered for {} on thread {}, stack trace follows", this.connectionName, this.threadName, this.exception);
    }

    void cancel() {
        this.scheduledFuture.cancel(false);
        if (this.isLeaked) {
            LOGGER.info("Previously reported leaked connection {} on thread {} was returned to the pool (unleaked)", this.connectionName, this.threadName);
        }
    }
}
