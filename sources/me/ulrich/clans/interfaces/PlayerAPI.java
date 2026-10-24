package me.ulrich.clans.interfaces;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.OnlineData;
import me.ulrich.clans.data.PlayerData;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/PlayerAPI.class */
public interface PlayerAPI {
    void loadAllPlayerData();

    void loadPlayerData(UUID uuid);

    void savePlayerData(PlayerData playerData);

    ConcurrentHashMap<UUID, PlayerData> getPlayerData();

    void loadAllOnlineInfo();

    boolean hasClan(UUID uuid);

    Optional<UUID> getClanID(UUID uuid);

    boolean hasClan(String str);

    Optional<ClanData> getPlayerClan(UUID uuid);

    Optional<ClanData> getPlayerClan(String str);

    boolean hasPlayerData(UUID uuid);

    boolean hasPlayerData(String str);

    Optional<PlayerData> getPlayerData(UUID uuid);

    Optional<PlayerData> getPlayerData(String str);

    boolean hasPlayerData(Player player);

    boolean isSameClan(UUID uuid, UUID uuid2);

    boolean canPVP(UUID uuid, UUID uuid2);

    boolean canRegionPVP(Player player, Player player2);

    boolean isLockedChat(Player player);

    boolean isLockedChat(UUID uuid);

    boolean toggleChat(Player player);

    boolean toggleChat(UUID uuid);

    boolean isInClan(UUID uuid, UUID uuid2);

    boolean isBanned(UUID uuid, UUID uuid2);

    boolean openedJoin(Player player, UUID uuid);

    boolean openedJoin(UUID uuid, UUID uuid2);

    double getPlayerKDR(UUID uuid);

    boolean resetPlayerKdr(UUID uuid);

    void updatePlayerKDR(Player player, Player player2);

    Optional<PlayerData> checkPlayerData(Player player);

    Optional<PlayerData> checkPlayerData(UUID uuid);

    Optional<PlayerData> checkPlayerData(UUID uuid, String str);

    boolean removePlayerData(UUID uuid);

    boolean addClanPlayer(PlayerData playerData, UUID uuid, Optional<ModerationData> optional);

    boolean removeClanPlayer(PlayerData playerData, UUID uuid);

    boolean updatePlayerRole(PlayerData playerData, Optional<ModerationData> optional);

    boolean changeNickname(UUID uuid, String str);

    boolean tryChangeNickname(Player player, String str);

    boolean changeSetting(UUID uuid, ClanEnum.PlayerSettingsType playerSettingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept);

    void tryDamageIndicator(Player player, Player player2, double d);

    boolean leaveClan(Player player);

    boolean leaveClan(UUID uuid);

    boolean toggleChatSpy(CommandSender commandSender);

    boolean isLeader(UUID uuid);

    boolean isLeader(UUID uuid, UUID uuid2);

    void updatePlayerSkin(UUID uuid);

    boolean canGeneralPvp(UUID uuid, UUID uuid2);

    boolean canGeneralPvp(Player player, Player player2);

    void clearOnlineData();

    Optional<OnlineData> getOnlineData(UUID uuid);

    Optional<OnlineData> getOnlineData(String str);

    boolean addOnlineData(UUID uuid, String str, String str2);

    boolean removeOnlineData(UUID uuid);

    void solveProxiedPlayers(String str);
}
