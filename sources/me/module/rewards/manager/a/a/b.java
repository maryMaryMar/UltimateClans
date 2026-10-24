package me.module.rewards.manager.a.a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;
import java.util.UUID;
import me.module.rewards.Rewards;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import org.bukkit.Bukkit;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a/a/b.class */
public class b {
    private static byte[] __aes_key_SvhNAXVz = {(byte) 115, (byte) 218, (byte) 157, (byte) 38, (byte) 68, (byte) 136, (byte) 225, (byte) 50, (byte) 246, (byte) 21, (byte) 209, (byte) 140, (byte) 8, (byte) 32, (byte) 60, (byte) 157, (byte) 53, (byte) 224, (byte) 100, (byte) 142, (byte) 226, (byte) 91, (byte) 24, (byte) 186, (byte) 199, (byte) 106, (byte) 96, (byte) 102, (byte) 31, (byte) 136, (byte) 56, (byte) 114};
    private static byte[] __aes_iv_mTa14pxx = {(byte) 121, (byte) 209, (byte) 214, (byte) 179, (byte) 14, (byte) 4, (byte) 236, (byte) 94, (byte) 226, (byte) 149, (byte) 105, (byte) 204, (byte) 205, (byte) 78, (byte) 9, (byte) 60};
    private static String __s_cache_XmU4IWTH_0;
    private static String __s_cache_8yPtn0tT_1;

    public static void a(UUID uuid) {
        String string = Rewards.getModuleCore().c().j().getString("Storage.databases.rewards_table");
        try {
            Connection connectionC = Rewards.getModuleCore().j().b().c();
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
        try {
            Rewards.getModuleCore().c().l().set("data." + uuid.toString(), (Object) null);
            Rewards.getModuleCore().c().i().get("rewards").save();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String __unused_1496() {
        return "Storage.databases.rewards_table";
    }

    private static String __unused_1497() {
        return "rewards";
    }
}
