package me.ulrich.clans.library.paperlib.features.bedspawnlocation;

import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.library.paperlib.PaperLib;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/bedspawnlocation/BedSpawnLocationPaper.class */
public class BedSpawnLocationPaper implements BedSpawnLocation {
    @Override // me.ulrich.clans.library.paperlib.features.bedspawnlocation.BedSpawnLocation
    public CompletableFuture<Location> getBedSpawnLocationAsync(Player player, boolean z) {
        Location potentialBedLocation = player.getPotentialBedLocation();
        return (potentialBedLocation == null || potentialBedLocation.getWorld() == null) ? CompletableFuture.completedFuture(null) : PaperLib.getChunkAtAsync(potentialBedLocation.getWorld(), potentialBedLocation.getBlockX() >> 4, potentialBedLocation.getBlockZ() >> 4, false, z).thenCompose(chunk -> {
            return CompletableFuture.completedFuture(player.getBedSpawnLocation());
        });
    }
}
