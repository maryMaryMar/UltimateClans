package me.ext.worldguard.manager;

import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Worldguard.jar:me/ext/worldguard/manager/WorldGuardManager.class */
public class WorldGuardManager {
    private boolean enabled = false;
    private WorldGuardAPI worldGuard = null;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return this.enabled && this.worldGuard != null && this.worldGuard.isEnabled();
    }

    public void initializeWg(Plugin plugin) {
        try {
            Plugin wgPlugin = plugin.getServer().getPluginManager().getPlugin("WorldGuard");
            if (wgPlugin != null) {
                String[] versionPieces = StringUtils.split(wgPlugin.getDescription().getVersion(), '.');
                int version = Integer.parseInt(versionPieces[0]);
                if (version >= 6) {
                    this.worldGuard = new WorldGuardAPI(wgPlugin, plugin);
                } else {
                    plugin.getLogger().warning("Only WorldGuard 6 and above are supported- please update! (WG version: " + wgPlugin.getDescription().getVersion() + ")");
                }
            }
        } catch (Throwable ex) {
            plugin.getLogger().log(Level.WARNING, "Error setting up custom WorldGuard flags", ex);
        }
    }

    public Optional<ApplicableRegionSet> getRegionSet(Location location) {
        if (this.enabled && this.worldGuard != null) {
            return Optional.of(this.worldGuard.getRegionSet(location));
        }
        return Optional.empty();
    }

    public boolean isPVPAllowed(Player player, Location location) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.isPVPAllowed(player, location);
        }
        return false;
    }

    public boolean isExitAllowed(Player player, Location location) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.isExitAllowed(player, location);
        }
        return false;
    }

    public boolean isEntryAllowed(Player player, Location location) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.isEntryAllowed(player, location);
        }
        return false;
    }

    public boolean isInRegion(Player player, String region) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.isInRegion(player, region);
        }
        return false;
    }

    public List<String> getPlayerRegion(Player player) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.getPlayerRegion(player);
        }
        return null;
    }

    public List<String> getLocationRegion(Location loc) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.getLocationRegion(loc);
        }
        return null;
    }

    public List<UUID> getOwners(Location loc) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.getOwners(loc);
        }
        return new ArrayList();
    }

    public List<UUID> getMembers(Location loc) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.getMembers(loc);
        }
        return new ArrayList();
    }

    public Location[] getCorders(Location loc) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.getCorders(loc);
        }
        return new Location[0];
    }

    public HashMap<String, String> getFlags(Location loc) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.getFlags(loc);
        }
        return new HashMap<>();
    }

    public boolean hasBuildPermission(Player player, Block block) {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.hasBuildPermission(player, block);
        }
        return true;
    }

    public boolean isLegacy() {
        if (this.enabled && this.worldGuard != null) {
            return this.worldGuard.isLegacy();
        }
        return false;
    }

    public List<String> getWorldRegionList(World world) {
        ArrayList<String> regions = new ArrayList<>();
        if (this.enabled && this.worldGuard != null) {
            this.worldGuard.getWorldRegionList(world).entrySet().iterator().forEachRemaining(reg -> {
                regions.add(((ProtectedRegion) reg.getValue()).getId());
            });
        }
        return regions;
    }
}
