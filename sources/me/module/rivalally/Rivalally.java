package me.module.rivalally;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.rivalally.manager.RivalAllyManager;
import me.module.rivalally.manager.a;
import me.module.rivalally.manager.b;
import me.module.rivalally.manager.d;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/Rivalally.class */
public class Rivalally extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Rivalally f159a;
    private static Clans b;
    private b d;
    private TaskScheduler e;
    private RivalAllyManager f;
    private a i;
    private d j;
    private List<MyScheduledTask> k;
    private Logger c = null;
    private List<Listener> g = new ArrayList();
    private boolean h = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f159a = this;
        b = (Clans) getInstance();
        this.k = new ArrayList();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        this.d = new b();
        this.f = new RivalAllyManager();
        this.i = new a();
        this.j = new d();
        Bukkit.getPluginManager().registerEvents(new me.module.rivalally.a.a(), getInstance());
        b.getLogger().info(" - Module : RivalAlly (+API)");
        b.getIntegrationAPI().registerRivalAllyAPI(this.f);
        b.getModuleEnabledList().put(this, true);
        j().add(this.e.runTaskTimer(new me.module.rivalally.b.a(), 1200L, 1200L));
        j().add(this.e.runTaskTimer(new me.module.rivalally.b.b(), 1200L, 1200L));
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.g != null) {
            this.g.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
        if (this.k != null) {
            this.k.iterator().forEachRemaining(myScheduledTask -> {
                myScheduledTask.cancel();
            });
        }
        if (this.f != null) {
            b.getIntegrationAPI().unregisterRivalAllyAPI(this.f);
        }
    }

    public static Rivalally getModuleCore() {
        return f159a;
    }

    public static Clans a() {
        return b;
    }

    public Logger b() {
        return this.c;
    }

    public b c() {
        return this.d;
    }

    public TaskScheduler d() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public RivalAllyManager e() {
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

    public d i() {
        return this.j;
    }

    public List<MyScheduledTask> j() {
        return this.k;
    }
}
