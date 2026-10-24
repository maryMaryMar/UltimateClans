package me.module.rewards;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.rewards.manager.RewardsManager;
import me.module.rewards.manager.a;
import me.module.rewards.manager.c;
import me.module.rewards.manager.d;
import me.module.rewards.manager.e;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/Rewards.class */
public class Rewards extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Rewards f149a;
    private static Clans b;
    private d d;
    private TaskScheduler e;
    private RewardsManager f;
    private a i;
    private e j;
    private c k;
    private Logger c = null;
    private List<Listener> g = new ArrayList();
    private boolean h = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f149a = this;
        b = (Clans) getInstance();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        this.d = new d();
        this.k = new c();
        if (!j().d()) {
            getInstance().getLogger().warning(" ! " + getName() + ", Reason: Mysql connection error");
            a().getModuleEnabledList().put(this, false);
            setEnabled(false);
            onDisable();
            return;
        }
        this.f = new RewardsManager();
        this.i = new a();
        this.j = new e();
        Bukkit.getPluginManager().registerEvents(new me.module.rewards.a.a(), getInstance());
        b.getIntegrationAPI().registerRewardsAPI(this.f);
        b.getLogger().info(" - Module : Rewards (+API)");
        b.getModuleEnabledList().put(this, true);
        k();
    }

    private void k() {
        me.module.rewards.manager.a.a.a.c.a().exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.g != null) {
            this.g.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
        if (this.f != null) {
            b.getIntegrationAPI().unregisterRewardsAPI(this.f);
        }
    }

    public static Rewards getModuleCore() {
        return f149a;
    }

    public static Clans a() {
        return b;
    }

    public Logger b() {
        return this.c;
    }

    public d c() {
        return this.d;
    }

    public TaskScheduler d() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public List<Listener> e() {
        return this.g;
    }

    public boolean f() {
        return this.h;
    }

    public a g() {
        return this.i;
    }

    public e h() {
        return this.j;
    }

    public RewardsManager i() {
        return this.f;
    }

    public c j() {
        return this.k;
    }
}
