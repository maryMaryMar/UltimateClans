package me.ulrich.clans.library.hikari.pool;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/hikari/pool/ProxyLeakTaskFactory.class */
class ProxyLeakTaskFactory {
    private ScheduledExecutorService executorService;
    private long leakDetectionThreshold;

    ProxyLeakTaskFactory(long j, ScheduledExecutorService scheduledExecutorService) {
        this.executorService = scheduledExecutorService;
        this.leakDetectionThreshold = j;
    }

    ProxyLeakTask schedule(PoolEntry poolEntry) {
        return this.leakDetectionThreshold == 0 ? ProxyLeakTask.NO_LEAK : scheduleNewTask(poolEntry);
    }

    void updateLeakDetectionThreshold(long j) {
        this.leakDetectionThreshold = j;
    }

    private ProxyLeakTask scheduleNewTask(PoolEntry poolEntry) {
        ProxyLeakTask proxyLeakTask = new ProxyLeakTask(poolEntry);
        proxyLeakTask.schedule(this.executorService, this.leakDetectionThreshold);
        return proxyLeakTask;
    }
}
