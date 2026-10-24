package me.module.rewards.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import me.module.rewards.Rewards;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a/a/a.class */
public class a {
    private static byte[] __aes_key_5IpeyMaZ = {(byte) 7, (byte) 156, (byte) 203, (byte) 200, (byte) 69, (byte) 44, (byte) 251, (byte) 107, (byte) 107, (byte) 34, (byte) 92, (byte) 247, (byte) 172, (byte) 23, (byte) 101, (byte) 237, (byte) 238, (byte) 10, (byte) 69, (byte) 167, (byte) 227, (byte) 126, (byte) 102, (byte) 80, (byte) 54, (byte) 64, (byte) 1, (byte) 252, (byte) 123, (byte) 217, (byte) 53, (byte) 16};
    private static byte[] __aes_iv_HL7yN1N6 = {(byte) 113, (byte) 131, (byte) 38, (byte) 221, (byte) 2, (byte) 215, (byte) 132, (byte) 50, (byte) 183, (byte) 245, (byte) 138, (byte) 139, (byte) 5, (byte) 119, (byte) 135, (byte) 218};
    private static String __s_cache_ZSHCBwl7_0;
    private static String __s_cache_9MaMp6bG_1;
    private static String __s_cache_WqdkCUFc_2;

    public static void a(UUID uuid) {
        String string = Rewards.getModuleCore().c().j().getString("Storage.databases.rewards_table");
        try {
            Connection connectionC = Rewards.getModuleCore().j().b().c();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionC.prepareStatement("DELETE FROM `" + string + "` WHERE `clan_id` = '" + uuid.toString() + "'");
                try {
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionC != null) {
                        connectionC.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANREWARDS.toString(), uuid, Optional.empty()));
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
            ConfigurationSection configurationSection = Rewards.getModuleCore().c().l().getConfigurationSection("data");
            if (configurationSection != null && (keys = configurationSection.getKeys(false)) != null) {
                for (String str : keys) {
                    if (Rewards.getModuleCore().c().l().contains("data." + str + ".clan_id") && UUID.fromString(Rewards.getModuleCore().c().l().getString("data." + str + ".clan_id")).equals(uuid)) {
                        Rewards.getModuleCore().c().l().set("data." + str.toString(), (Object) null);
                    }
                }
            }
            Rewards.getModuleCore().c().i().get("rewards").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_1498() {
        return "Storage.databases.rewards_table";
    }

    private static String __unused_1499() {
        return "data";
    }

    private static String __unused_1500() {
        return "rewards";
    }
}
