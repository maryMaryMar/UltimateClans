package me.module.mail.manager.a.a;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import me.module.mail.Mail;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.MailData;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/a/a/c.class */
public class c {
    private static byte[] __aes_key_j9kzlBO7 = {(byte) 111, (byte) 89, (byte) 164, (byte) 206, (byte) 249, (byte) 202, (byte) 205, (byte) 165, (byte) 147, (byte) 3, (byte) 74, (byte) 221, (byte) 19, (byte) 240, (byte) 237, (byte) 190, (byte) 33, (byte) 121, (byte) 50, (byte) 6, (byte) 99, (byte) 161, (byte) 211, (byte) 59, (byte) 79, (byte) 154, (byte) 81, (byte) 155, (byte) 11, (byte) 237, (byte) 117, (byte) 40};
    private static byte[] __aes_iv_dvyNHMxZ = {(byte) 126, (byte) 117, (byte) 17, (byte) 112, (byte) 50, (byte) 56, (byte) 144, (byte) 5, (byte) 74, (byte) 159, (byte) 210, (byte) 187, (byte) 236, (byte) 79, (byte) 218, (byte) 102};
    private static String __s_cache_jJvmjb7W_0;
    private static String __s_cache_NPReWK7w_1;
    private static String __s_cache_0qHfTFyc_2;
    private static String __s_cache_TmjL8An6_3;
    private static String __s_cache_RiiYbLKf_4;
    private static String __s_cache_hxRe3bxv_5;
    private static String __s_cache_OZiUrTzw_6;
    private static String __s_cache_SPB77VDI_7;
    private static String __s_cache_ddThPpFn_8;
    private static String __s_cache_ABCJAPBd_9;
    private static String __s_cache_GE1wUDjI_10;
    private static String __s_cache_XGjftF0z_11;

    public static CompletableFuture<List<MailData>> a(UUID uuid) {
        return Mail.getModuleCore().f().c() == ClanEnum.ClanStorage.YAML ? b(uuid) : a("SELECT * FROM `" + Mail.getModuleCore().c().j().getString("Storage.databases.mail_table") + "` WHERE `id` = '" + String.valueOf(uuid) + "' LIMIT 1");
    }

    public static CompletableFuture<List<MailData>> a() {
        return Mail.getModuleCore().f().c() == ClanEnum.ClanStorage.YAML ? b() : a("SELECT * FROM `" + Mail.getModuleCore().c().j().getString("Storage.databases.mail_table") + "`");
    }

    private static CompletableFuture<List<MailData>> a(String str) {
        CompletableFuture<List<MailData>> completableFuture = new CompletableFuture<>();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Mail.getModuleCore().f().b(resultSet -> {
            ArrayList arrayList = new ArrayList();
            while (resultSet.next()) {
                try {
                    MailData mailDataA = a(resultSet);
                    if (mailDataA != null && a(mailDataA, jCurrentTimeMillis)) {
                        a(mailDataA);
                        arrayList.add(mailDataA);
                    }
                } catch (Exception e) {
                    completableFuture.completeExceptionally(e);
                    return;
                }
            }
            completableFuture.complete(arrayList);
        }, str);
        return completableFuture;
    }

    private static MailData a(ResultSet resultSet) throws SQLException {
        UUID uuidFromString = UUID.fromString(resultSet.getString("id"));
        UUID uuidFromString2 = UUID.fromString(resultSet.getString("from"));
        UUID uuidFromString3 = UUID.fromString(resultSet.getString("to"));
        UUID uuidFromString4 = UUID.fromString(resultSet.getString("sender"));
        ArrayList arrayList = new ArrayList();
        String string = resultSet.getString("read_by");
        if (string != null && !string.isEmpty()) {
            for (String str : string.split("\\|")) {
                try {
                    arrayList.add(UUID.fromString(str));
                } catch (Exception e) {
                }
            }
        }
        return new MailData(uuidFromString, uuidFromString2, uuidFromString3, uuidFromString4, resultSet.getString("text"), resultSet.getLong("date"), arrayList);
    }

    private static CompletableFuture<List<MailData>> b(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList arrayList = new ArrayList();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            MailData mailDataC = c(uuid);
            if (mailDataC != null && a(mailDataC, jCurrentTimeMillis)) {
                a(mailDataC);
                arrayList.add(mailDataC);
            }
            return arrayList;
        }, Mail.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static CompletableFuture<List<MailData>> b() {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList arrayList = new ArrayList();
            Mail moduleCore = Mail.getModuleCore();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            ConfigurationSection configurationSection = moduleCore.c().l().getConfigurationSection("data");
            if (configurationSection == null) {
                return arrayList;
            }
            Iterator it = configurationSection.getKeys(false).iterator();
            while (it.hasNext()) {
                try {
                    MailData mailDataC = null;
                    try {
                        mailDataC = c(UUID.fromString((String) it.next()));
                    } catch (Exception e) {
                    }
                    if (mailDataC != null && a(mailDataC, jCurrentTimeMillis)) {
                        a(mailDataC);
                        arrayList.add(mailDataC);
                    }
                } catch (Exception e2) {
                }
            }
            return arrayList;
        }, Mail.a().getLibAPI().getAsyncTaskExecutor().getExecutor());
    }

    private static MailData c(UUID uuid) {
        Mail moduleCore = Mail.getModuleCore();
        UUID uuidFromString = UUID.fromString(moduleCore.c().l().getString("data." + String.valueOf(uuid) + ".from"));
        UUID uuidFromString2 = UUID.fromString(moduleCore.c().l().getString("data." + String.valueOf(uuid) + ".to"));
        UUID uuidFromString3 = UUID.fromString(moduleCore.c().l().getString("data." + String.valueOf(uuid) + ".sender"));
        ArrayList arrayList = new ArrayList();
        try {
            Iterator it = moduleCore.c().l().getStringList("data." + String.valueOf(uuid) + ".read_by").iterator();
            while (it.hasNext()) {
                arrayList.add(UUID.fromString((String) it.next()));
            }
        } catch (Exception e) {
        }
        return new MailData(uuid, uuidFromString, uuidFromString2, uuidFromString3, moduleCore.c().l().getString("data." + String.valueOf(uuid) + ".text"), moduleCore.c().l().getLong("data." + String.valueOf(uuid) + ".date"), arrayList);
    }

    private static boolean a(MailData mailData, long j) {
        return j < mailData.getDate() + ((long) (60 * Mail.getModuleCore().c().j().getInt("Config.Mail.time_expires")));
    }

    private static void a(MailData mailData) {
        Mail.getModuleCore().e().getMailData().computeIfAbsent(mailData.getTo(), uuid -> {
            return new ArrayList();
        }).add(mailData);
    }

    private static String __unused_780() {
        return "Storage.databases.mail_table";
    }

    private static String __unused_781() {
        return "Storage.databases.mail_table";
    }

    private static String __unused_782() {
        return "id";
    }

    private static String __unused_783() {
        return "from";
    }

    private static String __unused_784() {
        return "to";
    }

    private static String __unused_785() {
        return "sender";
    }

    private static String __unused_786() {
        return "read_by";
    }

    private static String __unused_787() {
        return "\\|";
    }

    private static String __unused_788() {
        return "text";
    }

    private static String __unused_789() {
        return "date";
    }

    private static String __unused_790() {
        return "Config.Mail.time_expires";
    }

    private static String __unused_791() {
        return "data";
    }
}
