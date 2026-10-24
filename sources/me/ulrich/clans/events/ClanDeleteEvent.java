package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanDeleteEvent.class */
public class ClanDeleteEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID sender;
    private final UUID clanID;
    private final String tag;

    public ClanDeleteEvent(UUID uuid, UUID uuid2, String str) {
        this.sender = uuid;
        this.clanID = uuid2;
        this.tag = str;
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

    public UUID getSender() {
        return this.sender;
    }

    public String getTag() {
        return this.tag;
    }

    public UUID getClanID() {
        return this.clanID;
    }
}
