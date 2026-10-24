package me.ulrich.clans.library.scoreboardlibrary.implementation.objective;

import java.util.Iterator;
import java.util.logging.Level;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.RunningTask;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/objective/ObjectiveUpdaterTask.class */
public final class ObjectiveUpdaterTask implements Runnable {
    private final ScoreboardLibraryImpl scoreboardLibrary;
    private final RunningTask task;
    private final Object lock = new Object();

    public ObjectiveUpdaterTask(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl) {
        this.scoreboardLibrary = scoreboardLibraryImpl;
        this.task = scoreboardLibraryImpl.taskScheduler().runEveryTick(this);
    }

    @NotNull
    public RunningTask task() {
        return this.task;
    }

    @NotNull
    public Object lock() {
        return this.lock;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.lock) {
            Iterator<ObjectiveManagerImpl> it = this.scoreboardLibrary.objectiveManagers().iterator();
            while (it.hasNext()) {
                try {
                    if (!it.next().tick()) {
                        it.remove();
                    }
                } catch (Exception e) {
                    this.scoreboardLibrary.plugin().getLogger().log(Level.WARNING, "an error occurred while updating an ObjectiveManager instance", (Throwable) e);
                }
            }
        }
    }
}
