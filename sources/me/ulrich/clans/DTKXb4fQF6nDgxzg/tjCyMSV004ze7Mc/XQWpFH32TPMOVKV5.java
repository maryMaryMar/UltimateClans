package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

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
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/XQWpFH32TPMOVKV5.class */
public class XQWpFH32TPMOVKV5 implements ClansCommand {
    private static String EnDqYK978PpcZ5;
    private static volatile String e4EmgU2Yur56HtMC0IxCQ;
    private static String JlOHWTJluaY0wNg;
    private static String dsw3TWuJd8MNYEBC;
    private static final byte[] JGTehfnfU0QS980s89L6l = {(byte) 204, (byte) 26, (byte) 200, (byte) 163, (byte) 130, (byte) 104, (byte) 122, (byte) 222, (byte) 167, (byte) 60, (byte) 54, (byte) 94, (byte) 182, (byte) 165, (byte) 131, (byte) 131};
    private static final byte[] mjJolDf4EEKMJcRMjT = {(byte) 204, (byte) 26, (byte) 200, (byte) 163, (byte) 130, (byte) 104, (byte) 122, (byte) 222, (byte) 167, (byte) 60, (byte) 54, (byte) 94, (byte) 182, (byte) 165, (byte) 131, (byte) 131};
    private static final byte[] NxpgpTAsPbp4PfM = {(byte) 247, (byte) 255, (byte) 104, (byte) 75, (byte) 15, (byte) 18, (byte) 143, (byte) 171, (byte) 77, (byte) 113, (byte) 255, (byte) 243, (byte) 139, (byte) 35, (byte) 210, (byte) 89, (byte) 33, (byte) 9, (byte) 186, (byte) 111, (byte) 9, (byte) 64, (byte) 62, (byte) 134, (byte) 4, (byte) 117, (byte) 37, (byte) 77, (byte) 99, (byte) 30, (byte) 115, (byte) 10, (byte) 119, (byte) 222, (byte) 111, (byte) 48, (byte) 86, (byte) 175, (byte) 127, (byte) 58, (byte) 229, (byte) 208, (byte) 151, (byte) 82, (byte) 174, (byte) 56, (byte) 108, (byte) 52};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(jPM9jkOugDUt9U2OU8nbFR())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(sGg3n1skZff9Nfm());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length != 0) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(mn3m4R1HEQExrMv5k())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), fyMtsZf7SGSJfd1p9())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (clans.getClanManager().b4i2FbOkaKeg91LiAe6l()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HAS_GLOBALFF));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (clans.getClanManager().ZwrsrwOCXRUscW6Q(optionalCDW4Fj1iwdIXEOqWjiJSR.get())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%clan_ff%;" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("STATE_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().isFf()).toUpperCase()))));
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
        return true;
    }

    private static String xpbCvIOgemPwNHBaZ(byte[] bArr) {
        return "";
    }

    private static String jPM9jkOugDUt9U2OU8nbFR() {
        return "ff";
    }

    private static String sGg3n1skZff9Nfm() {
        return "ff";
    }

    private static String mn3m4R1HEQExrMv5k() {
        return "Config.player.ff.enabled";
    }

    private static String fyMtsZf7SGSJfd1p9() {
        return "FF";
    }
}
