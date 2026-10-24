package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.RegroupInvite;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/TT1XiyOqwowi4.class */
public class TT1XiyOqwowi4 implements ClansCommand {
    private static volatile String oyoQ644IBYVsJk17uPC;
    private static volatile String uJ15W2TgTc338sNlV;
    private static volatile String G38SxB8crFOcy4G5eY9t8;
    private static String tSfH8HxI9WcRPsQ;
    private static String XtARxlMKanfgKvmUJL;
    private static String f3KF0sP8DGsPfs6;
    private static String avQAT3buAgjYj2Dg;
    private static String mrDPE4nT6pPCwPOT2Ddv;
    private static volatile String fYi8QGqz1jkdkSOfMr1JX;
    private static String kP7ZUMrJyejz0f0;
    private static volatile String bsOC1GQclcZksoIZHoV;
    private static String bHxgqkXx9mMciaNw4imq;
    private static volatile String R0ZzKhcLc2V2DVAx0J;
    private static final byte[] CTliETZDH7Hdvyz = {(byte) 156, (byte) 100, (byte) 65, (byte) 239, (byte) 10, (byte) 171, (byte) 60, (byte) 51, (byte) 118, (byte) 64, (byte) 167, (byte) 66, (byte) 84, (byte) 94, (byte) 243, (byte) 136};
    private static final byte[] XBUGN7FHmILCKDwqmk = {(byte) 156, (byte) 100, (byte) 65, (byte) 239, (byte) 10, (byte) 171, (byte) 60, (byte) 51, (byte) 118, (byte) 64, (byte) 167, (byte) 66, (byte) 84, (byte) 94, (byte) 243, (byte) 136};
    private static final byte[] gUF5GyDA0BdAYrrOU = {(byte) 165, (byte) 189, (byte) 70, (byte) 24, (byte) 60, (byte) 84, (byte) 100, (byte) 172, (byte) 108, (byte) 234, (byte) 169, (byte) 5, (byte) 228, (byte) 3, (byte) 197, (byte) 226};
    private static final byte[] wpUBblDvyEDJUy = {(byte) 188, (byte) 196, (byte) 20, (byte) 207, (byte) 248, (byte) 147, (byte) 131, (byte) 211, (byte) 198, (byte) 56, (byte) 151, (byte) 24, (byte) 141, (byte) 253, (byte) 45, (byte) 146};
    private static final byte[] AHjNMwptMEbgm20VUd8qcN = {(byte) 162, (byte) 240, (byte) 69, (byte) 35, (byte) 199, (byte) 78, (byte) 110, (byte) 187, (byte) 10, (byte) 3, (byte) 68, (byte) 159, (byte) 233, (byte) 31, (byte) 49, (byte) 196};
    private static final byte[] lhruhKTru91YCtlzICD = {(byte) 39, (byte) 2, (byte) 144, (byte) 139, (byte) 12, (byte) 200, (byte) 244, (byte) 147, (byte) 77, (byte) 16, (byte) 212, (byte) 136, (byte) 115, (byte) 182, (byte) 140, (byte) 132};
    private static final byte[] nYRaKnVL3iE7rZ1PSReGzT = {(byte) 7, (byte) 218, (byte) 156, (byte) 47, (byte) 156, (byte) 62, (byte) 86, (byte) 202, (byte) 150, (byte) 165, (byte) 90, (byte) 200, (byte) 216, (byte) 186, (byte) 246, (byte) 214, (byte) 229, (byte) 169, (byte) 80, (byte) 79, (byte) 134, (byte) 84, (byte) 148, (byte) 156, (byte) 72, (byte) 241, (byte) 14, (byte) 129, (byte) 100, (byte) 143, (byte) 193, (byte) 154};
    private static final byte[] Mk8xcgt0IJsRJ2MAyP3uBw = {(byte) 245, (byte) 18, (byte) 133, (byte) 169, (byte) 60, (byte) 145, (byte) 223, (byte) 86, (byte) 212, (byte) 131, (byte) 94, (byte) 20, (byte) 135, (byte) 248, (byte) 187, (byte) 127};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(C8GRpG5AvL0y62PMJEK2O())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(V9EBYkWSyTqporRWk6iV());
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase(eUi0h4tFN1bHKNK0()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(XLcObUbBiAztxTEAwx(), str2)) {
            if (strArr.length != 1) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (!clans.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), bRNfakdYi07poH885YP())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                return true;
            }
            if (clans.getClanManager().IO1OGSMpoP1ZjOsbXi3a(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()).isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_ALREADY_EXIST));
                return true;
            }
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.get().getMembers().size() <= 1) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_HAS_NO_MEMBERS));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
                return true;
            }
            try {
                clans.getClanManager().zJnaNCVQSgEShq().put(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), new RegroupInvite(optionalCDW4Fj1iwdIXEOqWjiJSR.get(), Long.valueOf((System.currentTimeMillis() / 1000) + ((long) (clans.getFiles().p31abtwfBag2jhMH6K().getInt(xwOFQU58nmTAXHk()) > 0 ? clans.getFiles().p31abtwfBag2jhMH6K().getInt(ahKY1zHBBQLTRaLgb()) : 60))), player, Arrays.asList(new Player[0]), Arrays.asList(new Player[0]), player.getLocation()));
                ArrayList arrayList = new ArrayList();
                arrayList.add(player);
                List<UUID> members = optionalCDW4Fj1iwdIXEOqWjiJSR.get().getMembers();
                if (members.size() > 0) {
                    Iterator<UUID> it = members.iterator();
                    while (it.hasNext()) {
                        Player player2 = null;
                        try {
                            player2 = Bukkit.getPlayer(it.next());
                        } catch (Exception e) {
                        }
                        if (player2 != null) {
                            if (!arrayList.contains(player2)) {
                                Player player3 = player2;
                                clans.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player3, () -> {
                                    me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player3, ClanEnum.ChatDataType.CLANREGROUPRECEIVE, Arrays.asList("%sec_expires%;" + clans.getFiles().p31abtwfBag2jhMH6K().getInt(QeUxOL0KGpr2Psaz()), "%clan_sender%;" + player.getName()), true, true, clans.getFiles().p31abtwfBag2jhMH6K().getInt(FyHMWKY26ftBqDS3QRSFjj()));
                                });
                            }
                        }
                    }
                }
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.success, null);
                return true;
            } catch (Exception e2) {
                MessageUtils.sendSubCommandJson(player, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
        }
        if (str2.equalsIgnoreCase(fB5Dw2RE5g0aq6sAA()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(jAV6cZ4leBOlURTFT(), str2)) {
            if (strArr.length != 1) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (!clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR2 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
            if (!optionalCDW4Fj1iwdIXEOqWjiJSR2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            Optional<RegroupInvite> optionalIO1OGSMpoP1ZjOsbXi3a = clans.getClanManager().IO1OGSMpoP1ZjOsbXi3a(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId());
            if (!optionalIO1OGSMpoP1ZjOsbXi3a.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_DOESNOT_EXIST));
                return true;
            }
            if (optionalIO1OGSMpoP1ZjOsbXi3a.get().getAccepted().contains(player)) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_ALREADY_ACCEPTED));
                return true;
            }
            if (optionalIO1OGSMpoP1ZjOsbXi3a.get().getDeny().contains(player)) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_ALREADY_DENIED));
                return true;
            }
            Player sender = optionalIO1OGSMpoP1ZjOsbXi3a.get().getSender();
            if (!sender.isOnline()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_OFFLINE));
                return true;
            }
            if (player.equals(sender)) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_YOU));
                return true;
            }
            if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
                return true;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(optionalIO1OGSMpoP1ZjOsbXi3a.get().getAccepted());
            if (!optionalIO1OGSMpoP1ZjOsbXi3a.get().getAccepted().contains(player)) {
                arrayList2.add(player);
            }
            clans.getChatManager().jBUuLP0sWwaPyPOmogdX7l(player);
            clans.getClanManager().zJnaNCVQSgEShq().get(optionalCDW4Fj1iwdIXEOqWjiJSR2.get().getId()).setAccepted(arrayList2);
            clans.getClanManager().v8qP8fE86HMhvNuYPFjqY(player, Optional.of(new EncodedLocationData(clans.getServerName(), optionalIO1OGSMpoP1ZjOsbXi3a.get().getLocation().getWorld().getName(), optionalIO1OGSMpoP1ZjOsbXi3a.get().getLocation().getX(), optionalIO1OGSMpoP1ZjOsbXi3a.get().getLocation().getY(), optionalIO1OGSMpoP1ZjOsbXi3a.get().getLocation().getZ(), optionalIO1OGSMpoP1ZjOsbXi3a.get().getLocation().getYaw(), optionalIO1OGSMpoP1ZjOsbXi3a.get().getLocation().getPitch())), true);
            return true;
        }
        if (!str2.equalsIgnoreCase(NLVUnbQVhOqnhMRpi()) && !clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(YYePEJ68YQGks1HPh(), str2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (strArr.length != 1) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR3 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR3.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        Optional<RegroupInvite> optionalIO1OGSMpoP1ZjOsbXi3a2 = clans.getClanManager().IO1OGSMpoP1ZjOsbXi3a(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getId());
        if (!optionalIO1OGSMpoP1ZjOsbXi3a2.isPresent()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_DOESNOT_EXIST));
            return true;
        }
        if (optionalIO1OGSMpoP1ZjOsbXi3a2.get().getAccepted().contains(player)) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_ALREADY_ACCEPTED));
            return true;
        }
        if (optionalIO1OGSMpoP1ZjOsbXi3a2.get().getDeny().contains(player)) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_ALREADY_DENIED));
            return true;
        }
        Player sender2 = optionalIO1OGSMpoP1ZjOsbXi3a2.get().getSender();
        if (!sender2.isOnline()) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_OFFLINE));
            return true;
        }
        if (player.equals(sender2)) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_IS_YOU));
            return true;
        }
        ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(optionalIO1OGSMpoP1ZjOsbXi3a2.get().getDeny());
        if (!optionalIO1OGSMpoP1ZjOsbXi3a2.get().getDeny().contains(player)) {
            arrayList3.add(player);
        }
        clans.getClanManager().zJnaNCVQSgEShq().get(optionalCDW4Fj1iwdIXEOqWjiJSR3.get().getId()).setDeny(arrayList3);
        MessageUtils.sendText((CommandSender) sender2, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_REGROUP_INVITE_DENY, Arrays.asList("%player%;" + player.getName())));
        return true;
    }

    private static String NWsrZC1zYbwuWBhtmk5(byte[] bArr) {
        return "";
    }

    private static String C8GRpG5AvL0y62PMJEK2O() {
        return "regroup";
    }

    private static String V9EBYkWSyTqporRWk6iV() {
        return "regroup";
    }

    private static String eUi0h4tFN1bHKNK0() {
        return "send";
    }

    private static String XLcObUbBiAztxTEAwx() {
        return "send";
    }

    private static String bRNfakdYi07poH885YP() {
        return "REGROUP";
    }

    private static String xwOFQU58nmTAXHk() {
        return "Clan.regroup_invite.max_time_seconds";
    }

    private static String ahKY1zHBBQLTRaLgb() {
        return "Clan.regroup_invite.max_time_seconds";
    }

    private static String fB5Dw2RE5g0aq6sAA() {
        return "accept";
    }

    private static String jAV6cZ4leBOlURTFT() {
        return "accept";
    }

    private static String NLVUnbQVhOqnhMRpi() {
        return "deny";
    }

    private static String YYePEJ68YQGks1HPh() {
        return "deny";
    }

    private static String QeUxOL0KGpr2Psaz() {
        return "Clan.regroup_invite.max_time_seconds";
    }

    private static String FyHMWKY26ftBqDS3QRSFjj() {
        return "Clan.regroup_invite.max_time_seconds";
    }
}
