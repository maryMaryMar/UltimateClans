package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanLeaderChangeEvent.class */
public class ClanLeaderChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final UUID oldLeader;
    private final UUID newLeader;

    public ClanLeaderChangeEvent(UUID uuid, UUID uuid2, UUID uuid3) {
        this.clanID = uuid;
        this.oldLeader = uuid2;
        this.newLeader = uuid3;
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

    public UUID getOldLeader() {
        return this.oldLeader;
    }

    public UUID getNewLeader() {
        return this.newLeader;
    }
}
