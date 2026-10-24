package me.ulrich.clans.data.addons;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/LandRegionEvent.class */
public abstract class LandRegionEvent extends PlayerEvent {
    private static final HandlerList handlerList = new HandlerList();
    private IslandJoinLeaveData region;
    private AddonEnum.MovementWay movement;
    public PlayerEvent parentEvent;

    public LandRegionEvent(IslandJoinLeaveData islandJoinLeaveData, Player player, AddonEnum.MovementWay movementWay, PlayerEvent playerEvent) {
        super(player);
        this.region = islandJoinLeaveData;
        this.movement = movementWay;
        this.parentEvent = playerEvent;
    }

    public HandlerList getHandlers() {
        return handlerList;
    }

    public IslandJoinLeaveData getRegion() {
        return this.region;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }

    public AddonEnum.MovementWay getMovementWay() {
        return this.movement;
    }

    public PlayerEvent getParentEvent() {
        return this.parentEvent;
    }
}
