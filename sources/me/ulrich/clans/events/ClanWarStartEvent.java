package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanWarStartEvent.class */
public class ClanWarStartEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanSender;
    private final UUID clanReceiver;
    private final String arenaName;
    private final String kitName;
    private final int maxPlayers;

    public ClanWarStartEvent(UUID uuid, UUID uuid2, String str, String str2, int i) {
        this.clanSender = uuid;
        this.clanReceiver = uuid2;
        this.arenaName = str;
        this.kitName = str2;
        this.maxPlayers = i;
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

    public String getKitName() {
        return this.kitName;
    }

    public int getMaxPlayers() {
        return this.maxPlayers;
    }
}
