package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 implements ClansCommand {
    private static String z3YXIx7593Rix1I;
    private static volatile String Nv0742Nf1VOau8QCyKEXLu;
    private static final byte[] jg65wLfyNnHgqDwoG = {(byte) 173, (byte) 171, (byte) 73, (byte) 170, (byte) 175, (byte) 250, (byte) 93, (byte) 179, (byte) 39, (byte) 138, (byte) 203, (byte) 170, (byte) 237, (byte) 226, (byte) 45, (byte) 208};
    private static final byte[] uduU3HJj9JHKbYkkm4Gt78 = {(byte) 108, (byte) 195, (byte) 115, (byte) 227, (byte) 125, (byte) 198, (byte) 31, (byte) 157, (byte) 32, (byte) 255, (byte) 242, (byte) 35, (byte) 239, (byte) 231, (byte) 191, (byte) 165, (byte) 77, (byte) 223, (byte) 17, (byte) 249, (byte) 129, (byte) 88, (byte) 13, (byte) 171, (byte) 208, (byte) 187, (byte) 128, (byte) 172, (byte) 115, (byte) 232, (byte) 167, (byte) 94, (byte) 30, (byte) 18, (byte) 9, (byte) 94, (byte) 214, (byte) 232, (byte) 7, (byte) 216, (byte) 30, (byte) 249, (byte) 154, (byte) 43, (byte) 203, (byte) 181, (byte) 254, (byte) 218};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(USu0AhhxsMpLRMZsq())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(XdchjKIPtetFhBdiYv7D());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        if (strArr.length != 0) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        boolean zV8qP8fE86HMhvNuYPFjqY = clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(commandSender);
        ClanEnum.MsgUsage msgUsage = ClanEnum.MsgUsage.success;
        String[] strArr2 = new String[1];
        strArr2[0] = "%state%;" + (zV8qP8fE86HMhvNuYPFjqY ? clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.STATE_TRUE) : clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.STATE_FALSE));
        MessageUtils.sendCommandJson(commandSender, commandData, msgUsage, Arrays.asList(strArr2));
        return true;
    }

    private static String gbCFfdqwBLhVmjJa8xSk(byte[] bArr) {
        return "";
    }

    private static String USu0AhhxsMpLRMZsq() {
        return "chatspy";
    }

    private static String XdchjKIPtetFhBdiYv7D() {
        return "chatspy";
    }
}
