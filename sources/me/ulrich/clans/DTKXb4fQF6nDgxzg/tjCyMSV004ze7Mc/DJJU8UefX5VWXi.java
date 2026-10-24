package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/DJJU8UefX5VWXi.class */
public class DJJU8UefX5VWXi implements ClansCommand {
    private static String Y8EIBSVmbaCBWIy5hj1B;
    private static String x7ZCkC0jkbzcngi6bx;
    private static String Rh7XHSI4sb55Vwu0;
    private static volatile String ppkbC3ij0fSQB7;
    private static String RIYt5mrh9Vzo6aY;
    private static String V0vUE3fgeOpcPG62rZ;
    private static String D3yXuksBynNXoypDmg;
    private static String Gd7LIsxxL2xyRmgZ;
    private static volatile String fCssA4Rqkg8gRZxo2jBA;
    private static String hql3rPUOPLxlLd;
    private static volatile String q5SrN8IlKmsN9Wy;
    private static String MAUWqFwmcVs6fsX;
    private static String W8Jg0dgky8WmlajMyBNb;
    private static String zUW8UTInMh2kORlyERL;
    private static volatile String SAqtKeFWG96vzfL;
    private static volatile String loVIUlvNAmvhD4eRPL;
    private static String jA9wSMcV7F8vgm6A0H7;
    private static String uABcYHxN8kc8SX2Jno;
    private static String rGcW7x6prMguv7VPjpbs;
    private static volatile String DyhRzackaeSOGy6c;
    private static volatile String jSwGqw3HhVa1oGdfYNoh;
    private static String z5iKGt9Q5s3vsNuI7;
    private static volatile String L6T9uuHOo9I0FFkzQ12q;
    private static volatile String wLZyY1JY4VWaBP0Ia;
    private static volatile String BolvZNjKbjK7oOGXudgH2z;
    private static final byte[] vA1PEKM00GqqIubv = {(byte) 11, (byte) 193, (byte) 13, (byte) 5, (byte) 146, (byte) 97, (byte) 42, (byte) 107, (byte) 239, (byte) 202, (byte) 154, (byte) 134, (byte) 251, (byte) 14, (byte) 157, (byte) 211};
    private static final byte[] ZrZv3db1e09knyP = {(byte) 110, (byte) 236, (byte) 128, (byte) 180, (byte) 219, (byte) 27, (byte) 66, (byte) 129, (byte) 216, (byte) 110, (byte) 229, (byte) 230, (byte) 126, (byte) 44, (byte) 219, (byte) 102};
    private static final byte[] FqxWDmkaoPJ7hV = {(byte) 40, (byte) 254, (byte) 119, (byte) 15, (byte) 225, (byte) 144, (byte) 82, (byte) 162, (byte) 139, (byte) 124, (byte) 50, (byte) 100, (byte) 16, (byte) 130, (byte) 226, (byte) 93};
    private static final byte[] zReTTWLkvfWjetl = {(byte) 42, (byte) 145, (byte) 225, (byte) 120, (byte) 29, (byte) 44, (byte) 81, (byte) 244, (byte) 51, (byte) 148, (byte) 62, (byte) 83, (byte) 132, (byte) 62, (byte) 57, (byte) 221};
    private static final byte[] IlIFY9TB45UJGQ = {(byte) 71, (byte) 95, (byte) 90, (byte) 78, (byte) 192, (byte) 125, (byte) 88, (byte) 114, (byte) 251, (byte) 250, (byte) 220, (byte) 229, (byte) 99, (byte) 253, (byte) 178, (byte) 26};
    private static final byte[] DYzAufbrz6OPkbeb = {(byte) 47, (byte) 100, (byte) 130, (byte) 78, (byte) 61, (byte) 188, (byte) 237, (byte) 64, (byte) 224, (byte) 116, (byte) 74, (byte) 20, (byte) 103, (byte) 8, (byte) 3, (byte) 185, (byte) 32, (byte) 231, (byte) 40, (byte) 40, (byte) 61, (byte) 166, (byte) 150, (byte) 74, (byte) 25, (byte) 176, (byte) 203, (byte) 220, (byte) 178, (byte) 69, (byte) 120, (byte) 102};
    private static final byte[] cL6PcwaGpQJrUrNUz0EXhS = {(byte) 108, (byte) 23, (byte) 246, (byte) 12, (byte) 41, (byte) 120, (byte) 184, (byte) 84, (byte) 93, (byte) 46, (byte) 147, (byte) 83, (byte) 66, (byte) 90, (byte) 58, (byte) 186};
    private static final byte[] zYwjy3xDRdYOCHCX8b6l = {(byte) 47, (byte) 100, (byte) 130, (byte) 78, (byte) 61, (byte) 188, (byte) 237, (byte) 64, (byte) 224, (byte) 116, (byte) 74, (byte) 20, (byte) 103, (byte) 8, (byte) 3, (byte) 185, (byte) 32, (byte) 231, (byte) 40, (byte) 40, (byte) 61, (byte) 166, (byte) 150, (byte) 74, (byte) 25, (byte) 176, (byte) 203, (byte) 220, (byte) 178, (byte) 69, (byte) 120, (byte) 102};
    private static final byte[] MzBiam7KG5VJ0p = {(byte) 108, (byte) 23, (byte) 246, (byte) 12, (byte) 41, (byte) 120, (byte) 184, (byte) 84, (byte) 93, (byte) 46, (byte) 147, (byte) 83, (byte) 66, (byte) 90, (byte) 58, (byte) 186};
    private static final byte[] tQwVMsxTenPlG41sgjNQ9 = {(byte) 45, (byte) 144, (byte) 200, (byte) 85, (byte) 84, (byte) 128, (byte) 147, (byte) 19, (byte) 96, (byte) 68, (byte) 113, (byte) 192, (byte) 215, (byte) 4, (byte) 32, (byte) 56};
    private static final byte[] WsZveBm9svWKucOKI4 = {(byte) 40, (byte) 254, (byte) 119, (byte) 15, (byte) 225, (byte) 144, (byte) 82, (byte) 162, (byte) 139, (byte) 124, (byte) 50, (byte) 100, (byte) 16, (byte) 130, (byte) 226, (byte) 93};
    private static final byte[] LHSpiZKy4sW7HvhJ = {(byte) 148, (byte) 49, (byte) 217, (byte) 58, (byte) 12, (byte) 128, (byte) 219, (byte) 116, (byte) 57, (byte) 68, (byte) 65, (byte) 46, (byte) 221, (byte) 22, (byte) 217, (byte) 180, (byte) 243, (byte) 168, (byte) 231, (byte) 253, (byte) 166, (byte) 228, (byte) 130, (byte) 30, (byte) 169, (byte) 195, (byte) 34, (byte) 100, (byte) 119, (byte) 15, (byte) 61, (byte) 220};
    private static final byte[] YSsyL8BiTDi4r1mV7dZ = {(byte) 42, (byte) 145, (byte) 225, (byte) 120, (byte) 29, (byte) 44, (byte) 81, (byte) 244, (byte) 51, (byte) 148, (byte) 62, (byte) 83, (byte) 132, (byte) 62, (byte) 57, (byte) 221};
    private static final byte[] mtv0k5ykWgjK0HvSzP = {(byte) 137, (byte) 60, (byte) 74, (byte) 209, (byte) 242, (byte) 69, (byte) 82, (byte) 4, (byte) 34, (byte) 197, (byte) 48, (byte) 103, (byte) 20, (byte) 28, (byte) 61, (byte) 0};
    private static final byte[] vxJOKdwloZKzMZV5SL = {(byte) 137, (byte) 60, (byte) 74, (byte) 209, (byte) 242, (byte) 69, (byte) 82, (byte) 4, (byte) 34, (byte) 197, (byte) 48, (byte) 103, (byte) 20, (byte) 28, (byte) 61, (byte) 0};
    private static final byte[] c1UT70VKtChOLH8pyF4u = {(byte) 41, (byte) 242, (byte) 15, (byte) 195, (byte) 140, (byte) 1, (byte) 161, (byte) 217, (byte) 36, (byte) 162, (byte) 143, (byte) 120, (byte) 166, (byte) 170, (byte) 71, (byte) 47, (byte) 26, (byte) 184, (byte) 36, (byte) 108, (byte) 8, (byte) 176, (byte) 226, (byte) 109, (byte) 127, (byte) 207, (byte) 122, (byte) 226, (byte) 63, (byte) 240, (byte) 210, (byte) 202, (byte) 129, (byte) 141, (byte) 130, (byte) 29, (byte) 225, (byte) 163, (byte) 149, (byte) 66, (byte) 204, (byte) 146, (byte) 165, (byte) 89, (byte) 211, (byte) 103, (byte) 11, (byte) 125};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(CVzwARLXDFqo8g6())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(MFgJHLegcXeYuHb5NDLPiC());
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase(Pyw0hR3W9Gl2tegdzJd()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(cwGnx5LDakzZby(), str2)) {
            if (strArr.length > 2) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), fxyAYewsHjsHmV61())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if ((commandSender instanceof Player) && clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(xO8E2TJvJSc6SooAVRdN()) || (strArr.length == 2 && strArr[1].equalsIgnoreCase(VjMXuy43kQS7Q1())))) {
                clans.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanRoles(player, null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_PERMISSIONS_VIEW_HEADER)));
            for (Map.Entry<String, HashMap<String, Boolean>> entry : clans.getModerationManager().ZwrsrwOCXRUscW6Q(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()).entrySet()) {
                if (clans.getModerationManager().zJnaNCVQSgEShq().containsKey(entry.getKey())) {
                    MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_PERMISSIONS_ROLE_VIEW_FORMAT, Arrays.asList("%role%;" + clans.getModerationManager().zJnaNCVQSgEShq().get(entry.getKey()).getName())));
                    for (Map.Entry<String, Boolean> entry2 : entry.getValue().entrySet()) {
                        if (!entry2.getKey().equalsIgnoreCase(cYYCra9y3cDmRNgBZQKjc5())) {
                            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_PERMISSIONS_VIEW_FORMAT, Arrays.asList("%role%;" + entry.getKey(), "%key%;" + clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(entry2.getKey()), "%value%;" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("STATE_" + String.valueOf(entry2.getValue()).toUpperCase())))));
                        }
                    }
                }
            }
            return true;
        }
        if (str2.equalsIgnoreCase(ebgrmpupVNjOlkr()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(Cw7x6oTZQvAwRu8Pbjw9H(), str2)) {
            if (strArr.length != 1) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean(SPhokzKuD2GgT9())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
                return true;
            }
            if (CooldownAPI.isInCooldown(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId(), DsiUOZ32VfQDFluSsiTGqz())) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.COMMAND_IN_COOLDOWN, Arrays.asList("%sec%;" + String.valueOf(clans.getFiles().IO1OGSMpoP1ZjOsbXi3a().getInt(d9tneoOMWABbbip())))));
                return true;
            }
            if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), EKIHqh36dIY8JjHI59Us5())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (clans.getModerationManager().iZTqZaRK5UGoe0Z(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId()).size() < 1) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
            new CooldownAPI(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId(), GA7bPlnReOn6GLUMqwg(), clans.getFiles().IO1OGSMpoP1ZjOsbXi3a().getInt(dz8y4qAoVRUi5qoiv7IRYz())).start();
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
            return true;
        }
        if (!str2.equalsIgnoreCase(rAgVhCM9jfDw1SEn3V5jF()) && !clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(RxxLKGfMrEH0LDO(), str2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (strArr.length > 4) {
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR3 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR3.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), W58fERx3Mu18QYS9B())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return true;
        }
        if ((commandSender instanceof Player) && clans.isUseGUI() && strArr.length == 2 && strArr[1].equalsIgnoreCase(sJWTC1EA9GugKogwtm())) {
            clans.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanRoles(player, null);
            return true;
        }
        if ((commandSender instanceof Player) && clans.isUseGUI() && strArr.length == 3 && strArr[2].equalsIgnoreCase(If0vhaAWI3kqOWz()) && clans.getModerationManager().zJnaNCVQSgEShq().containsKey(strArr[1])) {
            clans.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanRolesEditor(player, 1, strArr[1], null);
            return true;
        }
        ModerationData moderationData = null;
        String str3 = null;
        boolean zBooleanValue = false;
        try {
            if (clans.getModerationManager().zJnaNCVQSgEShq().containsKey(strArr[1])) {
                moderationData = clans.getModerationManager().zJnaNCVQSgEShq().get(strArr[1]);
            }
        } catch (Exception e) {
        }
        try {
            if (moderationData.getPermissionList().containsKey(strArr[2])) {
                str3 = strArr[2];
            }
        } catch (Exception e2) {
        }
        if (moderationData == null) {
            StringBuilder sb = new StringBuilder();
            List listAsList = Arrays.asList(clans.getModerationManager().zJnaNCVQSgEShq().keySet());
            for (int i = 0; i < listAsList.size(); i++) {
                if (i % 2 == 0) {
                    sb.append("&b" + ((Set) listAsList.get(i)).toString());
                } else {
                    sb.append("&7" + ((Set) listAsList.get(i)).toString());
                }
                if (i + 1 < listAsList.size()) {
                    sb.append(TUy4bMEXiQmqSpRBmz());
                } else {
                    sb.append(gMtjEBOGTj4S5a3bpFrrF());
                }
            }
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.ACCEPTED_VALUES, Arrays.asList("%types%;" + sb.toString())));
            return true;
        }
        if (str3 != null) {
            try {
                zBooleanValue = Boolean.valueOf(strArr[3]).booleanValue();
            } catch (Exception e3) {
            }
            if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
                return true;
            }
            if (clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getId(), moderationData.getId(), str3, Boolean.valueOf(zBooleanValue))) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("%role%;" + moderationData.getName(), "%key%;" + str3, "%value%;" + clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.valueOf("STATE_" + String.valueOf(zBooleanValue).toUpperCase()))));
                return true;
            }
            MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        List listAsList2 = Arrays.asList(moderationData.getPermissionList().keySet());
        for (int i2 = 0; i2 < listAsList2.size(); i2++) {
            if (i2 % 2 == 0) {
                sb2.append("&b" + ((Set) listAsList2.get(i2)).toString());
            } else {
                sb2.append("&7" + ((Set) listAsList2.get(i2)).toString());
            }
            if (i2 + 1 < listAsList2.size()) {
                sb2.append(OBCMZwoRnxiUOpa());
            } else {
                sb2.append(DDWUFUn7WpC9v4());
            }
        }
        MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.ACCEPTED_VALUES, Arrays.asList("%types%;" + sb2.toString())));
        return true;
    }

    private static String JThCE8X2u6KZlK0z95(byte[] bArr) {
        return "";
    }

    private static String CVzwARLXDFqo8g6() {
        return "role";
    }

    private static String MFgJHLegcXeYuHb5NDLPiC() {
        return "role";
    }

    private static String Pyw0hR3W9Gl2tegdzJd() {
        return "view";
    }

    private static String cwGnx5LDakzZby() {
        return "view";
    }

    private static String fxyAYewsHjsHmV61() {
        return "PERMISSIONS";
    }

    private static String xO8E2TJvJSc6SooAVRdN() {
        return "Config.gui.forge_open-gui";
    }

    private static String VjMXuy43kQS7Q1() {
        return "-gui";
    }

    private static String cYYCra9y3cDmRNgBZQKjc5() {
        return "default";
    }

    private static String ebgrmpupVNjOlkr() {
        return "sync";
    }

    private static String Cw7x6oTZQvAwRu8Pbjw9H() {
        return "sync";
    }

    private static String SPhokzKuD2GgT9() {
        return "Moderation.update.enabled";
    }

    private static String DsiUOZ32VfQDFluSsiTGqz() {
        return "update_sync";
    }

    private static String d9tneoOMWABbbip() {
        return "Moderation.update.cooldown";
    }

    private static String EKIHqh36dIY8JjHI59Us5() {
        return "PERMISSIONS";
    }

    private static String GA7bPlnReOn6GLUMqwg() {
        return "update_sync";
    }

    private static String dz8y4qAoVRUi5qoiv7IRYz() {
        return "Moderation.update.cooldown";
    }

    private static String rAgVhCM9jfDw1SEn3V5jF() {
        return "set";
    }

    private static String RxxLKGfMrEH0LDO() {
        return "set";
    }

    private static String W58fERx3Mu18QYS9B() {
        return "PERMISSIONS";
    }

    private static String sJWTC1EA9GugKogwtm() {
        return "-gui";
    }

    private static String If0vhaAWI3kqOWz() {
        return "-gui";
    }

    private static String TUy4bMEXiQmqSpRBmz() {
        return "&8, ";
    }

    private static String gMtjEBOGTj4S5a3bpFrrF() {
        return "&8.";
    }

    private static String OBCMZwoRnxiUOpa() {
        return "&8, ";
    }

    private static String DDWUFUn7WpC9v4() {
        return "&8.";
    }
}
