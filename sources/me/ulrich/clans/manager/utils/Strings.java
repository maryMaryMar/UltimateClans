package me.ulrich.clans.manager.utils;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.qjkRaOgynIj1.UsEbiuprSHpNw3qjITfH;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Strings.class */
public class Strings {
    private static final byte[] x1M3Ot4owzh8XsBi = {(byte) 92, (byte) 145, (byte) 80, (byte) 215, (byte) 202, (byte) 140, (byte) 146, (byte) 181, (byte) 173, (byte) 90, (byte) 252, (byte) 253, (byte) 1, (byte) 58, (byte) 232, (byte) 193, (byte) 50, (byte) 16, (byte) 23, (byte) 72, (byte) 254, (byte) 12, (byte) 182, (byte) 71, (byte) 153, (byte) 128, (byte) 77, (byte) 220, (byte) 130, (byte) 27, (byte) 218, (byte) 207};
    private static final byte[] GCyympH9l6PoKMjaw = {(byte) 167, (byte) 242, (byte) 7, (byte) 54, (byte) 141, (byte) 136, (byte) 210, (byte) 13, (byte) 166, (byte) 242, (byte) 128, (byte) 154, (byte) 197, (byte) 76, (byte) 7, (byte) 213};
    private static volatile String eku3wcBaDeBKZihLkYazpb;

    public String genKey(int i) {
        char[] charArray = Mvc3g0ZHyDvA1LpenKHYj().toCharArray();
        SecureRandom secureRandom = new SecureRandom();
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = charArray[secureRandom.nextInt(charArray.length)];
        }
        return new String(cArr);
    }

    public String Ucfirst(String str) {
        try {
            return str.toString().substring(0, 1).toUpperCase() + str.toString().substring(1).toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public String UcAll(String str) {
        try {
            return str.toString().toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public String UnUcAll(String str) {
        try {
            return str.toString().toLowerCase();
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public Boolean percentChance(double d) {
        return Boolean.valueOf(Math.random() <= d);
    }

    public void center(Player player, String str) {
        if (str == null || str.equals("")) {
            player.sendMessage("");
        }
        String strTranslateAlternateColorCodes = ChatColor.translateAlternateColorCodes('&', str);
        int iZwrsrwOCXRUscW6Q = 0;
        boolean z = false;
        boolean z2 = false;
        char[] charArray = strTranslateAlternateColorCodes.toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            char c = charArray[i];
            if (c == 167) {
                z = true;
            } else if (z) {
                z = false;
                z2 = c == 'l' || c == 'L';
            } else {
                UsEbiuprSHpNw3qjITfH usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY = UsEbiuprSHpNw3qjITfH.v8qP8fE86HMhvNuYPFjqY(c);
                iZwrsrwOCXRUscW6Q = iZwrsrwOCXRUscW6Q + (z2 ? usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q() : usEbiuprSHpNw3qjITfHV8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l()) + 1;
            }
        }
        int i2 = 154 - (iZwrsrwOCXRUscW6Q / 2);
        int iJBUuLP0sWwaPyPOmogdX7l = UsEbiuprSHpNw3qjITfH.FS8nw7CdxwHVFsO.jBUuLP0sWwaPyPOmogdX7l() + 1;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3 += iJBUuLP0sWwaPyPOmogdX7l) {
            sb.append(" ");
        }
        player.sendMessage(sb.toString() + strTranslateAlternateColorCodes);
    }

    public Color parseColor(String str) {
        if (str == null) {
            return Color.BLACK;
        }
        try {
            return (Color) Color.class.getField(str).get(null);
        } catch (Exception e) {
            return Color.BLACK;
        }
    }

    private static String s5YR1FgXejYSV8PnWX6(byte[] bArr) {
        return "";
    }

    private static String Mvc3g0ZHyDvA1LpenKHYj() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    }
}
