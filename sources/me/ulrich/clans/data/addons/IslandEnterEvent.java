package me.ulrich.clans.data.addons;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.player.PlayerEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/IslandEnterEvent.class */
public class IslandEnterEvent extends LandRegionEvent implements Cancellable {
    private boolean cancelled;
    private boolean cancellable;

    public IslandEnterEvent(IslandJoinLeaveData islandJoinLeaveData, Player player, AddonEnum.MovementWay movementWay, PlayerEvent playerEvent) {
        super(islandJoinLeaveData, player, movementWay, playerEvent);
        this.cancelled = false;
        this.cancellable = true;
        if (movementWay == AddonEnum.MovementWay.SPAWN || movementWay == AddonEnum.MovementWay.DISCONNECT) {
            this.cancellable = false;
        }
    }

    public void setCancelled(boolean z) {
        if (this.cancellable) {
            this.cancelled = z;
        }
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isCancellable() {
        return this.cancellable;
    }

    protected void setCancellable(boolean z) {
        this.cancellable = z;
        if (this.cancellable) {
            return;
        }
        this.cancelled = false;
    }
}
