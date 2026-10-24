package me.ulrich.clans.api;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.OnlineData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.PlayerAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/PlayerAPIManager.class */
public class PlayerAPIManager implements PlayerAPI {
    private Clans plugin;

    public PlayerAPIManager(Clans clans) {
        this.plugin = clans;
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void loadAllPlayerData() {
        this.plugin.getPlayerManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void loadPlayerData(UUID uuid) {
        this.plugin.getPlayerManager().ZwrsrwOCXRUscW6Q(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void savePlayerData(PlayerData playerData) {
        this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(playerData);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public ConcurrentHashMap<UUID, PlayerData> getPlayerData() {
        return this.plugin.getPlayerManager().xtOheRiObl4QeAl();
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void loadAllOnlineInfo() {
        this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY();
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean hasClan(UUID uuid) {
        return this.plugin.getPlayerManager().zJnaNCVQSgEShq(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<UUID> getClanID(UUID uuid) {
        return this.plugin.getPlayerManager().xtOheRiObl4QeAl(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    @Deprecated
    public boolean hasClan(String str) {
        return this.plugin.getPlayerManager().ZwrsrwOCXRUscW6Q(str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<ClanData> getPlayerClan(UUID uuid) {
        return this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<ClanData> getPlayerClan(String str) {
        return this.plugin.getPlayerManager().iZTqZaRK5UGoe0Z(str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean hasPlayerData(UUID uuid) {
        return this.plugin.getPlayerManager().b4i2FbOkaKeg91LiAe6l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean hasPlayerData(String str) {
        return this.plugin.getPlayerManager().xtOheRiObl4QeAl(str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<PlayerData> getPlayerData(UUID uuid) {
        return this.plugin.getPlayerManager().p31abtwfBag2jhMH6K(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<PlayerData> getPlayerData(String str) {
        return this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean hasPlayerData(Player player) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean isSameClan(UUID uuid, UUID uuid2) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean canPVP(UUID uuid, UUID uuid2) {
        return this.plugin.getPlayerManager().iZTqZaRK5UGoe0Z(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean canGeneralPvp(UUID uuid, UUID uuid2) {
        return this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean canGeneralPvp(Player player, Player player2) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player, player2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean isLockedChat(Player player) {
        return this.plugin.getPlayerManager().ZwrsrwOCXRUscW6Q(player);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean isLockedChat(UUID uuid) {
        return this.plugin.getPlayerManager().Un3NRLL6aWivTcbodkcK(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean toggleChat(Player player) {
        return this.plugin.getPlayerManager().iZTqZaRK5UGoe0Z(player);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean toggleChat(UUID uuid) {
        return this.plugin.getPlayerManager().lGGwXL678c4Kv7skJb5NiE(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean isInClan(UUID uuid, UUID uuid2) {
        return this.plugin.getPlayerManager().xtOheRiObl4QeAl(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean isBanned(UUID uuid, UUID uuid2) {
        return this.plugin.getPlayerManager().zJnaNCVQSgEShq(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    @Deprecated
    public boolean openedJoin(Player player, UUID uuid) {
        return this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(player, uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    @Deprecated
    public boolean openedJoin(UUID uuid, UUID uuid2) {
        return this.plugin.getPlayerManager().Un3NRLL6aWivTcbodkcK(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public double getPlayerKDR(UUID uuid) {
        return this.plugin.getPlayerManager().Fc3p9FhCjSD1k5Ra4(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean resetPlayerKdr(UUID uuid) {
        return this.plugin.getPlayerManager().QXoNfOxIPaPrSlQMNR(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void updatePlayerKDR(Player player, Player player2) {
        this.plugin.getPlayerManager().xtOheRiObl4QeAl(player, player2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<PlayerData> checkPlayerData(Player player) {
        return this.plugin.getPlayerManager().zJnaNCVQSgEShq(player);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<PlayerData> checkPlayerData(UUID uuid) {
        return this.plugin.getPlayerManager().Nz8xKv4RePC2a0f0iuYU(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<PlayerData> checkPlayerData(UUID uuid, String str) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean removePlayerData(UUID uuid) {
        return this.plugin.getPlayerManager().IO1OGSMpoP1ZjOsbXi3a(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean addClanPlayer(PlayerData playerData, UUID uuid, Optional<ModerationData> optional) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(playerData, uuid, optional);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean removeClanPlayer(PlayerData playerData, UUID uuid) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(playerData, uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean updatePlayerRole(PlayerData playerData, Optional<ModerationData> optional) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(playerData, optional);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean changeNickname(UUID uuid, String str) {
        return this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean tryChangeNickname(Player player, String str) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player, str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean changeSetting(UUID uuid, ClanEnum.PlayerSettingsType playerSettingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid, playerSettingsType, settingsFlagsAccept);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void tryDamageIndicator(Player player, Player player2, double d) {
        this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player, player2, d);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean leaveClan(Player player) {
        return this.plugin.getPlayerManager().xtOheRiObl4QeAl(player);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean leaveClan(UUID uuid) {
        return this.plugin.getPlayerManager().o1VU1x4DAlrEtGKZ3jAdhE(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean toggleChatSpy(CommandSender commandSender) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(commandSender);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean isLeader(UUID uuid) {
        return this.plugin.getPlayerManager().vVo2VUvxrriklPdRxI(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean isLeader(UUID uuid, UUID uuid2) {
        return this.plugin.getPlayerManager().lGGwXL678c4Kv7skJb5NiE(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean canRegionPVP(Player player, Player player2) {
        return this.plugin.getPlayerManager().ZwrsrwOCXRUscW6Q(player, player2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void updatePlayerSkin(UUID uuid) {
        this.plugin.getPlayerManager().HX3ZfRb1nSpNq57s7x5ui(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void clearOnlineData() {
        this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l();
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<OnlineData> getOnlineData(UUID uuid) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public Optional<OnlineData> getOnlineData(String str) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(str);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean addOnlineData(UUID uuid, String str, String str2) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid, str, str2);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public boolean removeOnlineData(UUID uuid) {
        return this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.PlayerAPI
    public void solveProxiedPlayers(String str) {
        this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(str);
    }
}
