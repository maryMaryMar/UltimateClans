package me.ulrich.clans.library.scoreboardlibrary.implementation.player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import me.ulrich.clans.library.scoreboardlibrary.implementation.player.PlayerDisplayable;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/scoreboardlibrary/implementation/player/DisplayableQueue.class */
public final class DisplayableQueue<T extends PlayerDisplayable> {
    private final UUID playerUuid;
    private final List<T> queue = new ArrayList(1);

    public DisplayableQueue(@NotNull UUID uuid) {
        this.playerUuid = uuid;
    }

    @Nullable
    public T current() {
        synchronized (this) {
            if (this.queue.isEmpty()) {
                return null;
            }
            return this.queue.get(0);
        }
    }

    public void add(@NotNull T t) {
        Player player;
        synchronized (this) {
            if (this.queue.contains(t)) {
                throw new IllegalStateException("displayable already registered");
            }
            this.queue.add(t);
            if (current() == t && (player = Bukkit.getPlayer(this.playerUuid)) != null) {
                t.display(player);
            }
        }
    }

    public void remove(@NotNull T t) {
        Player player;
        synchronized (this) {
            boolean z = t == current();
            if (!this.queue.remove(t)) {
                throw new IllegalStateException("displayable not registered");
            }
            if (z) {
                PlayerDisplayable playerDisplayableCurrent = current();
                if (playerDisplayableCurrent != null && (player = Bukkit.getPlayer(this.playerUuid)) != null) {
                    playerDisplayableCurrent.display(player);
                }
            }
        }
    }
}
