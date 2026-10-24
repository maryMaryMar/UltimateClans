package me.ulrich.clans.data.addons;

import java.util.UUID;
import org.bukkit.Chunk;
import org.bukkit.World;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/data/addons/NexusTerrainData.class */
public class NexusTerrainData {
    private Chunk chunk;
    private World world;
    private UUID landUUID;
    private UUID terrainUUID;

    public NexusTerrainData(UUID uuid, UUID uuid2, World world, Chunk chunk) {
        setTerrainUUID(uuid);
        setLandUUID(uuid2);
        setWorld(world);
        setChunk(chunk);
    }

    public Chunk getChunk() {
        return this.chunk;
    }

    public void setChunk(Chunk chunk) {
        this.chunk = chunk;
    }

    public World getWorld() {
        return this.world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public UUID getLandUUID() {
        return this.landUUID;
    }

    public void setLandUUID(UUID uuid) {
        this.landUUID = uuid;
    }

    public UUID getTerrainUUID() {
        return this.terrainUUID;
    }

    public void setTerrainUUID(UUID uuid) {
        this.terrainUUID = uuid;
    }
}
