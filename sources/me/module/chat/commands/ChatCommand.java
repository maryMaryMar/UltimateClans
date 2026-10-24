package me.module.chat.commands;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;
import me.module.chat.Chat;
import me.module.chat.manager.a;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Chat.jar:me/module/chat/commands/ChatCommand.class */
public class ChatCommand implements ClansCommand {
    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("chat");
        Player player = (Player) commandSender;
        if (!Chat.b().getPlayerAPI().hasClan(player.getUniqueId())) {
            MessageUtils.sendText(player.getUniqueId(), Chat.b().getColorAPI().addLegacyColor(Chat.getModuleCore().d().g().getString("Clan.player donthave clan")));
            return true;
        }
        if (strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2).append(" ");
            }
            a.a(player, sb.toString().substring(0, sb.toString().length() - 1), false);
            return true;
        }
        Chat.b().getPlayerAPI().toggleChat(player);
        Optional<PlayerData> playerData = Chat.b().getPlayerAPI().getPlayerData(player.getUniqueId());
        if (!playerData.isPresent()) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
            return true;
        }
        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, Arrays.asList("{locked_chat};" + Chat.getModuleCore().d().g().getString("Clan." + String.valueOf(playerData.get().isLockedChat()).toLowerCase())));
        return true;
    }
}
