package me.module.mail.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;
import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.MailData;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/d.class */
public class d {
    private static byte[] __aes_key_y0Bp7aUu = {(byte) 192, (byte) 204, (byte) 238, (byte) 52, (byte) 36, (byte) 192, (byte) 172, (byte) 106, (byte) 82, (byte) 118, (byte) 204, (byte) 110, (byte) 59, (byte) 6, (byte) 109, (byte) 42, (byte) 170, (byte) 15, (byte) 222, (byte) 250, (byte) 24, (byte) 73, (byte) 113, (byte) 108, (byte) 234, (byte) 255, (byte) 70, (byte) 249, (byte) 102, (byte) 149, (byte) 215, (byte) 75};
    private static byte[] __aes_iv_uXTXuOXG = {(byte) 60, (byte) 141, (byte) 192, (byte) 156, (byte) 89, (byte) 249, (byte) 62, (byte) 118, (byte) 238, (byte) 70, (byte) 203, (byte) 76, (byte) 136, (byte) 115, (byte) 130, (byte) 96};
    private static String __s_cache_IAtVya3C_0;
    private static String __s_cache_WTGUyZYY_1;
    private static String __s_cache_M3sdK1pB_2;
    private static String __s_cache_3XF3aFYg_3;
    private static String __s_cache_oZRfO9xT_4;
    private static String __s_cache_eDCcGFbe_5;

    public static void a(MailData mailData) {
        Mail.getModuleCore().c().j().getString("");
        String str = "INSERT OR REPLACE INTO `" + Mail.getModuleCore().c().j().getString("Storage.databases.mail_table") + "` (`id`, `from`, `text`, `to`, `sender`, `date`, `read_by`) VALUES (" + String.join(",", Collections.nCopies(7, "?")) + ")";
        String strD = d(mailData);
        try {
            Connection connectionC = Mail.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, mailData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, mailData.getFrom().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, mailData.getText());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, mailData.getTo().toString());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setString(i4, mailData.getSender().toString());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setLong(i5, mailData.getDate());
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, strD);
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

    public static void b(MailData mailData) {
        String str = "INSERT INTO `" + Mail.getModuleCore().c().j().getString("Storage.databases.mail_table") + "` (`id`, `from`, `text`, `to`, `sender`, `date`, `read_by`) VALUES (?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE `id`=?, `from`=?, `text`=?, `to`=?, `sender`=?, `date`=?, `read_by`=?";
        String strD = d(mailData);
        try {
            Connection connectionC = Mail.getModuleCore().f().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, mailData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, mailData.getFrom().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, mailData.getText());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, mailData.getTo().toString());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setString(i4, mailData.getSender().toString());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setLong(i5, mailData.getDate());
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, strD);
                    int i8 = i7 + 1;
                    preparedStatementPrepareStatement.setString(i7, mailData.getId().toString());
                    int i9 = i8 + 1;
                    preparedStatementPrepareStatement.setString(i8, mailData.getFrom().toString());
                    int i10 = i9 + 1;
                    preparedStatementPrepareStatement.setString(i9, mailData.getText());
                    int i11 = i10 + 1;
                    preparedStatementPrepareStatement.setString(i10, mailData.getTo().toString());
                    int i12 = i11 + 1;
                    preparedStatementPrepareStatement.setString(i11, mailData.getSender().toString());
                    int i13 = i12 + 1;
                    preparedStatementPrepareStatement.setLong(i12, mailData.getDate());
                    int i14 = i13 + 1;
                    preparedStatementPrepareStatement.setString(i13, strD);
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Mail.getModuleCore().d().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANMAILS.toString(), mailData.getFrom(), Optional.empty()));
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

    public static void c(MailData mailData) {
        try {
            FileConfiguration fileConfigurationL = Mail.getModuleCore().c().l();
            String str = "data." + String.valueOf(mailData.getId());
            fileConfigurationL.set(str + ".from", mailData.getFrom().toString());
            fileConfigurationL.set(str + ".text", mailData.getText());
            fileConfigurationL.set(str + ".to", mailData.getTo().toString());
            fileConfigurationL.set(str + ".sender", mailData.getSender().toString());
            fileConfigurationL.set(str + ".date", Long.valueOf(mailData.getDate()));
            fileConfigurationL.set(str + ".read_by", mailData.getReadBy().stream().map((v0) -> {
                return v0.toString();
            }).collect(Collectors.toList()));
            Mail.getModuleCore().c().i().get("mail").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String d(MailData mailData) {
        return (mailData.getReadBy() == null || mailData.getReadBy().isEmpty()) ? "" : (String) mailData.getReadBy().stream().map((v0) -> {
            return v0.toString();
        }).collect(Collectors.joining("|"));
    }

    private static String __unused_792() {
        return "Storage.databases.mail_table";
    }

    private static String __unused_793() {
        return ",";
    }

    private static String __unused_794() {
        return "?";
    }

    private static String __unused_795() {
        return "Storage.databases.mail_table";
    }

    private static String __unused_796() {
        return "mail";
    }

    private static String __unused_797() {
        return "|";
    }
}
