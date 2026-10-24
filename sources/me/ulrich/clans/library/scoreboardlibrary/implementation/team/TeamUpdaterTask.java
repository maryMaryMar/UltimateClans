package me.ulrich.clans.library.scoreboardlibrary.implementation.team;

import java.util.Iterator;
import java.util.logging.Level;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.RunningTask;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/team/TeamUpdaterTask.class */
public final class TeamUpdaterTask implements Runnable {
    private final ScoreboardLibraryImpl scoreboardLibrary;
    private final RunningTask task;
    private final Object lock = new Object();

    public TeamUpdaterTask(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl) {
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
            Iterator<TeamManagerImpl> it = this.scoreboardLibrary.teamManagers().iterator();
            while (it.hasNext()) {
                try {
                    if (!it.next().tick()) {
                        it.remove();
                    }
                } catch (Exception e) {
                    this.scoreboardLibrary.plugin().getLogger().log(Level.WARNING, "an error occurred while updating a TeamManager instance", (Throwable) e);
                }
            }
        }
    }
}
