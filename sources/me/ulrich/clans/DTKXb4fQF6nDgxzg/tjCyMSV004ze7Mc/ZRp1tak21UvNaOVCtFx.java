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
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx implements ClansCommand {
    private static volatile String CVritiyJe94DiiSqYa;
    private static String rEE1KCTKKdzCR7RRM;
    private static final byte[] dirosMNi4SrPDcU = {(byte) 74, (byte) 86, (byte) 66, (byte) 246, (byte) 226, (byte) 223, (byte) 71, (byte) 10, (byte) 239, (byte) 36, (byte) 251, (byte) 17, (byte) 72, (byte) 201, (byte) 243, (byte) 247};
    private static final byte[] IMaIDLoVxz7VFqMbIVzrWy = {(byte) 74, (byte) 86, (byte) 66, (byte) 246, (byte) 226, (byte) 223, (byte) 71, (byte) 10, (byte) 239, (byte) 36, (byte) 251, (byte) 17, (byte) 72, (byte) 201, (byte) 243, (byte) 247};
    private static final byte[] TVYKfC0CguLJS47Ndh = {(byte) 100, (byte) 18, (byte) 110, (byte) 186, (byte) 13, (byte) 223, (byte) 179, (byte) 167, (byte) 6, (byte) 148, (byte) 27, (byte) 107, (byte) 21, (byte) 89, (byte) 39, (byte) 168, (byte) 105, (byte) 115, (byte) 56, (byte) 217, (byte) 95, (byte) 150, (byte) 213, (byte) 19, (byte) 211, (byte) 83, (byte) 136, (byte) 152, (byte) 109, (byte) 94, (byte) 143, (byte) 148, (byte) 184, (byte) 86, (byte) 182, (byte) 23, (byte) 151, (byte) 236, (byte) 144, (byte) 166, (byte) 96, (byte) 151, (byte) 109, (byte) 172, (byte) 85, (byte) 244, (byte) 71, (byte) 85};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(pwWao1kxzhXFImZZ())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(vfALQK35WVcCuaAOLhX());
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
        if (!clans.getPlayerManager().vVo2VUvxrriklPdRxI(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_LEADER));
            return true;
        }
        Player player2 = null;
        try {
            player2 = Bukkit.getPlayer(String.valueOf(strArr[0]));
        } catch (Exception e) {
        }
        if (player2 == null) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_OFFLINE));
            return true;
        }
        if (player.equals(player2)) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_YOU));
            return true;
        }
        if (!clans.getPlayerManager().xtOheRiObl4QeAl(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), player2.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_ISNOT_YOUR_CLAN));
            return true;
        }
        if (clans.isUseGUI()) {
            clans.getGuiManager().b4i2FbOkaKeg91LiAe6l().openChangeLeaderConfirm(player, player2.getUniqueId(), null);
            return true;
        }
        if (clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), player2.getUniqueId())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%clan_leader%;" + player2.getName()));
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String q20rZtggMmcsVnvWnRe(byte[] bArr) {
        return "";
    }

    private static String pwWao1kxzhXFImZZ() {
        return "changeleader";
    }

    private static String vfALQK35WVcCuaAOLhX() {
        return "changeleader";
    }
}
