package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH {
    private static String awjhxJW3D0XorMnllg;
    private static String pxPFLhxf4MH7D7W0jqnyM;
    private static final byte[] MlCut78mjUKrVNobO = {(byte) 42, (byte) 33, (byte) 84, (byte) 79, (byte) 211, (byte) 43, (byte) 8, (byte) 13, (byte) 154, (byte) 178, (byte) 45, (byte) 248, (byte) 101, (byte) 72, (byte) 210, (byte) 192, (byte) 191, (byte) 120, (byte) 34, (byte) 148, (byte) 50, (byte) 213, (byte) 225, (byte) 8, (byte) 103, (byte) 203, (byte) 212, (byte) 113, (byte) 226, (byte) 68, (byte) 125, (byte) 175};
    private static final byte[] cAzn9x0ORMO00D7WLtxFxh = {(byte) 149, (byte) 186, (byte) 140, (byte) 118, (byte) 211, (byte) 122, (byte) 194, (byte) 24, (byte) 141, (byte) 153, (byte) 162, (byte) 176, (byte) 207, (byte) 12, (byte) 46, (byte) 52, (byte) 0, (byte) 90, (byte) 87, (byte) 191, (byte) 205, (byte) 63, (byte) 234, (byte) 207, (byte) 135, (byte) 4, (byte) 100, (byte) 44, (byte) 123, (byte) 136, (byte) 208, (byte) 165};
    private static final byte[] KDd3tDEyMSFtwA3 = {(byte) 55, (byte) 195, (byte) 71, (byte) 251, (byte) 62, (byte) 115, (byte) 239, (byte) 26, (byte) 38, (byte) 255, (byte) 102, (byte) 223, (byte) 253, (byte) 96, (byte) 181, (byte) 60};

    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(MvRcm8hUTqdBdkB8Kmy());
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement("DELETE FROM `" + string + "` WHERE `id` = ?");
                try {
                    preparedStatementPrepareStatement.setString(1, uuid.toString());
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANUPDATEUUID.toString(), uuid, Optional.empty()));
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
            Clans.getClanCore().getFiles().lGGwXL678c4Kv7skJb5NiE().set("data." + uuid.toString(), (Object) null);
            Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(hMDS7Z24HzvzCXurD()).save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String MvRcm8hUTqdBdkB8Kmy() {
        return "Storage.databases.clan_table";
    }

    private static String hMDS7Z24HzvzCXurD() {
        return "clans";
    }
}
