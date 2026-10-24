package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanBannerChangeEvent.class */
public class ClanBannerChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final ItemStack banner;

    public ClanBannerChangeEvent(UUID uuid, ItemStack itemStack) {
        this.clanID = uuid;
        this.banner = itemStack;
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

    public ItemStack getBanner() {
        return this.banner;
    }
}
