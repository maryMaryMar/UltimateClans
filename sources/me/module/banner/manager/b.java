package me.module.banner.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import me.module.banner.Banner;
import me.module.banner.commands.BannerCommand;
import me.module.banner.manager.EnumFiles.Lang;
import me.module.banner.utils.DyeColorUtil;
import me.module.banner.utils.PatternTypeMapper;
import me.module.multiserver.library.redis.jedis.search.IndexOptions;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.BannerGroupData;
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
import me.ulrich.clans.events.ClanBannerChangeEvent;
import me.ulrich.clans.library.gui.builder.item.BannerBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.scoreboardlibrary.api.sidebar.Sidebar;
import me.ulrich.clans.library.udojava.evalex.Expression;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.utils.Nbts;
import me.ulrich.clans.manager.utils.Serialize;
import me.ulrich.clans.manager.utils.VersionUtil;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.PatternType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/b.class */
public class b {
    private static byte[] __aes_key_IhKlQtbB = {(byte) 209, (byte) 145, (byte) 8, (byte) 241, (byte) 31, (byte) 219, (byte) 245, (byte) 216, (byte) 163, (byte) 205, (byte) 25, (byte) 185, (byte) 205, (byte) 123, (byte) 227, (byte) 150, (byte) 169, (byte) 236, (byte) 87, (byte) 114, (byte) 113, (byte) 183, (byte) 233, (byte) 68, (byte) 98, (byte) 119, (byte) 169, (byte) 147, (byte) 82, (byte) 246, (byte) 215, (byte) 155};
    private static byte[] __aes_iv_3esNJPhd = {(byte) 53, (byte) 7, (byte) 136, (byte) 196, (byte) 71, (byte) 114, (byte) 231, (byte) 205, (byte) 17, (byte) 233, (byte) 165, (byte) 41, (byte) 184, (byte) 69, (byte) 139, (byte) 1};
    private static String __s_cache_M6LSpxIR_0;
    private static String __s_cache_1FklrPCf_1;
    private static String __s_cache_wNWQRGmG_2;
    private static String __s_cache_7BaDrV8a_3;
    private static String __s_cache_qWClYwP3_4;
    private static String __s_cache_B8iSTlk8_5;
    private static String __s_cache_v0xK7xni_6;
    private static String __s_cache_iAOmRigs_7;
    private static String __s_cache_yjLtd0Kd_8;
    private static String __s_cache_A2hUHfKG_9;
    private static String __s_cache_8BqDIXfg_10;
    private static String __s_cache_DJsqHGp8_11;
    private static String __s_cache_lb2a7yN6_12;
    private static String __s_cache_JVaTOY4W_13;
    private static String __s_cache_52ndy4An_14;
    private static String __s_cache_ApbYADRg_15;
    private static String __s_cache_nxsjud0t_16;
    private static String __s_cache_Ysv0CnxB_17;
    private static String __s_cache_3AEkE3E9_18;
    private static String __s_cache_AqvK5QBl_19;
    private static String __s_cache_gkcRMncp_20;
    private static String __s_cache_qNVLQC8z_21;
    private static String __s_cache_5ijzPoCQ_22;
    private static String __s_cache_wAKbA5Sr_23;
    private static String __s_cache_mHMxJ53h_24;
    private static String __s_cache_0e6uPCOr_25;
    private static String __s_cache_8sqLihXN_26;
    private static String __s_cache_OEfWjrFw_27;
    private static String __s_cache_qP3rmjeg_28;
    private static String __s_cache_okedLyC6_29;
    private static String __s_cache_nuqKPJtP_30;
    private static String __s_cache_MM0J1Jmx_31;
    private static String __s_cache_V8KxgYC6_32;
    private static String __s_cache_Y6PJ6okQ_33;
    private static String __s_cache_3Eq2wcTT_34;
    private static String __s_cache_zhHcQQ22_35;
    private static String __s_cache_L9JBBg0R_36;
    private static String __s_cache_vVjJWP0E_37;
    private static String __s_cache_ioDgPOPS_38;
    private static String __s_cache_HLIJSPMD_39;
    private static String __s_cache_JFVPitGk_40;
    private static String __s_cache_FKZVPCno_41;
    private static String __s_cache_VRwfgLkp_42;
    private static String __s_cache_04oBewED_43;
    private static String __s_cache_skS0Enrq_44;
    private static String __s_cache_vGWWqu9I_45;
    private static String __s_cache_NdPtO95m_46;
    private static String __s_cache_5k4DoWEQ_47;
    private static String __s_cache_VpYiyNPx_48;
    private static String __s_cache_vVtjzLwF_49;
    private static String __s_cache_TU2bJwRh_50;
    private static String __s_cache_nsmGjW1n_51;
    private static String __s_cache_zpsIqkxS_52;
    private static String __s_cache_tUbsHl66_53;
    private static String __s_cache_cBE1HZJK_54;
    private static String __s_cache_B7xRSEJW_55;
    private static String __s_cache_DTSsepvb_56;
    private static String __s_cache_y2ZBapGX_57;
    private static String __s_cache_smLMFHrp_58;
    private static String __s_cache_caqOIzWJ_59;
    private static String __s_cache_aIwlHp8D_60;
    private static String __s_cache_T66pGFhD_61;
    private static String __s_cache_0XLB18QA_62;
    private static String __s_cache_da24BLdX_63;
    private static String __s_cache_LrfNB8qb_64;
    private static String __s_cache_9UkjECrb_65;
    private static String __s_cache_po9MiEVP_66;
    private static String __s_cache_hPUd2k6J_67;
    private static String __s_cache_7eNU2swi_68;
    private static String __s_cache_XnyHzZLd_69;
    private static String __s_cache_faJLgwPS_70;
    private static String __s_cache_61PspYLL_71;
    private static String __s_cache_k7ZSF8IP_72;
    private static String __s_cache_Zq05IIYO_73;
    private static String __s_cache_gfF7G8dn_74;
    private static String __s_cache_YoMnQs4q_75;
    private static String __s_cache_FcqnBfss_76;
    private static String __s_cache_tvPrwMNR_77;
    private static String __s_cache_O6b5KAsf_78;
    private static String __s_cache_dWvESQr8_79;
    private static String __s_cache_pRP1BtPm_80;
    private static String __s_cache_fUjAzcLO_81;
    private static String __s_cache_oY0AgzVD_82;
    private static String __s_cache_hXbjoqre_83;
    private static String __s_cache_NGKvubue_84;
    private static String __s_cache_rOtnyjC9_85;
    private static String __s_cache_gF0iZhk3_86;
    private static String __s_cache_DodsZaHm_87;
    private static String __s_cache_vIhLmrZV_88;
    private static String __s_cache_ondQmZ7x_89;
    private static String __s_cache_kQqYurZ9_90;

    /* JADX INFO: renamed from: me.module.banner.manager.b$1, reason: invalid class name */
    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/b$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f101a = new int[Material.values().length];

        static {
            try {
                f101a[Material.DIAMOND_HELMET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f101a[Material.DIAMOND_CHESTPLATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f101a[Material.DIAMOND_LEGGINGS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f101a[Material.DIAMOND_BOOTS.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f101a[Material.IRON_HELMET.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f101a[Material.IRON_CHESTPLATE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f101a[Material.IRON_LEGGINGS.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f101a[Material.IRON_BOOTS.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f101a[Material.GOLDEN_HELMET.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f101a[Material.GOLDEN_CHESTPLATE.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f101a[Material.GOLDEN_LEGGINGS.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f101a[Material.GOLDEN_BOOTS.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f101a[Material.LEATHER_HELMET.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f101a[Material.LEATHER_CHESTPLATE.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f101a[Material.LEATHER_LEGGINGS.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f101a[Material.LEATHER_BOOTS.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f101a[Material.NETHERITE_HELMET.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f101a[Material.NETHERITE_CHESTPLATE.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f101a[Material.NETHERITE_LEGGINGS.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f101a[Material.NETHERITE_BOOTS.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f101a[Material.DIAMOND_SWORD.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f101a[Material.IRON_SWORD.ordinal()] = 22;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f101a[Material.GOLDEN_SWORD.ordinal()] = 23;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f101a[Material.NETHERITE_SWORD.ordinal()] = 24;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f101a[Material.WOODEN_SWORD.ordinal()] = 25;
            } catch (NoSuchFieldError e25) {
            }
            try {
                f101a[Material.STONE_SWORD.ordinal()] = 26;
            } catch (NoSuchFieldError e26) {
            }
            try {
                f101a[Material.BOW.ordinal()] = 27;
            } catch (NoSuchFieldError e27) {
            }
            try {
                f101a[Material.CROSSBOW.ordinal()] = 28;
            } catch (NoSuchFieldError e28) {
            }
            try {
                f101a[Material.SHEARS.ordinal()] = 29;
            } catch (NoSuchFieldError e29) {
            }
            try {
                f101a[Material.SHIELD.ordinal()] = 30;
            } catch (NoSuchFieldError e30) {
            }
        }
    }

    public static void a() {
        d();
        c();
        e();
    }

    public static boolean a(UUID uuid, ItemStack itemStack) {
        return b(uuid).stream().filter(itemStack2 -> {
            return itemStack2.getType().equals(itemStack.getType());
        }).findAny().isPresent();
    }

    public static List<Material> a(UUID uuid) {
        return (List) b(uuid).stream().map((v0) -> {
            return v0.getType();
        }).distinct().collect(Collectors.toList());
    }

    public static List<ItemStack> b(UUID uuid) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(uuid, ClanEnum.BannerFilter.BANNER));
        arrayList.addAll(a(uuid, ClanEnum.BannerFilter.COMMON));
        arrayList.addAll(a(uuid, ClanEnum.BannerFilter.HEAD));
        return arrayList;
    }

    public static Optional<BannerGroupData> a(ClanData clanData) {
        try {
            String str = new String();
            Iterator it = Banner.getModuleCore().c().h().getStringList("Config.Unlocker.banner").iterator();
            while (it.hasNext()) {
                String[] strArrSplit = ((String) it.next()).split(":");
                if (strArrSplit.length == 2) {
                    String strValueOf = String.valueOf(strArrSplit[0]);
                    if (clanData.getLevel() >= Integer.valueOf(strArrSplit[1]).intValue() && strValueOf != str) {
                        str = strValueOf;
                    }
                }
            }
            if (!str.isEmpty()) {
                return a(str.split(","));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<ItemStack> a(UUID uuid, ClanEnum.BannerFilter bannerFilter) {
        ArrayList arrayList = new ArrayList();
        Optional<ClanData> clan = Banner.a().getClanAPI().getClan(uuid);
        if (clan.isPresent()) {
            Optional<BannerGroupData> optionalA = a(clan.get());
            if (optionalA.isPresent()) {
                BannerGroupData bannerGroupData = optionalA.get();
                if (bannerFilter.equals(ClanEnum.BannerFilter.COMMON)) {
                    for (String str : bannerGroupData.getCommon()) {
                        if (str.startsWith("SUFFIX_")) {
                            List<Material> listCollectItemsByPrefixSuffix = Banner.getModuleCore().e().collectItemsByPrefixSuffix(null, str);
                            if (listCollectItemsByPrefixSuffix.size() > 0) {
                                listCollectItemsByPrefixSuffix.iterator().forEachRemaining(material -> {
                                    arrayList.add(new ItemStack(material));
                                });
                            }
                        } else if (str.startsWith("PREFIX_")) {
                            List<Material> listCollectItemsByPrefixSuffix2 = Banner.getModuleCore().e().collectItemsByPrefixSuffix(str, null);
                            if (listCollectItemsByPrefixSuffix2.size() > 0) {
                                listCollectItemsByPrefixSuffix2.iterator().forEachRemaining(material2 -> {
                                    arrayList.add(new ItemStack(material2));
                                });
                            }
                        } else if (str.equalsIgnoreCase("ALL")) {
                            List<Material> listCollectItemsByAll = Banner.getModuleCore().e().collectItemsByAll();
                            if (listCollectItemsByAll.size() > 0) {
                                listCollectItemsByAll.iterator().forEachRemaining(material3 -> {
                                    arrayList.add(new ItemStack(material3));
                                });
                            }
                        } else {
                            ItemStack itemStack = new ItemStack(Material.valueOf(str));
                            if (!arrayList.contains(itemStack)) {
                                try {
                                    arrayList.add(itemStack);
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                } else if (bannerFilter.equals(ClanEnum.BannerFilter.BANNER)) {
                    for (Map.Entry<String, ItemStack> entry : bannerGroupData.getBanners().entrySet()) {
                        if (!arrayList.contains(entry.getValue())) {
                            arrayList.add(entry.getValue());
                        }
                    }
                } else if (bannerFilter.equals(ClanEnum.BannerFilter.HEAD)) {
                    for (Map.Entry<String, ItemStack> entry2 : bannerGroupData.getHeads().entrySet()) {
                        if (!arrayList.contains(entry2.getValue())) {
                            arrayList.add(entry2.getValue());
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static Optional<BannerGroupData> a(String... strArr) {
        ConfigurationSection configurationSection;
        Set<String> keys;
        ConfigurationSection configurationSection2;
        Set<String> keys2;
        BannerGroupData bannerGroupData = new BannerGroupData(null, new HashMap(), new HashMap(), new ArrayList());
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (Banner.getModuleCore().c().h().contains("Config.Banner.groups.common." + str)) {
                Banner.getModuleCore().c().h().getStringList("Config.Banner.groups.common." + str).iterator().forEachRemaining(str2 -> {
                    arrayList.add(str2);
                });
            }
            bannerGroupData.setCommon(arrayList);
            if (Banner.getModuleCore().c().h().contains("Config.Banner.groups.head." + str) && (configurationSection2 = Banner.getModuleCore().c().h().getConfigurationSection("Config.Banner.groups.head." + str)) != null && (keys2 = configurationSection2.getKeys(false)) != null) {
                for (String str3 : keys2) {
                    Optional<ItemStack> optionalA = a(Banner.getModuleCore().c().h().getString("Config.Banner.groups.head." + str + "." + str3));
                    if (optionalA.isPresent()) {
                        bannerGroupData.getHeads().put(str3, optionalA.get());
                    }
                }
            }
            if (Banner.getModuleCore().c().h().contains("Config.Banner.groups.banner." + str) && (configurationSection = Banner.getModuleCore().c().h().getConfigurationSection("Config.Banner.groups.banner." + str)) != null && (keys = configurationSection.getKeys(false)) != null) {
                for (String str4 : keys) {
                    Optional<ItemStack> optionalA2 = a(new JSONObject(Banner.getModuleCore().c().h().getString("Config.Banner.groups.banner." + str + "." + str4)), str);
                    if (optionalA2.isPresent()) {
                        bannerGroupData.getBanners().put(str4, optionalA2.get());
                    }
                }
            }
        }
        return Optional.of(bannerGroupData);
    }

    public static Optional<ItemStack> a(JSONObject jSONObject, String str) {
        ItemStack itemStack;
        BannerBuilder bannerBuilderBanner;
        if (!jSONObject.has("Color") || !jSONObject.has("Patterns")) {
            return Optional.empty();
        }
        Material bannerMaterial = null;
        try {
            try {
                bannerMaterial = jSONObject.get("Color") instanceof Integer ? DyeColorUtil.toBannerMaterial(DyeColorUtil.of(jSONObject.getInt("Color"))) : DyeColorUtil.toBannerMaterial(DyeColor.valueOf(jSONObject.getString("Color")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (bannerMaterial != null && (itemStack = new ItemStack(bannerMaterial)) != null && (bannerBuilderBanner = ItemBuilder.banner(itemStack)) != null) {
                JSONArray jSONArray = jSONObject.getJSONArray("Patterns");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.has("Color") && jSONObject2.has("Pattern")) {
                        Optional.empty();
                        Optional.empty();
                        try {
                            Optional optionalOf = Optional.of(DyeColor.valueOf(jSONObject2.getString("Color").toUpperCase()));
                            try {
                                Optional<PatternType> patternType = new PatternTypeMapper().getPatternType(jSONObject2.getString("Pattern"));
                                if (!patternType.isPresent() || !optionalOf.isPresent()) {
                                    System.err.println("Erro ao converter Banner: " + jSONObject2.getString("Pattern"));
                                    return Optional.empty();
                                }
                                bannerBuilderBanner.pattern((DyeColor) optionalOf.get(), patternType.get());
                            } catch (IllegalArgumentException | IncompatibleClassChangeError | NullPointerException e2) {
                                e2.printStackTrace();
                                System.err.println("Erro ao converter PatternType: " + e2.getMessage());
                                return Optional.empty();
                            }
                        } catch (IllegalArgumentException | IncompatibleClassChangeError | NullPointerException e3) {
                            System.err.println("Erro ao converter DyeColor: " + e3.getMessage());
                            return Optional.empty();
                        }
                    }
                }
                if (VersionUtil.isAbove(VersionUtil.VersionEnum.V114)) {
                }
                ItemStack itemStackBuild = bannerBuilderBanner.build();
                if ((!VersionUtil.is(VersionUtil.VersionEnum.V120) || VersionUtil.BUILD_VERSION.intValue() < 3) && !VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
                    ItemBuilder itemBuilderFrom = ItemBuilder.from(itemStackBuild);
                    try {
                        itemBuilderFrom.flags(ItemFlag.HIDE_ATTRIBUTES);
                    } catch (Exception e4) {
                    }
                    try {
                        itemBuilderFrom.flags(ItemFlag.HIDE_ENCHANTS);
                    } catch (Exception e5) {
                    }
                    try {
                        itemBuilderFrom.flags(ItemFlag.HIDE_DYE);
                    } catch (Exception e6) {
                    }
                    itemStackBuild = itemBuilderFrom.build();
                } else {
                    try {
                        itemStackBuild = Banner.getModuleCore().h().a(itemStackBuild, ItemFlag.HIDE_ATTRIBUTES);
                    } catch (Exception e7) {
                    }
                    try {
                        itemStackBuild = Banner.getModuleCore().h().a(itemStackBuild, ItemFlag.HIDE_ENCHANTS);
                    } catch (Exception e8) {
                    }
                    try {
                        itemStackBuild = Banner.getModuleCore().h().a(itemStackBuild, ItemFlag.HIDE_DYE);
                    } catch (Exception e9) {
                    }
                }
                return Optional.of(itemStackBuild);
            }
        } catch (Exception e10) {
        }
        return Optional.empty();
    }

    public static Optional<ItemStack> a(String str) {
        ItemBuilder itemBuilderFrom;
        try {
            ItemBuilder.from(new ItemStack(Material.valueOf("PLAYER_HEAD".split(":")[0]), 1));
            if (str != null && !str.isEmpty() && (itemBuilderFrom = ItemBuilder.from(ItemBuilder.skull().texture(str).build())) != null) {
                return Optional.of(itemBuilderFrom.build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static List<Material> a(String str, String str2) {
        return (List) Arrays.stream(Material.values()).filter(material -> {
            return a(material);
        }).filter(material2 -> {
            return b(material2);
        }).filter(material3 -> {
            return a(material3, str, str2);
        }).collect(Collectors.toList());
    }

    public static List<Material> b() {
        return (List) Arrays.stream(Material.values()).filter(material -> {
            return a(material);
        }).filter(material2 -> {
            return b(material2);
        }).collect(Collectors.toList());
    }

    public static Optional<ItemStack> a(Object obj, String str) {
        return a((JSONObject) obj, str);
    }

    public static boolean a(UUID uuid, Player player) {
        Optional<ClanData> clan = Banner.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            return false;
        }
        clan.get().setBanner(null);
        Banner.a().getClanAPI().saveClanData(clan.get());
        Bukkit.getPluginManager().callEvent(new ClanBannerChangeEvent(clan.get().getId(), null));
        return true;
    }

    public static boolean a(UUID uuid, Player player, ItemStack itemStack) {
        Optional<ClanData> clan = Banner.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent() || itemStack == null) {
            return false;
        }
        ItemStack itemStackClone = itemStack.clone();
        itemStackClone.setAmount(1);
        ItemMeta itemMeta = itemStackClone.getItemMeta();
        itemMeta.setLore((List) null);
        itemStackClone.setItemMeta(itemMeta);
        if ((!VersionUtil.is(VersionUtil.VersionEnum.V120) || VersionUtil.BUILD_VERSION.intValue() < 3) && !VersionUtil.isAbove(VersionUtil.VersionEnum.V121)) {
            ItemBuilder itemBuilderFrom = ItemBuilder.from(itemStackClone);
            try {
                itemBuilderFrom.flags(ItemFlag.HIDE_ATTRIBUTES);
            } catch (Exception e) {
            }
            try {
                itemBuilderFrom.flags(ItemFlag.HIDE_ENCHANTS);
            } catch (Exception e2) {
            }
            if (VersionUtil.isAbove(VersionUtil.VersionEnum.V116)) {
                try {
                    itemBuilderFrom.flags(ItemFlag.HIDE_DYE);
                } catch (Exception e3) {
                }
            }
            itemStackClone = itemBuilderFrom.build();
        } else {
            try {
                itemStackClone = Banner.getModuleCore().h().a(itemStackClone, ItemFlag.HIDE_ATTRIBUTES);
            } catch (Exception e4) {
            }
            try {
                itemStackClone = Banner.getModuleCore().h().a(itemStackClone, ItemFlag.HIDE_ENCHANTS);
            } catch (Exception e5) {
            }
            try {
                itemStackClone = Banner.getModuleCore().h().a(itemStackClone, ItemFlag.HIDE_DYE);
            } catch (Exception e6) {
            }
        }
        String strItemStackToBase64 = new Serialize().itemStackToBase64(itemStackClone);
        if (strItemStackToBase64 == null) {
            return false;
        }
        clan.get().setBanner(strItemStackToBase64);
        Banner.a().getClanAPI().saveClanData(clan.get());
        Bukkit.getPluginManager().callEvent(new ClanBannerChangeEvent(clan.get().getId(), itemStack));
        return true;
    }

    public static Optional<ItemStack> c(UUID uuid) {
        Optional<ClanData> clan = Banner.a().getClanAPI().getClan(uuid);
        if (clan.isPresent()) {
            String text = Banner.a().getClanAPI().parseText(clan.get().getLeader(), "%uclans_banner%");
            ItemBuilder itemBuilderFrom = ItemBuilder.from(new ItemStack(Material.valueOf(Banner.a().getLibAPI().getDefaultBanner())));
            if (text != null && !text.isEmpty() && !text.equalsIgnoreCase("null")) {
                if (text.startsWith("material:")) {
                    itemBuilderFrom = ItemBuilder.from(new ItemStack(Material.valueOf(text.split("\\:")[1]), 1));
                } else if (text.startsWith("base64:")) {
                    String[] strArrSplit = text.split("\\:");
                    if (strArrSplit[1] != null && !strArrSplit[1].equalsIgnoreCase("null") && strArrSplit[1].length() > 16 && new String(Base64.getUrlDecoder().decode(strArrSplit[1])).contains("\"url\":\"http")) {
                        itemBuilderFrom = ItemBuilder.from(ItemBuilder.skull().texture(strArrSplit[1]).build());
                    }
                } else if (text.startsWith("serialized:")) {
                    try {
                        String[] strArrSplit2 = text.split("\\:");
                        if (strArrSplit2.length == 2 && strArrSplit2[1] != null && !strArrSplit2[1].isEmpty() && !strArrSplit2[1].equalsIgnoreCase("null") && strArrSplit2[1].length() > 16) {
                            ItemStack itemStackItemStackFromBase64 = new Serialize().itemStackFromBase64(strArrSplit2[1]);
                            itemBuilderFrom = itemStackItemStackFromBase64 == null ? ItemBuilder.from(Material.valueOf(Banner.a().getLibAPI().getDefaultBanner())) : ItemBuilder.from(itemStackItemStackFromBase64);
                        }
                    } catch (Exception e) {
                    }
                } else if (text != null && !text.equalsIgnoreCase("null") && text.length() > 16) {
                    itemBuilderFrom = ItemBuilder.from(ItemBuilder.skull().texture(text).build());
                }
            }
            if (itemBuilderFrom != null) {
                return Optional.of(new Nbts().setNbt(itemBuilderFrom.build(), "KEY", "VALUE"));
            }
        }
        return Optional.empty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Material material) {
        if (VersionUtil.isAbove(VersionUtil.VersionEnum.V112)) {
            return material.isItem();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Material material) {
        return material.getMaxStackSize() > 1 || c(material);
    }

    private static boolean c(Material material) {
        switch (AnonymousClass1.f101a[material.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case Expression.OPERATOR_PRECEDENCE_EQUALITY /* 7 */:
            case 8:
            case 9:
            case 10:
            case IndexOptions.DEFAULT_FLAGS /* 11 */:
            case 12:
            case 13:
            case 14:
            case Sidebar.MAX_LINES /* 15 */:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(Material material, String str, String str2) {
        String upperCase = material.name().toUpperCase();
        boolean zStartsWith = false;
        boolean zEndsWith = false;
        if (str != null && str.startsWith("PREFIX_")) {
            zStartsWith = upperCase.startsWith(str.substring("PREFIX_".length()).toUpperCase() + "_");
        }
        if (str2 != null && str2.startsWith("SUFFIX_")) {
            zEndsWith = upperCase.endsWith("_" + str2.substring("SUFFIX_".length()).toUpperCase());
        }
        return zStartsWith || zEndsWith;
    }

    private static CommandData_show c(String str) {
        HashMap map = new HashMap();
        String str2 = "COMMANDS_banner_" + str + "_";
        Banner.getModuleCore().c().d().forEach((str3, enumConfiguration) -> {
            try {
                map.put(str3, new CommandData_show(b(enumConfiguration.getString(Lang.valueOf(str2 + "show"))), b(enumConfiguration.getString(Lang.valueOf(str2 + "success"))), b(enumConfiguration.getString(Lang.valueOf(str2 + "error"))), b(enumConfiguration.getString(Lang.valueOf(str2 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Banner.getModuleCore().c().a(Optional.empty()));
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
        Banner.a().getCommandAPI().unRegisterCommand("banner");
        Banner.a().getCommandAPI().unRegisterCommand(Banner.getModuleCore().c().i().getString("Commands.player.alias"));
        Banner.a().getCommandAPI().registerCommand("banner", new BannerCommand());
        Banner.a().getCommandAPI().registerCommand(Banner.getModuleCore().c().i().getString("Commands.player.alias"), new BannerCommand());
        Banner.a().getCommandAPI().getCommandAliases().put("banner", Banner.getModuleCore().c().i().getString("Commands.player.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("upload", "delete", "view")) {
                if (Banner.getModuleCore().c().i().contains("Commands.banner." + str)) {
                    if (!Banner.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Banner.a().getCommandAPI().getCommandAliases().put(str, Banner.getModuleCore().c().i().getString("Commands.banner." + str + ".aliases"));
                    }
                    map.put(str, c(str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Banner.a().getCommandAPI().insertCommand("banner", Banner.getModuleCore().c().i().getString("Commands.player.permission"), Banner.getModuleCore().c().i().getString("Commands.player.alias"), Banner.getModuleCore().c().i().getDouble("Commands.player.value"), Banner.getModuleCore().c().i().getInt("Commands.player.cooldown"), c("help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Banner.getModuleCore().c().i().getStringList("Commands.player.disabled_worlds"), Banner.getModuleCore().c().i().getStringList("Commands.player.disabled_regions")));
    }

    public static void d() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Banner.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Banner.getModuleCore().c().h().contains("Config.Icon.mimeslots")) {
                if (Banner.getModuleCore().c().h().getStringList("Config.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Banner.getModuleCore().c().h().getStringList("Config.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Banner.getModuleCore().c().h().getStringList("Config.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Banner.getModuleCore().c().h().getStringList("Config.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Banner.getModuleCore().c().h().getIntegerList("Config.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Banner.getModuleCore().c().h().contains("Config.Icon.left_click_action")) {
                Banner.getModuleCore().c().h().getStringList("Config.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(b(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Banner.getModuleCore().c().h().contains("Config.Icon.right_click_action")) {
                Banner.getModuleCore().c().h().getStringList("Config.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(b(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Banner.getModuleCore().c().d().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Banner.getModuleCore().c().a(Optional.empty());
        GuiItemsData guiItemsData = new GuiItemsData("clan_home", Banner.getModuleCore().c().h().getString("Config.Icon.click_sound"), Banner.getModuleCore().c().h().getString("Config.Icon.material"), 1, Banner.getModuleCore().c().h().getBoolean("Config.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Clan Banner.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Banner.getModuleCore().c().h().getString("Config.Icon.texture"), new NbtData(Banner.getModuleCore().c().h().getStringList("Config.Icon.nbt.string"), Banner.getModuleCore().c().h().getInt("Config.Icon.model")), Banner.getModuleCore().c().h().getInt("Config.Icon.slot"), guiItemsData_fill, arrayList, arrayList2);
        Banner.a().getGuiAPI().registerLocalizedInsertItem("General", "module_banner_item", map2, map3);
        map.put("module_banner_item", guiItemsData);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void e() {
        ConfigurationSection configurationSection = Banner.getModuleCore().c().h().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Banner.getModuleCore().c().h().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Banner.getModuleCore().c().h().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Banner.getModuleCore().c().h().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Banner.a().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Banner.a().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }

    public static String b(String str) {
        return Banner.a().getCommandAPI().replaceCmd(Banner.a().getCommandAPI().replaceMainCmd(str));
    }

    private static String __unused_1531() {
        return "Config.Unlocker.banner";
    }

    private static String __unused_1532() {
        return ":";
    }

    private static String __unused_1533() {
        return ",";
    }

    private static String __unused_1534() {
        return "SUFFIX_";
    }

    private static String __unused_1535() {
        return "PREFIX_";
    }

    private static String __unused_1536() {
        return "ALL";
    }

    private static String __unused_1537() {
        return "Color";
    }

    private static String __unused_1538() {
        return "Patterns";
    }

    private static String __unused_1539() {
        return "Color";
    }

    private static String __unused_1540() {
        return "Color";
    }

    private static String __unused_1541() {
        return "Color";
    }

    private static String __unused_1542() {
        return "Patterns";
    }

    private static String __unused_1543() {
        return "Color";
    }

    private static String __unused_1544() {
        return "Pattern";
    }

    private static String __unused_1545() {
        return "Color";
    }

    private static String __unused_1546() {
        return "Pattern";
    }

    private static String __unused_1547() {
        return "Pattern";
    }

    private static String __unused_1548() {
        return "PLAYER_HEAD";
    }

    private static String __unused_1549() {
        return ":";
    }

    private static String __unused_1550() {
        return "%uclans_banner%";
    }

    private static String __unused_1551() {
        return "null";
    }

    private static String __unused_1552() {
        return "material:";
    }

    private static String __unused_1553() {
        return "\\:";
    }

    private static String __unused_1554() {
        return "base64:";
    }

    private static String __unused_1555() {
        return "\\:";
    }

    private static String __unused_1556() {
        return "null";
    }

    private static String __unused_1557() {
        return "\"url\":\"http";
    }

    private static String __unused_1558() {
        return "serialized:";
    }

    private static String __unused_1559() {
        return "\\:";
    }

    private static String __unused_1560() {
        return "null";
    }

    private static String __unused_1561() {
        return "null";
    }

    private static String __unused_1562() {
        return "KEY";
    }

    private static String __unused_1563() {
        return "VALUE";
    }

    private static String __unused_1564() {
        return "PREFIX_";
    }

    private static String __unused_1565() {
        return "PREFIX_";
    }

    private static String __unused_1566() {
        return "SUFFIX_";
    }

    private static String __unused_1567() {
        return "SUFFIX_";
    }

    private static String __unused_1568() {
        return "EN";
    }

    private static String __unused_1569() {
        return "banner";
    }

    private static String __unused_1570() {
        return "Commands.player.alias";
    }

    private static String __unused_1571() {
        return "banner";
    }

    private static String __unused_1572() {
        return "Commands.player.alias";
    }

    private static String __unused_1573() {
        return "banner";
    }

    private static String __unused_1574() {
        return "Commands.player.alias";
    }

    private static String __unused_1575() {
        return "upload";
    }

    private static String __unused_1576() {
        return "delete";
    }

    private static String __unused_1577() {
        return "view";
    }

    private static String __unused_1578() {
        return "banner";
    }

    private static String __unused_1579() {
        return "Commands.player.permission";
    }

    private static String __unused_1580() {
        return "Commands.player.alias";
    }

    private static String __unused_1581() {
        return "Commands.player.value";
    }

    private static String __unused_1582() {
        return "Commands.player.cooldown";
    }

    private static String __unused_1583() {
        return "help";
    }

    private static String __unused_1584() {
        return "Commands.player.disabled_worlds";
    }

    private static String __unused_1585() {
        return "Commands.player.disabled_regions";
    }

    private static String __unused_1586() {
        return "General";
    }

    private static String __unused_1587() {
        return "General";
    }

    private static String __unused_1588() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_1589() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_1590() {
        return "ALL";
    }

    private static String __unused_1591() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_1592() {
        return "TOP";
    }

    private static String __unused_1593() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_1594() {
        return "BOTTOM";
    }

    private static String __unused_1595() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_1596() {
        return "BORDER";
    }

    private static String __unused_1597() {
        return "Config.Icon.mimeslots";
    }

    private static String __unused_1598() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_1599() {
        return "Config.Icon.left_click_action";
    }

    private static String __unused_1600() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_1601() {
        return "Config.Icon.right_click_action";
    }

    private static String __unused_1602() {
        return "EN";
    }

    private static String __unused_1603() {
        return "<green>Clan Banner.";
    }

    private static String __unused_1604() {
        return "EN";
    }

    private static String __unused_1605() {
        return "clan_home";
    }

    private static String __unused_1606() {
        return "Config.Icon.click_sound";
    }

    private static String __unused_1607() {
        return "Config.Icon.material";
    }

    private static String __unused_1608() {
        return "Config.Icon.glow";
    }

    private static String __unused_1609() {
        return "Config.Icon.texture";
    }

    private static String __unused_1610() {
        return "Config.Icon.nbt.string";
    }

    private static String __unused_1611() {
        return "Config.Icon.model";
    }

    private static String __unused_1612() {
        return "Config.Icon.slot";
    }

    private static String __unused_1613() {
        return "General";
    }

    private static String __unused_1614() {
        return "module_banner_item";
    }

    private static String __unused_1615() {
        return "module_banner_item";
    }

    private static String __unused_1616() {
        return "General";
    }

    private static String __unused_1617() {
        return "General";
    }

    private static String __unused_1618() {
        return "Config.Permissions";
    }

    private static String __unused_1619() {
        return "-";
    }

    private static String __unused_1620() {
        return ".";
    }

    private static String __unused_1621() {
        return "-";
    }
}
