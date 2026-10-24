package me.ulrich.clans.library.paperlib.features.asyncchunks;

import java.util.concurrent.CompletableFuture;
import org.bukkit.Chunk;
import org.bukkit.World;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/features/asyncchunks/AsyncChunks.class */
public interface AsyncChunks {
    default CompletableFuture<Chunk> getChunkAtAsync(World world, int i, int i2, boolean z) {
        return getChunkAtAsync(world, i, i2, z, false);
    }

    CompletableFuture<Chunk> getChunkAtAsync(World world, int i, int i2, boolean z, boolean z2);
}
