package me.ulrich.clans.events;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanRewardsEvent.class */
public class ClanRewardsEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanUUID;
    private Optional<String> description;
    private List<String> rewards;

    public ClanRewardsEvent(UUID uuid, Optional<String> optional, List<String> list) {
        this.clanUUID = uuid;
        setDescription(optional);
        setRewards(list);
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

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public List<String> getRewards() {
        return this.rewards;
    }

    public void setRewards(List<String> list) {
        this.rewards = list;
    }

    public Optional<String> getDescription() {
        return this.description;
    }

    public void setDescription(Optional<String> optional) {
        this.description = optional;
    }
}
