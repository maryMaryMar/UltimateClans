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
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/lO8DsfpVA7lKO.class */
public class lO8DsfpVA7lKO implements ClansCommand {
    private static volatile String QdxwCxXK9P859JO;
    private static volatile String s6qKJvS3Higfdy0YuCxRb;
    private static final byte[] kca9HyvR6r2HWER = {(byte) 28, (byte) 64, (byte) 18, (byte) 252, (byte) 193, (byte) 251, (byte) 61, (byte) 212, (byte) 181, (byte) 90, (byte) 210, (byte) 141, (byte) 138, (byte) 115, (byte) 61, (byte) 27};
    private static final byte[] COzuQFoXIwnwGAt1kOw = {(byte) 87, (byte) 243, (byte) 147, (byte) 25, (byte) 97, (byte) 201, (byte) 4, (byte) 24, (byte) 26, (byte) 95, (byte) 194, (byte) 190, (byte) 212, (byte) 177, (byte) 190, (byte) 37};
    private static final byte[] zCoU8IU0rxGdXt4NG = {(byte) 168, (byte) 156, (byte) 218, (byte) 172, (byte) 246, (byte) 18, (byte) 7, (byte) 150, (byte) 61, (byte) 131, (byte) 92, (byte) 237, (byte) 254, (byte) 10, (byte) 74, (byte) 62, (byte) 216, (byte) 227, (byte) 43, (byte) 236, (byte) 25, (byte) 187, (byte) 244, (byte) 50, (byte) 101, (byte) 212, (byte) 109, (byte) 185, (byte) 197, (byte) 102, (byte) 218, (byte) 199};
    private static final byte[] HjJvTKDvkgqhe1udTjB = {(byte) 57, (byte) 112, (byte) 228, (byte) 242, (byte) 121, (byte) 254, (byte) 172, (byte) 161, (byte) 148, (byte) 49, (byte) 82, (byte) 141, (byte) 16, (byte) 226, (byte) 61, (byte) 81};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(FcMP9SZYY4nqyRNK());
        if (strArr.length == 0 || strArr.length > 2) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (optionalCDW4Fj1iwdIXEOqWjiJSR.isEmpty()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[0]);
        if (optionalCDW4Fj1iwdIXEOqWjiJSR2.isEmpty() || !clans.getPlayerManager().xtOheRiObl4QeAl(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_ISNOT_YOUR_CLAN));
            return true;
        }
        if (player.getUniqueId().equals(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_YOU));
            return true;
        }
        if (clans.getPlayerManager().vVo2VUvxrriklPdRxI(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_CLAN_LEADER));
            return true;
        }
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), Qta30wE9krqE48FTUE()) || clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getUuid())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = clans.getModerationManager().b4i2FbOkaKeg91LiAe6l(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId());
        Optional<ModerationData> optionalV8qP8fE86HMhvNuYPFjqY = strArr.length == 2 ? clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(strArr[1], true) : clans.getModerationManager().p31abtwfBag2jhMH6K(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId());
        if (optionalB4i2FbOkaKeg91LiAe6l.isEmpty() || optionalV8qP8fE86HMhvNuYPFjqY.isEmpty()) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (optionalV8qP8fE86HMhvNuYPFjqY.get().getPriority() <= optionalB4i2FbOkaKeg91LiAe6l.get().getPriority()) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId(), optionalV8qP8fE86HMhvNuYPFjqY)) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String jFTbK7VShW9ZkaLh(byte[] bArr) {
        return "";
    }

    private static String FcMP9SZYY4nqyRNK() {
        return "promote";
    }

    private static String Qta30wE9krqE48FTUE() {
        return "PROMOTE";
    }
}
