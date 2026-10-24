package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.addons.AddonEnum;
import me.ulrich.clans.data.addons.NexusLandData;
import me.ulrich.clans.data.addons.NexusPowerData;
import me.ulrich.clans.data.addons.NexusStatsData;
import me.ulrich.clans.data.addons.NexusTerrainData;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/NexusAddonAPI.class */
public interface NexusAddonAPI {
    String parseText(UUID uuid, String str);

    void SaveNexus(NexusLandData nexusLandData);

    void DeleteNexus(UUID uuid);

    void DeleteTerrain(UUID uuid, UUID uuid2);

    void LoadAllNexus();

    boolean isLand(Location location);

    boolean isLand(Chunk chunk);

    Optional<NexusLandData> getLand(Location location);

    Optional<NexusLandData> getLand(Chunk chunk);

    Optional<NexusLandData> getLand(UUID uuid);

    Optional<NexusLandData> getClanLand(UUID uuid);

    List<NexusTerrainData> getAllClanTerrains(UUID uuid);

    List<Chunk> getAllClanChunks(UUID uuid);

    Optional<ClanData> getLandClan(Location location);

    Optional<ClanData> getLandClan(Chunk chunk);

    Optional<ClanData> getLandClan(UUID uuid);

    boolean isBanned(Player player, Chunk chunk);

    boolean isLandMember(UUID uuid, UUID uuid2);

    boolean canBuildLand(Player player, Location location);

    boolean terrainHasNexus(Location location);

    boolean terrainHasNexus(Chunk chunk);

    boolean terrainHasNexus(UUID uuid);

    Optional<NexusTerrainData> getTerrainNexus(Location location);

    Optional<NexusTerrainData> getTerrainNexus(Chunk chunk);

    Optional<NexusTerrainData> getTerrainNexus(UUID uuid);

    boolean changeEntityLife(UUID uuid, double d);

    boolean addNexusEntity(UUID uuid, UUID uuid2, int i);

    boolean isNexusEntity(int i);

    Optional<NexusLandData> getNexusEntity(int i);

    boolean updateNexusEntity(UUID uuid);

    boolean hasBuildPermission(UUID uuid);

    boolean hasBuildPermission(Player player);

    boolean changeLandHome(UUID uuid, Location location);

    boolean changeLandName(UUID uuid, String str);

    boolean addLandBannedPlayer(UUID uuid, UUID uuid2);

    boolean removeLandBannedPlayer(UUID uuid, UUID uuid2);

    boolean addLandTrustedPlayer(UUID uuid, UUID uuid2);

    boolean removeLandTrustedPlayer(UUID uuid, UUID uuid2);

    boolean changeLandStats(UUID uuid, NexusStatsData nexusStatsData);

    boolean changeLandSettings(UUID uuid, Optional<AddonEnum.NexusSettings> optional, boolean z);

    boolean unclaimClanLand(UUID uuid, UUID uuid2);

    boolean unclaimChunkTerrain(Player player, Location location);

    boolean checkLocationIsDisabled(Location location);

    Optional<Chunk> checkColision(Location location, Optional<UUID> optional);

    Optional<NexusLandData> claimNewChunk(Player player, Location location);

    Optional<NexusLandData> createNewLand(Player player, Location location);

    Optional<NexusPowerData> getLandPower(UUID uuid);

    int clanLandLimit(UUID uuid);

    void teleportDelay(Player player, Location location, boolean z);

    boolean verify(Player player, Location location, AddonEnum.NexusVerifyEvent nexusVerifyEvent);

    ConcurrentHashMap<UUID, NexusLandData> getLands();
}
