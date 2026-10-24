package me.ulrich.clans.library.scoreboardlibrary.implementation.sidebar;

import java.util.Iterator;
import java.util.logging.Level;
import me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl;
import me.ulrich.clans.library.scoreboardlibrary.implementation.scheduler.RunningTask;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/sidebar/SidebarUpdaterTask.class */
public final class SidebarUpdaterTask implements Runnable {
    private final ScoreboardLibraryImpl scoreboardLibrary;
    private final RunningTask task;
    private final Object lock = new Object();

    public SidebarUpdaterTask(@NotNull ScoreboardLibraryImpl scoreboardLibraryImpl) {
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
            Iterator<AbstractSidebar> it = this.scoreboardLibrary.sidebars().iterator();
            while (it.hasNext()) {
                try {
                    if (!it.next().tick()) {
                        it.remove();
                    }
                } catch (Exception e) {
                    this.scoreboardLibrary.plugin().getLogger().log(Level.WARNING, "an error occurred while updating a Sidebar instance", (Throwable) e);
                }
            }
        }
    }
}
