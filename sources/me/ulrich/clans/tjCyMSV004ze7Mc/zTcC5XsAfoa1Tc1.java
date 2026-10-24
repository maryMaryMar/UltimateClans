package me.ulrich.clans.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.events.ExtEvent;
import me.ulrich.clans.events.ModuleEvent;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/tjCyMSV004ze7Mc/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 implements Listener {
    private Clans v8qP8fE86HMhvNuYPFjqY;
    private static volatile String LNB3xwBeLPap07gjQdte;
    private static final byte[] BQDYNx7oauYKDO0 = {(byte) 196, (byte) 88, (byte) 254, (byte) 67, (byte) 164, (byte) 148, (byte) 246, (byte) 237, (byte) 176, (byte) 147, (byte) 154, (byte) 176, (byte) 224, (byte) 88, (byte) 162, (byte) 11};
    private static final byte[] HKKIrUCZ2oarAEW = {(byte) 116, (byte) 219, (byte) 89, (byte) 68, (byte) 3, (byte) 41, (byte) 144, (byte) 252, (byte) 124, (byte) 130, (byte) 246, (byte) 109, (byte) 10, (byte) 236, (byte) 0, (byte) 234, (byte) 78, (byte) 26, (byte) 107, (byte) 166, (byte) 92, (byte) 199, (byte) 255, (byte) 100, (byte) 180, (byte) 108, (byte) 226, (byte) 85, (byte) 53, (byte) 83, (byte) 193, (byte) 78, (byte) 207, (byte) 69, (byte) 233, (byte) 217, (byte) 128, (byte) 235, (byte) 154, (byte) 63, (byte) 179, (byte) 247, (byte) 239, (byte) 169, (byte) 39, (byte) 224, (byte) 82, (byte) 131};

    public zTcC5XsAfoa1Tc1(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
        this.v8qP8fE86HMhvNuYPFjqY.getRegistredListeners().add(this);
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ExtEvent extEvent) {
        if (extEvent.getCommandSender() != null) {
            if (extEvent.getStopwatch().isRunning()) {
                extEvent.getStopwatch().stop();
            }
            CommandSender commandSender = extEvent.getCommandSender();
            if ((extEvent.getCommandSender() instanceof Player) && !((Player) extEvent.getCommandSender()).isOnline()) {
                commandSender = Bukkit.getConsoleSender();
            }
            String strOr5N2qIMENemHLg = or5N2qIMENemHLg();
            if (extEvent.getStr() != null && extEvent.getStr().getPluginName() != null) {
                strOr5N2qIMENemHLg = extEvent.getStr().getPluginName();
            }
            MessageUtils.sendText((CommandSender) commandSender, this.v8qP8fE86HMhvNuYPFjqY.getFiles().v8qP8fE86HMhvNuYPFjqY((CommandSender) commandSender).getString(Lang.valueOf("CLAN_REPO_EVENT_" + extEvent.getRepoReturn().toString().toUpperCase()), Arrays.asList("{plugin};" + strOr5N2qIMENemHLg, "%time%;" + String.valueOf(extEvent.getStopwatch()))));
        }
    }

    @EventHandler
    public void v8qP8fE86HMhvNuYPFjqY(ModuleEvent moduleEvent) {
        if (moduleEvent.getCommandSender() != null) {
            if (moduleEvent.getStopwatch().isRunning()) {
                moduleEvent.getStopwatch().stop();
            }
            CommandSender commandSender = moduleEvent.getCommandSender();
            if ((moduleEvent.getCommandSender() instanceof Player) && !((Player) moduleEvent.getCommandSender()).isOnline()) {
                commandSender = Bukkit.getConsoleSender();
            }
            MessageUtils.sendText((CommandSender) commandSender, this.v8qP8fE86HMhvNuYPFjqY.getFiles().v8qP8fE86HMhvNuYPFjqY((CommandSender) commandSender).getString(Lang.valueOf("CLAN_REPO_EVENT_" + moduleEvent.getRepoReturn().toString().toUpperCase()), Arrays.asList("%time%;" + String.valueOf(moduleEvent.getStopwatch()))));
        }
    }

    public Clans v8qP8fE86HMhvNuYPFjqY() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String tO4HVmlhK3Hm6z1b(byte[] bArr) {
        return "";
    }

    private static String or5N2qIMENemHLg() {
        return "NONE";
    }
}
