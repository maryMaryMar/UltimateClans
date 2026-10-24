package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/qjkRaOgynIj1/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 {
    private static final byte[] ALt4nzMTHyQ3sex = {(byte) 161, (byte) 222, (byte) 49, (byte) 1, (byte) 12, (byte) 172, (byte) 107, (byte) 41, (byte) 89, (byte) 10, (byte) 199, (byte) 214, (byte) 236, (byte) 219, (byte) 108, (byte) 62, (byte) 219, (byte) 178, (byte) 191, (byte) 151, (byte) 229, (byte) 18, (byte) 188, (byte) 39, (byte) 169, (byte) 174, (byte) 143, (byte) 235, (byte) 53, (byte) 212, (byte) 251, (byte) 102};
    private static final byte[] uz6bmIYVVdNtroyiYutm = {(byte) 165, (byte) 94, (byte) 138, (byte) 140, (byte) 156, (byte) 149, (byte) 6, (byte) 83, (byte) 33, (byte) 9, (byte) 208, (byte) 168, (byte) 176, (byte) 132, (byte) 117, (byte) 26};
    private static volatile String hS4D8sXWEACswEJvhRJ;
    private static String c4sk5tc0LPOY0xs7eNuCyI;

    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(YcGHFCkn1g4N2YhhWuky());
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement("DELETE FROM `" + string + "` WHERE `id` = '" + uuid.toString() + "'");
                try {
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.MODERATIONUPDATEUUID.toString(), uuid, Optional.empty()));
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
                if (connectionIZTqZaRK5UGoe0Z != null) {
                    try {
                        connectionIZTqZaRK5UGoe0Z.close();
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

    public static void jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        try {
            if (Clans.getClanCore().getFiles().HX3ZfRb1nSpNq57s7x5ui().contains("data." + uuid.toString())) {
                Clans.getClanCore().getFiles().HX3ZfRb1nSpNq57s7x5ui().set("data." + uuid.toString(), (Object) null);
                Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(l7mo9IAq3ST9G8yS7MCMhL()).save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String MjdAclRWOekHK8bFDrXET(byte[] bArr) {
        return "";
    }

    private static String YcGHFCkn1g4N2YhhWuky() {
        return "Storage.databases.moderation_table";
    }

    private static String l7mo9IAq3ST9G8yS7MCMhL() {
        return "permissions";
    }
}
