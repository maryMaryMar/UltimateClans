package me.ulrich.clans.manager.utils;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/* JADX INFO: loaded from: UltimateClans-9.3.1-REV-1.0-RELEASE.jar:me/ulrich/clans/manager/utils/Items.class */
public class Items {
    private static String knXbAtvvgVveiuXroC;
    private static final byte[] N4zUuAfePFOUgxn = {(byte) 219, (byte) 214, (byte) 80, (byte) 209, (byte) 115, (byte) 95, (byte) 188, (byte) 92, (byte) 47, (byte) 219, (byte) 28, (byte) 102, (byte) 92, (byte) 147, (byte) 213, (byte) 184};
    private static final byte[] cy24Ln4bb42CdFU = {(byte) 156, (byte) 105, (byte) 193, (byte) 75, (byte) 207, (byte) 33, (byte) 205, (byte) 150, (byte) 17, (byte) 121, (byte) 26, (byte) 191, (byte) 77, (byte) 237, (byte) 197, (byte) 75, (byte) 177, (byte) 106, (byte) 51, (byte) 24, (byte) 172, (byte) 179, (byte) 28, (byte) 247, (byte) 105, (byte) 215, (byte) 9, (byte) 85, (byte) 248, (byte) 242, (byte) 148, (byte) 147};
    private static final byte[] qeST0se82WbvF0Iy = {(byte) 148, (byte) 183, (byte) 29, (byte) 162, (byte) 181, (byte) 85, (byte) 167, (byte) 29, (byte) 116, (byte) 71, (byte) 76, (byte) 233, (byte) 38, (byte) 254, (byte) 70, (byte) 122};

    public boolean hasAllItems(Player player, List<String> list) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(CuPHEDhP2eaqDGL4());
            String str = strArrSplit[0];
            int i = strArrSplit.length > 1 ? Integer.parseInt(strArrSplit[1]) : 1;
            Material material = Material.getMaterial(str.toUpperCase());
            if (material == null || !hasItem(player, material, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasItem(Player player, Material material, int i) {
        int amount = 0;
        for (ItemStack itemStack : player.getInventory().getContents()) {
            if (itemStack != null && itemStack.getType() == material) {
                amount += itemStack.getAmount();
            }
            if (amount >= i) {
                return true;
            }
        }
        return false;
    }

    public void removeEnchantments(ItemStack itemStack) {
        if (itemStack != null) {
            for (Object obj : itemStack.getEnchantments().keySet().toArray()) {
                itemStack.removeEnchantment((Enchantment) obj);
            }
        }
    }

    public int getAmount(Inventory inventory, ItemStack itemStack) {
        int amount = 0;
        for (ItemStack itemStack2 : inventory.getContents()) {
            if (itemStack2 != null && itemStack2.getType() == itemStack.getType() && itemStack2.getAmount() > 0 && itemStack2.getDurability() == itemStack.getDurability()) {
                amount += itemStack2.getAmount();
            }
        }
        return amount;
    }

    public String getDurability(ItemStack itemStack) {
        return itemStack.getDurability() != 0 ? ":" + Integer.toString(itemStack.getDurability()) : "";
    }

    public ItemStack ItemHand(Player player) {
        try {
            return VersionUtil.isAbove(VersionUtil.VersionEnum.V19) ? player.getInventory().getItemInMainHand() : player.getInventory().getItemInHand();
        } catch (Exception e) {
            return null;
        }
    }

    public static void removeItem(ItemStack itemStack, Player player) {
        try {
            if (itemStack.getAmount() <= 1) {
                player.getInventory().removeItem(new ItemStack[]{itemStack});
            } else {
                itemStack.setAmount(itemStack.getAmount() - 1);
            }
        } catch (Exception e) {
        }
    }

    public void removeItem(ItemStack itemStack, Player player, int i) {
        try {
            int i2 = i;
            for (ItemStack itemStack2 : player.getInventory().getContents()) {
                if (isSimilar(itemStack, itemStack2)) {
                    int amount = itemStack2.getAmount();
                    if (i2 - amount >= 0) {
                        player.getInventory().removeItem(new ItemStack[]{itemStack2});
                        i2 -= amount;
                    } else {
                        itemStack2.setAmount(itemStack2.getAmount() - i2);
                        i2 = 0;
                    }
                    if (i2 <= 0) {
                        break;
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    public boolean isSimilar(ItemStack itemStack, ItemStack itemStack2) {
        if (itemStack == null || itemStack2 == null || itemStack.getType() != itemStack2.getType()) {
            return false;
        }
        if (!itemStack.hasItemMeta() || !itemStack2.hasItemMeta()) {
            return (itemStack.hasItemMeta() || itemStack2.hasItemMeta()) ? false : true;
        }
        if (itemStack.getItemMeta().hasDisplayName() && itemStack2.getItemMeta().hasDisplayName()) {
            if (!itemStack.getItemMeta().getDisplayName().equalsIgnoreCase(itemStack2.getItemMeta().getDisplayName())) {
                return false;
            }
            if (!itemStack.getItemMeta().hasLore() || !itemStack2.getItemMeta().hasLore()) {
                return (itemStack.getItemMeta().hasLore() || itemStack2.getItemMeta().hasLore()) ? false : true;
            }
            if (itemStack.getItemMeta().getLore().size() != itemStack2.getItemMeta().getLore().size()) {
                return false;
            }
            int i = 0;
            Iterator it = itemStack.getItemMeta().getLore().iterator();
            while (it.hasNext()) {
                if (!((String) it.next()).equals(itemStack2.getItemMeta().getLore().get(i))) {
                    return false;
                }
                i++;
            }
            return true;
        }
        if (itemStack.getItemMeta().hasDisplayName() || itemStack2.getItemMeta().hasDisplayName()) {
            return false;
        }
        if (!itemStack.getItemMeta().hasLore() || !itemStack2.getItemMeta().hasLore()) {
            return (itemStack.getItemMeta().hasLore() || itemStack2.getItemMeta().hasLore()) ? false : true;
        }
        if (itemStack.getItemMeta().getLore().size() != itemStack2.getItemMeta().getLore().size()) {
            return false;
        }
        int i2 = 0;
        Iterator it2 = itemStack.getItemMeta().getLore().iterator();
        while (it2.hasNext()) {
            if (!((String) it2.next()).equals(itemStack2.getItemMeta().getLore().get(i2))) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private static String zrQJT8igwc7sPJsZDz6Q(byte[] bArr) {
        return "";
    }

    private static String CuPHEDhP2eaqDGL4() {
        return ":";
    }
}
