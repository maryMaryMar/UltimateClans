package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.data.addons.AddonEnum;
import me.ulrich.clans.data.addons.FarmCoinData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/FarmCoinsAddonAPI.class */
public interface FarmCoinsAddonAPI {
    String parseText(UUID uuid, String str);

    boolean isPlaced(Player player, Location location);

    void loadCoinList();

    boolean coinExists(String str);

    Optional<FarmCoinData> getCoin(String str);

    void checkReceive(Player player, Location location, AddonEnum.FarmAction farmAction, String str);

    Double clanLevelChance(UUID uuid, HashMap<Integer, Double> map);

    Double clanRoleChance(String str, HashMap<String, Double> map);

    Optional<ItemStack> getCoinItem(FarmCoinData farmCoinData, int i);

    HashMap<String, FarmCoinData> getCoinData();

    List<Material> getMaterialList();

    HashMap<Player, List<Location>> getBlockFollower();
}
