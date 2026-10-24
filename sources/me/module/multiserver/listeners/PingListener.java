package me.module.multiserver.listeners;

import me.module.multiserver.Multiserver;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Multiserver.jar:me/module/multiserver/listeners/PingListener.class */
public class PingListener implements Listener {
    public PingListener() {
        Multiserver.getModuleCore().f().add(this);
    }

    @EventHandler
    public void onClanMultiserverPingEvent(ClanMultiserverPingEvent clanMultiserverPingEvent) {
        if (!clanMultiserverPingEvent.isCancelled() && Multiserver.getModuleCore().e().syncEnabled()) {
            Multiserver.getModuleCore().e().sendSync(clanMultiserverPingEvent.getType(), clanMultiserverPingEvent.getUuid());
        }
    }
}
