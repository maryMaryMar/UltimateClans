package me.ulrich.clans.manager.gui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/gui/SettingsGuiManager.class */
public class SettingsGuiManager {
    private final Clans plugin;

    public SettingsGuiManager(Clans clans) {
        this.plugin = clans;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanSettings(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        GuiItemsData guiItemsData5;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5;
        GuiItemsData guiItemsData6;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6;
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_settings")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_settings");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (str != null && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title))))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "clan_settings", player);
        if (guiData.getItems().containsKey("clan_edit") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("clan_edit")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                openClanActions(player, null);
            }));
        }
        if (guiData.getItems().containsKey("member_ban") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("member_ban")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                openBannedMembers(player, null);
            }));
        }
        if (guiData.getItems().containsKey("clan_roles") && this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), "PERMISSIONS") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("clan_roles")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openClanRoles(player, null);
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent7 -> {
            inventoryClickEvent7.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openClanSettings(player, null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openBannedMembers(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        GuiItemsData guiItemsData5;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5;
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("banned_members")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("banned_members");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (str != null && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title.replace("%amount%", String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getBanned().size()))))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "banned_members", player);
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("add") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("add")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    paginatedGuiCreate.close(player);
                }
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                    player.chat("/clan ban");
                });
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openClanSettings(player, null);
            }));
        }
        optionalCDW4Fj1iwdIXEOqWjiJSR.get().getBanned().iterator().forEachRemaining(uuid -> {
            GuiItemsData guiItemsData6;
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6;
            if (!guiData.getItems().containsKey("current") || (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("current")), uuid, (List<String>) null)) == null) {
                return;
            }
            paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                if (this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY(((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), uuid)) {
                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_SUCCESS_UNBAN));
                    openBannedMembers(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_SUCCESS_UNBAN_GUI));
                } else {
                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ERROR_UNBAN));
                    openBannedMembers(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ERROR_UNBAN_GUI));
                }
            }));
        });
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openBannedMembers(player, null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanActions(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        GuiItemsData guiItemsData5;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5;
        GuiItemsData guiItemsData6;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6;
        GuiItemsData guiItemsData7;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY7;
        GuiItemsData guiItemsData8;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY8;
        GuiItemsData guiItemsData9;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY9;
        GuiItemsData guiItemsData10;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY10;
        GuiItemsData guiItemsData11;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY11;
        GuiItemsData guiItemsData12;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY12;
        GuiItemsData guiItemsData13;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY13;
        GuiItemsData guiItemsData14;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY14;
        GuiItemsData guiItemsData15;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY15;
        GuiItemsData guiItemsData16;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY16;
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_actions")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_actions");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (str != null && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title))))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY16 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData16 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData16, itemBuilderV8qP8fE86HMhvNuYPFjqY16.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData16.getClickSound() != null && !guiItemsData16.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData16.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY15 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData15 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData15, itemBuilderV8qP8fE86HMhvNuYPFjqY15.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData15.getClickSound() != null && !guiItemsData15.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData15.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "clan_actions", player);
        if (guiData.getItems().containsKey("modtag") && (itemBuilderV8qP8fE86HMhvNuYPFjqY14 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData14 = guiData.getItems().get("modtag")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData14, itemBuilderV8qP8fE86HMhvNuYPFjqY14.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData14.getClickSound() != null && !guiItemsData14.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData14.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    guiCreate.close(player);
                }
                if (t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.CLANMODTAG, null, true, true, 0)) {
                    return;
                }
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_START_ACTION));
            }));
        }
        if (guiData.getItems().containsKey("desc") && (itemBuilderV8qP8fE86HMhvNuYPFjqY13 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData13 = guiData.getItems().get("desc")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData13, itemBuilderV8qP8fE86HMhvNuYPFjqY13.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData13.getClickSound() != null && !guiItemsData13.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData13.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    guiCreate.close(player);
                }
                if (t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.CLANDESC, null, true, true, 0)) {
                    return;
                }
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_START_ACTION));
            }));
        }
        if (guiData.getItems().containsKey("warinvite") && getPlugin().getClanManager().iZTqZaRK5UGoe0Z("CLANWAR") && (itemBuilderV8qP8fE86HMhvNuYPFjqY12 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData12 = guiData.getItems().get("warinvite")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite())));
            if (materialV8qP8fE86HMhvNuYPFjqY != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY12.build().setType(materialV8qP8fE86HMhvNuYPFjqY);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY12.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY12.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData12, itemBuilderV8qP8fE86HMhvNuYPFjqY12.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData12.getClickSound() != null && !guiItemsData12.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData12.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.WARINVITE, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("allysharedchat") && (itemBuilderV8qP8fE86HMhvNuYPFjqY11 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData11 = guiData.getItems().get("allysharedchat")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY2 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllySharedChat())));
            if (materialV8qP8fE86HMhvNuYPFjqY2 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY11.build().setType(materialV8qP8fE86HMhvNuYPFjqY2);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY11.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllySharedChat()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY11.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllySharedChat());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData11, itemBuilderV8qP8fE86HMhvNuYPFjqY11.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData11.getClickSound() != null && !guiItemsData11.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData11.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.ALLYSHAREDCHAT, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("allysharedhome") && (itemBuilderV8qP8fE86HMhvNuYPFjqY10 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData10 = guiData.getItems().get("allysharedhome")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY3 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllySharedHome())));
            if (materialV8qP8fE86HMhvNuYPFjqY3 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY10.build().setType(materialV8qP8fE86HMhvNuYPFjqY3);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY10.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllySharedHome()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY10.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllySharedHome());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData10, itemBuilderV8qP8fE86HMhvNuYPFjqY10.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData10.getClickSound() != null && !guiItemsData10.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData10.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.ALLYSHAREDHOME, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("ff") && (itemBuilderV8qP8fE86HMhvNuYPFjqY9 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData9 = guiData.getItems().get("ff")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY4 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().isFf())));
            if (materialV8qP8fE86HMhvNuYPFjqY4 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY9.build().setType(materialV8qP8fE86HMhvNuYPFjqY4);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY9.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().isFf()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY9.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().isFf());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData9, itemBuilderV8qP8fE86HMhvNuYPFjqY9.asGuiItem(inventoryClickEvent8 -> {
                try {
                    if (guiItemsData9.getClickSound() != null && !guiItemsData9.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData9.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent8.setCancelled(true);
                if (!this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.player.ff.enabled")) {
                    openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.DISABLED_FUNCTION_GUI));
                    return;
                }
                this.plugin.getClanManager().ZwrsrwOCXRUscW6Q((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get());
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (getPlugin().getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.player.join_quit") && guiData.getItems().containsKey("join_leave") && (itemBuilderV8qP8fE86HMhvNuYPFjqY8 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData8 = guiData.getItems().get("join_leave")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY5 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isJoinLeave())));
            if (materialV8qP8fE86HMhvNuYPFjqY5 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY8.build().setType(materialV8qP8fE86HMhvNuYPFjqY5);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY8.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isJoinLeave()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY8.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isJoinLeave());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData8, itemBuilderV8qP8fE86HMhvNuYPFjqY8.asGuiItem(inventoryClickEvent9 -> {
                try {
                    if (guiItemsData8.getClickSound() != null && !guiItemsData8.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData8.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent9.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.JOINLEAVE, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("opened") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("opened")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY6 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isOpened())));
            if (materialV8qP8fE86HMhvNuYPFjqY6 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY7.build().setType(materialV8qP8fE86HMhvNuYPFjqY6);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY7.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isOpened()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY7.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isOpened());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent10 -> {
                try {
                    if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent10.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.OPENED, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("publichomes") && this.plugin.getConfig().getBoolean("Clan.home.can_toggle_view") && this.plugin.getConfig().getBoolean("Clan.home.public") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("publichomes")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY7 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isPublicHomes())));
            if (materialV8qP8fE86HMhvNuYPFjqY7 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY6.build().setType(materialV8qP8fE86HMhvNuYPFjqY7);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isPublicHomes()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY6.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isPublicHomes()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY6.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isPublicHomes());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent11 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent11.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.PUBLICHOMES, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("receivemailallies") && !this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Clan.mail.enabled_for_all_clans") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("receivemailallies")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY8 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceveMailAllies())));
            if (materialV8qP8fE86HMhvNuYPFjqY8 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY5.build().setType(materialV8qP8fE86HMhvNuYPFjqY8);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceveMailAllies()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY5.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceveMailAllies()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY5.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceveMailAllies());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent12 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent12.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.RECEIVEMAILALLIES, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("receivemailall") && this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Clan.mail.enabled_for_all_clans") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("receivemailall")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY9 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceiveMailAll())));
            if (materialV8qP8fE86HMhvNuYPFjqY9 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY4.build().setType(materialV8qP8fE86HMhvNuYPFjqY9);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceiveMailAll()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY4.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceiveMailAll()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY4.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceiveMailAll());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent13 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent13.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.RECEIVEMAILALL, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (guiData.getItems().containsKey("allypvp") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("allypvp")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY10 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllyPvp())));
            if (materialV8qP8fE86HMhvNuYPFjqY10 != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY3.build().setType(materialV8qP8fE86HMhvNuYPFjqY10);
                if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isReceiveMailAll()) + "_model") > 0) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY3.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllyPvp()) + "_model"));
                }
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY3.glow(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isAllyPvp());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent14 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent14.setCancelled(true);
                this.plugin.getClanManager().v8qP8fE86HMhvNuYPFjqY((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), ClanEnum.SettingsType.ALLYPVP, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openClanActions(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), "DISBAND") && guiData.getItems().containsKey("delete") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("delete")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent15 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent15.setCancelled(true);
                openDisbandConfirm(player, null);
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent16 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent16.setCancelled(true);
                openClanSettings(player, null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent17 -> {
            inventoryClickEvent17.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openClanActions(player, null);
        }, 25L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openDisbandConfirm(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("disband_confirm")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("disband_confirm");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (str != null && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), title))))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "disband_confirm", player);
        if (guiData.getItems().containsKey("confirm") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("confirm")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                if (!this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), "DISBAND")) {
                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                    openDisbandConfirm(player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI));
                } else {
                    if (!this.plugin.getClanManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId())) {
                        MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_DISBAND_ERROR));
                        openDisbandConfirm(player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_DELETE_ERROR_GUI));
                        return;
                    }
                    if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                            player.closeInventory();
                        }, 2L);
                    } else {
                        guiCreate.close(player);
                    }
                    MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_DISBAND_SUCCESS));
                    new jBWyXxi9EyWxcPiz(getPlugin()).v8qP8fE86HMhvNuYPFjqY(ClanEnum.ClanCommandActions.DELETE, Arrays.asList("%player%;" + getPlugin().getHooksManager().getPlayerName(player), "%clantag%;" + ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getTagNoColor()), player.getUniqueId());
                }
            }));
        }
        if (guiData.getItems().containsKey("cancel") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("cancel")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                openClanActions(player, null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent4 -> {
            inventoryClickEvent4.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanRoles(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        GuiItemsData guiItemsData5;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5;
        GuiItemsData guiItemsData6;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6;
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_roles")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_roles");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (str != null && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = str;
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title))))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "clan_roles", player);
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                openClanSettings(player, null);
            }));
        }

        if (guiData.getItems().containsKey("update") && this.plugin.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean("Moderation.update.enabled") && !CooldownAPI.isInCooldown(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), "update_sync") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("update")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                this.plugin.getModerationManager().iZTqZaRK5UGoe0Z(((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId());
                new CooldownAPI(((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), "update_sync", this.plugin.getFiles().IO1OGSMpoP1ZjOsbXi3a().getInt("Moderation.update.cooldown")).start();
                openClanRoles(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_SYNC_SETTINGS_GUI));
            }));
        }
        Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = this.plugin.getModerationManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId());
        for (Map.Entry<String, HashMap<String, Boolean>> entry : this.plugin.getModerationManager().ZwrsrwOCXRUscW6Q(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId()).entrySet()) {
            if (this.plugin.getModerationManager().zJnaNCVQSgEShq().containsKey(entry.getKey())) {
                ModerationData moderationData = this.plugin.getModerationManager().zJnaNCVQSgEShq().get(entry.getKey());
                if ((this.plugin.getPlayerManager().vVo2VUvxrriklPdRxI(player.getUniqueId()) || !this.plugin.getFiles().IO1OGSMpoP1ZjOsbXi3a().getBoolean("Moderation.just_edit_permissions_below") || !optionalB4i2FbOkaKeg91LiAe6l.isPresent() || moderationData.getPriority() < optionalB4i2FbOkaKeg91LiAe6l.get().getPriority()) && moderationData.isEditable()) {
                    ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(moderationData.getIcon(), player.getUniqueId(), (List<String>) null);
                    if (itemBuilderV8qP8fE86HMhvNuYPFjqY7 != null) {
                        guiCreate.setItem(moderationData.getIcon().getSlot(), itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent6 -> {
                            try {
                                if (moderationData.getIcon().getClickSound() != null && !moderationData.getIcon().getClickSound().isEmpty()) {
                                    this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, moderationData.getIcon().getClickSound());
                                }
                            } catch (Exception e2) {
                            }
                            inventoryClickEvent6.setCancelled(true);
                            openClanRolesEditor(player, 1, moderationData.getId(), str);
                        }));
                    }
                } else if (guiData.getItems().containsKey("blocked") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("blocked")), player.getUniqueId(), Arrays.asList("%name%;" + moderationData.getName()))) != null) {
                    final me.ulrich.clans.data.GuiItemsData finalBlockedData = guiItemsData;
                    guiCreate.setItem(moderationData.getIcon().getSlot(), itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent7 -> {
                        try {
                            if (finalBlockedData.getClickSound() != null && !finalBlockedData.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, finalBlockedData.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent7.setCancelled(true);
                    }));
                }
            }
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openClanRoles(player, null);
        }, 25L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanRolesEditor(Player player, int i, String str, String str2) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        GuiItemsData guiItemsData5;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5;
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_roles_editor") || !this.plugin.getModerationManager().zJnaNCVQSgEShq().containsKey(str)) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        ModerationData moderationData = this.plugin.getModerationManager().zJnaNCVQSgEShq().get(str);
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_roles_editor");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (str2 != null && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = str2;
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title.replace("%name%", moderationData.getName())))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "clan_roles_editor", player);
        HashMap<String, HashMap<String, Boolean>> mapZwrsrwOCXRUscW6Q = this.plugin.getModerationManager().ZwrsrwOCXRUscW6Q(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId());
        if (mapZwrsrwOCXRUscW6Q.containsKey(str)) {
            for (Map.Entry<String, Boolean> entry : mapZwrsrwOCXRUscW6Q.get(str).entrySet()) {
                if (guiData.getItems().containsKey("current") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("current")), player.getUniqueId(), Arrays.asList("%key%;" + entry.getKey(), "%value%;" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("STATE_" + String.valueOf(entry.getValue()).toUpperCase()))))) != null) {
                    Material materialV8qP8fE86HMhvNuYPFjqY = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(entry.getValue())));
                    if (materialV8qP8fE86HMhvNuYPFjqY != null) {
                        itemBuilderV8qP8fE86HMhvNuYPFjqY4.build().setType(materialV8qP8fE86HMhvNuYPFjqY);
                        if (this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getSettings().isWarInvite()) + "_model") > 0) {
                            itemBuilderV8qP8fE86HMhvNuYPFjqY4.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(entry.getValue()) + "_model"));
                        }
                    }
                    itemBuilderV8qP8fE86HMhvNuYPFjqY4.glow(entry.getValue().booleanValue());
                    final me.ulrich.clans.data.GuiItemsData finalCurrentData = guiItemsData4;
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent2 -> {
                        try {
                            if (finalCurrentData.getClickSound() != null && !finalCurrentData.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, finalCurrentData.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent2.setCancelled(true);
                        if (this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), str, (String) entry.getKey(), Boolean.valueOf(!((Boolean) entry.getValue()).booleanValue()))) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_EDITOR_CHANGED_SETTINGS));
                            openClanRolesEditor(player, paginatedGuiCreate.getCurrentPageNum(), str, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_EDITOR_CHANGED_SETTINGS_GUI));
                        } else {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_EDITOR_CHANGED_SETTINGS));
                            openClanRolesEditor(player, paginatedGuiCreate.getCurrentPageNum(), str, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_EDITOR_CHANGED_SETTINGS_GUI));
                        }
                    }));
                }
            }
        }
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.open(player, paginatedGuiCreate.getPrevPageNum());
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                paginatedGuiCreate.open(player, paginatedGuiCreate.getNextPageNum());
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openClanRoles(player, null);
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        paginatedGuiCreate.open(player, i);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str2 == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openClanRolesEditor(player, i, str, null);
        }, 25L);
    }

    public Clans getPlugin() {
        return this.plugin;
    }
}
