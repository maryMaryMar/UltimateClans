package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.EnumMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/RuVgd0Dnv0ddhdcWL.class */
public class RuVgd0Dnv0ddhdcWL implements ClansCommand {
    private static volatile String Yh17wfHyBCaWna6I;
    private static String xzUhKrG3utqhnJf;
    private static final byte[] GxYuxbNldlorSvtz24 = {(byte) 179, (byte) 117, (byte) 3, (byte) 76, (byte) 167, (byte) 198, (byte) 118, (byte) 163, (byte) 0, (byte) 143, (byte) 25, (byte) 42, (byte) 46, (byte) 208, (byte) 225, (byte) 234};
    private static final byte[] GDvJeAZQlJ5I8TF = {(byte) 113, (byte) 88, (byte) 143, (byte) 223, (byte) 123, (byte) 228, (byte) 35, (byte) 137, (byte) 135, (byte) 79, (byte) 245, (byte) 8, (byte) 124, (byte) 58, (byte) 72, (byte) 224, (byte) 128, (byte) 114, (byte) 204, (byte) 229, (byte) 2, (byte) 43, (byte) 204, (byte) 78, (byte) 110, (byte) 112, (byte) 44, (byte) 235, (byte) 202, (byte) 60, (byte) 151, (byte) 100};
    private static final byte[] SGemnD08Rr6gGxlZ = {(byte) 141, (byte) 92, (byte) 254, (byte) 99, (byte) 189, (byte) 106, (byte) 5, (byte) 69, (byte) 36, (byte) 68, (byte) 238, (byte) 160, (byte) 149, (byte) 165, (byte) 58, (byte) 115};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(f2g00wV178NCMg3())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(cXxPU3BQXWFIYGsRsz());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length == 0 && !clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            if (me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.CLANCREATE, null, true, true, 0)) {
                return true;
            }
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_HAVE_CLAN));
            return true;
        }
        String strValueOf = "";
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        if (strValueOf == null) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (clans.getClanManager().ZwrsrwOCXRUscW6Q(player, strValueOf)) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String f2g00wV178NCMg3() {
        return "create";
    }

    private static String cXxPU3BQXWFIYGsRsz() {
        return "create";
    }
}
