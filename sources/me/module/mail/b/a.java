package me.module.mail.b;

import java.util.Optional;
import me.module.mail.Mail;
import me.module.mail.events.ClanMailSendEvent;
import me.module.mail.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.events.ClanDeleteEvent;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/b/a.class */
public class a implements Listener {
    public a() {
        Mail.getModuleCore().g().add(this);
    }

    @EventHandler
    public void a(ClanMailSendEvent clanMailSendEvent) {
        Optional<ClanData> clan = Mail.a().getClanAPI().getClan(clanMailSendEvent.getData().getTo());
        if (clan.isPresent()) {
            MessageUtils.clanMessageSend(clan.get(), Mail.getModuleCore().c().d().getString(Lang.MAIL_NEW_RECEIVED));
        }
    }

    @EventHandler
    public void a(ClanDeleteEvent clanDeleteEvent) {
        Mail.getModuleCore().e().clearClanMail(clanDeleteEvent.getClanID());
    }
}
