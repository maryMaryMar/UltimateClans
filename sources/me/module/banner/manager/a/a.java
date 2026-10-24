package me.module.banner.manager.a;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.module.banner.Banner;
import me.module.banner.manager.EnumFiles.Lang;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.BannerGroupData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.utils.Strings;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Banner.jar:me/module/banner/manager/a/a.class */
public class a {
    private static byte[] __aes_key_ZMselvPq = {(byte) 72, (byte) 204, (byte) 239, (byte) 161, (byte) 213, (byte) 4, (byte) 96, (byte) 82, (byte) 29, (byte) 99, (byte) 185, (byte) 209, (byte) 251, (byte) 94, (byte) 8, (byte) 104, (byte) 91, (byte) 71, (byte) 113, (byte) 125, (byte) 40, (byte) 234, (byte) 34, (byte) 133, (byte) 88, (byte) 253, (byte) 26, (byte) 37, (byte) 110, (byte) 84, (byte) 187, (byte) 130};
    private static byte[] __aes_iv_9M677zrC = {(byte) 130, (byte) 100, (byte) 210, (byte) 156, (byte) 227, (byte) 119, (byte) 40, (byte) 173, (byte) 199, (byte) 168, (byte) 204, (byte) 63, (byte) 237, (byte) 64, (byte) 102, (byte) 29};
    private static String __s_cache_nAommZ2t_0;
    private static String __s_cache_kRGQrjvi_1;
    private static String __s_cache_OxXcA4HU_2;
    private static String __s_cache_5olfpuUJ_3;
    private static String __s_cache_9WDrknAA_4;
    private static String __s_cache_13Urz7hS_5;
    private static String __s_cache_Q91qNrw3_6;
    private static String __s_cache_aa5YYPSB_7;
    private static String __s_cache_vy8BnWty_8;
    private static String __s_cache_s7xIJkIy_9;
    private static String __s_cache_u6bU8v8m_10;
    private static String __s_cache_jggcVf8X_11;
    private static String __s_cache_NLyHg9Pg_12;
    private static String __s_cache_MawydUHX_13;
    private static String __s_cache_6yQlfSP8_14;
    private static String __s_cache_FHPUDE3O_15;
    private static String __s_cache_XqwGmKyU_16;
    private static String __s_cache_7e7qDulA_17;
    private static String __s_cache_SC2umET3_18;
    private static String __s_cache_EU0iMrMn_19;
    private static String __s_cache_kmVpSgcD_20;
    private static String __s_cache_uSzKQo9q_21;
    private static String __s_cache_FkYSMNb1_22;
    private static String __s_cache_uAZx83BQ_23;
    private static String __s_cache_FfVaT7Wx_24;
    private static String __s_cache_0lyZH7aD_25;
    private static String __s_cache_Q0ufgGUt_26;
    private static String __s_cache_XwywM0Nz_27;
    private static String __s_cache_MYJlEB22_28;
    private static String __s_cache_a2ODG1Yy_29;
    private static String __s_cache_Y6utAGlB_30;
    private static String __s_cache_njUNvBLs_31;
    private static String __s_cache_NER3hnF5_32;
    private static String __s_cache_isejFSUz_33;
    private static String __s_cache_zeWyymTQ_34;
    private static String __s_cache_Gvh7Nvkg_35;
    private static String __s_cache_Gmosma6n_36;
    private static String __s_cache_LZqy440s_37;
    private static String __s_cache_OxIfmKFR_38;
    private static String __s_cache_PMhbP0Iq_39;
    private static String __s_cache_YHNlobEd_40;
    private static String __s_cache_QiEuEn22_41;
    private static String __s_cache_5Vr0pkId_42;
    private static String __s_cache_Faeh0bl0_43;
    private static String __s_cache_lIrtcVxF_44;
    private static String __s_cache_a5FdWBRk_45;
    private static String __s_cache_Zn2OjA0w_46;
    private static String __s_cache_okIzVsYC_47;
    private static String __s_cache_0ZSNsmOr_48;
    private static String __s_cache_2CyVmNtQ_49;
    private static String __s_cache_6FigQrWv_50;
    private static String __s_cache_spSQV862_51;
    private static String __s_cache_aOyx0Bqb_52;
    private static String __s_cache_h3MTQ8EU_53;
    private static String __s_cache_0iaJVhzX_54;
    private static String __s_cache_KTqMdHcT_55;
    private static String __s_cache_FuxnMv3e_56;
    private static String __s_cache_1kQLLKLb_57;
    private static String __s_cache_AJYgZe7b_58;
    private static String __s_cache_V0xuvpM0_59;
    private static String __s_cache_LVOqvpud_60;
    private static String __s_cache_rCbraQ1b_61;
    private static String __s_cache_DS2TdNBh_62;
    private static String __s_cache_6wDLG9oZ_63;
    private static String __s_cache_DY9TzB9q_64;
    private static String __s_cache_IYDYIegs_65;
    private static String __s_cache_jjDNtPf1_66;
    private static String __s_cache_OR65BnTp_67;
    private static String __s_cache_2bzswzHs_68;
    private static String __s_cache_PQpjEt1s_69;
    private static String __s_cache_WC7rziJu_70;
    private static String __s_cache_X3keIAM2_71;

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
        Optional<ClanData> playerClan = Banner.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Banner.getModuleCore().h().a(player).containsKey("banner_upload")) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Banner.getModuleCore().h().a(player).get("banner_upload");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Banner.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Banner.a().getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Banner.a().getColorAPI().addMiniColor(Banner.a().getHooksAPI().parsePapi(player, Banner.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill2") && (itemBuilderA4 = Banner.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA3 = Banner.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        Banner.a().getGuiAPI().insertItens(guiCreate, "General", "banner_upload", player);
        int slot = 22;
        if (addonGuiData.getItems().containsKey("upload_slot")) {
            slot = addonGuiData.getItems().get("upload_slot").getSlot();
            guiCreate.removeItem(slot);
        }
        int i = slot;
        if (addonGuiData.getItems().containsKey("confirm") && (itemBuilderA2 = Banner.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("confirm")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                if (inventoryClickEvent3.getInventory().getItem(i) == null) {
                    a(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_EMPTY_ITEM));
                    return;
                }
                ItemStack item = inventoryClickEvent3.getInventory().getItem(i);
                if (!Banner.getModuleCore().e().canUploadMaterial(((ClanData) playerClan.get()).getId(), item)) {
                    a(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_NOT_ACCEPTABLE_GUI));
                    MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_NOT_ACCEPTABLE));
                    MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_ACCEPTABLE_LIST));
                } else if (!Banner.getModuleCore().e().setBanner(((ClanData) playerClan.get()).getId(), player, item)) {
                    a(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_ERROR_GUI));
                } else {
                    MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_SUCCESS));
                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_SUCCESS_GUI));
                }
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Banner.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                c(player, (String) null);
            }));
        }
        guiCreate.open(player);
        Banner.getModuleCore().h().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            ItemStack item;
            if (inventoryCloseEvent.getInventory().getItem(i) != null && (item = inventoryCloseEvent.getInventory().getItem(i)) != null) {
                player.getInventory().addItem(new ItemStack[]{item});
            }
            Banner.getModuleCore().h().c().remove(player);
        });
        if (str == null || !Banner.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Banner.getModuleCore().d().runTaskLater(() -> {
            a(player, (String) null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(Player player, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        Optional<ClanData> playerClan = Banner.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Banner.getModuleCore().h().a(player).containsKey("banner_delete")) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Banner.getModuleCore().h().a(player).get("banner_delete");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Banner.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Banner.a().getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Banner.a().getColorAPI().addMiniColor(Banner.a().getHooksAPI().parsePapi(player, Banner.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA3 = Banner.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Banner.a().getGuiAPI().insertItens(guiCreate, "General", "banner_delete", player);
        if (addonGuiData.getItems().containsKey("confirm") && (itemBuilderA2 = Banner.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("confirm")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                if (Banner.getModuleCore().e().deleteBanner(((ClanData) playerClan.get()).getId(), player)) {
                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_DELETE_SUCCESS_GUI));
                } else {
                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_DELETE_ERROR_GUI));
                }
            }));
        }
        if (addonGuiData.getItems().containsKey("cancel") && (itemBuilderA = Banner.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("cancel")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                c(player, (String) null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent4 -> {
            inventoryClickEvent4.setCancelled(true);
        });
        guiCreate.open(player);
        Banner.getModuleCore().h().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Banner.getModuleCore().h().c().remove(player);
        });
        if (str == null || !Banner.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Banner.getModuleCore().d().runTaskLater(() -> {
            b(player, (String) null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(Player player, String str) {
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
        AddonGuiItemsData addonGuiItemsData7;
        ItemBuilder itemBuilderA7;
        Optional<ClanData> playerClan = Banner.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Banner.getModuleCore().h().a(player).containsKey("banner_home")) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Banner.getModuleCore().h().a(player).get("banner_home");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Banner.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Banner.a().getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Banner.a().getColorAPI().addMiniColor(Banner.a().getHooksAPI().parsePapi(player, Banner.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill2") && (itemBuilderA7 = Banner.getModuleCore().h().a((addonGuiItemsData7 = addonGuiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData7, itemBuilderA7.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData7.getClickSound() != null && !addonGuiItemsData7.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA6 = Banner.getModuleCore().h().a((addonGuiItemsData6 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData6, itemBuilderA6.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData6.getClickSound() != null && !addonGuiItemsData6.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        Banner.a().getGuiAPI().insertItens(guiCreate, "General", "banner_home", player);
        if (addonGuiData.getItems().containsKey("current") && (itemBuilderA5 = Banner.getModuleCore().h().a((addonGuiItemsData5 = addonGuiData.getItems().get("current")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData5, itemBuilderA5.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
            }));
        }
        if (Banner.a().getModAPI().playerHasPermission(player.getUniqueId(), Banner.getModuleCore().c().h().getString("Config.Permissions.manager.name")) && addonGuiData.getItems().containsKey("upload") && (itemBuilderA4 = Banner.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("upload")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                a(player, (String) null);
            }));
        }
        if (Banner.a().getModAPI().playerHasPermission(player.getUniqueId(), Banner.getModuleCore().c().h().getString("Config.Permissions.manager.name")) && playerClan.get().getBanner() != null && !playerClan.get().getBanner().isEmpty() && addonGuiData.getItems().containsKey("delete") && (itemBuilderA3 = Banner.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("delete")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                if (((ClanData) playerClan.get()).getBanner() == null || ((ClanData) playerClan.get()).getBanner().isEmpty()) {
                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_EMPTY_GUI));
                } else {
                    b(player, (String) null);
                }
            }));
        }
        if (Banner.a().getModAPI().playerHasPermission(player.getUniqueId(), Banner.getModuleCore().c().h().getString("Config.Permissions.manager.name")) && addonGuiData.getItems().containsKey("pre") && (itemBuilderA2 = Banner.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("pre")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                a(player, ClanEnum.BannerFilter.COMMON, (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Banner.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                Banner.a().getGuiAPI().openClanHome(player);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        guiCreate.open(player);
        Banner.getModuleCore().h().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Banner.getModuleCore().h().c().remove(player);
        });
        if (str == null || !Banner.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Banner.getModuleCore().d().runTaskLater(() -> {
            c(player, (String) null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, ClanEnum.BannerFilter bannerFilter, String str) {
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
        Optional<ClanData> playerClan = Banner.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Banner.getModuleCore().h().a(player).containsKey("banner_home_pre")) {
            MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Banner.getModuleCore().h().a(player).get("banner_home_pre");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Banner.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && Banner.a().getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(Banner.a().getColorAPI().addMiniColor(Banner.a().getHooksAPI().parsePapi(player, Banner.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).pageSize(addonGuiData.getPageSize()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA6 = Banner.getModuleCore().h().a((addonGuiItemsData6 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData6, itemBuilderA6.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData6.getClickSound() != null && !addonGuiItemsData6.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill2") && (itemBuilderA5 = Banner.getModuleCore().h().a((addonGuiItemsData5 = addonGuiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData5, itemBuilderA5.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill3") && (itemBuilderA4 = Banner.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("fill3")), (UUID) null, (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
            }));
        }
        Banner.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "banner_home_pre", player);
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderA3 = Banner.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && (itemBuilderA2 = Banner.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Banner.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                Banner.getModuleCore().h().e().c(player, (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("common" + (bannerFilter.equals(ClanEnum.BannerFilter.COMMON) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData7 = addonGuiData.getItems().get("common" + (bannerFilter.equals(ClanEnum.BannerFilter.COMMON) ? "_current" : ""));
            ItemBuilder itemBuilderA7 = Banner.getModuleCore().h().a(addonGuiItemsData7, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA7 != null) {
                Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData7, itemBuilderA7.asGuiItem(inventoryClickEvent7 -> {
                    try {
                        if (addonGuiItemsData7.getClickSound() != null && !addonGuiItemsData7.getClickSound().isEmpty()) {
                            Banner.a().getLibAPI().playSound(player, addonGuiItemsData7.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent7.setCancelled(true);
                    a(player, ClanEnum.BannerFilter.COMMON, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("head" + (bannerFilter.equals(ClanEnum.BannerFilter.HEAD) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData8 = addonGuiData.getItems().get("head" + (bannerFilter.equals(ClanEnum.BannerFilter.HEAD) ? "_current" : ""));
            ItemBuilder itemBuilderA8 = Banner.getModuleCore().h().a(addonGuiItemsData8, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA8 != null) {
                Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData8, itemBuilderA8.asGuiItem(inventoryClickEvent8 -> {
                    try {
                        if (addonGuiItemsData8.getClickSound() != null && !addonGuiItemsData8.getClickSound().isEmpty()) {
                            Banner.a().getLibAPI().playSound(player, addonGuiItemsData8.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent8.setCancelled(true);
                    a(player, ClanEnum.BannerFilter.HEAD, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("banner" + (bannerFilter.equals(ClanEnum.BannerFilter.BANNER) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData9 = addonGuiData.getItems().get("banner" + (bannerFilter.equals(ClanEnum.BannerFilter.BANNER) ? "_current" : ""));
            ItemBuilder itemBuilderA9 = Banner.getModuleCore().h().a(addonGuiItemsData9, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA9 != null) {
                Banner.getModuleCore().h().a(paginatedGuiCreate, addonGuiItemsData9, itemBuilderA9.asGuiItem(inventoryClickEvent9 -> {
                    try {
                        if (addonGuiItemsData9.getClickSound() != null && !addonGuiItemsData9.getClickSound().isEmpty()) {
                            Banner.a().getLibAPI().playSound(player, addonGuiItemsData9.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent9.setCancelled(true);
                    a(player, ClanEnum.BannerFilter.BANNER, (String) null);
                }));
            }
        }
        Optional.empty();
        Optional<BannerGroupData> optionalBannerCount = Banner.getModuleCore().e().bannerCount(playerClan.get());
        if (optionalBannerCount.isPresent()) {
            BannerGroupData bannerGroupData = optionalBannerCount.get();
            if (bannerFilter.equals(ClanEnum.BannerFilter.COMMON)) {
                List<ItemStack> bannerEnabledList = Banner.getModuleCore().e().getBannerEnabledList(playerClan.get().getId(), bannerFilter);
                if (addonGuiData.getItems().containsKey("current")) {
                    for (ItemStack itemStack : bannerEnabledList) {
                        AddonGuiItemsData addonGuiItemsData10 = addonGuiData.getItems().get("current");
                        AddonGuiItemsData addonGuiItemsDataM386clone = addonGuiItemsData10.m386clone();
                        addonGuiItemsDataM386clone.setMaterial(itemStack.getType().name());
                        ItemBuilder itemBuilderA10 = Banner.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), Arrays.asList("%name%;" + Banner.a().getLibAPI().translate(ClanEnum.TranslatableKey.block, itemStack.getType().name(), new String[0])));
                        if (itemBuilderA10 != null && itemBuilderA10 != null) {
                            itemBuilderA10.glow(false);
                            paginatedGuiCreate.addItem(itemBuilderA10.asGuiItem(inventoryClickEvent10 -> {
                                try {
                                    if (addonGuiItemsData10.getClickSound() != null && !addonGuiItemsData10.getClickSound().isEmpty()) {
                                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData10.getClickSound());
                                    }
                                } catch (Exception e2) {
                                }
                                inventoryClickEvent10.setCancelled(true);
                                if (!Banner.getModuleCore().e().setBanner(((ClanData) playerClan.get()).getId(), player, new ItemStack(itemStack))) {
                                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_ERROR_GUI));
                                } else {
                                    MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_SUCCESS));
                                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_SUCCESS_GUI));
                                }
                            }));
                        }
                    }
                }
            } else if ((bannerFilter.equals(ClanEnum.BannerFilter.BANNER) || bannerFilter.equals(ClanEnum.BannerFilter.HEAD)) && addonGuiData.getItems().containsKey("current")) {
                HashMap<String, ItemStack> heads = null;
                if (bannerFilter.equals(ClanEnum.BannerFilter.BANNER)) {
                    heads = bannerGroupData.getBanners();
                } else if (bannerFilter.equals(ClanEnum.BannerFilter.HEAD)) {
                    heads = bannerGroupData.getHeads();
                }
                if (heads != null) {
                    for (Map.Entry<String, ItemStack> entry : heads.entrySet()) {
                        AddonGuiItemsData addonGuiItemsData11 = addonGuiData.getItems().get("current");
                        String key = entry.getKey();
                        if (Banner.getModuleCore().c().h().getBoolean("Config.Banner.ucfirst_id")) {
                            key = new Strings().Ucfirst(key);
                        }
                        ItemBuilder itemBuilderA11 = Banner.getModuleCore().h().a(addonGuiItemsData11, entry.getValue(), player.getUniqueId(), Arrays.asList("%name%;" + key));
                        if (itemBuilderA11 != null) {
                            itemBuilderA11.glow(false);
                            paginatedGuiCreate.addItem(itemBuilderA11.asGuiItem(inventoryClickEvent11 -> {
                                try {
                                    if (addonGuiItemsData11.getClickSound() != null && !addonGuiItemsData11.getClickSound().isEmpty()) {
                                        Banner.a().getLibAPI().playSound(player, addonGuiItemsData11.getClickSound());
                                    }
                                } catch (Exception e2) {
                                }
                                inventoryClickEvent11.setCancelled(true);
                                if (!Banner.getModuleCore().e().setBanner(((ClanData) playerClan.get()).getId(), player, new ItemStack((ItemStack) entry.getValue()))) {
                                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_ERROR_GUI));
                                } else {
                                    MessageUtils.sendText((CommandSender) player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_SUCCESS));
                                    c(player, Banner.getModuleCore().c().b(Optional.of(player.getUniqueId())).getString(Lang.BANNER_UPLOAD_SUCCESS_GUI));
                                }
                            }));
                        }
                    }
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent12 -> {
            inventoryClickEvent12.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        Banner.getModuleCore().h().c().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Banner.getModuleCore().h().c().remove(player);
        });
        if (str == null || !Banner.a().getGuiAPI().useTitleAlerts()) {
            return;
        }
        Banner.getModuleCore().d().runTaskLater(() -> {
            a(player, bannerFilter, (String) null);
        }, 20L);
    }

    private static String __unused_1671() {
        return "banner_upload";
    }

    private static String __unused_1672() {
        return "banner_upload";
    }

    private static String __unused_1673() {
        return "fill2";
    }

    private static String __unused_1674() {
        return "fill2";
    }

    private static String __unused_1675() {
        return "fill";
    }

    private static String __unused_1676() {
        return "fill";
    }

    private static String __unused_1677() {
        return "General";
    }

    private static String __unused_1678() {
        return "banner_upload";
    }

    private static String __unused_1679() {
        return "upload_slot";
    }

    private static String __unused_1680() {
        return "upload_slot";
    }

    private static String __unused_1681() {
        return "confirm";
    }

    private static String __unused_1682() {
        return "confirm";
    }

    private static String __unused_1683() {
        return "back";
    }

    private static String __unused_1684() {
        return "back";
    }

    private static String __unused_1685() {
        return "banner_delete";
    }

    private static String __unused_1686() {
        return "banner_delete";
    }

    private static String __unused_1687() {
        return "fill";
    }

    private static String __unused_1688() {
        return "fill";
    }

    private static String __unused_1689() {
        return "General";
    }

    private static String __unused_1690() {
        return "banner_delete";
    }

    private static String __unused_1691() {
        return "confirm";
    }

    private static String __unused_1692() {
        return "confirm";
    }

    private static String __unused_1693() {
        return "cancel";
    }

    private static String __unused_1694() {
        return "cancel";
    }

    private static String __unused_1695() {
        return "banner_home";
    }

    private static String __unused_1696() {
        return "banner_home";
    }

    private static String __unused_1697() {
        return "fill2";
    }

    private static String __unused_1698() {
        return "fill2";
    }

    private static String __unused_1699() {
        return "fill";
    }

    private static String __unused_1700() {
        return "fill";
    }

    private static String __unused_1701() {
        return "General";
    }

    private static String __unused_1702() {
        return "banner_home";
    }

    private static String __unused_1703() {
        return "current";
    }

    private static String __unused_1704() {
        return "current";
    }

    private static String __unused_1705() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_1706() {
        return "upload";
    }

    private static String __unused_1707() {
        return "upload";
    }

    private static String __unused_1708() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_1709() {
        return "delete";
    }

    private static String __unused_1710() {
        return "delete";
    }

    private static String __unused_1711() {
        return "Config.Permissions.manager.name";
    }

    private static String __unused_1712() {
        return "pre";
    }

    private static String __unused_1713() {
        return "pre";
    }

    private static String __unused_1714() {
        return "back";
    }

    private static String __unused_1715() {
        return "back";
    }

    private static String __unused_1716() {
        return "banner_home_pre";
    }

    private static String __unused_1717() {
        return "banner_home_pre";
    }

    private static String __unused_1718() {
        return "fill";
    }

    private static String __unused_1719() {
        return "fill";
    }

    private static String __unused_1720() {
        return "fill2";
    }

    private static String __unused_1721() {
        return "fill2";
    }

    private static String __unused_1722() {
        return "fill3";
    }

    private static String __unused_1723() {
        return "fill3";
    }

    private static String __unused_1724() {
        return "General";
    }

    private static String __unused_1725() {
        return "banner_home_pre";
    }

    private static String __unused_1726() {
        return "previous";
    }

    private static String __unused_1727() {
        return "previous";
    }

    private static String __unused_1728() {
        return "next";
    }

    private static String __unused_1729() {
        return "next";
    }

    private static String __unused_1730() {
        return "back";
    }

    private static String __unused_1731() {
        return "back";
    }

    private static String __unused_1732() {
        return "_current";
    }

    private static String __unused_1733() {
        return "_current";
    }

    private static String __unused_1734() {
        return "_current";
    }

    private static String __unused_1735() {
        return "_current";
    }

    private static String __unused_1736() {
        return "_current";
    }

    private static String __unused_1737() {
        return "_current";
    }

    private static String __unused_1738() {
        return "current";
    }

    private static String __unused_1739() {
        return "current";
    }

    private static String __unused_1740() {
        return "current";
    }

    private static String __unused_1741() {
        return "current";
    }

    private static String __unused_1742() {
        return "Config.Banner.ucfirst_id";
    }
}
