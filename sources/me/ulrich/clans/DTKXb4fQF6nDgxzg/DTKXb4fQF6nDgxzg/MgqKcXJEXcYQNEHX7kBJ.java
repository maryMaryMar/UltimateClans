package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import com.google.common.base.Stopwatch;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/MgqKcXJEXcYQNEHX7kBJ.class */
public class MgqKcXJEXcYQNEHX7kBJ implements ClansCommand {
    private static volatile String pE1GQ56T0ltcv3Pkqb;
    private static volatile String jCeNzOgHyRk1OjsJw6MYbX;
    private static String RGV6Kh7zWcHomI2avGQSl;
    private static final byte[] BtzUkBi2oULtOz9 = {(byte) 237, (byte) 245, (byte) 60, (byte) 95, (byte) 100, (byte) 49, (byte) 17, (byte) 202, (byte) 69, (byte) 59, (byte) 11, (byte) 61, (byte) 112, (byte) 189, (byte) 61, (byte) 216};
    private static final byte[] K0KZpAAZCi4Kkg1oImO6W = {(byte) 26, (byte) 88, (byte) 35, (byte) 42, (byte) 143, (byte) 140, (byte) 178, (byte) 106, (byte) 159, (byte) 180, (byte) 172, (byte) 234, (byte) 84, (byte) 39, (byte) 82, (byte) 11};
    private static final byte[] kiQqcA0bBc5BsSfLKWx7l = {(byte) 26, (byte) 88, (byte) 35, (byte) 42, (byte) 143, (byte) 140, (byte) 178, (byte) 106, (byte) 159, (byte) 180, (byte) 172, (byte) 234, (byte) 84, (byte) 39, (byte) 82, (byte) 11};
    private static final byte[] UL2D0dHqQ5CLsxBf = {(byte) 86, (byte) 16, (byte) 21, (byte) 56, (byte) 165, (byte) 231, (byte) 162, (byte) 4, (byte) 219, (byte) 14, (byte) 145, (byte) 122, (byte) 2, (byte) 180, (byte) 190, (byte) 194, (byte) 207, (byte) 251, (byte) 245, (byte) 100, (byte) 64, (byte) 53, (byte) 161, (byte) 238, (byte) 233, (byte) 220, (byte) 81, (byte) 197, (byte) 26, (byte) 216, (byte) 159, (byte) 138};
    private static final byte[] jHO76Evt1RRvuugYptjVhU = {(byte) 132, (byte) 110, (byte) 70, (byte) 176, (byte) 83, (byte) 89, (byte) 162, (byte) 95, (byte) 185, (byte) 249, (byte) 121, (byte) 71, (byte) 186, (byte) 168, (byte) 14, (byte) 237};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(ULULfsmisUce0eCi())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(QZTxQZhHfVfNEMi());
        if (strArr.length != 0) {
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        try {
            commandSender.sendMessage(U95eNBGmCGnBm3());
            clans.pluginDisableAddons(false);
            clans.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
                clans.loadAddons();
                stopwatchCreateStarted.stop();
                MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.success, Arrays.asList("%time%;" + String.valueOf(stopwatchCreateStarted)));
            }, 30L);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
    }

    private static String tSXLhjeSmuJfsTgL0(byte[] bArr) {
        return "";
    }

    private static String ULULfsmisUce0eCi() {
        return "reloadaddons";
    }

    private static String QZTxQZhHfVfNEMi() {
        return "reloadaddons";
    }

    private static String U95eNBGmCGnBm3() {
        return "WAIT...";
    }
}
