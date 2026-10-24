package me.module.logger.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Optional;
import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.LoggerData;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/d.class */
public class d {
    private static byte[] __aes_key_R30jByHj = {(byte) 133, (byte) 93, (byte) 86, (byte) 137, (byte) 1, (byte) 189, (byte) 183, (byte) 56, (byte) 168, (byte) 247, (byte) 14, (byte) 86, (byte) 169, (byte) 181, (byte) 178, (byte) 7, (byte) 15, (byte) 231, (byte) 17, (byte) 197, (byte) 181, (byte) 22, (byte) 14, (byte) 25, (byte) 176, (byte) 187, (byte) 62, (byte) 206, (byte) 50, (byte) 206, (byte) 200, (byte) 240};
    private static byte[] __aes_iv_HMAc9nKL = {(byte) 3, (byte) 72, (byte) 6, (byte) 29, (byte) 25, (byte) 1, (byte) 45, (byte) 220, (byte) 194, (byte) 83, (byte) 200, (byte) 114, (byte) 27, (byte) 145, (byte) 49, (byte) 18};
    private static String __s_cache_5qMqSCb1_0;
    private static String __s_cache_y1ZuTZyA_1;
    private static String __s_cache_WNkajpix_2;
    private static String __s_cache_Fha5F1Tx_3;
    private static String __s_cache_NtkxTQPa_4;

    public static void a(LoggerData loggerData) {
        String str = "INSERT OR REPLACE INTO `" + Logger.getModuleCore().c().i().getString("Storage.databases.logger_table") + "` (`id`, `clan_id`, `text`, `plugin`, `date`, `material`) VALUES (" + String.join(",", Collections.nCopies(6, "?")) + ")";
        try {
            Connection connectionC = Logger.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, loggerData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, loggerData.getClan_id().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, loggerData.getText());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, loggerData.getPlugin());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setLong(i4, loggerData.getDate());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setString(i5, loggerData.getMaterial().name());
                    preparedStatementPrepareStatement.execute();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
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

    public static void b(LoggerData loggerData) {
        String str = "INSERT INTO `" + Logger.getModuleCore().c().i().getString("Storage.databases.logger_table") + "` (`id`, `clan_id`, `text`, `plugin`, `date`, `material`) VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE `id`=?, `clan_id`=?, `text`=?, `plugin`=?, `date`=?, `material`=?";
        try {
            Connection connectionC = Logger.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, loggerData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, loggerData.getClan_id().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, loggerData.getText());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, loggerData.getPlugin());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setLong(i4, loggerData.getDate());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setString(i5, loggerData.getMaterial().name());
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, loggerData.getId().toString());
                    int i8 = i7 + 1;
                    preparedStatementPrepareStatement.setString(i7, loggerData.getClan_id().toString());
                    int i9 = i8 + 1;
                    preparedStatementPrepareStatement.setString(i8, loggerData.getText());
                    int i10 = i9 + 1;
                    preparedStatementPrepareStatement.setString(i9, loggerData.getPlugin());
                    int i11 = i10 + 1;
                    preparedStatementPrepareStatement.setLong(i10, loggerData.getDate());
                    int i12 = i11 + 1;
                    preparedStatementPrepareStatement.setString(i11, loggerData.getMaterial().name());
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Logger.getModuleCore().d().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANLOGGER.toString(), loggerData.getClan_id(), Optional.empty()));
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

    public static void c(LoggerData loggerData) {
        try {
            FileConfiguration fileConfigurationK = Logger.getModuleCore().c().k();
            String str = "data." + String.valueOf(loggerData.getId());
            fileConfigurationK.set(str + ".clan_id", loggerData.getClan_id().toString());
            fileConfigurationK.set(str + ".text", loggerData.getText());
            fileConfigurationK.set(str + ".plugin", loggerData.getPlugin());
            fileConfigurationK.set(str + ".date", Long.valueOf(loggerData.getDate()));
            fileConfigurationK.set(str + ".material", loggerData.getMaterial().name());
            Logger.getModuleCore().c().h().get("logger").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_270() {
        return "Storage.databases.logger_table";
    }

    private static String __unused_271() {
        return ",";
    }

    private static String __unused_272() {
        return "?";
    }

    private static String __unused_273() {
        return "Storage.databases.logger_table";
    }

    private static String __unused_274() {
        return "logger";
    }
}
