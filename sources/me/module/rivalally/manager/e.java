package me.module.rivalally.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import me.module.rivalally.Rivalally;
import me.module.rivalally.commands.AllyCommand;
import me.module.rivalally.commands.RivalCommand;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.ulrich.clans.api.GuiAPIManager;
import me.ulrich.clans.data.AllyInvite;
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
import me.ulrich.clans.data.RivalRemove;
import me.ulrich.clans.events.ClanAllyAddEvent;
import me.ulrich.clans.events.ClanAllyRemoveEvent;
import me.ulrich.clans.events.ClanRivalAddEvent;
import me.ulrich.clans.events.ClanRivalRemoveEvent;
import me.ulrich.clans.interfaces.LevelupModuleAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/e.class */
public class e {
    private static String __s_cache_FwtxdtsB_0;
    private static String __s_cache_X8Z0Z6MF_1;
    private static String __s_cache_4SZ2sUmH_2;
    private static String __s_cache_gdgQDVRv_3;
    private static String __s_cache_XEB6falp_4;
    private static String __s_cache_NGF88n54_5;
    private static String __s_cache_RLeiylxc_6;
    private static String __s_cache_ZMGpOftX_7;
    private static String __s_cache_gsUsuR8N_8;
    private static String __s_cache_PaRS3ro2_9;
    private static String __s_cache_GMcEnhWF_10;
    private static String __s_cache_RjFHSmTM_11;
    private static String __s_cache_yL0MS7FY_12;
    private static String __s_cache_p84ZQupm_13;
    private static String __s_cache_Mq6z8vgS_14;
    private static String __s_cache_7aCraJ4X_15;
    private static String __s_cache_Oge4psdf_16;
    private static String __s_cache_EiOx5Q91_17;
    private static String __s_cache_ywedbzO5_18;
    private static String __s_cache_h3K2d9CE_19;
    private static String __s_cache_R2w5ArQA_20;
    private static String __s_cache_4sNE8lMB_21;
    private static String __s_cache_KYACdWvy_22;
    private static String __s_cache_OBlCOczS_23;
    private static String __s_cache_zKRwH55S_24;
    private static String __s_cache_DPbJpqj8_25;
    private static String __s_cache_vfpKMJ1R_26;
    private static String __s_cache_wB12EeNL_27;
    private static String __s_cache_qjTbua2b_28;
    private static String __s_cache_fWcKTesb_29;
    private static String __s_cache_Km8o41ox_30;
    private static String __s_cache_nO2I51Mj_31;
    private static String __s_cache_OUt6QJfN_32;
    private static String __s_cache_7wUccpRk_33;
    private static String __s_cache_0VjuSQ9I_34;
    private static String __s_cache_LltOrVKG_35;
    private static String __s_cache_kzairYI2_36;
    private static String __s_cache_ugrYfxay_37;
    private static String __s_cache_eX8ra6Te_38;
    private static String __s_cache_npAqzPTj_39;
    private static String __s_cache_hWLdLmF6_40;
    private static String __s_cache_Yz5FDqEN_41;
    private static String __s_cache_4F9dtQDR_42;
    private static String __s_cache_v8zINAaw_43;
    private static String __s_cache_LhYKgEEO_44;
    private static String __s_cache_oNjy3dxG_45;
    private static String __s_cache_1lL3oThO_46;
    private static String __s_cache_Y5Ofk7xq_47;
    private static String __s_cache_4GM8mGWf_48;
    private static String __s_cache_V1C50rxM_49;
    private static String __s_cache_icCscJ3P_50;
    private static String __s_cache_F1V0IpD7_51;
    private static String __s_cache_5lk6y73F_52;
    private static String __s_cache_FTiNFbRv_53;
    private static String __s_cache_LcFQqx6s_54;
    private static String __s_cache_tZdW3cXv_55;
    private static String __s_cache_lXJZo0bp_56;
    private static String __s_cache_882Mbc30_57;
    private static String __s_cache_18NeQMLG_58;
    private static String __s_cache_TYFWqmOm_59;
    private static String __s_cache_aYfzdePE_60;
    private static String __s_cache_pw5rjEX3_61;
    private static String __s_cache_sz03Fi8M_62;
    private static String __s_cache_5aMSnvkJ_63;
    private static String __s_cache_3V2jxARC_64;
    private static String __s_cache_B4NYmrvL_65;
    private static String __s_cache_q3RaUeig_66;
    private static String __s_cache_UxX4Oiyl_67;
    private static String __s_cache_LL7kTXeE_68;
    private static String __s_cache_Jl7oy4Z0_69;
    private static String __s_cache_igJBi0RY_70;
    private static String __s_cache_CLyCNemt_71;
    private static String __s_cache_H0zsOBph_72;
    private static String __s_cache_3M4ZqiR2_73;
    private static String __s_cache_MQEBwrO9_74;
    private static String __s_cache_AlZwuBij_75;
    private static String __s_cache_kAzDtkLE_76;
    private static String __s_cache_ImAMuEW3_77;
    private static String __s_cache_EmeTG9uE_78;
    private static String __s_cache_xha87tII_79;
    private static String __s_cache_fTzEO5kK_80;
    private static String __s_cache_zGID7K5N_81;
    private static String __s_cache_REjewUXG_82;
    private static String __s_cache_KufKrjVW_83;
    private static String __s_cache_KeoQVBtO_84;
    private static String __s_cache_yTnC54pm_85;
    private static String __s_cache_DG3GE5hY_86;
    private static String __s_cache_tGBFH23g_87;
    private static String __s_cache_JtS5NnFp_88;
    private static String __s_cache_9LH3cxLN_89;
    private static String __s_cache_CgxkYnD7_90;
    private static String __s_cache_DkmsLMeC_91;
    private static String __s_cache_EHOfVik5_92;
    private static String __s_cache_RHgEInrG_93;
    private static String __s_cache_bZ4P9jBc_94;
    private static String __s_cache_A1QwuRg8_95;
    private static String __s_cache_n6HegLty_96;
    private static String __s_cache_FZ9xDCF0_97;
    private static String __s_cache_M0lH1dSM_98;
    private static String __s_cache_Rkgw9v4s_99;
    private static String __s_cache_gGcNPmFn_100;
    private static String __s_cache_Z1UOY582_101;
    private static String __s_cache_PpE9GqNT_102;
    private static String __s_cache_NkWPnUXE_103;
    private static String __s_cache_cmsI4jQc_104;
    private static String __s_cache_k5wUS4j0_105;
    private static String __s_cache_I3yEbLZD_106;
    private static String __s_cache_SpzP4r5S_107;
    private static String __s_cache_1EROgdzj_108;
    private static String __s_cache_oanwVVXi_109;
    private static String __s_cache_cpUYOUFf_110;
    private static String __s_cache_hBNTHqNE_111;
    private static String __s_cache_wZJRzU62_112;
    private static String __s_cache_TvAZPk10_113;
    private static String __s_cache_xDaxI1Li_114;
    private static String __s_cache_lYKjz9Sq_115;
    private static String __s_cache_fRzQYa31_116;
    private static String __s_cache_HzextpFY_117;
    private static String __s_cache_vnntzo5F_118;
    private static String __s_cache_59Tx0qaZ_119;
    private static String __s_cache_7LZJzWMa_120;
    private static String __s_cache_rr92Al9c_121;
    private static String __s_cache_QNvhN3sb_122;
    private static String __s_cache_GfxV5OMn_123;
    private static String __s_cache_D59m1XRG_124;
    private static String __s_cache_ViJSYjon_125;
    private static byte[] __aes_key_PPGYOeBr = {(byte) 143, (byte) 221, (byte) 184, (byte) 194, (byte) 117, (byte) 94, (byte) 78, (byte) 254, (byte) 58, (byte) 46, (byte) 227, (byte) 74, (byte) 169, (byte) 151, (byte) 2, (byte) 41, (byte) 62, (byte) 83, (byte) 37, (byte) 237, (byte) 224, (byte) 79, (byte) 9, (byte) 170, (byte) 95, (byte) 208, (byte) 235, (byte) 170, (byte) 127, (byte) 78, (byte) 45, (byte) 116};
    private static byte[] __aes_iv_nvkcCTol = {(byte) 220, (byte) 172, (byte) 95, (byte) 220, (byte) 187, (byte) 26, (byte) 147, (byte) 25, (byte) 251, (byte) 46, (byte) 171, (byte) 145, (byte) 141, (byte) 26, (byte) 121, (byte) 92};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ConcurrentHashMap<ClanData, AllyInvite> f165a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<ClanData, RivalRemove> b = new ConcurrentHashMap<>();
    private static final Pattern c = Pattern.compile("(%)(uclans_)(.+?)(%)");

    public static ConcurrentHashMap<ClanData, RivalRemove> a() {
        return b;
    }

    public static ConcurrentHashMap<ClanData, AllyInvite> b() {
        return f165a;
    }

    public static void c() {
        f();
        d();
        g();
        e();
        h();
    }

    public static ClanEnum.AllyInviteReturn a(UUID uuid, UUID uuid2, boolean z) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
        if (!clan.isPresent() || !clan2.isPresent()) {
            return ClanEnum.AllyInviteReturn.ERROR;
        }
        if (b().containsKey(clan2.get())) {
            return ClanEnum.AllyInviteReturn.ALREADY_INVITED;
        }
        int i = Rivalally.getModuleCore().c().i().getInt("Clan.ally_invite.max_time_seconds");
        if (i <= 0) {
            i = 60;
        }
        AllyInvite allyInvite = new AllyInvite(uuid, uuid2, Long.valueOf((System.currentTimeMillis() / 1000) + ((long) i)));
        ArrayList arrayList = new ArrayList();
        for (UUID uuid3 : clan2.get().getMembers()) {
            try {
                Player player = Bukkit.getPlayer(uuid3);
                if (player != null && player.isOnline() && Rivalally.a().getModAPI().playerHasPermission(uuid3, Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name"))) {
                    arrayList.add(player);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (arrayList.isEmpty()) {
            return ClanEnum.AllyInviteReturn.MODERATION_OFFLINE;
        }
        b().put(clan2.get(), allyInvite);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((Player) it.next(), clan.get(), Lang.CHAT_clanallyreceive_message, i);
        }
        return ClanEnum.AllyInviteReturn.SENDED;
    }

    public static boolean a(UUID uuid, UUID uuid2) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
        if (!clan.isPresent() || !clan2.isPresent() || e(clan.get().getId(), clan2.get().getId()) || e(clan2.get().getId(), clan.get().getId())) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (clan.get().getRivalAlly().getAlly() != null) {
            for (UUID uuid3 : clan.get().getRivalAlly().getAlly()) {
                if (!uuid3.equals(uuid2)) {
                    arrayList.add(uuid3);
                }
            }
        }
        arrayList.add(uuid2);
        clan.get().getRivalAlly().setAlly(arrayList);
        Rivalally.a().getClanAPI().saveClanData(clan.get());
        ArrayList arrayList2 = new ArrayList();
        if (clan2.get().getRivalAlly().getAlly() != null) {
            for (UUID uuid4 : clan2.get().getRivalAlly().getAlly()) {
                if (!uuid4.equals(uuid)) {
                    arrayList2.add(uuid4);
                }
            }
        }
        arrayList2.add(uuid);
        clan2.get().getRivalAlly().setAlly(arrayList2);
        Rivalally.a().getClanAPI().saveClanData(clan2.get());
        Optional<LevelupModuleAPI> levelup = Rivalally.a().getIntegrationAPI().getLevelup();
        if (levelup.isPresent()) {
            levelup.get().check_actions(ClanEnum.ClanActions.NEWALLIANCE, clan.get().getId());
            levelup.get().check_actions(ClanEnum.ClanActions.NEWALLIANCE, clan2.get().getId());
        }
        Bukkit.getPluginManager().callEvent(new ClanAllyAddEvent(uuid, uuid2));
        return true;
    }

    public static boolean b(UUID uuid, UUID uuid2) {
        try {
            Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
            Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
            if (clan.isPresent()) {
                clan.get().getRivalAlly().setAlly((List) new ArrayList(clan.get().getRivalAlly().getAlly()).stream().filter(uuid3 -> {
                    return !uuid3.equals(uuid2);
                }).collect(Collectors.toList()));
                Rivalally.a().getClanAPI().saveClanData(clan.get());
                Optional<LevelupModuleAPI> levelup = Rivalally.a().getIntegrationAPI().getLevelup();
                if (levelup.isPresent()) {
                    levelup.get().check_actions(ClanEnum.ClanActions.REMOVEALLIANCE, clan.get().getId());
                }
            }
            if (clan2.isPresent()) {
                clan2.get().getRivalAlly().setAlly((List) new ArrayList(clan2.get().getRivalAlly().getAlly()).stream().filter(uuid4 -> {
                    return !uuid4.equals(uuid);
                }).collect(Collectors.toList()));
                Rivalally.a().getClanAPI().saveClanData(clan2.get());
                Optional<LevelupModuleAPI> levelup2 = Rivalally.a().getIntegrationAPI().getLevelup();
                if (levelup2.isPresent()) {
                    levelup2.get().check_actions(ClanEnum.ClanActions.REMOVEALLIANCE, clan2.get().getId());
                }
            }
            Bukkit.getPluginManager().callEvent(new ClanAllyRemoveEvent(uuid, uuid2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static ClanEnum.RivalRemoveReturn b(UUID uuid, UUID uuid2, boolean z) {
        if (!Rivalally.a().getClanAPI().clanExists(uuid) || !Rivalally.a().getClanAPI().clanExists(uuid2)) {
            return ClanEnum.RivalRemoveReturn.ERROR;
        }
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
        if (!clan.isPresent() || !clan2.isPresent() || a().containsKey(clan2.get())) {
            return ClanEnum.RivalRemoveReturn.ALREADY_SENDED;
        }
        int i = Rivalally.getModuleCore().c().i().getInt("Clan.rival_remove.max_time_seconds");
        if (i <= 0) {
            i = 60;
        }
        RivalRemove rivalRemove = new RivalRemove(uuid, uuid2, (System.currentTimeMillis() / 1000) + ((long) i));
        ArrayList arrayList = new ArrayList();
        for (UUID uuid3 : clan2.get().getMembers()) {
            try {
                Player player = Bukkit.getPlayer(uuid3);
                if (player != null && player.isOnline() && Rivalally.a().getModAPI().playerHasPermission(uuid3, Rivalally.getModuleCore().c().i().getString("Config.Permissions.rival-manager.name"))) {
                    arrayList.add(player);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (arrayList.isEmpty()) {
            return ClanEnum.RivalRemoveReturn.MODERATION_OFFLINE;
        }
        a().put(clan2.get(), rivalRemove);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a((Player) it.next(), clan.get(), Lang.CHAT_clanrivalremove_message, i);
        }
        return ClanEnum.RivalRemoveReturn.SENDED;
    }

    private static void a(Player player, ClanData clanData, Lang lang, int i) {
        if (player == null || !player.isOnline() || clanData == null || lang == null) {
            return;
        }
        try {
            List<String> stringList = Rivalally.getModuleCore().c().b(Optional.of(player.getUniqueId())).getStringList(lang);
            if (stringList == null || stringList.isEmpty()) {
                return;
            }
            String strValueOf = String.valueOf(i);
            for (String str : stringList) {
                if (str != null) {
                    MessageUtils.sendText((CommandSender) player, str.replace("%sec_expires%", strValueOf).replace("%clan_tag_nocolor%", clanData.getTagNoColor()).replace("%uclans_tag_nocolor%", clanData.getTagNoColor()).replace("%clan_tag%", clanData.getTag()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(ClanData clanData, Lang lang) {
        if (clanData == null || lang == null) {
            return;
        }
        for (UUID uuid : clanData.getOnlineMembers()) {
            try {
                Player player = Bukkit.getPlayer(uuid);
                if (player != null && player.isOnline()) {
                    String string = Rivalally.getModuleCore().c().b(Optional.of(uuid)).getString(lang);
                    if (string != null && !string.isEmpty()) {
                        MessageUtils.sendText((CommandSender) player, string);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean c(UUID uuid, UUID uuid2) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
        if (!clan.isPresent() || !clan2.isPresent() || f(clan.get().getId(), clan2.get().getId()) || f(clan2.get().getId(), clan.get().getId())) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        if (clan.get().getRivalAlly().getRival() != null) {
            for (UUID uuid3 : clan.get().getRivalAlly().getRival()) {
                if (uuid3 != uuid2) {
                    arrayList.add(uuid3);
                }
            }
        }
        arrayList.add(uuid2);
        clan.get().getRivalAlly().setRival(arrayList);
        Rivalally.a().getClanAPI().saveClanData(clan.get());
        ArrayList arrayList2 = new ArrayList();
        if (clan2.get().getRivalAlly().getRival() != null) {
            for (UUID uuid4 : clan2.get().getRivalAlly().getRival()) {
                if (uuid4 != uuid) {
                    arrayList2.add(uuid4);
                }
            }
        }
        arrayList2.add(uuid);
        clan2.get().getRivalAlly().setRival(arrayList2);
        Rivalally.a().getClanAPI().saveClanData(clan2.get());
        Optional<LevelupModuleAPI> levelup = Rivalally.a().getIntegrationAPI().getLevelup();
        if (levelup.isPresent()) {
            levelup.get().check_actions(ClanEnum.ClanActions.NEWRIVAL, clan.get().getId());
            levelup.get().check_actions(ClanEnum.ClanActions.NEWRIVAL, clan2.get().getId());
        }
        Bukkit.getPluginManager().callEvent(new ClanRivalAddEvent(uuid, uuid2));
        return true;
    }

    public static boolean d(UUID uuid, UUID uuid2) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
        try {
            if (clan.isPresent()) {
                clan.get().getRivalAlly().setRival((List) new ArrayList(clan.get().getRivalAlly().getRival()).stream().filter(uuid3 -> {
                    return !uuid3.equals(uuid2);
                }).collect(Collectors.toList()));
                Rivalally.a().getClanAPI().saveClanData(clan.get());
                Optional<LevelupModuleAPI> levelup = Rivalally.a().getIntegrationAPI().getLevelup();
                if (levelup.isPresent()) {
                    levelup.get().check_actions(ClanEnum.ClanActions.REMOVERIVAL, clan.get().getId());
                }
            }
            if (clan2.isPresent()) {
                clan2.get().getRivalAlly().setRival((List) new ArrayList(clan2.get().getRivalAlly().getRival()).stream().filter(uuid4 -> {
                    return !uuid4.equals(uuid);
                }).collect(Collectors.toList()));
                Rivalally.a().getClanAPI().saveClanData(clan2.get());
                Optional<LevelupModuleAPI> levelup2 = Rivalally.a().getIntegrationAPI().getLevelup();
                if (levelup2.isPresent()) {
                    levelup2.get().check_actions(ClanEnum.ClanActions.REMOVERIVAL, clan2.get().getId());
                }
            }
            Bukkit.getPluginManager().callEvent(new ClanRivalRemoveEvent(uuid, uuid2));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean e(UUID uuid, UUID uuid2) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
        return clan.isPresent() && clan2.isPresent() && clan.get().getRivalAlly().getAlly().contains(clan2.get().getId());
    }

    public static boolean f(UUID uuid, UUID uuid2) {
        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(uuid2);
        return clan.isPresent() && clan2.isPresent() && clan.get().getRivalAlly().getRival().contains(clan2.get().getId());
    }

    public static boolean g(UUID uuid, UUID uuid2) {
        Optional<ClanData> playerClan = Rivalally.a().getPlayerAPI().getPlayerClan(uuid);
        Optional<ClanData> playerClan2 = Rivalally.a().getPlayerAPI().getPlayerClan(uuid2);
        return playerClan.isPresent() && playerClan2.isPresent() && f(playerClan.get().getId(), playerClan2.get().getId());
    }

    public static boolean h(UUID uuid, UUID uuid2) {
        Optional<ClanData> playerClan = Rivalally.a().getPlayerAPI().getPlayerClan(uuid);
        Optional<ClanData> playerClan2 = Rivalally.a().getPlayerAPI().getPlayerClan(uuid2);
        return playerClan.isPresent() && playerClan2.isPresent() && e(playerClan.get().getId(), playerClan2.get().getId());
    }

    public static String a(UUID uuid, String str) {
        String strA;
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            if (!str.contains("%") && (strA = Rivalally.getModuleCore().i().a(uuid, str)) != null) {
                return strA;
            }
            Matcher matcher = c.matcher(str);
            StringBuffer stringBuffer = new StringBuffer();
            while (matcher.find()) {
                String strA2 = Rivalally.getModuleCore().i().a(uuid, matcher.group(3));
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

    public static int a(ClanData clanData, ClanEnum.RivalAllyCount rivalAllyCount) {
        try {
            int i = 0;
            Iterator it = Rivalally.getModuleCore().c().i().getStringList("Config.unlocker." + rivalAllyCount.toString().toLowerCase()).iterator();
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
                if (rivalAllyCount.equals(ClanEnum.RivalAllyCount.ALLY)) {
                    i = Rivalally.getModuleCore().c().i().getInt("Config.Ally.default_limit");
                } else if (rivalAllyCount.equals(ClanEnum.RivalAllyCount.RIVAL)) {
                    i = Rivalally.getModuleCore().c().i().getInt("Config.Rival.default_limit");
                }
            }
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            return rivalAllyCount.equals(ClanEnum.RivalAllyCount.ALLY) ? Rivalally.getModuleCore().c().i().getInt("Config.Ally.default_limit") : Rivalally.getModuleCore().c().i().getInt("Config.Rival.default_limit");
        }
    }

    private static CommandData_show a(String str, String str2) {
        HashMap map = new HashMap();
        String str3 = "COMMANDS_" + str + "_" + str2 + "_";
        Rivalally.getModuleCore().c().e().forEach((str4, enumConfiguration) -> {
            try {
                map.put(str4, new CommandData_show(a(enumConfiguration.getString(Lang.valueOf(str3 + "show"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "success"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "error"))), a(enumConfiguration.getString(Lang.valueOf(str3 + "usage")))));
            } catch (Exception e) {
            }
        });
        CommandData_show commandData_show = (CommandData_show) map.get(Rivalally.getModuleCore().c().a(Optional.empty()));
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
        Rivalally.a().getCommandAPI().unRegisterCommand("ally");
        Rivalally.a().getCommandAPI().unRegisterCommand(Rivalally.getModuleCore().c().j().getString("Commands.player.ally.alias"));
        Rivalally.a().getCommandAPI().registerCommand("ally", new AllyCommand());
        Rivalally.a().getCommandAPI().registerCommand(Rivalally.getModuleCore().c().j().getString("Commands.player.ally.alias"), new AllyCommand());
        Rivalally.a().getCommandAPI().getCommandAliases().put("ally", Rivalally.getModuleCore().c().j().getString("Commands.player.ally.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("add", "remove", "accept", "deny", "list")) {
                if (Rivalally.getModuleCore().c().j().contains("Commands.ally." + str)) {
                    if (!Rivalally.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Rivalally.a().getCommandAPI().getCommandAliases().put(str, Rivalally.getModuleCore().c().j().getString("Commands.ally." + str + ".aliases"));
                    }
                    map.put(str, a("ally", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Rivalally.a().getCommandAPI().insertCommand("ally", Rivalally.getModuleCore().c().j().getString("Commands.player.ally.permission"), Rivalally.getModuleCore().c().j().getString("Commands.player.ally.alias"), Rivalally.getModuleCore().c().j().getDouble("Commands.player.ally.value"), Rivalally.getModuleCore().c().j().getInt("Commands.player.ally.cooldown"), a("ally", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Rivalally.getModuleCore().c().j().getStringList("Commands.player.ally.disabled_worlds"), Rivalally.getModuleCore().c().j().getStringList("Commands.player.ally.disabled_regions")));
    }

    public static void e() {
        Rivalally.a().getCommandAPI().unRegisterCommand("rival");
        Rivalally.a().getCommandAPI().unRegisterCommand(Rivalally.getModuleCore().c().j().getString("Commands.player.rival.alias"));
        Rivalally.a().getCommandAPI().registerCommand("rival", new RivalCommand());
        Rivalally.a().getCommandAPI().registerCommand(Rivalally.getModuleCore().c().j().getString("Commands.player.rival.alias"), new RivalCommand());
        Rivalally.a().getCommandAPI().getCommandAliases().put("rival", Rivalally.getModuleCore().c().j().getString("Commands.player.rival.alias"));
        HashMap<String, CommandData_show> map = new HashMap<>();
        try {
            for (String str : Arrays.asList("add", "accept", "deny", "remove", "list")) {
                if (Rivalally.getModuleCore().c().j().contains("Commands.rival." + str)) {
                    if (!Rivalally.a().getCommandAPI().getCommandAliases().containsKey(str)) {
                        Rivalally.a().getCommandAPI().getCommandAliases().put(str, Rivalally.getModuleCore().c().j().getString("Commands.rival." + str + ".aliases"));
                    }
                    map.put(str, a("rival", str));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Rivalally.a().getCommandAPI().insertCommand("rival", Rivalally.getModuleCore().c().j().getString("Commands.player.rival.permission"), Rivalally.getModuleCore().c().j().getString("Commands.player.rival.alias"), Rivalally.getModuleCore().c().j().getDouble("Commands.player.rival.value"), Rivalally.getModuleCore().c().j().getInt("Commands.player.rival.cooldown"), a("rival", "help"), new CommandData_title(null, null, null), new CommandData_actionbar(null, null, null), null, map, new CommandData_disable(Rivalally.getModuleCore().c().j().getStringList("Commands.player.disabled_worlds"), Rivalally.getModuleCore().c().j().getStringList("Commands.player.disabled_regions")));
    }

    public static void f() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Rivalally.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Rivalally.getModuleCore().c().i().contains("Config.Ally.Icon.mimeslots")) {
                if (Rivalally.getModuleCore().c().i().getStringList("Config.Ally.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Rivalally.getModuleCore().c().i().getStringList("Config.Ally.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Rivalally.getModuleCore().c().i().getStringList("Config.Ally.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Rivalally.getModuleCore().c().i().getStringList("Config.Ally.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Rivalally.getModuleCore().c().i().getIntegerList("Config.Ally.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Rivalally.getModuleCore().c().i().contains("Config.Ally.Icon.left_click_action")) {
                Rivalally.getModuleCore().c().i().getStringList("Config.Ally.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(a(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Rivalally.getModuleCore().c().i().contains("Config.Ally.Icon.right_click_action")) {
                Rivalally.getModuleCore().c().i().getStringList("Config.Ally.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(a(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Rivalally.getModuleCore().c().e().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_ally_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_ally_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Rivalally.getModuleCore().c().a(Optional.empty());
        map.put("module_ally_item", new GuiItemsData(Rivalally.getModuleCore().c().i().getString("Config.Ally.Icon.page"), Rivalally.getModuleCore().c().i().getString("Config.Ally.Icon.click_sound"), Rivalally.getModuleCore().c().i().getString("Config.Ally.Icon.material"), 1, Rivalally.getModuleCore().c().i().getBoolean("Config.Ally.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Alliances.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Rivalally.getModuleCore().c().i().getString("Config.Ally.Icon.texture"), new NbtData(Rivalally.getModuleCore().c().i().getStringList("Config.Ally.Icon.nbt.string"), Rivalally.getModuleCore().c().i().getInt("Config.Ally.Icon.model")), Rivalally.getModuleCore().c().i().getInt("Config.Ally.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Rivalally.a().getGuiAPI().registerLocalizedInsertItem("General", "module_ally_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void g() {
        GuiAPIManager guiAPIManager = new GuiAPIManager(Rivalally.a());
        HashMap<String, GuiItemsData> map = new HashMap<>();
        if (guiAPIManager.getInsertGui().containsKey("General")) {
            map = guiAPIManager.getInsertGui().get("General").getItems();
        }
        GuiItemsData_fill guiItemsData_fill = new GuiItemsData_fill(new ArrayList(), false, false, false, false);
        try {
            if (Rivalally.getModuleCore().c().i().contains("Config.Rival.Icon.mimeslots")) {
                if (Rivalally.getModuleCore().c().i().getStringList("Config.Rival.Icon.mimeslots").contains("ALL")) {
                    guiItemsData_fill.setAll(true);
                } else if (Rivalally.getModuleCore().c().i().getStringList("Config.Rival.Icon.mimeslots").contains("TOP")) {
                    guiItemsData_fill.setTop(true);
                } else if (Rivalally.getModuleCore().c().i().getStringList("Config.Rival.Icon.mimeslots").contains("BOTTOM")) {
                    guiItemsData_fill.setBottom(true);
                } else if (Rivalally.getModuleCore().c().i().getStringList("Config.Rival.Icon.mimeslots").contains("BORDER")) {
                    guiItemsData_fill.setBorder(true);
                } else {
                    guiItemsData_fill.setSlots(Rivalally.getModuleCore().c().i().getIntegerList("Config.Rival.Icon.mimeslots"));
                }
            }
        } catch (Exception e) {
        }
        ArrayList arrayList = new ArrayList();
        try {
            if (Rivalally.getModuleCore().c().i().contains("Config.Rival.Icon.left_click_action")) {
                Rivalally.getModuleCore().c().i().getStringList("Config.Rival.Icon.left_click_action").iterator().forEachRemaining(str -> {
                    arrayList.add(a(str));
                });
            }
        } catch (Exception e2) {
        }
        ArrayList arrayList2 = new ArrayList();
        try {
            if (Rivalally.getModuleCore().c().i().contains("Config.Rival.Icon.right_click_action")) {
                Rivalally.getModuleCore().c().i().getStringList("Config.Rival.Icon.right_click_action").iterator().forEachRemaining(str2 -> {
                    arrayList2.add(a(str2));
                });
            }
        } catch (Exception e3) {
        }
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        Rivalally.getModuleCore().c().e().forEach((str3, enumConfiguration) -> {
            try {
                map2.put(str3, enumConfiguration.getString(Lang.CONFIG_rival_icon_name));
                map3.put(str3, enumConfiguration.getStringList(Lang.CONFIG_rival_icon_lore));
            } catch (Exception e4) {
            }
        });
        String strA = Rivalally.getModuleCore().c().a(Optional.empty());
        map.put("module_rival_item", new GuiItemsData(Rivalally.getModuleCore().c().i().getString("Config.Rival.Icon.page"), Rivalally.getModuleCore().c().i().getString("Config.Rival.Icon.click_sound"), Rivalally.getModuleCore().c().i().getString("Config.Rival.Icon.material"), 1, Rivalally.getModuleCore().c().i().getBoolean("Config.Rival.Icon.glow"), (String) map2.getOrDefault(strA, (String) map2.getOrDefault("EN", "<green>Rivalries.")), (List) map3.getOrDefault(strA, (List) map3.getOrDefault("EN", Arrays.asList(new String[0]))), Rivalally.getModuleCore().c().i().getString("Config.Icon.texture"), new NbtData(Rivalally.getModuleCore().c().i().getStringList("Config.Rival.Icon.nbt.string"), Rivalally.getModuleCore().c().i().getInt("Config.Rival.Icon.model")), Rivalally.getModuleCore().c().i().getInt("Config.Rival.Icon.slot"), guiItemsData_fill, arrayList, arrayList2));
        Rivalally.a().getGuiAPI().registerLocalizedInsertItem("General", "module_rival_item", map2, map3);
        guiAPIManager.getInsertGui().put("General", new GuiData("General", null, 0, 0, null, map));
    }

    public static void h() {
        ConfigurationSection configurationSection = Rivalally.getModuleCore().c().i().getConfigurationSection("Config.Permissions");
        if (configurationSection == null || (r0 = configurationSection.getKeys(false).iterator()) == null) {
            return;
        }
        for (String str : configurationSection.getKeys(false)) {
            String strReplace = Rivalally.getModuleCore().c().i().getString("Config.Permissions." + str + ".name").replace(" ", "-").replace(".", "-");
            boolean z = Rivalally.getModuleCore().c().i().getBoolean("Config.Permissions." + str + ".default_value");
            if (!strReplace.isEmpty()) {
                List<String> stringList = Rivalally.getModuleCore().c().i().getStringList("Config.Permissions." + str + ".applicable_roles");
                if (stringList.size() > 0) {
                    for (String str2 : stringList) {
                        if (Rivalally.a().getModAPI().getDefaultModerationData().containsKey(str2)) {
                            Rivalally.a().getModAPI().getDefaultModerationData().get(str2).getPermissionList().put(strReplace, Boolean.valueOf(z));
                        }
                    }
                }
            }
        }
    }

    private static String a(String str) {
        return Rivalally.a().getCommandAPI().replaceCmd(Rivalally.a().getCommandAPI().replaceMainCmd(str));
    }

    public static String a(List<String> list) {
        return a(list, (Optional<UUID>) Optional.empty());
    }

    public static String a(List<String> list, UUID uuid) {
        return a(list, (Optional<UUID>) Optional.ofNullable(uuid));
    }

    private static String a(List<String> list, Optional<UUID> optional) {
        String string = "";
        int i = 1;
        if (list.size() > 0) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String str = string + it.next();
                string = i >= list.size() ? str + "." : str + ", ";
                i++;
            }
        } else {
            string = Rivalally.getModuleCore().c().b(optional).getString(Lang.NOTHING_HERE);
        }
        return string;
    }

    private static String __unused_1063() {
        return "Clan.ally_invite.max_time_seconds";
    }

    private static String __unused_1064() {
        return "Config.Permissions.ally-manager.name";
    }

    private static String __unused_1065() {
        return "Clan.rival_remove.max_time_seconds";
    }

    private static String __unused_1066() {
        return "Config.Permissions.rival-manager.name";
    }

    private static String __unused_1067() {
        return "%sec_expires%";
    }

    private static String __unused_1068() {
        return "%clan_tag_nocolor%";
    }

    private static String __unused_1069() {
        return "%uclans_tag_nocolor%";
    }

    private static String __unused_1070() {
        return "%clan_tag%";
    }

    private static String __unused_1071() {
        return "%";
    }

    private static String __unused_1072() {
        return ":";
    }

    private static String __unused_1073() {
        return "Config.Ally.default_limit";
    }

    private static String __unused_1074() {
        return "Config.Rival.default_limit";
    }

    private static String __unused_1075() {
        return "Config.Ally.default_limit";
    }

    private static String __unused_1076() {
        return "Config.Rival.default_limit";
    }

    private static String __unused_1077() {
        return "EN";
    }

    private static String __unused_1078() {
        return "ally";
    }

    private static String __unused_1079() {
        return "Commands.player.ally.alias";
    }

    private static String __unused_1080() {
        return "ally";
    }

    private static String __unused_1081() {
        return "Commands.player.ally.alias";
    }

    private static String __unused_1082() {
        return "ally";
    }

    private static String __unused_1083() {
        return "Commands.player.ally.alias";
    }

    private static String __unused_1084() {
        return "add";
    }

    private static String __unused_1085() {
        return "remove";
    }

    private static String __unused_1086() {
        return "accept";
    }

    private static String __unused_1087() {
        return "deny";
    }

    private static String __unused_1088() {
        return "list";
    }

    private static String __unused_1089() {
        return "ally";
    }

    private static String __unused_1090() {
        return "ally";
    }

    private static String __unused_1091() {
        return "Commands.player.ally.permission";
    }

    private static String __unused_1092() {
        return "Commands.player.ally.alias";
    }

    private static String __unused_1093() {
        return "Commands.player.ally.value";
    }

    private static String __unused_1094() {
        return "Commands.player.ally.cooldown";
    }

    private static String __unused_1095() {
        return "ally";
    }

    private static String __unused_1096() {
        return "help";
    }

    private static String __unused_1097() {
        return "Commands.player.ally.disabled_worlds";
    }

    private static String __unused_1098() {
        return "Commands.player.ally.disabled_regions";
    }

    private static String __unused_1099() {
        return "rival";
    }

    private static String __unused_1100() {
        return "Commands.player.rival.alias";
    }

    private static String __unused_1101() {
        return "rival";
    }

    private static String __unused_1102() {
        return "Commands.player.rival.alias";
    }

    private static String __unused_1103() {
        return "rival";
    }

    private static String __unused_1104() {
        return "Commands.player.rival.alias";
    }

    private static String __unused_1105() {
        return "add";
    }

    private static String __unused_1106() {
        return "accept";
    }

    private static String __unused_1107() {
        return "deny";
    }

    private static String __unused_1108() {
        return "remove";
    }

    private static String __unused_1109() {
        return "list";
    }

    private static String __unused_1110() {
        return "rival";
    }

    private static String __unused_1111() {
        return "rival";
    }

    private static String __unused_1112() {
        return "Commands.player.rival.permission";
    }

    private static String __unused_1113() {
        return "Commands.player.rival.alias";
    }

    private static String __unused_1114() {
        return "Commands.player.rival.value";
    }

    private static String __unused_1115() {
        return "Commands.player.rival.cooldown";
    }

    private static String __unused_1116() {
        return "rival";
    }

    private static String __unused_1117() {
        return "help";
    }

    private static String __unused_1118() {
        return "Commands.player.disabled_worlds";
    }

    private static String __unused_1119() {
        return "Commands.player.disabled_regions";
    }

    private static String __unused_1120() {
        return "General";
    }

    private static String __unused_1121() {
        return "General";
    }

    private static String __unused_1122() {
        return "Config.Ally.Icon.mimeslots";
    }

    private static String __unused_1123() {
        return "Config.Ally.Icon.mimeslots";
    }

    private static String __unused_1124() {
        return "ALL";
    }

    private static String __unused_1125() {
        return "Config.Ally.Icon.mimeslots";
    }

    private static String __unused_1126() {
        return "TOP";
    }

    private static String __unused_1127() {
        return "Config.Ally.Icon.mimeslots";
    }

    private static String __unused_1128() {
        return "BOTTOM";
    }

    private static String __unused_1129() {
        return "Config.Ally.Icon.mimeslots";
    }

    private static String __unused_1130() {
        return "BORDER";
    }

    private static String __unused_1131() {
        return "Config.Ally.Icon.mimeslots";
    }

    private static String __unused_1132() {
        return "Config.Ally.Icon.left_click_action";
    }

    private static String __unused_1133() {
        return "Config.Ally.Icon.left_click_action";
    }

    private static String __unused_1134() {
        return "Config.Ally.Icon.right_click_action";
    }

    private static String __unused_1135() {
        return "Config.Ally.Icon.right_click_action";
    }

    private static String __unused_1136() {
        return "EN";
    }

    private static String __unused_1137() {
        return "<green>Alliances.";
    }

    private static String __unused_1138() {
        return "EN";
    }

    private static String __unused_1139() {
        return "module_ally_item";
    }

    private static String __unused_1140() {
        return "Config.Ally.Icon.page";
    }

    private static String __unused_1141() {
        return "Config.Ally.Icon.click_sound";
    }

    private static String __unused_1142() {
        return "Config.Ally.Icon.material";
    }

    private static String __unused_1143() {
        return "Config.Ally.Icon.glow";
    }

    private static String __unused_1144() {
        return "Config.Ally.Icon.texture";
    }

    private static String __unused_1145() {
        return "Config.Ally.Icon.nbt.string";
    }

    private static String __unused_1146() {
        return "Config.Ally.Icon.model";
    }

    private static String __unused_1147() {
        return "Config.Ally.Icon.slot";
    }

    private static String __unused_1148() {
        return "General";
    }

    private static String __unused_1149() {
        return "module_ally_item";
    }

    private static String __unused_1150() {
        return "General";
    }

    private static String __unused_1151() {
        return "General";
    }

    private static String __unused_1152() {
        return "General";
    }

    private static String __unused_1153() {
        return "General";
    }

    private static String __unused_1154() {
        return "Config.Rival.Icon.mimeslots";
    }

    private static String __unused_1155() {
        return "Config.Rival.Icon.mimeslots";
    }

    private static String __unused_1156() {
        return "ALL";
    }

    private static String __unused_1157() {
        return "Config.Rival.Icon.mimeslots";
    }

    private static String __unused_1158() {
        return "TOP";
    }

    private static String __unused_1159() {
        return "Config.Rival.Icon.mimeslots";
    }

    private static String __unused_1160() {
        return "BOTTOM";
    }

    private static String __unused_1161() {
        return "Config.Rival.Icon.mimeslots";
    }

    private static String __unused_1162() {
        return "BORDER";
    }

    private static String __unused_1163() {
        return "Config.Rival.Icon.mimeslots";
    }

    private static String __unused_1164() {
        return "Config.Rival.Icon.left_click_action";
    }

    private static String __unused_1165() {
        return "Config.Rival.Icon.left_click_action";
    }

    private static String __unused_1166() {
        return "Config.Rival.Icon.right_click_action";
    }

    private static String __unused_1167() {
        return "Config.Rival.Icon.right_click_action";
    }

    private static String __unused_1168() {
        return "EN";
    }

    private static String __unused_1169() {
        return "<green>Rivalries.";
    }

    private static String __unused_1170() {
        return "EN";
    }

    private static String __unused_1171() {
        return "module_rival_item";
    }

    private static String __unused_1172() {
        return "Config.Rival.Icon.page";
    }

    private static String __unused_1173() {
        return "Config.Rival.Icon.click_sound";
    }

    private static String __unused_1174() {
        return "Config.Rival.Icon.material";
    }

    private static String __unused_1175() {
        return "Config.Rival.Icon.glow";
    }

    private static String __unused_1176() {
        return "Config.Icon.texture";
    }

    private static String __unused_1177() {
        return "Config.Rival.Icon.nbt.string";
    }

    private static String __unused_1178() {
        return "Config.Rival.Icon.model";
    }

    private static String __unused_1179() {
        return "Config.Rival.Icon.slot";
    }

    private static String __unused_1180() {
        return "General";
    }

    private static String __unused_1181() {
        return "module_rival_item";
    }

    private static String __unused_1182() {
        return "General";
    }

    private static String __unused_1183() {
        return "General";
    }

    private static String __unused_1184() {
        return "Config.Permissions";
    }

    private static String __unused_1185() {
        return "-";
    }

    private static String __unused_1186() {
        return ".";
    }

    private static String __unused_1187() {
        return "-";
    }

    private static String __unused_1188() {
        return "(%)(uclans_)(.+?)(%)";
    }
}
