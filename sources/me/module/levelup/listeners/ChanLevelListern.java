package me.module.levelup.listeners;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;
import me.module.levelup.Levelup;
import me.module.levelup.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.events.ClanCreateEvent;
import me.ulrich.clans.events.ClanLevelEvent;
import me.ulrich.clans.events.ClanPlayerBanEvent;
import me.ulrich.clans.events.ClanPlayerJoinEvent;
import me.ulrich.clans.events.ClanPlayerKDRChangeEvent;
import me.ulrich.clans.events.ClanPlayerKickedEvent;
import me.ulrich.clans.events.ClanPlayerLeaveEvent;
import me.ulrich.clans.events.ClanPlayerRoleChangeEvent;
import me.ulrich.clans.events.ClanVerifyChangeEvent;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/listeners/ChanLevelListern.class */
public class ChanLevelListern implements Listener {
    private static byte[] __aes_key_xnQj8Kzw = {(byte) 133, (byte) 219, (byte) 39, (byte) 42, (byte) 88, (byte) 243, (byte) 49, (byte) 202, (byte) 187, (byte) 32, (byte) 69, (byte) 218, (byte) 91, (byte) 140, (byte) 76, (byte) 47, (byte) 238, (byte) 196, (byte) 146, (byte) 78, (byte) 137, (byte) 27, (byte) 255, (byte) 81, (byte) 207, (byte) 0, (byte) 190, (byte) 223, (byte) 109, (byte) 165, (byte) 129, (byte) 95};
    private static byte[] __aes_iv_0BShlsb4 = {(byte) 139, (byte) 220, (byte) 209, (byte) 122, (byte) 0, (byte) 111, (byte) 205, (byte) 247, (byte) 93, (byte) 151, (byte) 0, (byte) 78, (byte) 130, (byte) 87, (byte) 232, (byte) 254};
    private static String __s_cache_UQOrkgAa_0;
    private static String __s_cache_XY5EYPQw_1;
    private static String __s_cache_q66lrtpF_2;
    private static String __s_cache_keEK4f98_3;
    private static String __s_cache_tePZciRh_4;
    private static String __s_cache_bSlYyfi1_5;
    private static String __s_cache_VKCZVsQC_6;
    private static String __s_cache_K8k9jIUe_7;

    public ChanLevelListern() {
        Levelup.getModuleCore().f().add(this);
    }

    @EventHandler
    public void onClanVerifyChangeEvent(ClanVerifyChangeEvent clanVerifyChangeEvent) {
        Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.CLANVERIFY, clanVerifyChangeEvent.getClanID());
    }

    @EventHandler
    public void onClanCreateEvent1(ClanCreateEvent clanCreateEvent) {
        Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.CREATE, clanCreateEvent.getClanID());
    }

    @EventHandler
    public void onClanCreateEvent2(ClanCreateEvent clanCreateEvent) {
        if (Levelup.getModuleCore().c().i().getInt("Level.points.start_level") >= 0) {
            Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(clanCreateEvent.getClanID());
            if (clan.isPresent()) {
                clan.get().setLevel(Levelup.getModuleCore().c().i().getInt("Level.points.start_level"));
                clan.get().setPatent(Levelup.getModuleCore().e().getFirstPatent().get().getId());
                Levelup.a().getClanAPI().saveClanData(clan.get());
            }
        }
    }

    @EventHandler
    public void onClanPlayerLeaveEvent(ClanPlayerLeaveEvent clanPlayerLeaveEvent) {
        Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.REMOVEMEMBER, clanPlayerLeaveEvent.getClanID());
    }

    @EventHandler
    public void onClanPlayerKickedEvent(ClanPlayerKickedEvent clanPlayerKickedEvent) {
        Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.REMOVEMEMBER, clanPlayerKickedEvent.getClanID());
    }

    @EventHandler
    public void onClanPlayerJoinEvent(ClanPlayerJoinEvent clanPlayerJoinEvent) {
        Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.NEWMEMBER, clanPlayerJoinEvent.getClanID());
    }

    @EventHandler
    public void onClanPlayerKDRChangeEvent(ClanPlayerKDRChangeEvent clanPlayerKDRChangeEvent) {
        if (clanPlayerKDRChangeEvent.getType().equals(ClanEnum.KdrChangeType.KILL)) {
            Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(clanPlayerKDRChangeEvent.getPlayerUUID());
            if (playerClan.isPresent()) {
                Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.KILLMEMBER, playerClan.get().getId());
                return;
            }
            return;
        }
        if (clanPlayerKDRChangeEvent.getType().equals(ClanEnum.KdrChangeType.DEATH)) {
            Optional<ClanData> playerClan2 = Levelup.a().getPlayerAPI().getPlayerClan(clanPlayerKDRChangeEvent.getPlayerUUID());
            if (playerClan2.isPresent()) {
                Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.DEATHMEMBER, playerClan2.get().getId());
            }
        }
    }

    @EventHandler
    public void onClanPlayerRoleChangeEvent(ClanPlayerRoleChangeEvent clanPlayerRoleChangeEvent) {
        if (clanPlayerRoleChangeEvent.getAction().equals(ClanEnum.ClanActions.DEMOTEMEMBER) || clanPlayerRoleChangeEvent.getAction().equals(ClanEnum.ClanActions.PROMOTEMEMBER)) {
            Levelup.getModuleCore().e().check_actions(clanPlayerRoleChangeEvent.getAction(), clanPlayerRoleChangeEvent.getClanID());
        }
    }

    @EventHandler
    public void onClanPlayerBanEvent(ClanPlayerBanEvent clanPlayerBanEvent) {
        if (Levelup.a().getPlayerAPI().isSameClan(clanPlayerBanEvent.getPlayer(), clanPlayerBanEvent.getSender())) {
            Levelup.getModuleCore().e().check_actions(ClanEnum.ClanActions.REMOVEMEMBER, clanPlayerBanEvent.getClanID());
        }
    }

    @EventHandler
    public void onLevelEvent(ClanLevelEvent clanLevelEvent) {
        Optional<ClanData> clan = Levelup.a().getClanAPI().getClan(clanLevelEvent.getClanUUID());
        if (clan.isPresent()) {
            int level = clan.get().getLevel();
            int maxlevel = clan.get().getMaxlevel();
            if (level > maxlevel) {
                clan.get().setMaxlevel(level);
                Levelup.a().getClanAPI().saveClanData(clan.get());
            }
            if (clanLevelEvent.isChangedPatent()) {
                ArrayList arrayList = new ArrayList();
                Iterator<UUID> it = clan.get().getMembers().iterator();
                Levelup.getModuleCore().e().getPatent(clan.get().getPatent()).ifPresent(patentData -> {
                    int i;
                    Optional<PlayerData> playerData;
                    while (it.hasNext()) {
                        UUID uuid = (UUID) it.next();
                        try {
                            if (!Bukkit.getPlayer(uuid).isOnline() || !patentData.getRewardsDisabledWorld().contains(Bukkit.getPlayer(uuid).getWorld().getName())) {
                                if (level > maxlevel) {
                                    try {
                                        if (patentData.isRewardsOnlyOnce()) {
                                            if (clanLevelEvent.isChangedPatent()) {
                                                for (i = 0; i < patentData.getRewards().size(); i++) {
                                                    playerData = Levelup.a().getPlayerAPI().getPlayerData(uuid);
                                                    if (playerData.isPresent()) {
                                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), patentData.getRewards().get(i).replace("%player%", playerData.get().getName()).replace("/", ""));
                                                    }
                                                }
                                            }
                                        } else if (!patentData.isRewardsOnlyOnce()) {
                                            if (clanLevelEvent.isChangedPatent() && patentData.getRewards().size() > 0) {
                                                while (i < patentData.getRewards().size()) {
                                                    playerData = Levelup.a().getPlayerAPI().getPlayerData(uuid);
                                                    if (playerData.isPresent()) {
                                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), patentData.getRewards().get(i).replace("%player%", playerData.get().getName()).replace("/", ""));
                                                    }
                                                }
                                            }
                                        }
                                    } catch (Exception e) {
                                    }
                                } else if (!patentData.isRewardsOnlyOnce()) {
                                    if (clanLevelEvent.isChangedPatent()) {
                                        while (i < patentData.getRewards().size()) {
                                            playerData = Levelup.a().getPlayerAPI().getPlayerData(uuid);
                                            if (playerData.isPresent()) {
                                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), patentData.getRewards().get(i).replace("%player%", playerData.get().getName()).replace("/", ""));
                                            }
                                        }
                                    }
                                }
                                try {
                                    if (Bukkit.getPlayer(uuid).isOnline()) {
                                        arrayList.add(Bukkit.getPlayer(uuid));
                                    }
                                } catch (Exception e2) {
                                }
                            }
                        } catch (Exception e3) {
                        }
                    }
                });
                if (clanLevelEvent.isChangedPatent()) {
                    String text = Levelup.a().getClanAPI().parseText(clan.get().getLeader(), Levelup.getModuleCore().c().c().getString(Lang.CLAN_PATENT_CHANGE));
                    if (text != null) {
                        MessageUtils.allOnlineMessage(text, null, arrayList);
                    }
                    MessageUtils.clanMessageJson(clan.get(), ClanEnum.ChatDataType.CLANPATENTRECEIVED, null);
                    return;
                }
                return;
            }
            MessageUtils.clanMessageJson(clan.get(), ClanEnum.ChatDataType.CLANLEVELRECEIVED, null);
            ConfigurationSection configurationSection = Levelup.getModuleCore().c().i().getConfigurationSection("Level.rewards");
            ArrayList arrayList2 = new ArrayList();
            if (configurationSection != null) {
                Iterator it2 = configurationSection.getKeys(false).iterator();
                ArrayList arrayList3 = new ArrayList();
                while (it2.hasNext()) {
                    try {
                        String[] strArrSplit = ((String) it2.next()).split("_");
                        if (clan.get().getLevel() == Integer.valueOf(strArrSplit[1]).intValue()) {
                            arrayList3.addAll(Levelup.getModuleCore().c().i().getStringList("Level.rewards.level_" + Integer.valueOf(strArrSplit[1])));
                        }
                    } catch (Exception e) {
                    }
                }
                for (UUID uuid : clan.get().getMembers()) {
                    if (level > maxlevel) {
                        try {
                            if (arrayList3.size() > 0) {
                                for (int i = 0; i < arrayList3.size(); i++) {
                                    Optional<PlayerData> playerData = Levelup.a().getPlayerAPI().getPlayerData(uuid);
                                    if (playerData.isPresent()) {
                                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ((String) arrayList3.get(i)).replace("%player%", playerData.get().getName()).replace("/", ""));
                                    }
                                }
                            }
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        if (Bukkit.getPlayer(uuid).isOnline()) {
                            arrayList2.add(Bukkit.getPlayer(uuid));
                        }
                    } catch (Exception e3) {
                    }
                }
            }
        }
    }

    private static String __unused_957() {
        return "Level.points.start_level";
    }

    private static String __unused_958() {
        return "Level.points.start_level";
    }

    private static String __unused_959() {
        return "Level.rewards";
    }

    private static String __unused_960() {
        return "_";
    }

    private static String __unused_961() {
        return "%player%";
    }

    private static String __unused_962() {
        return "/";
    }

    private static String __unused_963() {
        return "%player%";
    }

    private static String __unused_964() {
        return "/";
    }
}
