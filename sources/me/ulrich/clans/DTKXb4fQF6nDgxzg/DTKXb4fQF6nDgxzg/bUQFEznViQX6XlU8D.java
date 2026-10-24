package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/bUQFEznViQX6XlU8D.class */
public class bUQFEznViQX6XlU8D implements ClansCommand {
    private static String u4IW5YavyRUPDhPVxbTDMd;
    private static volatile String tB4mQstfC20Md7MGo;
    private static final byte[] pAu0UDb82Aq1zgKc = {(byte) 168, (byte) 176, (byte) 242, (byte) 9, (byte) 233, (byte) 164, (byte) 251, (byte) 96, (byte) 46, (byte) 247, (byte) 193, (byte) 7, (byte) 175, (byte) 207, (byte) 167, (byte) 221};
    private static final byte[] J9no7MPMJ3OyRfc9yrCt = {(byte) 204, (byte) 47, (byte) 233, (byte) 7, (byte) 98, (byte) 161, (byte) 208, (byte) 222, (byte) 50, (byte) 245, (byte) 141, (byte) 165, (byte) 6, (byte) 25, (byte) 137, (byte) 138, (byte) 247, (byte) 121, (byte) 112, (byte) 156, (byte) 6, (byte) 88, (byte) 93, (byte) 186, (byte) 120, (byte) 4, (byte) 38, (byte) 141, (byte) 1, (byte) 180, (byte) 216, (byte) 71};
    private static final byte[] zeo1AgZp59vvvP = {(byte) 84, (byte) 25, (byte) 57, (byte) 22, (byte) 99, (byte) 234, (byte) 71, (byte) 212, (byte) 185, (byte) 188, (byte) 65, (byte) 54, (byte) 99, (byte) 89, (byte) 49, (byte) 101};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(WLw79MqRuKIQani())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(WFPDVDTFBrxoi3Ksc());
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strZJnaNCVQSgEShq = null;
        try {
            strZJnaNCVQSgEShq = clans.getColorManager().zJnaNCVQSgEShq(strArr[0]);
        } catch (Exception e) {
        }
        if (strZJnaNCVQSgEShq == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strZJnaNCVQSgEShq);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strZJnaNCVQSgEShq);
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                optionalJBUuLP0sWwaPyPOmogdX7l = optionalIZTqZaRK5UGoe0Z;
            }
        }
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
            return true;
        }
        if (clans.getClanManager().zJnaNCVQSgEShq(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId())) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String WLw79MqRuKIQani() {
        return "delete";
    }

    private static String WFPDVDTFBrxoi3Ksc() {
        return "delete";
    }
}
