package me.ulrich.clans.api;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_sound;
import me.ulrich.clans.data.CommandData_title;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.interfaces.CommandAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/api/CommandAPIManager.class */
public class CommandAPIManager implements CommandAPI {
    private Clans plugin;

    public CommandAPIManager(Clans clans) {
        this.plugin = clans;
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public ConcurrentHashMap<String, CommandData> getClanCommander() {
        return this.plugin.getCommandManager().ZwrsrwOCXRUscW6Q();
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public ConcurrentHashMap<String, CommandData> getUClanCommander() {
        return this.plugin.getCommandManager().iZTqZaRK5UGoe0Z();
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public void unRegisterCommand(String str) {
        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(str);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public void registerCommand(String str, ClansCommand clansCommand) {
        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(str, clansCommand);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public void insertCommand(String str, String str2, String str3, double d, int i, CommandData_show commandData_show, CommandData_title commandData_title, CommandData_actionbar commandData_actionbar, CommandData_sound commandData_sound, HashMap<String, CommandData_show> map, CommandData_disable commandData_disable) {
        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(str, str2, str3, d, i, commandData_show, commandData_title, commandData_actionbar, commandData_sound, map, commandData_disable);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public ConcurrentHashMap<String, String> getCommandAliases() {
        return this.plugin.getCommandManager().b4i2FbOkaKeg91LiAe6l();
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public ConcurrentHashMap<String, String> getMainCommandAliases() {
        return this.plugin.getCommandManager().p31abtwfBag2jhMH6K();
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public String replaceMainCmd(String str) {
        return this.plugin.getCommandManager().v8qP8fE86HMhvNuYPFjqY(str);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public String replaceCmd(String str) {
        return this.plugin.getCommandManager().jBUuLP0sWwaPyPOmogdX7l(str);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public void showHelpSubmessage(CommandSender commandSender, CommandData commandData) {
        this.plugin.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public boolean findAliases(String str, String str2) {
        return this.plugin.getCommandManager().v8qP8fE86HMhvNuYPFjqY(str, str2);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public String findReturnAliases(String str) {
        return this.plugin.getCommandManager().ZwrsrwOCXRUscW6Q(str);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public String findReturnMain(String str) {
        return this.plugin.getCommandManager().iZTqZaRK5UGoe0Z(str);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public String findAliasesByValue(String str) {
        return this.plugin.getCommandManager().xtOheRiObl4QeAl(str);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public void sendCommandJson(CommandSender commandSender, CommandData commandData, ClanEnum.MsgUsage msgUsage, List<String> list) {
        MessageUtils.sendCommandJson(commandSender, commandData, msgUsage, list);
    }

    @Override // me.ulrich.clans.interfaces.CommandAPI
    public void sendSubCommandJson(CommandSender commandSender, CommandData commandData, String str, ClanEnum.MsgUsage msgUsage, List<String> list) {
        MessageUtils.sendSubCommandJson(commandSender, commandData, str, msgUsage, list);
    }
}
