package me.module.logger.manager.a.a.a;

import java.util.UUID;
import me.module.logger.Logger;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/a/d.class */
public class d {
    public static void a(UUID uuid) {
        if (Logger.getModuleCore().e().getLoggerData().containsKey(uuid)) {
            Logger.getModuleCore().e().getLoggerData().remove(uuid);
        }
        me.module.logger.manager.a.a.c.a(uuid).exceptionally(th -> {
            th.printStackTrace();
            return null;
        });
    }
}
