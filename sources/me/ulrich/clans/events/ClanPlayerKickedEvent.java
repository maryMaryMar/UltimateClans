package me.ulrich.clans.events;

import java.util.Optional;
import java.util.UUID;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanPlayerKickedEvent.class */
public class ClanPlayerKickedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private final UUID playerKicked;
    private final UUID clanID;
    private final Optional<UUID> sender;
    private Optional<String> reason;

    public ClanPlayerKickedEvent(UUID uuid, UUID uuid2, Optional<UUID> optional, Optional<String> optional2) {
        this.playerKicked = uuid;
        this.clanID = uuid2;
        this.sender = optional;
        setReason(optional2);
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

    public UUID getPlayerKicked() {
        return this.playerKicked;
    }

    public Optional<UUID> getSender() {
        return this.sender;
    }

    public Optional<String> getReason() {
        return this.reason;
    }

    public void setReason(Optional<String> optional) {
        this.reason = optional;
    }
}
