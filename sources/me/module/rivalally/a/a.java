package me.module.rivalally.a;

import java.util.Optional;
import me.module.rivalally.Rivalally;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.events.ClanAllyAddEvent;
import me.ulrich.clans.events.ClanAllyRemoveEvent;
import me.ulrich.clans.events.ClanMessageEvent;
import me.ulrich.clans.events.ClanRivalAddEvent;
import me.ulrich.clans.events.ClanRivalRemoveEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/a/a.class */
public class a implements Listener {
    public a() {
        Rivalally.getModuleCore().f().add(this);
    }

    @EventHandler
    public void a(ClanAllyRemoveEvent clanAllyRemoveEvent) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(clanAllyRemoveEvent.getClan1());
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(clanAllyRemoveEvent.getClan2());
        if (clan.isPresent()) {
            String string = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_REMOVED_ALLY);
            if (!string.isEmpty() && clan2.isPresent()) {
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan2.get().getLeader(), string), false, true, false, clan2.get().getId()));
            }
        }
        if (clan2.isPresent()) {
            String string2 = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_REMOVED_ALLY);
            if (string2.isEmpty() || !clan.isPresent()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan.get().getLeader(), string2), false, true, false, clan2.get().getId()));
        }
    }

    @EventHandler
    public void a(ClanAllyAddEvent clanAllyAddEvent) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(clanAllyAddEvent.getClan1());
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(clanAllyAddEvent.getClan2());
        if (clan.isPresent()) {
            String string = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_NEW_ALLY);
            if (!string.isEmpty() && clan2.isPresent()) {
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan2.get().getLeader(), string), false, true, false, clan.get().getId()));
            }
        }
        if (clan2.isPresent()) {
            String string2 = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_NEW_ALLY);
            if (string2.isEmpty() || !clan.isPresent()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan.get().getLeader(), string2), false, true, false, clan2.get().getId()));
        }
    }

    @EventHandler
    public void a(ClanRivalAddEvent clanRivalAddEvent) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(clanRivalAddEvent.getClan1());
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(clanRivalAddEvent.getClan2());
        if (clan.isPresent()) {
            String string = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_NEW_RIVAL);
            if (!string.isEmpty() && clan2.isPresent()) {
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan2.get().getLeader(), string), false, true, false, clan.get().getId()));
            }
        }
        if (clan2.isPresent()) {
            String string2 = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_NEW_RIVAL);
            if (string2.isEmpty() || !clan.isPresent()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan.get().getLeader(), string2), false, true, false, clan2.get().getId()));
        }
    }

    @EventHandler
    public void a(ClanRivalRemoveEvent clanRivalRemoveEvent) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(clanRivalRemoveEvent.getClan1());
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(clanRivalRemoveEvent.getClan2());
        if (clan.isPresent()) {
            String string = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_NEW_RIVAL_REMOVED);
            if (!string.isEmpty() && clan2.isPresent()) {
                Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan2.get().getLeader(), string), false, true, false, clan.get().getId()));
            }
        }
        if (clan2.isPresent()) {
            String string2 = Rivalally.getModuleCore().c().c().getString(Lang.CLAN_NEW_RIVAL_REMOVED);
            if (string2.isEmpty() || !clan.isPresent()) {
                return;
            }
            Bukkit.getPluginManager().callEvent(new ClanMessageEvent(Rivalally.a().getClanAPI().parseText(clan.get().getLeader(), string2), false, true, false, clan2.get().getId()));
        }
    }
}
