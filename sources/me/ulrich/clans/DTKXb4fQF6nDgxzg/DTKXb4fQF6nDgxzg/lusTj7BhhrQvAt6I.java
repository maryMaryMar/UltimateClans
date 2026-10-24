package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/lusTj7BhhrQvAt6I.class */
public class lusTj7BhhrQvAt6I implements ClansCommand {
    private static String sqxSxXGcVoCADrz8fL;
    private static volatile String cGWsnTCMJOM3GrglyH;
    private static final byte[] mbeP98WgL6ULHdx = {(byte) 50, (byte) 28, (byte) 17, (byte) 232, (byte) 40, (byte) 196, (byte) 63, (byte) 215, (byte) 252, (byte) 173, (byte) 157, (byte) 31, (byte) 123, (byte) 228, (byte) 213, (byte) 34};
    private static final byte[] qhxeKTMYVsTDv9ZgaZ = {(byte) 236, (byte) 180, (byte) 113, (byte) 91, (byte) 204, (byte) 186, (byte) 150, (byte) 187, (byte) 128, (byte) 64, (byte) 241, (byte) 250, (byte) 110, (byte) 158, (byte) 43, (byte) 249, (byte) 15, (byte) 119, (byte) 194, (byte) 64, (byte) 242, (byte) 175, (byte) 71, (byte) 103, (byte) 112, (byte) 205, (byte) 169, (byte) 182, (byte) 136, (byte) 53, (byte) 88, (byte) 166, (byte) 251, (byte) 115, (byte) 85, (byte) 153, (byte) 224, (byte) 216, (byte) 83, (byte) 11, (byte) 208, (byte) 60, (byte) 28, (byte) 112, (byte) 167, (byte) 67, (byte) 141, (byte) 65};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(okBy6uRxXPbi2M())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(HJb0TC0oq74JJ0LpxwOIO());
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional.empty();
        Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[0]);
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (clans.getPlayerManager().QXoNfOxIPaPrSlQMNR(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String uAdtFDW2pb72IJH(byte[] bArr) {
        return "";
    }

    private static String okBy6uRxXPbi2M() {
        return "resetplayerkdr";
    }

    private static String HJb0TC0oq74JJ0LpxwOIO() {
        return "resetplayerkdr";
    }
}
