package me.module.rewards.manager.a.a.a;

import java.util.UUID;
import me.module.rewards.Rewards;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a/a/a/a.class */
public class a {
    public static void a(UUID uuid) {
        Rewards.a().getLibAPI().getAsyncTaskExecutor().run(uuid, () -> {
            if (Rewards.getModuleCore().j().c().equals(ClanEnum.ClanStorage.YAML)) {
                me.module.rewards.manager.a.a.a.b(uuid);
            } else {
                me.module.rewards.manager.a.a.a.a(uuid);
            }
        });
    }
}
