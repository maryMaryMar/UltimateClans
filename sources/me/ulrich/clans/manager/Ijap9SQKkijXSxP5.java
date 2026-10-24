package me.ulrich.clans.manager;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import me.ulrich.clans.Clans;
import me.ulrich.clans.data.AddonGuiItemsData;
import me.ulrich.clans.interfaces.ItemParseImplement;
import me.ulrich.clans.library.gui.builder.item.ItemBuilder;
import me.ulrich.clans.library.gui.guis.Gui;
import me.ulrich.clans.library.gui.guis.GuiItem;
import me.ulrich.clans.library.gui.guis.PaginatedGui;
import me.ulrich.clans.library.gui.guis.StorageGui;
import me.ulrich.clans.manager.utils.Nbts;
import me.ulrich.clans.manager.utils.Serialize;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/Ijap9SQKkijXSxP5.class */
public class Ijap9SQKkijXSxP5 {
    private static String yySwmEwGHcbWCeC;
    private static String lLwoON12OKj4ORt0gbripe;
    private static String pTemhqCZRc9eNXhflJ;
    private static String sbG490ORlrFzHVlLYIZvq;
    private static String pnLV47JNtt18Jf5T;
    private static String hnHqGjB9pgTc6ZOI;
    private static volatile String oV7nKP7vKM6rimJX;
    private static volatile String JXgvOgEvY0oqdsIxKnk5u4;
    private static String AVwAZhOrgiKlGD6pNQo;
    private static volatile String ulvYS1bwG3F3lIVph;
    private static String qM7xCGm607MGNyWTH8mw;
    private static final byte[] kHhZ6ECxI3RSDjoC7e = {(byte) 192, (byte) 238, (byte) 130, (byte) 88, (byte) 229, (byte) 221, (byte) 231, (byte) 198, (byte) 244, (byte) 135, (byte) 8, (byte) 101, (byte) 250, (byte) 253, (byte) 51, (byte) 111};
    private static final byte[] zzftAZyRpHyPcvPR = {(byte) 192, (byte) 238, (byte) 130, (byte) 88, (byte) 229, (byte) 221, (byte) 231, (byte) 198, (byte) 244, (byte) 135, (byte) 8, (byte) 101, (byte) 250, (byte) 253, (byte) 51, (byte) 111};
    private static final byte[] P5hFr6Wd9VKklhl = {(byte) 150, (byte) 248, (byte) 212, (byte) 119, (byte) 134, (byte) 114, (byte) 103, (byte) 95, (byte) 128, (byte) 174, (byte) 124, (byte) 72, (byte) 6, (byte) 192, (byte) 175, (byte) 118};
    private static final byte[] s3Tj6MCPwTALZzdYa0JB = {(byte) 252, (byte) 218, (byte) 192, (byte) 119, (byte) 178, (byte) 51, (byte) 239, (byte) 103, (byte) 95, (byte) 57, (byte) 95, (byte) 99, (byte) 121, (byte) 61, (byte) 193, (byte) 91};
    private static final byte[] ijHq8uUmwnFdNA = {(byte) 136, (byte) 162, (byte) 32, (byte) 226, (byte) 175, (byte) 126, (byte) 238, (byte) 42, (byte) 190, (byte) 192, (byte) 103, (byte) 120, (byte) 218, (byte) 202, (byte) 124, (byte) 171, (byte) 95, (byte) 147, (byte) 120, (byte) 146, (byte) 183, (byte) 12, (byte) 15, (byte) 252, (byte) 19, (byte) 14, (byte) 118, (byte) 95, (byte) 90, (byte) 218, (byte) 42, (byte) 155, (byte) 2, (byte) 119, (byte) 172, (byte) 149, (byte) 214, (byte) 88, (byte) 18, (byte) 70, (byte) 161, (byte) 161, (byte) 156, (byte) 47, (byte) 247, (byte) 96, (byte) 238, (byte) 137};

    public static void v8qP8fE86HMhvNuYPFjqY(PaginatedGui paginatedGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        if (addonGuiItemsData.getSlot() >= 0) {
            paginatedGui.setItem(addonGuiItemsData.getSlot(), guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            paginatedGui.getFiller().fillTop(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            paginatedGui.getFiller().fillBorder(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            paginatedGui.getFiller().fillBottom(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().getSlots().size() > 0) {
            paginatedGui.setItem(addonGuiItemsData.getMineSlots().getSlots(), guiItem);
        }
    }

    public static void v8qP8fE86HMhvNuYPFjqY(StorageGui storageGui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        if (addonGuiItemsData.getSlot() >= 0) {
            storageGui.setItem(addonGuiItemsData.getSlot(), guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            storageGui.getFiller().fillTop(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            storageGui.getFiller().fillBorder(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            storageGui.getFiller().fillBottom(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().getSlots().size() > 0) {
            storageGui.setItem(addonGuiItemsData.getMineSlots().getSlots(), guiItem);
        }
    }

    public static void v8qP8fE86HMhvNuYPFjqY(Gui gui, AddonGuiItemsData addonGuiItemsData, GuiItem guiItem) {
        if (addonGuiItemsData.getMineSlots().isAll()) {
            gui.getFiller().fill(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isTop()) {
            gui.getFiller().fillTop(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBorder()) {
            gui.getFiller().fillBorder(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().isBottom()) {
            gui.getFiller().fillBottom(guiItem);
        }
        if (addonGuiItemsData.getMineSlots().getSlots().size() > 0) {
            gui.setItem(addonGuiItemsData.getMineSlots().getSlots(), guiItem);
        }
        if (addonGuiItemsData.getSlot() >= 0) {
            gui.setItem(addonGuiItemsData.getSlot(), guiItem);
        }
    }

    public static ItemBuilder v8qP8fE86HMhvNuYPFjqY(AddonGuiItemsData addonGuiItemsData, UUID uuid, List<String> list) {
        return v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, uuid).build(), uuid, list);
    }

    public static ItemBuilder v8qP8fE86HMhvNuYPFjqY(AddonGuiItemsData addonGuiItemsData, ItemStack itemStack, UUID uuid, List<String> list) {
        try {
            ItemBuilder itemBuilderFrom = itemStack != null ? ItemBuilder.from(itemStack) : v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, uuid);
            if (itemBuilderFrom == null) {
                return null;
            }
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY = v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, (Optional<UUID>) Optional.ofNullable(uuid), itemBuilderFrom);
            v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY, uuid, list);
            ItemBuilder itemBuilderV8qP8fE86HMhvNuYPFjqY2 = v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData, itemBuilderV8qP8fE86HMhvNuYPFjqY);
            v8qP8fE86HMhvNuYPFjqY(itemBuilderV8qP8fE86HMhvNuYPFjqY2);
            return itemBuilderV8qP8fE86HMhvNuYPFjqY2;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ItemBuilder v8qP8fE86HMhvNuYPFjqY(AddonGuiItemsData addonGuiItemsData, UUID uuid) {
        try {
            String material = addonGuiItemsData.getMaterial();
            if (material == null || material.trim().isEmpty()) {
                return ItemBuilder.from(Material.STONE);
            }
            if (uuid != null) {
                material = Clans.getClanCore().getHooksAPI().parsePapi(uuid, Clans.getClanCore().getClanAPI().parseText(uuid, material));
            }
            return ItemBuilder.from(new ItemStack(Material.valueOf(material.split(EV1vmvRNBwnfdQo0())[0].trim().toUpperCase()), addonGuiItemsData.getAmount()));
        } catch (Exception e) {
            return ItemBuilder.from(Material.STONE);
        }
    }

    private static ItemBuilder v8qP8fE86HMhvNuYPFjqY(AddonGuiItemsData addonGuiItemsData, ItemBuilder itemBuilder) {
        ItemStack item;
        if (addonGuiItemsData.getNbt() == null) {
            return itemBuilder;
        }
        boolean z = false;
        if (addonGuiItemsData.getNbt().getString() != null) {
            Iterator<String> it = addonGuiItemsData.getNbt().getString().iterator();
            while (it.hasNext()) {
                String[] strArrSplit = it.next().split(CohHvRxzPwneaJIQC(), 2);
                String strTrim = strArrSplit[0].trim();
                String strTrim2 = strArrSplit.length > 1 ? strArrSplit[1].trim() : "";
                if (strTrim.equalsIgnoreCase(nwib5fx6qrfTH8oEb1c9t())) {
                    z = true;
                } else {
                    Optional<ItemParseImplement> optionalJBUuLP0sWwaPyPOmogdX7l = Clans.getClanCore().getIntegrationManager().jBUuLP0sWwaPyPOmogdX7l(strTrim);
                    itemBuilder = (!optionalJBUuLP0sWwaPyPOmogdX7l.isPresent() || (item = optionalJBUuLP0sWwaPyPOmogdX7l.get().getItem(strTrim2)) == null) ? ItemBuilder.from(new Nbts().solveNbt(itemBuilder.build(), strTrim, strTrim2)) : ItemBuilder.from(item);
                }
            }
        }
        if (addonGuiItemsData.getNbt().getModel() > 0) {
            itemBuilder.model(addonGuiItemsData.getNbt().getModel());
        }
        if (z) {
            itemBuilder = v8qP8fE86HMhvNuYPFjqY(itemBuilder, true);
        }
        return itemBuilder;
    }

    public static ItemBuilder v8qP8fE86HMhvNuYPFjqY(ItemBuilder itemBuilder, boolean z) {
        return Clans.getClanCore().getGuiManager().v8qP8fE86HMhvNuYPFjqY(itemBuilder, z);
    }

    public static ItemStack v8qP8fE86HMhvNuYPFjqY(ItemStack itemStack, ItemFlag itemFlag) {
        return Clans.getClanCore().getGuiManager().v8qP8fE86HMhvNuYPFjqY(itemStack, itemFlag);
    }

    private static void v8qP8fE86HMhvNuYPFjqY(AddonGuiItemsData addonGuiItemsData, ItemBuilder itemBuilder, UUID uuid, List<String> list) {
        itemBuilder.name(Clans.getClanCore().getColorAPI().addMiniColor(Clans.getClanCore().getHooksAPI().parsePapi(uuid, Clans.getClanCore().getClanAPI().parseText(uuid, v8qP8fE86HMhvNuYPFjqY(addonGuiItemsData.getName(), list)))));
        itemBuilder.glow(addonGuiItemsData.isGlow());
        if (addonGuiItemsData.getLore() == null || addonGuiItemsData.getLore().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = addonGuiItemsData.getLore().iterator();
        while (it.hasNext()) {
            arrayList.add(Clans.getClanCore().getColorAPI().addMiniColor(Clans.getClanCore().getHooksAPI().parsePapi(uuid, Clans.getClanCore().getClanAPI().parseText(uuid, v8qP8fE86HMhvNuYPFjqY(it.next(), list)))));
        }
        itemBuilder.lore(arrayList);
    }

    private static void v8qP8fE86HMhvNuYPFjqY(ItemBuilder itemBuilder) {
        Clans.getClanCore().getGuiManager().v8qP8fE86HMhvNuYPFjqY(itemBuilder);
    }

    private static ItemBuilder v8qP8fE86HMhvNuYPFjqY(AddonGuiItemsData addonGuiItemsData, Optional<UUID> optional, ItemBuilder itemBuilder) {
        String texture = addonGuiItemsData.getTexture();
        if (texture == null || texture.isEmpty() || texture.equalsIgnoreCase(SjD3pl9CyMPYmgwm3FO())) {
            return itemBuilder;
        }
        if (optional.isPresent()) {
            texture = Clans.getClanCore().getClanAPI().parseText(optional.get(), texture);
        }
        try {
            if (texture.startsWith(qlzLQySINtPYoZqFFS())) {
                itemBuilder = ItemBuilder.from(new ItemStack(Material.valueOf(texture.split(LL0YtkWXVu6eUR5IvsF())[1]), 1));
            } else if (texture.startsWith(G5xSIh3PtunVrBxy9t8())) {
                String strSubstring = texture.substring(hHzLABBbetVnYhVvu5().length());
                if (!strSubstring.isEmpty() && strSubstring.length() > 16) {
                    itemBuilder = ItemBuilder.from(ItemBuilder.skull().texture(strSubstring).build());
                }
            } else if (texture.startsWith(ytrvwTihfJ3no11())) {
                ItemStack itemStackItemStackFromBase64 = new Serialize().itemStackFromBase64(texture.substring(pKIJHAvAQhokgNeeD().length()));
                itemBuilder = itemStackItemStackFromBase64 != null ? ItemBuilder.from(itemStackItemStackFromBase64) : ItemBuilder.from(Material.valueOf(Clans.getClanCore().getLibAPI().getDefaultBanner()));
            } else if (texture.length() > 16) {
                itemBuilder = ItemBuilder.from(ItemBuilder.skull().texture(texture).build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemBuilder;
    }

    public static String v8qP8fE86HMhvNuYPFjqY(String str, List<String> list) {
        if (list != null) {
            try {
                Iterator<String> it = list.iterator();
                while (it.hasNext()) {
                    String[] strArrSplit = it.next().split(wZ9yRhY3vW0WUpypP());
                    str = str.replace(strArrSplit[0], strArrSplit[1]);
                }
                return str;
            } catch (Exception e) {
            }
        }
        return str;
    }

    private static String hPd7li5VqOOgWH8(byte[] bArr) {
        return "";
    }

    private static String EV1vmvRNBwnfdQo0() {
        return ":";
    }

    private static String CohHvRxzPwneaJIQC() {
        return ":";
    }

    private static String nwib5fx6qrfTH8oEb1c9t() {
        return "HideTooltip";
    }

    private static String SjD3pl9CyMPYmgwm3FO() {
        return "null";
    }

    private static String qlzLQySINtPYoZqFFS() {
        return "material:";
    }

    private static String LL0YtkWXVu6eUR5IvsF() {
        return ":";
    }

    private static String G5xSIh3PtunVrBxy9t8() {
        return "base64:";
    }

    private static String hHzLABBbetVnYhVvu5() {
        return "base64:";
    }

    private static String ytrvwTihfJ3no11() {
        return "serialized:";
    }

    private static String pKIJHAvAQhokgNeeD() {
        return "serialized:";
    }

    private static String wZ9yRhY3vW0WUpypP() {
        return ";";
    }
}
