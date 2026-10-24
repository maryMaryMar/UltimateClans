package me.module.rivalally.b;

import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import me.module.rivalally.Rivalally;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.module.rivalally.manager.e;
import me.ulrich.clans.data.AllyInvite;
import me.ulrich.clans.data.ClanData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/b/a.class */
public class a implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        try {
            Iterator<Map.Entry<ClanData, AllyInvite>> it = e.b().entrySet().iterator();
            if (it != null) {
                it.forEachRemaining(entry -> {
                    if (entry == null || jCurrentTimeMillis <= ((AllyInvite) entry.getValue()).getExpires().longValue()) {
                        return;
                    }
                    Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(((AllyInvite) entry.getValue()).getClanReceiver());
                    Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(((AllyInvite) entry.getValue()).getClanSender());
                    if (clan.isPresent()) {
                        e.a(clan.get(), Lang.CLAN_ALLY_INVITE_EXPIRED);
                    }
                    if (clan2.isPresent()) {
                        e.a(clan2.get(), Lang.CLAN_ALLY_INVITE_EXPIRED);
                    }
                    it.remove();
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
