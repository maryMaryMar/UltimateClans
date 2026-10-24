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
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/XQWpFH32TPMOVKV5.class */
public class XQWpFH32TPMOVKV5 implements ClansCommand {
    private static volatile String N3p13Zd0UMXOtYtMgC;
    private static volatile String uVM5w5zWGLXpTe0OkSiuF;
    private static final byte[] A4gOzO2LtM0lT0iGVt = {(byte) 106, (byte) 15, (byte) 215, (byte) 243, (byte) 239, (byte) 69, (byte) 7, (byte) 97, (byte) 116, (byte) 234, (byte) 140, (byte) 223, (byte) 114, (byte) 248, (byte) 93, (byte) 146};
    private static final byte[] FoXtRNwsJWUzqYUxe = {(byte) 106, (byte) 15, (byte) 215, (byte) 243, (byte) 239, (byte) 69, (byte) 7, (byte) 97, (byte) 116, (byte) 234, (byte) 140, (byte) 223, (byte) 114, (byte) 248, (byte) 93, (byte) 146};
    private static final byte[] A1Y4OxXXFSTKr5G6E9TU = {(byte) 236, (byte) 69, (byte) 101, (byte) 158, (byte) 255, (byte) 165, (byte) 86, (byte) 103, (byte) 132, (byte) 39, (byte) 162, (byte) 204, (byte) 132, (byte) 252, (byte) 142, (byte) 128, (byte) 225, (byte) 244, (byte) 203, (byte) 92, (byte) 182, (byte) 93, (byte) 160, (byte) 23, (byte) 255, (byte) 20, (byte) 38, (byte) 117, (byte) 219, (byte) 7, (byte) 188, (byte) 94, (byte) 15, (byte) 135, (byte) 31, (byte) 64, (byte) 237, (byte) 193, (byte) 43, (byte) 93, (byte) 95, (byte) 34, (byte) 215, (byte) 6, (byte) 121, (byte) 185, (byte) 95, (byte) 208};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(gNUxIizg3TIogsKv())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(N084VjAnlMaTk4t());
        if (strArr.length != 2) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Player player = null;
        String strValueOf = null;
        try {
            strValueOf = String.valueOf(strArr[1]);
        } catch (Exception e) {
        }
        try {
            player = Bukkit.getPlayer(strArr[0]);
        } catch (Exception e2) {
        }
        if (strValueOf == null) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (player == null) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_OFFLINE));
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
        if (clans.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(player, optionalJBUuLP0sWwaPyPOmogdX7l.get().getId())) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String KaubDvsU4bH5Mwojd6(byte[] bArr) {
        return "";
    }

    private static String gNUxIizg3TIogsKv() {
        return "forcejoin";
    }

    private static String N084VjAnlMaTk4t() {
        return "forcejoin";
    }
}
