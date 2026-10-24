package me.module.rewards.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import me.module.rewards.Rewards;
import me.module.rewards.commands.RewardsCommand;
import me.module.rewards.manager.EnumFiles.Lang;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.RewardsData;
import me.ulrich.clans.events.ClanRewardsEvent;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/f.class */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<UUID, RewardsData> f158a;
    private static String __s_cache_1CdYB469_0;
    private static String __s_cache_H8szJ6tx_1;
    private static String __s_cache_OcVA2oad_2;
    private static String __s_cache_EKZKGYmN_3;
    private static String __s_cache_OZkctChD_4;
    private static String __s_cache_ZkzCXyRz_5;
    private static String __s_cache_LPSafNc0_6;
    private static String __s_cache_vReKZgcK_7;
    private static String __s_cache_RHyc2CWn_8;
    private static String __s_cache_c3TT95f3_9;
    private static String __s_cache_HUSn6D07_10;
    private static String __s_cache_SPbZCSbp_11;
    private static String __s_cache_JQz4bW6k_12;
    private static String __s_cache_O4Zjm0Vu_13;
    private static String __s_cache_p3tLbxEW_14;
    private static String __s_cache_8kDHwdAC_15;
    private static String __s_cache_QAH3OpHp_16;
    private static String __s_cache_y6rWFyp4_17;
    private static String __s_cache_99xLY9MM_18;
    private static String __s_cache_RMwMYJDi_19;
    private static String __s_cache_kM7BYzz5_20;
    private static String __s_cache_iQ6FKiOO_21;
    private static String __s_cache_m9edPftX_22;
    private static String __s_cache_rtmKdVXV_23;
    private static String __s_cache_Hy20DgfH_24;
    private static String __s_cache_As22kjeW_25;
    private static String __s_cache_yPv0Cbdk_26;
    private static String __s_cache_o8GAVuRi_27;
    private static String __s_cache_U3hEYs8K_28;
    private static String __s_cache_UgwSZAE6_29;
    private static String __s_cache_YHdjUk9i_30;
    private static String __s_cache_fo4fgBjU_31;
    private static String __s_cache_mAurrCiz_32;
    private static String __s_cache_Go5lLuPD_33;
    private static String __s_cache_A3oSc8Ni_34;
    private static String __s_cache_Kef6umPG_35;
    private static String __s_cache_FV3CiD8c_36;
    private static String __s_cache_mu2yuU9G_37;
    private static String __s_cache_OZ6Ri9uw_38;
    private static String __s_cache_ZfKOVerG_39;
    private static String __s_cache_gI12JBDr_40;
    private static String __s_cache_lvK3qjcX_41;
    private static String __s_cache_APN7OKuQ_42;
    private static String __s_cache_UHzI1Lr8_43;
    private static String __s_cache_A2TqkSBA_44;
    private static String __s_cache_LT9dmX4T_45;
    private static String __s_cache_eQV8Oe85_46;
    private static String __s_cache_KCr8ICqp_47;
    private static String __s_cache_QfzL0T4Q_48;
    private static String __s_cache_29wpXFhO_49;
    private static String __s_cache_JMis4Jwa_50;
    private static String __s_cache_rSHB0MOL_51;
    private static String __s_cache_370jaTwY_52;
    private static String __s_cache_1kGINd9A_53;
    private static String __s_cache_1cSjwNfh_54;
    private static String __s_cache_8CFBrZrK_55;
    private static String __s_cache_CVwGQUNd_56;
    private static String __s_cache_VgtPdTuq_57;
    private static String __s_cache_aoLC0E8Q_58;
    private static String __s_cache_TWsxtwLZ_59;
    private static String __s_cache_4D5azz5L_60;
    private static String __s_cache_rgrsUKGD_61;
    private static String __s_cache_3iv1PB9R_62;
    private static byte[] __aes_key_7MJp4I0y = {(byte) 32, (byte) 204, (byte) 64, (byte) 222, (byte) 207, (byte) 186, (byte) 103, (byte) 242, (byte) 213, (byte) 235, (byte) 131, (byte) 164, (byte) 88, (byte) 88, (byte) 1, (byte) 228, (byte) 236, (byte) 32, (byte) 218, (byte) 164, (byte) 97, (byte) 135, (byte) 203, (byte) 102, (byte) 137, (byte) 168, (byte) 174, (byte) 242, (byte) 65, (byte) 108, (byte) 254, (byte) 100};
    private static byte[] __aes_iv_JQcxuYmb = {(byte) 94, (byte) 125, (byte) 57, (byte) 104, (byte) 47, (byte) 25, (byte) 209, (byte) 173, (byte) 216, (byte) 230, (byte) 234, (byte) 211, (byte) 223, (byte) 147, (byte) 82, (byte) 220};
    private static final Pattern b = Pattern.compile("(%)(uclans_)(.+?)(%)");

    public static void a() {
        f158a = new ConcurrentHashMap<>();
        d();
        c();
        e();
    }

    public static void a(RewardsData rewardsData) {
        me.module.rewards.manager.a.a.a.e.a(rewardsData);
    }

    public static void a(UUID uuid) {
        me.module.rewards.manager.a.a.a.b.a(uuid);
    }

    public static void b(UUID uuid) {
        me.module.rewards.manager.a.a.a.d.a(uuid);
    }

    public static void c(UUID uuid) {
        me.module.rewards.manager.a.a.a.a.a(uuid);
    }

    public static void b() {
        me.module.rewards.manager.a.a.a.c.a();
    }

    public static boolean d(UUID uuid) {
        return f().values().stream().filter(rewardsData -> {
            return rewardsData.getClanUUID().equals(uuid);
        }).findFirst().isPresent();
    }

    public static List<RewardsData> e(UUID uuid) {
        return (List) f().values().stream().filter(rewardsData -> {
            return rewardsData.getClanUUID().equals(uuid);
        }).collect(Collectors.toList());
    }

    public static boolean a(UUID uuid, int i) {
        return f().values().stream().filter(rewardsData -> {
            return rewardsData.getClanUUID().equals(uuid) && rewardsData.getComplement().isPresent() && rewardsData.getComplement().get().equalsIgnoreCase("SURPRISE_" + i);
        }).findFirst().isPresent();
    }

    public static boolean f(UUID uuid) {
        Optional<PlayerData> playerData = Rewards.a().getPlayerAPI().getPlayerData(uuid);
        if (!playerData.isPresent()) {
            return false;
        }
        Optional<ClanData> playerClan = Rewards.a().getPlayerAPI().getPlayerClan(playerData.get().getId());
        if (!playerClan.isPresent()) {
            return false;
        }
        Optional<RewardsData> optionalFindFirst = f().values().stream().filter(rewardsData -> {
            return rewardsData.getClanUUID().equals(((ClanData) playerClan.get()).getId()) && rewardsData.getCollectedBy().contains(uuid);
        }).findFirst();
        if (optionalFindFirst.isPresent()) {
            return optionalFindFirst.get().getCollectedBy().contains(uuid);
        }
        return false;
    }

    public static List<RewardsData> g(UUID uuid) {
        Optional<PlayerData> playerData = Rewards.a().getPlayerAPI().getPlayerData(uuid);
        if (playerData.isPresent()) {
            Optional<ClanData> playerClan = Rewards.a().getPlayerAPI().getPlayerClan(playerData.get().getId());
            if (playerClan.isPresent()) {
                return (List) f().values().stream().filter(rewardsData -> {
                    return rewardsData.getClanUUID().equals(((ClanData) playerClan.get()).getId()) && rewardsData.getCollectedBy().contains(uuid);
                }).collect(Collectors.toList());
            }
        }
        return new ArrayList();
    }

    public static boolean a(UUID uuid, UUID uuid2) {
        List<RewardsData> listG = g(uuid);
        if (listG.size() <= 0) {
            return false;
        }
        Optional<RewardsData> optionalFindFirst = listG.stream().filter(rewardsData -> {
            return rewardsData.getId().equals(uuid2);
        }).findFirst();
        if (!optionalFindFirst.isPresent()) {
            return false;
        }
        optionalFindFirst.get().getRewards().iterator().forEachRemaining(str -> {
            Player player = Bukkit.getPlayer(uuid);
            if (player.isOnline()) {
                if (str.startsWith("/")) {
                    str = str.replaceFirst("/", "");
                }
                String text = Rewards.a().getClanAPI().parseText(player.getUniqueId(), str.replace("%player%", player.getName()).replace("{player}", player.getName()));
                Rewards.getModuleCore().d().runTask(() -> {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), text);
                });
            }
        });
        optionalFindFirst.get().getCollectedBy().remove(uuid);
        if (optionalFindFirst.get().getCollectedBy().size() != 0) {
            a(optionalFindFirst.get());
            return true;
        }
        if (optionalFindFirst.get().getComplement().isPresent() && optionalFindFirst.get().getComplement().get().startsWith("SURPRISE_")) {
            a(optionalFindFirst.get());
            return true;
        }
        a(uuid2);
        return true;
    }

    public static boolean a(UUID uuid, UUID uuid2, Optional<String> optional, Optional<Material> optional2, List<String> list, Optional<String> optional3) {
        if (list == null || list.size() == 0) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        Optional<ClanData> clan = Rewards.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            return false;
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        ArrayList arrayList = new ArrayList();
        clan.get().getMembers().iterator().forEachRemaining(uuid3 -> {
            if (Rewards.a().getModAPI().playerHasPermission(uuid3, Rewards.getModuleCore().c().j().getString("Config.Permissions.use.name"))) {
                arrayList.add(uuid3);
            }
        });
        if (arrayList.size() <= 0) {
            return false;
        }
        RewardsData rewardsData = new RewardsData(uuidRandomUUID, uuid, uuid2, optional, list, arrayList, optional2, jCurrentTimeMillis, optional3);
        f().put(uuidRandomUUID, rewardsData);
        a(rewardsData);
        Bukkit.getPluginManager().callEvent(new ClanRewardsEvent(uuid, optional, list));
        return true;
    }

    public static String a(UUID uuid, String str) {
        String strA;
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            if (!str.contains("%") && (strA = Rewards.getModuleCore().h().a(uuid, str)) != null) {
                return strA;
            }
            Matcher matcher = b.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strA2 = Rewards.getModuleCore().h().a(uuid, matcher.group(3));
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
        Rewards.getModuleCore().c().f().forEach((str4, enumConfiguration) -> {
            try {
                map.put(str4, new CommandData_show(a(enumConfiguration.getString(Lang.valueOf(str3 + "show"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "success"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "error"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Rewards.getModuleCore().c().a(Optional.empty()));
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

    public static void c() {
        Rewards.a().getCommandAPI().unRegisterCommand("rewards");
        Rewards.a().getCommandAPI().unRegisterCommand(Rewards.getModuleCore().c().k().getString("Commands.player.rewards.alias"));
        Rewards.a().getCommandAPI().registerCommand("rewards", new RewardsCommand());
        Rewards.a().getCommandAPI().registerCommand(Rewards.getModuleCore().c().k().getString("Commands.player.rewards.alias"), new RewardsCommand());
        Rewards.a().getCommandAPI().getCommandAliases().put("rewards", Rewards.getModuleCore().c().k().getString("Commands.player.rewards.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("collect", "list")) {
                if (Rewards.getModuleCore().c().k().contains("Commands.rewards." + str)) {
                    if (!Rewards.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Rewards.a().getCommandAPI().getCommandAliases().put(str, Rewards.getModuleCore().c().k().getString("Commands.rewards." + str + ".aliases"));
                    }
                    map.put(str, a("rewards", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Rewards.a().getCommandAPI().insertCommand("rewards", Rewards.getModuleCore().c().k().getString("Commands.player.rewards.permission"), Rewards.getModuleCore().c().k().getString("Commands.player.rewards.alias"), Rewards.getModuleCore().c().k().getDouble("Commands.player.rewards.value"), Rewards.getModuleCore().c().k().getInt("Commands.player.rewards.cooldown"), a("rewards", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Rewards.getModuleCore().c().k().getStringList("Commands.player.rewards.disabled_worlds"), Rewards.getModuleCore().c().k().getStringList("Commands.player.rewards.disabled_regions")));
    }

    public static void d() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Rewards.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Rewards.getModuleCore().c().j().contains("Config.Rewards.Icon.mimeslots")) {
                if (Rewards.getModuleCore().c().j().getStringList("Config.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Rewards.getModuleCore().c().j().getStringList("Config.Rewards.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Rewards.getModuleCore().c().j().getStringList("Config.Rewards.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Rewards.getModuleCore().c().j().getStringList("Config.Rewards.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Rewards.getModuleCore().c().j().getIntegerList("Config.Rewards.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Rewards.getModuleCore().c().j().contains("Config.Rewards.Icon.left_click_action")) {
                Rewards.getModuleCore().c().j().getStringList("Config.Rewards.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(a(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Rewards.getModuleCore().c().j().contains("Config.Rewards.Icon.right_click_action")) {
                Rewards.getModuleCore().c().j().getStringList("Config.Rewards.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(a(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Rewards.getModuleCore().c().f().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_rewards_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_rewards_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Rewards.getModuleCore().c().a(Optional.empty());
        map.put("module_rewards_item", new GuiItemsData(Rewards.getModuleCore().c().j().getString("Config.Rewards.Icon.page"), Rewards.getModuleCore().c().j().getString("Config.Rewards.Icon.click_sound"), Rewards.getModuleCore().c().j().getString("Config.Rewards.Icon.material"), 1, Rewards.getModuleCore().c().j().getBoolean("Config.Rewards.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Rewards center.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Rewards.getModuleCore().c().j().getString("Config.Rewards.Icon.texture"), new NbtData(Rewards.getModuleCore().c().j().getStringList("Config.Rewards.Icon.nbt.string"), Rewards.getModuleCore().c().j().getInt("Config.Rewards.Icon.model")), Rewards.getModuleCore().c().j().getInt("Config.Rewards.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Rewards.a().getGuiAPI().registerLocalizedInsertItem("General", "module_rewards_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void e() {
        ConfigurationSection configurationSection = Rewards.getModuleCore().c().j().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Rewards.getModuleCore().c().j().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Rewards.getModuleCore().c().j().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Rewards.getModuleCore().c().j().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Rewards.a().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Rewards.a().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }

    private static String a(String str) {
        return Rewards.a().getCommandAPI().replaceCmd(Rewards.a().getCommandAPI().replaceMainCmd(str));
    }

    public static ConcurrentHashMap<UUID, RewardsData> f() {
        return f158a;
    }

    private static String __unused_1402() {
        return "SURPRISE_";
    }

    private static String __unused_1403() {
        return "%";
    }

    private static String __unused_1404() {
        return "EN";
    }

    private static String __unused_1405() {
        return "rewards";
    }

    private static String __unused_1406() {
        return "Commands.player.rewards.alias";
    }

    private static String __unused_1407() {
        return "rewards";
    }

    private static String __unused_1408() {
        return "Commands.player.rewards.alias";
    }

    private static String __unused_1409() {
        return "rewards";
    }

    private static String __unused_1410() {
        return "Commands.player.rewards.alias";
    }

    private static String __unused_1411() {
        return "collect";
    }

    private static String __unused_1412() {
        return "list";
    }

    private static String __unused_1413() {
        return "rewards";
    }

    private static String __unused_1414() {
        return "rewards";
    }

    private static String __unused_1415() {
        return "Commands.player.rewards.permission";
    }

    private static String __unused_1416() {
        return "Commands.player.rewards.alias";
    }

    private static String __unused_1417() {
        return "Commands.player.rewards.value";
    }

    private static String __unused_1418() {
        return "Commands.player.rewards.cooldown";
    }

    private static String __unused_1419() {
        return "rewards";
    }

    private static String __unused_1420() {
        return "help";
    }

    private static String __unused_1421() {
        return "Commands.player.rewards.disabled_worlds";
    }

    private static String __unused_1422() {
        return "Commands.player.rewards.disabled_regions";
    }

    private static String __unused_1423() {
        return "General";
    }

    private static String __unused_1424() {
        return "General";
    }

    private static String __unused_1425() {
        return "Config.Rewards.Icon.mimeslots";
    }

    private static String __unused_1426() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_1427() {
        return "ALL";
    }

    private static String __unused_1428() {
        return "Config.Rewards.Icon.mimeslots";
    }

    private static String __unused_1429() {
        return "TOP";
    }

    private static String __unused_1430() {
        return "Config.Rewards.Icon.mimeslots";
    }

    private static String __unused_1431() {
        return "BOTTOM";
    }

    private static String __unused_1432() {
        return "Config.Rewards.Icon.mimeslots";
    }

    private static String __unused_1433() {
        return "BORDER";
    }

    private static String __unused_1434() {
        return "Config.Rewards.Icon.mimeslots";
    }

    private static String __unused_1435() {
        return "Config.Rewards.Icon.left_click_action";
    }

    private static String __unused_1436() {
        return "Config.Rewards.Icon.left_click_action";
    }

    private static String __unused_1437() {
        return "Config.Rewards.Icon.right_click_action";
    }

    private static String __unused_1438() {
        return "Config.Rewards.Icon.right_click_action";
    }

    private static String __unused_1439() {
        return "EN";
    }

    private static String __unused_1440() {
        return "<green>Rewards center.";
    }

    private static String __unused_1441() {
        return "EN";
    }

    private static String __unused_1442() {
        return "module_rewards_item";
    }

    private static String __unused_1443() {
        return "Config.Rewards.Icon.page";
    }

    private static String __unused_1444() {
        return "Config.Rewards.Icon.click_sound";
    }

    private static String __unused_1445() {
        return "Config.Rewards.Icon.material";
    }

    private static String __unused_1446() {
        return "Config.Rewards.Icon.glow";
    }

    private static String __unused_1447() {
        return "Config.Rewards.Icon.texture";
    }

    private static String __unused_1448() {
        return "Config.Rewards.Icon.nbt.string";
    }

    private static String __unused_1449() {
        return "Config.Rewards.Icon.model";
    }

    private static String __unused_1450() {
        return "Config.Rewards.Icon.slot";
    }

    private static String __unused_1451() {
        return "General";
    }

    private static String __unused_1452() {
        return "module_rewards_item";
    }

    private static String __unused_1453() {
        return "General";
    }

    private static String __unused_1454() {
        return "General";
    }

    private static String __unused_1455() {
        return "Config.Permissions";
    }

    private static String __unused_1456() {
        return "-";
    }

    private static String __unused_1457() {
        return ".";
    }

    private static String __unused_1458() {
        return "-";
    }

    private static String __unused_1459() {
        return "Config.Permissions.use.name";
    }

    private static String __unused_1460() {
        return "/";
    }

    private static String __unused_1461() {
        return "/";
    }

    private static String __unused_1462() {
        return "%player%";
    }

    private static String __unused_1463() {
        return "{player}";
    }

    private static String __unused_1464() {
        return "(%)(uclans_)(.+?)(%)";
    }
}
