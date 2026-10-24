package me.module.logger.b;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import me.module.logger.Logger;
import me.ulrich.clans.data.LoggerData;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/b/a.class */
public class a implements Runnable {
    private static byte[] __aes_key_q7yIj3HJ = {(byte) 99, (byte) 184, (byte) 217, (byte) 242, (byte) 193, (byte) 236, (byte) 224, (byte) 122, (byte) 192, (byte) 126, (byte) 48, (byte) 209, (byte) 120, (byte) 62, (byte) 143, (byte) 159, (byte) 198, (byte) 90, (byte) 162, (byte) 182, (byte) 220, (byte) 78, (byte) 249, (byte) 36, (byte) 37, (byte) 164, (byte) 11, (byte) 33, (byte) 206, (byte) 16, (byte) 131, (byte) 177};
    private static byte[] __aes_iv_gcFRW7a1 = {(byte) 87, (byte) 170, (byte) 56, (byte) 238, (byte) 20, (byte) 128, (byte) 159, (byte) 71, (byte) 152, (byte) 231, (byte) 62, (byte) 69, (byte) 185, (byte) 79, (byte) 88, (byte) 254};
    private static String __s_cache_e9BXkHe4_0;
    private static String __s_cache_T0tiqp3j_1;

    @Override // java.lang.Runnable
    public void run() {
        if (Logger.getModuleCore().c().i().getBoolean("Config.Logger.enabled")) {
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator<Map.Entry<UUID, List<LoggerData>>> it = Logger.getModuleCore().e().getLoggerData().entrySet().iterator();
            while (it.hasNext()) {
                Iterator<LoggerData> it2 = it.next().getValue().iterator();
                while (it2.hasNext()) {
                    LoggerData next = it2.next();
                    if (jCurrentTimeMillis > next.getDate() + ((long) (60 * Logger.getModuleCore().c().i().getInt("Config.Logger.time_expires")))) {
                        it2.remove();
                        Logger.getModuleCore().e().DeleteLoggerData(next);
                    }
                }
            }
        }
    }

    private static String __unused_156() {
        return "Config.Logger.enabled";
    }

    private static String __unused_157() {
        return "Config.Logger.time_expires";
    }
}
