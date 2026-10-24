package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
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
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/VEf2qW4PQbSn0GNh3FI.class */
public class VEf2qW4PQbSn0GNh3FI implements ClansCommand {
    private static volatile String uCA8u8MDSGPnIJe;
    private static volatile String mGhqkRHvSYVR7ctB;
    private static final byte[] Emp97yyf4EQNJTDQYggE = {(byte) 207, (byte) 226, (byte) 129, (byte) 100, (byte) 167, (byte) 23, (byte) 67, (byte) 160, (byte) 45, (byte) 163, (byte) 61, (byte) 68, (byte) 171, (byte) 234, (byte) 51, (byte) 101};
    private static final byte[] tu9RWR24BEU5triiX = {(byte) 247, (byte) 191, (byte) 134, (byte) 164, (byte) 82, (byte) 42, (byte) 118, (byte) 144, (byte) 103, (byte) 135, (byte) 238, (byte) 227, (byte) 130, (byte) 221, (byte) 234, (byte) 177, (byte) 240, (byte) 132, (byte) 2, (byte) 176, (byte) 42, (byte) 132, (byte) 133, (byte) 161, (byte) 141, (byte) 31, (byte) 162, (byte) 61, (byte) 124, (byte) 186, (byte) 199, (byte) 116, (byte) 23, (byte) 52, (byte) 53, (byte) 51, (byte) 146, (byte) 144, (byte) 45, (byte) 220, (byte) 149, (byte) 68, (byte) 213, (byte) 252, (byte) 213, (byte) 12, (byte) 218, (byte) 96};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(uIvcZrIC1q49vjmmC3A())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(lFCOBAVi6NcraF());
        if (strArr.length != 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String str2 = null;
        Optional<PlayerData> optionalEmpty = Optional.empty();
        try {
            str2 = strArr[0];
        } catch (Exception e) {
        }
        if (str2 == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
        }
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(str2);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerManager().iZTqZaRK5UGoe0Z(str2);
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                optionalJBUuLP0sWwaPyPOmogdX7l = optionalIZTqZaRK5UGoe0Z;
            }
        }
        if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_DOES_NOT_EXISTS));
            return true;
        }
        try {
            if (clans.getPlayerManager().xtOheRiObl4QeAl(strArr[1])) {
                optionalEmpty = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[1]);
            }
        } catch (Exception e2) {
        }
        if (!optionalEmpty.isPresent()) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerManager().xtOheRiObl4QeAl(optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), optionalEmpty.get().getId())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_ISNOT_YOUR_CLAN));
            return true;
        }
        if (clans.getPlayerManager().lGGwXL678c4Kv7skJb5NiE(optionalEmpty.get().getId(), optionalJBUuLP0sWwaPyPOmogdX7l.get().getId())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_CLAN_LEADER));
            return true;
        }
        if (clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalEmpty.get().getUuid(), ClanEnum.PlayerLeaveReaction.KICK, Optional.empty(), Optional.of(clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NEW_KICK_BY_CONSOLE)))) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String A0wmpNcQy5UKsQ(byte[] bArr) {
        return "";
    }

    private static String uIvcZrIC1q49vjmmC3A() {
        return "kick";
    }

    private static String lFCOBAVi6NcraF() {
        return "kick";
    }
}
