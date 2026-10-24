package me.ulrich.clans.interfaces;

import me.ulrich.clans.api.ClanAPIManager;
import me.ulrich.clans.api.ColorAPIManager;
import me.ulrich.clans.api.CommandAPIManager;
import me.ulrich.clans.api.EntityAPIManager;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.api.HooksAPIManager;
import me.ulrich.clans.api.IntegrationAPIManager;
import me.ulrich.clans.api.LibAPIManager;
import me.ulrich.clans.api.ModerationAPIManager;
import me.ulrich.clans.api.PlayerAPIManager;
import me.ulrich.clans.api.PlayerInviteAPIManager;
import org.bukkit.plugin.java.JavaPlugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/UClans.class */
public interface UClans {
    JavaPlugin getPlugin();

    ClanAPIManager getClanAPI();

    PlayerAPIManager getPlayerAPI();

    HooksAPIManager getHooksAPI();

    IntegrationAPIManager getIntegrationAPI();

    LibAPIManager getLibAPI();

    ModerationAPIManager getModAPI();

    CommandAPIManager getCommandAPI();

    EntityAPIManager getEntityAPI();

    GuiAPIManager getGuiAPI();

    ColorAPIManager getColorAPI();

    PlayerInviteAPIManager getInviteAPI();

    void startTasks();

    void registerEvents();

    void loadAddons();

    void loadExtensions();

    void loadModules();
}
