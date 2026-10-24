package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/ua6rk884OvNUdJs7.class */
public class ua6rk884OvNUdJs7 implements ClansCommand {
    private static String igRMhwJyP0BB3e;
    private static volatile String FSWMZDBhVaAw0qdrG3;
    private static final byte[] K2J5LdbNQBssabS7 = {(byte) 189, (byte) 164, (byte) 238, (byte) 59, (byte) 70, (byte) 177, (byte) 102, (byte) 242, (byte) 4, (byte) 98, (byte) 49, (byte) 233, (byte) 122, (byte) 66, (byte) 30, (byte) 193};
    private static final byte[] V7iWOOSuseXvEsnuJm5lX = {(byte) 209, (byte) 234, (byte) 19, (byte) 198, (byte) 126, (byte) 70, (byte) 108, (byte) 15, (byte) 232, (byte) 161, (byte) 206, (byte) 244, (byte) 68, (byte) 250, (byte) 4, (byte) 112, (byte) 219, (byte) 43, (byte) 237, (byte) 17, (byte) 215, (byte) 146, (byte) 32, (byte) 239, (byte) 66, (byte) 38, (byte) 171, (byte) 18, (byte) 107, (byte) 8, (byte) 152, (byte) 242, (byte) 205, (byte) 250, (byte) 83, (byte) 97, (byte) 19, (byte) 162, (byte) 228, (byte) 51, (byte) 94, (byte) 32, (byte) 76, (byte) 244, (byte) 133, (byte) 214, (byte) 69, (byte) 224};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(v0bxBl40TzL4Yi())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(Hun6iIvjvpN1CrjJwI8());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length == 0 && clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            if (me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.CLANMODTAG, null, false, true, 0)) {
                return true;
            }
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
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
        if (clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(player, strValueOf.trim())) {
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String tQnsKHmSVECGXspLn(byte[] bArr) {
        return "";
    }

    private static String v0bxBl40TzL4Yi() {
        return "modtag";
    }

    private static String Hun6iIvjvpN1CrjJwI8() {
        return "modtag";
    }
}
