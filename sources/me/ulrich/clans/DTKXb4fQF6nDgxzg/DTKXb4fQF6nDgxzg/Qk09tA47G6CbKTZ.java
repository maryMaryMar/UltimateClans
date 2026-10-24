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
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/Qk09tA47G6CbKTZ.class */
public class Qk09tA47G6CbKTZ implements ClansCommand {
    private static volatile String wTQmWIKFIZGj3Mjm17MR;
    private static volatile String wuc8uxYk2LNslIa;
    private static final byte[] ak8SCO4x78wBCg6L0PX = {(byte) 5, (byte) 180, (byte) 57, (byte) 91, (byte) 201, (byte) 167, (byte) 205, (byte) 195, (byte) 41, (byte) 72, (byte) 88, (byte) 105, (byte) 224, (byte) 205, (byte) 138, (byte) 50};
    private static final byte[] w9fogYqWC5dAsRJNPj = {(byte) 5, (byte) 180, (byte) 57, (byte) 91, (byte) 201, (byte) 167, (byte) 205, (byte) 195, (byte) 41, (byte) 72, (byte) 88, (byte) 105, (byte) 224, (byte) 205, (byte) 138, (byte) 50};
    private static final byte[] uXVzFiATgo2o8hVF = {(byte) 13, (byte) 66, (byte) 176, (byte) 130, (byte) 117, (byte) 79, (byte) 130, (byte) 252, (byte) 49, (byte) 232, (byte) 18, (byte) 57, (byte) 214, (byte) 139, (byte) 9, (byte) 14, (byte) 202, (byte) 226, (byte) 240, (byte) 85, (byte) 2, (byte) 143, (byte) 223, (byte) 119, (byte) 8, (byte) 200, (byte) 175, (byte) 243, (byte) 185, (byte) 41, (byte) 135, (byte) 46};
    private static final byte[] odheiGFtpE5ycop7b = {(byte) 126, (byte) 41, (byte) 70, (byte) 171, (byte) 96, (byte) 152, (byte) 59, (byte) 252, (byte) 251, (byte) 44, (byte) 176, (byte) 216, (byte) 30, (byte) 54, (byte) 187, (byte) 230};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(jvUUWvpERiseDQ5c5Wgea())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(boaEs9nKAGx3jU0());
        if (strArr.length != 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        int iIntValue = 0;
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(strArr[0]);
        } catch (Exception e) {
        }
        try {
            iIntValue = Integer.valueOf(strArr[1]).intValue();
        } catch (Exception e2) {
        }
        if (strValueOf == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (iIntValue < 1) {
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
        if (clans.getClanManager().ZwrsrwOCXRUscW6Q(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), iIntValue, commandSender)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%num%;" + String.valueOf(iIntValue), "%clan%;" + strValueOf));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String jvUUWvpERiseDQ5c5Wgea() {
        return "removeslot";
    }

    private static String boaEs9nKAGx3jU0() {
        return "removeslot";
    }
}
