package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.interfaces.LevelupModuleAPI;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/KG0dzbdBSFtZuuPbyPn.class */
public class KG0dzbdBSFtZuuPbyPn implements ClansCommand {
    private static String cdEHDGo1ynTKqOuRImO;
    private static volatile String ZX9JrppkyTwhFMo15LWj;
    private static final byte[] tgLd58dYgwJb35oY9rni4 = {(byte) 250, (byte) 135, (byte) 71, (byte) 8, (byte) 236, (byte) 104, (byte) 96, (byte) 38, (byte) 18, (byte) 4, (byte) 227, (byte) 77, (byte) 195, (byte) 221, (byte) 149, (byte) 161};
    private static final byte[] N4iWJxHB0FzKEzYN = {(byte) 250, (byte) 135, (byte) 71, (byte) 8, (byte) 236, (byte) 104, (byte) 96, (byte) 38, (byte) 18, (byte) 4, (byte) 227, (byte) 77, (byte) 195, (byte) 221, (byte) 149, (byte) 161};
    private static final byte[] lRoEraDx7eaXsK = {(byte) 177, (byte) 2, (byte) 101, (byte) 208, (byte) 73, (byte) 210, (byte) 158, (byte) 1, (byte) 212, (byte) 61, (byte) 146, (byte) 210, (byte) 234, (byte) 187, (byte) 190, (byte) 106, (byte) 124, (byte) 197, (byte) 190, (byte) 120, (byte) 108, (byte) 250, (byte) 1, (byte) 186, (byte) 183, (byte) 162, (byte) 47, (byte) 117, (byte) 178, (byte) 164, (byte) 45, (byte) 128};
    private static final byte[] cQ9pIPG23A2GrZR = {(byte) 8, (byte) 182, (byte) 134, (byte) 47, (byte) 72, (byte) 145, (byte) 199, (byte) 137, (byte) 236, (byte) 79, (byte) 48, (byte) 26, (byte) 20, (byte) 168, (byte) 172, (byte) 187};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(tCxT1tbksW5F000GIc())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(x4d1gcdB4C51tEQ6());
        if (strArr.length < 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        int iIntValue = 0;
        String strValueOf = null;
        StringBuilder sb = new StringBuilder();
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        try {
            iIntValue = Integer.valueOf(strArr[1]).intValue();
        } catch (Exception e2) {
        }
        for (int i = 2; i < strArr.length; i++) {
            try {
                sb.append(strArr[i]).append(" ");
            } catch (Exception e3) {
            }
        }
        if (strValueOf == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (iIntValue < 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.VALUE_GREATER_THAN_ZERO));
            return true;
        }
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
        Optional<LevelupModuleAPI> levelup = Clans.getClanCore().getIntegrationAPI().getLevelup();
        if (levelup.isPresent() && levelup.get().setPoint(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), iIntValue, commandSender, sb)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%num%;" + String.valueOf(iIntValue), "%clan%;" + strValueOf));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String tCxT1tbksW5F000GIc() {
        return "setpoints";
    }

    private static String x4d1gcdB4C51tEQ6() {
        return "setpoints";
    }
}
