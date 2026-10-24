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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/nfoeLRxl4WZADv.class */
public class nfoeLRxl4WZADv implements ClansCommand {
    private static volatile String G1cf1Jdp6Nz1ZBb;
    private static String PYCliO9teMUtqr;
    private static String hpWdGJ6rSw38zv;
    private static String ZpzEjscMaGPLiPnlrU;
    private static String sWyKZN3B2JHAwAp;
    private static volatile String dJmRL0KXaEWy0yDOKk5j;
    private static final byte[] TAWVVlMIvGeR77W = {(byte) 21, (byte) 101, (byte) 199, (byte) 166, (byte) 223, (byte) 225, (byte) 183, (byte) 169, (byte) 218, (byte) 228, (byte) 147, (byte) 236, (byte) 229, (byte) 37, (byte) 71, (byte) 129};
    private static final byte[] Tf3yjUWDllLKG5C = {(byte) 21, (byte) 101, (byte) 199, (byte) 166, (byte) 223, (byte) 225, (byte) 183, (byte) 169, (byte) 218, (byte) 228, (byte) 147, (byte) 236, (byte) 229, (byte) 37, (byte) 71, (byte) 129};
    private static final byte[] bbQ5tW8qJENNi5ZN = {(byte) 21, (byte) 101, (byte) 199, (byte) 166, (byte) 223, (byte) 225, (byte) 183, (byte) 169, (byte) 218, (byte) 228, (byte) 147, (byte) 236, (byte) 229, (byte) 37, (byte) 71, (byte) 129};
    private static final byte[] HOQUgtKZF6Y1qjzO = {(byte) 246, (byte) 48, (byte) 217, (byte) 150, (byte) 216, (byte) 140, (byte) 203, (byte) 189, (byte) 4, (byte) 197, (byte) 188, (byte) 104, (byte) 232, (byte) 86, (byte) 235, (byte) 26};
    private static final byte[] pecicGSP6rVyRp = {(byte) 37, (byte) 29, (byte) 188, (byte) 57, (byte) 147, (byte) 11, (byte) 33, (byte) 246, (byte) 240, (byte) 2, (byte) 132, (byte) 62, (byte) 215, (byte) 219, (byte) 115, (byte) 254, (byte) 224, (byte) 151, (byte) 86, (byte) 244, (byte) 171, (byte) 154, (byte) 239, (byte) 110, (byte) 245, (byte) 117, (byte) 255, (byte) 91, (byte) 227, (byte) 203, (byte) 111, (byte) 173, (byte) 0, (byte) 142, (byte) 161, (byte) 175, (byte) 220, (byte) 168, (byte) 119, (byte) 238, (byte) 59, (byte) 47, (byte) 57, (byte) 142, (byte) 60, (byte) 76, (byte) 70, (byte) 73};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(qHBfrLEDjuhUsbcysMQe())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(qRG7RZ2WSNc1xEIOq8q());
        Player player = (Player) commandSender;
        if (strArr.length > 3) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        ClanEnum.PlaceholderTop placeholderTopValueOf = ClanEnum.PlaceholderTop.ALL;
        if (strArr.length >= 1 && !strArr[0].equalsIgnoreCase(AV5eyScvk0q8KkWC())) {
            try {
                placeholderTopValueOf = ClanEnum.PlaceholderTop.valueOf(strArr[0].toUpperCase());
            } catch (Exception e) {
            }
        }
        if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
            return true;
        }
        if ((commandSender instanceof Player) && clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(elnKtY2Htg1cg3e()) || ((strArr.length == 1 && strArr[0].equalsIgnoreCase(AzlwbaMFyARJmC6wPe())) || (strArr.length == 2 && strArr[1].equalsIgnoreCase(KDh5sRoWKXfxRSp()))))) {
            clans.getGuiManager().p31abtwfBag2jhMH6K().openClanTop(player, placeholderTopValueOf, 1, false);
            return true;
        }
        MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_LIST_VIEW_HEADER, Arrays.asList("%current%;" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("TRANSLACTION_" + placeholderTopValueOf.toString()))))));
        List<Map.Entry<UUID, Float>> listV8qP8fE86HMhvNuYPFjqY = clans.getTopManager().v8qP8fE86HMhvNuYPFjqY(placeholderTopValueOf, 10);
        if (listV8qP8fE86HMhvNuYPFjqY.size() == 0) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
            return true;
        }
        for (Map.Entry<UUID, Float> entry : listV8qP8fE86HMhvNuYPFjqY) {
            String string = clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("HELP_CLAN_LIST_VIEW_FORMAT_" + placeholderTopValueOf.toString().toUpperCase()));
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getClanManager().iZTqZaRK5UGoe0Z(entry.getKey());
            if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), string));
            }
        }
        return true;
    }

    private static String Ma6bErUBIFscm76GhL(byte[] bArr) {
        return "";
    }

    private static String qHBfrLEDjuhUsbcysMQe() {
        return "list";
    }

    private static String qRG7RZ2WSNc1xEIOq8q() {
        return "list";
    }

    private static String AV5eyScvk0q8KkWC() {
        return "-gui";
    }

    private static String elnKtY2Htg1cg3e() {
        return "Config.gui.forge_open-gui";
    }

    private static String AzlwbaMFyARJmC6wPe() {
        return "-gui";
    }

    private static String KDh5sRoWKXfxRSp() {
        return "-gui";
    }
}
