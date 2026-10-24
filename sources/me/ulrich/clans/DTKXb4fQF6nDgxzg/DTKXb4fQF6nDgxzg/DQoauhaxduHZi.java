package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import com.google.common.base.Stopwatch;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/DQoauhaxduHZi.class */
public class DQoauhaxduHZi implements ClansCommand {
    private static volatile String Z8xrxlIrk8NjUucOiiKl;
    private static volatile String EaeGzbQh9A1iFNPSnEvVXF;
    private static volatile String i0VASWgAcCbAyVI4un;
    private static String HW5N1tNHfMpBEtNAg;
    private static volatile String gb1K5QyoBk9V1qAMT4wQPw;
    private static volatile String LzMnpQUPkjxOlPJXnzGymy;
    private static String kAJAWzHOYjDtKZlR;
    private static String DeEBnvkN6VaQBsLn7dhWM2;
    private static volatile String oAc85TWZU9FBkXDWISt;
    private static volatile String shZKBOlBmVjGZ1Uzr3;
    private static volatile String Jpu20gelrQuEaAi7Q;
    private static volatile String fesEdRhT5cloC5DnH;
    private static volatile String KtnOYB1qfTqSAY6AXe;
    private static volatile String PqqahhnZ1OFimMgf;
    private static String r9xDXI1fe14PXQR;
    private static String bfWeftePRig6I66GVfSU;
    private static String UI8XhlFJ5X1TZcyf7k;
    private static volatile String qmun128twlt3iPt2wOq6v;
    private static volatile String CqQ6sa4upZj6bjJT;
    private static String TwatJIDxXPJ4LWppspdS;
    private static String mXZ09vx4Kog4YqzO7PW6;
    private static volatile String eR1M0kzvQFd6juMq10S8i;
    private static String Fdoy8SGLpF285EU3d5nU;
    private static final byte[] QMXwf1SzuTfHxLcSzXkd = {(byte) 192, (byte) 223, (byte) 200, (byte) 11, (byte) 252, (byte) 12, (byte) 61, (byte) 172, (byte) 203, (byte) 69, (byte) 43, (byte) 197, (byte) 229, (byte) 39, (byte) 228, (byte) 250, (byte) 244, (byte) 91, (byte) 229, (byte) 64, (byte) 75, (byte) 222, (byte) 54, (byte) 87, (byte) 21, (byte) 82, (byte) 206, (byte) 5, (byte) 164, (byte) 231, (byte) 31, (byte) 171, (byte) 236, (byte) 20, (byte) 154, (byte) 57, (byte) 200, (byte) 64, (byte) 47, (byte) 147, (byte) 223, (byte) 60, (byte) 194, (byte) 75, (byte) 147, (byte) 39, (byte) 93, (byte) 43, (byte) 118, (byte) 70, (byte) 211, (byte) 89, (byte) 198, (byte) 96, (byte) 44, (byte) 146, (byte) 22, (byte) 85, (byte) 245, (byte) 196, (byte) 246, (byte) 0, (byte) 249, (byte) 2};
    private static final byte[] Tw9JLSYBPH9kOw0wb = {(byte) 211, (byte) 254, (byte) 156, (byte) 79, (byte) 79, (byte) 46, (byte) 149, (byte) 254, (byte) 117, (byte) 131, (byte) 99, (byte) 79, (byte) 171, (byte) 205, (byte) 125, (byte) 215};
    private static final byte[] vx5TXnKe5bozEnUEjH = {(byte) 144, (byte) 255, (byte) 204, (byte) 212, (byte) 61, (byte) 121, (byte) 155, (byte) 172, (byte) 90, (byte) 77, (byte) 25, (byte) 158, (byte) 115, (byte) 84, (byte) 154, (byte) 143};
    private static final byte[] kfKmBwr6Bcq31O8scQOmlC = {(byte) 18, (byte) 53, (byte) 95, (byte) 106, (byte) 89, (byte) 44, (byte) 112, (byte) 44, (byte) 92, (byte) 112, (byte) 187, (byte) 96, (byte) 155, (byte) 92, (byte) 29, (byte) 29};
    private static final byte[] zYK5iCTXuOEt2qA = {(byte) 220, (byte) 65, (byte) 140, (byte) 250, (byte) 55, (byte) 34, (byte) 42, (byte) 101, (byte) 29, (byte) 212, (byte) 253, (byte) 214, (byte) 154, (byte) 192, (byte) 206, (byte) 108};
    private static final byte[] mpd3d600TzlYB7FSicc = {(byte) 223, (byte) 1, (byte) 185, (byte) 171, (byte) 29, (byte) 135, (byte) 211, (byte) 126, (byte) 92, (byte) 255, (byte) 146, (byte) 51, (byte) 183, (byte) 213, (byte) 96, (byte) 53};
    private static final byte[] ijUtYQh4l4tCoikNeftVIl = {(byte) 106, (byte) 111, (byte) 243, (byte) 162, (byte) 120, (byte) 42, (byte) 37, (byte) 152, (byte) 158, (byte) 231, (byte) 146, (byte) 201, (byte) 121, (byte) 21, (byte) 252, (byte) 126};
    private static final byte[] TOaqQZpLfpOOo8 = {(byte) 161, (byte) 113, (byte) 135, (byte) 255, (byte) 254, (byte) 227, (byte) 106, (byte) 18, (byte) 12, (byte) 31, (byte) 67, (byte) 196, (byte) 39, (byte) 153, (byte) 107, (byte) 28};
    private static final byte[] PzU9ArUE0IuCdTV = {(byte) 82, (byte) 198, (byte) 105, (byte) 27, (byte) 209, (byte) 200, (byte) 41, (byte) 129, (byte) 116, (byte) 193, (byte) 158, (byte) 87, (byte) 194, (byte) 45, (byte) 24, (byte) 252};
    private static final byte[] dqiT6KosJBWVwCf = {(byte) 67, (byte) 163, (byte) 127, (byte) 181, (byte) 206, (byte) 101, (byte) 167, (byte) 98, (byte) 163, (byte) 204, (byte) 216, (byte) 2, (byte) 198, (byte) 201, (byte) 42, (byte) 108};
    private static final byte[] LWcbY6575whxr0Gm = {(byte) 174, (byte) 207, (byte) 98, (byte) 249, (byte) 109, (byte) 249, (byte) 71, (byte) 35, (byte) 103, (byte) 159, (byte) 69, (byte) 29, (byte) 77, (byte) 47, (byte) 77, (byte) 65};
    private static final byte[] s6WHvgEceCZR3dZK9 = {(byte) 21, (byte) 93, (byte) 155, (byte) 81, (byte) 54, (byte) 91, (byte) 186, (byte) 126, (byte) 240, (byte) 221, (byte) 139, (byte) 69, (byte) 8, (byte) 210, (byte) 144, (byte) 155};
    private static final byte[] jG4vYxPvSQvmNSn6DTTXAI = {(byte) 50, (byte) 162, (byte) 114, (byte) 126, (byte) 106, (byte) 84, (byte) 83, (byte) 115, (byte) 29, (byte) 13, (byte) 51, (byte) 95, (byte) 198, (byte) 178, (byte) 36, (byte) 167, (byte) 209, (byte) 110, (byte) 184, (byte) 82, (byte) 30, (byte) 114, (byte) 244, (byte) 183, (byte) 235, (byte) 64, (byte) 3, (byte) 189, (byte) 229, (byte) 10, (byte) 25, (byte) 158, (byte) 126, (byte) 41, (byte) 11, (byte) 72, (byte) 57, (byte) 20, (byte) 138, (byte) 234, (byte) 111, (byte) 76, (byte) 193, (byte) 81, (byte) 211, (byte) 39, (byte) 154, (byte) 53};
    private static final byte[] gW2h8HDCJccfdb = {(byte) 247, (byte) 136, (byte) 130, (byte) 188, (byte) 130, (byte) 105, (byte) 87, (byte) 76, (byte) 97, (byte) 136, (byte) 99, (byte) 211, (byte) 109, (byte) 85, (byte) 57, (byte) 102};
    private static final byte[] tz3FUUIdglOhpTq0jU1isP = {(byte) 136, (byte) 219, (byte) 98, (byte) 52, (byte) 251, (byte) 60, (byte) 91, (byte) 185, (byte) 226, (byte) 91, (byte) 179, (byte) 78, (byte) 18, (byte) 38, (byte) 73, (byte) 99, (byte) 209, (byte) 237, (byte) 66, (byte) 18, (byte) 134, (byte) 163, (byte) 129, (byte) 229, (byte) 20, (byte) 198, (byte) 192, (byte) 126, (byte) 192, (byte) 53, (byte) 98, (byte) 119};
    private static final byte[] axkFutcZxmAsFhW = {(byte) 77, (byte) 155, (byte) 115, (byte) 121, (byte) 228, (byte) 157, (byte) 50, (byte) 101, (byte) 119, (byte) 62, (byte) 247, (byte) 170, (byte) 116, (byte) 182, (byte) 193, (byte) 121};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(r7UrF7TGo8IyDAWg())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(QaVk42BFWEp2MY());
        if (strArr.length <= 1) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (commandSender instanceof Player) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_CONSOLE));
            return true;
        }
        if (Bukkit.getOnlinePlayers().size() != 0) {
            MessageUtils.sendText(commandSender, hQNf1APD6KBzaMm());
            return true;
        }
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        boolean zBooleanValue = false;
        boolean zBooleanValue2 = false;
        boolean zBooleanValue3 = false;
        boolean zBooleanValue4 = false;
        boolean zBooleanValue5 = false;
        boolean zBooleanValue6 = false;
        boolean zBooleanValue7 = false;
        int iIntValue = 0;
        for (String str2 : strArr) {
            if (str2.startsWith(MAJvg9dSwxqlrRKu5()) && str2.contains(P3s6hn1hwFhdvLx6())) {
                String[] strArrSplit = str2.split(rmWvpM3ZLIvaZdAP());
                if (strArrSplit.length == 2) {
                    String str3 = strArrSplit[0];
                    String str4 = strArrSplit[1];
                    if (str3 != null && str4 != null) {
                        if (str3.equalsIgnoreCase(HO2FU9blq2EZNKRB()) || str3.equalsIgnoreCase(vLXbTr0suVey3gyd3Q())) {
                            zBooleanValue = Boolean.valueOf(str4).booleanValue();
                        } else if (str3.equalsIgnoreCase(IPUhuubOEE7UWYP()) || str3.equalsIgnoreCase(eQVISgpy5qssV3i9M())) {
                            zBooleanValue2 = Boolean.valueOf(str4).booleanValue();
                        } else if (str3.equalsIgnoreCase(kxGHwBrSkIewK3yf()) || str3.equalsIgnoreCase(GM3OAe0mw7RHos6RsChjb())) {
                            zBooleanValue3 = Boolean.valueOf(str4).booleanValue();
                        } else if (str3.equalsIgnoreCase(kpJFFHoBDqzifEHiVne()) || str3.equalsIgnoreCase(nw2nPMgOKxIrO8mefY9())) {
                            zBooleanValue4 = Boolean.valueOf(str4).booleanValue();
                        } else if (str3.equalsIgnoreCase(fTkiyco7yY6iQp()) || str3.equalsIgnoreCase(bOUXElt60x4DzTUDZIxr())) {
                            zBooleanValue5 = Boolean.valueOf(str4).booleanValue();
                        } else if (str3.equalsIgnoreCase(T8rtGUjOcYx9PttGTx()) || str3.equalsIgnoreCase(XFDTwHtKh79itEZH5bHr())) {
                            zBooleanValue6 = Boolean.valueOf(str4).booleanValue();
                        } else if (str3.equalsIgnoreCase(tSTR8d2EVXMce5()) || str3.equalsIgnoreCase(pznnjV1BuAUirLNvo())) {
                            zBooleanValue7 = Boolean.valueOf(str4).booleanValue();
                        } else if (str3.equalsIgnoreCase(S0NPzbDEjGgh9ZQN7()) || str3.equalsIgnoreCase(CwmAeRzFQYHK96LYnRWlF())) {
                            iIntValue = Integer.valueOf(str4).intValue();
                        }
                    }
                }
            }
        }
        if (iIntValue == 0 || !(zBooleanValue || zBooleanValue2 || zBooleanValue3 || zBooleanValue4 || zBooleanValue5 || zBooleanValue6 || zBooleanValue7)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, Arrays.asList(S4rmggyVbLj0Qb8KLS7Z()));
            return true;
        }
        new me.ulrich.clans.tasks.UsEbiuprSHpNw3qjITfH(clans, stopwatchCreateStarted, iIntValue, zBooleanValue, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, zBooleanValue6, zBooleanValue7);
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
        return true;
    }

    private static String OtZ4fRzmZPrv43BMYmrL(byte[] bArr) {
        return "";
    }

    private static String r7UrF7TGo8IyDAWg() {
        return "emptyclans";
    }

    private static String QaVk42BFWEp2MY() {
        return "emptyclans";
    }

    private static String hQNf1APD6KBzaMm() {
        return "<red>The server needs to be empty for this!";
    }

    private static String MAJvg9dSwxqlrRKu5() {
        return "-";
    }

    private static String P3s6hn1hwFhdvLx6() {
        return ":";
    }

    private static String rmWvpM3ZLIvaZdAP() {
        return "\\:";
    }

    private static String HO2FU9blq2EZNKRB() {
        return "-bank";
    }

    private static String vLXbTr0suVey3gyd3Q() {
        return "-b";
    }

    private static String IPUhuubOEE7UWYP() {
        return "-kickall";
    }

    private static String eQVISgpy5qssV3i9M() {
        return "-ka";
    }

    private static String kxGHwBrSkIewK3yf() {
        return "-stats";
    }

    private static String GM3OAe0mw7RHos6RsChjb() {
        return "-s";
    }

    private static String kpJFFHoBDqzifEHiVne() {
        return "-homes";
    }

    private static String nw2nPMgOKxIrO8mefY9() {
        return "-ho";
    }

    private static String fTkiyco7yY6iQp() {
        return "-rival";
    }

    private static String bOUXElt60x4DzTUDZIxr() {
        return "-ri";
    }

    private static String T8rtGUjOcYx9PttGTx() {
        return "-ally";
    }

    private static String XFDTwHtKh79itEZH5bHr() {
        return "-al";
    }

    private static String tSTR8d2EVXMce5() {
        return "-points";
    }

    private static String pznnjV1BuAUirLNvo() {
        return "-pt";
    }

    private static String S0NPzbDEjGgh9ZQN7() {
        return "-sec";
    }

    private static String CwmAeRzFQYHK96LYnRWlF() {
        return "-s";
    }

    private static String S4rmggyVbLj0Qb8KLS7Z() {
        return "{keys};(bank, kickall, stats, homes, rival, ally, points, sec).";
    }
}
