package me.ulrich.clans.tjCyMSV004ze7Mc;

import org.bukkit.entity.Player;

import me.ulrich.clans.Clans;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.EventExecutor;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx implements Listener, EventExecutor {
    public ZRp1tak21UvNaOVCtFx() {
        Clans.getClanCore().getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(PlayerQuitEvent playerQuitEvent) {
        Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(playerQuitEvent.getPlayer(), false);
    }

    public void v8qP8fE86HMhvNuYPFjqY(AsyncPlayerChatEvent asyncPlayerChatEvent) {
        Player player = asyncPlayerChatEvent.getPlayer();
        if (Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player)) {
            String message = asyncPlayerChatEvent.getMessage();
            asyncPlayerChatEvent.setCancelled(true);
            String strXtOheRiObl4QeAl = Clans.getClanCore().getColorManager().xtOheRiObl4QeAl(message);
            Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(player, () -> {
                Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player, strXtOheRiObl4QeAl);
            });
        }
    }

    public void execute(Listener listener, Event event) {
        if (listener == this && (event instanceof AsyncPlayerChatEvent)) {
            v8qP8fE86HMhvNuYPFjqY((AsyncPlayerChatEvent) event);
        }
    }
}
