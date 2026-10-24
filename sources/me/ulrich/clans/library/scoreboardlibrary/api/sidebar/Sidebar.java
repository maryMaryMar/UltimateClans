package me.ulrich.clans.library.scoreboardlibrary.api.sidebar;

import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.ComponentLike;
import me.ulrich.clans.library.scoreboardlibrary.api.objective.ScoreFormat;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/sidebar/Sidebar.class */
@ApiStatus.NonExtendable
public interface Sidebar {
    public static final int MAX_LINES = 15;

    int maxLines();

    @NotNull
    String objectiveName();

    @Nullable
    Locale locale();

    @Nullable
    Component line(int i);

    default void line(int i, @Nullable ComponentLike componentLike) {
        line(i, componentLike, null);
    }

    void line(int i, @Nullable ComponentLike componentLike, @Nullable ScoreFormat scoreFormat);

    default void clearLines() {
        for (int i = 0; i < maxLines(); i++) {
            line(i, null);
        }
    }

    void refreshLine(int i);

    default void refreshLines() {
        for (int i = 0; i < maxLines(); i++) {
            refreshLine(i);
        }
    }

    @NotNull
    Component title();

    void title(@NotNull ComponentLike componentLike);

    void refreshTitle();

    @NotNull
    Collection<Player> players();

    boolean addPlayer(@NotNull Player player);

    default void addPlayers(@NotNull Collection<Player> collection) {
        Iterator<Player> it = collection.iterator();
        while (it.hasNext()) {
            addPlayer(it.next());
        }
    }

    boolean removePlayer(@NotNull Player player);

    default void removePlayers(@NotNull Collection<Player> collection) {
        Iterator<Player> it = collection.iterator();
        while (it.hasNext()) {
            removePlayer(it.next());
        }
    }

    void close();

    boolean closed();
}
