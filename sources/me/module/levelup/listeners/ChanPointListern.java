package me.module.levelup.listeners;

import java.util.Optional;
import me.module.levelup.Levelup;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.events.ClanPointChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/listeners/ChanPointListern.class */
public class ChanPointListern implements Listener {
    public ChanPointListern() {
        Levelup.getModuleCore().f().add(this);
    }

    @EventHandler
    public void onClanPointChangeEvent(ClanPointChangeEvent clanPointChangeEvent) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(clanPointChangeEvent.getClanID());
        if (clan.isPresent()) {
            Levelup.getModuleCore().e().checkDowngradeLevel(clan.get().getId());
        }
    }
}
