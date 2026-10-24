package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL implements ClansCommand {
    private static String BMm0jVeF2ypsLVq3o;
    private static String OxEPvOTmxwXpSYN;
    private static volatile String vOjDRY2xgd0rvBRc;
    private static volatile String Jij9fcrj0iwxOcT;
    private static volatile String dgxh3ErNY8mPBzC8;
    private static String qRmxuWbnOOcC2x;
    private static volatile String Dga0G6oOUUALbBTo7owR;
    private static volatile String T571gkQTbuqlsFl2Xvz;
    private static final byte[] iiesapCQWM2WYfOy = {(byte) 21, (byte) 215, (byte) 32, (byte) 74, (byte) 50, (byte) 30, (byte) 55, (byte) 245, (byte) 232, (byte) 69, (byte) 156, (byte) 78, (byte) 103, (byte) 142, (byte) 61, (byte) 6, (byte) 114, (byte) 9, (byte) 203, (byte) 88, (byte) 154, (byte) 35, (byte) 238, (byte) 200, (byte) 237, (byte) 221, (byte) 62, (byte) 8, (byte) 151, (byte) 23, (byte) 16, (byte) 120};
    private static final byte[] IQV28JKeOMzyMzMBd = {(byte) 21, (byte) 215, (byte) 32, (byte) 74, (byte) 50, (byte) 30, (byte) 55, (byte) 245, (byte) 232, (byte) 69, (byte) 156, (byte) 78, (byte) 103, (byte) 142, (byte) 61, (byte) 6, (byte) 114, (byte) 9, (byte) 203, (byte) 88, (byte) 154, (byte) 35, (byte) 238, (byte) 200, (byte) 237, (byte) 221, (byte) 62, (byte) 8, (byte) 151, (byte) 23, (byte) 16, (byte) 120};
    private static final byte[] JDKmLlOrpLazyI = {(byte) 159, (byte) 238, (byte) 116, (byte) 62, (byte) 176, (byte) 192, (byte) 88, (byte) 163, (byte) 181, (byte) 186, (byte) 186, (byte) 122, (byte) 93, (byte) 51, (byte) 29, (byte) 228, (byte) 185, (byte) 231, (byte) 19, (byte) 124, (byte) 255, (byte) 206, (byte) 132, (byte) 44, (byte) 93, (byte) 61, (byte) 175, (byte) 146, (byte) 214, (byte) 137, (byte) 120, (byte) 175};
    private static final byte[] jhsUzOrq8yzgPIoqsT9 = {(byte) 69, (byte) 20, (byte) 156, (byte) 22, (byte) 172, (byte) 29, (byte) 27, (byte) 172, (byte) 187, (byte) 23, (byte) 220, (byte) 153, (byte) 100, (byte) 71, (byte) 74, (byte) 57};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(bIpbT8j12ZX2Q2TwWXYa())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(pjIGuJWxmt13fYFhQ0());
        if (!(commandSender instanceof Player)) {
        }
        if (strArr.length != 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strValueOf = null;
        String strValueOf2 = null;
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        try {
            strValueOf2 = String.valueOf(strArr[1]);
        } catch (Exception e2) {
        }
        if (strValueOf == null || strValueOf2 == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strValueOf);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strValueOf);
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                optionalJBUuLP0sWwaPyPOmogdX7l = optionalIZTqZaRK5UGoe0Z;
            }
        }
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
            return true;
        }
        String tag = optionalJBUuLP0sWwaPyPOmogdX7l.get().getTag();
        if (!clans.getColorManager().jBUuLP0sWwaPyPOmogdX7l(strValueOf2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.ERROR_CHARACTER));
            return true;
        }
        String strZJnaNCVQSgEShq = clans.getColorManager().zJnaNCVQSgEShq(strValueOf2);
        if (clans.getClanManager().ZwrsrwOCXRUscW6Q(strZJnaNCVQSgEShq)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_TAG_IN_USE));
            return false;
        }
        if (strZJnaNCVQSgEShq.length() > clans.getFiles().p31abtwfBag2jhMH6K().getInt(OfiXQSEUQ40IH4Um()) || strZJnaNCVQSgEShq.length() < clans.getFiles().p31abtwfBag2jhMH6K().getInt(hl4KGwJtkMD5QK())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.ERROR_LENGTH).replace(YGDO8tY1adNE1a(), String.valueOf(clans.getFiles().p31abtwfBag2jhMH6K().getInt(fA06jtXR6Lc0dq8JOUNFZC()))).replace(ClGKaiavjsO6S5(), String.valueOf(clans.getFiles().p31abtwfBag2jhMH6K().getInt(vUmbFgKwvc2B5p6XK()))));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).lGGwXL678c4Kv7skJb5NiE(strZJnaNCVQSgEShq)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.ERROR_CHARACTER));
            return true;
        }
        if (optionalJBUuLP0sWwaPyPOmogdX7l.get().getTag().equalsIgnoreCase(strValueOf2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_TAG_EQUALS));
            return true;
        }
        if (clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(optionalJBUuLP0sWwaPyPOmogdX7l.get(), strValueOf2)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%clan%;" + tag, "%newtag%;" + strValueOf2));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String ypjqffnNLbw5W6T3ivyVZ(byte[] bArr) {
        return "";
    }

    private static String bIpbT8j12ZX2Q2TwWXYa() {
        return "changetag";
    }

    private static String pjIGuJWxmt13fYFhQ0() {
        return "changetag";
    }

    private static String OfiXQSEUQ40IH4Um() {
        return "Clan.tag.max_chars";
    }

    private static String hl4KGwJtkMD5QK() {
        return "Clan.tag.min_chars";
    }

    private static String YGDO8tY1adNE1a() {
        return "%min%";
    }

    private static String fA06jtXR6Lc0dq8JOUNFZC() {
        return "Clan.tag.min_chars";
    }

    private static String ClGKaiavjsO6S5() {
        return "%max%";
    }

    private static String vUmbFgKwvc2B5p6XK() {
        return "Clan.tag.max_chars";
    }
}
