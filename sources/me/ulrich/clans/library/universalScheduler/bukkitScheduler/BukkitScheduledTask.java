package me.ulrich.clans.library.universalScheduler.bukkitScheduler;

import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/bukkitScheduler/BukkitScheduledTask.class */
public class BukkitScheduledTask implements MyScheduledTask {
    BukkitTask task;
    boolean isRepeating;

    public BukkitScheduledTask(BukkitTask bukkitTask) {
        this.task = bukkitTask;
        this.isRepeating = false;
    }

    public BukkitScheduledTask(BukkitTask bukkitTask, boolean z) {
        this.task = bukkitTask;
        this.isRepeating = z;
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask
    public void cancel() {
        this.task.cancel();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask
    public boolean isCancelled() {
        return this.task.isCancelled();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask
    public Plugin getOwningPlugin() {
        return this.task.getOwner();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask
    public boolean isCurrentlyRunning() {
        return Bukkit.getServer().getScheduler().isCurrentlyRunning(this.task.getTaskId());
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask
    public boolean isRepeatingTask() {
        return this.isRepeating;
    }
}
