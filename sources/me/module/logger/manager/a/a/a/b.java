package me.module.logger.manager.a.a.a;

import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.LoggerData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/a/b.class */
public class b {
    public static void a(LoggerData loggerData) {
        Logger.a().getLibAPI().getAsyncTaskExecutor().run(loggerData.getId(), () -> {
            if (Logger.getModuleCore().f().c().equals(ClanEnum.ClanStorage.YAML)) {
                me.module.logger.manager.a.a.b.b(loggerData);
            } else {
                me.module.logger.manager.a.a.b.a(loggerData);
            }
        });
    }
}
