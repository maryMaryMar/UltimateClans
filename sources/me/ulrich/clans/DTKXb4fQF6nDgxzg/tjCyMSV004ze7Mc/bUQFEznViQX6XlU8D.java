package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/bUQFEznViQX6XlU8D.class */
public class bUQFEznViQX6XlU8D implements ClansCommand {
    private static final byte[] g3JCeRggjKmIxl = {(byte) 238, (byte) 199, (byte) 200, (byte) 248, (byte) 161, (byte) 104, (byte) 208, (byte) 207, (byte) 125, (byte) 36, (byte) 188, (byte) 15, (byte) 81, (byte) 211, (byte) 1, (byte) 163, (byte) 242, (byte) 17, (byte) 99, (byte) 70, (byte) 44, (byte) 52, (byte) 5, (byte) 2, (byte) 97, (byte) 154, (byte) 7, (byte) 195, (byte) 191, (byte) 222, (byte) 242, (byte) 74};
    private static final byte[] Ft2STn7yQ35KVeNDBpwbeQ = {(byte) 30, (byte) 103, (byte) 235, (byte) 32, (byte) 64, (byte) 38, (byte) 121, (byte) 140, (byte) 228, (byte) 90, (byte) 127, (byte) 75, (byte) 216, (byte) 2, (byte) 198, (byte) 40};
    private static volatile String KyoOtAlmDT0m0Jb6;
    private static volatile String ean6ebbFMjZn4W;

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(o7BSWIlgsjCsMRQdmJ())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(DFGhu3vUV5kk5y());
        Player player = (Player) commandSender;
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clans.getColorManager().zJnaNCVQSgEShq(strValueOf));
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_DOES_NOT_EXISTS));
            return true;
        }
        Optional<InviteData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerInviteManager().iZTqZaRK5UGoe0Z(player.getUniqueId(), optionalJBUuLP0sWwaPyPOmogdX7l.get().getId());
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_NO_INVITATIONS));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (!clans.getPlayerInviteManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId(), optionalIZTqZaRK5UGoe0Z.get().getId())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        clans.getChatManager().jBUuLP0sWwaPyPOmogdX7l(player);
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        return true;
    }

    private static String o7BSWIlgsjCsMRQdmJ() {
        return "deny";
    }

    private static String DFGhu3vUV5kk5y() {
        return "deny";
    }
}
