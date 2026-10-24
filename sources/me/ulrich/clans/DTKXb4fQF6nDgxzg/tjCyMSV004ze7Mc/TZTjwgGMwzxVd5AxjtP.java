package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
import java.util.Iterator;
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
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/TZTjwgGMwzxVd5AxjtP.class */
public class TZTjwgGMwzxVd5AxjtP implements ClansCommand {
    private static String SUsoGwC1ojWqoeK;
    private static volatile String fQMX1hqydilcoaYV2OKy;
    private static volatile String EsDXE2dUEE3WXepHNksddb;
    private static String dAhfjHSxlRz1np3;
    private static String gbrNgxWxeImLsJx;
    private static String tHnydJsXZiDLsO1qV0rjEN;
    private static final byte[] Lvnzk8F209X2GHckt = {(byte) 11, (byte) 104, (byte) 182, (byte) 85, (byte) 167, (byte) 40, (byte) 2, (byte) 103, (byte) 113, (byte) 145, (byte) 18, (byte) 37, (byte) 165, (byte) 20, (byte) 120, (byte) 36, (byte) 217, (byte) 132, (byte) 255, (byte) 253, (byte) 191, (byte) 166, (byte) 174, (byte) 137, (byte) 192, (byte) 16, (byte) 38, (byte) 246, (byte) 54, (byte) 141, (byte) 183, (byte) 152};
    private static final byte[] emb1Au7X8wthEp4 = {(byte) 144, (byte) 28, (byte) 68, (byte) 35, (byte) 130, (byte) 84, (byte) 107, (byte) 190, (byte) 122, (byte) 243, (byte) 166, (byte) 128, (byte) 254, (byte) 74, (byte) 221, (byte) 235};
    private static final byte[] CFcNcVyGE5fd1z = {(byte) 239, (byte) 107, (byte) 50, (byte) 124, (byte) 96, (byte) 22, (byte) 29, (byte) 97, (byte) 188, (byte) 187, (byte) 101, (byte) 150, (byte) 43, (byte) 97, (byte) 48, (byte) 165};
    private static final byte[] wrqJILB7P1Jk78FG04khQM = {(byte) 239, (byte) 107, (byte) 50, (byte) 124, (byte) 96, (byte) 22, (byte) 29, (byte) 97, (byte) 188, (byte) 187, (byte) 101, (byte) 150, (byte) 43, (byte) 97, (byte) 48, (byte) 165};
    private static final byte[] qVefKlVOcYGzw8wEgRRRM9 = {(byte) 176, (byte) 208, (byte) 67, (byte) 76, (byte) 210, (byte) 189, (byte) 76, (byte) 242, (byte) 246, (byte) 43, (byte) 210, (byte) 165, (byte) 156, (byte) 32, (byte) 145, (byte) 247, (byte) 87, (byte) 244, (byte) 228, (byte) 152, (byte) 219, (byte) 217, (byte) 4, (byte) 52, (byte) 0, (byte) 72, (byte) 203, (byte) 230, (byte) 12, (byte) 104, (byte) 187, (byte) 140};
    private static final byte[] rID8vnG8MhipHaH2B6o9 = {(byte) 130, (byte) 180, (byte) 30, (byte) 108, (byte) 130, (byte) 138, (byte) 239, (byte) 221, (byte) 91, (byte) 167, (byte) 76, (byte) 126, (byte) 130, (byte) 4, (byte) 114, (byte) 8};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR;
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(Gke7sDResjlGZ2JOoRU())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(HRJXtBFfySbSM0cxe());
        Player player = (Player) commandSender;
        if (strArr.length > 3) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional.empty();
        if (strArr.length < 1 || strArr[0].equalsIgnoreCase(rGr5mk2RCUX96RGyBI8h14())) {
            optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        } else {
            optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strArr[0]);
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strArr[0]);
                if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                    optionalCDW4Fj1iwdIXEOqWjiJSR = optionalIZTqZaRK5UGoe0Z;
                }
            }
        }
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
            return true;
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if ((commandSender instanceof Player) && clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(cYkfQHtmbNd6BmE4RSs()) || ((strArr.length == 1 && strArr[0].equalsIgnoreCase(lIP7juhcNMJl5tw4PaoAuh())) || (strArr.length == 2 && strArr[1].equalsIgnoreCase(t30YAEdIaogwwBY()))))) {
            clans.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanStats(player, optionalCDW4Fj1iwdIXEOqWjiJSR.get(), null);
            return true;
        }
        MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_INFO_VIEW_HEADER)));
        Iterator<String> it = clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getStringList(Lang.HELP_CLAN_INFO_VIEW_FORMAT).iterator();
        while (it.hasNext()) {
            MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), it.next()));
        }
        return true;
    }

    private static String UDW72Dmg7vWyiRFarNPP(byte[] bArr) {
        return "";
    }

    private static String Gke7sDResjlGZ2JOoRU() {
        return "info";
    }

    private static String HRJXtBFfySbSM0cxe() {
        return "info";
    }

    private static String rGr5mk2RCUX96RGyBI8h14() {
        return "-gui";
    }

    private static String cYkfQHtmbNd6BmE4RSs() {
        return "Config.gui.forge_open-gui";
    }

    private static String lIP7juhcNMJl5tw4PaoAuh() {
        return "-gui";
    }

    private static String t30YAEdIaogwwBY() {
        return "-gui";
    }
}
