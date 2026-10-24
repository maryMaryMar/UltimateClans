package me.module.rivalally.manager.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import me.module.rivalally.Rivalally;
import me.module.rivalally.manager.EnumFiles.Lang;
import me.module.rivalally.manager.c;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/a/a.class */
public class a {
    private static byte[] __aes_key_gAjFS5XV = {(byte) 217, (byte) 33, (byte) 86, (byte) 145, (byte) 163, (byte) 120, (byte) 158, (byte) 201, (byte) 118, (byte) 47, (byte) 213, (byte) 186, (byte) 205, (byte) 35, (byte) 85, (byte) 135, (byte) 248, (byte) 91, (byte) 248, (byte) 211, (byte) 128, (byte) 4, (byte) 212, (byte) 205, (byte) 190, (byte) 216, (byte) 2, (byte) 11, (byte) 198, (byte) 45, (byte) 60, (byte) 102};
    private static byte[] __aes_iv_iX5DIvSW = {(byte) 135, (byte) 23, (byte) 60, (byte) 179, (byte) 124, (byte) 243, (byte) 198, (byte) 178, (byte) 175, (byte) 97, (byte) 101, (byte) 187, (byte) 97, (byte) 157, (byte) 215, (byte) 211};
    private static String __s_cache_AQwgNrEs_0;
    private static String __s_cache_esPVIQMf_1;
    private static String __s_cache_bRgqu0L3_2;
    private static String __s_cache_ZVdAD51B_3;
    private static String __s_cache_PehkTu7d_4;
    private static String __s_cache_RyS9OCKD_5;
    private static String __s_cache_H3MCWbZK_6;
    private static String __s_cache_cqKABXUC_7;
    private static String __s_cache_oQV0aR6p_8;
    private static String __s_cache_MpFkOKn6_9;
    private static String __s_cache_Mw49mROJ_10;
    private static String __s_cache_mANJw16r_11;
    private static String __s_cache_XlAuqxh7_12;
    private static String __s_cache_M1423yAi_13;
    private static String __s_cache_2F666oc4_14;
    private static String __s_cache_sH9LObA6_15;
    private static String __s_cache_l8jgayD6_16;
    private static String __s_cache_8mmIksOe_17;
    private static String __s_cache_BrdYHe2w_18;
    private static String __s_cache_cUkAR4xh_19;
    private static String __s_cache_P6S68F8c_20;
    private static String __s_cache_8MeooK1j_21;
    private static String __s_cache_yp0Q6Ojp_22;
    private static String __s_cache_zuNuezq6_23;
    private static String __s_cache_A8sM2jZY_24;
    private static String __s_cache_Y6QWAjw2_25;
    private static String __s_cache_df3MoBJN_26;
    private static String __s_cache_ykkj5wvX_27;
    private static String __s_cache_PxnOP64K_28;
    private static String __s_cache_zBnLdBBI_29;
    private static String __s_cache_5mKPVJxX_30;
    private static String __s_cache_bHJzZCM9_31;
    private static String __s_cache_X0IvB0I5_32;
    private static String __s_cache_AGFztlTg_33;
    private static String __s_cache_nrLs7hjz_34;
    private static String __s_cache_l5VMa1Gf_35;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, String str) {
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA3;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA4;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderA5;
        AddonGuiItemsData addonGuiItemsData5;
        ItemBuilder itemBuilderA6;
        Optional<ClanData> playerClan = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Rivalally.getModuleCore().h().a(player).containsKey("ally")) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Rivalally.getModuleCore().h().a(player).get("ally");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Rivalally.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Rivalally.a().getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(Rivalally.a().getColorAPI().addMiniColor(Rivalally.a().getHooksAPI().parsePapi(player, Rivalally.a().getClanAPI().parseText(playerClan.get().getLeader(), title)), true))).rows(addonGuiData.getRows()).pageSize(addonGuiData.getPageSize()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA6 = Rivalally.getModuleCore().h().a((addonGuiItemsData5 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData5, itemBuilderA6.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Rivalally.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "ally", player);
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderA5 = Rivalally.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("previous")), player.getUniqueId(), Arrays.asList("{Unable to acquire a license key automatically, please contact the creator directly.};" + player.getUniqueId().toString()))) != null) {
            Rivalally.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData4, itemBuilderA5.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && (itemBuilderA4 = Rivalally.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData3, itemBuilderA4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA3 = Rivalally.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData2, itemBuilderA3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                Rivalally.a().getGuiAPI().openClanHome(player);
            }));
        }
        if (Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name")) && addonGuiData.getItems().containsKey("add") && (itemBuilderA2 = Rivalally.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("add")), player.getUniqueId(), (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData, itemBuilderA2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                a(player, 1, (String) null);
            }));
        }
        ArrayList arrayList = new ArrayList();
        for (UUID uuid : playerClan.get().getRivalAlly().getAlly()) {
            if (Rivalally.a().getClanAPI().clanExists(uuid)) {
                arrayList.add(uuid);
            }
        }
        Iterator it = arrayList.iterator();
        if (addonGuiData.getItems().containsKey("current")) {
            AddonGuiItemsData addonGuiItemsData6 = addonGuiData.getItems().get("current");
            while (it.hasNext()) {
                Optional<ClanData> clan = Rivalally.a().getClanAPI().getClan((UUID) it.next());
                if (clan.isPresent() && (itemBuilderA = Rivalally.getModuleCore().h().a(addonGuiItemsData6, clan.get().getLeader(), (List<String>) null)) != null) {
                    paginatedGuiCreate.addItem(itemBuilderA.asGuiItem(inventoryClickEvent6 -> {
                        try {
                            if (addonGuiItemsData6.getClickSound() != null && !addonGuiItemsData6.getClickSound().isEmpty()) {
                                Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData6.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent6.setCancelled(true);
                        if (inventoryClickEvent6.getClick().equals(ClickType.LEFT) || inventoryClickEvent6.getClick().equals(ClickType.SHIFT_LEFT)) {
                            return;
                        }
                        if (inventoryClickEvent6.getClick().equals(ClickType.RIGHT) || inventoryClickEvent6.getClick().equals(ClickType.SHIFT_RIGHT)) {
                            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name"))) {
                                a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI));
                            } else if (Rivalally.getModuleCore().e().allyRemove(((ClanData) playerClan.get()).getId(), ((ClanData) clan.get()).getId())) {
                                a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_REMOVE_SUCCESS_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_REMOVE_SUCCESS));
                            } else {
                                a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_REMOVE_ERROR_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_REMOVE_ERROR));
                            }
                        }
                    }));
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent7 -> {
            inventoryClickEvent7.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        Rivalally.getModuleCore().h().c().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Rivalally.getModuleCore().h().c().remove(player);
        });
        if (str == null || !Rivalally.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Rivalally.getModuleCore().d().runTaskLater(() -> {
            a(player, (String) null);
        }, 25L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, int i, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderA4;
        Optional<ClanData> playerClan = Rivalally.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Rivalally.getModuleCore().h().a(player).containsKey("clan_ally_search")) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Rivalally.getModuleCore().h().a(player).get("clan_ally_search");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Rivalally.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        if (i < 1) {
            i = 1;
        }
        int i2 = i;
        ArrayList arrayList = new ArrayList(Rivalally.a().getClanAPI().getAllClansData());
        int iAllyRivalCount = Rivalally.getModuleCore().e().allyRivalCount(playerClan.get(), ClanEnum.RivalAllyCount.ALLY);
        List list = (List) arrayList.stream().filter(clanData -> {
            return (clanData.getId().equals(((ClanData) playerClan.get()).getId()) || ((ClanData) playerClan.get()).getRivalAlly().getAlly().contains(clanData.getId()) || ((ClanData) playerClan.get()).getRivalAlly().getRival().contains(clanData.getId()) || clanData.getRivalAlly().getAlly().size() >= iAllyRivalCount) ? false : true;
        }).collect(Collectors.toList());
        new ArrayList();
        c cVar = new c(new ArrayList(list), addonGuiData.getPageSize());
        cVar.a(i2);
        String strReplace = addonGuiData.getTitle().replace("{page}", String.valueOf(i2)).replace("{pages}", String.valueOf(cVar.f()));
        if (str != null && Rivalally.a().getGuiAPI().useTitleAlerts()) {
            strReplace = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Rivalally.a().getColorAPI().addMiniColor(Rivalally.a().getHooksAPI().parsePapi(player, Rivalally.a().getClanAPI().parseText(player.getUniqueId(), strReplace)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA4 = Rivalally.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(guiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Rivalally.a().getGuiAPI().insertItens(guiCreate, "General", "clan_ally_search", player);
        if (addonGuiData.getItems().containsKey("previous") && cVar.c() && (itemBuilderA3 = Rivalally.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                a(player, cVar.e(), (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && cVar.b() && (itemBuilderA2 = Rivalally.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                a(player, cVar.d(), (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Rivalally.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Rivalally.getModuleCore().h().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                a(player, (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("current")) {
            AddonGuiItemsData addonGuiItemsData5 = addonGuiData.getItems().get("current");
            Iterator<Object> it = cVar.a().iterator();
            while (it.hasNext()) {
                ClanData clanData2 = (ClanData) it.next();
                ItemBuilder itemBuilderA5 = Rivalally.getModuleCore().h().a(addonGuiItemsData5, clanData2.getLeader(), (List<String>) null);
                if (itemBuilderA5 != null) {
                    guiCreate.addItem(itemBuilderA5.asGuiItem(inventoryClickEvent5 -> {
                        try {
                            if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                                Rivalally.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent5.setCancelled(true);
                        if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), Rivalally.getModuleCore().c().i().getString("Config.Permissions.ally-manager.name"))) {
                            a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI));
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                        }
                        if (Rivalally.getModuleCore().e().isClanRival(((ClanData) playerClan.get()).getId(), clanData2.getId())) {
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_IS_RIVAL_GUI));
                            return;
                        }
                        if (Rivalally.getModuleCore().e().isClanAlly(((ClanData) playerClan.get()).getId(), clanData2.getId())) {
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALREADY_ALLY_GUI));
                            return;
                        }
                        if (((ClanData) playerClan.get()).getRivalAlly().getAlly().size() >= iAllyRivalCount) {
                            a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_IN_LIMIT_GUI));
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_IN_LIMIT));
                            return;
                        }
                        if (!Rivalally.getModuleCore().c().i().getBoolean("Clan.ally_invite.need_confirmation")) {
                            if (Rivalally.getModuleCore().e().allyAdd(((ClanData) playerClan.get()).getId(), clanData2.getId())) {
                                a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_ADD_SUCCESS_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_ADD_SUCCESS));
                                return;
                            } else {
                                a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_ADD_ERROR_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_ADD_ERROR));
                                return;
                            }
                        }
                        switch (Rivalally.getModuleCore().e().allySend(((ClanData) playerClan.get()).getId(), clanData2.getId(), false)) {
                            case ALREADY_INVITED:
                                a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_ALREADY_INVITED_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_ALREADY_INVITED));
                                break;
                            case ERROR:
                                a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_ERROR_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_ERROR));
                                break;
                            case MODERATION_OFFLINE:
                                a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_MODERATION_OFFLINE_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_MODERATION_OFFLINE));
                                break;
                            case SENDED:
                                a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_SENDED_GUI));
                                MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALLY_INVITE_SENDED));
                                break;
                        }
                    }));
                }
            }
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Rivalally.getModuleCore().h().c().remove(player);
        });
        guiCreate.open(player);
        Rivalally.getModuleCore().h().c().add(player);
        if (str == null || !Rivalally.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Rivalally.getModuleCore().d().runTaskLater(() -> {
            a(player, i2, (String) null);
        }, 25L);
    }

    private static String __unused_1290() {
        return "ally";
    }

    private static String __unused_1291() {
        return "ally";
    }

    private static String __unused_1292() {
        return "fill";
    }

    private static String __unused_1293() {
        return "fill";
    }

    private static String __unused_1294() {
        return "General";
    }

    private static String __unused_1295() {
        return "ally";
    }

    private static String __unused_1296() {
        return "previous";
    }

    private static String __unused_1297() {
        return "previous";
    }

    private static String __unused_1298() {
        return "next";
    }

    private static String __unused_1299() {
        return "next";
    }

    private static String __unused_1300() {
        return "back";
    }

    private static String __unused_1301() {
        return "back";
    }

    private static String __unused_1302() {
        return "Config.Permissions.ally-manager.name";
    }

    private static String __unused_1303() {
        return "add";
    }

    private static String __unused_1304() {
        return "add";
    }

    private static String __unused_1305() {
        return "current";
    }

    private static String __unused_1306() {
        return "current";
    }

    private static String __unused_1307() {
        return "clan_ally_search";
    }

    private static String __unused_1308() {
        return "clan_ally_search";
    }

    private static String __unused_1309() {
        return "{page}";
    }

    private static String __unused_1310() {
        return "{pages}";
    }

    private static String __unused_1311() {
        return "fill";
    }

    private static String __unused_1312() {
        return "fill";
    }

    private static String __unused_1313() {
        return "General";
    }

    private static String __unused_1314() {
        return "clan_ally_search";
    }

    private static String __unused_1315() {
        return "previous";
    }

    private static String __unused_1316() {
        return "previous";
    }

    private static String __unused_1317() {
        return "next";
    }

    private static String __unused_1318() {
        return "next";
    }

    private static String __unused_1319() {
        return "back";
    }

    private static String __unused_1320() {
        return "back";
    }

    private static String __unused_1321() {
        return "current";
    }

    private static String __unused_1322() {
        return "current";
    }

    private static String __unused_1323() {
        return "Config.Permissions.ally-manager.name";
    }

    private static String __unused_1324() {
        return "Clan.ally_invite.need_confirmation";
    }

    private static String __unused_1325() {
        return "Config.Permissions.ally-manager.name";
    }
}
