package me.module.mail.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.UUID;
import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/b.class */
public class b {
    private static byte[] __aes_key_YI0U7GEy = {(byte) 177, (byte) 251, (byte) 145, (byte) 104, (byte) 99, (byte) 215, (byte) 159, (byte) 57, (byte) 7, (byte) 188, (byte) 117, (byte) 2, (byte) 11, (byte) 218, (byte) 143, (byte) 48, (byte) 135, (byte) 216, (byte) 56, (byte) 197, (byte) 94, (byte) 138, (byte) 0, (byte) 92, (byte) 180, (byte) 38, (byte) 196, (byte) 5, (byte) 62, (byte) 111, (byte) 175, (byte) 52};
    private static byte[] __aes_iv_Yszm9MYN = {(byte) 11, (byte) 61, (byte) 123, (byte) 62, (byte) 90, (byte) 23, (byte) 187, (byte) 43, (byte) 231, (byte) 90, (byte) 144, (byte) 15, (byte) 128, (byte) 50, (byte) 158, (byte) 15};
    private static String __s_cache_K9SWr1ms_0;
    private static String __s_cache_9MOd5gEs_1;

    public static void a(UUID uuid) {
        String string = Mail.getModuleCore().c().j().getString("Storage.databases.mail_table");
        try {
            Connection connectionC = Mail.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement("DELETE FROM `" + string + "` WHERE `id` = '" + uuid.toString() + "'");
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
        try {
            Mail.getModuleCore().c().l().set("data." + uuid.toString(), (Object) null);
            Mail.getModuleCore().c().i().get("mail").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_801() {
        return "Storage.databases.mail_table";
    }

    private static String __unused_802() {
        return "mail";
    }
}
