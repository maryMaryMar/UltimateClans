package me.module.logger.manager.a.a.a;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import me.module.logger.Logger;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/a/c.class */
public class c {
    public static CompletableFuture<Void> a() {
        Logger.getModuleCore().e().getLoggerData().clear();
        return me.module.logger.manager.a.a.c.a().thenAcceptAsync(list -> {
            Logger.getModuleCore().b().info("Loaded " + list.size() + " logger(s).");
        }, (Executor) Logger.a().getLibAPI().getAsyncTaskExecutor().getExecutor()).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
