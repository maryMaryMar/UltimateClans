package me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/scheduler/TaskScheduler.class */
public interface TaskScheduler {
    @NotNull
    static TaskScheduler create(@NotNull Plugin plugin) {
        try {
            Class.forName("io.papermc.paper.threadedregions.RegionizedServer");
            return new FoliaTaskScheduler(plugin);
        } catch (ClassNotFoundException e) {
            return new BukkitTaskScheduler(plugin);
        }
    }

    @NotNull
    RunningTask runEveryTick(@NotNull Runnable runnable);

    void runNextTick(@NotNull Runnable runnable);
}
