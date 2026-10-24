package me.module.levelup.commands;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import me.module.levelup.Levelup;
import me.module.levelup.manager.EnumFiles.Lang;
import me.module.levelup.manager.b.c;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.RequerimentData_Return;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/commands/LevelCommand.class */
public class LevelCommand implements ClansCommand, TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return (List) new ArrayList().stream().filter(str2 -> {
            return str2 != null && str2.startsWith(strArr[0]);
        }).collect(Collectors.toList());
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandAPI().getClanCommander().containsKey("level")) {
            MessageUtils.sendText(commandSender, Levelup.getModuleCore().c().a(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("level");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Levelup.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase("view") || clans.getCommandAPI().findAliases("view", str2)) {
            if (strArr.length > 2) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getModAPI().playerHasPermission(player.getUniqueId(), Levelup.getModuleCore().c().i().getString("Config.Permissions.view.name"))) {
                MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (clans.isUseGUI() && strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) {
                Levelup.getModuleCore().h().e().a(player, 1, Optional.empty());
                return true;
            }
            Optional<Integer> optionalClanNextLevel = Levelup.getModuleCore().e().clanNextLevel(playerClan.get().getId());
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.HELP_REQUIRES_HEADER));
            if (!optionalClanNextLevel.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.HELP_REQUIRES_MAX_REACHED));
                return true;
            }
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.HELP_REQUIRES_FORMAT));
            List<RequerimentData_Return> playerClanRequeriments = Levelup.getModuleCore().e().getPlayerClanRequeriments(player.getUniqueId());
            c.a(playerClanRequeriments).iterator().forEachRemaining(str3 -> {
                MessageUtils.sendText((CommandSender) player, " " + str3);
            });
            if (((List) playerClanRequeriments.stream().filter(requerimentData_Return -> {
                return requerimentData_Return.getFalseMessage().isPresent();
            }).collect(Collectors.toList())).size() == 0) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (!str2.equalsIgnoreCase("up") && !clans.getCommandAPI().findAliases("up", str2)) {
            MessageUtils.sendText(commandSender, Levelup.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        if (strArr.length > 2) {
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> playerClan2 = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan2.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!clans.getModAPI().playerHasPermission(player.getUniqueId(), Levelup.getModuleCore().c().i().getString("Config.Permissions.up.name"))) {
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        Optional<Integer> optionalClanNextLevel2 = Levelup.getModuleCore().e().clanNextLevel(playerClan2.get().getId());
        MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.HELP_REQUIRES_HEADER));
        if (!optionalClanNextLevel2.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a(commandSender).getString(Lang.HELP_REQUIRES_MAX_REACHED));
            return true;
        }
        if (((List) Levelup.getModuleCore().e().getPlayerClanRequeriments(player.getUniqueId()).stream().filter(requerimentData_Return2 -> {
            return requerimentData_Return2.getFalseMessage().isPresent();
        }).collect(Collectors.toList())).size() != 0) {
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (clans.isUseGUI() && strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) {
            Levelup.getModuleCore().h().e().b(player, 1, Optional.empty());
            return true;
        }
        if (Levelup.getModuleCore().e().checkUpgradeLevel(player.getUniqueId())) {
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
            return true;
        }
        MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
        return true;
    }
}
