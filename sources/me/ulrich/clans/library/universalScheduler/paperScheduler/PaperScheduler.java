package me.ulrich.clans.library.universalScheduler.paperScheduler;

import me.ulrich.clans.library.universalScheduler.foliaScheduler.FoliaScheduler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/library/universalScheduler/paperScheduler/PaperScheduler.class */
public class PaperScheduler extends FoliaScheduler {
    public PaperScheduler(Plugin plugin) {
        super(plugin);
    }

    @Override // me.ulrich.clans.library.universalScheduler.foliaScheduler.FoliaScheduler, me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler
    public boolean isGlobalThread() {
        return Bukkit.getServer().isPrimaryThread();
    }
}
