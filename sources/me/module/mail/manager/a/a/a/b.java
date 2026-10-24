package me.module.mail.manager.a.a.a;

import java.util.UUID;
import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/a/b.class */
public class b {
    public static void a(UUID uuid) {
        Mail.a().getLibAPI().getAsyncTaskExecutor().run(uuid, () -> {
            if (Mail.getModuleCore().f().c().equals(ClanEnum.ClanStorage.YAML)) {
                me.module.mail.manager.a.a.b.b(uuid);
            } else {
                me.module.mail.manager.a.a.b.a(uuid);
            }
        });
    }
}
