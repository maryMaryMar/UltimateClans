package me.module.mail;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.mail.manager.MailManager;
import me.module.mail.manager.a;
import me.module.mail.manager.a.a.a.c;
import me.module.mail.manager.d;
import me.module.mail.manager.e;
import me.module.mail.manager.g;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/Mail.class */
public class Mail extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Mail f131a;
    private static Clans b;
    private g d;
    private TaskScheduler e;
    private MailManager f;
    private d g;
    private a j;
    private e k;
    private Logger c = null;
    private List<Listener> h = new ArrayList();
    private boolean i = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f131a = this;
        b = (Clans) getInstance();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        this.d = new g();
        this.g = new d();
        if (!f().d()) {
            getInstance().getLogger().warning(" ! " + getName() + ", Reason: Mysql connection error");
            a().getModuleEnabledList().put(this, false);
            setEnabled(false);
            onDisable();
            return;
        }
        this.f = new MailManager();
        this.j = new a();
        this.k = new e();
        Bukkit.getPluginManager().registerEvents(new me.module.mail.b.a(), getInstance());
        b.getLogger().info(" - Module : Mail (+API)");
        b.getIntegrationAPI().registerMailAPI(this.f);
        b.getModuleEnabledList().put(this, true);
        k();
    }

    private void k() {
        c.a().exceptionally(th -> {
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
        if (this.f != null) {
            b.getIntegrationAPI().unregisterMailAPI(this.f);
        }
    }

    public static Mail getModuleCore() {
        return f131a;
    }

    public static Clans a() {
        return b;
    }

    public Logger b() {
        return this.c;
    }

    public g c() {
        return this.d;
    }

    public TaskScheduler d() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public MailManager e() {
        return this.f;
    }

    public d f() {
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

    public e j() {
        return this.k;
    }
}
