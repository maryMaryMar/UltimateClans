package me.ulrich.clans.events;

import java.util.UUID;
import me.ulrich.clans.data.ClanEnum;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanPlayerSoulsChangeEvent.class */
public class ClanPlayerSoulsChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID playerUUID;
    private final ClanEnum.SoulsChangeType type;
    private final int souls;

    public ClanPlayerSoulsChangeEvent(UUID uuid, ClanEnum.SoulsChangeType soulsChangeType, int i) {
        this.playerUUID = uuid;
        this.type = soulsChangeType;
        this.souls = i;
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

    public UUID getPlayerUUID() {
        return this.playerUUID;
    }

    public ClanEnum.SoulsChangeType getType() {
        return this.type;
    }

    public int getSouls() {
        return this.souls;
    }
}
