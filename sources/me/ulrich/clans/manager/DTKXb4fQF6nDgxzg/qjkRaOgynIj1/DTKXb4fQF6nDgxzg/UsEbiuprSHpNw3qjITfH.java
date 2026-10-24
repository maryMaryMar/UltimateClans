package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.DTKXb4fQF6nDgxzg;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/qjkRaOgynIj1/DTKXb4fQF6nDgxzg/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH {
    public static CompletableFuture<Void> v8qP8fE86HMhvNuYPFjqY() {
        Clans.getClanCore().getModerationManager().CDW4Fj1iwdIXEOqWjiJSR().clear();
        return me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY().thenAcceptAsync(map -> {
            Clans.getClanCore().getLogger().info("Loaded " + map.size() + " moderation(s).");
        }, (Executor) Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor()).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
