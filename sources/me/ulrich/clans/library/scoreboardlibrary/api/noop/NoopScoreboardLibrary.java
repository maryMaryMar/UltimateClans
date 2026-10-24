package me.ulrich.clans.library.scoreboardlibrary.api.noop;

import java.util.Locale;
import me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/noop/NoopScoreboardLibrary.class */
public final class NoopScoreboardLibrary implements ScoreboardLibrary {
    private boolean closed = false;

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    @NotNull
    public Sidebar createSidebar(int i, @Nullable Locale locale, @NotNull String str) {
        checkClosed();
        return new NoopSidebar(i, str, locale);
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    @NotNull
    public TeamManager createTeamManager() {
        checkClosed();
        return new NoopTeamManager();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    @NotNull
    public ObjectiveManager createObjectiveManager() {
        checkClosed();
        return new NoopObjectiveManager();
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    public void close() {
        this.closed = true;
    }

    @Override // me.ulrich.clans.library.scoreboardlibrary.api.ScoreboardLibrary
    public boolean closed() {
        return this.closed;
    }

    private void checkClosed() {
        if (this.closed) {
            throw new IllegalStateException("NoopScoreboardLibrary is closed");
        }
    }
}
