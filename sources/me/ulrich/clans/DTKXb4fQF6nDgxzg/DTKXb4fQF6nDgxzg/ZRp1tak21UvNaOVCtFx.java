package me.ulrich.clans.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.Flag;
import me.ulrich.clans.interfaces.ClansCommand;
import me.ulrich.clans.library.gui.components.util.Legacy;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.MiniMessage;
import me.ulrich.clans.library.kyori.adventure.text.minimessage.tag.resolver.Formatter;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx implements ClansCommand {
    private static String DaORE7ZICukBHy;
    private static String QdbxvFNcwYPGZmP;
    private static volatile String UjZI8MZnUxQN1l;
    private static String rqikYUyqhxWPEa2DDQ8u9m;
    private static String SE1XBw2rvYSh6NwgEtgWe6;
    private static volatile String rTjATNMiWqlWkfJ4;
    private static volatile String FwRWlUprRE9n60tp;
    private static String hbbJEURti4wlr3OjwOH;
    private static volatile String BY7crC1UCVAVzBHqcE;
    private static volatile String VKeUTQQwzuJTmwbp9n;
    private static String tdPaLb1gkTdIIA3tXXDLW;
    private static volatile String BgowOwZ7QM3EjJYfRqxF9;
    private static final byte[] AXq0Y9HwTmCboxsYU = {(byte) 22, (byte) 74, (byte) 48, (byte) 250, (byte) 25, (byte) 227, (byte) 94, (byte) 66, (byte) 154, (byte) 33, (byte) 148, (byte) 110, (byte) 23, (byte) 150, (byte) 239, (byte) 23};
    private static final byte[] lQDRXFWB0aSEzYrzNpC = {(byte) 215, (byte) 122, (byte) 238, (byte) 233, (byte) 187, (byte) 35, (byte) 119, (byte) 30, (byte) 230, (byte) 221, (byte) 148, (byte) 29, (byte) 35, (byte) 15, (byte) 224, (byte) 33, (byte) 57, (byte) 154, (byte) 252, (byte) 238, (byte) 166, (byte) 204, (byte) 173, (byte) 212, (byte) 65, (byte) 103, (byte) 225, (byte) 75, (byte) 172, (byte) 129, (byte) 155, (byte) 77};
    private static final byte[] RMUfZVNro5WRCcfkLXJK = {(byte) 158, (byte) 225, (byte) 21, (byte) 209, (byte) 6, (byte) 207, (byte) 12, (byte) 241, (byte) 185, (byte) 177, (byte) 32, (byte) 29, (byte) 153, (byte) 142, (byte) 181, (byte) 4};
    private static final byte[] AhljCEQuI08kZJ = {(byte) 158, (byte) 225, (byte) 21, (byte) 209, (byte) 6, (byte) 207, (byte) 12, (byte) 241, (byte) 185, (byte) 177, (byte) 32, (byte) 29, (byte) 153, (byte) 142, (byte) 181, (byte) 4};
    private static final byte[] NnxUhGyUfStc4fMz = {(byte) 22, (byte) 74, (byte) 48, (byte) 250, (byte) 25, (byte) 227, (byte) 94, (byte) 66, (byte) 154, (byte) 33, (byte) 148, (byte) 110, (byte) 23, (byte) 150, (byte) 239, (byte) 23};
    private static final byte[] M2SmDn2uzORrKmXVbga9W5 = {(byte) 22, (byte) 74, (byte) 48, (byte) 250, (byte) 25, (byte) 227, (byte) 94, (byte) 66, (byte) 154, (byte) 33, (byte) 148, (byte) 110, (byte) 23, (byte) 150, (byte) 239, (byte) 23};
    private static final byte[] eECzt4ZlEldtRZp = {(byte) 74, (byte) 208, (byte) 249, (byte) 174, (byte) 108, (byte) 10, (byte) 151, (byte) 189, (byte) 190, (byte) 122, (byte) 180, (byte) 164, (byte) 146, (byte) 78, (byte) 143, (byte) 8, (byte) 199, (byte) 117, (byte) 33, (byte) 38, (byte) 220, (byte) 233, (byte) 110, (byte) 85, (byte) 153, (byte) 83, (byte) 208, (byte) 248, (byte) 195, (byte) 230, (byte) 204, (byte) 106};
    private static final byte[] xhGJ1glpGHwyvj = {(byte) 203, (byte) 84, (byte) 223, (byte) 237, (byte) 107, (byte) 22, (byte) 165, (byte) 33, (byte) 157, (byte) 205, (byte) 204, (byte) 84, (byte) 209, (byte) 27, (byte) 53, (byte) 83};

    @Override // me.ulrich.clans.interfaces.ClansCommand
    public boolean execute(Clans clans, CommandSender commandSender, Command command, String str, String[] strArr, EnumMap<Flag, String> enumMap) {
        if (!clans.getCommandManager().iZTqZaRK5UGoe0Z().containsKey(gxYfRbVVB207gnm9T())) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.DISABLED_FUNCTION));
            return true;
        }
        CommandData commandData = clans.getCommandManager().iZTqZaRK5UGoe0Z().get(b5InqKi2Rzqeiv());
        if (strArr.length == 0) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        String str2 = strArr[0];
        if (str2.equalsIgnoreCase(PoNydlLid430TK8ScH()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(z4WMWOkeJbsxmefE(), str2)) {
            if (strArr.length != 2) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            String strValueOf = null;
            try {
                strValueOf = String.valueOf(strArr[1]);
            } catch (Exception e) {
            }
            if (strValueOf == null) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strValueOf);
            if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strValueOf);
                if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                    optionalJBUuLP0sWwaPyPOmogdX7l = optionalIZTqZaRK5UGoe0Z;
                }
            }
            if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("{value};" + String.valueOf(Legacy.SERIALIZER.serialize(MiniMessage.miniMessage().deserialize("<bank:'" + clans.getFiles().p31abtwfBag2jhMH6K().getString(NGlaRpWWkt8WF67()) + "'>", Formatter.number(czLzM08zwygySaXE(), optionalJBUuLP0sWwaPyPOmogdX7l.get().getBank()))))));
            return true;
        }
        if (str2.equalsIgnoreCase(pzouSxsedEdtGJvlxvT2F3()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(Tf4b1XZgeHH0KLUiS8X(), str2)) {
            if (strArr.length != 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            String strValueOf2 = null;
            Double dValueOf = Double.valueOf(0.0d);
            try {
                strValueOf2 = String.valueOf(strArr[1]);
            } catch (Exception e2) {
            }
            try {
                dValueOf = Double.valueOf(strArr[2]);
                if (dValueOf.doubleValue() < 0.0d) {
                    dValueOf = Double.valueOf(0.0d);
                }
            } catch (Exception e3) {
            }
            if (strValueOf2 == null || dValueOf.doubleValue() < 1.0d) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l2 = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strValueOf2);
            if (!optionalJBUuLP0sWwaPyPOmogdX7l2.isPresent()) {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z2 = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strValueOf2);
                if (optionalIZTqZaRK5UGoe0Z2.isPresent()) {
                    optionalJBUuLP0sWwaPyPOmogdX7l2 = optionalIZTqZaRK5UGoe0Z2;
                }
            }
            if (!optionalJBUuLP0sWwaPyPOmogdX7l2.isPresent()) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            optionalJBUuLP0sWwaPyPOmogdX7l2.get().setBank(dValueOf);
            clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalJBUuLP0sWwaPyPOmogdX7l2.get());
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("{value};" + dValueOf));
            return true;
        }
        if (str2.equalsIgnoreCase(Mv4KoVmlbhhe5hnz8Dp()) || clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(RTTWx764IV4EzQqpA0hGsV(), str2)) {
            if (strArr.length != 3) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            String strValueOf3 = null;
            Double dValueOf2 = Double.valueOf(0.0d);
            try {
                strValueOf3 = String.valueOf(strArr[1]);
            } catch (Exception e4) {
            }
            try {
                dValueOf2 = Double.valueOf(strArr[2]);
            } catch (Exception e5) {
            }
            if (strValueOf3 == null || dValueOf2.doubleValue() < 0.0d) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l3 = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strValueOf3);
            if (!optionalJBUuLP0sWwaPyPOmogdX7l3.isPresent()) {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z3 = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strValueOf3);
                if (optionalIZTqZaRK5UGoe0Z3.isPresent()) {
                    optionalJBUuLP0sWwaPyPOmogdX7l3 = optionalIZTqZaRK5UGoe0Z3;
                }
            }
            if (!optionalJBUuLP0sWwaPyPOmogdX7l3.isPresent()) {
                MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
                return true;
            }
            if (optionalJBUuLP0sWwaPyPOmogdX7l3.get().getBank().doubleValue() < dValueOf2.doubleValue()) {
                MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
                return true;
            }
            Double dValueOf3 = Double.valueOf(optionalJBUuLP0sWwaPyPOmogdX7l3.get().getBank().doubleValue() - dValueOf2.doubleValue());
            optionalJBUuLP0sWwaPyPOmogdX7l3.get().setBank(dValueOf3);
            clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalJBUuLP0sWwaPyPOmogdX7l3.get());
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("{value};" + dValueOf3));
            return true;
        }
        if (!str2.equalsIgnoreCase(hYTMziTdKm9sjn()) && !clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(EWBxptbUuAXeVB1(), str2)) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.HELP_CLAN_HEADER_SUBCOMMAND));
            MessageUtils.sendCommandJson(commandSender, commandData, ClanEnum.MsgUsage.help, null);
            clans.getCommandManager().v8qP8fE86HMhvNuYPFjqY(commandSender, commandData);
            return true;
        }
        if (strArr.length != 3) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        String strValueOf4 = null;
        Double dValueOf4 = Double.valueOf(0.0d);
        try {
            strValueOf4 = String.valueOf(strArr[1]);
        } catch (Exception e6) {
        }
        try {
            dValueOf4 = Double.valueOf(strArr[2]);
            if (dValueOf4.doubleValue() < 0.0d) {
                dValueOf4 = Double.valueOf(0.0d);
            }
        } catch (Exception e7) {
        }
        if (strValueOf4 == null || dValueOf4.doubleValue() < 1.0d) {
            MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.usage, null);
            return true;
        }
        Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l4 = clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(strValueOf4);
        if (!optionalJBUuLP0sWwaPyPOmogdX7l4.isPresent()) {
            Optional<ClanData> optionalIZTqZaRK5UGoe0Z4 = clans.getPlayerManager().iZTqZaRK5UGoe0Z(strValueOf4);
            if (optionalIZTqZaRK5UGoe0Z4.isPresent()) {
                optionalJBUuLP0sWwaPyPOmogdX7l4 = optionalIZTqZaRK5UGoe0Z4;
            }
        }
        if (!optionalJBUuLP0sWwaPyPOmogdX7l4.isPresent()) {
            MessageUtils.sendText(commandSender, clans.getFiles().v8qP8fE86HMhvNuYPFjqY(commandSender).getString(Lang.CLAN_NOT_FOUND));
            return true;
        }
        Double dValueOf5 = Double.valueOf(optionalJBUuLP0sWwaPyPOmogdX7l4.get().getBank().doubleValue() + dValueOf4.doubleValue());
        optionalJBUuLP0sWwaPyPOmogdX7l4.get().setBank(dValueOf5);
        clans.getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalJBUuLP0sWwaPyPOmogdX7l4.get());
        MessageUtils.sendSubCommandJson(commandSender, commandData, str2, ClanEnum.MsgUsage.success, Arrays.asList("{value};" + dValueOf5));
        return true;
    }

    private static String gxYfRbVVB207gnm9T() {
        return "bank";
    }

    private static String b5InqKi2Rzqeiv() {
        return "bank";
    }

    private static String PoNydlLid430TK8ScH() {
        return "view";
    }

    private static String z4WMWOkeJbsxmefE() {
        return "view";
    }

    private static String NGlaRpWWkt8WF67() {
        return "Config.money.format";
    }

    private static String czLzM08zwygySaXE() {
        return "bank";
    }

    private static String pzouSxsedEdtGJvlxvT2F3() {
        return "set";
    }

    private static String Tf4b1XZgeHH0KLUiS8X() {
        return "set";
    }

    private static String Mv4KoVmlbhhe5hnz8Dp() {
        return "remove";
    }

    private static String RTTWx764IV4EzQqpA0hGsV() {
        return "remove";
    }

    private static String hYTMziTdKm9sjn() {
        return "add";
    }

    private static String EWBxptbUuAXeVB1() {
        return "add";
    }
}
