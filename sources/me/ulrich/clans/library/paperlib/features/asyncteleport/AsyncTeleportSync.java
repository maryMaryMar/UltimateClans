package me.ulrich.clans.library.paperlib.features.asyncteleport;

import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/asyncteleport/AsyncTeleportSync.class */
public class AsyncTeleportSync implements AsyncTeleport {
    @Override // me.ulrich.clans.library.paperlib.features.asyncteleport.AsyncTeleport
    public CompletableFuture<Boolean> teleportAsync(Entity entity, Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return CompletableFuture.completedFuture(Boolean.valueOf(entity.teleport(location, teleportCause)));
    }
}
