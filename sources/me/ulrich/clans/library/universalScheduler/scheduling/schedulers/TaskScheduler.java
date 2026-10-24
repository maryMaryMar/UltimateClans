package me.ulrich.clans.library.universalScheduler.scheduling.schedulers;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/scheduling/schedulers/TaskScheduler.class */
public interface TaskScheduler {
    boolean isGlobalThread();

    default boolean isTickThread() {
        return Bukkit.getServer().isPrimaryThread();
    }

    boolean isEntityThread(Entity entity);

    boolean isRegionThread(Location location);

    MyScheduledTask runTask(Runnable runnable);

    MyScheduledTask runTaskLater(Runnable runnable, long j);

    MyScheduledTask runTaskTimer(Runnable runnable, long j, long j2);

    @Deprecated
    default MyScheduledTask runTask(Plugin plugin, Runnable runnable) {
        return runTask(runnable);
    }

    @Deprecated
    default MyScheduledTask runTaskLater(Plugin plugin, Runnable runnable, long j) {
        return runTaskLater(runnable, j);
    }

    @Deprecated
    default MyScheduledTask runTaskTimer(Plugin plugin, Runnable runnable, long j, long j2) {
        return runTaskTimer(runnable, j, j2);
    }

    default MyScheduledTask runTask(Location location, Runnable runnable) {
        return runTask(runnable);
    }

    default MyScheduledTask runTaskLater(Location location, Runnable runnable, long j) {
        return runTaskLater(runnable, j);
    }

    default MyScheduledTask runTaskTimer(Location location, Runnable runnable, long j, long j2) {
        return runTaskTimer(runnable, j, j2);
    }

    @Deprecated
    default MyScheduledTask scheduleSyncDelayedTask(Runnable runnable, long j) {
        return runTaskLater(runnable, j);
    }

    @Deprecated
    default MyScheduledTask scheduleSyncDelayedTask(Runnable runnable) {
        return runTask(runnable);
    }

    @Deprecated
    default MyScheduledTask scheduleSyncRepeatingTask(Runnable runnable, long j, long j2) {
        return runTaskTimer(runnable, j, j2);
    }

    default MyScheduledTask runTask(Entity entity, Runnable runnable) {
        return runTask(runnable);
    }

    default MyScheduledTask runTaskLater(Entity entity, Runnable runnable, long j) {
        return runTaskLater(runnable, j);
    }

    default MyScheduledTask runTaskTimer(Entity entity, Runnable runnable, long j, long j2) {
        return runTaskTimer(runnable, j, j2);
    }

    MyScheduledTask runTaskAsynchronously(Runnable runnable);

    MyScheduledTask runTaskLaterAsynchronously(Runnable runnable, long j);

    MyScheduledTask runTaskTimerAsynchronously(Runnable runnable, long j, long j2);

    @Deprecated
    default MyScheduledTask runTaskAsynchronously(Plugin plugin, Runnable runnable) {
        return runTaskAsynchronously(runnable);
    }

    @Deprecated
    default MyScheduledTask runTaskLaterAsynchronously(Plugin plugin, Runnable runnable, long j) {
        return runTaskLaterAsynchronously(runnable, j);
    }

    @Deprecated
    default MyScheduledTask runTaskTimerAsynchronously(Plugin plugin, Runnable runnable, long j, long j2) {
        return runTaskTimerAsynchronously(runnable, j, j2);
    }

    default <T> Future<T> callSyncMethod(Callable<T> callable) {
        CompletableFuture completableFuture = new CompletableFuture();
        execute(() -> {
            try {
                completableFuture.complete(callable.call());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return completableFuture;
    }

    void execute(Runnable runnable);

    default void execute(Location location, Runnable runnable) {
        execute(runnable);
    }

    default void execute(Entity entity, Runnable runnable) {
        execute(runnable);
    }

    void cancelTasks();

    void cancelTasks(Plugin plugin);
}
