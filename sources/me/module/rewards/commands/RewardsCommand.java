package me.module.rewards.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.module.rewards.Rewards;
import me.module.rewards.manager.EnumFiles.Lang;
import me.module.rewards.manager.c.a;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.RewardsData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.utils.Times;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/commands/RewardsCommand.class */
public class RewardsCommand implements ClansCommand {
    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandAPI().getClanCommander().containsKey("rewards")) {
            MessageUtils.sendText(commandSender, Rewards.getModuleCore().c().a(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("rewards");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase("collect") || clans.getCommandAPI().findAliases("collect", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (!Rewards.a().getPlayerAPI().getPlayerClan(player.getUniqueId()).isPresent()) {
                MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!Rewards.a().getModAPI().playerHasPermission(player.getUniqueId(), Rewards.getModuleCore().c().j().getString("Config.Permissions.use.name"))) {
                MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (clans.isUseGUI() && strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) {
                Rewards.getModuleCore().g().e().a(player, 1, Optional.empty());
                return true;
            }
            UUID uuidFromString = null;
            try {
                uuidFromString = UUID.fromString(strArr[1]);
            } catch (Exception e) {
            }
            if (uuidFromString == null) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            UUID uuid = uuidFromString;
            if (!Rewards.getModuleCore().i().getPlayerRewards(player.getUniqueId()).stream().filter(rewardsData -> {
                return rewardsData.getId().equals(uuid);
            }).findFirst().isPresent()) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (Rewards.getModuleCore().i().playerCollectReward(player.getUniqueId(), uuid)) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (!str2.equalsIgnoreCase("list") && !clans.getCommandAPI().findAliases("list", str2)) {
            MessageUtils.sendText(commandSender, Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        int iIntValue = 1;
        if (strArr.length > 2) {
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!Rewards.a().getPlayerAPI().getPlayerClan(player.getUniqueId()).isPresent()) {
            MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!Rewards.a().getModAPI().playerHasPermission(player.getUniqueId(), Rewards.getModuleCore().c().j().getString("Config.Permissions.use.name"))) {
            MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if (clans.isUseGUI() && strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) {
            Rewards.getModuleCore().g().e().a(player, 1, Optional.empty());
            return true;
        }
        try {
            iIntValue = Integer.valueOf(strArr[1]).intValue();
        } catch (Exception e2) {
        }
        List<RewardsData> playerRewards = Rewards.getModuleCore().i().getPlayerRewards(player.getUniqueId());
        new ArrayList();
        a aVar = new a(new ArrayList(playerRewards), 3);
        aVar.a(iIntValue);
        MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_REQUIRES_REWARDS_HEADER));
        if (aVar.a().size() == 0) {
            MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_LIST_EMPTY));
            return true;
        }
        aVar.a().iterator().forEachRemaining(obj -> {
            RewardsData rewardsData2 = (RewardsData) obj;
            ArrayList arrayList = new ArrayList();
            if (rewardsData2.getDescription().isPresent()) {
                arrayList.add("{description};" + String.valueOf(rewardsData2.getDescription().get()));
            } else {
                arrayList.add("{description};" + String.valueOf(Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_REWARDS_DEFAULT_TEXT)));
            }
            Optional<PlayerData> playerData = Rewards.a().getPlayerAPI().getPlayerData(rewardsData2.getSender());
            if (playerData.isPresent()) {
                arrayList.add("{sender};" + String.valueOf(playerData.get().getName()));
            }
            arrayList.add("{rewards_amount};" + String.valueOf(rewardsData2.getRewards().size()));
            arrayList.add("{date};" + String.valueOf(new Times().unixToDate(Long.valueOf(rewardsData2.getDate() * 1000), Rewards.getModuleCore().c().j().getString("Config.date_format_short"))));
            arrayList.add("{id};" + String.valueOf(rewardsData2.getId().toString()));
            MessageUtils.sendText((CommandSender) player, Rewards.a().getClanAPI().parseText(player.getUniqueId(), Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_REQUIRES_REWARDS_FORMAT, arrayList)));
        });
        StringBuilder sb = new StringBuilder();
        MessageUtils.sendText((CommandSender) player, " ");
        if (aVar.c()) {
            sb.append(" ");
            sb.append(Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_REWARDS_PREV, Arrays.asList("%page%;" + String.valueOf(aVar.e()))));
        }
        if (aVar.b()) {
            sb.append(" ");
            sb.append(Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_REWARDS_SEPARER));
            sb.append(" ");
            sb.append(Rewards.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_REWARDS_NEXT, Arrays.asList("%page%;" + String.valueOf(aVar.d()))));
        } else {
            sb.append(" ");
        }
        MessageUtils.sendText(commandSender, sb.toString());
        return true;
    }
}
