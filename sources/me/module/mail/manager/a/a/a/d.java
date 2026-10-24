package me.module.mail.manager.a.a.a;

import java.util.UUID;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/a/d.class */
public class d {
    public static void a(UUID uuid) {
        me.module.mail.manager.a.a.c.a(uuid).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
