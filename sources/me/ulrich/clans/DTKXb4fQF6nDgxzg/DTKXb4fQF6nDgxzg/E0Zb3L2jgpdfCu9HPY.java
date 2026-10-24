package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.Arrays;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/E0Zb3L2jgpdfCu9HPY.class */
public class E0Zb3L2jgpdfCu9HPY implements ClansCommand {
    private static final byte[] Lw8kmZQXqRzvZ335y3Odh = {(byte) 155, (byte) 146, (byte) 63, (byte) 147, (byte) 2, (byte) 140, (byte) 222, (byte) 2, (byte) 115, (byte) 149, (byte) 218, (byte) 32, (byte) 254, (byte) 74, (byte) 69, (byte) 187, (byte) 68, (byte) 219, (byte) 13, (byte) 210, (byte) 198, (byte) 247, (byte) 196, (byte) 50, (byte) 127, (byte) 207, (byte) 33, (byte) 161, (byte) 135, (byte) 97, (byte) 24, (byte) 249};
    private static final byte[] FkjskOIv2vviZS = {(byte) 183, (byte) 128, (byte) 226, (byte) 50, (byte) 19, (byte) 183, (byte) 181, (byte) 92, (byte) 250, (byte) 64, (byte) 63, (byte) 218, (byte) 13, (byte) 227, (byte) 201, (byte) 124};
    private static String nasIvAAQZguKUhWivk;
    private static volatile String SssoOMkX6ZRUqJy77iKg;

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(vlwHyqx9Ow1tUy8sSDES())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(ZT45QedzQ97954());
        if (strArr.length != 0) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(commandSender)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%globalff%;" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("STATE_" + String.valueOf(clans.getClanManager().b4i2FbOkaKeg91LiAe6l()).toUpperCase()))));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String vlwHyqx9Ow1tUy8sSDES() {
        return "globalff";
    }

    private static String ZT45QedzQ97954() {
        return "globalff";
    }
}
