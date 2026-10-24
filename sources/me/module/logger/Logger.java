package me.module.logger;

import java.util.ArrayList;
import java.util.List;
import me.module.logger.listeners.ClanLoggerListern;
import me.module.logger.manager.LoggerManager;
import me.module.logger.manager.a;
import me.module.logger.manager.c;
import me.module.logger.manager.d;
import me.module.logger.manager.f;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/Logger.class */
public class Logger extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Logger f121a;
    private static Clans b;
    private f d;
    private TaskScheduler e;
    private LoggerManager f;
    private c g;
    private a j;
    private d k;
    private List<MyScheduledTask> l;
    private java.util.logging.Logger c = null;
    private List<Listener> h = new ArrayList();
    private boolean i = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f121a = this;
        b = (Clans) getInstance();
        this.l = new ArrayList();
        this.c = java.util.logging.Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        this.d = new f();
        this.g = new c();
        if (!f().d()) {
            getInstance().getLogger().warning(" ! " + getName() + ", Reason: Mysql connection error");
            a().getModuleEnabledList().put(this, false);
            setEnabled(false);
            onDisable();
            return;
        }
        this.f = new LoggerManager();
        this.j = new a();
        this.k = new d();
        Bukkit.getPluginManager().registerEvents(new ClanLoggerListern(), getInstance());
        b.getLogger().info(" - Module : Logger (+API)");
        b.getIntegrationAPI().registerLoggerAPI(this.f);
        b.getModuleEnabledList().put(this, true);
        k().add(this.e.runTaskTimer(new me.module.logger.b.a(), 1200L, 1200L));
        l();
    }

    private void l() {
        me.module.logger.manager.a.a.a.c.a().exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.h != null) {
            this.h.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
        if (this.l != null) {
            this.l.iterator().forEachRemaining(myScheduledTask -> {
                myScheduledTask.cancel();
            });
        }
        if (this.f != null) {
            b.getIntegrationAPI().unregisterLoggerAPI(this.f);
        }
    }

    public static Logger getModuleCore() {
        return f121a;
    }

    public static Clans a() {
        return b;
    }

    public java.util.logging.Logger b() {
        return this.c;
    }

    public f c() {
        return this.d;
    }

    public TaskScheduler d() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public LoggerManager e() {
        return this.f;
    }

    public c f() {
        return this.g;
    }

    public List<Listener> g() {
        return this.h;
    }

    public boolean h() {
        return this.i;
    }

    public a i() {
        return this.j;
    }

    public d j() {
        return this.k;
    }

    public List<MyScheduledTask> k() {
        return this.l;
    }
}
