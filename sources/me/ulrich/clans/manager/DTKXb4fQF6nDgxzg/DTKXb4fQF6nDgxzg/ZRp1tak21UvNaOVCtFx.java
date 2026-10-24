package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.nio.charset.StandardCharsets;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ChestSettingsData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanQuestInfoData;
import me.ulrich.clans.data.ClanRivalAlly;
import me.ulrich.clans.data.ClanStats;
import me.ulrich.clans.data.HomesData;
import me.ulrich.clans.data.SettingsData;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx {
    private static volatile String HaX2HkvGpeyqWiad;
    private static volatile String l3GVxleYeOUk7ps3e84;
    private static volatile String wasw13AsyJW6QwMB;
    private static volatile String drXsvveKlzVBFWThpS3N;
    private static volatile String imfEhchidG80fq1XUi8;
    private static volatile String cNxjUNpXX9V0pLf3E;
    private static String AGMdP4kh06ZS7wz;
    private static String LX4SSCYlVxRAlDztaV;
    private static volatile String Snn1g04JfVvvi1FQN;
    private static volatile String L3ckrjazBHz2AGj;
    private static String oJIym9bb704lqK0;
    private static String LNSnWLLQ38QopzzS;
    private static String w9m0pvxQk9DIxZvT;
    private static volatile String Fzbhh5rIbPzbVJ;
    private static String NAB6vVykw18kkF;
    private static String tGjhu3hJ0zxcUBZFM5;
    private static String Gd18PiviD8bpAeqodgG;
    private static String XWGY29C0oM2R2kzp7H;
    private static String Wjxd4dOLFhHB7CBEjEYlM;
    private static String vwaPwWnj0lcpiWven;
    private static volatile String j0IPjJpvZBaoz8qm;
    private static volatile String n9tRD7BwoPE1wQQ1n;
    private static volatile String SdtDN2sUdSvdc36;
    private static volatile String pzSyHoWECrvmGhz;
    private static volatile String H6F2r4DMZHpCuQnj;
    private static volatile String GAB419hbL8Nd7N;
    private static String gHoQkdPEzh2HoTwGGCO0;
    private static String VXQxnG72h5G1g0eM5dJywr;
    private static volatile String PLK799XMkeYEYfBG;
    private static volatile String RVaq23Z2HflHj20676Z;
    private static volatile String lOR6XHs43bn9Ejx0kYD6O;
    private static String tW76UFW4RipfKG7;
    private static String wYPLjHOpxn0fMT;
    private static volatile String pV48tZqIzZY2jN6hqErLiF;
    private static String Pv8gnoluOxqq1hYJa;
    private static volatile String QlgIOhtYXoTL5kJ7l;
    private static volatile String UVspm1UCWxhxqXw9ddvQ;
    private static String MqX0bgRtLLZ3mn;
    private static String DW4RvrIDQrhCxkU9VYYFc;
    private static volatile String chqXj3ETMjVDyzx1C;
    private static String C9rY2rwqq4HmOXqyLHA5;
    private static volatile String l2JTcSzmcNnPm1aN7Y;
    private static String ZLKgSoHER5unoaSHOi4CxP;
    private static String gijrzhydv6flEqFI;
    private static String ga41JFpUdchj0q41FZy3a;
    private static volatile String TuHVpOeJzCCSn1UTnE;
    private static volatile String CvAHkCgv28nX2j6GX5DFA;
    private static String n8VhtAyCPaAu4ZBxOj8O;
    private static String Zoia9pwQ9KdkrwztPW;
    private static volatile String MOvV7iBcrwK38NueF4NgJ;
    private static String ymAqCnAaXfPa3QjkblmXz;
    private static String GS8TKqoLBN1CxX;
    private static volatile String sVr80ezgax9Q2th;
    private static String LDFDNarVRubiuhxZ;
    private static String xA80sS1zF0OFC9;
    private static volatile String mG6sR2zMg1hZsar;
    private static volatile String pGGcMGogQDTuh28;
    private static final byte[] lihoQcSPT6oeNj7yz19Ul = {(byte) 23, (byte) 90, (byte) 147, (byte) 22, (byte) 38, (byte) 189, (byte) 101, (byte) 247, (byte) 255, (byte) 105, (byte) 101, (byte) 163, (byte) 154, (byte) 62, (byte) 173, (byte) 122};
    private static final byte[] yyU9LrLo5ljGkXk0qqA8Qo = {(byte) 168, (byte) 84, (byte) 181, (byte) 174, (byte) 55, (byte) 182, (byte) 165, (byte) 186, (byte) 156, (byte) 71, (byte) 35, (byte) 20, (byte) 204, (byte) 161, (byte) 19, (byte) 106, (byte) 85, (byte) 189, (byte) 53, (byte) 72, (byte) 127, (byte) 144, (byte) 242, (byte) 141, (byte) 196, (byte) 117, (byte) 199, (byte) 235, (byte) 19, (byte) 171, (byte) 235, (byte) 222};
    private static final byte[] sBZj23gBp1YlTMpxy = {(byte) 22, (byte) 11, (byte) 85, (byte) 102, (byte) 50, (byte) 159, (byte) 59, (byte) 207, (byte) 246, (byte) 104, (byte) 71, (byte) 168, (byte) 191, (byte) 130, (byte) 103, (byte) 37};
    private static final byte[] ZQxnYZ7ThlXUIBoF = {(byte) 153, (byte) 106, (byte) 224, (byte) 13, (byte) 81, (byte) 90, (byte) 211, (byte) 188, (byte) 254, (byte) 40, (byte) 201, (byte) 88, (byte) 167, (byte) 216, (byte) 133, (byte) 203};
    private static final byte[] rQdK6qdfBcKgZJpQLzy = {(byte) 168, (byte) 153, (byte) 190, (byte) 229, (byte) 196, (byte) 132, (byte) 179, (byte) 195, (byte) 119, (byte) 225, (byte) 116, (byte) 62, (byte) 229, (byte) 255, (byte) 12, (byte) 15};
    private static final byte[] fvQYCJ4LxRd1HCvy = {(byte) 23, (byte) 90, (byte) 147, (byte) 22, (byte) 38, (byte) 189, (byte) 101, (byte) 247, (byte) 255, (byte) 105, (byte) 101, (byte) 163, (byte) 154, (byte) 62, (byte) 173, (byte) 122};
    private static final byte[] W5N64bekvil1BrOkMGruI = {(byte) 109, (byte) 54, (byte) 143, (byte) 144, (byte) 125, (byte) 122, (byte) 112, (byte) 31, (byte) 230, (byte) 156, (byte) 99, (byte) 157, (byte) 73, (byte) 230, (byte) 162, (byte) 77};
    private static final byte[] xlknnP1gsLS8wUI5P47HA = {(byte) 107, (byte) 172, (byte) 42, (byte) 6, (byte) 122, (byte) 142, (byte) 216, (byte) 192, (byte) 102, (byte) 175, (byte) 252, (byte) 166, (byte) 119, (byte) 80, (byte) 160, (byte) 105, (byte) 90, (byte) 253, (byte) 215, (byte) 83, (byte) 164, (byte) 215, (byte) 39, (byte) 61, (byte) 144, (byte) 92, (byte) 8, (byte) 147, (byte) 95, (byte) 197, (byte) 187, (byte) 150};
    private static final byte[] TGTJBXiveHB6wZK1 = {(byte) 7, (byte) 54, (byte) 247, (byte) 13, (byte) 64, (byte) 11, (byte) 223, (byte) 128, (byte) 29, (byte) 44, (byte) 54, (byte) 156, (byte) 182, (byte) 215, (byte) 85, (byte) 174, (byte) 152, (byte) 101, (byte) 134, (byte) 209, (byte) 88, (byte) 178, (byte) 215, (byte) 4, (byte) 133, (byte) 85, (byte) 1, (byte) 16, (byte) 213, (byte) 108, (byte) 100, (byte) 187};
    private static final byte[] dsIMVJSU4UzyEEN9 = {(byte) 181, (byte) 59, (byte) 221, (byte) 165, (byte) 103, (byte) 218, (byte) 110, (byte) 229, (byte) 134, (byte) 99, (byte) 242, (byte) 96, (byte) 130, (byte) 31, (byte) 242, (byte) 121};
    private static final byte[] sCFGSkfU1gnn6KAS = {(byte) 0, (byte) 72, (byte) 191, (byte) 5, (byte) 156, (byte) 206, (byte) 154, (byte) 232, (byte) 103, (byte) 60, (byte) 204, (byte) 176, (byte) 167, (byte) 117, (byte) 62, (byte) 224};
    private static final byte[] PPHL6IX5PaDW9Vq = {(byte) 40, (byte) 214, (byte) 232, (byte) 51, (byte) 63, (byte) 247, (byte) 32, (byte) 221, (byte) 177, (byte) 37, (byte) 228, (byte) 168, (byte) 6, (byte) 225, (byte) 83, (byte) 228};
    private static final byte[] jDkyRAPBJwtjIHjk2K3ta = {(byte) 185, (byte) 14, (byte) 220, (byte) 57, (byte) 52, (byte) 89, (byte) 118, (byte) 191, (byte) 33, (byte) 85, (byte) 22, (byte) 126, (byte) 122, (byte) 148, (byte) 242, (byte) 26};
    private static final byte[] rgc6lXTIzwtck7nViqj = {(byte) 222, (byte) 113, (byte) 99, (byte) 186, (byte) 179, (byte) 35, (byte) 171, (byte) 37, (byte) 141, (byte) 68, (byte) 123, (byte) 196, (byte) 236, (byte) 127, (byte) 159, (byte) 59};
    private static final byte[] XJfYEIfHbpHzyCgdnbj1 = {(byte) 147, (byte) 105, (byte) 229, (byte) 211, (byte) 118, (byte) 60, (byte) 222, (byte) 18, (byte) 60, (byte) 177, (byte) 55, (byte) 7, (byte) 29, (byte) 112, (byte) 8, (byte) 235};
    private static final byte[] QKHA9uoTK9TnuJpVRV = {(byte) 109, (byte) 31, (byte) 228, (byte) 9, (byte) 251, (byte) 146, (byte) 104, (byte) 164, (byte) 176, (byte) 231, (byte) 24, (byte) 144, (byte) 94, (byte) 194, (byte) 97, (byte) 73};
    private static final byte[] zXWnHdrUOuyk75 = {(byte) 25, (byte) 43, (byte) 238, (byte) 39, (byte) 182, (byte) 95, (byte) 100, (byte) 253, (byte) 199, (byte) 199, (byte) 27, (byte) 212, (byte) 103, (byte) 86, (byte) 100, (byte) 39};
    private static final byte[] dJlTkonF4DhhVxlFZG = {(byte) 206, (byte) 170, (byte) 232, (byte) 50, (byte) 223, (byte) 112, (byte) 21, (byte) 81, (byte) 208, (byte) 176, (byte) 24, (byte) 198, (byte) 174, (byte) 221, (byte) 211, (byte) 69};
    private static final byte[] FePHaZMZReFPpi = {(byte) 30, (byte) 88, (byte) 1, (byte) 167, (byte) 56, (byte) 201, (byte) 135, (byte) 42, (byte) 114, (byte) 73, (byte) 99, (byte) 225, (byte) 36, (byte) 255, (byte) 211, (byte) 17};
    private static final byte[] yDh6gEDSVqBYhe4e = {(byte) 126, (byte) 66, (byte) 27, (byte) 183, (byte) 35, (byte) 116, (byte) 41, (byte) 152, (byte) 101, (byte) 178, (byte) 201, (byte) 117, (byte) 200, (byte) 223, (byte) 116, (byte) 222};
    private static final byte[] SkNeS5vbvVfDYNhE5S = {(byte) 94, (byte) 233, (byte) 200, (byte) 197, (byte) 220, (byte) 50, (byte) 8, (byte) 208, (byte) 233, (byte) 153, (byte) 103, (byte) 232, (byte) 59, (byte) 150, (byte) 167, (byte) 166};
    private static final byte[] bsSn3gkCRy6R3qGwSjd = {(byte) 160, (byte) 253, (byte) 21, (byte) 109, (byte) 225, (byte) 62, (byte) 18, (byte) 120, (byte) 176, (byte) 106, (byte) 121, (byte) 88, (byte) 53, (byte) 10, (byte) 186, (byte) 237};
    private static final byte[] GTgKnip5D1CAzbmDx = {(byte) 107, (byte) 5, (byte) 16, (byte) 232, (byte) 241, (byte) 131, (byte) 125, (byte) 10, (byte) 232, (byte) 58, (byte) 185, (byte) 32, (byte) 207, (byte) 167, (byte) 3, (byte) 57};
    private static final byte[] Je1DX1ktMUe9yAJpwOI59 = {(byte) 157, (byte) 184, (byte) 130, (byte) 54, (byte) 76, (byte) 116, (byte) 195, (byte) 14, (byte) 177, (byte) 75, (byte) 212, (byte) 51, (byte) 17, (byte) 85, (byte) 125, (byte) 197};
    private static final byte[] HB9VpZoTD0DjzYROTS = {(byte) 18, (byte) 113, (byte) 105, (byte) 107, (byte) 140, (byte) 61, (byte) 116, (byte) 206, (byte) 137, (byte) 17, (byte) 237, (byte) 0, (byte) 86, (byte) 23, (byte) 212, (byte) 17};
    private static final byte[] avNmT8zPAdtv7ZnAwgA = {(byte) 155, (byte) 226, (byte) 158, (byte) 22, (byte) 29, (byte) 65, (byte) 51, (byte) 109, (byte) 23, (byte) 160, (byte) 125, (byte) 17, (byte) 255, (byte) 148, (byte) 212, (byte) 71};
    private static final byte[] oCfWE29ZlP0qi419 = {(byte) 252, (byte) 97, (byte) 230, (byte) 226, (byte) 125, (byte) 59, (byte) 144, (byte) 142, (byte) 156, (byte) 155, (byte) 171, (byte) 149, (byte) 203, (byte) 66, (byte) 152, (byte) 249};
    private static final byte[] TYRrlztlA7wNQGR3hT = {(byte) 90, (byte) 225, (byte) 13, (byte) 82, (byte) 235, (byte) 123, (byte) 39, (byte) 253, (byte) 60, (byte) 247, (byte) 187, (byte) 137, (byte) 1, (byte) 247, (byte) 16, (byte) 169, (byte) 91, (byte) 190, (byte) 35, (byte) 49, (byte) 219, (byte) 218, (byte) 48, (byte) 35, (byte) 138, (byte) 154, (byte) 125, (byte) 194, (byte) 242, (byte) 172, (byte) 105, (byte) 228};
    private static final byte[] FMjje9GsnuEGnvW9HCbgA = {(byte) 209, (byte) 69, (byte) 78, (byte) 116, (byte) 144, (byte) 130, (byte) 116, (byte) 150, (byte) 141, (byte) 46, (byte) 95, (byte) 191, (byte) 199, (byte) 76, (byte) 30, (byte) 205};

    public static CompletableFuture<List<ClanData>> v8qP8fE86HMhvNuYPFjqY() {
        switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
            case MYSQL:
            case SQLITE:
                return iZTqZaRK5UGoe0Z("SELECT * FROM `" + ZwrsrwOCXRUscW6Q() + "`");
            case YAML:
                return jBUuLP0sWwaPyPOmogdX7l();
            default:
                return CompletableFuture.completedFuture(new ArrayList());
        }
    }

    public static CompletableFuture<Optional<ClanData>> v8qP8fE86HMhvNuYPFjqY(UUID uuid) {
        switch (Clans.getClanCore().getDatabaseManager().ZwrsrwOCXRUscW6Q()) {
            case MYSQL:
            case SQLITE:
                return iZTqZaRK5UGoe0Z("SELECT * FROM `" + ZwrsrwOCXRUscW6Q() + "` WHERE `id`='" + String.valueOf(uuid) + "' LIMIT 1").thenApply(list -> {
                    return list.stream().findFirst();
                });
            case YAML:
                return jBUuLP0sWwaPyPOmogdX7l(uuid);
            default:
                return CompletableFuture.completedFuture(Optional.empty());
        }
    }

    private static CompletableFuture<List<ClanData>> jBUuLP0sWwaPyPOmogdX7l() {
        return CompletableFuture.supplyAsync(() -> {
            ArrayList arrayList = new ArrayList();
            ConfigurationSection configurationSection = Clans.getClanCore().getFiles().lGGwXL678c4Kv7skJb5NiE().getConfigurationSection(VbMhW3RHDKZcxrvBUY());
            if (configurationSection == null) {
                return arrayList;
            }
            Iterator it = configurationSection.getKeys(false).iterator();
            while (it.hasNext()) {
                try {
                    ClanData clanDataZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(UUID.fromString((String) it.next()));
                    if (clanDataZwrsrwOCXRUscW6Q != null) {
                        v8qP8fE86HMhvNuYPFjqY(clanDataZwrsrwOCXRUscW6Q);
                        arrayList.add(clanDataZwrsrwOCXRUscW6Q);
                    }
                } catch (Exception e) {
                }
            }
            return arrayList;
        }, Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor());
    }

    private static CompletableFuture<Optional<ClanData>> jBUuLP0sWwaPyPOmogdX7l(UUID uuid) {
        return CompletableFuture.supplyAsync(() -> {
            ClanData clanDataZwrsrwOCXRUscW6Q = ZwrsrwOCXRUscW6Q(uuid);
            if (clanDataZwrsrwOCXRUscW6Q == null) {
                return Optional.empty();
            }
            v8qP8fE86HMhvNuYPFjqY(clanDataZwrsrwOCXRUscW6Q);
            return Optional.of(clanDataZwrsrwOCXRUscW6Q);
        }, Clans.getClanCore().getTaskManager().b4i2FbOkaKeg91LiAe6l().getExecutor());
    }

    private static ClanData ZwrsrwOCXRUscW6Q(UUID uuid) {
        try {
            String str = "data." + String.valueOf(uuid) + ".";
            FileConfiguration fileConfigurationLGGwXL678c4Kv7skJb5NiE = Clans.getClanCore().getFiles().lGGwXL678c4Kv7skJb5NiE();
            String string = fileConfigurationLGGwXL678c4Kv7skJb5NiE.getString(str + "tag");
            String string2 = fileConfigurationLGGwXL678c4Kv7skJb5NiE.getString(str + "desc");
            UUID uuidFromString = UUID.fromString(fileConfigurationLGGwXL678c4Kv7skJb5NiE.getString(str + "leader"));
            boolean zV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "verified", false);
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l((List<String>) fileConfigurationLGGwXL678c4Kv7skJb5NiE.getStringList(str + "members"));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l2 = jBUuLP0sWwaPyPOmogdX7l((List<String>) fileConfigurationLGGwXL678c4Kv7skJb5NiE.getStringList(str + "mods"));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l3 = jBUuLP0sWwaPyPOmogdX7l((List<String>) fileConfigurationLGGwXL678c4Kv7skJb5NiE.getStringList(str + "banned"));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l4 = jBUuLP0sWwaPyPOmogdX7l((List<String>) fileConfigurationLGGwXL678c4Kv7skJb5NiE.getStringList(str + "rival"));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l5 = jBUuLP0sWwaPyPOmogdX7l((List<String>) fileConfigurationLGGwXL678c4Kv7skJb5NiE.getStringList(str + "ally"));
            List<HomesData> listV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY((List<String>) fileConfigurationLGGwXL678c4Kv7skJb5NiE.getStringList(str + "home"));
            ArrayList arrayList = new ArrayList();
            ClanStats clanStats = new ClanStats(v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "kills", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "deaths", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "souls", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "member_joined", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "member_left", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "war_win", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "war_lose", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "tag_changed", 0), 0, v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "glad_win", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "glad_lose", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "league_win", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "league_lose", 0));
            ClanRivalAlly clanRivalAlly = new ClanRivalAlly(listJBUuLP0sWwaPyPOmogdX7l4, listJBUuLP0sWwaPyPOmogdX7l5);
            ClanQuestInfoData clanQuestInfoData = new ClanQuestInfoData(v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "quest.points", 0), v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "quest.finished", 0));
            SettingsData settingsData = new SettingsData(Optional.empty(), true, true, true, true, false, true, true, true, false);
            v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "settings.", settingsData);
            ChestSettingsData chestSettingsData = new ChestSettingsData(v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "extra_chest", 0), new ArrayList(fileConfigurationLGGwXL678c4Kv7skJb5NiE.getIntegerList(str + "locked_pages_chest")));
            double dV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "bank", 0.0d);
            int iV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "level", 0);
            double dV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "kdr", 0.0d);
            boolean zV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "ff", false);
            long jV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "creation_date", 0L);
            int iV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "maxlevel", 0);
            int iV8qP8fE86HMhvNuYPFjqY3 = v8qP8fE86HMhvNuYPFjqY((ConfigurationSection) fileConfigurationLGGwXL678c4Kv7skJb5NiE, str + "extra_slots", 0);
            return new ClanData(uuid, string, string2, uuidFromString, zV8qP8fE86HMhvNuYPFjqY, listV8qP8fE86HMhvNuYPFjqY, jV8qP8fE86HMhvNuYPFjqY, clanStats, listJBUuLP0sWwaPyPOmogdX7l, arrayList, zV8qP8fE86HMhvNuYPFjqY2, dV8qP8fE86HMhvNuYPFjqY2, fileConfigurationLGGwXL678c4Kv7skJb5NiE.getString(str + "tag_raw"), listJBUuLP0sWwaPyPOmogdX7l2, listJBUuLP0sWwaPyPOmogdX7l3, clanRivalAlly, Double.valueOf(dV8qP8fE86HMhvNuYPFjqY), iV8qP8fE86HMhvNuYPFjqY, clanQuestInfoData, settingsData, chestSettingsData, v8qP8fE86HMhvNuYPFjqY(fileConfigurationLGGwXL678c4Kv7skJb5NiE.getString(str + "banner"), ""), iV8qP8fE86HMhvNuYPFjqY2, iV8qP8fE86HMhvNuYPFjqY3, fileConfigurationLGGwXL678c4Kv7skJb5NiE.getString(str + "patent"), fileConfigurationLGGwXL678c4Kv7skJb5NiE.getString(str + "webhook"), System.currentTimeMillis() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static ClanData v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet) {
        try {
            UUID uuidFromString = UUID.fromString(resultSet.getString(TUM614GdRCApaNS7pbfF()));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l = jBUuLP0sWwaPyPOmogdX7l(v8qP8fE86HMhvNuYPFjqY(resultSet, qc2RnjAfOogc3k8eD(), (String) null));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l2 = jBUuLP0sWwaPyPOmogdX7l(v8qP8fE86HMhvNuYPFjqY(resultSet, J3bQv1HZloFQYCG(), (String) null));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l3 = jBUuLP0sWwaPyPOmogdX7l(v8qP8fE86HMhvNuYPFjqY(resultSet, rjCuOXh4xPV7ugr(), (String) null));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l4 = jBUuLP0sWwaPyPOmogdX7l(v8qP8fE86HMhvNuYPFjqY(resultSet, IAKhWhy2obdOzatiBWFOup(), (String) null));
            List<UUID> listJBUuLP0sWwaPyPOmogdX7l5 = jBUuLP0sWwaPyPOmogdX7l(v8qP8fE86HMhvNuYPFjqY(resultSet, iYk1KyNtpvhpSPxcMGlM(), (String) null));
            List<HomesData> listV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(v8qP8fE86HMhvNuYPFjqY(resultSet, IksLLGSa9j8xhsvc567EQ(), (String) null));
            ArrayList arrayList = new ArrayList();
            ClanStats clanStats = new ClanStats(v8qP8fE86HMhvNuYPFjqY(resultSet, WkbwPKokUjOBt9l(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, kp2TeTvjQDkQFQm9j(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, uGg1lTl9CmW6CfR2EUT(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, ELHiaW3xHBJCOg2(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, NAz8JqCfuvo9WoZieda(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, fzkaTMXRmcvmVjRzY668(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, pKJgMNWxMfhkSrUwirD(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, FSfFeHlkLZyeUCE2b(), 0), 0, v8qP8fE86HMhvNuYPFjqY(resultSet, IJrAypbMo4cSNrXm(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, JWi1bSE44AL4Tz(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, cL73EOivrcp5Bcpg(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, E9sqbjQSXHVomzWqPdx(), 0));
            ClanRivalAlly clanRivalAlly = new ClanRivalAlly(listJBUuLP0sWwaPyPOmogdX7l4, listJBUuLP0sWwaPyPOmogdX7l5);
            ClanQuestInfoData clanQuestInfoData = new ClanQuestInfoData(v8qP8fE86HMhvNuYPFjqY(resultSet, rAFZhNH1aaaphuzOIHtxw(), 0), v8qP8fE86HMhvNuYPFjqY(resultSet, qb7J21NtLcJ6BhSpVx(), 0));
            SettingsData settingsData = new SettingsData(Optional.empty(), true, true, true, true, false, true, true, true, false);
            v8qP8fE86HMhvNuYPFjqY(resultSet, settingsData);
            ChestSettingsData chestSettingsData = new ChestSettingsData(v8qP8fE86HMhvNuYPFjqY(resultSet, iUTG0q1eOzwAHYzr3M(), 0), new ArrayList());
            boolean zV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(resultSet, m6qz9TCE5doxsRskB(), false);
            boolean zV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(resultSet, vH5XuySfRYCm0L5coZWTZt(), false);
            double dV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(resultSet, GViJvl0T0dNFtTPl(), 0.0d);
            long jV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(resultSet, nIfbQpXgyDT0zFfdC(), 0L);
            double dV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(resultSet, ayFz1hG4WfkzmE(), 0.0d);
            int iV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(resultSet, gxGLML2oiqCarGwTWC0T(), 0);
            int iV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(resultSet, eUBRT2Vws3iyMqq(), 0);
            int iV8qP8fE86HMhvNuYPFjqY3 = v8qP8fE86HMhvNuYPFjqY(resultSet, v0ftVHgx4sBx0zIyFA(), 0);
            return new ClanData(uuidFromString, resultSet.getString(A2VyptYjtPAs7vf2()), resultSet.getString(FhlNk18e8webhbxLg3()), UUID.fromString(resultSet.getString(J30lYMUByeQLRI())), zV8qP8fE86HMhvNuYPFjqY, listV8qP8fE86HMhvNuYPFjqY, jV8qP8fE86HMhvNuYPFjqY, clanStats, listJBUuLP0sWwaPyPOmogdX7l, arrayList, zV8qP8fE86HMhvNuYPFjqY2, dV8qP8fE86HMhvNuYPFjqY, v8qP8fE86HMhvNuYPFjqY(resultSet, oo13ceSBf1kc9n(), (String) null), listJBUuLP0sWwaPyPOmogdX7l2, listJBUuLP0sWwaPyPOmogdX7l3, clanRivalAlly, Double.valueOf(dV8qP8fE86HMhvNuYPFjqY2), iV8qP8fE86HMhvNuYPFjqY, clanQuestInfoData, settingsData, chestSettingsData, v8qP8fE86HMhvNuYPFjqY(resultSet, y0V3nISJCsZP21D(), ""), iV8qP8fE86HMhvNuYPFjqY2, iV8qP8fE86HMhvNuYPFjqY3, v8qP8fE86HMhvNuYPFjqY(resultSet, x1BgoXf8DZJjwWW(), (String) null), v8qP8fE86HMhvNuYPFjqY(resultSet, aAUr7xIoBk7Op8NXgFQlc(), (String) null), System.currentTimeMillis() / 1000);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void v8qP8fE86HMhvNuYPFjqY(ConfigurationSection configurationSection, String str, SettingsData settingsData) {
        if (configurationSection.contains(str + "war_invite")) {
            settingsData.setWarInvite(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "war_invite", true));
        }
        if (configurationSection.contains(str + "ally_shared_chat")) {
            settingsData.setAllySharedChat(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "ally_shared_chat", true));
        }
        if (configurationSection.contains(str + "join_leave")) {
            settingsData.setJoinLeave(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "join_leave", true));
        }
        if (configurationSection.contains(str + "ally_shared_home")) {
            settingsData.setAllySharedHome(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "ally_shared_home", true));
        }
        if (configurationSection.contains(str + "opened")) {
            settingsData.setOpened(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "opened", false));
        }
        if (configurationSection.contains(str + "public_homes")) {
            settingsData.setPublicHomes(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "public_homes", true));
        }
        if (configurationSection.contains(str + "receive_mail_allies")) {
            settingsData.setReceveMailAllies(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "receive_mail_allies", true));
        }
        if (configurationSection.contains(str + "receive_mail_all")) {
            settingsData.setReceiveMailAll(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "receive_mail_all", true));
        }
        if (configurationSection.contains(str + "allypvp")) {
            settingsData.setAllyPvp(v8qP8fE86HMhvNuYPFjqY(configurationSection, str + "allypvp", false));
        }
        v8qP8fE86HMhvNuYPFjqY(settingsData, configurationSection.getString(str + "json_meta"));
    }

    private static void v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet, SettingsData settingsData) {
        Integer numV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(resultSet, xPK4iFMwq01YCmQH8RT());
        if (numV8qP8fE86HMhvNuYPFjqY != null) {
            settingsData.setWarInvite(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(resultSet, kC56eBx9JJxpk5ci1gwBt());
        if (numV8qP8fE86HMhvNuYPFjqY2 != null) {
            settingsData.setAllySharedChat(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY2.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY3 = v8qP8fE86HMhvNuYPFjqY(resultSet, qsAiN92hztWv1x());
        if (numV8qP8fE86HMhvNuYPFjqY3 != null) {
            settingsData.setJoinLeave(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY3.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY4 = v8qP8fE86HMhvNuYPFjqY(resultSet, QFZ01L9tHB6TGzO0Z());
        if (numV8qP8fE86HMhvNuYPFjqY4 != null) {
            settingsData.setAllySharedHome(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY4.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY5 = v8qP8fE86HMhvNuYPFjqY(resultSet, irDB1e1cRv6qjh());
        if (numV8qP8fE86HMhvNuYPFjqY5 != null) {
            settingsData.setOpened(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY5.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY6 = v8qP8fE86HMhvNuYPFjqY(resultSet, Z8vjwPZKXveaMPoQ3B());
        if (numV8qP8fE86HMhvNuYPFjqY6 != null) {
            settingsData.setPublicHomes(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY6.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY7 = v8qP8fE86HMhvNuYPFjqY(resultSet, Zcb9oge05VyMnOUjr2o());
        if (numV8qP8fE86HMhvNuYPFjqY7 != null) {
            settingsData.setReceveMailAllies(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY7.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY8 = v8qP8fE86HMhvNuYPFjqY(resultSet, mhNUIbtr1xS11fURFOsYN());
        if (numV8qP8fE86HMhvNuYPFjqY8 != null) {
            settingsData.setReceiveMailAll(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY8.intValue()));
        }
        Integer numV8qP8fE86HMhvNuYPFjqY9 = v8qP8fE86HMhvNuYPFjqY(resultSet, uiC3vaiEcQ7vXQw());
        if (numV8qP8fE86HMhvNuYPFjqY9 != null) {
            settingsData.setAllyPvp(v8qP8fE86HMhvNuYPFjqY(numV8qP8fE86HMhvNuYPFjqY9.intValue()));
        }
        v8qP8fE86HMhvNuYPFjqY(settingsData, v8qP8fE86HMhvNuYPFjqY(resultSet, GFWKPZj8x8R6dVFyMavK1h(), (String) null));
    }

    private static void v8qP8fE86HMhvNuYPFjqY(SettingsData settingsData, String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        try {
            Optional<JSONObject> optionalV8qP8fE86HMhvNuYPFjqY = new me.ulrich.clans.qjkRaOgynIj1.RuVgd0Dnv0ddhdcWL().v8qP8fE86HMhvNuYPFjqY((Object) str).v8qP8fE86HMhvNuYPFjqY();
            if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
                settingsData.setJsonMeta(optionalV8qP8fE86HMhvNuYPFjqY);
            }
        } catch (Exception e) {
        }
    }

    private static List<HomesData> v8qP8fE86HMhvNuYPFjqY(String str) {
        ArrayList arrayList = new ArrayList();
        if (str == null || str.isEmpty()) {
            return arrayList;
        }
        for (String str2 : str.split(jadZza1ug2MHuzKIu8x())) {
            try {
                String[] strArrSplit = str2.split(cfQEGXhXRneBj4q9());
                if (strArrSplit.length >= 3) {
                    arrayList.add(new HomesData(strArrSplit[0], strArrSplit[1], strArrSplit[2], strArrSplit.length >= 4 ? Optional.of(strArrSplit[3]) : Optional.empty()));
                }
            } catch (Exception e) {
            }
        }
        return arrayList;
    }

    private static List<HomesData> v8qP8fE86HMhvNuYPFjqY(List<String> list) {
        return (List) list.stream().map(str -> {
            try {
                String[] strArrSplit = str.split(oFGXbBWMtSdRenOwQ9());
                if (strArrSplit.length >= 3) {
                    return new HomesData(strArrSplit[0], strArrSplit[1], strArrSplit[2], strArrSplit.length >= 4 ? Optional.of(strArrSplit[3]) : Optional.empty());
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<UUID> jBUuLP0sWwaPyPOmogdX7l(List<String> list) {
        return (list == null || list.isEmpty()) ? new ArrayList() : (List) list.stream().map(ZRp1tak21UvNaOVCtFx::ZwrsrwOCXRUscW6Q).filter((v0) -> {
            return Objects.nonNull(v0);
        }).distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<UUID> jBUuLP0sWwaPyPOmogdX7l(String str) {
        return (str == null || str.isEmpty()) ? new ArrayList() : (List) Arrays.stream(str.split(yqEZCuz16RXM7rM())).map(ZRp1tak21UvNaOVCtFx::ZwrsrwOCXRUscW6Q).filter((v0) -> {
            return Objects.nonNull(v0);
        }).distinct().collect(Collectors.toCollection(ArrayList::new));
    }

    private static UUID ZwrsrwOCXRUscW6Q(String str) {
        try {
            return UUID.fromString(str);
        } catch (Exception e) {
            return null;
        }
    }

    private static String v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet, String str, String str2) {
        try {
            String string = resultSet.getString(str);
            return string != null ? string : str2;
        } catch (Exception e) {
            return str2;
        }
    }

    private static int v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet, String str, int i) {
        try {
            Object object = resultSet.getObject(str);
            if (object == null) {
                return i;
            }
            return object instanceof Number ? ((Number) object).intValue() : Integer.parseInt(String.valueOf(object));
        } catch (Exception e) {
            return i;
        }
    }

    private static Integer v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet, String str) {
        try {
            Object object = resultSet.getObject(str);
            if (object == null) {
                return null;
            }
            return object instanceof Number ? Integer.valueOf(((Number) object).intValue()) : Integer.valueOf(String.valueOf(object));
        } catch (Exception e) {
            return null;
        }
    }

    private static long v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet, String str, long j) {
        try {
            Object object = resultSet.getObject(str);
            if (object == null) {
                return j;
            }
            return object instanceof Number ? ((Number) object).longValue() : Long.parseLong(String.valueOf(object));
        } catch (Exception e) {
            return j;
        }
    }

    private static double v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet, String str, double d) {
        try {
            Object object = resultSet.getObject(str);
            if (object == null) {
                return d;
            }
            return object instanceof Number ? ((Number) object).doubleValue() : Double.parseDouble(String.valueOf(object));
        } catch (Exception e) {
            return d;
        }
    }

    private static boolean v8qP8fE86HMhvNuYPFjqY(ResultSet resultSet, String str, boolean z) {
        try {
            Object object = resultSet.getObject(str);
            if (object == null) {
                return z;
            }
            if (object instanceof Boolean) {
                return ((Boolean) object).booleanValue();
            }
            if (object instanceof Number) {
                return ((Number) object).intValue() == 1;
            }
            String strValueOf = String.valueOf(object);
            if (u9LUR1VSMem1cvp2xaqGDT().equals(strValueOf)) {
                return true;
            }
            if (txHGN29dhSJMwWovsW9b1J().equals(strValueOf)) {
                return false;
            }
            return Boolean.parseBoolean(strValueOf);
        } catch (Exception e) {
            return z;
        }
    }

    private static int v8qP8fE86HMhvNuYPFjqY(ConfigurationSection configurationSection, String str, int i) {
        try {
            Object obj = configurationSection.get(str);
            if (obj == null) {
                return i;
            }
            return obj instanceof Number ? ((Number) obj).intValue() : Integer.parseInt(String.valueOf(obj));
        } catch (Exception e) {
            return i;
        }
    }

    private static long v8qP8fE86HMhvNuYPFjqY(ConfigurationSection configurationSection, String str, long j) {
        try {
            Object obj = configurationSection.get(str);
            if (obj == null) {
                return j;
            }
            return obj instanceof Number ? ((Number) obj).longValue() : Long.parseLong(String.valueOf(obj));
        } catch (Exception e) {
            return j;
        }
    }

    private static double v8qP8fE86HMhvNuYPFjqY(ConfigurationSection configurationSection, String str, double d) {
        try {
            Object obj = configurationSection.get(str);
            if (obj == null) {
                return d;
            }
            return obj instanceof Number ? ((Number) obj).doubleValue() : Double.parseDouble(String.valueOf(obj));
        } catch (Exception e) {
            return d;
        }
    }

    private static boolean v8qP8fE86HMhvNuYPFjqY(ConfigurationSection configurationSection, String str, boolean z) {
        try {
            Object obj = configurationSection.get(str);
            if (obj == null) {
                return z;
            }
            if (obj instanceof Boolean) {
                return ((Boolean) obj).booleanValue();
            }
            if (obj instanceof Number) {
                return ((Number) obj).intValue() == 1;
            }
            String strValueOf = String.valueOf(obj);
            if (OsojzEqM86dq5GkJv().equals(strValueOf)) {
                return true;
            }
            if (g18EnY8Bfalu8CDoz().equals(strValueOf)) {
                return false;
            }
            return Boolean.parseBoolean(strValueOf);
        } catch (Exception e) {
            return z;
        }
    }

    private static boolean v8qP8fE86HMhvNuYPFjqY(int i) {
        return i == 1;
    }

    private static String v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        return str != null ? str : str2;
    }

    private static CompletableFuture<List<ClanData>> iZTqZaRK5UGoe0Z(String str) {
        CompletableFuture<List<ClanData>> completableFuture = new CompletableFuture<>();
        Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l(resultSet -> {
            ArrayList arrayList = new ArrayList();
            try {
                while (resultSet.next()) {
                    ClanData clanDataV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(resultSet);
                    if (clanDataV8qP8fE86HMhvNuYPFjqY != null) {
                        v8qP8fE86HMhvNuYPFjqY(clanDataV8qP8fE86HMhvNuYPFjqY);
                        arrayList.add(clanDataV8qP8fE86HMhvNuYPFjqY);
                    }
                }
            } catch (Exception e) {
                completableFuture.completeExceptionally(e);
                return;
            }
            completableFuture.complete(arrayList);
        }, str);
        return completableFuture;
    }

    private static String ZwrsrwOCXRUscW6Q() {
        return Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(cPWLyN8YGJWgJzGcvH29js());
    }

    private static void v8qP8fE86HMhvNuYPFjqY(ClanData clanData) {
        Clans.getClanCore().getClanManager().CDW4Fj1iwdIXEOqWjiJSR().put(clanData.getId(), clanData);
    }

    private static String gXU6F6DaPVKIEOyIDZwSX(byte[] bArr) {
        return "";
    }

    private static String TUM614GdRCApaNS7pbfF() {
        return "id";
    }

    private static String qc2RnjAfOogc3k8eD() {
        return "members";
    }

    private static String J3bQv1HZloFQYCG() {
        return "mods";
    }

    private static String rjCuOXh4xPV7ugr() {
        return "banned";
    }

    private static String IAKhWhy2obdOzatiBWFOup() {
        return "rival";
    }

    private static String iYk1KyNtpvhpSPxcMGlM() {
        return "ally";
    }

    private static String IksLLGSa9j8xhsvc567EQ() {
        return "home";
    }

    private static String WkbwPKokUjOBt9l() {
        return "kills";
    }

    private static String kp2TeTvjQDkQFQm9j() {
        return "deaths";
    }

    private static String uGg1lTl9CmW6CfR2EUT() {
        return "souls";
    }

    private static String ELHiaW3xHBJCOg2() {
        return "member_joined";
    }

    private static String NAz8JqCfuvo9WoZieda() {
        return "member_left";
    }

    private static String fzkaTMXRmcvmVjRzY668() {
        return "war_win";
    }

    private static String pKJgMNWxMfhkSrUwirD() {
        return "war_lose";
    }

    private static String FSfFeHlkLZyeUCE2b() {
        return "tag_changed";
    }

    private static String IJrAypbMo4cSNrXm() {
        return "glad_win";
    }

    private static String JWi1bSE44AL4Tz() {
        return "glad_lose";
    }

    private static String cL73EOivrcp5Bcpg() {
        return "league_win";
    }

    private static String E9sqbjQSXHVomzWqPdx() {
        return "league_lose";
    }

    private static String rAFZhNH1aaaphuzOIHtxw() {
        return "quest_points";
    }

    private static String qb7J21NtLcJ6BhSpVx() {
        return "quest_finished";
    }

    private static String iUTG0q1eOzwAHYzr3M() {
        return "extra_chest";
    }

    private static String m6qz9TCE5doxsRskB() {
        return "verified";
    }

    private static String vH5XuySfRYCm0L5coZWTZt() {
        return "ff";
    }

    private static String GViJvl0T0dNFtTPl() {
        return "kdr";
    }

    private static String nIfbQpXgyDT0zFfdC() {
        return "creation_date";
    }

    private static String ayFz1hG4WfkzmE() {
        return "bank";
    }

    private static String gxGLML2oiqCarGwTWC0T() {
        return "level";
    }

    private static String eUBRT2Vws3iyMqq() {
        return "maxlevel";
    }

    private static String v0ftVHgx4sBx0zIyFA() {
        return "extra_slots";
    }

    private static String A2VyptYjtPAs7vf2() {
        return "tag";
    }

    private static String FhlNk18e8webhbxLg3() {
        return "desc";
    }

    private static String J30lYMUByeQLRI() {
        return "leader";
    }

    private static String oo13ceSBf1kc9n() {
        return "tag_raw";
    }

    private static String y0V3nISJCsZP21D() {
        return "banner";
    }

    private static String x1BgoXf8DZJjwWW() {
        return "patent";
    }

    private static String aAUr7xIoBk7Op8NXgFQlc() {
        return "webhook";
    }

    private static String xPK4iFMwq01YCmQH8RT() {
        return "war_invite";
    }

    private static String kC56eBx9JJxpk5ci1gwBt() {
        return "ally_shared_chat";
    }

    private static String qsAiN92hztWv1x() {
        return "join_leave";
    }

    private static String QFZ01L9tHB6TGzO0Z() {
        return "ally_shared_home";
    }

    private static String irDB1e1cRv6qjh() {
        return "opened";
    }

    private static String Z8vjwPZKXveaMPoQ3B() {
        return "public_homes";
    }

    private static String Zcb9oge05VyMnOUjr2o() {
        return "receive_mail_allies";
    }

    private static String mhNUIbtr1xS11fURFOsYN() {
        return "receive_mail_all";
    }

    private static String uiC3vaiEcQ7vXQw() {
        return "allypvp";
    }

    private static String GFWKPZj8x8R6dVFyMavK1h() {
        return "json_meta";
    }

    private static String jadZza1ug2MHuzKIu8x() {
        return ";";
    }

    private static String cfQEGXhXRneBj4q9() {
        return "::";
    }

    private static String yqEZCuz16RXM7rM() {
        return "\\|";
    }

    private static String u9LUR1VSMem1cvp2xaqGDT() {
        return "1";
    }

    private static String txHGN29dhSJMwWovsW9b1J() {
        return "0";
    }

    private static String OsojzEqM86dq5GkJv() {
        return "1";
    }

    private static String g18EnY8Bfalu8CDoz() {
        return "0";
    }

    private static String cPWLyN8YGJWgJzGcvH29js() {
        return "Storage.databases.clan_table";
    }

    private static String oFGXbBWMtSdRenOwQ9() {
        return "::";
    }

    private static String VbMhW3RHDKZcxrvBUY() {
        return "data";
    }
}
