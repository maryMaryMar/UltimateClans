package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg;

import java.util.UUID;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/kSFM3X0M9q2n7XFSS/DTKXb4fQF6nDgxzg/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        if (Clans.getClanCore().getPlayerManager().xtOheRiObl4QeAl().containsKey(uuid)) {
            Clans.getClanCore().getPlayerManager().xtOheRiObl4QeAl().remove(uuid);
        }
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY(uuid).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
