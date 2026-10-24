package me.ext.tab.manager;

import java.util.Optional;
import me.neznamy.tab.api.TabAPI;
import me.neznamy.tab.api.TabPlayer;
import me.neznamy.tab.api.scoreboard.ScoreboardManager;
import me.ulrich.clans.interfaces.ScoreboardImplement;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Tab.jar:me/ext/tab/manager/Implementation.class */
public class Implementation implements ScoreboardImplement {
    private TabAPI tabAPI;
    private Plugin plugin;

    public Implementation(Plugin plugin) {
        this.tabAPI = null;
        this.plugin = plugin;
        this.tabAPI = TabAPI.getInstance();
        if (TabAPI.getInstance().getScoreboardManager() == null) {
            this.tabAPI = null;
        }
    }

    @Override // me.ulrich.clans.interfaces.ScoreboardImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(getPlugin().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.ScoreboardImplement
    public Optional<String> getPluginName() {
        return Optional.of(getPlugin().getDescription().getName());
    }

    @Override // me.ulrich.clans.interfaces.ScoreboardImplement
    public boolean hidePluginScoreboard(Player player) {
        if (getTabAPI() != null) {
            ScoreboardManager sb = getTabAPI().getScoreboardManager();
            TabPlayer tabplayer = getTabAPI().getPlayer(player.getUniqueId());
            if (tabplayer != null && tabplayer.isLoaded()) {
                sb.setScoreboardVisible(tabplayer, false, false);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.ScoreboardImplement
    public boolean showPluginScoreboard(Player player) {
        if (getTabAPI() != null) {
            ScoreboardManager sb = getTabAPI().getScoreboardManager();
            TabPlayer tabplayer = getTabAPI().getPlayer(player.getUniqueId());
            if (tabplayer != null && tabplayer.isLoaded()) {
                sb.resetScoreboard(tabplayer);
                sb.setScoreboardVisible(tabplayer, true, false);
                return true;
            }
            return false;
        }
        return false;
    }

    public TabAPI getTabAPI() {
        return this.tabAPI;
    }

    public Plugin getPlugin() {
        return this.plugin;
    }
}
