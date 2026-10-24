package me.ulrich.clans.library.scoreboardlibrary.api.team;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/api/team/TeamManager.class */
@ApiStatus.NonExtendable
public interface TeamManager {
    @NotNull
    Collection<ScoreboardTeam> teams();

    @Nullable
    ScoreboardTeam team(@NotNull String str);

    boolean teamExists(@NotNull String str);

    @NotNull
    default ScoreboardTeam createIfAbsent(@NotNull String str) {
        return createIfAbsent(str, null);
    }

    @NotNull
    ScoreboardTeam createIfAbsent(@NotNull String str, @Nullable BiFunction<Player, ScoreboardTeam, TeamDisplay> biFunction);

    boolean removeTeam(@NotNull String str);

    void removeTeam(@NotNull ScoreboardTeam scoreboardTeam);

    @NotNull
    Collection<Player> players();

    default boolean addPlayer(@NotNull Player player) {
        return addPlayer(player, null);
    }

    boolean addPlayer(@NotNull Player player, @Nullable Function<ScoreboardTeam, TeamDisplay> function);

    default void addPlayers(@NotNull Collection<Player> collection) {
        addPlayers(collection, null);
    }

    default void addPlayers(@NotNull Collection<Player> collection, @Nullable Function<ScoreboardTeam, TeamDisplay> function) {
        Iterator<Player> it = collection.iterator();
        while (it.hasNext()) {
            addPlayer(it.next(), function);
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
