package me.module.rivalally.b;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import me.module.rivalally.Rivalally;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.module.rivalally.manager.e;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.RivalRemove;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/b/b.class */
public class b implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            Iterator<Map.Entry<ClanData, RivalRemove>> it = e.a().entrySet().iterator();
            if (it != null) {
                it.forEachRemaining(entry -> {
                    if (entry == null || jCurrentTimeMillis <= ((RivalRemove) entry.getValue()).getExpires()) {
                        return;
                    }
                    Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(((RivalRemove) entry.getValue()).getClanReceiver());
                    Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(((RivalRemove) entry.getValue()).getClanSender());
                    if (clan.isPresent()) {
                        e.a(clan.get(), Lang.CLAN_RIVAL_REMOVE_EXPIRED);
                    }
                    if (clan2.isPresent()) {
                        e.a(clan2.get(), Lang.CLAN_RIVAL_REMOVE_EXPIRED);
                    }
                    it.remove();
                });
            }
        } catch (Exception e) {
        }
    }
}
