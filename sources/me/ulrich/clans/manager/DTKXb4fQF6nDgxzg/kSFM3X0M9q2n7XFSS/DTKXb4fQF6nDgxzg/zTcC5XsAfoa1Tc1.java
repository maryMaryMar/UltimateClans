package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.DTKXb4fQF6nDgxzg;

import me.ulrich.clans.Clans;
import me.ulrich.clans.data.PlayerData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/kSFM3X0M9q2n7XFSS/DTKXb4fQF6nDgxzg/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 {
    public static void v8qP8fE86HMhvNuYPFjqY(PlayerData playerData) {
        Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().run(playerData.getUuid(), () -> {
            switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
                case MYSQL:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.RuVgd0Dnv0ddhdcWL.jBUuLP0sWwaPyPOmogdX7l(playerData);
                    break;
                case SQLITE:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(playerData);
                    break;
                case YAML:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS.RuVgd0Dnv0ddhdcWL.ZwrsrwOCXRUscW6Q(playerData);
                    break;
            }
        });
    }
}
