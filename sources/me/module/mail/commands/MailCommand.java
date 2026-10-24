package me.module.mail.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import me.module.mail.Mail;
import me.module.mail.manager.EnumFiles.Lang;
import me.module.mail.manager.b;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.MailData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.interfaces.RivalAllyModuleAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/commands/MailCommand.class */
public class MailCommand implements ClansCommand, TabCompleter {
    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return (List) new ArrayList().stream().filter(str2 -> {
            return str2 != null && str2.startsWith(strArr[0]);
        }).collect(Collectors.toList());
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandAPI().getClanCommander().containsKey("mail")) {
            MessageUtils.sendText(commandSender, Mail.getModuleCore().c().a(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("mail");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            clans.getCommandAPI().sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase("read") || clans.getCommandAPI().findAliases("read", str2)) {
            if (strArr.length > 4) {
                clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan = Mail.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.read.name"))) {
                MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            int iIntValue = 1;
            ClanEnum.MailTime mailTimeValueOf = ClanEnum.MailTime.UNREAD;
            if (strArr.length >= 3) {
                if (!strArr[2].equalsIgnoreCase("-gui")) {
                    try {
                        iIntValue = Integer.valueOf(strArr[2]).intValue();
                    } catch (Exception e) {
                    }
                }
                if (!strArr[1].equalsIgnoreCase("-gui")) {
                    try {
                        mailTimeValueOf = ClanEnum.MailTime.valueOf(strArr[1]);
                    } catch (Exception e2) {
                        mailTimeValueOf = null;
                    }
                }
            } else if (strArr.length == 2 && !strArr[1].equalsIgnoreCase("-gui")) {
                try {
                    mailTimeValueOf = ClanEnum.MailTime.valueOf(strArr[1]);
                } catch (Exception e3) {
                    mailTimeValueOf = null;
                }
            }
            if (mailTimeValueOf == null) {
                StringBuilder sb = new StringBuilder();
                List listAsList = Arrays.asList(ClanEnum.MailTime.values());
                for (int i = 0; i < listAsList.size(); i++) {
                    if (i % 2 == 0) {
                        sb.append("<aqua>").append(((ClanEnum.MailTime) listAsList.get(i)).toString());
                    } else {
                        sb.append("<gray>").append(((ClanEnum.MailTime) listAsList.get(i)).toString());
                    }
                    if (i + 1 < listAsList.size()) {
                        sb.append("<dark_gray>, ");
                    } else {
                        sb.append("<dark_gray>.");
                    }
                }
                MessageUtils.sendText(commandSender, Mail.getModuleCore().c().a(commandSender).getString(Lang.ACCEPTED_VALUES, Arrays.asList("%types%;" + String.valueOf(sb))));
                return true;
            }
            if (Mail.a().isUseGUI() && ((strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) || ((strArr.length == 3 && strArr[2].equalsIgnoreCase("-gui")) || (strArr.length == 4 && strArr[3].equalsIgnoreCase("-gui"))))) {
                Mail.getModuleCore().i().e().b(player, mailTimeValueOf, (String) null);
                return true;
            }
            List list = (List) new ArrayList(Mail.getModuleCore().e().getClanMailTimed(playerClan.get().getId(), player.getUniqueId(), mailTimeValueOf)).stream().collect(Collectors.toList());
            if (iIntValue < 1) {
                iIntValue = 1;
            }
            int i2 = iIntValue;
            double dCeil = Math.ceil(((double) list.size()) / ((double) 10));
            if (iIntValue > ((int) dCeil)) {
                iIntValue = (int) dCeil;
                i2 = iIntValue;
            }
            int i3 = 10 * (i2 - 1);
            int size = 10 * i2;
            if (size > list.size()) {
                size = list.size();
            }
            if (i3 > size) {
                i3 = size;
            }
            List<MailData> listSubList = list;
            if (list.size() > 0) {
                listSubList = list.subList(i3, size);
            }
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_MAIL_HEADER, Arrays.asList("%time%;" + Mail.getModuleCore().c().a(commandSender).getString(Lang.valueOf("TRANSLACTION_" + mailTimeValueOf.toString().toUpperCase())), "%page%;" + iIntValue, "%pages%;" + ((int) dCeil))));
            if (listSubList.size() < 1) {
                MessageUtils.sendText(commandSender, Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_LIST_NO_NEW_MESSAGES));
                return true;
            }
            for (MailData mailData : listSubList) {
                MessageUtils.sendText(commandSender, clans.getClanAPI().parseText(player.getUniqueId(), Mail.getModuleCore().e().parseText(player.getUniqueId(), Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_MAIL_FORMAT).replace("{id}", "{" + mailData.getId().toString() + "}"))));
                if (!mailData.getReadBy().contains(player.getUniqueId())) {
                    Mail.getModuleCore().e().addReadmail(mailData.getId(), player.getUniqueId());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            if (iIntValue > 1 || (list.size() > 10 && iIntValue * 10 < list.size())) {
                MessageUtils.sendText(commandSender, " ");
            }
            if (iIntValue > 1) {
                int i4 = iIntValue - 1;
                if (i4 > ((int) dCeil)) {
                    i4 = (int) dCeil;
                }
                sb2.append(" ").append(Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_MAIL_PREV, Arrays.asList("%page%;" + String.valueOf(i4), "%time%;" + mailTimeValueOf.toString())));
            }
            if (list.size() > 10 && iIntValue * 10 < list.size()) {
                if (iIntValue > 1) {
                    sb2.append(" ").append(Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_MAIL_SEPARER)).append(" ");
                } else {
                    sb2.append(" ");
                }
                sb2.append(Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_PLAYER_MAIL_NEXT, Arrays.asList("%page%;" + String.valueOf(iIntValue + 1), "%time%;" + mailTimeValueOf.toString())));
            }
            MessageUtils.sendText(commandSender, sb2.toString());
            return true;
        }
        if (!str2.equalsIgnoreCase("send") && !clans.getCommandAPI().findAliases("send", str2)) {
            if (!str2.equalsIgnoreCase("clear") && !clans.getCommandAPI().findAliases("clear", str2)) {
                MessageUtils.sendText(commandSender, Mail.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
                clans.getCommandAPI().sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
                clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
                return true;
            }
            if (strArr.length != 1) {
                clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan2 = Mail.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.clear.name"))) {
                MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (Mail.a().isUseGUI()) {
                Mail.getModuleCore().i().e().a(player, ClanEnum.MailTime.UNREAD, (String) null);
                return true;
            }
            if (Mail.getModuleCore().e().clearClanMail(playerClan2.get().getId())) {
                clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (strArr.length <= 1) {
            clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> playerClan3 = Mail.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan3.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.send.name"))) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        UUID id = playerClan3.get().getId();
        if (!strArr[1].equalsIgnoreCase("me")) {
            Optional<ClanData> clanDataByTag = clans.getClanAPI().getClanDataByTag(strArr[1]);
            if (!clanDataByTag.isPresent()) {
                clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            id = clanDataByTag.get().getId();
            if (id.equals(playerClan3.get().getId())) {
                MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.CLAN_IS_YOUR_CLAN));
                return true;
            }
            boolean z = Mail.getModuleCore().c().j().getBoolean("Config.Mail.enabled_for_all_clans");
            Optional<RivalAllyModuleAPI> rivalAlly = Mail.a().getIntegrationAPI().getRivalAlly();
            boolean zIsClanAlly = rivalAlly.isPresent() ? rivalAlly.get().isClanAlly(id, playerClan3.get().getId()) : false;
            if (!z) {
                if (!zIsClanAlly) {
                    MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.CLAN_DONT_ALLY));
                    return true;
                }
                if (!clanDataByTag.get().getSettings().isReceveMailAllies()) {
                    MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.MAIL_ALLIE_DISABLED));
                    return true;
                }
            } else if (!clanDataByTag.get().getSettings().isReceiveMailAll()) {
                MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.MAIL_ALL_DISABLED));
                return true;
            }
        }
        if (b.a() && b.a(player, "new_mail", Optional.of(id), false, Optional.empty())) {
            return true;
        }
        StringBuilder sb3 = new StringBuilder();
        for (int i5 = 2; i5 < strArr.length; i5++) {
            try {
                sb3.append(strArr[i5]).append(" ");
            } catch (Exception e4) {
            }
        }
        String string = sb3.toString();
        if (!Mail.getModuleCore().c().j().getBoolean("Config.Mail.enable_colors")) {
            string = clans.getColorAPI().removeColor(string);
        }
        String strRemoveColor = clans.getColorAPI().removeColor(string);
        if (strRemoveColor.length() > Mail.getModuleCore().c().j().getInt("Config.Mail.max_chars")) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.MAIL_MAX_CHARS));
            return true;
        }
        if (strRemoveColor.length() < Mail.getModuleCore().c().j().getInt("Config.Mail.min_chars") || strRemoveColor.length() == 0) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.MAIL_MIN_CHARS, Arrays.asList("{chars};" + String.valueOf(Mail.getModuleCore().c().j().getInt("Config.Mail.min_chars")))));
            return true;
        }
        if (Mail.getModuleCore().e().getClanMail(id).size() >= Mail.getModuleCore().c().j().getInt("Config.Mail.max_storage")) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.MAIL_MAX_STORAGE));
            return true;
        }
        if (((List) Mail.getModuleCore().e().getClanMail(id).stream().filter(mailData2 -> {
            return mailData2.getReadBy().size() < 1;
        }).collect(Collectors.toList())).size() >= Mail.getModuleCore().c().j().getInt("Config.Mail.max_unread")) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a(commandSender).getString(Lang.MAIL_MAX_UNREAD));
            return true;
        }
        if (Mail.getModuleCore().e().addClanMail(player.getUniqueId(), playerClan3.get().getId(), id, string)) {
            clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            return true;
        }
        clans.getCommandAPI().sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
        return true;
    }
}
