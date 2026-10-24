package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/jfN3Uc9ymXXFWVHj7Oor.class */
public class jfN3Uc9ymXXFWVHj7Oor implements ClansCommand {
    private static volatile String En2KhzCBTJ8P0cwal;
    private static volatile String AP5pti39NLdo4Wghxby;
    private static String V2pEMLmFyFaN6WzaaU;
    private static volatile String hnIexlcdoWYGApxy;
    private static final byte[] A8me96Pf6WaWfU67nB = {(byte) 188, (byte) 159, (byte) 58, (byte) 80, (byte) 169, (byte) 205, (byte) 97, (byte) 178, (byte) 64, (byte) 72, (byte) 188, (byte) 72, (byte) 35, (byte) 121, (byte) 151, (byte) 161};
    private static final byte[] r5KjcyB9gxsgc0RpYuGoN0 = {(byte) 194, (byte) 183, (byte) 159, (byte) 46, (byte) 223, (byte) 247, (byte) 9, (byte) 59, (byte) 254, (byte) 99, (byte) 171, (byte) 204, (byte) 251, (byte) 56, (byte) 209, (byte) 217};
    private static final byte[] zE8nFGzYGbI1Xu = {(byte) 194, (byte) 183, (byte) 159, (byte) 46, (byte) 223, (byte) 247, (byte) 9, (byte) 59, (byte) 254, (byte) 99, (byte) 171, (byte) 204, (byte) 251, (byte) 56, (byte) 209, (byte) 217};
    private static final byte[] L1XWgFNiNf1up5 = {(byte) 117, (byte) 34, (byte) 64, (byte) 48, (byte) 23, (byte) 54, (byte) 250, (byte) 20, (byte) 13, (byte) 85, (byte) 201, (byte) 90, (byte) 218, (byte) 218, (byte) 222, (byte) 199, (byte) 252, (byte) 67, (byte) 237, (byte) 182, (byte) 18, (byte) 93, (byte) 56, (byte) 152, (byte) 230, (byte) 203, (byte) 225, (byte) 125, (byte) 72, (byte) 209, (byte) 33, (byte) 48};
    private static final byte[] KFRlSx9qmP8yZVz0fyV = {(byte) 108, (byte) 243, (byte) 132, (byte) 46, (byte) 149, (byte) 124, (byte) 81, (byte) 160, (byte) 213, (byte) 51, (byte) 174, (byte) 53, (byte) 183, (byte) 172, (byte) 120, (byte) 152};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(AuDlCIaAQ65XSHD96nP())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(rTCakLqWKOGqz3dRrMy());
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length > 1) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), pYCww0rbIvMLzltVxqGzOY())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (clans.isUseGUI() && clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(NBMOoVmVIqJ9TYoE2RYc())) {
            clans.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openDisbandConfirm(player, null);
            return true;
        }
        if (!clans.getClanManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId())) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(ClanEnum.ClanCommandActions.DELETE, Arrays.asList("%player%;" + clans.getHooksManager().getPlayerName(player), "%clantag%;" + optionalCDW4Fj1iwdIXEOqWjiJSR.get().getTagNoColor()), player.getUniqueId());
        return true;
    }

    private static String AuDlCIaAQ65XSHD96nP() {
        return "disband";
    }

    private static String rTCakLqWKOGqz3dRrMy() {
        return "disband";
    }

    private static String pYCww0rbIvMLzltVxqGzOY() {
        return "DISBAND";
    }

    private static String NBMOoVmVIqJ9TYoE2RYc() {
        return "Config.gui.disband_confirm";
    }
}
