package me.module.logger.manager.a.a.a;

import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.LoggerData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/a/e.class */
public class e {
    public static void a(LoggerData loggerData) {
        Logger.a().getLibAPI().getAsyncTaskExecutor().run(loggerData.getId(), () -> {
            if (Logger.getModuleCore().f().c().equals(ClanEnum.ClanStorage.SQLITE)) {
                me.module.logger.manager.a.a.d.a(loggerData);
            } else if (Logger.getModuleCore().f().c().equals(ClanEnum.ClanStorage.MYSQL)) {
                me.module.logger.manager.a.a.d.b(loggerData);
            } else if (Logger.getModuleCore().f().c().equals(ClanEnum.ClanStorage.YAML)) {
                me.module.logger.manager.a.a.d.c(loggerData);
            }
        });
    }
}
