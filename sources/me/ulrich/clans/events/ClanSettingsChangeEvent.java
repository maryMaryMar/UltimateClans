package me.ulrich.clans.events;

import java.util.UUID;
import me.ulrich.clans.data.ClanEnum;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanSettingsChangeEvent.class */
public class ClanSettingsChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private final UUID clanID;
    private final ClanEnum.SettingsType type;
    private final ClanEnum.SettingsFlagsAccept value;

    public ClanSettingsChangeEvent(UUID uuid, ClanEnum.SettingsType settingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept) {
        this.clanID = uuid;
        this.type = settingsType;
        this.value = settingsFlagsAccept;
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

    public ClanEnum.SettingsType getType() {
        return this.type;
    }

    public ClanEnum.SettingsFlagsAccept getValue() {
        return this.value;
    }
}
