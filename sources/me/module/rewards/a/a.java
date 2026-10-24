package me.module.rewards.a;

import me.module.rewards.Rewards;
import me.ulrich.clans.events.ClanDeleteEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/a/a.class */
public class a implements Listener {
    public a() {
        Rewards.getModuleCore().e().add(this);
    }

    @EventHandler
    public void a(ClanDeleteEvent clanDeleteEvent) {
        Rewards.getModuleCore().i().ClearRewardsData(clanDeleteEvent.getClanID());
    }
}
