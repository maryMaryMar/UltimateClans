package me.ulrich.clans.tasks;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/AsyncTaskExecutor.class */
public class AsyncTaskExecutor {
    private final int THREADS = 2;
    private final ExecutorService executor = Executors.newFixedThreadPool(2, runnable -> {
        Thread thread = new Thread(runnable);
        thread.setName("Clans-Async");
        thread.setUncaughtExceptionHandler((thread2, th) -> {
            th.printStackTrace();
        });
        return thread;
    });
    private final UUID GLOBAL_KEY = UUID.fromString("00000000-0000-0000-0000-000000000000");
    private final ConcurrentHashMap<UUID, Ijap9SQKkijXSxP5> locks = new ConcurrentHashMap<>();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tasks/AsyncTaskExecutor$Ijap9SQKkijXSxP5.class */
    private class Ijap9SQKkijXSxP5 {
        final Object v8qP8fE86HMhvNuYPFjqY = new Object();
        int jBUuLP0sWwaPyPOmogdX7l = 1;

        private Ijap9SQKkijXSxP5() {
        }

        void v8qP8fE86HMhvNuYPFjqY() {
            this.jBUuLP0sWwaPyPOmogdX7l++;
        }

        void jBUuLP0sWwaPyPOmogdX7l() {
            this.jBUuLP0sWwaPyPOmogdX7l--;
        }

        boolean ZwrsrwOCXRUscW6Q() {
            return this.jBUuLP0sWwaPyPOmogdX7l <= 0;
        }
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public void run(UUID uuid, Runnable runnable) {
        if (uuid == null) {
            throw new IllegalArgumentException("Key cannot be null. Use runGlobal() or runAsync()");
        }
        Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5Compute = this.locks.compute(uuid, (uuid2, ijap9SQKkijXSxP5) -> {
            if (ijap9SQKkijXSxP5 == null) {
                return new Ijap9SQKkijXSxP5();
            }
            ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY();
            return ijap9SQKkijXSxP5;
        });
        this.executor.submit(() -> {
            synchronized (ijap9SQKkijXSxP5Compute.v8qP8fE86HMhvNuYPFjqY) {
                try {
                    try {
                        runnable.run();
                        release(uuid, ijap9SQKkijXSxP5Compute);
                    } catch (Throwable th) {
                        release(uuid, ijap9SQKkijXSxP5Compute);
                        throw th;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    release(uuid, ijap9SQKkijXSxP5Compute);
                }
            }
        });
    }

    public void runGlobal(Runnable runnable) {
        run(this.GLOBAL_KEY, runnable);
    }

    public void runAsync(Runnable runnable) {
        this.executor.submit(() -> {
            try {
                runnable.run();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    private void release(UUID uuid, Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5) {
        this.locks.computeIfPresent(uuid, (uuid2, ijap9SQKkijXSxP6) -> {
            ijap9SQKkijXSxP6.jBUuLP0sWwaPyPOmogdX7l();
            if (ijap9SQKkijXSxP6.ZwrsrwOCXRUscW6Q()) {
                return null;
            }
            return ijap9SQKkijXSxP6;
        });
    }

    public void shutdown() {
        this.executor.shutdown();
        try {
            if (!this.executor.awaitTermination(10L, TimeUnit.SECONDS)) {
                this.executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            this.executor.shutdownNow();
        }
    }
}
