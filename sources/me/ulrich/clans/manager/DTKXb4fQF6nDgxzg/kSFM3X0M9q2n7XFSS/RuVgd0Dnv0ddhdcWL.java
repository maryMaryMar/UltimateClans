package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.kSFM3X0M9q2n7XFSS;

import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/kSFM3X0M9q2n7XFSS/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    private static volatile String bqqVsztSDauHOQVt0n;
    private static volatile String vuysTzXqyceIq1JC7vNK;
    private static String S7b27posT45qAJCyU;
    private static volatile String xrnfaMAZeM6tpPWKu;
    private static String E0L23V74mI8j4IFG9nZXAm;
    private static final byte[] u85CtoaPCbBAoeNHhM8m = {(byte) 183, (byte) 233, (byte) 94, (byte) 247, (byte) 24, (byte) 8, (byte) 106, (byte) 251, (byte) 235, (byte) 1, (byte) 58, (byte) 172, (byte) 172, (byte) 211, (byte) 224, (byte) 86};
    private static final byte[] QJE3RzCfvXPfBWBZk35 = {(byte) 11, (byte) 28, (byte) 21, (byte) 83, (byte) 205, (byte) 210, (byte) 74, (byte) 30, (byte) 98, (byte) 195, (byte) 48, (byte) 115, (byte) 86, (byte) 22, (byte) 199, (byte) 31, (byte) 42, (byte) 42, (byte) 131, (byte) 90, (byte) 10, (byte) 248, (byte) 211, (byte) 0, (byte) 115, (byte) 52, (byte) 248, (byte) 207, (byte) 124, (byte) 29, (byte) 154, (byte) 131};
    private static final byte[] l0doUW1Cweet5U1J7666HM = {(byte) 24, (byte) 171, (byte) 15, (byte) 130, (byte) 249, (byte) 241, (byte) 129, (byte) 48, (byte) 145, (byte) 164, (byte) 189, (byte) 102, (byte) 172, (byte) 127, (byte) 113, (byte) 104, (byte) 24, (byte) 152, (byte) 71, (byte) 37, (byte) 139, (byte) 133, (byte) 63, (byte) 15, (byte) 9, (byte) 237, (byte) 90, (byte) 96, (byte) 222, (byte) 49, (byte) 57, (byte) 85, (byte) 24, (byte) 42, (byte) 107, (byte) 247, (byte) 142, (byte) 123, (byte) 31, (byte) 51, (byte) 145, (byte) 38, (byte) 23, (byte) 180, (byte) 124, (byte) 242, (byte) 67, (byte) 165};

    public static void v8qP8fE86HMhvNuYPFjqY(PlayerData playerData) {
        String str = "INSERT OR REPLACE INTO `" + Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(X2xIhDqrghPm2l()) + "` (`id`, `name`, `uuid`, `clan_id`, `kills`, `deaths`, `souls`, `kdr`, `join_date`, `last_seen`, `cache`, `nickname`, `custom_skin`, `settings.invitations`, `settings.clan_role`, `settings.locked_chat`, `settings.lang`) VALUES (" + String.join(Xm91Nq9h9hNtpaqSj(), Collections.nCopies(17, iF8x8CcqP6Mbscp3r6())) + ")";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    preparedStatementPrepareStatement.setString(1, playerData.getId().toString());
                    preparedStatementPrepareStatement.setString(2, playerData.getName());
                    preparedStatementPrepareStatement.setString(3, playerData.getUuid().toString());
                    preparedStatementPrepareStatement.setString(4, "");
                    preparedStatementPrepareStatement.setInt(5, playerData.getKills());
                    preparedStatementPrepareStatement.setInt(6, playerData.getDeaths());
                    preparedStatementPrepareStatement.setInt(7, playerData.getSouls());
                    preparedStatementPrepareStatement.setDouble(8, playerData.getKdr());
                    preparedStatementPrepareStatement.setLong(9, playerData.getJoinDate());
                    preparedStatementPrepareStatement.setLong(10, playerData.getLastSeen());
                    preparedStatementPrepareStatement.setString(11, playerData.getCache());
                    preparedStatementPrepareStatement.setString(12, playerData.getNickname());
                    preparedStatementPrepareStatement.setString(13, playerData.getCustomSkin());
                    preparedStatementPrepareStatement.setInt(14, v8qP8fE86HMhvNuYPFjqY(playerData.getSettings().isInvitations()));
                    preparedStatementPrepareStatement.setString(15, playerData.getRole());
                    preparedStatementPrepareStatement.setInt(16, v8qP8fE86HMhvNuYPFjqY(playerData.isLockedChat()));
                    preparedStatementPrepareStatement.setString(17, playerData.getLang());
                    preparedStatementPrepareStatement.execute();
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

    public static void jBUuLP0sWwaPyPOmogdX7l(PlayerData playerData) {
        String str = "INSERT INTO `" + Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(lAcEHm79KnOemWzFU7ObAB()) + "` (`id`, `name`, `uuid`, `clan_id`, `kills`, `deaths`, `souls`, `kdr`, `join_date`, `last_seen`, `cache`, `nickname`, `custom_skin`, `settings.invitations`, `settings.clan_role`, `settings.locked_chat`, `settings.lang`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE `id`=?, `name`=?, `uuid`=?, `clan_id`=?, `kills`=?, `deaths`=?, `souls`=?, `kdr`=?, `join_date`=?, `last_seen`=?, `cache`=?, `nickname`=?, `custom_skin`=?, `settings.invitations`=?, `settings.clan_role`=?, `settings.locked_chat`=?, `settings.lang`=?";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    preparedStatementPrepareStatement.setString(1, playerData.getId().toString());
                    preparedStatementPrepareStatement.setString(2, playerData.getName());
                    preparedStatementPrepareStatement.setString(3, playerData.getUuid().toString());
                    preparedStatementPrepareStatement.setString(4, "");
                    preparedStatementPrepareStatement.setInt(5, playerData.getKills());
                    preparedStatementPrepareStatement.setInt(6, playerData.getDeaths());
                    preparedStatementPrepareStatement.setInt(7, playerData.getSouls());
                    preparedStatementPrepareStatement.setDouble(8, playerData.getKdr());
                    preparedStatementPrepareStatement.setLong(9, playerData.getJoinDate());
                    preparedStatementPrepareStatement.setLong(10, playerData.getLastSeen());
                    preparedStatementPrepareStatement.setString(11, playerData.getCache());
                    preparedStatementPrepareStatement.setString(12, playerData.getNickname());
                    preparedStatementPrepareStatement.setString(13, playerData.getCustomSkin());
                    preparedStatementPrepareStatement.setInt(14, v8qP8fE86HMhvNuYPFjqY(playerData.getSettings().isInvitations()));
                    preparedStatementPrepareStatement.setString(15, playerData.getRole());
                    preparedStatementPrepareStatement.setInt(16, v8qP8fE86HMhvNuYPFjqY(playerData.isLockedChat()));
                    preparedStatementPrepareStatement.setString(17, playerData.getLang());
                    preparedStatementPrepareStatement.setString(18, playerData.getId().toString());
                    preparedStatementPrepareStatement.setString(19, playerData.getName());
                    preparedStatementPrepareStatement.setString(20, playerData.getUuid().toString());
                    preparedStatementPrepareStatement.setString(21, "");
                    preparedStatementPrepareStatement.setInt(22, playerData.getKills());
                    preparedStatementPrepareStatement.setInt(23, playerData.getDeaths());
                    preparedStatementPrepareStatement.setInt(24, playerData.getSouls());
                    preparedStatementPrepareStatement.setDouble(25, playerData.getKdr());
                    preparedStatementPrepareStatement.setLong(26, playerData.getJoinDate());
                    preparedStatementPrepareStatement.setLong(27, playerData.getLastSeen());
                    preparedStatementPrepareStatement.setString(28, playerData.getCache());
                    preparedStatementPrepareStatement.setString(29, playerData.getNickname());
                    preparedStatementPrepareStatement.setString(30, playerData.getCustomSkin());
                    preparedStatementPrepareStatement.setInt(31, v8qP8fE86HMhvNuYPFjqY(playerData.getSettings().isInvitations()));
                    preparedStatementPrepareStatement.setString(32, playerData.getRole());
                    preparedStatementPrepareStatement.setInt(33, v8qP8fE86HMhvNuYPFjqY(playerData.isLockedChat()));
                    preparedStatementPrepareStatement.setString(34, playerData.getLang());
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.PLAYERUPDATEUUID.toString(), playerData.getId(), Optional.empty()));
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

    public static void ZwrsrwOCXRUscW6Q(PlayerData playerData) {
        try {
            FileConfiguration fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE = Clans.getClanCore().getFiles().o1VU1x4DAlrEtGKZ3jAdhE();
            String str = "data." + String.valueOf(playerData.getId());
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".name", playerData.getName());
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".uuid", playerData.getUuid().toString());
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".kills", Integer.valueOf(playerData.getKills()));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".deaths", Integer.valueOf(playerData.getDeaths()));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".souls", Integer.valueOf(playerData.getSouls()));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".kdr", Double.valueOf(playerData.getKdr()));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".join_date", Long.valueOf(playerData.getJoinDate()));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".last_seen", Long.valueOf(playerData.getLastSeen()));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".cache", playerData.getCache());
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".nickname", playerData.getNickname());
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".custom_skin", playerData.getCustomSkin());
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".settings.invitations", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(playerData.getSettings().isInvitations())));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".settings.clan_role", playerData.getRole());
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".settings.locked_chat", Boolean.valueOf(playerData.isLockedChat()));
            fileConfigurationO1VU1x4DAlrEtGKZ3jAdhE.set(str + ".settings.lang", playerData.getLang());
            Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(jRbfSf8i00id9yh1ynSyY()).save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int v8qP8fE86HMhvNuYPFjqY(boolean z) {
        return z ? 1 : 0;
    }

    private static String NjShUYQcPDvDA8VCI(byte[] bArr) {
        return "";
    }

    private static String X2xIhDqrghPm2l() {
        return "Storage.databases.player_table";
    }

    private static String Xm91Nq9h9hNtpaqSj() {
        return ",";
    }

    private static String iF8x8CcqP6Mbscp3r6() {
        return "?";
    }

    private static String lAcEHm79KnOemWzFU7ObAB() {
        return "Storage.databases.player_table";
    }

    private static String jRbfSf8i00id9yh1ynSyY() {
        return "players";
    }
}
