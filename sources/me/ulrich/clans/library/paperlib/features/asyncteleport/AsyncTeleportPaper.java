package me.ulrich.clans.library.paperlib.features.asyncteleport;

import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.library.paperlib.PaperLib;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/asyncteleport/AsyncTeleportPaper.class */
public class AsyncTeleportPaper implements AsyncTeleport {
    @Override // me.ulrich.clans.library.paperlib.features.asyncteleport.AsyncTeleport
    public CompletableFuture<Boolean> teleportAsync(Entity entity, Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return PaperLib.getChunkAtAsyncUrgently(location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, true).thenApply(chunk -> {
            return Boolean.valueOf(entity.teleport(location, teleportCause));
        });
    }
}
