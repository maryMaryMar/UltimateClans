package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/lO8DsfpVA7lKO.class */
public class lO8DsfpVA7lKO implements ClansCommand {
    private static volatile String RhMxaD3MjikfjZGggkx6WM;
    private static volatile String nNA2qyKdzCqjPfNuYA;
    private static final byte[] rp8wVha8qoqusYmO4F = {(byte) 189, (byte) 111, (byte) 212, (byte) 217, (byte) 58, (byte) 216, (byte) 145, (byte) 74, (byte) 146, (byte) 121, (byte) 180, (byte) 125, (byte) 230, (byte) 215, (byte) 93, (byte) 209};
    private static final byte[] iTYkBTDWTDL7Kx = {(byte) 189, (byte) 111, (byte) 212, (byte) 217, (byte) 58, (byte) 216, (byte) 145, (byte) 74, (byte) 146, (byte) 121, (byte) 180, (byte) 125, (byte) 230, (byte) 215, (byte) 93, (byte) 209};
    private static final byte[] dZouyOHzR4VqWbT8EJHC = {(byte) 113, (byte) 115, (byte) 28, (byte) 229, (byte) 178, (byte) 190, (byte) 37, (byte) 147, (byte) 17, (byte) 122, (byte) 153, (byte) 50, (byte) 220, (byte) 48, (byte) 37, (byte) 26, (byte) 140, (byte) 5, (byte) 255, (byte) 24, (byte) 91, (byte) 116, (byte) 118, (byte) 82, (byte) 98, (byte) 196, (byte) 203, (byte) 178, (byte) 128, (byte) 226, (byte) 121, (byte) 210};
    private static final byte[] i2p7Lha4JH01oapFxGJ = {(byte) 94, (byte) 175, (byte) 128, (byte) 188, (byte) 186, (byte) 38, (byte) 156, (byte) 158, (byte) 130, (byte) 210, (byte) 173, (byte) 50, (byte) 116, (byte) 6, (byte) 235, (byte) 74};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(nhDaWHxWEkZ2YTEF2JS())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(Aut7DIrPgPPjkb3ZP7L());
        if (strArr.length != 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        int iIntValue = 0;
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        try {
            iIntValue = Integer.valueOf(strArr[1]).intValue();
        } catch (Exception e2) {
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
        if (clans.getClanManager().iZTqZaRK5UGoe0Z(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), iIntValue, commandSender)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%num%;" + String.valueOf(iIntValue), "%clan%;" + strValueOf));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String nhDaWHxWEkZ2YTEF2JS() {
        return "setslot";
    }

    private static String Aut7DIrPgPPjkb3ZP7L() {
        return "setslot";
    }
}
