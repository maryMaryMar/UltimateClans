package me.ulrich.clans.manager.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.OnlineData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/gui/GeneralGuiManager.class */
public class GeneralGuiManager {
    private Clans plugin;

    public GeneralGuiManager(Clans clans) {
        this.plugin = clans;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openChangeLeaderConfirm(Player player, UUID uuid, String str) {
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
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("changeleader_confirm")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("changeleader_confirm");
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
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), title)), true))).rows(guiData.getRows()).create();
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
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "changeleader_confirm", player);
        if (guiData.getItems().containsKey("confirm") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("confirm")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                CommandData commandData = this.plugin.getCommandManager().ZwrsrwOCXRUscW6Q().get("changeleader");
                if (!this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), uuid)) {
                    MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
                    return;
                }
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    guiCreate.close(player);
                }
                MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
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
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    guiCreate.close(player);
                }
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
    public void openNoClanHome(Player player) {
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
        if (getPlugin().getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("noclan_home")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("noclan_home");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), guiData.getTitle())), true))).rows(guiData.getRows()).create();
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
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "noclan_home", player);
        if (guiData.getItems().containsKey("create") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("create")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
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
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                    player.chat("/clan create");
                });
            }));
        }
        if (guiData.getItems().containsKey("clans") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("clans")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                getPlugin().getGuiManager().p31abtwfBag2jhMH6K().openClanTop(player, ClanEnum.PlaceholderTop.ALL, 1, false);
            }));
        }
        if (this.plugin.getPlayerManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId()) && guiData.getItems().containsKey("profile") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("profile")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfile(player, player.getUniqueId(), null);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        if (guiData.getItems().containsKey("commands") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("commands")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    guiCreate.close(player);
                }
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                    player.chat("/clan help");
                });
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanHome(Player player) {
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
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        if (!optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_home")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_home");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (optionalCDW4Fj1iwdIXEOqWjiJSR != null) {
            title = getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title);
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, title), true))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY9 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData9 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData9, itemBuilderV8qP8fE86HMhvNuYPFjqY9.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData9.getClickSound() != null && !guiItemsData9.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData9.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY8 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData8 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData8, itemBuilderV8qP8fE86HMhvNuYPFjqY8.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData8.getClickSound() != null && !guiItemsData8.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData8.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "clan_home", player);
        if (this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), "SETTINGS")) {
            if (guiData.getItems().containsKey("settings") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("settings")), player.getUniqueId(), (List<String>) null)) != null) {
                this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent3 -> {
                    try {
                        if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent3.setCancelled(true);
                    this.plugin.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanSettings(player, null);
                }));
            }
        } else if (guiData.getItems().containsKey("profile") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("profile")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfile(player, player.getUniqueId(), null);
            }));
        }
        if (new jBWyXxi9EyWxcPiz(getPlugin()).v8qP8fE86HMhvNuYPFjqY(player, "info", "clan", false) && guiData.getItems().containsKey("info") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("info")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openClanStats(player, (ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get(), null);
            }));
        }
        if (guiData.getItems().containsKey("clans") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("clans")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openClanTop(player, ClanEnum.PlaceholderTop.ALL, 1, false);
            }));
        }
        if (guiData.getItems().containsKey("players") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("players")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openPlayerTop(player, ClanEnum.PlaceholderPlayerTop.ALL, 1, false, false);
            }));
        }
        if (guiData.getItems().containsKey("commands") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("commands")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent8 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent8.setCancelled(true);
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    guiCreate.close(player);
                }
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                    player.chat("/clan help");
                });
            }));
        }
        if (new jBWyXxi9EyWxcPiz(getPlugin()).v8qP8fE86HMhvNuYPFjqY(player, "members", "clan", false) && guiData.getItems().containsKey("members") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("members")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent9 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent9.setCancelled(true);
                this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openClansListMembers(player, ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), false);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent10 -> {
            inventoryClickEvent10.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanMembersInvite(Player player, String str) {
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
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_members_invite")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_members_invite");
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
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title)), true))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "clan_members_invite", player);
        if (guiData.getItems().containsKey("current")) {
            ArrayList<OnlineData> arrayList = new ArrayList(this.plugin.getPlayerManager().zJnaNCVQSgEShq());
            arrayList.removeIf(onlineData -> {
                return ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getMembers().contains(onlineData.getPlayerUUID()) || onlineData.getPlayerUUID().equals(player.getUniqueId()) || this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), onlineData.getPlayerUUID()) || !this.plugin.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData.getPlayerUUID()) || !this.plugin.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData.getPlayerUUID()) || !this.plugin.getPlayerManager().b4i2FbOkaKeg91LiAe6l(onlineData.getPlayerUUID()) || this.plugin.getHooksManager().isInvisible(onlineData.getPlayerUUID());
            });
            for (OnlineData onlineData2 : arrayList) {
                GuiItemsData guiItemsData4 = guiData.getItems().get("current");
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData4, onlineData2.getPlayerUUID(), (List<String>) null);
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY4 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent2 -> {
                        try {
                            if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent2.setCancelled(true);
                        if (((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getBanned().contains(onlineData2.getPlayerUUID())) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_IS_BANNED));
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_IS_BANNED_GUI));
                            return;
                        }
                        if (!this.plugin.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData2.getPlayerUUID()) || ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getMembers().contains(onlineData2.getPlayerUUID())) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_BLOCKED_INVITE));
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_ERROR_GUI));
                        } else if (!this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), "INVITE")) {
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI));
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                        } else if (this.plugin.getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(onlineData2.getPlayerUUID(), ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), player.getUniqueId())) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_SUCCESS));
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_SUCCESS_GUI));
                        } else {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_ERROR));
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_ERROR_GUI));
                        }
                    }));
                }
            }
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openClansListMembers(player, ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), false);
            }));
        }
        if (guiData.getItems().containsKey("search") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("search")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
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
                if (this.plugin.getAnvilGuiManager().v8qP8fE86HMhvNuYPFjqY() && this.plugin.getAnvilGuiManager().v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.MEMBERSEARCH, true, Optional.empty())) {
                    return;
                }
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                    player.chat("/clan member search");
                });
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent5 -> {
            inventoryClickEvent5.setCancelled(true);
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
            openClanMembersInvite(player, null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanSearchMembersInvite(Player player, String str, String str2) {
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
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_search_members_invite")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_search_members_invite");
        ArrayList<OnlineData> arrayList = new ArrayList(this.plugin.getPlayerManager().zJnaNCVQSgEShq());
        arrayList.removeIf(onlineData -> {
            return (!((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getMembers().contains(onlineData.getPlayerUUID()) && !onlineData.getPlayerUUID().equals(player.getUniqueId()) && !this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), onlineData.getPlayerUUID()) && this.plugin.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData.getPlayerUUID()) && this.plugin.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData.getPlayerUUID()) && onlineData.getPlayerName().toLowerCase().contains(str.toLowerCase()) && this.plugin.getPlayerManager().b4i2FbOkaKeg91LiAe6l(onlineData.getPlayerUUID())) ? false : true;
        });
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
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getLeader(), title.replace("%search%", "").replace("%amount%", String.valueOf(arrayList.size())))), true))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "clan_search_members_invite", player);
        if (guiData.getItems().containsKey("current")) {
            for (OnlineData onlineData2 : arrayList) {
                GuiItemsData guiItemsData4 = guiData.getItems().get("current");
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData4, onlineData2.getPlayerUUID(), (List<String>) null);
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY4 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent2 -> {
                        try {
                            if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent2.setCancelled(true);
                        if (((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getBanned().contains(onlineData2.getPlayerUUID())) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_IS_BANNED));
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_IS_BANNED_GUI));
                            return;
                        }
                        if (!this.plugin.getPlayerInviteManager().b4i2FbOkaKeg91LiAe6l(onlineData2.getPlayerUUID()) || ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getMembers().contains(onlineData2.getPlayerUUID())) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_BLOCKED_INVITE));
                            return;
                        }
                        if (!this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), "INVITE")) {
                            openClanSearchMembersInvite(player, str, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI));
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                        } else if (this.plugin.getPlayerInviteManager().v8qP8fE86HMhvNuYPFjqY(onlineData2.getPlayerUUID(), ((ClanData) optionalCDW4Fj1iwdIXEOqWjiJSR.get()).getId(), player.getUniqueId())) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_SUCCESS));
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_SUCCESS_GUI));
                        } else {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_ERROR));
                            openClanMembersInvite(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_INVITATION_ERROR_GUI));
                        }
                    }));
                }
            }
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                openClanMembersInvite(player, null);
            }));
        }
        if (guiData.getItems().containsKey("search") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("search")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                openClanSearchMembersInvite(player, "", null);
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent5 -> {
            inventoryClickEvent5.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str2 == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openClanSearchMembersInvite(player, "", null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanStats(Player player, ClanData clanData, String str) {
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
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_stats")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_stats");
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
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(clanData.getLeader(), getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanData.getLeader(), title)), true))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY12 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData12 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData12, itemBuilderV8qP8fE86HMhvNuYPFjqY12.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData12.getClickSound() != null && !guiItemsData12.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData12.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "clan_stats", player);
        if (guiData.getItems().containsKey("foundation") && (itemBuilderV8qP8fE86HMhvNuYPFjqY11 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData11 = guiData.getItems().get("foundation")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData11, itemBuilderV8qP8fE86HMhvNuYPFjqY11.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData11.getClickSound() != null && !guiItemsData11.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData11.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("members") && (itemBuilderV8qP8fE86HMhvNuYPFjqY10 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData10 = guiData.getItems().get("members")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData10, itemBuilderV8qP8fE86HMhvNuYPFjqY10.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData10.getClickSound() != null && !guiItemsData10.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData10.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                this.plugin.getGuiManager().p31abtwfBag2jhMH6K().openClansListMembers(player, clanData.getId(), false);
            }));
        }
        if (guiData.getItems().containsKey("banner") && this.plugin.getIntegrationManager().zJnaNCVQSgEShq().isPresent() && (itemBuilderV8qP8fE86HMhvNuYPFjqY9 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData9 = guiData.getItems().get("banner")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData9, itemBuilderV8qP8fE86HMhvNuYPFjqY9.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData9.getClickSound() != null && !guiItemsData9.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData9.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("kdr") && (itemBuilderV8qP8fE86HMhvNuYPFjqY8 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData8 = guiData.getItems().get("kdr")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData8, itemBuilderV8qP8fE86HMhvNuYPFjqY8.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData8.getClickSound() != null && !guiItemsData8.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData8.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("disputes") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("disputes")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("status") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("status")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("others") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("others")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent8 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent8.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("member_rival_ally") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("member_rival_ally")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent9 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent9.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("limits") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("limits")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent10 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent10.setCancelled(true);
            }));
        }
        if (clanData.getSettings().isOpened() && !getPlugin().getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId()) && !getPlugin().getPlayerManager().xtOheRiObl4QeAl(clanData.getId(), player.getUniqueId()) && !this.plugin.getPlayerManager().vVo2VUvxrriklPdRxI(player.getUniqueId()) && !this.plugin.getPlayerManager().zJnaNCVQSgEShq(clanData.getId(), player.getUniqueId()) && this.plugin.getClanManager().o1VU1x4DAlrEtGKZ3jAdhE(clanData.getId()) && guiData.getItems().containsKey("join") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("join")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent11 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent11.setCancelled(true);
                if (this.plugin.getPlayerManager().Un3NRLL6aWivTcbodkcK(player.getUniqueId(), clanData.getId())) {
                    openClanStats(player, clanData, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_JOIN_SUCCESS_GUI));
                } else {
                    openClanStats(player, clanData, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_JOIN_ERROR_GUI));
                }
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent12 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent12.setCancelled(true);
                if (getPlugin().getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
                    openClanHome(player);
                } else {
                    openNoClanHome(player);
                }
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent13 -> {
            inventoryClickEvent13.setCancelled(true);
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
            openClanStats(player, clanData, null);
        }, 20L);
    }

    public Clans getPlugin() {
        return this.plugin;
    }
}
