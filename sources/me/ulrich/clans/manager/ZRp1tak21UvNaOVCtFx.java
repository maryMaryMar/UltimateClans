package me.ulrich.clans.manager;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.AnvilSession;
import me.ulrich.clans.data.ClanData;
import me.ulrich.clans.data.ClanEnum;
import me.ulrich.clans.data.CommandData;
import me.ulrich.clans.data.GuiData;
import me.ulrich.clans.interfaces.AnvilAction;
import me.ulrich.clans.interfaces.AnvilModuleAPI;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.manager.DTKXb4fQF6nDgxzg.tjCyMSV004ze7Mc.DTKXb4fQF6nDgxzg.ECMfR2SxjZy2nLBVbPf;
import me.ulrich.clans.manager.EnumFiles.Lang;
import me.ulrich.clans.manager.utils.MessageUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/ZRp1tak21UvNaOVCtFx.class */
public class ZRp1tak21UvNaOVCtFx {
    private final Clans v8qP8fE86HMhvNuYPFjqY;
    private static volatile String uRByWpY4BblkmjZY;
    private static volatile String WQizHMYXqnTiPucHYR;
    private static String Rx889W4kXoJ5E3J;
    private static String LBEj7ayN6Rh6XORQOx;
    private static String kw3u63LZK3pdNQdhb0Q;
    private static volatile String tArEtNFsbI4g17UKthCj;
    private static volatile String J5a4oOrN2dIwE9QN;
    private static String TIu8xjs9cCBEtM4kra6;
    private static String ZFjrwEQ83OjoQ0;
    private static volatile String wB9AsLHZvN1UcnXAUYiW;
    private static String Gx4PtNctbLLukCF2Pbm5lF;
    private static String UhkSkFkDKs1DkpZgmyJ2;
    private static volatile String WWE5BRPgBIPHRPBXxTNtnW;
    private static final byte[] miIXFgLcSC79toOH0pQ7i4 = {(byte) 21, (byte) 115, (byte) 60, (byte) 154, (byte) 178, (byte) 234, (byte) 63, (byte) 248, (byte) 218, (byte) 137, (byte) 225, (byte) 175, (byte) 156, (byte) 236, (byte) 60, (byte) 176};
    private static final byte[] RKfWwuAEgBFgjxl = {(byte) 110, (byte) 41, (byte) 227, (byte) 170, (byte) 111, (byte) 206, (byte) 243, (byte) 244, (byte) 55, (byte) 185, (byte) 121, (byte) 93, (byte) 175, (byte) 138, (byte) 74, (byte) 35};
    private static final byte[] AhOXCp0ZZhvt5yMl = {(byte) 114, (byte) 11, (byte) 70, (byte) 249, (byte) 83, (byte) 97, (byte) 74, (byte) 196, (byte) 133, (byte) 81, (byte) 239, (byte) 158, (byte) 163, (byte) 135, (byte) 248, (byte) 206};
    private static final byte[] tLu2ZerwFRNsnD = {(byte) 14, (byte) 122, (byte) 173, (byte) 174, (byte) 114, (byte) 41, (byte) 42, (byte) 24, (byte) 134, (byte) 253, (byte) 206, (byte) 224, (byte) 114, (byte) 31, (byte) 118, (byte) 114};
    private static final byte[] OBnZGUzfe0fBX2 = {(byte) 154, (byte) 198, (byte) 25, (byte) 130, (byte) 199, (byte) 88, (byte) 68, (byte) 100, (byte) 214, (byte) 177, (byte) 200, (byte) 67, (byte) 204, (byte) 137, (byte) 136, (byte) 109};
    private static final byte[] swGYjCrvaKWqcIv = {(byte) 73, (byte) 171, (byte) 94, (byte) 68, (byte) 82, (byte) 189, (byte) 66, (byte) 105, (byte) 2, (byte) 151, (byte) 174, (byte) 145, (byte) 5, (byte) 91, (byte) 110, (byte) 77};
    private static final byte[] ogGEx7F1q6TiiXbcW = {(byte) 230, (byte) 232, (byte) 213, (byte) 66, (byte) 0, (byte) 103, (byte) 89, (byte) 3, (byte) 145, (byte) 127, (byte) 105, (byte) 191, (byte) 232, (byte) 75, (byte) 80, (byte) 20, (byte) 4, (byte) 210, (byte) 136, (byte) 126, (byte) 111, (byte) 213, (byte) 229, (byte) 162, (byte) 69, (byte) 162, (byte) 220, (byte) 240, (byte) 86, (byte) 71, (byte) 34, (byte) 220};
    private static final byte[] WUovcVNNR81pPG = {(byte) 35, (byte) 20, (byte) 191, (byte) 1, (byte) 247, (byte) 139, (byte) 187, (byte) 151, (byte) 181, (byte) 187, (byte) 220, (byte) 4, (byte) 207, (byte) 180, (byte) 133, (byte) 231};

    public ZRp1tak21UvNaOVCtFx(Clans clans) {
        this.v8qP8fE86HMhvNuYPFjqY = clans;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY() {
        Optional<AnvilModuleAPI> optionalUn3NRLL6aWivTcbodkcK = Clans.getClanCore().getIntegrationManager().Un3NRLL6aWivTcbodkcK();
        if (optionalUn3NRLL6aWivTcbodkcK.isPresent()) {
            return optionalUn3NRLL6aWivTcbodkcK.get().supports();
        }
        return false;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, ClanEnum.ChatDataType chatDataType, boolean z, Optional<String> optional) {
        if (!v8qP8fE86HMhvNuYPFjqY()) {
            return false;
        }
        Optional<ClanData> optionalCDW4Fj1iwdIXEOqWjiJSR = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().CDW4Fj1iwdIXEOqWjiJSR(player.getUniqueId());
        String str = "anvil_" + chatDataType.toString().toLowerCase();
        if (!jBUuLP0sWwaPyPOmogdX7l().getFiles().v8qP8fE86HMhvNuYPFjqY(player).containsKey(str)) {
            MessageUtils.sendText((CommandSender) player, jBUuLP0sWwaPyPOmogdX7l().getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.GUI_ERROR));
            return false;
        }
        GuiData guiData = jBUuLP0sWwaPyPOmogdX7l().getFiles().v8qP8fE86HMhvNuYPFjqY(player).get(str);
        try {
            if (guiData.getOpensound() != null && !guiData.getOpensound().isEmpty()) {
                this.v8qP8fE86HMhvNuYPFjqY.getLibManager().v8qP8fE86HMhvNuYPFjqY(player, guiData.getOpensound());
            }
        } catch (Exception e) {
        }
        Optional<ItemStack> optionalV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(guiData, wbQ1MPJEapSGKOYVjB(), player);
        Optional<ItemStack> optionalV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(guiData, w28IUBOVQD3uA4AU9aiel(), player);
        Optional<ItemStack> optionalV8qP8fE86HMhvNuYPFjqY3 = v8qP8fE86HMhvNuYPFjqY(guiData, h1VV2RzS4ihtYoiR6JpFvJ(), player);
        Optional<String> optionalV8qP8fE86HMhvNuYPFjqY4 = v8qP8fE86HMhvNuYPFjqY(chatDataType, player, optionalCDW4Fj1iwdIXEOqWjiJSR);
        Optional<String> optionalOfNullable = optional.isPresent() ? optional : Optional.ofNullable(guiData.getTitle());
        Optional<AnvilModuleAPI> optionalUn3NRLL6aWivTcbodkcK = Clans.getClanCore().getIntegrationManager().Un3NRLL6aWivTcbodkcK();
        if (optionalUn3NRLL6aWivTcbodkcK.isPresent()) {
            AnvilModuleAPI anvilModuleAPI = optionalUn3NRLL6aWivTcbodkcK.get();
            this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
                AnvilSession anvilSessionOpen = anvilModuleAPI.open(player, this.v8qP8fE86HMhvNuYPFjqY.getColorManager().iZTqZaRK5UGoe0Z((String) optionalOfNullable.orElse(QBRyV39nT5CA633QzX())), optionalV8qP8fE86HMhvNuYPFjqY4, optionalV8qP8fE86HMhvNuYPFjqY, optionalV8qP8fE86HMhvNuYPFjqY2, optionalV8qP8fE86HMhvNuYPFjqY3, anvilClickContext -> {
                    return (anvilClickContext.getSlot() == 2 && anvilClickContext.getText().trim().isEmpty()) ? AnvilAction.keep() : AnvilAction.close();
                });
                jBUuLP0sWwaPyPOmogdX7l().getGuiManager().xtOheRiObl4QeAl().add(player);
                anvilSessionOpen.getFuture().thenAccept(anvilResult -> {
                    this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                        jBUuLP0sWwaPyPOmogdX7l().getGuiManager().xtOheRiObl4QeAl().remove(player);
                        switch (RuVgd0Dnv0ddhdcWL.jBUuLP0sWwaPyPOmogdX7l[anvilResult.getType().ordinal()]) {
                            case 1:
                                String strTrim = anvilResult.getInput().trim();
                                if (!strTrim.isEmpty()) {
                                    v8qP8fE86HMhvNuYPFjqY(player, chatDataType, strTrim, (Optional<ClanData>) optionalCDW4Fj1iwdIXEOqWjiJSR, z);
                                } else {
                                    v8qP8fE86HMhvNuYPFjqY(player, chatDataType, z, Optional.of(this.v8qP8fE86HMhvNuYPFjqY.getFiles().jBUuLP0sWwaPyPOmogdX7l(Optional.of(player.getUniqueId())).getString(Lang.TEXT_EMPTY)));
                                }
                                break;
                            case 2:
                                if (z) {
                                    v8qP8fE86HMhvNuYPFjqY(player, chatDataType, (Optional<ClanData>) optionalCDW4Fj1iwdIXEOqWjiJSR);
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
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            v8qP8fE86HMhvNuYPFjqY(player, chatDataType, z, Optional.empty());
        }, 30L);
        return true;
    }

    public boolean v8qP8fE86HMhvNuYPFjqY(Player player, String str, Optional<String> optional, Consumer<String> consumer, Runnable runnable) {
        if (!v8qP8fE86HMhvNuYPFjqY()) {
            return false;
        }
        Optional<AnvilModuleAPI> optionalUn3NRLL6aWivTcbodkcK = Clans.getClanCore().getIntegrationManager().Un3NRLL6aWivTcbodkcK();
        if (!optionalUn3NRLL6aWivTcbodkcK.isPresent()) {
            return false;
        }
        this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTaskLater((Entity) player, () -> {
            AnvilSession anvilSessionOpen = ((AnvilModuleAPI) optionalUn3NRLL6aWivTcbodkcK.get()).open(player, this.v8qP8fE86HMhvNuYPFjqY.getColorManager().iZTqZaRK5UGoe0Z(str == null ? "" : str), optional, Optional.empty(), Optional.empty(), Optional.empty(), anvilClickContext -> {
                return (anvilClickContext.getSlot() == 2 && anvilClickContext.getText().trim().isEmpty()) ? AnvilAction.keep() : AnvilAction.close();
            });
            jBUuLP0sWwaPyPOmogdX7l().getGuiManager().xtOheRiObl4QeAl().add(player);
            anvilSessionOpen.getFuture().thenAccept(anvilResult -> {
                this.v8qP8fE86HMhvNuYPFjqY.getTaskManager().xtOheRiObl4QeAl().runTask((Entity) player, () -> {
                    jBUuLP0sWwaPyPOmogdX7l().getGuiManager().xtOheRiObl4QeAl().remove(player);
                    switch (RuVgd0Dnv0ddhdcWL.jBUuLP0sWwaPyPOmogdX7l[anvilResult.getType().ordinal()]) {
                        case 1:
                            String strTrim = anvilResult.getInput() == null ? "" : anvilResult.getInput().trim();
                            if (!strTrim.isEmpty() && consumer != null) {
                                consumer.accept(strTrim);
                            } else if (runnable != null) {
                                runnable.run();
                            }
                            break;
                        case 2:
                            if (runnable != null) {
                                runnable.run();
                            }
                            break;
                    }
                });
            });
        }, 2L);
        return true;
    }

    private Optional<ItemStack> v8qP8fE86HMhvNuYPFjqY(GuiData guiData, String str, Player player) {
        ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY;
        if (guiData.getItems().containsKey(str) && (itemBuilderV8qP8fE86HMhvNuYPFjqY = this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().v8qP8fE86HMhvNuYPFjqY(guiData.getItems().get(str), player.getUniqueId(), (List<String>) null)) != null) {
            return Optional.of(itemBuilderV8qP8fE86HMhvNuYPFjqY.build());
        }
        return Optional.empty();
    }

    private Optional<String> v8qP8fE86HMhvNuYPFjqY(ClanEnum.ChatDataType chatDataType, Player player, Optional<ClanData> optional) {
        switch (RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY[chatDataType.ordinal()]) {
            case 1:
                return Optional.of(player.getName());
            case 2:
                return Optional.of((String) optional.map((v0) -> {
                    return v0.getTagNoColor();
                }).orElse(l0J0AetwqJLFBu()));
            case 3:
                return Optional.of((String) optional.map((v0) -> {
                    return v0.getDesc();
                }).orElse(wQ5xRkXxebvlrmfn()));
            case 4:
                return Optional.of(GP4tdrfoCCMf981());
            case 5:
                return Optional.of(YL36rHyhBnh3E2j());
            default:
                return Optional.empty();
        }
    }

    private void v8qP8fE86HMhvNuYPFjqY(Player player, ClanEnum.ChatDataType chatDataType, String str, Optional<ClanData> optional, boolean z) {
        CommandData commandData = this.v8qP8fE86HMhvNuYPFjqY.getCommandManager().ZwrsrwOCXRUscW6Q().get(v8qP8fE86HMhvNuYPFjqY(chatDataType));
        boolean zZwrsrwOCXRUscW6Q = false;
        switch (RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY[chatDataType.ordinal()]) {
            case 1:
                zZwrsrwOCXRUscW6Q = this.v8qP8fE86HMhvNuYPFjqY.getPlayerManager().v8qP8fE86HMhvNuYPFjqY(player, str);
                break;
            case 2:
                zZwrsrwOCXRUscW6Q = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().v8qP8fE86HMhvNuYPFjqY(player, str);
                break;
            case 3:
                zZwrsrwOCXRUscW6Q = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().jBUuLP0sWwaPyPOmogdX7l(player, str);
                break;
            case 4:
                optional.ifPresent(clanData -> {
                    this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanSearchMembersInvite(player, str, null);
                });
                return;
            case 5:
                zZwrsrwOCXRUscW6Q = this.v8qP8fE86HMhvNuYPFjqY.getClanManager().ZwrsrwOCXRUscW6Q(player, str);
                break;
        }
        if (!zZwrsrwOCXRUscW6Q) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.error, null);
        } else if (zZwrsrwOCXRUscW6Q) {
            MessageUtils.sendCommandJson(player, commandData, ClanEnum.MsgUsage.success, null);
        }
        if (z && this.v8qP8fE86HMhvNuYPFjqY.isUseGUI()) {
            v8qP8fE86HMhvNuYPFjqY(player, chatDataType, optional);
        } else {
            player.closeInventory();
        }
    }

    private String v8qP8fE86HMhvNuYPFjqY(ClanEnum.ChatDataType chatDataType) {
        switch (RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY[chatDataType.ordinal()]) {
            case 1:
                return fLe5lI7QwDqbeR02ZyS();
            case 2:
                return p5xjSKIZFXt4qXwaEalY();
            case 3:
                return oIg1v4Bf5DdtfoVns0w9();
            case 4:
                return JknmR30ckPx0k10hXEBI6();
            case 5:
                return cGPSSKSr3159J3EDK9aY();
            default:
                return "";
        }
    }

    private void v8qP8fE86HMhvNuYPFjqY(Player player, ClanEnum.ChatDataType chatDataType, Optional<ClanData> optional) {
        player.closeInventory();
        switch (RuVgd0Dnv0ddhdcWL.v8qP8fE86HMhvNuYPFjqY[chatDataType.ordinal()]) {
            case 1:
                this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().Un3NRLL6aWivTcbodkcK().openPlayerProfileSettings(player, null);
                break;
            case 2:
            case 3:
                this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().lGGwXL678c4Kv7skJb5NiE().openClanActions(player, null);
                break;
            case 4:
                optional.ifPresent(clanData -> {
                    this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().b4i2FbOkaKeg91LiAe6l().openClanSearchMembersInvite(player, null, null);
                });
                break;
            case 5:
                this.v8qP8fE86HMhvNuYPFjqY.getGuiManager().b4i2FbOkaKeg91LiAe6l().openNoClanHome(player);
                break;
        }
    }

    public Clans jBUuLP0sWwaPyPOmogdX7l() {
        return this.v8qP8fE86HMhvNuYPFjqY;
    }

    private static String wbQ1MPJEapSGKOYVjB() {
        return "left";
    }

    private static String w28IUBOVQD3uA4AU9aiel() {
        return "right";
    }

    private static String h1VV2RzS4ihtYoiR6JpFvJ() {
        return "output";
    }

    private static String l0J0AetwqJLFBu() {
        return "Tag";
    }

    private static String wQ5xRkXxebvlrmfn() {
        return "Desc";
    }

    private static String GP4tdrfoCCMf981() {
        return "Name";
    }

    private static String YL36rHyhBnh3E2j() {
        return "Tag";
    }

    private static String fLe5lI7QwDqbeR02ZyS() {
        return "nickname";
    }

    private static String p5xjSKIZFXt4qXwaEalY() {
        return "modtag";
    }

    private static String oIg1v4Bf5DdtfoVns0w9() {
        return "desc";
    }

    private static String JknmR30ckPx0k10hXEBI6() {
        return "member";
    }

    private static String cGPSSKSr3159J3EDK9aY() {
        return "create";
    }

    private static String QBRyV39nT5CA633QzX() {
        return "&eInput";
    }
}
