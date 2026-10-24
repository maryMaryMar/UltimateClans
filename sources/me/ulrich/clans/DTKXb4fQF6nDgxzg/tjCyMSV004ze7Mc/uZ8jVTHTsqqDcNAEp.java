package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/uZ8jVTHTsqqDcNAEp.class */
public class uZ8jVTHTsqqDcNAEp implements ClansCommand {
    private static volatile String Uf4NOomhaQ5zloAbkQY6;
    private static String mS7jtZJsd98AvRa1pcLCD;
    private static volatile String txYkNP18DBcqJiF;
    private static String Mqw7PfohGo9DNXhA1q;
    private static volatile String Nhmm7w2WTDplbjLLFAM;
    private static volatile String AWUy5IZvuepYds2Jqk;
    private static final byte[] gj7yd3Mj4pk3ogrtR8R = {(byte) 52, (byte) 6, (byte) 173, (byte) 162, (byte) 203, (byte) 176, (byte) 112, (byte) 205, (byte) 150, (byte) 255, (byte) 207, (byte) 236, (byte) 1, (byte) 103, (byte) 247, (byte) 153};
    private static final byte[] h5FdndcGFtEBxIbfm7f = {(byte) 249, (byte) 18, (byte) 73, (byte) 14, (byte) 197, (byte) 120, (byte) 129, (byte) 123, (byte) 22, (byte) 188, (byte) 211, (byte) 30, (byte) 38, (byte) 159, (byte) 125, (byte) 51, (byte) 187, (byte) 163, (byte) 46, (byte) 150, (byte) 99, (byte) 20, (byte) 236, (byte) 52, (byte) 214, (byte) 181, (byte) 29, (byte) 159, (byte) 57, (byte) 226, (byte) 212, (byte) 57};
    private static final byte[] rlo0QK4q6FEtVJ1FgApI = {(byte) 15, (byte) 90, (byte) 223, (byte) 141, (byte) 71, (byte) 192, (byte) 82, (byte) 145, (byte) 15, (byte) 26, (byte) 86, (byte) 132, (byte) 94, (byte) 91, (byte) 6, (byte) 0};
    private static final byte[] wyiqy7qWtpdsvB = {(byte) 43, (byte) 43, (byte) 85, (byte) 150, (byte) 138, (byte) 122, (byte) 138, (byte) 87, (byte) 160, (byte) 198, (byte) 232, (byte) 0, (byte) 38, (byte) 67, (byte) 106, (byte) 118, (byte) 230, (byte) 191, (byte) 135, (byte) 80, (byte) 104, (byte) 30, (byte) 103, (byte) 4, (byte) 106, (byte) 205, (byte) 18, (byte) 125, (byte) 188, (byte) 103, (byte) 244, (byte) 171};
    private static final byte[] kGufcOgARmnQvRO = {(byte) 124, (byte) 91, (byte) 119, (byte) 202, (byte) 150, (byte) 116, (byte) 76, (byte) 180, (byte) 205, (byte) 73, (byte) 54, (byte) 234, (byte) 13, (byte) 67, (byte) 201, (byte) 48};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(PeF1aJNjkMhH8Jhg())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(KBK4xfXFvMr1Xw5Nxii());
        Player player = (Player) commandSender;
        if (strArr.length > 3) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        ClanEnum.PlaceholderPlayerTop placeholderPlayerTopValueOf = ClanEnum.PlaceholderPlayerTop.ALL;
        if (strArr.length >= 1 && !strArr[0].equalsIgnoreCase(jOxHJ5HVDwnW1MlqK())) {
            try {
                placeholderPlayerTopValueOf = ClanEnum.PlaceholderPlayerTop.valueOf(strArr[0].toUpperCase());
            } catch (Exception e) {
            }
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if ((commandSender instanceof Player) && clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(OE9qQ1zra3252R()) || ((strArr.length == 1 && strArr[0].equalsIgnoreCase(OvCaQzdoLMWe4fWTMEAN())) || (strArr.length == 2 && strArr[1].equalsIgnoreCase(wOGZzo3BBRXLGj()))))) {
            clans.getGuiManager().p31abtwfBag2jhMH6K().openPlayerTop(player, placeholderPlayerTopValueOf, 1, false, false);
            return true;
        }
        MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_PLAYERS_LIST_VIEW_HEADER, Arrays.asList("%current%;" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("TRANSLACTION_" + placeholderPlayerTopValueOf.toString()))))));
        List<Map.Entry<UUID, Float>> listV8qP8fE86HMhvNuYPFjqY = clans.getTopManager().v8qP8fE86HMhvNuYPFjqY(placeholderPlayerTopValueOf, 10);
        if (listV8qP8fE86HMhvNuYPFjqY.size() == 0) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
            return true;
        }
        for (Map.Entry<UUID, Float> entry : listV8qP8fE86HMhvNuYPFjqY) {
            String string = clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("HELP_PLAYERS_LIST_VIEW_FORMAT_" + placeholderPlayerTopValueOf.toString().toUpperCase()));
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getClanManager().iZTqZaRK5UGoe0Z(entry.getKey());
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string));
            }
        }
        return true;
    }

    private static String Dv5pEA32ntwWlMMKhgh1(byte[] bArr) {
        return "";
    }

    private static String PeF1aJNjkMhH8Jhg() {
        return "players";
    }

    private static String KBK4xfXFvMr1Xw5Nxii() {
        return "players";
    }

    private static String jOxHJ5HVDwnW1MlqK() {
        return "-gui";
    }

    private static String OE9qQ1zra3252R() {
        return "Config.gui.forge_open-gui";
    }

    private static String OvCaQzdoLMWe4fWTMEAN() {
        return "-gui";
    }

    private static String wOGZzo3BBRXLGj() {
        return "-gui";
    }
}
