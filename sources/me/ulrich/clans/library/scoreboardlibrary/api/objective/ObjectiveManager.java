package me.ulrich.clans.library.scoreboardlibrary.api.objective;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/objective/ObjectiveManager.class */
public interface ObjectiveManager {
    @NotNull
    ScoreboardObjective create(@NotNull String str);

    void remove(@NotNull ScoreboardObjective scoreboardObjective);

    void display(@NotNull ObjectiveDisplaySlot objectiveDisplaySlot, @NotNull ScoreboardObjective scoreboardObjective);

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

    CompletableFuture<Void> removePlayerFuture(@NotNull Player player);

    void close();

    boolean closed();
}
