package me.ulrich.clans.events;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanMultiserverPingEvent.class */
public class ClanMultiserverPingEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private String type;
    private UUID uuid;
    private Optional<Object> out;

    public ClanMultiserverPingEvent(String str, UUID uuid, Optional<Object> optional) {
        setType(str);
        setUuid(uuid);
        setOut(optional);
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

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Optional<Object> getOut() {
        return this.out;
    }

    public void setOut(Optional<Object> optional) {
        this.out = optional;
    }
}
