package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import com.google.common.base.Stopwatch;
import java.util.Arrays;
import java.util.EnumMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.events.ClanPluginEvent;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/t5552Hwi8n9ivJHRmI.class */
public class t5552Hwi8n9ivJHRmI implements ClansCommand {
    private static volatile String JQIAzGhWf2mVKoZN;
    private static volatile String QslfLL7iEBbDmNfIk;
    private static String W0KRxbqIB69vzLZq;
    private static String xnVLZkJ62CfZ9UWstn;
    private static volatile String OYW53X09uyAy4AhwseJ98B;
    private static String csFrhcvVMxzf6tLjTOTss;
    private static String V7RfR4udS9lgmf;
    private static volatile String ZbffbZgEZx9xANJnNCD;
    private static String nTCozCjQjYzmL945;
    private static String VHekkQ1NA96B2nMjh;
    private static volatile String E9H0As8pj9l2VVk9CSSSY4;
    private static volatile String ZKDXbPYW9DuxfU;
    private static volatile String r4we0FFZgJswHsnGrCp;
    private static volatile String tYOwX29teEAJIyakWZ;
    private static String MAgA7kuPKITia2jA;
    private static String AjBF2y7itLjdrsPPirY;
    private static String ljoFcB01xeoPgtP5r;
    private static volatile String OEhjfO8aY9DAXZg;
    private static volatile String Pz2G2pAntZa2KSU;
    private static final byte[] RXlSKMcnH4SALekXTzaUnh = {(byte) 166, (byte) 191, (byte) 117, (byte) 145, (byte) 131, (byte) 55, (byte) 220, (byte) 56, (byte) 154, (byte) 50, (byte) 220, (byte) 8, (byte) 113, (byte) 7, (byte) 39, (byte) 223, (byte) 38, (byte) 7, (byte) 164, (byte) 79, (byte) 227, (byte) 82, (byte) 153, (byte) 204, (byte) 88, (byte) 31, (byte) 51, (byte) 146, (byte) 15, (byte) 67, (byte) 104, (byte) 198, (byte) 242, (byte) 213, (byte) 150, (byte) 114, (byte) 109, (byte) 99, (byte) 150, (byte) 200, (byte) 30, (byte) 8, (byte) 26, (byte) 83, (byte) 124, (byte) 188, (byte) 224, (byte) 169, (byte) 173, (byte) 98, (byte) 32, (byte) 69, (byte) 99, (byte) 124, (byte) 46, (byte) 4, (byte) 62, (byte) 221, (byte) 120, (byte) 97, (byte) 135, (byte) 248, (byte) 181, (byte) 101, (byte) 197, (byte) 129, (byte) 166, (byte) 160, (byte) 150, (byte) 159, (byte) 248, (byte) 138, (byte) 193, (byte) 28, (byte) 212, (byte) 254, (byte) 120, (byte) 151, (byte) 202, (byte) 127, (byte) 96, (byte) 210, (byte) 45, (byte) 253, (byte) 19, (byte) 74, (byte) 129, (byte) 55, (byte) 58, (byte) 29, (byte) 10, (byte) 92, (byte) 67, (byte) 10, (byte) 183, (byte) 243, (byte) 56, (byte) 242, (byte) 17, (byte) 47, (byte) 167, (byte) 243, (byte) 241, (byte) 98, (byte) 188, (byte) 233, (byte) 126, (byte) 217, (byte) 70, (byte) 217, (byte) 20, (byte) 144, (byte) 39, (byte) 178, (byte) 224, (byte) 194, (byte) 55, (byte) 145, (byte) 144, (byte) 201, (byte) 10, (byte) 148, (byte) 64, (byte) 182, (byte) 161, (byte) 110, (byte) 83, (byte) 161};
    private static final byte[] rqnmiap9ERxFHLSH4BL = {(byte) 174, (byte) 223, (byte) 141, (byte) 63, (byte) 136, (byte) 217, (byte) 226, (byte) 180, (byte) 92, (byte) 148, (byte) 126, (byte) 75, (byte) 248, (byte) 41, (byte) 149, (byte) 167, (byte) 147, (byte) 192, (byte) 247, (byte) 108, (byte) 125, (byte) 1, (byte) 235, (byte) 98, (byte) 23, (byte) 237, (byte) 123, (byte) 14, (byte) 213, (byte) 24, (byte) 242, (byte) 10, (byte) 225, (byte) 242, (byte) 22, (byte) 82, (byte) 1, (byte) 41, (byte) 141, (byte) 162, (byte) 208, (byte) 136, (byte) 97, (byte) 56, (byte) 24, (byte) 218, (byte) 126, (byte) 133, (byte) 240, (byte) 245, (byte) 107, (byte) 248, (byte) 79, (byte) 147, (byte) 30, (byte) 5, (byte) 19, (byte) 157, (byte) 76, (byte) 91, (byte) 98, (byte) 220, (byte) 114, (byte) 62, (byte) 244, (byte) 213, (byte) 233, (byte) 83, (byte) 67, (byte) 25, (byte) 237, (byte) 139, (byte) 236, (byte) 240, (byte) 79, (byte) 58, (byte) 26, (byte) 173, (byte) 219, (byte) 140, (byte) 104, (byte) 240, (byte) 192, (byte) 31, (byte) 86, (byte) 174, (byte) 221, (byte) 32, (byte) 249, (byte) 204, (byte) 111, (byte) 189, (byte) 28, (byte) 101, (byte) 185, (byte) 255};
    private static final byte[] VNDA0O2zWScnjB8qO8L0Yj = {(byte) 136, (byte) 123, (byte) 255, (byte) 199, (byte) 165, (byte) 24, (byte) 157, (byte) 245, (byte) 19, (byte) 204, (byte) 215, (byte) 173, (byte) 133, (byte) 66, (byte) 137, (byte) 223};
    private static final byte[] gKqFUO8mrIJOC39Y = {(byte) 209, (byte) 161, (byte) 37, (byte) 89, (byte) 21, (byte) 117, (byte) 203, (byte) 206, (byte) 15, (byte) 200, (byte) 103, (byte) 168, (byte) 151, (byte) 30, (byte) 103, (byte) 140};
    private static final byte[] Lys2ATQOpbg1wRt5ismbC = {(byte) 209, (byte) 161, (byte) 37, (byte) 89, (byte) 21, (byte) 117, (byte) 203, (byte) 206, (byte) 15, (byte) 200, (byte) 103, (byte) 168, (byte) 151, (byte) 30, (byte) 103, (byte) 140};
    private static final byte[] cHBpCzAFXYekETbOZ = {(byte) 166, (byte) 191, (byte) 117, (byte) 145, (byte) 131, (byte) 55, (byte) 220, (byte) 56, (byte) 154, (byte) 50, (byte) 220, (byte) 8, (byte) 113, (byte) 7, (byte) 39, (byte) 223, (byte) 38, (byte) 7, (byte) 164, (byte) 79, (byte) 227, (byte) 82, (byte) 153, (byte) 204, (byte) 88, (byte) 31, (byte) 51, (byte) 146, (byte) 15, (byte) 67, (byte) 104, (byte) 198, (byte) 242, (byte) 213, (byte) 150, (byte) 114, (byte) 109, (byte) 99, (byte) 150, (byte) 200, (byte) 30, (byte) 8, (byte) 26, (byte) 83, (byte) 124, (byte) 188, (byte) 224, (byte) 169, (byte) 173, (byte) 98, (byte) 32, (byte) 69, (byte) 99, (byte) 124, (byte) 46, (byte) 4, (byte) 62, (byte) 221, (byte) 120, (byte) 97, (byte) 135, (byte) 248, (byte) 181, (byte) 101, (byte) 197, (byte) 129, (byte) 166, (byte) 160, (byte) 150, (byte) 159, (byte) 248, (byte) 138, (byte) 193, (byte) 28, (byte) 212, (byte) 254, (byte) 120, (byte) 151, (byte) 202, (byte) 127, (byte) 96, (byte) 210, (byte) 45, (byte) 253, (byte) 19, (byte) 74, (byte) 129, (byte) 55, (byte) 58, (byte) 29, (byte) 10, (byte) 92, (byte) 67, (byte) 10, (byte) 183, (byte) 243, (byte) 56, (byte) 242, (byte) 17, (byte) 47, (byte) 167, (byte) 243, (byte) 241, (byte) 98, (byte) 188, (byte) 233, (byte) 126, (byte) 217, (byte) 70, (byte) 217, (byte) 20, (byte) 144, (byte) 39, (byte) 178, (byte) 224, (byte) 194, (byte) 55, (byte) 145, (byte) 144, (byte) 201, (byte) 10, (byte) 148, (byte) 64, (byte) 182, (byte) 161, (byte) 110, (byte) 83, (byte) 161};
    private static final byte[] Rg0Xito3yNnK1KQK9cag = {(byte) 174, (byte) 223, (byte) 141, (byte) 63, (byte) 136, (byte) 217, (byte) 226, (byte) 180, (byte) 92, (byte) 148, (byte) 126, (byte) 75, (byte) 248, (byte) 41, (byte) 149, (byte) 167, (byte) 147, (byte) 192, (byte) 247, (byte) 108, (byte) 125, (byte) 1, (byte) 235, (byte) 98, (byte) 23, (byte) 237, (byte) 123, (byte) 14, (byte) 213, (byte) 24, (byte) 242, (byte) 10, (byte) 225, (byte) 242, (byte) 22, (byte) 82, (byte) 1, (byte) 41, (byte) 141, (byte) 162, (byte) 208, (byte) 136, (byte) 97, (byte) 56, (byte) 24, (byte) 218, (byte) 126, (byte) 133, (byte) 240, (byte) 245, (byte) 107, (byte) 248, (byte) 79, (byte) 147, (byte) 30, (byte) 5, (byte) 19, (byte) 157, (byte) 76, (byte) 91, (byte) 98, (byte) 220, (byte) 114, (byte) 62, (byte) 244, (byte) 213, (byte) 233, (byte) 83, (byte) 67, (byte) 25, (byte) 237, (byte) 139, (byte) 236, (byte) 240, (byte) 79, (byte) 58, (byte) 26, (byte) 173, (byte) 219, (byte) 140, (byte) 104, (byte) 240, (byte) 192, (byte) 31, (byte) 86, (byte) 174, (byte) 221, (byte) 32, (byte) 249, (byte) 204, (byte) 111, (byte) 189, (byte) 28, (byte) 101, (byte) 185, (byte) 255};
    private static final byte[] jQOqILuWytw48WDp = {(byte) 41, (byte) 108, (byte) 75, (byte) 7, (byte) 170, (byte) 220, (byte) 72, (byte) 210, (byte) 13, (byte) 43, (byte) 36, (byte) 149, (byte) 149, (byte) 83, (byte) 54, (byte) 192};
    private static final byte[] ao0Whq72d6i6vk = {(byte) 166, (byte) 191, (byte) 117, (byte) 145, (byte) 131, (byte) 55, (byte) 220, (byte) 56, (byte) 154, (byte) 50, (byte) 220, (byte) 8, (byte) 113, (byte) 7, (byte) 39, (byte) 223, (byte) 38, (byte) 7, (byte) 164, (byte) 79, (byte) 227, (byte) 82, (byte) 153, (byte) 204, (byte) 88, (byte) 31, (byte) 51, (byte) 146, (byte) 15, (byte) 67, (byte) 104, (byte) 198, (byte) 242, (byte) 213, (byte) 150, (byte) 114, (byte) 109, (byte) 99, (byte) 150, (byte) 200, (byte) 30, (byte) 8, (byte) 26, (byte) 83, (byte) 124, (byte) 188, (byte) 224, (byte) 169, (byte) 173, (byte) 98, (byte) 32, (byte) 69, (byte) 99, (byte) 124, (byte) 46, (byte) 4, (byte) 62, (byte) 221, (byte) 120, (byte) 97, (byte) 135, (byte) 248, (byte) 181, (byte) 101, (byte) 197, (byte) 129, (byte) 166, (byte) 160, (byte) 150, (byte) 159, (byte) 248, (byte) 138, (byte) 193, (byte) 28, (byte) 212, (byte) 254, (byte) 120, (byte) 151, (byte) 202, (byte) 127, (byte) 96, (byte) 210, (byte) 45, (byte) 253, (byte) 19, (byte) 74, (byte) 129, (byte) 55, (byte) 58, (byte) 29, (byte) 10, (byte) 92, (byte) 67, (byte) 10, (byte) 183, (byte) 243, (byte) 56, (byte) 242, (byte) 17, (byte) 47, (byte) 167, (byte) 243, (byte) 241, (byte) 98, (byte) 188, (byte) 233, (byte) 126, (byte) 217, (byte) 70, (byte) 217, (byte) 20, (byte) 144, (byte) 39, (byte) 178, (byte) 224, (byte) 194, (byte) 55, (byte) 145, (byte) 144, (byte) 201, (byte) 10, (byte) 148, (byte) 64, (byte) 182, (byte) 161, (byte) 110, (byte) 83, (byte) 161};
    private static final byte[] U5keRW3ncKHkzRC = {(byte) 118, (byte) 162, (byte) 181, (byte) 30, (byte) 194, (byte) 141, (byte) 206, (byte) 87, (byte) 57, (byte) 181, (byte) 63, (byte) 90, (byte) 154, (byte) 225, (byte) 45, (byte) 219};
    private static final byte[] ApiHFmly5AzLQnBw = {(byte) 136, (byte) 123, (byte) 255, (byte) 199, (byte) 165, (byte) 24, (byte) 157, (byte) 245, (byte) 19, (byte) 204, (byte) 215, (byte) 173, (byte) 133, (byte) 66, (byte) 137, (byte) 223};
    private static final byte[] JneLv6roz1bzkfTB = {(byte) 174, (byte) 223, (byte) 141, (byte) 63, (byte) 136, (byte) 217, (byte) 226, (byte) 180, (byte) 92, (byte) 148, (byte) 126, (byte) 75, (byte) 248, (byte) 41, (byte) 149, (byte) 167, (byte) 175, (byte) 149, (byte) 249, (byte) 82, (byte) 118, (byte) 199, (byte) 190, (byte) 109, (byte) 238, (byte) 175, (byte) 229, (byte) 236, (byte) 166, (byte) 243, (byte) 170, (byte) 88, (byte) 122, (byte) 99, (byte) 135, (byte) 54, (byte) 33, (byte) 193, (byte) 7, (byte) 93, (byte) 166, (byte) 250, (byte) 167, (byte) 173, (byte) 8, (byte) 90, (byte) 28, (byte) 124, (byte) 1, (byte) 191, (byte) 62, (byte) 132, (byte) 231, (byte) 206, (byte) 134, (byte) 177, (byte) 175, (byte) 13, (byte) 29, (byte) 123, (byte) 226, (byte) 133, (byte) 119, (byte) 129, (byte) 255, (byte) 126, (byte) 250, (byte) 209, (byte) 39, (byte) 151, (byte) 166, (byte) 150, (byte) 172, (byte) 219, (byte) 2, (byte) 126, (byte) 140, (byte) 122, (byte) 216, (byte) 157};
    private static final byte[] iZcRO1w5NrZjDrs0oW = {(byte) 136, (byte) 123, (byte) 255, (byte) 199, (byte) 165, (byte) 24, (byte) 157, (byte) 245, (byte) 19, (byte) 204, (byte) 215, (byte) 173, (byte) 133, (byte) 66, (byte) 137, (byte) 223};
    private static final byte[] PaMxGIzN8103W1 = {(byte) 11, (byte) 84, (byte) 157, (byte) 150, (byte) 49, (byte) 219, (byte) 22, (byte) 78, (byte) 102, (byte) 131, (byte) 80, (byte) 241, (byte) 179, (byte) 57, (byte) 42, (byte) 236, (byte) 108, (byte) 9, (byte) 107, (byte) 210, (byte) 94, (byte) 187, (byte) 213, (byte) 87, (byte) 171, (byte) 8, (byte) 133, (byte) 68, (byte) 217, (byte) 84, (byte) 137, (byte) 117};
    private static final byte[] sr5VW04l6hLttloL = {(byte) 142, (byte) 81, (byte) 115, (byte) 91, (byte) 8, (byte) 222, (byte) 97, (byte) 169, (byte) 151, (byte) 4, (byte) 4, (byte) 25, (byte) 12, (byte) 144, (byte) 132, (byte) 219};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (CooldownAPI.isInCooldown(clans.getPluginUUID(), uJ8JP7wuemRlBcetjv())) {
            commandSender.sendMessage(new String[0]);
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', qro9L6pmw5T06Mqw2m()));
            return true;
        }
        Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(IFywdxFvIlBJpcPSkqID())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(Fzb1k5WcSwXmR4j());
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        if (str2.equalsIgnoreCase(CMyAiZGkTFA1gnDtQ7jxo()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(YApwNITDU75DtfBhyhI(), str2)) {
            if (strArr.length > 1) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            try {
                new CooldownAPI(clans.getPluginUUID(), DT2LmTUqm93wy8AKDl(), 4).start();
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', rGVefT1M5cubrUTt3F()));
                commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', e0IUPHbgNs7h9gj1N3CM()));
                clans.pluginDisable(false);
                clans.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
                    clans.pluginEnable();
                    stopwatchCreateStarted.stop();
                    MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("%time%;" + String.valueOf(stopwatchCreateStarted)));
                }, 30L);
                return true;
            } catch (Exception e) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(FTt9C0J50p4i5fY8w4()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(r3htRXDt3e6D5D09sFP(), str2)) {
            if (strArr.length > 1) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            clans.setLoaded(false);
            new CooldownAPI(clans.getPluginUUID(), VGalvxwB4iZAfs0di(), 4).start();
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', UTPCAi7buJZQJWN2vTB()));
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', T8hujRqncUGg18Is()));
            clans.pluginDisableAddons(true);
            clans.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
                clans.loadAddons();
                Bukkit.getPluginManager().callEvent(new ClanPluginEvent(true, true));
                clans.setLoaded(true);
                stopwatchCreateStarted.stop();
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("%time%;" + String.valueOf(stopwatchCreateStarted)));
            }, 30L);
            return true;
        }
        if (!str2.equalsIgnoreCase(U8i2LkU2zq9F9h7T()) && !clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(oCHBHz1VCFyd6QNZEsc5o(), str2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (strArr.length > 1) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        clans.setLoaded(false);
        new CooldownAPI(clans.getPluginUUID(), vzB1lg0bXKaZqA8qcG(), 4).start();
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', f3qZ1cebaLrEfJwbgFh3t()));
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', afZP5swuFU5VC6RF5fVF()));
        clans.getFiles().qCr0jwvuDANuhNNe9InzM1();
        clans.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
            clans.getFiles().v8qP8fE86HMhvNuYPFjqY();
            clans.getFiles().ZwrsrwOCXRUscW6Q();
            clans.setLoaded(true);
            stopwatchCreateStarted.stop();
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("%time%;" + String.valueOf(stopwatchCreateStarted)));
        }, 30L);
        return true;
    }

    private static String uJ8JP7wuemRlBcetjv() {
        return "reload";
    }

    private static String qro9L6pmw5T06Mqw2m() {
        return "&6&lU&9&lClans &7| &cThe plugin is already being reloaded, wait...";
    }

    private static String IFywdxFvIlBJpcPSkqID() {
        return "reload";
    }

    private static String Fzb1k5WcSwXmR4j() {
        return "reload";
    }

    private static String CMyAiZGkTFA1gnDtQ7jxo() {
        return "all";
    }

    private static String YApwNITDU75DtfBhyhI() {
        return "all";
    }

    private static String DT2LmTUqm93wy8AKDl() {
        return "reload";
    }

    private static String rGVefT1M5cubrUTt3F() {
        return "&6&lU&9&lClans &7| &cPlease wait, the plugin is restarting and this may take a few seconds.";
    }

    private static String e0IUPHbgNs7h9gj1N3CM() {
        return " &7- Reloading a working plugin can cause delays and this can cause instability for users who are using the plugin.";
    }

    private static String FTt9C0J50p4i5fY8w4() {
        return "addons";
    }

    private static String r3htRXDt3e6D5D09sFP() {
        return "addons";
    }

    private static String VGalvxwB4iZAfs0di() {
        return "reload";
    }

    private static String UTPCAi7buJZQJWN2vTB() {
        return "&6&lU&9&lClans &7| &cPlease wait, the plugin is restarting and this may take a few seconds.";
    }

    private static String T8hujRqncUGg18Is() {
        return " &7- Reloading a working plugin can cause delays and this can cause instability for users who are using the plugin.";
    }

    private static String U8i2LkU2zq9F9h7T() {
        return "configurations";
    }

    private static String oCHBHz1VCFyd6QNZEsc5o() {
        return "configurations";
    }

    private static String vzB1lg0bXKaZqA8qcG() {
        return "reload";
    }

    private static String f3qZ1cebaLrEfJwbgFh3t() {
        return "&6&lU&9&lClans &7| &cPlease wait, the plugin is restarting and this may take a few seconds.";
    }

    private static String afZP5swuFU5VC6RF5fVF() {
        return " &7- Reloading a working plugin can cause delays and this can cause instability for users who are using the plugin.";
    }
}
