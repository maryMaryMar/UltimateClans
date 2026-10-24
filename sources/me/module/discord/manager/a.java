package me.module.discord.manager;

import java.util.Optional;
import java.util.UUID;
import me.module.discord.Discord;
import me.module.discord.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/a.class */
public class a {
    private static byte[] __aes_key_d55YOsBG = {(byte) 213, (byte) 21, (byte) 20, (byte) 74, (byte) 25, (byte) 112, (byte) 141, (byte) 214, (byte) 50, (byte) 204, (byte) 205, (byte) 14, (byte) 37, (byte) 159, (byte) 131, (byte) 133, (byte) 98, (byte) 158, (byte) 0, (byte) 195, (byte) 179, (byte) 249, (byte) 96, (byte) 96, (byte) 17, (byte) 24, (byte) 58, (byte) 176, (byte) 102, (byte) 151, (byte) 120, (byte) 78};
    private static byte[] __aes_iv_jRmTYtsl = {(byte) 170, (byte) 138, (byte) 199, (byte) 67, (byte) 101, (byte) 91, (byte) 78, (byte) 251, (byte) 137, (byte) 106, (byte) 41, (byte) 125, (byte) 153, (byte) 234, (byte) 162, (byte) 83};
    private static String __s_cache_ozjWXrKg_0;
    private static String __s_cache_BCw06Tfe_1;
    private static String __s_cache_7gHZ11JG_2;
    private static String __s_cache_th6rU9kr_3;

    public String a(Player player, String str) {
        return a(player.getUniqueId(), str);
    }

    public String a(UUID uuid, String str) {
        Optional<ClanData> playerClan = Discord.b().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return str;
        }
        if (str.equals("is_connected")) {
            return playerClan.isPresent() ? String.valueOf(DiscordPublicManager.isConnectedClan(playerClan.get().getId())) : "0";
        }
        if (!str.equals("is_connected_formated")) {
            return null;
        }
        if (playerClan.isPresent()) {
            return Discord.getModuleCore().d().b(Optional.of(uuid)).getString(Lang.valueOf("TRANSLACTION_" + String.valueOf(DiscordPublicManager.isConnectedClan(playerClan.get().getId())).toUpperCase()));
        }
        return "0";
    }

    private static String __unused_1526() {
        return "is_connected";
    }

    private static String __unused_1527() {
        return "0";
    }

    private static String __unused_1528() {
        return "is_connected_formated";
    }

    private static String __unused_1529() {
        return "0";
    }
}
