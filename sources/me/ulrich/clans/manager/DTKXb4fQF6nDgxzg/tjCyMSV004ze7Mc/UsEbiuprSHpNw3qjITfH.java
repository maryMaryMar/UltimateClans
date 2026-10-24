package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH {
    private static String Lb8gAYdHy2KzXvCReYle;
    private static volatile String JKfZm4OuwUssWEDG;
    private static String mnCzhbp0x9ibEe5gI5;
    private static volatile String aJX0A910qA4MeySVh;
    private static String uEUlMWIrYJZn98saSv4;
    private static String QH26oGd62bllZub;
    private static String HBjIujHLat1q6GA;
    private static String kmOzzbT2iHUox1pwrCCM3;
    private static final byte[] AkqhyrnwXc5FIInCyd = {(byte) 180, (byte) 124, (byte) 20, (byte) 193, (byte) 130, (byte) 162, (byte) 16, (byte) 51, (byte) 3, (byte) 179, (byte) 58, (byte) 204, (byte) 8, (byte) 171, (byte) 49, (byte) 115};
    private static final byte[] r77qtiuuLfNvb4GOcV = {(byte) 131, (byte) 225, (byte) 18, (byte) 146, (byte) 63, (byte) 59, (byte) 229, (byte) 155, (byte) 49, (byte) 237, (byte) 123, (byte) 242, (byte) 193, (byte) 145, (byte) 13, (byte) 240, (byte) 98, (byte) 217, (byte) 109, (byte) 97, (byte) 193, (byte) 4, (byte) 183, (byte) 0, (byte) 112, (byte) 7, (byte) 164, (byte) 191, (byte) 51, (byte) 5, (byte) 45, (byte) 31};
    private static final byte[] ntyAWQZSkdZFw07iw = {(byte) 239, (byte) 110, (byte) 38, (byte) 66, (byte) 221, (byte) 247, (byte) 132, (byte) 31, (byte) 67, (byte) 48, (byte) 82, (byte) 209, (byte) 193, (byte) 215, (byte) 143, (byte) 158, (byte) 102, (byte) 137, (byte) 113, (byte) 228, (byte) 226, (byte) 24, (byte) 56, (byte) 33, (byte) 166, (byte) 88, (byte) 182, (byte) 190, (byte) 96, (byte) 68, (byte) 51, (byte) 134};
    private static final byte[] GYRAmMH537wHAiNb = {(byte) 249, (byte) 185, (byte) 28, (byte) 44, (byte) 84, (byte) 0, (byte) 211, (byte) 23, (byte) 192, (byte) 93, (byte) 194, (byte) 225, (byte) 176, (byte) 100, (byte) 250, (byte) 155};

    public static CompletableFuture<List<InviteData>> v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
            case YAML:
                return jBUuLP0sWwaPyPOmogdX7l(uuid);
            case MYSQL:
            case SQLITE:
                return v8qP8fE86HMhvNuYPFjqY("SELECT * FROM `" + Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(OOZB7AYEBThtULIltI3M()) + "` WHERE `player` = '" + String.valueOf(uuid) + "'");
            default:
                return CompletableFuture.completedFuture(new ArrayList());
        }
    }

    public static CompletableFuture<List<InviteData>> v8qP8fE86HMhvNuYPFjqY() {
        switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
            case YAML:
                return jBUuLP0sWwaPyPOmogdX7l();
            case MYSQL:
            case SQLITE:
                return v8qP8fE86HMhvNuYPFjqY("SELECT * FROM `" + Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(C1ls6tjR4C64iBUwgg9s89()) + "`");
            default:
                return CompletableFuture.completedFuture(new ArrayList());
        }
    }

    private static CompletableFuture<List<InviteData>> jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList arrayList = new ArrayList();
            Clans clanCore = Clans.getClanCore();
            if (!clanCore.getFiles().vVo2VUvxrriklPdRxI().contains("data." + String.valueOf(uuid))) {
                return arrayList;
            }
            InviteData inviteDataZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(uuid);
            if (inviteDataZwrsrwOCXRUscW6Q != null) {
                v8qP8fE86HMhvNuYPFjqY(uuid, inviteDataZwrsrwOCXRUscW6Q);
                arrayList.add(inviteDataZwrsrwOCXRUscW6Q);
            }
            return arrayList;
        }, Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor());
    }

    private static CompletableFuture<List<InviteData>> jBUuLP0sWwaPyPOmogdX7l() {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList arrayList = new ArrayList();
            Clans clanCore = Clans.getClanCore();
            ConfigurationSection configurationSection = clanCore.getFiles().vVo2VUvxrriklPdRxI().getConfigurationSection(cJ1HYJsmkuR4LCFlbdOQ());
            if (configurationSection == null) {
                return arrayList;
            }
            for (String str : configurationSection.getKeys(false)) {
                try {
                    UUID uuidFromString = UUID.fromString(str);
                    if (clanCore.getFiles().vVo2VUvxrriklPdRxI().contains("data." + str)) {
                        InviteData inviteDataZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(uuidFromString);
                        v8qP8fE86HMhvNuYPFjqY(uuidFromString, inviteDataZwrsrwOCXRUscW6Q);
                        arrayList.add(inviteDataZwrsrwOCXRUscW6Q);
                    }
                } catch (Exception e) {
                }
            }
            return arrayList;
        }, Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor());
    }

    private static InviteData ZwrsrwOCXRUscW6Q(UUID uuid) {
        Clans clanCore = Clans.getClanCore();
        UUID uuidRandomUUID = UUID.randomUUID();
        try {
            String string = clanCore.getFiles().vVo2VUvxrriklPdRxI().getString("data." + String.valueOf(uuid) + ".id");
            if (string != null) {
                uuidRandomUUID = UUID.fromString(string);
            }
        } catch (Exception e) {
        }
        return new InviteData(uuidRandomUUID, uuid, UUID.fromString(clanCore.getFiles().vVo2VUvxrriklPdRxI().getString("data." + String.valueOf(uuid) + ".clan_id")), UUID.fromString(clanCore.getFiles().vVo2VUvxrriklPdRxI().getString("data." + String.valueOf(uuid) + ".inviter")), clanCore.getFiles().vVo2VUvxrriklPdRxI().getLong("data." + String.valueOf(uuid) + ".date"));
    }

    private static CompletableFuture<List<InviteData>> v8qP8fE86HMhvNuYPFjqY(String str) {
        CompletableFuture<List<InviteData>> completableFuture = new CompletableFuture<>();
        Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l(resultSet -> {
            ArrayList arrayList = new ArrayList();
            try {
                while (resultSet.next()) {
                    UUID uuidFromString = UUID.fromString(resultSet.getString(gxNX0dpw4K6r1ZrL()));
                    InviteData inviteData = new InviteData(UUID.fromString(resultSet.getString(mr5qoBAIOojeUguI())), uuidFromString, UUID.fromString(resultSet.getString(EaWauz5fV4I5JIaC3G())), UUID.fromString(resultSet.getString(FdDDqes0BKN0ahwZHP0lVQ())), resultSet.getLong(lBde8uBxgCqYI4T5JkQe()));
                    v8qP8fE86HMhvNuYPFjqY(uuidFromString, inviteData);
                    arrayList.add(inviteData);
                }
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
                return;
            }
            completableFuture.complete(arrayList);
        }, str);
        return completableFuture;
    }

    private static void v8qP8fE86HMhvNuYPFjqY(UUID uuid, InviteData inviteData) {
        Clans.getClanCore().getPlayerInviteManager().ZwrsrwOCXRUscW6Q().computeIfAbsent(uuid, uuid2 -> {
            return new ArrayList();
        }).add(inviteData);
    }

    private static String OOZB7AYEBThtULIltI3M() {
        return "Storage.databases.invite_table";
    }

    private static String C1ls6tjR4C64iBUwgg9s89() {
        return "Storage.databases.invite_table";
    }

    private static String gxNX0dpw4K6r1ZrL() {
        return "player";
    }

    private static String mr5qoBAIOojeUguI() {
        return "id";
    }

    private static String EaWauz5fV4I5JIaC3G() {
        return "clan_id";
    }

    private static String FdDDqes0BKN0ahwZHP0lVQ() {
        return "inviter";
    }

    private static String lBde8uBxgCqYI4T5JkQe() {
        return "date";
    }

    private static String cJ1HYJsmkuR4LCFlbdOQ() {
        return "data";
    }
}
