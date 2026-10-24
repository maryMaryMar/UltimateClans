package me.module.rewards.manager.a.a.a;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import me.module.rewards.Rewards;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a/a/a/c.class */
public class c {
    public static CompletableFuture<Void> a() {
        Rewards.getModuleCore().i().getRewardsData().clear();
        return me.module.rewards.manager.a.a.c.a().thenAcceptAsync(map -> {
            Rewards.getModuleCore().b().info("Loaded " + map.size() + " reward(s).");
        }, (Executor) Rewards.a().getLibAPI().getAsyncTaskExecutor().getExecutor()).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
