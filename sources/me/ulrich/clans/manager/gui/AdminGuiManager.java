package me.ulrich.clans.manager.gui;

import com.google.common.base.Stopwatch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.Addon;
import me.ulrich.clans.data.AddonInfo;
import me.ulrich.clans.data.AddonList;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CustomChatPrompt;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.interfaces.MultiserverModuleAPI;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.EnumFiles.Config;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.qjkRaOgynIj1.jfN3Uc9ymXXFWVHj7Oor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.Plugin;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/gui/AdminGuiManager.class */
public class AdminGuiManager {
    private Clans plugin;
    private final ConcurrentHashMap<UUID, Boolean> storageTestResults = new ConcurrentHashMap<>();

    public AdminGuiManager(Clans clans) {
        this.plugin = clans;
    }

    private void playClick(Player player, GuiItemsData guiItemsData) {
        try {
            if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
            }
        } catch (Exception e) {
        }
    }

    private void addActionItem(Gui gui, GuiData guiData, String str, Player player, UUID uuid, List<String> list, Consumer<InventoryClickEvent> consumer) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (guiData.getItems().containsKey(str) && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get(str)), uuid, list)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(gui, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                playClick(player, guiItemsData);
                inventoryClickEvent.setCancelled(true);
                if (consumer != null) {
                    consumer.accept(inventoryClickEvent);
                }
            }));
        }
    }

    private String state(Player player, boolean z) {
        return this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(z ? Lang.STATE_TRUE : Lang.STATE_FALSE);
    }

    private List<String> diagnosticHookNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList("PlaceholderAPI", "NBTAPI", "SkinsRestorer", "EntityWizard", "RedisChat", "CombatLogX", "PvPManager", "Duels", "CMI", "Essentials", "SuperVanish", "PremiumVanish"));
        for (ClanEnum.ClansExtensions clansExtensions : ClanEnum.ClansExtensions.values()) {
            linkedHashSet.add(clansExtensions.getPluginName());
        }
        return new ArrayList(linkedHashSet);
    }

    private int enabledHookCount() {
        int i = 0;
        Iterator<String> it = diagnosticHookNames().iterator();
        while (it.hasNext()) {
            if (Bukkit.getPluginManager().isPluginEnabled(it.next())) {
                i++;
            }
        }
        return i;
    }

    private String pluginVersion(String str) {
        try {
            Plugin plugin = Bukkit.getPluginManager().getPlugin(str);
            return plugin == null ? "-" : plugin.getDescription().getVersion();
        } catch (Exception e) {
            return "-";
        }
    }

    private String[] multiserverData(Player player) {
        String strState = state(player, false);
        String[] strArr = {strState, strState, "-", "-", "-"};
        try {
            Optional<MultiserverModuleAPI> optionalP31abtwfBag2jhMH6K = this.plugin.getIntegrationManager().p31abtwfBag2jhMH6K();
            if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
                return strArr;
            }
            MultiserverModuleAPI multiserverModuleAPI = optionalP31abtwfBag2jhMH6K.get();
            strArr[0] = state(player, true);
            strArr[1] = state(player, multiserverModuleAPI.syncEnabled());
            strArr[2] = String.valueOf(multiserverModuleAPI.getServerName());
            strArr[3] = String.valueOf(multiserverModuleAPI.getInComingChannel());
            strArr[4] = String.valueOf(multiserverModuleAPI.getOutGoindChannel());
        } catch (Exception e) {
        }
        return strArr;
    }

    private List<String> adminStatusReplacements(Player player) {
        String upperCase = this.plugin.getPluginStorage() == null ? this.plugin.getFiles().VkPRYe34Awk6AdSxoUC().getString("Storage.type").toUpperCase() : this.plugin.getPluginStorage().toString();
        String upperCase2 = this.plugin.getFiles().VkPRYe34Awk6AdSxoUC().getString("Storage.type").toUpperCase();
        String string = "YAML files";
        String str = "-";
        if ("MYSQL".equalsIgnoreCase(upperCase2)) {
            string = this.plugin.getFiles().VkPRYe34Awk6AdSxoUC().getString("Storage.mysql.base");
            str = this.plugin.getFiles().VkPRYe34Awk6AdSxoUC().getString("Storage.mysql.host") + ":" + this.plugin.getFiles().VkPRYe34Awk6AdSxoUC().getInt("Storage.mysql.port");
        } else if ("SQLITE".equalsIgnoreCase(upperCase2)) {
            string = "storage/sqlite/clans.db";
        }
        String[] strArrMultiserverData = multiserverData(player);
        List<String> listDiagnosticHookNames = diagnosticHookNames();
        Boolean bool = this.storageTestResults.get(player.getUniqueId());
        String strState = bool == null ? "<yellow>NOT TESTED" : state(player, bool.booleanValue());
        ArrayList arrayList = new ArrayList();
        arrayList.add("{core_version};" + this.plugin.getDescription().getVersion());
        arrayList.add("{loaded};" + state(player, this.plugin.isLoaded()));
        arrayList.add("{language};" + this.plugin.getLanguage());
        arrayList.add("{timezone};" + this.plugin.getTimeZone());
        arrayList.add("{server_version};" + Bukkit.getBukkitVersion());
        arrayList.add("{java_version};" + System.getProperty("java.version", "-"));
        arrayList.add("{online};" + Bukkit.getOnlinePlayers().size());
        arrayList.add("{max_players};" + Bukkit.getMaxPlayers());
        arrayList.add("{folia};" + state(player, this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()));
        arrayList.add("{clans};" + this.plugin.getClanManager().iZTqZaRK5UGoe0Z().size());
        arrayList.add("{players};" + this.plugin.getPlayerManager().xtOheRiObl4QeAl().size());
        arrayList.add("{storage};" + upperCase);
        arrayList.add("{configured_type};" + upperCase2);
        arrayList.add("{database};" + string);
        arrayList.add("{host};" + str);
        arrayList.add("{pool};" + this.plugin.getFiles().VkPRYe34Awk6AdSxoUC().getInt("Storage.mysql.maximumPoolSize"));
        arrayList.add("{modules};" + this.plugin.getModuleManager().getModules().size());
        arrayList.add("{extensions};" + this.plugin.getExtensionManager().getExtensions().size());
        arrayList.add("{addons};" + this.plugin.getAddonEnabledList().size());
        arrayList.add("{multiserver};" + strArrMultiserverData[0]);
        arrayList.add("{sync};" + strArrMultiserverData[1]);
        arrayList.add("{network_server};" + strArrMultiserverData[2]);
        arrayList.add("{incoming};" + strArrMultiserverData[3]);
        arrayList.add("{outgoing};" + strArrMultiserverData[4]);
        arrayList.add("{hooks_enabled};" + enabledHookCount());
        arrayList.add("{hooks_total};" + listDiagnosticHookNames.size());
        int size = 0;
        try {
            size = this.plugin.getFiles().hqTnbBoUmxDUXvki().size();
        } catch (Exception e) {
        }
        arrayList.add("{languages};" + size);
        arrayList.add("{test_state};" + strState);
        return arrayList;
    }

    private void toggleConfigBoolean(Player player, String str, Runnable runnable) {
        try {
            FileConfiguration fileConfigurationP31abtwfBag2jhMH6K = this.plugin.getFiles().p31abtwfBag2jhMH6K();
            fileConfigurationP31abtwfBag2jhMH6K.set(str, Boolean.valueOf(!fileConfigurationP31abtwfBag2jhMH6K.getBoolean(str)));
            this.plugin.getFiles().b4i2FbOkaKeg91LiAe6l().get("config").save();
            if (runnable != null) {
                runnable.run();
            }
        } catch (Exception e) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_START_ACTION));
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    private void addConfigToggle(Gui gui, GuiData guiData, String str, Player player, String str2) {
        addActionItem(gui, guiData, str, player, player.getUniqueId(), Arrays.asList("{state};" + state(player, this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean(str2))), inventoryClickEvent -> {
            toggleConfigBoolean(player, str2, () -> {
                openAdminSettings(player);
            });
        });
    }

    private void testStorage(Player player) {
        player.closeInventory();
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskAsynchronously(() -> {
            boolean zIZTqZaRK5UGoe0Z = false;
            try {
                zIZTqZaRK5UGoe0Z = this.plugin.getDatabaseManager().iZTqZaRK5UGoe0Z();
            } catch (Exception e) {
            }
            this.storageTestResults.put(player.getUniqueId(), Boolean.valueOf(zIZTqZaRK5UGoe0Z));
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                if (player.isOnline()) {
                    openAdminStorage(player);
                }
            });
        });
    }

    private void executeAdminCommand(Player player, String str, Runnable runnable) {
        executeAdminCommand(player, str, runnable, 2L);
    }

    private void executeAdminCommand(Player player, String str, Runnable runnable, long j) {
        player.closeInventory();
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
            Bukkit.dispatchCommand(player, str);
        });
        if (runnable != null) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                if (player.isOnline()) {
                    runnable.run();
                }
            }, Math.max(1L, j));
        }
    }

    private void requestAdminInput(Player player, Optional<String> optional, Consumer<String> consumer, Runnable runnable) {
        player.closeInventory();
        if (this.plugin.getAnvilGuiManager().v8qP8fE86HMhvNuYPFjqY(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ADMIN_GUI_INPUT_TITLE), optional, consumer, runnable)) {
            return;
        }
        if (this.plugin.getChatManager().v8qP8fE86HMhvNuYPFjqY(player, new CustomChatPrompt.Builder().setDuration(60).setChatMessages(this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getStringList(Lang.ADMIN_GUI_INPUT_MESSAGE)).onResponse((player2, str) -> {
            if (consumer != null) {
                consumer.accept(str == null ? "" : str.trim());
            }
        }).onCancel(player3 -> {
            MessageUtils.sendText((CommandSender) player3, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player3.getUniqueId())).getString(Lang.ADMIN_GUI_INPUT_CANCELLED));
            if (runnable != null) {
                runnable.run();
            }
        }).build())) {
            return;
        }
        MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_START_ACTION));
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminHome(Player player, Optional<String> optional) {
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
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_home")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_home");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = optional.get();
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getHooksAPI().parsePapi(player, this.plugin.getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY13 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData13 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData13, itemBuilderV8qP8fE86HMhvNuYPFjqY13.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData13.getClickSound() != null && !guiItemsData13.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData13.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY12 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData12 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData12, itemBuilderV8qP8fE86HMhvNuYPFjqY12.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData12.getClickSound() != null && !guiItemsData12.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData12.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_home", player);
        if (guiData.getItems().containsKey("extensions") && (itemBuilderV8qP8fE86HMhvNuYPFjqY11 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData11 = guiData.getItems().get("extensions")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData11, itemBuilderV8qP8fE86HMhvNuYPFjqY11.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData11.getClickSound() != null && !guiItemsData11.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData11.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                this.plugin.getGuiManager().vVo2VUvxrriklPdRxI().openClansExtension(player, null);
            }));
        }
        if (guiData.getItems().containsKey("modules") && (itemBuilderV8qP8fE86HMhvNuYPFjqY10 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData10 = guiData.getItems().get("modules")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData10, itemBuilderV8qP8fE86HMhvNuYPFjqY10.asGuiItem(inventoryClickEvent4 -> {
                playClick(player, guiItemsData10);
                inventoryClickEvent4.setCancelled(true);
                this.plugin.getGuiManager().Fc3p9FhCjSD1k5Ra4().openClansModule(player, null);
            }));
        }
        if (guiData.getItems().containsKey("addons") && (itemBuilderV8qP8fE86HMhvNuYPFjqY9 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData9 = guiData.getItems().get("addons")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData9, itemBuilderV8qP8fE86HMhvNuYPFjqY9.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData9.getClickSound() != null && !guiItemsData9.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData9.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openAdminAddons(player, Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("languages") && (itemBuilderV8qP8fE86HMhvNuYPFjqY8 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData8 = guiData.getItems().get("languages")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData8, itemBuilderV8qP8fE86HMhvNuYPFjqY8.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData8.getClickSound() != null && !guiItemsData8.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData8.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                openAdminLanguages(player, Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("wizard") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("wizard")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                guiCreate.close(player);
                visitUrl(player, "https://github.com/UlrichBR/EntityWizard");
            }));
        }
        if (guiData.getItems().containsKey("clans") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("clans")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent8 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent8.setCancelled(true);
                openAdminClansHome(player, 1, Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("players") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("players")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent9 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent9.setCancelled(true);
                openAdminPlayersHome(player, 1, Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("globalff") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("globalff")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent10 -> {
                playClick(player, guiItemsData4);
                inventoryClickEvent10.setCancelled(true);
                executeAdminCommand(player, "uclan globalff", () -> {
                    openAdminHome(player, Optional.empty());
                });
            }));
        }
        if (guiData.getItems().containsKey("chatspy")) {
            GuiItemsData guiItemsData14 = guiData.getItems().get("chatspy");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY14 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData14, player.getUniqueId(), Arrays.asList("{state};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("STATE_" + String.valueOf(this.plugin.getClanManager().p31abtwfBag2jhMH6K().contains(player.getUniqueId())).toUpperCase()))));
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY14 != null) {
                this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData14, itemBuilderV8qP8fE86HMhvNuYPFjqY14.asGuiItem(inventoryClickEvent11 -> {
                    playClick(player, guiItemsData14);
                    inventoryClickEvent11.setCancelled(true);
                    executeAdminCommand(player, "uclan chatspy", () -> {
                        openAdminHome(player, Optional.empty());
                    });
                }));
            }
        }
        addActionItem(guiCreate, guiData, "server", player, player.getUniqueId(), null, inventoryClickEvent12 -> {
            openAdminServer(player);
        });
        addActionItem(guiCreate, guiData, "storage", player, player.getUniqueId(), null, inventoryClickEvent13 -> {
            openAdminStorage(player);
        });
        addActionItem(guiCreate, guiData, "diagnostics", player, player.getUniqueId(), null, inventoryClickEvent14 -> {
            openAdminDiagnostics(player);
        });
        addActionItem(guiCreate, guiData, "settings", player, player.getUniqueId(), null, inventoryClickEvent15 -> {
            openAdminSettings(player);
        });
        addActionItem(guiCreate, guiData, "maintenance", player, player.getUniqueId(), null, inventoryClickEvent16 -> {
            openAdminMaintenance(player);
        });
        if (guiData.getItems().containsKey("reload") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("reload")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent17 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent17.setCancelled(true);
                guiCreate.close(player);
                Stopwatch stopwatchCreateStarted = Stopwatch.createStarted();
                new CooldownAPI(this.plugin.getPluginUUID(), "reload", 4).start();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lU&9&lClans &7| &cPlease wait, the plugin is restarting and this may take a few seconds."));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', " &7- Reloading a working plugin can cause delays and this can cause instability for users who are using the plugin."));
                this.plugin.pluginDisable(false);
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater(() -> {
                    this.plugin.pluginEnable();
                    stopwatchCreateStarted.stop();
                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLUGIN_RELOADED, Arrays.asList("%time%;" + String.valueOf(stopwatchCreateStarted))));
                }, 30L);
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent18 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent18.setCancelled(true);
                this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
            }));
        }
        if (guiData.getItems().containsKey("help") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("help")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent19 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent19.setCancelled(true);
                if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                    this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                        player.closeInventory();
                    }, 2L);
                } else {
                    guiCreate.close(player);
                }
                player.chat("/uclans help");
            }));
        }
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openAdminHome(player, Optional.empty());
            }, 20L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminAddons(Player player, Optional<String> optional) {
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
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_addons_home")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_addons_home");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = optional.get();
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getHooksAPI().parsePapi(player, this.plugin.getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_addons_home", player);
        Arrays.asList(AddonList.values()).iterator().forEachRemaining(addonList -> {
            Optional<Map.Entry<Addon, AddonInfo>> optionalFindFirst = this.plugin.getAddonEnabledList().entrySet().stream().filter(entry -> {
                return ((Addon) entry.getKey()).getName().equalsIgnoreCase(addonList.getName());
            }).findFirst();
            if (guiData.getItems().containsKey("current" + (optionalFindFirst.isPresent() ? "_instaled" : ""))) {
                GuiItemsData guiItemsData7 = guiData.getItems().get("current" + (optionalFindFirst.isPresent() ? "_instaled" : ""));
                GuiItemsData guiItemsDataM427clone = guiItemsData7.m427clone();
                guiItemsDataM427clone.setMaterial(addonList.getIcon());
                if (addonList.getIconTexture() != null && !addonList.getIconTexture().isEmpty()) {
                    guiItemsDataM427clone.setTexture(addonList.getIconTexture());
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add("{description};" + addonList.getDescription());
                arrayList.add("{download_url};" + addonList.getDownloadUrl());
                arrayList.add("{long_description};" + addonList.getLongDescription());
                arrayList.add("{name};" + addonList.getName());
                arrayList.add("{price};" + String.valueOf(addonList.getPrice()));
                if (optionalFindFirst.isPresent()) {
                    arrayList.add("{instaled};<green>True");
                    arrayList.add("{enabled};<yellow>" + String.valueOf(optionalFindFirst.get().getValue().isEnabled()).toUpperCase());
                    arrayList.add("{version};" + optionalFindFirst.get().getKey().getVersion());
                } else {
                    arrayList.add("{instaled};<red>False");
                    arrayList.add("{enabled};<green>False");
                    arrayList.add("{version};" + addonList.getVersion());
                }
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsDataM427clone, player.getUniqueId(), arrayList);
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY7 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent2 -> {
                        try {
                            if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent2.setCancelled(true);
                        if (!optionalFindFirst.isPresent()) {
                            paginatedGuiCreate.close(player);
                            visitUrl(player, addonList.getDownloadUrl());
                            return;
                        }
                        try {
                            Addon addon = (Addon) ((Map.Entry) optionalFindFirst.get()).getKey();
                            AddonInfo addonInfo = (AddonInfo) ((Map.Entry) optionalFindFirst.get()).getValue();
                            if (inventoryClickEvent2.getClick() == ClickType.RIGHT || inventoryClickEvent2.getClick() == ClickType.SHIFT_RIGHT) {
                                if (addon.isEnabled()) {
                                    addon.disable();
                                } else {
                                    addon.enable(addon.getInstance(), addon.getAddonDataFolder(), addon.getDataSerializer(), addon.getConfigSerializer());
                                }
                                addonInfo.setEnabled(addon.isEnabled());
                                openAdminAddons(player, Optional.empty());
                                return;
                            }
                            if (inventoryClickEvent2.getClick() == ClickType.LEFT || inventoryClickEvent2.getClick() == ClickType.SHIFT_LEFT) {
                                if (addon.isEnabled()) {
                                    addon.disable();
                                }
                                addon.enable(addon.getInstance(), addon.getAddonDataFolder(), addon.getDataSerializer(), addon.getConfigSerializer());
                                addonInfo.setEnabled(addon.isEnabled());
                                openAdminAddons(player, Optional.empty());
                            }
                        } catch (Exception e3) {
                            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_START_ACTION));
                        }
                    }));
                }
            }
        });
        if (guiData.getItems().containsKey("reload") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("reload")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent2 -> {
                playClick(player, guiItemsData5);
                inventoryClickEvent2.setCancelled(true);
                player.closeInventory();
                Bukkit.dispatchCommand(player, "uclan reloadaddons");
                this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                    if (player.isOnline()) {
                        openAdminAddons(player, Optional.empty());
                    }
                }, 40L);
            }));
        }
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openAdminHome(player, Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("more") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("more")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                paginatedGuiCreate.close(player);
                visitUrl(player, "https://voxel.shop/shop/99/tribecraft");
            }));
        }
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openAdminAddons(player, Optional.empty());
            }, 20L);
        }
    }

    private void visitUrl(Player player, String str) {
        MessageUtils.sendText((CommandSender) player, " ");
        MessageUtils.sendText((CommandSender) player, "<gradient:blue:aqua>████████████████████████████████</gradient>");
        MessageUtils.sendText((CommandSender) player, " ");
        MessageUtils.sendText((CommandSender) player, " <yellow>Visit the official <gradient:blue:aqua>Ultimate Store</gradient><yellow>: ");
        MessageUtils.sendText((CommandSender) player, " ");
        MessageUtils.sendText((CommandSender) player, " <green><click:open_url:" + str + ">Visit: " + str + "</click>");
        MessageUtils.sendText((CommandSender) player, " <yellow>or <aqua><click:copy_to_clipboard:" + str + ">[Click to Copy Url]</click>");
        MessageUtils.sendText((CommandSender) player, " ");
        MessageUtils.sendText((CommandSender) player, " <yellow>There you will find other compatible addons as well as incredible plugins to enhance your server!");
        MessageUtils.sendText((CommandSender) player, " ");
        MessageUtils.sendText((CommandSender) player, "<gradient:blue:aqua>████████████████████████████████</gradient>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminLanguages(Player player, Optional<String> optional) {
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
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_languages")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_languages");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = guiData.getTitle();
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            title = optional.get();
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getHooksAPI().parsePapi(player, this.plugin.getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
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
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_languages", player);
        this.plugin.getFiles().hqTnbBoUmxDUXvki().forEach(str -> {
            if (guiData.getItems().containsKey("current")) {
                GuiItemsData guiItemsData6 = guiData.getItems().get("current");
                GuiItemsData guiItemsDataM427clone = guiItemsData6.m427clone();
                if (!guiItemsDataM427clone.getTexture().isEmpty()) {
                    guiItemsDataM427clone.setTexture(guiItemsDataM427clone.getTexture().replace("{id}", str.toUpperCase()));
                }
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsDataM427clone, player.getUniqueId(), Arrays.asList("{id};" + str.toUpperCase()));
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY6 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent2 -> {
                        try {
                            if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent2.setCancelled(true);
                        this.plugin.getFiles().CDW4Fj1iwdIXEOqWjiJSR().get("config").set(Config.CONFIG_language, str);
                        this.plugin.setLanguage(str);
                        openAdminLanguages(player, Optional.of(this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLUGIN_LANG_RELOADED_GUI)));
                    }));
                }
            }
        });
        if (guiData.getItems().containsKey("language") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("language")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
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
                paginatedGuiCreate.previous();
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
                paginatedGuiCreate.next();
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
                openAdminHome(player, Optional.empty());
            }));
        }
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openAdminLanguages(player, Optional.empty());
            }, 20L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminClansHome(Player player, int i, Optional<String> optional) {
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
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_clans_home")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_clans_home");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        if (i < 1) {
            i = 1;
        }
        int i2 = i;
        jfN3Uc9ymXXFWVHj7Oor jfn3uc9ymxxfwvhj7oor = new jfN3Uc9ymXXFWVHj7Oor(new ArrayList(this.plugin.getClanManager().iZTqZaRK5UGoe0Z()), guiData.getPageSize());
        jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY(i2);
        String strReplace = guiData.getTitle().replace("{page}", String.valueOf(i2)).replace("{pages}", String.valueOf(jfn3uc9ymxxfwvhj7oor.zJnaNCVQSgEShq()));
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            strReplace = optional.get();
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), strReplace))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_clans_home", player);
        if (guiData.getItems().containsKey("current")) {
            Iterator<Object> it = jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY().iterator();
            while (it.hasNext()) {
                UUID uuid = (UUID) it.next();
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid);
                if (optionalIZTqZaRK5UGoe0Z.isPresent()) {
                    UUID leader = optionalIZTqZaRK5UGoe0Z.get().getLeader();
                    GuiItemsData guiItemsData6 = guiData.getItems().get("current");
                    ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData6, leader, (List<String>) null);
                    if (itemBuilderV8qP8fE86HMhvNuYPFjqY6 != null) {
                        paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent2 -> {
                            playClick(player, guiItemsData6);
                            inventoryClickEvent2.setCancelled(true);
                            openAdminClansEdit(player, uuid, i2, Optional.empty());
                        }));
                    }
                }
            }
        }
        if (guiData.getItems().containsKey("search") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("search")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                playClick(player, guiItemsData4);
                inventoryClickEvent3.setCancelled(true);
                requestAdminInput(player, Optional.of("Clan"), str -> {
                    Optional<ClanData> optionalJBUuLP0sWwaPyPOmogdX7l = this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(str);
                    if (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
                        optionalJBUuLP0sWwaPyPOmogdX7l = this.plugin.getPlayerManager().iZTqZaRK5UGoe0Z(str);
                    }
                    if (optionalJBUuLP0sWwaPyPOmogdX7l.isPresent()) {
                        openAdminClansEdit(player, optionalJBUuLP0sWwaPyPOmogdX7l.get().getId(), i2, Optional.empty());
                    } else {
                        MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_NOT_FOUND));
                        openAdminClansHome(player, i2, Optional.empty());
                    }
                }, () -> {
                    openAdminClansHome(player, i2, Optional.empty());
                });
            }));
        }
        if (guiData.getItems().containsKey("previous") && jfn3uc9ymxxfwvhj7oor.ZwrsrwOCXRUscW6Q() && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent4 -> {
                playClick(player, guiItemsData3);
                inventoryClickEvent4.setCancelled(true);
                openAdminClansHome(player, jfn3uc9ymxxfwvhj7oor.xtOheRiObl4QeAl(), Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("next") && jfn3uc9ymxxfwvhj7oor.jBUuLP0sWwaPyPOmogdX7l() && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                playClick(player, guiItemsData2);
                inventoryClickEvent5.setCancelled(true);
                openAdminClansHome(player, jfn3uc9ymxxfwvhj7oor.iZTqZaRK5UGoe0Z(), Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent6 -> {
                playClick(player, guiItemsData);
                inventoryClickEvent6.setCancelled(true);
                openAdminHome(player, Optional.empty());
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent7 -> {
            inventoryClickEvent7.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openAdminClansHome(player, i2, Optional.empty());
            }, 20L);
        }
    }

    public void openAdminClansEdit(Player player, UUID uuid, Optional<String> optional) {
        openAdminClansEdit(player, uuid, 1, optional);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminClansEdit(Player player, UUID uuid, int i, Optional<String> optional) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_NOT_FOUND));
            openAdminClansHome(player, Math.max(1, i), Optional.empty());
            return;
        }
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_clan_edit")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        ClanData clanData = optionalIZTqZaRK5UGoe0Z.get();
        UUID leader = clanData.getLeader();
        String tagNoColor = clanData.getTagNoColor();
        int iMax = Math.max(1, i);
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_clan_edit");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(leader, (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) ? optional.get() : guiData.getTitle()))))).rows(guiData.getRows()).create();
        for (String str : Arrays.asList("fill", "fill2")) {
            if (guiData.getItems().containsKey(str) && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get(str)), (UUID) null, (List<String>) null)) != null) {
                this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent -> {
                    inventoryClickEvent.setCancelled(true);
                }));
            }
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_clan_edit", player);
        addActionItem(guiCreate, guiData, "info", player, leader, null, inventoryClickEvent2 -> {
        });
        addActionItem(guiCreate, guiData, "changetag", player, leader, null, inventoryClickEvent3 -> {
            requestAdminInput(player, Optional.of(tagNoColor), str2 -> {
                executeAdminCommand(player, "uclan changetag " + tagNoColor + " " + str2, () -> {
                    openAdminClansEdit(player, uuid, iMax, Optional.empty());
                });
            }, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addActionItem(guiCreate, guiData, "verify", player, leader, null, inventoryClickEvent4 -> {
            executeAdminCommand(player, "uclan verify " + tagNoColor, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addActionItem(guiCreate, guiData, "setleader", player, leader, null, inventoryClickEvent5 -> {
            requestAdminInput(player, Optional.of("Player"), str2 -> {
                executeAdminCommand(player, "uclan setleader " + tagNoColor + " " + str2, () -> {
                    openAdminClansEdit(player, uuid, iMax, Optional.empty());
                });
            }, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addNumericClanAction(guiCreate, guiData, "addpoints", player, leader, uuid, iMax, tagNoColor, "addpoints");
        addNumericClanAction(guiCreate, guiData, "setpoints", player, leader, uuid, iMax, tagNoColor, "setpoints");
        addNumericClanAction(guiCreate, guiData, "removepoints", player, leader, uuid, iMax, tagNoColor, "removepoints");
        addNumericClanAction(guiCreate, guiData, "addslot", player, leader, uuid, iMax, tagNoColor, "addslot");
        addNumericClanAction(guiCreate, guiData, "setslot", player, leader, uuid, iMax, tagNoColor, "setslot");
        addNumericClanAction(guiCreate, guiData, "removeslot", player, leader, uuid, iMax, tagNoColor, "removeslot");
        addActionItem(guiCreate, guiData, "bank_view", player, leader, null, inventoryClickEvent6 -> {
            executeAdminCommand(player, "uclan bank view " + tagNoColor, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addBankAction(guiCreate, guiData, "bank_add", player, leader, uuid, iMax, tagNoColor, "add");
        addBankAction(guiCreate, guiData, "bank_set", player, leader, uuid, iMax, tagNoColor, "set");
        addBankAction(guiCreate, guiData, "bank_remove", player, leader, uuid, iMax, tagNoColor, "remove");
        addActionItem(guiCreate, guiData, "members", player, leader, null, inventoryClickEvent7 -> {
            openAdminClanMembers(player, uuid, iMax);
        });
        addActionItem(guiCreate, guiData, "allies", player, leader, null, inventoryClickEvent8 -> {
            openAdminClanRelations(player, uuid, true, iMax);
        });
        addActionItem(guiCreate, guiData, "rivals", player, leader, null, inventoryClickEvent9 -> {
            openAdminClanRelations(player, uuid, false, iMax);
        });
        addActionItem(guiCreate, guiData, "kick", player, leader, null, inventoryClickEvent10 -> {
            requestAdminInput(player, Optional.of("Player"), str2 -> {
                executeAdminCommand(player, "uclan kick " + tagNoColor + " " + str2, () -> {
                    openAdminClansEdit(player, uuid, iMax, Optional.empty());
                });
            }, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addActionItem(guiCreate, guiData, "resetkdr", player, leader, null, inventoryClickEvent11 -> {
            openAdminConfirm(player, leader, "Reset Clan KDR", () -> {
                executeAdminCommand(player, "uclan resetclankdr " + tagNoColor, () -> {
                    openAdminClansEdit(player, uuid, iMax, Optional.empty());
                });
            }, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addActionItem(guiCreate, guiData, "delete", player, leader, null, inventoryClickEvent12 -> {
            openAdminConfirm(player, leader, "Delete " + tagNoColor, () -> {
                executeAdminCommand(player, "uclan delete " + tagNoColor, () -> {
                    openAdminClansHome(player, iMax, Optional.empty());
                });
            }, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            });
        });
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), leader, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent13 -> {
                playClick(player, guiItemsData);
                inventoryClickEvent13.setCancelled(true);
                openAdminClansHome(player, iMax, Optional.empty());
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent14 -> {
            inventoryClickEvent14.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openAdminClansEdit(player, uuid, iMax, Optional.empty());
            }, 20L);
        }
    }

    private void addNumericClanAction(Gui gui, GuiData guiData, String str, Player player, UUID uuid, UUID uuid2, int i, String str2, String str3) {
        addActionItem(gui, guiData, str, player, uuid, null, inventoryClickEvent -> {
            requestAdminInput(player, Optional.of("1"), str4 -> {
                executeAdminCommand(player, "uclan " + str3 + " " + str2 + " " + str4, () -> {
                    openAdminClansEdit(player, uuid2, i, Optional.empty());
                });
            }, () -> {
                openAdminClansEdit(player, uuid2, i, Optional.empty());
            });
        });
    }

    private void addBankAction(Gui gui, GuiData guiData, String str, Player player, UUID uuid, UUID uuid2, int i, String str2, String str3) {
        addActionItem(gui, guiData, str, player, uuid, null, inventoryClickEvent -> {
            requestAdminInput(player, Optional.of("1"), str4 -> {
                executeAdminCommand(player, "uclan bank " + str3 + " " + str2 + " " + str4, () -> {
                    openAdminClansEdit(player, uuid2, i, Optional.empty());
                });
            }, () -> {
                openAdminClansEdit(player, uuid2, i, Optional.empty());
            });
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminPlayersHome(Player player, int i, Optional<String> optional) {
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
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_players_home")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_players_home");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        if (i < 1) {
            i = 1;
        }
        int i2 = i;
        jfN3Uc9ymXXFWVHj7Oor jfn3uc9ymxxfwvhj7oor = new jfN3Uc9ymXXFWVHj7Oor(new ArrayList(new ArrayList(this.plugin.getPlayerManager().xtOheRiObl4QeAl().keySet())), guiData.getPageSize());
        jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY(i2);
        String strReplace = guiData.getTitle().replace("{page}", String.valueOf(i2)).replace("{pages}", String.valueOf(jfn3uc9ymxxfwvhj7oor.zJnaNCVQSgEShq()));
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            strReplace = optional.get();
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), strReplace))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "admin_players_home", player);
        if (guiData.getItems().containsKey("current")) {
            Iterator<Object> it = jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY().iterator();
            while (it.hasNext()) {
                UUID uuid = (UUID) it.next();
                if (this.plugin.getPlayerManager().p31abtwfBag2jhMH6K(uuid).isPresent() && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("current")), uuid, (List<String>) null)) != null) {
                    final me.ulrich.clans.data.GuiItemsData finalCurrentData5 = guiItemsData5;
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent2 -> {
                        playClick(player, finalCurrentData5);
                        inventoryClickEvent2.setCancelled(true);
                        openAdminPlayersEdit(player, uuid, i2, Optional.empty());
                    }));
                }
            }
        }
        if (guiData.getItems().containsKey("search") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("search")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                playClick(player, guiItemsData4);
                inventoryClickEvent3.setCancelled(true);
                requestAdminInput(player, Optional.of("Player"), str -> {
                    Optional<PlayerData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(str);
                    if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                        openAdminPlayersEdit(player, optionalCDW4Fj1iwdIXEOqWjiJSR.get().getUuid(), i2, Optional.empty());
                    } else {
                        MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ADMIN_GUI_PLAYER_NOT_FOUND));
                        openAdminPlayersHome(player, i2, Optional.empty());
                    }
                }, () -> {
                    openAdminPlayersHome(player, i2, Optional.empty());
                });
            }));
        }
        if (guiData.getItems().containsKey("previous") && jfn3uc9ymxxfwvhj7oor.ZwrsrwOCXRUscW6Q() && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent4 -> {
                playClick(player, guiItemsData3);
                inventoryClickEvent4.setCancelled(true);
                openAdminPlayersHome(player, jfn3uc9ymxxfwvhj7oor.xtOheRiObl4QeAl(), Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("next") && jfn3uc9ymxxfwvhj7oor.jBUuLP0sWwaPyPOmogdX7l() && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                playClick(player, guiItemsData2);
                inventoryClickEvent5.setCancelled(true);
                openAdminPlayersHome(player, jfn3uc9ymxxfwvhj7oor.iZTqZaRK5UGoe0Z(), Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent6 -> {
                playClick(player, guiItemsData);
                inventoryClickEvent6.setCancelled(true);
                openAdminHome(player, Optional.empty());
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent7 -> {
            inventoryClickEvent7.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openAdminPlayersHome(player, i2, Optional.empty());
            }, 20L);
        }
    }

    public void openAdminPlayersEdit(Player player, UUID uuid, Optional<String> optional) {
        openAdminPlayersEdit(player, uuid, 1, optional);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminPlayersEdit(Player player, UUID uuid, int i, Optional<String> optional) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.plugin.getPlayerManager().p31abtwfBag2jhMH6K(uuid);
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ADMIN_GUI_PLAYER_NOT_FOUND));
            openAdminPlayersHome(player, Math.max(1, i), Optional.empty());
            return;
        }
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_player_edit")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        String name = optionalP31abtwfBag2jhMH6K.get().getName();
        int iMax = Math.max(1, i);
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_player_edit");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) ? optional.get() : guiData.getTitle()))))).rows(guiData.getRows()).create();
        for (String str : Arrays.asList("fill", "fill2")) {
            if (guiData.getItems().containsKey(str) && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get(str)), (UUID) null, (List<String>) null)) != null) {
                this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent -> {
                    inventoryClickEvent.setCancelled(true);
                }));
            }
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_player_edit", player);
        addActionItem(guiCreate, guiData, "info", player, uuid, null, inventoryClickEvent2 -> {
        });
        addActionItem(guiCreate, guiData, "profile", player, uuid, null, inventoryClickEvent3 -> {
            this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfile(player, uuid, null);
        });
        addActionItem(guiCreate, guiData, "permissions", player, uuid, null, inventoryClickEvent4 -> {
            this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerPermissions(player, uuid, Optional.empty());
        });
        addActionItem(guiCreate, guiData, "resetkdr", player, uuid, null, inventoryClickEvent5 -> {
            openAdminConfirm(player, uuid, "Reset Player KDR", () -> {
                executeAdminCommand(player, "uclan resetplayerkdr " + name, () -> {
                    openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
                });
            }, () -> {
                openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addActionItem(guiCreate, guiData, "forcejoin", player, uuid, null, inventoryClickEvent6 -> {
            requestAdminInput(player, Optional.of("Clan"), str2 -> {
                executeAdminCommand(player, "uclan forcejoin " + name + " " + str2, () -> {
                    openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
                });
            }, () -> {
                openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
            });
        });
        addActionItem(guiCreate, guiData, "kick", player, uuid, null, inventoryClickEvent7 -> {
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                String tagNoColor = optionalCDW4Fj1iwdIXEOqWjiJSR.get().getTagNoColor();
                openAdminConfirm(player, uuid, "Kick " + name, () -> {
                    executeAdminCommand(player, "uclan kick " + tagNoColor + " " + name, () -> {
                        openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
                    });
                }, () -> {
                    openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
                });
            } else {
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
            }
        });
        addActionItem(guiCreate, guiData, "setleader", player, uuid, null, inventoryClickEvent8 -> {
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                executeAdminCommand(player, "uclan setleader " + optionalCDW4Fj1iwdIXEOqWjiJSR.get().getTagNoColor() + " " + name, () -> {
                    openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
                });
            } else {
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
            }
        });
        addActionItem(guiCreate, guiData, "clan", player, uuid, null, inventoryClickEvent9 -> {
            Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid);
            if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent()) {
                openAdminClansEdit(player, optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId(), 1, Optional.empty());
            } else {
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
                openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
            }
        });
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), uuid, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent10 -> {
                playClick(player, guiItemsData);
                inventoryClickEvent10.setCancelled(true);
                openAdminPlayersHome(player, iMax, Optional.empty());
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent11 -> {
            inventoryClickEvent11.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openAdminPlayersEdit(player, uuid, iMax, Optional.empty());
            }, 20L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminServer(Player player) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_server")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_server");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, guiData.getTitle())))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_server", player);
        List<String> listAdminStatusReplacements = adminStatusReplacements(player);
        addActionItem(guiCreate, guiData, "core", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent2 -> {
        });
        addActionItem(guiCreate, guiData, "runtime", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent3 -> {
        });
        addActionItem(guiCreate, guiData, "data", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent4 -> {
        });
        addActionItem(guiCreate, guiData, "components", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent5 -> {
            this.plugin.getGuiManager().Fc3p9FhCjSD1k5Ra4().openClansModule(player, null);
        });
        addActionItem(guiCreate, guiData, "multiserver", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent6 -> {
            openAdminStorage(player);
        });
        addActionItem(guiCreate, guiData, "back", player, player.getUniqueId(), null, inventoryClickEvent7 -> {
            openAdminHome(player, Optional.empty());
        });
        guiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminStorage(Player player) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_storage")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_storage");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, guiData.getTitle())))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_storage", player);
        List<String> listAdminStatusReplacements = adminStatusReplacements(player);
        addActionItem(guiCreate, guiData, "overview", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent2 -> {
        });
        addActionItem(guiCreate, guiData, "test", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent3 -> {
            testStorage(player);
        });
        addActionItem(guiCreate, guiData, "multiserver", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent4 -> {
        });
        addActionItem(guiCreate, guiData, "channels", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent5 -> {
        });
        addActionItem(guiCreate, guiData, "back", player, player.getUniqueId(), null, inventoryClickEvent6 -> {
            openAdminHome(player, Optional.empty());
        });
        guiCreate.setDefaultClickAction(inventoryClickEvent7 -> {
            inventoryClickEvent7.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminDiagnostics(Player player) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_diagnostics")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_diagnostics");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, guiData.getTitle())))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_diagnostics", player);
        List<String> listAdminStatusReplacements = adminStatusReplacements(player);
        addActionItem(guiCreate, guiData, "summary", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent2 -> {
        });
        addActionItem(guiCreate, guiData, "hooks", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent3 -> {
            openAdminDiagnosticHooks(player);
        });
        addActionItem(guiCreate, guiData, "storage", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent4 -> {
            openAdminStorage(player);
        });
        addActionItem(guiCreate, guiData, "components", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent5 -> {
            this.plugin.getGuiManager().Fc3p9FhCjSD1k5Ra4().openClansModule(player, null);
        });
        addActionItem(guiCreate, guiData, "refresh", player, player.getUniqueId(), listAdminStatusReplacements, inventoryClickEvent6 -> {
            openAdminDiagnostics(player);
        });
        addActionItem(guiCreate, guiData, "back", player, player.getUniqueId(), null, inventoryClickEvent7 -> {
            openAdminHome(player, Optional.empty());
        });
        guiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminDiagnosticHooks(Player player) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_diagnostics_hooks")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_diagnostics_hooks");
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, guiData.getTitle())))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("current")) {
            GuiItemsData guiItemsData4 = guiData.getItems().get("current");
            for (String str : diagnosticHookNames()) {
                boolean zIsPluginEnabled = Bukkit.getPluginManager().isPluginEnabled(str);
                GuiItemsData guiItemsDataM427clone = guiItemsData4.m427clone();
                guiItemsDataM427clone.setMaterial(zIsPluginEnabled ? "EMERALD" : "REDSTONE");
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsDataM427clone, player.getUniqueId(), Arrays.asList("{name};" + str, "{state};" + state(player, zIsPluginEnabled), "{version};" + pluginVersion(str)));
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY4 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent -> {
                        inventoryClickEvent.setCancelled(true);
                    }));
                }
            }
        }
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent2 -> {
                playClick(player, guiItemsData3);
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent3 -> {
                playClick(player, guiItemsData2);
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                playClick(player, guiItemsData);
                inventoryClickEvent4.setCancelled(true);
                openAdminDiagnostics(player);
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent5 -> {
            inventoryClickEvent5.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminSettings(Player player) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_settings")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_settings");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, guiData.getTitle())))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_settings", player);
        addConfigToggle(guiCreate, guiData, "updatechecker", player, "Plugin.check_for_updates");
        addConfigToggle(guiCreate, guiData, "ff", player, "Config.player.ff.enabled");
        addConfigToggle(guiCreate, guiData, "kdr", player, "Config.player.kdr.enabled");
        addConfigToggle(guiCreate, guiData, "souls", player, "Config.player.souls.enabled");
        addConfigToggle(guiCreate, guiData, "joinquit", player, "Config.player.join_quit");
        addConfigToggle(guiCreate, guiData, "toprealtime", player, "Config.top.realtime");
        addActionItem(guiCreate, guiData, "globalff", player, player.getUniqueId(), Arrays.asList("{state};" + state(player, this.plugin.getClanManager().b4i2FbOkaKeg91LiAe6l())), inventoryClickEvent2 -> {
            executeAdminCommand(player, "uclan globalff", () -> {
                openAdminSettings(player);
            });
        });
        addActionItem(guiCreate, guiData, "chatspy", player, player.getUniqueId(), Arrays.asList("{state};" + state(player, this.plugin.getClanManager().p31abtwfBag2jhMH6K().contains(player.getUniqueId()))), inventoryClickEvent3 -> {
            executeAdminCommand(player, "uclan chatspy", () -> {
                openAdminSettings(player);
            });
        });
        addActionItem(guiCreate, guiData, "back", player, player.getUniqueId(), null, inventoryClickEvent4 -> {
            openAdminHome(player, Optional.empty());
        });
        guiCreate.setDefaultClickAction(inventoryClickEvent5 -> {
            inventoryClickEvent5.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminMaintenance(Player player) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_maintenance")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_maintenance");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, guiData.getTitle())))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "admin_maintenance", player);
        addActionItem(guiCreate, guiData, "configurations", player, player.getUniqueId(), null, inventoryClickEvent2 -> {
            executeAdminCommand(player, "uclan reload configurations", () -> {
                this.plugin.getGuiManager().jBUuLP0sWwaPyPOmogdX7l();
                openAdminMaintenance(player);
            }, 45L);
        });
        addActionItem(guiCreate, guiData, "addons", player, player.getUniqueId(), null, inventoryClickEvent3 -> {
            executeAdminCommand(player, "uclan reload addons", () -> {
                openAdminMaintenance(player);
            }, 45L);
        });
        addActionItem(guiCreate, guiData, "modules", player, player.getUniqueId(), null, inventoryClickEvent4 -> {
            executeAdminCommand(player, "uclan module reload", () -> {
                openAdminMaintenance(player);
            }, 55L);
        });
        addActionItem(guiCreate, guiData, "extensions", player, player.getUniqueId(), null, inventoryClickEvent5 -> {
            executeAdminCommand(player, "uclan extension reload", () -> {
                openAdminMaintenance(player);
            }, 55L);
        });
        addActionItem(guiCreate, guiData, "gui", player, player.getUniqueId(), null, inventoryClickEvent6 -> {
            player.closeInventory();
            try {
                this.plugin.getFiles().b4i2FbOkaKeg91LiAe6l().get("gui").reload();
                this.plugin.getFiles().b4i2FbOkaKeg91LiAe6l().get("admin_gui").reload();
                this.plugin.getGuiManager().jBUuLP0sWwaPyPOmogdX7l();
            } catch (Exception e2) {
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.ERROR_START_ACTION));
            }
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                if (player.isOnline()) {
                    openAdminMaintenance(player);
                }
            }, 2L);
        });
        addActionItem(guiCreate, guiData, "plugin", player, player.getUniqueId(), null, inventoryClickEvent7 -> {
            openAdminConfirm(player, player.getUniqueId(), "Reload UltimateClans", () -> {
                executeAdminCommand(player, "uclan reload all", null);
            }, () -> {
                openAdminMaintenance(player);
            });
        });
        addActionItem(guiCreate, guiData, "back", player, player.getUniqueId(), null, inventoryClickEvent8 -> {
            openAdminHome(player, Optional.empty());
        });
        guiCreate.setDefaultClickAction(inventoryClickEvent9 -> {
            inventoryClickEvent9.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminClanMembers(Player player, UUID uuid, int i) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_NOT_FOUND));
            openAdminClansHome(player, Math.max(1, i), Optional.empty());
            return;
        }
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_clan_members")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        ClanData clanData = optionalIZTqZaRK5UGoe0Z.get();
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_clan_members");
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanData.getLeader(), guiData.getTitle()))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("current")) {
            GuiItemsData guiItemsData4 = guiData.getItems().get("current");
            LinkedHashSet<UUID> linkedHashSet = new LinkedHashSet();
            linkedHashSet.add(clanData.getLeader());
            linkedHashSet.addAll(clanData.getMembers());
            for (UUID uuid2 : linkedHashSet) {
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData4, uuid2, (List<String>) null);
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY4 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent -> {
                        playClick(player, guiItemsData4);
                        inventoryClickEvent.setCancelled(true);
                        if (inventoryClickEvent.getClick() != ClickType.RIGHT && inventoryClickEvent.getClick() != ClickType.SHIFT_RIGHT) {
                            openAdminPlayersEdit(player, uuid2, 1, Optional.empty());
                        } else {
                            if (uuid2.equals(clanData.getLeader())) {
                                return;
                            }
                            Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.plugin.getPlayerManager().p31abtwfBag2jhMH6K(uuid2);
                            if (optionalP31abtwfBag2jhMH6K.isPresent()) {
                                openAdminConfirm(player, uuid2, "Kick " + optionalP31abtwfBag2jhMH6K.get().getName(), () -> {
                                    executeAdminCommand(player, "uclan kick " + clanData.getTagNoColor() + " " + ((PlayerData) optionalP31abtwfBag2jhMH6K.get()).getName(), () -> {
                                        openAdminClanMembers(player, uuid, i);
                                    });
                                }, () -> {
                                    openAdminClanMembers(player, uuid, i);
                                });
                            }
                        }
                    }));
                }
            }
        }
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("previous")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent2 -> {
                playClick(player, guiItemsData3);
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent3 -> {
                playClick(player, guiItemsData2);
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                playClick(player, guiItemsData);
                inventoryClickEvent4.setCancelled(true);
                openAdminClansEdit(player, uuid, i, Optional.empty());
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent5 -> {
            inventoryClickEvent5.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openAdminClanRelations(Player player, UUID uuid, boolean z, int i) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_NOT_FOUND));
            return;
        }
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_clan_relations")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        ClanData clanData = optionalIZTqZaRK5UGoe0Z.get();
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_clan_relations");
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(clanData.getLeader(), guiData.getTitle().replace("{type}", z ? "<green>ALLIES" : "<red>RIVALS")))))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        ArrayList arrayList = new ArrayList();
        if (clanData.getRivalAlly() != null) {
            List<UUID> ally = z ? clanData.getRivalAlly().getAlly() : clanData.getRivalAlly().getRival();
            if (ally != null) {
                arrayList.addAll(ally);
            }
        }
        if (guiData.getItems().containsKey("current")) {
            GuiItemsData guiItemsData4 = guiData.getItems().get("current");
            for (UUID uuid2 : new ArrayList<UUID>(arrayList)) {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z2 = this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid2);
                if (optionalIZTqZaRK5UGoe0Z2.isPresent() && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData4, optionalIZTqZaRK5UGoe0Z2.get().getLeader(), (List<String>) null)) != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent -> {
                        playClick(player, guiItemsData4);
                        inventoryClickEvent.setCancelled(true);
                        openAdminClansEdit(player, uuid2, 1, Optional.empty());
                    }));
                }
            }
        }
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("previous")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent2 -> {
                playClick(player, guiItemsData3);
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("next")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent3 -> {
                playClick(player, guiItemsData2);
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), clanData.getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent4 -> {
                playClick(player, guiItemsData);
                inventoryClickEvent4.setCancelled(true);
                openAdminClansEdit(player, uuid, i, Optional.empty());
            }));
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent5 -> {
            inventoryClickEvent5.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void openAdminConfirm(Player player, UUID uuid, String str, Runnable runnable, Runnable runnable2) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("admin_confirm")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            if (runnable2 != null) {
                runnable2.run();
                return;
            }
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("admin_confirm");
        List<String> listAsList = Arrays.asList("{action};" + str);
        String strReplace = guiData.getTitle().replace("{action}", str);
        if (uuid != null) {
            strReplace = this.plugin.getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, strReplace);
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().ZwrsrwOCXRUscW6Q(this.plugin.getHooksManager().parsePapi(player, strReplace)))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("fill")), uuid, listAsList)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent -> {
                inventoryClickEvent.setCancelled(true);
            }));
        }
        addActionItem(guiCreate, guiData, "confirm", player, uuid, listAsList, inventoryClickEvent2 -> {
            player.closeInventory();
            if (runnable != null) {
                runnable.run();
            }
        });
        addActionItem(guiCreate, guiData, "cancel", player, uuid, listAsList, inventoryClickEvent3 -> {
            player.closeInventory();
            if (runnable2 != null) {
                runnable2.run();
            }
        });
        guiCreate.setDefaultClickAction(inventoryClickEvent4 -> {
            inventoryClickEvent4.setCancelled(true);
        });
        guiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }
}
