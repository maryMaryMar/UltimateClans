package me.module.discord.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/reflect/AbstractCommand.class */
public abstract class AbstractCommand implements CommandExecutor, TabCompleter {
    protected final String command;
    protected final String description;
    protected final List<String> alias;
    protected final String usage;
    protected final String permMessage;
    protected final Plugin plugin;
    protected String permission;
    protected static CommandMap cmap;
    private static CommandMap commandMap = getCommandMap();
    private static Field knownCommands = getKnownCommands();
    private static boolean loaded = false;
    private static List<AbstractCommand> list = new ArrayList();

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/reflect/AbstractCommand$PluginReflectCommand.class */
    private class PluginReflectCommand extends ReflectCommand implements PluginIdentifiableCommand {
        protected Plugin plugin;

        protected PluginReflectCommand(String str, Plugin plugin) {
            super(str);
            this.plugin = plugin;
        }

        public Plugin getPlugin() {
            return this.plugin;
        }
    }

    /* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/reflect/AbstractCommand$ReflectCommand.class */
    private class ReflectCommand extends Command {
        private AbstractCommand exe;

        protected ReflectCommand(String str) {
            super(str);
            this.exe = null;
        }

        public void setExecutor(AbstractCommand abstractCommand) {
            this.exe = abstractCommand;
        }

        public boolean execute(CommandSender commandSender, String str, String[] strArr) {
            if (this.exe == null) {
                return false;
            }
            this.exe.onCommand(commandSender, this, str, strArr);
            return false;
        }

        public List<String> tabComplete(CommandSender commandSender, String str, String[] strArr) {
            List<String> listOnTabComplete = this.exe.onTabComplete(commandSender, this, str, strArr);
            return listOnTabComplete != null ? listOnTabComplete : super.tabComplete(commandSender, str, strArr);
        }
    }

    public AbstractCommand(String str) {
        this(str, null, null, null, null, null);
    }

    public AbstractCommand(String str, String str2) {
        this(str, str2, null, null, null, null);
    }

    public AbstractCommand(String str, String str2, String str3) {
        this(str, str2, str3, null, null, null);
    }

    public AbstractCommand(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, null, null);
    }

    public AbstractCommand(String str, String str2, String str3, List<String> list2) {
        this(str, str2, str3, null, list2, null);
    }

    public AbstractCommand(String str, String str2, String str3, String str4, List<String> list2) {
        this(str, str2, str3, str4, list2, null);
    }

    public AbstractCommand(String str, String str2, String str3, String str4, List<String> list2, Plugin plugin) {
        this.command = str.toLowerCase();
        this.usage = str2;
        this.description = str3;
        this.permMessage = str4;
        this.alias = list2;
        this.plugin = plugin;
    }

    public String getCommand() {
        return this.command;
    }

    public static void enable() {
        loaded = true;
        Iterator<AbstractCommand> it = list.iterator();
        while (it.hasNext()) {
            it.next().register();
        }
        list.clear();
    }

    public static void removePluginCommands(Plugin plugin) {
        try {
            Map map = (Map) knownCommands.get(commandMap);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry entry : map.entrySet()) {
                PluginIdentifiableCommand pluginIdentifiableCommand = (Command) entry.getValue();
                if (pluginIdentifiableCommand != null && (pluginIdentifiableCommand instanceof PluginIdentifiableCommand) && pluginIdentifiableCommand.getPlugin() == plugin) {
                    arrayList.add((String) entry.getKey());
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                map.remove((String) it.next());
            }
            knownCommands.set(commandMap, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void register() {
        if (loaded) {
            reg();
        } else {
            list.add(this);
        }
    }

    protected void reg() {
        ReflectCommand reflectCommand = this.plugin == null ? new ReflectCommand(this.command) : new PluginReflectCommand(this.command, this.plugin);
        if (this.alias != null) {
            reflectCommand.setAliases(this.alias);
        }
        if (this.description != null) {
            reflectCommand.setDescription(this.description);
        }
        if (this.usage != null) {
            reflectCommand.setUsage(this.usage);
        }
        if (this.permMessage != null) {
            reflectCommand.setPermissionMessage(this.permMessage);
        }
        if (this.permission != null) {
            reflectCommand.setPermission(this.permission);
        }
        try {
            Map map = (Map) knownCommands.get(commandMap);
            map.remove(this.command);
            knownCommands.set(commandMap, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        commandMap.register(this.command, this.plugin == null ? "" : this.plugin.getName(), reflectCommand);
        reflectCommand.setExecutor(this);
    }

    protected static Field getKnownCommands() {
        try {
            Class superclass = commandMap.getClass();
            switch (superclass.getSimpleName()) {
                case "CraftCommandMap":
                case "FakeSimpleCommandMap":
                    superclass = superclass.getSuperclass();
                    break;
            }
            return NMSUtils.getField(superclass, "knownCommands");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    protected static CommandMap getCommandMap() {
        if (cmap != null) {
            return cmap;
        }
        try {
            Field declaredField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
            declaredField.setAccessible(true);
            cmap = (CommandMap) declaredField.get(Bukkit.getServer());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cmap;
    }

    public static void removeCommandOfClass(Class<? extends Command> cls) {
        try {
            Map map = (Map) knownCommands.get(commandMap);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (cls.isAssignableFrom(((Command) ((Map.Entry) it.next()).getValue()).getClass())) {
                    it.remove();
                }
            }
            knownCommands.set(commandMap, map);
        } catch (Exception e) {
        }
    }

    public static void removeCommand(String str) {
        try {
            Map map = (Map) knownCommands.get(commandMap);
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (((String) ((Map.Entry) it.next()).getKey()).equals(str)) {
                    it.remove();
                }
            }
            knownCommands.set(commandMap, map);
        } catch (Exception e) {
        }
    }

    public boolean isPlayer(CommandSender commandSender) {
        return commandSender instanceof Player;
    }

    public boolean isAuthorized(CommandSender commandSender, String str) {
        return commandSender.hasPermission(str);
    }

    public boolean isAuthorized(Player player, String str) {
        return player.hasPermission(str);
    }

    public boolean isAuthorized(CommandSender commandSender, Permission permission) {
        return commandSender.hasPermission(permission);
    }

    public boolean isAuthorized(Player player, Permission permission) {
        return player.hasPermission(permission);
    }

    public abstract boolean onCommand(CommandSender commandSender, Command command, String str, String[] strArr);

    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return null;
    }
}
