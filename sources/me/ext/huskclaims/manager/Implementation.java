package me.ext.huskclaims.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import me.ext.huskclaims.HuskClaims;
import me.ulrich.clans.interfaces.ClaimImplement;
import net.william278.huskclaims.api.BukkitHuskClaimsAPI;
import net.william278.huskclaims.claim.Claim;
import net.william278.huskclaims.claim.Region;
import net.william278.huskclaims.libraries.cloplib.operation.OperationType;
import net.william278.huskclaims.position.Position;
import net.william278.huskclaims.user.OnlineUser;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Huskclaims.jar:me/ext/huskclaims/manager/Implementation.class */
public final class Implementation implements ClaimImplement {
    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean hasClaimLocation(Location location) {
        return getClaim(location).isPresent();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean isOwnerClaimLocation(Player player, Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            return ((UUID) claim.get().getOwner().get()).equals(player.getUniqueId());
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
            return claim.get().getOwner();
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Location[] getClaimCornersLocation(Player player, Location location) {
        BukkitHuskClaimsAPI api = BukkitHuskClaimsAPI.getInstance();
        Optional<Claim> claimOpt = api.getClaimAt(api.getPosition(location));
        if (claimOpt.isEmpty()) {
            return new Location[0];
        }
        Claim claim = claimOpt.get();
        Region region = claim.getRegion();
        List<Region.Point> corners = region.getCorners();
        World world = location.getWorld();
        if (world == null) {
            return null;
        }
        int y = location.getBlockY();
        Location[] locCorners = new Location[corners.size()];
        for (int i = 0; i < corners.size(); i++) {
            Region.Point p = corners.get(i);
            locCorners[i] = new Location(world, p.getBlockX(), y, p.getBlockZ());
        }
        return locCorners;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public List<Chunk> getClaimChunksLocation(Player player, Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            return getChunksFromRegion(claim.get().getRegion(), location.getWorld());
        }
        return new ArrayList();
    }

    public List<Chunk> getChunksFromRegion(Region region, World world) {
        Set<int[]> chunkCoords = region.getChunks();
        List<Chunk> chunks = new ArrayList<>();
        for (int[] coords : chunkCoords) {
            int chunkX = coords[0];
            int chunkZ = coords[1];
            Chunk chunk = world.getChunkAt(chunkX, chunkZ);
            chunks.add(chunk);
        }
        return chunks;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean canDestroyClaimLocation(Player player, Location location) {
        BukkitHuskClaimsAPI api = BukkitHuskClaimsAPI.getInstance();
        OnlineUser user = api.getOnlineUser(player);
        Position position = api.getPosition(location);
        return api.isOperationAllowed(user, OperationType.BLOCK_BREAK, position);
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getClaimName(Location location) {
        BukkitHuskClaimsAPI api = BukkitHuskClaimsAPI.getInstance();
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            OnlineUser user = api.getOnlineUser((UUID) claim.get().getOwner().get());
            return Optional.of(user.getName());
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getPluginVersion() {
        return Optional.of(HuskClaims.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getPluginName() {
        return Optional.of(HuskClaims.getExtensionCore().getPluginImp().getDescription().getName());
    }

    public Optional<Claim> getClaim(Location loc) {
        BukkitHuskClaimsAPI huskClaimsAPI = BukkitHuskClaimsAPI.getInstance();
        Position pos = huskClaimsAPI.getPosition(loc);
        Optional<Claim> claim = huskClaimsAPI.getClaimAt(pos);
        if (claim.isPresent()) {
            return claim;
        }
        return Optional.empty();
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
