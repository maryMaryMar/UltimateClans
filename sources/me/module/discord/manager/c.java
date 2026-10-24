package me.module.discord.manager;

import java.net.URI;
import java.net.URISyntaxException;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/manager/c.class */
public class c {
    private static byte[] __aes_key_8dgVbORH = {(byte) 79, (byte) 69, (byte) 150, (byte) 147, (byte) 139, (byte) 131, (byte) 117, (byte) 250, (byte) 25, (byte) 143, (byte) 15, (byte) 245, (byte) 57, (byte) 221, (byte) 57, (byte) 180, (byte) 213, (byte) 154, (byte) 156, (byte) 129, (byte) 125, (byte) 112, (byte) 223, (byte) 14, (byte) 147, (byte) 216, (byte) 70, (byte) 173, (byte) 95, (byte) 208, (byte) 85, (byte) 165};
    private static byte[] __aes_iv_MjxNEJNK = {(byte) 17, (byte) 198, (byte) 42, (byte) 195, (byte) 62, (byte) 219, (byte) 192, (byte) 205, (byte) 140, (byte) 236, (byte) 196, (byte) 158, (byte) 98, (byte) 246, (byte) 10, (byte) 34};
    private static String __s_cache_6IOkG9tc_0;

    public static URI a() {
        try {
            return new URI("ws://" + "bot.tribecraft.com.br".trim() + ":8887");
        } catch (URISyntaxException e) {
            return null;
        }
    }

    private static String __unused_1510() {
        return "bot.tribecraft.com.br";
    }
}
