package me.module.multiserver.listeners;

import me.module.multiserver.Multiserver;
import me.module.multiserver.manager.b;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/listeners/SyncListener.class */
public class SyncListener implements Listener {
    public SyncListener() {
        Multiserver.getModuleCore().f().add(this);
    }

    public void onPlayerJoin(PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();
        Multiserver.getModuleCore().d().runTaskLater(() -> {
            b.a(player);
        }, 40L);
    }
}
