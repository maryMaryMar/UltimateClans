package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/TZTjwgGMwzxVd5AxjtP.class */
public class TZTjwgGMwzxVd5AxjtP implements ClansCommand {
    private static volatile String AcNhM0rT2ERKSWIG;
    private static String dX2sjdiNENh8kSH;
    private static volatile String CeHrCNL8alIGBxFX;
    private static final byte[] v0TKBYfPTaUXDxyuZvsJuD = {(byte) 212, (byte) 103, (byte) 157, (byte) 49, (byte) 39, (byte) 45, (byte) 108, (byte) 198, (byte) 149, (byte) 63, (byte) 12, (byte) 190, (byte) 85, (byte) 208, (byte) 181, (byte) 56, (byte) 184, (byte) 138, (byte) 125, (byte) 232, (byte) 229, (byte) 90, (byte) 34, (byte) 101, (byte) 246, (byte) 63, (byte) 113, (byte) 109, (byte) 10, (byte) 127, (byte) 196, (byte) 89, (byte) 73, (byte) 176, (byte) 26, (byte) 36, (byte) 238, (byte) 29, (byte) 61, (byte) 63, (byte) 56, (byte) 102, (byte) 137, (byte) 183, (byte) 207, (byte) 238, (byte) 182, (byte) 251};
    private static final byte[] oI0c1bYpMwNn1NWwLDGHbD = {(byte) 225, (byte) 53, (byte) 227, (byte) 15, (byte) 24, (byte) 195, (byte) 84, (byte) 222, (byte) 116, (byte) 254, (byte) 7, (byte) 189, (byte) 60, (byte) 107, (byte) 253, (byte) 252};
    private static final byte[] Wk2qFVqdJpOkjQ = {(byte) 238, (byte) 222, (byte) 0, (byte) 114, (byte) 59, (byte) 54, (byte) 109, (byte) 61, (byte) 215, (byte) 58, (byte) 185, (byte) 252, (byte) 204, (byte) 16, (byte) 80, (byte) 204, (byte) 88, (byte) 23, (byte) 196, (byte) 252, (byte) 226, (byte) 92, (byte) 100, (byte) 80, (byte) 89, (byte) 131, (byte) 1, (byte) 64, (byte) 130, (byte) 76, (byte) 255, (byte) 70};
    private static final byte[] QYm3Q0mS7vJemiDf = {(byte) 218, (byte) 37, (byte) 246, (byte) 36, (byte) 69, (byte) 26, (byte) 11, (byte) 38, (byte) 207, (byte) 139, (byte) 235, (byte) 69, (byte) 132, (byte) 133, (byte) 32, (byte) 92};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!(commandSender instanceof Player)) {
        }
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
        for (Map.Entry<String, ClansCommand> entry : clans.getCommandManager().zJnaNCVQSgEShq().registered().entrySet()) {
            if (clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(entry.getKey()) && new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(commandSender, entry.getKey(), o0FS3gW1Qp8rF4cDQM38Fx(), false)) {
                arrayList.add(entry.getKey());
            }
        }
        if (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(Ee3vGQdgAdq5yTrYJ())) {
            Collections.sort(arrayList);
        }
        int i = iIntValue;
        int i2 = clans.getFiles().p31abtwfBag2jhMH6K().getInt(AFP2lltBnu2XopdA());
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
        MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER, Arrays.asList("%page%;" + iIntValue, "%pages%;" + ((int) dCeil))));
        if (listSubList.size() < 1) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_LIST_EMPTY));
            return true;
        }
        Iterator it = listSubList.iterator();
        while (it.hasNext()) {
            MessageUtils.sendCommandJson(commandSender, clans.getCommandManager().iZTqZaRK5UGoe0Z().get((String) it.next()), ClanEnum.MsgUsage.help, null);
        }
        if (!(commandSender instanceof Player)) {
            return true;
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
            sb.append(clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_ADMIN_PAGINATION_PREV, Arrays.asList("%page%;" + String.valueOf(i4))));
        }
        if (arrayList.size() > i2 && iIntValue * i2 < arrayList.size()) {
            if (iIntValue > 1) {
                sb.append(" ");
                sb.append(clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_ADMIN_PAGINATION_SEPARER));
                sb.append(" ");
            } else {
                sb.append(" ");
            }
            sb.append(clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_ADMIN_PAGINATION_NEXT, Arrays.asList("%page%;" + String.valueOf(iIntValue + 1))));
        }
        MessageUtils.sendText(commandSender, sb.toString());
        if (clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.SEPARER).length() <= 1) {
            return true;
        }
        MessageUtils.sendText(commandSender, " ");
        MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.SEPARER));
        return true;
    }

    private static String ifPEbCencvavwL(byte[] bArr) {
        return "";
    }

    private static String o0FS3gW1Qp8rF4cDQM38Fx() {
        return "uclan";
    }

    private static String Ee3vGQdgAdq5yTrYJ() {
        return "Config.command.sort_alphabetically";
    }

    private static String AFP2lltBnu2XopdA() {
        return "Config.command.max_results_per_page";
    }
}
