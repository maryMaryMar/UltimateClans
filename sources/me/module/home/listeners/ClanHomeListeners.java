package me.module.home.listeners;

import java.util.Optional;
import me.module.home.Home;
import me.module.home.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.events.ClanHomeCreateEvent;
import me.ulrich.clans.events.ClanHomeDeleteEvent;
import me.ulrich.clans.events.ClanMessageEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/listeners/ClanHomeListeners.class */
public class ClanHomeListeners implements Listener {
    private static byte[] __aes_key_dzSwyhb9 = {(byte) 63, (byte) 12, (byte) 102, (byte) 122, (byte) 216, (byte) 39, (byte) 15, (byte) 119, (byte) 89, (byte) 249, (byte) 145, (byte) 66, (byte) 26, (byte) 149, (byte) 244, (byte) 169, (byte) 188, (byte) 51, (byte) 157, (byte) 22, (byte) 248, (byte) 215, (byte) 89, (byte) 208, (byte) 9, (byte) 83, (byte) 67, (byte) 68, (byte) 94, (byte) 153, (byte) 101, (byte) 112};
    private static byte[] __aes_iv_O60BkRtG = {(byte) 59, (byte) 40, (byte) 181, (byte) 250, (byte) 37, (byte) 124, (byte) 75, (byte) 189, (byte) 220, (byte) 121, (byte) 253, (byte) 61, (byte) 84, (byte) 249, (byte) 111, (byte) 173};
    private static String __s_cache_Rai0v1nt_0;
    private static String __s_cache_fXqte3Y5_1;

    public ClanHomeListeners() {
        Home.getModuleCore().f().add(this);
    }

    @EventHandler
    public void ClanHomeDeleteEvent(ClanHomeDeleteEvent clanHomeDeleteEvent) {
        Optional<ClanData> clan = Home.a().getClanAPI().getClan(clanHomeDeleteEvent.getClanID());
        if (clan.isPresent()) {
            String string = Home.getModuleCore().c().c().getString(Lang.HOME_DELETE_SUCCESS);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Home.getModuleCore().e().parseText(clan.get().getLeader(), Home.a().getClanAPI().parseText(clan.get().getLeader(), string)).replace("{deleted_home}", clanHomeDeleteEvent.getHomeName()), false, true, false, clan.get().getId()));
        }
    }

    @EventHandler
    public void ClanHomeCreateEvent(ClanHomeCreateEvent clanHomeCreateEvent) {
        Optional<ClanData> clan = Home.a().getClanAPI().getClan(clanHomeCreateEvent.getClanID());
        if (clan.isPresent()) {
            String string = Home.getModuleCore().c().c().getString(Lang.HOME_NEW_CREATE);
            if (string.isEmpty()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Home.getModuleCore().e().parseText(clan.get().getLeader(), Home.a().getClanAPI().parseText(clan.get().getLeader(), string.replace("{name}", "{" + clanHomeCreateEvent.getHomeName() + "}"))), false, true, false, clan.get().getId()));
        }
    }

    private static String __unused_427() {
        return "{deleted_home}";
    }

    private static String __unused_428() {
        return "{name}";
    }
}
