package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanAllyInviteEvent.class */
public class ClanAllyInviteEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clan1;
    private final UUID clan2;
    private final boolean proxied;

    public ClanAllyInviteEvent(UUID uuid, UUID uuid2, boolean z) {
        this.clan1 = uuid;
        this.clan2 = uuid2;
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

    public UUID getClan1() {
        return this.clan1;
    }

    public UUID getClan2() {
        return this.clan2;
    }

    public boolean isProxied() {
        return this.proxied;
    }
}
