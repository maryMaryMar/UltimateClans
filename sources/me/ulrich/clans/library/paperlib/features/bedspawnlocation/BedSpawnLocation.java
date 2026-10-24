package me.ulrich.clans.library.paperlib.features.bedspawnlocation;

import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/bedspawnlocation/BedSpawnLocation.class */
public interface BedSpawnLocation {
    CompletableFuture<Location> getBedSpawnLocationAsync(Player player, boolean z);
}
