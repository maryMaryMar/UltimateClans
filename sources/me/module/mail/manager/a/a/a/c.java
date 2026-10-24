package me.module.mail.manager.a.a.a;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import me.module.mail.Mail;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/a/c.class */
public class c {
    public static CompletableFuture<Void> a() {
        Mail.getModuleCore().e().getMailData().clear();
        return me.module.mail.manager.a.a.c.a().thenAcceptAsync(list -> {
            Mail.getModuleCore().b().info("Loaded " + list.size() + " mail(s).");
        }, (Executor) Mail.a().getLibAPI().getAsyncTaskExecutor().getExecutor()).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
