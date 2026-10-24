package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/uZ8jVTHTsqqDcNAEp.class */
public class uZ8jVTHTsqqDcNAEp implements ClansCommand {
    private static volatile String JiTw9kjJKZJG8N;
    private static volatile String fP2hqaS2ouoVrO;
    private static final byte[] iTdj2LqrAjjsPwN86aU = {(byte) 190, (byte) 245, (byte) 30, (byte) 42, (byte) 21, (byte) 180, (byte) 96, (byte) 9, (byte) 64, (byte) 229, (byte) 200, (byte) 198, (byte) 146, (byte) 159, (byte) 13, (byte) 12};
    private static final byte[] l7bbYrSEBHiMboEsDf = {(byte) 113, (byte) 59, (byte) 233, (byte) 77, (byte) 40, (byte) 145, (byte) 162, (byte) 232, (byte) 123, (byte) 6, (byte) 78, (byte) 131, (byte) 108, (byte) 146, (byte) 51, (byte) 226, (byte) 165, (byte) 181, (byte) 128, (byte) 176, (byte) 92, (byte) 27, (byte) 255, (byte) 2, (byte) 28, (byte) 201, (byte) 173, (byte) 139, (byte) 85, (byte) 240, (byte) 133, (byte) 76};
    private static final byte[] slqF2WfdJBdw8NqKgrHR = {(byte) 140, (byte) 8, (byte) 46, (byte) 107, (byte) 63, (byte) 73, (byte) 217, (byte) 34, (byte) 104, (byte) 72, (byte) 196, (byte) 177, (byte) 80, (byte) 119, (byte) 40, (byte) 126};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(LBJlSJOyRrTg3A9())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(TnkuibO6ja5WHeOFU());
        if (strArr.length != 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        Optional.empty();
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strValueOf);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strValueOf);
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                optionalJBUuLP0sWwaPyPOmogdX7l = optionalIZTqZaRK5UGoe0Z;
            }
        }
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
            return true;
        }
        Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[1]);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (clans.getPlayerManager().lGGwXL678c4Kv7skJb5NiE(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), optionalJBUuLP0sWwaPyPOmogdX7l.get().getId())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_CLAN_LEADER));
            return true;
        }
        if (!clans.getPlayerManager().xtOheRiObl4QeAl(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()) && clans.getPlayerManager().vVo2VUvxrriklPdRxI(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_CLAN_LEADER));
            return true;
        }
        if (clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String LBJlSJOyRrTg3A9() {
        return "setleader";
    }

    private static String TnkuibO6ja5WHeOFU() {
        return "setleader";
    }
}
