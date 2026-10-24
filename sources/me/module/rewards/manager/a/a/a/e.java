package me.module.rewards.manager.a.a.a;

import me.module.rewards.Rewards;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.RewardsData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a/a/a/e.class */
public class e {
    public static void a(RewardsData rewardsData) {
        Rewards.a().getLibAPI().getAsyncTaskExecutor().run(rewardsData.getId(), () -> {
            if (Rewards.getModuleCore().j().c().equals(ClanEnum.ClanStorage.SQLITE)) {
                me.module.rewards.manager.a.a.d.a(rewardsData);
            } else if (Rewards.getModuleCore().j().c().equals(ClanEnum.ClanStorage.MYSQL)) {
                me.module.rewards.manager.a.a.d.b(rewardsData);
            } else if (Rewards.getModuleCore().j().c().equals(ClanEnum.ClanStorage.YAML)) {
                me.module.rewards.manager.a.a.d.c(rewardsData);
            }
        });
    }
}
