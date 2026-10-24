package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import me.ulrich.clans.Clans;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx {
    public static CompletableFuture<Void> v8qP8fE86HMhvNuYPFjqY() {
        Clans.getClanCore().getClanManager().CDW4Fj1iwdIXEOqWjiJSR().clear();
        return me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg.ZRp1tak21UvNaOVCtFx.v8qP8fE86HMhvNuYPFjqY().thenAcceptAsync(list -> {
            Clans.getClanCore().getLogger().info("Loaded " + list.size() + " clan(s).");
        }, (Executor) Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor()).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
