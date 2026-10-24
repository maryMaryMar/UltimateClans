package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.Clans;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/qjkRaOgynIj1/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH {
    private static String pKeRdKSiw3HHBhTG;
    private static volatile String FjMbU8kqr6RmGD3;
    private static volatile String IoUlRBQB2uXpjkfFiPmOE;
    private static String CjTyOgbdzH5wq7qt0;
    private static String l45Qa2hGUYlHwOZRtXR;
    private static String pEv3aaVau8Fmm1qrX7d;
    private static String v2wAjSiKwE1iqw21VaQ;
    private static volatile String LFDBZMf6VHvri3OKxkjX;
    private static String Oojdb1HDp2z6iYlW5gFC;
    private static final byte[] jXmuO4QfYjwtLcL = {(byte) 6, (byte) 34, (byte) 161, (byte) 196, (byte) 143, (byte) 251, (byte) 101, (byte) 191, (byte) 70, (byte) 210, (byte) 50, (byte) 255, (byte) 91, (byte) 220, (byte) 83, (byte) 65};
    private static final byte[] Boaoo8bACvFAy7knPi = {(byte) 135, (byte) 234, (byte) 219, (byte) 26, (byte) 85, (byte) 149, (byte) 40, (byte) 135, (byte) 171, (byte) 154, (byte) 2, (byte) 11, (byte) 85, (byte) 99, (byte) 238, (byte) 125};
    private static final byte[] kpZr5h83Uq1CXf = {(byte) 45, (byte) 46, (byte) 13, (byte) 24, (byte) 2, (byte) 35, (byte) 53, (byte) 200, (byte) 61, (byte) 103, (byte) 170, (byte) 224, (byte) 37, (byte) 213, (byte) 30, (byte) 34};
    private static final byte[] F9nlp7QDUARON0eK7Hk1dF = {(byte) 231, (byte) 162, (byte) 170, (byte) 216, (byte) 131, (byte) 160, (byte) 215, (byte) 117, (byte) 29, (byte) 79, (byte) 10, (byte) 109, (byte) 5, (byte) 204, (byte) 182, (byte) 206, (byte) 78, (byte) 95, (byte) 63, (byte) 184, (byte) 144, (byte) 111, (byte) 151, (byte) 16, (byte) 140, (byte) 226, (byte) 72, (byte) 245, (byte) 198, (byte) 253, (byte) 25, (byte) 70};
    private static final byte[] Y8J31BvDNx64InzhkG1yrY = {(byte) 182, (byte) 106, (byte) 97, (byte) 72, (byte) 32, (byte) 12, (byte) 82, (byte) 12, (byte) 241, (byte) 16, (byte) 33, (byte) 154, (byte) 215, (byte) 48, (byte) 143, (byte) 116};

    public static CompletableFuture<HashMap<UUID, HashMap<String, HashMap<String, Boolean>>>> v8qP8fE86HMhvNuYPFjqY() {
        switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
            case MYSQL:
            case SQLITE:
                return v8qP8fE86HMhvNuYPFjqY("SELECT * FROM `" + ZwrsrwOCXRUscW6Q() + "`");
            case YAML:
                return jBUuLP0sWwaPyPOmogdX7l();
            default:
                return CompletableFuture.completedFuture(new HashMap());
        }
    }

    public static CompletableFuture<HashMap<String, HashMap<String, Boolean>>> v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
            case MYSQL:
            case SQLITE:
                return jBUuLP0sWwaPyPOmogdX7l(uuid);
            case YAML:
                return ZwrsrwOCXRUscW6Q(uuid);
            default:
                return CompletableFuture.completedFuture(new HashMap());
        }
    }

    private static CompletableFuture<HashMap<UUID, HashMap<String, HashMap<String, Boolean>>>> v8qP8fE86HMhvNuYPFjqY(String str) {
        return CompletableFuture.supplyAsync(() -> {
            HashMap map = new HashMap();
            Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l(resultSet -> {
                try {
                    String string;
                    while (resultSet.next()) {
                        UUID uuidZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(resultSet.getString(kzeCrc7tbdKn8mEmU6oM4R()));
                        if (uuidZwrsrwOCXRUscW6Q != null && (string = resultSet.getString(OwhHm7rfrMcCgIW8A())) != null && !string.isEmpty()) {
                            HashMap<String, HashMap<String, Boolean>> mapJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(string);
                            if (!mapJBUuLP0sWwaPyPOmogdX7l.isEmpty()) {
                                HashMap<String, HashMap<String, Boolean>> mapV8qP8fE86HMhvNuYPFjqY = Clans.getClanCore().getModerationManager().v8qP8fE86HMhvNuYPFjqY(mapJBUuLP0sWwaPyPOmogdX7l);
                                v8qP8fE86HMhvNuYPFjqY(uuidZwrsrwOCXRUscW6Q, mapV8qP8fE86HMhvNuYPFjqY);
                                map.put(uuidZwrsrwOCXRUscW6Q, mapV8qP8fE86HMhvNuYPFjqY);
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }, str);
            return map;
        }, Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor());
    }

    private static CompletableFuture<HashMap<String, HashMap<String, Boolean>>> jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        return v8qP8fE86HMhvNuYPFjqY("SELECT * FROM `" + ZwrsrwOCXRUscW6Q() + "` WHERE id='" + String.valueOf(uuid) + "' LIMIT 1").thenApply(map -> {
            return (HashMap) map.getOrDefault(uuid, new HashMap());
        });
    }

    private static CompletableFuture<HashMap<UUID, HashMap<String, HashMap<String, Boolean>>>> jBUuLP0sWwaPyPOmogdX7l() {
        return CompletableFuture.supplyAsync(() -> {
            HashMap map = new HashMap();
            ConfigurationSection configurationSection = Clans.getClanCore().getFiles().HX3ZfRb1nSpNq57s7x5ui().getConfigurationSection(k7HXIdOgluV6rpTJ());
            if (configurationSection == null) {
                return map;
            }
            Iterator it = configurationSection.getKeys(false).iterator();
            while (it.hasNext()) {
                UUID uuidZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q((String) it.next());
                if (uuidZwrsrwOCXRUscW6Q != null) {
                    HashMap<String, HashMap<String, Boolean>> mapIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuidZwrsrwOCXRUscW6Q);
                    if (!mapIZTqZaRK5UGoe0Z.isEmpty()) {
                        HashMap<String, HashMap<String, Boolean>> mapV8qP8fE86HMhvNuYPFjqY = Clans.getClanCore().getModerationManager().v8qP8fE86HMhvNuYPFjqY(mapIZTqZaRK5UGoe0Z);
                        v8qP8fE86HMhvNuYPFjqY(uuidZwrsrwOCXRUscW6Q, mapV8qP8fE86HMhvNuYPFjqY);
                        map.put(uuidZwrsrwOCXRUscW6Q, mapV8qP8fE86HMhvNuYPFjqY);
                    }
                }
            }
            return map;
        }, Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor());
    }

    private static CompletableFuture<HashMap<String, HashMap<String, Boolean>>> ZwrsrwOCXRUscW6Q(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            HashMap<String, HashMap<String, Boolean>> mapIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(uuid);
            if (mapIZTqZaRK5UGoe0Z.isEmpty()) {
                return new HashMap();
            }
            HashMap<String, HashMap<String, Boolean>> mapV8qP8fE86HMhvNuYPFjqY = Clans.getClanCore().getModerationManager().v8qP8fE86HMhvNuYPFjqY(mapIZTqZaRK5UGoe0Z);
            v8qP8fE86HMhvNuYPFjqY(uuid, mapV8qP8fE86HMhvNuYPFjqY);
            return mapV8qP8fE86HMhvNuYPFjqY;
        }, Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor());
    }

    private static HashMap<String, HashMap<String, Boolean>> iZTqZaRK5UGoe0Z(UUID uuid) {
        ConfigurationSection configurationSection;
        Boolean boolIZTqZaRK5UGoe0Z;
        HashMap<String, HashMap<String, Boolean>> map = new HashMap<>();
        FileConfiguration fileConfigurationHX3ZfRb1nSpNq57s7x5ui = Clans.getClanCore().getFiles().HX3ZfRb1nSpNq57s7x5ui();
        String str = "data." + String.valueOf(uuid) + ".permissions";
        if (fileConfigurationHX3ZfRb1nSpNq57s7x5ui.contains(str) && (configurationSection = fileConfigurationHX3ZfRb1nSpNq57s7x5ui.getConfigurationSection(str)) != null) {
            for (String str2 : configurationSection.getKeys(false)) {
                for (String str3 : fileConfigurationHX3ZfRb1nSpNq57s7x5ui.getStringList(str + "." + str2)) {
                    if (str3 != null && str3.contains(Yl3t20xryfcef5a())) {
                        String[] strArrSplit = str3.split(zjRwqbOMG6DXUk5iZHY5CC());
                        if (strArrSplit.length == 2 && (boolIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(strArrSplit[1])) != null) {
                            map.computeIfAbsent(str2, str4 -> {
                                return new HashMap();
                            }).put(strArrSplit[0], boolIZTqZaRK5UGoe0Z);
                        }
                    }
                }
            }
            return map;
        }
        return map;
    }

    private static HashMap<String, HashMap<String, Boolean>> jBUuLP0sWwaPyPOmogdX7l(String str) {
        Boolean boolIZTqZaRK5UGoe0Z;
        HashMap<String, HashMap<String, Boolean>> map = new HashMap<>();
        if (str == null || str.isEmpty()) {
            return map;
        }
        for (String str2 : str.split(HF4xd1CDC2txca4N())) {
            if (str2 != null && str2.contains(eQWuEoD79enY8Dd5A())) {
                String[] strArrSplit = str2.split(UMC9R2bHgZlOKV());
                if (strArrSplit.length == 3 && (boolIZTqZaRK5UGoe0Z = iZTqZaRK5UGoe0Z(strArrSplit[2])) != null) {
                    map.computeIfAbsent(strArrSplit[0], str3 -> {
                        return new HashMap();
                    }).put(strArrSplit[1], boolIZTqZaRK5UGoe0Z);
                }
            }
        }
        return map;
    }

    private static UUID ZwrsrwOCXRUscW6Q(String str) {
        try {
            return UUID.fromString(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static Boolean iZTqZaRK5UGoe0Z(String str) {
        try {
            return Boolean.valueOf(Integer.parseInt(str) == 1);
        } catch (Exception e) {
            return null;
        }
    }

    private static String ZwrsrwOCXRUscW6Q() {
        return Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(JHKDDTlXlHtAsImPdEa());
    }

    private static void v8qP8fE86HMhvNuYPFjqY(UUID uuid, HashMap<String, HashMap<String, Boolean>> map) {
        Clans.getClanCore().getModerationManager().CDW4Fj1iwdIXEOqWjiJSR().put(uuid, map);
    }

    private static String Yl3t20xryfcef5a() {
        return "#";
    }

    private static String zjRwqbOMG6DXUk5iZHY5CC() {
        return "#";
    }

    private static String HF4xd1CDC2txca4N() {
        return "\\|";
    }

    private static String eQWuEoD79enY8Dd5A() {
        return "#";
    }

    private static String UMC9R2bHgZlOKV() {
        return "#";
    }

    private static String JHKDDTlXlHtAsImPdEa() {
        return "Storage.databases.moderation_table";
    }

    private static String k7HXIdOgluV6rpTJ() {
        return "data";
    }

    private static String kzeCrc7tbdKn8mEmU6oM4R() {
        return "id";
    }

    private static String OwhHm7rfrMcCgIW8A() {
        return "value";
    }
}
