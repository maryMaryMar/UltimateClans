package me.module.rivalally.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.UUID;
import me.module.rivalally.Rivalally;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.PlayerData;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/d.class */
public class d {
    private static byte[] __aes_key_dmMjoqdJ = {(byte) 233, (byte) 170, (byte) 137, (byte) 94, (byte) 135, (byte) 133, (byte) 86, (byte) 158, (byte) 82, (byte) 236, (byte) 138, (byte) 172, (byte) 196, (byte) 7, (byte) 197, (byte) 20, (byte) 36, (byte) 0, (byte) 57, (byte) 23, (byte) 26, (byte) 143, (byte) 12, (byte) 222, (byte) 64, (byte) 56, (byte) 164, (byte) 7, (byte) 224, (byte) 32, (byte) 5, (byte) 11};
    private static byte[] __aes_iv_d0JZXo8r = {(byte) 182, (byte) 0, (byte) 240, (byte) 78, (byte) 84, (byte) 15, (byte) 192, (byte) 99, (byte) 101, (byte) 57, (byte) 177, (byte) 232, (byte) 4, (byte) 47, (byte) 228, (byte) 34};
    private static String __s_cache_ukUb0dXO_0;
    private static String __s_cache_VLvOIW42_1;
    private static String __s_cache_Gp33OkBn_2;
    private static String __s_cache_nundVYH4_3;
    private static String __s_cache_KWtSvJ95_4;
    private static String __s_cache_alD28y8P_5;
    private static String __s_cache_6ZrvfAgO_6;
    private static String __s_cache_rrCG0yDu_7;
    private static String __s_cache_jRXk2P9d_8;
    private static String __s_cache_yqvEvOiR_9;
    private static String __s_cache_XICiYIbq_10;
    private static String __s_cache_lmh489KM_11;
    private static String __s_cache_0GJW8a1Y_12;
    private static String __s_cache_H9AJYyHH_13;
    private static String __s_cache_X7niX5Qe_14;
    private static String __s_cache_cWl1Gaou_15;
    private static String __s_cache_NXcXP9CB_16;
    private static String __s_cache_xgEszNTv_17;

    public String a(Player player, String str) {
        return a(player.getUniqueId(), str);
    }

    public String a(UUID uuid, String str) {
        Optional<ClanData> playerClan = Rivalally.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return str;
        }
        if (str.equals("clan_rival")) {
            if (!playerClan.isPresent()) {
                return null;
            }
            String string = "";
            try {
                int i = 1;
                if (playerClan.get().getRivalAlly().getRival().size() > 0) {
                    Iterator<UUID> it = playerClan.get().getRivalAlly().getRival().iterator();
                    while (it.hasNext()) {
                        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(it.next());
                        if (clan.isPresent()) {
                            String tag = clan.get().getTag();
                            string = i >= playerClan.get().getRivalAlly().getRival().size() ? string + tag + "." : string + tag + ", ";
                            i++;
                        }
                    }
                } else {
                    string = Rivalally.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.NOTHING_HERE);
                }
            } catch (Exception e) {
            }
            return string;
        }
        if (str.equals("clan_count_rival")) {
            return playerClan.isPresent() ? String.valueOf(playerClan.get().getRivalAlly().getRival().size()) : "0";
        }
        if (str.equals("clan_count_ally")) {
            return playerClan.isPresent() ? String.valueOf(playerClan.get().getRivalAlly().getAlly().size()) : "0";
        }
        if (str.equals("clan_ally")) {
            if (!playerClan.isPresent()) {
                return null;
            }
            String string2 = "";
            try {
                int i2 = 1;
                if (playerClan.get().getRivalAlly().getAlly().size() > 0) {
                    Iterator<UUID> it2 = playerClan.get().getRivalAlly().getAlly().iterator();
                    while (it2.hasNext()) {
                        Optional<ClanData> clan2 = Rivalally.a().getClanAPI().getClan(it2.next());
                        if (clan2.isPresent()) {
                            String tag2 = clan2.get().getTag();
                            string2 = i2 >= playerClan.get().getRivalAlly().getAlly().size() ? string2 + tag2 + "." : string2 + tag2 + ", ";
                        }
                        i2++;
                    }
                } else {
                    string2 = Rivalally.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.NOTHING_HERE);
                }
            } catch (Exception e2) {
            }
            return string2;
        }
        if (str.equals("limit_ally")) {
            return playerClan.isPresent() ? String.valueOf(Rivalally.getModuleCore().e().allyRivalCount(playerClan.get(), ClanEnum.RivalAllyCount.ALLY)) : "0";
        }
        if (str.equals("limit_rival")) {
            return playerClan.isPresent() ? String.valueOf(Rivalally.getModuleCore().e().allyRivalCount(playerClan.get(), ClanEnum.RivalAllyCount.RIVAL)) : "0";
        }
        if (str.equals("clan_rival_members_amount")) {
            int size = 0;
            if (playerClan.isPresent()) {
                Iterator<UUID> it3 = playerClan.get().getRivalAlly().getRival().iterator();
                while (it3.hasNext()) {
                    Optional<ClanData> clan3 = Rivalally.a().getClanAPI().getClan(it3.next());
                    if (clan3.isPresent()) {
                        size += clan3.get().getMembers().size();
                    }
                }
            }
            return String.valueOf(size);
        }
        if (str.equals("clan_rival_members_list")) {
            ArrayList arrayList = new ArrayList();
            if (playerClan.isPresent()) {
                Iterator<UUID> it4 = playerClan.get().getRivalAlly().getRival().iterator();
                while (it4.hasNext()) {
                    Optional<ClanData> clan4 = Rivalally.a().getClanAPI().getClan(it4.next());
                    if (clan4.isPresent()) {
                        clan4.get().getMembers().iterator().forEachRemaining(uuid2 -> {
                            Optional<PlayerData> playerData = Rivalally.a().getPlayerAPI().getPlayerData(uuid2);
                            if (playerData.isPresent()) {
                                arrayList.add(playerData.get().getName());
                            }
                        });
                    }
                }
            }
            return e.a(arrayList, uuid);
        }
        if (str.equals("clan_rival_members_online_amount")) {
            int size2 = 0;
            if (playerClan.isPresent()) {
                Iterator<UUID> it5 = playerClan.get().getRivalAlly().getRival().iterator();
                while (it5.hasNext()) {
                    Optional<ClanData> clan5 = Rivalally.a().getClanAPI().getClan(it5.next());
                    if (clan5.isPresent()) {
                        size2 += clan5.get().getOnlineMembers().size();
                    }
                }
            }
            return String.valueOf(size2);
        }
        if (str.equals("clan_rival_members_online_list")) {
            ArrayList arrayList2 = new ArrayList();
            if (playerClan.isPresent()) {
                Iterator<UUID> it6 = playerClan.get().getRivalAlly().getRival().iterator();
                while (it6.hasNext()) {
                    Optional<ClanData> clan6 = Rivalally.a().getClanAPI().getClan(it6.next());
                    if (clan6.isPresent()) {
                        clan6.get().getOnlineMembers().iterator().forEachRemaining(uuid3 -> {
                            Optional<PlayerData> playerData = Rivalally.a().getPlayerAPI().getPlayerData(uuid3);
                            if (playerData.isPresent()) {
                                arrayList2.add(playerData.get().getName());
                            }
                        });
                    }
                }
            }
            return e.a(arrayList2, uuid);
        }
        if (str.equals("clan_ally_members_amount")) {
            int size3 = 0;
            if (playerClan.isPresent()) {
                Iterator<UUID> it7 = playerClan.get().getRivalAlly().getAlly().iterator();
                while (it7.hasNext()) {
                    Optional<ClanData> clan7 = Rivalally.a().getClanAPI().getClan(it7.next());
                    if (clan7.isPresent()) {
                        size3 += clan7.get().getMembers().size();
                    }
                }
            }
            return String.valueOf(size3);
        }
        if (str.equals("clan_ally_members_list")) {
            ArrayList arrayList3 = new ArrayList();
            if (playerClan.isPresent()) {
                Iterator<UUID> it8 = playerClan.get().getRivalAlly().getAlly().iterator();
                while (it8.hasNext()) {
                    Optional<ClanData> clan8 = Rivalally.a().getClanAPI().getClan(it8.next());
                    if (clan8.isPresent()) {
                        clan8.get().getMembers().iterator().forEachRemaining(uuid4 -> {
                            Optional<PlayerData> playerData = Rivalally.a().getPlayerAPI().getPlayerData(uuid4);
                            if (playerData.isPresent()) {
                                arrayList3.add(playerData.get().getName());
                            }
                        });
                    }
                }
            }
            return e.a(arrayList3, uuid);
        }
        if (str.equals("clan_ally_members_online_amount")) {
            int size4 = 0;
            if (playerClan.isPresent()) {
                Iterator<UUID> it9 = playerClan.get().getRivalAlly().getAlly().iterator();
                while (it9.hasNext()) {
                    Optional<ClanData> clan9 = Rivalally.a().getClanAPI().getClan(it9.next());
                    if (clan9.isPresent()) {
                        size4 += clan9.get().getOnlineMembers().size();
                    }
                }
            }
            return String.valueOf(size4);
        }
        if (!str.equals("clan_ally_members_online_list")) {
            return null;
        }
        ArrayList arrayList4 = new ArrayList();
        if (playerClan.isPresent()) {
            Iterator<UUID> it10 = playerClan.get().getRivalAlly().getAlly().iterator();
            while (it10.hasNext()) {
                Optional<ClanData> clan10 = Rivalally.a().getClanAPI().getClan(it10.next());
                if (clan10.isPresent()) {
                    clan10.get().getOnlineMembers().iterator().forEachRemaining(uuid5 -> {
                        Optional<PlayerData> playerData = Rivalally.a().getPlayerAPI().getPlayerData(uuid5);
                        if (playerData.isPresent()) {
                            arrayList4.add(playerData.get().getName());
                        }
                    });
                }
            }
        }
        return e.a(arrayList4, uuid);
    }

    private static String __unused_1209() {
        return "clan_rival";
    }

    private static String __unused_1210() {
        return "clan_count_rival";
    }

    private static String __unused_1211() {
        return "0";
    }

    private static String __unused_1212() {
        return "clan_count_ally";
    }

    private static String __unused_1213() {
        return "0";
    }

    private static String __unused_1214() {
        return "clan_ally";
    }

    private static String __unused_1215() {
        return "limit_ally";
    }

    private static String __unused_1216() {
        return "0";
    }

    private static String __unused_1217() {
        return "limit_rival";
    }

    private static String __unused_1218() {
        return "0";
    }

    private static String __unused_1219() {
        return "clan_rival_members_amount";
    }

    private static String __unused_1220() {
        return "clan_rival_members_list";
    }

    private static String __unused_1221() {
        return "clan_rival_members_online_amount";
    }

    private static String __unused_1222() {
        return "clan_rival_members_online_list";
    }

    private static String __unused_1223() {
        return "clan_ally_members_amount";
    }

    private static String __unused_1224() {
        return "clan_ally_members_list";
    }

    private static String __unused_1225() {
        return "clan_ally_members_online_amount";
    }

    private static String __unused_1226() {
        return "clan_ally_members_online_list";
    }
}
