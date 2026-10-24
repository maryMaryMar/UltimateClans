package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanRegroupSendEvent.class */
public class ClanRegroupSendEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanUUID;
    private UUID senderUUID;

    public ClanRegroupSendEvent(UUID uuid, UUID uuid2) {
        this.clanUUID = uuid;
        setSenderUUID(uuid2);
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

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public UUID getSenderUUID() {
        return this.senderUUID;
    }

    public void setSenderUUID(UUID uuid) {
        this.senderUUID = uuid;
    }
}
