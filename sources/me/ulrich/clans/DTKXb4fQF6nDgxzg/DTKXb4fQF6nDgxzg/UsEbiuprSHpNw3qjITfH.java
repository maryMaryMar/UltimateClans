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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/UsEbiuprSHpNw3qjITfH.class */
public class UsEbiuprSHpNw3qjITfH implements ClansCommand {
    private static volatile String rTQoUpWt1dfcAROjm;
    private static volatile String m3Rsqxf0WOp3WPhELiw7G;
    private static final byte[] lcEnyDT702pBkRsTcpXyNX = {(byte) 205, (byte) 232, (byte) 30, (byte) 158, (byte) 116, (byte) 26, (byte) 22, (byte) 76, (byte) 188, (byte) 155, (byte) 180, (byte) 185, (byte) 192, (byte) 206, (byte) 241, (byte) 30};
    private static final byte[] z8iPw85GOJ0rflhW = {(byte) 191, (byte) 93, (byte) 97, (byte) 220, (byte) 17, (byte) 219, (byte) 233, (byte) 30, (byte) 75, (byte) 28, (byte) 20, (byte) 117, (byte) 238, (byte) 164, (byte) 180, (byte) 200, (byte) 155, (byte) 70, (byte) 75, (byte) 62, (byte) 129, (byte) 11, (byte) 216, (byte) 19, (byte) 143, (byte) 159, (byte) 229, (byte) 30, (byte) 212, (byte) 69, (byte) 168, (byte) 239};
    private static final byte[] ppu4pKR0gUqZPbOhd8 = {(byte) 216, (byte) 143, (byte) 113, (byte) 15, (byte) 216, (byte) 136, (byte) 75, (byte) 152, (byte) 227, (byte) 160, (byte) 8, (byte) 146, (byte) 52, (byte) 25, (byte) 124, (byte) 36};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(oj7xvwuYBbYA3E())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(rtXxUm6euhnp13AXxCvd());
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
        if (clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), iIntValue, commandSender)) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%num%;" + String.valueOf(iIntValue), "%clan%;" + strValueOf));
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String oj7xvwuYBbYA3E() {
        return "addslot";
    }

    private static String rtXxUm6euhnp13AXxCvd() {
        return "addslot";
    }
}
