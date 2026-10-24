package me.ulrich.clans.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/tjCyMSV004ze7Mc/KG0dzbdBSFtZuuPbyPn.class */
public class KG0dzbdBSFtZuuPbyPn implements ClansCommand {
    private static volatile String zieVgnvLCEWN3N0KYl5;
    private static volatile String dknUcEM7hPcHP3xxaIPXH;
    private static volatile String Xl5HcLI6zqPkUc2Gmg;
    private static volatile String egZxvyPkcJaIsiyUhGt;
    private static volatile String ajHGgacjl777z5;
    private static String tFOwNMc1FJ7LecBwGg;
    private static volatile String Ml0NaL2bfTketDElMF2YE;
    private static volatile String DBQPyYu6esZpZBmUmK7r;
    private static String WH3wGBpkC3VBGM8ePu;
    private static volatile String XkEmnh6NrNqZa4tY;
    private static String fFftVpsDbBiyGm;
    private static volatile String aFNw7eUrOcIS7B45NHupW;
    private static String Pgn1GMgCa1iSac;
    private static String XG4P1wySGPIv256nxwFSa;
    private static volatile String xhqPU1DWaYk0E0Jryr5;
    private static String OwZmtAAFT83ZWjcJM6Yjcn;
    private static String QWyrdNQXeCFwfwTvF;
    private static String Py7VzjQomOXuqfEtQQ4W;
    private static volatile String K2q0f2fxS84QPPJ;
    private static volatile String LlBTosqMa2aGUPR;
    private static volatile String dyLLkwvW5vxM0TtNms;
    private static String pbeQoEBje36VyqrgzFf7i;
    private static volatile String XHuQojvX1BocUJ;
    private static String S5yITQqyP0eaWi;
    private static String u9aF9rviwq7fFYz80;
    private static volatile String DZ2IL82CS7xvnC;
    private static String xh77m82qJFoJI5J;
    private static volatile String kfwvV69sDVPxIlLjHl3p;
    private static String SLZ7fk9CyeO8IJ2WolGsUs;
    private static String IwmnKpGXvWsiKvrIXtodw;
    private static final byte[] eGz6umbPC90EJrC = {(byte) 36, (byte) 91, (byte) 119, (byte) 230, (byte) 53, (byte) 48, (byte) 120, (byte) 63, (byte) 72, (byte) 92, (byte) 115, (byte) 92, (byte) 254, (byte) 121, (byte) 226, (byte) 241};
    private static final byte[] dqKyMiO1bcMKcMtSs7qZ = {(byte) 162, (byte) 6, (byte) 226, (byte) 76, (byte) 174, (byte) 147, (byte) 78, (byte) 117, (byte) 246, (byte) 249, (byte) 166, (byte) 193, (byte) 203, (byte) 209, (byte) 248, (byte) 192, (byte) 153, (byte) 27, (byte) 214, (byte) 93, (byte) 248, (byte) 81, (byte) 177, (byte) 192, (byte) 105, (byte) 67, (byte) 37, (byte) 87, (byte) 253, (byte) 236, (byte) 97, (byte) 25, (byte) 90, (byte) 65, (byte) 221, (byte) 104, (byte) 222, (byte) 232, (byte) 37, (byte) 188, (byte) 127, (byte) 179, (byte) 239, (byte) 243, (byte) 88, (byte) 51, (byte) 208, (byte) 239};
    private static final byte[] a4K7FJIeg1zRJtdgr4n = {(byte) 27, (byte) 194, (byte) 11, (byte) 182, (byte) 199, (byte) 1, (byte) 160, (byte) 154, (byte) 1, (byte) 219, (byte) 27, (byte) 98, (byte) 182, (byte) 107, (byte) 102, (byte) 178};
    private static final byte[] HDMVqnNzlENRO6bl9hBgP7 = {(byte) 254, (byte) 206, (byte) 148, (byte) 220, (byte) 46, (byte) 188, (byte) 51, (byte) 167, (byte) 97, (byte) 192, (byte) 13, (byte) 170, (byte) 182, (byte) 151, (byte) 150, (byte) 221};
    private static final byte[] nyRPNsLCVwpSJ3JNWUcoyS = {(byte) 81, (byte) 65, (byte) 234, (byte) 6, (byte) 160, (byte) 137, (byte) 48, (byte) 18, (byte) 101, (byte) 62, (byte) 121, (byte) 184, (byte) 31, (byte) 8, (byte) 225, (byte) 186};
    private static final byte[] sRsLHVRix4U2V4KoC = {(byte) 8, (byte) 64, (byte) 82, (byte) 181, (byte) 20, (byte) 236, (byte) 27, (byte) 59, (byte) 128, (byte) 234, (byte) 219, (byte) 189, (byte) 19, (byte) 98, (byte) 186, (byte) 26};
    private static final byte[] E7X244gN0z6aRFF8P1 = {(byte) 8, (byte) 64, (byte) 82, (byte) 181, (byte) 20, (byte) 236, (byte) 27, (byte) 59, (byte) 128, (byte) 234, (byte) 219, (byte) 189, (byte) 19, (byte) 98, (byte) 186, (byte) 26};
    private static final byte[] xOXTrDuAMKxevR = {(byte) 81, (byte) 65, (byte) 234, (byte) 6, (byte) 160, (byte) 137, (byte) 48, (byte) 18, (byte) 101, (byte) 62, (byte) 121, (byte) 184, (byte) 31, (byte) 8, (byte) 225, (byte) 186};
    private static final byte[] gDAWg88SRMtbXD = {(byte) 127, (byte) 16, (byte) 187, (byte) 172, (byte) 56, (byte) 179, (byte) 160, (byte) 13, (byte) 15, (byte) 251, (byte) 151, (byte) 148, (byte) 228, (byte) 15, (byte) 218, (byte) 103, (byte) 97, (byte) 186, (byte) 172, (byte) 117, (byte) 28, (byte) 106, (byte) 81, (byte) 94, (byte) 103, (byte) 151, (byte) 191, (byte) 103, (byte) 248, (byte) 24, (byte) 50, (byte) 179};
    private static final byte[] erwKE4bTYUhzIvF = {(byte) 214, (byte) 2, (byte) 167, (byte) 225, (byte) 125, (byte) 116, (byte) 71, (byte) 188, (byte) 137, (byte) 209, (byte) 69, (byte) 29, (byte) 169, (byte) 252, (byte) 86, (byte) 7};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(eaXwMYAkFBwemn21JW3x())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().ZwrsrwOCXRUscW6Q().get(t11ymomNdZNOuY7());
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        Player player = (Player) commandSender;
        if (str2.equalsIgnoreCase(KsOrZZenDQpONb()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(GvJAhSSUu7VCOQ8CRtVn(), str2)) {
            if (strArr.length > 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<PlayerData> optionalEmpty = Optional.empty();
            if (strArr.length >= 2 && !strArr[1].equalsIgnoreCase(JdgvQ3XGqogTQQXWFGi())) {
                try {
                    if (clans.getPlayerManager().xtOheRiObl4QeAl(strArr[1])) {
                        optionalEmpty = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[1]);
                    }
                } catch (Exception e) {
                }
            } else if (clans.getPlayerManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId())) {
                optionalEmpty = clans.getPlayerManager().p31abtwfBag2jhMH6K(player.getUniqueId());
            }
            if (!optionalEmpty.isPresent()) {
                try {
                    Player player2 = (strArr.length < 2 || strArr[1].equalsIgnoreCase(vsI8CP3aAIavj0cIErnf())) ? player : Bukkit.getPlayer(strArr[1]);
                    if (player2 != null && player2.isOnline()) {
                        optionalEmpty = clans.getPlayerManager().zJnaNCVQSgEShq(player2);
                    }
                } catch (Exception e2) {
                }
            }
            if (!optionalEmpty.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_PROFILE));
                return true;
            }
            Optional<PlayerData> optional = optionalEmpty;
            if (!new jBWyXxi9EyWxcPiz(clans).v8qP8fE86HMhvNuYPFjqY(player, Double.valueOf(commandData.getValue()), true)) {
                return true;
            }
            if (clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(BHjR15xAPKeYSJuahv()) || ((strArr.length == 3 && strArr[2].equalsIgnoreCase(gilQlnRi3sGtC8())) || (strArr.length == 2 && strArr[1].equalsIgnoreCase(IRKC3EwuFp8Pjn5jn2()))))) {
                clans.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfile(player, optionalEmpty.get().getUuid(), null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalEmpty.get().getUuid(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_PROFILE_VIEW_HEADER)));
            clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getStringList(Lang.HELP_CLAN_PROFILE_VIEW_FORMAT).iterator().forEachRemaining(str3 -> {
                MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(((PlayerData) optional.get()).getUuid(), str3));
            });
            return true;
        }
        if (str2.equalsIgnoreCase(AZKlDhyus1gMEV5dcUjp()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(YgBxEaePwvfkYJxZ(), str2)) {
            if (strArr.length > 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<PlayerData> optionalEmpty2 = Optional.empty();
            if (strArr.length >= 2 && !strArr[1].equalsIgnoreCase(WdjKS6BHn2pY3fm7V9())) {
                try {
                    if (clans.getPlayerManager().xtOheRiObl4QeAl(strArr[1])) {
                        optionalEmpty2 = clans.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(strArr[1]);
                    }
                } catch (Exception e3) {
                }
            } else if (clans.getPlayerManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId())) {
                optionalEmpty2 = clans.getPlayerManager().p31abtwfBag2jhMH6K(player.getUniqueId());
            }
            if (!optionalEmpty2.isPresent()) {
                try {
                    Player player3 = (strArr.length < 2 || strArr[1].equalsIgnoreCase(MyLfup5ShjLK5n())) ? player : Bukkit.getPlayer(strArr[1]);
                    if (player3 != null && player3.isOnline()) {
                        optionalEmpty2 = clans.getPlayerManager().zJnaNCVQSgEShq(player3);
                    }
                } catch (Exception e4) {
                }
            }
            if (!optionalEmpty2.isPresent()) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_PROFILE));
                return true;
            }
            if (clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(WfZtzBV2GbhmDT0()) || (strArr.length == 3 && strArr[2].equalsIgnoreCase(tqedFnMKDQh7oRRxPJIuT())))) {
                clans.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerPermissions(player, optionalEmpty2.get().getUuid(), Optional.empty());
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_PERMISSIONS_LIST_HEADER)));
            HashMap<String, Boolean> mapZJnaNCVQSgEShq = clans.getModerationManager().zJnaNCVQSgEShq(optionalEmpty2.get().getUuid());
            if (mapZJnaNCVQSgEShq == null || mapZJnaNCVQSgEShq.size() == 0) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalEmpty2.get().getUuid(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_PERMISSIONS_LIST_FORMAT)));
            return true;
        }
        if (str2.equalsIgnoreCase(Al228YMVKUIC06()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(zFpcKDofBgCAUTwZ6QbR(), str2)) {
            if (strArr.length > 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (clans.isUseGUI() && (clans.getFiles().p31abtwfBag2jhMH6K().getBoolean(QHNuofnHObg3uunLI()) || (strArr.length == 2 && strArr[1].equalsIgnoreCase(RKk5tXDNw7RKWS0swn4EfL())))) {
                clans.getGuiManager().Un3NRLL6aWivTcbodkcK().openProfileInvites(player, null);
                return true;
            }
            MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_INVITES_LIST_HEADER)));
            List<InviteData> listIZTqZaRK5UGoe0Z = clans.getPlayerInviteManager().iZTqZaRK5UGoe0Z(player.getUniqueId());
            if (listIZTqZaRK5UGoe0Z == null || listIZTqZaRK5UGoe0Z.size() == 0) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_LIST_EMPTY));
                return true;
            }
            listIZTqZaRK5UGoe0Z.iterator().forEachRemaining(inviteData -> {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getClanManager().iZTqZaRK5UGoe0Z(inviteData.getClanID());
                if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                    MessageUtils.sendText(commandSender, clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_INVITES_LIST_FORMAT)));
                }
            });
            return true;
        }
        if (str2.equalsIgnoreCase(SQ6U6UYOJkY1WJYSzI()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(kGM8CJNUhRyOWa(), str2)) {
            if (strArr.length != 1) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            if (!clans.getPlayerManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId())) {
                MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                return true;
            }
            if (CooldownAPI.isInCooldown(player.getUniqueId(), StohnRLwcjqZ1LCTAd1b())) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.error, null);
                return true;
            }
            new CooldownAPI(player.getUniqueId(), cvsff2BZgfdYVq1QEm(), clans.getFiles().p31abtwfBag2jhMH6K().getInt(dcC6JmZYS61Nuvi())).start();
            clans.getPlayerManager().HX3ZfRb1nSpNq57s7x5ui(player.getUniqueId());
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            return true;
        }
        if (!str2.equalsIgnoreCase(dVvq6UVbt2pcyqzBvYwxK()) && !clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(IAlid9zN70PGQrN7bEB0d(), str2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (strArr.length <= 2 || strArr.length > 3) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        if (!clans.getPlayerManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return true;
        }
        ClanEnum.PlayerSettingsType playerSettingsTypeValueOf = null;
        ClanEnum.SettingsFlagsAccept settingsFlagsAcceptValueOf = null;
        try {
            playerSettingsTypeValueOf = ClanEnum.PlayerSettingsType.valueOf(strArr[1].toUpperCase());
        } catch (Exception e5) {
        }
        try {
            settingsFlagsAcceptValueOf = ClanEnum.SettingsFlagsAccept.valueOf(strArr[2].toUpperCase());
        } catch (Exception e6) {
        }
        if (playerSettingsTypeValueOf == null) {
            StringBuilder sb = new StringBuilder();
            List listAsList = Arrays.asList(ClanEnum.PlayerSettingsType.values());
            for (int i = 0; i < listAsList.size(); i++) {
                if (i % 2 == 0) {
                    sb.append("&b" + ((ClanEnum.PlayerSettingsType) listAsList.get(i)).toString());
                } else {
                    sb.append("&7" + ((ClanEnum.PlayerSettingsType) listAsList.get(i)).toString());
                }
                if (i + 1 < listAsList.size()) {
                    sb.append(QHtdTOp4MD7xvMsBG8());
                } else {
                    sb.append(QhdEq85hwPd3FPJ7r());
                }
            }
            MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.ACCEPTED_VALUES, Arrays.asList("%types%;" + sb.toString())));
            return true;
        }
        if (settingsFlagsAcceptValueOf != null) {
            clans.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), playerSettingsTypeValueOf, settingsFlagsAcceptValueOf);
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, null);
            return true;
        }
        StringBuilder sb2 = new StringBuilder();
        List listAsList2 = Arrays.asList(ClanEnum.SettingsFlagsAccept.values());
        for (int i2 = 0; i2 < listAsList2.size(); i2++) {
            if (i2 % 2 == 0) {
                sb2.append("&b" + ((ClanEnum.SettingsFlagsAccept) listAsList2.get(i2)).toString());
            } else {
                sb2.append("&7" + ((ClanEnum.SettingsFlagsAccept) listAsList2.get(i2)).toString());
            }
            if (i2 + 1 < listAsList2.size()) {
                sb2.append(gogS9IUpcsFRktC());
            } else {
                sb2.append(S5UWHZuuZ3Y0iY27());
            }
        }
        MessageUtils.sendText((CommandSender) player, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.ACCEPTED_VALUES, Arrays.asList("%types%;" + sb2.toString())));
        return true;
    }

    private static String JSZDwTar4norNG(byte[] bArr) {
        return "";
    }

    private static String eaXwMYAkFBwemn21JW3x() {
        return "profile";
    }

    private static String t11ymomNdZNOuY7() {
        return "profile";
    }

    private static String KsOrZZenDQpONb() {
        return "view";
    }

    private static String GvJAhSSUu7VCOQ8CRtVn() {
        return "view";
    }

    private static String JdgvQ3XGqogTQQXWFGi() {
        return "-gui";
    }

    private static String vsI8CP3aAIavj0cIErnf() {
        return "-gui";
    }

    private static String BHjR15xAPKeYSJuahv() {
        return "Config.gui.forge_open-gui";
    }

    private static String gilQlnRi3sGtC8() {
        return "-gui";
    }

    private static String IRKC3EwuFp8Pjn5jn2() {
        return "-gui";
    }

    private static String AZKlDhyus1gMEV5dcUjp() {
        return "permissions";
    }

    private static String YgBxEaePwvfkYJxZ() {
        return "permissions";
    }

    private static String WdjKS6BHn2pY3fm7V9() {
        return "-gui";
    }

    private static String MyLfup5ShjLK5n() {
        return "-gui";
    }

    private static String WfZtzBV2GbhmDT0() {
        return "Config.gui.forge_open-gui";
    }

    private static String tqedFnMKDQh7oRRxPJIuT() {
        return "-gui";
    }

    private static String Al228YMVKUIC06() {
        return "invites";
    }

    private static String zFpcKDofBgCAUTwZ6QbR() {
        return "invites";
    }

    private static String QHNuofnHObg3uunLI() {
        return "Config.gui.forge_open-gui";
    }

    private static String RKk5tXDNw7RKWS0swn4EfL() {
        return "-gui";
    }

    private static String SQ6U6UYOJkY1WJYSzI() {
        return "updateskin";
    }

    private static String kGM8CJNUhRyOWa() {
        return "updateskin";
    }

    private static String StohnRLwcjqZ1LCTAd1b() {
        return "skin_update";
    }

    private static String cvsff2BZgfdYVq1QEm() {
        return "skin_update";
    }

    private static String dcC6JmZYS61Nuvi() {
        return "Config.player.skin.custom_cooldown";
    }

    private static String dVvq6UVbt2pcyqzBvYwxK() {
        return "set";
    }

    private static String IAlid9zN70PGQrN7bEB0d() {
        return "set";
    }

    private static String QHtdTOp4MD7xvMsBG8() {
        return "&8, ";
    }

    private static String QhdEq85hwPd3FPJ7r() {
        return "&8.";
    }

    private static String gogS9IUpcsFRktC() {
        return "&8, ";
    }

    private static String S5UWHZuuZ3Y0iY27() {
        return "&8.";
    }
}
