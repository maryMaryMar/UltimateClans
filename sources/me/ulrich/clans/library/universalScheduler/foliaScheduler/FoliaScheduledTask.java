package me.ulrich.clans.library.universalScheduler.foliaScheduler;

import io.papermc.paper.threadedregions.scheduler.ScheduledTask;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/foliaScheduler/FoliaScheduledTask.class */
public class FoliaScheduledTask implements MyScheduledTask {
    private final ScheduledTask task;

    public FoliaScheduledTask(ScheduledTask scheduledTask) {
        this.task = scheduledTask;
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
        return this.task.getOwningPlugin();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask
    public boolean isCurrentlyRunning() {
        ScheduledTask.ExecutionState executionState = this.task.getExecutionState();
        return executionState == ScheduledTask.ExecutionState.RUNNING || executionState == ScheduledTask.ExecutionState.CANCELLED_RUNNING;
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask
    public boolean isRepeatingTask() {
        return this.task.isRepeatingTask();
    }
}
