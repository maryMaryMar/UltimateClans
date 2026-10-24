package me.module.levelup.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import me.module.levelup.Levelup;
import me.module.levelup.commands.LevelCommand;
import me.module.levelup.manager.EnumFiles.Lang;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.GuiItemsData_fill;
import me.ulrich.clans.data.NbtData;
import me.ulrich.clans.data.PatentData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.RequerimentData;
import me.ulrich.clans.data.RequerimentData_Return;
import me.ulrich.clans.events.ClanLevelEvent;
import me.ulrich.clans.events.ClanPointChangeEvent;
import me.ulrich.clans.interfaces.RewardsModuleAPI;
import me.ulrich.clans.library.udojava.evalex.Expression;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/c.class */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, PatentData> f119a;
    private static ConcurrentHashMap<Integer, RequerimentData> b;
    private static String __s_cache_8IhwdoWn_0;
    private static String __s_cache_4HHopVBg_1;
    private static String __s_cache_dY12mJcv_2;
    private static String __s_cache_57n7Yfis_3;
    private static String __s_cache_RCyzt9uX_4;
    private static String __s_cache_dIRCgQgM_5;
    private static String __s_cache_AkmXd8mR_6;
    private static String __s_cache_bJAtEmyk_7;
    private static String __s_cache_avFkL8kS_8;
    private static String __s_cache_O6JORqra_9;
    private static String __s_cache_KbOoJMYd_10;
    private static String __s_cache_23Ny46xr_11;
    private static String __s_cache_BoLHzS2e_12;
    private static String __s_cache_aZ5rv0AN_13;
    private static String __s_cache_98mDE7ZS_14;
    private static String __s_cache_kAU31YIu_15;
    private static String __s_cache_HpkcQvZq_16;
    private static String __s_cache_1Mai1Qas_17;
    private static String __s_cache_bCuckKCw_18;
    private static String __s_cache_KlnXiORf_19;
    private static String __s_cache_YZDSgohe_20;
    private static String __s_cache_okOukWfq_21;
    private static String __s_cache_Oln1zQUK_22;
    private static String __s_cache_dYWy4TDW_23;
    private static String __s_cache_iiWnOgD0_24;
    private static String __s_cache_e0yRsPLH_25;
    private static String __s_cache_33K71kdR_26;
    private static String __s_cache_eMEvmXse_27;
    private static String __s_cache_F7V8zDTr_28;
    private static String __s_cache_R576DnId_29;
    private static String __s_cache_nXOyudkH_30;
    private static String __s_cache_xmBjiubW_31;
    private static String __s_cache_n6dxdgOZ_32;
    private static String __s_cache_X208RUBk_33;
    private static String __s_cache_XmCWAWYf_34;
    private static String __s_cache_BPrsoDXT_35;
    private static String __s_cache_35esUwkG_36;
    private static String __s_cache_okFMqoq3_37;
    private static String __s_cache_KEv5zzp2_38;
    private static String __s_cache_AA4VC4Ph_39;
    private static String __s_cache_rTfkbT9G_40;
    private static String __s_cache_xFj30PUS_41;
    private static String __s_cache_A9Gw17iv_42;
    private static String __s_cache_SWnxmQek_43;
    private static String __s_cache_2M7KVYji_44;
    private static String __s_cache_VEM5Yh6R_45;
    private static String __s_cache_SCWBZDUx_46;
    private static String __s_cache_RISx4f9E_47;
    private static String __s_cache_JOy4Snee_48;
    private static String __s_cache_PDcWSvSN_49;
    private static String __s_cache_bZpKyH2j_50;
    private static String __s_cache_QxKqGdWB_51;
    private static String __s_cache_7ZQ7YC4w_52;
    private static String __s_cache_m7wqAbs6_53;
    private static String __s_cache_aHfQT4Z3_54;
    private static String __s_cache_VjJmvGTZ_55;
    private static String __s_cache_jzh5UuRi_56;
    private static String __s_cache_iVqoPg0l_57;
    private static String __s_cache_BYt21HXD_58;
    private static String __s_cache_CduMKzQz_59;
    private static String __s_cache_fPRnSG6S_60;
    private static String __s_cache_XLjsRNFl_61;
    private static String __s_cache_egXUSvVA_62;
    private static String __s_cache_zry0nTXI_63;
    private static String __s_cache_4dj9PKBb_64;
    private static String __s_cache_K1RKt0A6_65;
    private static String __s_cache_EdZVGBF1_66;
    private static String __s_cache_JzFknouA_67;
    private static String __s_cache_dcQYqykD_68;
    private static String __s_cache_IezM0EpC_69;
    private static String __s_cache_Y4qFuGWR_70;
    private static String __s_cache_j1cJ9Lm3_71;
    private static String __s_cache_f6W8zvha_72;
    private static String __s_cache_tQKhYK9A_73;
    private static String __s_cache_bzIT4wvR_74;
    private static String __s_cache_BSLBtszB_75;
    private static String __s_cache_LfRGJWph_76;
    private static String __s_cache_GSJPTxHj_77;
    private static String __s_cache_MRG9JjvX_78;
    private static String __s_cache_3wre42Fy_79;
    private static String __s_cache_cbOukJLz_80;
    private static String __s_cache_yFKUeR8A_81;
    private static String __s_cache_u05sODYm_82;
    private static String __s_cache_29mxephY_83;
    private static String __s_cache_wEWLzxxq_84;
    private static String __s_cache_czjRv97m_85;
    private static String __s_cache_pSRKTbnL_86;
    private static byte[] __aes_key_m7GbhfKf = {(byte) 238, (byte) 93, (byte) 203, (byte) 158, (byte) 106, (byte) 51, (byte) 229, (byte) 24, (byte) 250, (byte) 105, (byte) 124, (byte) 251, (byte) 208, (byte) 212, (byte) 241, (byte) 128, (byte) 103, (byte) 118, (byte) 187, (byte) 19, (byte) 227, (byte) 93, (byte) 1, (byte) 43, (byte) 172, (byte) 157, (byte) 129, (byte) 152, (byte) 116, (byte) 96, (byte) 59, (byte) 93};
    private static byte[] __aes_iv_ZaV5KeqJ = {(byte) 173, (byte) 102, (byte) 85, (byte) 120, (byte) 232, (byte) 189, (byte) 3, (byte) 53, (byte) 178, (byte) 208, (byte) 113, (byte) 165, (byte) 52, (byte) 107, (byte) 165, (byte) 220};
    private static final Pattern c = Pattern.compile("(%)(uclans_)(.+?)(%)");

    public static void a() {
        f119a = new ConcurrentHashMap<>();
        b = new ConcurrentHashMap<>();
        f();
        e();
        g();
        b();
        c();
    }

    public static void b() {
        Set<String> keys;
        i().clear();
        ConfigurationSection configurationSection = Levelup.getModuleCore().c().i().getConfigurationSection("Level.requeriments.list");
        if (configurationSection != null && (keys = configurationSection.getKeys(false)) != null) {
            for (String str : keys) {
                String string = "";
                List arrayList = new ArrayList();
                List arrayList2 = new ArrayList();
                List arrayList3 = new ArrayList();
                List arrayList4 = new ArrayList();
                List arrayList5 = new ArrayList();
                int i = Levelup.getModuleCore().c().i().contains("Level.requeriments.list." + str + ".level") ? Levelup.getModuleCore().c().i().getInt("Level.requeriments.list." + str + ".level") : 0;
                if (Levelup.getModuleCore().c().i().contains("Level.requeriments.list." + str + ".rewards")) {
                    arrayList = Levelup.getModuleCore().c().i().getStringList("Level.requeriments.list." + str + ".rewards");
                }
                if (Levelup.getModuleCore().c().i().contains("Level.requeriments.list." + str + ".surprise")) {
                    arrayList2 = Levelup.getModuleCore().c().i().getStringList("Level.requeriments.list." + str + ".surprise");
                }
                if (Levelup.getModuleCore().c().i().contains("Level.requeriments.list." + str + ".requires")) {
                    arrayList3 = Levelup.getModuleCore().c().i().getStringList("Level.requeriments.list." + str + ".requires");
                }
                if (Levelup.getModuleCore().c().i().contains("Level.requeriments.list." + str + ".cost")) {
                    arrayList4 = Levelup.getModuleCore().c().i().getStringList("Level.requeriments.list." + str + ".cost");
                }
                if (Levelup.getModuleCore().c().i().contains("Level.requeriments.list." + str + ".points")) {
                    string = Levelup.getModuleCore().c().i().getString("Level.requeriments.list." + str + ".points");
                }
                if (Levelup.getModuleCore().c().i().contains("Level.requeriments.list." + str + ".description") && Levelup.getModuleCore().c().i().getStringList("Level.requeriments.list." + str + ".description").size() > 0) {
                    arrayList5 = Levelup.getModuleCore().c().i().getStringList("Level.requeriments.list." + str + ".description");
                }
                if (i <= 0 || b.containsKey(Integer.valueOf(i))) {
                    Levelup.getModuleCore().b().warning("Requeriment '" + str + "' cannot be loaded because it contains errors or duplicates another configured level.");
                } else {
                    if (string == null) {
                        string = "";
                    }
                    if (!string.trim().isEmpty() && !string.equalsIgnoreCase("{FORMULA}")) {
                        try {
                            Integer.parseInt(string.trim());
                        } catch (NumberFormatException e) {
                            Levelup.getModuleCore().b().warning("Requeriment '" + str + "' has an invalid points value ('" + string + "'). The points requirement will be disabled for this level.");
                            string = "";
                        }
                    }
                    b.put(Integer.valueOf(i), new RequerimentData(i, string, arrayList, arrayList2, arrayList3, arrayList4, arrayList5));
                }
            }
        }
        Levelup.getModuleCore().b().info("Loaded " + b.size() + " clan level requeriments(s).");
    }

    public static boolean a(int i) {
        return i().containsKey(Integer.valueOf(i));
    }

    public static Optional<RequerimentData> b(int i) {
        return a(i) ? Optional.of(i().get(Integer.valueOf(i))) : Optional.empty();
    }

    public static boolean c(int i) {
        Optional<RequerimentData> optionalB = b(i);
        return optionalB.isPresent() && optionalB.get().getSurprise().size() > 0;
    }

    public static Optional<Integer> a(UUID uuid) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        return clan.isPresent() ? Optional.of(Integer.valueOf(clan.get().getLevel())) : Optional.empty();
    }

    public static Optional<Integer> b(UUID uuid) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (clan.isPresent() && clan.get().getLevel() + 1 <= Levelup.getModuleCore().c().i().getInt("Level.points.max_level")) {
            return Optional.of(Integer.valueOf(clan.get().getLevel() + 1));
        }
        return Optional.empty();
    }

    public static boolean c(UUID uuid) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (clan.isPresent()) {
            return c(clan.get().getLevel());
        }
        return false;
    }

    public static boolean a(UUID uuid, int i) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        return clan.isPresent() && clan.get().getLevel() >= i;
    }

    public static Optional<Integer> d(UUID uuid) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        return clan.isPresent() ? Optional.of(Integer.valueOf(clan.get().getMaxlevel())) : Optional.empty();
    }

    public static List<RequerimentData_Return> e(UUID uuid) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            return new ArrayList();
        }
        Optional<Integer> optionalB = b(uuid);
        return !optionalB.isPresent() ? new ArrayList() : a(uuid, optionalB.get().intValue(), (Optional<UUID>) Optional.of(clan.get().getLeader()), (Optional<UUID>) Optional.empty());
    }

    private static List<RequerimentData_Return> a(UUID uuid, int i, Optional<UUID> optional, Optional<UUID> optional2) {
        ArrayList arrayList = new ArrayList();
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent() || i < 1 || i > Levelup.getModuleCore().c().i().getInt("Level.points.max_level")) {
            return arrayList;
        }
        Optional<RequerimentData> optionalB = b(i);
        if (optionalB.isPresent() && optionalB.get().getRequires() != null && !optionalB.get().getRequires().isEmpty()) {
            arrayList.addAll(new me.module.levelup.manager.b.c().a(optional.orElse(clan.get().getLeader()), optionalB.get().getRequires(), optional2));
        }
        Optional<Integer> optionalG = g(i);
        if (optionalG.isPresent()) {
            int iIntValue = optionalG.get().intValue();
            if (clan.get().getQuest().getPoints() >= iIntValue) {
                arrayList.add(new RequerimentData_Return(String.valueOf(iIntValue), Optional.of(Levelup.getModuleCore().c().b(optional2).getString(Lang.REQUIRES_POINTS_TRUE)), Optional.empty()));
            } else {
                arrayList.add(new RequerimentData_Return(String.valueOf(iIntValue), Optional.empty(), Optional.of(Levelup.getModuleCore().c().b(optional2).getString(Lang.REQUIRES_POINTS_FALSE))));
            }
        }
        return arrayList;
    }

    public static List<RequerimentData_Return> f(UUID uuid) {
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return new ArrayList();
        }
        Optional<Integer> optionalB = b(playerClan.get().getId());
        return !optionalB.isPresent() ? new ArrayList() : a(playerClan.get().getId(), optionalB.get().intValue(), (Optional<UUID>) Optional.of(uuid), (Optional<UUID>) Optional.of(uuid));
    }

    public static List<RequerimentData_Return> b(UUID uuid, int i) {
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(uuid);
        return !playerClan.isPresent() ? new ArrayList() : a(playerClan.get().getId(), i, (Optional<UUID>) Optional.of(uuid), (Optional<UUID>) Optional.of(uuid));
    }

    public static boolean g(UUID uuid) {
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(uuid);
        if (playerClan.isPresent() && b(playerClan.get().getId()).isPresent()) {
            return f(uuid).stream().noneMatch(requerimentData_Return -> {
                return requerimentData_Return.getFalseMessage().isPresent();
            });
        }
        return false;
    }

    public static boolean h(UUID uuid) {
        if (Levelup.a().getClanAPI().getClan(uuid).isPresent() && b(uuid).isPresent()) {
            return e(uuid).stream().noneMatch(requerimentData_Return -> {
                return requerimentData_Return.getFalseMessage().isPresent();
            });
        }
        return false;
    }

    private static Optional<Integer> g(int i) {
        Optional<RequerimentData> optionalB = b(i);
        if (!optionalB.isPresent()) {
            return Optional.of(Integer.valueOf(h(i)));
        }
        String points = optionalB.get().getPoints();
        if (points == null || points.trim().isEmpty()) {
            return Optional.empty();
        }
        if (points.equalsIgnoreCase("{FORMULA}")) {
            return Optional.of(Integer.valueOf(h(i)));
        }
        try {
            int i2 = Integer.parseInt(points.trim());
            return i2 >= 0 ? Optional.of(Integer.valueOf(i2)) : Optional.empty();
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    private static int h(int i) {
        return f(Math.max(0, i - 1));
    }

    private static int a(int i, int i2) {
        int iMax = Math.max(0, Levelup.getModuleCore().c().i().getInt("Level.points.start_level"));
        if (i2 <= iMax) {
            return i2;
        }
        int i3 = iMax;
        for (int i4 = iMax + 1; i4 <= i2; i4++) {
            Optional<Integer> optionalG = g(i4);
            if (optionalG.isPresent() && i < optionalG.get().intValue()) {
                break;
            }
            i3 = i4;
        }
        return i3;
    }

    public static boolean i(UUID uuid) {
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent() || !g(uuid)) {
            return false;
        }
        Optional<Integer> optionalB = b(playerClan.get().getId());
        if (!optionalB.isPresent()) {
            return false;
        }
        Optional<PatentData> optionalD = d(optionalB.get().intValue());
        Optional<RequerimentData> optionalB2 = b(optionalB.get().intValue());
        if (!optionalD.isPresent() || optionalB.get().intValue() <= playerClan.get().getLevel()) {
            return false;
        }
        if (optionalB2.isPresent() && !new me.module.levelup.manager.b.a().a(uuid, optionalB2.get().getCost())) {
            return false;
        }
        boolean z = false;
        if (!optionalD.get().getId().equals(playerClan.get().getPatent())) {
            playerClan.get().setPatent(optionalD.get().getId());
            z = true;
        }
        playerClan.get().setLevel(optionalB.get().intValue());
        Levelup.a().getClanAPI().saveClanData(playerClan.get());
        if (optionalB2.isPresent() && (!Levelup.getModuleCore().c().i().getBoolean("Level.requeriments.rewards_only_once") || (Levelup.getModuleCore().c().i().getBoolean("Level.requeriments.rewards_only_once") && playerClan.get().getMaxlevel() < optionalB.get().intValue()))) {
            Optional<String> optionalOf = Optional.of(Levelup.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.HELP_REWARDS_LEVELUP, Arrays.asList("{level};" + String.valueOf(optionalB.get()))));
            Optional<Material> optionalEmpty = Optional.empty();
            if (!Levelup.getModuleCore().c().i().getString("Level.requeriments.icon").isEmpty()) {
                optionalEmpty = Optional.of(Material.valueOf(Levelup.getModuleCore().c().i().getString("Level.requeriments.icon")));
            }
            Optional<RewardsModuleAPI> rewards = Levelup.a().getIntegrationAPI().getRewards();
            if (rewards.isPresent()) {
                rewards.get().addClanReward(playerClan.get().getId(), uuid, optionalOf, optionalEmpty, optionalB2.get().getRewards(), Optional.of("LEVEL"));
            } else {
                a(playerClan.get().getId(), optionalB2.get().getRewards());
            }
        }
        try {
            Bukkit.getPluginManager().callEvent(new ClanLevelEvent(playerClan.get().getId(), null, z));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean j(UUID uuid) {
        if (Levelup.getModuleCore().c().i().getBoolean("Level.points.block_level_decay")) {
            return false;
        }
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            return false;
        }
        int points = clan.get().getQuest().getPoints();
        int level = clan.get().getLevel();
        int iA = a(points, level);
        Optional<PatentData> optionalD = d(iA);
        if (!optionalD.isPresent() || iA >= level) {
            return false;
        }
        boolean z = false;
        if (!optionalD.get().getId().equals(clan.get().getPatent())) {
            clan.get().setPatent(optionalD.get().getId());
            z = true;
        }
        clan.get().setLevel(iA);
        Levelup.a().getClanAPI().saveClanData(clan.get());
        try {
            Bukkit.getPluginManager().callEvent(new ClanLevelEvent(clan.get().getId(), null, z));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void c() {
        Set<String> keys;
        f119a.clear();
        ConfigurationSection configurationSection = Levelup.getModuleCore().c().i().getConfigurationSection("Level.patent.list");
        if (configurationSection != null && (keys = configurationSection.getKeys(false)) != null) {
            for (String str : keys) {
                try {
                    f119a.put(str, new PatentData(str, Levelup.getModuleCore().c().i().getString("Level.patent.list." + str + ".name"), Levelup.getModuleCore().c().i().getInt("Level.patent.list." + str + ".required_level"), Levelup.getModuleCore().c().i().getStringList("Level.patent.list." + str + ".rewards"), Levelup.getModuleCore().c().i().getBoolean("Level.patent.list." + str + ".rewards_only_once"), Levelup.getModuleCore().c().i().getStringList("Level.patent.list." + str + ".rewards_disabled_world")));
                } catch (Exception e) {
                    Levelup.getModuleCore().b().warning("Patent '" + str + "' cannot be loaded because it contains errors.");
                }
            }
        }
        Levelup.getModuleCore().b().info("Loaded " + f119a.size() + " clan patent(s).");
    }

    public static boolean a(String str) {
        return str != null && f119a.containsKey(str);
    }

    public static Optional<PatentData> b(String str) {
        return Optional.ofNullable(str == null ? null : f119a.get(str)).or(() -> {
            return d();
        });
    }

    public static Optional<PatentData> d() {
        try {
            if (h().size() > 0) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                h().entrySet().iterator().forEachRemaining(entry -> {
                    linkedHashMap.put(((PatentData) entry.getValue()).getId(), Integer.valueOf(((PatentData) entry.getValue()).getRequiredlevel()));
                });
                Optional<PatentData> optionalB = b((String) ((Map.Entry) ((Map) linkedHashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap((v0) -> {
                    return v0.getKey();
                }, (v0) -> {
                    return v0.getValue();
                }, (num, num2) -> {
                    return num2;
                }, LinkedHashMap::new))).entrySet().iterator().next()).getKey());
                if (optionalB.isPresent()) {
                    return Optional.of(optionalB.get());
                }
            }
        } catch (Exception e) {
        }
        return Optional.empty();
    }

    public static Optional<PatentData> d(int i) {
        Optional<PatentData> optionalD = d();
        try {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            h().entrySet().iterator().forEachRemaining(entry -> {
                linkedHashMap.put(((PatentData) entry.getValue()).getId(), Integer.valueOf(((PatentData) entry.getValue()).getRequiredlevel()));
            });
            for (Map.Entry entry2 : ((Map) linkedHashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap((v0) -> {
                return v0.getKey();
            }, (v0) -> {
                return v0.getValue();
            }, (num, num2) -> {
                return num2;
            }, LinkedHashMap::new))).entrySet()) {
                if (i >= ((Integer) entry2.getValue()).intValue()) {
                    Optional<PatentData> optionalB = b((String) entry2.getKey());
                    if (optionalB.isPresent()) {
                        optionalD = optionalB;
                    }
                }
            }
        } catch (Exception e) {
        }
        return optionalD;
    }

    public static Optional<PatentData> k(UUID uuid) {
        Optional<PatentData> optionalD = d();
        try {
            Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
            if (clan.isPresent()) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                h().entrySet().iterator().forEachRemaining(entry -> {
                    linkedHashMap.put(((PatentData) entry.getValue()).getId(), Integer.valueOf(((PatentData) entry.getValue()).getRequiredlevel()));
                });
                for (Map.Entry entry2 : ((Map) linkedHashMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap((v0) -> {
                    return v0.getKey();
                }, (v0) -> {
                    return v0.getValue();
                }, (num, num2) -> {
                    return num2;
                }, LinkedHashMap::new))).entrySet()) {
                    if (clan.get().getLevel() >= ((Integer) entry2.getValue()).intValue()) {
                        Optional<PatentData> optionalB = b((String) entry2.getKey());
                        if (optionalB.isPresent()) {
                            optionalD = optionalB;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        return optionalD;
    }

    public static double e(int i) {
        if (i == 0) {
            i = 1;
        }
        int i2 = Levelup.getModuleCore().c().i().getInt("Level.points.base");
        if (i2 <= 0) {
            i2 = 1;
        }
        double d = Levelup.getModuleCore().c().i().getDouble("Level.points.exponent");
        try {
            return new Expression(Levelup.getModuleCore().c().i().getString("Level.points.formula").replace("{BASE}", String.valueOf(i2)).replace("{CLAN_LEVEL}", String.valueOf(i)).replace("{EXPONENT}", String.valueOf(d))).eval().intValue();
        } catch (Exception e) {
            UUID uuidRandomUUID = UUID.randomUUID();
            if (!CooldownAPI.isInCooldown(uuidRandomUUID, "eval")) {
                new CooldownAPI(uuidRandomUUID, "eval", 300).start();
                Levelup.getModuleCore().b().warning("ScriptEngine failed, using formula for default level '({CLAN_LEVEL}*{BASE})*{EXPONENT}'. For expressions use only operators like +, -, *, /, ^ etc...");
            }
            return ((double) (i * i2)) * d;
        }
    }

    public static int f(int i) {
        int iE = 0;
        for (int i2 = 0; i2 <= i; i2++) {
            iE = (int) (((double) iE) + e(i2));
        }
        return iE;
    }

    public static int a(double d) {
        int i = Levelup.getModuleCore().c().i().getInt("Level.points.max_level");
        if (i <= 0 || d < 0.0d) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 1; i3 <= i && d >= h(i3); i3++) {
            i2 = i3;
        }
        return i2;
    }

    public static int a(ClanData clanData) {
        if (clanData == null) {
            return 0;
        }
        Optional<Integer> optionalB = b(clanData.getId());
        if (!optionalB.isPresent()) {
            return 0;
        }
        Optional<Integer> optionalG = g(optionalB.get().intValue());
        if (optionalG.isPresent()) {
            return Math.max(0, optionalG.get().intValue() - clanData.getQuest().getPoints());
        }
        return 0;
    }

    @Deprecated
    public static void a(ClanData clanData, CommandSender commandSender) {
        int points = clanData.getQuest().getPoints();
        int level = clanData.getLevel();
        int i = Levelup.getModuleCore().c().i().getInt("Level.points.max_level");
        int iA = a(points);
        Optional<PatentData> optionalD = d(iA);
        if (iA == level || !optionalD.isPresent()) {
            return;
        }
        if (i > 0 && iA >= i) {
            iA = i;
            if (level >= i) {
                return;
            }
        }
        boolean z = false;
        if (!optionalD.get().getId().equals(clanData.getPatent())) {
            clanData.setPatent(optionalD.get().getId());
            z = true;
        }
        clanData.setLevel(iA);
        Levelup.a().getClanAPI().saveClanData(clanData);
        try {
            Bukkit.getPluginManager().callEvent(new ClanLevelEvent(clanData.getId(), commandSender, z));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(ClanEnum.ClanActions clanActions, UUID uuid) {
        if (Levelup.a().getClanAPI().getClan(uuid).isPresent()) {
            StringBuilder sb = new StringBuilder();
            Levelup.getModuleCore().d().runTaskLater(() -> {
                int i;
                if (!Levelup.getModuleCore().c().i().contains("Level.actions." + clanActions.toString()) || (i = Levelup.getModuleCore().c().i().getInt("Level.actions." + clanActions.toString())) == 0) {
                    return;
                }
                sb.append(Levelup.getModuleCore().c().c().getString(Lang.CLAN_POINT_REASON_LEVEL_CHANGE));
                if (i > 0) {
                    a(uuid, i, (CommandSender) null, sb);
                } else if (i < 0) {
                    b(uuid, Math.abs(i), null, sb);
                }
            }, 20L);
        }
    }

    public static boolean a(UUID uuid, int i, CommandSender commandSender, StringBuilder sb) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        String string = "";
        if (sb != null) {
            try {
                if (sb.length() != 0) {
                    string = sb.toString();
                }
            } catch (Exception e) {
            }
        }
        if (commandSender == null) {
            try {
                Bukkit.getConsoleSender();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        if (!clan.isPresent()) {
            return false;
        }
        if (string.isEmpty()) {
            string = Levelup.getModuleCore().c().c().getString(Lang.CLAN_POINT_REASON_NO_REASON);
        }
        int points = clan.get().getQuest().getPoints() + i;
        clan.get().getQuest().setPoints(points);
        Levelup.a().getClanAPI().saveClanData(clan.get());
        try {
            String string2 = Levelup.getModuleCore().c().c().getString(Lang.NEW_POINT_RECEIVED, Arrays.asList("%points%;" + i, "%totalpoints%;" + points, "%reason%;" + string.toString()));
            if (string2 != null) {
                try {
                    if (!string2.isEmpty() && !string2.equalsIgnoreCase("NULL") && !string2.isEmpty()) {
                        MessageUtils.clanMessageSend(clan.get(), string2);
                    }
                } catch (Exception e3) {
                }
            }
            try {
                Bukkit.getPluginManager().callEvent(new ClanPointChangeEvent(uuid, points));
            } catch (Exception e4) {
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return true;
        }
    }

    public static boolean b(UUID uuid, int i, CommandSender commandSender, StringBuilder sb) {
        String string = "";
        if (sb != null) {
            try {
                if (sb.length() != 0) {
                    string = sb.toString();
                }
            } catch (Exception e) {
            }
        }
        if (commandSender == null) {
            try {
                Bukkit.getConsoleSender();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            return false;
        }
        if (string.isEmpty()) {
            string = Levelup.getModuleCore().c().c().getString(Lang.CLAN_POINT_REASON_NO_REASON);
        }
        if (clan.get().getQuest().getPoints() == 0) {
            return true;
        }
        int points = clan.get().getQuest().getPoints() - i;
        if (points < 1) {
            points = 0;
        }
        clan.get().getQuest().setPoints(points);
        Levelup.a().getClanAPI().saveClanData(clan.get());
        try {
            String string2 = Levelup.getModuleCore().c().c().getString(Lang.NEW_POINT_REMOVED, Arrays.asList("%points%;" + i, "%totalpoints%;" + points, "%reason%;" + string.toString()));
            if (string2 != null) {
                try {
                    if (!string2.isEmpty() && !string2.equalsIgnoreCase("NULL") && !string2.isEmpty()) {
                        MessageUtils.clanMessageSend(clan.get(), string2);
                    }
                } catch (Exception e3) {
                }
            }
            try {
                Bukkit.getPluginManager().callEvent(new ClanPointChangeEvent(uuid, points));
            } catch (Exception e4) {
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return true;
        }
    }

    public static boolean c(UUID uuid, int i, CommandSender commandSender, StringBuilder sb) {
        String string = "";
        if (sb != null) {
            try {
                if (sb.length() != 0) {
                    string = sb.toString();
                }
            } catch (Exception e) {
            }
        }
        if (commandSender == null) {
            try {
                Bukkit.getConsoleSender();
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            return false;
        }
        if (string.isEmpty()) {
            string = Levelup.getModuleCore().c().c().getString(Lang.CLAN_POINT_REASON_NO_REASON);
        }
        if (i < 1) {
            i = 0;
        }
        clan.get().getQuest().setPoints(i);
        Levelup.a().getClanAPI().saveClanData(clan.get());
        try {
            String string2 = Levelup.getModuleCore().c().c().getString(Lang.NEW_POINT_SET, Arrays.asList("%points%;" + i, "%totalpoints%;" + i, "%reason%;" + string.toString()));
            if (string2 != null) {
                try {
                    if (!string2.isEmpty() && !string2.equalsIgnoreCase("NULL") && !string2.isEmpty()) {
                        MessageUtils.clanMessageSend(clan.get(), string2);
                    }
                } catch (Exception e3) {
                }
            }
            try {
                Bukkit.getPluginManager().callEvent(new ClanPointChangeEvent(uuid, i));
            } catch (Exception e4) {
            }
            return true;
        } catch (Exception e5) {
            e5.printStackTrace();
            return true;
        }
    }

    public static boolean a(UUID uuid, List<String> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            return false;
        }
        boolean z = false;
        Iterator<UUID> it = clan.get().getMembers().iterator();
        while (it.hasNext()) {
            Optional<PlayerData> playerData = Levelup.a().getPlayerAPI().getPlayerData(it.next());
            if (playerData.isPresent()) {
                String name = playerData.get().getName();
                Iterator<String> it2 = list.iterator();
                while (it2.hasNext()) {
                    String strReplace = it2.next().replace("%player%", name);
                    if (strReplace.startsWith("/")) {
                        strReplace = strReplace.substring(1);
                    }
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), strReplace);
                    z = true;
                }
            }
        }
        return z;
    }

    public static String a(UUID uuid, String str) {
        String strA;
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            if (!str.contains("%") && (strA = Levelup.getModuleCore().i().a(uuid, str)) != null) {
                return strA;
            }
            Matcher matcher = c.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strA2 = Levelup.getModuleCore().i().a(uuid, matcher.group(3));
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
        Levelup.getModuleCore().c().e().forEach((str4, enumConfiguration) -> {
            try {
                map.put(str4, new CommandData_show(c(enumConfiguration.getString(Lang.valueOf(str3 + "show"))), c(enumConfiguration.getString(Lang.valueOf(str3 + "success"))), c(enumConfiguration.getString(Lang.valueOf(str3 + "error"))), c(enumConfiguration.getString(Lang.valueOf(str3 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Levelup.getModuleCore().c().a(Optional.empty()));
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

    public static void e() {
        Levelup.a().getCommandAPI().unRegisterCommand("level");
        Levelup.a().getCommandAPI().unRegisterCommand(Levelup.getModuleCore().c().j().getString("Commands.player.level.alias"));
        Levelup.a().getCommandAPI().registerCommand("level", new LevelCommand());
        Levelup.a().getCommandAPI().registerCommand(Levelup.getModuleCore().c().j().getString("Commands.player.level.alias"), new LevelCommand());
        Levelup.a().getCommandAPI().getCommandAliases().put("level", Levelup.getModuleCore().c().j().getString("Commands.player.level.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("up", "view")) {
                if (Levelup.getModuleCore().c().j().contains("Commands.level." + str)) {
                    if (!Levelup.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Levelup.a().getCommandAPI().getCommandAliases().put(str, Levelup.getModuleCore().c().j().getString("Commands.level." + str + ".aliases"));
                    }
                    map.put(str, a("level", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Levelup.a().getCommandAPI().insertCommand("level", Levelup.getModuleCore().c().j().getString("Commands.player.level.permission"), Levelup.getModuleCore().c().j().getString("Commands.player.level.alias"), Levelup.getModuleCore().c().j().getDouble("Commands.player.level.value"), Levelup.getModuleCore().c().j().getInt("Commands.player.level.cooldown"), a("level", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Levelup.getModuleCore().c().j().getStringList("Commands.player.level.disabled_worlds"), Levelup.getModuleCore().c().j().getStringList("Commands.player.level.disabled_regions")));
    }

    public static void f() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Levelup.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Levelup.getModuleCore().c().i().contains("Config.Levelup.Icon.mimeslots")) {
                if (Levelup.getModuleCore().c().i().getStringList("Config.Levelup.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Levelup.getModuleCore().c().i().getStringList("Config.Levelup.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Levelup.getModuleCore().c().i().getStringList("Config.Levelup.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Levelup.getModuleCore().c().i().getStringList("Config.Levelup.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Levelup.getModuleCore().c().i().getIntegerList("Config.Levelup.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Levelup.getModuleCore().c().i().contains("Config.Levelup.Icon.left_click_action")) {
                Levelup.getModuleCore().c().i().getStringList("Config.Levelup.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(c(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Levelup.getModuleCore().c().i().contains("Config.Levelup.Icon.right_click_action")) {
                Levelup.getModuleCore().c().i().getStringList("Config.Levelup.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(c(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Levelup.getModuleCore().c().e().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_levelup_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_levelup_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Levelup.getModuleCore().c().a(Optional.empty());
        map.put("module_levelup_item", new GuiItemsData(Levelup.getModuleCore().c().i().getString("Config.Levelup.Icon.page"), Levelup.getModuleCore().c().i().getString("Config.Levelup.Icon.click_sound"), Levelup.getModuleCore().c().i().getString("Config.Levelup.Icon.material"), 1, Levelup.getModuleCore().c().i().getBoolean("Config.Levelup.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Clan Levelup.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Levelup.getModuleCore().c().i().getString("Config.Levelup.Icon.texture"), new NbtData(Levelup.getModuleCore().c().i().getStringList("Config.Levelup.Icon.nbt.string"), Levelup.getModuleCore().c().i().getInt("Config.Levelup.Icon.model")), Levelup.getModuleCore().c().i().getInt("Config.Levelup.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Levelup.a().getGuiAPI().registerLocalizedInsertItem("General", "module_levelup_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void g() {
        ConfigurationSection configurationSection = Levelup.getModuleCore().c().i().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Levelup.getModuleCore().c().i().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Levelup.getModuleCore().c().i().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Levelup.getModuleCore().c().i().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Levelup.a().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Levelup.a().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }

    public static String a(String str, List<String> list) {
        if (list != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(";");
                    str = str.replace(strArrSplit[0], strArrSplit[1]);
                }
                return str;
            } catch (Exception e) {
            }
        }
        return str;
    }

    private static String c(String str) {
        return Levelup.a().getCommandAPI().replaceCmd(Levelup.a().getCommandAPI().replaceMainCmd(str));
    }

    public static ConcurrentHashMap<String, PatentData> h() {
        return f119a;
    }

    public static ConcurrentHashMap<Integer, RequerimentData> i() {
        return b;
    }

    private static String __unused_803() {
        return "Level.requeriments.list";
    }

    private static String __unused_804() {
        return "{FORMULA}";
    }

    private static String __unused_805() {
        return "Level.points.max_level";
    }

    private static String __unused_806() {
        return "Level.points.max_level";
    }

    private static String __unused_807() {
        return "{FORMULA}";
    }

    private static String __unused_808() {
        return "Level.points.start_level";
    }

    private static String __unused_809() {
        return "Level.requeriments.rewards_only_once";
    }

    private static String __unused_810() {
        return "Level.requeriments.rewards_only_once";
    }

    private static String __unused_811() {
        return "Level.requeriments.icon";
    }

    private static String __unused_812() {
        return "Level.requeriments.icon";
    }

    private static String __unused_813() {
        return "LEVEL";
    }

    private static String __unused_814() {
        return "Level.points.block_level_decay";
    }

    private static String __unused_815() {
        return "Level.patent.list";
    }

    private static String __unused_816() {
        return "Level.points.base";
    }

    private static String __unused_817() {
        return "Level.points.exponent";
    }

    private static String __unused_818() {
        return "Level.points.formula";
    }

    private static String __unused_819() {
        return "{BASE}";
    }

    private static String __unused_820() {
        return "{CLAN_LEVEL}";
    }

    private static String __unused_821() {
        return "{EXPONENT}";
    }

    private static String __unused_822() {
        return "eval";
    }

    private static String __unused_823() {
        return "eval";
    }

    private static String __unused_824() {
        return "ScriptEngine failed, using formula for default level '({CLAN_LEVEL}*{BASE})*{EXPONENT}'. For expressions use only operators like +, -, *, /, ^ etc...";
    }

    private static String __unused_825() {
        return "Level.points.max_level";
    }

    private static String __unused_826() {
        return "Level.points.max_level";
    }

    private static String __unused_827() {
        return "NULL";
    }

    private static String __unused_828() {
        return "NULL";
    }

    private static String __unused_829() {
        return "NULL";
    }

    private static String __unused_830() {
        return "%player%";
    }

    private static String __unused_831() {
        return "/";
    }

    private static String __unused_832() {
        return "%";
    }

    private static String __unused_833() {
        return "EN";
    }

    private static String __unused_834() {
        return "level";
    }

    private static String __unused_835() {
        return "Commands.player.level.alias";
    }

    private static String __unused_836() {
        return "level";
    }

    private static String __unused_837() {
        return "Commands.player.level.alias";
    }

    private static String __unused_838() {
        return "level";
    }

    private static String __unused_839() {
        return "Commands.player.level.alias";
    }

    private static String __unused_840() {
        return "up";
    }

    private static String __unused_841() {
        return "view";
    }

    private static String __unused_842() {
        return "level";
    }

    private static String __unused_843() {
        return "level";
    }

    private static String __unused_844() {
        return "Commands.player.level.permission";
    }

    private static String __unused_845() {
        return "Commands.player.level.alias";
    }

    private static String __unused_846() {
        return "Commands.player.level.value";
    }

    private static String __unused_847() {
        return "Commands.player.level.cooldown";
    }

    private static String __unused_848() {
        return "level";
    }

    private static String __unused_849() {
        return "help";
    }

    private static String __unused_850() {
        return "Commands.player.level.disabled_worlds";
    }

    private static String __unused_851() {
        return "Commands.player.level.disabled_regions";
    }

    private static String __unused_852() {
        return "General";
    }

    private static String __unused_853() {
        return "General";
    }

    private static String __unused_854() {
        return "Config.Levelup.Icon.mimeslots";
    }

    private static String __unused_855() {
        return "Config.Levelup.Icon.mimeslots";
    }

    private static String __unused_856() {
        return "ALL";
    }

    private static String __unused_857() {
        return "Config.Levelup.Icon.mimeslots";
    }

    private static String __unused_858() {
        return "TOP";
    }

    private static String __unused_859() {
        return "Config.Levelup.Icon.mimeslots";
    }

    private static String __unused_860() {
        return "BOTTOM";
    }

    private static String __unused_861() {
        return "Config.Levelup.Icon.mimeslots";
    }

    private static String __unused_862() {
        return "BORDER";
    }

    private static String __unused_863() {
        return "Config.Levelup.Icon.mimeslots";
    }

    private static String __unused_864() {
        return "Config.Levelup.Icon.left_click_action";
    }

    private static String __unused_865() {
        return "Config.Levelup.Icon.left_click_action";
    }

    private static String __unused_866() {
        return "Config.Levelup.Icon.right_click_action";
    }

    private static String __unused_867() {
        return "Config.Levelup.Icon.right_click_action";
    }

    private static String __unused_868() {
        return "EN";
    }

    private static String __unused_869() {
        return "<green>Clan Levelup.";
    }

    private static String __unused_870() {
        return "EN";
    }

    private static String __unused_871() {
        return "module_levelup_item";
    }

    private static String __unused_872() {
        return "Config.Levelup.Icon.page";
    }

    private static String __unused_873() {
        return "Config.Levelup.Icon.click_sound";
    }

    private static String __unused_874() {
        return "Config.Levelup.Icon.material";
    }

    private static String __unused_875() {
        return "Config.Levelup.Icon.glow";
    }

    private static String __unused_876() {
        return "Config.Levelup.Icon.texture";
    }

    private static String __unused_877() {
        return "Config.Levelup.Icon.nbt.string";
    }

    private static String __unused_878() {
        return "Config.Levelup.Icon.model";
    }

    private static String __unused_879() {
        return "Config.Levelup.Icon.slot";
    }

    private static String __unused_880() {
        return "General";
    }

    private static String __unused_881() {
        return "module_levelup_item";
    }

    private static String __unused_882() {
        return "General";
    }

    private static String __unused_883() {
        return "General";
    }

    private static String __unused_884() {
        return "Config.Permissions";
    }

    private static String __unused_885() {
        return "-";
    }

    private static String __unused_886() {
        return ".";
    }

    private static String __unused_887() {
        return "-";
    }

    private static String __unused_888() {
        return ";";
    }

    private static String __unused_889() {
        return "(%)(uclans_)(.+?)(%)";
    }
}
