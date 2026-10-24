package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/jfN3Uc9ymXXFWVHj7Oor.class */
public class jfN3Uc9ymXXFWVHj7Oor implements ClansCommand {
    private static String DSZSUQCZtiLNBSbIe;
    private static volatile String tQ4IIEiHChzHQrKnsSebp;
    private static String psMHYhhfKP9BOYVv0S;
    private static volatile String kRPyEOCN2F33Mox;
    private static String UQTdCuYxApCTGg0OCSbLG;
    private static String thr6HKa3vO7P4O0R1;
    private static String MuMrN3sp4nw43k6s4jr;
    private static volatile String nMyI89thq0ExKc0;
    private static String jpQaHVhEV7KqjjB;
    private static String JPCZZQz8OUY3sl2k;
    private static volatile String RBLughS8RJysrhhAJMgR;
    private static volatile String OK31pWwsboEQioc;
    private static String mcBLhuQQllYqoeIwy;
    private static final byte[] o3K6T0OVia71dOB = {(byte) 27, (byte) 97, (byte) 237, (byte) 163, (byte) 86, (byte) 97, (byte) 53, (byte) 46, (byte) 149, (byte) 227, (byte) 201, (byte) 167, (byte) 255, (byte) 195, (byte) 71, (byte) 254, (byte) 29, (byte) 192, (byte) 132, (byte) 25, (byte) 236, (byte) 154, (byte) 113, (byte) 50, (byte) 85, (byte) 26, (byte) 218, (byte) 190, (byte) 242, (byte) 148, (byte) 156, (byte) 51};
    private static final byte[] pj9LHgMUUvi2DYr = {(byte) 54, (byte) 244, (byte) 199, (byte) 131, (byte) 153, (byte) 246, (byte) 3, (byte) 119, (byte) 205, (byte) 226, (byte) 245, (byte) 96, (byte) 0, (byte) 188, (byte) 147, (byte) 14, (byte) 235, (byte) 236, (byte) 146, (byte) 26, (byte) 248, (byte) 239, (byte) 223, (byte) 144, (byte) 238, (byte) 54, (byte) 32, (byte) 44, (byte) 3, (byte) 236, (byte) 116, (byte) 198, (byte) 182, (byte) 30, (byte) 114, (byte) 253, (byte) 138, (byte) 235, (byte) 216, (byte) 140, (byte) 156, (byte) 245, (byte) 24, (byte) 105, (byte) 114, (byte) 60, (byte) 185, (byte) 220, (byte) 86, (byte) 65, (byte) 226, (byte) 215, (byte) 26, (byte) 247, (byte) 26, (byte) 152, (byte) 73, (byte) 82, (byte) 101, (byte) 62, (byte) 165, (byte) 4, (byte) 37, (byte) 184, (byte) 54, (byte) 27, (byte) 73, (byte) 225, (byte) 252, (byte) 15, (byte) 104, (byte) 71, (byte) 247, (byte) 85, (byte) 95, (byte) 32, (byte) 93, (byte) 168, (byte) 143, (byte) 111, (byte) 25, (byte) 195, (byte) 154, (byte) 36, (byte) 121, (byte) 73, (byte) 140, (byte) 61, (byte) 149, (byte) 135, (byte) 248, (byte) 124, (byte) 209, (byte) 12, (byte) 18, (byte) 19};
    private static final byte[] LT4DD18ikRVYhngPOZQTH = {(byte) 57, (byte) 133, (byte) 15, (byte) 204, (byte) 232, (byte) 236, (byte) 114, (byte) 171, (byte) 73, (byte) 151, (byte) 255, (byte) 138, (byte) 155, (byte) 177, (byte) 234, (byte) 51};
    private static final byte[] t8YcSr7l3ubH62qYtn6 = {(byte) 57, (byte) 133, (byte) 15, (byte) 204, (byte) 232, (byte) 236, (byte) 114, (byte) 171, (byte) 73, (byte) 151, (byte) 255, (byte) 138, (byte) 155, (byte) 177, (byte) 234, (byte) 51};
    private static final byte[] duuPNavsVI4vBigFszC = {(byte) 57, (byte) 133, (byte) 15, (byte) 204, (byte) 232, (byte) 236, (byte) 114, (byte) 171, (byte) 73, (byte) 151, (byte) 255, (byte) 138, (byte) 155, (byte) 177, (byte) 234, (byte) 51};
    private static final byte[] FnSa1FslggLwYR0O = {(byte) 120, (byte) 149, (byte) 249, (byte) 186, (byte) 100, (byte) 185, (byte) 23, (byte) 191, (byte) 188, (byte) 157, (byte) 212, (byte) 145, (byte) 77, (byte) 45, (byte) 73, (byte) 20};
    private static final byte[] b2b8XLe8FxyZAL8su = {(byte) 192, (byte) 171, (byte) 51, (byte) 34, (byte) 230, (byte) 174, (byte) 215, (byte) 46, (byte) 172, (byte) 111, (byte) 65, (byte) 158, (byte) 164, (byte) 52, (byte) 14, (byte) 164};
    private static final byte[] jzHzJGamXMl59ngf = {(byte) 82, (byte) 72, (byte) 7, (byte) 198, (byte) 37, (byte) 201, (byte) 119, (byte) 127, (byte) 245, (byte) 176, (byte) 235, (byte) 77, (byte) 17, (byte) 249, (byte) 208, (byte) 6};
    private static final byte[] WkFO7lYzjWoT9RYW = {(byte) 140, (byte) 112, (byte) 69, (byte) 189, (byte) 61, (byte) 150, (byte) 74, (byte) 147, (byte) 122, (byte) 222, (byte) 151, (byte) 143, (byte) 169, (byte) 175, (byte) 142, (byte) 207};
    private static final byte[] Eb2YlZritkN8dn1A2 = {(byte) 70, (byte) 127, (byte) 9, (byte) 77, (byte) 211, (byte) 242, (byte) 167, (byte) 102, (byte) 36, (byte) 147, (byte) 113, (byte) 13, (byte) 89, (byte) 221, (byte) 157, (byte) 166, (byte) 139, (byte) 149, (byte) 83, (byte) 80, (byte) 49, (byte) 159, (byte) 111, (byte) 16, (byte) 167, (byte) 75, (byte) 143, (byte) 93, (byte) 154, (byte) 97, (byte) 167, (byte) 105};
    private static final byte[] ugFvSjbRcZiWK1 = {(byte) 2, (byte) 58, (byte) 210, (byte) 46, (byte) 247, (byte) 180, (byte) 35, (byte) 220, (byte) 81, (byte) 248, (byte) 115, (byte) 22, (byte) 163, (byte) 58, (byte) 54, (byte) 167};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(CAxzknT3c99BGgHCy())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(Ihhb4acNeEsz3GO9JB());
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
        if (str2.equalsIgnoreCase(oFx01D1ce8q1vYB9n6())) {
            if (strArr.length < 1 || strArr.length > 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_HEADER));
            HashMap<Extension, Boolean> extensionEnabledList = clans.getExtensionEnabledList();
            if (extensionEnabledList.size() == 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
                return true;
            }
            try {
                int i = 0;
                for (Map.Entry<Extension, Boolean> entry : extensionEnabledList.entrySet()) {
                    MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_FORMAT, Arrays.asList("{num};" + i, "{id};" + entry.getKey().getName(), "{name};" + entry.getKey().getName(), "{state};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entry.getValue()).toUpperCase())))));
                    i++;
                }
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.error, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(mjiSPBpj47hp5eo())) {
            if (strArr.length < 1 || strArr.length > 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_ALL_HEADER));
            List<ClanEnum.ClansExtensions> listAsList = Arrays.asList(ClanEnum.ClansExtensions.values());
            if (listAsList.size() == 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
                return true;
            }
            try {
                int i2 = 0;
                for (ClanEnum.ClansExtensions clansExtensions : listAsList) {
                    boolean zZwrsrwOCXRUscW6Q = new jBWyXxi9EyWxcPiz(clans).ZwrsrwOCXRUscW6Q(clansExtensions.toString());
                    Map.Entry<Extension, Boolean> entryV8qP8fE86HMhvNuYPFjqY = new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(clansExtensions.toString());
                    boolean zBooleanValue = false;
                    if (entryV8qP8fE86HMhvNuYPFjqY != null) {
                        zBooleanValue = entryV8qP8fE86HMhvNuYPFjqY.getValue().booleanValue();
                    }
                    MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_ALL_FORMAT, Arrays.asList("{num};" + i2, "{id};" + clansExtensions.toString(), "{name};" + clansExtensions.toString(), "{downloaded};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_DOWNLOADED_" + String.valueOf(zZwrsrwOCXRUscW6Q).toUpperCase())), "{state};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(zBooleanValue).toUpperCase())))));
                    i2++;
                }
                return true;
            } catch (Exception e2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(IGlkTLxdIDoqtkPTJX7pc())) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            ClanEnum.ClansExtensions clansExtensionsValueOf = null;
            try {
                clansExtensionsValueOf = ClanEnum.ClansExtensions.valueOf(strArr[1]);
            } catch (Exception e3) {
            }
            if (clansExtensionsValueOf == null) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_NOT_EXIST));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).ZwrsrwOCXRUscW6Q(clansExtensionsValueOf.toString())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_NOT_ENABLED));
                return true;
            }
            try {
                Map.Entry<Extension, Boolean> entryV8qP8fE86HMhvNuYPFjqY2 = new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(clansExtensionsValueOf.toString());
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_VIEW_HEADER));
                clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getStringList(Lang.CLAN_EXTENSION_VIEW_FORMAT, Arrays.asList("{name};" + entryV8qP8fE86HMhvNuYPFjqY2.getKey().getName(), "{status};" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entryV8qP8fE86HMhvNuYPFjqY2.getValue()).toUpperCase())), "{author};" + entryV8qP8fE86HMhvNuYPFjqY2.getKey().getAuthor(), "{version};" + entryV8qP8fE86HMhvNuYPFjqY2.getKey().getVersion(), "{description};" + entryV8qP8fE86HMhvNuYPFjqY2.getKey().getDescription())).iterator().forEachRemaining(str3 -> {
                    MessageUtils.sendText(commandSender, str3);
                });
                return true;
            } catch (Exception e4) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(IQrOalgDooCTQYPZ5Of())) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (strArr.length > 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
                return true;
            }
            ClanEnum.ClansExtensions clansExtensionsValueOf2 = null;
            try {
                clansExtensionsValueOf2 = ClanEnum.ClansExtensions.valueOf(strArr[1]);
            } catch (Exception e5) {
            }
            if (clansExtensionsValueOf2 == null) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_NOT_EXIST));
                return true;
            }
            if (new jBWyXxi9EyWxcPiz(clans).ZwrsrwOCXRUscW6Q(clansExtensionsValueOf2.toString())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_ALREADY_ENABLED));
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender, clansExtensionsValueOf2, false, false);
            return true;
        }
        if (str2.equalsIgnoreCase(uBsXda605x2mscO())) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (strArr.length > 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
                return true;
            }
            ClanEnum.ClansExtensions clansExtensionsValueOf3 = null;
            try {
                clansExtensionsValueOf3 = ClanEnum.ClansExtensions.valueOf(strArr[1]);
            } catch (Exception e6) {
            }
            if (clansExtensionsValueOf3 == null) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_NOT_EXIST));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).jBUuLP0sWwaPyPOmogdX7l(clansExtensionsValueOf3.toString())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_EXTENSION_NOT_ENABLED));
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender, clansExtensionsValueOf3, true, false);
            return true;
        }
        if (!str2.equalsIgnoreCase(Y2cjqaCWnnbOtLR6FbvlJj())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (CooldownAPI.isInCooldown(clans.getPluginUUID(), Ob8iSSv0t9BMw55gTrC())) {
            commandSender.sendMessage(new String[0]);
            commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', onsyNq4jUmzat4O8pZh()));
            return true;
        }
        if (strArr.length != 1) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        new CooldownAPI(clans.getPluginUUID(), EbF7pOzRV7j1dja6DaZk(), 4).start();
        commandSender.sendMessage(ChatColor.translateAlternateColorCodes('&', pZBatxNc35JqTdZgr()));
        clans.pluginDisableExtensions(true);
        clans.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
            clans.loadExtensions();
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList(b3EjBVAGQwPTeG()));
        }, 40L);
        return true;
    }

    private static String KxzJg6WEOYf6YvhUz(byte[] bArr) {
        return "";
    }

    private static String CAxzknT3c99BGgHCy() {
        return "extension";
    }

    private static String Ihhb4acNeEsz3GO9JB() {
        return "extension";
    }

    private static String oFx01D1ce8q1vYB9n6() {
        return "list";
    }

    private static String mjiSPBpj47hp5eo() {
        return "all";
    }

    private static String IGlkTLxdIDoqtkPTJX7pc() {
        return "view";
    }

    private static String IQrOalgDooCTQYPZ5Of() {
        return "download";
    }

    private static String uBsXda605x2mscO() {
        return "update";
    }

    private static String Y2cjqaCWnnbOtLR6FbvlJj() {
        return "reload";
    }

    private static String Ob8iSSv0t9BMw55gTrC() {
        return "reload";
    }

    private static String onsyNq4jUmzat4O8pZh() {
        return "&6&lU&9&lClans &7| &cExtensions are already restarting, please wait...";
    }

    private static String EbF7pOzRV7j1dja6DaZk() {
        return "reload";
    }

    private static String pZBatxNc35JqTdZgr() {
        return "&6&lU&9&lClans &7| &cPlease wait, the extensions is restarting and this may take a few seconds.";
    }

    private static String b3EjBVAGQwPTeG() {
        return "%time%;No counting!";
    }
}
