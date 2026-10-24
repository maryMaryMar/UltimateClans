package me.module.chat;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import me.module.chat.manager.a;
import me.module.chat.manager.b;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.library.universalScheduler.scheduling.schedulers.TaskScheduler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:me/module/chat/Chat.class */
public class Chat extends Module {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Chat f103a;
    private static Clans b;
    private Logger c = null;
    private List<Listener> d;
    private b e;
    private TaskScheduler f;

    @Override // me.ulrich.clans.data.Module
    public void onEnable() {
        f103a = this;
        b = (Clans) getInstance();
        this.f = b.getLibAPI().getScheduler();
        this.d = new ArrayList();
        this.c = Logger.getLogger(getName());
        this.e = new b();
        f();
        a.a();
        b.getLogger().info(" - Module : Chat");
        b.getModuleEnabledList().put(this, true);
    }

    private void f() {
        EventPriority eventPriorityValueOf;
        try {
            try {
                eventPriorityValueOf = EventPriority.valueOf(this.e.g().getString("Clan.chat.priority"));
            } catch (IllegalArgumentException e) {
                eventPriorityValueOf = EventPriority.NORMAL;
            }
            me.module.chat.a.a aVar = new me.module.chat.a.a();
            b.getServer().getPluginManager().registerEvents(aVar, b());
            b.getServer().getPluginManager().registerEvent(AsyncPlayerChatEvent.class, aVar, eventPriorityValueOf, aVar, b(), true);
        } catch (Exception e2) {
            c().warning("An error occurred while registering the Clan Chat Listener!");
        }
    }

    @Override // me.ulrich.clans.data.Module
    public void onDisable() {
        if (this.d != null) {
            this.d.iterator().forEachRemaining(listener -> {
                HandlerList.unregisterAll(listener);
            });
        }
    }

    public List<Listener> a() {
        return this.d;
    }

    public void a(List<Listener> list) {
        this.d = list;
    }

    public static Chat getModuleCore() {
        return f103a;
    }

    public static Clans b() {
        return b;
    }

    public Logger c() {
        return this.c;
    }

    public b d() {
        return this.e;
    }

    public TaskScheduler e() {
        return this.f;
    }
}
