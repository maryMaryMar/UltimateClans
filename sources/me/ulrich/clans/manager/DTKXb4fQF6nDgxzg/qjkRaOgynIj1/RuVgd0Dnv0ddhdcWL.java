package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.qjkRaOgynIj1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/qjkRaOgynIj1/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL {
    private static volatile String CAYU12dl4Ps94sX;
    private static String wY3uvm7wTyEur6Dzw;
    private static volatile String j2zSwo0lT9rt3FKIvBPao;
    private static volatile String Y2sIru91PKQD3zzLAm6E;
    private static volatile String PzvIR868912BuxVJkgKa3;
    private static volatile String JZK5xV4VgocW0L87h6oVOm;
    private static volatile String tRUUfxA62HSrvf5V4;
    private static volatile String uDjpXNsDSHQerXDr;
    private static volatile String T5o3ayHrRweoOT;
    private static final byte[] Z4nrSDUmQ6cvL9BYs = {(byte) 31, (byte) 103, (byte) 155, (byte) 177, (byte) 10, (byte) 145, (byte) 141, (byte) 137, (byte) 28, (byte) 142, (byte) 191, (byte) 32, (byte) 187, (byte) 77, (byte) 41, (byte) 86};
    private static final byte[] VFiH11RAbKCDMAMz3T9 = {(byte) 142, (byte) 54, (byte) 124, (byte) 253, (byte) 210, (byte) 99, (byte) 62, (byte) 15, (byte) 155, (byte) 67, (byte) 99, (byte) 192, (byte) 90, (byte) 60, (byte) 85, (byte) 41};
    private static final byte[] NlPfQS7CDOEt2tBBIkyQl = {(byte) 110, (byte) 107, (byte) 214, (byte) 149, (byte) 170, (byte) 135, (byte) 124, (byte) 59, (byte) 145, (byte) 189, (byte) 231, (byte) 79, (byte) 18, (byte) 236, (byte) 96, (byte) 177};
    private static final byte[] sjYdko2Zqa9iej4K = {(byte) 89, (byte) 90, (byte) 125, (byte) 144, (byte) 213, (byte) 146, (byte) 104, (byte) 15, (byte) 207, (byte) 131, (byte) 189, (byte) 166, (byte) 123, (byte) 50, (byte) 241, (byte) 217, (byte) 239, (byte) 126, (byte) 183, (byte) 228, (byte) 166, (byte) 92, (byte) 38, (byte) 98, (byte) 12, (byte) 148, (byte) 187, (byte) 177, (byte) 44, (byte) 98, (byte) 165, (byte) 216, (byte) 238, (byte) 27, (byte) 2, (byte) 75, (byte) 103, (byte) 71, (byte) 21, (byte) 228, (byte) 114, (byte) 176, (byte) 47, (byte) 23, (byte) 37, (byte) 194, (byte) 60, (byte) 132};
    private static final byte[] dr4JCCzBccTYs3nWfrB8l = {(byte) 116, (byte) 130, (byte) 193, (byte) 228, (byte) 186, (byte) 68, (byte) 139, (byte) 170, (byte) 199, (byte) 76, (byte) 186, (byte) 72, (byte) 103, (byte) 218, (byte) 14, (byte) 82, (byte) 92, (byte) 13, (byte) 241, (byte) 168, (byte) 209, (byte) 226, (byte) 178, (byte) 98, (byte) 143, (byte) 167, (byte) 83, (byte) 81, (byte) 118, (byte) 228, (byte) 220, (byte) 87};
    private static final byte[] YBVWi046D1AXi3iaTXhf = {(byte) 230, (byte) 168, (byte) 195, (byte) 79, (byte) 175, (byte) 35, (byte) 196, (byte) 255, (byte) 252, (byte) 119, (byte) 22, (byte) 176, (byte) 126, (byte) 46, (byte) 112, (byte) 127};

    public static void v8qP8fE86HMhvNuYPFjqY(UUID uuid, HashMap<String, HashMap<String, Boolean>> map) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(bSxF364DgUyzsN9());
        String strJoin = String.join(JUnil1hHfPokRhK6j(), Collections.nCopies(2, P0GKkqFQx9RTXm()));
        String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(map);
        if (strV8qP8fE86HMhvNuYPFjqY.isEmpty()) {
            return;
        }
        String str = "INSERT OR REPLACE INTO `" + string + "` (`id`, `value`) VALUES (" + strJoin + ")";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, uuid.toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, strV8qP8fE86HMhvNuYPFjqY);
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

    public static void jBUuLP0sWwaPyPOmogdX7l(UUID uuid, HashMap<String, HashMap<String, Boolean>> map) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(cUbbaMuUjXJUcNmuxN());
        String strV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(map);
        if (strV8qP8fE86HMhvNuYPFjqY.isEmpty()) {
            return;
        }
        String str = "INSERT INTO `" + string + "` (`id`, `value`) VALUES (?, ?) ON DUPLICATE KEY UPDATE `id`=?, `value`=?";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, uuid.toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, strV8qP8fE86HMhvNuYPFjqY);
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, uuid.toString());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, strV8qP8fE86HMhvNuYPFjqY);
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.MODERATIONUPDATEUUID.toString(), uuid, Optional.empty()));
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

    public static void ZwrsrwOCXRUscW6Q(UUID uuid, HashMap<String, HashMap<String, Boolean>> map) {
        boolean z = false;
        FileConfiguration fileConfigurationHX3ZfRb1nSpNq57s7x5ui = Clans.getClanCore().getFiles().HX3ZfRb1nSpNq57s7x5ui();
        for (Map.Entry<String, HashMap<String, Boolean>> entry : map.entrySet()) {
            String key = entry.getKey();
            HashMap<String, Boolean> value = entry.getValue();
            ArrayList arrayList = new ArrayList();
            if (value == null || value.isEmpty()) {
                arrayList.add(key + "#default#1");
            } else {
                for (Map.Entry<String, Boolean> entry2 : value.entrySet()) {
                    arrayList.add(entry2.getKey() + "#" + v8qP8fE86HMhvNuYPFjqY(entry2.getValue().booleanValue()));
                }
            }
            fileConfigurationHX3ZfRb1nSpNq57s7x5ui.set("data." + String.valueOf(uuid) + ".permissions." + key, arrayList);
            z = true;
        }
        if (z) {
            try {
                Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(pObI1xlMXakF0jSUoBgk()).save();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static String v8qP8fE86HMhvNuYPFjqY(HashMap<String, HashMap<String, Boolean>> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, HashMap<String, Boolean>> entry : map.entrySet()) {
            String key = entry.getKey();
            HashMap<String, Boolean> value = entry.getValue();
            if (value == null || value.isEmpty()) {
                sb.append(key).append(AqxVeOcC2Etmuw());
            } else {
                for (Map.Entry<String, Boolean> entry2 : value.entrySet()) {
                    sb.append(key).append(rTYDbRE8bjgSRvfMGp()).append(entry2.getKey()).append(AjC2ELmdYv4oCI()).append(v8qP8fE86HMhvNuYPFjqY(entry2.getValue().booleanValue())).append(BFoRqDz4BxGquyo3ag());
                }
            }
        }
        return sb.toString();
    }

    private static int v8qP8fE86HMhvNuYPFjqY(boolean z) {
        return z ? 1 : 0;
    }

    private static String bSxF364DgUyzsN9() {
        return "Storage.databases.moderation_table";
    }

    private static String JUnil1hHfPokRhK6j() {
        return ",";
    }

    private static String P0GKkqFQx9RTXm() {
        return "?";
    }

    private static String cUbbaMuUjXJUcNmuxN() {
        return "Storage.databases.moderation_table";
    }

    private static String pObI1xlMXakF0jSUoBgk() {
        return "permissions";
    }

    private static String rTYDbRE8bjgSRvfMGp() {
        return "#";
    }

    private static String AjC2ELmdYv4oCI() {
        return "#";
    }

    private static String BFoRqDz4BxGquyo3ag() {
        return "|";
    }

    private static String AqxVeOcC2Etmuw() {
        return "#default#1|";
    }
}
