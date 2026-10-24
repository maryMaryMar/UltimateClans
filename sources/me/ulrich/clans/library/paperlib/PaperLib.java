package me.ulrich.clans.library.paperlib;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import me.ulrich.clans.library.paperlib.environments.CraftBukkitEnvironment;
import me.ulrich.clans.library.paperlib.environments.Environment;
import me.ulrich.clans.library.paperlib.environments.PaperEnvironment;
import me.ulrich.clans.library.paperlib.environments.SpigotEnvironment;
import me.ulrich.clans.library.paperlib.features.blockstatesnapshot.BlockStateSnapshotResult;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/paperlib/PaperLib.class */
public class PaperLib {
    private static Environment ENVIRONMENT = initialize();

    private PaperLib() {
    }

    private static Environment initialize() {
        try {
            Class.forName("com.destroystokyo.paper.PaperConfig");
            return new PaperEnvironment();
        } catch (ClassNotFoundException e) {
            try {
                Class.forName("org.spigotmc.SpigotConfig");
                return new SpigotEnvironment();
            } catch (ClassNotFoundException e2) {
                return new CraftBukkitEnvironment();
            }
        }
    }

    @Nonnull
    public static Environment getEnvironment() {
        return ENVIRONMENT;
    }

    public static void setCustomEnvironment(@Nonnull Environment environment) {
        ENVIRONMENT = environment;
    }

    @Nonnull
    public static CompletableFuture<Boolean> teleportAsync(@Nonnull Entity entity, @Nonnull Location location) {
        return ENVIRONMENT.teleport(entity, location, PlayerTeleportEvent.TeleportCause.PLUGIN);
    }

    @Nonnull
    public static CompletableFuture<Boolean> teleportAsync(@Nonnull Entity entity, @Nonnull Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return ENVIRONMENT.teleport(entity, location, teleportCause);
    }

    @Nonnull
    public static CompletableFuture<Chunk> getChunkAtAsync(@Nonnull Location location) {
        return getChunkAtAsync(location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, true);
    }

    @Nonnull
    public static CompletableFuture<Chunk> getChunkAtAsync(@Nonnull Location location, boolean z) {
        return getChunkAtAsync(location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4, z);
    }

    @Nonnull
    public static CompletableFuture<Chunk> getChunkAtAsync(@Nonnull World world, int i, int i2) {
        return getChunkAtAsync(world, i, i2, true);
    }

    @Nonnull
    public static CompletableFuture<Chunk> getChunkAtAsync(@Nonnull World world, int i, int i2, boolean z) {
        return ENVIRONMENT.getChunkAtAsync(world, i, i2, z, false);
    }

    @Nonnull
    public static CompletableFuture<Chunk> getChunkAtAsync(@Nonnull World world, int i, int i2, boolean z, boolean z2) {
        return ENVIRONMENT.getChunkAtAsync(world, i, i2, z, z2);
    }

    @Nonnull
    public static CompletableFuture<Chunk> getChunkAtAsyncUrgently(@Nonnull World world, int i, int i2, boolean z) {
        return ENVIRONMENT.getChunkAtAsync(world, i, i2, z, true);
    }

    public static boolean isChunkGenerated(@Nonnull Location location) {
        return isChunkGenerated(location.getWorld(), location.getBlockX() >> 4, location.getBlockZ() >> 4);
    }

    public static boolean isChunkGenerated(@Nonnull World world, int i, int i2) {
        return ENVIRONMENT.isChunkGenerated(world, i, i2);
    }

    @Nonnull
    public static BlockStateSnapshotResult getBlockState(@Nonnull Block block, boolean z) {
        return ENVIRONMENT.getBlockState(block, z);
    }

    public static CompletableFuture<Location> getBedSpawnLocationAsync(@Nonnull Player player, boolean z) {
        return ENVIRONMENT.getBedSpawnLocationAsync(player, z);
    }

    public static boolean isVersion(int i) {
        return ENVIRONMENT.isVersion(i);
    }

    public static boolean isVersion(int i, int i2) {
        return ENVIRONMENT.isVersion(i, i2);
    }

    public static int getMinecraftVersion() {
        return ENVIRONMENT.getMinecraftVersion();
    }

    public static int getMinecraftPatchVersion() {
        return ENVIRONMENT.getMinecraftPatchVersion();
    }

    public static int getMinecraftPreReleaseVersion() {
        return ENVIRONMENT.getMinecraftPreReleaseVersion();
    }

    public static boolean isSpigot() {
        return ENVIRONMENT.isSpigot();
    }

    public static boolean isPaper() {
        return ENVIRONMENT.isPaper();
    }

    public static void suggestPaper(@Nonnull Plugin plugin) {
        suggestPaper(plugin, Level.INFO);
    }

    public static void suggestPaper(@Nonnull Plugin plugin, @Nonnull Level level) {
        if (isPaper()) {
            return;
        }
        String name = plugin.getDescription().getName();
        Logger logger = plugin.getLogger();
        logger.log(level, "====================================================");
        logger.log(level, " " + name + " works better if you use Paper ");
        logger.log(level, " as your server software. ");
        if (System.getProperty("paperlib.shown-benefits") == null) {
            System.setProperty("paperlib.shown-benefits", "1");
            logger.log(level, "  ");
            logger.log(level, " Paper offers significant performance improvements,");
            logger.log(level, " bug fixes, security enhancements and optional");
            logger.log(level, " features for server owners to enhance their server.");
            logger.log(level, "  ");
            logger.log(level, " Paper includes Timings v2, which is significantly");
            logger.log(level, " better at diagnosing lag problems over v1.");
            logger.log(level, "  ");
            logger.log(level, " All of your plugins should still work, and the");
            logger.log(level, " Paper community will gladly help you fix any issues.");
            logger.log(level, "  ");
            logger.log(level, " Join the Paper Community @ https://papermc.io");
        }
        logger.log(level, "====================================================");
    }
}
