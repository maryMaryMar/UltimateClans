package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanRivalInviteEvent.class */
public class ClanRivalInviteEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanInvite;
    private final UUID clanReceive;
    private final boolean proxied;

    public ClanRivalInviteEvent(UUID uuid, UUID uuid2, boolean z) {
        this.clanInvite = uuid;
        this.clanReceive = uuid2;
        this.proxied = z;
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

    public UUID getClanInvite() {
        return this.clanInvite;
    }

    public UUID getClanReceive() {
        return this.clanReceive;
    }

    public boolean isProxied() {
        return this.proxied;
    }
}
