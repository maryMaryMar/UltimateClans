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
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/t5552Hwi8n9ivJHRmI.class */
public class t5552Hwi8n9ivJHRmI implements ClansCommand {
    private static final byte[] caAE0ORfA3B3goNhq = {(byte) 80, (byte) 94, (byte) 62, (byte) 94, (byte) 64, (byte) 144, (byte) 234, (byte) 168, (byte) 148, (byte) 167, (byte) 236, (byte) 223, (byte) 96, (byte) 0, (byte) 5, (byte) 107, (byte) 48, (byte) 148, (byte) 152, (byte) 118, (byte) 182, (byte) 44, (byte) 74, (byte) 33, (byte) 221, (byte) 243, (byte) 98, (byte) 240, (byte) 164, (byte) 114, (byte) 69, (byte) 144, (byte) 194, (byte) 3, (byte) 99, (byte) 159, (byte) 236, (byte) 247, (byte) 160, (byte) 93, (byte) 10, (byte) 140, (byte) 189, (byte) 184, (byte) 64, (byte) 52, (byte) 12, (byte) 48};
    private static volatile String UgmDz3S7hL4KFX1XRK48;
    private static volatile String yxSamgztAxiWiKqQRw63;

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(thd4NzAFNVVen5eCeLVU())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(EnKMqMXbWtma2KbL());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length != 0) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (clans.getPlayerManager().vVo2VUvxrriklPdRxI(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_CLAN_LEADER));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (!clans.getPlayerManager().xtOheRiObl4QeAl(player)) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        try {
            if (clans.getPlayerManager().ZwrsrwOCXRUscW6Q(player)) {
                clans.getPlayerManager().iZTqZaRK5UGoe0Z(player);
            }
        } catch (Exception e) {
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        return true;
    }

    private static String oR1pH2qXLHBvQy(byte[] bArr) {
        return "";
    }

    private static String thd4NzAFNVVen5eCeLVU() {
        return "leave";
    }

    private static String EnKMqMXbWtma2KbL() {
        return "leave";
    }
}
