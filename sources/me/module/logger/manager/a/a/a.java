package me.module.logger.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/a.class */
public class a {
    private static byte[] __aes_key_wyo3kMyj = {(byte) 160, (byte) 11, (byte) 159, (byte) 53, (byte) 173, (byte) 116, (byte) 211, (byte) 227, (byte) 237, (byte) 220, (byte) 97, (byte) 118, (byte) 76, (byte) 175, (byte) 6, (byte) 55, (byte) 219, (byte) 33, (byte) 169, (byte) 109, (byte) 212, (byte) 20, (byte) 130, (byte) 166, (byte) 244, (byte) 164, (byte) 151, (byte) 155, (byte) 126, (byte) 42, (byte) 170, (byte) 171};
    private static byte[] __aes_iv_ePtGwYkA = {(byte) 227, (byte) 19, (byte) 118, (byte) 152, (byte) 17, (byte) 123, (byte) 95, (byte) 139, (byte) 128, (byte) 90, (byte) 111, (byte) 154, (byte) 250, (byte) 146, (byte) 138, (byte) 238};
    private static String __s_cache_dw2V5yBv_0;
    private static String __s_cache_conmpAUT_1;
    private static String __s_cache_rgI4PAGv_2;

    public static void a(UUID uuid) {
        String string = Logger.getModuleCore().c().i().getString("Storage.databases.logger_table");
        try {
            Connection connectionC = Logger.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement("DELETE FROM `" + string + "` WHERE `clan_id` = '" + uuid.toString() + "'");
                try {
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Logger.getModuleCore().d().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANLOGGER.toString(), uuid, Optional.empty()));
                        });
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionC != null) {
                    try {
                        connectionC.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void b(UUID uuid) {
        Set<String> keys;
        try {
            ConfigurationSection configurationSection = Logger.getModuleCore().c().k().getConfigurationSection("data");
            if (configurationSection != null && (keys = configurationSection.getKeys(false)) != null) {
                for (String str : keys) {
                    if (UUID.fromString(Logger.getModuleCore().c().k().getString("data." + str + ".clan_id")).equals(uuid)) {
                        Logger.getModuleCore().c().k().set("data." + str.toString(), (Object) null);
                    }
                }
            }
            Logger.getModuleCore().c().h().get("logger").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_265() {
        return "Storage.databases.logger_table";
    }

    private static String __unused_266() {
        return "data";
    }

    private static String __unused_267() {
        return "logger";
    }
}
