package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/UUq89fbpNlals.class */
public class UUq89fbpNlals implements ClansCommand {
    private static String Tyf7Dtcx35oB2mfw;
    private static String dxfyDmfggr49SJH1;
    private static String rNY0NCT99O1G1p4pZ;
    private static final byte[] ipfMHmQJzUt2fanp = {(byte) 240, (byte) 169, (byte) 62, (byte) 38, (byte) 43, (byte) 86, (byte) 51, (byte) 218, (byte) 176, (byte) 30, (byte) 11, (byte) 180, (byte) 99, (byte) 6, (byte) 119, (byte) 91};
    private static final byte[] RmXdY2Em1j9rNzSs = {(byte) 238, (byte) 210, (byte) 126, (byte) 223, (byte) 160, (byte) 190, (byte) 94, (byte) 155, (byte) 246, (byte) 154, (byte) 218, (byte) 173, (byte) 197, (byte) 139, (byte) 128, (byte) 39, (byte) 155, (byte) 46, (byte) 167, (byte) 175, (byte) 5, (byte) 61, (byte) 215, (byte) 211, (byte) 0, (byte) 122, (byte) 231, (byte) 227, (byte) 106, (byte) 106, (byte) 96, (byte) 148};
    private static final byte[] stL48kFxd90AcKr4 = {(byte) 227, (byte) 27, (byte) 91, (byte) 242, (byte) 169, (byte) 157, (byte) 210, (byte) 44, (byte) 121, (byte) 104, (byte) 249, (byte) 11, (byte) 218, (byte) 217, (byte) 17, (byte) 165};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(GYzhFVxHz8XJqDs())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(qBUt0B2lflqlPrZ());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[0]);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_OFFLINE));
            return true;
        }
        if (!clans.getPlayerManager().zJnaNCVQSgEShq(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_ISNOT_BANNED));
            return true;
        }
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), zsDQpbBj0kWJDjPc1XA())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (!clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        if (!clans.isUseGUI()) {
            return true;
        }
        clans.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openBannedMembers(player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_SUCCESS_UNBAN_GUI));
        return true;
    }

    private static String GYzhFVxHz8XJqDs() {
        return "unban";
    }

    private static String qBUt0B2lflqlPrZ() {
        return "unban";
    }

    private static String zsDQpbBj0kWJDjPc1XA() {
        return "UNBAN";
    }
}
