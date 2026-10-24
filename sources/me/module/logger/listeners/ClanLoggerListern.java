package me.module.logger.listeners;

import java.util.Optional;
import me.module.logger.Logger;
import me.module.logger.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ClanAllyAddEvent;
import me.ulrich.clans.events.ClanAllyInviteEvent;
import me.ulrich.clans.events.ClanAllyRemoveEvent;
import me.ulrich.clans.events.ClanBannerChangeEvent;
import me.ulrich.clans.events.ClanCreateEvent;
import me.ulrich.clans.events.ClanDeleteEvent;
import me.ulrich.clans.events.ClanFFChangeEvent;
import me.ulrich.clans.events.ClanHomeCreateEvent;
import me.ulrich.clans.events.ClanHomeDeleteEvent;
import me.ulrich.clans.events.ClanLeaderChangeEvent;
import me.ulrich.clans.events.ClanLevelEvent;
import me.ulrich.clans.events.ClanModDescEvent;
import me.ulrich.clans.events.ClanModTagEvent;
import me.ulrich.clans.events.ClanPlayerBanEvent;
import me.ulrich.clans.events.ClanPlayerInviteReceive;
import me.ulrich.clans.events.ClanPlayerJoinEvent;
import me.ulrich.clans.events.ClanPlayerKickedEvent;
import me.ulrich.clans.events.ClanPlayerLeaveEvent;
import me.ulrich.clans.events.ClanPlayerRoleChangeEvent;
import me.ulrich.clans.events.ClanPlayerUnbanEvent;
import me.ulrich.clans.events.ClanPointChangeEvent;
import me.ulrich.clans.events.ClanRegroupSendEvent;
import me.ulrich.clans.events.ClanRewardsEvent;
import me.ulrich.clans.events.ClanRivalAddEvent;
import me.ulrich.clans.events.ClanRivalInviteEvent;
import me.ulrich.clans.events.ClanRivalRemoveEvent;
import me.ulrich.clans.events.ClanVerifyChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/listeners/ClanLoggerListern.class */
public class ClanLoggerListern implements Listener {
    private static byte[] __aes_key_F0omibEg = {(byte) 135, (byte) 111, (byte) 61, (byte) 146, (byte) 9, (byte) 144, (byte) 166, (byte) 45, (byte) 113, (byte) 65, (byte) 225, (byte) 232, (byte) 95, (byte) 154, (byte) 171, (byte) 201, (byte) 9, (byte) 91, (byte) 162, (byte) 48, (byte) 48, (byte) 249, (byte) 188, (byte) 193, (byte) 77, (byte) 5, (byte) 244, (byte) 115, (byte) 46, (byte) 234, (byte) 179, (byte) 199};
    private static byte[] __aes_iv_vTMKN0Xu = {(byte) 173, (byte) 65, (byte) 86, (byte) 89, (byte) 204, (byte) 231, (byte) 107, (byte) 62, (byte) 68, (byte) 127, (byte) 40, (byte) 167, (byte) 181, (byte) 85, (byte) 55, (byte) 75};
    private static String __s_cache_RPGYc1w0_0;
    private static String __s_cache_iAWOf6ia_1;
    private static String __s_cache_zWWHcxaJ_2;
    private static String __s_cache_IxoOwTxA_3;
    private static String __s_cache_GeLTfgKh_4;
    private static String __s_cache_slq2bjwp_5;
    private static String __s_cache_kBVbGVs2_6;
    private static String __s_cache_oFTlYFep_7;
    private static String __s_cache_Ksbb2jQW_8;
    private static String __s_cache_AvmPoiKn_9;
    private static String __s_cache_wPmYaiRc_10;
    private static String __s_cache_IW7CPv0a_11;
    private static String __s_cache_xpDfGvDj_12;
    private static String __s_cache_YWW5VAV9_13;
    private static String __s_cache_BBLgRNQZ_14;
    private static String __s_cache_V2zHz3EA_15;
    private static String __s_cache_qjYlj0bC_16;
    private static String __s_cache_0HCDX7J4_17;
    private static String __s_cache_C57ycEvA_18;
    private static String __s_cache_Tx4sQeoK_19;
    private static String __s_cache_Z6dfynuz_20;
    private static String __s_cache_Dwtp8zJU_21;
    private static String __s_cache_cSOZtcem_22;
    private static String __s_cache_IPgC8Ib7_23;
    private static String __s_cache_UAOxhxN7_24;
    private static String __s_cache_KTsVx99N_25;
    private static String __s_cache_WNFCCxoP_26;
    private static String __s_cache_0R1b3BTA_27;
    private static String __s_cache_WXYPCwVP_28;
    private static String __s_cache_lodLrYoX_29;
    private static String __s_cache_n4rSmPF7_30;
    private static String __s_cache_LfwTOVFf_31;
    private static String __s_cache_NBKSpBhy_32;
    private static String __s_cache_cvW3NJH2_33;
    private static String __s_cache_VladUkhc_34;
    private static String __s_cache_7gJ0aMsC_35;
    private static String __s_cache_YmARqC0r_36;
    private static String __s_cache_E7ZAXzh2_37;
    private static String __s_cache_09TIO4K8_38;
    private static String __s_cache_vQtUVhMO_39;
    private static String __s_cache_Xe3G8Zuo_40;
    private static String __s_cache_VUtITcav_41;
    private static String __s_cache_d93WzGIJ_42;
    private static String __s_cache_7fnfvUf2_43;
    private static String __s_cache_GwHypEL4_44;
    private static String __s_cache_HyGgLlgz_45;
    private static String __s_cache_1VcxmrnT_46;
    private static String __s_cache_uBgYBkSU_47;
    private static String __s_cache_r7qg2Lfx_48;
    private static String __s_cache_69NkcN4N_49;

    public ClanLoggerListern() {
        Logger.getModuleCore().g().add(this);
    }

    @EventHandler
    public void onClanDeleteEvent(ClanDeleteEvent clanDeleteEvent) {
        Logger.getModuleCore().e().clearClanLogger(clanDeleteEvent.getClanID());
    }

    @EventHandler
    public void ClanRegroupSendEvent(ClanRegroupSendEvent clanRegroupSendEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanRegroupSendEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanRegroupSendEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANREGROUPSENDEVENT);
            if (clanRegroupSendEvent.getClanUUID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanRegroupSendEvent.getClanUUID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), string);
                }
            }
            Optional<PlayerData> playerData = Logger.a().getPlayerAPI().getPlayerData(clanRegroupSendEvent.getSenderUUID());
            if (playerData.isPresent()) {
                string = string.replace("{player_other}", playerData.get().getName());
            }
            Logger.getModuleCore().e().addClanLogger(clanRegroupSendEvent.getClanUUID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void ClanFFChangeEvent(ClanFFChangeEvent clanFFChangeEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanFFChangeEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanFFChangeEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANFFCHANGEEVENT);
            if (clanFFChangeEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanFFChangeEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANFFCHANGEEVENT));
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanFFChangeEvent.getClanID(), string.replace("{status}", String.valueOf(clanFFChangeEvent.isStatus())), Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void ClanRewardsEvent(ClanRewardsEvent clanRewardsEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanRewardsEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanRewardsEvent.getEventName())) {
            Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANREWARDSEVENT);
            Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanRewardsEvent.getClanUUID());
            if (clan.isPresent()) {
                Logger.getModuleCore().e().addClanLogger(clanRewardsEvent.getClanUUID(), Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANREWARDSEVENT)), Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
            }
        }
    }

    @EventHandler
    public void ClanPlayerBanEvent(ClanPlayerBanEvent clanPlayerBanEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPlayerBanEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPlayerBanEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERBANEVENT);
            Optional<PlayerData> playerData = Logger.a().getPlayerAPI().getPlayerData(clanPlayerBanEvent.getPlayer());
            if (playerData.isPresent()) {
                string = string.replace("{player_other}", playerData.get().getName());
            }
            if (clanPlayerBanEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanPlayerBanEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), string);
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanPlayerBanEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void e(ClanPlayerUnbanEvent clanPlayerUnbanEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPlayerUnbanEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPlayerUnbanEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERUNBANEVENT);
            Optional<PlayerData> playerData = Logger.a().getPlayerAPI().getPlayerData(clanPlayerUnbanEvent.getPlayer());
            if (playerData.isPresent()) {
                string = string.replace("{player_other}", playerData.get().getName());
            }
            if (clanPlayerUnbanEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanPlayerUnbanEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), string);
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanPlayerUnbanEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void ClanRivalInviteEvent(ClanRivalInviteEvent clanRivalInviteEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanRivalInviteEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanRivalInviteEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANRIVALINVITEEVENT);
            if (clanRivalInviteEvent.getClanInvite() != null) {
                string = Logger.a().getClanAPI().parseText(clanRivalInviteEvent.getClanInvite(), string);
            }
            if (clanRivalInviteEvent.getClanReceive() != null) {
                string = string.replace("{clan_other}", Logger.a().getClanAPI().getClan(clanRivalInviteEvent.getClanReceive()).get().getTagNoColor());
            }
            Logger.getModuleCore().e().addClanLogger(clanRivalInviteEvent.getClanInvite(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void ClanRivalRemoveEvent(ClanRivalRemoveEvent clanRivalRemoveEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanRivalRemoveEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanRivalRemoveEvent.getEventName())) {
            try {
                if (clanRivalRemoveEvent.getClan1() != null) {
                    String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANRIVALREMOVEEVENT);
                    Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanRivalRemoveEvent.getClan1());
                    if (clan.isPresent()) {
                        string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), string);
                    }
                    if (clanRivalRemoveEvent.getClan2() != null) {
                        Optional<ClanData> clan2 = Logger.a().getClanAPI().getClan(clanRivalRemoveEvent.getClan2());
                        if (clan2.isPresent()) {
                            string = string.replace("{clan_other}", clan2.get().getTagNoColor());
                        }
                    }
                    Logger.getModuleCore().e().addClanLogger(clanRivalRemoveEvent.getClan1(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e) {
            }
            try {
                if (clanRivalRemoveEvent.getClan2() != null) {
                    String string2 = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANRIVALREMOVEEVENT);
                    if (clanRivalRemoveEvent.getClan1() != null) {
                        string2 = string2.replace("{clan_other}", Logger.a().getClanAPI().getClan(clanRivalRemoveEvent.getClan1()).get().getTagNoColor());
                    }
                    Optional<ClanData> clan3 = Logger.a().getClanAPI().getClan(clanRivalRemoveEvent.getClan2());
                    if (clan3.isPresent()) {
                        string2 = Logger.a().getClanAPI().parseText(clan3.get().getLeader(), string2);
                    }
                    Logger.getModuleCore().e().addClanLogger(clanRivalRemoveEvent.getClan2(), string2, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e2) {
            }
        }
    }

    @EventHandler
    public void ClanRivalAddEvent(ClanRivalAddEvent clanRivalAddEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanRivalAddEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanRivalAddEvent.getEventName())) {
            try {
                if (clanRivalAddEvent.getClan1() != null) {
                    String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANRIVALADDEVENT);
                    if (clanRivalAddEvent.getClan2() != null) {
                        Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanRivalAddEvent.getClan2());
                        if (clan.isPresent()) {
                            string = string.replace("{clan_other}", clan.get().getTagNoColor());
                        }
                    }
                    Optional<ClanData> clan2 = Logger.a().getClanAPI().getClan(clanRivalAddEvent.getClan1());
                    if (clan2.isPresent()) {
                        string = Logger.a().getClanAPI().parseText(clan2.get().getLeader(), string);
                    }
                    Logger.getModuleCore().e().addClanLogger(clanRivalAddEvent.getClan1(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e) {
            }
            try {
                if (clanRivalAddEvent.getClan2() != null) {
                    String string2 = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANRIVALADDEVENT);
                    if (clanRivalAddEvent.getClan1() != null) {
                        Optional<ClanData> clan3 = Logger.a().getClanAPI().getClan(clanRivalAddEvent.getClan1());
                        if (clan3.isPresent()) {
                            string2 = string2.replace("{clan_other}", clan3.get().getTagNoColor());
                        }
                    }
                    Optional<ClanData> clan4 = Logger.a().getClanAPI().getClan(clanRivalAddEvent.getClan2());
                    if (clan4.isPresent()) {
                        string2 = Logger.a().getClanAPI().parseText(clan4.get().getLeader(), string2);
                    }
                    Logger.getModuleCore().e().addClanLogger(clanRivalAddEvent.getClan2(), string2, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e2) {
            }
        }
    }

    @EventHandler
    public void ClanAllyInviteEvent(ClanAllyInviteEvent clanAllyInviteEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanAllyInviteEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanAllyInviteEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANALLYINVITEEVENT);
            if (clanAllyInviteEvent.getClan1() != null) {
                string = Logger.a().getClanAPI().parseText(clanAllyInviteEvent.getClan1(), string);
            }
            if (clanAllyInviteEvent.getClan2() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanAllyInviteEvent.getClan2());
                if (clan.isPresent()) {
                    string = string.replace("{clan_other}", clan.get().getTagNoColor());
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanAllyInviteEvent.getClan1(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void ClanAllyAddEvent(ClanAllyAddEvent clanAllyAddEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanAllyAddEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanAllyAddEvent.getEventName())) {
            try {
                if (clanAllyAddEvent.getClan1() != null) {
                    String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANALLYADDEVENT);
                    if (clanAllyAddEvent.getClan2() != null) {
                        Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanAllyAddEvent.getClan2());
                        if (clan.isPresent()) {
                            string = string.replace("{clan_other}", clan.get().getTagNoColor());
                        }
                    }
                    Optional<ClanData> clan2 = Logger.a().getClanAPI().getClan(clanAllyAddEvent.getClan1());
                    if (clan2.isPresent()) {
                        string = Logger.a().getClanAPI().parseText(clan2.get().getLeader(), string);
                    }
                    Logger.getModuleCore().e().addClanLogger(clanAllyAddEvent.getClan1(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e) {
            }
            try {
                if (clanAllyAddEvent.getClan2() != null) {
                    String string2 = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANALLYADDEVENT);
                    if (clanAllyAddEvent.getClan1() != null) {
                        Optional<ClanData> clan3 = Logger.a().getClanAPI().getClan(clanAllyAddEvent.getClan1());
                        if (clan3.isPresent()) {
                            string2 = string2.replace("{clan_other}", clan3.get().getTagNoColor());
                        }
                    }
                    Optional<ClanData> clan4 = Logger.a().getClanAPI().getClan(clanAllyAddEvent.getClan2());
                    if (clan4.isPresent()) {
                        string2 = Logger.a().getClanAPI().parseText(clan4.get().getLeader(), string2);
                    }
                    Logger.getModuleCore().e().addClanLogger(clanAllyAddEvent.getClan2(), string2, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e2) {
            }
        }
    }

    @EventHandler
    public void ClanAllyRemoveEvent(ClanAllyRemoveEvent clanAllyRemoveEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanAllyRemoveEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanAllyRemoveEvent.getEventName())) {
            try {
                if (clanAllyRemoveEvent.getClan1() != null) {
                    String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANALLYREMOVEEVENT);
                    if (clanAllyRemoveEvent.getClan2() != null) {
                        Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanAllyRemoveEvent.getClan2());
                        if (clan.isPresent()) {
                            string = string.replace("{clan_other}", clan.get().getTagNoColor());
                        }
                    }
                    Optional<ClanData> clan2 = Logger.a().getClanAPI().getClan(clanAllyRemoveEvent.getClan1());
                    if (clan2.isPresent()) {
                        string = Logger.a().getClanAPI().parseText(clan2.get().getLeader(), string);
                    }
                    Logger.getModuleCore().e().addClanLogger(clanAllyRemoveEvent.getClan1(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e) {
            }
            try {
                if (clanAllyRemoveEvent.getClan2() != null) {
                    String string2 = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANALLYREMOVEEVENT);
                    if (clanAllyRemoveEvent.getClan1() != null) {
                        Optional<ClanData> clan3 = Logger.a().getClanAPI().getClan(clanAllyRemoveEvent.getClan1());
                        if (clan3.isPresent()) {
                            string2 = string2.replace("{clan_other}", clan3.get().getTagNoColor());
                        }
                    }
                    Optional<ClanData> clan4 = Logger.a().getClanAPI().getClan(clanAllyRemoveEvent.getClan2());
                    if (clan4.isPresent()) {
                        string2 = Logger.a().getClanAPI().parseText(clan4.get().getLeader(), string2);
                    }
                    Logger.getModuleCore().e().addClanLogger(clanAllyRemoveEvent.getClan2(), string2, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            } catch (Exception e2) {
            }
        }
    }

    @EventHandler
    public void onEvent(ClanPlayerInviteReceive clanPlayerInviteReceive) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPlayerInviteReceive.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPlayerInviteReceive.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERINVITERECEIVE);
            Optional<PlayerData> playerData = Logger.a().getPlayerAPI().getPlayerData(clanPlayerInviteReceive.getInviteData().getPlayer());
            if (playerData.isPresent()) {
                string = string.replace("{player_other}", playerData.get().getName());
            }
            if (clanPlayerInviteReceive.getInviteData().getInviter() != null) {
                string = Logger.a().getClanAPI().parseText(clanPlayerInviteReceive.getInviteData().getInviter(), string);
            }
            if (clanPlayerInviteReceive.getInviteData().getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanPlayerInviteReceive.getInviteData().getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), string);
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanPlayerInviteReceive.getInviteData().getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onDelete(ClanPlayerRoleChangeEvent clanPlayerRoleChangeEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPlayerRoleChangeEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPlayerRoleChangeEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERROLECHANGE);
            if (clanPlayerRoleChangeEvent.getPlayer() != null) {
                string = Logger.a().getClanAPI().parseText(clanPlayerRoleChangeEvent.getPlayer(), string);
            }
            if (clanPlayerRoleChangeEvent.getClanID() != null && Logger.a().getClanAPI().getClan(clanPlayerRoleChangeEvent.getClanID()).isPresent()) {
                string = Logger.a().getClanAPI().parseText(clanPlayerRoleChangeEvent.getPlayer(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERROLECHANGE));
            }
            Logger.getModuleCore().e().addClanLogger(clanPlayerRoleChangeEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onClanPlayerJoinEvent(ClanPlayerJoinEvent clanPlayerJoinEvent) {
        String text;
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPlayerJoinEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPlayerJoinEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERJOINEVENT);
            if (clanPlayerJoinEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanPlayerJoinEvent.getClanID());
                if (clan.isPresent()) {
                    if (clanPlayerJoinEvent.getPlayer() != null) {
                        text = Logger.a().getClanAPI().parseText(clanPlayerJoinEvent.getPlayer(), string);
                    } else {
                        text = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERJOINEVENT));
                    }
                    Logger.getModuleCore().e().addClanLogger(clanPlayerJoinEvent.getClanID(), text, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            }
        }
    }

    @EventHandler
    public void onDelete(ClanPlayerKickedEvent clanPlayerKickedEvent) {
        String strReplace;
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPlayerKickedEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPlayerKickedEvent.getEventName())) {
            Optional<PlayerData> playerData = Logger.a().getPlayerAPI().getPlayerData(clanPlayerKickedEvent.getPlayerKicked());
            Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERKICKEDEVENT);
            if (clanPlayerKickedEvent.getClanID() != null && Logger.a().getClanAPI().getClan(clanPlayerKickedEvent.getClanID()).isPresent() && playerData.isPresent()) {
                String text = Logger.a().getClanAPI().parseText(playerData.get().getUuid(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERKICKEDEVENT));
                if (clanPlayerKickedEvent.getSender().isPresent()) {
                    Optional<PlayerData> playerData2 = Logger.a().getPlayerAPI().getPlayerData(clanPlayerKickedEvent.getSender().get());
                    strReplace = playerData2.isPresent() ? text.replace("{player_kicker}", playerData2.get().getName()) : text.replace("{player_kicker}", Logger.getModuleCore().c().c().getString(Lang.TRANSLACTION_CONSOLE));
                } else {
                    strReplace = text.replace("{player_kicker}", Logger.getModuleCore().c().c().getString(Lang.TRANSLACTION_CONSOLE));
                }
                Logger.getModuleCore().e().addClanLogger(clanPlayerKickedEvent.getClanID(), strReplace, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
            }
        }
    }

    @EventHandler
    public void onDelete(ClanPlayerLeaveEvent clanPlayerLeaveEvent) {
        String text;
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPlayerLeaveEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPlayerLeaveEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERLEAVEEVENT);
            if (clanPlayerLeaveEvent.getPlayer() != null) {
                string = Logger.a().getClanAPI().parseText(clanPlayerLeaveEvent.getPlayer(), string);
            }
            if (clanPlayerLeaveEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanPlayerLeaveEvent.getClanID());
                if (clan.isPresent()) {
                    if (clanPlayerLeaveEvent.getSender() != null) {
                        text = Logger.a().getClanAPI().parseText(clanPlayerLeaveEvent.getSender(), string);
                    } else {
                        text = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPLAYERLEAVEEVENT));
                    }
                    Logger.getModuleCore().e().addClanLogger(clanPlayerLeaveEvent.getClanID(), text, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            }
        }
    }

    @EventHandler
    public void onClanCreateEvent(ClanCreateEvent clanCreateEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanCreateEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanCreateEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANCREATEEVENT);
            if (clanCreateEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanCreateEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANCREATEEVENT));
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanCreateEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onDelete(ClanModTagEvent clanModTagEvent) {
        String text;
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanModTagEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanModTagEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANMODTAGEVENT);
            if (clanModTagEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanModTagEvent.getClanID());
                if (clan.isPresent()) {
                    if (clanModTagEvent.getSender() != null) {
                        text = Logger.a().getClanAPI().parseText(clanModTagEvent.getSender(), string);
                    } else {
                        text = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANMODTAGEVENT));
                    }
                    Logger.getModuleCore().e().addClanLogger(clanModTagEvent.getClanID(), text, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            }
        }
    }

    @EventHandler
    public void onDelete(ClanModDescEvent clanModDescEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanModDescEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanModDescEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANMODDESCEVENT);
            if (clanModDescEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanModDescEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANMODDESCEVENT));
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanModDescEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onDelete(ClanPointChangeEvent clanPointChangeEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanPointChangeEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanPointChangeEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPOINTCHANGEEVENT);
            if (clanPointChangeEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanPointChangeEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANPOINTCHANGEEVENT));
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanPointChangeEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onDelete(ClanLevelEvent clanLevelEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanLevelEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanLevelEvent.getEventName())) {
            Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANLEVELEVENT);
            if (clanLevelEvent.isChangedPatent()) {
                Logger.getModuleCore().c().c().getString(Lang.LOGGER_PATENT_CLANLEVELEVENT);
            }
            if (clanLevelEvent.getClanUUID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanLevelEvent.getClanUUID());
                if (clan.isPresent()) {
                    String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANLEVELEVENT);
                    if (clanLevelEvent.isChangedPatent()) {
                        string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_PATENT_CLANLEVELEVENT);
                    }
                    Logger.getModuleCore().e().addClanLogger(clan.get().getId(), Logger.a().getClanAPI().parseText(clan.get().getLeader(), string), Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
                }
            }
        }
    }

    @EventHandler
    public void onDelete(ClanVerifyChangeEvent clanVerifyChangeEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanVerifyChangeEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanVerifyChangeEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANVERIFYCHANGEEVENT);
            if (clanVerifyChangeEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanVerifyChangeEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANVERIFYCHANGEEVENT));
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanVerifyChangeEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onDelete(ClanLeaderChangeEvent clanLeaderChangeEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanLeaderChangeEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanLeaderChangeEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANLEADERCHANGEEVENT);
            if (clanLeaderChangeEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanLeaderChangeEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANLEADERCHANGEEVENT));
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanLeaderChangeEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onDelete(ClanHomeCreateEvent clanHomeCreateEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanHomeCreateEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanHomeCreateEvent.getEventName()) && clanHomeCreateEvent.getClanID() != null) {
            Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanHomeCreateEvent.getClanID());
            if (clan.isPresent()) {
                Logger.getModuleCore().e().addClanLogger(clanHomeCreateEvent.getClanID(), Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANHOMECREATEEVENT).replace("{home}", "{" + clanHomeCreateEvent.getHomeName() + "}")), Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
            }
        }
    }

    @EventHandler
    public void onDelete(ClanHomeDeleteEvent clanHomeDeleteEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanHomeDeleteEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanHomeDeleteEvent.getEventName())) {
            Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanHomeDeleteEvent.getClanID());
            if (clanHomeDeleteEvent.getClanID() == null || !clan.isPresent()) {
                return;
            }
            Logger.getModuleCore().e().addClanLogger(clanHomeDeleteEvent.getClanID(), Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANHOMEDELETEEVENT).replace("{home}", clanHomeDeleteEvent.getHomeName())), Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    @EventHandler
    public void onDelete(ClanBannerChangeEvent clanBannerChangeEvent) {
        if (Logger.getModuleCore().c().i().contains("Config.Logger.events." + clanBannerChangeEvent.getEventName()) && Logger.getModuleCore().c().i().getBoolean("Config.Logger.events." + clanBannerChangeEvent.getEventName())) {
            String string = Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANBANNERCHANGEEVENT);
            if (clanBannerChangeEvent.getClanID() != null) {
                Optional<ClanData> clan = Logger.a().getClanAPI().getClan(clanBannerChangeEvent.getClanID());
                if (clan.isPresent()) {
                    string = Logger.a().getClanAPI().parseText(clan.get().getLeader(), Logger.getModuleCore().c().c().getString(Lang.LOGGER_CLANBANNERCHANGEEVENT));
                }
            }
            Logger.getModuleCore().e().addClanLogger(clanBannerChangeEvent.getClanID(), string, Logger.getModuleCore().c().i().getString("Config.Logger.plugin_name"), null);
        }
    }

    private static String __unused_158() {
        return "{player_other}";
    }

    private static String __unused_159() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_160() {
        return "{status}";
    }

    private static String __unused_161() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_162() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_163() {
        return "{player_other}";
    }

    private static String __unused_164() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_165() {
        return "{player_other}";
    }

    private static String __unused_166() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_167() {
        return "{clan_other}";
    }

    private static String __unused_168() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_169() {
        return "{clan_other}";
    }

    private static String __unused_170() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_171() {
        return "{clan_other}";
    }

    private static String __unused_172() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_173() {
        return "{clan_other}";
    }

    private static String __unused_174() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_175() {
        return "{clan_other}";
    }

    private static String __unused_176() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_177() {
        return "{clan_other}";
    }

    private static String __unused_178() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_179() {
        return "{clan_other}";
    }

    private static String __unused_180() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_181() {
        return "{clan_other}";
    }

    private static String __unused_182() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_183() {
        return "{clan_other}";
    }

    private static String __unused_184() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_185() {
        return "{clan_other}";
    }

    private static String __unused_186() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_187() {
        return "{player_other}";
    }

    private static String __unused_188() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_189() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_190() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_191() {
        return "{player_kicker}";
    }

    private static String __unused_192() {
        return "{player_kicker}";
    }

    private static String __unused_193() {
        return "{player_kicker}";
    }

    private static String __unused_194() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_195() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_196() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_197() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_198() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_199() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_200() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_201() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_202() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_203() {
        return "{home}";
    }

    private static String __unused_204() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_205() {
        return "{home}";
    }

    private static String __unused_206() {
        return "Config.Logger.plugin_name";
    }

    private static String __unused_207() {
        return "Config.Logger.plugin_name";
    }
}
