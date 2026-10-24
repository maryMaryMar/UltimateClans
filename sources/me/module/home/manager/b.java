package me.module.home.manager;

import java.util.Optional;
import me.module.home.Home;
import me.module.home.manager.EnumFiles.Lang;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.interfaces.AnvilAction;
import me.ulrich.clans.interfaces.AnvilModuleAPI;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Home.jar:me/module/home/manager/b.class */
public class b {
    private static byte[] __aes_key_DVGdg78M = {(byte) 123, (byte) 248, (byte) 236, (byte) 161, (byte) 235, (byte) 87, (byte) 138, (byte) 178, (byte) 143, (byte) 91, (byte) 233, (byte) 27, (byte) 129, (byte) 26, (byte) 122, (byte) 154, (byte) 195, (byte) 130, (byte) 139, (byte) 4, (byte) 115, (byte) 2, (byte) 131, (byte) 53, (byte) 140, (byte) 226, (byte) 157, (byte) 46, (byte) 13, (byte) 106, (byte) 86, (byte) 182};
    private static byte[] __aes_iv_UdoygmdE = {(byte) 42, (byte) 135, (byte) 214, (byte) 146, (byte) 245, (byte) 254, (byte) 77, (byte) 133, (byte) 248, (byte) 59, (byte) 173, (byte) 44, (byte) 8, (byte) 141, (byte) 59, (byte) 108};
    private static String __s_cache_w1alh2SM_0;
    private static String __s_cache_QNtU8y1r_1;
    private static String __s_cache_OPJpkNfU_2;
    private static String __s_cache_EfZPcmX8_3;
    private static String __s_cache_tY5QNiVP_4;
    private static String __s_cache_0fMjIfec_5;
    private static String __s_cache_RC83jzbs_6;

    public static boolean a() {
        Optional<AnvilModuleAPI> anvilAPI = Home.a().getIntegrationAPI().getAnvilAPI();
        if (anvilAPI.isPresent()) {
            return anvilAPI.get().supports();
        }
        return false;
    }

    public static boolean a(Player player, String str, boolean z, Optional<String> optional) {
        if (!a()) {
            return false;
        }
        Optional<ClanData> playerClan = Home.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        String str2 = "anvil_" + str;
        if (!Home.getModuleCore().h().a(player).containsKey(str2)) {
            MessageUtils.sendText((CommandSender) player, Home.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return false;
        }
        AddonGuiData addonGuiData = Home.getModuleCore().h().a(player).get(str2);
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Home.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Optional<ItemStack> optionalA = a(addonGuiData, "left", player);
        Optional<ItemStack> optionalA2 = a(addonGuiData, "right", player);
        Optional<ItemStack> optionalA3 = a(addonGuiData, "output", player);
        Optional optionalOf = Optional.of("Home");
        Optional<String> optionalOfNullable = optional.isPresent() ? optional : Optional.ofNullable(addonGuiData.getTitle());
        Optional<AnvilModuleAPI> anvilAPI = Home.a().getIntegrationAPI().getAnvilAPI();
        if (anvilAPI.isPresent()) {
            AnvilModuleAPI anvilModuleAPI = anvilAPI.get();
            Home.getModuleCore().d().runTaskLater(() -> {
                anvilModuleAPI.open(player, Home.a().getColorAPI().toLegacyColor((String) optionalOfNullable.orElse("&eInput")), optionalOf, optionalA, optionalA2, optionalA3, anvilClickContext -> {
                    return (anvilClickContext.getSlot() == 2 && anvilClickContext.getText().trim().isEmpty()) ? AnvilAction.keep() : AnvilAction.close();
                }).getFuture().thenAccept(anvilResult -> {
                    Home.getModuleCore().d().runTask(() -> {
                        switch (anvilResult.getType()) {
                            case COMPLETED:
                                String strTrim = anvilResult.getInput().trim();
                                if (strTrim.isEmpty()) {
                                    a(player, str, z, Optional.of(Home.getModuleCore().c().a((CommandSender) player).getString(Lang.TEXT_EMPTY)));
                                } else if (str.equalsIgnoreCase("home_create")) {
                                    if (!Home.getModuleCore().e().tryCreateHome(player, strTrim)) {
                                        Home.getModuleCore().h().e().a(player, ((ClanData) playerClan.get()).getId(), Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_CREATE_ERROR_GUI));
                                    } else {
                                        Home.getModuleCore().h().e().a(player, ((ClanData) playerClan.get()).getId(), Home.getModuleCore().c().a((CommandSender) player).getString(Lang.HOME_CREATE_SUCCESS_GUI));
                                    }
                                }
                                break;
                            case CANCELLED:
                                if (z && str.equalsIgnoreCase("home_create")) {
                                    Home.getModuleCore().h().e().a(player, ((ClanData) playerClan.get()).getId(), (String) null);
                                    break;
                                }
                                break;
                        }
                    });
                });
            }, 5L);
        }
        if (!optional.isPresent()) {
            return true;
        }
        Home.getModuleCore().d().runTaskLater(() -> {
            a(player, str, z, Optional.empty());
        }, 30L);
        return true;
    }

    private static Optional<ItemStack> a(AddonGuiData addonGuiData, String str, Player player) {
        ItemBuilder itemBuilderMountItem;
        if (addonGuiData.getItems().containsKey(str) && (itemBuilderMountItem = Home.a().getLibAPI().mountItem(addonGuiData.getItems().get(str), player.getUniqueId(), null)) != null) {
            return Optional.of(itemBuilderMountItem.build());
        }
        return Optional.empty();
    }

    private static String __unused_420() {
        return "left";
    }

    private static String __unused_421() {
        return "right";
    }

    private static String __unused_422() {
        return "output";
    }

    private static String __unused_423() {
        return "Home";
    }

    private static String __unused_424() {
        return "&eInput";
    }

    private static String __unused_425() {
        return "home_create";
    }

    private static String __unused_426() {
        return "home_create";
    }
}
