package me.ulrich.clans.data.addons;

import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/IslandJoinLeaveData.class */
public class IslandJoinLeaveData {
    private Player player;
    private AddonEnum.MovementWay movementWay;
    private Location to;
    private UUID islandUUID;
    private UUID clanUUID;

    public IslandJoinLeaveData(Player player, AddonEnum.MovementWay movementWay, Location location, UUID uuid, UUID uuid2) {
        setPlayer(player);
        setMovementWay(movementWay);
        setTo(location);
        setIslandUUID(uuid);
        setClanUUID(uuid2);
    }

    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public AddonEnum.MovementWay getMovementWay() {
        return this.movementWay;
    }

    public void setMovementWay(AddonEnum.MovementWay movementWay) {
        this.movementWay = movementWay;
    }

    public Location getTo() {
        return this.to;
    }

    public void setTo(Location location) {
        this.to = location;
    }

    public UUID getIslandUUID() {
        return this.islandUUID;
    }

    public void setIslandUUID(UUID uuid) {
        this.islandUUID = uuid;
    }

    public UUID getClanUUID() {
        return this.clanUUID;
    }

    public void setClanUUID(UUID uuid) {
        this.clanUUID = uuid;
    }
}
