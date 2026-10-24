package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanPlayerBanEvent.class */
public class ClanPlayerBanEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID player;
    private final UUID clanID;
    private final UUID sender;

    public ClanPlayerBanEvent(UUID uuid, UUID uuid2, UUID uuid3) {
        this.player = uuid;
        this.clanID = uuid2;
        this.sender = uuid3;
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

    public UUID getClanID() {
        return this.clanID;
    }

    public UUID getPlayer() {
        return this.player;
    }

    public UUID getSender() {
        return this.sender;
    }
}
