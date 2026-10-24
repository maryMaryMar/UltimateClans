package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/E0Zb3L2jgpdfCu9HPY.class */
public class E0Zb3L2jgpdfCu9HPY implements ClansCommand {
    private static String wyJHtzEzj1JnuoWqD1wErE;
    private static volatile String wtlz548ylka3eR;
    private static String Nm4g6UHon0VdgcSF7K3Qrs;
    private static final byte[] NONpeWcG6iXULMBPcW = {(byte) 41, (byte) 47, (byte) 165, (byte) 247, (byte) 239, (byte) 142, (byte) 167, (byte) 144, (byte) 233, (byte) 132, (byte) 246, (byte) 1, (byte) 124, (byte) 114, (byte) 13, (byte) 197, (byte) 96, (byte) 6, (byte) 230, (byte) 181, (byte) 103, (byte) 22, (byte) 65, (byte) 23, (byte) 21, (byte) 83, (byte) 157, (byte) 191, (byte) 108, (byte) 34, (byte) 79, (byte) 248, (byte) 51, (byte) 38, (byte) 122, (byte) 170, (byte) 198, (byte) 139, (byte) 93, (byte) 7, (byte) 151, (byte) 146, (byte) 112, (byte) 252, (byte) 67, (byte) 206, (byte) 175, (byte) 25};
    private static final byte[] kZabmJI2vrAHrDjactJdQ = {(byte) 62, (byte) 16, (byte) 105, (byte) 155, (byte) 137, (byte) 243, (byte) 118, (byte) 112, (byte) 215, (byte) 255, (byte) 100, (byte) 161, (byte) 86, (byte) 79, (byte) 27, (byte) 249};
    private static final byte[] KQov7pzXJr4YzG = {(byte) 1, (byte) 153, (byte) 210, (byte) 216, (byte) 135, (byte) 208, (byte) 101, (byte) 211, (byte) 190, (byte) 195, (byte) 102, (byte) 140, (byte) 8, (byte) 62, (byte) 0, (byte) 37, (byte) 59, (byte) 107, (byte) 67, (byte) 87, (byte) 83, (byte) 28, (byte) 17, (byte) 114, (byte) 75, (byte) 244, (byte) 14, (byte) 149, (byte) 253, (byte) 143, (byte) 194, (byte) 49, (byte) 98, (byte) 12, (byte) 93, (byte) 197, (byte) 185, (byte) 104, (byte) 210, (byte) 195, (byte) 242, (byte) 19, (byte) 84, (byte) 118, (byte) 193, (byte) 185, (byte) 61, (byte) 9};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        CommandSender commandSender2 = (Player) commandSender;
        int iIntValue = 1;
        try {
            iIntValue = Integer.valueOf(strArr[0]).intValue();
        } catch (Exception e) {
        }
        if (iIntValue < 1) {
            iIntValue = 1;
        }
        try {
            iIntValue = Integer.valueOf(strArr[0]).intValue();
        } catch (Exception e2) {
        }
        if (iIntValue < 1) {
            iIntValue = 1;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ClansCommand> entry : clans.getCommandManager().CDW4Fj1iwdIXEOqWjiJSR().registered().entrySet()) {
            if (clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(entry.getKey()) && new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(commandSender2, entry.getKey(), HzWcJbxBAYzi8Ygwf(), false)) {
                arrayList.add(entry.getKey());
            }
        }
        if (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(SNAATDLMmweM9wVS1pCNU())) {
            Collections.sort(arrayList);
        }
        int i = iIntValue;
        int i2 = clans.getFiles().p31abtwfBag2jhMH6K().getInt(rt9xpPg5Gz5tP7DJG());
        int i3 = i2 * (i - 1);
        int size = i2 * i;
        if (size > arrayList.size()) {
            size = arrayList.size();
        }
        if (i3 > size) {
            i3 = size;
        }
        List listSubList = arrayList.subList(i3, size);
        double dCeil = Math.ceil(((double) arrayList.size()) / ((double) i2));
        if (clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.SEPARER).length() > 1) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.SEPARER));
            MessageUtils.sendText(commandSender, " ");
        }
        MessageUtils.sendText(commandSender2, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER, Arrays.asList("%page%;" + iIntValue, "%pages%;" + ((int) dCeil))));
        if (listSubList.size() < 1) {
            MessageUtils.sendText(commandSender2, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_LIST_EMPTY));
            return true;
        }
        Iterator it = listSubList.iterator();
        while (it.hasNext()) {
            MessageUtils.sendCommandJson(commandSender2, clans.getCommandManager().ZwrsrwOCXRUscW6Q().get((String) it.next()), ClanEnum.MsgUsage.help, null);
        }
        StringBuilder sb = new StringBuilder();
        if (iIntValue > 1 || (arrayList.size() > i2 && iIntValue * i2 < arrayList.size())) {
            MessageUtils.sendText(commandSender, " ");
        }
        if (iIntValue > 1) {
            int i4 = iIntValue - 1;
            if (i4 > ((int) dCeil)) {
                i4 = (int) dCeil;
            }
            sb.append(" ");
            sb.append(clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_PLAYER_PAGINATION_PREV, Arrays.asList("%page%;" + String.valueOf(i4))));
        }
        if (arrayList.size() > i2 && iIntValue * i2 < arrayList.size()) {
            if (iIntValue > 1) {
                sb.append(" ");
                sb.append(clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_PLAYER_PAGINATION_SEPARER));
                sb.append(" ");
            } else {
                sb.append(" ");
            }
            sb.append(clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_PLAYER_PAGINATION_NEXT, Arrays.asList("%page%;" + String.valueOf(iIntValue + 1))));
        }
        MessageUtils.sendText(commandSender, sb.toString());
        if (clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.SEPARER).length() <= 1) {
            return true;
        }
        MessageUtils.sendText(commandSender, " ");
        MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.SEPARER));
        return true;
    }

    private static String z6hXyMMjADGlxRnU(byte[] bArr) {
        return "";
    }

    private static String HzWcJbxBAYzi8Ygwf() {
        return "clan";
    }

    private static String SNAATDLMmweM9wVS1pCNU() {
        return "Config.command.sort_alphabetically";
    }

    private static String rt9xpPg5Gz5tP7DJG() {
        return "Config.command.max_results_per_page";
    }
}
