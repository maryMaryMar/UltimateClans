package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/RegionImplement.class */
public interface RegionImplement {
    boolean hasRegion(String str, Location location);

    boolean isPVPAllowed(Player player, Location location);

    boolean isExitAllowed(Player player, Location location);

    boolean isEntryAllowed(Player player, Location location);

    boolean isInRegion(Player player, String str);

    List<String> getPlayerRegion(Player player);

    boolean hasBuildPermission(Player player, Block block);

    List<String> getLocationRegion(Location location);

    List<String> getWorldRegionList(World world);

    List<UUID> getOwners(Location location);

    List<UUID> getMembers(Location location);

    Location[] getCorders(Location location);

    HashMap<String, String> getFlags(Location location);

    Optional<String> getPluginVersion();

    Optional<String> getPluginName();

    boolean playerHasRegionList(Player player, List<String> list);
}
