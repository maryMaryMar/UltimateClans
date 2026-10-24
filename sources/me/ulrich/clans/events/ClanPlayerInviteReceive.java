package me.ulrich.clans.events;

import me.ulrich.clans.data.InviteData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanPlayerInviteReceive.class */
public class ClanPlayerInviteReceive extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private InviteData inviteData;

    public ClanPlayerInviteReceive(InviteData inviteData) {
        setInviteData(inviteData);
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

    public InviteData getInviteData() {
        return this.inviteData;
    }

    public void setInviteData(InviteData inviteData) {
        this.inviteData = inviteData;
    }
}
