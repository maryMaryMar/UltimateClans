package me.module.home.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;
import me.module.home.Home;
import me.module.home.manager.EnumFiles.Lang;
import me.module.home.manager.b;
import me.module.home.manager.d;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.HomesData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/commands/HomeCommand.class */
public class HomeCommand implements ClansCommand, TabCompleter {
    private static byte[] __aes_key_LQ9dldcn = {(byte) 13, (byte) 190, (byte) 130, (byte) 156, (byte) 222, (byte) 82, (byte) 226, (byte) 217, (byte) 170, (byte) 57, (byte) 214, (byte) 202, (byte) 215, (byte) 3, (byte) 7, (byte) 2, (byte) 185, (byte) 230, (byte) 179, (byte) 54, (byte) 5, (byte) 168, (byte) 97, (byte) 125, (byte) 189, (byte) 179, (byte) 153, (byte) 37, (byte) 60, (byte) 32, (byte) 140, (byte) 226};
    private static byte[] __aes_iv_pMUsyos6 = {(byte) 175, (byte) 54, (byte) 44, (byte) 212, (byte) 167, (byte) 211, (byte) 124, (byte) 132, (byte) 248, (byte) 2, (byte) 203, (byte) 106, (byte) 205, (byte) 188, (byte) 150, (byte) 80};
    private static String __s_cache_5rLoCgEG_0;
    private static String __s_cache_nTXsleKN_1;
    private static String __s_cache_br8bsVnI_2;
    private static String __s_cache_rk8EryHE_3;
    private static String __s_cache_MpLf4Vqy_4;
    private static String __s_cache_6hYIuxLM_5;
    private static String __s_cache_gD69ad97_6;
    private static String __s_cache_vcpVOTNQ_7;
    private static String __s_cache_zgg9oWLR_8;
    private static String __s_cache_WBJDXlzZ_9;
    private static String __s_cache_Pt35svrB_10;
    private static String __s_cache_3mwfRIxz_11;
    private static String __s_cache_PkRuOv8J_12;
    private static String __s_cache_eOh0JDnb_13;
    private static String __s_cache_NoSAK7nr_14;
    private static String __s_cache_yaKc2Dr5_15;
    private static String __s_cache_nljtfcKs_16;
    private static String __s_cache_aOfDOmaa_17;
    private static String __s_cache_zU0Mo0mp_18;
    private static String __s_cache_fQz3DL1l_19;
    private static String __s_cache_L9AQWDVd_20;
    private static String __s_cache_raqQtmCk_21;
    private static String __s_cache_nTsyYX93_22;
    private static String __s_cache_5TVCW1Q9_23;
    private static String __s_cache_vP77xXcf_24;

    public List<String> onTabComplete(CommandSender commandSender, Command command, String str, String[] strArr) {
        return new ArrayList();
    }

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        Optional<ClanData> playerClan;
        if (!clans.getCommandAPI().getClanCommander().containsKey("home")) {
            MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandAPI().getClanCommander().get("home");
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase("create") || clans.getCommandAPI().findAliases("create", str2)) {
            if (strArr.length > 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> playerClan2 = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
            if (!playerClan2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getModAPI().playerHasPermission(player.getUniqueId(), Home.getModuleCore().c().i().getString("Config.Permissions.manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            int size = playerClan2.get().getHome() == null ? 0 : playerClan2.get().getHome().size();
            int iHomeCount = Home.getModuleCore().e().homeCount(playerClan2.get());
            if (size >= iHomeCount) {
                MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.HOME_LIMIT_REACHED, Arrays.asList("%homes%;" + iHomeCount)));
                return true;
            }
            String str3 = null;
            Optional<String> optionalEmpty = Optional.empty();
            try {
                str3 = strArr[1];
            } catch (Exception e) {
            }
            if (strArr.length == 3 && strArr[2] != null) {
                optionalEmpty = Optional.of(strArr[2]);
            }
            if (str3 == null) {
                if (b.a(player, "home_create", false, Optional.empty())) {
                    return true;
                }
                Home.a().getLibAPI().startChat(player, d.a(player, "clanhomecreate").onResponse((player2, str4) -> {
                    if (Home.getModuleCore().e().tryCreateHome(player2, str4, Optional.empty())) {
                        MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                    }
                }).onCancel(player3 -> {
                    MessageUtils.sendText((CommandSender) player3, Home.getModuleCore().c().a(commandSender).getString(Lang.CLAN_ACTIONS_EXPIRED));
                }).build());
                return true;
            }
            if (!Home.getModuleCore().e().tryCreateHome(player, str3, optionalEmpty)) {
                return true;
            }
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
            return true;
        }
        if (str2.equalsIgnoreCase("delete") || clans.getCommandAPI().findAliases("delete", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (!clans.getPlayerAPI().getPlayerClan(player.getUniqueId()).isPresent()) {
                MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            String str5 = null;
            try {
                str5 = strArr[1];
            } catch (Exception e2) {
            }
            if (!clans.getModAPI().playerHasPermission(player.getUniqueId(), Home.getModuleCore().c().i().getString("Config.Permissions.manager.name"))) {
                MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (str5 == null) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
            }
            if (!Home.getModuleCore().e().hasHome(player.getUniqueId(), str5)) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
            if (Home.getModuleCore().e().deleteHome(player.getUniqueId(), str5)) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (str2.equalsIgnoreCase("list") || clans.getCommandAPI().findAliases("list", str2)) {
            if (strArr.length > 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional.empty();
            if (!(commandSender instanceof Player) || strArr.length < 2 || strArr[1].equalsIgnoreCase("-gui")) {
                playerClan = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
            } else {
                playerClan = clans.getClanAPI().getClanDataByTag(strArr[1]);
                if (playerClan.isPresent() && !Home.getModuleCore().c().i().getBoolean("Config.Home.public") && !clans.getPlayerAPI().isSameClan(player.getUniqueId(), playerClan.get().getLeader())) {
                    playerClan = Optional.empty();
                }
            }
            if (!playerClan.isPresent()) {
                MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.CLAN_DOES_NOT_EXISTS));
                return true;
            }
            if ((commandSender instanceof Player) && clans.isUseGUI() && ((strArr.length == 2 && strArr[1].equalsIgnoreCase("-gui")) || (strArr.length == 3 && strArr[2].equalsIgnoreCase("-gui")))) {
                Home.getModuleCore().h().e().a(player, playerClan.get().getId(), (String) null);
                return true;
            }
            MessageUtils.sendText(commandSender, Home.getModuleCore().e().parseText(playerClan.get().getLeader(), clans.getClanAPI().parseText(playerClan.get().getLeader(), Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HOME_LIST_HEADER))));
            List<HomesData> home = playerClan.get().getHome();
            if (home == null || home.size() == 0) {
                MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.CLAN_LIST_EMPTY));
                return true;
            }
            int i = 0;
            for (HomesData homesData : home) {
                if (homesData.getServer() != null) {
                    int i2 = i;
                    String string = Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HOME_LIST_FORMAT);
                    if (!Home.getModuleCore().c().i().getBoolean("Config.Home.public") && !clans.getPlayerAPI().isSameClan(player.getUniqueId(), playerClan.get().getLeader())) {
                        string = Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HOME_LIST_FORMAT_VISIT);
                    }
                    MessageUtils.sendText(commandSender, Home.getModuleCore().e().parseText(playerClan.get().getLeader(), clans.getClanAPI().parseText(playerClan.get().getLeader(), string.replace("{num}", String.valueOf(i2)).replace("{name}", "{" + homesData.getName() + "}"))));
                    i++;
                }
            }
            return true;
        }
        if (str2.equalsIgnoreCase("view") || clans.getCommandAPI().findAliases("view", str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            String lowerCase = null;
            try {
                lowerCase = strArr[1].toLowerCase();
            } catch (Exception e3) {
            }
            if (lowerCase == null) {
                MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<HomesData> homeData = Home.getModuleCore().e().getHomeData(player.getUniqueId(), lowerCase);
            if (!homeData.isPresent()) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
            MessageUtils.sendText(commandSender, Home.getModuleCore().e().parseText(player.getUniqueId(), clans.getClanAPI().parseText(player.getUniqueId(), Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HOME_VIEW_HEADER))));
            Home.getModuleCore().c().a(commandSender).getStringList(Lang.HELP_CLAN_HOME_VIEW_FORMAT, Arrays.asList("{name};{" + homeData.get().getName() + "}")).iterator().forEachRemaining(str6 -> {
                MessageUtils.sendText(commandSender, Home.getModuleCore().e().parseText(player.getUniqueId(), clans.getClanAPI().parseText(player.getUniqueId(), str6)));
            });
            return true;
        }
        if (!str2.equalsIgnoreCase("teleport") && !clans.getCommandAPI().findAliases("teleport", str2)) {
            MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandAPI().showHelpSubmessage(commandSender, commandData);
            return true;
        }
        if (strArr.length > 3) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> playerClan3 = clans.getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan3.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        String name = null;
        if (playerClan3.get().getHome().size() == 1 && strArr.length == 0 && (clans.getPlayerAPI().isLeader(player.getUniqueId(), playerClan3.get().getId()) || clans.getModAPI().playerHasPermission(player.getUniqueId(), Home.getModuleCore().c().i().getString("Config.Permissions.manager.name")) || !playerClan3.get().getHome().get(0).getPassword().isPresent())) {
            name = playerClan3.get().getHome().get(0).getName();
        }
        if (name == null) {
            try {
                name = strArr[1];
            } catch (Exception e4) {
            }
        }
        String str7 = strArr.length == 3 ? strArr[2] : null;
        if (name == null) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (clans.getHooksAPI().isInCombat(player)) {
            MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.PLAYER_TELEPORT_FALSE));
            return true;
        }
        Optional<HomesData> homeData2 = Home.getModuleCore().e().getHomeData(player.getUniqueId(), name);
        if (!homeData2.isPresent()) {
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (homeData2.get().getPassword().isPresent() && !clans.getPlayerAPI().isLeader(player.getUniqueId(), playerClan3.get().getId()) && !clans.getModAPI().playerHasPermission(player.getUniqueId(), Home.getModuleCore().c().i().getString("Config.Permissions.manager.name"))) {
            if (str7 == null) {
                MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HOME_REQUIRES_PASSWD));
                return true;
            }
            if (!homeData2.get().getPassword().get().equals(str7)) {
                MessageUtils.sendText(commandSender, Home.getModuleCore().c().a(commandSender).getString(Lang.HELP_CLAN_HOME_WRONG_PASSWD));
                return true;
            }
        }
        Optional<EncodedLocationData> encodedHomeLocation = Home.getModuleCore().e().getEncodedHomeLocation(player.getUniqueId(), name);
        if (encodedHomeLocation.isPresent()) {
            clans.getClanAPI().teleportDelay(player, encodedHomeLocation, true);
            return true;
        }
        MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
        return true;
    }

    private static String __unused_429() {
        return "home";
    }

    private static String __unused_430() {
        return "home";
    }

    private static String __unused_431() {
        return "create";
    }

    private static String __unused_432() {
        return "create";
    }

    private static String __unused_433() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_434() {
        return "home_create";
    }

    private static String __unused_435() {
        return "clanhomecreate";
    }

    private static String __unused_436() {
        return "delete";
    }

    private static String __unused_437() {
        return "delete";
    }

    private static String __unused_438() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_439() {
        return "list";
    }

    private static String __unused_440() {
        return "list";
    }

    private static String __unused_441() {
        return "-gui";
    }

    private static String __unused_442() {
        return "Config.Home.public";
    }

    private static String __unused_443() {
        return "-gui";
    }

    private static String __unused_444() {
        return "-gui";
    }

    private static String __unused_445() {
        return "Config.Home.public";
    }

    private static String __unused_446() {
        return "{num}";
    }

    private static String __unused_447() {
        return "{name}";
    }

    private static String __unused_448() {
        return "view";
    }

    private static String __unused_449() {
        return "view";
    }

    private static String __unused_450() {
        return "teleport";
    }

    private static String __unused_451() {
        return "teleport";
    }

    private static String __unused_452() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_453() {
        return "Config.Permissions.manager.name";
    }
}
