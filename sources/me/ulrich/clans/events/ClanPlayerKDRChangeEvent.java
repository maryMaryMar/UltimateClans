package me.ulrich.clans.events;

import java.util.UUID;
import me.ulrich.clans.data.ClanEnum;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanPlayerKDRChangeEvent.class */
public class ClanPlayerKDRChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID playerUUID;
    private final double kdr;
    private final int kills;
    private final int deaths;
    private final ClanEnum.KdrChangeType type;

    public ClanPlayerKDRChangeEvent(UUID uuid, ClanEnum.KdrChangeType kdrChangeType, double d, int i, int i2) {
        this.playerUUID = uuid;
        this.kdr = d;
        this.kills = i;
        this.deaths = i2;
        this.type = kdrChangeType;
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

    public double getKdr() {
        return this.kdr;
    }

    public int getKills() {
        return this.kills;
    }

    public int getDeaths() {
        return this.deaths;
    }

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

    public ClanEnum.KdrChangeType getType() {
        return this.type;
    }
}
