package me.module.home.manager;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.module.home.Home;
import me.module.home.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.HomesData;
import me.ulrich.clans.manager.utils.Locals;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/c.class */
public class c {
    private static byte[] __aes_key_g2VZqAHT = {(byte) 201, (byte) 183, (byte) 158, (byte) 92, (byte) 22, (byte) 20, (byte) 155, (byte) 148, (byte) 125, (byte) 139, (byte) 1, (byte) 6, (byte) 154, (byte) 66, (byte) 143, (byte) 28, (byte) 205, (byte) 164, (byte) 213, (byte) 75, (byte) 46, (byte) 148, (byte) 99, (byte) 172, (byte) 89, (byte) 61, (byte) 47, (byte) 36, (byte) 166, (byte) 69, (byte) 165, (byte) 66};
    private static byte[] __aes_iv_ygqSOo0G = {(byte) 202, (byte) 148, (byte) 199, (byte) 200, (byte) 23, (byte) 196, (byte) 109, (byte) 243, (byte) 125, (byte) 145, (byte) 205, (byte) 181, (byte) 72, (byte) 165, (byte) 152, (byte) 70};
    private static String __s_cache_A3k8pRe3_0;
    private static String __s_cache_YBX5UTjG_1;
    private static String __s_cache_d29gZTw9_2;
    private static String __s_cache_J31cW4aC_3;
    private static String __s_cache_6DhdX5Vu_4;
    private static String __s_cache_T4a4aA9c_5;
    private static String __s_cache_QEvs4nKy_6;
    private static String __s_cache_ZXL0uNV3_7;
    private static String __s_cache_SZqBDAZM_8;
    private static String __s_cache_C3xmhYJO_9;
    private static String __s_cache_3viKdFK9_10;
    private static String __s_cache_TsGsSyP3_11;
    private static String __s_cache_uDnYtWaK_12;
    private static String __s_cache_dcEXRtHB_13;
    private static String __s_cache_5ZFVX7wW_14;

    public String a(Player player, String str) {
        return a(player.getUniqueId(), str);
    }

    public String a(UUID uuid, String str) {
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return str;
        }
        if (str.equals("limit_home")) {
            return playerClan.isPresent() ? String.valueOf(Home.getModuleCore().e().homeCount(playerClan.get())) : "0";
        }
        if (str.equals("home")) {
            return (!playerClan.isPresent() || playerClan.get().getHome() == null) ? "0" : String.valueOf(playerClan.get().getHome().size());
        }
        if (str.equals("homes_amount")) {
            return (!playerClan.isPresent() || playerClan.get().getHome() == null) ? "0" : String.valueOf(playerClan.get().getHome().size());
        }
        if (!str.startsWith("home:") || !playerClan.isPresent()) {
            return null;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 3) {
            return null;
        }
        String lowerCase = strArrSplit[2].toLowerCase();
        Matcher matcher = Pattern.compile("\\{([^}]*)\\}").matcher(strArrSplit[1]);
        if (!matcher.find()) {
            return null;
        }
        try {
            Optional<HomesData> homeData = Home.getModuleCore().e().getHomeData(playerClan.get().getLeader(), matcher.group(1));
            if (!homeData.isPresent()) {
                return null;
            }
            if (lowerCase.equals("server")) {
                return homeData.get().getServer();
            }
            if (lowerCase.equals("name")) {
                return homeData.get().getName();
            }
            if (lowerCase.equals("world")) {
                return new Locals().decodeLocation(homeData.get().getLoc()).getWorld().getName();
            }
            if (lowerCase.equals("location")) {
                Location locationDecodeLocation = new Locals().decodeLocation(homeData.get().getLoc());
                return locationDecodeLocation.getWorld().getName() + ": " + locationDecodeLocation.getBlockX() + "/" + locationDecodeLocation.getBlockY() + "/" + locationDecodeLocation.getBlockZ();
            }
            if (lowerCase.equals("password")) {
                return homeData.get().getPassword().isPresent() ? homeData.get().getPassword().get() : Home.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.TRANSLACTION_NONE);
            }
            if (lowerCase.equals("has_passwd")) {
                return Home.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.valueOf("TRANSLACTION_NOYES_" + String.valueOf(homeData.get().getPassword().isPresent()).toUpperCase()));
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    private static String __unused_353() {
        return "limit_home";
    }

    private static String __unused_354() {
        return "0";
    }

    private static String __unused_355() {
        return "home";
    }

    private static String __unused_356() {
        return "0";
    }

    private static String __unused_357() {
        return "homes_amount";
    }

    private static String __unused_358() {
        return "0";
    }

    private static String __unused_359() {
        return "home:";
    }

    private static String __unused_360() {
        return ":";
    }

    private static String __unused_361() {
        return "\\{([^}]*)\\}";
    }

    private static String __unused_362() {
        return "server";
    }

    private static String __unused_363() {
        return "name";
    }

    private static String __unused_364() {
        return "world";
    }

    private static String __unused_365() {
        return "location";
    }

    private static String __unused_366() {
        return "password";
    }

    private static String __unused_367() {
        return "has_passwd";
    }
}
