package me.module.levelup.manager.a;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.module.levelup.Levelup;
import me.module.levelup.manager.EnumFiles.Lang;
import me.module.levelup.manager.b.b;
import me.module.levelup.manager.b.c;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.RequerimentData;
import me.ulrich.clans.interfaces.RewardsModuleAPI;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Levelup.jar:me/module/levelup/manager/a/a.class */
public class a {
    private static byte[] __aes_key_oGLvNbkL = {(byte) 5, (byte) 248, (byte) 253, (byte) 132, (byte) 232, (byte) 166, (byte) 45, (byte) 108, (byte) 127, (byte) 172, (byte) 133, (byte) 206, (byte) 45, (byte) 209, (byte) 100, (byte) 179, (byte) 164, (byte) 90, (byte) 89, (byte) 77, (byte) 0, (byte) 45, (byte) 164, (byte) 154, (byte) 67, (byte) 91, (byte) 186, (byte) 125, (byte) 10, (byte) 219, (byte) 250, (byte) 35};
    private static byte[] __aes_iv_ogfpO6GW = {(byte) 98, (byte) 25, (byte) 93, (byte) 176, (byte) 70, (byte) 114, (byte) 226, (byte) 74, (byte) 192, (byte) 230, (byte) 191, (byte) 238, (byte) 241, (byte) 151, (byte) 218, (byte) 186};
    private static String __s_cache_O7VVd19i_0;
    private static String __s_cache_DcPvs25X_1;
    private static String __s_cache_rnYyGs3P_2;
    private static String __s_cache_rynyWoHV_3;
    private static String __s_cache_OQxdZIUe_4;
    private static String __s_cache_fCOVsWkO_5;
    private static String __s_cache_yl9Otf5o_6;
    private static String __s_cache_aWRO3Mcv_7;
    private static String __s_cache_lZPjFet5_8;
    private static String __s_cache_pBUZlAxc_9;
    private static String __s_cache_BBhPNX45_10;
    private static String __s_cache_MLbaC6SF_11;
    private static String __s_cache_RjfteacK_12;
    private static String __s_cache_DGjbYKn0_13;
    private static String __s_cache_HGjKxlSv_14;
    private static String __s_cache_qPzZ7SfV_15;
    private static String __s_cache_UkmmDjdu_16;
    private static String __s_cache_h8vLuguE_17;
    private static String __s_cache_bGM7JHlp_18;
    private static String __s_cache_CAunRhHe_19;
    private static String __s_cache_ci56ix1c_20;
    private static String __s_cache_Bu3LnsTI_21;
    private static String __s_cache_h2dRt1dk_22;
    private static String __s_cache_25hBrVNC_23;
    private static String __s_cache_hA9DBhjr_24;
    private static String __s_cache_TrtUViUO_25;
    private static String __s_cache_DB3xZidp_26;
    private static String __s_cache_XnY9QJIv_27;
    private static String __s_cache_CI4vGpka_28;
    private static String __s_cache_1TzofFbA_29;
    private static String __s_cache_dQSRXtkL_30;
    private static String __s_cache_tnmQxE8h_31;
    private static String __s_cache_GfXdEVbV_32;
    private static String __s_cache_HwxGI6hv_33;
    private static String __s_cache_sHBxikLN_34;
    private static String __s_cache_ykIKP7Mf_35;
    private static String __s_cache_m7dKc4F3_36;
    private static String __s_cache_25oHc0uU_37;
    private static String __s_cache_2cIQVuAq_38;
    private static String __s_cache_a5lwDfP4_39;
    private static String __s_cache_y1yoXL9B_40;
    private static String __s_cache_uU4tTb2O_41;
    private static String __s_cache_a0ke3iOn_42;
    private static String __s_cache_po0zUwzw_43;
    private static String __s_cache_SQSJXEbZ_44;
    private static String __s_cache_Kq6cUc5M_45;
    private static String __s_cache_tUX7WqOq_46;
    private static String __s_cache_qvSBC6Cx_47;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, int i, Optional<String> optional) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        int i2;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderA4;
        AddonGuiItemsData addonGuiItemsData5;
        ItemBuilder itemBuilderA5;
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Levelup.getModuleCore().h().a(player).containsKey("levelup_home")) {
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Levelup.getModuleCore().h().a(player).get("levelup_home");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Levelup.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        if (i < 1) {
            i = 1;
        }
        int i3 = i;
        AddonGuiItemsData addonGuiItemsData6 = addonGuiData.getItems().get("current");
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(addonGuiItemsData6.getSlot()));
        if (addonGuiItemsData6.getMineSlots().getSlots() != null) {
            arrayList.addAll(addonGuiItemsData6.getMineSlots().getSlots());
        }
        int i4 = Levelup.getModuleCore().c().i().getInt("Level.points.max_level");
        if (i4 < 0) {
            i4 = 0;
        }
        int i5 = i4;
        ArrayList arrayList2 = new ArrayList();
        for (int i6 = 0; i6 < i4; i6++) {
            arrayList2.add(Integer.valueOf(i6));
        }
        String title = addonGuiData.getTitle();
        if (optional.isPresent() && Levelup.a().getGuiAPI().useTitleAlerts()) {
            title = optional.get();
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Levelup.a().getColorAPI().addMiniColor(Levelup.a().getHooksAPI().parsePapi(player, Levelup.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill2") && (itemBuilderA5 = Levelup.getModuleCore().h().a((addonGuiItemsData5 = addonGuiData.getItems().get("fill2")), (UUID) null, (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData5, itemBuilderA5.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA4 = Levelup.getModuleCore().h().a((addonGuiItemsData4 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
            }));
        }
        Levelup.a().getGuiAPI().insertItens(guiCreate, "General", "levelup_home", player);
        b bVar = new b(arrayList2, arrayList.size());
        bVar.a(i3);
        HashMap map = new HashMap();
        int size = ((i3 - 1) * arrayList.size()) + 1;
        for (int i7 = 0; i7 < arrayList.size() && (i2 = size + i7) <= i4; i7++) {
            map.put((Integer) arrayList.get(i7), Integer.valueOf(i2));
        }
        boolean zHasPlayerClanRequeriments = Levelup.getModuleCore().e().hasPlayerClanRequeriments(player.getUniqueId());
        Optional<Integer> optionalClanNextLevel = Levelup.getModuleCore().e().clanNextLevel(playerClan.get().getId());
        if (addonGuiData.getItems().containsKey("current")) {
            map.forEach((num, num2) -> {
                Optional<RequerimentData> requeriment = Levelup.getModuleCore().e().getRequeriment(num2.intValue());
                List<String> listA = c.a(me.module.levelup.manager.c.b(player.getUniqueId(), num2.intValue()));
                AddonGuiItemsData addonGuiItemsData7 = addonGuiData.getItems().get("current");
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add("{level};" + num2);
                if (!requeriment.isPresent() || !Levelup.getModuleCore().c().i().getBoolean("Level.requeriments.show_command_rewards")) {
                    arrayList3.add("{REWARDS}; ");
                }
                if (requeriment.isPresent() && requeriment.get().getDescription().size() > 0) {
                    arrayList3.add("{DESC}; ");
                }
                if (Levelup.getModuleCore().c().i().getBoolean("Level.requeriments.rewards_only_once") && ((ClanData) playerClan.get()).getMaxlevel() >= num2.intValue() && optionalClanNextLevel.isPresent() && optionalClanNextLevel.get() == num2) {
                    arrayList3.add("{has_rewards};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_REWARD_ALREADY_COLLECTED));
                } else if (requeriment.isPresent()) {
                    arrayList3.add("{has_rewards};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.valueOf("TRANSLACTION_NOYES_" + String.valueOf(requeriment.get().getRewards().size() > 0).toUpperCase())));
                } else {
                    arrayList3.add("{has_rewards};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.valueOf("TRANSLACTION_NOYES_" + String.valueOf("false").toUpperCase())));
                }
                AddonGuiItemsData addonGuiItemsDataM386clone = addonGuiItemsData7.m386clone();
                if (optionalClanNextLevel.isPresent() && num2 == optionalClanNextLevel.get()) {
                    if (zHasPlayerClanRequeriments) {
                        arrayList3.add("{ACTION};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_GUI));
                    } else {
                        arrayList3.add("{ACTION};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_NEED_GUI));
                    }
                    a(player, (ClanData) playerClan.get(), num2.intValue(), requeriment, addonGuiItemsDataM386clone, arrayList3, listA, true);
                } else if (optionalClanNextLevel.isPresent() && num2.intValue() > ((Integer) optionalClanNextLevel.get()).intValue()) {
                    arrayList3.add("{ACTION};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_ADVANCE_ACTION_GUI));
                    arrayList3.add("{REWARDS}; ");
                    if (Levelup.getModuleCore().c().i().getBoolean("Level.requeriments.hide_upcoming_requirements")) {
                        arrayList3.add("{REQUERIMENTS};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_ADVANCE_REQUIRES_GUI));
                        arrayList3.add("{DESCRIPTION};" + Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_ADVANCE_REQUIRES_GUI));
                    } else {
                        a(player, (ClanData) playerClan.get(), num2.intValue(), requeriment, addonGuiItemsDataM386clone, arrayList3, listA, false);
                    }
                }
                ItemBuilder itemBuilderA6 = Levelup.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), arrayList3);
                if (itemBuilderA6 != null) {
                    if (Levelup.getModuleCore().e().clanIsLevelPassed(((ClanData) playerClan.get()).getId(), num2.intValue())) {
                        if (Levelup.getModuleCore().e().isRequerimentSurprise(num2.intValue())) {
                            Optional<RewardsModuleAPI> rewards = Levelup.a().getIntegrationAPI().getRewards();
                            if (rewards.isPresent()) {
                                if (rewards.get().hasClanCollectedSurprise(((ClanData) playerClan.get()).getId(), num2.intValue())) {
                                    addonGuiItemsDataM386clone = addonGuiData.getItems().get("surprise_collected");
                                    itemBuilderA6 = Levelup.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), Arrays.asList("{level};" + num2));
                                } else {
                                    addonGuiItemsDataM386clone = addonGuiData.getItems().get("surprise");
                                    itemBuilderA6 = Levelup.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), Arrays.asList("{level};" + num2));
                                }
                            } else if (num2.intValue() == i5) {
                                addonGuiItemsDataM386clone = addonGuiData.getItems().get("finallist");
                                itemBuilderA6 = Levelup.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), Arrays.asList("{level};" + num2));
                            } else {
                                addonGuiItemsDataM386clone = addonGuiData.getItems().get("levelup");
                                itemBuilderA6 = Levelup.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), Arrays.asList("{level};" + num2));
                            }
                        } else if (num2.intValue() == i5) {
                            addonGuiItemsDataM386clone = addonGuiData.getItems().get("finallist");
                            itemBuilderA6 = Levelup.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), Arrays.asList("{level};" + num2));
                        } else {
                            addonGuiItemsDataM386clone = addonGuiData.getItems().get("levelup");
                            itemBuilderA6 = Levelup.getModuleCore().h().a(addonGuiItemsDataM386clone, player.getUniqueId(), Arrays.asList("{level};" + num2));
                        }
                    }
                    if (i5 <= itemBuilderA6.build().getType().getMaxStackSize()) {
                        itemBuilderA6.amount(num2.intValue());
                    }
                    AddonGuiItemsData addonGuiItemsData8 = addonGuiItemsDataM386clone;
                    guiCreate.setItem(num.intValue(), itemBuilderA6.asGuiItem(inventoryClickEvent3 -> {
                        try {
                            if (addonGuiItemsData8.getClickSound() != null && !addonGuiItemsData8.getClickSound().isEmpty()) {
                                Levelup.a().getLibAPI().playSound(player, addonGuiItemsData8.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent3.setCancelled(true);
                        if (zHasPlayerClanRequeriments && optionalClanNextLevel.isPresent() && optionalClanNextLevel.get() == num2) {
                            if (Levelup.a().getModAPI().playerHasPermission(player.getUniqueId(), Levelup.getModuleCore().c().i().getString("Config.Permissions.up.name"))) {
                                b(player, i3, Optional.empty());
                                return;
                            } else {
                                a(player, i3, Optional.of(Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE_GUI)));
                                MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_PERMISSION_ROLE));
                                return;
                            }
                        }
                        if (Levelup.a().getIntegrationAPI().getRewards().isPresent()) {
                            boolean zAddClanReward = false;
                            if (((ClanData) playerClan.get()).getLevel() >= num2.intValue()) {
                                Optional<RewardsModuleAPI> rewards2 = Levelup.a().getIntegrationAPI().getRewards();
                                if (rewards2.isPresent()) {
                                    boolean zHasClanCollectedSurprise = rewards2.get().hasClanCollectedSurprise(((ClanData) playerClan.get()).getId(), num2.intValue());
                                    if (Levelup.getModuleCore().e().isRequerimentSurprise(num2.intValue()) && !zHasClanCollectedSurprise) {
                                        zAddClanReward = rewards2.get().addClanReward(((ClanData) playerClan.get()).getId(), player.getUniqueId(), Optional.of(Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REWARDS_SURPRISE, Arrays.asList("{level};" + String.valueOf(num2)))), Optional.of(Material.CHEST), ((RequerimentData) requeriment.get()).getSurprise(), Optional.of("SURPRISE_" + num2));
                                    }
                                }
                                if (zAddClanReward) {
                                    a(player, i3, Optional.of(Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_SUCCESS_GUI)));
                                    MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_SUCCESS));
                                } else {
                                    a(player, i3, Optional.of(Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_ERROR_GUI)));
                                    MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_ERROR));
                                }
                            }
                        }
                    }));
                }
            });
        }
        if (addonGuiData.getItems().containsKey("previous") && bVar.c() && (itemBuilderA3 = Levelup.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                a(player, bVar.e(), Optional.empty());
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && bVar.b() && (itemBuilderA2 = Levelup.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                a(player, bVar.d(), Optional.empty());
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Levelup.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                Levelup.getModuleCore().d().runTask(player.getLocation(), () -> {
                    player.chat("/clan");
                });
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        guiCreate.open(player);
        Levelup.getModuleCore().h().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Levelup.getModuleCore().h().c().remove(player);
        });
        if (optional.isPresent() && Levelup.a().getGuiAPI().useTitleAlerts()) {
            Levelup.getModuleCore().d().runTaskLater(() -> {
                a(player, i3, Optional.empty());
            }, 20L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void b(Player player, int i, Optional<String> optional) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        Optional<ClanData> playerClan = Levelup.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        if (!playerClan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        Optional<Integer> optionalClanNextLevel = Levelup.getModuleCore().e().clanNextLevel(playerClan.get().getId());
        boolean zHasPlayerClanRequeriments = Levelup.getModuleCore().e().hasPlayerClanRequeriments(player.getUniqueId());
        if (!Levelup.getModuleCore().h().a(player).containsKey("levelup_confirm")) {
            MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Levelup.getModuleCore().h().a(player).get("levelup_confirm");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Levelup.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        if (optional.isPresent() && Levelup.a().getGuiAPI().useTitleAlerts()) {
            title = optional.get();
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Levelup.a().getColorAPI().addMiniColor(Levelup.a().getHooksAPI().parsePapi(player, Levelup.a().getClanAPI().parseText(player.getUniqueId(), title)), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA3 = Levelup.getModuleCore().h().a((addonGuiItemsData3 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Levelup.a().getGuiAPI().insertItens(guiCreate, "General", "levelup_confirm", player);
        if (addonGuiData.getItems().containsKey("confirm") && (itemBuilderA2 = Levelup.getModuleCore().h().a((addonGuiItemsData2 = addonGuiData.getItems().get("confirm")), player.getUniqueId(), (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent2 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent2.setCancelled(true);
                if (!zHasPlayerClanRequeriments || !optionalClanNextLevel.isPresent()) {
                    a(player, 1, Optional.empty());
                    return;
                }
                Optional<RequerimentData> requeriment = Levelup.getModuleCore().e().getRequeriment(((Integer) optionalClanNextLevel.get()).intValue());
                if (!Levelup.getModuleCore().e().checkUpgradeLevel(player.getUniqueId())) {
                    b(player, i, Optional.of(Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_ERROR_GUI)));
                    return;
                }
                int iIntValue = ((Integer) optionalClanNextLevel.get()).intValue();
                if (!Levelup.a().getIntegrationAPI().getRewards().isPresent() && ((ClanData) playerClan.get()).getLevel() >= iIntValue && requeriment.isPresent() && ((ClanData) playerClan.get()).getLevel() >= iIntValue) {
                    me.module.levelup.manager.c.a(((ClanData) playerClan.get()).getId(), requeriment.get().getSurprise());
                    MessageUtils.sendText((CommandSender) player, Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_SURPRISE_COLLECTED_SUCCESS));
                }
                a(player, i, Optional.of(Levelup.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_SUCCESS_GUI)));
            }));
        }
        if (addonGuiData.getItems().containsKey("cancel") && (itemBuilderA = Levelup.getModuleCore().h().a((addonGuiItemsData = addonGuiData.getItems().get("cancel")), player.getUniqueId(), (List<String>) null)) != null) {
            Levelup.getModuleCore().h().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Levelup.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                a(player, 1, Optional.empty());
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent4 -> {
            inventoryClickEvent4.setCancelled(true);
        });
        guiCreate.open(player);
        Levelup.getModuleCore().h().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Levelup.getModuleCore().h().c().remove(player);
        });
        if (optional.isPresent() && Levelup.a().getGuiAPI().useTitleAlerts()) {
            Levelup.getModuleCore().d().runTaskLater(() -> {
                b(player, i, Optional.empty());
            }, 20L);
        }
    }

    private void a(Player player, ClanData clanData, int i, Optional<RequerimentData> optional, AddonGuiItemsData addonGuiItemsData, List<String> list, List<String> list2, boolean z) {
        ArrayList arrayList = new ArrayList();
        List<String> lore = addonGuiItemsData.getLore();
        if (lore == null || lore.isEmpty()) {
            return;
        }
        for (String str : lore) {
            if (str.contains("{DESCRIPTION}")) {
                if (optional.isPresent() && optional.get().getDescription() != null) {
                    arrayList.addAll(optional.get().getDescription());
                }
            } else if (str.contains("{REQUERIMENTS}")) {
                Iterator<String> it = list2.iterator();
                while (it.hasNext()) {
                    arrayList.add(" " + it.next());
                }
            } else if (!str.contains("{REWARDS}")) {
                arrayList.add(Levelup.a().getHooksAPI().parsePapi(player.getUniqueId(), Levelup.a().getClanAPI().parseText(player.getUniqueId(), me.module.levelup.manager.c.a(str, list))));
            } else if (z && optional.isPresent() && optional.get().getRewards() != null && !optional.get().getRewards().isEmpty()) {
                if (Levelup.getModuleCore().c().i().getBoolean("Level.requeriments.rewards_only_once") && clanData.getMaxlevel() >= i) {
                    arrayList.add("");
                } else if (Levelup.getModuleCore().c().i().getBoolean("Level.requeriments.show_command_rewards")) {
                    Iterator<String> it2 = optional.get().getRewards().iterator();
                    while (it2.hasNext()) {
                        arrayList.add(" <gray>- " + it2.next());
                    }
                    arrayList.add("");
                }
            }
        }
        addonGuiItemsData.setLore(arrayList);
    }

    private static String __unused_1015() {
        return "levelup_home";
    }

    private static String __unused_1016() {
        return "levelup_home";
    }

    private static String __unused_1017() {
        return "current";
    }

    private static String __unused_1018() {
        return "Level.points.max_level";
    }

    private static String __unused_1019() {
        return "fill2";
    }

    private static String __unused_1020() {
        return "fill2";
    }

    private static String __unused_1021() {
        return "fill";
    }

    private static String __unused_1022() {
        return "fill";
    }

    private static String __unused_1023() {
        return "General";
    }

    private static String __unused_1024() {
        return "levelup_home";
    }

    private static String __unused_1025() {
        return "current";
    }

    private static String __unused_1026() {
        return "previous";
    }

    private static String __unused_1027() {
        return "previous";
    }

    private static String __unused_1028() {
        return "next";
    }

    private static String __unused_1029() {
        return "next";
    }

    private static String __unused_1030() {
        return "back";
    }

    private static String __unused_1031() {
        return "back";
    }

    private static String __unused_1032() {
        return "levelup_confirm";
    }

    private static String __unused_1033() {
        return "levelup_confirm";
    }

    private static String __unused_1034() {
        return "fill";
    }

    private static String __unused_1035() {
        return "fill";
    }

    private static String __unused_1036() {
        return "General";
    }

    private static String __unused_1037() {
        return "levelup_confirm";
    }

    private static String __unused_1038() {
        return "confirm";
    }

    private static String __unused_1039() {
        return "confirm";
    }

    private static String __unused_1040() {
        return "cancel";
    }

    private static String __unused_1041() {
        return "cancel";
    }

    private static String __unused_1042() {
        return "{DESCRIPTION}";
    }

    private static String __unused_1043() {
        return "{REQUERIMENTS}";
    }

    private static String __unused_1044() {
        return "{REWARDS}";
    }

    private static String __unused_1045() {
        return "Level.requeriments.rewards_only_once";
    }

    private static String __unused_1046() {
        return "Level.requeriments.show_command_rewards";
    }

    private static String __unused_1047() {
        return "/clan";
    }

    private static String __unused_1048() {
        return "current";
    }

    private static String __unused_1049() {
        return "Level.requeriments.show_command_rewards";
    }

    private static String __unused_1050() {
        return "{REWARDS}; ";
    }

    private static String __unused_1051() {
        return "{DESC}; ";
    }

    private static String __unused_1052() {
        return "Level.requeriments.rewards_only_once";
    }

    private static String __unused_1053() {
        return "false";
    }

    private static String __unused_1054() {
        return "{REWARDS}; ";
    }

    private static String __unused_1055() {
        return "Level.requeriments.hide_upcoming_requirements";
    }

    private static String __unused_1056() {
        return "surprise_collected";
    }

    private static String __unused_1057() {
        return "surprise";
    }

    private static String __unused_1058() {
        return "finallist";
    }

    private static String __unused_1059() {
        return "levelup";
    }

    private static String __unused_1060() {
        return "finallist";
    }

    private static String __unused_1061() {
        return "levelup";
    }

    private static String __unused_1062() {
        return "Config.Permissions.up.name";
    }
}
