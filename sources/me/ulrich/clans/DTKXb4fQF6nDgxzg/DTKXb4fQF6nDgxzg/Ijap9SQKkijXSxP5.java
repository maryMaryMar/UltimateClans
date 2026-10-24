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
import me.ulrich.clans.interfaces.LevelupModuleAPI;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 implements ClansCommand {
    private static volatile String zg1tiYIxdET3NtBx;
    private static String IPYj4GQAnDFIUpjaX;
    private static final byte[] RkXha1bl943gx57O = {(byte) 215, (byte) 91, (byte) 40, (byte) 58, (byte) 234, (byte) 242, (byte) 253, (byte) 194, (byte) 8, (byte) 41, (byte) 63, (byte) 67, (byte) 200, (byte) 48, (byte) 226, (byte) 233};
    private static final byte[] lmsCI0JeZwDJTASqM = {(byte) 215, (byte) 91, (byte) 40, (byte) 58, (byte) 234, (byte) 242, (byte) 253, (byte) 194, (byte) 8, (byte) 41, (byte) 63, (byte) 67, (byte) 200, (byte) 48, (byte) 226, (byte) 233};
    private static final byte[] udRkLbgCk1cEa88mUlTP = {(byte) 89, (byte) 101, (byte) 209, (byte) 32, (byte) 218, (byte) 74, (byte) 67, (byte) 104, (byte) 20, (byte) 179, (byte) 25, (byte) 248, (byte) 0, (byte) 190, (byte) 33, (byte) 105, (byte) 71, (byte) 125, (byte) 243, (byte) 146, (byte) 129, (byte) 55, (byte) 213, (byte) 216, (byte) 215, (byte) 40, (byte) 83, (byte) 237, (byte) 141, (byte) 218, (byte) 6, (byte) 30, (byte) 145, (byte) 161, (byte) 75, (byte) 19, (byte) 100, (byte) 220, (byte) 205, (byte) 54, (byte) 49, (byte) 131, (byte) 111, (byte) 18, (byte) 171, (byte) 192, (byte) 248, (byte) 218};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(sXyQbuyYbYSuPHWadd7())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(opyw3cJS60WzBw());
        if (strArr.length < 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        int iIntValue = 0;
        String strValueOf = null;
        StringBuilder sb = new StringBuilder();
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        try {
            iIntValue = Integer.valueOf(strArr[1]).intValue();
        } catch (Exception e2) {
        }
        for (int i = 2; i < strArr.length; i++) {
            try {
                sb.append(strArr[i]).append(" ");
            } catch (Exception e3) {
            }
        }
        if (strValueOf == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (iIntValue < 1) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.VALUE_GREATER_THAN_ZERO));
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
        Optional<LevelupModuleAPI> levelup = Clans.getClanCore().getIntegrationAPI().getLevelup();
        if (levelup.isPresent() && levelup.get().addPoint(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), iIntValue, commandSender, sb)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%num%;" + String.valueOf(iIntValue), "%clan%;" + strValueOf));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String yyhHIQoCRZauQS(byte[] bArr) {
        return "";
    }

    private static String sXyQbuyYbYSuPHWadd7() {
        return "addpoints";
    }

    private static String opyw3cJS60WzBw() {
        return "addpoints";
    }
}
