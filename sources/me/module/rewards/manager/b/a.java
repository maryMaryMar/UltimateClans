package me.module.rewards.manager.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import me.module.rewards.Rewards;
import me.module.rewards.manager.EnumFiles.Lang;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.data.PlayerData;
import me.ulrich.clans.data.RewardsData;
import me.ulrich.clans.library.gui.builder.gui.ChestGuiBuilder;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.manager.utils.MessageUtils;
import me.ulrich.clans.manager.utils.Times;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Rewards.jar:me/module/rewards/manager/b/a.class */
public class a {
    private static byte[] __aes_key_ETGFOUGR = {(byte) 0, (byte) 152, (byte) 226, (byte) 15, (byte) 249, (byte) 168, (byte) 91, (byte) 46, (byte) 13, (byte) 4, (byte) 230, (byte) 240, (byte) 115, (byte) 227, (byte) 191, (byte) 232, (byte) 85, (byte) 56, (byte) 138, (byte) 33, (byte) 176, (byte) 177, (byte) 211, (byte) 224, (byte) 92, (byte) 22, (byte) 116, (byte) 108, (byte) 129, (byte) 168, (byte) 186, (byte) 121};
    private static byte[] __aes_iv_mwhZLsBu = {(byte) 94, (byte) 73, (byte) 162, (byte) 234, (byte) 107, (byte) 93, (byte) 40, (byte) 214, (byte) 61, (byte) 125, (byte) 182, (byte) 28, (byte) 54, (byte) 123, (byte) 78, (byte) 53};
    private static String __s_cache_LtJ0CHXC_0;
    private static String __s_cache_Eom2VBOo_1;
    private static String __s_cache_WmzxvffV_2;
    private static String __s_cache_yzwNpo5J_3;
    private static String __s_cache_AHCULA78_4;
    private static String __s_cache_SgLA1lW7_5;
    private static String __s_cache_U2jIhABy_6;
    private static String __s_cache_faH7Smnh_7;
    private static String __s_cache_E4D6Kr4i_8;
    private static String __s_cache_tfAjA5F7_9;
    private static String __s_cache_AVahXTPF_10;
    private static String __s_cache_uOKlLVnB_11;
    private static String __s_cache_huRA9hiy_12;
    private static String __s_cache_7eNGl24b_13;
    private static String __s_cache_1hEbTWj8_14;
    private static String __s_cache_gBpr2eIf_15;
    private static String __s_cache_Sp6rEGpY_16;
    private static String __s_cache_ojiybPLT_17;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(Player player, int i, Optional<String> optional) {
        AddonGuiItemsData addonGuiItemsData;
        ItemBuilder itemBuilderA;
        AddonGuiItemsData addonGuiItemsData2;
        ItemBuilder itemBuilderA2;
        AddonGuiItemsData addonGuiItemsData3;
        ItemBuilder itemBuilderA3;
        AddonGuiItemsData addonGuiItemsData4;
        ItemBuilder itemBuilderA4;
        if (!Rewards.a().getPlayerAPI().getPlayerClan(player.getUniqueId()).isPresent()) {
            MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a((CommandSender) player).getString(Lang.PLAYER_DONT_HAVE_CLAN));
            return;
        }
        if (!Rewards.getModuleCore().g().a(player).containsKey("levelup_rewards")) {
            MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return;
        }
        AddonGuiData addonGuiData = Rewards.getModuleCore().g().a(player).get("levelup_rewards");
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Rewards.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        if (i < 1) {
            i = 1;
        }
        int i2 = i;
        List<RewardsData> playerRewards = Rewards.getModuleCore().i().getPlayerRewards(player.getUniqueId());
        new ArrayList();
        ArrayList arrayList = new ArrayList(playerRewards);
        String title = addonGuiData.getTitle();
        if (optional.isPresent() && Rewards.a().getGuiAPI().useTitleAlerts()) {
            title = optional.get();
        }
        Gui guiCreate = ((ChestGuiBuilder) Gui.gui().title(Rewards.a().getColorAPI().addMiniColor(Rewards.a().getHooksAPI().parsePapi(player, Rewards.a().getClanAPI().parseText(player.getUniqueId(), title.replace("{amount}", String.valueOf(arrayList.size())))), true))).rows(addonGuiData.getRows()).create();
        if (addonGuiData.getItems().containsKey("fill") && (itemBuilderA4 = Rewards.getModuleCore().g().a((addonGuiItemsData4 = addonGuiData.getItems().get("fill")), (UUID) null, (List<String>) null)) != null) {
            Rewards.getModuleCore().g().a(guiCreate, addonGuiItemsData4, itemBuilderA4.asGuiItem(inventoryClickEvent -> {
                try {
                    if (addonGuiItemsData4.getClickSound() != null && !addonGuiItemsData4.getClickSound().isEmpty()) {
                        Rewards.a().getLibAPI().playSound(player, addonGuiItemsData4.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent.setCancelled(true);
            }));
        }
        Rewards.a().getGuiAPI().insertItens(guiCreate, "General", "levelup_rewards", player);
        me.module.rewards.manager.c.a aVar = new me.module.rewards.manager.c.a(arrayList, addonGuiData.getPageSize());
        aVar.a(i2);
        if (addonGuiData.getItems().containsKey("current")) {
            Iterator<Object> it = aVar.a().iterator();
            while (it.hasNext()) {
                RewardsData rewardsData = (RewardsData) it.next();
                AddonGuiItemsData addonGuiItemsData5 = addonGuiData.getItems().get("current");
                AddonGuiItemsData addonGuiItemsDataM386clone = addonGuiItemsData5.m386clone();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                List<String> lore = addonGuiItemsDataM386clone.getLore();
                if (lore != null && !lore.isEmpty()) {
                    for (int i3 = 0; i3 < lore.size(); i3++) {
                        String str = lore.get(i3);
                        if (!str.contains("{REWARDS}") || rewardsData.getRewards().size() <= 0) {
                            arrayList3.add(str);
                        } else {
                            rewardsData.getRewards().iterator().forEachRemaining(str2 -> {
                                arrayList3.add(" <gray>- " + Rewards.a().getClanAPI().parseText(player.getUniqueId(), str2.replace("%player%", player.getName())));
                            });
                            arrayList3.add("");
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    addonGuiItemsDataM386clone.setLore(arrayList3);
                }
                if (rewardsData.getDescription().isPresent()) {
                    arrayList2.add("{description};" + String.valueOf(rewardsData.getDescription().get()));
                } else {
                    arrayList2.add("{description};" + String.valueOf(Rewards.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REWARDS_DEFAULT_TEXT)));
                }
                Optional<PlayerData> playerData = Rewards.a().getPlayerAPI().getPlayerData(rewardsData.getSender());
                if (playerData.isPresent()) {
                    arrayList2.add("{sender};" + String.valueOf(playerData.get().getName()));
                }
                arrayList2.add("{date};" + String.valueOf(new Times().unixToDate(Long.valueOf(rewardsData.getDate() * 1000), Rewards.getModuleCore().c().j().getString("Config.date_format_short"))));
                if (rewardsData.getIcon().isPresent()) {
                    addonGuiItemsDataM386clone.setMaterial(rewardsData.getIcon().get().name());
                }
                ItemBuilder itemBuilderA5 = Rewards.getModuleCore().g().a(addonGuiItemsDataM386clone, player.getUniqueId(), arrayList2);
                if (itemBuilderA5 != null) {
                    guiCreate.addItem(itemBuilderA5.asGuiItem(inventoryClickEvent2 -> {
                        try {
                            if (addonGuiItemsData5.getClickSound() != null && !addonGuiItemsData5.getClickSound().isEmpty()) {
                                Rewards.a().getLibAPI().playSound(player, addonGuiItemsData5.getClickSound());
                            }
                        } catch (Exception e2) {
                        }
                        inventoryClickEvent2.setCancelled(true);
                        if (Rewards.getModuleCore().i().playerCollectReward(player.getUniqueId(), rewardsData.getId())) {
                            a(player, i2, Optional.of(Rewards.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_SUCCESS_GUI)));
                            MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_SUCCESS));
                        } else {
                            a(player, i2, Optional.of(Rewards.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_ERROR_GUI)));
                            MessageUtils.sendText((CommandSender) player, Rewards.getModuleCore().c().a((CommandSender) player).getString(Lang.HELP_REQUIRES_LEVELUP_REWARD_COLLECTED_ERROR));
                        }
                    }));
                }
            }
        }
        if (addonGuiData.getItems().containsKey("previous") && aVar.c() && (itemBuilderA3 = Rewards.getModuleCore().g().a((addonGuiItemsData3 = addonGuiData.getItems().get("previous")), player.getUniqueId(), (List<String>) null)) != null) {
            Rewards.getModuleCore().g().a(guiCreate, addonGuiItemsData3, itemBuilderA3.asGuiItem(inventoryClickEvent3 -> {
                try {
                    if (addonGuiItemsData3.getClickSound() != null && !addonGuiItemsData3.getClickSound().isEmpty()) {
                        Rewards.a().getLibAPI().playSound(player, addonGuiItemsData3.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent3.setCancelled(true);
                a(player, aVar.e(), Optional.empty());
            }));
        }
        if (addonGuiData.getItems().containsKey("next") && aVar.b() && (itemBuilderA2 = Rewards.getModuleCore().g().a((addonGuiItemsData2 = addonGuiData.getItems().get("next")), player.getUniqueId(), (List<String>) null)) != null) {
            Rewards.getModuleCore().g().a(guiCreate, addonGuiItemsData2, itemBuilderA2.asGuiItem(inventoryClickEvent4 -> {
                try {
                    if (addonGuiItemsData2.getClickSound() != null && !addonGuiItemsData2.getClickSound().isEmpty()) {
                        Rewards.a().getLibAPI().playSound(player, addonGuiItemsData2.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent4.setCancelled(true);
                a(player, aVar.d(), Optional.empty());
            }));
        }
        if (addonGuiData.getItems().containsKey("back") && (itemBuilderA = Rewards.getModuleCore().g().a((addonGuiItemsData = addonGuiData.getItems().get("back")), player.getUniqueId(), (List<String>) null)) != null) {
            Rewards.getModuleCore().g().a(guiCreate, addonGuiItemsData, itemBuilderA.asGuiItem(inventoryClickEvent5 -> {
                try {
                    if (addonGuiItemsData.getClickSound() != null && !addonGuiItemsData.getClickSound().isEmpty()) {
                        Rewards.a().getLibAPI().playSound(player, addonGuiItemsData.getClickSound());
                    }
                } catch (Exception e2) {
                }
                inventoryClickEvent5.setCancelled(true);
                Rewards.a().getGuiAPI().openClanHome(player);
            }));
        }
        guiCreate.setDefaultClickAction(inventoryClickEvent6 -> {
            inventoryClickEvent6.setCancelled(true);
        });
        guiCreate.open(player);
        Rewards.getModuleCore().g().c().add(player);
        guiCreate.setCloseGuiAction(inventoryCloseEvent -> {
            Rewards.getModuleCore().g().c().remove(player);
        });
        if (optional.isPresent() && Rewards.a().getGuiAPI().useTitleAlerts()) {
            Rewards.getModuleCore().d().runTaskLater(() -> {
                a(player, i2, Optional.empty());
            }, 20L);
        }
    }

    private static String __unused_1465() {
        return "levelup_rewards";
    }

    private static String __unused_1466() {
        return "levelup_rewards";
    }

    private static String __unused_1467() {
        return "{amount}";
    }

    private static String __unused_1468() {
        return "fill";
    }

    private static String __unused_1469() {
        return "fill";
    }

    private static String __unused_1470() {
        return "General";
    }

    private static String __unused_1471() {
        return "levelup_rewards";
    }

    private static String __unused_1472() {
        return "current";
    }

    private static String __unused_1473() {
        return "current";
    }

    private static String __unused_1474() {
        return "{REWARDS}";
    }

    private static String __unused_1475() {
        return "Config.date_format_short";
    }

    private static String __unused_1476() {
        return "previous";
    }

    private static String __unused_1477() {
        return "previous";
    }

    private static String __unused_1478() {
        return "next";
    }

    private static String __unused_1479() {
        return "next";
    }

    private static String __unused_1480() {
        return "back";
    }

    private static String __unused_1481() {
        return "back";
    }

    private static String __unused_1482() {
        return "%player%";
    }
}
