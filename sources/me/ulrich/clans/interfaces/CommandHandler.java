package me.ulrich.clans.interfaces;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/interfaces/CommandHandler.class */
public abstract class CommandHandler implements CommandExecutor {
    protected final Map<String, ClansCommand> registeredCommands = new HashMap();
    protected final Map<String, CommandHandler> registeredHandlers = new HashMap();
    protected Clans plugin;
    protected String cmd;

    public CommandHandler(Clans clans, String str) {
        this.plugin = clans;
        this.cmd = str;
    }

    public void registerCommand(String str, ClansCommand clansCommand) {
        if (this.registeredCommands.containsKey(str) && this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.debug_errors")) {
            this.plugin.getLogger().warning("The alias command '" + str + "' appears repeated. ");
        }
        this.registeredCommands.put(str, clansCommand);
    }

    public Map<String, ClansCommand> registered() {
        return this.registeredCommands;
    }

    public void unregisterCommand(String str) {
        this.registeredCommands.remove(str);
    }

    public void registerHandler(CommandHandler commandHandler) {
        if (this.registeredHandlers.containsKey(commandHandler.getCommand())) {
            this.plugin.getLogger().warning("Replacing existing handler for: " + commandHandler.getCommand());
        }
        this.registeredHandlers.put(commandHandler.getCommand(), commandHandler);
    }

    public void unregisterHandler(String str) {
        this.registeredHandlers.remove(str);
    }

    public boolean onCommand(CommandSender commandSender, Command command, String str, String[] strArr) {
        EnumMap<Flag, String> enumMap = new EnumMap<>(Flag.class);
        if (this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender) == null) {
            return false;
        }
        enumMap.put(Flag.TAG, this.plugin.getTagpl());
        if (strArr.length == 0) {
            return noArgs(commandSender, command, str, enumMap);
        }
        String lowerCase = strArr[0].toLowerCase();
        CommandHandler commandHandler = this.registeredHandlers.get(lowerCase);
        if (commandHandler != null) {
            return commandHandler.onCommand(commandSender, command, str, shortenArgs(strArr));
        }
        ClansCommand clansCommand = this.registeredCommands.get(lowerCase);
        if (clansCommand == null) {
            return unknownCommand(commandSender, command, str, strArr, enumMap);
        }
        boolean zExecute = true;
        try {
            zExecute = clansCommand.execute(this.plugin, commandSender, command, str, shortenArgs(strArr), enumMap);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            MessageUtils.sendText(commandSender, this.plugin.getTagpl() + "<red>Missing parameters.");
        }
        return zExecute;
    }

    public abstract boolean noArgs(CommandSender commandSender, Command command, String str, EnumMap<Flag, String> enumMap);

    public abstract boolean unknownCommand(CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap);

    protected String[] shortenArgs(String[] strArr) {
        if (strArr.length == 0) {
            return strArr;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 1; i < strArr.length; i++) {
            arrayList.add(strArr[i]);
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public String getCommand() {
        return this.cmd;
    }
}
