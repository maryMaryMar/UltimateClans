package me.ulrich.clans.api;

import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.interfaces.HooksAPI;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/HooksAPIManager.class */
public class HooksAPIManager implements HooksAPI {
    private Clans plugin;

    public HooksAPIManager(Clans clans) {
        this.plugin = clans;
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public boolean isInDuel(Player player) {
        return this.plugin.getHooksManager().isInDuel(player);
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public Player getEnemyCombat(Player player) {
        return this.plugin.getHooksManager().getEnemyCombat(player);
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public boolean removeCombat(Player player) {
        return this.plugin.getHooksManager().removeCombat(player);
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public boolean isInCombat(Player player) {
        return this.plugin.getHooksManager().isInCombat(player);
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public boolean isFloodgate() {
        return this.plugin.getHooksManager().isFloodgate();
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public String getPlayerName(Player player) {
        return this.plugin.getHooksManager().getPlayerName(player);
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public String parsePapi(Player player, String str) {
        return this.plugin.getHooksManager().parsePapi(player, str);
    }

    @Override // me.ulrich.clans.interfaces.HooksAPI
    public String parsePapi(UUID uuid, String str) {
        return this.plugin.getHooksManager().parsePapi(uuid, str);
    }
}
