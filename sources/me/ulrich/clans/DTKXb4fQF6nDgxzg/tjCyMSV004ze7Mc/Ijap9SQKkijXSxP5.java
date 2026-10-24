package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
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
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 implements ClansCommand {
    private static volatile String Hh2GYkXwPS7Oliw7E5BCwY;
    private static volatile String fFpD1sVRYx51ps8;
    private static volatile String KjtHoes26r5aJSYq4IzC;
    private static final byte[] MtpFqDCZIZ9yfmejQ0 = {(byte) 199, (byte) 92, (byte) 57, (byte) 110, (byte) 205, (byte) 155, (byte) 190, (byte) 5, (byte) 104, (byte) 168, (byte) 118, (byte) 108, (byte) 246, (byte) 188, (byte) 200, (byte) 58};
    private static final byte[] P549t88oclqbeEl0F5 = {(byte) 130, (byte) 155, (byte) 158, (byte) 115, (byte) 62, (byte) 122, (byte) 81, (byte) 233, (byte) 73, (byte) 153, (byte) 182, (byte) 191, (byte) 28, (byte) 86, (byte) 89, (byte) 173, (byte) 125, (byte) 219, (byte) 211, (byte) 127, (byte) 202, (byte) 222, (byte) 129, (byte) 182, (byte) 47, (byte) 52, (byte) 219, (byte) 2, (byte) 74, (byte) 131, (byte) 128, (byte) 99};
    private static final byte[] drvK5ysELKVAl1dpWdNG = {(byte) 212, (byte) 233, (byte) 15, (byte) 153, (byte) 76, (byte) 239, (byte) 18, (byte) 143, (byte) 216, (byte) 81, (byte) 161, (byte) 206, (byte) 109, (byte) 244, (byte) 20, (byte) 198};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(ZzpAuNjsQYRiPs())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(pyP5eJ0ivnSafchi());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), CKV4nJ77YFECZ0ZzVV0())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[0]);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_OFFLINE));
            return true;
        }
        if (clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (clans.getPlayerManager().zJnaNCVQSgEShq(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_ISALREADY_BANNED));
            return true;
        }
        if (clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId()) && clans.getPlayerManager().vVo2VUvxrriklPdRxI(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_CLAN_LEADER));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (!clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId(), player.getUniqueId())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        if (!clans.isUseGUI()) {
            return true;
        }
        clans.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openBannedMembers(player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_SUCCESS_BAN_GUI));
        return true;
    }

    private static String dCKR0xFnEguF3SAp7(byte[] bArr) {
        return "";
    }

    private static String ZzpAuNjsQYRiPs() {
        return "ban";
    }

    private static String pyP5eJ0ivnSafchi() {
        return "ban";
    }

    private static String CKV4nJ77YFECZ0ZzVV0() {
        return "BAN";
    }
}
