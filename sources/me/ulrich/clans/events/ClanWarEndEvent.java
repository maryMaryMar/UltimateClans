package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanWarEndEvent.class */
public class ClanWarEndEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanSender;
    private final UUID clanReceiver;
    private final String arenaName;

    public ClanWarEndEvent(UUID uuid, UUID uuid2, String str) {
        this.clanSender = uuid;
        this.clanReceiver = uuid2;
        this.arenaName = str;
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

    public UUID getClanSender() {
        return this.clanSender;
    }

    public UUID getClanReceiver() {
        return this.clanReceiver;
    }

    public String getArenaName() {
        return this.arenaName;
    }
}
