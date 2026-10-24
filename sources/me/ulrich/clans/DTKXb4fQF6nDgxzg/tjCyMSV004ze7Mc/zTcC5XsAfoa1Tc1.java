package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.EnumMap;
import java.util.Objects;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.z8MICAC4yDYZiO;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 implements ClansCommand {
    private static volatile String sh54vulLgxWcizVJ;
    private static String mrKWGpNjpFcMPD1Xh;
    private static final byte[] oyIFh2UUdq8Yqtkcvi = {(byte) 72, (byte) 226, (byte) 154, (byte) 180, (byte) 20, (byte) 68, (byte) 153, (byte) 2, (byte) 91, (byte) 185, (byte) 188, (byte) 127, (byte) 90, (byte) 206, (byte) 227, (byte) 255};
    private static final byte[] FqRHK9jJI5he4PSM79l = {(byte) 15, (byte) 196, (byte) 141, (byte) 18, (byte) 130, (byte) 33, (byte) 104, (byte) 75, (byte) 20, (byte) 245, (byte) 241, (byte) 103, (byte) 0, (byte) 105, (byte) 172, (byte) 89, (byte) 53, (byte) 21, (byte) 77, (byte) 146, (byte) 92, (byte) 3, (byte) 34, (byte) 194, (byte) 26, (byte) 26, (byte) 133, (byte) 234, (byte) 44, (byte) 47, (byte) 177, (byte) 22};
    private static final byte[] Iwfnryz5tEPLSvUr = {(byte) 159, (byte) 130, (byte) 121, (byte) 43, (byte) 25, (byte) 64, (byte) 200, (byte) 227, (byte) 209, (byte) 76, (byte) 247, (byte) 68, (byte) 202, (byte) 210, (byte) 158, (byte) 128};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(fLbGiPOz4PRXfxs8Hrf());
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
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), NHnXi07I20q6vkrCWYX()) || clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getUuid())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = clans.getModerationManager().b4i2FbOkaKeg91LiAe6l(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId());
        Optional<ModerationData> optionalV8qP8fE86HMhvNuYPFjqY = strArr.length == 2 ? clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(strArr[1], true) : clans.getModerationManager().Un3NRLL6aWivTcbodkcK(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId());
        if (optionalB4i2FbOkaKeg91LiAe6l.isEmpty() || optionalV8qP8fE86HMhvNuYPFjqY.isEmpty()) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (optionalV8qP8fE86HMhvNuYPFjqY.get().getPriority() >= optionalB4i2FbOkaKeg91LiAe6l.get().getPriority()) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if (!clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId(), optionalV8qP8fE86HMhvNuYPFjqY)) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        Player player2 = Bukkit.getPlayer(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getUuid());
        if (player2 != null && player2.isOnline()) {
            z8MICAC4yDYZiO taskManager = clans.getTaskManager();
            Objects.requireNonNull(player2);
            taskManager.v8qP8fE86HMhvNuYPFjqY((Entity) player2, player2::closeInventory);
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        return true;
    }

    private static String fLbGiPOz4PRXfxs8Hrf() {
        return "demote";
    }

    private static String NHnXi07I20q6vkrCWYX() {
        return "DEMOTE";
    }
}
