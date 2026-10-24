package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.Executor;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid, boolean z) {
        if (Clans.getClanCore().getClanManager().CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid)) {
            Clans.getClanCore().getClanManager().CDW4Fj1iwdIXEOqWjiJSR().remove(uuid);
        }
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY(uuid).thenAcceptAsync(optional -> {
            if (optional.isPresent()) {
                ClanData clanData = (ClanData) optional.get();
                if (z) {
                    Iterator<UUID> it = clanData.getMembers().iterator();
                    while (it.hasNext()) {
                        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(it.next());
                    }
                }
            }
        }, (Executor) Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor()).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
