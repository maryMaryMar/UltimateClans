package me.ext.griefprevention.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ext.griefprevention.GriefPrevention;
import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.ClaimPermission;
import me.ulrich.clans.interfaces.ClaimImplement;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:extensions/Griefprevention.jar:me/ext/griefprevention/manager/Implementation.class */
public final class Implementation implements ClaimImplement {
    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean hasClaimLocation(Location location) {
        return getClaim(location).isPresent();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean isOwnerClaimLocation(Player player, Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            return claim.get().getOwnerID().equals(player.getUniqueId());
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
            return Optional.of(claim.get().getOwnerID());
        }
        return Optional.empty();
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Location[] getClaimCornersLocation(Player player, Location location) {
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            Location greater = claim.get().getGreaterBoundaryCorner();
            Location less = claim.get().getLesserBoundaryCorner();
            Location[] corners = {less, greater};
        }
        return new Location[0];
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public List<Chunk> getClaimChunksLocation(Player player, Location location) {
        List<Chunk> chunks = new ArrayList<>();
        Optional<Claim> claim = getClaim(location);
        if (claim.isPresent()) {
            return claim.get().getChunks();
        }
        return chunks;
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public boolean canDestroyClaimLocation(Player player, Location location) {
        try {
            Optional<Claim> claim = getClaim(location);
            if (claim.isPresent()) {
                ClaimPermission permission = claim.get().getPermission(player.getUniqueId().toString());
                return permission.equals(ClaimPermission.Build);
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
        return Optional.of(GriefPrevention.getExtensionCore().getPluginImp().getDescription().getVersion());
    }

    @Override // me.ulrich.clans.interfaces.ClaimImplement
    public Optional<String> getPluginName() {
        return Optional.of(GriefPrevention.getExtensionCore().getPluginImp().getDescription().getName());
    }

    public Optional<Claim> getClaim(Location loc) {
        Claim claim = me.ryanhamshire.GriefPrevention.GriefPrevention.instance.dataStore.getClaimAt(loc, true, (Claim) null);
        if (claim != null) {
            return Optional.of(claim);
        }
        return Optional.empty();
    }
}
