package me.ulrich.clans.manager.utils;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.WeakHashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanData_show_json;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CommandData_show;
import me.ulrich.clans.library.kyori.adventure.audience.Audience;
import me.ulrich.clans.library.kyori.adventure.text.Component;
import me.ulrich.clans.library.kyori.adventure.text.event.ClickEvent;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/MessageUtils.class */
public class MessageUtils {
    private static String sCq12wQz1JTpQPOncYjy;
    private static String pdAPnJN0OlJzDO;
    private static String WRPMGubAnaOeJ9Iu;
    private static String WUP3jfCSvoIJZNpE;
    private static String hlf3ufoQ0VFA3hrIih;
    private static volatile String m0P4hLlmMa78d76T;
    private static volatile String Bt3R6VJrfUJeiLXCXi;
    private static volatile String pHgGgF2XjLUtDgaFBMd2d;
    private static String fjj6i1UzBQ0S3AQ;
    private static volatile String RgK8KBxbWNFWEeOfeH;
    private static String PV0donuMgCv1OqGQp;
    private static String kJIJR2fhqXMhBVm8dCeGF8;
    private static String ps0dDpIIlPffFE1oSu;
    private static String LVA48Ab4bF5sco5jQnT6;
    private static String XAsX6DtjDIEn3YGiTl;
    private static final byte[] PNfSapFn9xSAjUm = {(byte) 112, (byte) 213, (byte) 212, (byte) 76, (byte) 71, (byte) 148, (byte) 49, (byte) 44, (byte) 169, (byte) 183, (byte) 148, (byte) 195, (byte) 71, (byte) 232, (byte) 236, (byte) 66};
    private static final byte[] cDl1FXzd8uzG0DIB5ajQI = {(byte) 226, (byte) 253, (byte) 40, (byte) 69, (byte) 196, (byte) 135, (byte) 233, (byte) 138, (byte) 96, (byte) 227, (byte) 238, (byte) 6, (byte) 84, (byte) 138, (byte) 201, (byte) 28};
    private static final byte[] nOsOZKRZIXXUIZ15jed = {(byte) 219, (byte) 60, (byte) 229, (byte) 7, (byte) 64, (byte) 212, (byte) 66, (byte) 243, (byte) 252, (byte) 56, (byte) 76, (byte) 160, (byte) 142, (byte) 242, (byte) 159, (byte) 70};
    private static final byte[] kWl9jnccoYrbsOX = {(byte) 114, (byte) 119, (byte) 62, (byte) 228, (byte) 171, (byte) 24, (byte) 74, (byte) 186, (byte) 168, (byte) 190, (byte) 100, (byte) 150, (byte) 33, (byte) 196, (byte) 120, (byte) 178};
    private static final byte[] PzNDIgSof1i3OaifP = {(byte) 198, (byte) 132, (byte) 202, (byte) 210, (byte) 75, (byte) 96, (byte) 138, (byte) 87, (byte) 192, (byte) 66, (byte) 81, (byte) 16, (byte) 12, (byte) 109, (byte) 112, (byte) 109};
    private static final byte[] YkZrSlesapZsft2bVxDdlo = {(byte) 198, (byte) 132, (byte) 202, (byte) 210, (byte) 75, (byte) 96, (byte) 138, (byte) 87, (byte) 192, (byte) 66, (byte) 81, (byte) 16, (byte) 12, (byte) 109, (byte) 112, (byte) 109};
    private static final byte[] hp9MQBDkMNg5PdSW = {(byte) 13, (byte) 109, (byte) 147, (byte) 253, (byte) 39, (byte) 86, (byte) 58, (byte) 27, (byte) 69, (byte) 214, (byte) 56, (byte) 111, (byte) 8, (byte) 185, (byte) 152, (byte) 18, (byte) 95, (byte) 54, (byte) 215, (byte) 121, (byte) 0, (byte) 184, (byte) 11, (byte) 61, (byte) 13, (byte) 204, (byte) 22, (byte) 179, (byte) 240, (byte) 122, (byte) 125, (byte) 190};
    private static final byte[] e0XklgHEgTySL2jRr = {(byte) 103, (byte) 221, (byte) 189, (byte) 108, (byte) 147, (byte) 158, (byte) 17, (byte) 6, (byte) 209, (byte) 215, (byte) 206, (byte) 162, (byte) 43, (byte) 138, (byte) 95, (byte) 76};
    private static final Map<CommandData_show, Map<String, CommandData_show>> LOCALIZED_COMMAND_SHOWS = Collections.synchronizedMap(new WeakHashMap());

    public static void registerLocalizedCommandShow(CommandData_show commandData_show, Map<String, CommandData_show> map) {
        if (commandData_show == null) {
            return;
        }
        if (map == null || map.isEmpty()) {
            LOCALIZED_COMMAND_SHOWS.remove(commandData_show);
        } else {
            LOCALIZED_COMMAND_SHOWS.put(commandData_show, new HashMap(map));
        }
    }

    private static boolean queueForPlayerThread(Player player, Runnable runnable) {
        if (player == null || runnable == null) {
            return false;
        }
        try {
            if (Clans.getClanCore() == null || Clans.getClanCore().getTaskManager() == null || !Clans.getClanCore().getTaskManager().ZwrsrwOCXRUscW6Q() || Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().isEntityThread(player)) {
                return false;
            }
            Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, runnable);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void sendCommandJson(CommandSender commandSender, CommandData commandData, ClanEnum.MsgUsage msgUsage, List<String> list) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (queueForPlayerThread(player, () -> {
                sendCommandJson(player, commandData, msgUsage, list);
            })) {
                return;
            }
        }
        boolean z = !(commandSender instanceof Player);
        if (commandData != null) {
            String on_usage = null;
            ClanData_show_json on_help_json = null;
            String strJBUuLP0sWwaPyPOmogdX7l = null;
            String on_success = null;
            String on_success2 = null;
            switch (msgUsage) {
                case error:
                    on_usage = commandData.getShow().getOn_error();
                    strJBUuLP0sWwaPyPOmogdX7l = commandData.getActionbar() != null ? commandData.getActionbar().getOn_error() : null;
                    on_success = commandData.getTitle() != null ? commandData.getTitle().getOn_error() : null;
                    if (commandData.getSound() != null) {
                        on_success2 = commandData.getSound().getOn_error();
                    }
                    break;
                case help:
                    on_usage = commandData.getShow().getOn_help();
                    on_help_json = commandData.getShow().getOn_help_json();
                    strJBUuLP0sWwaPyPOmogdX7l = commandData.getActionbar() != null ? commandData.getActionbar().getOn_help() : null;
                    on_success = commandData.getTitle() != null ? commandData.getTitle().getOn_help() : null;
                    if (commandData.getSound() != null) {
                        on_success2 = commandData.getSound().getOn_help();
                    }
                    break;
                case success:
                    on_usage = commandData.getShow().getOn_success();
                    strJBUuLP0sWwaPyPOmogdX7l = commandData.getActionbar() != null ? commandData.getActionbar().getOn_success() : null;
                    on_success = commandData.getTitle() != null ? commandData.getTitle().getOn_success() : null;
                    if (commandData.getSound() != null) {
                        on_success2 = commandData.getSound().getOn_success();
                    }
                    break;
                case usage:
                    on_usage = commandData.getShow().getOn_usage();
                    break;
            }
            String strResolveLocalizedCommandText = resolveLocalizedCommandText(commandSender, commandData, null, msgUsage, on_usage);
            if (strResolveLocalizedCommandText != null && !strResolveLocalizedCommandText.isEmpty()) {
                if (list != null) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        String[] strArrSplit = it.next().split(Uj0QHcdqRggIcf8ID());
                        strResolveLocalizedCommandText = strResolveLocalizedCommandText.replace(strArrSplit[0], strArrSplit[1]);
                    }
                }
                try {
                    if (Clans.getClanCore().getFiles().p31abtwfBag2jhMH6K().getString(BXBFwOoHpJc2lKI8za()) != null && !Clans.getClanCore().getFiles().p31abtwfBag2jhMH6K().getString(yFOZhxMzMPJNeund()).isEmpty()) {
                        strResolveLocalizedCommandText = strResolveLocalizedCommandText.replace(aYHEH1r6DWCFyKX6m3w9Q(), Clans.getClanCore().getFiles().p31abtwfBag2jhMH6K().getString(e1VJqDOLfueFG0g()));
                    }
                } catch (Exception e) {
                }
                String strReplace = strResolveLocalizedCommandText.replace(KuHt8YAmx5isw4kAq2g(), Clans.getClanCore().getTagpl());
                if (commandSender instanceof Player) {
                    strReplace = Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(((Player) commandSender).getUniqueId(), strReplace);
                }
                if (on_help_json != null) {
                    try {
                        if (!on_help_json.getHover_text().isEmpty() && on_help_json.getHover_text() != null) {
                            String hover_text = on_help_json.getHover_text();
                            if (list != null) {
                                Iterator<String> it2 = list.iterator();
                                while (it2.hasNext()) {
                                    String[] strArrSplit2 = it2.next().split(qNjCfmWtWuLCkPhM9K83e());
                                    hover_text = hover_text.replace(strArrSplit2[0], strArrSplit2[1]);
                                }
                            }
                            strReplace = "<hover:show_text:'" + hover_text + "'>" + strReplace + "</hover>";
                        }
                        if (!on_help_json.getClick_type().isEmpty() && on_help_json.getClick_type() != null && !on_help_json.getClick_action().isEmpty() && on_help_json.getClick_action() != null) {
                            String click_action = on_help_json.getClick_action();
                            if (list != null) {
                                Iterator<String> it3 = list.iterator();
                                while (it3.hasNext()) {
                                    String[] strArrSplit3 = it3.next().split(JA3YquM36cloGZqY8());
                                    click_action = click_action.replace(strArrSplit3[0], strArrSplit3[1]);
                                }
                            }
                            strReplace = "<click:" + ClickEvent.Action.NAMES.value(on_help_json.getClick_type()).toString() + ":'" + click_action + "'>" + strReplace + "</click>";
                        }
                        if (z) {
                            Clans.getClanCore().getAdventure().sender(Bukkit.getConsoleSender()).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(strReplace));
                        } else {
                            Clans.getClanCore().getAdventure().player((Player) commandSender).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(strReplace));
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (z) {
                    Clans.getClanCore().getAdventure().sender(Bukkit.getConsoleSender()).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(strReplace));
                } else {
                    Clans.getClanCore().getAdventure().player((Player) commandSender).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(strReplace));
                }
            }
            if (strJBUuLP0sWwaPyPOmogdX7l != null) {
                try {
                    if (!strJBUuLP0sWwaPyPOmogdX7l.isEmpty() && !z) {
                        if (commandSender instanceof Player) {
                            strJBUuLP0sWwaPyPOmogdX7l = Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(((Player) commandSender).getUniqueId(), strJBUuLP0sWwaPyPOmogdX7l);
                        }
                        Actionbar.showActionbar((Player) commandSender, strJBUuLP0sWwaPyPOmogdX7l);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (on_success != null) {
                try {
                    if (!on_success.isEmpty() && !z) {
                        String strJBUuLP0sWwaPyPOmogdX7l2 = on_success;
                        String strJBUuLP0sWwaPyPOmogdX7l3 = "";
                        if (on_success.contains(KGK9dTgZ6xT8nyuTI())) {
                            String[] strArrSplit4 = on_success.split(ioUHUoRaw41c814PVhS());
                            strJBUuLP0sWwaPyPOmogdX7l2 = strArrSplit4[0];
                            strJBUuLP0sWwaPyPOmogdX7l3 = strArrSplit4[1];
                        }
                        if (commandSender instanceof Player) {
                            Player player2 = (Player) commandSender;
                            strJBUuLP0sWwaPyPOmogdX7l2 = Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player2.getUniqueId(), strJBUuLP0sWwaPyPOmogdX7l2);
                            strJBUuLP0sWwaPyPOmogdX7l3 = Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player2.getUniqueId(), strJBUuLP0sWwaPyPOmogdX7l3);
                        }
                        if (!strJBUuLP0sWwaPyPOmogdX7l2.isEmpty() || !strJBUuLP0sWwaPyPOmogdX7l3.isEmpty()) {
                            Title.showTitle((Player) commandSender, strJBUuLP0sWwaPyPOmogdX7l2, strJBUuLP0sWwaPyPOmogdX7l3);
                        }
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            try {
                if (!on_success2.isEmpty()) {
                    Clans.getClanCore().getLibManager().v8qP8fE86HMhvNuYPFjqY((Player) commandSender, on_success2);
                }
            } catch (Exception e5) {
            }
        }
    }

    public static void sendSubCommandJson(CommandSender commandSender, CommandData commandData, String str, ClanEnum.MsgUsage msgUsage, List<String> list) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (queueForPlayerThread(player, () -> {
                sendSubCommandJson(player, commandData, str, msgUsage, list);
            })) {
                return;
            }
        }
        boolean z = !(commandSender instanceof Player);
        String strXtOheRiObl4QeAl = str;
        if (!commandData.getSubcommands().containsKey(str)) {
            strXtOheRiObl4QeAl = Clans.getClanCore().getCommandManager().xtOheRiObl4QeAl(str);
        }
        if (commandData == null || str == null || strXtOheRiObl4QeAl == null || !commandData.getSubcommands().containsKey(strXtOheRiObl4QeAl)) {
            return;
        }
        String on_usage = null;
        switch (msgUsage) {
            case error:
                on_usage = commandData.getSubcommands().get(strXtOheRiObl4QeAl).getOn_error();
                break;
            case help:
                on_usage = commandData.getSubcommands().get(strXtOheRiObl4QeAl).getOn_help();
                break;
            case success:
                on_usage = commandData.getSubcommands().get(strXtOheRiObl4QeAl).getOn_success();
                break;
            case usage:
                on_usage = commandData.getSubcommands().get(strXtOheRiObl4QeAl).getOn_usage();
                break;
        }
        String strResolveLocalizedCommandText = resolveLocalizedCommandText(commandSender, commandData, strXtOheRiObl4QeAl, msgUsage, on_usage);
        if (strResolveLocalizedCommandText == null || strResolveLocalizedCommandText.isEmpty()) {
            return;
        }
        if (list != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split(usJkQP3i9IbvfXNrqd());
                strResolveLocalizedCommandText = strResolveLocalizedCommandText.replace(strArrSplit[0], strArrSplit[1]);
            }
        }
        String strReplace = strResolveLocalizedCommandText.replace(U3XKd8UfdARDQN3NHGr(), Clans.getClanCore().getTagpl());
        if (commandSender instanceof Player) {
            strReplace = Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(((Player) commandSender).getUniqueId(), strReplace);
        }
        try {
            if (z) {
                Clans.getClanCore().getAdventure().sender(Bukkit.getConsoleSender()).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(strReplace));
            } else {
                Clans.getClanCore().getAdventure().player((Player) commandSender).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(strReplace));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String resolveLocalizedCommandText(CommandSender commandSender, CommandData commandData, String str, ClanEnum.MsgUsage msgUsage, String str2) {
        String showText;
        if (commandData == null || msgUsage == null) {
            return str2;
        }
        try {
            Map<String, CommandData_show> map = LOCALIZED_COMMAND_SHOWS.get(str == null ? commandData.getShow() : commandData.getSubcommands().get(str));
            if (map != null && !map.isEmpty()) {
                CommandData_show commandData_show = map.get(Clans.getClanCore().getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender instanceof Player ? Optional.of(((Player) commandSender).getUniqueId()) : Optional.empty()));
                if (commandData_show == null) {
                    commandData_show = map.get(FxjfNBGoQpJtXTik6PDGK());
                }
                if (commandData_show != null && (showText = getShowText(commandData_show, msgUsage)) != null && !showText.isEmpty()) {
                    return Clans.getClanCore().getCommandManager().jBUuLP0sWwaPyPOmogdX7l(showText);
                }
            }
            String strBQaYnqGJlLrbfKXoXF1 = null;
            if (Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().get(commandData.getId()) == commandData) {
                strBQaYnqGJlLrbfKXoXF1 = bBF8PmrQh778fwz();
            } else if (Clans.getClanCore().getCommandManager().iZTqZaRK5UGoe0Z().get(commandData.getId()) == commandData) {
                strBQaYnqGJlLrbfKXoXF1 = bQaYnqGJlLrbfKXoXF1();
            }
            if (strBQaYnqGJlLrbfKXoXF1 == null) {
                return str2;
            }
            String str3 = "COMMANDS_" + strBQaYnqGJlLrbfKXoXF1 + "_" + commandData.getId();
            if (str != null && !str.isEmpty()) {
                str3 = str3 + "_subcommands_" + str;
            }
            String string = Clans.getClanCore().getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf(str3 + "_show_on_" + msgUsage.toString()));
            return (string == null || string.isEmpty()) ? str2 : Clans.getClanCore().getCommandManager().jBUuLP0sWwaPyPOmogdX7l(string);
        } catch (Exception e) {
            return str2;
        }
    }

    private static String getShowText(CommandData_show commandData_show, ClanEnum.MsgUsage msgUsage) {
        if (commandData_show == null || msgUsage == null) {
            return null;
        }
        switch (msgUsage) {
            case error:
                return commandData_show.getOn_error();
            case help:
                return commandData_show.getOn_help();
            case success:
                return commandData_show.getOn_success();
            case usage:
                return commandData_show.getOn_usage();
            default:
                return null;
        }
    }

    public static void sendText(UUID uuid, String str) {
        Player player;
        if ((uuid == null || (player = Bukkit.getPlayer(uuid)) == null || !queueForPlayerThread(player, () -> {
            sendText(uuid, str);
        })) && str.length() >= 1 && uuid != null) {
            Clans.getClanCore().getAdventure().player(uuid).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, str)));
        }
    }

    public static void sendText(CommandSender commandSender, String str) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (queueForPlayerThread(player, () -> {
                sendText((CommandSender) player, str);
            })) {
                return;
            }
        }
        String strJBUuLP0sWwaPyPOmogdX7l = Clans.getClanCore().getCommandManager().jBUuLP0sWwaPyPOmogdX7l(str);
        if (!(commandSender instanceof Player)) {
            Clans.getClanCore().getAdventure().sender(commandSender).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(strJBUuLP0sWwaPyPOmogdX7l));
            return;
        }
        Player player2 = (Player) commandSender;
        if (strJBUuLP0sWwaPyPOmogdX7l.length() >= 1 && player2.isOnline() && player2 != null) {
            Clans.getClanCore().getAdventure().player((Player) commandSender).sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player2.getUniqueId(), strJBUuLP0sWwaPyPOmogdX7l)));
        }
    }

    public static void sendText(CommandSender commandSender, Component component) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (queueForPlayerThread(player, () -> {
                sendText((CommandSender) player, component);
            })) {
                return;
            }
        }
        if (commandSender instanceof Player) {
            Clans.getClanCore().getAdventure().player((Player) commandSender).sendMessage(component);
        } else {
            Clans.getClanCore().getAdventure().sender(commandSender).sendMessage(component);
        }
    }

    public static void sendBroadcast(String str) {
        Audience audienceAll = Clans.getClanCore().getAdventure().all();
        if (audienceAll != null) {
            audienceAll.sendMessage(Clans.getClanCore().getColorManager().ZwrsrwOCXRUscW6Q(str));
        }
    }

    public static void allOnlineMessage(String str, List<String> list, List<Player> list2) {
        Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();
        if (onlinePlayers.size() > 0) {
            for (Player player : onlinePlayers) {
                if (list2 == null || !list2.contains(player)) {
                    sendText((CommandSender) player, str);
                }
            }
        }
    }

    public static void clanMessageJson(ClanData clanData, ClanEnum.ChatDataType chatDataType, List<String> list) {
        List<UUID> onlineMembers = clanData.getOnlineMembers();
        if (onlineMembers.size() > 0) {
            Iterator<UUID> it = onlineMembers.iterator();
            while (it.hasNext()) {
                try {
                    Player player = Bukkit.getPlayer(it.next());
                    if (player != null && !queueForPlayerThread(player, () -> {
                        t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, chatDataType, list, false, false, 0);
                    })) {
                        t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, chatDataType, list, false, false, 0);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    public static void clanMessageSend(ClanData clanData, String str) {
        clanData.getOnlineMembers().iterator().forEachRemaining(uuid -> {
            Player player = null;
            try {
                player = Bukkit.getPlayer(uuid);
            } catch (Exception e) {
            }
            if (player != null) {
                sendText((CommandSender) player, str);
            }
        });
    }

    public static void clanMessageSend(ClanData clanData, String str, List<UUID> list) {
        Iterator<UUID> it = clanData.getOnlineMembers().iterator();
        while (it.hasNext()) {
            Player player = null;
            try {
                player = Bukkit.getPlayer(it.next());
            } catch (Exception e) {
            }
            if (player != null && !list.contains(player.getUniqueId())) {
                sendText((CommandSender) player, str);
            }
        }
    }

    public static void clanModerationMessageSend(ClanData clanData, String str) {
        clanData.getOnlineMembers().iterator().forEachRemaining(uuid -> {
            try {
                Player player = Bukkit.getPlayer(uuid);
                if (Clans.getClanCore().getPlayerManager().vVo2VUvxrriklPdRxI(uuid) || clanData.getMods().contains(uuid)) {
                    sendText((CommandSender) player, str);
                }
            } catch (Exception e) {
            }
        });
    }

    private static String M0BwkW7b9zh61rUCmA(byte[] bArr) {
        return "";
    }

    private static String Uj0QHcdqRggIcf8ID() {
        return ";";
    }

    private static String BXBFwOoHpJc2lKI8za() {
        return "Config.confirm";
    }

    private static String yFOZhxMzMPJNeund() {
        return "Config.confirm";
    }

    private static String aYHEH1r6DWCFyKX6m3w9Q() {
        return "%confirm_action%";
    }

    private static String e1VJqDOLfueFG0g() {
        return "Config.confirm";
    }

    private static String KuHt8YAmx5isw4kAq2g() {
        return "%tag%";
    }

    private static String qNjCfmWtWuLCkPhM9K83e() {
        return ";";
    }

    private static String JA3YquM36cloGZqY8() {
        return ";";
    }

    private static String KGK9dTgZ6xT8nyuTI() {
        return "%nl%";
    }

    private static String ioUHUoRaw41c814PVhS() {
        return "%nl%";
    }

    private static String usJkQP3i9IbvfXNrqd() {
        return ";";
    }

    private static String U3XKd8UfdARDQN3NHGr() {
        return "%tag%";
    }

    private static String FxjfNBGoQpJtXTik6PDGK() {
        return "EN";
    }

    private static String bBF8PmrQh778fwz() {
        return "clan";
    }

    private static String bQaYnqGJlLrbfKXoXF1() {
        return "uclan";
    }
}
