package me.module.discord;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.discord.listeners.ClanDiscordListern;
import me.module.discord.manager.ClanWebSocketClient;
import me.module.discord.manager.DiscordManager;
import me.module.discord.manager.DiscordPublicManager;
import me.module.discord.manager.a;
import me.module.discord.manager.b;
import me.module.discord.reflect.AbstractCommand;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import me.ulrich.clans.library.universalScheduler.scheduling.tasks.MyScheduledTask;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/Discord.class */
public class Discord extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Discord f105a;
    private static Clans b;
    private b d;
    private TaskScheduler e;
    private DiscordManager f;
    private a i;
    private List<MyScheduledTask> j;
    private ClanWebSocketClient k;
    private boolean l;
    private String m;
    private Logger c = null;
    private List<Listener> g = new ArrayList();
    private boolean h = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f105a = this;
        b = (Clans) getInstance();
        this.j = new ArrayList();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        AbstractCommand.enable();
        this.d = new b();
        this.f = new DiscordManager();
        this.i = new a();
        Bukkit.getPluginManager().registerEvents(new ClanDiscordListern(), getInstance());
        b.getIntegrationAPI().registerDiscordAPI(this.f);
        b.getLogger().info(" - Module : Discord (+API)");
        b.getModuleEnabledList().put(this, true);
        m();
    }

    private void m() {
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        AbstractCommand.removeCommand("discord_register");
        setEnabled(false);
        DiscordPublicManager.disconnectALL();
        if (j() != null) {
            j().forEach(myScheduledTask -> {
                if (myScheduledTask != null) {
                    myScheduledTask.cancel();
                }
            });
            j().clear();
        }
        if (g() != null) {
            g().forEach(listener -> {
                if (listener != null) {
                    HandlerList.unregisterAll(listener);
                }
            });
            g().clear();
        }
    }

    public ClanWebSocketClient a() {
        return this.k;
    }

    public static Discord getModuleCore() {
        return f105a;
    }

    public static Clans b() {
        return b;
    }

    public Logger c() {
        return this.c;
    }

    public b d() {
        return this.d;
    }

    public TaskScheduler e() {
        return this.e;
    }

    public void a(TaskScheduler taskScheduler) {
        this.e = taskScheduler;
    }

    public DiscordManager f() {
        return this.f;
    }

    public List<Listener> g() {
        return this.g;
    }

    public boolean h() {
        return this.h;
    }

    public a i() {
        return this.i;
    }

    public List<MyScheduledTask> j() {
        return this.j;
    }

    public String k() {
        return this.m;
    }

    public void a(String str) {
        this.m = str;
    }

    public boolean l() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }
}
