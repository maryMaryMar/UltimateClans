package me.module.rewards.manager;

import java.util.UUID;
import me.module.rewards.Rewards;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/e.class */
public class e {
    private static byte[] __aes_key_KD4tXk2M = {(byte) 84, (byte) 21, (byte) 241, (byte) 39, (byte) 132, (byte) 247, (byte) 93, (byte) 60, (byte) 131, (byte) 196, (byte) 219, (byte) 188, (byte) 4, (byte) 8, (byte) 60, (byte) 212, (byte) 250, (byte) 32, (byte) 9, (byte) 73, (byte) 143, (byte) 215, (byte) 193, (byte) 23, (byte) 152, (byte) 157, (byte) 153, (byte) 239, (byte) 2, (byte) 64, (byte) 39, (byte) 208};
    private static byte[] __aes_iv_DOc6Oqdr = {(byte) 230, (byte) 9, (byte) 219, (byte) 28, (byte) 38, (byte) 93, (byte) 249, (byte) 214, (byte) 4, (byte) 73, (byte) 189, (byte) 251, (byte) 38, (byte) 207, (byte) 3, (byte) 246};
    private static String __s_cache_0un3jgl7_0;
    private static String __s_cache_73Z0qFjI_1;

    public String a(Player player, String str) {
        return a(player.getUniqueId(), str);
    }

    public String a(UUID uuid, String str) {
        if (!Rewards.a().getPlayerAPI().getPlayerClan(uuid).isPresent()) {
            return str;
        }
        if (!str.equals("player_rewards_amount")) {
            return null;
        }
        if (!Rewards.a().getPlayerAPI().hasPlayerData(uuid)) {
            return "0";
        }
        if (Rewards.a().getPlayerAPI().getPlayerData(uuid).isPresent()) {
            return String.valueOf(Rewards.getModuleCore().i().getPlayerRewards(uuid).size());
        }
        return null;
    }

    private static String __unused_1373() {
        return "player_rewards_amount";
    }

    private static String __unused_1374() {
        return "0";
    }
}
