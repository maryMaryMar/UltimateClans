package me.ulrich.clans.library.paperlib.environments;

import java.util.concurrent.CompletableFuture;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunks;
import me.ulrich.clans.library.paperlib.features.asyncchunks.AsyncChunksSync;
import me.ulrich.clans.library.paperlib.features.asyncteleport.AsyncTeleport;
import me.ulrich.clans.library.paperlib.features.asyncteleport.AsyncTeleportSync;
import me.ulrich.clans.library.paperlib.features.bedspawnlocation.BedSpawnLocation;
import me.ulrich.clans.library.paperlib.features.bedspawnlocation.BedSpawnLocationSync;
import me.ulrich.clans.library.paperlib.features.blockstatesnapshot.BlockStateSnapshot;
import me.ulrich.clans.library.paperlib.features.blockstatesnapshot.BlockStateSnapshotBeforeSnapshots;
import me.ulrich.clans.library.paperlib.features.blockstatesnapshot.BlockStateSnapshotNoOption;
import me.ulrich.clans.library.paperlib.features.blockstatesnapshot.BlockStateSnapshotResult;
import me.ulrich.clans.library.paperlib.features.chunkisgenerated.ChunkIsGenerated;
import me.ulrich.clans.library.paperlib.features.chunkisgenerated.ChunkIsGeneratedApiExists;
import me.ulrich.clans.library.paperlib.features.chunkisgenerated.ChunkIsGeneratedUnknown;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/environments/Environment.class */
public abstract class Environment {
    private final int minecraftVersion;
    private final int minecraftPatchVersion;
    private final int minecraftPreReleaseVersion;
    protected ChunkIsGenerated isGeneratedHandler;
    protected BlockStateSnapshot blockStateSnapshotHandler;
    protected AsyncChunks asyncChunksHandler = new AsyncChunksSync();
    protected AsyncTeleport asyncTeleportHandler = new AsyncTeleportSync();
    protected BedSpawnLocation bedSpawnLocationHandler = new BedSpawnLocationSync();

    public Environment() {
        this.isGeneratedHandler = new ChunkIsGeneratedUnknown();
        Matcher matcher = Pattern.compile("(?i)\\(MC: (\\d)\\.(\\d+)\\.?(\\d+?)?(?: Pre-Release )?(\\d)?\\)").matcher(Bukkit.getVersion());
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        if (matcher.find()) {
            MatchResult matchResult = matcher.toMatchResult();
            try {
                i = Integer.parseInt(matchResult.group(2), 10);
            } catch (Exception e) {
            }
            if (matchResult.groupCount() >= 3) {
                try {
                    i2 = Integer.parseInt(matchResult.group(3), 10);
                } catch (Exception e2) {
                }
            }
            if (matchResult.groupCount() >= 4) {
                try {
                    i3 = Integer.parseInt(matcher.group(4));
                } catch (Exception e3) {
                }
            }
        }
        this.minecraftVersion = i;
        this.minecraftPatchVersion = i2;
        this.minecraftPreReleaseVersion = i3;
        if (isVersion(13, 1)) {
            this.isGeneratedHandler = new ChunkIsGeneratedApiExists();
        }
        if (isVersion(12)) {
            this.blockStateSnapshotHandler = new BlockStateSnapshotNoOption();
        } else {
            this.blockStateSnapshotHandler = new BlockStateSnapshotBeforeSnapshots();
        }
    }

    public abstract String getName();

    public CompletableFuture<Chunk> getChunkAtAsync(World world, int i, int i2, boolean z) {
        return this.asyncChunksHandler.getChunkAtAsync(world, i, i2, z, false);
    }

    public CompletableFuture<Chunk> getChunkAtAsync(World world, int i, int i2, boolean z, boolean z2) {
        return this.asyncChunksHandler.getChunkAtAsync(world, i, i2, z, z2);
    }

    public CompletableFuture<Chunk> getChunkAtAsyncUrgently(World world, int i, int i2, boolean z) {
        return this.asyncChunksHandler.getChunkAtAsync(world, i, i2, z, true);
    }

    public CompletableFuture<Boolean> teleport(Entity entity, Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return this.asyncTeleportHandler.teleportAsync(entity, location, teleportCause);
    }

    public boolean isChunkGenerated(World world, int i, int i2) {
        return this.isGeneratedHandler.isChunkGenerated(world, i, i2);
    }

    public BlockStateSnapshotResult getBlockState(Block block, boolean z) {
        return this.blockStateSnapshotHandler.getBlockState(block, z);
    }

    public CompletableFuture<Location> getBedSpawnLocationAsync(Player player, boolean z) {
        return this.bedSpawnLocationHandler.getBedSpawnLocationAsync(player, z);
    }

    public boolean isVersion(int i) {
        return isVersion(i, 0);
    }

    public boolean isVersion(int i, int i2) {
        return this.minecraftVersion > i || (this.minecraftVersion >= i && this.minecraftPatchVersion >= i2);
    }

    public int getMinecraftVersion() {
        return this.minecraftVersion;
    }

    public int getMinecraftPatchVersion() {
        return this.minecraftPatchVersion;
    }

    public int getMinecraftPreReleaseVersion() {
        return this.minecraftPreReleaseVersion;
    }

    public boolean isSpigot() {
        return false;
    }

    public boolean isPaper() {
        return false;
    }
}
