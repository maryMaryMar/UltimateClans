package me.module.logger.manager.a.a.a;

import java.util.UUID;
import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/a/a.class */
public class a {
    public static void a(UUID uuid) {
        Logger.a().getLibAPI().getAsyncTaskExecutor().run(uuid, () -> {
            if (Logger.getModuleCore().f().c().equals(ClanEnum.ClanStorage.YAML)) {
                me.module.logger.manager.a.a.a.b(uuid);
            } else {
                me.module.logger.manager.a.a.a.a(uuid);
            }
        });
    }
}
