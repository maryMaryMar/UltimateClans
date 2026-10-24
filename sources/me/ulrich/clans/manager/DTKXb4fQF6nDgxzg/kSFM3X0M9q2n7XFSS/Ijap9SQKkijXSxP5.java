package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/kSFM3X0M9q2n7XFSS/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 {
    private static volatile String XJwW72ZbzrnfUUTjMCv;
    private static String SPR9AZDbGJg1aE3sHqM7;
    private static final byte[] yGcTlsTKfwCga9BuaV = {(byte) 187, (byte) 60, (byte) 189, (byte) 211, (byte) 19, (byte) 123, (byte) 123, (byte) 138, (byte) 86, (byte) 151, (byte) 97, (byte) 147, (byte) 150, (byte) 158, (byte) 182, (byte) 229};
    private static final byte[] nh7YqnnZZopc9dNLDsg = {(byte) 249, (byte) 82, (byte) 195, (byte) 207, (byte) 94, (byte) 104, (byte) 2, (byte) 117, (byte) 16, (byte) 236, (byte) 238, (byte) 40, (byte) 180, (byte) 73, (byte) 254, (byte) 254, (byte) 89, (byte) 107, (byte) 221, (byte) 116, (byte) 202, (byte) 183, (byte) 126, (byte) 144, (byte) 246, (byte) 211, (byte) 130, (byte) 217, (byte) 62, (byte) 150, (byte) 211, (byte) 121};
    private static final byte[] QPwP71mb1C95CJ = {(byte) 227, (byte) 99, (byte) 150, (byte) 190, (byte) 52, (byte) 197, (byte) 102, (byte) 197, (byte) 160, (byte) 131, (byte) 54, (byte) 234, (byte) 36, (byte) 130, (byte) 234, (byte) 213};

    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(AQpdf8VAiuRTrOYXyp());
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement("DELETE FROM `" + string + "` WHERE `uuid` = '" + uuid.toString() + "'");
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
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.PLAYERUPDATEUUID.toString(), uuid, Optional.empty()));
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
            Clans.getClanCore().getFiles().o1VU1x4DAlrEtGKZ3jAdhE().set("data." + uuid.toString(), (Object) null);
            Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(C6mATJnkfZsf0q()).save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String AQpdf8VAiuRTrOYXyp() {
        return "Storage.databases.player_table";
    }

    private static String C6mATJnkfZsf0q() {
        return "players";
    }
}
