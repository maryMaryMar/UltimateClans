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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/DQoauhaxduHZi.class */
public class DQoauhaxduHZi implements ClansCommand {
    private static String Qh8Z8oz4r2fa515QyA6Ro;
    private static String kahqmUvkMe8tszzU;
    private static volatile String ECsU3sWRMJ8QvADFZ;
    private static final byte[] HKoIKFSGbNOBkfR9WZ1XV = {(byte) 215, (byte) 254, (byte) 137, (byte) 101, (byte) 78, (byte) 196, (byte) 198, (byte) 27, (byte) 77, (byte) 148, (byte) 79, (byte) 177, (byte) 193, (byte) 134, (byte) 216, (byte) 160};
    private static final byte[] d8OshMfp71ty1KwGo = {(byte) 215, (byte) 254, (byte) 137, (byte) 101, (byte) 78, (byte) 196, (byte) 198, (byte) 27, (byte) 77, (byte) 148, (byte) 79, (byte) 177, (byte) 193, (byte) 134, (byte) 216, (byte) 160};
    private static final byte[] jaNvEURRZgOnyF = {(byte) 228, (byte) 19, (byte) 123, (byte) 50, (byte) 39, (byte) 123, (byte) 79, (byte) 60, (byte) 191, (byte) 249, (byte) 186, (byte) 0, (byte) 77, (byte) 170, (byte) 153, (byte) 73, (byte) 195, (byte) 27, (byte) 86, (byte) 68, (byte) 39, (byte) 83, (byte) 120, (byte) 142, (byte) 251, (byte) 213, (byte) 123, (byte) 197, (byte) 82, (byte) 244, (byte) 252, (byte) 197, (byte) 5, (byte) 24, (byte) 153, (byte) 15, (byte) 77, (byte) 129, (byte) 57, (byte) 243, (byte) 205, (byte) 103, (byte) 162, (byte) 190, (byte) 87, (byte) 207, (byte) 186, (byte) 53};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(JMPC2m1uleqhwrDju())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(GVA10JMF4WtG76qjkaKj());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length == 0 && clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            if (me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.CLANDESC, null, false, true, 0)) {
                return true;
            }
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (strArr.length < 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), WJf2TBeWwK1ZyBUg6XboMx())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            try {
                sb.append(str2).append(" ");
            } catch (Exception e) {
            }
        }
        if (clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player, sb.toString())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String dw7yU9vj0Vb9ME(byte[] bArr) {
        return "";
    }

    private static String JMPC2m1uleqhwrDju() {
        return "desc";
    }

    private static String GVA10JMF4WtG76qjkaKj() {
        return "desc";
    }

    private static String WJf2TBeWwK1ZyBUg6XboMx() {
        return "DESC";
    }
}
