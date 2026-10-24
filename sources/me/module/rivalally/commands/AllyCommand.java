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
import me.ulrich.clans.data.AllyInvite;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/commands/AllyCommand.class */
public class AllyCommand implements ClansCommand, TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandAPI().getClanCommander().containsKey("ally")) {
            MessageUtils.sendText(commandSender, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("ally");
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
            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan.get().getId().equals(optionalEmpty.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            if (Rivalally.getModuleCore().e().isClanRival(playerClan.get().getId(), optionalEmpty.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_RIVAL));
                return true;
            }
            if (Rivalally.getModuleCore().e().isClanAlly(playerClan.get().getId(), optionalEmpty.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALREADY_ALLY));
                return true;
            }
            if (playerClan.get().getRivalAlly().getAlly().size() >= Rivalally.getModuleCore().e().allyRivalCount(playerClan.get(), ClanEnum.RivalAllyCount.ALLY)) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_IN_LIMIT));
                return true;
            }
            if (!Rivalally.getModuleCore().c().i().getBoolean("Config.Ally.invite.need_confirmation")) {
                boolean zAllyAdd = Rivalally.getModuleCore().e().allyAdd(playerClan.get().getId(), optionalEmpty.get().getId());
                e.b().remove(playerClan.get());
                if (zAllyAdd) {
                    MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
                    return true;
                }
                MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
                return true;
            }
            switch (Rivalally.getModuleCore().e().allySend(playerClan.get().getId(), optionalEmpty.get().getId(), true)) {
                case ALREADY_INVITED:
                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_ALREADY_INVITED));
                    break;
                case ERROR:
                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_ERROR));
                    break;
                case MODERATION_OFFLINE:
                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_MODERATION_OFFLINE));
                    break;
                case SENDED:
                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_SENDED));
                    break;
            }
            return true;
        }
        if (str2.equalsIgnoreCase("remove") || clans.getCommandAPI().findAliases("remove", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan2 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<ClanData> optionalEmpty2 = Optional.empty();
            try {
                optionalEmpty2 = Rivalally.a().getClanAPI().getClanDataByTag(Rivalally.a().getColorAPI().removeColor(strArr[1]));
            } catch (Exception e2) {
            }
            if (!optionalEmpty2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan2.get().getId().equals(optionalEmpty2.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            if (!Rivalally.getModuleCore().e().isClanAlly(playerClan2.get().getId(), optionalEmpty2.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_DONT_ALLY));
                return true;
            }
            if (Rivalally.getModuleCore().e().allyRemove(playerClan2.get().getId(), optionalEmpty2.get().getId())) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (str2.equalsIgnoreCase("accept") || clans.getCommandAPI().findAliases("accept", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan3 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan3.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<ClanData> optionalEmpty3 = Optional.empty();
            try {
                optionalEmpty3 = Rivalally.a().getClanAPI().getClanDataByTag(Rivalally.a().getColorAPI().removeColor(strArr[1]));
            } catch (Exception e3) {
            }
            if (!optionalEmpty3.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan3.get().getId().equals(optionalEmpty3.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            if (!e.b().containsKey(playerClan3.get())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_NOT_FOUND));
                return true;
            }
            AllyInvite allyInvite = e.b().get(playerClan3.get());
            if (!allyInvite.getClanReceiver().equals(playerClan3.get().getId()) || !allyInvite.getClanSender().equals(optionalEmpty3.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_NOT_FOUND));
                return true;
            }
            int iAllyRivalCount = Rivalally.getModuleCore().e().allyRivalCount(playerClan3.get(), ClanEnum.RivalAllyCount.ALLY);
            if (playerClan3.get().getRivalAlly().getAlly().size() >= iAllyRivalCount) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_IN_LIMIT));
                return true;
            }
            if (optionalEmpty3.get().getRivalAlly().getAlly().size() >= iAllyRivalCount) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_IN_LIMIT));
                return true;
            }
            boolean zAllyAdd2 = Rivalally.getModuleCore().e().allyAdd(optionalEmpty3.get().getId(), playerClan3.get().getId());
            e.b().remove(playerClan3.get());
            if (zAllyAdd2) {
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
            Optional<ClanData> playerClan4 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan4.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<ClanData> optionalEmpty4 = Optional.empty();
            try {
                optionalEmpty4 = Rivalally.a().getClanAPI().getClanDataByTag(Rivalally.a().getColorAPI().removeColor(strArr[1]));
            } catch (Exception e4) {
            }
            if (!optionalEmpty4.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan4.get().getId().equals(optionalEmpty4.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            if (!e.b().containsKey(playerClan4.get())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_NOT_FOUND));
                return true;
            }
            AllyInvite allyInvite2 = e.b().get(playerClan4.get());
            if (!allyInvite2.getClanReceiver().equals(playerClan4.get().getId()) || !allyInvite2.getClanSender().equals(optionalEmpty4.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_NOT_FOUND));
                return true;
            }
            e.b().remove(playerClan4.get());
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_DENY));
            if (!Rivalally.a().getClanAPI().clanExists(optionalEmpty4.get().getId())) {
                return true;
            }
            MessageUtils.clanModerationMessageSend(optionalEmpty4.get(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ALLY_INVITE_DENY_RECEIVED));
            return true;
        }
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
        Optional<ClanData> optionalEmpty5 = Optional.empty();
        if (strArr.length < 2 || strArr[1].equalsIgnoreCase("-gui")) {
            optionalEmpty5 = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        } else {
            Optional<UUID> clanByTag = Rivalally.a().getClanAPI().getClanByTag(strArr[1]);
            if (clanByTag.isPresent()) {
                optionalEmpty5 = Rivalally.a().getClanAPI().getClan(clanByTag.get());
            }
        }
        if (!optionalEmpty5.isPresent()) {
            MessageUtils.sendText(commandSender, Rivalally.getModuleCore().c().a(commandSender).getString(Lang.CLAN_DOES_NOT_EXISTS));
            return true;
        }
        if ((commandSender instanceof Player) && clans.isUseGUI() && ((strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) || (strArr.length == 3 && strArr[2].equalsIgnoreCase("-gui")))) {
            Rivalally.getModuleCore().h().e().a(player, (String) null);
            return true;
        }
        MessageUtils.sendText(commandSender, Rivalally.a().getClanAPI().parseText(optionalEmpty5.get().getLeader(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_ALLY_LIST_HEADER)));
        if (optionalEmpty5.get().getRivalAlly().getAlly() == null || optionalEmpty5.get().getRivalAlly().getAlly().size() != 0) {
            optionalEmpty5.get().getRivalAlly().getAlly().iterator().forEachRemaining(uuid -> {
                Rivalally.a().getClanAPI().getClan(uuid).ifPresent(clanData -> {
                    MessageUtils.sendText(commandSender, Rivalally.a().getClanAPI().parseText(clanData.getLeader(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_ALLY_LIST_FORMAT)));
                });
            });
            return true;
        }
        MessageUtils.clanMessageSend(optionalEmpty5.get(), Rivalally.getModuleCore().c().a(commandSender).getString(Lang.HELP_LIST_EMPTY));
        return true;
    }
}
