package me.ext.griefdefender.manager;

import com.griefdefender.api.claim.Claim;
import com.griefdefender.api.claim.TrustTypes;
import com.griefdefender.lib.flowpowered.math.vector.Vector3i;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ext.griefdefender.GriefDefender;
import me.ulrich.clans.interfaces.ClaimImplement;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Griefdefender.jar:me/ext/griefdefender/manager/Implementation.class */
public final class Implementation implements ClaimImplement {
    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean hasClaimLocation(Location location) {
        return getClaim(location).isPresent();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean isOwnerClaimLocation(Player player, Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            return claim.get().getOwnerUniqueId().equals(player.getUniqueId());
        }
        return false;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean isMemberClaimLocation(Player player, Location location) {
        return isOwnerClaimLocation(player, location);
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<UUID> getClaimOwner(Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            return Optional.of(claim.get().getOwnerUniqueId());
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Location[] getClaimCornersLocation(Player player, Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            Vector3i greater = claim.get().getGreaterBoundaryCorner();
            Vector3i lesser = claim.get().getLesserBoundaryCorner();
            World world = Bukkit.getWorld(claim.get().getWorldName());
            Location greaterLoc = vectorToLocation(world, greater);
            Location lesserLoc = vectorToLocation(world, lesser);
            Location[] finloc = {lesserLoc, greaterLoc};
            return finloc;
        }
        return new Location[0];
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public List<Chunk> getClaimChunksLocation(Player player, Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            Vector3i greater = claim.get().getGreaterBoundaryCorner();
            Vector3i lesser = claim.get().getLesserBoundaryCorner();
            World world = Bukkit.getWorld(claim.get().getWorldName());
            Location greaterLoc = vectorToLocation(world, greater);
            Location lesserLoc = vectorToLocation(world, lesser);
            return getChunksBetweenLocations(greaterLoc, lesserLoc);
        }
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean canDestroyClaimLocation(Player player, Location location) {
        try {
            Optional<Claim> claim = getClaim(location);
            if (claim.isPresent() && claim.get().isUserTrusted(player.getUniqueId(), TrustTypes.BUILDER)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getClaimName(Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            return Optional.of(claim.get().getOwnerName());
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(GriefDefender.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getPluginName() {
        return Optional.of(GriefDefender.getExtensionCore().getPluginImp().getDescription().getName());
    }

    public Optional<Claim> getClaim(Location loc) {
        Claim claim = com.griefdefender.api.GriefDefender.getCore().getClaimAt(loc);
        if (claim != null && !claim.isWilderness()) {
            return Optional.of(claim);
        }
        return Optional.empty();
    }

    public Location vectorToLocation(World world, Vector3i vector) {
        return new Location(world, vector.getX(), vector.getY(), vector.getZ());
    }

    public List<Chunk> getChunksBetweenLocations(Location loc1, Location loc2) {
        List<Chunk> chunks = new ArrayList<>();
        int minX = Math.min(loc1.getBlockX(), loc2.getBlockX()) >> 4;
        int maxX = Math.max(loc1.getBlockX(), loc2.getBlockX()) >> 4;
        int minZ = Math.min(loc1.getBlockZ(), loc2.getBlockZ()) >> 4;
        int maxZ = Math.max(loc1.getBlockZ(), loc2.getBlockZ()) >> 4;
        World world = loc1.getWorld();
        for (int x = minX; x <= maxX; x++) {
            for (int z = minZ; z <= maxZ; z++) {
                chunks.add(world.getChunkAt(x, z));
            }
        }
        return chunks;
    }
}
