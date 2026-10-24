package me.module.home;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.home.listeners.ClanHomeListeners;
import me.module.home.manager.HomeManager;
import me.module.home.manager.a;
import me.module.home.manager.c;
import me.module.home.manager.e;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/Home.class */
public class Home extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Home f108a;
    private static Clans b;
    private e d;
    private TaskScheduler e;
    private HomeManager f;
    private a h;
    private c j;
    private Logger c = null;
    private List<Listener> g = new ArrayList();
    private boolean i = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f108a = this;
        b = (Clans) getInstance();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        this.d = new e();
        this.f = new HomeManager();
        this.h = new a();
        this.j = new c();
        Bukkit.getPluginManager().registerEvents(new ClanHomeListeners(), getInstance());
        b.getLogger().info(" - Module : Home (+API)");
        b.getIntegrationAPI().registerHomeAPI(this.f);
        b.getModuleEnabledList().put(this, true);
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.g != null) {
            this.g.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
        if (this.f != null) {
            b.getIntegrationAPI().unregisterHomeAPI(this.f);
        }
    }

    public static Home getModuleCore() {
        return f108a;
    }

    public static Clans a() {
        return b;
    }

    public Logger b() {
        return this.c;
    }

    public e c() {
        return this.d;
    }

    public TaskScheduler d() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public HomeManager e() {
        return this.f;
    }

    public List<Listener> f() {
        return this.g;
    }

    public boolean g() {
        return this.i;
    }

    public a h() {
        return this.h;
    }

    public c i() {
        return this.j;
    }
}
