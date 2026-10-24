package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.Module;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/aKbPiHspMivN0z046nNK.class */
public class aKbPiHspMivN0z046nNK implements ClansCommand {
    private static String QP3W9Zf07QOUJPdF;
    private static volatile String BWJhVlYpld4mDzPf6;
    private static String cEf5eh6sUhKBnCfqnVl;
    private static volatile String c1C2IJjwB83jNbvNOj;
    private static String LQp1sym1htwKi6aj;
    private static String ysCw27bEpqcCJEZ;
    private static String cuIHRC2FshLiSSWqkdmNq;
    private static volatile String dEx1xOvEgkTeZholj7P;
    private static volatile String UGsRsXLjagWaWS;
    private static volatile String EjADASl2M1ZwbG;
    private static String Z9fVRv4XQuGFtlElJtv8OB;
    private static String viiccmfHhLMmEJl;
    private static volatile String iW0lsDizzZQLYQpDoC;
    private static final byte[] atdPdxokcpHoBUYyl1tZ = {(byte) 119, (byte) 124, (byte) 55, (byte) 32, (byte) 230, (byte) 211, (byte) 89, (byte) 161, (byte) 92, (byte) 150, (byte) 104, (byte) 46, (byte) 204, (byte) 198, (byte) 139, (byte) 1};
    private static final byte[] g4QQCuqv0F258yCiNmSOp = {(byte) 141, (byte) 15, (byte) 251, (byte) 112, (byte) 135, (byte) 73, (byte) 35, (byte) 140, (byte) 178, (byte) 217, (byte) 229, (byte) 126, (byte) 5, (byte) 33, (byte) 68, (byte) 45, (byte) 78, (byte) 130, (byte) 214, (byte) 67, (byte) 81, (byte) 166, (byte) 216, (byte) 15, (byte) 183, (byte) 86, (byte) 110, (byte) 231, (byte) 120, (byte) 47, (byte) 188, (byte) 149, (byte) 164, (byte) 61, (byte) 90, (byte) 121, (byte) 194, (byte) 231, (byte) 123, (byte) 121, (byte) 118, (byte) 1, (byte) 76, (byte) 159, (byte) 130, (byte) 208, (byte) 178, (byte) 147, (byte) 139, (byte) 150, (byte) 221, (byte) 103, (byte) 248, (byte) 198, (byte) 131, (byte) 153, (byte) 252, (byte) 85, (byte) 236, (byte) 15, (byte) 247, (byte) 139, (byte) 90, (byte) 45, (byte) 186, (byte) 200, (byte) 109, (byte) 177, (byte) 182, (byte) 130, (byte) 167, (byte) 229, (byte) 114, (byte) 13, (byte) 6, (byte) 87, (byte) 12, (byte) 38, (byte) 50, (byte) 175};
    private static final byte[] zOlgCVVqmuZQSX = {(byte) 119, (byte) 124, (byte) 55, (byte) 32, (byte) 230, (byte) 211, (byte) 89, (byte) 161, (byte) 92, (byte) 150, (byte) 104, (byte) 46, (byte) 204, (byte) 198, (byte) 139, (byte) 1};
    private static final byte[] SE83rSXUdIflKTasEjUU = {(byte) 174, (byte) 132, (byte) 192, (byte) 233, (byte) 122, (byte) 25, (byte) 241, (byte) 208, (byte) 193, (byte) 16, (byte) 56, (byte) 137, (byte) 191, (byte) 24, (byte) 26, (byte) 40};
    private static final byte[] QS8rKHWhmAadRcAT0p8p = {(byte) 192, (byte) 43, (byte) 178, (byte) 105, (byte) 130, (byte) 32, (byte) 82, (byte) 100, (byte) 158, (byte) 57, (byte) 202, (byte) 129, (byte) 4, (byte) 131, (byte) 126, (byte) 50};
    private static final byte[] Lfom3Hm8JxWXS8Ci4s0O8 = {(byte) 238, (byte) 189, (byte) 193, (byte) 55, (byte) 79, (byte) 139, (byte) 97, (byte) 254, (byte) 113, (byte) 88, (byte) 92, (byte) 7, (byte) 118, (byte) 81, (byte) 242, (byte) 38, (byte) 182, (byte) 30, (byte) 160, (byte) 128, (byte) 142, (byte) 138, (byte) 85, (byte) 145, (byte) 215, (byte) 193, (byte) 208, (byte) 39, (byte) 55, (byte) 234, (byte) 198, (byte) 134};
    private static final byte[] zcFTocCasqY5HXBtn81hp = {(byte) 57, (byte) 106, (byte) 126, (byte) 240, (byte) 26, (byte) 233, (byte) 193, (byte) 130, (byte) 160, (byte) 210, (byte) 221, (byte) 55, (byte) 45, (byte) 102, (byte) 66, (byte) 72};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(JRsLTHbBRqbvezoz())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(ubDecS7xBvnm1hmHQkVU());
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        if (!commandData.getSubcommands().containsKey(str2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (str2.equalsIgnoreCase(Tzfoyp8BQgCtRCOK2M())) {
            if (strArr.length < 1 || strArr.length > 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_HEADER));
            HashMap<Module, Boolean> moduleEnabledList = clans.getModuleEnabledList();
            if (moduleEnabledList.size() == 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
                return true;
            }
            try {
                int i = 0;
                for (Map.Entry<Module, Boolean> entry : moduleEnabledList.entrySet()) {
                    MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_FORMAT, Arrays.asList("{num};" + i, "{id};" + entry.getKey().getName(), "{name};" + entry.getKey().getName(), "{state};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entry.getValue()).toUpperCase())))));
                    i++;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(JeG2PRw0YWSlamv())) {
            if (strArr.length < 1 || strArr.length > 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_ALL_HEADER));
            List<ClanEnum.ClansModules> listAsList = Arrays.asList(ClanEnum.ClansModules.values());
            if (listAsList.size() == 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
                return true;
            }
            try {
                int i2 = 0;
                for (ClanEnum.ClansModules clansModules : listAsList) {
                    boolean zZJnaNCVQSgEShq = new jBWyXxi9EyWxcPiz(clans).zJnaNCVQSgEShq(clansModules.toString());
                    Map.Entry<Module, Boolean> entryIZTqZaRK5UGoe0Z = new jBWyXxi9EyWxcPiz(clans).iZTqZaRK5UGoe0Z(clansModules.toString());
                    boolean zBooleanValue = false;
                    if (entryIZTqZaRK5UGoe0Z != null) {
                        zBooleanValue = entryIZTqZaRK5UGoe0Z.getValue().booleanValue();
                    }
                    MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_ALL_FORMAT, Arrays.asList("{num};" + i2, "{id};" + clansModules.toString(), "{name};" + clansModules.toString(), "{downloaded};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_DOWNLOADED_" + String.valueOf(zZJnaNCVQSgEShq).toUpperCase())), "{state};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(zBooleanValue).toUpperCase())))));
                    i2++;
                }
                return true;
            } catch (Exception e2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(Z7xXN6T8FzXDvh9Iwo3())) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            ClanEnum.ClansModules clansModulesValueOf = null;
            try {
                clansModulesValueOf = ClanEnum.ClansModules.valueOf(strArr[1]);
            } catch (Exception e3) {
            }
            if (clansModulesValueOf == null) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_NOT_EXIST));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).zJnaNCVQSgEShq(clansModulesValueOf.toString())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_NOT_ENABLED));
                return true;
            }
            try {
                Map.Entry<Module, Boolean> entryIZTqZaRK5UGoe0Z2 = new jBWyXxi9EyWxcPiz(clans).iZTqZaRK5UGoe0Z(clansModulesValueOf.toString());
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_VIEW_HEADER));
                clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getStringList(Lang.CLAN_MODULE_VIEW_FORMAT, Arrays.asList("{name};" + entryIZTqZaRK5UGoe0Z2.getKey().getName(), "{status};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entryIZTqZaRK5UGoe0Z2.getValue()).toUpperCase())), "{author};" + entryIZTqZaRK5UGoe0Z2.getKey().getAuthor(), "{version};" + entryIZTqZaRK5UGoe0Z2.getKey().getVersion(), "{description};" + entryIZTqZaRK5UGoe0Z2.getKey().getDescription())).iterator().forEachRemaining(str3 -> {
                    MessageUtils.sendText(commandSender, str3);
                });
                return true;
            } catch (Exception e4) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(SlPhdThfkyho4NZ())) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (strArr.length > 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
                return true;
            }
            ClanEnum.ClansModules clansModulesValueOf2 = null;
            try {
                clansModulesValueOf2 = ClanEnum.ClansModules.valueOf(strArr[1]);
            } catch (Exception e5) {
            }
            if (clansModulesValueOf2 == null) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_NOT_EXIST));
                return true;
            }
            if (new jBWyXxi9EyWxcPiz(clans).zJnaNCVQSgEShq(clansModulesValueOf2.toString())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_ALREADY_ENABLED));
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender, clansModulesValueOf2, false, false);
            return true;
        }
        if (str2.equalsIgnoreCase(I656coMcq4njIxJo0NLj())) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (strArr.length > 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
                return true;
            }
            ClanEnum.ClansModules clansModulesValueOf3 = null;
            try {
                clansModulesValueOf3 = ClanEnum.ClansModules.valueOf(strArr[1]);
            } catch (Exception e6) {
            }
            if (clansModulesValueOf3 == null) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_NOT_EXIST));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).xtOheRiObl4QeAl(clansModulesValueOf3.toString())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MODULE_NOT_ENABLED));
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender, clansModulesValueOf3, true, false);
            return true;
        }
        if (!str2.equalsIgnoreCase(Wt8MCqXYA94ooHnddW())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (CooldownAPI.isInCooldown(clans.getPluginUUID(), BftRL9iTVmsgDK2Liywg())) {
            commandSender.sendMessage(new String[0]);
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', NpmAea1e4Ltl3PitjgGW()));
            return true;
        }
        if (strArr.length != 1) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        new CooldownAPI(clans.getPluginUUID(), h4jiuHneNZo62rmDnuFk6(), 4).start();
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', vH5tpJI6uIx3axvq5()));
        clans.pluginDisableModules(false);
        clans.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
            clans.loadModules();
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList(rNChgih0L0wZ5SID()));
        }, 40L);
        return true;
    }

    private static String JRsLTHbBRqbvezoz() {
        return "module";
    }

    private static String ubDecS7xBvnm1hmHQkVU() {
        return "module";
    }

    private static String Tzfoyp8BQgCtRCOK2M() {
        return "list";
    }

    private static String JeG2PRw0YWSlamv() {
        return "all";
    }

    private static String Z7xXN6T8FzXDvh9Iwo3() {
        return "view";
    }

    private static String SlPhdThfkyho4NZ() {
        return "download";
    }

    private static String I656coMcq4njIxJo0NLj() {
        return "update";
    }

    private static String Wt8MCqXYA94ooHnddW() {
        return "reload";
    }

    private static String BftRL9iTVmsgDK2Liywg() {
        return "reload";
    }

    private static String NpmAea1e4Ltl3PitjgGW() {
        return "&6&lU&9&lClans &7| &cModules are already restarting, please wait...";
    }

    private static String h4jiuHneNZo62rmDnuFk6() {
        return "reload";
    }

    private static String vH5tpJI6uIx3axvq5() {
        return "&6&lU&9&lClans &7| &cPlease wait, the modules is restarting and this may take a few seconds.";
    }

    private static String rNChgih0L0wZ5SID() {
        return "%time%;No counting!";
    }
}
