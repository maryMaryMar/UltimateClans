package me.module.logger.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import me.module.logger.Logger;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.LoggerData;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/a/a/b.class */
public class b {
    private static byte[] __aes_key_0iA4Wrl7 = {(byte) 137, (byte) 126, (byte) 80, (byte) 44, (byte) 127, (byte) 173, (byte) 90, (byte) 193, (byte) 105, (byte) 159, (byte) 121, (byte) 89, (byte) 8, (byte) 106, (byte) 159, (byte) 110, (byte) 77, (byte) 177, (byte) 8, (byte) 14, (byte) 178, (byte) 27, (byte) 152, (byte) 229, (byte) 147, (byte) 29, (byte) 234, (byte) 148, (byte) 197, (byte) 32, (byte) 91, (byte) 7};
    private static byte[] __aes_iv_aR1vuXsw = {(byte) 34, (byte) 100, (byte) 173, (byte) 189, (byte) 206, (byte) 116, (byte) 100, (byte) 95, (byte) 236, (byte) 140, (byte) 1, (byte) 116, (byte) 244, (byte) 23, (byte) 178, (byte) 156};
    private static String __s_cache_jX9GGVy6_0;
    private static String __s_cache_A1IagH8N_1;

    public static void a(LoggerData loggerData) {
        String string = Logger.getModuleCore().c().i().getString("Storage.databases.logger_table");
        try {
            Connection connectionC = Logger.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement("DELETE FROM `" + string + "` WHERE `id` = '" + loggerData.getId().toString() + "'");
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

    public static void b(LoggerData loggerData) {
        try {
            Logger.getModuleCore().c().k().set("data." + loggerData.getId().toString(), (Object) null);
            Logger.getModuleCore().c().h().get("logger").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_268() {
        return "Storage.databases.logger_table";
    }

    private static String __unused_269() {
        return "logger";
    }
}
