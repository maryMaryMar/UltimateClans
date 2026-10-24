package me.ulrich.clans.library.paperlib.features.asyncteleport;

import java.util.concurrent.CompletableFuture;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/asyncteleport/AsyncTeleportPaper_13.class */
public class AsyncTeleportPaper_13 implements AsyncTeleport {
    @Override // me.ulrich.clans.library.paperlib.features.asyncteleport.AsyncTeleport
    public CompletableFuture<Boolean> teleportAsync(Entity entity, Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return entity.teleportAsync(location, teleportCause);
    }
}
