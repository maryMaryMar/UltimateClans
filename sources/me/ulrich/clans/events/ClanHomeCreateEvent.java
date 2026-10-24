package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanHomeCreateEvent.class */
public class ClanHomeCreateEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final String homeName;
    private final Location location;
    private final UUID sender;

    public ClanHomeCreateEvent(UUID uuid, UUID uuid2, String str, Location location) {
        this.clanID = uuid2;
        this.homeName = str;
        this.location = location;
        this.sender = uuid;
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

    public String getHomeName() {
        return this.homeName;
    }

    public Location getLocation() {
        return this.location;
    }

    public UUID getSender() {
        return this.sender;
    }
}
