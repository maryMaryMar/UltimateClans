package me.module.logger.manager.a.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.module.logger.Logger;
import me.ulrich.clans.data.LoggerData;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/c.class */
public class c {
    private static byte[] __aes_key_lweK9A1B = {(byte) 14, (byte) 133, (byte) 119, (byte) 128, (byte) 18, (byte) 153, (byte) 225, (byte) 93, (byte) 177, (byte) 116, (byte) 75, (byte) 140, (byte) 5, (byte) 86, (byte) 209, (byte) 45, (byte) 109, (byte) 122, (byte) 205, (byte) 162, (byte) 117, (byte) 12, (byte) 40, (byte) 167, (byte) 100, (byte) 193, (byte) 203, (byte) 73, (byte) 83, (byte) 174, (byte) 79, (byte) 140};
    private static byte[] __aes_iv_9eW2AZvL = {(byte) 230, (byte) 116, (byte) 68, (byte) 226, (byte) 64, (byte) 92, (byte) 16, (byte) 9, (byte) 85, (byte) 79, (byte) 87, (byte) 255, (byte) 226, (byte) 156, (byte) 180, (byte) 253};
    private static String __s_cache_j6CqmwoY_0;
    private static String __s_cache_k8YmdPc6_1;
    private static String __s_cache_VuNe8C0x_2;
    private static String __s_cache_gTgBmVI0_3;
    private static String __s_cache_oLXXJkrF_4;
    private static String __s_cache_mF8zjh7V_5;
    private static String __s_cache_YLId7WaV_6;
    private static String __s_cache_0sWTesO8_7;
    private static String __s_cache_BLCDqSV8_8;
    private static String __s_cache_jkIH2pAx_9;
    private static String __s_cache_ta4yNcjD_10;
    private static String __s_cache_drqp9Oud_11;

    public static CompletableFuture<List<LoggerData>> a(UUID uuid) {
        switch (Logger.getModuleCore().f().c()) {
            case YAML:
                return b(uuid);
            case MYSQL:
            case SQLITE:
                return a("SELECT * FROM `" + Logger.getModuleCore().c().i().getString("Storage.databases.logger_table") + "` WHERE `id` = '" + String.valueOf(uuid) + "' LIMIT 1");
            default:
                return CompletableFuture.completedFuture(new ArrayList());
        }
    }

    public static CompletableFuture<List<LoggerData>> a() {
        switch (Logger.getModuleCore().f().c()) {
            case YAML:
                return b();
            case MYSQL:
            case SQLITE:
                return a("SELECT * FROM `" + Logger.getModuleCore().c().i().getString("Storage.databases.logger_table") + "`");
            default:
                return CompletableFuture.completedFuture(new ArrayList());
        }
    }

    private static CompletableFuture<List<LoggerData>> b(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList arrayList = new ArrayList();
            LoggerData loggerDataA = a(uuid, System.currentTimeMillis() / 1000);
            if (loggerDataA != null) {
                a(loggerDataA);
                arrayList.add(loggerDataA);
            }
            return arrayList;
        }, Logger.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static CompletableFuture<List<LoggerData>> b() {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList arrayList = new ArrayList();
            ConfigurationSection configurationSection = Logger.getModuleCore().c().k().getConfigurationSection("data");
            if (configurationSection == null) {
                return arrayList;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            Iterator it = configurationSection.getKeys(false).iterator();
            while (it.hasNext()) {
                try {
                    LoggerData loggerDataA = a(UUID.fromString((String) it.next()), jCurrentTimeMillis);
                    if (loggerDataA != null) {
                        a(loggerDataA);
                        arrayList.add(loggerDataA);
                    }
                } catch (Exception e) {
                }
            }
            return arrayList;
        }, Logger.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static LoggerData a(UUID uuid, long j) {
        try {
            UUID uuidFromString = UUID.fromString(Logger.getModuleCore().c().k().getString("data." + String.valueOf(uuid) + ".clan_id"));
            Material materialValueOf = Material.valueOf(Logger.getModuleCore().c().i().getString("Config.Logger.plugin_material"));
            try {
                String string = Logger.getModuleCore().c().k().getString("data." + String.valueOf(uuid) + ".material");
                if (string != null) {
                    materialValueOf = Material.valueOf(string);
                }
            } catch (Exception e) {
            }
            LoggerData loggerData = new LoggerData(uuid, uuidFromString, Logger.getModuleCore().c().k().getString("data." + String.valueOf(uuid) + ".text"), Logger.getModuleCore().c().k().getLong("data." + String.valueOf(uuid) + ".date"), Logger.getModuleCore().c().k().getString("data." + String.valueOf(uuid) + ".plugin"), materialValueOf);
            if (a(loggerData, j)) {
                return null;
            }
            return loggerData;
        } catch (Exception e2) {
            return null;
        }
    }

    private static CompletableFuture<List<LoggerData>> a(String str) {
        CompletableFuture<List<LoggerData>> completableFuture = new CompletableFuture<>();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Logger.getModuleCore().f().b(resultSet -> {
            ArrayList arrayList = new ArrayList();
            while (resultSet.next()) {
                try {
                    UUID uuidFromString = UUID.fromString(resultSet.getString("id"));
                    UUID uuidFromString2 = UUID.fromString(resultSet.getString("clan_id"));
                    Material materialValueOf = Material.valueOf(Logger.getModuleCore().c().i().getString("Config.Logger.plugin_material"));
                    try {
                        String string = resultSet.getString("material");
                        if (string != null) {
                            materialValueOf = Material.valueOf(string);
                        }
                    } catch (Exception e) {
                    }
                    LoggerData loggerData = new LoggerData(uuidFromString, uuidFromString2, resultSet.getString("text"), resultSet.getLong("date"), resultSet.getString("plugin"), materialValueOf);
                    if (!a(loggerData, jCurrentTimeMillis)) {
                        a(loggerData);
                        arrayList.add(loggerData);
                    }
                } catch (Exception e2) {
                    completableFuture.completeExceptionally(e2);
                    return;
                }
            }
            completableFuture.complete(arrayList);
        }, str);
        return completableFuture;
    }

    private static void a(LoggerData loggerData) {
        Logger.getModuleCore().e().getLoggerData().computeIfAbsent(loggerData.getClan_id(), uuid -> {
            return new ArrayList();
        }).add(loggerData);
    }

    private static boolean a(LoggerData loggerData, long j) {
        return j >= loggerData.getDate() + ((long) (60 * Logger.getModuleCore().c().i().getInt("Config.Logger.time_expires")));
    }

    private static String __unused_253() {
        return "Storage.databases.logger_table";
    }

    private static String __unused_254() {
        return "Storage.databases.logger_table";
    }

    private static String __unused_255() {
        return "Config.Logger.plugin_material";
    }

    private static String __unused_256() {
        return "Config.Logger.time_expires";
    }

    private static String __unused_257() {
        return "id";
    }

    private static String __unused_258() {
        return "clan_id";
    }

    private static String __unused_259() {
        return "Config.Logger.plugin_material";
    }

    private static String __unused_260() {
        return "material";
    }

    private static String __unused_261() {
        return "text";
    }

    private static String __unused_262() {
        return "date";
    }

    private static String __unused_263() {
        return "plugin";
    }

    private static String __unused_264() {
        return "data";
    }
}
