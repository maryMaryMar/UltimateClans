package org.apache.commons.pool2.impl;

import java.lang.ref.WeakReference;
import java.security.AccessController;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/EvictionTimer.class */
class EvictionTimer {
    private static ScheduledThreadPoolExecutor executor;
    private static final HashMap<WeakReference<Runnable>, WeakRunner> taskMap = new HashMap<>();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/EvictionTimer$EvictorThreadFactory.class */
    private static class EvictorThreadFactory implements ThreadFactory {
        private EvictorThreadFactory() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(null, runnable, "commons-pool-evictor");
            thread.setDaemon(true);
            AccessController.doPrivileged(() -> {
                thread.setContextClassLoader(EvictorThreadFactory.class.getClassLoader());
                return null;
            });
            return thread;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/EvictionTimer$Reaper.class */
    private static class Reaper implements Runnable {
        private Reaper() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (EvictionTimer.class) {
                for (Map.Entry entry : EvictionTimer.taskMap.entrySet()) {
                    if (((WeakReference) entry.getKey()).get() == null) {
                        EvictionTimer.executor.remove((Runnable) entry.getValue());
                        EvictionTimer.taskMap.remove(entry.getKey());
                    }
                }
                if (EvictionTimer.taskMap.isEmpty() && EvictionTimer.executor != null) {
                    EvictionTimer.executor.shutdown();
                    EvictionTimer.executor.setCorePoolSize(0);
                    ScheduledThreadPoolExecutor unused = EvictionTimer.executor = null;
                }
            }
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:org/apache/commons/pool2/impl/EvictionTimer$WeakRunner.class */
    private static class WeakRunner implements Runnable {
        private final WeakReference<Runnable> ref;

        private WeakRunner(WeakReference<Runnable> weakReference) {
            this.ref = weakReference;
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = this.ref.get();
            if (runnable != null) {
                runnable.run();
            } else {
                EvictionTimer.executor.remove(this);
                EvictionTimer.taskMap.remove(this.ref);
            }
        }
    }

    static synchronized void cancel(BaseGenericObjectPool<?>.Evictor evictor, Duration duration, boolean z) {
        if (evictor != null) {
            evictor.cancel();
            remove(evictor);
        }
        if (z || executor == null || !taskMap.isEmpty()) {
            return;
        }
        executor.shutdown();
        try {
            executor.awaitTermination(duration.toMillis(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
        }
        executor.setCorePoolSize(0);
        executor = null;
    }

    static synchronized int getNumTasks() {
        return taskMap.size();
    }

    private static void remove(BaseGenericObjectPool<?>.Evictor evictor) {
        for (Map.Entry<WeakReference<Runnable>, WeakRunner> entry : taskMap.entrySet()) {
            if (entry.getKey().get() == evictor) {
                executor.remove(entry.getValue());
                taskMap.remove(entry.getKey());
                return;
            }
        }
    }

    static synchronized void schedule(BaseGenericObjectPool<?>.Evictor evictor, Duration duration, Duration duration2) {
        if (null == executor) {
            executor = new ScheduledThreadPoolExecutor(1, new EvictorThreadFactory());
            executor.setRemoveOnCancelPolicy(true);
            executor.scheduleAtFixedRate(new Reaper(), duration.toMillis(), duration2.toMillis(), TimeUnit.MILLISECONDS);
        }
        WeakReference<Runnable> weakReference = new WeakReference<>(evictor);
        WeakRunner weakRunner = new WeakRunner(weakReference);
        evictor.setScheduledFuture(executor.scheduleWithFixedDelay(weakRunner, duration.toMillis(), duration2.toMillis(), TimeUnit.MILLISECONDS));
        taskMap.put(weakReference, weakRunner);
    }

    private EvictionTimer() {
    }

    public String toString() {
        return "EvictionTimer []";
    }
}
