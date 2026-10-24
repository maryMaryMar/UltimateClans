package me.ulrich.clans.library.paperlib.features.asyncchunks;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.library.paperlib.PaperLib;
import org.bukkit.Chunk;
import org.bukkit.World;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/asyncchunks/AsyncChunksPaper_9_12.class */
public class AsyncChunksPaper_9_12 implements AsyncChunks {
    @Override // me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunks
    public CompletableFuture<Chunk> getChunkAtAsync(World world, int i, int i2, boolean z, boolean z2) {
        CompletableFuture<Chunk> completableFuture = new CompletableFuture<>();
        if (z || PaperLib.getMinecraftVersion() < 12 || world.isChunkGenerated(i, i2)) {
            Objects.requireNonNull(completableFuture);
            world.getChunkAtAsync(i, i2, (v1) -> {
                r0.complete(v1);
            });
        } else {
            completableFuture.complete(null);
        }
        return completableFuture;
    }
}
