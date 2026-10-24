package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanModDescEvent.class */
public class ClanModDescEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final String clanTag;
    private final String newDesc;
    private final String message;

    public ClanModDescEvent(UUID uuid, String str, String str2, String str3) {
        this.clanID = uuid;
        this.clanTag = str;
        this.newDesc = str2;
        this.message = str3;
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

    public String getClanTag() {
        return this.clanTag;
    }

    public String getNewDesc() {
        return this.newDesc;
    }

    public String getMessage() {
        return this.message;
    }
}
