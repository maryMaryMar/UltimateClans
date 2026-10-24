package me.ulrich.clans.library.universalScheduler;

import me.ulrich.clans.library.universalScheduler.bukkitScheduler.BukkitScheduler;
import me.ulrich.clans.library.universalScheduler.foliaScheduler.FoliaScheduler;
import me.ulrich.clans.library.universalScheduler.paperScheduler.PaperScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.utils.JavaUtil;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/UniversalScheduler.class */
public class UniversalScheduler {
    public static final boolean isFolia = JavaUtil.classExists("io.papermc.paper.threadedregions.RegionizedServer");
    public static final boolean isCanvas = JavaUtil.classExists("io.canvasmc.canvas.server.ThreadedServer");
    public static final boolean isExpandedSchedulingAvailable = JavaUtil.classExists("io.papermc.paper.threadedregions.scheduler.ScheduledTask");

    public static TaskScheduler getScheduler(Plugin plugin) {
        if (isFolia || isCanvas) {
            return new FoliaScheduler(plugin);
        }
        return isExpandedSchedulingAvailable ? new PaperScheduler(plugin) : new BukkitScheduler(plugin);
    }
}
