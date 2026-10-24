package me.module.mail.manager.b;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import me.module.mail.Mail;
import me.module.mail.manager.EnumFiles.Lang;
import me.module.mail.manager.b;
import me.module.mail.manager.h;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.MailData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/b/a.class */
public class a {
    private static byte[] __aes_key_Nz2b9tfn = {(byte) 47, (byte) 102, (byte) 226, (byte) 182, (byte) 127, (byte) 255, (byte) 201, (byte) 235, (byte) 118, (byte) 112, (byte) 159, (byte) 115, (byte) 143, (byte) 108, (byte) 40, (byte) 227, (byte) 163, (byte) 179, (byte) 111, (byte) 82, (byte) 90, (byte) 18, (byte) 156, (byte) 174, (byte) 64, (byte) 216, (byte) 177, (byte) 191, (byte) 219, (byte) 207, (byte) 189, (byte) 91};
    private static byte[] __aes_iv_ljhjURYu = {(byte) 222, (byte) 120, (byte) 183, (byte) 11, (byte) 245, (byte) 96, (byte) 196, (byte) 73, (byte) 77, (byte) 165, (byte) 69, (byte) 88, (byte) 42, (byte) 62, (byte) 20, (byte) 222};
    private static String __s_cache_51rU68Zj_0;
    private static String __s_cache_8Rwt0ksq_1;
    private static String __s_cache_0sXpDKy6_2;
    private static String __s_cache_zTvI8bzt_3;
    private static String __s_cache_flzrnjGd_4;
    private static String __s_cache_InolNBgb_5;
    private static String __s_cache_ZRgflhIM_6;
    private static String __s_cache_fI27NsGk_7;
    private static String __s_cache_xTBo2Xc2_8;
    private static String __s_cache_nO7SegRG_9;
    private static String __s_cache_DziRL5HS_10;
    private static String __s_cache_cT5ovUfM_11;
    private static String __s_cache_d1gn1xfQ_12;
    private static String __s_cache_ULpTqMnh_13;
    private static String __s_cache_7Osd5vWP_14;
    private static String __s_cache_rrctaeUv_15;
    private static String __s_cache_LakjIxHS_16;
    private static String __s_cache_afT0s2hF_17;
    private static String __s_cache_6BuljSE4_18;
    private static String __s_cache_DVBo9UsJ_19;
    private static String __s_cache_QSnMY5qX_20;
    private static String __s_cache_FQzDQhUd_21;
    private static String __s_cache_S1JP36Zc_22;
    private static String __s_cache_fFBuxsBg_23;
    private static String __s_cache_YBW5Vk9i_24;
    private static String __s_cache_MHBOgx4G_25;
    private static String __s_cache_DBcvSKRP_26;
    private static String __s_cache_pW3q2U3e_27;
    private static String __s_cache_1VaKD5z4_28;
    private static String __s_cache_EggdcVwx_29;
    private static String __s_cache_GfNG4Iza_30;
    private static String __s_cache_eUVQjkSm_31;
    private static String __s_cache_iPA8DcUP_32;
    private static String __s_cache_25ueIxXd_33;
    private static String __s_cache_27xdpzxO_34;
    private static String __s_cache_F81iybNj_35;
    private static String __s_cache_lQ4iyCu3_36;
    private static String __s_cache_xgdzMCwH_37;
    private static String __s_cache_vZ0Ca26c_38;
    private static String __s_cache_WiSwcDII_39;
    private static String __s_cache_XIdvDC2h_40;
    private static String __s_cache_z7QlxxW3_41;
    private static String __s_cache_Rh0yzFOl_42;
    private static String __s_cache_ggEuXIbf_43;
    private static String __s_cache_6JTLcDQD_44;
    private static String __s_cache_tULAsDTz_45;
    private static String __s_cache_FV7TG6yY_46;
    private static String __s_cache_3hzGFBrI_47;
    private static String __s_cache_cDbaXHAl_48;
    private static String __s_cache_R3bXi4Kz_49;
    private static String __s_cache_Pk6banvR_50;
    private static String __s_cache_ztcS6Vgc_51;
    private static String __s_cache_7cyiU58r_52;
    private static String __s_cache_G5sdkkSX_53;
    private static String __s_cache_Qt1XeSFp_54;
    private static String __s_cache_y3tAjDQC_55;
    private static String __s_cache_T1rHoTt6_56;
    private static String __s_cache_ubitcO3r_57;
    private static String __s_cache_B5x0yWtw_58;
    private static String __s_cache_4da1Z4qB_59;
    private static String __s_cache_JdSR5hjK_60;
    private static String __s_cache_iOQxsVjY_61;
    private static String __s_cache_PSffq6gx_62;
    private static String __s_cache_o6R9X9CK_63;
    private static String __s_cache_RKnEV9Yk_64;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, ClanEnum.MailTime mailTime, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderMountItem;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderMountItem2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderMountItem3;
        Optional<ClanData> playerClan = Mail.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.edit.name"))) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return;
        }
        if (!Mail.getModuleCore().i().a(player).containsKey("clear_mail_confirm")) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Mail.getModuleCore().i().a(player).get("clear_mail_confirm");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Mail.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Mail.a().isTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Mail.a().getColorAPI().addMiniColor(Mail.a().getHooksAPI().parsePapi(player, Mail.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderMountItem3 = Mail.a().getLibAPI().mountItem((addonGuiItemsData3 = addonGuiData.getItems().get("fill")), null, null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData3, itemBuilderMountItem3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Mail.a().getGuiAPI().insertItens(guiCreate, "General", "clear_mail_confirm", player);
        if (addonGuiData.getItems().containsKey("confirm") && (itemBuilderMountItem2 = Mail.a().getLibAPI().mountItem((addonGuiItemsData2 = addonGuiData.getItems().get("confirm")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData2, itemBuilderMountItem2.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                if (Mail.getModuleCore().e().clearClanMail(((ClanData) playerClan.get()).getId())) {
                    b(player, mailTime, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.MAIL_CLEAR_SUCCESS_GUI));
                } else {
                    b(player, mailTime, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.MAIL_CLEAR_ERROR_GUI));
                }
            }));
        }
        if (addonGuiData.getItems().containsKey("cancel") && (itemBuilderMountItem = Mail.a().getLibAPI().mountItem((addonGuiItemsData = addonGuiData.getItems().get("cancel")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData, itemBuilderMountItem.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                b(player, mailTime, (String) null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent4 -> {
            inventoryClickEvent4.setCancelled(true);
        });
        guiCreate.open(player);
        Mail.getModuleCore().i().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Mail.getModuleCore().i().c().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(Player player, ClanEnum.MailTime mailTime, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderMountItem;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderMountItem2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderMountItem3;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderMountItem4;
        AddonGuiItemsData addonGuiItemsData5;
        ItemBuilder itemBuilderMountItem5;
        AddonGuiItemsData addonGuiItemsData6;
        ItemBuilder itemBuilderMountItem6;
        AddonGuiItemsData addonGuiItemsData7;
        ItemBuilder itemBuilderMountItem7;
        Optional<ClanData> playerClan = Mail.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.read.name"))) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return;
        }
        if (!Mail.getModuleCore().i().a(player).containsKey("clan_mail")) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Mail.getModuleCore().i().a(player).get("clan_mail");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Mail.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Mail.a().isTitleAlerts()) {
            title = str;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(Mail.a().getColorAPI().addMiniColor(Mail.a().getHooksAPI().parsePapi(player, Mail.a().getClanAPI().parseText(player.getUniqueId(), title.replace("{timer}", Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.valueOf("TRANSLACTION_" + mailTime.toString().toUpperCase()))))), true))).rows(addonGuiData.getRows()).pageSize(addonGuiData.getPageSize()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderMountItem7 = Mail.a().getLibAPI().mountItem((addonGuiItemsData7 = addonGuiData.getItems().get("fill")), null, null)) != null) {
            Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData7, itemBuilderMountItem7.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData7.getClickSound() != null && !addonGuiItemsData7.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill2") && (itemBuilderMountItem6 = Mail.a().getLibAPI().mountItem((addonGuiItemsData6 = addonGuiData.getItems().get("fill2")), null, null)) != null) {
            Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData6, itemBuilderMountItem6.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData6.getClickSound() != null && !addonGuiItemsData6.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        Mail.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "clan_mail", player);
        if (addonGuiData.getItems().containsKey("filter_all" + (mailTime.equals(ClanEnum.MailTime.ALL) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData8 = addonGuiData.getItems().get("filter_all" + (mailTime.equals(ClanEnum.MailTime.ALL) ? "_current" : ""));
            ItemBuilder itemBuilderMountItem8 = Mail.a().getLibAPI().mountItem(addonGuiItemsData8, player.getUniqueId(), null);
            if (itemBuilderMountItem8 != null) {
                Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData8, itemBuilderMountItem8.asGuiItem(inventoryClickEvent3 -> {
                    try {
                        if (addonGuiItemsData8.getClickSound() != null && !addonGuiItemsData8.getClickSound().isEmpty()) {
                            Mail.a().getLibAPI().playSound(player, addonGuiItemsData8.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent3.setCancelled(true);
                    b(player, ClanEnum.MailTime.ALL, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("filter_read" + (mailTime.equals(ClanEnum.MailTime.READ) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData9 = addonGuiData.getItems().get("filter_read" + (mailTime.equals(ClanEnum.MailTime.READ) ? "_current" : ""));
            ItemBuilder itemBuilderMountItem9 = Mail.a().getLibAPI().mountItem(addonGuiItemsData9, player.getUniqueId(), null);
            if (itemBuilderMountItem9 != null) {
                Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData9, itemBuilderMountItem9.asGuiItem(inventoryClickEvent4 -> {
                    try {
                        if (addonGuiItemsData9.getClickSound() != null && !addonGuiItemsData9.getClickSound().isEmpty()) {
                            Mail.a().getLibAPI().playSound(player, addonGuiItemsData9.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent4.setCancelled(true);
                    b(player, ClanEnum.MailTime.READ, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("filter_unread" + (mailTime.equals(ClanEnum.MailTime.UNREAD) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData10 = addonGuiData.getItems().get("filter_unread" + (mailTime.equals(ClanEnum.MailTime.UNREAD) ? "_current" : ""));
            ItemBuilder itemBuilderMountItem10 = Mail.a().getLibAPI().mountItem(addonGuiItemsData10, player.getUniqueId(), null);
            if (itemBuilderMountItem10 != null) {
                Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData10, itemBuilderMountItem10.asGuiItem(inventoryClickEvent5 -> {
                    try {
                        if (addonGuiItemsData10.getClickSound() != null && !addonGuiItemsData10.getClickSound().isEmpty()) {
                            Mail.a().getLibAPI().playSound(player, addonGuiItemsData10.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent5.setCancelled(true);
                    b(player, ClanEnum.MailTime.UNREAD, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("new") && Mail.a().getIntegrationAPI().getAnvilAPI().isPresent() && Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.send.name")) && (itemBuilderMountItem5 = Mail.a().getLibAPI().mountItem((addonGuiItemsData5 = addonGuiData.getItems().get("new")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData5, itemBuilderMountItem5.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                boolean z = Mail.getModuleCore().c().j().getBoolean("Config.Mail.enabled_for_all_clans");
                boolean zIsEmpty = ((ClanData) playerClan.get()).getRivalAlly().getAlly().isEmpty();
                if (z || !zIsEmpty) {
                    a(player, 1, (String) null);
                } else if (b.a(player, "new_mail", Optional.of(((ClanData) playerClan.get()).getId()), true, Optional.empty())) {
                }
            }));
        }
        if (addonGuiData.getItems().containsKey("clear") && Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.edit.name")) && (itemBuilderMountItem4 = Mail.a().getLibAPI().mountItem((addonGuiItemsData4 = addonGuiData.getItems().get("clear")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData4, itemBuilderMountItem4.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                a(player, mailTime, (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderMountItem3 = Mail.a().getLibAPI().mountItem((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData3, itemBuilderMountItem3.asGuiItem(inventoryClickEvent8 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent8.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && (itemBuilderMountItem2 = Mail.a().getLibAPI().mountItem((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData2, itemBuilderMountItem2.asGuiItem(inventoryClickEvent9 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent9.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderMountItem = Mail.a().getLibAPI().mountItem((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(paginatedGuiCreate, addonGuiItemsData, itemBuilderMountItem.asGuiItem(inventoryClickEvent10 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent10.setCancelled(true);
                Mail.a().getGuiAPI().openClanHome(player);
            }));
        }
        if (addonGuiData.getItems().containsKey("current")) {
            for (MailData mailData : Mail.getModuleCore().e().getClanMailTimed(playerClan.get().getId(), player.getUniqueId(), mailTime)) {
                if (!mailData.getReadBy().contains(player.getUniqueId())) {
                    Mail.getModuleCore().e().addReadmail(mailData.getId(), player.getUniqueId());
                }
                AddonGuiItemsData addonGuiItemsData11 = addonGuiData.getItems().get("current");
                ItemBuilder itemBuilderMountItem11 = Mail.a().getLibAPI().mountItem(addonGuiItemsData11, player.getUniqueId(), Arrays.asList("{id};{" + mailData.getId().toString() + "}"));
                if (itemBuilderMountItem11 != null) {
                    paginatedGuiCreate.addItem(itemBuilderMountItem11.asGuiItem(inventoryClickEvent11 -> {
                        try {
                            if (addonGuiItemsData11.getClickSound() != null && !addonGuiItemsData11.getClickSound().isEmpty()) {
                                Mail.a().getLibAPI().playSound(player, addonGuiItemsData11.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent11.setCancelled(true);
                    }));
                }
            }
        }
        paginatedGuiCreate.open(player);
        Mail.getModuleCore().i().c().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Mail.getModuleCore().i().c().remove(player);
        });
        if (str == null || !Mail.a().isTitleAlerts()) {
            return;
        }
        Mail.getModuleCore().d().runTaskLater(() -> {
            b(player, mailTime, (String) null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, int i, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderMountItem;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderMountItem2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderMountItem3;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderMountItem4;
        AddonGuiItemsData addonGuiItemsData5;
        ItemBuilder itemBuilderMountItem5;
        AddonGuiItemsData addonGuiItemsData6;
        ItemBuilder itemBuilderMountItem6;
        AddonGuiItemsData addonGuiItemsData7;
        ItemBuilder itemBuilderMountItem7;
        Optional<ClanData> playerClan = Mail.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Mail.a().getModAPI().playerHasPermission(player.getUniqueId(), Mail.getModuleCore().c().j().getString("Config.Permissions.send.name"))) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return;
        }
        if (!Mail.getModuleCore().i().a(player).containsKey("new_mail") || !Mail.a().getIntegrationAPI().getAnvilAPI().isPresent()) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Mail.getModuleCore().i().a(player).get("new_mail");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Mail.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Mail.a().isTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Mail.a().getColorAPI().addMiniColor(Mail.a().getHooksAPI().parsePapi(player, Mail.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderMountItem7 = Mail.a().getLibAPI().mountItem((addonGuiItemsData7 = addonGuiData.getItems().get("fill")), null, null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData7, itemBuilderMountItem7.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData7.getClickSound() != null && !addonGuiItemsData7.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill2") && (itemBuilderMountItem6 = Mail.a().getLibAPI().mountItem((addonGuiItemsData6 = addonGuiData.getItems().get("fill2")), null, null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData6, itemBuilderMountItem6.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData6.getClickSound() != null && !addonGuiItemsData6.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        Mail.a().getGuiAPI().insertItens(guiCreate, "General", "new_mail", player);
        if (addonGuiData.getItems().containsKey("my") && (itemBuilderMountItem5 = Mail.a().getLibAPI().mountItem((addonGuiItemsData5 = addonGuiData.getItems().get("my")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData5, itemBuilderMountItem5.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                b.a(player, "new_mail", Optional.of(((ClanData) playerClan.get()).getId()), true, Optional.empty());
            }));
        }
        boolean z = Mail.getModuleCore().c().j().getBoolean("Config.Mail.enabled_for_all_clans");
        List<UUID> arrayList = new ArrayList();
        if (z) {
            arrayList = Mail.a().getClanAPI().getAllClansUUID();
        } else {
            arrayList.addAll(playerClan.get().getRivalAlly().getAlly());
        }
        List list = (List) arrayList.stream().filter(uuid -> {
            return Mail.a().getClanAPI().clanExists(uuid) && Mail.a().getClanAPI().getClan(uuid).get().getSettings().isReceveMailAllies();
        }).collect(Collectors.toList());
        new ArrayList();
        h hVar = new h(new ArrayList(list), addonGuiData.getPageSize());
        hVar.a(i);
        Iterator<Object> it = hVar.a().iterator();
        while (it.hasNext()) {
            Optional<ClanData> clan = Mail.a().getClanAPI().getClan((UUID) it.next());
            if (clan.isPresent() && addonGuiData.getItems().containsKey("current") && (itemBuilderMountItem4 = Mail.a().getLibAPI().mountItem((addonGuiItemsData4 = addonGuiData.getItems().get("current")), clan.get().getLeader(), null)) != null) {
                guiCreate.addItem(itemBuilderMountItem4.asGuiItem(inventoryClickEvent4 -> {
                    try {
                        if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                            Mail.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent4.setCancelled(true);
                    b.a(player, "new_mail", Optional.of(((ClanData) clan.get()).getId()), true, Optional.empty());
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("previous") && hVar.c() && (itemBuilderMountItem3 = Mail.a().getLibAPI().mountItem((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData3, itemBuilderMountItem3.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                a(player, hVar.e(), (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && hVar.c() && (itemBuilderMountItem2 = Mail.a().getLibAPI().mountItem((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData2, itemBuilderMountItem2.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                a(player, hVar.d(), (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderMountItem = Mail.a().getLibAPI().mountItem((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), null)) != null) {
            Mail.a().getLibAPI().filler(guiCreate, addonGuiItemsData, itemBuilderMountItem.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Mail.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                b(player, ClanEnum.MailTime.ALL, (String) null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        guiCreate.open(player);
        Mail.getModuleCore().i().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Mail.getModuleCore().i().c().remove(player);
        });
    }

    private static String __unused_715() {
        return "Config.Permissions.edit.name";
    }

    private static String __unused_716() {
        return "clear_mail_confirm";
    }

    private static String __unused_717() {
        return "clear_mail_confirm";
    }

    private static String __unused_718() {
        return "fill";
    }

    private static String __unused_719() {
        return "fill";
    }

    private static String __unused_720() {
        return "General";
    }

    private static String __unused_721() {
        return "clear_mail_confirm";
    }

    private static String __unused_722() {
        return "confirm";
    }

    private static String __unused_723() {
        return "confirm";
    }

    private static String __unused_724() {
        return "cancel";
    }

    private static String __unused_725() {
        return "cancel";
    }

    private static String __unused_726() {
        return "Config.Permissions.read.name";
    }

    private static String __unused_727() {
        return "clan_mail";
    }

    private static String __unused_728() {
        return "clan_mail";
    }

    private static String __unused_729() {
        return "{timer}";
    }

    private static String __unused_730() {
        return "fill";
    }

    private static String __unused_731() {
        return "fill";
    }

    private static String __unused_732() {
        return "fill2";
    }

    private static String __unused_733() {
        return "fill2";
    }

    private static String __unused_734() {
        return "General";
    }

    private static String __unused_735() {
        return "clan_mail";
    }

    private static String __unused_736() {
        return "_current";
    }

    private static String __unused_737() {
        return "_current";
    }

    private static String __unused_738() {
        return "_current";
    }

    private static String __unused_739() {
        return "_current";
    }

    private static String __unused_740() {
        return "_current";
    }

    private static String __unused_741() {
        return "_current";
    }

    private static String __unused_742() {
        return "new";
    }

    private static String __unused_743() {
        return "Config.Permissions.send.name";
    }

    private static String __unused_744() {
        return "new";
    }

    private static String __unused_745() {
        return "clear";
    }

    private static String __unused_746() {
        return "Config.Permissions.edit.name";
    }

    private static String __unused_747() {
        return "clear";
    }

    private static String __unused_748() {
        return "previous";
    }

    private static String __unused_749() {
        return "previous";
    }

    private static String __unused_750() {
        return "next";
    }

    private static String __unused_751() {
        return "next";
    }

    private static String __unused_752() {
        return "back";
    }

    private static String __unused_753() {
        return "back";
    }

    private static String __unused_754() {
        return "current";
    }

    private static String __unused_755() {
        return "current";
    }

    private static String __unused_756() {
        return "Config.Permissions.send.name";
    }

    private static String __unused_757() {
        return "new_mail";
    }

    private static String __unused_758() {
        return "new_mail";
    }

    private static String __unused_759() {
        return "fill";
    }

    private static String __unused_760() {
        return "fill";
    }

    private static String __unused_761() {
        return "fill2";
    }

    private static String __unused_762() {
        return "fill2";
    }

    private static String __unused_763() {
        return "General";
    }

    private static String __unused_764() {
        return "new_mail";
    }

    private static String __unused_765() {
        return "my";
    }

    private static String __unused_766() {
        return "my";
    }

    private static String __unused_767() {
        return "Config.Mail.enabled_for_all_clans";
    }

    private static String __unused_768() {
        return "current";
    }

    private static String __unused_769() {
        return "current";
    }

    private static String __unused_770() {
        return "previous";
    }

    private static String __unused_771() {
        return "previous";
    }

    private static String __unused_772() {
        return "next";
    }

    private static String __unused_773() {
        return "next";
    }

    private static String __unused_774() {
        return "back";
    }

    private static String __unused_775() {
        return "back";
    }

    private static String __unused_776() {
        return "new_mail";
    }

    private static String __unused_777() {
        return "new_mail";
    }

    private static String __unused_778() {
        return "Config.Mail.enabled_for_all_clans";
    }

    private static String __unused_779() {
        return "new_mail";
    }
}
