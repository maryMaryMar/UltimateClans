package me.module.mail.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/a.class */
public class a {
    private static byte[] __aes_key_w4zk4Nk8 = {(byte) 131, (byte) 117, (byte) 42, (byte) 218, (byte) 51, (byte) 127, (byte) 159, (byte) 150, (byte) 235, (byte) 100, (byte) 144, (byte) 144, (byte) 83, (byte) 75, (byte) 30, (byte) 22, (byte) 156, (byte) 177, (byte) 21, (byte) 199, (byte) 249, (byte) 214, (byte) 16, (byte) 48, (byte) 10, (byte) 71, (byte) 201, (byte) 198, (byte) 30, (byte) 185, (byte) 80, (byte) 215};
    private static byte[] __aes_iv_WMK3WsZV = {(byte) 170, (byte) 64, (byte) 66, (byte) 246, (byte) 56, (byte) 183, (byte) 76, (byte) 79, (byte) 225, (byte) 131, (byte) 222, (byte) 64, (byte) 84, (byte) 30, (byte) 207, (byte) 5};
    private static String __s_cache_zEpjgirk_0;
    private static String __s_cache_stQdNZsg_1;
    private static String __s_cache_NUeVh8OM_2;

    public static void a(UUID uuid) {
        String string = Mail.getModuleCore().c().j().getString("Storage.databases.mail_table");
        try {
            Connection connectionC = Mail.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement("DELETE FROM `" + string + "` WHERE `to` = '" + uuid.toString() + "'");
                try {
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Mail.getModuleCore().d().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANMAILS.toString(), uuid, Optional.empty()));
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
            ConfigurationSection configurationSection = Mail.getModuleCore().c().l().getConfigurationSection("data");
            if (configurationSection != null && (keys = configurationSection.getKeys(false)) != null) {
                for (String str : keys) {
                    if (UUID.fromString(Mail.getModuleCore().c().l().getString("data." + str + ".to")).equals(uuid)) {
                        Mail.getModuleCore().c().l().set("data." + str.toString(), (Object) null);
                    }
                }
            }
            Mail.getModuleCore().c().i().get("mail").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_798() {
        return "Storage.databases.mail_table";
    }

    private static String __unused_799() {
        return "data";
    }

    private static String __unused_800() {
        return "mail";
    }
}
