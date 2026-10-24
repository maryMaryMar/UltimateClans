package me.ulrich.clans.data.addons;

import java.util.List;
import java.util.UUID;
import org.bukkit.Location;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusData.class */
public class NexusData {
    private UUID terrainUUID;
    private Location location;
    private Integer structureId;
    private List<Location> structureBlocks;
    private double currentLife;
    private long shield;
    private long lastDamage;

    public NexusData(UUID uuid, Location location, int i, List<Location> list, double d, long j, long j2) {
        setTerrainUUID(uuid);
        setLocation(location);
        setStructureId(Integer.valueOf(i));
        setStructureBlocks(list);
        setCurrentLife(d);
        setShield(j);
        setLastDamage(j2);
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getStructureId() {
        return this.structureId;
    }

    public void setStructureId(Integer num) {
        this.structureId = num;
    }

    public List<Location> getStructureBlocks() {
        return this.structureBlocks;
    }

    public void setStructureBlocks(List<Location> list) {
        this.structureBlocks = list;
    }

    public double getCurrentLife() {
        return this.currentLife;
    }

    public void setCurrentLife(double d) {
        this.currentLife = d;
    }

    public long getShield() {
        return this.shield;
    }

    public void setShield(long j) {
        this.shield = j;
    }

    public UUID getTerrainUUID() {
        return this.terrainUUID;
    }

    public void setTerrainUUID(UUID uuid) {
        this.terrainUUID = uuid;
    }

    public long getLastDamage() {
        return this.lastDamage;
    }

    public void setLastDamage(long j) {
        this.lastDamage = j;
    }
}
