package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanPlayerTeleportEvent.class */
public class ClanPlayerTeleportEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID playerUUID;
    private final UUID clanID;
    private final String server;
    private final String locationEncoded;

    public ClanPlayerTeleportEvent(UUID uuid, UUID uuid2, String str, String str2) {
        this.playerUUID = uuid;
        this.clanID = uuid2;
        this.server = str;
        this.locationEncoded = str2;
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

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

    public String getServer() {
        return this.server;
    }

    public String getLocationEncoded() {
        return this.locationEncoded;
    }
}
