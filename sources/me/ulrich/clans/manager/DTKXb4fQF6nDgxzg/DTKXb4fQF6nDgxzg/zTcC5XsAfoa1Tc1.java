package me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.DTKXb4fQF6nDgxzg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.events.ClanMultiserverPingEvent;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/DTKXb4fQF6nDgxzg/DTKXb4fQF6nDgxzg/zTcC5XsAfoa1Tc1.class */
public class zTcC5XsAfoa1Tc1 {
    private static String DZUyjS015bTjZ8mn;
    private static volatile String EsHwOgI9pBCM1XjEY;
    private static volatile String IfJtGwUhCzpjnilg96Yri;
    private static volatile String i2MN8AvnzVThngswt;
    private static String LT4RVBiEv3qufK;
    private static String iwi8IeMKEm9T1zlCY5IVfQ;
    private static String DX1MLfa4ymq9Np;
    private static String Ivog43JWZjYkBtrINAc;
    private static volatile String R8jLImg5RneCfvIR9DrN8V;
    private static volatile String wkjmrOIXPfpKv6Hi8D31;
    private static String oN5r8tQd7SGjFvA;
    private static volatile String n8ISqZXfmRwKJ4j;
    private static String vwCtzgxlDYCk97fdOeqk;
    private static final byte[] eB2wyUkVcmfWfP5P3c = {(byte) 23, (byte) 186, (byte) 100, (byte) 227, (byte) 114, (byte) 177, (byte) 180, (byte) 117, (byte) 194, (byte) 165, (byte) 205, (byte) 159, (byte) 155, (byte) 232, (byte) 251, (byte) 204, (byte) 136, (byte) 234, (byte) 78, (byte) 89, (byte) 249, (byte) 247, (byte) 85, (byte) 167, (byte) 129, (byte) 130, (byte) 5, (byte) 72, (byte) 107, (byte) 149, (byte) 120, (byte) 219};
    private static final byte[] xwbEoOCTPL1Y77gP4 = {(byte) 170, (byte) 70, (byte) 10, (byte) 174, (byte) 167, (byte) 160, (byte) 114, (byte) 186, (byte) 224, (byte) 192, (byte) 253, (byte) 2, (byte) 15, (byte) 188, (byte) 70, (byte) 42};
    private static final byte[] EJ2dunKVmHeIEY = {(byte) 71, (byte) 43, (byte) 119, (byte) 109, (byte) 56, (byte) 164, (byte) 125, (byte) 206, (byte) 118, (byte) 228, (byte) 66, (byte) 225, (byte) 144, (byte) 18, (byte) 107, (byte) 178};
    private static final byte[] RLQj1BgFNqkMMabB = {(byte) 23, (byte) 186, (byte) 100, (byte) 227, (byte) 114, (byte) 177, (byte) 180, (byte) 117, (byte) 194, (byte) 165, (byte) 205, (byte) 159, (byte) 155, (byte) 232, (byte) 251, (byte) 204, (byte) 136, (byte) 234, (byte) 78, (byte) 89, (byte) 249, (byte) 247, (byte) 85, (byte) 167, (byte) 129, (byte) 130, (byte) 5, (byte) 72, (byte) 107, (byte) 149, (byte) 120, (byte) 219};
    private static final byte[] WWhl9sHU96nDGkmSVL = {(byte) 56, (byte) 216, (byte) 4, (byte) 137, (byte) 125, (byte) 116, (byte) 29, (byte) 62, (byte) 33, (byte) 209, (byte) 157, (byte) 189, (byte) 111, (byte) 237, (byte) 105, (byte) 32};
    private static final byte[] w2s1Nx7uKwFyQ9m = {(byte) 198, (byte) 8, (byte) 47, (byte) 12, (byte) 226, (byte) 150, (byte) 66, (byte) 40, (byte) 8, (byte) 77, (byte) 159, (byte) 150, (byte) 249, (byte) 248, (byte) 202, (byte) 163};
    private static final byte[] nltGRX9R2jgFjTYtXu1 = {(byte) 198, (byte) 8, (byte) 47, (byte) 12, (byte) 226, (byte) 150, (byte) 66, (byte) 40, (byte) 8, (byte) 77, (byte) 159, (byte) 150, (byte) 249, (byte) 248, (byte) 202, (byte) 163};
    private static final byte[] aZUw4lIOeHGYqr = {(byte) 198, (byte) 8, (byte) 47, (byte) 12, (byte) 226, (byte) 150, (byte) 66, (byte) 40, (byte) 8, (byte) 77, (byte) 159, (byte) 150, (byte) 249, (byte) 248, (byte) 202, (byte) 163};
    private static final byte[] nMbbP6j4usKpRnH = {(byte) 182, (byte) 151, (byte) 84, (byte) 226, (byte) 132, (byte) 154, (byte) 186, (byte) 75, (byte) 35, (byte) 192, (byte) 178, (byte) 252, (byte) 207, (byte) 81, (byte) 162, (byte) 226};
    private static final byte[] kKirqqw6avttYWugzWK = {(byte) 100, (byte) 157, (byte) 145, (byte) 142, (byte) 153, (byte) 119, (byte) 211, (byte) 235, (byte) 250, (byte) 108, (byte) 92, (byte) 106, (byte) 0, (byte) 7, (byte) 30, (byte) 142, (byte) 156, (byte) 47, (byte) 110, (byte) 250, (byte) 114, (byte) 175, (byte) 203, (byte) 237, (byte) 97, (byte) 131, (byte) 10, (byte) 16, (byte) 199, (byte) 191, (byte) 162, (byte) 194};
    private static final byte[] Y1s0O5yobQDjhiIII = {(byte) 141, (byte) 204, (byte) 31, (byte) 112, (byte) 58, (byte) 104, (byte) 253, (byte) 191, (byte) 241, (byte) 57, (byte) 180, (byte) 69, (byte) 169, (byte) 63, (byte) 148, (byte) 211};

    public static void v8qP8fE86HMhvNuYPFjqY(ClanData clanData) {
        try {
            FileConfiguration fileConfigurationLGGwXL678c4Kv7skJb5NiE = Clans.getClanCore().getFiles().lGGwXL678c4Kv7skJb5NiE();
            String str = "data." + String.valueOf(clanData.getId());
            Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY = Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(clanData);
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".tag", clanData.getTag());
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".tag_raw", clanData.getTagNoColor());
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".desc", clanData.getDesc());
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".leader", clanData.getLeader().toString());
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".verified", Boolean.valueOf(clanData.isVerified()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".home", v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.zJnaNCVQSgEShq, YNGheSTVssMD92f5aXa()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".creation_date", Long.valueOf(clanData.getCreationDate()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".members", v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY, XTHMSpbq5DY7I4uZr1()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".online_members", "");
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".mods", v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l, Z6OLLyjBqNni46H7SwbKX()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".rival", v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.iZTqZaRK5UGoe0Z, tT7urXRriXn5FZ()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".ally", v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.xtOheRiObl4QeAl, G2Ip9uMe0FyVtvidD()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".banned", v8qP8fE86HMhvNuYPFjqY(ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q, LkZMjkcMjoLCVA()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".kills", Integer.valueOf(clanData.getStats().getKills()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".deaths", Integer.valueOf(clanData.getStats().getDeaths()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".souls", String.valueOf(clanData.getStats().getSouls()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".kdr", Double.valueOf(clanData.getKdr()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".ff", Boolean.valueOf(clanData.isFf()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".bank", clanData.getBank().toString());
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".level", String.valueOf(clanData.getLevel()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".maxlevel", String.valueOf(clanData.getMaxlevel()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".extra_slots", String.valueOf(clanData.getExtraSlots()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".quest.points", Integer.valueOf(clanData.getQuest().getPoints()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".quest.finished", Integer.valueOf(clanData.getQuest().getFinished()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".member_joined", Integer.valueOf(clanData.getStats().getMemberJoined()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".member_left", Integer.valueOf(clanData.getStats().getMemberLeft()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".war_win", Integer.valueOf(clanData.getStats().getWarWin()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".war_lose", Integer.valueOf(clanData.getStats().getWarLose()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".glad_win", Integer.valueOf(clanData.getStats().getGladWin()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".glad_lose", Integer.valueOf(clanData.getStats().getGladLose()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".league_win", Integer.valueOf(clanData.getStats().getLeagueWin()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".league_lose", Integer.valueOf(clanData.getStats().getLeagueLose()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".tag_changed", Integer.valueOf(clanData.getStats().getTagChanged()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".member_kicked", Integer.valueOf(clanData.getStats().getMemberKicked()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".extra_chest", Integer.valueOf(clanData.getChestSettings().getExtraChest()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".locked_pages_chest", clanData.getChestSettings().getLockedPages());
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".banner", ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.b4i2FbOkaKeg91LiAe6l);
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.war_invite", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isWarInvite())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.ally_shared_chat", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllySharedChat())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.ally_shared_home", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllySharedHome())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.join_leave", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isJoinLeave())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.opened", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isOpened())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.public_homes", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isPublicHomes())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.receive_mail_allies", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isReceveMailAllies())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.receive_mail_all", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isReceiveMailAll())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.allypvp", Integer.valueOf(v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllyPvp())));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".settings.json_meta", clanData.getSettings().getJsonMeta().map((v0) -> {
                return v0.toString();
            }).orElse(null));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".patent", String.valueOf(clanData.getPatent()));
            fileConfigurationLGGwXL678c4Kv7skJb5NiE.set(str + ".webhook", String.valueOf(clanData.getWebhook()));
            Clans.getClanCore().getFiles().b4i2FbOkaKeg91LiAe6l().get(xZ1ZEG4osmu9Y9fLngXreJ()).save();
        } catch (Exception e) {
            Clans.getClanCore().getLogger().severe("Failed to save YAML clan: " + String.valueOf(clanData.getId()));
            e.printStackTrace();
        }
    }

    public static void jBUuLP0sWwaPyPOmogdX7l(ClanData clanData) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(wuaKTCHkPijAeacAMWDPo());
        Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY = Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(clanData);
        String str = "INSERT INTO `" + string + "` (id, tag, tag_raw, `desc`, leader, verified, home, creation_date, members, mods, banned, rival, ally,kills, deaths, souls, kdr, ff, bank, level, quest_points, quest_finished, member_joined, member_left,war_win, war_lose, tag_changed, member_kicked, war_invite, ally_shared_chat, extra_chest,locked_pages_chest, join_leave, ally_shared_home, banner, maxlevel, extra_slots, opened,public_homes, patent, webhook, receive_mail_allies, receive_mail_all, json_meta, allypvp,glad_win, glad_lose, league_win, league_lose) VALUES (" + String.join(N99qYHzZDS2ErPv6(), Collections.nCopies(49, nQWZDwKxcCSlBy1BMd())) + ") ON CONFLICT(id) DO UPDATE SET tag=excluded.tag, tag_raw=excluded.tag_raw, `desc`=excluded.`desc`, leader=excluded.leader,verified=excluded.verified, home=excluded.home, creation_date=excluded.creation_date,members=excluded.members, mods=excluded.mods, banned=excluded.banned,rival=excluded.rival, ally=excluded.ally,kills=excluded.kills, deaths=excluded.deaths, souls=excluded.souls,kdr=excluded.kdr, ff=excluded.ff, bank=excluded.bank, level=excluded.level,quest_points=excluded.quest_points, quest_finished=excluded.quest_finished,member_joined=excluded.member_joined, member_left=excluded.member_left,war_win=excluded.war_win, war_lose=excluded.war_lose,tag_changed=excluded.tag_changed, member_kicked=excluded.member_kicked,war_invite=excluded.war_invite, ally_shared_chat=excluded.ally_shared_chat,extra_chest=excluded.extra_chest, locked_pages_chest=excluded.locked_pages_chest,join_leave=excluded.join_leave, ally_shared_home=excluded.ally_shared_home,banner=excluded.banner, maxlevel=excluded.maxlevel, extra_slots=excluded.extra_slots,opened=excluded.opened, public_homes=excluded.public_homes,patent=excluded.patent, webhook=excluded.webhook,receive_mail_allies=excluded.receive_mail_allies,receive_mail_all=excluded.receive_mail_all,json_meta=excluded.json_meta, allypvp=excluded.allypvp,glad_win=excluded.glad_win, glad_lose=excluded.glad_lose,league_win=excluded.league_win, league_lose=excluded.league_lose";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, clanData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, clanData.getTag());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, clanData.getTagNoColor());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, clanData.getDesc());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setString(i4, clanData.getLeader().toString());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setBoolean(i5, clanData.isVerified());
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.zJnaNCVQSgEShq);
                    int i8 = i7 + 1;
                    preparedStatementPrepareStatement.setLong(i7, clanData.getCreationDate());
                    int i9 = i8 + 1;
                    preparedStatementPrepareStatement.setString(i8, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY);
                    int i10 = i9 + 1;
                    preparedStatementPrepareStatement.setString(i9, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l);
                    int i11 = i10 + 1;
                    preparedStatementPrepareStatement.setString(i10, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q);
                    int i12 = i11 + 1;
                    preparedStatementPrepareStatement.setString(i11, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.iZTqZaRK5UGoe0Z);
                    int i13 = i12 + 1;
                    preparedStatementPrepareStatement.setString(i12, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.xtOheRiObl4QeAl);
                    int i14 = i13 + 1;
                    preparedStatementPrepareStatement.setInt(i13, clanData.getStats().getKills());
                    int i15 = i14 + 1;
                    preparedStatementPrepareStatement.setInt(i14, clanData.getStats().getDeaths());
                    int i16 = i15 + 1;
                    preparedStatementPrepareStatement.setInt(i15, clanData.getStats().getSouls());
                    int i17 = i16 + 1;
                    preparedStatementPrepareStatement.setDouble(i16, clanData.getKdr());
                    int i18 = i17 + 1;
                    preparedStatementPrepareStatement.setBoolean(i17, clanData.isFf());
                    int i19 = i18 + 1;
                    preparedStatementPrepareStatement.setString(i18, clanData.getBank().toString());
                    int i20 = i19 + 1;
                    preparedStatementPrepareStatement.setInt(i19, clanData.getLevel());
                    int i21 = i20 + 1;
                    preparedStatementPrepareStatement.setInt(i20, clanData.getQuest().getPoints());
                    int i22 = i21 + 1;
                    preparedStatementPrepareStatement.setInt(i21, clanData.getQuest().getFinished());
                    int i23 = i22 + 1;
                    preparedStatementPrepareStatement.setInt(i22, clanData.getStats().getMemberJoined());
                    int i24 = i23 + 1;
                    preparedStatementPrepareStatement.setInt(i23, clanData.getStats().getMemberLeft());
                    int i25 = i24 + 1;
                    preparedStatementPrepareStatement.setInt(i24, clanData.getStats().getWarWin());
                    int i26 = i25 + 1;
                    preparedStatementPrepareStatement.setInt(i25, clanData.getStats().getWarLose());
                    int i27 = i26 + 1;
                    preparedStatementPrepareStatement.setInt(i26, clanData.getStats().getTagChanged());
                    int i28 = i27 + 1;
                    preparedStatementPrepareStatement.setInt(i27, clanData.getStats().getMemberKicked());
                    int i29 = i28 + 1;
                    preparedStatementPrepareStatement.setInt(i28, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isWarInvite()));
                    int i30 = i29 + 1;
                    preparedStatementPrepareStatement.setInt(i29, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllySharedChat()));
                    int i31 = i30 + 1;
                    preparedStatementPrepareStatement.setInt(i30, clanData.getChestSettings().getExtraChest());
                    int i32 = i31 + 1;
                    preparedStatementPrepareStatement.setString(i31, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.CDW4Fj1iwdIXEOqWjiJSR);
                    int i33 = i32 + 1;
                    preparedStatementPrepareStatement.setInt(i32, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isJoinLeave()));
                    int i34 = i33 + 1;
                    preparedStatementPrepareStatement.setInt(i33, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllySharedHome()));
                    int i35 = i34 + 1;
                    preparedStatementPrepareStatement.setString(i34, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.b4i2FbOkaKeg91LiAe6l);
                    int i36 = i35 + 1;
                    preparedStatementPrepareStatement.setInt(i35, clanData.getMaxlevel());
                    int i37 = i36 + 1;
                    preparedStatementPrepareStatement.setInt(i36, clanData.getExtraSlots());
                    int i38 = i37 + 1;
                    preparedStatementPrepareStatement.setInt(i37, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isOpened()));
                    int i39 = i38 + 1;
                    preparedStatementPrepareStatement.setInt(i38, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isPublicHomes()));
                    int i40 = i39 + 1;
                    preparedStatementPrepareStatement.setString(i39, clanData.getPatent());
                    int i41 = i40 + 1;
                    preparedStatementPrepareStatement.setString(i40, clanData.getWebhook());
                    int i42 = i41 + 1;
                    preparedStatementPrepareStatement.setInt(i41, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isReceveMailAllies()));
                    int i43 = i42 + 1;
                    preparedStatementPrepareStatement.setInt(i42, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isReceiveMailAll()));
                    int i44 = i43 + 1;
                    preparedStatementPrepareStatement.setString(i43, (String) clanData.getSettings().getJsonMeta().map((v0) -> {
                        return v0.toString();
                    }).orElse(""));
                    int i45 = i44 + 1;
                    preparedStatementPrepareStatement.setInt(i44, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllyPvp()));
                    int i46 = i45 + 1;
                    preparedStatementPrepareStatement.setInt(i45, clanData.getStats().getGladWin());
                    int i47 = i46 + 1;
                    preparedStatementPrepareStatement.setInt(i46, clanData.getStats().getGladLose());
                    int i48 = i47 + 1;
                    preparedStatementPrepareStatement.setInt(i47, clanData.getStats().getLeagueWin());
                    int i49 = i48 + 1;
                    preparedStatementPrepareStatement.setInt(i48, clanData.getStats().getLeagueLose());
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANUPDATEUUID.toString(), clanData.getId(), Optional.empty()));
                        });
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionIZTqZaRK5UGoe0Z != null) {
                    try {
                        connectionIZTqZaRK5UGoe0Z.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void ZwrsrwOCXRUscW6Q(ClanData clanData) {
        String string = Clans.getClanCore().getFiles().VkPRYe34Awk6AdSxoUC().getString(ZzYRYpwCyd8m8Bje4nOKgN());
        Ijap9SQKkijXSxP5 ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY = Ijap9SQKkijXSxP5.v8qP8fE86HMhvNuYPFjqY(clanData);
        String str = "INSERT INTO `" + string + "` (id, tag, tag_raw, `desc`, leader, verified, home, creation_date, members, mods, banned, rival, ally,kills, deaths, souls, kdr, ff, bank, level, quest_points, quest_finished, member_joined, member_left,war_win, war_lose, tag_changed, member_kicked, war_invite, ally_shared_chat, extra_chest,locked_pages_chest, join_leave, ally_shared_home, banner, maxlevel, extra_slots, opened,public_homes, patent, webhook, receive_mail_allies, receive_mail_all, json_meta, allypvp,glad_win, glad_lose, league_win, league_lose) VALUES (" + String.join(mI80gbbZW3MrEu7R(), Collections.nCopies(49, XjxCU7F60WNQOrCk5xD())) + ") ON DUPLICATE KEY UPDATE tag=VALUES(tag), tag_raw=VALUES(tag_raw), `desc`=VALUES(`desc`), leader=VALUES(leader),verified=VALUES(verified), home=VALUES(home), creation_date=VALUES(creation_date),members=VALUES(members), mods=VALUES(mods), banned=VALUES(banned),rival=VALUES(rival), ally=VALUES(ally),kills=VALUES(kills), deaths=VALUES(deaths), souls=VALUES(souls),kdr=VALUES(kdr), ff=VALUES(ff), bank=VALUES(bank), level=VALUES(level),quest_points=VALUES(quest_points), quest_finished=VALUES(quest_finished),member_joined=VALUES(member_joined), member_left=VALUES(member_left),war_win=VALUES(war_win), war_lose=VALUES(war_lose),tag_changed=VALUES(tag_changed), member_kicked=VALUES(member_kicked),war_invite=VALUES(war_invite), ally_shared_chat=VALUES(ally_shared_chat),extra_chest=VALUES(extra_chest), locked_pages_chest=VALUES(locked_pages_chest),join_leave=VALUES(join_leave), ally_shared_home=VALUES(ally_shared_home),banner=VALUES(banner), maxlevel=VALUES(maxlevel), extra_slots=VALUES(extra_slots),opened=VALUES(opened), public_homes=VALUES(public_homes),patent=VALUES(patent), webhook=VALUES(webhook),receive_mail_allies=VALUES(receive_mail_allies),receive_mail_all=VALUES(receive_mail_all),json_meta=VALUES(json_meta), allypvp=VALUES(allypvp),glad_win=VALUES(glad_win), glad_lose=VALUES(glad_lose),league_win=VALUES(league_win), league_lose=VALUES(league_lose)";
        try {
            Connection connectionIZTqZaRK5UGoe0Z = Clans.getClanCore().getDatabaseManager().jBUuLP0sWwaPyPOmogdX7l().iZTqZaRK5UGoe0Z();
            try {
                PreparedStatement preparedStatementPrepareStatement = connectionIZTqZaRK5UGoe0Z.prepareStatement(str);
                try {
                    int i = 1 + 1;
                    preparedStatementPrepareStatement.setString(1, clanData.getId().toString());
                    int i2 = i + 1;
                    preparedStatementPrepareStatement.setString(i, clanData.getTag());
                    int i3 = i2 + 1;
                    preparedStatementPrepareStatement.setString(i2, clanData.getTagNoColor());
                    int i4 = i3 + 1;
                    preparedStatementPrepareStatement.setString(i3, clanData.getDesc());
                    int i5 = i4 + 1;
                    preparedStatementPrepareStatement.setString(i4, clanData.getLeader().toString());
                    int i6 = i5 + 1;
                    preparedStatementPrepareStatement.setBoolean(i5, clanData.isVerified());
                    int i7 = i6 + 1;
                    preparedStatementPrepareStatement.setString(i6, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.zJnaNCVQSgEShq);
                    int i8 = i7 + 1;
                    preparedStatementPrepareStatement.setLong(i7, clanData.getCreationDate());
                    int i9 = i8 + 1;
                    preparedStatementPrepareStatement.setString(i8, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.v8qP8fE86HMhvNuYPFjqY);
                    int i10 = i9 + 1;
                    preparedStatementPrepareStatement.setString(i9, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.jBUuLP0sWwaPyPOmogdX7l);
                    int i11 = i10 + 1;
                    preparedStatementPrepareStatement.setString(i10, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.ZwrsrwOCXRUscW6Q);
                    int i12 = i11 + 1;
                    preparedStatementPrepareStatement.setString(i11, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.iZTqZaRK5UGoe0Z);
                    int i13 = i12 + 1;
                    preparedStatementPrepareStatement.setString(i12, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.xtOheRiObl4QeAl);
                    int i14 = i13 + 1;
                    preparedStatementPrepareStatement.setInt(i13, clanData.getStats().getKills());
                    int i15 = i14 + 1;
                    preparedStatementPrepareStatement.setInt(i14, clanData.getStats().getDeaths());
                    int i16 = i15 + 1;
                    preparedStatementPrepareStatement.setInt(i15, clanData.getStats().getSouls());
                    int i17 = i16 + 1;
                    preparedStatementPrepareStatement.setDouble(i16, clanData.getKdr());
                    int i18 = i17 + 1;
                    preparedStatementPrepareStatement.setBoolean(i17, clanData.isFf());
                    int i19 = i18 + 1;
                    preparedStatementPrepareStatement.setString(i18, clanData.getBank().toString());
                    int i20 = i19 + 1;
                    preparedStatementPrepareStatement.setInt(i19, clanData.getLevel());
                    int i21 = i20 + 1;
                    preparedStatementPrepareStatement.setInt(i20, clanData.getQuest().getPoints());
                    int i22 = i21 + 1;
                    preparedStatementPrepareStatement.setInt(i21, clanData.getQuest().getFinished());
                    int i23 = i22 + 1;
                    preparedStatementPrepareStatement.setInt(i22, clanData.getStats().getMemberJoined());
                    int i24 = i23 + 1;
                    preparedStatementPrepareStatement.setInt(i23, clanData.getStats().getMemberLeft());
                    int i25 = i24 + 1;
                    preparedStatementPrepareStatement.setInt(i24, clanData.getStats().getWarWin());
                    int i26 = i25 + 1;
                    preparedStatementPrepareStatement.setInt(i25, clanData.getStats().getWarLose());
                    int i27 = i26 + 1;
                    preparedStatementPrepareStatement.setInt(i26, clanData.getStats().getTagChanged());
                    int i28 = i27 + 1;
                    preparedStatementPrepareStatement.setInt(i27, clanData.getStats().getMemberKicked());
                    int i29 = i28 + 1;
                    preparedStatementPrepareStatement.setInt(i28, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isWarInvite()));
                    int i30 = i29 + 1;
                    preparedStatementPrepareStatement.setInt(i29, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllySharedChat()));
                    int i31 = i30 + 1;
                    preparedStatementPrepareStatement.setInt(i30, clanData.getChestSettings().getExtraChest());
                    int i32 = i31 + 1;
                    preparedStatementPrepareStatement.setString(i31, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.CDW4Fj1iwdIXEOqWjiJSR);
                    int i33 = i32 + 1;
                    preparedStatementPrepareStatement.setInt(i32, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isJoinLeave()));
                    int i34 = i33 + 1;
                    preparedStatementPrepareStatement.setInt(i33, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllySharedHome()));
                    int i35 = i34 + 1;
                    preparedStatementPrepareStatement.setString(i34, ijap9SQKkijXSxP5V8qP8fE86HMhvNuYPFjqY.b4i2FbOkaKeg91LiAe6l);
                    int i36 = i35 + 1;
                    preparedStatementPrepareStatement.setInt(i35, clanData.getMaxlevel());
                    int i37 = i36 + 1;
                    preparedStatementPrepareStatement.setInt(i36, clanData.getExtraSlots());
                    int i38 = i37 + 1;
                    preparedStatementPrepareStatement.setInt(i37, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isOpened()));
                    int i39 = i38 + 1;
                    preparedStatementPrepareStatement.setInt(i38, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isPublicHomes()));
                    int i40 = i39 + 1;
                    preparedStatementPrepareStatement.setString(i39, clanData.getPatent());
                    int i41 = i40 + 1;
                    preparedStatementPrepareStatement.setString(i40, clanData.getWebhook());
                    int i42 = i41 + 1;
                    preparedStatementPrepareStatement.setInt(i41, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isReceveMailAllies()));
                    int i43 = i42 + 1;
                    preparedStatementPrepareStatement.setInt(i42, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isReceiveMailAll()));
                    int i44 = i43 + 1;
                    preparedStatementPrepareStatement.setString(i43, (String) clanData.getSettings().getJsonMeta().map((v0) -> {
                        return v0.toString();
                    }).orElse(""));
                    int i45 = i44 + 1;
                    preparedStatementPrepareStatement.setInt(i44, v8qP8fE86HMhvNuYPFjqY(clanData.getSettings().isAllyPvp()));
                    int i46 = i45 + 1;
                    preparedStatementPrepareStatement.setInt(i45, clanData.getStats().getGladWin());
                    int i47 = i46 + 1;
                    preparedStatementPrepareStatement.setInt(i46, clanData.getStats().getGladLose());
                    int i48 = i47 + 1;
                    preparedStatementPrepareStatement.setInt(i47, clanData.getStats().getLeagueWin());
                    int i49 = i48 + 1;
                    preparedStatementPrepareStatement.setInt(i48, clanData.getStats().getLeagueLose());
                    int iExecuteUpdate = preparedStatementPrepareStatement.executeUpdate();
                    if (preparedStatementPrepareStatement != null) {
                        preparedStatementPrepareStatement.close();
                    }
                    if (connectionIZTqZaRK5UGoe0Z != null) {
                        connectionIZTqZaRK5UGoe0Z.close();
                    }
                    if (iExecuteUpdate > 0) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask(() -> {
                            Bukkit.getPluginManager().callEvent(new ClanMultiserverPingEvent(ClanEnum.RedisType.CLANUPDATEUUID.toString(), clanData.getId(), Optional.empty()));
                        });
                    }
                } catch (Throwable th) {
                    if (preparedStatementPrepareStatement != null) {
                        try {
                            preparedStatementPrepareStatement.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                if (connectionIZTqZaRK5UGoe0Z != null) {
                    try {
                        connectionIZTqZaRK5UGoe0Z.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String> v8qP8fE86HMhvNuYPFjqY(String str, String str2) {
        return (str == null || str.isEmpty()) ? Collections.emptyList() : Arrays.asList(str.split(str2));
    }

    private static final int v8qP8fE86HMhvNuYPFjqY(boolean z) {
        return z ? 1 : 0;
    }

    private static String YNGheSTVssMD92f5aXa() {
        return ";";
    }

    private static String XTHMSpbq5DY7I4uZr1() {
        return "\\|";
    }

    private static String Z6OLLyjBqNni46H7SwbKX() {
        return "\\|";
    }

    private static String tT7urXRriXn5FZ() {
        return "\\|";
    }

    private static String G2Ip9uMe0FyVtvidD() {
        return "\\|";
    }

    private static String LkZMjkcMjoLCVA() {
        return "\\|";
    }

    private static String xZ1ZEG4osmu9Y9fLngXreJ() {
        return "clans";
    }

    private static String wuaKTCHkPijAeacAMWDPo() {
        return "Storage.databases.clan_table";
    }

    private static String N99qYHzZDS2ErPv6() {
        return ",";
    }

    private static String nQWZDwKxcCSlBy1BMd() {
        return "?";
    }

    private static String ZzYRYpwCyd8m8Bje4nOKgN() {
        return "Storage.databases.clan_table";
    }

    private static String mI80gbbZW3MrEu7R() {
        return ",";
    }

    private static String XjxCU7F60WNQOrCk5xD() {
        return "?";
    }
}
