package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.HomesData;
import me.ulrich.clans.data.ModerationData;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/UltimateClanAPI.class */
public interface UltimateClanAPI {
    void saveClanData(ClanData clanData);

    void deleteClanData(UUID uuid);

    void reloadClanData(UUID uuid);

    void loadAllClanData();

    Optional<UUID> getClanByTag(String str);

    Optional<ClanData> getClanDataByTag(String str);

    boolean tagExists(String str);

    boolean clanExists(UUID uuid);

    Optional<ClanData> getClan(UUID uuid);

    boolean verifyClan(UUID uuid);

    boolean allyAdd(UUID uuid, UUID uuid2);

    boolean allyRemove(UUID uuid, UUID uuid2);

    ClanEnum.AllyInviteReturn allySend(UUID uuid, UUID uuid2, boolean z);

    boolean rivalAdd(UUID uuid, UUID uuid2);

    boolean rivalRemove(UUID uuid, UUID uuid2);

    ClanEnum.RivalRemoveReturn rivalRemoveSend(UUID uuid, UUID uuid2, boolean z);

    boolean isRival(UUID uuid, UUID uuid2);

    boolean isAlly(UUID uuid, UUID uuid2);

    boolean isClanAlly(UUID uuid, UUID uuid2);

    boolean isClanRival(UUID uuid, UUID uuid2);

    void clanMessageSend(UUID uuid, String str);

    void clanChatSend(Player player, String str, boolean z);

    void clanChatSend(UUID uuid, String str, boolean z);

    boolean promotePlayer(UUID uuid, UUID uuid2, Optional<ModerationData> optional);

    boolean demotePlayer(UUID uuid, UUID uuid2, Optional<ModerationData> optional);

    boolean banPlayer(UUID uuid, UUID uuid2);

    boolean unbanPlayer(UUID uuid, UUID uuid2);

    boolean kickPlayer(UUID uuid, UUID uuid2);

    boolean changeLeader(UUID uuid, Player player);

    boolean changeLeader(UUID uuid, UUID uuid2);

    boolean leaveClan(Player player);

    boolean leaveClan(UUID uuid);

    boolean modTag(ClanData clanData, String str, Player player);

    boolean modDesc(ClanData clanData, String str, Player player);

    boolean changeSetting(ClanData clanData, ClanEnum.SettingsType settingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept);

    boolean toggleChatSpy(CommandSender commandSender);

    boolean toggleGlobalFF(CommandSender commandSender);

    boolean toggleFF(ClanData clanData);

    boolean isLeader(UUID uuid);

    boolean isLeader(UUID uuid, UUID uuid2);

    boolean deleteBanner(UUID uuid, Player player);

    boolean setBanner(UUID uuid, Player player, ItemStack itemStack);

    boolean saveBanner(ClanData clanData, Player player, ItemStack itemStack);

    boolean hasHome(UUID uuid, String str);

    boolean setHome(UUID uuid, Location location, String str);

    boolean deleteHome(UUID uuid, String str);

    Optional<Location> getHomeLocation(UUID uuid, String str);

    Optional<EncodedLocationData> getEncodedHomeLocation(UUID uuid, String str);

    Optional<HomesData> getHomeData(UUID uuid, String str);

    boolean deleteClan(UUID uuid);

    boolean deletePlayerClan(UUID uuid);

    Optional<ClanData> createNewClan(Player player, String str, String str2, long j);

    void teleportDelay(Player player, Optional<EncodedLocationData> optional, boolean z);

    List<String> getAllClansTags();

    List<UUID> getAllVerifiedClans();

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

    boolean tryCreateHome(Player player, String str);

    boolean tryCreateClan(Player player, String str);

    boolean hasAddonEnabled(String str);

    boolean hasExtensionEnabled(String str);
}
