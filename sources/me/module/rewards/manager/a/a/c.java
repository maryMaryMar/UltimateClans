package me.module.rewards.manager.a.a;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.module.rewards.Rewards;
import me.ulrich.clans.data.RewardsData;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/a/a/c.class */
public class c {
    private static byte[] __aes_key_tQsqq7zl = {(byte) 211, (byte) 26, (byte) 192, (byte) 191, (byte) 9, (byte) 188, (byte) 173, (byte) 173, (byte) 190, (byte) 148, (byte) 19, (byte) 247, (byte) 3, (byte) 19, (byte) 2, (byte) 230, (byte) 140, (byte) 151, (byte) 175, (byte) 94, (byte) 48, (byte) 106, (byte) 160, (byte) 73, (byte) 36, (byte) 55, (byte) 195, (byte) 88, (byte) 218, (byte) 101, (byte) 158, (byte) 71};
    private static byte[] __aes_iv_IOuse8fT = {(byte) 113, (byte) 157, (byte) 5, (byte) 255, (byte) 76, (byte) 110, (byte) 189, (byte) 170, (byte) 15, (byte) 66, (byte) 87, (byte) 87, (byte) 224, (byte) 126, (byte) 180, (byte) 75};
    private static String __s_cache_hpy7F65s_0;
    private static String __s_cache_M5lfrTNT_1;
    private static String __s_cache_VtNETayd_2;
    private static String __s_cache_aa15oEJj_3;
    private static String __s_cache_aCC5bk8V_4;
    private static String __s_cache_7V5qttmx_5;
    private static String __s_cache_2GHhMBY5_6;
    private static String __s_cache_ReV8A1pM_7;
    private static String __s_cache_3pNMbifZ_8;
    private static String __s_cache_VwMbqNk4_9;
    private static String __s_cache_RoRxyRd5_10;
    private static String __s_cache_pFwbt8g0_11;
    private static String __s_cache_a4yXpIdM_12;

    public static CompletableFuture<HashMap<UUID, RewardsData>> a() {
        switch (Rewards.getModuleCore().j().c()) {
            case MYSQL:
            case SQLITE:
                return a("SELECT * FROM `" + c() + "`");
            case YAML:
                return b();
            default:
                return CompletableFuture.completedFuture(new HashMap());
        }
    }

    public static CompletableFuture<Optional<RewardsData>> a(UUID uuid) {
        switch (Rewards.getModuleCore().j().c()) {
            case MYSQL:
            case SQLITE:
                return b(uuid);
            case YAML:
                return c(uuid);
            default:
                return CompletableFuture.completedFuture(Optional.empty());
        }
    }

    private static CompletableFuture<HashMap<UUID, RewardsData>> a(String str) {
        return CompletableFuture.supplyAsync(() -> {
            HashMap map = new HashMap();
            Rewards.getModuleCore().j().b(resultSet -> {
                while (resultSet.next()) {
                    try {
                        RewardsData rewardsDataA = a(resultSet);
                        if (rewardsDataA != null) {
                            a(rewardsDataA.getId(), rewardsDataA);
                            map.put(rewardsDataA.getId(), rewardsDataA);
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }, str);
            return map;
        }, Rewards.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static CompletableFuture<Optional<RewardsData>> b(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            RewardsData[] rewardsDataArr = new RewardsData[1];
            Rewards.getModuleCore().j().b(resultSet -> {
                RewardsData rewardsDataA;
                try {
                    if (resultSet.next() && (rewardsDataA = a(resultSet)) != null) {
                        a(rewardsDataA.getId(), rewardsDataA);
                        rewardsDataArr[0] = rewardsDataA;
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, "SELECT * FROM `" + c() + "` WHERE id='" + String.valueOf(uuid) + "' LIMIT 1");
            return Optional.ofNullable(rewardsDataArr[0]);
        }, Rewards.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static CompletableFuture<HashMap<UUID, RewardsData>> b() {
        return CompletableFuture.supplyAsync(() -> {
            RewardsData rewardsDataD;
            HashMap map = new HashMap();
            ConfigurationSection configurationSection = Rewards.getModuleCore().c().l().getConfigurationSection("data");
            if (configurationSection == null) {
                return map;
            }
            Iterator it = configurationSection.getKeys(false).iterator();
            while (it.hasNext()) {
                UUID uuidB = b((String) it.next());
                if (uuidB != null && (rewardsDataD = d(uuidB)) != null) {
                    a(uuidB, rewardsDataD);
                    map.put(uuidB, rewardsDataD);
                }
            }
            return map;
        }, Rewards.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static CompletableFuture<Optional<RewardsData>> c(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            RewardsData rewardsDataD = d(uuid);
            if (rewardsDataD != null) {
                a(uuid, rewardsDataD);
            }
            return Optional.ofNullable(rewardsDataD);
        }, Rewards.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static RewardsData a(ResultSet resultSet) {
        try {
            UUID uuidFromString = UUID.fromString(resultSet.getString("id"));
            UUID uuidFromString2 = UUID.fromString(resultSet.getString("clan_id"));
            UUID uuidFromString3 = UUID.fromString(resultSet.getString("sender"));
            long j = resultSet.getLong("date");
            Optional<String> optionalC = c(resultSet.getString("description"));
            Optional<String> optionalC2 = c(resultSet.getString("complement"));
            return new RewardsData(uuidFromString, uuidFromString2, uuidFromString3, optionalC, e(resultSet.getString("rewards")), f(resultSet.getString("collected_by")), d(resultSet.getString("icon")), j, optionalC2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static RewardsData d(UUID uuid) {
        try {
            FileConfiguration fileConfigurationL = Rewards.getModuleCore().c().l();
            String str = "data." + String.valueOf(uuid) + ".";
            UUID uuidFromString = UUID.fromString(fileConfigurationL.getString(str + "clan_id"));
            UUID uuidFromString2 = UUID.fromString(fileConfigurationL.getString(str + "sender"));
            long j = fileConfigurationL.getLong(str + "date");
            Optional<String> optionalC = c(fileConfigurationL.getString(str + "description"));
            Optional<String> optionalC2 = c(fileConfigurationL.getString(str + "complement"));
            Optional<Material> optionalD = d(fileConfigurationL.getString(str + "icon"));
            List stringList = fileConfigurationL.getStringList(str + "rewards");
            ArrayList arrayList = new ArrayList();
            Iterator it = fileConfigurationL.getStringList(str + "collected_by").iterator();
            while (it.hasNext()) {
                UUID uuidB = b((String) it.next());
                if (uuidB != null) {
                    arrayList.add(uuidB);
                }
            }
            return new RewardsData(uuid, uuidFromString, uuidFromString2, optionalC, stringList, arrayList, optionalD, j, optionalC2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String c() {
        return Rewards.getModuleCore().c().j().getString("Storage.databases.rewards_table");
    }

    private static UUID b(String str) {
        try {
            return UUID.fromString(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static Optional<String> c(String str) {
        return (str == null || str.isEmpty()) ? Optional.empty() : Optional.of(str);
    }

    private static Optional<Material> d(String str) {
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    return Optional.of(Material.valueOf(str));
                }
            } catch (Exception e) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }

    private static List<String> e(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty()) {
            return arrayList;
        }
        for (String str2 : str.split("\\|")) {
            if (str2 != null && !str2.isEmpty()) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    private static List<UUID> f(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty()) {
            return arrayList;
        }
        for (String str2 : str.split("\\|")) {
            UUID uuidB = b(str2);
            if (uuidB != null) {
                arrayList.add(uuidB);
            }
        }
        return arrayList;
    }

    private static void a(UUID uuid, RewardsData rewardsData) {
        Rewards.getModuleCore().i().getRewardsData().put(uuid, rewardsData);
    }

    private static String __unused_1483() {
        return "id";
    }

    private static String __unused_1484() {
        return "clan_id";
    }

    private static String __unused_1485() {
        return "sender";
    }

    private static String __unused_1486() {
        return "date";
    }

    private static String __unused_1487() {
        return "description";
    }

    private static String __unused_1488() {
        return "complement";
    }

    private static String __unused_1489() {
        return "icon";
    }

    private static String __unused_1490() {
        return "rewards";
    }

    private static String __unused_1491() {
        return "collected_by";
    }

    private static String __unused_1492() {
        return "Storage.databases.rewards_table";
    }

    private static String __unused_1493() {
        return "\\|";
    }

    private static String __unused_1494() {
        return "\\|";
    }

    private static String __unused_1495() {
        return "data";
    }
}
