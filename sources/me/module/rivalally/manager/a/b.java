package me.module.rivalally.manager.a;

import java.util.ArrayList;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rivalally.jar:me/module/rivalally/manager/a/b.class */
public class b {
    private static byte[] __aes_key_6qklEINQ = {(byte) 8, (byte) 58, (byte) 33, (byte) 159, (byte) 13, (byte) 231, (byte) 120, (byte) 248, (byte) 198, (byte) 237, (byte) 189, (byte) 127, (byte) 196, (byte) 17, (byte) 93, (byte) 251, (byte) 187, (byte) 175, (byte) 245, (byte) 112, (byte) 172, (byte) 102, (byte) 153, (byte) 126, (byte) 145, (byte) 122, (byte) 17, (byte) 105, (byte) 151, (byte) 119, (byte) 176, (byte) 48};
    private static byte[] __aes_iv_z8KHEso6 = {(byte) 107, (byte) 0, (byte) 166, (byte) 146, (byte) 89, (byte) 208, (byte) 114, (byte) 174, (byte) 2, (byte) 37, (byte) 30, (byte) 206, (byte) 66, (byte) 72, (byte) 126, (byte) 75};
    private static String __s_cache_Ea6Uva9V_0;
    private static String __s_cache_zDCEhH6I_1;
    private static String __s_cache_lnpR82Kh_2;
    private static String __s_cache_mIoOCQYb_3;
    private static String __s_cache_64BcLnI5_4;
    private static String __s_cache_OwI09Kt0_5;
    private static String __s_cache_mJo8UHPX_6;
    private static String __s_cache_HOqB3roQ_7;
    private static String __s_cache_awbLNzBg_8;
    private static String __s_cache_FGufOcF4_9;
    private static String __s_cache_v44zbIed_10;
    private static String __s_cache_i6PXA8zP_11;
    private static String __s_cache_NmIH94gX_12;
    private static String __s_cache_sB0N7YVc_13;
    private static String __s_cache_dotpVjer_14;
    private static String __s_cache_h8IdXnI6_15;
    private static String __s_cache_Pn4Cx5fZ_16;
    private static String __s_cache_Bd3XasYS_17;
    private static String __s_cache_kIfDYhpy_18;
    private static String __s_cache_svzgUa5j_19;
    private static String __s_cache_HKss5AeV_20;
    private static String __s_cache_mhXkcSVS_21;
    private static String __s_cache_qsAfXvKX_22;
    private static String __s_cache_fcRGAEdD_23;
    private static String __s_cache_IxMzIaeC_24;
    private static String __s_cache_sh3McECF_25;
    private static String __s_cache_RXzNN7Xd_26;
    private static String __s_cache_wAdOEmwJ_27;
    private static String __s_cache_Ecn4hwwH_28;
    private static String __s_cache_CcBJYdzH_29;
    private static String __s_cache_hu8yHWBe_30;
    private static String __s_cache_stnlPxem_31;
    private static String __s_cache_NFhrON8z_32;
    private static String __s_cache_0TPFbEhH_33;
    private static String __s_cache_jKjEDZDF_34;
    private static String __s_cache_3b3s3VPZ_35;

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
        if (!Rivalally.getModuleCore().h().a(player).containsKey("rival")) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Rivalally.getModuleCore().h().a(player).get("rival");
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
        Rivalally.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "rival", player);
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderA5 = Rivalally.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
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
        if (Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), "RIVALMANAGER") && addonGuiData.getItems().containsKey("add") && (itemBuilderA2 = Rivalally.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("add")), player.getUniqueId(), (List<String>) null)) != null) {
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
        for (UUID uuid : playerClan.get().getRivalAlly().getRival()) {
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
                            if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), "RIVALMANAGER")) {
                                a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI));
                                return;
                            }
                            if (!Rivalally.getModuleCore().c().i().getBoolean("Clan.rival_remove.need_confirmation")) {
                                if (Rivalally.getModuleCore().e().rivalRemove(((ClanData) playerClan.get()).getId(), ((ClanData) clan.get()).getId())) {
                                    a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_SUCCESS_GUI));
                                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_SUCCESS));
                                    return;
                                } else {
                                    a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_ERROR_GUI));
                                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_ERROR));
                                    return;
                                }
                            }
                            switch (Rivalally.getModuleCore().e().rivalRemoveSend(((ClanData) playerClan.get()).getId(), ((ClanData) clan.get()).getId(), false)) {
                                case ALREADY_SENDED:
                                    a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_ALREADY_INVITED_GUI));
                                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_ALREADY_INVITED));
                                    break;
                                case ERROR:
                                    a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_ERROR_GUI));
                                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_ERROR));
                                    break;
                                case MODERATION_OFFLINE:
                                    a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_MODERATION_OFFLINE_GUI));
                                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_MODERATION_OFFLINE));
                                    break;
                                case SENDED:
                                    a(player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_SENDED_GUI));
                                    MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_REMOVE_SENDED));
                                    break;
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
        if (!Rivalally.getModuleCore().h().a(player).containsKey("clan_rival_search")) {
            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Rivalally.getModuleCore().h().a(player).get("clan_rival_search");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Rivalally.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        if (i < 1) {
            i = 1;
        }
        int iAllyRivalCount = Rivalally.getModuleCore().e().allyRivalCount(playerClan.get(), ClanEnum.RivalAllyCount.RIVAL);
        int i2 = i;
        List list = (List) new ArrayList(Rivalally.a().getClanAPI().getAllClansData()).stream().filter(clanData -> {
            return (clanData.getId().equals(((ClanData) playerClan.get()).getId()) || ((ClanData) playerClan.get()).getRivalAlly().getRival().contains(clanData.getId()) || ((ClanData) playerClan.get()).getRivalAlly().getAlly().contains(clanData.getId()) || clanData.getRivalAlly().getRival().size() >= iAllyRivalCount) ? false : true;
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
        Rivalally.a().getGuiAPI().insertItens(guiCreate, "General", "clan_rival_search", player);
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
                        if (!Rivalally.a().getModAPI().playerHasPermission(player.getUniqueId(), "RIVALMANAGER")) {
                            a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI));
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                            return;
                        }
                        if (Rivalally.getModuleCore().e().isClanRival(((ClanData) playerClan.get()).getId(), clanData2.getId())) {
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_IS_RIVAL_GUI));
                            return;
                        }
                        if (Rivalally.getModuleCore().e().isClanAlly(((ClanData) playerClan.get()).getId(), clanData2.getId())) {
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_ALREADY_ALLY_GUI));
                            return;
                        }
                        if (((ClanData) playerClan.get()).getRivalAlly().getRival().size() >= iAllyRivalCount) {
                            a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_IN_LIMIT_GUI));
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_IN_LIMIT));
                        } else if (Rivalally.getModuleCore().e().rivalAdd(((ClanData) playerClan.get()).getId(), clanData2.getId())) {
                            a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_ADD_SUCCESS_GUI));
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_ADD_SUCCESS));
                        } else {
                            a(player, i2, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_ADD_ERROR_GUI));
                            MessageUtils.sendText((CommandSender) player, Rivalally.getModuleCore().c().a((CommandSender) player).getString(Lang.CLAN_RIVAL_ADD_ERROR));
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

    private static String __unused_1254() {
        return "rival";
    }

    private static String __unused_1255() {
        return "rival";
    }

    private static String __unused_1256() {
        return "fill";
    }

    private static String __unused_1257() {
        return "fill";
    }

    private static String __unused_1258() {
        return "General";
    }

    private static String __unused_1259() {
        return "rival";
    }

    private static String __unused_1260() {
        return "previous";
    }

    private static String __unused_1261() {
        return "previous";
    }

    private static String __unused_1262() {
        return "next";
    }

    private static String __unused_1263() {
        return "next";
    }

    private static String __unused_1264() {
        return "back";
    }

    private static String __unused_1265() {
        return "back";
    }

    private static String __unused_1266() {
        return "RIVALMANAGER";
    }

    private static String __unused_1267() {
        return "add";
    }

    private static String __unused_1268() {
        return "add";
    }

    private static String __unused_1269() {
        return "current";
    }

    private static String __unused_1270() {
        return "current";
    }

    private static String __unused_1271() {
        return "clan_rival_search";
    }

    private static String __unused_1272() {
        return "clan_rival_search";
    }

    private static String __unused_1273() {
        return "{page}";
    }

    private static String __unused_1274() {
        return "{pages}";
    }

    private static String __unused_1275() {
        return "fill";
    }

    private static String __unused_1276() {
        return "fill";
    }

    private static String __unused_1277() {
        return "General";
    }

    private static String __unused_1278() {
        return "clan_rival_search";
    }

    private static String __unused_1279() {
        return "previous";
    }

    private static String __unused_1280() {
        return "previous";
    }

    private static String __unused_1281() {
        return "next";
    }

    private static String __unused_1282() {
        return "next";
    }

    private static String __unused_1283() {
        return "back";
    }

    private static String __unused_1284() {
        return "back";
    }

    private static String __unused_1285() {
        return "current";
    }

    private static String __unused_1286() {
        return "current";
    }

    private static String __unused_1287() {
        return "RIVALMANAGER";
    }

    private static String __unused_1288() {
        return "RIVALMANAGER";
    }

    private static String __unused_1289() {
        return "Clan.rival_remove.need_confirmation";
    }
}
