package me.ulrich.clans.library.scoreboardlibrary.api;

import java.lang.reflect.InvocationTargetException;
import java.util.Locale;
import me.ulrich.clans.library.scoreboardlibrary.api.exception.NoPacketAdapterAvailableException;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ObjectiveManager;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import me.ulrich.clans.library.scoreboardlibrary.api.team.TeamManager;
import org.apache.commons.lang.RandomStringUtils;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/ScoreboardLibrary.class */
@ApiStatus.NonExtendable
public interface ScoreboardLibrary {
    @NotNull
    static ScoreboardLibrary loadScoreboardLibrary(@NotNull Plugin plugin) throws NoPacketAdapterAvailableException {
        try {
            try {
                return (ScoreboardLibrary) Class.forName("me.ulrich.clans.library.scoreboardlibrary.implementation.ScoreboardLibraryImpl").getDeclaredConstructor(Plugin.class).newInstance(plugin);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                if (e instanceof InvocationTargetException) {
                    Throwable targetException = ((InvocationTargetException) e).getTargetException();
                    if (targetException instanceof NoPacketAdapterAvailableException) {
                        throw ((NoPacketAdapterAvailableException) targetException);
                    }
                }
                throw new RuntimeException("failed to load scoreboard-library implementation", e);
            }
        } catch (ClassNotFoundException e2) {
            throw new IllegalStateException("scoreboard-library implementation is not shaded into the classpath");
        }
    }

    @NotNull
    default Sidebar createSidebar() {
        return createSidebar(15);
    }

    @NotNull
    default Sidebar createSidebar(int i) {
        return createSidebar(i, null);
    }

    @NotNull
    default Sidebar createSidebar(int i, @Nullable Locale locale) {
        return createSidebar(i, locale, RandomStringUtils.randomAlphanumeric(16));
    }

    @NotNull
    Sidebar createSidebar(int i, @Nullable Locale locale, @NotNull String str);

    @NotNull
    TeamManager createTeamManager();

    @NotNull
    ObjectiveManager createObjectiveManager();

    void close();

    boolean closed();
}
