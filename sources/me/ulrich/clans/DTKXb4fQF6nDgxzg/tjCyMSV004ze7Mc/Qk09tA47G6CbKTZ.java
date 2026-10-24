package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.OnlineData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/Qk09tA47G6CbKTZ.class */
public class Qk09tA47G6CbKTZ implements ClansCommand {
    private static volatile String xPGlKQpeL2i0Ct;
    private static volatile String QhMAvvABr8ksbHG5mT;
    private static volatile String qXCdK4F865HBx00;
    private static volatile String U9gTjpYvsKmEc2J7GlR;
    private static volatile String j6n7bFnOqkOLYDCH2uJyl1;
    private static volatile String MY2qI03IVL42BqEJir8;
    private static volatile String HNxpDrKGzGbWeML;
    private static volatile String r5Qf9vo38qXTdH1czQ;
    private static volatile String pUeDMLfMmctVBB;
    private static volatile String I2yBut8eLBjg1TLUfur;
    private static volatile String A4IyX9fBEUXfcDs;
    private static volatile String yLKS8rA9qmLmKTF;
    private static String vXlHy71Y6LgPqWv1uNiu4u;
    private static volatile String DR7G2rF6wyF0YM7vEny;
    private static volatile String s2UOSohhDI5FNPE;
    private static String NLb8wBXC1K7EwMY;
    private static volatile String p2mwWgfHmLbsdhkJauxX;
    private static volatile String gu6MoHxrN832q8q;
    private static final byte[] cK7fc1Ua9YzQoAGbXB = {(byte) 63, (byte) 64, (byte) 126, (byte) 250, (byte) 255, (byte) 123, (byte) 101, (byte) 46, (byte) 44, (byte) 104, (byte) 128, (byte) 3, (byte) 169, (byte) 230, (byte) 97, (byte) 94};
    private static final byte[] XBS1hdUM6tLiHFC = {(byte) 63, (byte) 64, (byte) 126, (byte) 250, (byte) 255, (byte) 123, (byte) 101, (byte) 46, (byte) 44, (byte) 104, (byte) 128, (byte) 3, (byte) 169, (byte) 230, (byte) 97, (byte) 94};
    private static final byte[] k1oBKUNfcj9Gw4kuj5A = {(byte) 33, (byte) 75, (byte) 65, (byte) 86, (byte) 233, (byte) 39, (byte) 189, (byte) 0, (byte) 52, (byte) 87, (byte) 166, (byte) 21, (byte) 24, (byte) 200, (byte) 50, (byte) 132};
    private static final byte[] w321iXl0L81QBYL3lDoHg = {(byte) 80, (byte) 227, (byte) 55, (byte) 159, (byte) 195, (byte) 114, (byte) 53, (byte) 241, (byte) 100, (byte) 37, (byte) 31, (byte) 5, (byte) 22, (byte) 13, (byte) 57, (byte) 171};
    private static final byte[] TeehVCR4HDlW28ofPQ9 = {(byte) 85, (byte) 121, (byte) 48, (byte) 30, (byte) 118, (byte) 14, (byte) 89, (byte) 80, (byte) 234, (byte) 70, (byte) 144, (byte) 19, (byte) 247, (byte) 128, (byte) 215, (byte) 176};
    private static final byte[] Xu6lBMHePydmTviJVN = {(byte) 85, (byte) 121, (byte) 48, (byte) 30, (byte) 118, (byte) 14, (byte) 89, (byte) 80, (byte) 234, (byte) 70, (byte) 144, (byte) 19, (byte) 247, (byte) 128, (byte) 215, (byte) 176};
    private static final byte[] lbKkKGjsFNPXK4CnC = {(byte) 200, (byte) 64, (byte) 218, (byte) 240, (byte) 129, (byte) 38, (byte) 191, (byte) 19, (byte) 236, (byte) 9, (byte) 249, (byte) 194, (byte) 115, (byte) 75, (byte) 58, (byte) 94};
    private static final byte[] CAPPhi8wKtagvSm3aKJ = {(byte) 212, (byte) 25, (byte) 167, (byte) 37, (byte) 238, (byte) 213, (byte) 171, (byte) 31, (byte) 97, (byte) 150, (byte) 213, (byte) 117, (byte) 255, (byte) 108, (byte) 85, (byte) 26};
    private static final byte[] GKKX6KOtxmsRVkXk9k = {(byte) 129, (byte) 248, (byte) 57, (byte) 235, (byte) 132, (byte) 225, (byte) 216, (byte) 10, (byte) 1, (byte) 207, (byte) 208, (byte) 96, (byte) 49, (byte) 211, (byte) 223, (byte) 84, (byte) 103, (byte) 84, (byte) 81, (byte) 56, (byte) 178, (byte) 153, (byte) 26, (byte) 252, (byte) 175, (byte) 159, (byte) 105, (byte) 94, (byte) 79, (byte) 251, (byte) 35, (byte) 204};
    private static final byte[] RgvIKrdYWfcJrQ4 = {(byte) 238, (byte) 125, (byte) 190, (byte) 216, (byte) 4, (byte) 47, (byte) 219, (byte) 64, (byte) 51, (byte) 230, (byte) 171, (byte) 108, (byte) 223, (byte) 166, (byte) 227, (byte) 113};
    private static final byte[] r0OSBEGm8I9cVaqhxbv1LC = {(byte) 238, (byte) 125, (byte) 190, (byte) 216, (byte) 4, (byte) 47, (byte) 219, (byte) 64, (byte) 51, (byte) 230, (byte) 171, (byte) 108, (byte) 223, (byte) 166, (byte) 227, (byte) 113};
    private static final byte[] zubfQVUDs0AufQ = {(byte) 237, (byte) 156, (byte) 218, (byte) 54, (byte) 235, (byte) 132, (byte) 194, (byte) 103, (byte) 28, (byte) 249, (byte) 119, (byte) 33, (byte) 67, (byte) 27, (byte) 242, (byte) 76};
    private static final byte[] UA0UXNqb9snagva5ICB = {(byte) 237, (byte) 156, (byte) 218, (byte) 54, (byte) 235, (byte) 132, (byte) 194, (byte) 103, (byte) 28, (byte) 249, (byte) 119, (byte) 33, (byte) 67, (byte) 27, (byte) 242, (byte) 76};
    private static final byte[] ORR5yjBcaPXpKn6moH3T = {(byte) 89, (byte) 28, (byte) 161, (byte) 152, (byte) 91, (byte) 245, (byte) 186, (byte) 46, (byte) 206, (byte) 17, (byte) 120, (byte) 214, (byte) 199, (byte) 28, (byte) 207, (byte) 185, (byte) 46, (byte) 245, (byte) 207, (byte) 76, (byte) 87, (byte) 72, (byte) 221, (byte) 131, (byte) 115, (byte) 248, (byte) 184, (byte) 240, (byte) 157, (byte) 200, (byte) 209, (byte) 243, (byte) 166, (byte) 128, (byte) 193, (byte) 44, (byte) 150, (byte) 17, (byte) 32, (byte) 104, (byte) 75, (byte) 73, (byte) 193, (byte) 200, (byte) 40, (byte) 94, (byte) 28, (byte) 83};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(gIC2qwlTCvtGHKUR1dvl())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(mlQAJloqjewO1tjS());
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase(XKvcm7pruJrndJcSf1E3m()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(I7Ir4R0UgYND6n(), str2)) {
            if (strArr.length > 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (!clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (strArr.length == 1) {
                if (!clans.getAnvilGuiManager().v8qP8fE86HMhvNuYPFjqY()) {
                    MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                    return true;
                }
                if (clans.getAnvilGuiManager().v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.MEMBERSEARCH, true, Optional.empty())) {
                    return true;
                }
            }
            if ((commandSender instanceof Player) && clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(yhODxhMoW6dyv9xrN2dUA()) || (strArr.length == 3 && strArr[2].equalsIgnoreCase(gAwBVAZBEJCJEWHMMwLuPD())))) {
                clans.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanSearchMembersInvite(player, strArr[1], null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_MEMBER_SEARCH_LIST_HEADER)));
            ArrayList<Player> arrayList = new ArrayList<>();
            for (Player player2 : Bukkit.getOnlinePlayers()) {
                if (player2.getName().toLowerCase().contains(strArr[1].toLowerCase()) && !player.getUniqueId().equals(player2.getUniqueId()) && !clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), player2.getUniqueId()) && clans.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(player2.getUniqueId())) {
                    arrayList.add(player2);
                }
            }
            if (arrayList.size() == 0) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
                return true;
            }
            arrayList.iterator().forEachRemaining(player3 -> {
                if (clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player3)) {
                    MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player3.getUniqueId(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_MEMBER_SEARCH_LIST_FORMAT)));
                }
            });
            return true;
        }
        if (str2.equalsIgnoreCase(y6XszE2KCYz6WfglH()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(RTNqBz96RcvEU6Odj1cn(), str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), NBShnurssHEXVCR5pBS9x())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (!clans.getClanManager().o1VU1x4DAlrEtGKZ3jAdhE(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_MAX_MEMBERS_LEVEL));
                return true;
            }
            Optional<OnlineData> optionalV8qP8fE86HMhvNuYPFjqY = clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(strArr[1]);
            if (optionalV8qP8fE86HMhvNuYPFjqY.isPresent()) {
                if (!clans.getPlayerManager().p31abtwfBag2jhMH6K(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID()).isPresent()) {
                    MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_HAS_NOPROFILE));
                    return true;
                }
                if (player.getUniqueId().equals(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                    MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_YOU));
                    return true;
                }
                if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getBanned().contains(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                    MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_IS_BANNED));
                    return true;
                }
                if (!clans.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                    MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_BLOCKED_INVITE));
                    return true;
                }
                if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getMembers().contains(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID())) {
                    MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_ALREADY_PARTICIPATING));
                    return true;
                }
            }
            if (!optionalV8qP8fE86HMhvNuYPFjqY.isPresent() || (optionalV8qP8fE86HMhvNuYPFjqY.isPresent() && optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerName().length() != strArr[1].length())) {
                if (clans.isUseGUI()) {
                    clans.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanSearchMembersInvite(player, strArr[1], null);
                    return true;
                }
                clans.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                    player.chat("/clan member search " + strArr[1]);
                });
                return true;
            }
            if (clans.getPlayerInviteManager().ZwrsrwOCXRUscW6Q(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID(), optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_ALREADY_INVITED));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
                return true;
            }
            if (clans.getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(optionalV8qP8fE86HMhvNuYPFjqY.get().getPlayerUUID(), optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), player.getUniqueId())) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
            return true;
        }
        if (str2.equalsIgnoreCase(HgPd274LAQtid3JyqLmdw5()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(RI1Bd1U0v9ojcy9JOBqtK9(), str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR3 = null;
            try {
                optionalCDW4Fj1iwdIXEOqWjiJSR3 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[1]);
            } catch (Exception e) {
            }
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR3.isPresent() || !clans.getPlayerManager().xtOheRiObl4QeAl(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId(), optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getUuid())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_ISNOT_YOUR_CLAN));
                return true;
            }
            if (clans.getPlayerManager().vVo2VUvxrriklPdRxI(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getUuid())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_CANNOT_EXPEL_LEADER));
                return true;
            }
            if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), o4xPZmhJgBcvArovY1dSlX())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getUuid())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
                return true;
            }
            if (!clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getUuid(), ClanEnum.PlayerLeaveReaction.KICK, Optional.of(player.getUniqueId()), Optional.empty())) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            try {
                Player player4 = Bukkit.getPlayer(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getUuid());
                if (player4 != null && player4.isOnline()) {
                    clans.getTaskManager().v8qP8fE86HMhvNuYPFjqY((Entity) player4, () -> {
                        player4.closeInventory();
                        if (clans.getPlayerManager().ZwrsrwOCXRUscW6Q(player4)) {
                            clans.getPlayerManager().iZTqZaRK5UGoe0Z(player4);
                        }
                        MessageUtils.sendText((CommandSender) player4, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_KICKED_OUT, Arrays.asList("%player%;" + player4.getName(), "%clan_leader%;" + player.getName(), "%clan%;" + ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR2.get()).getTag())));
                    });
                }
            } catch (Exception e2) {
            }
            MessageUtils.clanMessageSend(optionalCDW4Fj1iwdIXEOqWjiJSR2.get(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_PLAYER_KICKED_OUTBY, Arrays.asList("%player%;" + optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getName(), "{player_other};" + optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getName(), "%clan_leader%;" + player.getName(), "{player_sender};" + player.getName(), "%uclans_player_name%;" + player.getName(), "%clan%;" + optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getTag())));
            return true;
        }
        if (!str2.equalsIgnoreCase(AUtIT7nJlPHfK7RY8C6BS()) && !clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(ogNqgUacCOQ5zo(), str2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (strArr.length > 3) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalEmpty = Optional.empty();
        if (!(commandSender instanceof Player) || strArr.length < 2 || strArr[1].equalsIgnoreCase(gVIrf8oEXVBrzf216IPw())) {
            optionalEmpty = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        } else {
            Optional<UUID> optionalV8qP8fE86HMhvNuYPFjqY2 = clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(strArr[1]);
            if (optionalV8qP8fE86HMhvNuYPFjqY2.isPresent()) {
                optionalEmpty = clans.getClanManager().iZTqZaRK5UGoe0Z(optionalV8qP8fE86HMhvNuYPFjqY2.get());
            }
        }
        if (!optionalEmpty.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_DOES_NOT_EXISTS));
            return true;
        }
        if ((commandSender instanceof Player) && clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(M00luvMMTIjPHJB77cDHIt()) || ((strArr.length == 2 && strArr[1].equalsIgnoreCase(Djm6CCnfALtYwxGsv35())) || (strArr.length == 3 && strArr[2].equalsIgnoreCase(WjwhKkUGlez3PiyjwPBe()))))) {
            clans.getGuiManager().p31abtwfBag2jhMH6K().openClansListMembers(player, optionalEmpty.get().getId(), false);
            return true;
        }
        MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalEmpty.get().getLeader(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_MEMBER_LIST_HEADER)));
        if (optionalEmpty.get().getMembers() != null && optionalEmpty.get().getMembers().size() == 0) {
            MessageUtils.clanMessageSend(optionalEmpty.get(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
            return true;
        }
        HashMap<UUID, Integer> map = new HashMap<>();
        for (UUID uuid : optionalEmpty.get().getMembers()) {
            Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = clans.getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid);
            if (optionalB4i2FbOkaKeg91LiAe6l.isPresent()) {
                map.put(uuid, Integer.valueOf(optionalB4i2FbOkaKeg91LiAe6l.get().getPriority()));
            }
        }
        ((Map<UUID, Integer>) map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap((v0) -> {
            return v0.getKey();
        }, (v0) -> {
            return v0.getValue();
        }, (num, num2) -> {
            return num2;
        }, LinkedHashMap::new))).entrySet().iterator().forEachRemaining(entry -> {
            if (clans.getPlayerManager().b4i2FbOkaKeg91LiAe6l((UUID) entry.getKey())) {
                MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l((UUID) entry.getKey(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_MEMBER_LIST_FORMAT)));
            }
        });
        return true;
    }

    private static String XPHZZMOGecHbES9QvvIdF(byte[] bArr) {
        return "";
    }

    private static String gIC2qwlTCvtGHKUR1dvl() {
        return "member";
    }

    private static String mlQAJloqjewO1tjS() {
        return "member";
    }

    private static String XKvcm7pruJrndJcSf1E3m() {
        return "search";
    }

    private static String I7Ir4R0UgYND6n() {
        return "search";
    }

    private static String yhODxhMoW6dyv9xrN2dUA() {
        return "Config.gui.forge_open-gui";
    }

    private static String gAwBVAZBEJCJEWHMMwLuPD() {
        return "-gui";
    }

    private static String y6XszE2KCYz6WfglH() {
        return "invite";
    }

    private static String RTNqBz96RcvEU6Odj1cn() {
        return "invite";
    }

    private static String NBShnurssHEXVCR5pBS9x() {
        return "INVITE";
    }

    private static String HgPd274LAQtid3JyqLmdw5() {
        return "kick";
    }

    private static String RI1Bd1U0v9ojcy9JOBqtK9() {
        return "kick";
    }

    private static String o4xPZmhJgBcvArovY1dSlX() {
        return "KICK";
    }

    private static String AUtIT7nJlPHfK7RY8C6BS() {
        return "list";
    }

    private static String ogNqgUacCOQ5zo() {
        return "list";
    }

    private static String gVIrf8oEXVBrzf216IPw() {
        return "-gui";
    }

    private static String M00luvMMTIjPHJB77cDHIt() {
        return "Config.gui.forge_open-gui";
    }

    private static String Djm6CCnfALtYwxGsv35() {
        return "-gui";
    }

    private static String WjwhKkUGlez3PiyjwPBe() {
        return "-gui";
    }
}
