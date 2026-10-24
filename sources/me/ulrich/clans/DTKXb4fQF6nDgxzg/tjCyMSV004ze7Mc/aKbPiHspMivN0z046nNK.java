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
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/aKbPiHspMivN0z046nNK.class */
public class aKbPiHspMivN0z046nNK implements ClansCommand {
    private static String peAcNepN55lozJ5VC;
    private static volatile String NIroLsCoOFQz4E;
    private static final byte[] muabGDdkqBg3Av = {(byte) 146, (byte) 9, (byte) 15, (byte) 25, (byte) 176, (byte) 165, (byte) 22, (byte) 241, (byte) 58, (byte) 30, (byte) 50, (byte) 158, (byte) 179, (byte) 240, (byte) 9, (byte) 169};
    private static final byte[] U4MRx4jH0LedxWdRwk = {(byte) 146, (byte) 9, (byte) 15, (byte) 25, (byte) 176, (byte) 165, (byte) 22, (byte) 241, (byte) 58, (byte) 30, (byte) 50, (byte) 158, (byte) 179, (byte) 240, (byte) 9, (byte) 169};
    private static final byte[] HUy6g5l28axatbhU4 = {(byte) 194, (byte) 168, (byte) 247, (byte) 204, (byte) 116, (byte) 154, (byte) 47, (byte) 55, (byte) 53, (byte) 167, (byte) 230, (byte) 166, (byte) 154, (byte) 13, (byte) 55, (byte) 90, (byte) 172, (byte) 174, (byte) 74, (byte) 81, (byte) 196, (byte) 33, (byte) 206, (byte) 204, (byte) 32, (byte) 64, (byte) 121, (byte) 141, (byte) 188, (byte) 31, (byte) 34, (byte) 195, (byte) 33, (byte) 92, (byte) 161, (byte) 65, (byte) 137, (byte) 70, (byte) 76, (byte) 95, (byte) 86, (byte) 64, (byte) 12, (byte) 129, (byte) 221, (byte) 181, (byte) 222, (byte) 210};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(CeeBsjwtb4lw5kuT83Qdku())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(PkDoS3RDneAUjhwD4r());
        Player player = (Player) commandSender;
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clans.getColorManager().zJnaNCVQSgEShq(strValueOf));
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_DOES_NOT_EXISTS));
            return true;
        }
        if (optionalJBUuLP0sWwaPyPOmogdX7l.get().getBanned().contains(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_ARE_BANNED));
            return true;
        }
        if (clans.getPlayerManager().vVo2VUvxrriklPdRxI(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_CLAN_LEADER));
            return true;
        }
        if (!clans.getClanManager().o1VU1x4DAlrEtGKZ3jAdhE(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MAX_MEMBERS_LEVEL));
            return true;
        }
        if (clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_HAVE_CLAN));
            return true;
        }
        if (optionalJBUuLP0sWwaPyPOmogdX7l.get().getSettings().isOpened()) {
            if (optionalJBUuLP0sWwaPyPOmogdX7l.get().getMembers().contains(player.getUniqueId())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_ALREADY_PARTICIPATING));
                return true;
            }
            if (clans.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(player, optionalJBUuLP0sWwaPyPOmogdX7l.get().getId())) {
                MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        Optional<InviteData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerInviteManager().iZTqZaRK5UGoe0Z(player.getUniqueId(), optionalJBUuLP0sWwaPyPOmogdX7l.get().getId());
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_NO_INVITATIONS));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (!clans.getPlayerInviteManager().zJnaNCVQSgEShq(player.getUniqueId(), optionalIZTqZaRK5UGoe0Z.get().getId())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        clans.getChatManager().jBUuLP0sWwaPyPOmogdX7l(player);
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        return true;
    }

    private static String etQD8Mkbx8JHfdZO5iB8C(byte[] bArr) {
        return "";
    }

    private static String CeeBsjwtb4lw5kuT83Qdku() {
        return "join";
    }

    private static String PkDoS3RDneAUjhwD4r() {
        return "join";
    }
}
