package me.ulrich.clans.manager.gui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.data.GuiItemsData;
import me.ulrich.clans.data.InviteData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.gui.PaginatedBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.t5552Hwi8n9ivJHRmI;
import me.ulrich.clans.manager.utils.CooldownAPI;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/gui/ProfileGuiManager.class */
public class ProfileGuiManager {
    private Clans plugin;

    public ProfileGuiManager(Clans clans) {
        this.plugin = clans;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openProfileInvites(Player player, String str) {
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
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("invites")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("invites");
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
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), title)), true))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
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
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "invites", player);
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
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                openPlayerProfile(player, player.getUniqueId(), null);
            }));
        }
        List<InviteData> listIZTqZaRK5UGoe0Z = this.plugin.getPlayerInviteManager().iZTqZaRK5UGoe0Z(player.getUniqueId());
        if (listIZTqZaRK5UGoe0Z != null) {
            if (guiData.getItems().containsKey("current")) {
                final GuiItemsData currentItemData = guiData.getItems().get("current");
                for (InviteData inviteData : listIZTqZaRK5UGoe0Z) {
                    Optional<ClanData> optionalIZTqZaRK5UGoe0Z = this.plugin.getClanManager().iZTqZaRK5UGoe0Z(inviteData.getClanID());
                    if (optionalIZTqZaRK5UGoe0Z.isPresent() && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(currentItemData, optionalIZTqZaRK5UGoe0Z.get().getLeader(), (List<String>) null)) != null) {
                        paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent5 -> {
                            try {
                                if (currentItemData.getClickSound() != null && !currentItemData.getClickSound().isEmpty()) {
                                    this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, currentItemData.getClickSound());
                                }
                            } catch (Exception e2) {
                            }
                            inventoryClickEvent5.setCancelled(true);
                            if (inventoryClickEvent5.getClick().equals(ClickType.RIGHT)) {
                                if (this.plugin.getPlayerInviteManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId(), inviteData.getId())) {
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_DENY_SUCCESS_INVITE));
                                    openProfileInvites(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_DENY_SUCCESS_INVITE_GUI));
                                    return;
                                } else {
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_DENY_ERROR_INVITE));
                                    openProfileInvites(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_DENY_ERROR_INVITE_GUI));
                                    return;
                                }
                            }
                            if (inventoryClickEvent5.getClick().equals(ClickType.LEFT)) {
                                if (!this.plugin.getClanManager().o1VU1x4DAlrEtGKZ3jAdhE(((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getId())) {
                                    openProfileInvites(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_MAX_MEMBERS_LEVEL_GUI));
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_MAX_MEMBERS_LEVEL));
                                    return;
                                }
                                if (((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getBanned().contains(player.getUniqueId())) {
                                    openProfileInvites(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ACCEPT_ERROR_INVITE_GUI));
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ARE_BANNED));
                                    return;
                                }
                                if (this.plugin.getPlayerManager().vVo2VUvxrriklPdRxI(player.getUniqueId())) {
                                    openProfileInvites(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ACCEPT_ERROR_INVITE_GUI));
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_IS_CLAN_LEADER));
                                } else if (((ClanData) optionalIZTqZaRK5UGoe0Z.get()).getMembers().contains(player.getUniqueId())) {
                                    openProfileInvites(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ACCEPT_ERROR_INVITE_GUI));
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_ALREADY_PARTICIPATING));
                                } else if (this.plugin.getPlayerInviteManager().zJnaNCVQSgEShq(player.getUniqueId(), inviteData.getId())) {
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ACCEPT_SUCCESS_INVITE));
                                    openPlayerProfile(player, player.getUniqueId(), this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ACCEPT_SUCCESS_INVITE_GUI));
                                } else {
                                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ACCEPT_ERROR_INVITE));
                                    openProfileInvites(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ACCEPT_ERROR_INVITE_GUI));
                                }
                            }
                        }));
                    }
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
            openProfileInvites(player, null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openPlayerProfile(Player player, UUID uuid, String str) {
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
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("player_profile")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("player_profile");
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
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(uuid, getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(uuid, title)), true))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "player_profile", player);
        if (guiData.getItems().containsKey("head") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("head")), uuid, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("invites") && player.getUniqueId().equals(uuid) && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("invites")), uuid, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                openProfileInvites(player, null);
            }));
        }
        if (guiData.getItems().containsKey("settings") && player.getUniqueId().equals(uuid) && this.plugin.getPlayerManager().b4i2FbOkaKeg91LiAe6l(player.getUniqueId()) && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("settings")), uuid, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                openPlayerProfileSettings(player, null);
            }));
        }
        if (guiData.getItems().containsKey("languages") && player.getUniqueId().equals(uuid) && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("languages")), uuid, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                openPlayerLanguages(player, Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("permissions") && this.plugin.getPlayerManager().zJnaNCVQSgEShq(uuid) && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("permissions")), uuid, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                openPlayerPermissions(player, uuid, Optional.empty());
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("back")), uuid, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                if (getPlugin().getPlayerManager().zJnaNCVQSgEShq(player.getUniqueId())) {
                    getPlugin().getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanHome(player);
                } else {
                    getPlugin().getGuiManager().b4i2FbOkaKeg91LiAe6l().openNoClanHome(player);
                }
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
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openPlayerProfile(player, uuid, null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openPlayerPermissions(Player player, UUID uuid, Optional<String> optional) {
        GuiItemsData guiItemsData;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        GuiItemsData guiItemsData2;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        GuiItemsData guiItemsData3;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY3;
        GuiItemsData guiItemsData4;
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY4;
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("player_permissions")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("player_permissions");
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
        PaginatedGui paginatedGuiCreate = ((PaginatedBuilder) Gui.paginated().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getHooksAPI().parsePapi(uuid, this.plugin.getClanAPI().parseText(uuid, title)), true))).rows(guiData.getRows()).pageSize(guiData.getPageSize()).create();
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
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
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "player_permissions", player);
        HashMap<String, Boolean> mapZJnaNCVQSgEShq = this.plugin.getModerationManager().zJnaNCVQSgEShq(uuid);
        mapZJnaNCVQSgEShq.entrySet().stream().filter(entry -> {
            return Boolean.TRUE.equals(entry.getValue());
        }).map((v0) -> {
            return v0.getKey();
        }).sorted((v0, v1) -> {
            return v0.compareToIgnoreCase(v1);
        }).toList().iterator().forEachRemaining(str -> {
            Material materialV8qP8fE86HMhvNuYPFjqY;
            if (guiData.getItems().containsKey("current")) {
                GuiItemsData guiItemsData5 = guiData.getItems().get("current");
                ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY5 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiItemsData5.m427clone(), uuid, Arrays.asList("{permission};" + str.toString().replace("-", " "), "{value};" + this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.valueOf("TRANSLACTION_NOYES_" + String.valueOf(mapZJnaNCVQSgEShq.get(str)).toUpperCase()))));
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY5 != null && (materialV8qP8fE86HMhvNuYPFjqY = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(mapZJnaNCVQSgEShq.get(str))))) != null) {
                    itemBuilderV8qP8fE86HMhvNuYPFjqY5.build().setType(materialV8qP8fE86HMhvNuYPFjqY);
                }
                if (itemBuilderV8qP8fE86HMhvNuYPFjqY5 != null) {
                    paginatedGuiCreate.addItem(itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent2 -> {
                        try {
                            if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                                this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent2.setCancelled(true);
                    }));
                }
            }
        });
        if (guiData.getItems().containsKey("previous") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
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
                openPlayerProfile(player, uuid, null);
            }));
        }
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openPlayerLanguages(player, Optional.empty());
            }, 20L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openPlayerProfileSettings(Player player, String str) {
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
        Optional<PlayerData> optionalP31abtwfBag2jhMH6K = getPlugin().getPlayerManager().p31abtwfBag2jhMH6K(player.getUniqueId());
        if (!optionalP31abtwfBag2jhMH6K.isPresent()) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("player_settings")) {
            MessageUtils.sendText((CommandSender) player, getPlugin().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = getPlugin().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("player_settings");
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
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(this.plugin.getColorManager().v8qP8fE86HMhvNuYPFjqY(getPlugin().getHooksManager().parsePapi(player.getUniqueId(), getPlugin().getClanManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), title)), true))).rows(guiData.getRows()).create();
        if (guiData.getItems().containsKey("fill2") && (itemBuilderV8qP8fE86HMhvNuYPFjqY7 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData7 = guiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData7, itemBuilderV8qP8fE86HMhvNuYPFjqY7.asGuiItem(inventoryClickEvent -> {
                try {
                    if (guiItemsData7.getClickSound() != null && !guiItemsData7.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData7.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (guiData.getItems().containsKey("fill") && (itemBuilderV8qP8fE86HMhvNuYPFjqY6 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData6 = guiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData6, itemBuilderV8qP8fE86HMhvNuYPFjqY6.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (guiItemsData6.getClickSound() != null && !guiItemsData6.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData6.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, "General", "player_settings", player);
        if (guiData.getItems().containsKey("nickname") && this.plugin.getCommandManager().ZwrsrwOCXRUscW6Q().containsKey("nickname") && (itemBuilderV8qP8fE86HMhvNuYPFjqY5 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData5 = guiData.getItems().get("nickname")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData5, itemBuilderV8qP8fE86HMhvNuYPFjqY5.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (guiItemsData5.getClickSound() != null && !guiItemsData5.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                if (!inventoryClickEvent3.getClick().equals(ClickType.RIGHT)) {
                    if (inventoryClickEvent3.getClick().equals(ClickType.LEFT)) {
                        if (this.plugin.getTaskManager().iZTqZaRK5UGoe0Z()) {
                            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                                player.closeInventory();
                            }, 2L);
                        } else {
                            guiCreate.close(player);
                        }
                        t5552Hwi8n9ivJHRmI.v8qP8fE86HMhvNuYPFjqY(player, ClanEnum.ChatDataType.CHANGENICKNAME, null, true, true, 0);
                        return;
                    }
                    return;
                }
                if (((PlayerData) optionalP31abtwfBag2jhMH6K.get()).getNickname() == null || ((PlayerData) optionalP31abtwfBag2jhMH6K.get()).getNickname().isEmpty()) {
                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_NICKNAME_DEFAULT));
                    openPlayerProfileSettings(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_NICKNAME_DEFAULT_GUI));
                } else if (this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), (String) null)) {
                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_CHANGED_NICKNAME));
                    openPlayerProfileSettings(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_CHANGED_NICKNAME_GUI));
                } else {
                    MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ERROR_CHANGE_NICKNAME));
                    openPlayerProfileSettings(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_ERROR_CHANGE_NICKNAME_GUI));
                }
            }));
        }
        if (guiData.getItems().containsKey("invite") && (itemBuilderV8qP8fE86HMhvNuYPFjqY4 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData4 = guiData.getItems().get("invite")), player.getUniqueId(), (List<String>) null)) != null) {
            Material materialV8qP8fE86HMhvNuYPFjqY = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getString("Settings.icon_" + String.valueOf(optionalP31abtwfBag2jhMH6K.get().getSettings().isInvitations())));
            if (materialV8qP8fE86HMhvNuYPFjqY != null) {
                itemBuilderV8qP8fE86HMhvNuYPFjqY4.build().setType(materialV8qP8fE86HMhvNuYPFjqY);
                itemBuilderV8qP8fE86HMhvNuYPFjqY4.model(this.plugin.getFiles().V3DAV3orG0so43Del8NdO().getInt("Settings.icon_" + String.valueOf(optionalP31abtwfBag2jhMH6K.get().getSettings().isInvitations()) + "_model"));
            }
            itemBuilderV8qP8fE86HMhvNuYPFjqY4.glow(optionalP31abtwfBag2jhMH6K.get().getSettings().isInvitations());
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData4, itemBuilderV8qP8fE86HMhvNuYPFjqY4.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (guiItemsData4.getClickSound() != null && !guiItemsData4.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                this.plugin.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player.getUniqueId(), ClanEnum.PlayerSettingsType.INVITATIONS, ClanEnum.SettingsFlagsAccept.TOGGLE);
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS));
                openPlayerProfileSettings(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI));
            }));
        }
        if (CooldownAPI.isInCooldown(player.getUniqueId(), "skin_update")) {
            if (guiData.getItems().containsKey("skin_cooldown") && (itemBuilderV8qP8fE86HMhvNuYPFjqY = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData = guiData.getItems().get("skin_cooldown")), player.getUniqueId(), Arrays.asList("%time%;" + String.valueOf(CooldownAPI.getTimeLeft(player.getUniqueId(), "skin_update"))))) != null) {
                this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY.asGuiItem(inventoryClickEvent5 -> {
                    try {
                        if (guiItemsData.getClickSound() != null && !guiItemsData.getClickSound().isEmpty()) {
                            this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData.getClickSound());
                        }
                    } catch (Exception e2) {
                    }
                    inventoryClickEvent5.setCancelled(true);
                }));
            }
        } else if (guiData.getItems().containsKey("skin") && (itemBuilderV8qP8fE86HMhvNuYPFjqY3 = getPlugin().getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData3 = guiData.getItems().get("skin")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData3, itemBuilderV8qP8fE86HMhvNuYPFjqY3.asGuiItem(inventoryClickEvent6 -> {
                try {
                    if (guiItemsData3.getClickSound() != null && !guiItemsData3.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent6.setCancelled(true);
                new CooldownAPI(player.getUniqueId(), "skin_update", this.plugin.getFiles().p31abtwfBag2jhMH6K().getInt("Config.player.skin.custom_cooldown")).start();
                this.plugin.getPlayerManager().HX3ZfRb1nSpNq57s7x5ui(player.getUniqueId());
                MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_SKIN_IN_UPDATE));
                openPlayerProfileSettings(player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_PLAYER_SKIN_IN_UPDATE_GUI));
            }));
        }
        if (guiData.getItems().containsKey("back") && (itemBuilderV8qP8fE86HMhvNuYPFjqY2 = this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY((guiItemsData2 = guiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiCreate, guiItemsData2, itemBuilderV8qP8fE86HMhvNuYPFjqY2.asGuiItem(inventoryClickEvent7 -> {
                try {
                    if (guiItemsData2.getClickSound() != null && !guiItemsData2.getClickSound().isEmpty()) {
                        this.plugin.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent7.setCancelled(true);
                openPlayerProfile(player, player.getUniqueId(), null);
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
        if (str == null || !this.plugin.getGuiAPI().useTitleAlerts()) {
            return;
        }
        this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            openPlayerProfileSettings(player, null);
        }, 20L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void openPlayerLanguages(Player player, Optional<String> optional) {
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
        if (!this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey("player_languages")) {
            MessageUtils.sendText((CommandSender) player, this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return;
        }
        GuiData guiData = this.plugin.getFiles().v8qP8fE86HMhvNuYPFjqY(player).get("player_languages");
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
        this.plugin.getGuiManager().v8qP8fE86HMhvNuYPFjqY(paginatedGuiCreate, "General", "player_languages", player);
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
                        this.plugin.getPlayerManager().jBUuLP0sWwaPyPOmogdX7l(player.getUniqueId(), Optional.of(str));
                        openPlayerLanguages(player, Optional.of(this.plugin.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.CLAN_CHANGED_SETTINGS_GUI)));
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
                openPlayerProfile(player, player.getUniqueId(), null);
            }));
        }
        paginatedGuiCreate.open(player);
        this.plugin.getGuiManager().xtOheRiObl4QeAl().add(player);
        paginatedGuiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            this.plugin.getGuiManager().xtOheRiObl4QeAl().remove(player);
        });
        if (optional.isPresent() && this.plugin.getGuiAPI().useTitleAlerts()) {
            this.plugin.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                openPlayerLanguages(player, Optional.empty());
            }, 20L);
        }
    }

    public Clans getPlugin() {
        return this.plugin;
    }
}
