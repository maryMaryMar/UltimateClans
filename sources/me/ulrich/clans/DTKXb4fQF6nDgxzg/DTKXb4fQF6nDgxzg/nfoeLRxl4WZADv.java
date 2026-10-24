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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/nfoeLRxl4WZADv.class */
public class nfoeLRxl4WZADv implements ClansCommand {
    private static volatile String ZG1Jk2ybADYPI2L43f;
    private static volatile String vJFzq9Kbu3BWnEM42NtR;
    private static final byte[] VdGASk7gUeKzIgJeTT4Gc = {(byte) 114, (byte) 135, (byte) 132, (byte) 151, (byte) 99, (byte) 83, (byte) 122, (byte) 188, (byte) 42, (byte) 224, (byte) 112, (byte) 15, (byte) 142, (byte) 183, (byte) 218, (byte) 61};
    private static final byte[] CyRD2XSV05Om0xTYkU9F = {(byte) 157, (byte) 22, (byte) 131, (byte) 189, (byte) 211, (byte) 204, (byte) 197, (byte) 103, (byte) 95, (byte) 249, (byte) 220, (byte) 60, (byte) 57, (byte) 62, (byte) 248, (byte) 227, (byte) 157, (byte) 6, (byte) 223, (byte) 44, (byte) 82, (byte) 33, (byte) 100, (byte) 116, (byte) 253, (byte) 58, (byte) 187, (byte) 190, (byte) 110, (byte) 101, (byte) 97, (byte) 130, (byte) 35, (byte) 255, (byte) 79, (byte) 160, (byte) 248, (byte) 26, (byte) 182, (byte) 146, (byte) 151, (byte) 8, (byte) 139, (byte) 16, (byte) 7, (byte) 197, (byte) 168, (byte) 47};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(qa63GQVgv4NjgwHZlBTg8U())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(aANbbujg9sTtb4huz9());
        if (strArr.length < 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        int points = 0;
        String strValueOf = null;
        StringBuilder sb = new StringBuilder();
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        try {
            points = Integer.valueOf(strArr[1]).intValue();
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
        if (points < 1) {
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
        if (optionalJBUuLP0sWwaPyPOmogdX7l.get().getQuest().getPoints() < 1) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_HAVE_POINTS));
            return true;
        }
        if (optionalJBUuLP0sWwaPyPOmogdX7l.get().getQuest().getPoints() < points) {
            points = optionalJBUuLP0sWwaPyPOmogdX7l.get().getQuest().getPoints();
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_HAS_ONLY_POINTS, Arrays.asList("%num%;" + String.valueOf(optionalJBUuLP0sWwaPyPOmogdX7l.get().getQuest().getPoints()))));
        }
        Optional<LevelupModuleAPI> levelup = Clans.getClanCore().getIntegrationAPI().getLevelup();
        if (levelup.isPresent() && levelup.get().removePoint(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), points, commandSender, sb)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%num%;" + String.valueOf(points), "%clan%;" + strValueOf));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String Gk3EpjolUuXk8o58kT(byte[] bArr) {
        return "";
    }

    private static String qa63GQVgv4NjgwHZlBTg8U() {
        return "removepoints";
    }

    private static String aANbbujg9sTtb4huz9() {
        return "removepoints";
    }
}
