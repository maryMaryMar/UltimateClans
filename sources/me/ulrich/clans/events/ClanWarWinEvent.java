package me.ulrich.clans.events;

import java.util.List;
import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanWarWinEvent.class */
public class ClanWarWinEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanWinner;
    private final UUID clanLoser;
    private final List<UUID> livePlayers;

    public ClanWarWinEvent(UUID uuid, UUID uuid2, List<UUID> list) {
        this.clanWinner = uuid;
        this.clanLoser = uuid2;
        this.livePlayers = list;
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public void setCancelled(boolean z) {
        this.cancelled = z;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public UUID getClanWinner() {
        return this.clanWinner;
    }

    public UUID getClanLoser() {
        return this.clanLoser;
    }

    public List<UUID> getLivePlayers() {
        return this.livePlayers;
    }
}
