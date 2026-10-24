package me.ulrich.clans.manager.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.ModerationData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.GuiItem;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.qjkRaOgynIj1.jfN3Uc9ymXXFWVHj7Oor;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/gui/PaginationGui.class */
public class PaginationGui {
    private Clans plugin;

    public PaginationGui(Clans clans) {
        this.plugin = clans;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClansListMembers(Player player, UUID uuid, boolean z) {
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
        Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid);
        if (!optionalIZTqZaRK5UGoe0Z.isPresent()) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("members")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("members");
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(optionalIZTqZaRK5UGoe0Z.get().getLeader(), guiData.getTitle())), true))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
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
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "members", player);
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("previous")), optionalIZTqZaRK5UGoe0Z.get().getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                paginatedGuiCreate.previous();
            }));
        }
        if (guiData.getItems().containsKey("next") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("next")), optionalIZTqZaRK5UGoe0Z.get().getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                paginatedGuiCreate.next();
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("back")), optionalIZTqZaRK5UGoe0Z.get().getLeader(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                if (this.plugin.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
                    Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
                    if (optionalCDW4Fj1iwdIXEOqWjiJSR.isPresent() && uuid.equals(optionalCDW4Fj1iwdIXEOqWjiJSR.get().getId())) {
                        this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
                        return;
                    }
                }
                this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanStats(player, (ClanData) optionalIZTqZaRK5UGoe0Z.get(), null);
            }));
        }
        if (guiData.getItems().containsKey("onlines") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("onlines")), optionalIZTqZaRK5UGoe0Z.get().getLeader(), Arrays.asList("{state};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("STATE_" + String.valueOf(z).toUpperCase()))))) != null) {
            itemBuilderV8qP8fE86HMhvNuYPFjqY2.glow(z);
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openClansListMembers(player, uuid, !z);
            }));
        }
        if (this.plugin.getModerationManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), "INVITE") && guiData.getItems().containsKey("invite") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("invite")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanMembersInvite(player, (String) null);
            }));
        }
        HashMap<UUID, Integer> map = new HashMap<>();
        ArrayList<UUID> arrayList = new ArrayList();
        if (z) {
            arrayList.addAll(optionalIZTqZaRK5UGoe0Z.get().getOnlineMembers());
        } else {
            arrayList.addAll(optionalIZTqZaRK5UGoe0Z.get().getMembers());
        }
        for (UUID uuid2 : arrayList) {
            if (!this.plugin.getHooksManager().isInvisible(player) || !z) {
                if (this.plugin.getPlayerManager().xtOheRiObl4QeAl(uuid, uuid2)) {
                    Optional<ModerationData> optionalB4i2FbOkaKeg91LiAe6l = this.plugin.getModerationManager().b4i2FbOkaKeg91LiAe6l(uuid2);
                    if (optionalB4i2FbOkaKeg91LiAe6l.isPresent()) {
                        map.put(uuid2, Integer.valueOf(optionalB4i2FbOkaKeg91LiAe6l.get().getPriority()));
                    } else {
                        Optional<ModerationData> optionalZwrsrwOCXRUscW6Q = this.plugin.getModerationManager().ZwrsrwOCXRUscW6Q();
                        if (optionalZwrsrwOCXRUscW6Q.isPresent()) {
                            map.put(uuid2, Integer.valueOf(optionalZwrsrwOCXRUscW6Q.get().getPriority()));
                        }
                    }
                } else {
                    this.plugin.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(uuid, uuid2);
                }
            }
        }
        if (guiData.getItems().containsKey("current")) {
            for (Map.Entry<UUID, Integer> entry : ((Map<UUID, Integer>) map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap((v0) -> {
                return v0.getKey();
            }, (v0) -> {
                return v0.getValue();
            }, (num, num2) -> {
                return num2;
            }, LinkedHashMap::new))).entrySet()) {
                GuiItemsData guiItemsData7 = guiData.getItems().get("current");
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData7, (UUID) entry.getKey(), (List<String>) null);
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY7 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent7 -> {
                        try {
                            if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent7.setCancelled(true);
                        this.plugin.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfile(player, (UUID) entry.getKey(), null);
                    }));
                }
            }
        }
        paginatedGuiCreate.setDefaultClickAction(inventoryClickEvent8 -> {
            inventoryClickEvent8.setCancelled(true);
        });
        paginatedGuiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openClanTop(Player player, ClanEnum.PlaceholderTop placeholderTop, int i, boolean z) {
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5;
        GuiItemsData guiItemsData5;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6;
        GuiItemsData guiItemsData6;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY7;
        GuiItemsData guiItemsData7;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY8;
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("clan_top")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("clan_top");
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
        List list = (List) getPlugin().getTopManager().jBUuLP0sWwaPyPOmogdX7l(placeholderTop).keySet().stream().filter(uuid -> {
            return !z || (z && this.plugin.getClanManager().ZwrsrwOCXRUscW6Q(uuid) && this.plugin.getClanManager().iZTqZaRK5UGoe0Z(uuid).get().getSettings().isOpened());
        }).collect(Collectors.toList());
        new ArrayList();
        jfN3Uc9ymXXFWVHj7Oor jfn3uc9ymxxfwvhj7oor = new jfN3Uc9ymXXFWVHj7Oor(new ArrayList(list), guiData.getPageSize());
        jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY(i2);
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), guiData.getTitle().replace("{page}", String.valueOf(i2)).replace("{pages}", String.valueOf(jfn3uc9ymxxfwvhj7oor.zJnaNCVQSgEShq())).replace("%current%", getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("TRANSLACTION_" + placeholderTop.toString()))))), true))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill3") && (itemBuilderV8qP8fE86HMhvNuYPFjqY8 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("fill3")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY8.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "clan_top", player);
        if (guiData.getItems().containsKey("all")) {
            GuiItemsData guiItemsData8 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.ALL) ? "active" : "all");
            GuiItemsData guiItemsData9 = guiData.getItems().get("all");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY9 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData8, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY9 != null) {
                GuiItem guiItemAsGuiItem = itemBuilderV8qP8fE86HMhvNuYPFjqY9.asGuiItem(inventoryClickEvent4 -> {
                    try {
                        if (guiItemsData8.getClickSound() != null && !guiItemsData8.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData8.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent4.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.ALL, 1, z);
                });
                if (guiItemsData9.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData9, guiItemAsGuiItem);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData8, guiItemAsGuiItem);
                }
            }
        }
        if (guiData.getItems().containsKey("kdr")) {
            GuiItemsData guiItemsData10 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.KDR) ? "active" : "kdr");
            GuiItemsData guiItemsData11 = guiData.getItems().get("kdr");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY10 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData10, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY10 != null) {
                GuiItem guiItemAsGuiItem2 = itemBuilderV8qP8fE86HMhvNuYPFjqY10.asGuiItem(inventoryClickEvent5 -> {
                    try {
                        if (guiItemsData10.getClickSound() != null && !guiItemsData10.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData10.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent5.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.KDR, 1, z);
                });
                if (guiItemsData11.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData11, guiItemAsGuiItem2);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData10, guiItemAsGuiItem2);
                }
            }
        }
        if (guiData.getItems().containsKey("member")) {
            GuiItemsData guiItemsData12 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.MEMBER) ? "active" : "member");
            GuiItemsData guiItemsData13 = guiData.getItems().get("member");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY11 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData12, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY11 != null) {
                GuiItem guiItemAsGuiItem3 = itemBuilderV8qP8fE86HMhvNuYPFjqY11.asGuiItem(inventoryClickEvent6 -> {
                    try {
                        if (guiItemsData12.getClickSound() != null && !guiItemsData12.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData12.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent6.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.MEMBER, 1, z);
                });
                if (guiItemsData13.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData13, guiItemAsGuiItem3);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData12, guiItemAsGuiItem3);
                }
            }
        }
        if (guiData.getItems().containsKey("bank")) {
            GuiItemsData guiItemsData14 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.BANK) ? "active" : "bank");
            GuiItemsData guiItemsData15 = guiData.getItems().get("bank");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY12 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData14, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY12 != null) {
                GuiItem guiItemAsGuiItem4 = itemBuilderV8qP8fE86HMhvNuYPFjqY12.asGuiItem(inventoryClickEvent7 -> {
                    try {
                        if (guiItemsData14.getClickSound() != null && !guiItemsData14.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData14.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent7.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.BANK, 1, z);
                });
                if (guiItemsData15.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData15, guiItemAsGuiItem4);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData14, guiItemAsGuiItem4);
                }
            }
        }
        if (guiData.getItems().containsKey("war")) {
            GuiItemsData guiItemsData16 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.WAR) ? "active" : "war");
            GuiItemsData guiItemsData17 = guiData.getItems().get("war");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY13 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData16, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY13 != null) {
                GuiItem guiItemAsGuiItem5 = itemBuilderV8qP8fE86HMhvNuYPFjqY13.asGuiItem(inventoryClickEvent8 -> {
                    try {
                        if (guiItemsData16.getClickSound() != null && !guiItemsData16.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData16.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent8.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.WAR, 1, z);
                });
                if (guiItemsData17.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData17, guiItemAsGuiItem5);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData16, guiItemAsGuiItem5);
                }
            }
        }
        if (guiData.getItems().containsKey("level")) {
            GuiItemsData guiItemsData18 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.LEVEL) ? "active" : "level");
            GuiItemsData guiItemsData19 = guiData.getItems().get("level");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY14 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData18, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY14 != null) {
                GuiItem guiItemAsGuiItem6 = itemBuilderV8qP8fE86HMhvNuYPFjqY14.asGuiItem(inventoryClickEvent9 -> {
                    try {
                        if (guiItemsData18.getClickSound() != null && !guiItemsData18.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData18.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent9.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.LEVEL, 1, z);
                });
                if (guiItemsData19.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData19, guiItemAsGuiItem6);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData18, guiItemAsGuiItem6);
                }
            }
        }
        if (guiData.getItems().containsKey("point")) {
            GuiItemsData guiItemsData20 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.POINT) ? "active" : "point");
            GuiItemsData guiItemsData21 = guiData.getItems().get("point");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY15 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData20, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY15 != null) {
                GuiItem guiItemAsGuiItem7 = itemBuilderV8qP8fE86HMhvNuYPFjqY15.asGuiItem(inventoryClickEvent10 -> {
                    try {
                        if (guiItemsData20.getClickSound() != null && !guiItemsData20.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData20.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent10.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.POINT, 1, z);
                });
                if (guiItemsData21.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData21, guiItemAsGuiItem7);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData20, guiItemAsGuiItem7);
                }
            }
        }
        if (guiData.getItems().containsKey("patent")) {
            GuiItemsData guiItemsData22 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.PATENT) ? "active" : "patent");
            GuiItemsData guiItemsData23 = guiData.getItems().get("patent");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY16 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData22, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY16 != null) {
                GuiItem guiItemAsGuiItem8 = itemBuilderV8qP8fE86HMhvNuYPFjqY16.asGuiItem(inventoryClickEvent11 -> {
                    try {
                        if (guiItemsData22.getClickSound() != null && !guiItemsData22.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData22.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent11.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.PATENT, 1, z);
                });
                if (guiItemsData23.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData23, guiItemAsGuiItem8);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData22, guiItemAsGuiItem8);
                }
            }
        }
        if (guiData.getItems().containsKey("souls") && this.plugin.getFiles().p31abtwfBag2jhMH6K().getBoolean("Config.player.souls.enabled")) {
            GuiItemsData guiItemsData24 = guiData.getItems().get(placeholderTop.equals(ClanEnum.PlaceholderTop.SOULS) ? "active" : "souls");
            GuiItemsData guiItemsData25 = guiData.getItems().get("souls");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY17 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData24, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY17 != null) {
                GuiItem guiItemAsGuiItem9 = itemBuilderV8qP8fE86HMhvNuYPFjqY17.asGuiItem(inventoryClickEvent12 -> {
                    try {
                        if (guiItemsData24.getClickSound() != null && !guiItemsData24.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData24.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent12.setCancelled(true);
                    openClanTop(player, ClanEnum.PlaceholderTop.SOULS, 1, z);
                });
                if (guiItemsData25.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData25, guiItemAsGuiItem9);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData24, guiItemAsGuiItem9);
                }
            }
        }
        if (guiData.getItems().containsKey("previous") && jfn3uc9ymxxfwvhj7oor.ZwrsrwOCXRUscW6Q() && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent13 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent13.setCancelled(true);
                openClanTop(player, placeholderTop, jfn3uc9ymxxfwvhj7oor.xtOheRiObl4QeAl(), z);
            }));
        }
        if (guiData.getItems().containsKey("next") && jfn3uc9ymxxfwvhj7oor.jBUuLP0sWwaPyPOmogdX7l() && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent14 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent14.setCancelled(true);
                openClanTop(player, placeholderTop, jfn3uc9ymxxfwvhj7oor.iZTqZaRK5UGoe0Z(), z);
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent15 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent15.setCancelled(true);
                if (this.plugin.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
                    this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
                } else {
                    this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openNoClanHome(player);
                }
            }));
        }
        if (guiData.getItems().containsKey("only_open") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("only_open")), player.getUniqueId(), Arrays.asList("{state};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("STATE_" + String.valueOf(z).toUpperCase()))))) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent16 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent16.setCancelled(true);
                openClanTop(player, placeholderTop, 1, !z);
            }));
        }
        if (guiData.getItems().containsKey("current_" + placeholderTop.toString().toLowerCase())) {
            GuiItemsData guiItemsData26 = guiData.getItems().get("current_" + placeholderTop.toString().toLowerCase());
            Iterator<Object> it = jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY().iterator();
            while (it.hasNext()) {
                Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.plugin.getClanManager().iZTqZaRK5UGoe0Z((UUID) it.next());
                if (optionalIZTqZaRK5UGoe0Z.isPresent() && this.plugin.getPlayerManager().b4i2FbOkaKeg91LiAe6l(optionalIZTqZaRK5UGoe0Z.get().getLeader()) && this.plugin.getPlayerManager().zJnaNCVQSgEShq(optionalIZTqZaRK5UGoe0Z.get().getLeader()) && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData26, optionalIZTqZaRK5UGoe0Z.get().getLeader(), (List<String>) null)) != null) {
                    guiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent17 -> {
                        try {
                            if (guiItemsData26.getClickSound() != null && !guiItemsData26.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData26.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent17.setCancelled(true);
                        getPlugin().getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanStats(player, (ClanData) optionalIZTqZaRK5UGoe0Z.get(), null);
                    }));
                }
            }
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent18 -> {
            inventoryClickEvent18.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openPlayerTop(Player player, ClanEnum.PlaceholderPlayerTop placeholderPlayerTop, int i, boolean z, boolean z2) {
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5;
        GuiItemsData guiItemsData5;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY6;
        GuiItemsData guiItemsData6;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY7;
        GuiItemsData guiItemsData7;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY8;
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("player_top")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("player_top");
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
        List<UUID> list = ((List<UUID>) getPlugin().getTopManager().jBUuLP0sWwaPyPOmogdX7l(placeholderPlayerTop).keySet().stream().filter(uuid -> {
            return !z || (z && this.plugin.getPlayerManager().p31abtwfBag2jhMH6K(uuid).isPresent() && Bukkit.getOnlinePlayers().stream().anyMatch(player2 -> {
                return player2.getUniqueId().equals(uuid);
            }));
        }).collect(Collectors.toList())).stream().filter(uuid2 -> {
            return !z2 || (z2 && !this.plugin.getPlayerManager().zJnaNCVQSgEShq(uuid2));
        }).collect(Collectors.toList());
        new ArrayList();
        jfN3Uc9ymXXFWVHj7Oor jfn3uc9ymxxfwvhj7oor = new jfN3Uc9ymXXFWVHj7Oor(new ArrayList(list), guiData.getPageSize());
        jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY(i2);
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), guiData.getTitle().replace("{page}", String.valueOf(i2)).replace("{pages}", String.valueOf(jfn3uc9ymxxfwvhj7oor.zJnaNCVQSgEShq())).replace("%current%", getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("TRANSLACTION_" + placeholderPlayerTop.toString()))))), true))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill3") && (itemBuilderV8qP8fE86HMhvNuYPFjqY8 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("fill3")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY8.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "player_top", player);
        if (guiData.getItems().containsKey("all")) {
            GuiItemsData guiItemsData8 = guiData.getItems().get(placeholderPlayerTop.equals(ClanEnum.PlaceholderPlayerTop.ALL) ? "active" : "all");
            GuiItemsData guiItemsData9 = guiData.getItems().get("all");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY9 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData8, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY9 != null) {
                GuiItem guiItemAsGuiItem = itemBuilderV8qP8fE86HMhvNuYPFjqY9.asGuiItem(inventoryClickEvent4 -> {
                    try {
                        if (guiItemsData8.getClickSound() != null && !guiItemsData8.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData8.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent4.setCancelled(true);
                    openPlayerTop(player, ClanEnum.PlaceholderPlayerTop.ALL, 1, z, z2);
                });
                if (guiItemsData9.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData9, guiItemAsGuiItem);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData8, guiItemAsGuiItem);
                }
            }
        }
        if (guiData.getItems().containsKey("kdr")) {
            GuiItemsData guiItemsData10 = guiData.getItems().get(placeholderPlayerTop.equals(ClanEnum.PlaceholderPlayerTop.KDR) ? "active" : "kdr");
            GuiItemsData guiItemsData11 = guiData.getItems().get("kdr");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY10 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData10, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY10 != null) {
                GuiItem guiItemAsGuiItem2 = itemBuilderV8qP8fE86HMhvNuYPFjqY10.asGuiItem(inventoryClickEvent5 -> {
                    try {
                        if (guiItemsData10.getClickSound() != null && !guiItemsData10.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData10.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent5.setCancelled(true);
                    openPlayerTop(player, ClanEnum.PlaceholderPlayerTop.KDR, 1, z, z2);
                });
                if (guiItemsData11.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData11, guiItemAsGuiItem2);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData10, guiItemAsGuiItem2);
                }
            }
        }
        if (guiData.getItems().containsKey("souls")) {
            GuiItemsData guiItemsData12 = guiData.getItems().get(placeholderPlayerTop.equals(ClanEnum.PlaceholderPlayerTop.SOULS) ? "active" : "souls");
            GuiItemsData guiItemsData13 = guiData.getItems().get("souls");
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY11 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData12, player.getUniqueId(), (List<String>) null);
            if (itemBuilderV8qP8fE86HMhvNuYPFjqY11 != null) {
                GuiItem guiItemAsGuiItem3 = itemBuilderV8qP8fE86HMhvNuYPFjqY11.asGuiItem(inventoryClickEvent6 -> {
                    try {
                        if (guiItemsData12.getClickSound() != null && !guiItemsData12.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData12.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent6.setCancelled(true);
                    openPlayerTop(player, ClanEnum.PlaceholderPlayerTop.SOULS, 1, z, z2);
                });
                if (guiItemsData13.getSlot() >= 0) {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData13, guiItemAsGuiItem3);
                } else {
                    this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData12, guiItemAsGuiItem3);
                }
            }
        }
        if (guiData.getItems().containsKey("previous") && jfn3uc9ymxxfwvhj7oor.ZwrsrwOCXRUscW6Q() && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                openPlayerTop(player, placeholderPlayerTop, jfn3uc9ymxxfwvhj7oor.xtOheRiObl4QeAl(), z, z2);
            }));
        }
        if (guiData.getItems().containsKey("next") && jfn3uc9ymxxfwvhj7oor.jBUuLP0sWwaPyPOmogdX7l() && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent8 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent8.setCancelled(true);
                openPlayerTop(player, placeholderPlayerTop, jfn3uc9ymxxfwvhj7oor.iZTqZaRK5UGoe0Z(), z, z2);
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent9 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent9.setCancelled(true);
                if (this.plugin.getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
                    this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
                } else {
                    this.plugin.getGuiManager().b4i2FbOkaKeg91LiAe6l().openNoClanHome(player);
                }
            }));
        }
        if (guiData.getItems().containsKey("online") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("online")), player.getUniqueId(), Arrays.asList("{state};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("STATE_" + String.valueOf(z).toUpperCase()))))) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent10 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent10.setCancelled(true);
                openPlayerTop(player, placeholderPlayerTop, 1, !z, z2);
            }));
        }
        if (guiData.getItems().containsKey("current_" + placeholderPlayerTop.toString().toLowerCase())) {
            GuiItemsData guiItemsData14 = guiData.getItems().get("current_" + placeholderPlayerTop.toString().toLowerCase());
            Iterator<Object> it = jfn3uc9ymxxfwvhj7oor.v8qP8fE86HMhvNuYPFjqY().iterator();
            while (it.hasNext()) {
                Optional<PlayerData> optionalP31abtwfBag2jhMH6K = this.plugin.getPlayerManager().p31abtwfBag2jhMH6K((UUID) it.next());
                if (optionalP31abtwfBag2jhMH6K.isPresent() && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData14, optionalP31abtwfBag2jhMH6K.get().getId(), (List<String>) null)) != null) {
                    guiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent11 -> {
                        try {
                            if (guiItemsData14.getClickSound() != null && !guiItemsData14.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData14.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent11.setCancelled(true);
                    }));
                }
            }
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent12 -> {
            inventoryClickEvent12.setCancelled(true);
        });
        guiCreate.open(player);
        getPlugin().getGuiManager().xtOheRiObl4QeAl().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            getPlugin().getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
    }

    public Clans getPlugin() {
        return this.plugin;
    }
}
