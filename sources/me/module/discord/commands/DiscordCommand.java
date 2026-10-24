package me.module.discord.commands;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import me.module.discord.Discord;
import me.module.discord.data.ModuleEnum;
import me.module.discord.manager.DiscordPublicManager;
import me.module.discord.manager.EnumFiles.Lang;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Discord.jar:me/module/discord/commands/DiscordCommand.class */
public class DiscordCommand implements ClansCommand, TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("discord");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            clans.getCommandAPI().sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase("register") || clans.getCommandAPI().findAliases("register", str2)) {
            if (strArr.length > 1) {
                clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan = Discord.b().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!Discord.b().getModAPI().playerHasPermission(player.getUniqueId(), Discord.getModuleCore().d().i().getString("Config.Permissions.edit.name"))) {
                MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            ClanData clanData = playerClan.get();
            boolean z = ModuleEnum.Webhook.fromString(clanData.getWebhook()) == ModuleEnum.Webhook.CONNECTED;
            if (DiscordPublicManager.isConnectedClan(clanData.getId())) {
                if (!z) {
                    clanData.setWebhook(ModuleEnum.Webhook.CONNECTED.toString());
                    Discord.b().getClanAPI().saveClanData(clanData);
                }
                MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLAN_DISCORD_ALREADY_CONNECTED).replace("%UUID%", clanData.getId().toString()));
                return true;
            }
            if (DiscordPublicManager.registerClan(clanData.getId())) {
                clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (!str2.equalsIgnoreCase("unregister") && !clans.getCommandAPI().findAliases("unregister", str2)) {
            MessageUtils.sendText(commandSender, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            clans.getCommandAPI().sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        if (strArr.length > 1) {
            clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> playerClan2 = Discord.b().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan2.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!Discord.b().getModAPI().playerHasPermission(player.getUniqueId(), Discord.getModuleCore().d().i().getString("Config.Permissions.edit.name"))) {
            MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        ClanData clanData2 = playerClan2.get();
        if (!ModuleEnum.Webhook.fromString(clanData2.getWebhook()).equals(ModuleEnum.Webhook.CONNECTED)) {
            MessageUtils.sendText((CommandSender) player, Discord.getModuleCore().d().a(commandSender).getString(Lang.HELP_CLAN_DISCORD_NOT_CONNECTED));
            return true;
        }
        DiscordPublicManager.unregisterClan(clanData2.getId());
        clanData2.setWebhook(ModuleEnum.Webhook.DISCONNECTED.toString());
        Discord.b().getClanAPI().saveClanData(clanData2);
        clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
        return true;
    }
}
