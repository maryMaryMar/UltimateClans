package me.ext.worldguard.manager;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.domains.Association;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.association.Associables;
import com.sk89q.worldguard.protection.association.RegionAssociable;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;
import javax.annotation.Nullable;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Worldguard.jar:me/ext/worldguard/manager/WorldGuardAPI.class */
public class WorldGuardAPI {
    private final Plugin owningPlugin;
    private Object worldGuard;
    private WorldGuardPlugin worldGuardPlugin;
    private StateFlag buildFlag;
    private StateFlag pvpFlag;
    private StateFlag exitFlag;
    private StateFlag entryFlag;
    private boolean legacy;
    private Object regionContainer = null;
    private Method regionContainerGetMethod = null;
    private Method createQueryMethod = null;
    private Method regionQueryTestStateMethod = null;
    private Method locationAdaptMethod = null;
    private Method worldAdaptMethod = null;
    private Method regionManagerGetMethod = null;
    private Constructor<?> vectorConstructor = null;
    private Method vectorConstructorAsAMethodBecauseWhyNot = null;
    private boolean initialized = false;

    public boolean isEnabled() {
        return this.worldGuardPlugin != null;
    }

    public WorldGuardAPI(Plugin plugin, Plugin owningPlugin) {
        this.worldGuard = null;
        this.worldGuardPlugin = null;
        this.legacy = false;
        this.owningPlugin = owningPlugin;
        if (plugin instanceof WorldGuardPlugin) {
            this.worldGuardPlugin = (WorldGuardPlugin) plugin;
            try {
                Class<?> worldGuardClass = Class.forName("com.sk89q.worldguard.WorldGuard");
                Method getInstanceMethod = worldGuardClass.getMethod("getInstance", new Class[0]);
                this.worldGuard = getInstanceMethod.invoke(null, new Object[0]);
            } catch (Exception e) {
                this.legacy = true;
            }
        }
    }

    protected RegionAssociable getAssociable(Player player) {
        RegionAssociable associable;
        if (player == null) {
            associable = Associables.constant(Association.NON_MEMBER);
        } else {
            associable = this.worldGuardPlugin.wrapPlayer(player);
        }
        return associable;
    }

    private void initialize() {
        if (!this.initialized) {
            this.initialized = true;
            if (this.worldGuard != null) {
                try {
                    Method getPlatFormMethod = this.worldGuard.getClass().getMethod("getPlatform", new Class[0]);
                    Object platform = getPlatFormMethod.invoke(this.worldGuard, new Object[0]);
                    Method getRegionContainerMethod = platform.getClass().getMethod("getRegionContainer", new Class[0]);
                    this.regionContainer = getRegionContainerMethod.invoke(platform, new Object[0]);
                    this.createQueryMethod = this.regionContainer.getClass().getMethod("createQuery", new Class[0]);
                    Class<?> worldEditLocationClass = Class.forName("com.sk89q.worldedit.util.Location");
                    Class<?> worldEditWorldClass = Class.forName("com.sk89q.worldedit.world.World");
                    Class<?> worldEditAdapterClass = Class.forName("com.sk89q.worldedit.bukkit.BukkitAdapter");
                    this.worldAdaptMethod = worldEditAdapterClass.getMethod("adapt", World.class);
                    this.locationAdaptMethod = worldEditAdapterClass.getMethod("adapt", Location.class);
                    this.regionContainerGetMethod = this.regionContainer.getClass().getMethod("get", worldEditWorldClass);
                    Class<?> regionQueryClass = Class.forName("com.sk89q.worldguard.protection.regions.RegionQuery");
                    this.regionQueryTestStateMethod = regionQueryClass.getMethod("testState", worldEditLocationClass, RegionAssociable.class, StateFlag[].class);
                    Class<?> flagsClass = Class.forName("com.sk89q.worldguard.protection.flags.Flags");
                    this.buildFlag = (StateFlag) flagsClass.getField("BUILD").get(null);
                    this.pvpFlag = (StateFlag) flagsClass.getField("PVP").get(null);
                    this.exitFlag = (StateFlag) flagsClass.getField("EXIT").get(null);
                    this.entryFlag = (StateFlag) flagsClass.getField("ENTRY").get(null);
                } catch (Exception ex) {
                    this.owningPlugin.getLogger().log(Level.WARNING, "Failed to bind to WorldGuard, integration will not work!", (Throwable) ex);
                    this.regionContainer = null;
                    return;
                }
            } else {
                this.regionContainer = this.worldGuardPlugin.getRegionContainer();
                try {
                    this.createQueryMethod = this.regionContainer.getClass().getMethod("createQuery", new Class[0]);
                    this.regionContainerGetMethod = this.regionContainer.getClass().getMethod("get", World.class);
                    Class<?> regionQueryClass2 = Class.forName("com.sk89q.worldguard.bukkit.RegionQuery");
                    this.regionQueryTestStateMethod = regionQueryClass2.getMethod("testState", Location.class, RegionAssociable.class, StateFlag[].class);
                    Class<?> flagsClass2 = Class.forName("com.sk89q.worldguard.protection.flags.DefaultFlag");
                    this.buildFlag = (StateFlag) flagsClass2.getField("BUILD").get(null);
                    this.pvpFlag = (StateFlag) flagsClass2.getField("PVP").get(null);
                    this.exitFlag = (StateFlag) flagsClass2.getField("EXIT").get(null);
                    this.entryFlag = (StateFlag) flagsClass2.getField("ENTRY").get(null);
                } catch (Exception ex2) {
                    this.owningPlugin.getLogger().log(Level.WARNING, "Failed to bind to WorldGuard, integration will not work!", (Throwable) ex2);
                    this.regionContainer = null;
                    return;
                }
            }
            try {
                Class<?> vectorClass = Class.forName("com.sk89q.worldedit.Vector");
                this.vectorConstructor = vectorClass.getConstructor(Double.TYPE, Double.TYPE, Double.TYPE);
                this.regionManagerGetMethod = RegionManager.class.getMethod("getApplicableRegions", vectorClass);
            } catch (Exception ex3) {
                try {
                    Class<?> vectorClass2 = Class.forName("com.sk89q.worldedit.math.BlockVector3");
                    this.vectorConstructorAsAMethodBecauseWhyNot = vectorClass2.getMethod("at", Double.TYPE, Double.TYPE, Double.TYPE);
                    this.regionManagerGetMethod = RegionManager.class.getMethod("getApplicableRegions", vectorClass2);
                } catch (Exception e) {
                    this.owningPlugin.getLogger().log(Level.WARNING, "Failed to bind to WorldGuard (no Vector class?), integration will not work!", (Throwable) ex3);
                    this.regionContainer = null;
                    return;
                }
            }
            if (this.regionContainer == null) {
                this.owningPlugin.getLogger().warning("Failed to find RegionContainer, WorldGuard integration will not function!");
            }
        }
    }

    @Nullable
    private RegionManager getRegionManager(World world) {
        initialize();
        if (this.regionContainer == null || this.regionContainerGetMethod == null) {
            return null;
        }
        RegionManager regionManager = null;
        try {
            if (this.worldAdaptMethod != null) {
                Object worldEditWorld = this.worldAdaptMethod.invoke(null, world);
                regionManager = (RegionManager) this.regionContainerGetMethod.invoke(this.regionContainer, worldEditWorld);
            } else {
                regionManager = (RegionManager) this.regionContainerGetMethod.invoke(this.regionContainer, world);
            }
        } catch (Exception ex) {
            this.owningPlugin.getLogger().log(Level.WARNING, "An error occurred looking up a WorldGuard RegionManager", (Throwable) ex);
        }
        return regionManager;
    }

    @Nullable
    public ApplicableRegionSet getRegionSet(Location location) {
        Object objInvoke;
        RegionManager regionManager = getRegionManager(location.getWorld());
        if (regionManager == null) {
            return null;
        }
        try {
            if (this.vectorConstructorAsAMethodBecauseWhyNot == null) {
                objInvoke = this.vectorConstructor.newInstance(Double.valueOf(location.getX()), Double.valueOf(location.getY()), Double.valueOf(location.getZ()));
            } else {
                objInvoke = this.vectorConstructorAsAMethodBecauseWhyNot.invoke(null, Double.valueOf(location.getX()), Double.valueOf(location.getY()), Double.valueOf(location.getZ()));
            }
            Object vector = objInvoke;
            return (ApplicableRegionSet) this.regionManagerGetMethod.invoke(regionManager, vector);
        } catch (Exception ex) {
            this.owningPlugin.getLogger().log(Level.WARNING, "An error occurred looking up a WorldGuard ApplicableRegionSet", (Throwable) ex);
            return null;
        }
    }

    public Map<String, ProtectedRegion> getWorldRegionList(World world) {
        RegionManager regionManager = getRegionManager(world);
        return regionManager == null ? new HashMap() : regionManager.getRegions();
    }

    public boolean isPVPAllowed(Player player, Location location) {
        ApplicableRegionSet checkSet;
        return this.worldGuardPlugin == null || location == null || (checkSet = getRegionSet(location)) == null || checkSet.queryState(getAssociable(player), new StateFlag[]{this.pvpFlag}) != StateFlag.State.DENY;
    }

    public boolean isEntryAllowed(Player player, Location location) {
        ApplicableRegionSet checkSet;
        return this.worldGuardPlugin == null || location == null || (checkSet = getRegionSet(location)) == null || checkSet.queryState(getAssociable(player), new StateFlag[]{this.entryFlag}) != StateFlag.State.DENY;
    }

    public boolean isExitAllowed(Player player, Location location) {
        ApplicableRegionSet checkSet;
        return this.worldGuardPlugin == null || location == null || (checkSet = getRegionSet(location)) == null || checkSet.queryState(getAssociable(player), new StateFlag[]{this.exitFlag}) != StateFlag.State.DENY;
    }

    public boolean isInRegion(Player player, String region) {
        if (this.worldGuardPlugin == null || player == null) {
            return false;
        }
        ApplicableRegionSet checkSet = getRegionSet(player.getLocation());
        Set<ProtectedRegion> rglist = checkSet.getRegions();
        for (ProtectedRegion rg : rglist) {
            if (rg.getId().equals(region)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getPlayerRegion(Player player) {
        if (this.worldGuardPlugin == null || player == null) {
            return null;
        }
        List<String> regions = new ArrayList<>();
        ApplicableRegionSet checkSet = getRegionSet(player.getLocation());
        Set<ProtectedRegion> rglist = checkSet.getRegions();
        for (ProtectedRegion rg : rglist) {
            regions.add(rg.getId().toString());
        }
        return regions;
    }

    public List<String> getLocationRegion(Location loc) {
        if (this.worldGuardPlugin == null || loc == null) {
            return null;
        }
        List<String> regions = new ArrayList<>();
        ApplicableRegionSet checkSet = getRegionSet(loc);
        Set<ProtectedRegion> rglist = checkSet.getRegions();
        for (ProtectedRegion rg : rglist) {
            regions.add(rg.getId().toString());
        }
        return regions;
    }

    public List<UUID> getOwners(Location loc) {
        if (this.worldGuardPlugin == null || loc == null) {
            return null;
        }
        List<UUID> regions = new ArrayList<>();
        ApplicableRegionSet checkSet = getRegionSet(loc);
        Set<ProtectedRegion> rglist = checkSet.getRegions();
        for (ProtectedRegion rg : rglist) {
            if (rg.hasMembersOrOwners() && rg.getOwners().size() > 0) {
                regions.addAll(rg.getOwners().getUniqueIds());
            }
        }
        return regions;
    }

    public List<UUID> getMembers(Location loc) {
        if (this.worldGuardPlugin == null || loc == null) {
            return null;
        }
        List<UUID> regions = new ArrayList<>();
        ApplicableRegionSet checkSet = getRegionSet(loc);
        Set<ProtectedRegion> rglist = checkSet.getRegions();
        for (ProtectedRegion rg : rglist) {
            if (rg.hasMembersOrOwners() && rg.getMembers().size() > 0) {
                regions.addAll(rg.getMembers().getUniqueIds());
            }
        }
        return regions;
    }

    public Location[] getCorders(Location loc) {
        if (this.worldGuardPlugin == null || loc == null) {
            return null;
        }
        Location[] regions = new Location[0];
        ApplicableRegionSet checkSet = getRegionSet(loc);
        Set<ProtectedRegion> rglist = checkSet.getRegions();
        for (ProtectedRegion rg : rglist) {
            regions = new Location[]{new Location(loc.getWorld(), rg.getMaximumPoint().getX(), rg.getMaximumPoint().getY(), rg.getMaximumPoint().getZ()), new Location(loc.getWorld(), rg.getMinimumPoint().getX(), rg.getMinimumPoint().getY(), rg.getMinimumPoint().getZ())};
        }
        return regions;
    }

    public HashMap<String, String> getFlags(Location loc) {
        if (this.worldGuardPlugin == null || loc == null) {
            return null;
        }
        HashMap<String, String> flags = new HashMap<>();
        ApplicableRegionSet checkSet = getRegionSet(loc);
        Set<ProtectedRegion> rglist = checkSet.getRegions();
        for (ProtectedRegion rg : rglist) {
            rg.getFlags().entrySet().iterator().forEachRemaining(flag -> {
                flags.put(((Flag) flag.getKey()).getName(), flag.getValue().toString());
            });
        }
        return new HashMap<>();
    }

    public boolean hasBuildPermission(Player player, Block block) {
        boolean result;
        initialize();
        if (block != null && this.createQueryMethod != null && this.regionContainer != null) {
            try {
                Object query = this.createQueryMethod.invoke(this.regionContainer, new Object[0]);
                if (this.locationAdaptMethod != null) {
                    Object location = this.locationAdaptMethod.invoke(null, block.getLocation());
                    result = ((Boolean) this.regionQueryTestStateMethod.invoke(query, location, getAssociable(player), new StateFlag[]{this.buildFlag})).booleanValue();
                } else {
                    result = ((Boolean) this.regionQueryTestStateMethod.invoke(query, block.getLocation(), getAssociable(player), new StateFlag[]{this.buildFlag})).booleanValue();
                }
                return result;
            } catch (Exception ex) {
                this.owningPlugin.getLogger().log(Level.WARNING, "An error occurred querying WorldGuard", (Throwable) ex);
                return true;
            }
        }
        return true;
    }

    public boolean isLegacy() {
        return this.legacy;
    }
}
