package me.module.home.manager.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.module.home.Home;
import me.module.home.manager.EnumFiles.Lang;
import me.module.home.manager.b;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.EncodedLocationData;
import me.ulrich.clans.data.HomesData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/a/a.class */
public class a {
    private static byte[] __aes_key_K6STBTqJ = {(byte) 102, (byte) 162, (byte) 76, (byte) 191, (byte) 88, (byte) 66, (byte) 160, (byte) 34, (byte) 28, (byte) 232, (byte) 30, (byte) 228, (byte) 153, (byte) 84, (byte) 85, (byte) 67, (byte) 195, (byte) 230, (byte) 139, (byte) 177, (byte) 186, (byte) 170, (byte) 213, (byte) 112, (byte) 94, (byte) 85, (byte) 236, (byte) 1, (byte) 31, (byte) 27, (byte) 180, (byte) 151};
    private static byte[] __aes_iv_FIq6n5Ja = {(byte) 176, (byte) 73, (byte) 240, (byte) 237, (byte) 86, (byte) 156, (byte) 204, (byte) 1, (byte) 23, (byte) 177, (byte) 23, (byte) 88, (byte) 134, (byte) 205, (byte) 151, (byte) 31};
    private static String __s_cache_9ztwrvRf_0;
    private static String __s_cache_uPDpQIN3_1;
    private static String __s_cache_nzxfpkbB_2;
    private static String __s_cache_c9h7jGLa_3;
    private static String __s_cache_yNOqFPy6_4;
    private static String __s_cache_bljlpsnV_5;
    private static String __s_cache_O6rScBLj_6;
    private static String __s_cache_0dNxkiYq_7;
    private static String __s_cache_frR5p4sR_8;
    private static String __s_cache_d6siiVFt_9;
    private static String __s_cache_tClnKlt1_10;
    private static String __s_cache_tkpG3vwQ_11;
    private static String __s_cache_IYuYyszN_12;
    private static String __s_cache_3TAo9qh5_13;
    private static String __s_cache_q7TiBaSR_14;
    private static String __s_cache_CO9RDa9S_15;
    private static String __s_cache_oW7bj4gT_16;
    private static String __s_cache_m6RFC0l6_17;
    private static String __s_cache_FAc3c7pA_18;
    private static String __s_cache_Z2TBTVq1_19;
    private static String __s_cache_kZYMmipy_20;
    private static String __s_cache_SAet6Zlk_21;
    private static String __s_cache_iMMEghYi_22;
    private static String __s_cache_ac9lq5Hg_23;
    private static String __s_cache_gI0kOObl_24;
    private static String __s_cache_Huuxu9HR_25;
    private static String __s_cache_jFihErcd_26;
    private static String __s_cache_aPPtymKI_27;
    private static String __s_cache_M2YvY0N4_28;
    private static String __s_cache_FKXSknGh_29;
    private static String __s_cache_PX0FtnYv_30;
    private static String __s_cache_dsGk3srd_31;
    private static String __s_cache_B4XJGk5H_32;
    private static String __s_cache_D3jS5qp7_33;
    private static String __s_cache_SyXjFKeO_34;
    private static String __s_cache_xSnbKdYB_35;
    private static String __s_cache_ZdNqElin_36;
    private static String __s_cache_S8zBfnrx_37;
    private static String __s_cache_jpzKBYtz_38;
    private static String __s_cache_61UUf5ar_39;
    private static String __s_cache_RsZeiSVH_40;
    private static String __s_cache_IWHMkxw1_41;
    private static String __s_cache_oeoOwZSs_42;
    private static String __s_cache_Td8zDjYS_43;
    private static String __s_cache_NRRG9XjJ_44;
    private static String __s_cache_VmbxwpOj_45;
    private static String __s_cache_by0LOjG3_46;
    private static String __s_cache_3e66Xd7D_47;
    private static String __s_cache_qi0oXwqt_48;
    private static String __s_cache_ALwttPzc_49;
    private static String __s_cache_nZGltGAv_50;
    private static String __s_cache_1KkuIP6j_51;
    private static String __s_cache_xbB9G9qc_52;
    private static String __s_cache_fmlRKBK6_53;
    private static String __s_cache_lBr9Uv3K_54;
    private static String __s_cache_6cjffkM1_55;
    private static String __s_cache_Y5TacJNG_56;
    private static String __s_cache_rKz1nufM_57;
    private static String __s_cache_teO6cdnH_58;
    private static String __s_cache_iXTszAiq_59;
    private static String __s_cache_poDRALDK_60;
    private static String __s_cache_u7StV9Lb_61;

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Player player, HomesData homesData, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        if (homesData == null) {
            return;
        }
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Home.getModuleCore().h().a(player).containsKey("clan_delhome_confirm")) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Home.getModuleCore().h().a(player).get("clan_delhome_confirm");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Home.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Home.a().getColorAPI().addMiniColor(Home.a().getHooksAPI().parsePapi(player, Home.a().getClanAPI().parseText(player.getUniqueId(), title.replace("%home_name%", homesData.getName()))), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA3 = Home.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Home.getModuleCore().h().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Home.a().getGuiAPI().insertItens(guiCreate, "General", "clan_delhome_confirm", player);
        if (addonGuiData.getItems().containsKey("confirm") && (itemBuilderA2 = Home.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("confirm")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                if (!Home.getModuleCore().e().deleteHome(player.getUniqueId(), homesData.getName())) {
                    a(player, homesData, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_DELETE_ERROR_GUI));
                }
                a(player, ((ClanData) playerClan.get()).getId(), Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_DELETE_SUCCESS_GUI));
            }));
        }
        if (addonGuiData.getItems().containsKey("cancel") && (itemBuilderA = Home.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("cancel")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                a(player, ((ClanData) playerClan.get()).getId(), (String) null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent4 -> {
            inventoryClickEvent4.setCancelled(true);
        });
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Home.getModuleCore().h().c().remove(player);
        });
        guiCreate.open(player);
        Home.getModuleCore().h().c().add(player);
        if (str == null || !Home.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Home.getModuleCore().d().runTaskLater(() -> {
            a(player, homesData, (String) null);
        }, 25L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderA4;
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Home.getModuleCore().h().a(player).containsKey("clan_allyhome")) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Home.getModuleCore().h().a(player).get("clan_allyhome");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Home.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Home.a().getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(Home.a().getColorAPI().addMiniColor(Home.a().getHooksAPI().parsePapi(player, Home.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).pageSize(addonGuiData.getPageSize()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA4 = Home.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Home.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "clan_allyhome", player);
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderA3 = Home.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && (itemBuilderA2 = Home.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Home.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                a(player, ((ClanData) playerClan.get()).getId(), (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("current")) {
            AddonGuiItemsData addonGuiItemsData5 = addonGuiData.getItems().get("current");
            ArrayList arrayList = new ArrayList();
            for (UUID uuid : playerClan.get().getRivalAlly().getAlly()) {
                if (Home.a().getClanAPI().clanExists(uuid)) {
                    Optional<ClanData> clan = Home.a().getClanAPI().getClan(uuid);
                    if (clan.isPresent() && clan.get().getSettings().isAllySharedHome()) {
                        arrayList.add(uuid);
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Optional<ClanData> clan2 = Home.a().getClanAPI().getClan((UUID) it.next());
                if (clan2.isPresent()) {
                    for (HomesData homesData : clan2.get().getHome()) {
                        ItemBuilder itemBuilderA5 = Home.getModuleCore().h().a(addonGuiItemsData5, clan2.get().getLeader(), Arrays.asList("{name};{" + homesData.getName() + "}"));
                        if (itemBuilderA5 != null) {
                            paginatedGuiCreate.addItem(itemBuilderA5.asGuiItem(inventoryClickEvent5 -> {
                                try {
                                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                                        Home.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                                    }
                                } catch (Exception e2) {
                                }
                                inventoryClickEvent5.setCancelled(true);
                                if (inventoryClickEvent5.getClick().equals(ClickType.LEFT)) {
                                    Optional<EncodedLocationData> encodedHomeLocation = Home.getModuleCore().e().getEncodedHomeLocation(((ClanData) clan2.get()).getLeader(), homesData.getName());
                                    if (!encodedHomeLocation.isPresent()) {
                                        a(player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_NOT_EXISTS_GUI));
                                        return;
                                    }
                                    if (Home.a().getHooksAPI().isInCombat(player)) {
                                        MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_TELEPORT_FALSE));
                                        return;
                                    }
                                    if (homesData.getPassword().isPresent()) {
                                        MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_CLAN_HOME_REQUIRES_PASSWD_GUI));
                                        return;
                                    }
                                    if (Home.a().getLibAPI().isFolia()) {
                                        Home.getModuleCore().d().runTaskLater(() -> {
                                            player.closeInventory();
                                        }, 2L);
                                    } else {
                                        paginatedGuiCreate.close(player);
                                    }
                                    Home.a().getClanAPI().teleportDelay(player, encodedHomeLocation, true);
                                }
                            }));
                        }
                    }
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Home.getModuleCore().h().c().remove(player);
        });
        paginatedGuiCreate.open(player);
        Home.getModuleCore().h().c().add(player);
        if (str == null || !Home.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Home.getModuleCore().d().runTaskLater(() -> {
            a(player, (String) null);
        }, 25L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, UUID uuid, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderA4;
        AddonGuiItemsData addonGuiItemsData5;
        ItemBuilder itemBuilderA5;
        AddonGuiItemsData addonGuiItemsData6;
        ItemBuilder itemBuilderA6;
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        AddonGuiData addonGuiData = Home.getModuleCore().h().a(player).get("clan_homes");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Home.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Home.a().getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(Home.a().getColorAPI().addMiniColor(Home.a().getHooksAPI().parsePapi(player, Home.a().getClanAPI().parseText(playerClan.get().getLeader(), title)), true))).rows(addonGuiData.getRows()).pageSize(addonGuiData.getPageSize()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA6 = Home.getModuleCore().h().a((addonGuiItemsData6 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData6, itemBuilderA6.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData6.getClickSound() != null && !addonGuiItemsData6.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Home.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "clan_homes", player);
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderA5 = Home.getModuleCore().h().a((addonGuiItemsData5 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData5, itemBuilderA5.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && (itemBuilderA4 = Home.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA3 = Home.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                Home.a().getGuiAPI().openClanHome(player);
            }));
        }
        if (Home.a().getPlayerAPI().isSameClan(player.getUniqueId(), playerClan.get().getLeader())) {
            if (addonGuiData.getItems().containsKey("ally_homes") && (itemBuilderA2 = Home.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("ally_homes")), player.getUniqueId(), (List<String>) null)) != null) {
                Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent5 -> {
                    try {
                        if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                            Home.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent5.setCancelled(true);
                    a(player, (String) null);
                }));
            }
            if (Home.a().getModAPI().playerHasPermission(player.getUniqueId(), Home.getModuleCore().c().i().getString("Config.Permissions.manager.name")) && addonGuiData.getItems().containsKey("create") && (itemBuilderA = Home.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("create")), player.getUniqueId(), (List<String>) null)) != null) {
                Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent6 -> {
                    try {
                        if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                            Home.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent6.setCancelled(true);
                    int size = ((ClanData) playerClan.get()).getHome() == null ? 0 : ((ClanData) playerClan.get()).getHome().size();
                    int iHomeCount = Home.getModuleCore().e().homeCount((ClanData) playerClan.get());
                    if (size >= iHomeCount) {
                        a(player, uuid, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_LIMIT, Arrays.asList("%limit%;" + iHomeCount)));
                        return;
                    }
                    if (Home.a().getLibAPI().isFolia()) {
                        Home.getModuleCore().d().runTaskLater(() -> {
                            player.closeInventory();
                        }, 2L);
                    } else {
                        paginatedGuiCreate.close(player);
                    }
                    if (b.a()) {
                        b.a(player, "home_create", true, Optional.empty());
                    } else {
                        player.chat("/clan home create");
                    }
                }));
            }
        }
        String str__getString_mC6ojEoJ_41 = "current";
        if (!Home.a().getPlayerAPI().isSameClan(player.getUniqueId(), playerClan.get().getLeader())) {
            str__getString_mC6ojEoJ_41 = "current_visit";
        }
        if (addonGuiData.getItems().containsKey(str__getString_mC6ojEoJ_41)) {
            AddonGuiItemsData addonGuiItemsData7 = addonGuiData.getItems().get(str__getString_mC6ojEoJ_41);
            List<HomesData> home = playerClan.get().getHome();
            if (home != null) {
                for (HomesData homesData : home) {
                    ItemBuilder itemBuilderA7 = Home.getModuleCore().h().a(addonGuiItemsData7, playerClan.get().getLeader(), Arrays.asList("{name};{" + homesData.getName() + "}"));
                    if (itemBuilderA7 != null) {
                        paginatedGuiCreate.addItem(itemBuilderA7.asGuiItem(inventoryClickEvent7 -> {
                            try {
                                if (addonGuiItemsData7.getClickSound() != null && !addonGuiItemsData7.getClickSound().isEmpty()) {
                                    Home.a().getLibAPI().playSound(player, addonGuiItemsData7.getClickSound());
                                }
                            } catch (Exception e2) {
                            }
                            inventoryClickEvent7.setCancelled(true);
                            if (inventoryClickEvent7.getClick().equals(ClickType.RIGHT)) {
                                if (Home.a().getPlayerAPI().isSameClan(player.getUniqueId(), ((ClanData) playerClan.get()).getLeader())) {
                                    if (Home.a().getModAPI().playerHasPermission(player.getUniqueId(), Home.getModuleCore().c().i().getString("Config.Permissions.manager.name"))) {
                                        a(player, homesData, (String) null);
                                        return;
                                    } else {
                                        a(player, uuid, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_MOD_AND_LEADER_GUI));
                                        return;
                                    }
                                }
                                return;
                            }
                            if (inventoryClickEvent7.getClick().equals(ClickType.LEFT) && Home.a().getPlayerAPI().isSameClan(player.getUniqueId(), ((ClanData) playerClan.get()).getLeader())) {
                                if (Home.getModuleCore().c().i().getBoolean("Config.Home.guiclick_teleport_as_command") || (homesData.getPassword().isPresent() && !(Home.a().getPlayerAPI().isLeader(player.getUniqueId(), ((ClanData) playerClan.get()).getId()) && Home.a().getModAPI().playerHasPermission(player.getUniqueId(), Home.getModuleCore().c().i().getString("Config.Permissions.manager.name"))))) {
                                    if (Home.a().getLibAPI().isFolia()) {
                                        Home.getModuleCore().d().runTaskLater(() -> {
                                            player.closeInventory();
                                        }, 2L);
                                    } else {
                                        paginatedGuiCreate.close(player);
                                    }
                                    Home.getModuleCore().d().runTask(player.getLocation(), () -> {
                                        player.chat("/clan home teleport " + homesData.getName());
                                    });
                                    return;
                                }
                                Optional<EncodedLocationData> encodedHomeLocation = Home.getModuleCore().e().getEncodedHomeLocation(player.getUniqueId(), homesData.getName());
                                if (!encodedHomeLocation.isPresent()) {
                                    a(player, uuid, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_NOT_EXISTS_GUI));
                                    return;
                                }
                                if (Home.a().getHooksAPI().isInCombat(player)) {
                                    MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_TELEPORT_FALSE));
                                    return;
                                }
                                if (Home.a().getLibAPI().isFolia()) {
                                    Home.getModuleCore().d().runTaskLater(() -> {
                                        player.closeInventory();
                                    }, 2L);
                                } else {
                                    paginatedGuiCreate.close(player);
                                }
                                Home.a().getClanAPI().teleportDelay(player, encodedHomeLocation, true);
                            }
                        }));
                    }
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Home.getModuleCore().h().c().remove(player);
        });
        paginatedGuiCreate.open(player);
        Home.getModuleCore().h().c().add(player);
        if (str == null || !Home.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Home.getModuleCore().d().runTaskLater(() -> {
            a(player, uuid, (String) null);
        }, 25L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, UUID uuid, int i) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderA4;
        Optional<ClanData> clan = Home.a().getClanAPI().getClan(uuid);
        if (!clan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Home.getModuleCore().h().a(player).containsKey("listhomes")) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Home.getModuleCore().h().a(player).get("listhomes");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Home.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(Home.a().getColorAPI().addMiniColor(Home.a().getHooksAPI().parsePapi(clan.get().getLeader(), Home.a().getClanAPI().parseText(clan.get().getLeader(), addonGuiData.getTitle())), true))).rows(addonGuiData.getRows()).pageSize(addonGuiData.getPageSize()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA4 = Home.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Home.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "listhomes", player);
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderA3 = Home.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), clan.get().getLeader(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && (itemBuilderA2 = Home.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("next")), clan.get().getLeader(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Home.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("back")), clan.get().getLeader(), (List<String>) null)) != null) {
            Home.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Home.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                Home.a().getGuiAPI().openClanStats(player, (ClanData) clan.get(), null);
            }));
        }
        if (addonGuiData.getItems().containsKey("current")) {
            AddonGuiItemsData addonGuiItemsData5 = addonGuiData.getItems().get("current");
            List<HomesData> home = clan.get().getHome();
            if (home != null) {
                for (HomesData homesData : home) {
                    ItemBuilder itemBuilderA5 = Home.getModuleCore().h().a(addonGuiItemsData5, clan.get().getLeader(), Arrays.asList("{name};{" + homesData.getName() + "}", "<num>;{" + homesData.getName() + "}"));
                    if (itemBuilderA5 != null) {
                        paginatedGuiCreate.addItem(itemBuilderA5.asGuiItem(inventoryClickEvent5 -> {
                            try {
                                if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                                    Home.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                                }
                            } catch (Exception e2) {
                            }
                            inventoryClickEvent5.setCancelled(true);
                        }));
                    }
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        Home.getModuleCore().h().c().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Home.getModuleCore().h().c().remove(player);
        });
    }

    private static String __unused_454() {
        return "clan_delhome_confirm";
    }

    private static String __unused_455() {
        return "clan_delhome_confirm";
    }

    private static String __unused_456() {
        return "%home_name%";
    }

    private static String __unused_457() {
        return "fill";
    }

    private static String __unused_458() {
        return "fill";
    }

    private static String __unused_459() {
        return "General";
    }

    private static String __unused_460() {
        return "clan_delhome_confirm";
    }

    private static String __unused_461() {
        return "confirm";
    }

    private static String __unused_462() {
        return "confirm";
    }

    private static String __unused_463() {
        return "cancel";
    }

    private static String __unused_464() {
        return "cancel";
    }

    private static String __unused_465() {
        return "clan_allyhome";
    }

    private static String __unused_466() {
        return "clan_allyhome";
    }

    private static String __unused_467() {
        return "fill";
    }

    private static String __unused_468() {
        return "fill";
    }

    private static String __unused_469() {
        return "General";
    }

    private static String __unused_470() {
        return "clan_allyhome";
    }

    private static String __unused_471() {
        return "previous";
    }

    private static String __unused_472() {
        return "previous";
    }

    private static String __unused_473() {
        return "next";
    }

    private static String __unused_474() {
        return "next";
    }

    private static String __unused_475() {
        return "back";
    }

    private static String __unused_476() {
        return "back";
    }

    private static String __unused_477() {
        return "current";
    }

    private static String __unused_478() {
        return "current";
    }

    private static String __unused_479() {
        return "clan_homes";
    }

    private static String __unused_480() {
        return "fill";
    }

    private static String __unused_481() {
        return "fill";
    }

    private static String __unused_482() {
        return "General";
    }

    private static String __unused_483() {
        return "clan_homes";
    }

    private static String __unused_484() {
        return "previous";
    }

    private static String __unused_485() {
        return "previous";
    }

    private static String __unused_486() {
        return "next";
    }

    private static String __unused_487() {
        return "next";
    }

    private static String __unused_488() {
        return "back";
    }

    private static String __unused_489() {
        return "back";
    }

    private static String __unused_490() {
        return "ally_homes";
    }

    private static String __unused_491() {
        return "ally_homes";
    }

    private static String __unused_492() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_493() {
        return "create";
    }

    private static String __unused_494() {
        return "create";
    }

    private static String __unused_495() {
        return "current";
    }

    private static String __unused_496() {
        return "current_visit";
    }

    private static String __unused_497() {
        return "listhomes";
    }

    private static String __unused_498() {
        return "listhomes";
    }

    private static String __unused_499() {
        return "fill";
    }

    private static String __unused_500() {
        return "fill";
    }

    private static String __unused_501() {
        return "General";
    }

    private static String __unused_502() {
        return "listhomes";
    }

    private static String __unused_503() {
        return "previous";
    }

    private static String __unused_504() {
        return "previous";
    }

    private static String __unused_505() {
        return "next";
    }

    private static String __unused_506() {
        return "next";
    }

    private static String __unused_507() {
        return "back";
    }

    private static String __unused_508() {
        return "back";
    }

    private static String __unused_509() {
        return "current";
    }

    private static String __unused_510() {
        return "current";
    }

    private static String __unused_511() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_512() {
        return "Config.Home.guiclick_teleport_as_command";
    }

    private static String __unused_513() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_514() {
        return "home_create";
    }

    private static String __unused_515() {
        return "/clan home create";
    }
}
