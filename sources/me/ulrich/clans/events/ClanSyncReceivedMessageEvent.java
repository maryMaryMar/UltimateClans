package me.ulrich.clans.events;

import me.ulrich.clans.data.ClanEnum;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanSyncReceivedMessageEvent.class */
public class ClanSyncReceivedMessageEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private String data;
    private ClanEnum.DebugType type;

    public ClanSyncReceivedMessageEvent(ClanEnum.DebugType debugType, String str) {
        setType(debugType);
        setData(str);
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public ClanEnum.DebugType getType() {
        return this.type;
    }

    public void setType(ClanEnum.DebugType debugType) {
        this.type = debugType;
    }
}
