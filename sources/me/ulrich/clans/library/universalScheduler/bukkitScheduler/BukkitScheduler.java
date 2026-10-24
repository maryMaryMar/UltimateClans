package me.ulrich.clans.library.universalScheduler.bukkitScheduler;

import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/bukkitScheduler/BukkitScheduler.class */
public class BukkitScheduler implements TaskScheduler {
    final Plugin plugin;

    public BukkitScheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isGlobalThread() {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isEntityThread(Entity entity) {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isRegionThread(Location location) {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTask(Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTask(this.plugin, runnable));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLater(Runnable runnable, long j) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLater(this.plugin, runnable, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimer(Runnable runnable, long j, long j2) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimer(this.plugin, runnable, j, j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskAsynchronously(Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskAsynchronously(this.plugin, runnable));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLaterAsynchronously(Runnable runnable, long j) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLaterAsynchronously(this.plugin, runnable, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimerAsynchronously(Runnable runnable, long j, long j2) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimerAsynchronously(this.plugin, runnable, j, j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTask(Plugin plugin, Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTask(plugin, runnable));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLater(Plugin plugin, Runnable runnable, long j) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLater(plugin, runnable, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimer(Plugin plugin, Runnable runnable, long j, long j2) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimer(plugin, runnable, j, j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskAsynchronously(Plugin plugin, Runnable runnable) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskAsynchronously(plugin, runnable));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLaterAsynchronously(Plugin plugin, Runnable runnable, long j) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, runnable, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimerAsynchronously(Plugin plugin, Runnable runnable, long j, long j2) {
        return new BukkitScheduledTask(Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, runnable, j, j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void execute(Runnable runnable) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, runnable);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void cancelTasks() {
        Bukkit.getScheduler().cancelTasks(this.plugin);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void cancelTasks(Plugin plugin) {
        Bukkit.getScheduler().cancelTasks(plugin);
    }
}
