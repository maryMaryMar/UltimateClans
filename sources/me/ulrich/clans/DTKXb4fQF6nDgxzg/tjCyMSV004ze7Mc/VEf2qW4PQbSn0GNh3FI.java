package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.OnlineData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/VEf2qW4PQbSn0GNh3FI.class */
public class VEf2qW4PQbSn0GNh3FI implements ClansCommand {
    private static volatile String VoZefRxkL3TE1B3RBjEz;
    private static String qUwaZm3dGoiavMHgqu;
    private static String Gkm8ebhjawKyEC7Ga;
    private static final byte[] YxdMKZXSG3VCGRDyu = {(byte) 160, (byte) 130, (byte) 128, (byte) 140, (byte) 185, (byte) 74, (byte) 142, (byte) 144, (byte) 231, (byte) 68, (byte) 182, (byte) 165, (byte) 102, (byte) 224, (byte) 126, (byte) 54};
    private static final byte[] Fx6w407IO2LG9Em = {(byte) 179, (byte) 154, (byte) 250, (byte) 249, (byte) 245, (byte) 105, (byte) 183, (byte) 145, (byte) 148, (byte) 193, (byte) 102, (byte) 225, (byte) 143, (byte) 138, (byte) 93, (byte) 141, (byte) 255, (byte) 242, (byte) 138, (byte) 217, (byte) 128, (byte) 250, (byte) 3, (byte) 246, (byte) 147, (byte) 156, (byte) 115, (byte) 173, (byte) 14, (byte) 185, (byte) 183, (byte) 187};
    private static final byte[] b89xfZ5rpqAUEgks = {(byte) 193, (byte) 174, (byte) 124, (byte) 60, (byte) 232, (byte) 250, (byte) 217, (byte) 244, (byte) 7, (byte) 160, (byte) 99, (byte) 6, (byte) 217, (byte) 104, (byte) 128, (byte) 200};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(wgLLQ4ZBjTVgUSi90p())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(ucbzg1MY1JqP7HpAEjNB6V());
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
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), LNB1RP3LwzhI8i8jvKdvU())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (!clans.getClanManager().o1VU1x4DAlrEtGKZ3jAdhE(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MAX_MEMBERS_LEVEL));
            return true;
        }
        Optional<OnlineData> optionalV8qP8fE86HMhvNuYPFjqY = clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(strArr[0]);
        if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = clans.getPlayerManager().p31abtwfBag2jhMH6K(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID());
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getMembers().contains(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_ALREADY_PARTICIPATING));
                return true;
            }
            if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_HAS_NOPROFILE));
                return true;
            }
            if (player.getUniqueId().equals(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_YOU));
                return true;
            }
            if (!clans.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_BLOCKED_INVITE));
                return true;
            }
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getBanned().contains(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_IS_BANNED));
                return true;
            }
        }
        if (!optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
            if (clans.isUseGUI()) {
                clans.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanSearchMembersInvite(player, strArr[0], null);
                return true;
            }
            clans.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                player.chat("/clan member search " + strArr[0]);
            });
            return true;
        }
        if (clans.getPlayerInviteManager().ZwrsrwOCXRUscW6Q(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID(), optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_ALREADY_INVITED));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (clans.getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID(), optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), player.getUniqueId())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String wgLLQ4ZBjTVgUSi90p() {
        return "invite";
    }

    private static String ucbzg1MY1JqP7HpAEjNB6V() {
        return "invite";
    }

    private static String LNB1RP3LwzhI8i8jvKdvU() {
        return "INVITE";
    }
}
