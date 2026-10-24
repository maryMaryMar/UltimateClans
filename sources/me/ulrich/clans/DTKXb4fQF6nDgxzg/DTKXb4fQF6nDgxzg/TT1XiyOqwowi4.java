package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.nio.charset.StandardCharsets;
import java.util.EnumMap;
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
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/TT1XiyOqwowi4.class */
public class TT1XiyOqwowi4 implements ClansCommand {
    private static volatile String Rdggm5i0e5X7CsF5J7l0O;
    private static String skMQxHAJSRxM7DOYR;
    private static final byte[] RopyQpRy3VIJTs2C = {(byte) 201, (byte) 164, (byte) 166, (byte) 160, (byte) 173, (byte) 134, (byte) 199, (byte) 215, (byte) 215, (byte) 23, (byte) 237, (byte) 0, (byte) 230, (byte) 4, (byte) 171, (byte) 84};
    private static final byte[] mvHZ9vbvIckwoU = {(byte) 34, (byte) 121, (byte) 47, (byte) 115, (byte) 248, (byte) 201, (byte) 66, (byte) 17, (byte) 191, (byte) 91, (byte) 232, (byte) 67, (byte) 116, (byte) 106, (byte) 51, (byte) 249, (byte) 23, (byte) 0, (byte) 116, (byte) 172, (byte) 107, (byte) 143, (byte) 111, (byte) 70, (byte) 61, (byte) 250, (byte) 15, (byte) 98, (byte) 119, (byte) 17, (byte) 31, (byte) 109};
    private static final byte[] fz5iezX8BtNZK3ADxM = {(byte) 125, (byte) 51, (byte) 74, (byte) 5, (byte) 39, (byte) 169, (byte) 220, (byte) 121, (byte) 131, (byte) 27, (byte) 210, (byte) 189, (byte) 227, (byte) 212, (byte) 2, (byte) 1};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(Ib3YwRhCfTW0OJ1())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(SflydxDKCFvbQuqy4ja());
        if (strArr.length != 1) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strZJnaNCVQSgEShq = null;
        try {
            strZJnaNCVQSgEShq = clans.getColorManager().zJnaNCVQSgEShq(strArr[0]);
        } catch (Exception e) {
        }
        if (strZJnaNCVQSgEShq == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strZJnaNCVQSgEShq);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strZJnaNCVQSgEShq);
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                optionalJBUuLP0sWwaPyPOmogdX7l = optionalIZTqZaRK5UGoe0Z;
            }
        }
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
            return true;
        }
        if (clans.getClanManager().xtOheRiObl4QeAl(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId())) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String zEttmYGzBaaKaL1RdRNR6(byte[] bArr) {
        return "";
    }

    private static String Ib3YwRhCfTW0OJ1() {
        return "verify";
    }

    private static String SflydxDKCFvbQuqy4ja() {
        return "verify";
    }
}
