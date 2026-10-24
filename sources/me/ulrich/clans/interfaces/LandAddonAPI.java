package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.addons.AddonEnum;
import me.ulrich.clans.data.addons.IslandJoinLeaveData;
import me.ulrich.clans.data.addons.LandBoxData;
import me.ulrich.clans.data.addons.LandClaimMethod;
import me.ulrich.clans.data.addons.LandsData;
import me.ulrich.clans.manager.utils.Cuboid;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/LandAddonAPI.class */
public interface LandAddonAPI {
    String parseText(UUID uuid, String str);

    ItemStack getBanner(UUID uuid);

    boolean landExists(UUID uuid);

    Optional<LandsData> getLandData(UUID uuid);

    void finalizeFakePoints(Player player);

    void putFakeBlock(Player player, Location location, Material material);

    void removeFakeBlock(Player player, Location location, LandBoxData landBoxData);

    void clearFakeBox(Player player, List<LandBoxData> list);

    void deleteFakes();

    void updateFakePoints(Player player);

    void sendClaimChanges(Player player, AddonEnum.ClaimChanges claimChanges);

    List<LandBoxData> getHollowCube(Location location, Location location2);

    List<LandBoxData> getBoxCube(Location location, Location location2);

    List<Location> getHollowCube(Location location, Location location2, double d);

    List<Location> getHollowCube(Location location, Location location2, boolean z);

    List<Location> getHollowCube2(Location location, Location location2, boolean z);

    void createBox(Player player, Location location);

    boolean checkColision(Player player, Optional<Location> optional, Optional<Location> optional2);

    boolean checkChunkCornersInClaim(Optional<ClaimImplement> optional, List<Chunk> list);

    boolean checkChunkCornersInClaim(List<Chunk> list);

    List<Block> getCubeEdges(Cuboid cuboid);

    boolean checkClose(Player player, Location location);

    boolean intersectsCuboid(Cuboid cuboid, Cuboid cuboid2);

    boolean checkCurrentSize(Player player, Location location, Location location2);

    boolean expandLand(Player player, AddonEnum.LandExpandDirection landExpandDirection, int i);

    void effectCunk(Cuboid cuboid, Chunk chunk, Player player, Material material, int i, boolean z, boolean z2);

    boolean deleteClanLands(UUID uuid);

    boolean deleteLand(UUID uuid, UUID uuid2, Player player);

    Optional<LandsData> createNewClaim(Player player, LandClaimMethod landClaimMethod);

    Optional<LandsData> getLand(Location location);

    boolean hasPlayerLand(UUID uuid);

    List<LandsData> getPlayerLands(UUID uuid);

    boolean hasClanLand(UUID uuid);

    List<LandsData> getClanLands(UUID uuid);

    boolean isMemberOfLand(UUID uuid, LandsData landsData);

    boolean isTrustOfLand(UUID uuid, LandsData landsData);

    boolean banPlayerLand(PlayerData playerData, LandsData landsData);

    boolean unbanPlayerLand(PlayerData playerData, LandsData landsData);

    boolean trustPlayerLand(PlayerData playerData, LandsData landsData);

    boolean untrustPlayerLand(PlayerData playerData, LandsData landsData);

    boolean setSpawnLand(LandsData landsData, Location location);

    boolean setFlagLand(LandsData landsData, AddonEnum.LandFlags landFlags, boolean z);

    boolean setNameLand(LandsData landsData, String str);

    void teleportDelay(Player player, Location location, boolean z);

    int clanLandLimit(ClanData clanData);

    HashMap<UUID, LandClaimMethod> getClaim();

    void setClaim(HashMap<UUID, LandClaimMethod> map);

    HashMap<UUID, LandsData> getLandsData();

    HashMap<Player, IslandJoinLeaveData> getPlayerRegion();
}
