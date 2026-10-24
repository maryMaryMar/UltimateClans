package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.addons.AddonEnum;
import me.ulrich.clans.data.addons.WarArenaData;
import me.ulrich.clans.data.addons.WarEventData;
import me.ulrich.clans.data.addons.WarInvite;
import me.ulrich.clans.data.addons.WarKitData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/WarAddonAPI.class */
public interface WarAddonAPI {
    String parseText(UUID uuid, String str);

    boolean hasClanInviter(UUID uuid);

    WarInvite getClanInvite(UUID uuid);

    boolean removeWarInvite(UUID uuid);

    ClanEnum.WarReturn warSend(UUID uuid, UUID uuid2, String str, int i, Player player, WarKitData warKitData);

    HashMap<ClanData, WarInvite> getWarinvites();

    boolean arenaExists(String str);

    WarArenaData getArena(String str);

    WarArenaData getArena(Location location);

    WarArenaData getInGameArena(Location location);

    boolean isArenaEnabled(String str);

    boolean createArena(String str, Location location, Location location2);

    boolean addArenaPoint(String str, AddonEnum.EventPoint eventPoint, Location location);

    boolean toggleArena(String str);

    boolean startArena(Player player, String str, UUID uuid, UUID uuid2, int i, Player player2, String str2);

    boolean playerJoinArena(Player player, String str);

    void playerExitArena(Player player, boolean z);

    void exitAllPlayers();

    WarEventData getPlayerArena(Player player);

    WarEventData getPlayerArena(UUID uuid);

    String getPlayerEvent(Player player);

    String getClanEvent(UUID uuid);

    boolean playerIsInWar(Player player);

    boolean playerIsInWar(UUID uuid);

    boolean clanIsInWar(UUID uuid);

    boolean playerClanIsInWar(Player player);

    boolean changeArenaState(WarArenaData warArenaData, ClanEnum.EventState eventState);

    boolean teleportPlayerTo(List<Player> list, String str, AddonEnum.EventPoint eventPoint);

    boolean clearPlayer(Player player, WarEventData warEventData);

    Location getArenaLocal(String str, AddonEnum.EventPoint eventPoint);

    HashMap<String, WarEventData> getEvent();

    void loadArenas();

    void loadArena(String str);

    void saveArena(WarArenaData warArenaData);

    boolean descArena(String str, StringBuilder sb);

    boolean spectatorArena(String str, Location location);

    boolean modeArena(String str, AddonEnum.ArenaMode arenaMode);

    boolean iconArena(String str, Material material);

    boolean deleteArena(String str);

    String encodeLocation(Location location);

    Location decodeLocation(String str);

    ItemStack getWand();

    boolean clearWand();

    boolean checkWand();

    boolean isPlayerSpectator(Player player);

    void setPlayerSpectator(Player player, String str);

    void removePlayerSpectator(Player player, boolean z);

    void removeAllSpectator();

    void removeArenaSpectators(String str, boolean z);

    HashMap<String, WarArenaData> getArenaData();

    Location getLeftAction();

    Location getRightAction();

    HashMap<Player, String> getSpectator();

    HashMap<Location, Player> getPlacedLocations();
}
