package me.ulrich.clans.api;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.interfaces.ClanAPI;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/ClanAPIManager.class */
public class ClanAPIManager implements ClanAPI {
    private final Clans plugin;

    public ClanAPIManager(Clans clans) {
        this.plugin = clans;
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public void saveClanData(ClanData clanData) {
        this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(clanData);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public void deleteClanData(UUID uuid) {
        this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public void reloadClanData(UUID uuid) {
        this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public void loadAllClanData() {
        this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY();
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public ConcurrentHashMap<UUID, ClanData> getClanData() {
        return this.plugin.getClanManager().CDW4Fj1iwdIXEOqWjiJSR();
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public Optional<UUID> getClanByTag(String str) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public Optional<ClanData> getClanDataByTag(String str) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean tagExists(String str) {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean clanExists(UUID uuid) {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public Optional<ClanData> getClan(UUID uuid) {
        return this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean verifyClan(UUID uuid) {
        return this.plugin.getClanManager().xtOheRiObl4QeAl(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public void clanMessageSend(UUID uuid, String str) {
        this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean promotePlayer(UUID uuid, UUID uuid2, Optional<ModerationData> optional) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2, optional);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean demotePlayer(UUID uuid, UUID uuid2, Optional<ModerationData> optional) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, uuid2, optional);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean banPlayer(UUID uuid, UUID uuid2, UUID uuid3) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2, uuid3);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean unbanPlayer(UUID uuid, UUID uuid2) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean kickPlayer(UUID uuid, UUID uuid2, UUID uuid3) {
        return this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(uuid2, ClanEnum.PlayerLeaveReaction.KICK);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean changeLeader(UUID uuid, Player player) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid, player);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean changeLeader(UUID uuid, UUID uuid2) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, uuid2);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean modTag(ClanData clanData, String str, Player player) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanData, str, player);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean modDesc(ClanData clanData, String str, Player player) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(clanData, str, player);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean changeSetting(ClanData clanData, ClanEnum.SettingsType settingsType, ClanEnum.SettingsFlagsAccept settingsFlagsAccept) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(clanData, settingsType, settingsFlagsAccept);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean toggleFF(ClanData clanData) {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(clanData);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean toggleGlobalFF(CommandSender commandSender) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean deleteClan(UUID uuid) {
        return this.plugin.getClanManager().zJnaNCVQSgEShq(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean deletePlayerClan(UUID uuid) {
        return this.plugin.getClanManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public Optional<ClanData> createNewClan(Player player, String str, String str2, long j) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(player, str, str2, j);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public Optional<ClanData> createNewClan(UUID uuid, String str, String str2, long j) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid, str, str2, j);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public void teleportDelay(Player player, Optional<EncodedLocationData> optional, boolean z) {
        this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(player, optional, z);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public List<String> getAllClansTags() {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public List<ClanData> getAllClansData() {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l();
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public List<UUID> getAllClansUUID() {
        return this.plugin.getClanManager().iZTqZaRK5UGoe0Z();
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    @Deprecated
    public List<ClanData> getTopClansData(ClanEnum.PlaceholderTop placeholderTop) {
        return this.plugin.getTopManager().ZwrsrwOCXRUscW6Q(placeholderTop);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public HashMap<UUID, Float> getTopClans(ClanEnum.PlaceholderTop placeholderTop) {
        return this.plugin.getTopManager().jBUuLP0sWwaPyPOmogdX7l(placeholderTop);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    @Deprecated
    public void sort(List<ClanData> list, ClanEnum.PlaceholderTop placeholderTop) {
        this.plugin.getTopManager().v8qP8fE86HMhvNuYPFjqY(list, placeholderTop);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public double getClanKDR(UUID uuid) {
        return this.plugin.getClanManager().b4i2FbOkaKeg91LiAe6l(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean resetClanKDR(ClanData clanData) {
        return this.plugin.getClanManager().iZTqZaRK5UGoe0Z(clanData);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean resetClanKDR(UUID uuid) {
        return this.plugin.getClanManager().p31abtwfBag2jhMH6K(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean addExtraChest(UUID uuid, int i, CommandSender commandSender) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(uuid, i, commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean addSlot(String str, int i, CommandSender commandSender) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(str, i, commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean addSlot(UUID uuid, int i, CommandSender commandSender) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, i, commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean removeSlot(String str, int i, CommandSender commandSender) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(str, i, commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean removeSlot(UUID uuid, int i, CommandSender commandSender) {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(uuid, i, commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean setSlot(String str, int i, CommandSender commandSender) {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(str, i, commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean setSlot(UUID uuid, int i, CommandSender commandSender) {
        return this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid, i, commandSender);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean canMemberJoin(UUID uuid) {
        return this.plugin.getClanManager().o1VU1x4DAlrEtGKZ3jAdhE(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    @Deprecated
    public boolean hasClanModerationOnline(UUID uuid) {
        return this.plugin.getClanManager().vVo2VUvxrriklPdRxI(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public String parseText(UUID uuid, String str) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public List<ClanData> getRivalries(UUID uuid) {
        return this.plugin.getClanManager().Fc3p9FhCjSD1k5Ra4(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public List<ClanData> getAlliances(UUID uuid) {
        return this.plugin.getClanManager().Nz8xKv4RePC2a0f0iuYU(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean tryChangeModtag(Player player, String str) {
        return this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(player, str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean tryChangeDesc(Player player, String str) {
        return this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player, str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean tryCreateClan(Player player, String str) {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(player, str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean hasAddonEnabled(String str) {
        return this.plugin.getClanManager().iZTqZaRK5UGoe0Z(str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean hasExtensionEnabled(String str) {
        return this.plugin.getClanManager().xtOheRiObl4QeAl(str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean isGlobalFF() {
        return this.plugin.getClanManager().b4i2FbOkaKeg91LiAe6l();
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public boolean setJsonMeta(UUID uuid, String str) {
        return this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public Optional<String> getJsonMeta(UUID uuid) {
        return this.plugin.getClanManager().VkPRYe34Awk6AdSxoUC(uuid);
    }

    @Override // me.ulrich.clans.interfaces.ClanAPI
    public Set<UUID> getChatspy() {
        return this.plugin.getClanManager().p31abtwfBag2jhMH6K();
    }
}
