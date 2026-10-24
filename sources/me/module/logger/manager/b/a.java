package me.module.logger.manager.b;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.module.logger.Logger;
import me.module.logger.manager.EnumFiles.Lang;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.LoggerData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Logger.jar:me/module/logger/manager/b/a.class */
public class a {
    private static byte[] __aes_key_VxTuftq3 = {(byte) 99, (byte) 181, (byte) 47, (byte) 120, (byte) 75, (byte) 52, (byte) 92, (byte) 223, (byte) 15, (byte) 130, (byte) 41, (byte) 112, (byte) 76, (byte) 83, (byte) 41, (byte) 107, (byte) 154, (byte) 169, (byte) 118, (byte) 217, (byte) 155, (byte) 36, (byte) 210, (byte) 4, (byte) 175, (byte) 225, (byte) 163, (byte) 177, (byte) 162, (byte) 86, (byte) 159, (byte) 133};
    private static byte[] __aes_iv_1Z6jdx9V = {(byte) 150, (byte) 81, (byte) 81, (byte) 253, (byte) 104, (byte) 60, (byte) 138, (byte) 9, (byte) 55, (byte) 247, (byte) 193, (byte) 65, (byte) 167, (byte) 147, (byte) 3, (byte) 254};
    private static String __s_cache_jmGOJ5b5_0;
    private static String __s_cache_0WgZWkdI_1;
    private static String __s_cache_8LS38RRS_2;
    private static String __s_cache_kd7kJdEz_3;
    private static String __s_cache_J3CVRH8D_4;
    private static String __s_cache_GHxW401c_5;
    private static String __s_cache_8nAOZnp7_6;
    private static String __s_cache_EBKY0ZEi_7;
    private static String __s_cache_lZm6xtr8_8;
    private static String __s_cache_1V26ni2A_9;
    private static String __s_cache_1g3EUCK1_10;
    private static String __s_cache_zBrdymHE_11;
    private static String __s_cache_BB7vGoNw_12;
    private static String __s_cache_fE2tsJyC_13;
    private static String __s_cache_N1wZtRz2_14;
    private static String __s_cache_TStcus63_15;
    private static String __s_cache_WDiwKaTm_16;
    private static String __s_cache_djqow4HP_17;
    private static String __s_cache_aliX9RWZ_18;
    private static String __s_cache_vhnsHL4L_19;
    private static String __s_cache_0DK9ETT0_20;
    private static String __s_cache_oroqeWHx_21;
    private static String __s_cache_bUiSRRQ6_22;
    private static String __s_cache_xx3N56d4_23;
    private static String __s_cache_D5A3WLry_24;
    private static String __s_cache_SHMf6DkM_25;
    private static String __s_cache_3vxJGtZg_26;
    private static String __s_cache_q70umLEe_27;
    private static String __s_cache_3hKHm8IW_28;
    private static String __s_cache_UiEnBTaa_29;
    private static String __s_cache_99tqJoFr_30;
    private static String __s_cache_htRgGvtl_31;
    private static String __s_cache_CVbzjZOn_32;
    private static String __s_cache_dQenFMTw_33;
    private static String __s_cache_g4eyt3NB_34;
    private static String __s_cache_CdopxDAe_35;
    private static String __s_cache_QqLFtxUY_36;
    private static String __s_cache_Rl2Wlzo0_37;
    private static String __s_cache_xGzkM9HY_38;
    private static String __s_cache_sUkOaVDN_39;
    private static String __s_cache_4Tppnmn3_40;
    private static String __s_cache_aagx8L2J_41;
    private static String __s_cache_dkrbS3Go_42;
    private static String __s_cache_F6bkDdTv_43;
    private static String __s_cache_0wC24l7M_44;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, ClanEnum.LoggerTime loggerTime, String str) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        Optional<ClanData> playerClan = Logger.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Logger.a().getModAPI().playerHasPermission(player.getUniqueId(), Logger.getModuleCore().c().i().getString("Config.Permissions.edit.name"))) {
            MessageUtils.sendText((CommandSender) player, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return;
        }
        if (!Logger.getModuleCore().i().a(player).containsKey("clear_logger_confirm")) {
            MessageUtils.sendText((CommandSender) player, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Logger.getModuleCore().i().a(player).get("clear_logger_confirm");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Logger.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && !Logger.getModuleCore().c().i().getBoolean("Config.gui.disable_title_alerts")) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Logger.a().getColorAPI().addMiniColor(Logger.a().getHooksAPI().parsePapi(player, Logger.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA3 = Logger.getModuleCore().i().a((addonGuiItemsData3 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Logger.a().getGuiAPI().insertItens(guiCreate, "General", "clear_logger_confirm", player);
        if (addonGuiData.getItems().containsKey("confirm") && (itemBuilderA2 = Logger.getModuleCore().i().a((addonGuiItemsData2 = addonGuiData.getItems().get("confirm")), player.getUniqueId(), (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                if (Logger.getModuleCore().e().clearClanLogger(((ClanData) playerClan.get()).getId())) {
                    b(player, loggerTime, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.LOGGER_CLEAR_SUCCESS_GUI));
                } else {
                    b(player, loggerTime, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.LOGGER_CLEAR_ERROR_GUI));
                }
            }));
        }
        if (addonGuiData.getItems().containsKey("cancel") && (itemBuilderA = Logger.getModuleCore().i().a((addonGuiItemsData = addonGuiData.getItems().get("cancel")), player.getUniqueId(), (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                b(player, loggerTime, (String) null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent4 -> {
            inventoryClickEvent4.setCancelled(true);
        });
        guiCreate.open(player);
        Logger.getModuleCore().i().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Logger.getModuleCore().i().c().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(Player player, ClanEnum.LoggerTime loggerTime, String str) {
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
        Optional<ClanData> playerClan = Logger.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Logger.a().getModAPI().playerHasPermission(player.getUniqueId(), Logger.getModuleCore().c().i().getString("Config.Permissions.view.name"))) {
            MessageUtils.sendText((CommandSender) player, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
            return;
        }
        if (!Logger.getModuleCore().i().a(player).containsKey("clan_logger")) {
            MessageUtils.sendText((CommandSender) player, Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Logger.getModuleCore().i().a(player).get("clan_logger");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Logger.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (str != null && !Logger.getModuleCore().c().i().getBoolean("Config.gui.disable_title_alerts")) {
            title = str;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(Logger.a().getColorAPI().addMiniColor(Logger.a().getHooksAPI().parsePapi(player, Logger.a().getClanAPI().parseText(player.getUniqueId(), title.replace("{timer}", Logger.getModuleCore().c().a((CommandSender) player).getString(Lang.valueOf("TRANSLACTION_" + loggerTime.toString().toUpperCase()))))), true))).rows(addonGuiData.getRows()).pageSize(addonGuiData.getPageSize()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA6 = Logger.getModuleCore().i().a((addonGuiItemsData6 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData6, itemBuilderA6.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData6.getClickSound() != null && !addonGuiItemsData6.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill2") && (itemBuilderA5 = Logger.getModuleCore().i().a((addonGuiItemsData5 = addonGuiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData5, itemBuilderA5.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        Logger.a().getGuiAPI().insertItens(paginatedGuiCreate, "General", "clan_logger", player);
        if (addonGuiData.getItems().containsKey("filter_all" + (loggerTime.equals(ClanEnum.LoggerTime.ALL) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData7 = addonGuiData.getItems().get("filter_all" + (loggerTime.equals(ClanEnum.LoggerTime.ALL) ? "_current" : ""));
            ItemBuilder itemBuilderA7 = Logger.getModuleCore().i().a(addonGuiItemsData7, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA7 != null) {
                Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData7, itemBuilderA7.asGuiItem(inventoryClickEvent3 -> {
                    try {
                        if (addonGuiItemsData7.getClickSound() != null && !addonGuiItemsData7.getClickSound().isEmpty()) {
                            Logger.a().getLibAPI().playSound(player, addonGuiItemsData7.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent3.setCancelled(true);
                    b(player, ClanEnum.LoggerTime.ALL, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("filter_daily" + (loggerTime.equals(ClanEnum.LoggerTime.DAILY) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData8 = addonGuiData.getItems().get("filter_daily" + (loggerTime.equals(ClanEnum.LoggerTime.DAILY) ? "_current" : ""));
            ItemBuilder itemBuilderA8 = Logger.getModuleCore().i().a(addonGuiItemsData8, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA8 != null) {
                Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData8, itemBuilderA8.asGuiItem(inventoryClickEvent4 -> {
                    try {
                        if (addonGuiItemsData8.getClickSound() != null && !addonGuiItemsData8.getClickSound().isEmpty()) {
                            Logger.a().getLibAPI().playSound(player, addonGuiItemsData8.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent4.setCancelled(true);
                    b(player, ClanEnum.LoggerTime.DAILY, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("filter_weekly" + (loggerTime.equals(ClanEnum.LoggerTime.WEEKLY) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData9 = addonGuiData.getItems().get("filter_weekly" + (loggerTime.equals(ClanEnum.LoggerTime.WEEKLY) ? "_current" : ""));
            ItemBuilder itemBuilderA9 = Logger.getModuleCore().i().a(addonGuiItemsData9, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA9 != null) {
                Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData9, itemBuilderA9.asGuiItem(inventoryClickEvent5 -> {
                    try {
                        if (addonGuiItemsData9.getClickSound() != null && !addonGuiItemsData9.getClickSound().isEmpty()) {
                            Logger.a().getLibAPI().playSound(player, addonGuiItemsData9.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent5.setCancelled(true);
                    b(player, ClanEnum.LoggerTime.WEEKLY, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("filter_monthly" + (loggerTime.equals(ClanEnum.LoggerTime.MONTHLY) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData10 = addonGuiData.getItems().get("filter_monthly" + (loggerTime.equals(ClanEnum.LoggerTime.MONTHLY) ? "_current" : ""));
            ItemBuilder itemBuilderA10 = Logger.getModuleCore().i().a(addonGuiItemsData10, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA10 != null) {
                Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData10, itemBuilderA10.asGuiItem(inventoryClickEvent6 -> {
                    try {
                        if (addonGuiItemsData10.getClickSound() != null && !addonGuiItemsData10.getClickSound().isEmpty()) {
                            Logger.a().getLibAPI().playSound(player, addonGuiItemsData10.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent6.setCancelled(true);
                    b(player, ClanEnum.LoggerTime.MONTHLY, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("filter_yearly" + (loggerTime.equals(ClanEnum.LoggerTime.YEARLY) ? "_current" : ""))) {
            AddonGuiItemsData addonGuiItemsData11 = addonGuiData.getItems().get("filter_yearly" + (loggerTime.equals(ClanEnum.LoggerTime.YEARLY) ? "_current" : ""));
            ItemBuilder itemBuilderA11 = Logger.getModuleCore().i().a(addonGuiItemsData11, player.getUniqueId(), (List<String>) null);
            if (itemBuilderA11 != null) {
                Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData11, itemBuilderA11.asGuiItem(inventoryClickEvent7 -> {
                    try {
                        if (addonGuiItemsData11.getClickSound() != null && !addonGuiItemsData11.getClickSound().isEmpty()) {
                            Logger.a().getLibAPI().playSound(player, addonGuiItemsData11.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent7.setCancelled(true);
                    b(player, ClanEnum.LoggerTime.YEARLY, (String) null);
                }));
            }
        }
        if (addonGuiData.getItems().containsKey("clear") && Logger.a().getModAPI().playerHasPermission(player.getUniqueId(), Logger.getModuleCore().c().i().getString("Config.Permissions.edit.name")) && (itemBuilderA4 = Logger.getModuleCore().i().a((addonGuiItemsData4 = addonGuiData.getItems().get("clear")), player.getUniqueId(), (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent8 -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent8.setCancelled(true);
                a(player, loggerTime, (String) null);
            }));
        }
        if (addonGuiData.getItems().containsKey("previous") && (itemBuilderA3 = Logger.getModuleCore().i().a((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent9 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent9.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && (itemBuilderA2 = Logger.getModuleCore().i().a((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent10 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent10.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Logger.getModuleCore().i().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Logger.getModuleCore().i().a(paginatedGuiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent11 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Logger.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent11.setCancelled(true);
                Logger.a().getGuiAPI().openClanHome(player);
            }));
        }
        if (addonGuiData.getItems().containsKey("current")) {
            for (LoggerData loggerData : Logger.getModuleCore().e().getClanLoggerTimed(playerClan.get().getId(), loggerTime)) {
                AddonGuiItemsData addonGuiItemsData12 = addonGuiData.getItems().get("current");
                ItemBuilder itemBuilderA12 = Logger.getModuleCore().i().a(addonGuiItemsData12, player.getUniqueId(), Arrays.asList("{id};{" + loggerData.getId().toString() + "}"));
                if (itemBuilderA12 != null) {
                    if (loggerData.getMaterial() != null && !loggerData.getMaterial().equals(Material.AIR)) {
                        itemBuilderA12.build().setType(loggerData.getMaterial());
                    }
                    paginatedGuiCreate.addItem(itemBuilderA12.asGuiItem(inventoryClickEvent12 -> {
                        try {
                            if (addonGuiItemsData12.getClickSound() != null && !addonGuiItemsData12.getClickSound().isEmpty()) {
                                Logger.a().getLibAPI().playSound(player, addonGuiItemsData12.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent12.setCancelled(true);
                    }));
                }
            }
        }
        paginatedGuiCreate.open(player);
        Logger.getModuleCore().i().c().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Logger.getModuleCore().i().c().remove(player);
        });
        if (str == null || Logger.getModuleCore().c().i().getBoolean("Config.gui.disable_title_alerts")) {
            return;
        }
        Logger.getModuleCore().d().runTaskLater(() -> {
            b(player, loggerTime, (String) null);
        }, 20L);
    }

    private static String __unused_208() {
        return "Config.Permissions.edit.name";
    }

    private static String __unused_209() {
        return "clear_logger_confirm";
    }

    private static String __unused_210() {
        return "clear_logger_confirm";
    }

    private static String __unused_211() {
        return "Config.gui.disable_title_alerts";
    }

    private static String __unused_212() {
        return "fill";
    }

    private static String __unused_213() {
        return "fill";
    }

    private static String __unused_214() {
        return "General";
    }

    private static String __unused_215() {
        return "clear_logger_confirm";
    }

    private static String __unused_216() {
        return "confirm";
    }

    private static String __unused_217() {
        return "confirm";
    }

    private static String __unused_218() {
        return "cancel";
    }

    private static String __unused_219() {
        return "cancel";
    }

    private static String __unused_220() {
        return "Config.Permissions.view.name";
    }

    private static String __unused_221() {
        return "clan_logger";
    }

    private static String __unused_222() {
        return "clan_logger";
    }

    private static String __unused_223() {
        return "Config.gui.disable_title_alerts";
    }

    private static String __unused_224() {
        return "{timer}";
    }

    private static String __unused_225() {
        return "fill";
    }

    private static String __unused_226() {
        return "fill";
    }

    private static String __unused_227() {
        return "fill2";
    }

    private static String __unused_228() {
        return "fill2";
    }

    private static String __unused_229() {
        return "General";
    }

    private static String __unused_230() {
        return "clan_logger";
    }

    private static String __unused_231() {
        return "_current";
    }

    private static String __unused_232() {
        return "_current";
    }

    private static String __unused_233() {
        return "_current";
    }

    private static String __unused_234() {
        return "_current";
    }

    private static String __unused_235() {
        return "_current";
    }

    private static String __unused_236() {
        return "_current";
    }

    private static String __unused_237() {
        return "_current";
    }

    private static String __unused_238() {
        return "_current";
    }

    private static String __unused_239() {
        return "_current";
    }

    private static String __unused_240() {
        return "_current";
    }

    private static String __unused_241() {
        return "clear";
    }

    private static String __unused_242() {
        return "Config.Permissions.edit.name";
    }

    private static String __unused_243() {
        return "clear";
    }

    private static String __unused_244() {
        return "previous";
    }

    private static String __unused_245() {
        return "previous";
    }

    private static String __unused_246() {
        return "next";
    }

    private static String __unused_247() {
        return "next";
    }

    private static String __unused_248() {
        return "back";
    }

    private static String __unused_249() {
        return "back";
    }

    private static String __unused_250() {
        return "current";
    }

    private static String __unused_251() {
        return "current";
    }

    private static String __unused_252() {
        return "Config.gui.disable_title_alerts";
    }
}
