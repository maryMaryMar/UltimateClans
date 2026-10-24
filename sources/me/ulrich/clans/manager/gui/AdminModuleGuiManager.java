package me.ulrich.clans.manager.gui;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.Module;
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

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/gui/AdminModuleGuiManager.class */
public class AdminModuleGuiManager {
    private final Clans plugin;

    public AdminModuleGuiManager(Clans clans) {
        this.plugin = clans;
    }

    private void click(Player player, GuiItemsData guiItemsData) {
        try {
            if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
            }
        } catch (Exception e) {
        }
    }

    private void fill(Gui gui, GuiData guiData, String str, Player player, Runnable runnable) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (guiData.getItems().containsKey(str) && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get(str)), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(gui, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                click(player, guiItemsData);
                inventoryClickEvent.setCancelled(true);
                if (runnable != null) {
                    runnable.run();
                }
            }));
        }
    }

    private void fill(PaginatedGui paginatedGui, GuiData guiData, String str, Player player, Runnable runnable) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (guiData.getItems().containsKey(str) && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get(str)), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGui, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                click(player, guiItemsData);
                inventoryClickEvent.setCancelled(true);
                if (runnable != null) {
                    runnable.run();
                }
            }));
        }
    }

    private void open(Gui gui, Player player) {
        gui.setDefaultClickAction(inventoryClickEvent -> {
            inventoryClickEvent.setCancelled(true);
        });
        gui.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        gui.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClansModule(Player player, String str) {
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_module")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_module");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) ? guiData.getTitle() : str))))).rows(guiData.getRows()).create();
        fill(guiCreate, guiData, "fill", player, (Runnable) null);
        fill(guiCreate, guiData, "fill2", player, (Runnable) null);
        fill(guiCreate, guiData, "all", player, () -> {
            openClansModuleAll(player, null);
        });
        fill(guiCreate, guiData, "instaled", player, () -> {
            openClansModuleInstalled(player, null);
        });
        if (guiData.getItems().containsKey("reload") && !CooldownAPI.isInCooldown(this.plugin.getPluginUUID(), "reload")) {
            fill(guiCreate, guiData, "reload", player, () -> {
                Bukkit.dispatchCommand(player, "uclan module reload");
                openClansModule(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_MODULE_RELOAD_WAIT_GUI));
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                    if (player.isOnline()) {
                        openClansModule(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_MODULE_RELOADED_GUI));
                    }
                }, 45L);
            });
        }
        fill(guiCreate, guiData, "back", player, () -> {
            this.plugin.getGuiManager().o1VU1x4DAlrEtGKZ3jAdhE().openAdminHome(player, Optional.empty());
        });
        open(guiCreate, player);
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            if (player.isOnline()) {
                openClansModule(player, null);
            }
        }, 40L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClansModuleAll(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_module_list")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_module_list");
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), ((str == null || !this.plugin.getGuiAPI().useTitleAlerts()) ? guiData.getTitle() : str).replace("{type}", this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_ALL))))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_module_list", player);
        Objects.requireNonNull(paginatedGuiCreate);
        fill(paginatedGuiCreate, guiData, "prev", player, paginatedGuiCreate::previous);
        Objects.requireNonNull(paginatedGuiCreate);
        fill(paginatedGuiCreate, guiData, "next", player, paginatedGuiCreate::next);
        fill(paginatedGuiCreate, guiData, "back", player, () -> {
            openClansModule(player, null);
        });
        if (guiData.getItems().containsKey("current_all")) {
            GuiItemsData guiItemsData2 = guiData.getItems().get("current_all");
            for (ClanEnum.ClansModules clansModules : ClanEnum.ClansModules.values()) {
                boolean zZJnaNCVQSgEShq = new jBWyXxi9EyWxcPiz(this.plugin).zJnaNCVQSgEShq(clansModules.toString());
                Map.Entry<Module, Boolean> entryIZTqZaRK5UGoe0Z = new jBWyXxi9EyWxcPiz(this.plugin).iZTqZaRK5UGoe0Z(clansModules.toString());
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData2, player.getUniqueId(), Arrays.asList("{name};" + String.valueOf(clansModules), "{downloaded};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CLAN_REPO_DOWNLOADED_" + String.valueOf(zZJnaNCVQSgEShq).toUpperCase())), "{state};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entryIZTqZaRK5UGoe0Z != null && entryIZTqZaRK5UGoe0Z.getValue().booleanValue()).toUpperCase()))));
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY2 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent2 -> {
                        click(player, guiItemsData2);
                        inventoryClickEvent2.setCancelled(true);
                        if (inventoryClickEvent2.getClick() == ClickType.LEFT) {
                            if (new jBWyXxi9EyWxcPiz(this.plugin).zJnaNCVQSgEShq(clansModules.toString())) {
                                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_MODULE_ALREADY_DOWNLOADED));
                                return;
                            }
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED));
                            openClansModuleAll(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED_GUI));
                            this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY((CommandSender) player, clansModules, false, false);
                        }
                    }));
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent3 -> {
            inventoryClickEvent3.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            if (player.isOnline()) {
                openClansModuleAll(player, null);
            }
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClansModuleInstalled(Player player, String str) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_module_list")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_module_list");
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), ((str == null || !this.plugin.getGuiAPI().useTitleAlerts()) ? guiData.getTitle() : str).replace("{type}", this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_INSTALED))))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_module_list", player);
        Objects.requireNonNull(paginatedGuiCreate);
        fill(paginatedGuiCreate, guiData, "prev", player, paginatedGuiCreate::previous);
        Objects.requireNonNull(paginatedGuiCreate);
        fill(paginatedGuiCreate, guiData, "next", player, paginatedGuiCreate::next);
        fill(paginatedGuiCreate, guiData, "back", player, () -> {
            openClansModule(player, null);
        });
        if (guiData.getItems().containsKey("current_instaled")) {
            GuiItemsData guiItemsData2 = guiData.getItems().get("current_instaled");
            for (Map.Entry<Module, Boolean> entry : this.plugin.getModuleEnabledList().entrySet()) {
                Module key = entry.getKey();
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData2, player.getUniqueId(), Arrays.asList("{name};" + key.getName(), "{status};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("CLAN_REPO_STATE_" + String.valueOf(entry.getValue()).toUpperCase())), "{author};" + String.valueOf(key.getAuthor()), "{version};" + String.valueOf(key.getVersion()), "{description};" + String.valueOf(key.getDescription()), "{require};" + String.valueOf(key.getRequire())));
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY2 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent2 -> {
                        click(player, guiItemsData2);
                        inventoryClickEvent2.setCancelled(true);
                        if (inventoryClickEvent2.getClick() == ClickType.LEFT) {
                            try {
                                ClanEnum.ClansModules clansModulesValueOf = ClanEnum.ClansModules.valueOf(key.getName());
                                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED));
                                openClansModuleInstalled(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_REPO_DOWNLOAD_STARTED_GUI));
                                this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY((CommandSender) player, clansModulesValueOf, true, false);
                            } catch (IllegalArgumentException e) {
                                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_MODULE_NOT_EXIST));
                            }
                        }
                    }));
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent3 -> {
            inventoryClickEvent3.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            if (player.isOnline()) {
                openClansModuleInstalled(player, null);
            }
        }, 20L);
    }
}
