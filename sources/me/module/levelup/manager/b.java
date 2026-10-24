package me.module.levelup.manager;

import java.util.Optional;
import java.util.UUID;
import me.module.levelup.Levelup;
import me.module.levelup.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.PatentData;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/b.class */
public class b {
    private static byte[] __aes_key_7WALO4PZ = {(byte) 7, (byte) 220, (byte) 65, (byte) 146, (byte) 130, (byte) 182, (byte) 131, (byte) 70, (byte) 8, (byte) 38, (byte) 206, (byte) 89, (byte) 188, (byte) 166, (byte) 167, (byte) 75, (byte) 20, (byte) 176, (byte) 157, (byte) 204, (byte) 205, (byte) 212, (byte) 224, (byte) 159, (byte) 39, (byte) 143, (byte) 15, (byte) 98, (byte) 215, (byte) 203, (byte) 29, (byte) 160};
    private static byte[] __aes_iv_GClBizAc = {(byte) 16, (byte) 25, (byte) 187, (byte) 180, (byte) 244, (byte) 71, (byte) 206, (byte) 120, (byte) 26, (byte) 234, (byte) 255, (byte) 253, (byte) 73, (byte) 3, (byte) 34, (byte) 143};
    private static String __s_cache_0v4i3ZMk_0;
    private static String __s_cache_ST1r1Aco_1;
    private static String __s_cache_yO598Kpx_2;
    private static String __s_cache_dgjuTYSN_3;
    private static String __s_cache_s35gYxCV_4;
    private static String __s_cache_JzDUnFjS_5;
    private static String __s_cache_Vvc3GFRG_6;
    private static String __s_cache_uB56zqQG_7;
    private static String __s_cache_GW07UXN9_8;
    private static String __s_cache_3N3StkE9_9;
    private static String __s_cache_uh1i921L_10;
    private static String __s_cache_ZQUtOFTy_11;

    public String a(Player player, String str) {
        return a(player.getUniqueId(), str);
    }

    public String a(UUID uuid, String str) {
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return str;
        }
        if (str.equals("max_level")) {
            return String.valueOf(Levelup.getModuleCore().c().i().getInt("Level.points.max_level"));
        }
        if (str.equals("next_level")) {
            if (playerClan.isPresent()) {
                Optional<ClanData> playerClan2 = Levelup.a().getPlayerAPI().getPlayerClan(uuid);
                if (playerClan2.isPresent()) {
                    Optional<Integer> optionalClanNextLevel = Levelup.getModuleCore().e().clanNextLevel(playerClan2.get().getId());
                    return optionalClanNextLevel.isPresent() ? String.valueOf(optionalClanNextLevel.get()) : String.valueOf(playerClan2.get().getLevel());
                }
            }
            return "0";
        }
        if (str.equals("has_next_requeriments_level")) {
            return (playerClan.isPresent() && Levelup.a().getPlayerAPI().getPlayerClan(uuid).isPresent()) ? String.valueOf(Levelup.getModuleCore().e().hasPlayerClanRequeriments(uuid)) : "false";
        }
        if (str.equals("has_next_requeriments_level_formated")) {
            if (playerClan.isPresent() && Levelup.a().getPlayerAPI().getPlayerClan(uuid).isPresent()) {
                return Levelup.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.valueOf("TRANSLACTION_NOYES_" + String.valueOf(Levelup.getModuleCore().e().hasPlayerClanRequeriments(uuid)).toUpperCase()));
            }
            return "false";
        }
        if (str.equals("points_to_nextlevel")) {
            return playerClan.isPresent() ? String.valueOf(Levelup.getModuleCore().e().getPointsNextLevel(playerClan.get())) : "0";
        }
        if (str.equals("patent_name")) {
            if (!playerClan.isPresent()) {
                return null;
            }
            Optional<PatentData> patent = Levelup.getModuleCore().e().getPatent(playerClan.get().getPatent());
            return patent.isPresent() ? String.valueOf(patent.get().getId()) : Levelup.getModuleCore().e().getFirstPatent().get().getName();
        }
        if (!str.equals("patent_formated") || !playerClan.isPresent()) {
            return null;
        }
        Optional<PatentData> patent2 = Levelup.getModuleCore().e().getPatent(playerClan.get().getPatent());
        return patent2.isPresent() ? String.valueOf(patent2.get().getName()) : Levelup.getModuleCore().e().getFirstPatent().get().getName();
    }

    private static String __unused_917() {
        return "max_level";
    }

    private static String __unused_918() {
        return "Level.points.max_level";
    }

    private static String __unused_919() {
        return "next_level";
    }

    private static String __unused_920() {
        return "0";
    }

    private static String __unused_921() {
        return "has_next_requeriments_level";
    }

    private static String __unused_922() {
        return "false";
    }

    private static String __unused_923() {
        return "has_next_requeriments_level_formated";
    }

    private static String __unused_924() {
        return "false";
    }

    private static String __unused_925() {
        return "points_to_nextlevel";
    }

    private static String __unused_926() {
        return "0";
    }

    private static String __unused_927() {
        return "patent_name";
    }

    private static String __unused_928() {
        return "patent_formated";
    }
}
