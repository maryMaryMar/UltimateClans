package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanMessageEvent.class */
public class ClanMessageEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID uuid;
    private final String message;
    private final boolean toBroadcast;
    private final boolean toClan;
    private final boolean toPlayer;

    public ClanMessageEvent(String str, boolean z, boolean z2, boolean z3, UUID uuid) {
        this.uuid = uuid;
        this.message = str;
        this.toBroadcast = z;
        this.toClan = z2;
        this.toPlayer = z3;
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

    public String getMessage() {
        return this.message;
    }

    public boolean isToBroadcast() {
        return this.toBroadcast;
    }

    public boolean isToClan() {
        return this.toClan;
    }

    public boolean isToPlayer() {
        return this.toPlayer;
    }

    public UUID getUuid() {
        return this.uuid;
    }
}
