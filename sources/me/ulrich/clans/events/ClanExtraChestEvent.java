package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanExtraChestEvent.class */
public class ClanExtraChestEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final int total;
    private final CommandSender sender;

    public ClanExtraChestEvent(UUID uuid, int i, CommandSender commandSender) {
        this.clanID = uuid;
        this.total = i;
        this.sender = commandSender;
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

    public int getTotal() {
        return this.total;
    }

    public CommandSender getSender() {
        return this.sender;
    }
}
