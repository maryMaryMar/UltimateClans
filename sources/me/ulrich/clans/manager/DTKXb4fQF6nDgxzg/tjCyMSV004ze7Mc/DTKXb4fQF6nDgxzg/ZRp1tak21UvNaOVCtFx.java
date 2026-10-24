package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg;

import java.util.UUID;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/DTKXb4fQF6nDgxzg/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx {
    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        Clans clanCore = Clans.getClanCore();
        if (clanCore.getPlayerInviteManager().ZwrsrwOCXRUscW6Q().containsKey(uuid)) {
            clanCore.getPlayerInviteManager().ZwrsrwOCXRUscW6Q().remove(uuid);
        }
        me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY(uuid).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
