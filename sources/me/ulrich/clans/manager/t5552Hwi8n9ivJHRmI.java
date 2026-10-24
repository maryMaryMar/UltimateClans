package me.ulrich.clans.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.CustomChatPrompt;
import me.ulrich.clans.interfaces.RegionImplement;
import me.ulrich.clans.library.kyori.adventure.bossbar.BossBar;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/t5552Hwi8n9ivJHRmI.class */
public class t5552Hwi8n9ivJHRmI {
    private static volatile String b9p59UU4jZ6GdFB9Y;
    private static volatile String Eid57f9zTbznoW;
    private static volatile String yKLDuJXmIakkjgDLofXWqw;
    private static volatile String IsRbLXEsLMj6W9QDGU;
    private static String NeDgkznWtYn0aR1Phr;
    private static String plYRRSHM0lp3iX;
    private static volatile String Mbc9FPQOvXLIFpZ;
    private static volatile String PCR7B5JqQMVROHw1;
    private static volatile String iMh9ypTgk5FewZJ;
    private static String NMpzyMvPgB0A4sST5b7tud;
    private static volatile String aOHwTi2X1J9AjpXyBLTv;
    private static String XdZiBBViIe2cyMQ7Cedm;
    private static String BbPLWraqAH7sTVhjH4z52A;
    private static String E4NeexkFVRkdqvvNCq;
    private static final byte[] F4HinRVXqEFMdeZmboEJ9 = {(byte) 245, (byte) 190, (byte) 142, (byte) 78, (byte) 87, (byte) 229, (byte) 242, (byte) 255, (byte) 170, (byte) 72, (byte) 4, (byte) 180, (byte) 241, (byte) 237, (byte) 228, (byte) 250};
    private static final byte[] OSIC2Rxuz7eQF9wiuI6 = {(byte) 188, (byte) 208, (byte) 145, (byte) 179, (byte) 199, (byte) 241, (byte) 48, (byte) 136, (byte) 122, (byte) 136, (byte) 250, (byte) 95, (byte) 230, (byte) 196, (byte) 135, (byte) 225};
    private static final byte[] NbaPC4xYp3Xn3S5tefBd = {(byte) 194, (byte) 213, (byte) 182, (byte) 238, (byte) 115, (byte) 194, (byte) 152, (byte) 239, (byte) 65, (byte) 25, (byte) 92, (byte) 144, (byte) 54, (byte) 10, (byte) 53, (byte) 72};
    private static final byte[] HA9kKjKnOxqBZBkzkQdF = {(byte) 141, (byte) 144, (byte) 131, (byte) 27, (byte) 40, (byte) 159, (byte) 195, (byte) 123, (byte) 177, (byte) 125, (byte) 130, (byte) 45, (byte) 8, (byte) 172, (byte) 73, (byte) 253};
    private static final byte[] cCfeaaNtmOqbYZdHiKftG8 = {(byte) 87, (byte) 23, (byte) 166, (byte) 13, (byte) 22, (byte) 71, (byte) 105, (byte) 236, (byte) 68, (byte) 43, (byte) 200, (byte) 123, (byte) 182, (byte) 88, (byte) 169, (byte) 239, (byte) 196, (byte) 18, (byte) 15, (byte) 105, (byte) 88, (byte) 154, (byte) 128, (byte) 253, (byte) 47, (byte) 44, (byte) 198, (byte) 166, (byte) 43, (byte) 72, (byte) 189, (byte) 199, (byte) 69, (byte) 46, (byte) 58, (byte) 168, (byte) 207, (byte) 59, (byte) 7, (byte) 68, (byte) 166, (byte) 247, (byte) 75, (byte) 44, (byte) 65, (byte) 186, (byte) 149, (byte) 237, (byte) 39, (byte) 105, (byte) 76, (byte) 7, (byte) 251, (byte) 114, (byte) 211, (byte) 108, (byte) 11, (byte) 219, (byte) 170, (byte) 177, (byte) 20, (byte) 60, (byte) 109, (byte) 109};
    private static final byte[] lrJBRfi9rVC88TUrG = {(byte) 106, (byte) 91, (byte) 52, (byte) 200, (byte) 35, (byte) 9, (byte) 124, (byte) 88, (byte) 53, (byte) 173, (byte) 70, (byte) 67, (byte) 188, (byte) 89, (byte) 1, (byte) 130};
    private static final byte[] emotuXlZmhPhqAZjeZ1sy = {(byte) 166, (byte) 169, (byte) 173, (byte) 19, (byte) 16, (byte) 85, (byte) 179, (byte) 139, (byte) 255, (byte) 205, (byte) 61, (byte) 106, (byte) 193, (byte) 237, (byte) 66, (byte) 161, (byte) 226, (byte) 251, (byte) 102, (byte) 157, (byte) 19, (byte) 85, (byte) 166, (byte) 102, (byte) 223, (byte) 136, (byte) 147, (byte) 207, (byte) 48, (byte) 119, (byte) 57, (byte) 167};
    private static final byte[] wepTd7HPStHLswoF3q = {(byte) 126, (byte) 187, (byte) 5, (byte) 32, (byte) 160, (byte) 82, (byte) 70, (byte) 29, (byte) 88, (byte) 157, (byte) 248, (byte) 81, (byte) 117, (byte) 226, (byte) 113, (byte) 124};

    public static boolean v8qP8fE86HMhvNuYPFjqY(Player player, ClanEnum.ChatDataType chatDataType, List<String> list, boolean z, boolean z2, int i) {
        String string;
        List<String> stringList;
        if (player == null || Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean(g7RJRMJmxhuWZvg()) || Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player)) {
            return false;
        }
        if (Clans.getClanCore().getAnvilGuiManager().v8qP8fE86HMhvNuYPFjqY() && Clans.getClanCore().getAnvilGuiManager().v8qP8fE86HMhvNuYPFjqY(player, chatDataType, z, Optional.empty())) {
            return true;
        }
        String lowerCase = chatDataType.toString().toLowerCase();
        if (!Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".enabled")) {
            return false;
        }
        int i2 = Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getInt("Chat." + lowerCase + ".time");
        if (i > 0) {
            i2 = i;
        }
        List<String> arrayList = list == null ? new ArrayList<>() : list;
        CustomChatPrompt.Builder duration = new CustomChatPrompt.Builder().setDuration(i2);
        if (Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".message.enabled") && (stringList = Clans.getClanCore().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getStringList(Lang.valueOf("CHAT_" + lowerCase + "_message"))) != null) {
            stringList.forEach(str -> {
                String strJBUuLP0sWwaPyPOmogdX7l = Clans.getClanCore().getCommandManager().jBUuLP0sWwaPyPOmogdX7l(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), new jBWyXxi9EyWxcPiz(Clans.getClanCore()).v8qP8fE86HMhvNuYPFjqY(str, (List<String>) arrayList)));
                if (Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".message.center", false)) {
                    strJBUuLP0sWwaPyPOmogdX7l = new jBWyXxi9EyWxcPiz(Clans.getClanCore()).vVo2VUvxrriklPdRxI(strJBUuLP0sWwaPyPOmogdX7l);
                }
                duration.addChatMessage(strJBUuLP0sWwaPyPOmogdX7l);
            });
        }
        if (Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".actionbar.enabled") && (string = Clans.getClanCore().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CHAT_" + lowerCase + "_actionbar"))) != null && !string.isEmpty()) {
            duration.setActionBar(Clans.getClanCore().getCommandManager().jBUuLP0sWwaPyPOmogdX7l(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), new jBWyXxi9EyWxcPiz(Clans.getClanCore()).v8qP8fE86HMhvNuYPFjqY(string, arrayList))));
        }
        if (Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".title.enabled")) {
            duration.setTitle(Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), new jBWyXxi9EyWxcPiz(Clans.getClanCore()).v8qP8fE86HMhvNuYPFjqY(Clans.getClanCore().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CHAT_" + lowerCase + "_title_line")), arrayList)), Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), new jBWyXxi9EyWxcPiz(Clans.getClanCore()).v8qP8fE86HMhvNuYPFjqY(Clans.getClanCore().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CHAT_" + lowerCase + "_title_subline")), arrayList)));
        }
        if (Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".bossbar.enabled")) {
            BossBar.Color colorValueOf = BossBar.Color.valueOf(Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getString("Chat." + lowerCase + ".bossbar.color", RYgG4cjwTdQChl7jUV()));
            BossBar.Overlay overlayValueOf = BossBar.Overlay.valueOf(Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getString("Chat." + lowerCase + ".bossbar.style", SOTUI4uQHI6F6kLpslD()));
            boolean z3 = Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".bossbar.animated");
            ArrayList arrayList2 = new ArrayList();
            try {
                Iterator it = Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getStringList("Chat." + lowerCase + ".bossbar.flags").iterator();
                while (it.hasNext()) {
                    arrayList2.add(BossBar.Flag.valueOf((String) it.next()));
                }
            } catch (Exception e) {
            }
            duration.setBossBar(Clans.getClanCore().getCommandManager().jBUuLP0sWwaPyPOmogdX7l(new jBWyXxi9EyWxcPiz(Clans.getClanCore()).v8qP8fE86HMhvNuYPFjqY(Clans.getClanCore().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CHAT_" + lowerCase + "_bossbar")), arrayList)), colorValueOf, overlayValueOf, arrayList2, z3);
        }
        if (Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getBoolean("Chat." + lowerCase + ".sound.enabled")) {
            duration.setSound(Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getString("Chat." + lowerCase + ".sound.display"));
        }
        duration.onResponse((player2, str2) -> {
            if (v8qP8fE86HMhvNuYPFjqY(player2)) {
                return;
            }
            v8qP8fE86HMhvNuYPFjqY(player2, chatDataType, str2, z);
        }).onCancel(player3 -> {
            if (player3.isOnline()) {
                MessageUtils.sendText((CommandSender) player3, Clans.getClanCore().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player3.getUniqueId())).getString(Lang.CLAN_ACTIONS_EXPIRED));
            }
        }).build();
        return Clans.getClanCore().getChatManager().v8qP8fE86HMhvNuYPFjqY(player, duration.build());
    }

    private static boolean v8qP8fE86HMhvNuYPFjqY(Player player) {
        if (Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getString(fJpMvTohHeal2mE()).isEmpty() || player.hasPermission(Clans.getClanCore().getFiles().p31abtwfBag2jhMH6K().getString(foGoTdqLC9feAnFlYF()))) {
            return false;
        }
        Optional<RegionImplement> optionalHX3ZfRb1nSpNq57s7x5ui = Clans.getClanCore().getIntegrationManager().HX3ZfRb1nSpNq57s7x5ui();
        if (!optionalHX3ZfRb1nSpNq57s7x5ui.isPresent() || !optionalHX3ZfRb1nSpNq57s7x5ui.get().playerHasRegionList(player, Clans.getClanCore().getFiles().QXoNfOxIPaPrSlQMNR().getStringList(q4vbRTN79NIdJkwKc41Z()))) {
            return false;
        }
        MessageUtils.sendText((CommandSender) player, Clans.getClanCore().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.DISABLED_REGION_COMMAND));
        return true;
    }

    private static void v8qP8fE86HMhvNuYPFjqY(Player player, ClanEnum.ChatDataType chatDataType, String str, boolean z) {
        switch (nfoeLRxl4WZADv.v8qP8fE86HMhvNuYPFjqY[chatDataType.ordinal()]) {
            case 1:
                String strTrim = str.trim();
                if (Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(k4NWToJPNBtP9zw())) {
                    CommandData commandData = Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().get(HgfxSNA8Ww7BZX());
                    if (!Clans.getClanCore().getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player, strTrim)) {
                        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
                        break;
                    } else {
                        MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
                        if (z && Clans.getClanCore().isUseGUI()) {
                            Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                                Clans.getClanCore().getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfileSettings(player, null);
                            });
                            break;
                        }
                    }
                }
                break;
            case 2:
                String strTrim2 = str.trim();
                if (Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(gxilLpqf6XFXXQ6())) {
                    CommandData commandData2 = Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().get(FCpftvPRoqBpHX9());
                    if (!Clans.getClanCore().getClanManager().v8qP8fE86HMhvNuYPFjqY(player, strTrim2)) {
                        MessageUtils.sendCommandJson(player, commandData2, ClanEnum.MsgUsage.error, null);
                        break;
                    } else if (z && Clans.getClanCore().isUseGUI()) {
                        Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                            Clans.getClanCore().getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanActions(player, null);
                        }, 40L);
                        break;
                    }
                }
                break;
            case 3:
                if (Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(LWK3eJCWHUCzBQbv3BCK())) {
                    CommandData commandData3 = Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().get(KKlJVu75F8tnPhV4KhDLiD());
                    if (!Clans.getClanCore().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player, str)) {
                        MessageUtils.sendCommandJson(player, commandData3, ClanEnum.MsgUsage.error, null);
                        break;
                    } else {
                        MessageUtils.sendCommandJson(player, commandData3, ClanEnum.MsgUsage.success, null);
                        if (z && Clans.getClanCore().isUseGUI()) {
                            Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                                Clans.getClanCore().getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanActions(player, null);
                            });
                            break;
                        }
                    }
                }
                break;
            case 4:
                if (Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().containsKey(R4TEa18VeGJE5T())) {
                    CommandData commandData4 = Clans.getClanCore().getCommandManager().ZwrsrwOCXRUscW6Q().get(BIiLrWyEMtiCrmEw());
                    if (!Clans.getClanCore().getClanManager().ZwrsrwOCXRUscW6Q(player, str)) {
                        MessageUtils.sendCommandJson(player, commandData4, ClanEnum.MsgUsage.error, null);
                        break;
                    } else {
                        MessageUtils.sendCommandJson(player, commandData4, ClanEnum.MsgUsage.success, null);
                        if (z && Clans.getClanCore().isUseGUI()) {
                            Clans.getClanCore().getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                                Clans.getClanCore().getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
                            }, 40L);
                            break;
                        }
                    }
                }
                break;
        }
    }

    private static String g7RJRMJmxhuWZvg() {
        return "Chat.config.disable_all_interactions";
    }

    private static String RYgG4cjwTdQChl7jUV() {
        return "RED";
    }

    private static String SOTUI4uQHI6F6kLpslD() {
        return "PROGRESS";
    }

    private static String fJpMvTohHeal2mE() {
        return "Chat.config.regions_interaction_disabled";
    }

    private static String foGoTdqLC9feAnFlYF() {
        return "Config.special_permissions.bypass_command_regions";
    }

    private static String q4vbRTN79NIdJkwKc41Z() {
        return "Chat.config.regions_interaction_disabled";
    }

    private static String k4NWToJPNBtP9zw() {
        return "nickname";
    }

    private static String HgfxSNA8Ww7BZX() {
        return "nickname";
    }

    private static String gxilLpqf6XFXXQ6() {
        return "modtag";
    }

    private static String FCpftvPRoqBpHX9() {
        return "modtag";
    }

    private static String LWK3eJCWHUCzBQbv3BCK() {
        return "desc";
    }

    private static String KKlJVu75F8tnPhV4KhDLiD() {
        return "desc";
    }

    private static String R4TEa18VeGJE5T() {
        return "create";
    }

    private static String BIiLrWyEMtiCrmEw() {
        return "create";
    }
}
