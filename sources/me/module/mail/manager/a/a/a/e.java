package me.module.mail.manager.a.a.a;

import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.MailData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/a/e.class */
public class e {
    public static void a(MailData mailData) {
        if (Mail.getModuleCore().f().c().equals(ClanEnum.ClanStorage.SQLITE)) {
            me.module.mail.manager.a.a.d.a(mailData);
        } else if (Mail.getModuleCore().f().c().equals(ClanEnum.ClanStorage.MYSQL)) {
            me.module.mail.manager.a.a.d.b(mailData);
        } else if (Mail.getModuleCore().f().c().equals(ClanEnum.ClanStorage.YAML)) {
            me.module.mail.manager.a.a.d.c(mailData);
        }
    }
}
