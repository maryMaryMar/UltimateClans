package me.ulrich.clans.library.paperlib.features.asyncchunks;

import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.library.paperlib.PaperLib;
import org.bukkit.Chunk;
import org.bukkit.World;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/asyncchunks/AsyncChunksSync.class */
public class AsyncChunksSync implements AsyncChunks {
    @Override // me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunks
    public CompletableFuture<Chunk> getChunkAtAsync(World world, int i, int i2, boolean z, boolean z2) {
        return (z || PaperLib.isChunkGenerated(world, i, i2)) ? CompletableFuture.completedFuture(world.getChunkAt(i, i2)) : CompletableFuture.completedFuture(null);
    }
}
