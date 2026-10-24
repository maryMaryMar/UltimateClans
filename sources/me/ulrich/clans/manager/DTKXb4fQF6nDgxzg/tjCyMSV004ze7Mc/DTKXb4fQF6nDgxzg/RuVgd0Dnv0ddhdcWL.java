package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg;

import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.InviteData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/DTKXb4fQF6nDgxzg/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    public static void v8qP8fE86HMhvNuYPFjqY(InviteData inviteData) {
        Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().run(inviteData.getId(), () -> {
            if (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q().equals(ClanEnum.ClanStorage.SQLITE)) {
                me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY(inviteData);
            } else if (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q().equals(ClanEnum.ClanStorage.MYSQL)) {
                me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.RuVgd0Dnv0ddhdcWL.jBUuLP0sWwaPyPOmogdX7l(inviteData);
            } else if (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q().equals(ClanEnum.ClanStorage.YAML)) {
                me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.RuVgd0Dnv0ddhdcWL.ZwrsrwOCXRUscW6Q(inviteData);
            }
        });
    }
}
