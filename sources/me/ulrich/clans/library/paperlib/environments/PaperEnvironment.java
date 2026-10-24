package me.ulrich.clans.library.paperlib.environments;

import me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunksPaper_13;
import me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunksPaper_15;
import me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunksPaper_9_12;
import me.ulrich.clans.library.paperlib.features.asyncteleport.AsyncTeleportPaper;
import me.ulrich.clans.library.paperlib.features.asyncteleport.AsyncTeleportPaper_13;
import me.ulrich.clans.library.paperlib.features.bedspawnlocation.BedSpawnLocationPaper;
import me.ulrich.clans.library.paperlib.features.blockstatesnapshot.BlockStateSnapshotOptionalSnapshots;
import me.ulrich.clans.library.paperlib.features.chunkisgenerated.ChunkIsGeneratedApiExists;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.HumanEntity;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/environments/PaperEnvironment.class */
public class PaperEnvironment extends SpigotEnvironment {
    public PaperEnvironment() {
        if (isVersion(13, 1)) {
            this.asyncChunksHandler = new AsyncChunksPaper_13();
            this.asyncTeleportHandler = new AsyncTeleportPaper_13();
        } else if (isVersion(9) && !isVersion(13)) {
            this.asyncChunksHandler = new AsyncChunksPaper_9_12();
            this.asyncTeleportHandler = new AsyncTeleportPaper();
        }
        if (isVersion(12)) {
            this.isGeneratedHandler = new ChunkIsGeneratedApiExists();
            this.blockStateSnapshotHandler = new BlockStateSnapshotOptionalSnapshots();
        }
        if (isVersion(15, 2)) {
            try {
                World.class.getDeclaredMethod("getChunkAtAsyncUrgently", Location.class);
                this.asyncChunksHandler = new AsyncChunksPaper_15();
                HumanEntity.class.getDeclaredMethod("getPotentialBedLocation", new Class[0]);
                this.bedSpawnLocationHandler = new BedSpawnLocationPaper();
            } catch (NoSuchMethodException e) {
            }
        }
    }

    @Override // me.ulrich.clans.library.paperlib.environments.SpigotEnvironment, me.ulrich.clans.library.paperlib.environments.CraftBukkitEnvironment, me.ulrich.clans.library.paperlib.environments.Environment
    public String getName() {
        return "Paper";
    }

    @Override // me.ulrich.clans.library.paperlib.environments.Environment
    public boolean isPaper() {
        return true;
    }
}
