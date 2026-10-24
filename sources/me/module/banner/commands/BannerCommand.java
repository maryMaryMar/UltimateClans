package me.module.banner.commands;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import me.module.banner.Banner;
import me.module.banner.manager.EnumFiles.Lang;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.Items;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/commands/BannerCommand.class */
public class BannerCommand implements ClansCommand, TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandAPI().getClanCommander().containsKey("banner")) {
            MessageUtils.sendText(commandSender, Banner.getModuleCore().c().a(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("banner");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Banner.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase("upload") || clans.getCommandAPI().findAliases("upload", str2)) {
            if (strArr.length > 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getModAPI().playerHasPermission(player.getUniqueId(), "BANNERMANAGER")) {
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (clans.isUseGUI() && strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) {
                Banner.getModuleCore().h().e().a(player, (String) null);
                return true;
            }
            ItemStack itemStackItemHand = new Items().ItemHand(player);
            if (itemStackItemHand == null || itemStackItemHand.getType().equals(Material.AIR)) {
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.BANNER_HAND_EMPTY));
                return true;
            }
            if (!Banner.getModuleCore().e().canUploadMaterial(playerClan.get().getId(), itemStackItemHand)) {
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.BANNER_NOT_ACCEPTABLE));
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.BANNER_ACCEPTABLE_LIST));
                return true;
            }
            if (Banner.getModuleCore().e().setBanner(playerClan.get().getId(), player, itemStackItemHand)) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (str2.equalsIgnoreCase("delete") || clans.getCommandAPI().findAliases("delete", str2)) {
            if (strArr.length != 1) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan2 = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getModAPI().playerHasPermission(player.getUniqueId(), "BANNERMANAGER")) {
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (playerClan2.get().getBanner() == null || playerClan2.get().getBanner().isEmpty()) {
                MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.BANNER_EMPTY));
                return true;
            }
            if (Banner.getModuleCore().e().deleteBanner(playerClan2.get().getId(), player)) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (!str2.equalsIgnoreCase("view") && !clans.getCommandAPI().findAliases("view", str2)) {
            MessageUtils.sendText(commandSender, Banner.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        if (strArr.length > 2) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerAPI().hasClan(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (clans.isUseGUI() && strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) {
            Banner.getModuleCore().h().e().c(player, (String) null);
            return true;
        }
        MessageUtils.sendText(commandSender, clans.getClanAPI().parseText(player.getUniqueId(), Banner.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_BANNER_LIST_HEADER)));
        Banner.getModuleCore().c().a(commandSender).getStringList(Lang.HELP_CLAN_BANNER_LIST_FORMAT).iterator().forEachRemaining(str3 -> {
            MessageUtils.sendText(commandSender, clans.getClanAPI().parseText(player.getUniqueId(), str3));
        });
        return true;
    }
}
