package me.module.banner;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.banner.listeners.ClanbannerListern;
import me.module.banner.manager.BannerManager;
import me.module.banner.manager.a;
import me.module.banner.manager.c;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/Banner.class */
public class Banner extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Banner f98a;
    private static Clans b;
    private c d;
    private TaskScheduler e;
    private BannerManager f;
    private a i;
    private List<MyScheduledTask> j;
    private Logger c = null;
    private List<Listener> g = new ArrayList();
    private boolean h = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f98a = this;
        b = (Clans) getInstance();
        this.j = new ArrayList();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        this.d = new c();
        b.getLibAPI().setDefaultBanner(this.d.h().getString("Config.Banner.default_material"));
        this.f = new BannerManager();
        this.i = new a();
        Bukkit.getPluginManager().registerEvents(new ClanbannerListern(), getInstance());
        b.getLogger().info(" - Module : Banner (+API)");
        b.getIntegrationAPI().registerBannerAPI(this.f);
        b.getModuleEnabledList().put(this, true);
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.g != null) {
            this.g.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
        if (this.j != null) {
            this.j.iterator().forEachRemaining(myScheduledTask -> {
                myScheduledTask.cancel();
            });
        }
        if (this.f != null) {
            b.getIntegrationAPI().unregisterBannerAPI(this.f);
        }
    }

    public static Banner getModuleCore() {
        return f98a;
    }

    public static Clans a() {
        return b;
    }

    public Logger b() {
        return this.c;
    }

    public c c() {
        return this.d;
    }

    public TaskScheduler d() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public BannerManager e() {
        return this.f;
    }

    public List<Listener> f() {
        return this.g;
    }

    public boolean g() {
        return this.h;
    }

    public a h() {
        return this.i;
    }

    public List<MyScheduledTask> i() {
        return this.j;
    }
}
