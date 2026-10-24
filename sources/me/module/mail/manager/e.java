package me.module.mail.manager;

import java.util.Optional;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import me.module.mail.Mail;
import me.module.mail.manager.EnumFiles.Lang;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.MailData;
import me.ulrich.clans.manager.utils.Times;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/e.class */
public class e {
    private static byte[] __aes_key_8nMo8Qvd = {(byte) 26, (byte) 31, (byte) 141, (byte) 187, (byte) 249, (byte) 213, (byte) 251, (byte) 237, (byte) 104, (byte) 63, (byte) 116, (byte) 229, (byte) 241, (byte) 91, (byte) 16, (byte) 185, (byte) 232, (byte) 111, (byte) 239, (byte) 201, (byte) 119, (byte) 254, (byte) 116, (byte) 214, (byte) 201, (byte) 180, (byte) 164, (byte) 182, (byte) 16, (byte) 152, (byte) 23, (byte) 211};
    private static byte[] __aes_iv_4gB78Lx7 = {(byte) 204, (byte) 221, (byte) 54, (byte) 197, (byte) 54, (byte) 110, (byte) 164, (byte) 96, (byte) 172, (byte) 121, (byte) 67, (byte) 5, (byte) 11, (byte) 139, (byte) 142, (byte) 228};
    private static String __s_cache_rjeWK9aB_0;
    private static String __s_cache_jUhnaXys_1;
    private static String __s_cache_BocuJcWR_2;
    private static String __s_cache_YXWIp3BR_3;
    private static String __s_cache_W07ndbaQ_4;
    private static String __s_cache_XFBGqQ9y_5;
    private static String __s_cache_fhJ1dsmy_6;
    private static String __s_cache_OOhkMsVu_7;
    private static String __s_cache_3bL8P3N9_8;
    private static String __s_cache_QwKcMneq_9;
    private static String __s_cache_ESy4R3MB_10;
    private static String __s_cache_JqnUD81O_11;
    private static String __s_cache_3WR2MBdk_12;
    private static String __s_cache_ja98YVpE_13;
    private static String __s_cache_eXWMVSYx_14;
    private static String __s_cache_HOEPHWJu_15;
    private static String __s_cache_33SEDIny_16;

    public String a(Player player, String str) {
        return a(player.getUniqueId(), str);
    }

    public String a(UUID uuid, String str) {
        Optional<ClanData> playerClan = Mail.a().getPlayerAPI().getPlayerClan(uuid);
        if (!playerClan.isPresent()) {
            return str;
        }
        if (str.equals("mail_amount")) {
            return playerClan.isPresent() ? String.valueOf(Mail.getModuleCore().e().getClanMail(playerClan.get().getId()).size()) : "0";
        }
        if (str.equals("mail_amount_unread")) {
            return playerClan.isPresent() ? String.valueOf(Mail.getModuleCore().e().getClanMailTimed(playerClan.get().getId(), uuid, ClanEnum.MailTime.UNREAD).size()) : "0";
        }
        if (!str.startsWith("mail:") || !playerClan.isPresent()) {
            return null;
        }
        String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 3) {
            return null;
        }
        String lowerCase = strArrSplit[2].toLowerCase();
        Matcher matcher = Pattern.compile("\\{([^}]*)\\}").matcher(strArrSplit[1]);
        if (!matcher.find()) {
            return null;
        }
        try {
            Optional<MailData> mailById = Mail.getModuleCore().e().getMailById(UUID.fromString(matcher.group(1)));
            if (!mailById.isPresent()) {
                return null;
            }
            if (lowerCase.equals("text")) {
                return mailById.get().getText();
            }
            if (lowerCase.equals("from")) {
                Optional<ClanData> clan = Mail.a().getClanAPI().getClan(mailById.get().getFrom());
                return clan.isPresent() ? clan.get().getTag() : Mail.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.CLAN_DELETED_SMALL);
            }
            if (lowerCase.equals("readstate")) {
                return mailById.get().getReadBy().contains(uuid) ? Mail.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.MAIL_READSTATE_TRUE) : Mail.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.MAIL_READSTATE_FALSE);
            }
            if (lowerCase.equals("readstate_formated")) {
                return mailById.get().getReadBy().contains(uuid) ? Mail.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.MAIL_READSTATE_FORMATED_TRUE) : Mail.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.MAIL_READSTATE_FORMATED_FALSE);
            }
            if (lowerCase.equals("to")) {
                Optional<ClanData> clan2 = Mail.a().getClanAPI().getClan(mailById.get().getTo());
                return clan2.isPresent() ? clan2.get().getTag() : Mail.getModuleCore().c().b(Optional.of(uuid)).getString(Lang.CLAN_DELETED_SMALL);
            }
            if (lowerCase.equals("date")) {
                return new Times().unixToDate(Long.valueOf(mailById.get().getDate() * 1000), Mail.getModuleCore().c().j().getString("Config.date_format_short"));
            }
            if (!lowerCase.equals("expires")) {
                return null;
            }
            int date = (int) ((mailById.get().getDate() + ((long) (60 * Mail.getModuleCore().c().j().getInt("Clan.logger.time_expires")))) - (System.currentTimeMillis() / 1000));
            return date < 1 ? "0s" : f.a(date);
        } catch (Exception e) {
            return null;
        }
    }

    private static String __unused_690() {
        return "mail_amount";
    }

    private static String __unused_691() {
        return "0";
    }

    private static String __unused_692() {
        return "mail_amount_unread";
    }

    private static String __unused_693() {
        return "0";
    }

    private static String __unused_694() {
        return "mail:";
    }

    private static String __unused_695() {
        return ":";
    }

    private static String __unused_696() {
        return "\\{([^}]*)\\}";
    }

    private static String __unused_697() {
        return "text";
    }

    private static String __unused_698() {
        return "from";
    }

    private static String __unused_699() {
        return "readstate";
    }

    private static String __unused_700() {
        return "readstate_formated";
    }

    private static String __unused_701() {
        return "to";
    }

    private static String __unused_702() {
        return "date";
    }

    private static String __unused_703() {
        return "Config.date_format_short";
    }

    private static String __unused_704() {
        return "expires";
    }

    private static String __unused_705() {
        return "Clan.logger.time_expires";
    }

    private static String __unused_706() {
        return "0s";
    }
}
