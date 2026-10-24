package me.module.discord.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import me.module.discord.Discord;
import me.module.discord.manager.DiscordPublicManager;
import me.module.discord.manager.EnumFiles.Lang;
import me.module.discord.manager.b;
import me.module.discord.reflect.AbstractCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/commands/AdminCommand.class */
public class AdminCommand extends AbstractCommand implements TabCompleter {
    private static AdminCommand command = new AdminCommand("discord_register");

    public static AdminCommand getInstance() {
        return command;
    }

    public AdminCommand(String str) {
        super(str, null, null, null, Arrays.asList(Discord.getModuleCore().d().j().getString("Commands.admin.alias")));
        register();
    }

    @Override // me.module.discord.reflect.AbstractCommand
    public List<String> onTabComplete(CommandSender commandSender, Command command2, String str, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        b bVarD = Discord.getModuleCore().d();
        if (strArr.length != 1) {
            return (List) arrayList.stream().filter(str2 -> {
                return str2.startsWith(strArr[0]);
            }).collect(Collectors.toList());
        }
        Iterator it = bVarD.j().getConfigurationSection("Commands.discord_register").getKeys(false).iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return (List) arrayList.stream().filter(str3 -> {
            return str3.startsWith(strArr[0]);
        }).collect(Collectors.toList());
    }

    @Override // me.module.discord.reflect.AbstractCommand
    public boolean onCommand(CommandSender commandSender, Command command2, String str, String[] strArr) {
        b bVarD = Discord.getModuleCore().d();
        if (!bVarD.j().getString("Commands.admin.permission").isEmpty() && !commandSender.hasPermission(bVarD.j().getString("Commands.admin.permission"))) {
            MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.NO_PERMISSION));
            return true;
        }
        if (!(commandSender instanceof Player)) {
            MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.COMMAND_BY_PLAYER));
            return true;
        }
        Player player = (Player) commandSender;
        if (strArr.length == 0) {
            Bukkit.dispatchCommand(commandSender, "discord_register help");
            return true;
        }
        if (strArr[0].equalsIgnoreCase("client") || bVarD.j().getStringList("Commands.discord_register.client.aliases").contains(strArr[0])) {
            if (strArr.length != 2) {
                MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.COMMANDS_discord_register_client_usage));
                return true;
            }
            String str2 = strArr[1];
            if (!Discord.b().getPlayerAPI().getPlayerClan(player.getUniqueId()).isPresent()) {
                MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (Discord.b().getModAPI().playerHasPermission(player.getUniqueId(), Discord.getModuleCore().d().i().getString("Config.Permissions.edit.name"))) {
                DiscordPublicManager.registerClient(str2, str3 -> {
                    if (str3.equals("CLIENT_REGISTER_SUCCESS")) {
                        MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.COMMANDS_discord_register_client_success));
                        MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLIENT_DISCORD_SUCCESSFULLY_REGISTERED));
                        return;
                    }
                    MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.COMMANDS_discord_register_client_error));
                    if (str3.equals("CLIENT_REGISTER_ALREADY_LINKED")) {
                        MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLIENT_DISCORD_ALREADY_REGISTERED));
                        return;
                    }
                    if (str3.equals("CLIENT_REGISTER_ERROR|DISCORD_NOT_REGISTERED")) {
                        MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLIENT_DISCORD_ID_NOT_REGISTERED));
                        return;
                    }
                    if (str3.equals("CLIENT_REGISTER_ERROR|BUYER_ALREADY_USED")) {
                        MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLIENT_DISCORD_ALREADY_LINKED_TO_ANOTHER));
                        return;
                    }
                    if (str3.equals("CLIENT_REGISTER_ERROR|DISCORD_ALREADY_LINKED_OTHER")) {
                        MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLIENT_DISCORD_ACCOUNT_ALREADY_LINKED_TO_ANOTHER));
                    } else if (str3.equals("CLIENT_REGISTER_ERROR|BUYER_ID_MISMATCH")) {
                        MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLIENT_DISCORD_VALIDATION_FAILED));
                    } else {
                        MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLIENT_DISCORD_REGISTRATION_FAILED, Arrays.asList("{response};" + str3)));
                    }
                });
                return true;
            }
            MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (!strArr[0].equalsIgnoreCase("help") && !bVarD.j().getStringList("Commands.discord_register.help.aliases").contains(strArr[0])) {
            Bukkit.dispatchCommand(commandSender, "discord_register help");
            return true;
        }
        if (strArr.length != 1) {
            MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.COMMANDS_discord_register_help_usage));
            return true;
        }
        commandSender.sendMessage(" ");
        MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.HEADER_HELP));
        Iterator it = bVarD.j().getConfigurationSection("Commands.discord_register").getKeys(false).iterator();
        while (it.hasNext()) {
            MessageUtils.sendText(commandSender, bVarD.a(commandSender).getString(Lang.valueOf("COMMANDS_discord_register_" + ((String) it.next()) + "_show")));
        }
        return true;
    }
}
