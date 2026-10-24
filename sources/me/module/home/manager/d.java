package me.module.home.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import me.module.home.Home;
import me.module.home.commands.HomeCommand;
import me.module.home.manager.EnumFiles.Lang;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.data.CustomChatPrompt;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.HomesData;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.events.ClanHomeCreateEvent;
import me.ulrich.clans.events.ClanHomeDeleteEvent;
import me.ulrich.clans.interfaces.ClaimImplement;
import me.ulrich.clans.interfaces.RegionImplement;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.manager.utils.Locals;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/d.class */
public class d {
    private static String __s_cache_95JLRDFs_0;
    private static String __s_cache_EWJuBECk_1;
    private static String __s_cache_WkcHT9QM_2;
    private static String __s_cache_iwUfGfRY_3;
    private static String __s_cache_E2xc0xrI_4;
    private static String __s_cache_BCUMdjiy_5;
    private static String __s_cache_iNy4s35w_6;
    private static String __s_cache_yi4TzpXi_7;
    private static String __s_cache_OtXF0WG5_8;
    private static String __s_cache_dcMwltUI_9;
    private static String __s_cache_a3HgLCXs_10;
    private static String __s_cache_ZpfzLCc4_11;
    private static String __s_cache_qGR4yPbY_12;
    private static String __s_cache_kRgCkbKL_13;
    private static String __s_cache_2u9lGB6g_14;
    private static String __s_cache_4C4uKfso_15;
    private static String __s_cache_L4oNmEp9_16;
    private static String __s_cache_WT5ND016_17;
    private static String __s_cache_BVvhO1Fh_18;
    private static String __s_cache_JWv4SUHP_19;
    private static String __s_cache_PL1Erp8V_20;
    private static String __s_cache_SsV5sZqk_21;
    private static String __s_cache_nTYCyOOd_22;
    private static String __s_cache_MFaCQXQk_23;
    private static String __s_cache_HsF73F4B_24;
    private static String __s_cache_ntR8XFcs_25;
    private static String __s_cache_6NBtS0p1_26;
    private static String __s_cache_vgiXA64d_27;
    private static String __s_cache_gu7S2bcI_28;
    private static String __s_cache_juU0FHMZ_29;
    private static String __s_cache_njQboQrk_30;
    private static String __s_cache_HAhSUIov_31;
    private static String __s_cache_lFE2Mldi_32;
    private static String __s_cache_GNTftsgb_33;
    private static String __s_cache_FmAiQApH_34;
    private static String __s_cache_nKTpAu6s_35;
    private static String __s_cache_hwjoVc74_36;
    private static String __s_cache_emhaPEnC_37;
    private static String __s_cache_Esfm84EB_38;
    private static String __s_cache_uyFkS3nw_39;
    private static String __s_cache_QI4nWwb5_40;
    private static String __s_cache_q8qpSN9g_41;
    private static String __s_cache_5MOv7HEd_42;
    private static String __s_cache_1BQHlTrR_43;
    private static String __s_cache_Nue0bKWo_44;
    private static String __s_cache_5y5HsqC2_45;
    private static String __s_cache_grnt4HI9_46;
    private static String __s_cache_yrnpwKbA_47;
    private static String __s_cache_nK4mBKft_48;
    private static String __s_cache_RQPk1b2L_49;
    private static String __s_cache_UbjdFkXV_50;
    private static String __s_cache_TLmZL9t1_51;
    private static String __s_cache_k580rQrX_52;
    private static String __s_cache_wbalgjZY_53;
    private static String __s_cache_IFFzzeLh_54;
    private static String __s_cache_RtdF7bS7_55;
    private static String __s_cache_o5JsppDK_56;
    private static String __s_cache_OTk13BzK_57;
    private static String __s_cache_3dRpHyCi_58;
    private static String __s_cache_ZP54tq7W_59;
    private static String __s_cache_Kko7m2yO_60;
    private static String __s_cache_PQU2S0PW_61;
    private static String __s_cache_Xra1r57C_62;
    private static String __s_cache_cFZB7vRQ_63;
    private static String __s_cache_rwWAZwp5_64;
    private static String __s_cache_Uooe8vSy_65;
    private static String __s_cache_3kynP2hT_66;
    private static String __s_cache_PGzNkzED_67;
    private static String __s_cache_yMANPaCV_68;
    private static String __s_cache_XBemAJsu_69;
    private static String __s_cache_dLclUubg_70;
    private static String __s_cache_eMBj9bZD_71;
    private static String __s_cache_N77G0zhp_72;
    private static String __s_cache_Jew16zD3_73;
    private static String __s_cache_YPkapl8r_74;
    private static String __s_cache_yF9OydD8_75;
    private static String __s_cache_M2yPkBDT_76;
    private static byte[] __aes_key_ltfrfKaO = {(byte) 221, (byte) 243, (byte) 182, (byte) 254, (byte) 207, (byte) 229, (byte) 121, (byte) 230, (byte) 206, (byte) 47, (byte) 6, (byte) 62, (byte) 50, (byte) 35, (byte) 250, (byte) 128, (byte) 9, (byte) 217, (byte) 144, (byte) 81, (byte) 34, (byte) 89, (byte) 179, (byte) 201, (byte) 239, (byte) 114, (byte) 223, (byte) 144, (byte) 42, (byte) 214, (byte) 239, (byte) 224};
    private static byte[] __aes_iv_uxU9OwPC = {(byte) 60, (byte) 150, (byte) 65, (byte) 140, (byte) 241, (byte) 154, (byte) 34, (byte) 251, (byte) 54, (byte) 212, (byte) 190, (byte) 94, (byte) 80, (byte) 74, (byte) 13, (byte) 51};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f112a = Pattern.compile("(%)(uclans_)(.+?)(%)");

    public static void a() {
        c();
        b();
        d();
    }

    public static CustomChatPrompt.Builder a(Player player, String str) {
        List<String> stringList;
        CustomChatPrompt.Builder duration = new CustomChatPrompt.Builder().setDuration(Home.getModuleCore().c().l().getInt("Chat." + str + ".time"));
        if (Home.getModuleCore().c().l().getBoolean("Chat." + str + ".message.enabled") && (stringList = Home.getModuleCore().c().a((CommandSender) player).getStringList(Lang.valueOf("CHAT_" + str + "_message"))) != null) {
            Iterator<String> it = stringList.iterator();
            while (it.hasNext()) {
                duration.addChatMessage(a(it.next()));
            }
        }
        if (Home.getModuleCore().c().l().getBoolean("Chat." + str + ".title.enabled")) {
            duration.setTitle(a((String) Home.getModuleCore().c().a((CommandSender) player).get(Lang.valueOf("CHAT_" + str + "_title_line"))), a((String) Home.getModuleCore().c().a((CommandSender) player).get(Lang.valueOf("CHAT_" + str + "_title_subline"))));
        }
        if (Home.getModuleCore().c().l().getBoolean("Chat." + str + ".actionbar.enabled")) {
            duration.setActionBar(a((String) Home.getModuleCore().c().a((CommandSender) player).get(Lang.valueOf("CHAT_" + str + "_actionbar"))));
        }
        if (Home.getModuleCore().c().l().getBoolean("Chat." + str + ".bossbar.enabled")) {
            String string = Home.getModuleCore().c().l().getString("Chat." + str + ".bossbar.color");
            String string2 = Home.getModuleCore().c().l().getString("Chat." + str + ".bossbar.style");
            boolean z = Home.getModuleCore().c().l().getBoolean("Chat." + str + ".bossbar.animated");
            BossBar.Color colorValueOf = BossBar.Color.valueOf(string);
            BossBar.Overlay overlayValueOf = BossBar.Overlay.valueOf(string2);
            String str2 = (String) Home.getModuleCore().c().a((CommandSender) player).get(Lang.valueOf("CHAT_" + str + "_bossbar"));
            ArrayList arrayList = new ArrayList();
            Iterator it2 = Home.getModuleCore().c().l().getStringList("Chat." + str + ".bossbar.flags").iterator();
            while (it2.hasNext()) {
                arrayList.add(BossBar.Flag.valueOf((String) it2.next()));
            }
            duration.setBossBar(a(str2), colorValueOf, overlayValueOf, arrayList, z);
        }
        if (Home.getModuleCore().c().l().getBoolean("Chat." + str + ".sound.enabled")) {
            duration.setSound(Home.getModuleCore().c().l().getString("Chat." + str + ".sound.display"));
        }
        return duration;
    }

    public static boolean a(UUID uuid, String str) {
        try {
            if (!c(uuid, str)) {
                return false;
            }
            Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(uuid);
            if (!playerClan.isPresent()) {
                return false;
            }
            playerClan.get().setHome((List) playerClan.get().getHome().stream().filter(homesData -> {
                return !homesData.getName().equals(str);
            }).collect(Collectors.toList()));
            Home.a().getClanAPI().saveClanData(playerClan.get());
            Home.getModuleCore().d().runTask(() -> {
                Bukkit.getPluginManager().callEvent(new ClanHomeDeleteEvent(uuid, ((ClanData) playerClan.get()).getId(), str));
            });
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(UUID uuid, Location location, String str) {
        return a(uuid, location, str, (Optional<String>) Optional.empty());
    }

    public static int a(ClanData clanData) {
        try {
            int i = 0;
            Iterator it = Home.getModuleCore().c().i().getStringList("Config.Unlocker.home").iterator();
            while (it.hasNext()) {
                String[] strArrSplit = ((String) it.next()).split(":");
                if (strArrSplit.length == 2) {
                    int iIntValue = Integer.valueOf(strArrSplit[0]).intValue();
                    if (clanData.getLevel() >= Integer.valueOf(strArrSplit[1]).intValue() && iIntValue > i) {
                        i = iIntValue;
                    }
                }
            }
            if (i == 0) {
                i = Home.getModuleCore().c().i().getInt("Config.Home.default_amount");
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return Home.getModuleCore().c().i().getInt("Config.Home.default_amount");
        }
    }

    public static String b(UUID uuid, String str) {
        String strA;
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            if (!str.contains("%") && (strA = Home.getModuleCore().i().a(uuid, str)) != null) {
                return strA;
            }
            Matcher matcher = f112a.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strA2 = Home.getModuleCore().i().a(uuid, matcher.group(3));
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

    public static boolean a(UUID uuid, Location location, String str, Optional<String> optional) {
        if (c(uuid, str)) {
            return false;
        }
        String strEncodeLocation = new Locals().encodeLocation(location);
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return false;
        }
        playerClan.get().getHome().add(new HomesData(Home.a().getServerName(), str, strEncodeLocation, optional));
        Home.a().getClanAPI().saveClanData(playerClan.get());
        Home.getModuleCore().d().runTask(() -> {
            Bukkit.getPluginManager().callEvent(new ClanHomeCreateEvent(uuid, ((ClanData) playerClan.get()).getId(), str, location));
        });
        return true;
    }

    public static boolean c(UUID uuid, String str) {
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent() || playerClan.get().getHome() == null) {
            return false;
        }
        return playerClan.get().getHome().stream().filter(homesData -> {
            return homesData.getName().equals(str);
        }).findAny().isPresent();
    }

    public static Optional<Location> d(UUID uuid, String str) {
        Location locationDecodeLocation;
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(uuid);
        if (playerClan.isPresent() && playerClan.get().getHome() != null) {
            Optional<HomesData> optionalFindAny = playerClan.get().getHome().stream().filter(homesData -> {
                return homesData.getName().equals(str);
            }).findAny();
            if (optionalFindAny.isPresent() && (locationDecodeLocation = new Locals().decodeLocation(optionalFindAny.get().getLoc())) != null) {
                return Optional.of(locationDecodeLocation);
            }
        }
        return Optional.empty();
    }

    public static Optional<EncodedLocationData> e(UUID uuid, String str) {
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(uuid);
        if (playerClan.isPresent() && playerClan.get().getHome() != null) {
            Optional<HomesData> optionalFindAny = playerClan.get().getHome().stream().filter(homesData -> {
                return homesData.getName().equals(str);
            }).findAny();
            if (optionalFindAny.isPresent()) {
                return new Locals().decodeLocation(optionalFindAny.get().getServer(), optionalFindAny.get().getLoc());
            }
        }
        return Optional.empty();
    }

    public static Optional<HomesData> f(UUID uuid, String str) {
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(uuid);
        return (!playerClan.isPresent() || playerClan.get().getHome() == null) ? Optional.empty() : playerClan.get().getHome().stream().filter(homesData -> {
            return homesData.getName().equals(str);
        }).findAny();
    }

    public static boolean b(Player player, String str) {
        return a(player, str, (Optional<String>) Optional.empty());
    }

    public static boolean b(UUID uuid, Location location, String str, Optional<String> optional) {
        if (str.contains(" ") && str.split(" ").length > 0) {
            return false;
        }
        String strRemoveColor = Home.a().getColorAPI().removeColor(str);
        if (!strRemoveColor.toString().matches(Home.getModuleCore().c().i().getString("Config.Home.allowed_chars")) || c(uuid, strRemoveColor)) {
            return false;
        }
        if (Home.getModuleCore().c().i().getStringList("Config.Home.disabled_worlds").contains(location.getWorld().getName())) {
            return false;
        }
        if (Home.getModuleCore().c().i().getBoolean("Config.Home.terrain.verify_enabled")) {
            List stringList = Home.getModuleCore().c().i().getStringList("Config.Home.terrain.disabled_plugin");
            List stringList2 = Home.getModuleCore().c().i().getStringList("Config.Home.terrain.enabled_plugin");
            if (stringList.size() > 0) {
                Iterator it = stringList.iterator();
                while (it.hasNext()) {
                    Optional<ClaimImplement> claimAPI = Home.a().getIntegrationAPI().getClaimAPI((String) it.next());
                    if (claimAPI.isPresent() && claimAPI.get().hasClaimLocation(location)) {
                        return false;
                    }
                }
            }
            if (stringList2.size() > 0) {
                Iterator it2 = stringList2.iterator();
                while (it2.hasNext()) {
                    Optional<ClaimImplement> claimAPI2 = Home.a().getIntegrationAPI().getClaimAPI((String) it2.next());
                    if (claimAPI2.isPresent() && !claimAPI2.get().hasClaimLocation(location)) {
                        return false;
                    }
                }
            }
        }
        return a(uuid, location, strRemoveColor, optional);
    }

    public static boolean a(Player player, String str, Optional<String> optional) {
        if (str.contains(" ") && str.split(" ").length > 0) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_NAME_WITHOUT_SPACE));
            return false;
        }
        String strRemoveColor = Home.a().getColorAPI().removeColor(str);
        if (!strRemoveColor.toString().matches(Home.getModuleCore().c().i().getString("Config.Home.allowed_chars"))) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.ERROR_CHARACTER));
            return false;
        }
        if (c(player.getUniqueId(), strRemoveColor)) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_ALREADY_EXISTS));
            return false;
        }
        String name = player.getWorld().getName();
        List stringList = Home.getModuleCore().c().i().getStringList("Config.Home.disabled_worlds");
        String string = Home.getModuleCore().c().i().getString("Config.special_permissions.bypass_home_worlds");
        if (stringList.contains(name)) {
            if (string == null || string.isEmpty()) {
                MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.DISABLED_WORLD_COMMAND));
                return false;
            }
            if (!player.hasPermission(string)) {
                MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.DISABLED_WORLD_COMMAND));
                return false;
            }
        }
        String string2 = Home.getModuleCore().c().i().getString("Config.special_permissions.bypass_home_regions");
        List stringList2 = Home.getModuleCore().c().i().getStringList("Config.Home.disabled_regions");
        boolean z = false;
        Optional<RegionImplement> regionAPI = Home.a().getIntegrationAPI().getRegionAPI();
        if (regionAPI.isPresent()) {
            Iterator it = stringList2.iterator();
            while (it.hasNext()) {
                if (regionAPI.get().isInRegion(player, (String) it.next())) {
                    z = true;
                }
            }
        }
        if (string2 == null || string2.isEmpty()) {
            if (z) {
                MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.DISABLED_REGION_COMMAND));
                return false;
            }
        } else if (!player.hasPermission(string2) && z) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.DISABLED_REGION_COMMAND));
            return false;
        }
        if (Home.getModuleCore().c().i().getBoolean("Config.Home.terrain.verify_enabled")) {
            List stringList3 = Home.getModuleCore().c().i().getStringList("Config.Home.terrain.disabled_plugin");
            List stringList4 = Home.getModuleCore().c().i().getStringList("Config.Home.terrain.enabled_plugin");
            if (stringList3.size() > 0) {
                Iterator it2 = stringList3.iterator();
                while (it2.hasNext()) {
                    Optional<ClaimImplement> claimAPI = Home.a().getIntegrationAPI().getClaimAPI((String) it2.next());
                    if (claimAPI.isPresent() && claimAPI.get().hasClaimLocation(player.getLocation()) && !claimAPI.get().isMemberClaimLocation(player, player.getLocation())) {
                        MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.DISABLED_REGION_COMMAND));
                        return false;
                    }
                }
            }
            if (stringList4.size() > 0) {
                Iterator it3 = stringList4.iterator();
                while (it3.hasNext()) {
                    Optional<ClaimImplement> claimAPI2 = Home.a().getIntegrationAPI().getClaimAPI((String) it3.next());
                    if (claimAPI2.isPresent() && !claimAPI2.get().hasClaimLocation(player.getLocation())) {
                        MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.DISABLED_REGION_COMMAND));
                        return false;
                    }
                }
            }
        }
        return a(player.getUniqueId(), player.getLocation(), strRemoveColor, optional);
    }

    private static CommandData_show a(String str, String str2) {
        HashMap map = new HashMap();
        String str3 = "COMMANDS_" + str + "_" + str2 + "_";
        Home.getModuleCore().c().e().forEach((str4, enumConfiguration) -> {
            try {
                map.put(str4, new CommandData_show(a(enumConfiguration.getString(Lang.valueOf(str3 + "show"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "success"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "error"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Home.getModuleCore().c().a(Optional.empty()));
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

    public static void b() {
        Home.a().getCommandAPI().unRegisterCommand("home");
        Home.a().getCommandAPI().unRegisterCommand(Home.getModuleCore().c().j().getString("Commands.player.alias"));
        Home.a().getCommandAPI().registerCommand("home", new HomeCommand());
        Home.a().getCommandAPI().registerCommand(Home.getModuleCore().c().j().getString("Commands.player.alias"), new HomeCommand());
        Home.a().getCommandAPI().getCommandAliases().put("home", Home.getModuleCore().c().j().getString("Commands.player.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("create", "delete", "list", "teleport", "view")) {
                if (Home.getModuleCore().c().j().contains("Commands.home." + str)) {
                    if (!Home.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Home.a().getCommandAPI().getCommandAliases().put(str, Home.getModuleCore().c().j().getString("Commands.home." + str + ".aliases"));
                    }
                    map.put(str, a("home", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Home.a().getCommandAPI().insertCommand("home", Home.getModuleCore().c().j().getString("Commands.player.permission"), Home.getModuleCore().c().j().getString("Commands.player.alias"), Home.getModuleCore().c().j().getDouble("Commands.player.value"), Home.getModuleCore().c().j().getInt("Commands.player.cooldown"), a("home", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Home.getModuleCore().c().j().getStringList("Commands.player.disabled_worlds"), Home.getModuleCore().c().j().getStringList("Commands.player.disabled_regions")));
    }

    public static void c() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Home.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Home.getModuleCore().c().i().contains("Config.Icon.mimeslots")) {
                if (Home.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Home.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Home.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Home.getModuleCore().c().i().getStringList("Config.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Home.getModuleCore().c().i().getIntegerList("Config.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Home.getModuleCore().c().i().contains("Config.Icon.left_click_action")) {
                Home.getModuleCore().c().i().getStringList("Config.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(a(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Home.getModuleCore().c().i().contains("Config.Icon.right_click_action")) {
                Home.getModuleCore().c().i().getStringList("Config.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(a(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Home.getModuleCore().c().e().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Home.getModuleCore().c().a(Optional.empty());
        map.put("module_home_item", new GuiItemsData("clan_home", Home.getModuleCore().c().i().getString("Config.Icon.click_sound"), Home.getModuleCore().c().i().getString("Config.Icon.material"), 1, Home.getModuleCore().c().i().getBoolean("Config.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Clan Home.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Home.getModuleCore().c().i().getString("Config.Icon.texture"), new NbtData(Home.getModuleCore().c().i().getStringList("Config.Icon.nbt.string"), Home.getModuleCore().c().i().getInt("Config.Icon.model")), Home.getModuleCore().c().i().getInt("Config.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Home.a().getGuiAPI().registerLocalizedInsertItem("General", "module_home_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void d() {
        ConfigurationSection configurationSection = Home.getModuleCore().c().i().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Home.getModuleCore().c().i().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Home.getModuleCore().c().i().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Home.getModuleCore().c().i().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Home.a().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Home.a().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }

    private static String a(String str) {
        return Home.a().getCommandAPI().replaceCmd(Home.a().getCommandAPI().replaceMainCmd(str));
    }

    private static String __unused_276() {
        return "Config.Unlocker.home";
    }

    private static String __unused_277() {
        return ":";
    }

    private static String __unused_278() {
        return "Config.Home.default_amount";
    }

    private static String __unused_279() {
        return "Config.Home.default_amount";
    }

    private static String __unused_280() {
        return "%";
    }

    private static String __unused_281() {
        return "Config.Home.allowed_chars";
    }

    private static String __unused_282() {
        return "Config.Home.disabled_worlds";
    }

    private static String __unused_283() {
        return "Config.Home.terrain.verify_enabled";
    }

    private static String __unused_284() {
        return "Config.Home.terrain.disabled_plugin";
    }

    private static String __unused_285() {
        return "Config.Home.terrain.enabled_plugin";
    }

    private static String __unused_286() {
        return "Config.Home.allowed_chars";
    }

    private static String __unused_287() {
        return "Config.Home.disabled_worlds";
    }

    private static String __unused_288() {
        return "Config.special_permissions.bypass_home_worlds";
    }

    private static String __unused_289() {
        return "Config.special_permissions.bypass_home_regions";
    }

    private static String __unused_290() {
        return "Config.Home.disabled_regions";
    }

    private static String __unused_291() {
        return "Config.Home.terrain.verify_enabled";
    }

    private static String __unused_292() {
        return "Config.Home.terrain.disabled_plugin";
    }

    private static String __unused_293() {
        return "Config.Home.terrain.enabled_plugin";
    }

    private static String __unused_294() {
        return "EN";
    }

    private static String __unused_295() {
        return "home";
    }

    private static String __unused_296() {
        return "Commands.player.alias";
    }

    private static String __unused_297() {
        return "home";
    }

    private static String __unused_298() {
        return "Commands.player.alias";
    }

    private static String __unused_299() {
        return "home";
    }

    private static String __unused_300() {
        return "Commands.player.alias";
    }

    private static String __unused_301() {
        return "create";
    }

    private static String __unused_302() {
        return "delete";
    }

    private static String __unused_303() {
        return "list";
    }

    private static String __unused_304() {
        return "teleport";
    }

    private static String __unused_305() {
        return "view";
    }

    private static String __unused_306() {
        return "home";
    }

    private static String __unused_307() {
        return "home";
    }

    private static String __unused_308() {
        return "Commands.player.permission";
    }

    private static String __unused_309() {
        return "Commands.player.alias";
    }

    private static String __unused_310() {
        return "Commands.player.value";
    }

    private static String __unused_311() {
        return "Commands.player.cooldown";
    }

    private static String __unused_312() {
        return "home";
    }

    private static String __unused_313() {
        return "help";
    }

    private static String __unused_314() {
        return "Commands.player.disabled_worlds";
    }

    private static String __unused_315() {
        return "Commands.player.disabled_regions";
    }

    private static String __unused_316() {
        return "General";
    }

    private static String __unused_317() {
        return "General";
    }

    private static String __unused_318() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_319() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_320() {
        return "ALL";
    }

    private static String __unused_321() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_322() {
        return "TOP";
    }

    private static String __unused_323() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_324() {
        return "BOTTOM";
    }

    private static String __unused_325() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_326() {
        return "BORDER";
    }

    private static String __unused_327() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_328() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_329() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_330() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_331() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_332() {
        return "EN";
    }

    private static String __unused_333() {
        return "<green>Clan Home.";
    }

    private static String __unused_334() {
        return "EN";
    }

    private static String __unused_335() {
        return "module_home_item";
    }

    private static String __unused_336() {
        return "clan_home";
    }

    private static String __unused_337() {
        return "Config.Icon.click_sound";
    }

    private static String __unused_338() {
        return "Config.Icon.material";
    }

    private static String __unused_339() {
        return "Config.Icon.glow";
    }

    private static String __unused_340() {
        return "Config.Icon.texture";
    }

    private static String __unused_341() {
        return "Config.Icon.nbt.string";
    }

    private static String __unused_342() {
        return "Config.Icon.model";
    }

    private static String __unused_343() {
        return "Config.Icon.slot";
    }

    private static String __unused_344() {
        return "General";
    }

    private static String __unused_345() {
        return "module_home_item";
    }

    private static String __unused_346() {
        return "General";
    }

    private static String __unused_347() {
        return "General";
    }

    private static String __unused_348() {
        return "Config.Permissions";
    }

    private static String __unused_349() {
        return "-";
    }

    private static String __unused_350() {
        return ".";
    }

    private static String __unused_351() {
        return "-";
    }

    private static String __unused_352() {
        return "(%)(uclans_)(.+?)(%)";
    }
}
