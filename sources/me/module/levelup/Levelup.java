package me.module.levelup;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.levelup.listeners.ChanLevelListern;
import me.module.levelup.listeners.ChanPointListern;
import me.module.levelup.manager.LevelupManager;
import me.module.levelup.manager.a;
import me.module.levelup.manager.b;
import me.module.levelup.manager.d;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/Levelup.class */
public class Levelup extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Levelup f114a;
    private static Clans b;
    private d d;
    private TaskScheduler e;
    private LevelupManager f;
    private a i;
    private b j;
    private static byte[] __aes_key_3cKgBK3j = {(byte) 195, (byte) 165, (byte) 182, (byte) 0, (byte) 98, (byte) 202, (byte) 232, (byte) 178, (byte) 49, (byte) 201, (byte) 209, (byte) 70, (byte) 143, (byte) 163, (byte) 33, (byte) 157, (byte) 8, (byte) 159, (byte) 187, (byte) 97, (byte) 243, (byte) 61, (byte) 166, (byte) 14, (byte) 4, (byte) 63, (byte) 167, (byte) 235, (byte) 173, (byte) 176, (byte) 149, (byte) 172};
    private static byte[] __aes_iv_6NQqyZHH = {(byte) 102, (byte) 79, (byte) 125, (byte) 29, (byte) 21, (byte) 67, (byte) 183, (byte) 223, (byte) 101, (byte) 53, (byte) 199, (byte) 227, (byte) 212, (byte) 247, (byte) 14, (byte) 136};
    private static String __s_cache_j46sdjbg_0;
    private Logger c = null;
    private List<Listener> g = new ArrayList();
    private boolean h = false;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f114a = this;
        b = (Clans) getInstance();
        this.c = Logger.getLogger(getName());
        a(b.getLibAPI().getScheduler());
        this.d = new d();
        this.f = new LevelupManager();
        this.i = new a();
        this.j = new b();
        Bukkit.getPluginManager().registerEvents(new ChanLevelListern(), getInstance());
        Bukkit.getPluginManager().registerEvents(new ChanPointListern(), getInstance());
        b.getLogger().info(" - Module : Levelup (+API)");
        b.getIntegrationAPI().registerLevelupAPI(this.f);
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
            b.getIntegrationAPI().unregisterLevelupAPI(this.f);
        }
    }

    public static Levelup getModuleCore() {
        return f114a;
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

    public LevelupManager e() {
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

    public b i() {
        return this.j;
    }

    private static String __unused_1() {
        return " - Module : Levelup (+API)";
    }
}
