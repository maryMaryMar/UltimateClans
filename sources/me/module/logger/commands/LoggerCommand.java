package me.module.logger.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import me.module.logger.Logger;
import me.module.logger.manager.EnumFiles.Lang;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.LoggerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/commands/LoggerCommand.class */
public class LoggerCommand implements ClansCommand, TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("logger");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Logger.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            clans.getCommandAPI().sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (!str2.equalsIgnoreCase("view") && !clans.getCommandAPI().findAliases("view", str2)) {
            if (!str2.equalsIgnoreCase("clear") && !clans.getCommandAPI().findAliases("clear", str2)) {
                return true;
            }
            Optional<ClanData> playerClan = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (playerClan.isPresent() && Logger.getModuleCore().e().clearClanLogger(playerClan.get().getId())) {
                clans.getCommandAPI().sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            clans.getCommandAPI().sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        int i = 1;
        ClanEnum.LoggerTime loggerTimeValueOf = ClanEnum.LoggerTime.ALL;
        if (strArr.length >= 2 && !strArr[1].equalsIgnoreCase("-gui")) {
            try {
                loggerTimeValueOf = ClanEnum.LoggerTime.valueOf(strArr[1].toUpperCase());
            } catch (Exception e) {
                loggerTimeValueOf = null;
            }
        }
        if (strArr.length >= 3 && !strArr[2].equalsIgnoreCase("-gui")) {
            try {
                i = Integer.parseInt(strArr[2]);
            } catch (Exception e2) {
            }
        }
        if (loggerTimeValueOf == null) {
            MessageUtils.sendText(commandSender, "§cValor inválido. Tipos disponíveis: " + Arrays.toString(ClanEnum.LoggerTime.values()));
            return true;
        }
        Optional<ClanData> playerClan2 = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan2.isPresent()) {
            return true;
        }
        if (clans.isUseGUI() && Arrays.asList(strArr).contains("-gui")) {
            Logger.getModuleCore().i().e().b(player, loggerTimeValueOf, (String) null);
            return true;
        }
        List<LoggerData> clanLoggerTimed = Logger.getModuleCore().e().getClanLoggerTimed(playerClan2.get().getId(), loggerTimeValueOf);
        int iCeil = (int) Math.ceil(((double) clanLoggerTimed.size()) / ((double) 10));
        if (i < 1) {
            i = 1;
        }
        if (i > iCeil && iCeil > 0) {
            i = iCeil;
        }
        int i2 = 10 * (i - 1);
        int iMin = Math.min(10 * i, clanLoggerTimed.size());
        if (i2 > iMin) {
            i2 = iMin;
        }
        List<LoggerData> listSubList = clanLoggerTimed.subList(i2, iMin);
        MessageUtils.sendText((CommandSender) player, Logger.getModuleCore().c().a(commandSender).getString(Lang.HELP_LOGGER_HEADER, Arrays.asList("%time%;" + Logger.getModuleCore().c().a(commandSender).getString(Lang.valueOf("TRANSLACTION_" + loggerTimeValueOf.toString().toUpperCase())), "%page%;" + i, "%pages%;" + iCeil)));
        if (listSubList.isEmpty()) {
            MessageUtils.sendText(commandSender, Logger.getModuleCore().c().a(commandSender).getString(Lang.HELP_LIST_EMPTY));
            return true;
        }
        Iterator<LoggerData> it = listSubList.iterator();
        while (it.hasNext()) {
            MessageUtils.sendText(commandSender, Logger.getModuleCore().e().parseText(player.getUniqueId(), Logger.getModuleCore().c().a(commandSender).getString(Lang.HELP_LOGGER_FORMAT).replace("{id}", "{" + it.next().getId().toString() + "}")));
        }
        StringBuilder sb = new StringBuilder();
        if (i > 1 || (clanLoggerTimed.size() > 10 && i * 10 < clanLoggerTimed.size())) {
            MessageUtils.sendText(commandSender, " ");
        }
        if (i > 1) {
            sb.append(" ").append(Logger.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_LOGGER_PREV, Arrays.asList("%page%;" + (i - 1), "%time%;" + loggerTimeValueOf.toString())));
        }
        if (clanLoggerTimed.size() > 10 && i * 10 < clanLoggerTimed.size()) {
            if (i > 1) {
                sb.append(" ").append(Logger.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_LOGGER_SEPARER)).append(" ");
            } else {
                sb.append(" ");
            }
            sb.append(Logger.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_LOGGER_NEXT, Arrays.asList("%page%;" + (i + 1), "%time%;" + loggerTimeValueOf.toString())));
        }
        MessageUtils.sendText(commandSender, sb.toString());
        return true;
    }
}
