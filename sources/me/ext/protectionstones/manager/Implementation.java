package me.ext.protectionstones.manager;

import com.sk89q.worldedit.BlockVector2D;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import dev.espi.protectionstones.PSRegion;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ext.protectionstones.ProtectionStones;
import me.ulrich.clans.interfaces.ClaimImplement;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Protectionstones.jar:me/ext/protectionstones/manager/Implementation.class */
public final class Implementation implements ClaimImplement {
    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean hasClaimLocation(Location location) {
        PSRegion r1 = PSRegion.fromLocation(location);
        if (r1 != null) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean isOwnerClaimLocation(Player player, Location location) {
        PSRegion r1 = PSRegion.fromLocation(location);
        if (r1 != null) {
            return r1.getOwners().contains(player.getUniqueId());
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean isMemberClaimLocation(Player player, Location location) {
        PSRegion r1 = PSRegion.fromLocation(location);
        if (r1 != null) {
            return r1.isMember(player.getUniqueId());
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<UUID> getClaimOwner(Location location) {
        PSRegion r1 = PSRegion.fromLocation(location);
        if (r1 != null) {
            return Optional.of((UUID) r1.getOwners().get(0));
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Location[] getClaimCornersLocation(Player player, Location location) {
        Optional<PSRegion> claim = getClaim(location);
        if (claim.isPresent()) {
            ProtectedRegion region = claim.get().getWGRegion();
            List<BlockVector2D> points = region.getPoints();
            return convertToLocations(points, claim.get().getWorld(), location.getY());
        }
        return new Location[0];
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public List<Chunk> getClaimChunksLocation(Player player, Location location) {
        Location[] corners = getClaimCornersLocation(player, location);
        if (corners.length > 0) {
            return getChunksFromLocations(corners);
        }
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean canDestroyClaimLocation(Player player, Location location) {
        if (isOwnerClaimLocation(player, location) || isMemberClaimLocation(player, location)) {
            return true;
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getClaimName(Location location) {
        Optional<PSRegion> claim = getClaim(location);
        if (claim.isPresent()) {
            return Optional.of(claim.get().getName());
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(ProtectionStones.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getPluginName() {
        return Optional.of(ProtectionStones.getExtensionCore().getPluginImp().getDescription().getName());
    }

    public static Location[] convertToLocations(List<BlockVector2D> points, World world, double y) {
        if (points == null || world == null) {
            return new Location[0];
        }
        Location[] locations = new Location[points.size()];
        for (int i = 0; i < points.size(); i++) {
            BlockVector2D point = points.get(i);
            locations[i] = new Location(world, point.getX(), y, point.getZ());
        }
        return locations;
    }

    public Optional<PSRegion> getClaim(Location loc) {
        PSRegion r1 = PSRegion.fromLocation(loc);
        if (r1 != null) {
            return Optional.of(r1);
        }
        return Optional.empty();
    }

    public List<Chunk> getChunksFromLocations(Location[] locations) {
        List<Chunk> chunks = new ArrayList<>();
        if (locations == null || locations.length == 0) {
            return chunks;
        }
        World world = locations[0].getWorld();
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minZ = Integer.MAX_VALUE;
        int maxZ = Integer.MIN_VALUE;
        for (Location loc : locations) {
            if (!loc.getWorld().equals(world)) {
                throw new IllegalArgumentException("Todas as locations devem estar no mesmo mundo");
            }
            int x = loc.getBlockX();
            int z = loc.getBlockZ();
            if (x < minX) {
                minX = x;
            }
            if (x > maxX) {
                maxX = x;
            }
            if (z < minZ) {
                minZ = z;
            }
            if (z > maxZ) {
                maxZ = z;
            }
        }
        int maxX2 = maxX >> 4;
        int minZ2 = minZ >> 4;
        int maxZ2 = maxZ >> 4;
        for (int chunkX = minX >> 4; chunkX <= maxX2; chunkX++) {
            for (int chunkZ = minZ2; chunkZ <= maxZ2; chunkZ++) {
                chunks.add(world.getChunkAt(chunkX, chunkZ));
            }
        }
        return chunks;
    }
}
