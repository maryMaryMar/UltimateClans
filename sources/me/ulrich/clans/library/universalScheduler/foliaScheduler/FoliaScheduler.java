package me.ulrich.clans.library.universalScheduler.foliaScheduler;

import io.papermc.paper.threadedregions.scheduler.AsyncScheduler;
import io.papermc.paper.threadedregions.scheduler.GlobalRegionScheduler;
import io.papermc.paper.threadedregions.scheduler.RegionScheduler;
import java.util.concurrent.TimeUnit;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/foliaScheduler/FoliaScheduler.class */
public class FoliaScheduler implements TaskScheduler {
    final Plugin plugin;
    private final RegionScheduler regionScheduler = Bukkit.getServer().getRegionScheduler();
    private final GlobalRegionScheduler globalRegionScheduler = Bukkit.getServer().getGlobalRegionScheduler();
    private final AsyncScheduler asyncScheduler = Bukkit.getServer().getAsyncScheduler();

    public FoliaScheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isGlobalThread() {
        return Bukkit.getServer().isGlobalTickThread();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isTickThread() {
        return Bukkit.getServer().isPrimaryThread();
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isEntityThread(Entity entity) {
        return Bukkit.getServer().isOwnedByCurrentRegion(entity);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isRegionThread(Location location) {
        return Bukkit.getServer().isOwnedByCurrentRegion(location);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTask(Runnable runnable) {
        return new FoliaScheduledTask(this.globalRegionScheduler.run(this.plugin, scheduledTask -> {
            runnable.run();
        }));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLater(Runnable runnable, long j) {
        return j <= 0 ? runTask(runnable) : new FoliaScheduledTask(this.globalRegionScheduler.runDelayed(this.plugin, scheduledTask -> {
            runnable.run();
        }, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimer(Runnable runnable, long j, long j2) {
        return new FoliaScheduledTask(this.globalRegionScheduler.runAtFixedRate(this.plugin, scheduledTask -> {
            runnable.run();
        }, getOneIfNotPositive(j), j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTask(Plugin plugin, Runnable runnable) {
        return new FoliaScheduledTask(this.globalRegionScheduler.run(plugin, scheduledTask -> {
            runnable.run();
        }));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLater(Plugin plugin, Runnable runnable, long j) {
        return j <= 0 ? runTask(plugin, runnable) : new FoliaScheduledTask(this.globalRegionScheduler.runDelayed(plugin, scheduledTask -> {
            runnable.run();
        }, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimer(Plugin plugin, Runnable runnable, long j, long j2) {
        return new FoliaScheduledTask(this.globalRegionScheduler.runAtFixedRate(plugin, scheduledTask -> {
            runnable.run();
        }, getOneIfNotPositive(j), j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTask(Location location, Runnable runnable) {
        return new FoliaScheduledTask(this.regionScheduler.run(this.plugin, location, scheduledTask -> {
            runnable.run();
        }));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLater(Location location, Runnable runnable, long j) {
        return j <= 0 ? runTask(runnable) : new FoliaScheduledTask(this.regionScheduler.runDelayed(this.plugin, location, scheduledTask -> {
            runnable.run();
        }, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimer(Location location, Runnable runnable, long j, long j2) {
        return new FoliaScheduledTask(this.regionScheduler.runAtFixedRate(this.plugin, location, scheduledTask -> {
            runnable.run();
        }, getOneIfNotPositive(j), j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTask(Entity entity, Runnable runnable) {
        return new FoliaScheduledTask(entity.getScheduler().run(this.plugin, scheduledTask -> {
            runnable.run();
        }, (Runnable) null));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLater(Entity entity, Runnable runnable, long j) {
        return j <= 0 ? runTask(entity, runnable) : new FoliaScheduledTask(entity.getScheduler().runDelayed(this.plugin, scheduledTask -> {
            runnable.run();
        }, (Runnable) null, j));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimer(Entity entity, Runnable runnable, long j, long j2) {
        return new FoliaScheduledTask(entity.getScheduler().runAtFixedRate(this.plugin, scheduledTask -> {
            runnable.run();
        }, (Runnable) null, getOneIfNotPositive(j), j2));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskAsynchronously(Runnable runnable) {
        return new FoliaScheduledTask(this.asyncScheduler.runNow(this.plugin, scheduledTask -> {
            runnable.run();
        }));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLaterAsynchronously(Runnable runnable, long j) {
        return new FoliaScheduledTask(this.asyncScheduler.runDelayed(this.plugin, scheduledTask -> {
            runnable.run();
        }, getOneIfNotPositive(j) * 50, TimeUnit.MILLISECONDS));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimerAsynchronously(Runnable runnable, long j, long j2) {
        return new FoliaScheduledTask(this.asyncScheduler.runAtFixedRate(this.plugin, scheduledTask -> {
            runnable.run();
        }, j * 50, j2 * 50, TimeUnit.MILLISECONDS));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskAsynchronously(Plugin plugin, Runnable runnable) {
        return new FoliaScheduledTask(this.asyncScheduler.runNow(plugin, scheduledTask -> {
            runnable.run();
        }));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskLaterAsynchronously(Plugin plugin, Runnable runnable, long j) {
        return new FoliaScheduledTask(this.asyncScheduler.runDelayed(plugin, scheduledTask -> {
            runnable.run();
        }, getOneIfNotPositive(j) * 50, TimeUnit.MILLISECONDS));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public MyScheduledTask runTaskTimerAsynchronously(Plugin plugin, Runnable runnable, long j, long j2) {
        return new FoliaScheduledTask(this.asyncScheduler.runAtFixedRate(plugin, scheduledTask -> {
            runnable.run();
        }, getOneIfNotPositive(j) * 50, j2 * 50, TimeUnit.MILLISECONDS));
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void execute(Runnable runnable) {
        this.globalRegionScheduler.execute(this.plugin, runnable);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void execute(Location location, Runnable runnable) {
        this.regionScheduler.execute(this.plugin, location, runnable);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void execute(Entity entity, Runnable runnable) {
        entity.getScheduler().execute(this.plugin, runnable, (Runnable) null, 1L);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void cancelTasks() {
        this.globalRegionScheduler.cancelTasks(this.plugin);
        this.asyncScheduler.cancelTasks(this.plugin);
    }

    @Override // me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public void cancelTasks(Plugin plugin) {
        this.globalRegionScheduler.cancelTasks(plugin);
        this.asyncScheduler.cancelTasks(plugin);
    }

    private long getOneIfNotPositive(long j) {
        if (j <= 0) {
            return 1L;
        }
        return j;
    }
}
