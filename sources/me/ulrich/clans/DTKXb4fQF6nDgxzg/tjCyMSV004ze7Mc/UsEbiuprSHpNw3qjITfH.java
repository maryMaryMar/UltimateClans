package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH implements ClansCommand {
    private static String tNq4On3VGcC9xiii;
    private static volatile String TW9dahZbcZFVs4W;
    private static final byte[] pesnNRcTpDHxwgb3ckluI = {(byte) 120, (byte) 169, (byte) 204, (byte) 164, (byte) 126, (byte) 205, (byte) 100, (byte) 229, (byte) 115, (byte) 143, (byte) 56, (byte) 111, (byte) 108, (byte) 89, (byte) 192, (byte) 80};
    private static final byte[] oXpXh8ClHWRfQbVySnC = {(byte) 236, (byte) 103, (byte) 250, (byte) 186, (byte) 213, (byte) 106, (byte) 170, (byte) 180, (byte) 187, (byte) 92, (byte) 24, (byte) 197, (byte) 173, (byte) 24, (byte) 126, (byte) 136, (byte) 145, (byte) 208, (byte) 197, (byte) 191, (byte) 169, (byte) 104, (byte) 151, (byte) 115, (byte) 217, (byte) 178, (byte) 246, (byte) 210, (byte) 137, (byte) 187, (byte) 127, (byte) 235};
    private static final byte[] Gagt8DgRUmG7X6 = {(byte) 55, (byte) 47, (byte) 82, (byte) 92, (byte) 95, (byte) 170, (byte) 218, (byte) 239, (byte) 124, (byte) 185, (byte) 38, (byte) 33, (byte) 186, (byte) 33, (byte) 77, (byte) 189};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(gN3bXJxybtv6oilwm00aHj())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(SDTRTpqu8JrBfL5dFD());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length != 0) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        boolean zV8qP8fE86HMhvNuYPFjqY = false;
        if (!clans.getChatManager().v8qP8fE86HMhvNuYPFjqY(player) && !clans.getGuiManager().xtOheRiObl4QeAl().contains(player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NO_ACTIONS));
            return true;
        }
        if (clans.getChatManager().v8qP8fE86HMhvNuYPFjqY(player)) {
            zV8qP8fE86HMhvNuYPFjqY = clans.getChatManager().v8qP8fE86HMhvNuYPFjqY(player, true);
        }
        if (clans.getGuiManager().xtOheRiObl4QeAl().contains(player)) {
            zV8qP8fE86HMhvNuYPFjqY = clans.getGuiManager().v8qP8fE86HMhvNuYPFjqY(player);
        }
        if (zV8qP8fE86HMhvNuYPFjqY) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String lnRFLh9jyIxgfLXbo9(byte[] bArr) {
        return "";
    }

    private static String gN3bXJxybtv6oilwm00aHj() {
        return "cancel";
    }

    private static String SDTRTpqu8JrBfL5dFD() {
        return "cancel";
    }
}
