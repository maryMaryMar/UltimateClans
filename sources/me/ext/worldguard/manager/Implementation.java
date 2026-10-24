package me.ext.worldguard.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ext.worldguard.WorldGuardRegion;
import me.ulrich.clans.interfaces.RegionImplement;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Worldguard.jar:me/ext/worldguard/manager/Implementation.class */
public final class Implementation implements RegionImplement {
    private WorldGuardManager worldguardManager;

    public Implementation(WorldGuardManager rg) {
        this.worldguardManager = rg;
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public List<String> getLocationRegion(Location loc) {
        return this.worldguardManager.getLocationRegion(loc);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public List<String> getWorldRegionList(World world) {
        return this.worldguardManager.getWorldRegionList(world);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public boolean hasRegion(String regionName, Location location) {
        if (getLocationRegion(location).contains(regionName)) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public boolean isPVPAllowed(Player player, Location location) {
        return this.worldguardManager.isPVPAllowed(player, location);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public boolean isExitAllowed(Player player, Location location) {
        return this.worldguardManager.isExitAllowed(player, location);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public boolean isInRegion(Player player, String regionName) {
        return this.worldguardManager.isInRegion(player, regionName);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public List<String> getPlayerRegion(Player player) {
        return this.worldguardManager.getPlayerRegion(player);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public boolean hasBuildPermission(Player player, Block block) {
        return this.worldguardManager.hasBuildPermission(player, block);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(WorldGuardRegion.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    public WorldGuardManager getWorldguardManager() {
        return this.worldguardManager;
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public boolean isEntryAllowed(Player player, Location location) {
        return this.worldguardManager.isEntryAllowed(player, location);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public List<UUID> getOwners(Location loc) {
        return this.worldguardManager.getOwners(loc);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public List<UUID> getMembers(Location loc) {
        return this.worldguardManager.getMembers(loc);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public Location[] getCorders(Location loc) {
        return this.worldguardManager.getCorders(loc);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public HashMap<String, String> getFlags(Location loc) {
        return this.worldguardManager.getFlags(loc);
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public Optional<String> getPluginName() {
        return Optional.of(WorldGuardRegion.getExtensionCore().getPluginImp().getDescription().getName());
    }

    @Override // me.ulrich.clans.interfaces.RegionImplement
    public boolean playerHasRegionList(Player player, List<String> stringList) {
        for (String rg : stringList) {
            if (hasRegion(rg, player.getLocation())) {
                return true;
            }
        }
        return false;
    }
}
