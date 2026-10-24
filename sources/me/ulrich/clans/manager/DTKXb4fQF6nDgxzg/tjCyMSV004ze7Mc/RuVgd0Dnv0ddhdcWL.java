package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Collections;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    private static volatile String S438Kgl4AaFkb5PBM;
    private static String zNI47gdZedFwrNo;
    private static volatile String NpTijPGomhXDbstAsgiv;
    private static String GSaWL8XUnFZ8AQsF2Hn6ru;
    private static String ENFudxSEMZUYvQw;
    private static final byte[] oOvc9bQTspdKrCC0EtaWt = {(byte) 103, (byte) 186, (byte) 92, (byte) 26, (byte) 1, (byte) 147, (byte) 246, (byte) 59, (byte) 242, (byte) 155, (byte) 25, (byte) 209, (byte) 28, (byte) 53, (byte) 1, (byte) 35};
    private static final byte[] pcGRzBF6HwCHdUuxq6t = {(byte) 246, (byte) 96, (byte) 64, (byte) 16, (byte) 220, (byte) 226, (byte) 163, (byte) 102, (byte) 183, (byte) 134, (byte) 8, (byte) 106, (byte) 32, (byte) 210, (byte) 21, (byte) 202, (byte) 59, (byte) 185, (byte) 188, (byte) 73, (byte) 173, (byte) 169, (byte) 86, (byte) 139, (byte) 210, (byte) 3, (byte) 26, (byte) 225, (byte) 131, (byte) 17, (byte) 99, (byte) 202};
    private static final byte[] qjragSmKZPOdziWzk0G4C = {(byte) 54, (byte) 18, (byte) 8, (byte) 108, (byte) 215, (byte) 185, (byte) 242, (byte) 62, (byte) 21, (byte) 201, (byte) 23, (byte) 242, (byte) 194, (byte) 126, (byte) 116, (byte) 41, (byte) 226, (byte) 243, (byte) 225, (byte) 246, (byte) 183, (byte) 14, (byte) 42, (byte) 242, (byte) 246, (byte) 57, (byte) 68, (byte) 189, (byte) 188, (byte) 66, (byte) 50, (byte) 134};
    private static final byte[] Xh2pSPDU0ILw8qfn = {(byte) 29, (byte) 106, (byte) 170, (byte) 225, (byte) 187, (byte) 123, (byte) 252, (byte) 236, (byte) 70, (byte) 12, (byte) 243, (byte) 90, (byte) 68, (byte) 70, (byte) 244, (byte) 134};

    public static void v8qP8fE86HMhvNuYPFjqY(InviteData inviteData) {
        String str = "INSERT OR REPLACE INTO `" + Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(f2z9q3MKfWlWnad()) + "` (`id`, `player`, `clan_id`, `inviter`, `date`) VALUES (" + String.join(PYNROB3zwracAzUD(), Collections.nCopies(5, cWfLHjdgzcI9fK28Zx3QVI())) + ")";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, inviteData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, inviteData.getPlayer().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, inviteData.getClanID().toString());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, inviteData.getInviter().toString());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setLong(i4, inviteData.getDate());
                    preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
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

    public static void jBUuLP0sWwaPyPOmogdX7l(InviteData inviteData) {
        String str = "INSERT INTO `" + Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(CWhXDiKv66YrTCye7tKT()) + "` (`id`, `player`, `clan_id`, `inviter`, `date`) VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE `id`=VALUES(`id`), `player`=VALUES(`player`), `clan_id`=VALUES(`clan_id`), `inviter`=VALUES(`inviter`), `date`=VALUES(`date`)";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, inviteData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, inviteData.getPlayer().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, inviteData.getClanID().toString());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, inviteData.getInviter().toString());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setLong(i4, inviteData.getDate());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setString(i5, inviteData.getId().toString());
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, inviteData.getPlayer().toString());
                    int i8 = i7 + 1;
                    preparedStatementPrepareStatement.setString(i7, inviteData.getClanID().toString());
                    int i9 = i8 + 1;
                    preparedStatementPrepareStatement.setString(i8, inviteData.getInviter().toString());
                    int i10 = i9 + 1;
                    preparedStatementPrepareStatement.setLong(i9, inviteData.getDate());
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.INVITEUPDATEUUID.toString(), inviteData.getPlayer(), Optional.empty()));
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

    public static void ZwrsrwOCXRUscW6Q(InviteData inviteData) {
        try {
            FileConfiguration fileConfigurationVVo2VUvxrriklPdRxI = Clans.getClanCore().getFiles().vVo2VUvxrriklPdRxI();
            String str = "data." + String.valueOf(inviteData.getId());
            fileConfigurationVVo2VUvxrriklPdRxI.set(str + ".id", inviteData.getId().toString());
            fileConfigurationVVo2VUvxrriklPdRxI.set(str + ".player", inviteData.getPlayer().toString());
            fileConfigurationVVo2VUvxrriklPdRxI.set(str + ".clan_id", inviteData.getClanID().toString());
            fileConfigurationVVo2VUvxrriklPdRxI.set(str + ".inviter", inviteData.getInviter().toString());
            fileConfigurationVVo2VUvxrriklPdRxI.set(str + ".date", Long.valueOf(inviteData.getDate()));
            Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(MMKsiNjgc0AetcQItt()).save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String xefRIV21uZOFRF8uF69fu9(byte[] bArr) {
        return "";
    }

    private static String f2z9q3MKfWlWnad() {
        return "Storage.databases.invite_table";
    }

    private static String PYNROB3zwracAzUD() {
        return ",";
    }

    private static String cWfLHjdgzcI9fK28Zx3QVI() {
        return "?";
    }

    private static String CWhXDiKv66YrTCye7tKT() {
        return "Storage.databases.invite_table";
    }

    private static String MMKsiNjgc0AetcQItt() {
        return "invite";
    }
}
