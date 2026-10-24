package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanBankChangeEvent.class */
public class ClanBankChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final UUID sender;
    private final String balance;

    public ClanBankChangeEvent(UUID uuid, UUID uuid2, String str) {
        this.clanID = uuid;
        this.sender = uuid2;
        this.balance = str;
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

    public String getBalance() {
        return this.balance;
    }

    public UUID getSender() {
        return this.sender;
    }
}
