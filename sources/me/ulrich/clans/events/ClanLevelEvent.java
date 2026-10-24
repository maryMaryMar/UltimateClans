package me.ulrich.clans.events;

import java.util.UUID;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanLevelEvent.class */
public class ClanLevelEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private UUID clanUUID;
    private CommandSender sender;
    private boolean changedPatent;

    public ClanLevelEvent(UUID uuid, CommandSender commandSender, boolean z) {
        setClanUUID(uuid);
        setSender(commandSender);
        setChangedPatent(z);
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

    public CommandSender getSender() {
        return this.sender;
    }

    public void setSender(CommandSender commandSender) {
        this.sender = commandSender;
    }

    public boolean isChangedPatent() {
        return this.changedPatent;
    }

    public void setChangedPatent(boolean z) {
        this.changedPatent = z;
    }

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public void setClanUUID(UUID uuid) {
        this.clanUUID = uuid;
    }
}
