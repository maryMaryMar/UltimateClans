package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.ModerationData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/ClanAPI.class */
public interface ClanAPI {
    void saveClanData(ClanData clanData);

    void deleteClanData(UUID uuid);

    void reloadClanData(UUID uuid);

    void loadAllClanData();

    ConcurrentHashMap<UUID, ClanData> getClanData();

    Optional<UUID> getClanByTag(String str);

    Optional<ClanData> getClanDataByTag(String str);

    boolean tagExists(String str);

    boolean clanExists(UUID uuid);

    Optional<ClanData> getClan(UUID uuid);

    boolean verifyClan(UUID uuid);

    void clanMessageSend(UUID uuid, String str);

    boolean promotePlayer(UUID uuid, UUID uuid2, Optional<ModerationData> optional);

    boolean demotePlayer(UUID uuid, UUID uuid2, Optional<ModerationData> optional);

    boolean banPlayer(UUID uuid, UUID uuid2, UUID uuid3);

    boolean unbanPlayer(UUID uuid, UUID uuid2);

    boolean kickPlayer(UUID uuid, UUID uuid2, UUID uuid3);

    boolean changeLeader(UUID uuid, Player player);

    boolean changeLeader(UUID uuid, UUID uuid2);

    boolean modTag(ClanData clanData, String str, Player player);

    boolean modDesc(ClanData clanData, String str, Player player);

    boolean changeSetting(ClanData clanData, ClanEnum.SettingsType settingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept);

    boolean toggleFF(ClanData clanData);

    boolean deleteClan(UUID uuid);

    boolean deletePlayerClan(UUID uuid);

    Optional<ClanData> createNewClan(Player player, String str, String str2, long j);

    Optional<ClanData> createNewClan(UUID uuid, String str, String str2, long j);

    void teleportDelay(Player player, Optional<EncodedLocationData> optional, boolean z);

    List<ClanData> getAllClansData();

    List<String> getAllClansTags();

    List<UUID> getAllClansUUID();

    List<ClanData> getTopClansData(ClanEnum.PlaceholderTop placeholderTop);

    HashMap<UUID, Float> getTopClans(ClanEnum.PlaceholderTop placeholderTop);

    void sort(List<ClanData> list, ClanEnum.PlaceholderTop placeholderTop);

    double getClanKDR(UUID uuid);

    boolean resetClanKDR(ClanData clanData);

    boolean resetClanKDR(UUID uuid);

    boolean addExtraChest(UUID uuid, int i, CommandSender commandSender);

    boolean addSlot(String str, int i, CommandSender commandSender);

    boolean addSlot(UUID uuid, int i, CommandSender commandSender);

    boolean removeSlot(String str, int i, CommandSender commandSender);

    boolean removeSlot(UUID uuid, int i, CommandSender commandSender);

    boolean setSlot(String str, int i, CommandSender commandSender);

    boolean setSlot(UUID uuid, int i, CommandSender commandSender);

    boolean canMemberJoin(UUID uuid);

    boolean hasClanModerationOnline(UUID uuid);

    String parseText(UUID uuid, String str);

    List<ClanData> getRivalries(UUID uuid);

    List<ClanData> getAlliances(UUID uuid);

    boolean tryChangeModtag(Player player, String str);

    boolean tryChangeDesc(Player player, String str);

    boolean tryCreateClan(Player player, String str);

    boolean hasAddonEnabled(String str);

    boolean hasExtensionEnabled(String str);

    boolean toggleGlobalFF(CommandSender commandSender);

    boolean isGlobalFF();

    boolean setJsonMeta(UUID uuid, String str);

    Optional<String> getJsonMeta(UUID uuid);

    Set<UUID> getChatspy();
}
