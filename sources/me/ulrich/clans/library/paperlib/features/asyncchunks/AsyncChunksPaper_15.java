package me.ulrich.clans.library.paperlib.features.asyncchunks;

import java.util.concurrent.CompletableFuture;
import org.bukkit.Chunk;
import org.bukkit.World;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/asyncchunks/AsyncChunksPaper_15.class */
public class AsyncChunksPaper_15 implements AsyncChunks {
    @Override // me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunks
    public CompletableFuture<Chunk> getChunkAtAsync(World world, int i, int i2, boolean z, boolean z2) {
        return world.getChunkAtAsync(i, i2, z, z2);
    }
}
