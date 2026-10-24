package me.module.mail.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.module.mail.Mail;
import me.module.mail.commands.MailCommand;
import me.module.mail.events.ClanMailSendEvent;
import me.module.mail.manager.EnumFiles.Lang;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.MailData;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/f.class */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<UUID, List<MailData>> f139a;
    private static String __s_cache_MRRtLGLk_0;
    private static String __s_cache_Ja1qTy6U_1;
    private static String __s_cache_f0vOA3yE_2;
    private static String __s_cache_v7T0QpgH_3;
    private static String __s_cache_mv4pk9sB_4;
    private static String __s_cache_FNmpzBwH_5;
    private static String __s_cache_VEZb3GTP_6;
    private static String __s_cache_WHz9dkQk_7;
    private static String __s_cache_SJUXLgMR_8;
    private static String __s_cache_TlxlizO5_9;
    private static String __s_cache_nEX233gs_10;
    private static String __s_cache_es9yELKM_11;
    private static String __s_cache_DsIiy5dd_12;
    private static String __s_cache_X2DU9Sjo_13;
    private static String __s_cache_UlskBnmj_14;
    private static String __s_cache_Kt1batdg_15;
    private static String __s_cache_xSmRFeCY_16;
    private static String __s_cache_RZIy6qSh_17;
    private static String __s_cache_ieFsymeY_18;
    private static String __s_cache_5Uy0eqnd_19;
    private static String __s_cache_2bAr4MsQ_20;
    private static String __s_cache_sBkr73Wv_21;
    private static String __s_cache_iCjXGLkX_22;
    private static String __s_cache_daF3eMHS_23;
    private static String __s_cache_7OdLbgdH_24;
    private static String __s_cache_OI2AuXEe_25;
    private static String __s_cache_GJ7pUWux_26;
    private static String __s_cache_1oY17TLE_27;
    private static String __s_cache_BjJgfNq4_28;
    private static String __s_cache_uLIlq4Jg_29;
    private static String __s_cache_YpqOKx0o_30;
    private static String __s_cache_bhNKFD9G_31;
    private static String __s_cache_49kTD6Qo_32;
    private static String __s_cache_8DjOqBkp_33;
    private static String __s_cache_5SYnFRuf_34;
    private static String __s_cache_61RmPl4A_35;
    private static String __s_cache_YSYdvmbN_36;
    private static String __s_cache_5a6Ukxvs_37;
    private static String __s_cache_Eu3MWSUK_38;
    private static String __s_cache_5XV4J7BW_39;
    private static String __s_cache_otN1xCOi_40;
    private static String __s_cache_c1fcvJWw_41;
    private static String __s_cache_ZHzAjS0z_42;
    private static String __s_cache_M5f25ztW_43;
    private static String __s_cache_yvbZJjnj_44;
    private static String __s_cache_3qQOXFIl_45;
    private static String __s_cache_OMwOvWXY_46;
    private static String __s_cache_ydwCMR0O_47;
    private static String __s_cache_r3yN5eRy_48;
    private static String __s_cache_izEh8hih_49;
    private static String __s_cache_LrgsaVFz_50;
    private static String __s_cache_gmQnuHm7_51;
    private static String __s_cache_WjTzrjEz_52;
    private static String __s_cache_rInzJNGG_53;
    private static String __s_cache_jIZ9dHMb_54;
    private static String __s_cache_6UKl0lup_55;
    private static String __s_cache_3JMm6LxX_56;
    private static String __s_cache_QRlUeuKK_57;
    private static String __s_cache_ZOcSJ6D9_58;
    private static String __s_cache_ZgPQRgfn_59;
    private static String __s_cache_dcXCDVuS_60;
    private static String __s_cache_k3jFRAWO_61;
    private static String __s_cache_dXwQLpjZ_62;
    private static String __s_cache_782cLJ6n_63;
    private static byte[] __aes_key_n7mtBipE = {(byte) 225, (byte) 83, (byte) 98, (byte) 9, (byte) 149, (byte) 27, (byte) 71, (byte) 114, (byte) 120, (byte) 149, (byte) 20, (byte) 0, (byte) 48, (byte) 123, (byte) 218, (byte) 25, (byte) 188, (byte) 109, (byte) 32, (byte) 172, (byte) 16, (byte) 172, (byte) 174, (byte) 32, (byte) 102, (byte) 253, (byte) 14, (byte) 194, (byte) 158, (byte) 70, (byte) 51, (byte) 27};
    private static byte[] __aes_iv_Cwqwpw7T = {(byte) 205, (byte) 32, (byte) 172, (byte) 113, (byte) 160, (byte) 144, (byte) 224, (byte) 192, (byte) 108, (byte) 161, (byte) 136, (byte) 36, (byte) 152, (byte) 60, (byte) 133, (byte) 151};
    private static final Pattern b = Pattern.compile("(%)(uclans_)(.+?)(%)");

    public static void a() {
        f139a = new ConcurrentHashMap<>();
        e();
        d();
        f();
    }

    public static ConcurrentHashMap<UUID, List<MailData>> b() {
        return f139a;
    }

    public static void a(MailData mailData) {
        me.module.mail.manager.a.a.a.e.a(mailData);
    }

    public static void a(UUID uuid) {
        me.module.mail.manager.a.a.a.b.a(uuid);
    }

    public static void b(UUID uuid) {
        me.module.mail.manager.a.a.a.d.a(uuid);
    }

    public static void c(UUID uuid) {
        me.module.mail.manager.a.a.a.a.a(uuid);
    }

    public static void c() {
        me.module.mail.manager.a.a.a.c.a();
    }

    public static boolean d(UUID uuid) {
        return b().containsKey(uuid);
    }

    public static List<MailData> e(UUID uuid) {
        return b().containsKey(uuid) ? b().get(uuid) : new ArrayList();
    }

    public static Optional<MailData> f(UUID uuid) {
        Iterator<List<MailData>> it = b().values().iterator();
        while (it.hasNext()) {
            for (MailData mailData : it.next()) {
                if (mailData.getId().equals(uuid)) {
                    return Optional.of(mailData);
                }
            }
        }
        return Optional.empty();
    }

    public static List<MailData> a(UUID uuid, UUID uuid2, ClanEnum.MailTime mailTime) {
        ArrayList arrayList = new ArrayList();
        e(uuid).iterator().forEachRemaining(mailData -> {
            if (mailTime.equals(ClanEnum.MailTime.UNREAD)) {
                if (mailData.getReadBy().contains(uuid2)) {
                    return;
                }
                arrayList.add(mailData);
            } else if (mailTime.equals(ClanEnum.MailTime.READ)) {
                if (mailData.getReadBy().contains(uuid2)) {
                    arrayList.add(mailData);
                }
            } else if (mailTime.equals(ClanEnum.MailTime.ALL)) {
                arrayList.add(mailData);
            }
        });
        Collections.sort(arrayList, (mailData2, mailData3) -> {
            return new Date(mailData3.getDate()).compareTo(new Date(mailData2.getDate()));
        });
        return arrayList;
    }

    public static List<MailData> a(UUID uuid, UUID uuid2) {
        if (!d(uuid2)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(b().get(uuid2));
        arrayList.removeIf(mailData -> {
            return !mailData.getTo().equals(uuid);
        });
        return arrayList;
    }

    public static boolean g(UUID uuid) {
        if (d(uuid)) {
            b().get(uuid).removeIf(mailData -> {
                return mailData.getId().equals(uuid);
            });
        }
        a(uuid);
        return false;
    }

    public static boolean b(UUID uuid, UUID uuid2) {
        Optional<MailData> optionalF = f(uuid);
        if (!optionalF.isPresent()) {
            return false;
        }
        optionalF.get().getReadBy().add(uuid2);
        a(optionalF.get());
        return true;
    }

    public static boolean h(UUID uuid) {
        try {
            if (!d(uuid)) {
                return false;
            }
            b().remove(uuid);
            c(uuid);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(UUID uuid, UUID uuid2, UUID uuid3, String str) {
        try {
            UUID uuidRandomUUID = UUID.randomUUID();
            long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            if (!Mail.getModuleCore().c().j().getBoolean("Config.Mail.enable_colors")) {
                str = Mail.a().getColorAPI().removeColor(str);
            }
            MailData mailData = new MailData(uuidRandomUUID, uuid2, uuid3, uuid, str, jCurrentTimeMillis, new ArrayList());
            if (b().containsKey(uuid3)) {
                b().get(uuid3).add(mailData);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(mailData);
                b().put(uuid3, arrayList);
            }
            a(mailData);
            Bukkit.getPluginManager().callEvent(new ClanMailSendEvent(mailData));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String a(UUID uuid, String str) {
        String strA;
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            if (!str.contains("%") && (strA = Mail.getModuleCore().j().a(uuid, str)) != null) {
                return strA;
            }
            Matcher matcher = b.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strA2 = Mail.getModuleCore().j().a(uuid, matcher.group(3));
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

    private static CommandData_show a(String str, String str2) {
        HashMap map = new HashMap();
        String str3 = "COMMANDS_" + str + "_" + str2 + "_";
        Mail.getModuleCore().c().f().forEach((str4, enumConfiguration) -> {
            try {
                map.put(str4, new CommandData_show(a(enumConfiguration.getString(Lang.valueOf(str3 + "show"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "success"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "error"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Mail.getModuleCore().c().a(Optional.empty()));
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
        Mail.a().getCommandAPI().unRegisterCommand("mail");
        Mail.a().getCommandAPI().unRegisterCommand(Mail.getModuleCore().c().k().getString("Commands.player.alias"));
        Mail.a().getCommandAPI().registerCommand("mail", new MailCommand());
        Mail.a().getCommandAPI().registerCommand(Mail.getModuleCore().c().k().getString("Commands.player.alias"), new MailCommand());
        Mail.a().getCommandAPI().getCommandAliases().put("mail", Mail.getModuleCore().c().k().getString("Commands.player.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("read", "clear", "send")) {
                if (Mail.getModuleCore().c().k().contains("Commands.mail." + str)) {
                    if (!Mail.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Mail.a().getCommandAPI().getCommandAliases().put(str, Mail.getModuleCore().c().k().getString("Commands.mail." + str + ".aliases"));
                    }
                    map.put(str, a("mail", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Mail.a().getCommandAPI().insertCommand("mail", Mail.getModuleCore().c().k().getString("Commands.player.permission"), Mail.getModuleCore().c().k().getString("Commands.player.alias"), Mail.getModuleCore().c().k().getDouble("Commands.player.value"), Mail.getModuleCore().c().k().getInt("Commands.player.cooldown"), a("mail", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Mail.getModuleCore().c().k().getStringList("Commands.player.disabled_worlds"), Mail.getModuleCore().c().k().getStringList("Commands.player.disabled_regions")));
    }

    public static void e() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Mail.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Mail.getModuleCore().c().j().contains("Config.Icon.mimeslots")) {
                if (Mail.getModuleCore().c().j().getStringList("Config.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Mail.getModuleCore().c().j().getStringList("Config.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Mail.getModuleCore().c().j().getStringList("Config.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Mail.getModuleCore().c().j().getStringList("Config.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Mail.getModuleCore().c().j().getIntegerList("Config.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Mail.getModuleCore().c().j().contains("Config.Icon.left_click_action")) {
                Mail.getModuleCore().c().j().getStringList("Config.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(a(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Mail.getModuleCore().c().j().contains("Config.Icon.right_click_action")) {
                Mail.getModuleCore().c().j().getStringList("Config.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(a(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Mail.getModuleCore().c().f().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Mail.getModuleCore().c().a(Optional.empty());
        map.put("module_mail_item", new GuiItemsData("clan_home", Mail.getModuleCore().c().j().getString("Config.Icon.click_sound"), Mail.getModuleCore().c().j().getString("Config.Icon.material"), 1, Mail.getModuleCore().c().j().getBoolean("Config.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Clan mailbox.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Mail.getModuleCore().c().j().getString("Config.Icon.texture"), new NbtData(Mail.getModuleCore().c().j().getStringList("Config.Icon.nbt.string"), Mail.getModuleCore().c().j().getInt("Config.Icon.model")), Mail.getModuleCore().c().j().getInt("Config.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Mail.a().getGuiAPI().registerLocalizedInsertItem("General", "module_mail_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void f() {
        ConfigurationSection configurationSection = Mail.getModuleCore().c().j().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Mail.getModuleCore().c().j().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Mail.getModuleCore().c().j().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Mail.getModuleCore().c().j().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Mail.a().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Mail.a().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }

    private static String a(String str) {
        return Mail.a().getCommandAPI().replaceCmd(Mail.a().getCommandAPI().replaceMainCmd(str));
    }

    private static String __unused_571() {
        return "Config.Mail.enable_colors";
    }

    private static String __unused_572() {
        return "%";
    }

    private static String __unused_573() {
        return "week+";
    }

    private static String __unused_574() {
        return "%02d";
    }

    private static String __unused_575() {
        return "%02d";
    }

    private static String __unused_576() {
        return "%02d";
    }

    private static String __unused_577() {
        return "%02d";
    }

    private static String __unused_578() {
        return "EN";
    }

    private static String __unused_579() {
        return "mail";
    }

    private static String __unused_580() {
        return "Commands.player.alias";
    }

    private static String __unused_581() {
        return "mail";
    }

    private static String __unused_582() {
        return "Commands.player.alias";
    }

    private static String __unused_583() {
        return "mail";
    }

    private static String __unused_584() {
        return "Commands.player.alias";
    }

    private static String __unused_585() {
        return "read";
    }

    private static String __unused_586() {
        return "clear";
    }

    private static String __unused_587() {
        return "send";
    }

    private static String __unused_588() {
        return "mail";
    }

    private static String __unused_589() {
        return "mail";
    }

    private static String __unused_590() {
        return "Commands.player.permission";
    }

    private static String __unused_591() {
        return "Commands.player.alias";
    }

    private static String __unused_592() {
        return "Commands.player.value";
    }

    private static String __unused_593() {
        return "Commands.player.cooldown";
    }

    private static String __unused_594() {
        return "mail";
    }

    private static String __unused_595() {
        return "help";
    }

    private static String __unused_596() {
        return "Commands.player.disabled_worlds";
    }

    private static String __unused_597() {
        return "Commands.player.disabled_regions";
    }

    private static String __unused_598() {
        return "General";
    }

    private static String __unused_599() {
        return "General";
    }

    private static String __unused_600() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_601() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_602() {
        return "ALL";
    }

    private static String __unused_603() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_604() {
        return "TOP";
    }

    private static String __unused_605() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_606() {
        return "BOTTOM";
    }

    private static String __unused_607() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_608() {
        return "BORDER";
    }

    private static String __unused_609() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_610() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_611() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_612() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_613() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_614() {
        return "EN";
    }

    private static String __unused_615() {
        return "<green>Clan mailbox.";
    }

    private static String __unused_616() {
        return "EN";
    }

    private static String __unused_617() {
        return "module_mail_item";
    }

    private static String __unused_618() {
        return "clan_home";
    }

    private static String __unused_619() {
        return "Config.Icon.click_sound";
    }

    private static String __unused_620() {
        return "Config.Icon.material";
    }

    private static String __unused_621() {
        return "Config.Icon.glow";
    }

    private static String __unused_622() {
        return "Config.Icon.texture";
    }

    private static String __unused_623() {
        return "Config.Icon.nbt.string";
    }

    private static String __unused_624() {
        return "Config.Icon.model";
    }

    private static String __unused_625() {
        return "Config.Icon.slot";
    }

    private static String __unused_626() {
        return "General";
    }

    private static String __unused_627() {
        return "module_mail_item";
    }

    private static String __unused_628() {
        return "General";
    }

    private static String __unused_629() {
        return "General";
    }

    private static String __unused_630() {
        return "Config.Permissions";
    }

    private static String __unused_631() {
        return "-";
    }

    private static String __unused_632() {
        return ".";
    }

    private static String __unused_633() {
        return "-";
    }

    private static String __unused_634() {
        return "(%)(uclans_)(.+?)(%)";
    }
}
