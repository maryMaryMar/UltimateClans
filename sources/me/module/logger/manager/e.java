package me.module.logger.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.module.logger.Logger;
import me.module.logger.commands.LoggerCommand;
import me.module.logger.manager.EnumFiles.Lang;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.LoggerData;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.interfaces.DiscordModuleAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/e.class */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<UUID, List<LoggerData>> f129a;
    private static String __s_cache_9JMI8l40_0;
    private static String __s_cache_NfYxr8C5_1;
    private static String __s_cache_zdah48sm_2;
    private static String __s_cache_RXEU4zOB_3;
    private static String __s_cache_WIIuJjXB_4;
    private static String __s_cache_cWw6grcj_5;
    private static String __s_cache_HorH3wHU_6;
    private static String __s_cache_bf6M8RIB_7;
    private static String __s_cache_0eNYtFrh_8;
    private static String __s_cache_ZWSC0pBx_9;
    private static String __s_cache_F4yCEKnU_10;
    private static String __s_cache_Y57sSpw0_11;
    private static String __s_cache_HeWOwjbV_12;
    private static String __s_cache_su3FlpE6_13;
    private static String __s_cache_zp0YMwwP_14;
    private static String __s_cache_xfRjWIgr_15;
    private static String __s_cache_KM3JxGM0_16;
    private static String __s_cache_GqDm7sLl_17;
    private static String __s_cache_mOTZpHo3_18;
    private static String __s_cache_yDm9kmoa_19;
    private static String __s_cache_Ej6azHAk_20;
    private static String __s_cache_1gwMP8pO_21;
    private static String __s_cache_5vI3DsNC_22;
    private static String __s_cache_GHj2BKHw_23;
    private static String __s_cache_Txd29yVi_24;
    private static String __s_cache_GIWG1Un6_25;
    private static String __s_cache_Jt5PClcd_26;
    private static String __s_cache_lKGb4i3d_27;
    private static String __s_cache_ZVEjpJ0Q_28;
    private static String __s_cache_O54Ab76o_29;
    private static String __s_cache_HKE2qahH_30;
    private static String __s_cache_Z7DmfpiP_31;
    private static String __s_cache_vtIcNbzQ_32;
    private static String __s_cache_PP5B2tKB_33;
    private static String __s_cache_A3u3dGSv_34;
    private static String __s_cache_NQ0dIfZC_35;
    private static String __s_cache_r5AxWH0P_36;
    private static String __s_cache_3snambnO_37;
    private static String __s_cache_lu5mfW6Z_38;
    private static String __s_cache_0RNCCtZA_39;
    private static String __s_cache_dKE6bkjo_40;
    private static String __s_cache_mTEkfHlW_41;
    private static String __s_cache_78FTa5oW_42;
    private static String __s_cache_ojJm5aiw_43;
    private static String __s_cache_bGcDJMIR_44;
    private static String __s_cache_vCdVMWL6_45;
    private static String __s_cache_U6NDF2o4_46;
    private static String __s_cache_Dlp2oOeJ_47;
    private static String __s_cache_iakBkIii_48;
    private static String __s_cache_KtK9qjnx_49;
    private static String __s_cache_D8Tx941k_50;
    private static String __s_cache_Bq54o79G_51;
    private static String __s_cache_g6gwD3o6_52;
    private static String __s_cache_GMPY2mS6_53;
    private static String __s_cache_B9nt07Ht_54;
    private static String __s_cache_OWBdcWnk_55;
    private static String __s_cache_dBOx1DDC_56;
    private static String __s_cache_mREbnCzA_57;
    private static String __s_cache_n8JSnhpl_58;
    private static String __s_cache_6IUkmkGq_59;
    private static String __s_cache_j13PveSo_60;
    private static String __s_cache_t4eE2P4P_61;
    private static String __s_cache_89PPUTQb_62;
    private static String __s_cache_FVHxbPh2_63;
    private static String __s_cache_bGL3ONEF_64;
    private static byte[] __aes_key_cQNxnupP = {(byte) 122, (byte) 113, (byte) 239, (byte) 236, (byte) 207, (byte) 182, (byte) 71, (byte) 2, (byte) 80, (byte) 18, (byte) 54, (byte) 9, (byte) 23, (byte) 110, (byte) 75, (byte) 123, (byte) 183, (byte) 88, (byte) 232, (byte) 154, (byte) 249, (byte) 116, (byte) 87, (byte) 179, (byte) 247, (byte) 83, (byte) 208, (byte) 11, (byte) 248, (byte) 128, (byte) 107, (byte) 99};
    private static byte[] __aes_iv_oroCSlc0 = {(byte) 99, (byte) 246, (byte) 198, (byte) 143, (byte) 75, (byte) 34, (byte) 153, (byte) 181, (byte) 236, (byte) 254, (byte) 18, (byte) 254, (byte) 152, (byte) 25, (byte) 154, (byte) 155};
    private static final Pattern b = Pattern.compile("(%)(uclans_)(.+?)(%)");

    public static void a() {
        f129a = new ConcurrentHashMap<>();
        e();
        d();
        f();
    }

    public static ConcurrentHashMap<UUID, List<LoggerData>> b() {
        return f129a;
    }

    public static void a(LoggerData loggerData) {
        me.module.logger.manager.a.a.a.e.a(loggerData);
    }

    public static void b(LoggerData loggerData) {
        me.module.logger.manager.a.a.a.b.a(loggerData);
    }

    public static void a(UUID uuid) {
        me.module.logger.manager.a.a.a.d.a(uuid);
    }

    public static void b(UUID uuid) {
        me.module.logger.manager.a.a.a.a.a(uuid);
    }

    public static void c() {
        me.module.logger.manager.a.a.a.c.a();
    }

    public static boolean c(UUID uuid) {
        return b().containsKey(uuid);
    }

    public static List<LoggerData> d(UUID uuid) {
        return b().containsKey(uuid) ? b().get(uuid) : new ArrayList();
    }

    public static List<LoggerData> a(UUID uuid, ClanEnum.LoggerTime loggerTime) {
        ArrayList arrayList = new ArrayList();
        if (b().containsKey(uuid)) {
            b().get(uuid).forEach(loggerData -> {
                if (!a(loggerTime, loggerData.getDate()) || arrayList.contains(loggerData)) {
                    return;
                }
                arrayList.add(loggerData);
            });
        }
        Collections.sort(arrayList, (loggerData2, loggerData3) -> {
            return new Date(loggerData3.getDate()).compareTo(new Date(loggerData2.getDate()));
        });
        return arrayList;
    }

    public static List<LoggerData> a(UUID uuid, String str) {
        if (!c(uuid)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(b().get(uuid));
        arrayList.removeIf(loggerData -> {
            return !loggerData.getPlugin().equalsIgnoreCase(str);
        });
        return arrayList;
    }

    public static Optional<LoggerData> a(UUID uuid, UUID uuid2) {
        return c(uuid) ? new ArrayList(b().get(uuid)).stream().filter(loggerData -> {
            return loggerData.getId().equals(uuid2);
        }).findFirst() : Optional.empty();
    }

    public static boolean b(UUID uuid, UUID uuid2) {
        if (!c(uuid)) {
            return false;
        }
        boolean z = false;
        Iterator<LoggerData> it = b().get(uuid).iterator();
        while (it.hasNext()) {
            LoggerData next = it.next();
            if (next.getId().equals(uuid2)) {
                it.remove();
                b(next);
                z = true;
                break;
            }
        }
        return z;
    }

    public static boolean b(UUID uuid, String str) {
        if (!c(uuid)) {
            return false;
        }
        Iterator<LoggerData> it = b().get(uuid).iterator();
        it.forEachRemaining(loggerData -> {
            if (loggerData.getPlugin().equalsIgnoreCase(str)) {
                it.remove();
                b(loggerData);
            }
        });
        return false;
    }

    public static boolean e(UUID uuid) {
        try {
            if (!c(uuid)) {
                return false;
            }
            b().remove(uuid);
            b(uuid);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(UUID uuid, String str, String str2, Material material) {
        try {
            UUID uuidRandomUUID = UUID.randomUUID();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            if (!Logger.getModuleCore().c().i().getBoolean("Config.Logger.enable_colors")) {
                str = Logger.a().getColorAPI().removeColor(str);
            }
            if (material == null) {
                try {
                    material = Material.valueOf(Logger.getModuleCore().c().i().getString("Config.Logger.plugin_material"));
                } catch (Exception e) {
                    material = Material.STONE;
                }
            }
            LoggerData loggerData = new LoggerData(uuidRandomUUID, uuid, str, jCurrentTimeMillis, str2, material);
            if (b().containsKey(uuid)) {
                b().get(uuid).add(loggerData);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(loggerData);
                b().put(uuid, arrayList);
            }
            a(loggerData);
            Optional<DiscordModuleAPI> discordAPI = Logger.a().getIntegrationAPI().getDiscordAPI();
            if (!discordAPI.isPresent() || !discordAPI.get().isConnectedClan(uuid)) {
                return true;
            }
            discordAPI.get().sendDiscordNotification(uuid, str);
            return true;
        } catch (Exception e2) {
            return false;
        }
    }

    public static boolean a(ClanEnum.LoggerTime loggerTime, long j) {
        if (loggerTime.equals(ClanEnum.LoggerTime.ALL)) {
            return true;
        }
        TimeZone timeZone = TimeZone.getTimeZone(Logger.getModuleCore().c().i().getString("Config.timezone"));
        Calendar calendar = Calendar.getInstance(timeZone);
        Calendar calendar2 = Calendar.getInstance(timeZone);
        calendar2.setTimeInMillis(j * 1000);
        if (loggerTime.equals(ClanEnum.LoggerTime.DAILY)) {
            return calendar.get(6) == calendar2.get(6);
        }
        if (loggerTime.equals(ClanEnum.LoggerTime.WEEKLY)) {
            return calendar.get(4) == calendar2.get(4);
        }
        if (loggerTime.equals(ClanEnum.LoggerTime.MONTHLY)) {
            return calendar.get(2) == calendar2.get(2);
        }
        return loggerTime.equals(ClanEnum.LoggerTime.YEARLY) && calendar.get(1) == calendar2.get(1);
    }

    public static String c(UUID uuid, String str) {
        String strA;
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            if (!str.contains("%") && (strA = Logger.getModuleCore().j().a(uuid, str)) != null) {
                return strA;
            }
            Matcher matcher = b.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strA2 = Logger.getModuleCore().j().a(uuid, matcher.group(3));
                if (strA2 != null) {
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strA2));
                } else {
                    matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(matcher.group(0)));
                }
            }
            matcher.appendTail(stringBuffer);
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    private static CommandData_show a(String str, String str2) {
        HashMap map = new HashMap();
        String str3 = "COMMANDS_" + str + "_" + str2 + "_";
        Logger.getModuleCore().c().e().forEach((str4, enumConfiguration) -> {
            try {
                map.put(str4, new CommandData_show(a(enumConfiguration.getString(Lang.valueOf(str3 + "show"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "success"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "error"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Logger.getModuleCore().c().a(Optional.empty()));
        if (commandData_show == null) {
            commandData_show = (CommandData_show) map.get("EN");
        }
        if (commandData_show == null && !map.isEmpty()) {
            commandData_show = (CommandData_show) map.values().iterator().next();
        }
        if (commandData_show == null) {
            commandData_show = new CommandData_show("", "", "", "");
        }
        CommandData_show commandData_show2 = new CommandData_show(commandData_show.getOn_help(), commandData_show.getOn_success(), commandData_show.getOn_error(), commandData_show.getOn_usage());
        MessageUtils.registerLocalizedCommandShow(commandData_show2, map);
        return commandData_show2;
    }

    public static void d() {
        Logger.a().getCommandAPI().unRegisterCommand("logger");
        Logger.a().getCommandAPI().unRegisterCommand(Logger.getModuleCore().c().j().getString("Commands.player.alias"));
        Logger.a().getCommandAPI().registerCommand("logger", new LoggerCommand());
        Logger.a().getCommandAPI().registerCommand(Logger.getModuleCore().c().j().getString("Commands.player.alias"), new LoggerCommand());
        Logger.a().getCommandAPI().getCommandAliases().put("logger", Logger.getModuleCore().c().j().getString("Commands.player.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("view", "clear")) {
                if (Logger.getModuleCore().c().j().contains("Commands.logger." + str)) {
                    if (!Logger.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Logger.a().getCommandAPI().getCommandAliases().put(str, Logger.getModuleCore().c().j().getString("Commands.logger." + str + ".aliases"));
                    }
                    map.put(str, a("logger", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Logger.a().getCommandAPI().insertCommand("logger", Logger.getModuleCore().c().j().getString("Commands.player.permission"), Logger.getModuleCore().c().j().getString("Commands.player.alias"), Logger.getModuleCore().c().j().getDouble("Commands.player.value"), Logger.getModuleCore().c().j().getInt("Commands.player.cooldown"), a("logger", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Logger.getModuleCore().c().j().getStringList("Commands.player.disabled_worlds"), Logger.getModuleCore().c().j().getStringList("Commands.player.disabled_regions")));
    }

    public static void e() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Logger.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Logger.getModuleCore().c().i().contains("Config.Icon.mimeslots")) {
                if (Logger.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Logger.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Logger.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Logger.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Logger.getModuleCore().c().i().getIntegerList("Config.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Logger.getModuleCore().c().i().contains("Config.Icon.left_click_action")) {
                Logger.getModuleCore().c().i().getStringList("Config.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(a(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Logger.getModuleCore().c().i().contains("Config.Icon.right_click_action")) {
                Logger.getModuleCore().c().i().getStringList("Config.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(a(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Logger.getModuleCore().c().e().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Logger.getModuleCore().c().a(Optional.empty());
        map.put("module_logger_item", new GuiItemsData("clan_home", Logger.getModuleCore().c().i().getString("Config.Icon.click_sound"), Logger.getModuleCore().c().i().getString("Config.Icon.material"), 1, Logger.getModuleCore().c().i().getBoolean("Config.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Clan Logger.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Logger.getModuleCore().c().i().getString("Config.Icon.texture"), new NbtData(Logger.getModuleCore().c().i().getStringList("Config.Icon.nbt.string"), Logger.getModuleCore().c().i().getInt("Config.Icon.model")), Logger.getModuleCore().c().i().getInt("Config.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Logger.a().getGuiAPI().registerLocalizedInsertItem("General", "module_logger_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void f() {
        ConfigurationSection configurationSection = Logger.getModuleCore().c().i().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Logger.getModuleCore().c().i().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Logger.getModuleCore().c().i().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Logger.getModuleCore().c().i().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Logger.a().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Logger.a().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }

    private static String a(String str) {
        return Logger.a().getCommandAPI().replaceCmd(Logger.a().getCommandAPI().replaceMainCmd(str));
    }

    public static String a(long j) {
        int days = (int) TimeUnit.SECONDS.toDays(j);
        long hours = TimeUnit.SECONDS.toHours(j) - ((long) (days * 24));
        long minutes = TimeUnit.SECONDS.toMinutes(j) - (TimeUnit.SECONDS.toHours(j) * 60);
        long seconds = TimeUnit.SECONDS.toSeconds(j) - (TimeUnit.SECONDS.toMinutes(j) * 60);
        StringBuilder sb = new StringBuilder();
        if (days > 0) {
            if (days >= 7) {
                return "week+";
            }
            sb.append(String.format("%02d", Integer.valueOf(days)) + "d ");
        }
        if (hours > 0) {
            sb.append(String.format("%02d", Long.valueOf(hours)) + ":");
        }
        return sb.toString() + String.format("%02d", Long.valueOf(minutes)) + ":" + String.format("%02d", Long.valueOf(seconds));
    }

    private static String __unused_51() {
        return "Config.Logger.enable_colors";
    }

    private static String __unused_52() {
        return "Config.Logger.plugin_material";
    }

    private static String __unused_53() {
        return "Config.timezone";
    }

    private static String __unused_54() {
        return "%";
    }

    private static String __unused_55() {
        return "EN";
    }

    private static String __unused_56() {
        return "logger";
    }

    private static String __unused_57() {
        return "Commands.player.alias";
    }

    private static String __unused_58() {
        return "logger";
    }

    private static String __unused_59() {
        return "Commands.player.alias";
    }

    private static String __unused_60() {
        return "logger";
    }

    private static String __unused_61() {
        return "Commands.player.alias";
    }

    private static String __unused_62() {
        return "view";
    }

    private static String __unused_63() {
        return "clear";
    }

    private static String __unused_64() {
        return "logger";
    }

    private static String __unused_65() {
        return "logger";
    }

    private static String __unused_66() {
        return "Commands.player.permission";
    }

    private static String __unused_67() {
        return "Commands.player.alias";
    }

    private static String __unused_68() {
        return "Commands.player.value";
    }

    private static String __unused_69() {
        return "Commands.player.cooldown";
    }

    private static String __unused_70() {
        return "logger";
    }

    private static String __unused_71() {
        return "help";
    }

    private static String __unused_72() {
        return "Commands.player.disabled_worlds";
    }

    private static String __unused_73() {
        return "Commands.player.disabled_regions";
    }

    private static String __unused_74() {
        return "General";
    }

    private static String __unused_75() {
        return "General";
    }

    private static String __unused_76() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_77() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_78() {
        return "ALL";
    }

    private static String __unused_79() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_80() {
        return "TOP";
    }

    private static String __unused_81() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_82() {
        return "BOTTOM";
    }

    private static String __unused_83() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_84() {
        return "BORDER";
    }

    private static String __unused_85() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_86() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_87() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_88() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_89() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_90() {
        return "EN";
    }

    private static String __unused_91() {
        return "<green>Clan Logger.";
    }

    private static String __unused_92() {
        return "EN";
    }

    private static String __unused_93() {
        return "module_logger_item";
    }

    private static String __unused_94() {
        return "clan_home";
    }

    private static String __unused_95() {
        return "Config.Icon.click_sound";
    }

    private static String __unused_96() {
        return "Config.Icon.material";
    }

    private static String __unused_97() {
        return "Config.Icon.glow";
    }

    private static String __unused_98() {
        return "Config.Icon.texture";
    }

    private static String __unused_99() {
        return "Config.Icon.nbt.string";
    }

    private static String __unused_100() {
        return "Config.Icon.model";
    }

    private static String __unused_101() {
        return "Config.Icon.slot";
    }

    private static String __unused_102() {
        return "General";
    }

    private static String __unused_103() {
        return "module_logger_item";
    }

    private static String __unused_104() {
        return "General";
    }

    private static String __unused_105() {
        return "General";
    }

    private static String __unused_106() {
        return "Config.Permissions";
    }

    private static String __unused_107() {
        return "-";
    }

    private static String __unused_108() {
        return ".";
    }

    private static String __unused_109() {
        return "-";
    }

    private static String __unused_110() {
        return "week+";
    }

    private static String __unused_111() {
        return "%02d";
    }

    private static String __unused_112() {
        return "%02d";
    }

    private static String __unused_113() {
        return "%02d";
    }

    private static String __unused_114() {
        return "%02d";
    }

    private static String __unused_115() {
        return "(%)(uclans_)(.+?)(%)";
    }
}
