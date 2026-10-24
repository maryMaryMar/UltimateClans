package me.ulrich.clans.library.universalScheduler;

import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/UniversalRunnable.class */
public abstract class UniversalRunnable implements Runnable {
    MyScheduledTask task;

    public synchronized void cancel() {
        checkScheduled();
        this.task.cancel();
    }

    public synchronized boolean isCancelled() {
        checkScheduled();
        return this.task.isCancelled();
    }

    public synchronized MyScheduledTask runTask(Plugin plugin) {
        checkNotYetScheduled();
        return setupTask(UniversalScheduler.getScheduler(plugin).runTask(this));
    }

    public synchronized MyScheduledTask runTaskAsynchronously(Plugin plugin) {
        checkNotYetScheduled();
        return setupTask(UniversalScheduler.getScheduler(plugin).runTaskAsynchronously(this));
    }

    public synchronized MyScheduledTask runTaskLater(Plugin plugin, long j) {
        checkNotYetScheduled();
        return setupTask(UniversalScheduler.getScheduler(plugin).runTaskLater(this, j));
    }

    public synchronized MyScheduledTask runTaskLaterAsynchronously(Plugin plugin, long j) {
        checkNotYetScheduled();
        return setupTask(UniversalScheduler.getScheduler(plugin).runTaskLaterAsynchronously(this, j));
    }

    public synchronized MyScheduledTask runTaskTimer(Plugin plugin, long j, long j2) {
        checkNotYetScheduled();
        return setupTask(UniversalScheduler.getScheduler(plugin).runTaskTimer(this, j, j2));
    }

    public synchronized MyScheduledTask runTaskTimerAsynchronously(Plugin plugin, long j, long j2) {
        checkNotYetScheduled();
        return setupTask(UniversalScheduler.getScheduler(plugin).runTaskTimerAsynchronously(this, j, j2));
    }

    private void checkScheduled() {
        if (this.task == null) {
            throw new IllegalStateException("Not scheduled yet");
        }
    }

    private void checkNotYetScheduled() {
        if (this.task != null) {
            throw new IllegalStateException("Already scheduled");
        }
    }

    private MyScheduledTask setupTask(MyScheduledTask myScheduledTask) {
        this.task = myScheduledTask;
        return myScheduledTask;
    }
}
