package me.ulrich.clans.interfaces;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/GuiAPI.class */
public interface GuiAPI {
    ConcurrentHashMap<String, GuiData> getInsertGui();

    List<Player> getOpenedGuiPlayers();

    void closeAllOpened();

    void insertItens(Gui gui, String str, String str2, Player player);

    void insertItens(PaginatedGui paginatedGui, String str, String str2, Player player);

    void close(Player player);

    boolean useTitleAlerts();

    void registerLocalizedInsertItem(String str, String str2, Map<String, String> map, Map<String, List<String>> map2);

    void openChangeLeaderConfirm(Player player, UUID uuid, String str);

    void openNoClanHome(Player player);

    void openClanHome(Player player);

    void openClanMembersInvite(Player player, String str);

    void openClanSearchMembersInvite(Player player, String str, String str2);

    void openClanStats(Player player, ClanData clanData, String str);

    void openClansListMembers(Player player, UUID uuid, boolean z);

    void openClanTop(Player player, ClanEnum.PlaceholderTop placeholderTop, int i, boolean z);

    void openPlayerTop(Player player, ClanEnum.PlaceholderPlayerTop placeholderPlayerTop, int i, boolean z, boolean z2);

    void openProfileInvites(Player player, String str);

    void openPlayerProfile(Player player, UUID uuid, String str);

    void openPlayerPermissions(Player player, UUID uuid, Optional<String> optional);

    void openPlayerProfileSettings(Player player, String str);

    void openPlayerLanguages(Player player, Optional<String> optional);

    void openClanSettings(Player player, String str);

    void openBannedMembers(Player player, String str);

    void openClanActions(Player player, String str);

    void openDisbandConfirm(Player player, String str);

    void openClanRoles(Player player, String str);

    void openClanRolesEditor(Player player, int i, String str, String str2);
}
