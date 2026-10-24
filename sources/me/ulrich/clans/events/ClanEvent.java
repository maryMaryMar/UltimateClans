package me.ulrich.clans.events;

import java.util.List;
import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanEvent.class */
public class ClanEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanUUID;
    private final List<UUID> livePlayers;
    private String eventData;

    public ClanEvent(UUID uuid, String str, List<UUID> list) {
        this.clanUUID = uuid;
        this.eventData = str;
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

    public List<UUID> getLivePlayers() {
        return this.livePlayers;
    }

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public String getEventData() {
        return this.eventData;
    }
}
