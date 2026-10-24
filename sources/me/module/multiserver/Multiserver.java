package me.module.multiserver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.multiserver.listeners.MultiserverListener;
import me.module.multiserver.listeners.PingListener;
import me.module.multiserver.listeners.SyncListener;
import me.module.multiserver.manager.MultiserverManager;
import me.module.multiserver.manager.a;
import me.module.multiserver.manager.b;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import me.ulrich.clans.manager.utils.VersionComparer;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/Multiserver.class */
public class Multiserver extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Multiserver f142a;
    private static Clans b;
    private a d;
    private TaskScheduler e;
    private MultiserverManager f;
    private List<MyScheduledTask> h;
    private Logger c = null;
    private List<Listener> g = new ArrayList();

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f142a = this;
        b = (Clans) getInstance();
        this.h = new ArrayList();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        if (new VersionComparer(b.getDescription().getVersion()).compareTo(new VersionComparer("9.0.0")) < 0) {
            getInstance().getLogger().warning(" ! " + getName() + ", Reason: Need Ultimate Clans 9.0.0+");
            b.getModuleEnabledList().put(this, false);
            setEnabled(false);
            onDisable();
            return;
        }
        this.d = new a();
        this.f = new MultiserverManager();
        Bukkit.getPluginManager().registerEvents(new MultiserverListener(), getInstance());
        Bukkit.getPluginManager().registerEvents(new SyncListener(), getInstance());
        Bukkit.getPluginManager().registerEvents(new PingListener(), getInstance());
        b.getLogger().info(" - Module : Multiserver (+API)");
        b.getIntegrationAPI().registerMultiserverAPI(this.f);
        b.getModuleEnabledList().put(this, true);
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.f != null) {
            b().info("Disabling Redis...");
            b.d();
        }
        if (this.g != null) {
            this.g.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
        if (this.h != null) {
            this.h.iterator().forEachRemaining(myScheduledTask -> {
                myScheduledTask.cancel();
            });
        }
        if (this.f != null) {
            b.getIntegrationAPI().unregisterMultiserverAPI(this.f);
        }
    }

    public static Multiserver getModuleCore() {
        return f142a;
    }

    public static Clans a() {
        return b;
    }

    public Logger b() {
        return this.c;
    }

    public a c() {
        return this.d;
    }

    public TaskScheduler d() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public MultiserverManager e() {
        return this.f;
    }

    public List<Listener> f() {
        return this.g;
    }

    public List<MyScheduledTask> g() {
        return this.h;
    }
}
