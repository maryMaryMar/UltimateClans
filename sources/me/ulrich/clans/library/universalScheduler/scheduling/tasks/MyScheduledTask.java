package me.ulrich.clans.library.universalScheduler.scheduling.tasks;

import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/scheduling/tasks/MyScheduledTask.class */
public interface MyScheduledTask {
    void cancel();

    boolean isCancelled();

    Plugin getOwningPlugin();

    boolean isCurrentlyRunning();

    boolean isRepeatingTask();
}
