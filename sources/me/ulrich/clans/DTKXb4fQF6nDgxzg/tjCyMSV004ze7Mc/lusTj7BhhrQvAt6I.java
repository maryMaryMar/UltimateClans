package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/lusTj7BhhrQvAt6I.class */
public class lusTj7BhhrQvAt6I implements ClansCommand {
    private static String ljKK3bPoe34lZHn0aCKEAL;
    private static volatile String qvzeXOnK5VandRjMS5s8;
    private static volatile String Lkqn45dtTRsiPlFZO;
    private static final byte[] lqLEZmeoQLcB4C7pC5l = {(byte) 172, (byte) 215, (byte) 31, (byte) 170, (byte) 115, (byte) 14, (byte) 196, (byte) 29, (byte) 239, (byte) 164, (byte) 159, (byte) 142, (byte) 52, (byte) 189, (byte) 60, (byte) 37};
    private static final byte[] G2x9xiJpfBF8j6 = {(byte) 71, (byte) 251, (byte) 121, (byte) 229, (byte) 100, (byte) 202, (byte) 85, (byte) 120, (byte) 195, (byte) 53, (byte) 9, (byte) 21, (byte) 77, (byte) 63, (byte) 73, (byte) 147};
    private static final byte[] MOnkFbokJvbGfiEuTZus = {(byte) 51, (byte) 162, (byte) 133, (byte) 222, (byte) 20, (byte) 58, (byte) 245, (byte) 178, (byte) 159, (byte) 203, (byte) 167, (byte) 67, (byte) 241, (byte) 61, (byte) 9, (byte) 156, (byte) 174, (byte) 252, (byte) 202, (byte) 35, (byte) 58, (byte) 240, (byte) 151, (byte) 46, (byte) 234, (byte) 149, (byte) 222, (byte) 109, (byte) 127, (byte) 228, (byte) 182, (byte) 155};
    private static final byte[] NRSKvuY7PBes5gQqgj = {(byte) 5, (byte) 187, (byte) 123, (byte) 210, (byte) 165, (byte) 15, (byte) 191, (byte) 115, (byte) 8, (byte) 51, (byte) 69, (byte) 36, (byte) 74, (byte) 46, (byte) 48, (byte) 53};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(lKu4yfoivTi0Na2asXN())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(Og7sEzLOfdQ7P0gbFNraso());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Player player = (Player) commandSender;
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = clans.getPlayerManager().p31abtwfBag2jhMH6K(player.getUniqueId());
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        String strTrim = strArr[0].trim();
        if (!strTrim.equalsIgnoreCase(NQJcT9Rd96mlAFcsLBSgx())) {
            if (clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player, strTrim)) {
                MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (optionalP31abtwfBag2jhMH6K.get().getNickname() == null || optionalP31abtwfBag2jhMH6K.get().getNickname().isEmpty()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_NICKNAME_DEFAULT));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return false;
        }
        if (clans.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), (String) null)) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String lKu4yfoivTi0Na2asXN() {
        return "nickname";
    }

    private static String Og7sEzLOfdQ7P0gbFNraso() {
        return "nickname";
    }

    private static String NQJcT9Rd96mlAFcsLBSgx() {
        return "-reset";
    }
}
