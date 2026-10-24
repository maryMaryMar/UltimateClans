package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 {
    public static void v8qP8fE86HMhvNuYPFjqY(ClanData clanData) {
        Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().run(clanData.getId(), () -> {
            switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
                case MYSQL:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.zTcC5XsAfoa1Tc1.ZwrsrwOCXRUscW6Q(clanData);
                    break;
                case SQLITE:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.zTcC5XsAfoa1Tc1.jBUuLP0sWwaPyPOmogdX7l(clanData);
                    break;
                case YAML:
                    me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.zTcC5XsAfoa1Tc1.v8qP8fE86HMhvNuYPFjqY(clanData);
                    break;
            }
        });
    }
}
