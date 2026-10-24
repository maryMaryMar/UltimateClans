package me.ulrich.clans.events;

import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanQuestInfoData;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/events/ClanQuestChangeEvent.class */
public class ClanQuestChangeEvent extends Event implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private ClanQuestInfoData guestData;
    private ClanData clanData;
    private Player changer;

    public ClanQuestChangeEvent(ClanQuestInfoData clanQuestInfoData, ClanData clanData, Player player) {
        setQuestData(clanQuestInfoData);
        setClanData(clanData);
        setChanger(player);
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

    public ClanQuestInfoData getQuestData() {
        return this.guestData;
    }

    public void setQuestData(ClanQuestInfoData clanQuestInfoData) {
        this.guestData = clanQuestInfoData;
    }

    public ClanData getClanData() {
        return this.clanData;
    }

    public void setClanData(ClanData clanData) {
        this.clanData = clanData;
    }

    public Player getChanger() {
        return this.changer;
    }

    public void setChanger(Player player) {
        this.changer = player;
    }
}
