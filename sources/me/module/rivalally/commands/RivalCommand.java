package me.module.rivalally.commands;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.module.rivalally.Rivalally;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.module.rivalally.manager.e;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.RivalRemove;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/commands/RivalCommand.class */
public class RivalCommand implements ClansCommand, TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandAPI().getClanCommander().containsKey("rival")) {
            MessageUtils.sendText(commandSender, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("rival");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase("add") || clans.getCommandAPI().findAliases("add", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<ClanData> optionalEmpty = Optional.empty();
            try {
                optionalEmpty = Rivalally.a().getClanAPI().getClanDataByTag(Rivalally.a().getColorAPI().removeColor(strArr[1]));
            } catch (Exception e) {
            }
            if (!optionalEmpty.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.rival-manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan.get().getId().equals(optionalEmpty.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            if (Rivalally.getModuleCore().e().isClanRival(playerClan.get().getId(), optionalEmpty.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALREADY_RIVAL));
                return true;
            }
            if (Rivalally.getModuleCore().e().isClanAlly(playerClan.get().getId(), optionalEmpty.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_ALLY));
                return true;
            }
            if (playerClan.get().getRivalAlly().getRival().size() >= Rivalally.getModuleCore().e().allyRivalCount(playerClan.get(), ClanEnum.RivalAllyCount.RIVAL)) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_IN_LIMIT));
                return true;
            }
            if (Rivalally.getModuleCore().e().rivalAdd(playerClan.get().getId(), optionalEmpty.get().getId())) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (str2.equalsIgnoreCase("accept") || clans.getCommandAPI().findAliases("accept", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan2 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<ClanData> clanDataByTag = null;
            try {
                clanDataByTag = Rivalally.a().getClanAPI().getClanDataByTag(Rivalally.a().getColorAPI().removeColor(strArr[1]));
            } catch (Exception e2) {
            }
            if (!clanDataByTag.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.rival-manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan2.get().getId().equals(clanDataByTag.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            if (Rivalally.getModuleCore().e().isClanAlly(playerClan2.get().getId(), clanDataByTag.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_ALLY));
                return true;
            }
            if (!e.a().containsKey(playerClan2.get())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_NOT_FOUND));
                return true;
            }
            RivalRemove rivalRemove = e.a().get(playerClan2.get());
            if (!rivalRemove.getClanReceiver().equals(playerClan2.get().getId()) || !rivalRemove.getClanSender().equals(clanDataByTag.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_NOT_FOUND));
                return true;
            }
            boolean zRivalRemove = Rivalally.getModuleCore().e().rivalRemove(playerClan2.get().getId(), clanDataByTag.get().getId());
            e.a().remove(playerClan2.get());
            if (zRivalRemove) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (str2.equalsIgnoreCase("deny") || clans.getCommandAPI().findAliases("deny", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan3 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan3.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<ClanData> clanDataByTag2 = null;
            try {
                clanDataByTag2 = Rivalally.a().getClanAPI().getClanDataByTag(Rivalally.a().getColorAPI().removeColor(strArr[1]));
            } catch (Exception e3) {
            }
            if (!clanDataByTag2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.rival-manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan3.get().getId().equals(clanDataByTag2.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            if (Rivalally.getModuleCore().e().isClanAlly(playerClan3.get().getId(), clanDataByTag2.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_ALLY));
                return true;
            }
            if (!e.a().containsKey(playerClan3.get())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_NOT_FOUND));
                return true;
            }
            RivalRemove rivalRemove2 = e.a().get(playerClan3.get());
            if (!rivalRemove2.getClanReceiver().equals(playerClan3.get().getId()) || !rivalRemove2.getClanSender().equals(clanDataByTag2.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_NOT_FOUND));
                return true;
            }
            e.a().remove(playerClan3.get());
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_DENY));
            if (!Rivalally.a().getClanAPI().clanExists(clanDataByTag2.get().getId())) {
                return true;
            }
            MessageUtils.clanModerationMessageSend(clanDataByTag2.get(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_DENY_RECEIVED));
            return true;
        }
        if (!str2.equalsIgnoreCase("remove") && !clans.getCommandAPI().findAliases("remove", str2)) {
            if (!str2.equalsIgnoreCase("list") && !clans.getCommandAPI().findAliases("list", str2)) {
                MessageUtils.sendText(commandSender, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
                MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
                clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
                return true;
            }
            if (strArr.length > 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalEmpty2 = Optional.empty();
            if (!(commandSender instanceof Player) || strArr.length < 2 || strArr[1].equalsIgnoreCase("-gui")) {
                optionalEmpty2 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            } else {
                Optional<UUID> clanByTag = Rivalally.a().getClanAPI().getClanByTag(strArr[1]);
                if (clanByTag != null) {
                    optionalEmpty2 = Rivalally.a().getClanAPI().getClan(clanByTag.get());
                }
            }
            if (!optionalEmpty2.isPresent()) {
                MessageUtils.sendText(commandSender, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_DOES_NOT_EXISTS));
                return true;
            }
            if ((commandSender instanceof Player) && clans.isUseGUI() && ((strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) || (strArr.length == 3 && strArr[2].equalsIgnoreCase("-gui")))) {
                Rivalally.getModuleCore().h().f().a(player, (String) null);
                return true;
            }
            MessageUtils.sendText(commandSender, Rivalally.a().getClanAPI().parseText(optionalEmpty2.get().getLeader(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_RIVAL_LIST_HEADER)));
            if (optionalEmpty2.get().getRivalAlly().getRival() == null || optionalEmpty2.get().getRivalAlly().getRival().size() != 0) {
                optionalEmpty2.get().getRivalAlly().getRival().iterator().forEachRemaining(uuid -> {
                    if (Rivalally.a().getClanAPI().clanExists(uuid)) {
                        Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan(uuid);
                        if (clan.isPresent()) {
                            MessageUtils.sendText(commandSender, Rivalally.a().getClanAPI().parseText(clan.get().getLeader(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_RIVAL_LIST_FORMAT)));
                        }
                    }
                });
                return true;
            }
            MessageUtils.clanMessageSend(optionalEmpty2.get(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_LIST_EMPTY));
            return true;
        }
        if (strArr.length != 2) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> playerClan4 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan4.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        Optional<ClanData> clanDataByTag3 = null;
        try {
            clanDataByTag3 = Rivalally.a().getClanAPI().getClanDataByTag(Rivalally.a().getColorAPI().removeColor(strArr[1]));
        } catch (Exception e4) {
        }
        if (!clanDataByTag3.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_NOT_FOUND));
            return true;
        }
        if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.rival-manager.name"))) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (playerClan4.get().getId().equals(clanDataByTag3.get().getId())) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
            return true;
        }
        if (!Rivalally.getModuleCore().e().isClanRival(playerClan4.get().getId(), clanDataByTag3.get().getId())) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_DONT_RIVAL));
            return true;
        }
        if (!Rivalally.getModuleCore().c().i().getBoolean("Config.Rival.remove.need_confirmation")) {
            boolean zRivalRemove2 = Rivalally.getModuleCore().e().rivalRemove(playerClan4.get().getId(), clanDataByTag3.get().getId());
            e.a().remove(playerClan4.get());
            if (zRivalRemove2) {
                MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        switch (Rivalally.getModuleCore().e().rivalRemoveSend(playerClan4.get().getId(), clanDataByTag3.get().getId(), true)) {
            case ALREADY_SENDED:
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_ALREADY_INVITED));
                break;
            case ERROR:
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_ERROR));
                break;
            case MODERATION_OFFLINE:
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_MODERATION_OFFLINE));
                break;
            case SENDED:
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_RIVAL_REMOVE_SENDED));
                break;
        }
        return true;
    }
}
