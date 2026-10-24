package me.module.logger.manager;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.module.logger.Logger;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.LoggerData;
import me.ulrich.clans.manager.utils.Times;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/d.class */
public class d {
    private static byte[] __aes_key_xsbazm28 = {(byte) 216, (byte) 189, (byte) 51, (byte) 62, (byte) 153, (byte) 47, (byte) 40, (byte) 223, (byte) 53, (byte) 69, (byte) 246, (byte) 73, (byte) 110, (byte) 167, (byte) 205, (byte) 26, (byte) 210, (byte) 7, (byte) 58, (byte) 45, (byte) 238, (byte) 38, (byte) 222, (byte) 50, (byte) 124, (byte) 239, (byte) 234, (byte) 209, (byte) 20, (byte) 174, (byte) 238, (byte) 129};
    private static byte[] __aes_iv_PCiRD7f0 = {(byte) 15, (byte) 145, (byte) 93, (byte) 21, (byte) 251, (byte) 136, (byte) 253, (byte) 40, (byte) 186, (byte) 145, (byte) 159, (byte) 81, (byte) 115, (byte) 78, (byte) 228, (byte) 222};
    private static String __s_cache_ezU4o8Dd_0;
    private static String __s_cache_Rd8gmqPN_1;
    private static String __s_cache_Vz3N01mx_2;
    private static String __s_cache_V4voca0s_3;
    private static String __s_cache_3GvRfDoM_4;
    private static String __s_cache_8cMfYM3Z_5;
    private static String __s_cache_Ww0VrC3V_6;
    private static String __s_cache_VdzUK8EF_7;
    private static String __s_cache_TmeBfsl8_8;
    private static String __s_cache_2lcz0A8z_9;
    private static String __s_cache_Yozn1gFf_10;
    private static String __s_cache_F6M6yGhm_11;
    private static String __s_cache_8ROdEmmh_12;

    public String a(Player player, String str) {
        return a(player.getUniqueId(), str);
    }

    public String a(UUID uuid, String str) {
        Optional<ClanData> playerClan = Logger.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return str;
        }
        if (str.equals("logger_amount")) {
            return playerClan.isPresent() ? String.valueOf(Logger.getModuleCore().e().getClanLogger(playerClan.get().getId()).size()) : "0";
        }
        if (!str.startsWith("logger:") || !playerClan.isPresent()) {
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
            Optional<LoggerData> pluginLogger = Logger.getModuleCore().e().getPluginLogger(playerClan.get().getId(), UUID.fromString(matcher.group(1)));
            if (!pluginLogger.isPresent()) {
                return null;
            }
            if (lowerCase.equals("text")) {
                return pluginLogger.get().getText();
            }
            if (lowerCase.equals("plugin")) {
                return pluginLogger.get().getPlugin();
            }
            if (lowerCase.equals("material")) {
                return pluginLogger.get().getMaterial().name();
            }
            if (lowerCase.equals("date")) {
                return new Times().unixToDate(Long.valueOf(pluginLogger.get().getDate() * 1000), Logger.getModuleCore().c().i().getString("Config.date_format_short"));
            }
            if (!lowerCase.equals("expires")) {
                return null;
            }
            int date = (int) ((pluginLogger.get().getDate() + ((long) (60 * Logger.getModuleCore().c().i().getInt("Config.Logger.time_expires")))) - (System.currentTimeMillis() / 1000));
            return date < 1 ? "0s" : e.a(date);
        } catch (Exception e) {
            return null;
        }
    }

    private static String __unused_116() {
        return "logger_amount";
    }

    private static String __unused_117() {
        return "0";
    }

    private static String __unused_118() {
        return "logger:";
    }

    private static String __unused_119() {
        return ":";
    }

    private static String __unused_120() {
        return "\\{([^}]*)\\}";
    }

    private static String __unused_121() {
        return "text";
    }

    private static String __unused_122() {
        return "plugin";
    }

    private static String __unused_123() {
        return "material";
    }

    private static String __unused_124() {
        return "date";
    }

    private static String __unused_125() {
        return "Config.date_format_short";
    }

    private static String __unused_126() {
        return "expires";
    }

    private static String __unused_127() {
        return "Config.Logger.time_expires";
    }

    private static String __unused_128() {
        return "0s";
    }
}
