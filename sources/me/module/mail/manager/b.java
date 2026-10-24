package me.module.mail.manager;

import java.util.Optional;
import java.util.UUID;
import me.module.mail.Mail;
import me.module.mail.manager.EnumFiles.Lang;
import me.ulrich.clans.data.AddonGuiData;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.interfaces.AnvilAction;
import me.ulrich.clans.interfaces.AnvilModuleAPI;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:modules/Mail.jar:me/module/mail/manager/b.class */
public class b {
    private static byte[] __aes_key_wD6MLTvh = {(byte) 108, (byte) 130, (byte) 91, (byte) 81, (byte) 67, (byte) 129, (byte) 220, (byte) 87, (byte) 52, (byte) 190, (byte) 44, (byte) 150, (byte) 72, (byte) 14, (byte) 80, (byte) 188, (byte) 169, (byte) 81, (byte) 221, (byte) 14, (byte) 53, (byte) 8, (byte) 152, (byte) 191, (byte) 209, (byte) 212, (byte) 91, (byte) 205, (byte) 78, (byte) 15, (byte) 166, (byte) 175};
    private static byte[] __aes_iv_mjhxwxvj = {(byte) 94, (byte) 185, (byte) 55, (byte) 144, (byte) 64, (byte) 38, (byte) 122, (byte) 38, (byte) 179, (byte) 232, (byte) 235, (byte) 72, (byte) 82, (byte) 73, (byte) 193, (byte) 148};
    private static String __s_cache_EKmKztTd_0;
    private static String __s_cache_djf2SzjZ_1;
    private static String __s_cache_3FpmEeBo_2;
    private static String __s_cache_1xJSIzEZ_3;
    private static String __s_cache_aKSsOzD6_4;
    private static String __s_cache_pyKZaTju_5;
    private static String __s_cache_v4rZyd0q_6;

    public static boolean a() {
        Optional<AnvilModuleAPI> anvilAPI = Mail.a().getIntegrationAPI().getAnvilAPI();
        if (anvilAPI.isPresent()) {
            return anvilAPI.get().supports();
        }
        return false;
    }

    public static boolean a(Player player, String str, Optional<UUID> optional, boolean z, Optional<String> optional2) {
        if (!a()) {
            return false;
        }
        Optional<ClanData> playerClan = Mail.a().getPlayerAPI().getPlayerClan(player.getUniqueId());
        Optional<ClanData> clan = Mail.a().getClanAPI().getClan(optional.orElse(null));
        String str2 = "anvil_" + str;
        if (!Mail.getModuleCore().i().a(player).containsKey(str2) || !clan.isPresent()) {
            MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.GUI_ERROR));
            return false;
        }
        AddonGuiData addonGuiData = Mail.getModuleCore().i().a(player).get(str2);
        try {
            if (addonGuiData.getOpensound() != null && !addonGuiData.getOpensound().isEmpty()) {
                Mail.a().getLibAPI().playSound(player, addonGuiData.getOpensound());
            }
        } catch (Exception e) {
        }
        String title = addonGuiData.getTitle();
        String text = clan.isPresent() ? Mail.a().getClanAPI().parseText(clan.get().getLeader(), title) : Mail.a().getClanAPI().parseText(player.getUniqueId(), title);
        Optional<ItemStack> optionalA = a(addonGuiData, "left", player);
        Optional<ItemStack> optionalA2 = a(addonGuiData, "right", player);
        Optional<ItemStack> optionalA3 = a(addonGuiData, "output", player);
        Optional optionalOf = Optional.of("Text");
        Optional<String> optionalOfNullable = optional2.isPresent() ? optional2 : Optional.ofNullable(text);
        Optional<AnvilModuleAPI> anvilAPI = Mail.a().getIntegrationAPI().getAnvilAPI();
        if (anvilAPI.isPresent()) {
            AnvilModuleAPI anvilModuleAPI = anvilAPI.get();
            Mail.getModuleCore().d().runTaskLater(() -> {
                anvilModuleAPI.open(player, Mail.a().getColorAPI().toLegacyColor((String) optionalOfNullable.orElse("&eInput")), optionalOf, optionalA, optionalA2, optionalA3, anvilClickContext -> {
                    return (anvilClickContext.getSlot() == 2 && anvilClickContext.getText().trim().isEmpty()) ? AnvilAction.keep() : AnvilAction.close();
                }).getFuture().thenAccept(anvilResult -> {
                    Mail.getModuleCore().d().runTask(() -> {
                        switch (anvilResult.getType()) {
                            case COMPLETED:
                                String strTrim = anvilResult.getInput().trim();
                                if (strTrim.isEmpty()) {
                                    a(player, str, optional, z, Optional.of(Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.TEXT_EMPTY)));
                                } else if (str.equalsIgnoreCase("new_mail")) {
                                    if (!Mail.getModuleCore().e().addClanMail(player.getUniqueId(), ((ClanData) playerClan.get()).getId(), ((ClanData) clan.get()).getId(), strTrim)) {
                                        Mail.getModuleCore().i().e().b(player, ClanEnum.MailTime.ALL, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.MAIL_SEND_ERROR_GUI));
                                    } else if (!z) {
                                        MessageUtils.sendText((CommandSender) player, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.MAIL_SEND_SUCCESS));
                                    } else {
                                        Mail.getModuleCore().i().e().b(player, ClanEnum.MailTime.ALL, Mail.getModuleCore().c().a((CommandSender) player).getString(Lang.MAIL_SEND_SUCCESS_GUI));
                                    }
                                }
                                break;
                            case CANCELLED:
                                if (z && str.equalsIgnoreCase("new_mail")) {
                                    Mail.getModuleCore().i().e().b(player, ClanEnum.MailTime.ALL, (String) null);
                                    break;
                                }
                                break;
                        }
                    });
                });
            }, 5L);
        }
        if (!optional2.isPresent()) {
            return true;
        }
        Mail.getModuleCore().d().runTaskLater(() -> {
            a(player, str, optional, z, Optional.empty());
        }, 30L);
        return true;
    }

    private static Optional<ItemStack> a(AddonGuiData addonGuiData, String str, Player player) {
        ItemBuilder itemBuilderMountItem;
        if (addonGuiData.getItems().containsKey(str) && (itemBuilderMountItem = Mail.a().getLibAPI().mountItem(addonGuiData.getItems().get(str), player.getUniqueId(), null)) != null) {
            return Optional.of(itemBuilderMountItem.build());
        }
        return Optional.empty();
    }

    private static String __unused_707() {
        return "left";
    }

    private static String __unused_708() {
        return "right";
    }

    private static String __unused_709() {
        return "output";
    }

    private static String __unused_710() {
        return "Text";
    }

    private static String __unused_711() {
        return "&eInput";
    }

    private static String __unused_712() {
        return "new_mail";
    }

    private static String __unused_713() {
        return "new_mail";
    }
}
