package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg;

import java.util.HashMap;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/qjkRaOgynIj1/DTKXb4fQF6nDgxzg/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid, HashMap<String, HashMap<String, Boolean>> map) {
        Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().run(uuid, () -> {
            if (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q().equals(ClanEnum.ClanStorage.SQLITE)) {
                me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(uuid, map);
            } else if (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q().equals(ClanEnum.ClanStorage.MYSQL)) {
                me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.RuVgd0Dnv0ddhdcWL.jBUuLP0sWwaPyPOmogdX7l(uuid, map);
            } else if (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q().equals(ClanEnum.ClanStorage.YAML)) {
                me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.RuVgd0Dnv0ddhdcWL.ZwrsrwOCXRUscW6Q(uuid, map);
            }
        });
    }
}
