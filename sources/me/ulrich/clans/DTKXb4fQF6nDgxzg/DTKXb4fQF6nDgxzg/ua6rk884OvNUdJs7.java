package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

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
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/ua6rk884OvNUdJs7.class */
public class ua6rk884OvNUdJs7 implements ClansCommand {
    private static String Npr71WJA10WiFw1DGDdqm;
    private static volatile String cN0xTSkKA3czSo0;
    private static final byte[] VeznCXOSop8ZeIuTxwLT9 = {(byte) 166, (byte) 38, (byte) 210, (byte) 32, (byte) 18, (byte) 99, (byte) 136, (byte) 88, (byte) 24, (byte) 55, (byte) 232, (byte) 199, (byte) 85, (byte) 30, (byte) 30, (byte) 171};
    private static final byte[] k1C11MLBKCS63ea0K = {(byte) 233, (byte) 111, (byte) 103, (byte) 196, (byte) 204, (byte) 32, (byte) 56, (byte) 238, (byte) 252, (byte) 113, (byte) 211, (byte) 219, (byte) 74, (byte) 189, (byte) 217, (byte) 47, (byte) 54, (byte) 127, (byte) 224, (byte) 97, (byte) 85, (byte) 226, (byte) 141, (byte) 94, (byte) 38, (byte) 185, (byte) 146, (byte) 77, (byte) 119, (byte) 50, (byte) 34, (byte) 234};
    private static final byte[] owpcPwg6uEnsODRM = {(byte) 136, (byte) 70, (byte) 147, (byte) 241, (byte) 57, (byte) 183, (byte) 118, (byte) 15, (byte) 183, (byte) 56, (byte) 204, (byte) 177, (byte) 93, (byte) 13, (byte) 255, (byte) 236};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(ALzIGPThSRIZ78PQIX2())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(lZZw8FWU8Je6iYb1wsvco());
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        if (strValueOf == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
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
        if (clans.getClanManager().iZTqZaRK5UGoe0Z(optionalJBUuLP0sWwaPyPOmogdX7l.get())) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String ALzIGPThSRIZ78PQIX2() {
        return "resetclankdr";
    }

    private static String lZZw8FWU8Je6iYb1wsvco() {
        return "resetclankdr";
    }
}
