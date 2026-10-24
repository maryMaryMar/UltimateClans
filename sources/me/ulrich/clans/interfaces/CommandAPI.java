package me.ulrich.clans.interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CommandData_actionbar;
import me.ulrich.clans.data.CommandData_disable;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.data.CommandData_sound;
import me.ulrich.clans.data.CommandData_title;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/CommandAPI.class */
public interface CommandAPI {
    ConcurrentHashMap<String, String> getCommandAliases();

    ConcurrentHashMap<String, String> getMainCommandAliases();

    String replaceMainCmd(String str);

    String replaceCmd(String str);

    void showHelpSubmessage(CommandSender commandSender, CommandData commandData);

    boolean findAliases(String str, String str2);

    String findReturnAliases(String str);

    String findReturnMain(String str);

    String findAliasesByValue(String str);

    ConcurrentHashMap<String, CommandData> getClanCommander();

    ConcurrentHashMap<String, CommandData> getUClanCommander();

    void unRegisterCommand(String str);

    void insertCommand(String str, String str2, String str3, double d, int i, CommandData_show commandData_show, CommandData_title commandData_title, CommandData_actionbar commandData_actionbar, CommandData_sound commandData_sound, HashMap<String, CommandData_show> map, CommandData_disable commandData_disable);

    void registerCommand(String str, ClansCommand clansCommand);

    void sendCommandJson(CommandSender commandSender, CommandData commandData, ClanEnum.MsgUsage msgUsage, List<String> list);

    void sendSubCommandJson(CommandSender commandSender, CommandData commandData, String str, ClanEnum.MsgUsage msgUsage, List<String> list);
}
