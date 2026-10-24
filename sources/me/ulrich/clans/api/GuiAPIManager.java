package me.ulrich.clans.api;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.interfaces.GuiAPI;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/GuiAPIManager.class */
public class GuiAPIManager implements GuiAPI {
    private Clans plugin;

    public GuiAPIManager(Clans clans) {
        this.plugin = clans;
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public ConcurrentHashMap<String, GuiData> getInsertGui() {
        return this.plugin.getGuiManager().zJnaNCVQSgEShq();
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public List<Player> getOpenedGuiPlayers() {
        return this.plugin.getGuiManager().xtOheRiObl4QeAl();
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void closeAllOpened() {
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY();
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void insertItens(Gui gui, String str, String str2, Player player) {
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(gui, str, str2, player);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void insertItens(PaginatedGui paginatedGui, String str, String str2, Player player) {
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGui, str, str2, player);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void close(Player player) {
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(player);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public boolean useTitleAlerts() {
        return !this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.gui.disable_title_alerts");
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openChangeLeaderConfirm(Player player, UUID uuid, String str) {
        this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openChangeLeaderConfirm(player, uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openNoClanHome(Player player) {
        this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openNoClanHome(player);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanHome(Player player) {
        this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanMembersInvite(Player player, String str) {
        this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanMembersInvite(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanSearchMembersInvite(Player player, String str, String str2) {
        this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanSearchMembersInvite(player, str, str2);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanStats(Player player, ClanData clanData, String str) {
        this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanStats(player, clanData, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClansListMembers(Player player, UUID uuid, boolean z) {
        this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openClansListMembers(player, uuid, z);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanTop(Player player, ClanEnum.PlaceholderTop placeholderTop, int i, boolean z) {
        this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openClanTop(player, placeholderTop, i, z);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openPlayerTop(Player player, ClanEnum.PlaceholderPlayerTop placeholderPlayerTop, int i, boolean z, boolean z2) {
        this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openPlayerTop(player, placeholderPlayerTop, i, z, z2);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openProfileInvites(Player player, String str) {
        this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openProfileInvites(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openPlayerProfile(Player player, UUID uuid, String str) {
        this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfile(player, uuid, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openPlayerPermissions(Player player, UUID uuid, Optional<String> optional) {
        this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerPermissions(player, uuid, optional);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openPlayerProfileSettings(Player player, String str) {
        this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfileSettings(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openPlayerLanguages(Player player, Optional<String> optional) {
        this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerLanguages(player, optional);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanSettings(Player player, String str) {
        this.plugin.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanSettings(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openBannedMembers(Player player, String str) {
        this.plugin.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openBannedMembers(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanActions(Player player, String str) {
        this.plugin.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanActions(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openDisbandConfirm(Player player, String str) {
        this.plugin.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openDisbandConfirm(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanRoles(Player player, String str) {
        this.plugin.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanRoles(player, str);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void openClanRolesEditor(Player player, int i, String str, String str2) {
        this.plugin.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanRolesEditor(player, i, str, str2);
    }

    @Override // me.ulrich.clans.interfaces.GuiAPI
    public void registerLocalizedInsertItem(String str, String str2, Map<String, String> map, Map<String, List<String>> map2) {
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(str, str2, map, map2);
    }
}
