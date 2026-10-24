package me.ulrich.clans.manager.gui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.Extension;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.jBWyXxi9EyWxcPiz;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/gui/AdminExtensionGuiManager.class */
public class AdminExtensionGuiManager {
    private final Clans plugin;

    public AdminExtensionGuiManager(Clans clans) {
        this.plugin = clans;
    }

    public Clans getPlugin() {
        return this.plugin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClansExtension(Player player, String str) {
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
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_extension")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_extension");
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
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
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
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
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
        if (guiData.getItems().containsKey("all") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("all")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                openClansExtension_all(player, null);
            }));
        }
        if (guiData.getItems().containsKey("instaled") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("instaled")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                openClansExtension_instaled(player, null);
            }));
        }
        if (guiData.getItems().containsKey("reload") && !CooldownAPI.isInCooldown(this.plugin.getPluginUUID(), "reload") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("reload")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                Bukkit.dispatchCommand(player, "uclan extension reload");
                openClansExtension(player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_EXTENSION_RELOAD_WAIT_GUI));
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                    openClansExtension(player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_EXTENSION_RELOADED_GUI, Arrays.asList("%time%;Xs")));
                }, 40L);
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
                this.plugin.getGuiManager().o1VU1x4DAlrEtGKZ3jAdhE().openAdminHome(player, Optional.empty());
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
            openClansExtension(player, null);
        }, 40L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClansExtension_all(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_extension_list")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_extension_list");
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
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), title.replace("{type}", this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_ALL))))))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_extension_list", player);
        if (guiData.getItems().containsKey("prev") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("prev")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                openClansExtension(player, null);
            }));
        }
        if (guiData.getItems().containsKey("current_all")) {
            for (ClanEnum.ClansExtensions clansExtensions : Arrays.asList(ClanEnum.ClansExtensions.values())) {
                GuiItemsData guiItemsData5 = guiData.getItems().get("current_all");
                boolean zZwrsrwOCXRUscW6Q = new jBWyXxi9EyWxcPiz(this.plugin).ZwrsrwOCXRUscW6Q(clansExtensions.toString());
                Map.Entry<Extension, Boolean> entryV8qP8fE86HMhvNuYPFjqY = new jBWyXxi9EyWxcPiz(this.plugin).v8qP8fE86HMhvNuYPFjqY(clansExtensions.toString());
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData5, player.getUniqueId(), Arrays.asList("{name};" + clansExtensions.toString(), "{downloaded};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CLAN_REPO_DOWNLOADED_" + String.valueOf(zZwrsrwOCXRUscW6Q).toUpperCase())), "{state};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entryV8qP8fE86HMhvNuYPFjqY != null ? entryV8qP8fE86HMhvNuYPFjqY.getValue().booleanValue() : false).toUpperCase()))));
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY5 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent5 -> {
                        try {
                            if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent5.setCancelled(true);
                        if (inventoryClickEvent5.getClick().equals(ClickType.LEFT)) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED));
                            openClansExtension_all(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED_GUI));
                            this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY((CommandSender) player, clansExtensions, false, false);
                        }
                    }));
                }
            }
        }
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
            openClansExtension_all(player, null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClansExtension_instaled(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_extension_list")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_extension_list");
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
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(getPlugin().getColorManager().ZwrsrwOCXRUscW6Q(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), title.replace("{type}", this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_INSTALED))))))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_extension_list", player);
        if (guiData.getItems().containsKey("prev") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("prev")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                openClansExtension(player, null);
            }));
        }
        if (guiData.getItems().containsKey("current_instaled")) {
            for (Map.Entry<Extension, Boolean> entry : this.plugin.getExtensionEnabledList().entrySet()) {
                GuiItemsData guiItemsData5 = guiData.getItems().get("current_instaled");
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData5, player.getUniqueId(), Arrays.asList("{name};" + entry.getKey().getName(), "{status};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entry.getValue()).toUpperCase())), "{author};" + entry.getKey().getAuthor(), "{version};" + entry.getKey().getVersion(), "{description};" + entry.getKey().getDescription(), "{category};None"));
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY5 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent5 -> {
                        try {
                            if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent5.setCancelled(true);
                        if (inventoryClickEvent5.getClick().equals(ClickType.LEFT)) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED));
                            openClansExtension_instaled(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED_GUI));
                            try {
                                this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY((CommandSender) player, ClanEnum.ClansExtensions.valueOf(((Extension) entry.getKey()).getName()), true, false);
                            } catch (Exception e3) {
                            }
                        }
                    }));
                }
            }
        }
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
            openClansExtension_instaled(player, null);
        }, 20L);
    }
}
