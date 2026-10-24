package me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler;

import java.util.Objects;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/scheduler/BukkitTaskScheduler.class */
final class BukkitTaskScheduler implements TaskScheduler {
    private final Plugin plugin;

    public BukkitTaskScheduler(@NotNull Plugin plugin) {
        this.plugin = plugin;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.TaskScheduler
    @NotNull
    public RunningTask runEveryTick(@NotNull Runnable runnable) {
        BukkitTask bukkitTaskRunTaskTimerAsynchronously = this.plugin.getServer().getScheduler().runTaskTimerAsynchronously(this.plugin, runnable, 1L, 1L);
        Objects.requireNonNull(bukkitTaskRunTaskTimerAsynchronously);
        return bukkitTaskRunTaskTimerAsynchronously::cancel;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.TaskScheduler
    public void runNextTick(@NotNull Runnable runnable) {
        this.plugin.getServer().getScheduler().runTaskLaterAsynchronously(this.plugin, runnable, 1L);
    }
}
