package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 {
    private static String bgLuz0Hnlt1SrfAvrr;
    private static volatile String ZQAShNQUFHuPGMWKVMdvIY;
    private static final byte[] UbVOAshtw7tXGUaYy = {(byte) 79, (byte) 26, (byte) 222, (byte) 142, (byte) 22, (byte) 142, (byte) 201, (byte) 200, (byte) 58, (byte) 178, (byte) 121, (byte) 46, (byte) 195, (byte) 87, (byte) 210, (byte) 45, (byte) 42, (byte) 217, (byte) 94, (byte) 139, (byte) 101, (byte) 206, (byte) 128, (byte) 0, (byte) 16, (byte) 86, (byte) 151, (byte) 2, (byte) 227, (byte) 171, (byte) 84, (byte) 31};
    private static final byte[] z0Y0xWly4FgAxcsfymuMTg = {(byte) 179, (byte) 141, (byte) 32, (byte) 237, (byte) 145, (byte) 4, (byte) 122, (byte) 38, (byte) 199, (byte) 44, (byte) 60, (byte) 196, (byte) 214, (byte) 153, (byte) 235, (byte) 213, (byte) 16, (byte) 62, (byte) 84, (byte) 179, (byte) 3, (byte) 67, (byte) 69, (byte) 239, (byte) 24, (byte) 240, (byte) 51, (byte) 39, (byte) 16, (byte) 55, (byte) 108, (byte) 142, (byte) 246, (byte) 13, (byte) 39, (byte) 206, (byte) 175, (byte) 73, (byte) 71, (byte) 177, (byte) 162, (byte) 80, (byte) 37, (byte) 215, (byte) 95, (byte) 168, (byte) 15, (byte) 201};

    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(DFiYcT02N0LDSb());
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
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.INVITEUPDATEUUID.toString(), uuid, Optional.empty()));
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
            Clans.getClanCore().getFiles().vVo2VUvxrriklPdRxI().set("data." + uuid.toString(), (Object) null);
            Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(VEcNO5sTLc5uyuKDh()).save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String hxoeGGop8UVTZ2me(byte[] bArr) {
        return "";
    }

    private static String DFiYcT02N0LDSb() {
        return "Storage.databases.invite_table";
    }

    private static String VEcNO5sTLc5uyuKDh() {
        return "invite";
    }
}
