package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanChatEvent.class */
public class ClanChatEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final String message;
    private final UUID sender;
    private String rawMessage;

    public ClanChatEvent(UUID uuid, UUID uuid2, String str, String str2) {
        this.clanID = uuid;
        this.message = str;
        this.sender = uuid2;
        setRawMessage(str2);
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

    public String getMessage() {
        return this.message;
    }

    public UUID getSender() {
        return this.sender;
    }

    public String getRawMessage() {
        return this.rawMessage;
    }

    public void setRawMessage(String str) {
        this.rawMessage = str;
    }
}
