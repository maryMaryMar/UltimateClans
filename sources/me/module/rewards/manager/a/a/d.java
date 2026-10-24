package me.module.rewards.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import me.module.rewards.Rewards;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.RewardsData;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a/a/d.class */
public class d {
    private static byte[] __aes_key_oWjk6aR6 = {(byte) 47, (byte) 185, (byte) 1, (byte) 188, (byte) 155, (byte) 55, (byte) 85, (byte) 73, (byte) 55, (byte) 249, (byte) 65, (byte) 60, (byte) 9, (byte) 178, (byte) 96, (byte) 152, (byte) 72, (byte) 43, (byte) 255, (byte) 108, (byte) 95, (byte) 233, (byte) 63, (byte) 180, (byte) 195, (byte) 114, (byte) 120, (byte) 183, (byte) 210, (byte) 215, (byte) 127, (byte) 117};
    private static byte[] __aes_iv_bmhLj4Wz = {(byte) 148, (byte) 157, (byte) 145, (byte) 42, (byte) 5, (byte) 194, (byte) 189, (byte) 91, (byte) 243, (byte) 65, (byte) 193, (byte) 69, (byte) 29, (byte) 168, (byte) 209, (byte) 100};
    private static String __s_cache_HG10nVVt_0;
    private static String __s_cache_lMolNW3a_1;
    private static String __s_cache_h8jfYtVG_2;
    private static String __s_cache_PPZJYXgW_3;
    private static String __s_cache_T8Sw2pSE_4;
    private static String __s_cache_X4RVhByJ_5;
    private static String __s_cache_J6PZ9HXw_6;
    private static String __s_cache_bq0BMBWG_7;
    private static String __s_cache_dZtZ3wR3_8;

    public static void a(RewardsData rewardsData) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            rewardsData.getCollectedBy().forEach(uuid -> {
                sb.append(uuid).append("|");
            });
        } catch (Exception e) {
        }
        try {
            rewardsData.getRewards().forEach(str -> {
                sb2.append(str).append("|");
            });
        } catch (Exception e2) {
        }
        String str2 = "INSERT OR REPLACE INTO `" + Rewards.getModuleCore().c().j().getString("Storage.databases.rewards_table") + "` (`id`, `clan_id`, `sender`, `rewards`, `collected_by`, `description`, `icon`, `date`, `complement`) VALUES (" + String.join(",", Collections.nCopies(9, "?")) + ")";
        try {
            Connection connectionC = Rewards.getModuleCore().j().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str2);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, rewardsData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, rewardsData.getClanUUID().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, rewardsData.getSender().toString());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, sb2.toString());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setString(i4, sb.toString());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setString(i5, rewardsData.getDescription().orElse(""));
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, (String) rewardsData.getIcon().map((v0) -> {
                        return v0.name();
                    }).orElse(""));
                    int i8 = i7 + 1;
                    preparedStatementPrepareStatement.setLong(i7, rewardsData.getDate());
                    int i9 = i8 + 1;
                    preparedStatementPrepareStatement.setString(i8, rewardsData.getComplement().orElse(""));
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
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void b(RewardsData rewardsData) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            rewardsData.getCollectedBy().forEach(uuid -> {
                sb.append(uuid).append("|");
            });
        } catch (Exception e) {
        }
        try {
            rewardsData.getRewards().forEach(str -> {
                sb2.append(str).append("|");
            });
        } catch (Exception e2) {
        }
        String str2 = "INSERT INTO `" + Rewards.getModuleCore().c().j().getString("Storage.databases.rewards_table") + "` (`id`, `clan_id`, `sender`, `rewards`, `collected_by`, `description`, `icon`, `date`, `complement`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE `id`=?, `clan_id`=?, `sender`=?, `rewards`=?, `collected_by`=?, `description`=?, `icon`=?, `date`=?, `complement`=?";
        try {
            Connection connectionC = Rewards.getModuleCore().j().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement(str2);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, rewardsData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, rewardsData.getClanUUID().toString());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, rewardsData.getSender().toString());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, sb2.toString());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setString(i4, sb.toString());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setString(i5, rewardsData.getDescription().orElse(""));
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, (String) rewardsData.getIcon().map((v0) -> {
                        return v0.name();
                    }).orElse(""));
                    int i8 = i7 + 1;
                    preparedStatementPrepareStatement.setLong(i7, rewardsData.getDate());
                    int i9 = i8 + 1;
                    preparedStatementPrepareStatement.setString(i8, rewardsData.getComplement().orElse(""));
                    int i10 = i9 + 1;
                    preparedStatementPrepareStatement.setString(i9, rewardsData.getId().toString());
                    int i11 = i10 + 1;
                    preparedStatementPrepareStatement.setString(i10, rewardsData.getClanUUID().toString());
                    int i12 = i11 + 1;
                    preparedStatementPrepareStatement.setString(i11, rewardsData.getSender().toString());
                    int i13 = i12 + 1;
                    preparedStatementPrepareStatement.setString(i12, sb2.toString());
                    int i14 = i13 + 1;
                    preparedStatementPrepareStatement.setString(i13, sb.toString());
                    int i15 = i14 + 1;
                    preparedStatementPrepareStatement.setString(i14, rewardsData.getDescription().orElse(""));
                    int i16 = i15 + 1;
                    preparedStatementPrepareStatement.setString(i15, (String) rewardsData.getIcon().map((v0) -> {
                        return v0.name();
                    }).orElse(""));
                    int i17 = i16 + 1;
                    preparedStatementPrepareStatement.setLong(i16, rewardsData.getDate());
                    int i18 = i17 + 1;
                    preparedStatementPrepareStatement.setString(i17, rewardsData.getComplement().orElse(""));
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANREWARDS.toString(), rewardsData.getClanUUID(), Optional.empty()));
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
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static void c(RewardsData rewardsData) {
        try {
            ArrayList arrayList = new ArrayList();
            rewardsData.getCollectedBy().forEach(uuid -> {
                arrayList.add(uuid.toString());
            });
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".id", rewardsData.getId().toString());
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".clan_id", rewardsData.getClanUUID().toString());
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".sender", rewardsData.getSender().toString());
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".rewards", rewardsData.getRewards());
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".collected_by", arrayList);
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".description", rewardsData.getDescription().orElse(null));
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".icon", rewardsData.getIcon().map((v0) -> {
                return v0.name();
            }).orElse(null));
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".complement", rewardsData.getComplement().orElse(null));
            Rewards.getModuleCore().c().l().set("data." + String.valueOf(rewardsData.getId()) + ".date", Long.valueOf(rewardsData.getDate()));
            Rewards.getModuleCore().c().i().get("rewards").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_1501() {
        return "Storage.databases.rewards_table";
    }

    private static String __unused_1502() {
        return ",";
    }

    private static String __unused_1503() {
        return "?";
    }

    private static String __unused_1504() {
        return "Storage.databases.rewards_table";
    }

    private static String __unused_1505() {
        return "rewards";
    }

    private static String __unused_1506() {
        return "|";
    }

    private static String __unused_1507() {
        return "|";
    }

    private static String __unused_1508() {
        return "|";
    }

    private static String __unused_1509() {
        return "|";
    }
}
