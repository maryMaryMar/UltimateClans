package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg;

import java.util.UUID;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/qjkRaOgynIj1/DTKXb4fQF6nDgxzg/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx {
    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        if (Clans.getClanCore().getModerationManager().CDW4Fj1iwdIXEOqWjiJSR().containsKey(uuid)) {
            Clans.getClanCore().getModerationManager().CDW4Fj1iwdIXEOqWjiJSR().remove(uuid);
        }
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY(uuid).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
